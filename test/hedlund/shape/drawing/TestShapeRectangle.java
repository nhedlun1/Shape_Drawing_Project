package hedlund.shape.drawing;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class TestShapeRectangle {

	@Test (expected = IllegalArgumentException.class)
	public void testCreateRectangle1() {
		@SuppressWarnings("unused")
		Rectangle temp = new Rectangle(-5,5,new Coord());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCreateRectangle2() {
		@SuppressWarnings("unused")
		Rectangle temp = new Rectangle(5,5,new Coord(-1,2));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCreateRectangle3() {
		@SuppressWarnings("unused")
		Rectangle temp = new Rectangle(5,5,new Coord(598,2));
	}
	
	@Test 
	public void testCreateRectangle4() {
		Rectangle temp = new Rectangle(5,5,new Coord());
		Assert.assertNotNull(temp);
	}
	
	
	@Test 
	public void testCreateRectangle5() {
		Rectangle temp = new Rectangle(5,5);
		Assert.assertNotNull(temp);
	}
	
	@Test 
	public void testCreateRectangle6() {
		Rectangle temp = new Rectangle();
		Assert.assertNotNull(temp);
	}
	
	//Test toStringMethod
	@Test 
	public void testToStringRectangle7() {
		Rectangle temp = new Rectangle(5,5, new Coord(1,1));
		int uniqueId = temp.getElementId();
		assertEquals("Rectangle [height=5, width=5, profileLength=20.0, area=25.0, uniqueId="+uniqueId+", Coordinate=1,1]", temp.toString());
	} 
	


}
