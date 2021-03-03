package hedlund.shape.drawing;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Drawing {

//	Shape[] shapes = new Shape[MAX_SHAPES];
//	List<Shape> shapes;
	Map<Integer,Shape> shapes;
	
	public Drawing(Map<Integer,Shape> shapes) {
		this.shapes = shapes;
	}

	//Default constructor
	public Drawing() {
		this.shapes = new HashMap<Integer,Shape>();
	}


	public boolean addShape(Shape shape)  {
		if((shapes.putIfAbsent(shape.getElementId(), shape) == null)){
			return true;
		}
		return false;
		
	}


	
	public boolean removeShape(int id) {
		if((shapes.remove(id)!=null)) {
			return true;
		}
		
		return false;
		
//		Iterator<Integer> iter = shapes.iterator();
//		while(iter.hasNext()) {
//			Shape temp = iter.next();
//			if(temp.getElementId()==id) {
//				iter.remove();
//				return true;
//			}
//		}
//		return false;
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
		Set<Integer> keys = shapes.keySet();
		
		sb.append("Shapes:\n");

		Iterator<Integer> shapeIter = keys.iterator();
		
		while(shapeIter.hasNext()) {
			Integer currKey = shapeIter.next();
			Shape currShape = shapes.get(currKey);
			sb.append(currShape.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	
	
	
}