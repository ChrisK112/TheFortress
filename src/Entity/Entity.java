package Entity;

import java.util.Random;

import Graphics.Screen;
import Level.Level;

public  class Entity {
	
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update(){
		
	}
	
	public  void render(Screen screen){
		
	}
	
	public void remove(){
		removed = true;      //remove from level
	}
	
	public boolean isRemoved(){
		return removed;
	}
	
	public void init(Level level){
		this.level = level;
	}
	
}
