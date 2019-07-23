package Tile;

import Graphics.Screen;
import Graphics.Sprite;

public class Tile {

	public int x,y;
	public Sprite sprite;
	
	public static Tile grass1 = new GrassTile(Sprite.grass1);
	public static Tile grass2 = new GrassTile2(Sprite.grass2);
	public static Tile ground = new GroundTile(Sprite.ground);
	public static Tile voidTile = new VoidTile(Sprite.voidTile);
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen){
		
	}
	
	public boolean solid(){
		return false;
	}
}

