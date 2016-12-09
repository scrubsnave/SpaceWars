package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ToAlienCommand extends Command{
	GameWorld temp;

	public ToAlienCommand(GameWorld gw) {
		super("MoveToAlien");
		temp=gw;
	}
	
	public void actionPerformed(ActionEvent ev){
		if(temp.getPlayPause()==true)
			temp.toAlien();
	}
}
