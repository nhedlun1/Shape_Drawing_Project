/**
 * JavaBasic
 * Chapter 4 - Inheritance and Interfaces
 * 2014-04-28
 * 
 * Copyright Affix Byte Coders AB
 */

package hedlund.shape.drawing;

import static hedlund.shape.drawing.ShapeConfig.*;

public abstract class Shape {

	public enum ShapeType {
		Triangle,
		Circle,
		Line,
		Rectangle,
		None
	};


	protected float profileLength;
	protected float area;
	protected Coord coordinate;
	protected ShapeType type;

	private int elementId;
	private static int uniqueId = 1;
	
	public abstract void calcProfileLength();
	public abstract void calcArea();
	public abstract boolean withinDrawLim(Coord coord);

	
	protected Shape(ShapeType shapeType,Coord coord) {
		checkCoord(coord);
		elementId = uniqueId++;
		this.coordinate = coord;
		this.type = shapeType;
	}

//	protected Shape(ShapeType type) { //TODO: maybe this can be removed? Is never used in tests? 
//		this(type,new Coord());	
//	}


	/*
	 * @Return profile length of object
	 */
	public float getProfileLength(){
		return profileLength;
	}

	// present area of object
	public float getArea(){
		return area;
	}

	// present area of object
	public int getUniqueId(){
		return elementId;
	}

	boolean move(Coord newCoord) {
		int X = newCoord.getX();
		int Y = newCoord.getY();
		
		if(!this.withinDrawLim(newCoord)) {
			return false;
		}else{
			this.coordinate = new Coord(X, Y);
			return true;
		}
	}

	protected static boolean checkCoord(Coord coord) {
		int coordX = coord.getX();
		int coordY = coord.getY();

		if(coordX < X_DRAW_MIN || coordX > X_DRAW_MAX) {
			throw new IllegalArgumentException("Coord is out of limits!\n");
		}

		if(coordY < Y_DRAW_MIN || coordY > Y_DRAW_MAX) {
			throw new IllegalArgumentException("Coord is out of limits!\n");
		}

		return true;	
	}




}



