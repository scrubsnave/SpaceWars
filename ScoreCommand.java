package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ScoreCommand extends Command{
	GameWorld temp;
	public ScoreCommand(GameWorld g) {
		super("Score");
		temp=g;
	}
	
	public void actionPerformed(ActionEvent ev){
		System.out.println("score command is invoked...");
		if(temp.getPlayPause()==true)
			temp.collect();
	}

}
