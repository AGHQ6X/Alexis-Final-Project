package edu.missouri.finalproject.keyboard;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.EnumMap;
import java.util.Map;

/**
 * The {@code KeyListener} class will keep track of keyboard input such that the 
 * controllers are able to check which important keys are being held.
 */
public class KeyListener extends KeyAdapter
{
	/**
	 * A map that associates every important key with whether it's pressed.
	 */
	private Map<Key, Boolean> isPressed;
	
	/**
	 * Default constructor that fills out the map.
	 */
	public KeyListener()
	{
		// Create an Enum map 
		this.isPressed = new EnumMap<Key, Boolean>(Key.class);
		
		// Loop through all keys
		for (Key key : Key.values())
		{
			// Set every entry to false (no keys pressed by default)
			this.isPressed.put(key, Boolean.FALSE);
		}
	}
	
	/**
	 * Check if a key is being pressed.
	 * 
	 * @param key The key to check the status of.
	 * @return Return whether the key is being pressed at the moment.
	 */
	public boolean isKeyPressed(Key key)
	{
		// Return the boolean from the Enum
		return this.isPressed.get(key);
	}
	
	/**
	 * Invoked any time a key is pressed.
	 * 
	 * @param event The event object sent when pressed.
	 */
	@Override
	public void keyPressed(KeyEvent event)
	{
		// Get the key int 
		int id = event.getKeyCode();
		
		// Get the Key Enum associated with it
		Key key = Key.getKey(id);
		
		// Check if key is mapped
		if (key != null)
		{
			// Set the map to pressed
			this.isPressed.put(key, Boolean.TRUE);
		}
	}
	
	/**
	 * Invoked any time a key is released.
	 * 
	 * @param event The event object sent when released.
	 */
	@Override
	public void keyReleased(KeyEvent event)
	{
		// Get the key int 
		int id = event.getKeyCode();
		
		// Get the Key Enum associated with it
		Key key = Key.getKey(id);
		
		// Check if key is mapped
		if (key != null)
		{
			// Set the map to pressed
			this.isPressed.put(key, Boolean.FALSE);
		}
	}
}
