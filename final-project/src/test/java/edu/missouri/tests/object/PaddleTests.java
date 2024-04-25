package edu.missouri.tests.object;

import org.junit.jupiter.api.*;

import edu.missouri.finalproject.math.Rectangle;
import edu.missouri.finalproject.object.paddle.PaddleModel;

@DisplayName("Test object.paddle.PaddleModel")
public class PaddleTests
{
	@Test
	@DisplayName("Test the PaddleModel constructor.")
	void testConstructor()
	{
		// Goal hitbox and bound
		Rectangle hitbox = new Rectangle(5.0, 6.0, 40.0, 200.0);
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);
		
		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(hitbox.getX(), hitbox.getY(), bound);
		
		// Test that the start coordinates are saved correctly
		Assertions.assertEquals(model.getStartX(), hitbox.getX());
		Assertions.assertEquals(model.getStartY(), hitbox.getY());
		
		// Test that the current position coordinates are saved correctly
		Assertions.assertEquals(model.getPosX(), hitbox.getX());
		Assertions.assertEquals(model.getPosY(), hitbox.getY());
		
		// Test that the current velocity is zero
		Assertions.assertEquals(model.getVelX(), 0.0);
		Assertions.assertEquals(model.getVelY(), 0.0);
		
		// Test that the hitbox and bound are equal
		Assertions.assertTrue(model.getHitbox().equals(hitbox));
		Assertions.assertTrue(model.getBound().equals(bound));
	}
}
