package edu.missouri.tests.object;

import org.junit.jupiter.api.*;

import edu.missouri.finalproject.object.scoreboard.Score;

@DisplayName("Test object.scoreboard.Score")
public class ScoreTests
{
	@Test
	@DisplayName("Test the Score default constructor.")
	void testConstructor()
	{
		// Model created with the constructor to test
		Score score = new Score();
		
		// Check if the score is zero
		Assertions.assertEquals(score.getScore(), 0);
	}
	
	@Test
	@DisplayName("Test that Score setters and getters work.")
	void testSetGet()
	{
		// Model created with the constructor
		Score score = new Score().setScore(52);

		// Check if the score is correct
		Assertions.assertEquals(score.getScore(), 52);

		// Set the score to a new value
		score.setScore(523);

		// Check if the score is correct
		Assertions.assertEquals(score.getScore(), 523);

		// Set the score to a new value
		score.setScore(765);

		// Check if the score is correct
		Assertions.assertEquals(score.getScore(), 765);

		// Set the score to a new value
		score.setScore(204);

		// Check if the score is correct
		Assertions.assertEquals(score.getScore(), 204);

		// Set the score to a new value
		score.setScore(124);

		// Check if the score is correct
		Assertions.assertEquals(score.getScore(), 124);

		// Set the score to a new value
		score.setScore(999);

		// Check if the score is correct
		Assertions.assertEquals(score.getScore(), 999);
	}
	
	@Test
	@DisplayName("Test that Score incriments when called to.")
	void testIncrementBasic()
	{
		// Model created with the constructor to test
		Score score = new Score();
		
		// Check if the score is zero
		Assertions.assertEquals(score.getScore(), 0);
		
		// Increment the score
		score.incrementScore();
		
		// Check if the score is correct
		Assertions.assertEquals(score.getScore(), 1);
		
		// Increment the score
		score.incrementScore();

		// Check if the score is correct
		Assertions.assertEquals(score.getScore(), 2);
		
		// Increment the score
		score.incrementScore();

		// Check if the score is correct
		Assertions.assertEquals(score.getScore(), 3);
	}
	
	@Test
	@DisplayName("Test that Score digit 1 is accurate.")
	void testScoreDigitOne()
	{
		// Model created with the constructor
		Score score = new Score().setScore(52);
		
		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitOne(), 0);
		
		// Set the score to a new value
		score.setScore(523);
		
		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitOne(), 5);
		
		// Set the score to a new value
		score.setScore(765);
				
		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitOne(), 7);
		
		// Set the score to a new value
		score.setScore(204);

		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitOne(), 2);
		
		// Set the score to a new value
		score.setScore(124);

		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitOne(), 1);
		
		// Set the score to a new value
		score.setScore(999);

		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitOne(), 9);
	}
	
	@Test
	@DisplayName("Test that Score digit 2 is accurate.")
	void testScoreDigitTwo()
	{
		// Model created with the constructor
		Score score = new Score().setScore(52);
		
		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitTwo(), 5);
		
		// Set the score to a new value
		score.setScore(523);
		
		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitTwo(), 2);
		
		// Set the score to a new value
		score.setScore(765);
				
		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitTwo(), 6);
		
		// Set the score to a new value
		score.setScore(204);

		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitTwo(), 0);
		
		// Set the score to a new value
		score.setScore(124);

		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitTwo(), 2);
		
		// Set the score to a new value
		score.setScore(999);

		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitTwo(), 9);
	}
	
	@Test
	@DisplayName("Test that Score digit 3 is accurate.")
	void testScoreDigitThree()
	{
		// Model created with the constructor
		Score score = new Score().setScore(52);
		
		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitThree(), 2);
		
		// Set the score to a new value
		score.setScore(523);
		
		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitThree(), 3);
		
		// Set the score to a new value
		score.setScore(765);
				
		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitThree(), 5);
		
		// Set the score to a new value
		score.setScore(204);

		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitThree(), 4);
		
		// Set the score to a new value
		score.setScore(124);

		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitThree(), 4);
		
		// Set the score to a new value
		score.setScore(999);

		// Check if the score is correct
		Assertions.assertEquals(score.getScoreDigitThree(), 9);
	}
}
