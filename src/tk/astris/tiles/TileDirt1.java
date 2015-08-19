package tk.astris.tiles;

import tk.astris.data.Tile;

public class TileDirt1 extends Tile{
	
	public TileDirt1(){
		img = spritetSheet.getSubimage(0, 0, 64, 64);
		name = "TileDirt1";
		id = 1;
	}

}
