package Level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entity.Slime;



public class ReadyLevel extends Level{
	
	


	public ReadyLevel(String path) {
		super(path);
		
	}
	
	protected void loadLevel(String path){
		try{
			BufferedImage image = ImageIO.read(ReadyLevel.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			tiles = new int[width*height];
			image.getRGB(0, 0, width, height, tiles, 0, width);
		}
		catch (IOException e){
			System.out.println("Error in loading level!");
		}
		add(new Slime(15,5));

		
		
	}
	protected void generateLevel(){
		
		}

		
	

}
