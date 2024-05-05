package edu.missouri.tests.object;

import org.junit.jupiter.api.*;

import edu.missouri.finalproject.math.Circle;
import edu.missouri.finalproject.math.Rectangle;
import edu.missouri.finalproject.object.ball.BallModel;

@DisplayName("Test object.ball.BallModel")
public class BallTests
{
	@Test
	@DisplayName("Test the constructor")
	void testConstructor()
	{
		// Goal hitbox and bound
		Circle hitbox = new Circle(5.0, 6.0, 80.0);
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);
		
		// Model created with the constructor to test
		BallModel model = new BallModel(hitbox.getX(), hitbox.getY(), bound);
		
		// Test that the start coordinates are saved correctly
		Assertions.assertEquals(model.getStartX(), 5.0);
		Assertions.assertEquals(model.getStartY(), 6.0);
		
		// Test that the current position coordinates are saved correctly
		Assertions.assertEquals(model.getPosX(), 5.0);
		Assertions.assertEquals(model.getPosY(), 6.0);
		
		// Test that the current velocity is uniform
		Assertions.assertTrue(model.getVelX() == model.getVelY() || 
							  model.getVelX() == -model.getVelY());
		
		// Test that the hitbox and bound is equal
		// Test that the bound is equal
		Assertions.assertTrue(model.getHitbox().equals(hitbox));
		Assertions.assertTrue(model.getBound().equals(bound));
	}
	
	@Test
	@DisplayName("Test the setters and getters")
	void testSetGet()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		BallModel model = new BallModel(150.0, 150.0, bound);
		
		// Change the position
		model.setPosX(250.0).setPosY(100.0);

		// Change the velocity
		model.setVelX(16.0).setVelY(-12.0);
		
		// Test that the current position was changed
		Assertions.assertEquals(model.getPosX(), 250.0);
		Assertions.assertEquals(model.getPosY(), 100.0);
		
		// Test that the current velocity was changed
		Assertions.assertEquals(model.getVelX(), 16.0);
		Assertions.assertEquals(model.getVelY(), -12.0);
	}
	
	@Test
	@DisplayName("Test reset()")
	void testReset()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		BallModel model = new BallModel(150.0, 150.0, bound);
		
		// Change the position
		model.setPosX(200.0).setPosY(100.0);
		
		// Change the velocity
		model.setVelX(14.0).setVelY(10.0);
		
		// Reset the position
		model.reset();
		
		// Test that the reset position coordinates are saved correctly
		Assertions.assertEquals(model.getPosX(), 150.0);
		Assertions.assertEquals(model.getPosY(), 150.0);

		// Test that the reset velocity is uniform
		Assertions.assertTrue(model.getVelX() == model.getVelY() || 
				model.getVelX() == -model.getVelY());
	}
	
	@Test
	@DisplayName("Test bounceRectangle(Rectangle) method top")
	void testBounceRectangleTop()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		BallModel model = new BallModel(150.0, 150.0, bound);
		
		// // Change the velocity
		model.setVelX(0.0).setVelY(10.0);
		
		// Rectangle to bounce off of
		Rectangle paddleBox = new Rectangle(150.0, 200.0, 80.0, 80.0);
		
		// Bounce the ball off the rectangle
		model.bounceRectangle(paddleBox);
		
		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 150.0);
		Assertions.assertEquals(model.getPosY(), 90.0);
		
		// Assert that the velocity is correct
		Assertions.assertEquals(model.getVelX(), 0.0);
		Assertions.assertTrue(model.getVelY() < 0.0);
	}
	
	@Test
	@DisplayName("Test bounceRectangle(Rectangle) method bottom")
	void testBounceRectangleBottom()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		BallModel model = new BallModel(150.0, 150.0, bound);
		
		// // Change the velocity
		model.setVelX(0.0).setVelY(-10.0);
		
		// Rectangle to bounce off of
		Rectangle paddleBox = new Rectangle(150.0, 95.0, 80.0, 80.0);
		
		// Bounce the ball off the rectangle
		model.bounceRectangle(paddleBox);
		
		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 150.0);
		Assertions.assertEquals(model.getPosY(), 200.0);
		
		// Assert that the velocity is correct
		Assertions.assertEquals(model.getVelX(), 0.0);
		Assertions.assertTrue(model.getVelY() > 0.0);
	}
	
	@Test
	@DisplayName("Test bounceRectangle(Rectangle) method left")
	void testBounceRectangleLeft()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		BallModel model = new BallModel(150.0, 150.0, bound);
		
		// // Change the velocity
		model.setVelX(10.0).setVelY(0.0);
		
		// Rectangle to bounce off of
		Rectangle paddleBox = new Rectangle(200.0, 150.0, 80.0, 80.0);
		
		// Bounce the ball off the rectangle
		model.bounceRectangle(paddleBox);
		
		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 90.0);
		Assertions.assertEquals(model.getPosY(), 150.0);
		
		// Assert that the velocity is correct
		Assertions.assertTrue(model.getVelX() < 0.0);
		Assertions.assertEquals(model.getVelY(), 0.0);
	}
	
	@Test
	@DisplayName("Test bounceRectangle(Rectangle) method right")
	void testBounceRectangleRight()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		BallModel model = new BallModel(150.0, 150.0, bound);
		
		// // Change the velocity
		model.setVelX(-10.0).setVelY(0.0);
		
		// Rectangle to bounce off of
		Rectangle paddleBox = new Rectangle(100.0, 150.0, 80.0, 80.0);
		
		// Bounce the ball off the rectangle
		model.bounceRectangle(paddleBox);
		
		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 210.0);
		Assertions.assertEquals(model.getPosY(), 150.0);
		
		// Assert that the velocity is correct
		Assertions.assertTrue(model.getVelX() > 0.0);
		Assertions.assertEquals(model.getVelY(), 0.0);
	}
	
	@Test
	@DisplayName("Test update method moves the ball based off velocity")
	void testUpdateMovesBall()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(-250.0, -250.0, 500.0, 500.0);

		// Model created with the constructor to test
		BallModel model = new BallModel(0.0, 0.0, bound);
				
		// Change the velocity
		model.setVelX(0.0).setVelY(0.0);
		
		// Update the model
		model.update(1.0);
		
		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 0.0);
		Assertions.assertEquals(model.getPosY(), 0.0);
		
		// Change the velocity
		model.setVelX(10.0).setVelY(-5.0);

		// Update the model
		model.update(1.0);

		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 120.0);
		Assertions.assertEquals(model.getPosY(), -60.0);
		
		// Change the velocity
		model.setVelX(-2.0).setVelY(10.0);

		// Update the model
		model.update(1.0);

		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 96.0);
		Assertions.assertEquals(model.getPosY(), 60.0);
		
		// Change the velocity
		model.setVelX(-8.0).setVelY(-5.0);

		// Update the model
		model.update(1.0);

		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 0.0);
		Assertions.assertEquals(model.getPosY(), 0.0);
		
		// Change the velocity
		model.setVelX(-12.0).setVelY(-8.0);

		// Update the model
		model.update(1.0);

		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), -144.0);
		Assertions.assertEquals(model.getPosY(), -96.0);
	}
	
	@Test
	@DisplayName("Test update method moves the ball based off velocity AND delta")
	void testUpdateMovesBallDelta()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(-500.0, -500.0, 1000.0, 1000.0);

		// Model created with the constructor to test
		BallModel model = new BallModel(0.0, 0.0, bound);
				
		// Change the velocity
		model.setVelX(0.0).setVelY(0.0);
		
		// Update the model
		model.update(1.0);
		
		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 0.0);
		Assertions.assertEquals(model.getPosY(), 0.0);
		
		// Change the velocity
		model.setVelX(10.0).setVelY(-5.0);

		// Update the model
		model.update(2.0);

		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 240.0);
		Assertions.assertEquals(model.getPosY(), -120.0);
		
		// Change the velocity
		model.setVelX(-2.0).setVelY(20.0);

		// Update the model
		model.update(1.5);

		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 204.0);
		Assertions.assertEquals(model.getPosY(), 240.0);
		
		// Change the velocity
		model.setVelX(-10.0).setVelY(-5.0);

		// Update the model
		model.update(1.0);

		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 84.0);
		Assertions.assertEquals(model.getPosY(), 180.0);
		
		// Change the velocity
		model.setVelX(-12.0).setVelY(-8.0);

		// Update the model
		model.update(3.0);

		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), -348.0);
		Assertions.assertEquals(model.getPosY(), -108.0);
	}
	
	@Test
	@DisplayName("Test update method bounce off top")
	void testUpdateBounceTop()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		BallModel model = new BallModel(150.0, 0.0, bound);
		
		// Change the velocity
		model.setVelX(0.0).setVelY(-1.0);
		
		// Update the model
		model.update(1.0);
		
		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 150.0);
		Assertions.assertEquals(model.getPosY(), 12.0);
		
		// Assert that the velocity is correct
		Assertions.assertEquals(model.getVelX(), 0.0);
		Assertions.assertTrue(model.getVelY() > 0.0);
	}
	
	@Test
	@DisplayName("Test update method bounce off bottom")
	void testUpdateBounceBottom()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		BallModel model = new BallModel(150.0, 288.0, bound);
		
		// Change the velocity
		model.setVelX(0.0).setVelY(1.0);
		
		// Update the model
		model.update(1.0);
		
		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 150.0);
		Assertions.assertEquals(model.getPosY(), 140.0);
		
		// Assert that the velocity is correct
		Assertions.assertEquals(model.getVelX(), 0.0);
		Assertions.assertTrue(model.getVelY() < 0.0);
	}
	
	@Test
	@DisplayName("Test update method gives zero score when nobody scored")
	void testUpdateScoreNobody()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		BallModel model = new BallModel(150.0, 50.0, bound);
		
		// Change the velocity
		model.setVelX(.0).setVelY(0.0);
		
		// Update the model
		Assertions.assertEquals(model.update(1.0), 0);
		
		// Change the position
		model.setPosX(5.0).setPosY(50.0);

		// Update the model
		Assertions.assertEquals(model.update(1.0), 0);
		
		// Change the position
		model.setPosX(200.0).setPosY(5.0);

		// Update the model
		Assertions.assertEquals(model.update(1.0), 0);
	}
	
	@Test
	@DisplayName("Test update method gives zero score when player two scored")
	void testUpdateScorePlayerTwo()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		BallModel model = new BallModel(-10.0, 50.0, bound);
		
		// Change the velocity
		model.setVelX(0.0).setVelY(0.0);
		
		// Update the model
		Assertions.assertEquals(model.update(1.0), 2);
		
		// Change the position
		model.setPosX(-5.0).setPosY(50.0);
		
		// Change the velocity
		model.setVelX(0.0).setVelY(0.0);

		// Update the model
		Assertions.assertEquals(model.update(1.0), 2);
		
		// Change the position
		model.setPosX(0.0).setPosY(-5.0);
		
		// Change the velocity
		model.setVelX(0.0).setVelY(0.0);

		// Update the model
		Assertions.assertEquals(model.update(1.0), 2);
	}
	
	@Test
	@DisplayName("Test update method gives zero score when player one scored")
	void testUpdateScorePlayerOne()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		BallModel model = new BallModel(380.0, 50.0, bound);
		
		// Change the velocity
		model.setVelX(0.0).setVelY(0.0);
		
		// Update the model
		Assertions.assertEquals(model.update(1.0), 1);
		
		// Change the position
		model.setPosX(300.0).setPosY(50.0);
		
		// Change the velocity
		model.setVelX(0.0).setVelY(0.0);

		// Update the model
		Assertions.assertEquals(model.update(1.0), 1);
		
		// Change the position
		model.setPosX(240.0).setPosY(200.0);
		
		// Change the velocity
		model.setVelX(0.0).setVelY(0.0);

		// Update the model
		Assertions.assertEquals(model.update(1.0), 1);
	}
}
