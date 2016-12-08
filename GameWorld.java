package com.mycompany.a1;

import java.util.LinkedList;
import java.util.Random;

public class GameWorld {

	private int astroResc;//Astronauts Rescued
	private int alienResc;//Aliens Rescued
	private int astroRem;//Astronauts remaining
	private int alienRem;//aliens remaining
	private int score;//total score
	private Spaceship vlad;
	private LinkedList<Astronaut> damsel = new LinkedList<Astronaut>();
	private LinkedList<Alien> et = new LinkedList<Alien>();
	private boolean closeProg = false;
	
	public void init(){
		//some housekeeping
		setAstroResc(0);
		setAlienResc(0);
		setAstroRem(4);
		setAlienRem(3);
		setScore(0);
		//the hero is always named vlad
		vlad = new Spaceship();
		//creating damsels in distress
		for(int i =0;i<4;i++)
		damsel.add(new Astronaut());
		//These ET's are the evil kind.
		for(int i=0;i<3;i++){
		et.add(new Alien());
		}
	}
	
	//setter and getter for Astronauts Rescued variable.
	public void setAstroResc(int newAstroResc){
		astroResc=newAstroResc;
	}
	public int getAstroResc(){
		return astroResc;
	}
	
	//setter and getter for Aliens (accidently) Rescued variable.
	public void setAlienResc(int newAlienResc){
		alienResc=newAlienResc;
	}
	public int getAlienResc(){
		return alienResc;
	}
	
	//setter and getter for astronauts remaining variable.
	public void setAstroRem(int newAstroRem){
		astroRem=newAstroRem;
	}
	public int getAstroRem(){
		return astroRem;
	}
	
	
	//setter and getter for aliens remaining variable.
	public void setAlienRem(int newAlienRem){
		alienRem=newAlienRem;
	}
	public int getAlienRem(){
		return alienRem;
	}
	
	
	//setter and getter for your game score.
	public void setScore(int newScore){
		astroResc=score;
	}
	public int getScore(){
		return score;
	}
	
	//done
	public void toMap(){
		closeProg=false;
		
		//lets print some hero stuff
		System.out.println(vlad.toString());
		for(int i=0;i<astroRem;i++){
			Astronaut curAst = damsel.get(i);
			System.out.println(curAst.toString());
		}
		
		for(int i=0;i<alienRem;i++){
			Alien curAl = et.get(i);
			System.out.println(curAl.toString());
		}		
	}
	
	//done
	public void toAlien(){
		closeProg=false;
		if(alienRem==0){
			System.out.println("No aliens remaining to teleport to!");
			return;
		}
		else{
			Random num = new Random();
			int temp=(num.nextInt(alienRem-1));
			Alien curAl=et.get(temp);
			vlad.setLocationX(curAl.getLocationX());
			vlad.setLocationY(curAl.getLocationY());
		}
	}
	
	//done
	public void toAstronaut(){
		closeProg=false;
		Random num = new Random();
		int temp=(num.nextInt(astroRem-1));
		vlad.setLocationX(damsel.get(temp).getLocationX());
		vlad.setLocationY(damsel.get(temp).getLocationY());
	}
	
	//done
	public void spaceshipMoveR(){
		closeProg=false;
		vlad.moveRight();
	}
	
	//done
	public void spaceshipMoveL(){
		closeProg=false;
		vlad.moveLeft();
	}
	
	//done
	public void spaceshipMoveU(){
		closeProg=false;
		vlad.moveUp();
	}
	
	//done
	public void spaceshipMoveD(){
		closeProg=false;
		vlad.moveDown();
	}
	
	public void expand(){
		closeProg=false;
		vlad.setSize(vlad.getSize()+10);
	}
	
	public void contract(){
		vlad.setSize(vlad.getSize()-10);
		closeProg=false;
	}
	
	public void tick(){
		for(int i=0;i<alienRem;i++){
			et.get(i).move();			
		}		
		closeProg=false;
	}
	
	public void collect(){
		double curLocX=vlad.getLocationX();
		double curLocY=vlad.getLocationY();
		for(int i=0;i<astroRem;i++){
			Astronaut curAst = damsel.get(i);
			if(curAst.getLocationX() <= (curLocX+(vlad.getSize()/2)) && curAst.getLocationX() >= (curLocX-(vlad.getSize()/2)))
				if(curAst.getLocationY() <= (curLocY+(vlad.getSize()/2)) && curAst.getLocationY() >= (curLocY-(vlad.getSize()/2))){
					score=score+5+curAst.getHealth();
					damsel.remove(i);
					astroRem--;
					astroResc++;
				}							
		}		
		for(int i=0;i<alienRem;i++){
			Alien curAl = et.get(i);
			if(curAl.getLocationX() <= (curLocX+(vlad.getSize()/2)) && curAl.getLocationX() >= (curLocX-(vlad.getSize()/2)))
				if(curAl.getLocationY() <= (curLocY+(vlad.getSize()/2)) && curAl.getLocationY() >= (curLocY-(vlad.getSize()/2))){
					score=score-10;
					et.remove(i);
					alienRem--;
					alienResc++;
				}	
			}		
		closeProg=false;
	}
	
	//done
	public void alienCol(){
		closeProg=false;
		if (alienRem<2){
			System.out.println("It is not possible for a Alien on Alien collision because there are not enough aliens!");
			return;
		}
		else{
			Random num = new Random();
			int temp = num.nextInt(alienRem-1);
			Alien newAlien = new Alien();
			if(et.get(temp).getLocationX()>974)
				newAlien.setLocationX(et.get(temp).getLocationX()-num.nextInt(50));
			else
				newAlien.setLocationX(et.get(temp).getLocationX()+num.nextInt(50));
			if(et.get(temp).getLocationY()>717)			
				newAlien.setLocationY(et.get(temp).getLocationY()-num.nextInt(50));
			else
				newAlien.setLocationY(et.get(temp).getLocationY()+num.nextInt(50));
			et.add(newAlien);
			alienRem++;
		}
	}
	
	//done
	public void fightCol(){
		closeProg=false;
		if (alienRem==0){
			System.out.println("It is not possible for a Astronaut-Alien collision because there are no aliens!");
			return;
		}
		else{
			Random num = new Random();
			int temp=num.nextInt(astroRem-1);
			damsel.get(temp).setHealth(damsel.get(temp).getHealth()-1);
			damsel.get(temp).setSpeed(damsel.get(temp).getHealth());
			//change color???
		}
	}
	
	//done
	public void scorePrint(){
		closeProg=false;
		System.out.println("Current Score: "+score+" # of Astronauts rescued: "+astroResc+" Number of Aliens on Spaceship: "+alienResc+" Aliens Left: "+alienRem);
	}
	
	public void closeProgram(){
		System.out.println("Would you like to close the program? (y/n)");
		closeProg=true;
	}
	
	public void yEnter(){
		if (closeProg==true)
			System.exit(0);
		else
			invalidKey();
			
	}
	
	public void nEnter(){
		if (closeProg==true)
			closeProg=false;
		else
			invalidKey();
		
	}
	
	public void invalidKey(){
		System.out.println("The key that you entered is unforunately invalid. Please try again! :)");	
	}
}
