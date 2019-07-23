package Entity;

import Graphics.Screen;
import Graphics.Sprite;


public abstract class Mob extends Entity{
	
	protected static Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	public void move(int xa, int ya){
		if(xa > 0) dir = 1;
		if(xa < 0) dir = 3;
		if(ya > 0) dir = 2;
		if(ya < 0) dir = 0;
		if (!collision(xa, ya)){
			x += xa;
			y += ya;
		}
		if (!collision(xa, 0)){
			x += xa;
		}
		if (!collision(0, ya)){
			y += ya;
		}
		
	}
	
	public abstract void update();
	public abstract void render(Screen screen);
	
	
	private boolean collision(int xa, int ya){
		boolean solid = false;
		for(int corner = 0; corner < 4; corner++){
			int xt = ((x + xa) + corner%2 * 22 - 11 ) /32;
			int yt = ((y + ya) + corner/2 * 14 - 1) /32;
			if(level.getTile(xt, yt).solid()) solid = true;
		}
			return solid;
	}
	
	
	
}
