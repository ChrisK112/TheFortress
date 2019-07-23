package Tile;

import Graphics.Screen;
import Graphics.Sprite;


public class GrassTile2 extends Tile{

	public GrassTile2(Sprite sprite) {
		super(sprite);

	}
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 5, y << 5, this);
	}



	
}
