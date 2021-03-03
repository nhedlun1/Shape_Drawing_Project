package hedlund.shape.drawing;


import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestDrawing {

	
	@Test //adding a shape successfully
	public void testAddShape1() {
		Drawing tempDrawing = new Drawing();
		Circle tempCircle = new Circle(1,new Coord());
		tempDrawing.addShape(tempCircle);
		Assert.assertNotNull(tempDrawing.shapes.get(0));
	}
	
	@Ignore //not needed anymore due to List<Shape>
	@Test //adding to many shapes
	public void testAddShape2() {
		Drawing tempDrawing = new Drawing();
		Circle oneToMuchCircle = new Circle();

		for(int i=0;i<10;i++) {
			Circle circle = new Circle();
			tempDrawing.addShape(circle);
		}
		Assert.assertFalse(tempDrawing.addShape(oneToMuchCircle));
	}
	
	@Ignore //Test no longer needed due to refactor from Array to List<Shape>
	@Test //adding 10 shapes and testing isFull()
	public void testAddShape3() {
		Drawing tempDrawing = new Drawing();
		
		for(int i=0;i<10;i++) {
			Circle circle = new Circle();
			tempDrawing.addShape(circle);
		}
		//Assert.assertTrue(tempDrawing.isFull());
	}
	
	@Ignore //Test no longer needed due to refactor from Array to List<Shape>
	@Test //adding 8 shapes and testing isFull()
	public void testAddShape4() {
		Drawing tempDrawing = new Drawing();
		
		for(int i=0;i<9;i++) {
			Circle circle = new Circle();
			tempDrawing.addShape(circle);
		}
		
		//Assert.assertFalse(tempDrawing.isFull());
	}
	
	@Test //Remove existing shape
	public void testRemoveShape1() {
		Drawing tempDrawing = new Drawing();
		Circle tempCircle = new Circle(1,new Coord());
		tempDrawing.addShape(tempCircle);
		Assert.assertTrue(tempDrawing.removeShape(tempCircle.getElementId()));
		//Assert.assertNull(tempDrawing.shapes.get(0));
	}
	
	@Test //Remove non existing shape
	public void testRemoveShape2() {
		int nonExistingId = 99;
		Drawing tempDrawing = new Drawing();
		Circle tempCircle = new Circle();
		tempDrawing.addShape(tempCircle);
		
		Assert.assertFalse(tempDrawing.removeShape(nonExistingId));
	}
	
	@Test //move a existing shape to ok position
 	public void testMoveShape1() {
		Drawing tempDrawing = new Drawing();
		Circle tempCircle = new Circle();
		tempDrawing.addShape(tempCircle);
		
		Assert.assertTrue(tempDrawing.moveShape(tempCircle.getElementId(), new Coord()));
	}
	
	@Test //move a existing shape to faulty location
	public void testMoveShape2() {
		Drawing tempDrawing = new Drawing();
		Circle tempCircle = new Circle();
		tempDrawing.addShape(tempCircle);
		
		Assert.assertFalse(tempDrawing.moveShape(tempCircle.getElementId(), new Coord(600,50)));
	}
	
	@Test //move a non existing shape to ok location
	public void testMoveShape3() {
		int nonExistingId = 99;
		Drawing tempDrawing = new Drawing();
		Circle tempCircle = new Circle();
		tempDrawing.addShape(tempCircle);
		
		Assert.assertFalse(tempDrawing.moveShape(nonExistingId, new Coord(50,50)));
	}
	
	@Test //Creating drawing with drawing supplied as argument
	public void testCreateDrawing() {
		Map<Integer,Shape> shapes = new HashMap<Integer,Shape>();
		
		Circle c1 = new Circle();
		Triangle t1 = new Triangle();
		Rectangle r1 = new Rectangle();
		Line l1 = new Line();
		
		shapes.putIfAbsent(c1.getElementId(),c1);
		shapes.putIfAbsent(t1.getElementId(),t1);
		shapes.putIfAbsent(r1.getElementId(),r1);
		shapes.putIfAbsent(l1.getElementId(),l1);
		
		Drawing tempDrawing = new Drawing(shapes);
		Assert.assertNotNull(tempDrawing.shapes);
	}

}
