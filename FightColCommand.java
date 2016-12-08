package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class FightColCommand extends Command{
	GameWorld temp;
	
	public FightColCommand(GameWorld g) {
		super("Fight");
		temp=g;
	}

	public void actionPerformed(ActionEvent ev){
		System.out.println("Fight Col command is invoked...");
		temp.fightCol();
	}
}
