package paket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

public abstract class NPC extends Creature {
	
	private boolean useBrain = true;
	
	public NPC(int x, int y, int r, ID id, int speed, Color color, Handler handler) {
		super(x, y, r, id, speed, color, handler);
	}
	
	public void setUseBrainT() {
		useBrain = true;
	}
	
	public void setUseBrainF() {
		useBrain = false;
	}
	
	public void toggleUseBrain() {
		if (useBrain) useBrain = false;
		else useBrain = true;
	}
	
	protected abstract void brain();

	public void tick() {
		
		if (useBrain) brain();
		
		super.tick();

	}

}
