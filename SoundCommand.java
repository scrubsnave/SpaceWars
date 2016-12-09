package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SoundCommand extends Command{
	GameWorld temp;
	
	public SoundCommand(GameWorld g) {
		super("Sound");
		temp=g;
	}
	
	public void actionPerformed(ActionEvent ev){
		temp.switchSound();
	}
}
