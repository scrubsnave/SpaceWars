package com.mycompany.a4;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public final class Spaceship extends Rescuer implements IDrawable{
	
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

	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(getColor());
		int numX = (int) (getLocationX()+pCmpRelPrnt.getX());
		int numY = (int) (getLocationY()+pCmpRelPrnt.getY());
		g.drawRect(numX-(getSize()/2), numY-(getSize()/2), getSize(), getSize());
		
	}
}
