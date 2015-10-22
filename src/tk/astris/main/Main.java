package tk.astris.main;

import java.io.File;

import tk.astris.data.TileNames;
import tk.astris.fileManager.Images;
import tk.astris.player.Player;


public class Main {
	
	public static Frame frame;
	public static Player player;
	public static Images images;
	
	public static int tileSize = 32;
	
	public static File saveGame = new File(System.getProperty("user.home") + "/weco/savegametest.lvl");;//TODO: Add savegame
	public static File saveGame2 = new File(System.getProperty("user.home") + "/weco/savegametest.lvl");;//TODO: Add savegame

	
	private int fps;
	private long timeThen;
	boolean newVersion = true;
	public Main(int frameRate) {
		if (System.getProperty("java.version").startsWith("1.4"))
			newVersion = false;
		if (newVersion) {
			fps = frameRate;
			timeThen = System.nanoTime();
		} else {
			fps = frameRate;
			System.out.println("Old Version Detected: " +
				"Running Old Java Timer Version");
			timeThen = System.currentTimeMillis();
		}
	}
	public void sync() {
		if (newVersion) {
			long gapTo = 1000000000L / fps + timeThen;
			long timeNow = System.nanoTime();
				
			while (gapTo > timeNow) {
				try { Thread.sleep(1);
				} catch (InterruptedException e) {}
				timeNow = System.nanoTime();
			}
			
			timeThen = timeNow;
		} else {
			long gapTo = 1000 / fps + timeThen;
			long timeNow = System.currentTimeMillis();
				
			while (gapTo > timeNow) {
				try { Thread.sleep(1);
				} catch (InterruptedException e) {}
				timeNow = System.currentTimeMillis();
			}
			
			timeThen = timeNow;
		}
	}
	
	
	public static void main(String args[]) {
		
		System.out.println("Savegame: " + saveGame);
		
		images = new Images();
		TileNames.put();
		player = new Player();
		
		frame = new Frame(player);
		frame.setVisible(true);
		
		
		Main timer = new Main(60);
		while (true) {
			frame.update();
			timer.sync();
		}
		
	}
}