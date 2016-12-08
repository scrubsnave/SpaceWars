package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ToAlienCommand extends Command{
	GameWorld temp;

	public ToAlienCommand(GameWorld gw) {
		super("MoveToAlien");
		temp=gw;
	}
	
	public void actionPerformed(ActionEvent ev){
		System.out.println("toAlien command is invoked...");
		temp.toAlien();
	}

}
