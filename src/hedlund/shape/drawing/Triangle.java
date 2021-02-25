package hedlund.shape.drawing;

import static hedlund.shape.drawing.ShapeConfig.*;

public class Triangle extends Shape {
	
	int height;
	int base;
	

	
	public Triangle() {
	this(DEFAULT_DIMENSION,DEFAULT_DIMENSION, new Coord());
	System.out.println("Default triangle created!");
	}
	
	public Triangle(int height, int base) {
	this(height,base, new Coord());
	System.out.println("Default triangle created!");
	}
	
	/**
	 * @param height
	 * @param base
	 * @param coord
	 */
	public Triangle(int height, int base,Coord coord) {
		super(ShapeType.Triangle,coord);
		if(height <= 0 || base <= 0) {
			throw new IllegalArgumentException("Triangle Height or Base cannot be less than 1!");
		}
		this.height = height;
		this.base = base;
		this.calcProfileLength();
		this.calcArea();
		
		if(!this.withinDrawLim(coord)) {
			throw new IllegalArgumentException("Triangle not within Drawing Limits!");
		}
		System.out.println("Triangle created!");
	}
	
	@Override
	public void calcProfileLength() {
		profileLength = height+base+this.calcHyp();
	}

	@Override
	public void calcArea() {
		this.area = (float)(0.5 * (this.base * this.height));
	}
	
	public float calcHyp() {
		return (float)Math.sqrt(base*base + height*height);
	}
	
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Triangle [");
		sb.append("Hypotenusa=");
		sb.append(this.calcHyp());
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
	
	
	public boolean withinDrawLim(Coord coord) {
		int x = coord.getX();
		int y = coord.getY();
		if(x+base>X_DRAW_MAX || y+height>Y_DRAW_MAX){
			return false;
		}
		return true;
	}

}
