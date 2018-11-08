package paket;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected float x, y;
	protected ID id;
	protected float velX, velY;
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public void setX(int x) {
		this. x = x;
	}
	
	public void setY(int y) {
		this. y = y;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setID(ID id) {
		this. id = id;
	}
	
	public ID getID() {
		return id;
	}
	
	public void setVelX(int velX) {
		this.velX = velX; 
	}
	
	public void setVelY(int velY) {
		this.velY = velY; 
	}
	
	public float getVelX() {
		return velX; 
	}
	
	public float getVelY() {
		return velY; 
	}
	
	public abstract void tick();
	
	public abstract void render(Point sc, Graphics g);

}
