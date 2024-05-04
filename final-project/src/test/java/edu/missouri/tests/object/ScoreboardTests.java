package edu.missouri.tests.object;

import org.junit.jupiter.api.*;

import edu.missouri.finalproject.object.scoreboard.Score;
import edu.missouri.finalproject.object.scoreboard.ScoreboardModel;

@DisplayName("Test object.scoreboard.ScoreboardModel")
public class ScoreboardTests
{
	@Test
	@DisplayName("Test the ScoreboardModel default constructor")
	void testConstructor()
	{
		// Model created with the constructor to test
		ScoreboardModel model = new ScoreboardModel();
		
		// Get the player scores
		Score playerOne = model.getPlayerOneScore();
		Score playerTwo = model.getPlayerTwoScore();
		
		// Check if the scores are zero
		Assertions.assertEquals(playerOne.getScore(), 0);
		Assertions.assertEquals(playerTwo.getScore(), 0);
	}
	
	@Test
	@DisplayName("Test the ScoreboardModel ability to increment player 1 score")
	void testIncrementPlayerOne()
	{
		// Model created with the constructor to test
		ScoreboardModel model = new ScoreboardModel();
		
		//Increment 3 times
		model.incrementPlayerOneScore().incrementPlayerOneScore().incrementPlayerOneScore();

		// Get the player scores
		Score playerOne = model.getPlayerOneScore();
		
		// Check if player 1 score is equal to 3
		Assertions.assertEquals(playerOne.getScore(), 3);
	}
	
	@Test
	@DisplayName("Test the ScoreboardModel ability to increment player 2 score")
	void testIncrementPlayerTwo()
	{
		// Model created with the constructor to test
		ScoreboardModel model = new ScoreboardModel();
		
		//Increment 3 times
		model.incrementPlayerTwoScore().incrementPlayerTwoScore().incrementPlayerTwoScore();

		// Get the player scores
		Score playerTwo = model.getPlayerTwoScore();
		
		// Check if player 1 score is equal to 3
		Assertions.assertEquals(playerTwo.getScore(), 3);
	}
}
