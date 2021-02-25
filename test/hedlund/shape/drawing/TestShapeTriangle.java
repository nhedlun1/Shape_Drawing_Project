package hedlund.shape.drawing;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class TestShapeTriangle {

	@Test (expected = IllegalArgumentException.class)
	public void testCreateTriangle1() {
		@SuppressWarnings("unused")
		Triangle temp = new Triangle(5,-5,new Coord());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCreateTriangle2() {
		@SuppressWarnings("unused")
		Triangle temp = new Triangle(5,5,new Coord(1,-1));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCreateTriangle3() {
		@SuppressWarnings("unused")
		Triangle temp = new Triangle(5,5,new Coord(598,2));
	}
	
	@Test 
	public void testCreateTriangle4() {
		Triangle temp = new Triangle(5,5,new Coord());
		Assert.assertNotNull(temp);
	}
	
	
	@Test 
	public void testCreateTriangle5() {
		Triangle temp = new Triangle(5,5);
		Assert.assertNotNull(temp);
	}
	
	@Test 
	public void testCreateTriangle6() {
		Triangle temp = new Triangle();
		Assert.assertNotNull(temp);
	}
	
	//Test toStringMethod
	@Test
	public void testToStringTriangle7() {
		Triangle temp = new Triangle(5,5, new Coord(10,10));
		int uniqueId = temp.getElementId();
		assertEquals("Triangle [Hypotenusa=7.071068, profileLength=17.071068, area=12.5, uniqueId="+uniqueId+", Coordinate=10,10]", temp.toString());
	} 
	
	

}
