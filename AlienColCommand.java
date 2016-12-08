package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AlienColCommand extends Command{
	GameWorld temp;
	
	public AlienColCommand(GameWorld g) {
		super("NewAlien");
		temp=g;
	}

	public void actionPerformed(ActionEvent ev){
		System.out.println("Alien Col command is invoked...");
		temp.alienCol();
	}
}
