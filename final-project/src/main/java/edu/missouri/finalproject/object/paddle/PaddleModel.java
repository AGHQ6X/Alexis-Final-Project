package edu.missouri.finalproject.object.paddle;

import edu.missouri.finalproject.math.Rectangle;

public class PaddleModel
{
	/**
	 * The speed of the paddle in pixels per 1/60th second.
	 */
	private static final double paddleSpeed = 6.0;
	
	/**
	 * The stored starting position to reset back to.
	 */
	@SuppressWarnings("unused")
	private double startX, startY;
	
	/**
	 * The velocity of the paddle.
	 */
	private double velX, velY;
	
	/**
	 * The Rectangle that represents the paddle itself.
	 */
	private Rectangle hitbox;
	
	/**
	 * The region in which the paddle is allowed to move.
	 */
	private Rectangle bound;
	
	/**
	 * The default constructor.
	 */
	public PaddleModel(double x, double y, Rectangle bound)
	{
		// Set the starting position fields
		this.startX = x;
		this.startY = y;
		
		// Set the velocity to zero
		this.velX = 0.0;
		this.velY = 0.0;
		
		// Set hitbox to given position with set dimensions
		this.hitbox = new Rectangle(x, y, 20.0, 200.0);
		
		// Set bounding box to given Rectangle
		this.bound = bound;
	}
	
	/**
	 * Accept key inputs from the controller.
	 * 
	 * @param up True if the up key is being held.
	 * @param down True if the down key is being used.
	 * @param left True if the left key is being used.
	 * @param right True if the right key is being used.
	 */
	public void acceptKeys(boolean up, boolean down, boolean left, boolean right)
	{
		// Check which direction the player is attempting to go in
		if (up && !down && (left == right))
		{
			// Move up
			this.velX = 0.000;
			this.velY = 1.000;
		} 
		else if (down && !up && (left == right))
		{
			// Move down
			this.velX = 0.000;
			this.velY = -1.000;
		}
		else if (left && !right && (up == down))
		{
			// Move left
			this.velX = 1.000;
			this.velY = 0.000;
		}
		else if (right && !left && (up == down))
		{
			// Move right
			this.velX = -1.000;
			this.velY = 0.000;
		}
		else if (up && left && !down && !right)
		{
			// Move up and left
			this.velX = 0.707;
			this.velY = 0.707;
		}
		else if (up && right && !down && !left)
		{
			// Move up and right
			this.velX = -0.707;
			this.velY = 0.707;
		}
		else if (down && left && !up && !right)
		{
			// Move down and left
			this.velX = 0.707;
			this.velY = -0.707;
		}
		else if (down && right && !up && !left)
		{
			// Move down and right
			this.velX = -0.707;
			this.velY = -0.707;
		}
		else
		{
			// Stay still
			this.velX = 0.0;
			this.velY = 0.0;
		}
	}
	
	/**
	 * Called every frame to update Paddle logic.
	 * 
	 * @param delta The ratio of actual frame duration to ideal frame duration.
	 */
	public void update(double delta)
	{
		// Translate the paddle
		this.hitbox.translateX(velX * delta * PaddleModel.paddleSpeed);
		this.hitbox.translateY(velY * delta * PaddleModel.paddleSpeed);
		
		// Make sure paddle is within upper bounds
		if (this.hitbox.withinRectangleTop(this.bound) == false)
		{
			// Move hitbox back within bound
			this.hitbox.setY(this.bound.getMinY());
		}
		
		// Make sure paddle is within lower bounds
		if (this.hitbox.withinRectangleBottom(this.bound) == false)
		{
			// Move hitbox back within bound
			this.hitbox.setY(this.bound.getMaxY() - this.hitbox.getHeight());
		}
		
		// Make sure paddle is within left bounds
		if (this.hitbox.withinRectangleLeft(this.bound) == false)
		{
			// Move hitbox back within bound
			this.hitbox.setX(this.bound.getMinX());
		}

		// Make sure paddle is within right bounds
		if (this.hitbox.withinRectangleRight(this.bound) == false)
		{
			// Move hitbox back within bound
			this.hitbox.setX(this.bound.getMaxX() - this.hitbox.getWidth());
		}
	}
	
	/**
	 * Get the {@code Rectangle} that holds the paddle position and size.
	 * 
	 * @return The {@code Rectangle} that holds the paddle position and size.
	 */
	public Rectangle getHitbox()
	{
		// Return paddleBox
		return this.hitbox;
	}
}
