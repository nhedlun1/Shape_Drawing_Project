package hedlund.shape.drawing;

import org.junit.Assert;
import org.junit.Test;

public class TestShapeDrawing {

	
	@Test //adding a shape successfully
	public void testAddShape1() {
		Drawing tempDrawing = new Drawing();
		Circle tempCircle = new Circle(1,new Coord());
		tempDrawing.addShape(tempCircle);
		Assert.assertNotNull(tempDrawing.shapes[0]);
	}
	
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
	
	@Test //adding 10 shapes and testing isFull()
	public void testAddShape3() {
		Drawing tempDrawing = new Drawing();
		
		for(int i=0;i<10;i++) {
			Circle circle = new Circle();
			tempDrawing.addShape(circle);
		}
		Assert.assertTrue(tempDrawing.isFull());
	}
	
	@Test //adding 8 shapes and testing isFull()
	public void testAddShape4() {
		Drawing tempDrawing = new Drawing();
		
		for(int i=0;i<9;i++) {
			Circle circle = new Circle();
			tempDrawing.addShape(circle);
		}
		
		Assert.assertFalse(tempDrawing.isFull());
	}
	
	@Test //Remove existing shape
	public void testRemoveShape1() {
		Drawing tempDrawing = new Drawing();
		Circle tempCircle = new Circle(1,new Coord());
		tempDrawing.addShape(tempCircle);
		Assert.assertTrue(tempDrawing.removeShape(tempCircle.getUniqueId()));
		Assert.assertNull(tempDrawing.shapes[0]);
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
		
		Assert.assertTrue(tempDrawing.moveShape(tempCircle.getUniqueId(), new Coord()));
	}
	
	@Test //move a existing shape to faulty location
	public void testMoveShape2() {
		Drawing tempDrawing = new Drawing();
		Circle tempCircle = new Circle();
		tempDrawing.addShape(tempCircle);
		
		Assert.assertFalse(tempDrawing.moveShape(tempCircle.getUniqueId(), new Coord(600,50)));
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
		Shape[] shapes = {new Circle(),new Triangle(),new Rectangle(),new Line()};
		Drawing tempDrawing = new Drawing(shapes);
		Assert.assertNotNull(tempDrawing.shapes);
	}

}
