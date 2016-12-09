package com.mycompany.a4;
//CLEANED UP
import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.models.Point;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;

public class MapView extends Container implements Observer{
	private GameWorld temp;
	
	public void update(Observable gw, Object data) {
		temp=((GameWorld) gw);
		this.repaint();		
	}
	
	@Override
	public void paint(Graphics g){		
		super.paint(g);		
		Point p = new Point(getX(),getY());			
		temp.getSpIt().draw(g,p);							//draw spaceship		
		IIterator it = temp.getGOIt();
		while(it.hasNext()){it.getNext().draw(g, p);}		//draw all game objects
	}
	
	public void pointerPressed(int x, int y){
		x = x - getParent().getAbsoluteX();
		y = y - getParent().getAbsoluteY();
		Point pPtrRelPrnt = new Point(x, y);
		Point pCmpRelPrnt = new Point(getX(), getY());
		IIterator it = temp.getGOIt();
		Opponent tempObj;
		
		while(it.hasNext()){
			tempObj=(Opponent) it.getNext();
			if(tempObj.returnType()!="Astronaut"){continue;}
			if(((Astronaut) tempObj).contains(pPtrRelPrnt, pCmpRelPrnt))
				((Astronaut) tempObj).setSelected(true);
			else
				((Astronaut) tempObj).setSelected(false);
		}		
		repaint();}
}
