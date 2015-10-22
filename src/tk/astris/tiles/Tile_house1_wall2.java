package tk.astris.tiles;

import tk.astris.data.Tile;
import tk.astris.main.Main;

public class Tile_house1_wall2 extends Tile{
	
	public Tile_house1_wall2(){
		img = spritetSheet.getSubimage(64, 96, Main.tileSize, Main.tileSize);
		name = "Tile_house1_wall2";
		id = 95;
	}

}
