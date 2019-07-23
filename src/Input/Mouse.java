package Input;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Game.Game;
import Game.Menu;
import Game.StartGame;
import Highscores.NewScore;


public class Mouse implements MouseListener, MouseMotionListener{
	private static int mouseX = -1;
	private static int mouseY = -1;		

	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}	
	
	public void mousePressed(MouseEvent e) {
		if(Game.state == Game.STATE.MAIN_MENU){
	
			//play button
			if(mouseX >= 565  && mouseX <= 665){
				if(mouseY >= 260 && mouseY <= 290){
					Game.state = Game.STATE.START_GAME;
				}
			}
			
			//Exit button		
			if(mouseX >= 560 && mouseX <= 630){
				if(mouseY >= 460 && mouseY <= 490){
					System.exit(1);
				}
			}
			
			//Highscores button
			if(mouseX >= 510 && mouseX <= 680){
				if(mouseY >= 360 && mouseY <= 400){
					Game.state = Game.STATE.HIGHSCORES;
					NewScore.newPlayer();
					
				}
			}
			
		}
		
		if(Game.state == Game.STATE.START_GAME || Game.state == Game.STATE.HIGHSCORES){
			
			//Back button
			if(mouseX >= (Game.width - 515) && mouseX <= (Game.width - 435)){
				if(mouseY >= (Game.height) + 242 && mouseY <= (Game.height) + 282){
					Game.state = Game.STATE.MAIN_MENU;
				}
			}
			
			//Start button
			if(mouseX >= (Game.width + 445) && mouseX <= (Game.width + 525)){
				if(mouseY >= (Game.height) + 242 && mouseY <= (Game.height) + 282){
					if(Game.state == Game.STATE.START_GAME){
							StartGame.ValidateName();
							Game.state = Game.STATE.GAME;
					}
				}
			}
			//Sprite selection
			if(mouseY >= (Game.height + 80) && mouseY <= (Game.height + 250)){
				if(mouseX >= (Game.width -180) && mouseX <= (Game.width - 235 + StartGame.imageWidth)){
					StartGame.spriteSelected = 1;
				}
				else if(mouseX >= (Game.width + 70) && mouseX <= (Game.width + 15 + StartGame.imageWidth)){
					StartGame.spriteSelected = 2;
				}
			}
			
			//Text Field
			if(mouseX >= (Game.width - 515) && mouseX <= (Game.width - 435)){
				if(mouseY >= (Game.height) + 242 && mouseY <= (Game.height) + 282){
					Game.nameField.setVisible(true);
				}
			}
			//g.fillRoundRect((Game.width - 180), 220, Game.width -200, 40, 20, 20);
		}   
			
		
	}


	public void mouseReleased(MouseEvent e) {
	}
	public void mouseDragged(MouseEvent e) {	
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		if(Game.state == Game.STATE.MAIN_MENU){
			//y1, x1 = left top   y2,x1 = left bottom  y3, x2 = right middle
			Menu.getCoords(1, 1, 1, 1, 1);
			//play button
			if(mouseX >= 565  && mouseX <= 665){
				if(mouseY >= 260 && mouseY <= 290){
					Menu.getCoords(295, 265, 280, 450, 475);  //y1,y2,y3,x1,x2
				}
				
			}
			
			//Exit button		
			if(mouseX >= 560 && mouseX <= 630){
				if(mouseY >= 460 && mouseY <= 490){
					Menu.getCoords(495, 465, 480, 450, 475);
				}
				
			}
			
			//Highscores button
			if(mouseX >= 510 && mouseX <= 680){
				if(mouseY >= 360 && mouseY <= 400){
					Menu.getCoords(395, 365, 380, 450, 475);			
				}
				
			}

			
		}
			
	}
	
}
