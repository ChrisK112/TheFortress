package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Game.Game;
import Game.Game.STATE;



public class Keyboard implements KeyListener{
	
	private boolean[] keys = new boolean[120];
	public boolean up, down, left, right;
	public boolean esc;
	
	public void update() {
		up = keys[KeyEvent.VK_UP];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		down = keys[KeyEvent.VK_DOWN];
		esc = keys[KeyEvent.VK_ESCAPE];
		}
	

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;

	}


	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}


	public void keyTyped(KeyEvent e) {
		
	}
	

}
