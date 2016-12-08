package com.mycompany.a3;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;


public class GameObject {
	private int size; //length of one size of the square that is the object
	private double locationX; //location on the x-axis of the center of the object
	private double locationY; //location on the y-axis of the center of the object.
	private int myColor=ColorUtil.rgb(255, 255, 255);;
	
	//changes the size of the object
	//pre: int variable of the new size
	//post: nothing
	public void setSize(int newSize){
		size=newSize;
	}
	
	//returns the size of the object
	//pre: nothing
	//post: returns variable of type int of the size of the object
	public int getSize(){		
		return size;
	}
	
	//changes the location on the x-axis
	//pre: double variable of the new location (x axis)
	//post: nothing
	public void setLocationX(double newLocation){
		locationX=newLocation;
	}
	
	//returns a variable of type double of the center of the object on the x-axis
	//pre: nothing
	//post: returns variable of type double of the location (x-axis)
	public double getLocationX(){
		double rVal = Math.round(locationX*10.0)/10.0;
		return rVal;
	}
	
	/*
	 * changes the location on the y-axis
	 * pre: double variable of the new location (y-axis)
	 * post: nothing
	 */
	public void setLocationY(double newLocation){
		locationY=newLocation;
	}
	
	/*
	 * returns a variable of type double of the center of the object on the y-axis
	 * pre:
	 * post:
	 */
	public double getLocationY(){
		double rVal = Math.round(locationY*10.0)/10.0;
		return rVal;
	}
	
	public void setColor(int red, int green, int blue){
		myColor=ColorUtil.rgb(red, green, blue);
	}
	
	public int getColor(){
		return myColor;
	}
	
	
	/*
	 * constructor for class GameObject
	 * pre: nothing
	 * post: sets a random two dimensional location (x-axis=0-1024/y-axis=0-767)
	 */
	public GameObject(){
		Random num = new Random();
		setLocationX(num.nextInt(1023)+num.nextFloat());//set's x location to a random number between 0.0-1024.0
		setLocationY(num.nextInt(767)+num.nextFloat());//set's y location to a random number between 0.0-767.0
	}

}
