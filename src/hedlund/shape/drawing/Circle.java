/**
 * JavaBasic
 * Chapter 4 - Inheritance and Interfaces
 * 2014-04-28
 * 
 * Copyright Affix Byte Coders AB
 */

package hedlund.shape.drawing;

import static hedlund.shape.drawing.ShapeConfig.*;


//--------------------- Define class Circle ------------
public class Circle extends Shape{

	private int radius;

	public Circle(){
		this(DEFAULT_DIMENSION);
	}
	

	public Circle(int r){
		this(r, DEFAULT_POSITION);
	}

	/**
	 * @Extends Base Class Shape 
	 * @param r Radius of Circle
	 * @param coord Coordinate(X,Y)
	 * @throws IllegalArgumentException
	 */
	public Circle(int r,Coord coord) {
		super(ShapeType.Circle,coord);
		if(r<DEFAULT_DIMENSION) {
			throw new IllegalArgumentException("Circle radius cannot be less than 1!");
		}
		radius = r;
		this.calcProfileLength();
		this.calcArea();
		
		if(!this.withinDrawLim(coord)) {
			throw new IllegalArgumentException("Circle not within Drawing Limits!");
		}
		
	    System.out.println("Circle with coord created!");
}
	

	// calculate profile length of Circle object
	public void calcProfileLength(){
	    profileLength = (float) (2*Math.PI*radius);
	}

	// calculate area of Circle object
	public void calcArea(){
 		area = (float) (Math.PI*radius*radius);
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Circle [");
		sb.append("radius=");
		sb.append(radius);
		sb.append(", profileLength=");
		sb.append(super.getProfileLength());
		sb.append(", area=");
		sb.append(super.getArea());
		sb.append(", uniqueId=");
		sb.append(this.getUniqueId());
		sb.append(", Coordinate=");
		sb.append(coordinate.getX());
		sb.append(",");
		sb.append(coordinate.getY());
		sb.append("]");
		return sb.toString();
	}
	
	@Override
	public boolean withinDrawLim(Coord newCoord) {
		int x = newCoord.getX();
		int y = newCoord.getY();
		if(x+radius<=X_DRAW_MAX && y+radius<=Y_DRAW_MAX){
			return true;
		}
		return false;
	}
}