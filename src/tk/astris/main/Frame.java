package tk.astris.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JLabel;

import tk.astris.data.Level;
import tk.astris.data.TileNames;
import tk.astris.data.TileObject;
import tk.astris.level.Main_city;
import tk.astris.player.Player;

@SuppressWarnings("serial")
public class Frame extends JFrame{
	
	paint zeichnen;
	Player player;
	public Level l = new Main_city(); //TODO: testlvl
	boolean showLvl = true;
	public int width = 64 * 20;
	public int height = 64 * 20;
	
	boolean debug = true;
	
	ArrayList<Rectangle> mouseClicks = new ArrayList<Rectangle>();
	
	public Frame(Player p){
		super("Game");		
		player = p;
		zeichnen = new paint();
		zeichnen.setBounds(0, 0, width, height);
		addKeyListener(new keyCheck());
		add(zeichnen);
		setSize(width, height);
		
		if(!debug){
		setResizable(false);
		}
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.addMouseListener(new MouseAdapter() {
		     @Override
		     public void mousePressed(MouseEvent e) {
		    	 
		    	 if(!l.name.equals("main_city")){
		         if(e.getClickCount() == 1){
		    	 Rectangle r = new Rectangle(e.getX() + player.camX, e.getY() + player.camX - 25, 1, 1); //TODO: possible error
		    	 mouseClicks.add(r);
		    	 for(int i = 0; i < l.tileObjectList.size() - 1; i++){
		    		 TileObject tileO = l.tileObjectList.get(i);
		    		 
			    	 Rectangle r2 = new Rectangle(tileO.x + player.camX, tileO.y + player.camX, Main.tileSize, Main.tileSize);
		    		 
		    		 if(r.intersects(r2)){
		    			 System.out.println(tileO.tile.name);
		    			 
		    			 
		    			 /*if(e.getButton() == e.BUTTON1){
		    			 l.tileObjectList.add(i, new TileObject(tileO.x, tileO.y, TileNames.tile_test_square1));
		    			 }
		    			 if(e.getButton() == e.BUTTON3){
		    			 l.tileObjectList.add(i, new TileObject(tileO.x, tileO.y, TileNames.tile_test_square2));
		    			 }*/
		    			 
		    			 if(e.getButton() == e.BUTTON1){
		    				 if(l.placedTileObjs.get(i) == null){
		    					 ArrayList<TileObject> tl = new ArrayList<TileObject>();
		    					 tl.add(new TileObject(tileO.x, tileO.y, TileNames.tile_test_square1));
		    			         l.placedTileObjs.put(i, tl);
		    				 }else{
		    					 ArrayList<TileObject> tl = l.placedTileObjs.get(i);
		    					 tl.add(new TileObject(tileO.x, tileO.y, TileNames.tile_test_square1));
				    			 l.placedTileObjs.put(i, tl);
		    				 }
		    			 }
		    			 if(e.getButton() == e.BUTTON3){
	    				 if(l.placedTileObjs.get(i) == null){
	    					 ArrayList<TileObject> tl = new ArrayList<TileObject>();
	    					 tl.add(new TileObject(tileO.x, tileO.y, TileNames.tile_test_square2));
	    			         l.placedTileObjs.put(i, tl);
	    				 }else{
	    					 ArrayList<TileObject> tl = l.placedTileObjs.get(i);
	    					 tl.add(new TileObject(tileO.x, tileO.y, TileNames.tile_test_square2));
			    			 l.placedTileObjs.put(i, tl);
	    				 }
		    			 
		    			 }
		    			 
		    			 if(e.getButton() == e.BUTTON2){
		    					l.save(Main.saveGame2, "spritesheet.png", 50, 50);
		    			 }
		    			 
		    			 return;
		    		 }
		    		 
		    		 
		    	 }
		         }		    	 
		         
		    	 }
		         
		     }
		});
		
	}
	
	public void repaintScreen(){
		zeichnen.repaint();
	}
	
	public void update() {
		zeichnen.repaint();
		player.update();
	}

	private class paint extends JLabel{
		@Override
		public void paintComponent(Graphics g2){
			super.paintComponent(g2);
			
			Graphics2D g = (Graphics2D)g2;
						
			
			if(showLvl){
				Rectangle r = new Rectangle(0, 0, width, height);
				
		    	 for(int i = 0; i < l.tileObjectList.size() - 1; i++){
		    		 TileObject tileObj = l.tileObjectList.get(i);
				
				if(r.intersects(new Rectangle(tileObj.x + player.camX, tileObj.y + player.camY, Main.tileSize, Main.tileSize))){
					
				g.drawImage(tileObj.tile.img, tileObj.x + player.camX, tileObj.y + player.camY, null);
				
				
				
				}
				
								
			}
		    	 
			for (Map.Entry<Integer, ArrayList<TileObject>> entry : l.placedTileObjs.entrySet()) {
				
			    //int key = entry.getKey();
			    ArrayList<TileObject> value = entry.getValue();
			    
			    for(TileObject tObj : value){
				g.drawImage(tObj.tile.img, tObj.x + player.camX, tObj.y + player.camY, null);
			    }
			}
			
			
			}
			
			
			if(debug){
			for(Rectangle r : mouseClicks){
				g.draw(r);
			}
			}

			
		}
	}	
}

