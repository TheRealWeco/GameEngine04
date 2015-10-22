package tk.astris.tiles;

import tk.astris.data.Tile;
import tk.astris.main.Main;

public class Tile_house1_door1 extends Tile{
	
	public Tile_house1_door1(){
		img = spritetSheet.getSubimage(32, 96, Main.tileSize, Main.tileSize);
		name = "Tile_house1_door1";
		id = 94;
	}

}
