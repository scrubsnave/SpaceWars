package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ScoreCommand extends Command{
	GameWorld temp;
	public ScoreCommand(GameWorld g) {
		super("Score");
		temp=g;
	}
	
	public void actionPerformed(ActionEvent ev){
		if(temp.getPlayPause()==true)
			temp.collect();
	}
}
