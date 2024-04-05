package edu.missouri.tests.math;

import org.junit.jupiter.api.*;

import edu.missouri.finalproject.math.Circle;
import edu.missouri.finalproject.math.Rectangle;

@DisplayName("Test math.Circle")
public class CircleTests
{
	@Test
	@DisplayName("Test the Circle default constructor")
	void testDefaultConstructor()
	{
		// Create a default rectangle
		Circle circle = new Circle();
		
		// Assert that all values match zero
		Assertions.assertEquals(circle.getX(), 0.0);
		Assertions.assertEquals(circle.getY(), 0.0);
		Assertions.assertEquals(circle.getDiameter(), 0.0);
		Assertions.assertEquals(circle.getWidth(), 0.0);
		Assertions.assertEquals(circle.getHeight(), 0.0);
	}
	
	@Test
	@DisplayName("Test the Circle advanced constructor")
	void testAdvancedConstructor()
	{
		// Create a custom rectangle
		Circle circle = new Circle(5.0, -2.0, 5.0);
		
		// Assert that all values match hard coded values
		Assertions.assertEquals(circle.getX(), 5.0);
		Assertions.assertEquals(circle.getY(), -2.0);
		Assertions.assertEquals(circle.getDiameter(), 5.0);
		Assertions.assertEquals(circle.getWidth(), 5.0);
		Assertions.assertEquals(circle.getHeight(), 5.0);
	}
	
	@Test
	@DisplayName("Test the Circle setters to check for accurate chaining")
	void testSetters()
	{
		// Create a default rectangle and use setters to set values
		Circle circle = new Circle()
				.setX(2.0)
				.setY(1.0)
				.setDiameter(4.0);
		
		// Assert that all values match hard coded values
		Assertions.assertEquals(circle.getX(), 2.0);
		Assertions.assertEquals(circle.getY(), 1.0);
		Assertions.assertEquals(circle.getDiameter(), 4.0);
		Assertions.assertEquals(circle.getWidth(), 4.0);
		Assertions.assertEquals(circle.getHeight(), 4.0);
	}
	
	@Test
	@DisplayName("Test the Circle 'boolean withinRectangleTop(Rectangle)' method")
	void testWithinRectangleTop()
	{
		// Create a small rectangle
		Circle rect = new Circle(0.0, -1.0, 5.0);
		
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
	@DisplayName("Test the Circle 'boolean withinRectangleBottom(Rectangle)' method")
	void testWithinRectangleBottom()
	{
		// Create a small rectangle
		Circle circle = new Circle(0.0, 55.0, 5.0);
		
		// Create a larger rectangle as a bounding box
		Rectangle bound = new Rectangle(0.0, 0.0, 50.0, 50.0);
		
		// Make sure collision is detected
		Assertions.assertFalse(circle.withinRectangleBottom(bound));
		
		// Move rectangle to new spot out of boundary
		circle.setY(45.0);
		
		// Make sure collision is detected
		Assertions.assertFalse(circle.withinRectangleBottom(bound));
		
		// Move rectangle within boundary
		circle.setY(5.0);
		
		// Make sure lack of collision is detected
		Assertions.assertTrue(circle.withinRectangleBottom(bound));
		
		// Move rectangle to new spot within boundary
		circle.setY(-5.0);
				
		// Make sure lack of collision is detected
		Assertions.assertTrue(circle.withinRectangleBottom(bound));
	}
	
	@Test
	@DisplayName("Test the Circle 'boolean withinRectangleLeft(Rectangle)' method")
	void testWithinRectangleLeft()
	{
		// Create a small rectangle
		Circle circle = new Circle(-1.0, 0.0, 5.0);
		
		// Create a larger rectangle as a bounding box
		Rectangle bound = new Rectangle(0.0, 0.0, 50.0, 50.0);
		
		// Make sure collision is detected
		Assertions.assertFalse(circle.withinRectangleLeft(bound));
		
		// Move rectangle to new spot out of boundary
		circle.setX(0.0);
		
		// Make sure collision is detected
		Assertions.assertFalse(circle.withinRectangleLeft(bound));
		
		// Move rectangle within boundary
		circle.setX(1.0);
		
		// Make sure lack of collision is detected
		Assertions.assertTrue(circle.withinRectangleLeft(bound));
		
		// Move rectangle to new spot within boundary
		circle.setX(55.0);
				
		// Make sure lack of collision is detected
		Assertions.assertTrue(circle.withinRectangleLeft(bound));
	}
	
	@Test
	@DisplayName("Test the Circle 'boolean withinRectangleRight(Rectangle)' method")
	void testWithinRectangleRight()
	{
		// Create a small rectangle
		Circle circle = new Circle(55.0, 0.0, 5.0);
		
		// Create a larger rectangle as a bounding box
		Rectangle bound = new Rectangle(0.0, 0.0, 50.0, 50.0);
		
		// Make sure collision is detected
		Assertions.assertFalse(circle.withinRectangleRight(bound));
		
		// Move rectangle to new spot out of boundary
		circle.setX(45.0);
		
		// Make sure collision is detected
		Assertions.assertFalse(circle.withinRectangleRight(bound));
		
		// Move rectangle within boundary
		circle.setX(5.0);
		
		// Make sure lack of collision is detected
		Assertions.assertTrue(circle.withinRectangleRight(bound));
		
		// Move rectangle to new spot within boundary
		circle.setX(-5.0);
				
		// Make sure lack of collision is detected
		Assertions.assertTrue(circle.withinRectangleRight(bound));
	}
}
