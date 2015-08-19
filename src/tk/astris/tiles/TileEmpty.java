package tk.astris.tiles;

import java.awt.image.BufferedImage;

import tk.astris.data.Tile;

public class TileEmpty extends Tile{
	
	public TileEmpty(){
		img =  new BufferedImage(64, 64, BufferedImage.TYPE_INT_RGB);
		name = "TileEmpty";
		id = 0;
	}
	
}
