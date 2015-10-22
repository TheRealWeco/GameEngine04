package tk.astris.data;

import java.awt.image.BufferedImage;

import tk.astris.main.Main;

public class Tile {
	
	public BufferedImage spritetSheet = Main.images.getImg("spritesheet.png");
	public BufferedImage img;
	public String name;
	public int id = 0;
	public boolean canBeGenerated = false;
	
	
}
