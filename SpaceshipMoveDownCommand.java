package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SpaceshipMoveDownCommand extends Command{
	GameWorld temp;

	public SpaceshipMoveDownCommand(GameWorld gw) {
		super("Down");
		temp=gw;
	}
	
	public void actionPerformed(ActionEvent ev){
		System.out.println("spaceshipMoveD command is invoked...");
		temp.spaceshipMoveD();
	}

}
