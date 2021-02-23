package hedlund.shape.drawing;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class TestShapeCircle {

	//test with negative circle radius
	@Test (expected = IllegalArgumentException.class)
	public void testCreateCircle1() {
		@SuppressWarnings("unused")
		Circle temp = new Circle(-5,new Coord());
	}
	//test with negative coordinate
	@Test (expected = IllegalArgumentException.class)
	public void testCreateCircle2() {
		@SuppressWarnings("unused")
		Circle temp = new Circle(5,new Coord(-1,2));
	}
	//test with coordinate where cirle wont fit within limits
	@Test (expected = IllegalArgumentException.class)
	public void testCreateCircle3() {
		@SuppressWarnings("unused")
		Circle temp = new Circle(5,new Coord(50,398));
	}
	//test with to large coord input
	@Test (expected = IllegalArgumentException.class)
	public void testCreateCircle4() {
		@SuppressWarnings("unused")
		Circle temp = new Circle(5,new Coord(601,300));
	}
	
	@Test 
	public void testCreateCircle5() {
		Circle temp = new Circle(1,new Coord());
		Assert.assertNotNull(temp);
	}
	
	@Test 
	public void testCreateCircle6() {
		Circle temp = new Circle();
		Assert.assertNotNull(temp);
	}
	
	@Test 
	public void testCreateCircle7() {
		Circle temp = new Circle(1);
		Assert.assertNotNull(temp);
	}
	
	@Test 
	public void testCreateCircle8() {
		Circle temp = new Circle();
		Assert.assertNotNull(temp);
	}
	
	//Test toStringMethod
	@Test 
	public void testToStringCircle9() {
		Circle temp = new Circle(5, new Coord(5,5));
		int uniqueId = temp.getUniqueId();
		assertEquals("Circle [radius=5, profileLength=31.415926, area=78.53982, uniqueId="+uniqueId+", Coordinate=5,5]", temp.toString());
	}


}
