package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SoundCommand extends Command{
	GameWorld temp;
	public SoundCommand(GameWorld g) {
		super("Sound");
		temp=g;
	}
	
	public void actionPerformed(ActionEvent ev){
		System.out.println("sound command is invoked...");
		if(temp.getSound()==true)
			temp.setSound(false);
		else
			temp.setSound(true);
	}
}
