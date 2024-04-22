package edu.missouri.finalproject.object.scoreboard;

public class ScoreboardModel
{
	/**
	 * The score for player 1.
	 */
	private Score playerOne;
	
	/**
	 * The score for player 1.
	 */
	private Score playerTwo;
	
	/**
	 * Default constructor creates two player scores set to zero.
	 */
	public ScoreboardModel()
	{
		// Create both player scores with default constructor
		this.playerOne = new Score();
		this.playerTwo = new Score();
	}
	
	/**
	 * Increment the score for player 1.
	 */
	public void incrementPlayerOneScore()
	{
		// Increment the score
		this.playerOne.incrementScore();
	}
	
	/**
	 * Increment the score for player 2.
	 */
	public void incrementPlayerTwoScore()
	{
		// Increment the score
		this.playerTwo.incrementScore();
	}
	
	/**
	 * Getter for the player 1 score.
	 * 
	 * @return The {@code Score} object asked for.
	 */
	public Score getPlayerOneScore()
	{
		/**
		 * Return the score.
		 */
		return this.playerOne;
	}
	
	/**
	 * Getter for the player 2 score.
	 * 
	 * @return The {@code Score} object asked for.
	 */
	public Score getPlayerTwoScore()
	{
		/**
		 * Return the score.
		 */
		return this.playerTwo;
	}
}
