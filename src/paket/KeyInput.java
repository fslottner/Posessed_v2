package paket;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private KeyBinding keyBinding;

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		keyBinding.keyPressed(key);

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		keyBinding.keyReleased(key);
		
	}
	
	public void setKeyBinding(KeyBinding keyBinding) {
		this.keyBinding = keyBinding;
	}

}
