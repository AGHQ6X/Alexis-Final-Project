package edu.missouri.finalproject.object.scoreboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScoreboardView
{
	/**
	 * The spritesheet that stores all of the digit pixel art images.
	 */
	BufferedImage digitSheet;
	
	/**
	 * Digit dimensions.
	 */
	int digitHeight, digitWidth;
	
	/**
	 * Load the spritesheet
	 */
	public ScoreboardView()
	{
		// Set the sheet to null in case of error
		this.digitSheet = null;
		
		// Try file IO
		try
		{
			// Attempt to read from file
			this.digitSheet = ImageIO.read(ScoreboardView.class.getResource("/DigitSheet.png"));
		} 
		catch (IOException e)
		{
			System.err.println("ScoreboardView: Digit spritesheet failed to load | " 
							   + e.toString());
		}
		
		// Check if the sheet loaded
		if (this.digitSheet != null)
		{
			// Set height
			this.digitHeight = this.digitSheet.getHeight();
			
			// Set width
			this.digitWidth = this.digitSheet.getWidth() / 10;
		}
	}
	
	/**
	 * Render a single digit at the given dimensions.
	 * 
	 * @param graphics The graphics object to draw upon.
	 * @param x The X to draw the digit at.
	 * @param y The Y to draw the digit at.
	 * @param digit The digit to draw.
	 */
	private void renderDigit(Graphics graphics, int x, int y, int digit)
	{
		// Check if sheet failed to load
		if (this.digitSheet == null)
		{
			// Just don't render if the sheet failed to load
			return;
		}
		
		// Calculate the subimage of the digit spritesheet
		BufferedImage subimage = this.digitSheet.getSubimage(digit * this.digitWidth, 
															  0, 
															  this.digitWidth, 
															  this.digitHeight);
		
		// Attempt to draw the subimage
		graphics.drawImage(subimage, x, y, 80, 80, null);
	}
	
	/**
	 * Called every paint call to render the Scoreboard.
	 * 
	 * @param graphics The graphics object to draw upon.
	 * @param playerOne The {@code Score} object for player 1.
	 * @param playerTwo The {@code Score} object for player 2.
	 */
	public void render(Graphics graphics, Score playerOne, Score playerTwo)
	{
		// Draw player 1 score
		this.renderDigit(graphics, 220, 20, playerOne.getScoreDigitOne());
		this.renderDigit(graphics, 300, 20, playerOne.getScoreDigitTwo());
		this.renderDigit(graphics, 380, 20, playerOne.getScoreDigitThree());
		
		// Draw player 2 score
		this.renderDigit(graphics, 520, 20, playerTwo.getScoreDigitOne());
		this.renderDigit(graphics, 600, 20, playerTwo.getScoreDigitTwo());
		this.renderDigit(graphics, 680, 20, playerTwo.getScoreDigitThree());
		
		// Set the drawing color
		graphics.setColor(Color.WHITE);
		
		// Draw a line
		graphics.drawLine(0, 120, 960, 120);
	}
}
