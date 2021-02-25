package hedlund.shape.drawing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static hedlund.shape.drawing.ShapeConfig.*;
import org.junit.Test;

public class TestCoord {

	/**
	 * // test the default constructor
	 */
	@Test 
	public void testCoordCtor1() {
		Coord testCoord = new Coord();
		assertEquals(DEFAULT_DIMENSION, testCoord.getX());
		assertEquals(DEFAULT_DIMENSION, testCoord.getY());
	}
	
	/**
	 * // test the ctor with input
	 */
	@Test
	public void testCoordCtor2() {
		int testDim = 5;
		Coord testCoord = new Coord(testDim,testDim);
		assertEquals(testDim, testCoord.getX());
		assertEquals(testDim, testCoord.getY());
	}
	
	/**
	 * // test the Copy constructor
	 */
	@Test
	public void testCoordCtor3() {
		int testDim = 5;
		Coord testCoord = new Coord(testDim,testDim);
		Coord CoordUnderTest = new Coord(testCoord);
		assertEquals(CoordUnderTest.getX(), testCoord.getX());
		assertEquals(CoordUnderTest.getY(), testCoord.getY());
	}
	
	/**
	 * // test the String constructor
	 */
	@Test
	public void testCoordCtor4() {
		String testCordString = "2,5";
		Coord CoordUnderTest = new Coord(testCordString);
		assertEquals(CoordUnderTest.getX(), 2);
		assertEquals(CoordUnderTest.getY(), 5);
	}
	
	/**
	 * // test the String constructor with falty separator
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCoordCtor5() {
		String testCordString = "2&5";
		@SuppressWarnings("unused")
		Coord CoordUnderTest = new Coord(testCordString);
	}
	
	/**
	 * // test the String constructor with falty integerInput
	 */
	@Test (expected = NumberFormatException.class)
	public void testCoordCtor6() {
		String testCordString = "b,5";
		@SuppressWarnings("unused")
		Coord CoordUnderTest = new Coord(testCordString);
	}

	/**
	 * // test the String constructor with missing integer
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void testCoordCtor7() {
		String testCordString = "1,";
		@SuppressWarnings("unused")
		Coord CoordUnderTest = new Coord(testCordString);
	}
	
	
	/**
	 * // test the CompareTo Method
	 */
	@Test
	public void testCoordCompareTo1() {
		Coord bigCoord = new Coord(1,5);
		Coord smallCoord = new Coord(5,1);
		assertTrue(bigCoord.compareTo(smallCoord)<1);
	}
	/**
	 * // test the CompareTo Method
	 */
	@Test
	public void testCoordCompareTo2() {
		Coord bigCoord = new Coord(5,5);
		Coord smallCoord = new Coord(5,4);
		assertTrue(smallCoord.compareTo(bigCoord)<1);
	}
	
	/**
	 * // test the Equals Method
	 */
	@Test
	public void testCoordEquals1() {
		Coord aCoord = new Coord(5,5);
		Coord bCoord = new Coord(5,5);
		assertTrue(aCoord.equals(bCoord));
	}
	
	/**
	 * // test the Equals Method
	 */
	@Test
	public void testCoordEquals2() {
		Coord aCoord = new Coord(4,5);
		Coord bCoord = new Coord(5,5);
		assertFalse(aCoord.equals(bCoord));
	}
	
	/**
	 * // test the Equals Method
	 */
	@Test
	public void testCoordEquals3() {
		Coord aCoord = new Coord(4,5);
		assertFalse(aCoord.equals(null));
	}
	
//	/**
//	 * // test the Hashing Method
//	 */
//	@Test
//	public void testCoordHash1() {
//		Coord aCoord = new Coord(4,5);
//		Integer aInteger = 13;
//		int hash = aCoord.hashCode();
//		assertEquals(hash,aInteger.hashCode());
//	}
//	
//	/**
//	 * // test the Hashing Method
//	 */
//	@Test
//	public void testCoordHash2() {
//		Coord aCoord = new Coord(5,5);
//		Integer aInteger = 4+5;
//		int hash = aCoord.hashCode();
//		assertNotEquals(hash,aInteger.hashCode());
//	}
//	
	/**
	 * // test a List of Coords with one double
	 */
	@Test
	public void testListOfCoords() {
		int nums = 10;
		List<Coord> list = new ArrayList<Coord>();
		for (int i=1;i<=nums;i++) {
			Coord tempCoord = new Coord(i,i);
			list.add(tempCoord);
		}
		
		list.add(new Coord(2,2));
		System.out.println("testListOfCoords:");
		for(Coord tempList: list) {
			System.out.println(tempList.toString());	
		}
		System.out.println();
	}
	
	/**
	 * // test a HashtSet of Coords
	 */
	@Test
	public void testSetOfCoords() {
		int nums = 10;
		Set<Coord> list = new HashSet<Coord>();
		for (int i=1;i<=nums;i++) {
			Coord tempCoord = new Coord(i,i);
			list.add(tempCoord);
		}
		
		list.add(new Coord(2,2));
		
		System.out.println("testSetOfCoords:");
		for(Coord tempList: list) {
			System.out.println(tempList.toString());	
		}
		System.out.println();
	}
	
	
}
