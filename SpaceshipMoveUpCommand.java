package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SpaceshipMoveUpCommand extends Command{
	GameWorld temp;
	
	public SpaceshipMoveUpCommand(GameWorld gw) {
		super("Up");
		temp=gw;
	}

	public void actionPerformed(ActionEvent ev){
		if(temp.getPlayPause()==true)
			temp.spaceshipMoveU();
	}
}
