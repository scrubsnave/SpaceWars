package com.mycompany.a1;

public class Alien extends Opponent{
	private int speedConst = 1;

	public String toString(){
		String myDesc = "Alien: loc="+this.getLocationX()+","+this.getLocationY()+" color=[255, 0, 0] size="+this.getSize()+" speed="+this.getSpeed()+" dir="+this.getDirection();
	
		return myDesc;
	}
	
	public Alien(){
		new Opponent();
		setSpeed(5*speedConst);
		//colors
	}
}
