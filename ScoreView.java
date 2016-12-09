package com.mycompany.a4;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;

public class ScoreView extends Container implements Observer{

	public ScoreView(){
		 new Container(new FlowLayout());
	}
	
	public void update(Observable gw, Object data) {
		Label newLabel = new Label("Total Score: "+((GameWorld) gw).getScore()+" Astronauts Rescued: "+((GameWorld) gw).getAstroResc()+" Aliens Sneaked In: "+((GameWorld) gw).getAlienResc()+" Astronauts Remaining: "+((GameWorld) gw).getAstroRem()+" Aliens Remaining: "+((GameWorld) gw).getAlienRem()+" Sound: "+((GameWorld) gw).getSoundText());
		newLabel.getUnselectedStyle().setFgColor(ColorUtil.MAGENTA);
		this.removeAll();
		this.add(newLabel);		
	}
}
