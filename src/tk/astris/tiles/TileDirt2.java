package tk.astris.tiles;

import tk.astris.data.Tile;
import tk.astris.main.Main;

public class TileDirt2 extends Tile{
	
	public TileDirt2(){
		img = spritetSheet.getSubimage(Main.tileSize * 1, 0, Main.tileSize, Main.tileSize);
		name = "TileDirt2";
		id = 0;
		canBeGenerated = true;
	}

}
