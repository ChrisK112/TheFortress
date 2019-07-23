package Graphics;

import Entity.Player;
import Tile.Tile;


public class Screen {
	
	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	
	public int xOffset, yOffset;
			

	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width*height];

	}
	
	public void clear(){
		for(int i=0;i<pixels.length;i++){
			pixels[i] = 0;
		}
	}
	

	public void renderTile(int xPixel, int yPixel, Tile tile){
		xPixel -= xOffset;
		yPixel -= yOffset;
		for(int y = 0; y<tile.sprite.SIZE; y++){
			int yAbsolute = yPixel + y;
			for(int x = 0; x<tile.sprite.SIZE; x++){
				int xAbsolute = xPixel + x;
				if(xAbsolute < -tile.sprite.SIZE || xAbsolute >= width || yAbsolute<0 || yAbsolute>= height) break;
				if(xAbsolute < 0) xAbsolute = 0;
				pixels[xAbsolute + yAbsolute * width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
			}
		}
	}
	
	public void renderMob(int xPixel, int yPixel, Sprite sprite){
		xPixel -= xOffset;
		yPixel -= yOffset;
		for(int y = 0; y<Sprite.playerSize; y++){
			int yAbsolute = yPixel + y;
			for(int x = 0; x<Sprite.playerSize; x++){
				int xAbsolute = xPixel + x;
				if(xAbsolute < -Sprite.playerSize || xAbsolute >= width || yAbsolute< 0 || yAbsolute>= height) break;
				if(xAbsolute < 0) xAbsolute = 0;
				int colour = sprite.pixels[x + y * Sprite.playerSize];
				if(colour != 0xff00ff00) pixels[xAbsolute + yAbsolute * width] = colour;
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
}

