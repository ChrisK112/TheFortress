package Tile;

import Graphics.Screen;
import Graphics.Sprite;


public class GroundTile extends Tile{

	public GroundTile(Sprite sprite) {
		super(sprite);

	}
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 5, y << 5, this);
	}

	public boolean solid(){
		return true;
	}


	
}
