package edu.missouri.finalproject.object.scoreboard;

public class Score
{
	/**
	 * Stores the current score.
	 */
	private int score;
	
	/**
	 * Creates a {@code Score} object set to a score of zero.
	 */
	public Score()
	{
		// Zero out the score
		this.score = 0;
	}
	
	/**
	 * Increment the score if possible.
	 * 
	 * @return Returns {@code this}.
	 */
	public Score incrementScore()
	{
		// Check that the score will be displayable
		if (this.score < 999)
		{
			// Increment the score
			this.score++;
		}
		
		// Return this
		return this;
	}
	
	/**
	 * Setter for the total score.
	 * 
	 * @param score The new score to set to.
	 * @return Returns {@code this}.
	 */
	public Score setScore(int score)
	{
		// Set score
		this.score = score;
		
		// Return this
		return this;
	}
	
	/**
	 * Getter for the total score.
	 * 
	 * @return The current score total.
	 */
	public int getScore()
	{
		// Return score
		return this.score;
	}
	
	/**
	 * Getter for the first digit (hundreds place) of the store.
	 * 
	 * @return The hundreds place digit.
	 */
	public int getScoreDigitOne()
	{
		// Return hundreds place
		return (this.score / 100) % 10;
	}
	
	/**
	 * Getter for the second digit (tens place) of the store.
	 * 
	 * @return The tens place digit.
	 */
	public int getScoreDigitTwo()
	{
		// Return tens place
		return (this.score / 10) % 10;
	}
	
	/**
	 * Getter for the first digit (hundreds place) of the store.
	 * 
	 * @return The ones place digit.
	 */
	public int getScoreDigitThree()
	{
		// Return ones place
		return this.score % 10;
	}
}
