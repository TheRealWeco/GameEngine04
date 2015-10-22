package tk.astris.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import tk.astris.main.Main;

public class Level {
	
	public String name = "";
	public ArrayList<TileObject> tileObjectList = new ArrayList<TileObject>();
	public HashMap<Integer, ArrayList<TileObject>> placedTileObjs = new HashMap<Integer,  ArrayList<TileObject>>();

	public String imgFile = ".png";
	public int width = 0;
	public int height = 0;
	
	
	
	public void load(String file){
		
		boolean data = false;
		int row = 0;
		
		if(Main.saveGame.length() == 0){
		/*@SuppressWarnings("unused")
		WorldGen w = new WorldGen(Main.saveGame, "spritesheet.png", 50, 50);*/
			
			try {
				Files.copy(getClass().getClassLoader().getResourceAsStream("tk/astris/level/" + file + ".lvl"), Main.saveGame.toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		int c2 = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader(Main.saveGame))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	//System.out.println(line);
		    	
		    	if(line.startsWith("tileset")){
		    		imgFile = StringUtils.substringBetween(line, "/", ".png");
		    		log("imgFile=" + imgFile);
		    	}
		    	
		    	if(line.startsWith("width=")){
		    		width = Integer.parseInt(line.split("=")[1]);
		    		log("width=" + width);
		    	}
		    	
		    	if(line.startsWith("height=")){
		    		height = Integer.parseInt(line.split("=")[1]);
		    		log("height=" + height);
		    	}
		    	
		    	if(data){
		    		
		    		if(row >= height){
		    			data = false;
		    			log("data=false");
		    		}else{
		    		
		    		String[] split = line.split(",");
		    		
		    		for(int i = 0; i < split.length; i++){
		    			int x = i * Main.tileSize;
		    			int y = row * Main.tileSize;
		    			
		    			if(split[i].contains("+")){
		    				String[] split2 = split[i].split("\\+");
		    				
			    			Tile tile = TileNames.tileMap.get(Integer.parseInt(split2[0]));
			    			//log("tileObject_x=" + x + "tileObject_y=" + y + "tileObject_name=" + tile.name);
			    			tileObjectList.add(new TileObject(x, y, tile));
		    				
		    				for(int i4 = 1; i4 < split2.length; i4++){
		    					
			    				 if(placedTileObjs.get(c2) == null){
			    					 ArrayList<TileObject> tl = new ArrayList<TileObject>();
			    					 tl.add(new TileObject(x, y, TileNames.tileMap.get(Integer.parseInt(split2[i4]))));
			    			         placedTileObjs.put(c2, tl);
			    				 }else{
			    					 ArrayList<TileObject> tl = placedTileObjs.get(c2);
			    					 tl.add(new TileObject(x, y, TileNames.tileMap.get(Integer.parseInt(split2[i4]))));
					    			 placedTileObjs.put(c2, tl);
			    				 }
		    					
		    				}
		    				
		    			}else{
		    				
		    			Tile tile = TileNames.tileMap.get(Integer.parseInt(split[i]));
		    			//log("tileObject_x=" + x + "tileObject_y=" + y + "tileObject_name=" + tile.name);
		    			tileObjectList.add(new TileObject(x, y, tile));
		    			
		    			}
		    			c2++;
		    		}
		    		
		    		row++;
		    		
		    		}
		    	}
		    	
		    	if(line.startsWith("data=")){
		    		data = true;
		    		log("data=true");
		    	}
		    			    	
		    	
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		//save(Main.saveGame2, "spritesheet.png", 50, 50);
		
		
		/*try(BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("tk/astris/level/" + file + ".lvl")))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	System.out.println(line);
		    	
		    	if(line.startsWith("tileset")){
		    		imgFile = StringUtils.substringBetween(line, "/", ".png");
		    		log("imgFile=" + imgFile);
		    	}
		    	
		    	if(line.startsWith("width=")){
		    		width = Integer.parseInt(line.split("=")[1]);
		    		log("width=" + width);
		    	}
		    	
		    	if(line.startsWith("height=")){
		    		height = Integer.parseInt(line.split("=")[1]);
		    		log("height=" + height);
		    	}
		    	
		    	if(data){
		    		
		    		if(row >= height){
		    			data = false;
		    			log("data=false");
		    		}else{
		    		
		    		String[] split = line.split(",");
		    		
		    		for(int i = 0; i < split.length; i++){
		    			int x = i * Main.tileSize;
		    			int y = row * Main.tileSize;
		    			
		    			if(split[i].contains("+")){
		    				
		    			}else{
		    				
		    			Tile tile = TileNames.tileMap.get(Integer.parseInt(split[i]));
		    			log("tileObject_x=" + x + "tileObject_y=" + y + "tileObject_name=" + tile.name);
		    			tileObjectList.add(new TileObject(x, y, tile));
		    			
		    			}
		    		}
		    		
		    		row++;
		    		
		    		}
		    	}
		    	
		    	if(line.startsWith("data=")){
		    		data = true;
		    		log("data=true");
		    	}
		    			    	
		    	
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		
		
		
	}
	
	public void save(File loc, String tileset, int width, int height){
		
		try {
			PrintWriter writer = new PrintWriter(loc);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(loc, true)))) {	
		    out.println("tileset=" + "../fileManager/" + tileset + ",32,32,0,0");
		    out.println("width=" + width);
		    out.println("height=" + height);
		    out.println("data=");

		}catch (IOException e) {
			
		}

		int c = 0;
		int c2 = 0;
					
			try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(loc, true)))) {
				String toPrint = "";
				String attr = "";

				for(TileObject tileO : tileObjectList){
					
					if(placedTileObjs.containsKey(c2)){
						for(TileObject tO : placedTileObjs.get(c2)){
							System.out.println("EY: " + tO.tile.name);
							attr = attr + "+" + tO.tile.id;
						}
					}
					
					    toPrint = toPrint + tileO.tile.id + attr + ",";
					    c++;
					    c2++;
					    attr = "";
						if(c == width){
							c = 0;
						    out.println(toPrint);
						    toPrint = "";
					}
					
				}
				
				
			    
			    
			}catch (IOException e) {
				
			}
	}
	
	public void log(String msg){
		System.out.println("[Level." + name + "] " + msg);
	}

}
