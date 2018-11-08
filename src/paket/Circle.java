package paket;

import java.awt.geom.Ellipse2D;

public class Circle extends Ellipse2D.Float {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8183330568774600050L;
	private float r;
	
	public Circle(float x, float y, float r) {
		this.x = x;
		this.y = y;
		this.width = 2 * r;
		this.height = 2 * r;
		this.r = r;
		
	}
	
	public float getR() {
		return r;
	}
	
	public boolean intersectsCircle(Circle c) {
		float x = c.x;
		float y = c.y;
		float r = c.r;
						
		double d = Math.sqrt(((this.x - x) * (this.x - x)) + ((this.y - y) * (this.y - y)));
		
		System.out.println(d);
		System.out.println((this.r + r) + "\n");

		if (d <= (this.r + r)) {
			return true;
		} else {
			return false;
		}
	}

}
