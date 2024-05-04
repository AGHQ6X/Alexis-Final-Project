package edu.missouri.tests.keyboard;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.event.KeyEvent;

import org.junit.jupiter.api.*;

import edu.missouri.finalproject.keyboard.Key;
import edu.missouri.finalproject.keyboard.KeyListener;

@DisplayName("Test keyboard.KeyListener")
public class KeyListenerTests
{
	@Test
	@DisplayName("Test KeyListener constructor")
	void testKeyListenerConstructor()
	{
		// Create a new key listener
		KeyListener listener = new KeyListener();
		
		// Loop through all keys
		for (Key key : Key.values())
		{
			// Assert that the key is not pressed
			Assertions.assertEquals(listener.isKeyPressed(key), false);
		}
	}
	
	@Test
	@DisplayName("Test KeyListener press key")
	void testKeyListenerPress()
	{
		// Create a new key listener
		KeyListener listener = new KeyListener();
		
		// Create a dummy Component
		Component component = new Canvas();
		
		// Loop through all keys
		for (Key key : Key.values())
		{
			// Create a new KeyEvent
			KeyEvent event = new KeyEvent(component, 0, 1, 0, key.getBind(), '\0');
			
			// Tell listener it's pressed
			listener.keyPressed(event);
			
			// Assert that the key is pressed
			Assertions.assertEquals(listener.isKeyPressed(key), true);
		}
	}
	
	@Test
	@DisplayName("Test KeyListener press then release key")
	void testKeyListenerPressRelease()
	{
		// Create a new key listener
		KeyListener listener = new KeyListener();
		
		// Create a dummy Component
		Component component = new Canvas();
		
		// Loop through all keys
		for (Key key : Key.values())
		{
			// Create a new KeyEvent
			KeyEvent event = new KeyEvent(component, 0, 1, 0, key.getBind(), '\0');
			
			// Tell listener it's pressed
			listener.keyPressed(event);
			
			// Tell listener it's released
			listener.keyReleased(event);
			
			// Assert that the key is pressed
			Assertions.assertEquals(listener.isKeyPressed(key), false);
		}
	}
}
