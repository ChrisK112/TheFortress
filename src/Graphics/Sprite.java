package Graphics;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	public static int playerSize = 32;
	public static int slimeSize = 32;
	
	//tiles
	public static Sprite grass1 = new Sprite(32, 1, 0, SpriteSheet.tiles);
	public static Sprite grass2 = new Sprite(32, 1, 1, SpriteSheet.tiles);
	public static Sprite ground = new Sprite(32, 3, 0, SpriteSheet.tiles);
	public static Sprite voidTile = new Sprite(32, 4, 0, SpriteSheet.tiles);
	
	
	//player sprites
	public static Sprite player_still_forward = new Sprite(playerSize, 1, 3, SpriteSheet.characters);
	public static Sprite player_still_back = new Sprite(playerSize, 1, 0, SpriteSheet.characters);
	public static Sprite player_still_right = new Sprite(playerSize, 1, 2, SpriteSheet.characters);
	public static Sprite player_still_left = new Sprite(playerSize, 1, 1, SpriteSheet.characters);
	
	public static Sprite player_forward_move1 = new Sprite(playerSize, 0, 3, SpriteSheet.characters);
	public static Sprite player_forward_move2 = new Sprite(playerSize, 2, 3, SpriteSheet.characters);
	
	public static Sprite player_back_move1 = new Sprite(playerSize, 0, 0, SpriteSheet.characters);
	public static Sprite player_back_move2 = new Sprite(playerSize, 2, 0, SpriteSheet.characters);
	
	public static Sprite player_right_move1 = new Sprite(playerSize, 0, 2, SpriteSheet.characters);
	public static Sprite player_right_move2 = new Sprite(playerSize, 2, 2, SpriteSheet.characters);
	
	public static Sprite player_left_move1 = new Sprite(playerSize, 0, 1, SpriteSheet.characters);
	public static Sprite player_left_move2 = new Sprite(playerSize, 2, 1, SpriteSheet.characters);
	
	//slime sprites
	
	public static Sprite slime_normal = new Sprite(slimeSize, 1, 2, SpriteSheet.tiles);
	public static Sprite slime_hit = new Sprite(slimeSize, 1, 4, SpriteSheet.tiles);
	public static Sprite player_attack = new Sprite(slimeSize, 1, 6, SpriteSheet.tiles);
	public static Sprite player_aggro = new Sprite(slimeSize, 1, 4, SpriteSheet.tiles);
	
	
	
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int colour){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}
	
	private void setColour(int colour) {
		for(int i=0;i<SIZE*SIZE;i++){
			pixels[i] = colour;
		}
		
	}

	private void load(){
		for(int y=0;y<SIZE;y++){
			for(int x=0;x<SIZE;x++){
				pixels[x+y*SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
	
}
