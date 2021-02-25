package hedlund.shape.drawing;

import static hedlund.shape.drawing.ShapeConfig.*;

import java.util.List;


import java.util.ArrayList;
import java.util.Iterator;


public class Drawing {

	//Shape[] shapes = new Shape[MAX_SHAPES];
	List<Shape> shapes;

	public Drawing(List<Shape> shapes) {
		this.shapes = shapes;
	}

	//Default constructor
	public Drawing() {
		this.shapes = new ArrayList<Shape>();
	}


	public boolean addShape(Shape shape)  {
		return shapes.add(shape);
	}


	
	public boolean removeShape(int id) {
		Iterator<Shape> iter = shapes.iterator();
		while(iter.hasNext()) {
			Shape temp = iter.next();
			if(temp.getElementId()==id) {
				iter.remove();
				return true;
			}
		}
		return false;
	}


	public boolean moveShape(int id, Coord newCoord) {
		
		for(int i=0;i<shapes.size();i++) {
			if(shapes.get(i).getElementId()==id) {
				Shape temp = shapes.get(i);
				return temp.move(newCoord);
			}
		}
		return false;
	}
	
	public void printShapes() {	
		StringBuilder sb = new StringBuilder();
		sb.append("Shapes:\n");

		for(Shape aShape: this.shapes) {
			sb.append(aShape.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}