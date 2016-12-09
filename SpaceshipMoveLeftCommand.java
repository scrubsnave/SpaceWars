package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SpaceshipMoveLeftCommand extends Command{
	GameWorld temp;
	
	public SpaceshipMoveLeftCommand(GameWorld gw) {
		super("Left");
		temp=gw;
	}

	public void actionPerformed(ActionEvent ev){
		if(temp.getPlayPause()==true)
			temp.spaceshipMoveL();
	}	
}
