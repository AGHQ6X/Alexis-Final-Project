package edu.missouri.finalproject.game;

import java.awt.Color;
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
	 * The point in time where the previous frame started.
	 */
	private long lastFrameTime;
	
	/**
	 * The window that the game uses 
	 */
	private Window window;
	
	/**
	 * 
	 */
	private KeyListener keyListener;
	
	/**
	 * The constructor for a game object. This creates a window and gives this object
	 * the ability to display on the window.
	 */
	private Game()
	{
		// Create a new window
		this.window = new Window(this);
				
		// Add the game view as a JPanel
		this.window.add(this);

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
		double delta = (this.lastFrameTime - newFrameTime) / Game.idealFrameTime;
		
		// Reset the timer
		this.lastFrameTime = newFrameTime;
		
		// Tell the controller and its children to update the model
		this.update(delta);
		
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
    	this.render(graphics);
    }
	
	/**
	 * Called every frame in order to tell all child controllers to update game logic.
	 * 
	 * @param delta The ratio of actual frame duration to ideal frame duration.
	 */
	public void update(double delta)
	{
		// TODO
	}
	
	/**
	 * Called every paint call in order to tell all child controllers to paint.
	 * 
	 * @param graphics The graphics object to pass to children.
	 */
	public void render(Graphics graphics)
	{
		// TODO
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
