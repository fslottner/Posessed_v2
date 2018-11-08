package paket;

import java.awt.event.KeyEvent;

public class KeyBindingGamePlay extends KeyBinding {
	
	private Handler handler;
	private Player player;
	
	public KeyBindingGamePlay(Handler handler) {
		this.handler = handler;
		
		System.out.println(handler.object.size());
		
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getID() == ID.Player) {
				// keyEvents for player
				
				this.player = (Player) tempObject;
				System.out.println("player added");
			}
		}
	}

	@Override
	public void keyPressed(int key) {

				switch (key) {
				case KeyEvent.VK_UP:
					player.startMoveUp();
					break;
				case KeyEvent.VK_DOWN:
					player.startMoveDown();
					break;
				case KeyEvent.VK_LEFT:
					player.startMoveLeft();
					System.out.println("left pressed");
					break;
				case KeyEvent.VK_RIGHT:
					player.startMoveRight();
					break;
				case KeyEvent.VK_ESCAPE:
					System.exit(0);
					break;
				case KeyEvent.VK_F:
					player.quickPosessCheck(); 
					System.out.println("F");
					break;
				case KeyEvent.VK_V:
					player.unposess();
					
				}

	}

	@Override
	public void keyReleased(int key) {

		switch (key) {
		case KeyEvent.VK_UP:
			player.stopMoveUp();
			break;
		case KeyEvent.VK_DOWN:
			player.stopMoveDown();
			break;
		case KeyEvent.VK_LEFT:
			player.stopMoveLeft();
			System.out.println("left key released");
			break;
		case KeyEvent.VK_RIGHT:
			player.stopMoveRight();
			break;
		}
		
	}

	@Override
	public void keyTyped(int key) {
		// TODO Auto-generated method stub
		
	}
	

}
