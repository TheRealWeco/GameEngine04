package tk.astris.tiles;

import tk.astris.data.Tile;
import tk.astris.main.Main;

public class Tile_house1_wall1 extends Tile{
	
	public Tile_house1_wall1(){
		img = spritetSheet.getSubimage(0, 96, Main.tileSize, Main.tileSize);
		name = "Tile_house1_wall1";
		id = 93;
	}

}
