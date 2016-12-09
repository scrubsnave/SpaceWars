package com.mycompany.a4;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
//CLEANED UP

public abstract class GameObject {
	private int size; //length of one size of the square that is the object
	private double locationX; //location on the x-axis of the center of the object
	private double locationY; //location on the y-axis of the center of the object.
	private int myColor=ColorUtil.rgb(255, 255, 255);
	
	public void setSize(int newSize){size=newSize;}
	public int getSize(){return size;}
	
	public void setLocationX(double newLocation){locationX=newLocation;}
	public double getLocationX(){return Math.round(locationX*10.0)/10.0;}
	
	public void setLocationY(double newLocation){locationY=newLocation;}
	public double getLocationY(){return Math.round(locationY*10.0)/10.0;}
	
	public void setColor(int red, int green, int blue){myColor=ColorUtil.rgb(red, green, blue);}	
	public int getColor(){return myColor;}
	
	abstract String returnType();
	abstract int getPoints();
	abstract void draw(Graphics g, Point p);
	abstract void handleCollision(Alien otherObj, GameObjectCollection allAiGameObj, GameWorld gw);
	abstract boolean collidesWith(GameObject otherObj);
	abstract void removeObj(GameObject otherObj);
}