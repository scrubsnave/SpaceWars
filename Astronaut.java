package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class Astronaut extends Opponent{
	private int health;
	private int speedConst = 1;
	
	public String toString(){
		String myDesc = "Astronaut: loc="+this.getLocationX()+","+this.getLocationY()+" color = ["+ColorUtil.red(getColor()) + "," + ColorUtil.green(getColor())+","+ColorUtil.blue(getColor())+"] size="+this.getSize()+" speed="+this.getSpeed()+" dir="+this.getDirection()+" health="+this.getHealth();
		return myDesc;
	}
	
	public int getHealth(){
		return health;
	}
	
	public void setHealth(int newHealth){
		health=newHealth;
	}
	
	
	public Astronaut(){
		new Opponent();
		health=5;
		setSpeed(health*speedConst);
		setColor(0,255,0);
		
	}

}
