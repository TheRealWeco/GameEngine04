package tk.astris.data;

import java.util.HashMap;

import tk.astris.tiles.*;

public class TileNames {

	public static Tile tileGrass1 = new TileDirt1();
	public static Tile tileGrass2 = new TileDirt2();
	public static Tile tileEmpty = new TileEmpty();
	public static HashMap<Integer, Tile> tileMap = new HashMap<Integer, Tile>();
	
	public static void put(){
		tileMap.put(tileGrass1.id, tileGrass1);
		tileMap.put(tileGrass2.id, tileGrass2);
		tileMap.put(tileEmpty.id, tileEmpty);

	}
	
}
