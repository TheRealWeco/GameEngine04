package tk.astris.tiles;

import tk.astris.data.Tile;
import tk.astris.main.Main;

public class TileTree extends Tile{
	
	public TileTree(){
		img = spritetSheet.getSubimage(0, 32, Main.tileSize, Main.tileSize);
		name = "TileTree";
		id = 32;
	}

}
