/**
 * MoorGrove
 * @author Niklas Hedlund
 * @date   February 2021
 *
 */

package hedlund.shape.drawing;
import static hedlund.shape.drawing.ShapeConfig.*;

public class Coord implements Comparable<Coord>{
	private int X;
	private int Y;

	/**
	 * Default contstructor, creates Coord with default dimensions
	 */
	public Coord() {
		this(DEFAULT_DIMENSION,DEFAULT_DIMENSION);
	}
	/**
	 * Coord constructor taking ints"
	 * @param x coordinate
	 * @param y coordinate 
	 */
	public Coord(int x, int y) {
		this.X = x;
		this.Y = y;
	}

	public Coord(Coord cpyCoord) {
		this(cpyCoord.getX(),cpyCoord.getY());
	}

	/**
	 * Coord constructor taking a String "X,Y"
	 * @param strCoord
	 * @throws IllegalArgumentException, IndexOutOfBoundsException, NumberFormatException
	 */
	public Coord(String strCoord) {
		int tempX, tempY;
		String coordParts[]=strCoord.split(",");
		tempX = Integer.parseInt(coordParts[0]);
		tempY = Integer.parseInt(coordParts[1]);
		this.X = tempX;
		this.Y = tempY;
	}

	@Override
	public int hashCode() {
		int result = 13;
		result = result*31 + X;
		result = result*31 + Y;

		return result;
	}

	public boolean equals(Coord theCoord) {
		if(this==theCoord) {
			return true;
		}
		if (theCoord == null)
			return false;

		return (this.X == theCoord.getX() && this.Y == theCoord.getY());
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	@Override
	public int compareTo(Coord that) {
		if(this.X==that.X && this.Y ==that.Y) {
			return 0;
		}
		else {
			return (this.X>that.X || this.X==that.X && this.Y>that.Y) ? +1 : -1;
		}
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Coord(");
		sb.append(this.X);
		sb.append(",");
		sb.append(this.Y);
		sb.append(")");
		return sb.toString();
	}

}
