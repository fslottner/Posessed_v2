package paket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class ScreenPosition {
	
	GameObject target;
	int maxPCD;
	float x, y, prevX, prevY;

	public ScreenPosition(float x, float y, int maxPCD) {
		this.maxPCD = maxPCD;
		this.x = x;
		this.y = y;
		this.prevX = x;
		this.prevY = y;

	}
	
	public void setTarget(GameObject t) {
		this.target = t;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void tick() {
		if (GetplayerCenterDistance() > maxPCD) {
			x += target.getX() - prevX;
			y += target.getY() - prevY;
		}
		
		prevX = target.getX();
		prevY = target.getY();

	}
	
	private double GetplayerCenterDistance() {
		float dX = target.getX() - x;
		float dY = target.getY() - y;
		double distance = Math.sqrt((dX * dX) + (dY * dY));
		return distance;
		
	}
	
}
