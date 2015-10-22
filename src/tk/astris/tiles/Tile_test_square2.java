package tk.astris.tiles;

import tk.astris.data.Tile;
import tk.astris.main.Main;

public class Tile_test_square2 extends Tile{
	
	public Tile_test_square2(){
		img = spritetSheet.getSubimage(64 + 32, 0, Main.tileSize, Main.tileSize);
		name = "Tile_test_square1";
		id = 4;
	}

}
