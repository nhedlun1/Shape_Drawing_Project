package hedlund.shape.drawing;
import static hedlund.shape.drawing.ShapeConfig.*;
public class Line extends Shape {
	private final int length;

	@Override
	public void calcProfileLength() {
		profileLength = length;
	}
	
	public Line() {
		this(ShapeConfig.DEFAULT_DIMENSION,new Coord());
	}
	
	public Line(int length) {
		this(length,new Coord());
	}

	public Line(int length, Coord coord) {
		super(ShapeType.Line,coord);
		if(length<=0) {
			throw new IllegalArgumentException("Line Length cannot be less than 1!");
		}
		this.length = length;
		this.calcProfileLength();
		this.calcArea();
		if(!this.withinDrawLim(coord)) {
			throw new IllegalArgumentException("Line not within Drawing Limits!");
		}
		System.out.println("Line created!");
	}

	@Override
	public void calcArea() {
		area=0;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Line [");
		sb.append("Length=");
		sb.append(length);
		sb.append(", profileLength=");
		sb.append(super.getProfileLength());
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
		
		if(x+length<=X_DRAW_MAX && y+length<=Y_DRAW_MAX){
			return true;
		}
		return false;
	}
	
}
