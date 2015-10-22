package tk.astris.tiles;

import tk.astris.data.Tile;
import tk.astris.main.Main;

public class Tile_house1_roof1 extends Tile{
	
	public Tile_house1_roof1(){
		img = spritetSheet.getSubimage(96, 96, Main.tileSize, Main.tileSize);
		name = "Tile_house1_roof1";
		id = 96;
	}

}
