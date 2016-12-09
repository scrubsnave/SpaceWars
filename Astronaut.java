package com.mycompany.a4;

import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Astronaut extends Opponent implements IDrawable, ISelectable{
	private int health;
	private int speedConst = 1;
	private Sound astroColSound = new Sound("astroColSound.wav");
	private boolean isSelected;
	
	public Astronaut(int worldWidth,int worldHeight){
		Random num = new Random();
		setLocationX(num.nextInt(worldWidth)+num.nextFloat());//set's x location to a random number between 0.0-1024.0
		setLocationY(num.nextInt(worldHeight)+num.nextFloat());//set's y location to a random number between 0.0-767.0
		setSize(50+num.nextInt(30));//set's the size of the opponent to a random number between 20-50
		setDirection(num.nextInt(359));//set's the direction to any number between 0-359
		health=5;
		setSpeed(health*speedConst);
		setColor(0,255,0);		
	}
	
	@Override
	public void flagCollision(){antiCollision=3000;}
	
	public String toString(){return "Astronaut: loc="+this.getLocationX()+","+this.getLocationY()+" color = ["+ColorUtil.red(getColor()) + "," + ColorUtil.green(getColor())+","+ColorUtil.blue(getColor())+"] size="+this.getSize()+" speed="+this.getSpeed()+" dir="+this.getDirection()+" health="+this.getHealth()+" flag= "+this.getFlag();}

	public String returnType(){return "Astronaut";}
	
	public int getPoints(){return 5+this.getHealth();}
	
	public int getHealth(){return health;}
	
	public void setHealth(int newHealth){health=newHealth;this.setColor((250-(this.getHealth()*50)),(this.getHealth()*50+5),0);}	

	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(getColor());
		
		int numX = (int) (getLocationX()+pCmpRelPrnt.getX());
		int numY = (int) (getLocationY()+pCmpRelPrnt.getY());
		
		int[] arrX = {numX,numX,numX+getSize()/2};
		int[] arrY = {numY,numY+getSize(),numY};
		
		if(isSelected())
			g.fillPolygon(arrX,arrY,3);
		else
			g.drawPolygon(arrX,arrY,3);		
	}	
	
	public void handleCollision(Alien otherObject, GameObjectCollection allAiGameObj, GameWorld gw) {
		this.setHealth(this.getHealth()-1);
		this.setColor(0,(this.getHealth()*50+5),0);
		this.setSpeed(this.getHealth());
		this.flagCollision();
		if (gw.getSound()==true)
			astroColSound.play();
	}

	public void setSelected(boolean yesNo) {isSelected = yesNo;}

	public boolean isSelected() {return isSelected;}

	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		double px = pPtrRelPrnt.getX();
		double py = pPtrRelPrnt.getY();
		double xLoc = pCmpRelPrnt.getX() + this.getLocationX();
		double yLoc = pCmpRelPrnt.getY() + this.getLocationY();
		
		if ( (px >= xLoc) && (px <= xLoc + this.getSize()) && (py >= yLoc) && (py <= yLoc+this.getSize())) 
			return true;
		else
			return false;
	}
}
