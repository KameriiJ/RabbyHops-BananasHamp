package gameObstacles;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.GameScreen;

/**
 * Read image from file(by using bufferedImage) and return an image object.
 * 
 * @author Gunthee Tawewatmongkol
 */
public class Resource {
	
	private BufferedImage img;
	
	public Resource(String filename) {
		String path = String.format("/objects/(%s)%s", GameScreen.theme, filename);
		try {
		    img = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getResourceImage() {
		return img;
	}
}
