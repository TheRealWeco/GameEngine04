package tk.astris.tiles;

import java.awt.image.BufferedImage;

import tk.astris.data.Tile;
import tk.astris.main.Main;

public class TileEmpty extends Tile{
	
	public TileEmpty(){
		img =  new BufferedImage(Main.tileSize, Main.tileSize, BufferedImage.TYPE_INT_RGB);
		name = "TileEmpty";
		id = 999;
	}
	
}
