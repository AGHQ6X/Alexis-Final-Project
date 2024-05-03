package edu.missouri.tests.keyboard;

import java.awt.event.KeyEvent;

import org.junit.jupiter.api.*;

import edu.missouri.finalproject.keyboard.Key;

@DisplayName("Test keyboard.Key")
public class KeyTests
{
	@Test
	@DisplayName("Test player 1 key binds")
	void testPlayerOneBinds()
	{
		Assertions.assertEquals(Key.getKey(KeyEvent.VK_W), Key.PLAYER_ONE_UP);
		Assertions.assertEquals(Key.getKey(KeyEvent.VK_A), Key.PLAYER_ONE_LEFT);
		Assertions.assertEquals(Key.getKey(KeyEvent.VK_S), Key.PLAYER_ONE_DOWN);
		Assertions.assertEquals(Key.getKey(KeyEvent.VK_D), Key.PLAYER_ONE_RIGHT);
	}
	
	@Test
	@DisplayName("Test player 2 key binds")
	void testPlayerTwoBinds()
	{
		Assertions.assertEquals(Key.getKey(KeyEvent.VK_I), Key.PLAYER_TWO_UP);
		Assertions.assertEquals(Key.getKey(KeyEvent.VK_J), Key.PLAYER_TWO_LEFT);
		Assertions.assertEquals(Key.getKey(KeyEvent.VK_K), Key.PLAYER_TWO_DOWN);
		Assertions.assertEquals(Key.getKey(KeyEvent.VK_L), Key.PLAYER_TWO_RIGHT);
	}
}
