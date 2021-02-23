package hedlund.shape.drawing;

import static hedlund.shape.drawing.ShapeConfig.*;


public class Drawing {

	Shape[] shapes = new Shape[MAX_SHAPES];


	public Drawing(Shape[] shapes) {
		this.shapes = shapes;
	}

	//Default constructor
	public Drawing() {}


	public boolean addShape(Shape shape)  {
		int tempIndex = getEmptyIndex();

		if(tempIndex != -1) {
			shapes[tempIndex]=shape;
			return true;
		}else {
			return false;
		}
	}


	private int getEmptyIndex() {
		for(int i=0;i<shapes.length;i++) {
			if (shapes[i]==null) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean removeShape(int id) {
		for(int i=0;i<this.shapes.length;i++) {
			if(shapes[i] !=null && id==shapes[i].getUniqueId()) {
				shapes[i]=null;
				return true;
			}
		}
		return false;
	}

	public boolean isFull() {
		if(getEmptyIndex()==-1) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean moveShape(int id, Coord newCoord) {	//TODO: maybe throw an error if the shape.move method returns false so to separate failing reason.
		for(int i=0;i<this.shapes.length;i++) {
			if(shapes[i] !=null && id==shapes[i].getUniqueId()) {
				if(!shapes[i].move(newCoord)) {
					return false;
				}else {
					return true;
				}
			}
		}
		return false;
	}

}