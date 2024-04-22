package edu.missouri.finalproject.object.ball;

import edu.missouri.finalproject.math.Circle;
import edu.missouri.finalproject.math.Rectangle;

public class BallModel
{
	/**
	 * The speed of the ball in pixels per 1/60th second.
	 */
	private static final double startSpeed = 12.0;
	
	/**
	 * The speed of the ball in pixels per 1/60th second.
	 */
	private static final double bounceMod = -1.05;
	
	/**
	 * The stored starting position to reset back to.
	 */
	private double startX, startY;
	
	/**
	 * The velocity of the paddle.
	 */
	private double velX, velY;
	
	/**
	 * The Rectangle that represents the paddle itself.
	 */
	private Circle hitbox;
	
	/**
	 * The region in which the paddle is allowed to move.
	 */
	private Rectangle bound;
	
	/**
	 * The default constructor.
	 */
	public BallModel(double x, double y, Rectangle bound)
	{
		// Set the starting position fields
		this.startX = x;
		this.startY = y;
		
		// Set the velocity to random
		this.randomizeVelocity();
		
		// Set hitbox to given position with set dimensions
		this.hitbox = new Circle(x, y, 40.0);
		
		// Set bounding box to screen
		this.bound = bound;
	}
	
	/**
	 * Randomize the velocity to be moving in both axes.
	 */
	private void randomizeVelocity()
	{
		// Get a random double
		double rand = Math.random();
		
		// Check random number
		if (rand <= 0.25)
		{
			// Move up and left
			this.velX = -0.707;
			this.velY = -0.707;
		}
		else if (rand <= 0.5)
		{
			// Move up and right
			this.velX = 0.707;
			this.velY = -0.707;
		}
		else if (rand <= 0.75)
		{
			// Move down and left
			this.velX = -0.707;
			this.velY = 0.707;
		}
		else
		{
			// Move down and right
			this.velX = 0.707;
			this.velY = 0.707;
		}
	}
	
	/**
	 * Reset the Paddle to default position.
	 */
	public void reset()
	{
		// Reset position
		this.hitbox.setX(this.startX);
		this.hitbox.setY(this.startY);
		
		// Re-randomize velocity
		this.randomizeVelocity();
	}
	
	/**
	 * Bounce off of a Rectangle. It should look at which side it should bounce off of.
	 * 
	 * @param rect The rectangle to bounce off of.
	 */
	private void bounceRectangle(Rectangle rect)
	{
		// TODO Write a bounce algorithm
		this.velX *= BallModel.bounceMod;
	}
	
	/**
	 * Called every frame to update Ball logic.
	 * 
	 * @param delta The ratio of actual frame duration to ideal frame duration.
	 * @param rectOne The hitbox for player 1.
	 * @param rectTwo The hitbox for player 2.
	 * @return Returns 0 if nobody scored or the player number of who scored.
	 */
	public int update(double delta, Rectangle rectOne, Rectangle rectTwo)
	{
		// Translate the paddle
		this.hitbox.translateX(velX * delta * BallModel.startSpeed);
		this.hitbox.translateY(velY * delta * BallModel.startSpeed);
		
		//Check if the ball should bounce off paddle 1
		if (this.hitbox.intersects(rectOne))
		{
			// It intersects paddle 1, so the ball needs to bounce
			this.bounceRectangle(rectOne);
		}
		
		//Check if the ball should bounce off paddle 2
		if (this.hitbox.intersects(rectTwo))
		{
			// It intersects paddle 2, so the ball needs to bounce
			this.bounceRectangle(rectTwo);
		}
		
		// Check if the ball needs to bounce off of the ceiling
		if (this.hitbox.withinRectangleTop(this.bound) == false)
		{
			// Check if the ball is moving upwards
			if (this.velY < 0.0)
			{
				this.velY *= BallModel.bounceMod;
			}
		}
		
		// Check if the ball needs to bounce off of the floor
		if (this.hitbox.withinRectangleBottom(this.bound) == false)
		{
			// Check if the ball is moving downwards
			if (this.velY > 0.0)
			{
				this.velY *= BallModel.bounceMod;
			}
		}
		
		// Check who scored
		if (this.hitbox.withinRectangleLeft(this.bound) == false)
		{
			// Player 2 scored
			return 2;
		}
		else if (this.hitbox.withinRectangleRight(this.bound) == false)
		{
			// Player 1 scored
			return 1;
		}
		else
		{
			// By default, nobody scored
			return 0;
		}
	}
	
	/**
	 * Get the starting X position to set the position on reset.
	 * 
	 * @return The starting X position.
	 */
	public double getStartX()
	{
		// Return startX
		return this.startX;
	}
	
	/**
	 * Get the starting Y position to set the position on reset.
	 * 
	 * @return The starting Y position.
	 */
	public double getStartY()
	{
		// Return startY
		return this.startY;
	}
	
	/**
	 * Get the current X position.
	 * 
	 * @return The current X position.
	 */
	public double getPosX()
	{
		// Return hitbox X
		return this.hitbox.getX();
	}
	
	/**
	 * Get the current Y position.
	 * 
	 * @return The current Y position.
	 */
	public double getPosY()
	{
		// Return hitbox Y
		return this.hitbox.getY();
	}
	
	/**
	 * Get the velocity in the X direction.
	 * 
	 * @return The X velocity.
	 */
	public double getVelX()
	{
		// Return startX
		return this.velX;
	}
	
	/**
	 * Get the velocity in the Y direction.
	 * 
	 * @return The Y velocity.
	 */
	public double getVelY()
	{
		// Return startX
		return this.velY;
	}
	
	/**
	 * Get the {@code Circle} that holds the ball position and size.
	 * 
	 * @return The {@code Circle} that holds the ball position and size.
	 */
	public Circle getHitbox()
	{
		// Return hitbox
		return this.hitbox;
	}
	
	/**
	 * Get the {@code Rectangle} that holds the ball boundaries.
	 * 
	 * @return The {@code Rectangle} that holds the ball boundaries.
	 */
	public Rectangle getBound()
	{
		// Return bound
		return this.bound;
	}
}
