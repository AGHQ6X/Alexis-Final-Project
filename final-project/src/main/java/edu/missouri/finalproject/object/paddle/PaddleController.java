package edu.missouri.finalproject.object.paddle;

import java.awt.Graphics;

import edu.missouri.finalproject.keyboard.Key;
import edu.missouri.finalproject.keyboard.KeyListener;
import edu.missouri.finalproject.math.Rectangle;

public class PaddleController
{
	/**
	 * A reference to the main paddle model.
	 */
	private PaddleModel model;
	
	/**
	 * A reference to the main paddle view.
	 */
	private PaddleView view;
	
	/**
	 * The key code associated with this paddle moving.
	 */
	private Key keyUp, keyDown, keyLeft, keyRight;
	
	/**
	 * Creates a model and view for the paddle.
	 */
	public PaddleController(double x, double y, Rectangle bound)
	{
		// Create model and view
		this.model = new PaddleModel(x, y, bound);
		this.view = new PaddleView();
	}
	
	/**
	 * Called every frame to update Paddle logic.
	 * 
	 * @param delta The ratio of actual frame duration to ideal frame duration.
	 * @param keys The {@code KeyListener} for the game to check for controls.
	 */
	public void update(double delta, KeyListener keys)
	{
		// Check keys
		boolean up = keys.isKeyPressed(keyUp);
		boolean down = keys.isKeyPressed(keyDown);
		boolean left = keys.isKeyPressed(keyLeft);
		boolean right = keys.isKeyPressed(keyRight);
		
		// Give the model the keyboard input
		this.model.acceptKeys(up, down, left, right);
		
		// Update the model 
		this.model.update(delta);
	}
	
	/**
	 * Called by the {@code Game} object in order to tell {@code PaddleController} to 
	 * call upon {@code PaddleView}.
	 * 
	 * @param graphics The graphics object to pass to the view.
	 */
	public void render(Graphics graphics)
	{
		// Get the hitbox object
		Rectangle hitbox = this.model.getHitbox();
		
		// Tell the view to render
		this.view.render(graphics, hitbox);
	}
	
	/**
	 * Set the key code for this paddle's up key.
	 * 
	 * @param keyCode The key code to set.
	 * @return Returns {@code this}.
	 */
	public PaddleController setKeyUp(Key keyCode)
	{
		// Set the key code
		this.keyUp = keyCode;
		
		// Return this
		return this;
	}
	
	/**
	 * Set the key code for this paddle's down key.
	 * 
	 * @param keyCode The key code to set.
	 * @return Returns {@code this}.
	 */
	public PaddleController setKeyDown(Key keyCode)
	{
		// Set the key code
		this.keyDown = keyCode;
		
		// Return this
		return this;
	}
	
	/**
	 * Set the key code for this paddle's left key.
	 * 
	 * @param keyCode The key code to set.
	 * @return Returns {@code this}.
	 */
	public PaddleController setKeyLeft(Key keyCode)
	{
		// Set the key code
		this.keyLeft = keyCode;
		
		// Return this
		return this;
	}
	
	/**
	 * Set the key code for this paddle's right key.
	 * 
	 * @param keyCode The key code to set.
	 * @return Returns {@code this}.
	 */
	public PaddleController setKeyRight(Key keyCode)
	{
		// Set the key code
		this.keyRight = keyCode;
		
		// Return this
		return this;
	}
}
