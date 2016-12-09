package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SpaceshipMoveRightCommand extends Command{
	GameWorld temp;
		
	public SpaceshipMoveRightCommand(GameWorld gw) {
		super("Right");
		temp=gw;
	}
	
	public void actionPerformed(ActionEvent ev){
		if(temp.getPlayPause()==true)
			temp.spaceshipMoveR();
	}
}
