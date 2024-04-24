package edu.missouri.tests.object;

import org.junit.jupiter.api.*;

import edu.missouri.finalproject.object.scoreboard.Score;
import edu.missouri.finalproject.object.scoreboard.ScoreboardModel;

@DisplayName("Test object.scoreboard.ScoreboardModel")
public class ScoreboardTests
{
	@Test
	@DisplayName("Test the ScoreboardModel default constructor.")
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
}
