package tk.astris.fileManager;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	public BufferedImage getImg(String name){
		try {
			return ImageIO.read(getClass().getResource(name));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
