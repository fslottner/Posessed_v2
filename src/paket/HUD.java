package paket;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int HEALTH = 100;
	
	public void tick() {		
		HEALTH = Library.clamp(HEALTH, 0, 100);
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(10, 10, 200, 20);
		g.setColor(Color.green);
		g.fillRect(10, 10, HEALTH * 2, 20);
		g.setColor(Color.white);
		g.drawRect(10, 10, 200, 20);
		
	}

}
