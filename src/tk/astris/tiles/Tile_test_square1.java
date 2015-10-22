package tk.astris.tiles;

import tk.astris.data.Tile;
import tk.astris.main.Main;

public class Tile_test_square1 extends Tile{
	
	public Tile_test_square1(){
		img = spritetSheet.getSubimage(64, 0, Main.tileSize, Main.tileSize);
		name = "Tile_test_square1";
		id = 3;
	}

}
