package Tile;

import Graphics.Screen;
import Graphics.Sprite;


public class VoidTile extends Tile{

	public VoidTile(Sprite sprite) {
		super(sprite);

	}
	public void render(int x, int y, Screen screen){
		screen.renderTile(x, y, this);
	}



	
}
