package Level;


import java.util.ArrayList;
import java.util.List;

import Entity.Entity;
import Graphics.Screen;
import Tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	protected int tilesize = 32;
	
	private List<Entity> entities = new ArrayList<Entity>();
	
	public static Level readyLevel = new ReadyLevel("/Levels/exampleLevel.png");
	
	public Level(int width, int height){
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}
	
	public Level(String path){
		loadLevel(path);
		generateLevel();
	}

	

	protected void loadLevel(String path) {

	}

	protected void generateLevel() {
		for(int y = 0; y < 64; y++){
			for(int x = 0; x < 64; x++){
				getTile(x,y);
			}
		}
		tilesize = 32;
	}
	
	public void add(Entity e){
		entities.add(e);
	}
	 
	public void update(){
		for(int i = 0; i < entities.size(); i++){
			entities.get(i).update();
		}
		
	}
	public void time(){
		
	}
	public void render(int xScroll, int yScroll, Screen screen){
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 5;
		int x1 = (xScroll + screen.width + tilesize) >> 5;
		int y0 = yScroll >> 5;
		int y1 = (yScroll + screen.height + tilesize) >> 5;
		
		for(int y=y0; y<y1;y++){
			for(int x=x0; x<x1;x++){
				getTile(x,y).render(x, y, screen);
			}
		}
		for(int i = 0; i < entities.size(); i++){
			entities.get(i).render(screen);
		}

	}
	//hex values for tiles
	//Grass1=0x00ff00
	//Grass2=0x00a708
	//ground=6d5947
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >=width || y >= height) return Tile.voidTile;
		if(tiles[x+y*width] == 0xff00ff00) return Tile.grass1;
		if(tiles[x+y*width] == 0xff00a708) return Tile.grass2;
		if(tiles[x+y*width] == 0xff6d5947) return Tile.ground;
		return Tile.voidTile;
		
	}
			
}
