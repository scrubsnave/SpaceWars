package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TickCommand extends Command{
	GameWorld temp;

	public TickCommand(GameWorld gw) {
		super("Tick");
		//temp=gw;
	}

	public void actionPerformed(ActionEvent ev){
		//System.out.println("Tick command is invoked...");
		//temp.tick();
	}
	
}
