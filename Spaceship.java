package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public final class Spaceship extends Rescuer {
	
	private static Spaceship instance = null;
	public String toString(){
		String myDesc = "Spaceship: loc="+this.getLocationX()+","+this.getLocationY()+" color = ["+ColorUtil.red(getColor()) + "," + ColorUtil.green(getColor())+","+ColorUtil.blue(getColor())+"] size="+this.getSize();	
	
		return myDesc;
	}
	
	public void moveLeft(){
		this.setLocationX(getLocationX()-10);
	}
	
	public void moveRight(){
		this.setLocationX(getLocationX()+10);
	}
	
	public void moveUp(){
		this.setLocationY(getLocationY()+10);
	}
	
	public void moveDown(){
		this.setLocationY(getLocationY()-10);
	}
	private Spaceship(){
		setSize(100);
		setColor(0,0,255);
	}
	public static synchronized Spaceship getInstance(){
		if(instance ==null) instance = new Spaceship();
		return instance;
	}
}
