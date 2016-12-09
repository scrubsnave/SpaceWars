package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ExitCommand extends Command{	
	GameWorld temp;
	
	public ExitCommand(GameWorld g) {
		super("Exit");
		temp=g;
	}
	
	public void actionPerformed(ActionEvent ev){
		temp.closeProgram();
	}
}