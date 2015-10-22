package tk.astris.player;

import tk.astris.data.Controls;
import tk.astris.main.Main;
import tk.astris.main.keyCheck;

public class Player {
	
	public int camX = 0;
	public int camY = 0;
	public int x = 0;
	public int y = 0;
	public int speed = 5;
	
	public Player(){
		
	}
	
	public void update(){
		
		if(keyCheck.keysCheck(Controls.Player_move_forward)){
			y = y + speed;
			camY = camY + speed;
		}
		if(keyCheck.keysCheck(Controls.Player_move_backward)){
			if(!(-camY > Main.frame.l.height * 32 - Main.frame.height)){
			y = y - speed;
			camY = camY - speed;
			}
		}
		if(keyCheck.keysCheck(Controls.Player_move_left)){
			x = x + speed;
			camX = camX + speed;
		}
		if(keyCheck.keysCheck(Controls.Player_move_right)){
			if(!(-camX > Main.frame.l.width * 32 - Main.frame.width)){
			x = x - speed;
			camX = camX - speed;
			}
		}
				
		if(-camX < 0){
			camX = 0;
		}
		if(-camY < 0){
			camY = 0;
		}
		
		
		
	}
	

}
