package com.mycompany.a4;


import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Alien extends Opponent implements IDrawable{
	private double speedConst = 1;
	private Sound alienColSound = new Sound("alienColSound.wav");

	public String toString(){
		String myDesc = "Alien: loc="+this.getLocationX()+","+this.getLocationY()+" color = ["+ColorUtil.red(getColor()) + "," + ColorUtil.green(getColor())+","+ColorUtil.blue(getColor())+"] size="+this.getSize()+" speed="+this.getSpeed()+" dir="+this.getDirection();
	
		return myDesc;
	}
	
	public String returnType(){return "Alien";}
	
	public int getPoints(){return -10;}
	
	public Alien(int worldWidth,int worldHeight){
		Random num = new Random();
		setLocationX(num.nextInt(worldWidth)+num.nextFloat());//set's x location to a random number between 0.0-1024.0
		setLocationY(num.nextInt(worldHeight)+num.nextFloat());//set's y location to a random number between 0.0-767.0
		setSize(50+num.nextInt(30));//set's the size of the opponent to a random number between 20-50
		setDirection(num.nextInt(359));//set's the direction to any number between 0-359
		setSpeed(5*speedConst);
		setColor(255,0,0);
	}

	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(getColor());
		int numX = (int) (getLocationX()+pCmpRelPrnt.getX());
		int numY = (int) (getLocationY()+pCmpRelPrnt.getY());
		g.drawArc(numX, numY, 2*getSize(), 2*getSize(),0,360);
		
	}

	public void handleCollision(Alien otherObj, GameObjectCollection allAiGameObj, GameWorld gw) {
		if(this.containsObj(otherObj))
			return;
		else{
			if(allAiGameObj.getSize()>20)
				return;
			Alien newAlien = new Alien(1,1);
			this.addObj((GameObject) otherObj);		
			this.addObj(newAlien);
			otherObj.addObj(this);
			otherObj.addObj(newAlien);			
			newAlien.addObj(otherObj);
			newAlien.addObj(this);
			newAlien.setLocationX(this.getLocationX());
			newAlien.setLocationY(this.getLocationY()+200);
			allAiGameObj.add(newAlien);
			if (gw.getSound()==true)
				alienColSound.play();
		}
		
	}
}
