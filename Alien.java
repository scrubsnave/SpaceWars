package com.mycompany.a4;


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
	
	public Alien(){
		new Opponent();
		setSpeed(5*speedConst);
		setColor(255,0,0);
	}

	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(getColor());
		int numX = (int) (getLocationX()+pCmpRelPrnt.getX());
		int numY = (int) (getLocationY()+pCmpRelPrnt.getY());
		g.drawArc(numX, numY, 2*getSize(), 2*getSize(),0,360);
		
	}

	public void handleCollision(Alien otherObj, GameObjectCollection et1, GameWorld gw) {
		if(this.containsObj(otherObj))
			return;
		else{
			if(et1.getSize()>20)
				return;
			Alien newAlien = new Alien();
			this.addObj((GameObject) otherObj);		
			this.addObj(newAlien);
			otherObj.addObj(this);
			otherObj.addObj(newAlien);			
			newAlien.addObj(otherObj);
			newAlien.addObj(this);
			newAlien.setLocationX(this.getLocationX());
			newAlien.setLocationY(this.getLocationY()+200);
			et1.add(newAlien);
			if (gw.getSound()==true)
				alienColSound.play();
		}
		
	}

	

	
}
