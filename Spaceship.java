package com.mycompany.a4;

import java.util.Random;

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
	private Spaceship(int worldWidth,int worldHeight){
		Random num = new Random();
		setLocationX(num.nextInt(worldWidth)+num.nextFloat());//set's x location to a random number between 0.0-1024.0
		setLocationY(num.nextInt(worldHeight)+num.nextFloat());//set's y location to a random number between 0.0-767.0
		setSize(100);
		setColor(0,0,255);
	}
	public static synchronized Spaceship getInstance(int worldWidth,int worldHeight){
		if(instance ==null) instance = new Spaceship(worldWidth,worldHeight);
		return instance;
	}

	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(getColor());
		int numX = (int) (getLocationX()+pCmpRelPrnt.getX());
		int numY = (int) (getLocationY()+pCmpRelPrnt.getY());
		g.drawRect(numX-(getSize()/2), numY-(getSize()/2), getSize(), getSize());
		
	}


	@Override
	String returnType() {return "Spaceship";}


	@Override
	int getPoints() {return -1;}


	@Override
	void handleCollision(Alien otherObj, GameObjectCollection allAiGameObj, GameWorld gw) {}


	@Override
	boolean collidesWith(GameObject otherObj) {return false;}


	@Override
	void removeObj(GameObject otherObj) {}
}
