package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class Spaceship extends Rescuer {
	
	public String toString(){
		String myDesc = "Spaceship: loc="+this.getLocationX()+","+this.getLocationY()+" color= [0, 255, 0]" + " size="+this.getSize();	
	
		return myDesc;
	}
	
	public Spaceship(){
		setSize(100);
		setColor(ColorUtil.GREEN);
	}
}
