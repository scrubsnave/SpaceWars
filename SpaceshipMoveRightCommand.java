package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SpaceshipMoveRightCommand extends Command{
	GameWorld temp;
		
	public SpaceshipMoveRightCommand(GameWorld gw) {
		super("Right");
		temp=gw;
	}
	
	public void actionPerformed(ActionEvent ev){
		System.out.println("spaceshipMoveR command is invoked...");
		temp.spaceshipMoveR();
	}

}
