package com.mycompany.a1;

public class Rescuer extends GameObject implements Guider{
	
	
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

	public void jumpToLocation(){
	
	}

}
