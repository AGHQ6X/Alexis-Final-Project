package edu.missouri.finalproject.keyboard;

import java.awt.event.KeyEvent;

import java.util.HashMap;
import java.util.Map;

public enum Key
{
	// Keys and their associated bindings
	PLAYER_ONE_UP(KeyEvent.VK_W),
	PLAYER_ONE_DOWN(KeyEvent.VK_S),
	PLAYER_ONE_LEFT(KeyEvent.VK_A),
	PLAYER_ONE_RIGHT(KeyEvent.VK_D),
	PLAYER_TWO_UP(KeyEvent.VK_I),
	PLAYER_TWO_DOWN(KeyEvent.VK_K),
	PLAYER_TWO_LEFT(KeyEvent.VK_J),
	PLAYER_TWO_RIGHT(KeyEvent.VK_L);
	
	/**
	 * Store the bind for the key
	 */
	private int bind;
	
	/**
	 * A subclass to store the map in.
	 */
	private class KeyMap
	{
		// The map to store the awt codes to Enum conversion in
		public static Map<Integer, Key> map = new HashMap<Integer, Key>();
	}
	
	/**
	 * Constructor that adds the key to the map.
	 * 
	 * @param bind The key code to bind to a given key.
	 */
	private Key(int bind)
	{
		// Store the bind
		this.bind = bind;
		
		// Add the key to the map
		KeyMap.map.put(Integer.valueOf(bind), this);
	}
	
	/**
	 * Converts an awt key code into a Keys object.
	 * 
	 * @param key The key code to check.
	 * @return Returns the Key Enum object associated with the key code.
	 */
	public static Key getKey(int key)
	{
		// Return the key from the map
		return KeyMap.map.get(key);
	}
	
	/**
	 * Gets the bind integer code 
	 * 
	 * @return The KeyEvent key
	 */
	public int getBind()
	{
		// Return the key bind
		return this.bind;
	}
}
