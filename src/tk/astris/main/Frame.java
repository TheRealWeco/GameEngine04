package tk.astris.main;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JLabel;

import tk.astris.data.Level;
import tk.astris.data.TileObject;
import tk.astris.level.Level1;
import tk.astris.player.Player;

@SuppressWarnings("serial")
public class Frame extends JFrame{
	
	paint zeichnen;
	Player player;
	Level l = new Level1(); //TODO: testlvl
	boolean showLvl = true;
	public int width = 64 * 10;
	public int height = 64 * 5;
	
	public Frame(Player p){
		super("Game");		
		player = p;
		zeichnen = new paint();
		zeichnen.setBounds(0, 0, width, height);
		addKeyListener(new keyCheck());
		add(zeichnen);
		setSize(1024, 1024);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void repaintScreen(){
		zeichnen.repaint();
	}
	
	public void update() {
		
	}

	private class paint extends JLabel{
		@Override
		public void paintComponent(Graphics g2){
			super.paintComponent(g2);
			
			Graphics2D g = (Graphics2D)g2;
			
			if(showLvl){
			for(TileObject tileObj : l.tileObjectList){
				g.drawImage(tileObj.tile.img, tileObj.x + player.camX, tileObj.y + player.camY, null);
			}
			}
			
		}
	}	
}

