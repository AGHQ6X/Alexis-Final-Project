package edu.missouri.finalproject.object.ball;

import java.awt.Graphics;

import edu.missouri.finalproject.math.Circle;
import edu.missouri.finalproject.math.Rectangle;

public class BallController
{
	/**
	 * A reference to the main paddle model.
	 */
	private BallModel model;
	
	/**
	 * A reference to the main paddle view.
	 */
	private BallView view;
	
	/**
	 * Creates a model and view for the paddle.
	 */
	public BallController(double x, double y, Rectangle bound)
	{
		// Create model and view
		this.model = new BallModel(x, y, bound);
		this.view = new BallView();
	}
	
	/**
	 * Reset the Ball to default position.
	 */
	public void reset()
	{
		// Reset the Model
		this.model.reset();
	}
	
	/**
	 * Check if a bounce is needed off of a {@code Rectangle} and bounce 
	 * the ball off of it if so.
	 * 
	 * @param rect The rectangle to check and to possibly bounce off of.
	 */
	public void checkBounce(Rectangle rect)
	{
		// Bounce off 
		this.model.bounceRectangle(rect);
	}
	
	/**
	 * Called every frame to update Paddle logic.
	 * 
	 * @param delta The ratio of actual frame duration to ideal frame duration.
	 * @return Returns 0 if nobody scored or the player number of who scored.
	 */
	public int update(double delta)
	{
		// Update the model
		return this.model.update(delta);
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
		Circle hitbox = this.model.getHitbox();
		
		// Tell the view to render
		this.view.render(graphics, hitbox);
	}
}
