package com.mycompany.a4;
import java.util.LinkedList;
import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.ui.Graphics;

public class Opponent extends GameObject implements Moving, ICollider{
	
	private double speed;
	private int direction;
	private LinkedList<GameObject> haveCollidedWith = new LinkedList<GameObject>();
	
	public void removeObj(GameObject otherObject){
		while(haveCollidedWith.contains(otherObject))
			haveCollidedWith.removeFirstOccurrence(otherObject);
	}
	
	public void addObj(GameObject otherObject){
		haveCollidedWith.add(otherObject);
	}
	
	public boolean containsObj(GameObject otherObject){
		boolean result = false;
		if (haveCollidedWith.contains(otherObject))
			result = true;
		
		return result;
	}
	
	
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
		
		Random num = new Random();
		int dirVar = 0;//5-num.nextInt(10); //create random number between -5 and 5
			//changes the direction by a factor of +/- 5	
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
	
	public Opponent(){
		Random num = new Random();
		setSize(50+num.nextInt(30));//set's the size of the opponent to a random number between 20-50
		setDirection(num.nextInt(359));//set's the direction to any number between 0-359
		setLocationX(num.nextInt(1023)+num.nextFloat());//set's x location to a random number between 0.0-1024.0
		setLocationY(num.nextInt(767)+num.nextFloat());//set's y location to a random number between 0.0-767.0
	}
	
	
	
	public boolean collidesWith(ICollider otherObject) {
		boolean result = false;
		double thisCenterX = this.getLocationX() + (this.getSize()/2);
		double thisCenterY = this.getLocationY() + (this.getSize()/2);
		
		double otherCenterX = ((GameObject) otherObject).getLocationX() + (((GameObject) otherObject).getSize()/2);
		double otherCenterY = ((GameObject) otherObject).getLocationY() + (((GameObject) otherObject).getSize()/2);
		
		double dx = thisCenterX - otherCenterX;
		double dy = thisCenterY - otherCenterY;
		
		double distBetweenCentersSqr = ((dx*dx) + (dy*dy));
		
		int thisRadius = this.getSize()/2;
		int otherRadius = ((GameObject) otherObject).getSize()/2;
		int radiiSqr = (thisRadius*thisRadius + 2*thisRadius*otherRadius + otherRadius*otherRadius);
		
		if(distBetweenCentersSqr <= radiiSqr) {result = true;}		
		return result;
	}

	public void handleCollision(ICollider otherObject) {System.out.println("This should never happen1");}
	
	public void move(int time) {System.out.println("This should never happen2");}

	String returnType() {System.out.println("This should never happen3");return null;}

	int getPoints() {System.out.println("This should never happen4");return 0;}

	@Override
	void draw(Graphics g, Point p) {System.out.println("SHOULD NEVER GET HEREEEE");}
}
