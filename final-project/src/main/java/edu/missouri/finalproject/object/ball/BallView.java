package edu.missouri.finalproject.object.ball;

import java.awt.Color;
import java.awt.Graphics;

import edu.missouri.finalproject.math.Circle;

public class BallView
{
	/**
	 * Called every paint call to render the Ball.
	 * 
	 * @param graphics The graphics object to draw upon.
	 * @param hitbox The ball position and dimensions.
	 */
	public void render(Graphics graphics, Circle hitbox)
	{
		// Convert Circle to ints
		int x = (int) Math.round(hitbox.getX());
		int y = (int) Math.round(hitbox.getY());
		int diameter = (int) Math.round(hitbox.getDiameter());
		
		// Set the current draw color to white
		graphics.setColor(Color.WHITE);
		
		// Draw the rectangle
		graphics.fillOval(x, y, diameter, diameter);
	}
}
