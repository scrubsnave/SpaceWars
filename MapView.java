package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.models.Point;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;

public class MapView extends Container implements Observer{
	private GameWorld temp;
	
	public void update(Observable gw, Object data) {
		temp=((GameWorld) gw);		
		((GameWorld) gw).toMap();
		
		this.repaint();
		
	}
	
	@Override
	public void paint(Graphics g){		
		super.paint(g);
		
		Point p = new Point(getX(),getY());		
		//draw new Spaceship
		temp.getSpIt().draw(g,p);
		
		//draw new astronauts
		IIterator it = temp.getAsIt();
		while(it.hasNext()){
			((Astronaut) it.getNext()).draw(g, p);				
		}
		
		//draw new aliens
		it = temp.getAlIt();
		while(it.hasNext()){
			((Alien) it.getNext()).draw(g, p);
		}
		
	}
	
	public void pointerPressed(int x, int y){
		x = x - getParent().getAbsoluteX();
		y = y - getParent().getAbsoluteY();
		Point pPtrRelPrnt = new Point(x, y);
		Point pCmpRelPrnt = new Point(getX(), getY());
		IIterator it = temp.getAsIt();
		Astronaut newAstro = new Astronaut();
		
		for (int i = 0; i < it.getSize() ; i++){
			if(it.hasNext())
				newAstro=(Astronaut) it.getNext();
			if(newAstro.contains(pPtrRelPrnt, pCmpRelPrnt))
				newAstro.setSelected(true);
			else
				newAstro.setSelected(false);
		}
		
		repaint();}
}
