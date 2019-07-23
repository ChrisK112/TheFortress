package Game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Menu {
	
	private static int xPoint1 = 1;
	private static int xPoint2 = 1;
	private static int yPoint1 = 1;
	private static int yPoint2 = 1;
	private static int yPoint3 = 1;
	
	 int[] xArrowPoint;
	 int[] yArrowPoint;
	
/*	public Rectangle startButton = new Rectangle(Game.width - 35 , 250, 100, 50);  //250
	public Rectangle highscoresButton = new Rectangle(Game.width - 60, 350, 100, 50);
	public Rectangle quitButton = new Rectangle(Game.width - 60, 450, 100, 50);
*/	
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		
		Font fnt0 = new Font("calibri", Font.PLAIN, 60);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("The Fortress", (Game.width - (Game.width/2) / Game.scale ), (Game.height - (Game.height/2) / Game.scale ) - 100);		
		Font fnt1= new Font("arial", Font.PLAIN, 30);
		g.setFont(fnt1);
		g.drawString("Start", Game.width - 35, 290);
		g.drawString("Highscores", Game.width - 80, 390);
		g.drawString("Exit", Game.width - 30, 490);
		
		
		
		//arrow
		
		xArrowPoint = new int[3] ;
		xArrowPoint[0] = xPoint1;
		xArrowPoint[1] = xPoint1;
		xArrowPoint[2] = xPoint2;
		yArrowPoint = new int[3] ;
		yArrowPoint[0] = yPoint1;
		yArrowPoint[1] = yPoint2;
		yArrowPoint[2] = yPoint3;
		
		g2d.fillPolygon(xArrowPoint, yArrowPoint, 3);

		
	}
	
	//y1, x1 = left top   y2,x1 = left bottom  y3, x2 = right middle
	public static void getCoords(int y1, int y2, int y3, int x1, int x2) {
		yPoint1 = y1;
		yPoint2 = y2;
		yPoint3 = y3;
		xPoint1 = x1;
		xPoint2 = x2;

		
	}
}
