package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ContractCommand extends Command{
	GameWorld temp;

	public ContractCommand(GameWorld gw) {
		super("Contract");
		temp=gw;
	}
	
	public void actionPerformed(ActionEvent ev){
		if(temp.getPlayPause()==true)
			temp.contract();
	}
}
