package edu.missouri.finalproject.object.scoreboard;

import java.awt.Graphics;

public class ScoreboardController
{
	/**
	 * A reference to the main paddle model.
	 */
	private ScoreboardModel model;
	
	/**
	 * A reference to the main paddle view.
	 */
	private ScoreboardView view;
	
	/**
	 * Creates a model and view for the paddle.
	 */
	public ScoreboardController()
	{
		// Create model and view
		this.model = new ScoreboardModel();
		this.view = new ScoreboardView();
	}
	
	/**
	 * Increment the score for player 1.
	 */
	public void incrementPlayerOneScore()
	{
		// Increment the score
		this.model.incrementPlayerOneScore();
	}
	
	/**
	 * Increment the score for player 2.
	 */
	public void incrementPlayerTwoScore()
	{
		// Increment the score
		this.model.incrementPlayerTwoScore();
	}
	
	/**
	 * Called by the {@code Game} object in order to tell {@code PaddleController} to 
	 * call upon {@code PaddleView}.
	 * 
	 * @param graphics The graphics object to pass to the view.
	 */
	public void render(Graphics graphics)
	{
		// Get the player 1 score from the model
		Score playerOne = this.model.getPlayerOneScore();
		
		// Get the player 2 score from the model
		Score playerTwo = this.model.getPlayerTwoScore();
		
		// Tell the view to render and pass the scores
		this.view.render(graphics, playerOne, playerTwo);
	}
}
