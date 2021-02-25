/**
 * JavaBasic
 * Chapter 4 - Inheritance and Interfaces
 * 2014-04-28
 * 
 * Copyright Affix Byte Coders AB
 */

package hedlund.shape.drawing;
import static hedlund.shape.drawing.ShapeConfig.*;

//--------------------- Define class Rectangle ------------
public class Rectangle extends Shape{

	private int height;
	private int width;

	

	public Rectangle(int h, int w){
		this(h,w,new Coord());
	}

	public Rectangle(){
		this(DEFAULT_DIMENSION,DEFAULT_DIMENSION,new Coord());
	}
	
	/**
	 * @param h Height
	 * @param w	Width
	 * @param coord	Coordinate
	 * 
	 */
	public Rectangle(int h, int w, Coord coord){
		super(ShapeType.Rectangle,coord);
		if(h<=0 || w<=0) {
			throw new IllegalArgumentException("Rectangle height or width cannot be less than 1!");
		}
		height = h;
		width = w;
		this.calcProfileLength();
		this.calcArea();
		if(!this.withinDrawLim(coord)) {
			throw new IllegalArgumentException("Rectangle not within Drawing Limits!");
		}
		System.out.println("Rectangle created!");
	}

	
	// calculate profile length of Rectangle
	public void calcProfileLength(){
		profileLength = 2*(height+width);
	}

	// calculate Area of Rectangle
	public void calcArea(){
		area = height*width;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Rectangle [");
		sb.append("height=");
		sb.append(height);
		sb.append(", width=");
		sb.append(width);
		sb.append(", profileLength=");
		sb.append(super.getProfileLength());
		sb.append(", area=");
		sb.append(super.getArea());
		sb.append(", uniqueId=");
		sb.append(this.getElementId());
		sb.append(", Coordinate=");
		sb.append(coordinate.getX());
		sb.append(",");
		sb.append(coordinate.getY());
		sb.append("]");
		return sb.toString();
	}


	@Override
	public boolean withinDrawLim(Coord coord) {
		int x = coord.getX();
		int y = coord.getY();
		
		if(x+height<=X_DRAW_MAX && y+width<=Y_DRAW_MAX){
			return true;
		}
		return false;
	}
}

