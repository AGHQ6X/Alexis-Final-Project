package edu.missouri.tests.object;

import org.junit.jupiter.api.*;

import edu.missouri.finalproject.math.Rectangle;
import edu.missouri.finalproject.object.paddle.PaddleModel;

@DisplayName("Test object.paddle.PaddleModel")
public class PaddleTests
{
	@Test
	@DisplayName("Test the constructor")
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
	
	@Test
	@DisplayName("Test acceptKeys(boolean, boolean, boolean, boolean) neutral")
	void testAcceptKeysNeutral()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(150.0, 150.0, bound);
		
		// Test if up key alone works
		model.acceptKeys(false, false, false, false);
		
		// Test that the current velocity is up
		Assertions.assertEquals(model.getVelX(), 0.000);
		Assertions.assertEquals(model.getVelY(), 0.000);
		
		// Test if up, down, left, and right key combo works
		model.acceptKeys(true, true, true, true);

		// Test that the current velocity is up
		Assertions.assertEquals(model.getVelX(), 0.000);
		Assertions.assertEquals(model.getVelY(), 0.000);
	}
	
	@Test
	@DisplayName("Test acceptKeys(boolean, boolean, boolean, boolean) up")
	void testAcceptKeysUp()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(150.0, 150.0, bound);
		
		// Test if up key alone works
		model.acceptKeys(true, false, false, false);
		
		// Test that the current velocity is up
		Assertions.assertEquals(model.getVelX(), 0.000);
		Assertions.assertEquals(model.getVelY(), -1.000);
		
		// Test if up key, left, and right works 
		model.acceptKeys(true, false, true, true);

		// Test that the current velocity is up
		Assertions.assertEquals(model.getVelX(), 0.000);
		Assertions.assertEquals(model.getVelY(), -1.000);
	}
	
	@Test
	@DisplayName("Test acceptKeys(boolean, boolean, boolean, boolean) down")
	void testAcceptKeysDown()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(150.0, 150.0, bound);
		
		// Test if down key alone works
		model.acceptKeys(false, true, false, false);
		
		// Test that the current velocity is down
		Assertions.assertEquals(model.getVelX(), 0.000);
		Assertions.assertEquals(model.getVelY(), 1.000);
		
		// Test if down key, left, and right works 
		model.acceptKeys(false, true, true, true);

		// Test that the current velocity is up
		Assertions.assertEquals(model.getVelX(), 0.000);
		Assertions.assertEquals(model.getVelY(), 1.000);
	}
	
	@Test
	@DisplayName("Test acceptKeys(boolean, boolean, boolean, boolean) left")
	void testAcceptKeysLeft()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(150.0, 150.0, bound);
		
		// Test if left key alone works
		model.acceptKeys(false, false, true, false);
		
		// Test that the current velocity is down
		Assertions.assertEquals(model.getVelX(), -1.000);
		Assertions.assertEquals(model.getVelY(), 0.000);
		
		// Test if left, up, and down works 
		model.acceptKeys(true, true, true, false);

		// Test that the current velocity is up
		Assertions.assertEquals(model.getVelX(), -1.000);
		Assertions.assertEquals(model.getVelY(), 0.000);
	}
	
	@Test
	@DisplayName("Test acceptKeys(boolean, boolean, boolean, boolean) down")
	void testAcceptKeysRight()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(150.0, 150.0, bound);
		
		// Test if right key alone works
		model.acceptKeys(false, false, false, true);
		
		// Test that the current velocity is down
		Assertions.assertEquals(model.getVelX(), 1.000);
		Assertions.assertEquals(model.getVelY(), 0.000);
		
		// Test if right, up, and down works 
		model.acceptKeys(true, true, false, true);

		// Test that the current velocity is up
		Assertions.assertEquals(model.getVelX(), 1.000);
		Assertions.assertEquals(model.getVelY(), 0.000);
	}
	
	@Test
	@DisplayName("Test acceptKeys(boolean, boolean, boolean, boolean) up left")
	void testAcceptKeysUpLeft()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(150.0, 150.0, bound);
		
		// Test if right key alone works
		model.acceptKeys(true, false, true, false);
		
		// Test that the current velocity is up left
		Assertions.assertEquals(model.getVelX(), -0.707);
		Assertions.assertEquals(model.getVelY(), -0.707);
	}
	
	@Test
	@DisplayName("Test acceptKeys(boolean, boolean, boolean, boolean) up right")
	void testAcceptKeysUpRight()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(150.0, 150.0, bound);
		
		// Test if right key alone works
		model.acceptKeys(true, false, false, true);
		
		// Test that the current velocity is up right
		Assertions.assertEquals(model.getVelX(), 0.707);
		Assertions.assertEquals(model.getVelY(), -0.707);
	}
	
	@Test
	@DisplayName("Test acceptKeys(boolean, boolean, boolean, boolean) down left")
	void testAcceptKeysDownLeft()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(150.0, 150.0, bound);
		
		// Test if right key alone works
		model.acceptKeys(false, true, true, false);
		
		// Test that the current velocity is up left
		Assertions.assertEquals(model.getVelX(), -0.707);
		Assertions.assertEquals(model.getVelY(), 0.707);
	}
	
	@Test
	@DisplayName("Test acceptKeys(boolean, boolean, boolean, boolean) down right")
	void testAcceptKeysDownRight()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(150.0, 150.0, bound);
		
		// Test if right key alone works
		model.acceptKeys(false, true, false, true);
		
		// Test that the current velocity is up left
		Assertions.assertEquals(model.getVelX(), 0.707);
		Assertions.assertEquals(model.getVelY(), 0.707);
	}
	
	@Test
	@DisplayName("Test reset()")
	void testReset()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(150.0, 150.0, bound);
		
		// Change the position
		model.setPosX(200.0).setPosY(100.0);
		
		// Change the velocity
		model.setVelX(14.0).setVelY(10.0);
		
		// Reset the position
		model.reset();
		
		// Test that the reset position coordinates are saved correctly
		Assertions.assertEquals(model.getPosX(), 150.0);
		Assertions.assertEquals(model.getPosY(), 150.0);
	}
	
	@Test
	@DisplayName("Test the setters and getters")
	void testSetGet()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(150.0, 150.0, bound);
		
		// Change the position
		model.setPosX(250.0).setPosY(100.0);

		// Change the velocity
		model.setVelX(-12.0).setVelY(16.0);
		
		// Test that the current position was changed
		Assertions.assertEquals(model.getPosX(), 250.0);
		Assertions.assertEquals(model.getPosY(), 100.0);
		
		// Test that the current velocity was changed
		Assertions.assertEquals(model.getVelX(), -12.0);
		Assertions.assertEquals(model.getVelY(), 16.0);
	}
	
	@Test
	@DisplayName("Test update(double) moves paddle based off velocity")
	void testUpdateMovesPaddle()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(-500.0, -500.0, 1000.0, 1000.0);

		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(0.0, 0.0, bound);
		
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
	@DisplayName("Test update(double) moves paddle based off velocity AND delta")
	void testUpdateMovesPaddleDelta()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(-500.0, -500.0, 1000.0, 1000.0);

		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(0.0, 0.0, bound);
		
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
	@DisplayName("Test update method bound top")
	void testUpdateBoundTop()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(150.0, -10.0, bound);
		
		// Change the velocity
		model.setVelX(0.0).setVelY(0.0);

		// Update the model
		model.update(1.0);

		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 150.0);
		Assertions.assertEquals(model.getPosY(), 0.0);
	}
	
	@Test
	@DisplayName("Test update method bound bottom")
	void testUpdateBoundBottom()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(150.0, 150.0, bound);
		
		// Change the velocity
		model.setVelX(0.0).setVelY(0.0);

		// Update the model
		model.update(1.0);

		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 150.0);
		Assertions.assertEquals(model.getPosY(), 100.0);
	}
	
	@Test
	@DisplayName("Test update method bound left")
	void testUpdateBoundLeft()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(-10.0, 50.0, bound);
		
		// Change the velocity
		model.setVelX(0.0).setVelY(0.0);

		// Update the model
		model.update(1.0);

		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 0.0);
		Assertions.assertEquals(model.getPosY(), 50.0);
	}
	
	@Test
	@DisplayName("Test update method bound right")
	void testUpdateBoundRight()
	{
		// Goal hitbox and bound
		Rectangle bound = new Rectangle(0.0, 0.0, 300.0, 300.0);

		// Model created with the constructor to test
		PaddleModel model = new PaddleModel(300.0, 50.0, bound);
		
		// Change the velocity
		model.setVelX(0.0).setVelY(0.0);

		// Update the model
		model.update(1.0);

		// Assert that the new position is correct
		Assertions.assertEquals(model.getPosX(), 260.0);
		Assertions.assertEquals(model.getPosY(), 50.0);
	}
}
