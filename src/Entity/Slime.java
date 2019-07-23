package Entity;

import Graphics.Screen;
import Graphics.Sprite;

public class Slime extends Mob{

	public Slime(int x, int y){
		this.x = x * 16;
		this.y = y * 16;
		sprite = Sprite.slime_normal;
	}
	
	public void update() {

		
	}

	
	public void render(Screen screen) {
		screen.renderMob(x, y, sprite);
		
	}

}
