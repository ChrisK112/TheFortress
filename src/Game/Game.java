package Game;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Entity.Player;
import Graphics.Screen;
import Highscores.NewScore;
import Input.Keyboard;
import Input.Mouse;
import Level.Level;
import Level.TileCoordinate;


public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static int width = 600;
	public static int height = width/16*9;  //res is 16*9
	public static int scale = 2;
	public static String title = "The Fortress";
	
	public static JTextField nameField;
	
	private Menu menu;
	private StartGame startgame;
	private Highscores highscores;
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	private Keyboard key;
	private Screen screen;
	private Level level;
	private Player player;
	
	private NewScore newScore;
	
	public static enum STATE{
		MAIN_MENU,
		START_GAME,
		HIGHSCORES,
		QUESTION_TIME,
		GAME
	}
	
	public static STATE state = STATE.MAIN_MENU;
	
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	public Game(){
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		
		newScore = new NewScore(4000, "CppL");

		
		frame = new JFrame();
	
		//text field for name input
		nameField =  new JTextField();
		nameField.setLayout(null);
		nameField.setBounds((width - 150), 220, width - 260, 40); 
		nameField.setBackground(Color.yellow);
		nameField.setBorder(null);
		
		nameField.setVisible(false);
		frame.add(nameField);
		
		menu = new Menu();
		startgame = new StartGame();
		highscores = new Highscores();
		level = Level.readyLevel;
		key = new Keyboard();
		TileCoordinate playerSpawn = new TileCoordinate(3,2);
		player = new Player(playerSpawn.x(), playerSpawn.y(), key);
		player.init(level);
		
		addKeyListener(key);
		
		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		
		
	}
	
	public synchronized void start(){
		running = true;
		thread = new Thread(this, "Game Display");
		thread.start();
	}
	
	public synchronized void stop(){
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;  //FPS
		double delta = 0;
		int frames = 0;
		int updates = 0;
		frame.requestFocus();
		while(running == true){
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while(delta >= 1){
				update();
				updates ++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer  > 1000){
				timer += 1000;
				System.out.println(updates + "ups, " + frames + " fps");
				frame.setTitle(title + "   |   " + updates + "ups, " + frames + " fps");
				frames = 0;
				updates = 0;
			}
		}
	}

	
	
	public void update(){
		if (key.esc) {
			state = STATE.MAIN_MENU;
			key.esc = false;
		}
		if(state == STATE.GAME){
		player.update();
		level.update();
		}
		
		if(state == STATE.GAME || state == STATE.HIGHSCORES || state == STATE.START_GAME){
		key.update();
		}
	
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;			
		}
		screen.clear();
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		if(state == STATE.GAME){
		int xScroll = player.x - screen.width /2;
		int yScroll = player.y - screen.height /2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);		
		}
		else if(state == STATE.MAIN_MENU){
			menu.render(g);
		}
		else if(state == STATE.START_GAME){
			startgame.render(g);
		}
		else if(state == STATE.HIGHSCORES){
			highscores.render(g);
		}
		
		for(int i=0;i<pixels.length;i++){
			pixels[i] = screen.pixels[i];
		}

		g.dispose();
		bs.show();
		
		

	}
	
	
	public static void main(String[] args){
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		

		game.start();
				
	}
	
}
