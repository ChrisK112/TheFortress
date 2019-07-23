package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Highscores.DataFile;

public class Highscores extends java.applet.Applet{
	private static String[] namesAr;
	private static int[] scoresAr;
	

	public void render(Graphics g){
		
		Graphics2D g2d = (Graphics2D)g;
		
		Font fnt0 = new Font("calibri", Font.PLAIN, 60);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Name", 120, 50);		
		g.drawString("Score", 700, 50);
		
		
		scoresAr = DataFile.getScores();
		namesAr = DataFile.getNames();
		
		Font fnt1 = new Font("calibri", Font.ROMAN_BASELINE, 40);
		g.setFont(fnt1);
		for(int i = 1; i < 11; i++){
			g.drawString(i + ": " + namesAr[i-1], 90,  100 + (50*(i-1)));
			g.drawString("\t" + scoresAr[i-1],  700,  100 + (50*(i-1)));
			g.fillRect(0, 60 +(50*(i)), 1500, 2);
			
		}
		
		//seperator lines
		g.fillRect(400, -200, 2, 762);
		g.fillRect(0, 60, 1500, 2);
		//back button
		g.fillRoundRect((Game.width - 515), (Game.height) + 242, 80, 40, 20, 20);

		Font fnt2 = new Font("calibri", Font.PLAIN, 25);
		g.setFont(fnt2);
		g.setColor(Color.black);
		g.drawString("Back", (Game.width - 500), (Game.height) + 270);

	
	}
	
}
