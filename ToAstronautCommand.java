package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ToAstronautCommand extends Command{
	GameWorld temp;

	public ToAstronautCommand(GameWorld gw) {
		super("MoveToAstronaut");
		temp=gw;
	}

	public void actionPerformed(ActionEvent ev){
		if(temp.getPlayPause()==true)
			temp.toAstronaut();
	}
}
