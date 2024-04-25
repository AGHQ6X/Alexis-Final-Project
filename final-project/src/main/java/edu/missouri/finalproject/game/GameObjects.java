package edu.missouri.finalproject.game;

import java.awt.Graphics;

import edu.missouri.finalproject.keyboard.Key;
import edu.missouri.finalproject.keyboard.KeyListener;
import edu.missouri.finalproject.math.Rectangle;
import edu.missouri.finalproject.object.ball.BallController;
import edu.missouri.finalproject.object.paddle.PaddleController;
import edu.missouri.finalproject.object.scoreboard.ScoreboardController;

/**
 * Contains the game board objects for {@code Game}.
 */
public class GameObjects
{
	/**
	 * The scoreboard for the game.
	 */
	private ScoreboardController scoreboard;
	
	/**
	 * The object to control the player 1 paddle.
	 */
	private PaddleController playerOne;
	
	/**
	 * The object to control the player 2 paddle.
	 */
	private PaddleController playerTwo;
	
	/**
	 * The object to control a bouncing ball.
	 */
	private BallController ball;
	
	/**
	 * Generate game objects.
	 */
	public GameObjects()
	{
		// Create a scoreboard
		this.scoreboard = new ScoreboardController();
		
		// Create player 1
		Rectangle playerOneBound = new Rectangle(0.0, 120.0, 240.0, 600.0);
		this.playerOne = new PaddleController(40.0, 320.0, playerOneBound)
				.setKeyUp(Key.PLAYER_ONE_UP)
				.setKeyDown(Key.PLAYER_ONE_DOWN)
				.setKeyLeft(Key.PLAYER_ONE_LEFT)
				.setKeyRight(Key.PLAYER_ONE_RIGHT);
		
		// Create player 2
		Rectangle playerTwoBound = new Rectangle(720.0, 120.0, 240.0, 600.0);
		this.playerTwo = new PaddleController(880.0, 320.0, playerTwoBound)
				.setKeyUp(Key.PLAYER_TWO_UP)
				.setKeyDown(Key.PLAYER_TWO_DOWN)
				.setKeyLeft(Key.PLAYER_TWO_LEFT)
				.setKeyRight(Key.PLAYER_TWO_RIGHT);
		
		// Create ball
		Rectangle ballBound = new Rectangle(0.0, 120.0, 960.0, 600.0);
		this.ball = new BallController(440.0, 380.0, ballBound);
	}
	
	/**
	 * Reset paddles and ball to default location and velocities.
	 */
	private void reset()
	{
		// Reset all
		this.playerOne.reset();
		this.playerTwo.reset();
		this.ball.reset();
	}
	
	/**
	 * Called every frame in order to tell all objects to update game logic.
	 * 
	 * @param delta The ratio of actual frame duration to ideal frame duration.
	 * @param keys The {@code KeyListener} to pass to objects.
	 */
	public void update(double delta, KeyListener keys)
	{
		// Update player 1
		this.playerOne.update(delta, keys);
		
		// Update player 2
		this.playerTwo.update(delta, keys);
		
		// Get paddle hitboxes as Rectangles
		Rectangle hitboxOne = this.playerOne.getHitbox();
		Rectangle hitboxTwo = this.playerTwo.getHitbox();
		
		// Update the ball and get score
		int score = this.ball.update(delta, hitboxOne, hitboxTwo);
		
		// Reset objects if someone scored
		if (score != 0)
		{
			// Set all objects to reset
			this.reset();
		}
		
		// Check for player 1 score
		if (score == 1)
		{
			// Increment player 1 score
			this.scoreboard.incrementPlayerOneScore();
		}
		
		// Check for player 2 score
		if (score == 2)
		{
			// Increment player 2 score
			this.scoreboard.incrementPlayerTwoScore();
		}
	}
	
	/**
	 * Called every paint call in order to tell all objects to paint.
	 * 
	 * @param graphics The graphics object to pass to children.
	 */
	public void render(Graphics graphics)
	{
		// Render scoreboard
		this.scoreboard.render(graphics);
		
		// Render player 1
		this.playerOne.render(graphics);
		
		// Render player 2
		this.playerTwo.render(graphics);
		
		// Render the ball
		this.ball.render(graphics);
	}
}
