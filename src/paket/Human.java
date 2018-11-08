package paket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

public class Human extends NPC {
	
	private Random random = new Random();

	public Human(int x, int y, int r, ID id, int speed, Color color, Handler handler) {
		super(x, y, r, id, speed, color, handler);
		
		
	}

	protected void brain() {
		int rNr = random.nextInt(1000);
		if (rNr == 0) {
			int dir = random.nextInt(8);

			switch (dir) {
			case 0:
				velX = 0;
				velY = 0;
				break;
			case 1:
				velX = 0;
				velY = -speed;
				break;
			case 2:
				velX = speed;
				velY = -speed;
				break;
			case 3:
				velX = speed;
				velY = 0;
				break;
			case 4:
				velX = speed;
				velY = speed;
				break;
			case 5:
				velX = 0;
				velY = speed;
				break;
			case 6:
				velX = -speed;
				velY = speed;
				break;
			case 7:
				velX = -speed;
				velY = 0;
				break;
			case 8:
				velX = -speed;
				velY = -speed;
				break;
				
			}
			
		}
		
	}
	
	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getID() == ID.Human && tempObject != this) {
				GameObjectCircle tempObjectC = (GameObjectCircle) tempObject;
				
				if (getBounds().intersectsCircle(tempObjectC.getBounds())) {
					
					double angle = Math.tan((y - tempObjectC.y) / (x - tempObjectC.x));
					double distanceToMove = ((this.d + tempObjectC.d) / 2) - Library.getDistance(this, tempObjectC);
					
					System.out.println(distanceToMove);
					
					x += Math.cos(angle) * distanceToMove;
					y += Math.sin(angle) * distanceToMove;		
					
					System.out.println("collision");
					
				}
				
				
			}
			
		}
	}
	
	@Override
	public void tick()  {
		collision();
		super.tick();
	}
	
	public void render(Point sc, Graphics g) {
		g.setColor(color);
		g.fillOval((int) (x - (d / 2) + Game.ScreenCenter.x - sc.x), (int) (y - (d / 2) + Game.ScreenCenter.y - sc.y),(int) d,(int) d);
	}

}
