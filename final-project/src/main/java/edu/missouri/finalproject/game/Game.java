package edu.missouri.finalproject.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import edu.missouri.finalproject.keyboard.KeyListener;
import edu.missouri.finalproject.window.Window;

/**
 * Controls the flow of the game by managing the main loop and children.
 */
public class Game extends JPanel implements ActionListener
{
	/**
	 * Needed for {@code Serializable} interface.
	 */
	private static final long serialVersionUID = -6421306597088218028L;
	
	/**
	 * The minimum amount of time a frame should take for 60 FPS.
	 */
	private static final long idealFrameTime = 1000000000 / 60;
	
	/**
	 * The default height to make the window.
	 */
	private static final int pannelWidth = 960;
	
	/**
	 * The default width to make the window.
	 */
	private static final int pannelHeight = 720;
	
	/**
	 * The point in time where the previous frame started.
	 */
	private long lastFrameTime;
	
	/**
	 * The window that the game uses 
	 */
	private Window window;
	
	/**
	 * The key listener that keeps track of the pressed status of important keys.
	 */
	private KeyListener keyListener;
	
	/**
	 * The collection of objects that are on the board.
	 */
	private GameObjects objects;
	
	/**
	 * The constructor for a game object. This creates a window and gives this object
	 * the ability to display on the window.
	 */
	private Game()
	{
		// Create a new window
		this.window = new Window();
				
		// Add the game view as a JPanel
		this.window.add(this);
		
		//Set the size of the game
		this.setPreferredSize(new Dimension(Game.pannelWidth, Game.pannelHeight));
		this.window.pack();

		// Set the background color for this panel
		this.setBackground(Color.BLACK);

		// Set the window as visible
		this.window.setVisible(true);
		
		// Set this as focused
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		// Create a game key listener and add it to this panel
		this.keyListener = new KeyListener();
		this.addKeyListener(this.keyListener);
		
		// Create game objects
		this.objects = new GameObjects();
	}
	
	/**
	 * Contains the primary game loop. This guarantees that the game is updated at most
	 * 60 times per second.
	 */
	private void run()
	{
		// Create and run a timer that runs the action listener ~1/60th second
		Timer timer = new Timer(17, this);
		timer.start();
		
		// Set a first frame time
		this.lastFrameTime = System.nanoTime();
	}
	
	/**
	 * Update the main game logic. The {@code run} method causes this to run ~60 times 
	 * per second.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Calculate the time at the beginning of this frame
		long newFrameTime = System.nanoTime();
		
		// Calculate the ratio of actual frame duration to ideal frame duration
		double delta = (newFrameTime - this.lastFrameTime) / Game.idealFrameTime;
		
		// Reset the timer
		this.lastFrameTime = newFrameTime;
		
		// Tell the controller and its children to update the model
		this.objects.update(delta, this.keyListener);
		
		// Tell the panel to paint everything
		this.repaint();
	}
	
	/**
	 * Called when the panel is ready to be painted. It draws the background and then 
	 * tells this to paint children.
	 * 
	 * @param graphics The graphics object to pass to children.
	 */
	@Override
    public void paintComponent(Graphics graphics)
    {
		// Paint the default before beginning drawing
    	super.paintComponent(graphics);
    	
    	// Tell the controller to draw children
    	this.objects.render(graphics);
    }
	
	/**
	 * The Main method; it creates and runs a GameController object.
	 * 
	 * @param args Unused default arguments.
	 */
	public static void main(String[] args)
	{
		// Slightly delay things
		EventQueue.invokeLater(() -> 
		{
			// Create a game object
			Game game = new Game();
			
			// Run the game loop
			game.run();
        });
	}
}
