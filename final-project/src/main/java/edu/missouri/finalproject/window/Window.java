package edu.missouri.finalproject.window;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import edu.missouri.finalproject.object.scoreboard.ScoreboardView;

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
	public Window()
	{
		// Set the Window title
		this.setTitle(WINDOW_TITLE);
		
		// Set the closing operation
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Try file IO
		try
		{
			// Attempt to read from file
			BufferedImage i16 = ImageIO.read(ScoreboardView.class.getResource("/Icon16.png"));
			BufferedImage i32 = ImageIO.read(ScoreboardView.class.getResource("/Icon32.png"));
			
			// Set images
			this.setIconImages(Arrays.asList(i16, i32));
		} 
		catch (IOException e)
		{
			System.err.println("Window: Image icon failed to load | " 
					+ e.toString());
		}
	}
}
