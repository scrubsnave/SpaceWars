package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ContractCommand extends Command{
	GameWorld temp;

	public ContractCommand(GameWorld gw) {
		super("Contract");
		temp=gw;
	}
	
	public void actionPerformed(ActionEvent ev){
		System.out.println("Contract command is invoked...");
		if(temp.getPlayPause()==true)
			temp.contract();
	}

}
