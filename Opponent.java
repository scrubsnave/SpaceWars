package com.mycompany.a2;
import java.util.Random;

public class Opponent extends GameObject implements Moving{
	private int speed;
	private int direction;
	
	public void setSpeed(int newSpeed){
		speed=newSpeed;
	}
	public int getSpeed(){
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
		double deltaX=Math.cos(this.getDirection()+5-num.nextInt(10))*this.getSpeed();
		double deltaY=Math.sin(this.getDirection()+5-num.nextInt(10))*this.getSpeed();
		this.setLocationX(this.getLocationX()+deltaX);
		this.setLocationY(this.getLocationY()+deltaY);
	}
	
	public Opponent(){
		new GameObject();
		Random num = new Random();
		setSize(20+num.nextInt(30));//set's the size of the opponent to a random number between 20-50
		setDirection(num.nextInt(359));//set's the direction to any number between 0-359
	}
}
