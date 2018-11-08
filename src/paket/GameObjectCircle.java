package paket;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public abstract class GameObjectCircle extends GameObject {
	
	protected float d;

	public GameObjectCircle(int x, int y, int d, ID id) {
		super(x, y, id);
		this.d = d;
	}
	
	public float getR() {
		return d;
	}

	public Circle getBounds() {
		return new Circle(x, y, (d / 2));
	}

}
