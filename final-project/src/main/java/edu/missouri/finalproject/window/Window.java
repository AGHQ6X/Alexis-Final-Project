package edu.missouri.finalproject.window;

import javax.swing.JFrame;

import edu.missouri.finalproject.game.Game;

public class Window extends JFrame
{
	/**
	 * Needed for {@code Serializable} interface.
	 */
	private static final long serialVersionUID = 5410410718413589764L;
	
	/**
	 * The title to make the window upon creation.
	 */
	private static final String WINDOW_TITLE = "Two Player Pong";
	
	/**
	 * Constructs a frame built for this Pong implementation.
	 */
	public Window(Game view)
	{
		// Set the Window title
		this.setTitle(WINDOW_TITLE);
		
		// Set the closing operation
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
