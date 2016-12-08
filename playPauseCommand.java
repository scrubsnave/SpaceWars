package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class playPauseCommand extends Command{

	GameWorld temp;
	public playPauseCommand(GameWorld g, String txt) {
		super("Play");
		temp=g;
	}
	
	public playPauseCommand(GameWorld g, int num) {
		super("Pause");
		temp=g;	
	}
	

	public void actionPerformed(ActionEvent ev){
		if(temp.getPlayPause()==true)
			System.out.println("THE GAME IS PAUSED");
		else
			System.out.println("THE GAME IS RESUMED");
		temp.switchPlayPause();
	}
	
}
