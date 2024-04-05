package edu.missouri.tests.math;

import org.junit.jupiter.api.*;

import edu.missouri.finalproject.math.Rectangle;

@DisplayName("Test math.Rectangle")
public class RectangleTests
{
	@Test
	@DisplayName("Test the Rectangle default constructor")
	void testDefaultConstructor()
	{
		// Create a default rectangle
		Rectangle rect = new Rectangle();
		
		// Assert that all values match zero
		Assertions.assertEquals(rect.getX(), 0.0);
		Assertions.assertEquals(rect.getY(), 0.0);
		Assertions.assertEquals(rect.getWidth(), 0.0);
		Assertions.assertEquals(rect.getHeight(), 0.0);
	}
	
	@Test
	@DisplayName("Test the Rectangle advanced constructor")
	void testAdvancedConstructor()
	{
		// Create a custom rectangle
		Rectangle rect = new Rectangle(5.0, -2.0, 5.0, 6.0);
		
		// Assert that all values match hard coded values
		Assertions.assertEquals(rect.getX(), 5.0);
		Assertions.assertEquals(rect.getY(), -2.0);
		Assertions.assertEquals(rect.getWidth(), 5.0);
		Assertions.assertEquals(rect.getHeight(), 6.0);
	}
	
	@Test
	@DisplayName("Test the Rectangle setters to check for accurate chaining")
	void testSetters()
	{
		// Create a default rectangle and use setters to set values
		Rectangle rect = new Rectangle()
				.setX(2.0)
				.setY(1.0)
				.setWidth(4.0)
				.setHeight(4.0);
		
		// Assert that all values match hard coded values
		Assertions.assertEquals(rect.getX(), 2.0);
		Assertions.assertEquals(rect.getY(), 1.0);
		Assertions.assertEquals(rect.getWidth(), 4.0);
		Assertions.assertEquals(rect.getHeight(), 4.0);
	}
	
	@Test
	@DisplayName("Test the Rectangle 'boolean withinRectangleTop(Rectangle)' method")
	void testWithinRectangleTop()
	{
		// Create a small rectangle
		Rectangle rect = new Rectangle(0.0, -1.0, 5.0, 5.0);
		
		// Create a larger rectangle as a bounding box
		Rectangle bound = new Rectangle(0.0, 0.0, 50.0, 50.0);
		
		// Make sure collision is detected
		Assertions.assertFalse(rect.withinRectangleTop(bound));
		
		// Move rectangle to new spot out of boundary
		rect.setY(0.0);
		
		// Make sure collision is detected
		Assertions.assertFalse(rect.withinRectangleTop(bound));
		
		// Move rectangle within boundary
		rect.setY(1.0);
		
		// Make sure lack of collision is detected
		Assertions.assertTrue(rect.withinRectangleTop(bound));
		
		// Move rectangle to new spot within boundary
		rect.setY(55.0);
				
		// Make sure lack of collision is detected
		Assertions.assertTrue(rect.withinRectangleTop(bound));
	}
	
	@Test
	@DisplayName("Test the Rectangle 'boolean withinRectangleBottom(Rectangle)' method")
	void testWithinRectangleBottom()
	{
		// Create a small rectangle
		Rectangle rect = new Rectangle(0.0, 55.0, 5.0, 5.0);
		
		// Create a larger rectangle as a bounding box
		Rectangle bound = new Rectangle(0.0, 0.0, 50.0, 50.0);
		
		// Make sure collision is detected
		Assertions.assertFalse(rect.withinRectangleBottom(bound));
		
		// Move rectangle to new spot out of boundary
		rect.setY(45.0);
		
		// Make sure collision is detected
		Assertions.assertFalse(rect.withinRectangleBottom(bound));
		
		// Move rectangle within boundary
		rect.setY(5.0);
		
		// Make sure lack of collision is detected
		Assertions.assertTrue(rect.withinRectangleBottom(bound));
		
		// Move rectangle to new spot within boundary
		rect.setY(-5.0);
				
		// Make sure lack of collision is detected
		Assertions.assertTrue(rect.withinRectangleBottom(bound));
	}
	
	@Test
	@DisplayName("Test the Rectangle 'boolean withinRectangleLeft(Rectangle)' method")
	void testWithinRectangleLeft()
	{
		// Create a small rectangle
		Rectangle rect = new Rectangle(-1.0, 0.0, 5.0, 5.0);
		
		// Create a larger rectangle as a bounding box
		Rectangle bound = new Rectangle(0.0, 0.0, 50.0, 50.0);
		
		// Make sure collision is detected
		Assertions.assertFalse(rect.withinRectangleLeft(bound));
		
		// Move rectangle to new spot out of boundary
		rect.setX(0.0);
		
		// Make sure collision is detected
		Assertions.assertFalse(rect.withinRectangleLeft(bound));
		
		// Move rectangle within boundary
		rect.setX(1.0);
		
		// Make sure lack of collision is detected
		Assertions.assertTrue(rect.withinRectangleLeft(bound));
		
		// Move rectangle to new spot within boundary
		rect.setX(55.0);
				
		// Make sure lack of collision is detected
		Assertions.assertTrue(rect.withinRectangleLeft(bound));
	}
	
	@Test
	@DisplayName("Test the Rectangle 'boolean withinRectangleRight(Rectangle)' method")
	void testWithinRectangleRight()
	{
		// Create a small rectangle
		Rectangle rect = new Rectangle(55.0, 0.0, 5.0, 5.0);
		
		// Create a larger rectangle as a bounding box
		Rectangle bound = new Rectangle(0.0, 0.0, 50.0, 50.0);
		
		// Make sure collision is detected
		Assertions.assertFalse(rect.withinRectangleRight(bound));
		
		// Move rectangle to new spot out of boundary
		rect.setX(45.0);
		
		// Make sure collision is detected
		Assertions.assertFalse(rect.withinRectangleRight(bound));
		
		// Move rectangle within boundary
		rect.setX(5.0);
		
		// Make sure lack of collision is detected
		Assertions.assertTrue(rect.withinRectangleRight(bound));
		
		// Move rectangle to new spot within boundary
		rect.setX(-5.0);
				
		// Make sure lack of collision is detected
		Assertions.assertTrue(rect.withinRectangleRight(bound));
	}
}
