package hedlund.shape.drawing;
import static hedlund.shape.drawing.ShapeConfig.*;

public class Coord {
	private int X;
	private int Y;
	
	
	/**
	 * 
	 * @param x coordinate
	 * @param y coordinate 
	 */
	public Coord(int x, int y) {
		
//		if(x<X_DRAW_MIN || x>X_DRAW_MAX || y<Y_DRAW_MIN  || y>Y_DRAW_MAX) {
//			throw new IllegalArgumentException("Coordinate out of bounds");
//		} Commented out due to unnecessary code TODO: MAYBE remove this?
		
		this.X = x;
		this.Y = y;
	}
	
	public Coord() {
		this.X = DEFAULT_DIMENSION;
		this.Y = DEFAULT_DIMENSION;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	

}
