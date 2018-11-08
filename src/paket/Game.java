package paket;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5265788895333134855L;

	public static final int WIDTH = 1000, HEIGHT = WIDTH / 12 * 9;
	
	public static final Point ScreenCenter = (new Point(WIDTH / 2, HEIGHT / 2));

	private Thread thread;
	private boolean running = false;

	private ScreenPosition screenPosition;
	private KeyInput keyInput;
	private KeyBindingGamePlay keyBinding;
	private Handler handler;
	private HUD hud;
		
	private Player player;

	public Game() {
		
		handler = new Handler();
		
		screenPosition = new ScreenPosition(WIDTH / 2, HEIGHT / 2, 220);
		
		hud = new HUD();
		
		keyInput = new KeyInput();
				
		this.addKeyListener(keyInput);

		player = new Player(WIDTH / 2, HEIGHT / 2, 50, ID.Player, 5, 1500, Color.red, handler);
		
		handler.addObject(player);
		handler.addObject(new Human(100, 100, 30, ID.Human, 7, Color.blue, handler));
		handler.addObject(new Human(450, 200, 60, ID.Human, 3, Color.green, handler));
		
		keyBinding = new KeyBindingGamePlay(handler);
		keyInput.setKeyBinding(keyBinding);
		
		screenPosition.setTarget(player);
		
		new Window(WIDTH, HEIGHT, "Posessed", this);
		
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				//System.out.println("player: " + player.getX() + ", " + player.getY());
				//System.out.println("npc: " + handler.object.get(1).getVelX() + ", " + handler.object.get(1).getVelY());
				frames = 0;

			}
		}
		stop();

	}

	private void tick() {
		handler.tick();
		hud.tick();
		screenPosition.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Point sp = new Point((int) screenPosition.getX(), (int) screenPosition.getY());

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
				
		handler.render(sp, g);
		
		hud.render(g);

		g.dispose();
		bs.show();

	}

	public static void main(String args[]) {
		new Game();
	}

}
