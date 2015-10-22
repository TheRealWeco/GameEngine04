package tk.astris.tiles;

import tk.astris.data.Tile;
import tk.astris.main.Main;

public class TileDirt1 extends Tile{
	
	public TileDirt1(){
		img = spritetSheet.getSubimage(0, 0, Main.tileSize, Main.tileSize);
		name = "TileDirt1";
		id = 1;
		canBeGenerated = true;
	}

}
