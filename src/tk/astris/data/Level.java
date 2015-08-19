package tk.astris.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

public class Level {
	
	public String name = "";
	public ArrayList<TileObject> tileObjectList = new ArrayList<TileObject>();
	
	
	public String imgFile = ".png";
	public int width = 0;
	public int height = 0;
	public void load(String file){
		
		boolean data = false;
		int row = 0;
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("tk/astris/level/" + file + ".lvl")))) {
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
		    			int x = i * 64;
		    			int y = row * 64;
		    			Tile tile = TileNames.tileMap.get(Integer.parseInt(split[i]));
		    			log("tileObject_x=" + x + "tileObject_y=" + y + "tileObject_name=" + tile.name);
		    			tileObjectList.add(new TileObject(x, y, tile));
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
	}
	
	public void log(String msg){
		System.out.println("[Level." + name + "] " + msg);
	}

}
