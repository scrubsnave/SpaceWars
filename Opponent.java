package com.mycompany.a4;
import java.util.Random;

public abstract class Opponent extends GameObject implements Moving, ICollider{
	
	private double speed;
	private int direction;
	int antiCollision = 0;
	
	public void flagCollision(){antiCollision=2000;}
	public void unFlagCollision(){antiCollision--;}
	public int getFlag(){return antiCollision;}
	
	public void setSpeed(double d){
		speed=d;
	}
	public double getSpeed(){
		return speed;
	}
	
	public void setDirection(int newDirection){
		direction=newDirection;
	}
	public int getDirection(){
		return direction;
	}
	
	public void move(){
		antiCollision--;
		Random num = new Random();
		int dirVar = 5-num.nextInt(10); //create random number between -5 and 5 and changes the direction by a factor of +/- 5	
		double deltaX=Math.cos(this.getDirection()+dirVar)*(this.getSpeed()); //find the change in location on x axis
		double deltaY=Math.sin(this.getDirection()+dirVar)*(this.getSpeed()); //find the change in location on y axis
		
		double newLocationX = this.getLocationX()+deltaX;
		double newLocationY = this.getLocationY()+deltaY;
		
		this.setLocationX(newLocationX); //set new location as old location plus change in location
		this.setLocationY(newLocationY); //set new location as old location plus change in location				
	}
	
	public void checkOutOfBounds(int gameWidth, int gameHeight) {
		Random num = new Random();		
		if (this.getLocationX() < 0 ){					//if cur obj x location is less than 0
			this.setDirection(90-num.nextInt(180));		//set new direction somewhere in the right side of the y axis
			this.setLocationX(1);}						//set location back in bounds
		else if(this.getLocationX() > gameWidth){		//if cur obj x location is greater than the screen size
			this.setDirection(90+num.nextInt(180));		//set new direction somewhere on the left side of y axis
			this.setLocationX(gameWidth-1);}			//set location back in bounds
		else if(this.getLocationY() < 0){				//if cur obj y location is less than 0
			this.setDirection(180+num.nextInt(180));	//set new direction somewhere below x axis
			this.setLocationY(1);}						//set location back in bounds
		else if(this.getLocationY()> gameHeight){		//if cur obj y location is greater than screen size
			this.setDirection(num.nextInt(180));		//set new direction somewhere above x axis
			this.setLocationY(gameHeight-1);}			//set location back in bounds		
	}
	
	public boolean collidesWith(GameObject otherObject) {
		boolean result = false;
		if(this.getFlag()>0){return false;}
		if(((Opponent) otherObject).getFlag()>0){return false;}
			
		double thisCenterX = this.getLocationX() + (this.getSize()/2);
		double thisCenterY = this.getLocationY() + (this.getSize()/2);
		
		double otherCenterX=otherObject.getLocationX() + otherObject.getSize()/2;
		double otherCenterY=otherObject.getLocationY() + otherObject.getSize()/2;
		
		double dx = thisCenterX - otherCenterX;
		double dy = thisCenterY - otherCenterY;
		
		double distBetweenCentersSqr = ((dx*dx) + (dy*dy));
		
		int thisRadius = this.getSize()/2;
		int otherRadius = ((GameObject) otherObject).getSize()/2;
		int radiiSqr = (thisRadius*thisRadius + 2*thisRadius*otherRadius + otherRadius*otherRadius);
		
		if(distBetweenCentersSqr <= radiiSqr) {
			result=true;
			this.flagCollision();}
		return result;		
	}
}
