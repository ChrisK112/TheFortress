package Entity;

import java.awt.Graphics;

import Graphics.Screen;
import Graphics.Sprite;
import Input.Keyboard;

public class Player extends Mob{
	private Keyboard input;
	private static Sprite sprite ;
	public static int xOff;
	public static int yOff;
	private int animation = 0;
	private boolean walking = false;
	public Player(Keyboard input){
		this.input = input;
	}
	
	public Player(int x, int y, Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;

	}
	
	public void update(){
		int xa = 0; int ya = 0;
		if (animation < 7500) animation++;    //prevent from going too big
		else animation = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		xOff =  xa;
		yOff =  ya;
		if(xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
			}
		else{
			walking = false;
		}
	}

	public void render(Screen screen) {
		if(dir == 0) {
			sprite = Sprite.player_still_forward;
			if(walking) {
				if (animation % 30 > 15) {
					sprite = Sprite.player_forward_move1;
				}
				else sprite = Sprite.player_forward_move2;
			}
		}
		if(dir == 1) {
			sprite = Sprite.player_still_right;
			if(walking) {
				if (animation % 30 > 15) {
					sprite = Sprite.player_right_move1;
				}
				else sprite = Sprite.player_right_move2;
			}
		}
		if(dir == 2) {
			sprite = Sprite.player_still_back;
			if(walking) {
				if (animation % 30 > 15) {
					sprite = Sprite.player_back_move1;
				}
				else sprite = Sprite.player_back_move2;
			}
		}
		if(dir == 3) {
			sprite = Sprite.player_still_left;
			if(walking) {
				if (animation % 30 > 15) {
					sprite = Sprite.player_left_move1;
				}
				else sprite = Sprite.player_left_move2;
			}
		}
		screen.renderMob(x- 16, y -16, sprite);
	}


	




}
