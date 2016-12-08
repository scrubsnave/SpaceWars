package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SpaceshipMoveLeftCommand extends Command{
	GameWorld temp;
	
	public SpaceshipMoveLeftCommand(GameWorld gw) {
		super("Left");
		temp=gw;
	}

	public void actionPerformed(ActionEvent ev){
		System.out.println("spaceshipMoveL command is invoked...");
		temp.spaceshipMoveL();
	}
	
}
