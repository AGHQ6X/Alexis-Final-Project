package edu.missouri.tests.object;

import org.junit.jupiter.api.*;

import edu.missouri.finalproject.math.Rectangle;
import edu.missouri.finalproject.object.ball.BallModel;

@DisplayName("Test object.ball.BallModel")
public class BallTests
{
	@Test
	@DisplayName("Test the BallModel constructor.")
	void testConstructor()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);
		
		// Model created with the constructor to test
		BallModel model = new BallModel(5.0, 6.0, bound);
		
		// Test that the start coordinates are saved correctly
		Assertions.assertEquals(model.getStartX(), 5.0);
		Assertions.assertEquals(model.getStartY(), 6.0);
		
		// Test that the current position coordinates are saved correctly
		Assertions.assertEquals(model.getPosX(), 5.0);
		Assertions.assertEquals(model.getPosY(), 6.0);
		
		// Test that the current velocity is uniform
		Assertions.assertTrue(model.getVelX() == model.getVelY() || 
							  model.getVelX() == -model.getVelY());
		
		// Test that the bound is equal
		Assertions.assertTrue(model.getBound().equals(bound));
	}
}
