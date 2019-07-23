package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class StartGame extends java.applet.Applet{
	
	public static int imageHeight, imageWidth;
	public static int spriteSelected = 1;
	

	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		
		Font fnt0 = new Font("calibri", Font.PLAIN, 60);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Welcome, adventurer!", (Game.width - (Game.width/2) / Game.scale - 120), (Game.height - (Game.height/2) / Game.scale ) - 120);		
		
		Font fnt1= new Font("calibri", Font.PLAIN, 40);
		g.setFont(fnt1);
		g.drawString("Please enter the player name:", (Game.width -230), 200);
		g.drawString("Choose a character:", Game.width -150, 350);
		

		
		//back, start and black text space rectangles
		//textspace
		g.fillRoundRect((Game.width - 180), 220, Game.width -200, 40, 20, 20);
		//back
		g.fillRoundRect((Game.width - 515), (Game.height) + 242, 80, 40, 20 ,20);
		//start
		g.fillRoundRect((Game.width + 445), (Game.height) + 242, 80, 40, 20 ,20);
		
		//rectangle around sprites
		if(spriteSelected == 1){
			g.drawRoundRect(Game.width -180, 420, imageWidth - 55, imageHeight - 30, 20, 20);
		}
		else if(spriteSelected == 2){
			g.drawRoundRect(Game.width + 70, 420, imageWidth - 55, imageHeight - 30, 20, 20);
		}
		else{System.out.println("No sprite selected");}

		
		

			
		//character sprites
		File path = new File("/C://Users/Chris112/workspace/Game2/res/Images/Picture1.png/");
		try {
			BufferedImage image = ImageIO.read(path);
			imageWidth = image.getWidth();
			imageHeight = image.getHeight();
			g.drawImage(image, Game.width -200, 400, null);
			g.drawImage(image, Game.width + 50, 400, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Font fnt2 = new Font("calibri", Font.PLAIN, 25);
		g.setFont(fnt2);
		g.setColor(Color.black);
		g.drawString("Back", (Game.width - 500), (Game.height) + 270);
		g.drawString("Start", (Game.width + 460), (Game.height) + 270);
	

	}

	public static void ValidateName() {
		// TODO Auto-generated method stub
		
	}



}
