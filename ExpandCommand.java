package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ExpandCommand extends Command{
	GameWorld temp;

	public ExpandCommand(GameWorld gw) {
		super("Expand");
		temp=gw;
	}

	public void actionPerformed(ActionEvent ev){
		System.out.println("expand command is invoked...");
		temp.expand();
	}
}
