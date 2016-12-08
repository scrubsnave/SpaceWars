package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class HealCommand extends Command{	
	GameWorld temp;
	
	public HealCommand(GameWorld g) {
		super("Heal");
		temp=g;
	}
	
	public void actionPerformed(ActionEvent ev){
		System.out.println("Heal Command was invoked...");
		if(temp.getPlayPause()==false)
			temp.healAstro();
	}
}
