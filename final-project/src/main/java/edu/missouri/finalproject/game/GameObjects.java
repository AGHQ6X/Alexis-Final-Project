package edu.missouri.finalproject.game;

import java.awt.Graphics;

import edu.missouri.finalproject.keyboard.Key;
import edu.missouri.finalproject.keyboard.KeyListener;
import edu.missouri.finalproject.math.Rectangle;
import edu.missouri.finalproject.object.paddle.PaddleController;

/**
 * Contains the game board objects for {@code Game}.
 */
public class GameObjects
{
	/**
	 * The object to control the player 1 paddle.
	 */
	private PaddleController playerOne;
	
	/**
	 * The object to control the player 2 paddle.
	 */
	private PaddleController playerTwo;
	
	/**
	 * Generate game objects.
	 */
	public GameObjects()
	{
		// Create player 1
		Rectangle playerOneBound = new Rectangle(0.0, 120.0, 240.0, 600.0);
		this.playerOne = new PaddleController(40.0, 320.0, playerOneBound)
				.setKeyUp(Key.PLAYER_ONE_UP)
				.setKeyDown(Key.PLAYER_ONE_DOWN)
				.setKeyLeft(Key.PLAYER_ONE_LEFT)
				.setKeyRight(Key.PLAYER_ONE_RIGHT);
		
		// Create player 2
		Rectangle playerTwoBound = new Rectangle(720.0, 120.0, 240.0, 600.0);
		this.playerTwo = new PaddleController(900.0, 320.0, playerTwoBound)
				.setKeyUp(Key.PLAYER_TWO_UP)
				.setKeyDown(Key.PLAYER_TWO_DOWN)
				.setKeyLeft(Key.PLAYER_TWO_LEFT)
				.setKeyRight(Key.PLAYER_TWO_RIGHT);
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
		playerOne.update(delta, keys);
		
		// Update player 2
		playerTwo.update(delta, keys);
	}
	
	/**
	 * Called every paint call in order to tell all objects to paint.
	 * 
	 * @param graphics The graphics object to pass to children.
	 */
	public void render(Graphics graphics)
	{
		// Render player 1
		playerOne.render(graphics);
		
		// Render player 2
		playerTwo.render(graphics);
	}
}
