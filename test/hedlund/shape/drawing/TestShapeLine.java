package hedlund.shape.drawing;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class TestShapeLine {

	//test with negative Line length
	@Test (expected = IllegalArgumentException.class)
	public void testCreateLine1() {
		@SuppressWarnings("unused")
		Line temp = new Line(-5,new Coord());
	}
	//test with negative coordinate
	@Test (expected = IllegalArgumentException.class)
	public void testCreateLine2() {
		@SuppressWarnings("unused")
		Line temp = new Line(5,new Coord(-1,2));
	}
	//test with coordinate where Line wont fit within limits
	@Test (expected = IllegalArgumentException.class)
	public void testCreateLine3() {
		@SuppressWarnings("unused")
		Line temp = new Line(5,new Coord(598,2));
	}
	//test with to large coord input
	@Test (expected = IllegalArgumentException.class)
	public void testCreateLine4() {
		@SuppressWarnings("unused")
		Line temp = new Line(-5,new Coord(601,401));
	}
	
	@Test 
	public void testCreateLine5() {
		Line temp = new Line(1,new Coord());
		Assert.assertNotNull(temp);
	}
	
	@Test 
	public void testCreateLine6() {
		Line temp = new Line(1);
		Assert.assertNotNull(temp);
	}
	
	@Test 
	public void testCreateLine7() {
		Line temp = new Line();
		Assert.assertNotNull(temp);
	}
	
	//Test toStringMethod
	@Test
	public void testToStringLine8() {
		Line temp = new Line(5, new Coord(10,10));
		int uniqueId = temp.getUniqueId();
		assertEquals("Line [Length=5, profileLength=5.0, uniqueId="+uniqueId+", Coordinate=10,10]", temp.toString());
	}
	
			

}
