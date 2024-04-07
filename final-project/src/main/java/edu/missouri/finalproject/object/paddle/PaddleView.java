package edu.missouri.finalproject.object.paddle;

import java.awt.Color;
import java.awt.Graphics;

import edu.missouri.finalproject.math.Rectangle;

public class PaddleView
{
	/**
	 * Called every paint call to render the Paddle.
	 * 
	 * @param graphics The graphics object to draw upon.
	 * @param hitbox The paddle position and dimensions.
	 */
	public void render(Graphics graphics, Rectangle hitbox)
	{
		// Convert Rectangle to ints
		int x = (int) Math.round(hitbox.getX());
		int y = (int) Math.round(hitbox.getY());
		int width = (int) Math.round(hitbox.getWidth());
		int height = (int) Math.round(hitbox.getHeight());
		
		// Set the current draw color to white
		graphics.setColor(Color.WHITE);
		
		// Draw the rectangle
		graphics.fillRect(x, y, width, height);
	}
}
