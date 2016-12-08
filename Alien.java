package com.mycompany.a2;


import com.codename1.charts.util.ColorUtil;

public class Alien extends Opponent{
	private int speedConst = 1;

	public String toString(){
		String myDesc = "Alien: loc="+this.getLocationX()+","+this.getLocationY()+" color = ["+ColorUtil.red(getColor()) + "," + ColorUtil.green(getColor())+","+ColorUtil.blue(getColor())+"] size="+this.getSize()+" speed="+this.getSpeed()+" dir="+this.getDirection();
	
		return myDesc;
	}
	
	public Alien(){
		new Opponent();
		setSpeed(5*speedConst);
		setColor(255,0,0);
	}
}

