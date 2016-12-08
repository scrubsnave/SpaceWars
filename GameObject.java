package com.mycompany.a1;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class GameObject {
	private int size;
	private double locationX;
	private double locationY;
	private int color=0;
	
	public void setColor(int newColor){
		color=newColor;
	}
	
	public int setColor(){
		return color;
	}
	
	public void setSize(int newSize){
		size=newSize;
	}	
	public int getSize(){		
		return size;
	}
	
	public void setLocationX(double newLocation){
		locationX=newLocation;
	}
	public double getLocationX(){
		double rVal = Math.round(locationX*10.0)/10.0;
		return rVal;
	}
	
	public void setLocationY(double newLocation){
		locationY=newLocation;
	}
	public double getLocationY(){
		double rVal = Math.round(locationY*10.0)/10.0;
		return rVal;
	}
	
	
	public GameObject(){
		Random num = new Random();
		setLocationX(num.nextInt(1023)+num.nextFloat());//set's x location to a random number between 0.0-1024.0
		setLocationY(num.nextInt(767)+num.nextFloat());//set's y location to a random number between 0.0-767.0
	}

}
