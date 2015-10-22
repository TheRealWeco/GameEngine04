package tk.astris.data;

import java.util.ArrayList;
import java.util.HashMap;

import tk.astris.tiles.*;

public class TileNames {

	public static Tile tileGrass1 = new TileDirt1();
	public static Tile tileGrass2 = new TileDirt2();
	public static Tile tileEmpty = new TileEmpty();
	public static Tile tile_test_square1 = new Tile_test_square1();
	public static Tile tile_test_square2 = new Tile_test_square2();
	public static Tile tileTree = new TileTree();
	
	public static Tile tileHouse1_door1 = new Tile_house1_door1();
	public static Tile tileHouse1_roof1 = new Tile_house1_roof1();
	public static Tile tileHouse1_roof2 = new Tile_house1_roof2();
	public static Tile tileHouse1_wall1 = new Tile_house1_wall1();
	public static Tile tileHouse1_wall2 = new Tile_house1_wall2();

	public static HashMap<Integer, Tile> tileMap = new HashMap<Integer, Tile>();
	public static ArrayList<Integer> tileIDs = new ArrayList<Integer>(); 

	public static void put(){
		tileMap.put(tileGrass1.id, tileGrass1);
		tileMap.put(tileGrass2.id, tileGrass2);
		tileMap.put(tileEmpty.id, tileEmpty);
		
		tileMap.put(tile_test_square1.id, tile_test_square1);
		tileMap.put(tile_test_square2.id, tile_test_square2);

		tileMap.put(tileTree.id, tileTree);
		
		tileMap.put(tileHouse1_door1.id, tileHouse1_door1);
		tileMap.put(tileHouse1_roof1.id, tileHouse1_roof1);
		tileMap.put(tileHouse1_roof2.id, tileHouse1_roof2);
		tileMap.put(tileHouse1_wall1.id, tileHouse1_wall1);
		tileMap.put(tileHouse1_wall2.id, tileHouse1_wall2);

		
		tileIDs.add(tileGrass1.id);
		tileIDs.add(tileGrass2.id);
		tileIDs.add(tileEmpty.id);
		
		tileIDs.add(tile_test_square1.id);
		tileIDs.add(tile_test_square2.id);
		
		tileIDs.add(tileTree.id);
		
		tileIDs.add(tileHouse1_door1.id);
		tileIDs.add(tileHouse1_roof1.id);
		tileIDs.add(tileHouse1_roof2.id);
		tileIDs.add(tileHouse1_wall1.id);
		tileIDs.add(tileHouse1_wall2.id);
		
		for(int i : tileIDs){
			System.out.println(i);
		}
		
	}
	
}
