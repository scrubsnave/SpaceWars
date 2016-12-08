package com.mycompany.a2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Random;

public class GameWorld extends Observable {

	private int astroResc;//Astronauts Rescued
	private int alienResc;//Aliens Rescued
	private int astroRem;//Astronauts remaining
	private int alienRem;//aliens remaining
	private int score;//total score
	private boolean sound;//is sound ON or OFF
	private Spaceship vlad; //vlad is the hero of this story
	private GameObjectCollection damsel1 = new GameObjectCollection();
	private GameObjectCollection et1 = new GameObjectCollection();
	//private LinkedList<Astronaut> damsel = new LinkedList<Astronaut>(); //LinkedList variable of all the Astronaut (damsels in distress)
	//private LinkedList<Alien> et = new LinkedList<Alien>(); //LinkedList variable of all the aliens (et phone home)
	
	
	/*
	 *****************************************************************************************************************************
	 * initializes some basic housekeeping
	 * pre: 	nothing
	 * post: 	sets Astronaut rescued to 0
	 * 			sets Aliens rescued to 0
	 * 			sets Astronauts remaining to 0
	 * 			sets Aliens remaining to 0
	 * 			sets score to 0
	 * 			constructs the spaceship
	 * 			constructs the LinkedList containing 4 Astronauts
	 * 			constructs the LinkedList containing 3 Aliens
	 */
	public void init(){
		setAstroResc(0);
		setAlienResc(0);
		setAstroRem(4);
		setAlienRem(3);
		setScore(0);
		vlad = Spaceship.getInstance();
		for(int i =0;i<4;i++){
			damsel1.add(new Astronaut());
		}		
		for(int i=0;i<3;i++){
			et1.add(new Alien());
		}
	}
	
	/*
	 ****************************************************************************************************************************** 
	 * setter and getter for Astronauts Rescued variable.
	 */
	public void setAstroResc(int newAstroResc){
		astroResc=newAstroResc;
	}
	public int getAstroResc(){
		return astroResc;
	}
	
	/*
	 ******************************************************************************************************************************
	 * setter and getter for Aliens (accidently) Rescued variable.
	 */
	public void setAlienResc(int newAlienResc){
		alienResc=newAlienResc;
	}
	public int getAlienResc(){
		return alienResc;
	}
	
	/*
	 ****************************************************************************************************************************** 
	 * setter and getter for astronauts remaining variable.
	 */
	public void setAstroRem(int newAstroRem){
		astroRem=newAstroRem;
	}
	public int getAstroRem(){
		return astroRem;
	}
	
	
	/*
	 ****************************************************************************************************************************** 
	 * setter and getter for aliens remaining variable.
	 */
	public void setAlienRem(int newAlienRem){
		alienRem=newAlienRem;
	}
	public int getAlienRem(){
		return alienRem;
	}
	
	/*
	 ****************************************************************************************************************************** 
	 * setter and getter for your game score.
	 */
	public void setScore(int newScore){
		astroResc=score;
	}
	public int getScore(){
		return score;
	}
	
	/*
	 ****************************************************************************************************************************** 
	 * setter and getter for SOUND.
	 */
	public void setSound(){
		if (sound==true) sound=false;
		else sound=true;
		
		this.setChanged();
		this.notifyObservers();
	}
	public String getSound(){
		if (sound==true) return "ON";
		else return "OFF";
	}
	
	/*
	 ****************************************************************************************************************************** 
	 * toMap prints out some info about all the objects in the game giving a map of the world in text form
	 * pre: nothing
	 * post: prints out the info for all created game objects
	 */
	public void toMap(){
			
		//lets print some hero stuff
		System.out.println(vlad.toString());
		IIterator it = damsel1.getIterator();
		while(it.hasNext()){
			System.out.println(it.getNext().toString());
		}
		
		it = et1.getIterator();
		while(it.hasNext()){
			System.out.println(it.getNext().toString());
		}
		
	}
	
	/*
	 ******************************************************************************************************************************
	 * toAlien will teleport the spaceship to a random Alien
	 * pre:nothing
	 * post:spaceships location changes to that of a random alien
	 */
	public void toAlien(){
		
		if(alienRem==0){
			System.out.println("No aliens remaining to teleport to!");
			return;
		}
		else{
			Random num = new Random();
			int temp=(num.nextInt(alienRem-1));
			IIterator it = et1.getIterator();
			Alien curAl=new Alien();
			for(int i =-1;i<temp;i++){
				curAl=(Alien) it.getNext();}			
			vlad.setLocationX(curAl.getLocationX());
			vlad.setLocationY(curAl.getLocationY());
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	/*
	 ******************************************************************************************************************************
	 * toAstronaut will teleport the spaceship to a random Astronaut
	 * pre: nothing
	 * post: spaceship's location changes to that of a random Astronaut
	 */
	public void toAstronaut(){
		
		Random num = new Random();
		int temp=(num.nextInt(astroRem-1));
		IIterator it = damsel1.getIterator();
		Astronaut curAs=new Astronaut();
		for(int i =-1;i<temp;i++){
			curAs=(Astronaut) it.getNext();}
		vlad.setLocationX(curAs.getLocationX());
		vlad.setLocationY(curAs.getLocationY());
		this.setChanged();
		this.notifyObservers();
	}
	
	/*
	 ******************************************************************************************************************************
	 * spaceshipMoveR tells the spaceship to call the function moveRight
	 * pre: nothing
	 * post: moveRight method is called
	 */
	public void spaceshipMoveR(){
		
		vlad.moveRight();
		this.setChanged();
		this.notifyObservers();
	}
	
	/*
	 ****************************************************************************************************************************** 
	 * spaceshipMoveL tells the spaceship to call the function moveLeft
	 * pre: nothing
	 * post: moveLeft method is called
	 */
	public void spaceshipMoveL(){
		
		vlad.moveLeft();
		this.setChanged();
		this.notifyObservers();
	}
	
	/*
	 ******************************************************************************************************************************
	 *SpaceshipMoveU tells the spaceship to call the function moveUp
	 */
	public void spaceshipMoveU(){
		
		vlad.moveUp();
		this.setChanged();
		this.notifyObservers();
	}
	
	/*
	 ******************************************************************************************************************************
	 *SpaceshipMoveD tells the spaceship to call the function moveDown 
	 */
	public void spaceshipMoveD(){
		
		vlad.moveDown();
		this.setChanged();
		this.notifyObservers();
	}
	
	
	/*
	 ******************************************************************************************************************************
	 *expand opens the "doors" (increases the size of the doors) by 10 
	 */
	public void expand(){
		
		vlad.setSize(vlad.getSize()+10);
		this.setChanged();
		this.notifyObservers();
	}
	
	/*
	 ******************************************************************************************************************************
	 *contract closes the "doors" (decreases the size) by 10 
	 */
	public void contract(){
		vlad.setSize(vlad.getSize()-10);
		this.setChanged();
		this.notifyObservers();		
	}
	
	/*
	 ******************************************************************************************************************************
	 *tick is kind of like the game clock moving forward by 1 sec so all aliens move once
	 */
	public void tick(){
		IIterator it = et1.getIterator();
		while(it.hasNext()){
			Alien curAl = (Alien) it.getNext();
			curAl.move();
			it.replace(curAl);
		}		
		this.setChanged();
		this.notifyObservers();
		
	}
	
	/*
	 ******************************************************************************************************************************
	 *collect tells the spaceship to take all aliens/astronauts in his door space 
	 */
	public void collect(){
		double curLocX=vlad.getLocationX();
		double curLocY=vlad.getLocationY();
		IIterator it = damsel1.getIterator();
		while(it.hasNext()){
			Astronaut curAst = (Astronaut) it.getNext();
			if(curAst.getLocationX() <= (curLocX+(vlad.getSize()/2)) && curAst.getLocationX() >= (curLocX-(vlad.getSize()/2)))
				if(curAst.getLocationY() <= (curLocY+(vlad.getSize()/2)) && curAst.getLocationY() >= (curLocY-(vlad.getSize()/2))){
					score=score+5+curAst.getHealth();
					it.remove();
					astroRem--;
					astroResc++;
				}	
		}
		it = et1.getIterator();
		while(it.hasNext()){
			Alien curAl = (Alien) it.getNext();
			if(curAl.getLocationX() <= (curLocX+(vlad.getSize()/2)) && curAl.getLocationX() >= (curLocX-(vlad.getSize()/2)))
				if(curAl.getLocationY() <= (curLocY+(vlad.getSize()/2)) && curAl.getLocationY() >= (curLocY-(vlad.getSize()/2))){
					score=score-10;
					it.remove();
					alienRem--;
					alienResc++;
				}	
			}
		this.setChanged();
		this.notifyObservers();
		
	}
	
	/*
	 ******************************************************************************************************************************
	 *alienCol simulates two random aliens colliding with each other and creating another alien near the collision 
	 */
	public void alienCol(){
		
		if (alienRem<2){
			System.out.println("It is not possible for a Alien on Alien collision because there are not enough aliens!");
			return;
		}
		else{
			Random num = new Random();
			int temp = num.nextInt(alienRem-1);
			IIterator it = et1.getIterator();
			Alien curAl = new Alien();
			
			for(int i =-1;i<temp;i++){
				curAl = (Alien) it.getNext();}
			
			Alien newAlien = new Alien();
			if(curAl.getLocationX()>974)
				newAlien.setLocationX(curAl.getLocationX()-num.nextInt(50));
			else
				newAlien.setLocationX(curAl.getLocationX()+num.nextInt(50));
			if(curAl.getLocationY()>717)			
				newAlien.setLocationY(curAl.getLocationY()-num.nextInt(50));
			else
				newAlien.setLocationY(curAl.getLocationY()+num.nextInt(50));
			et1.add(newAlien);
			alienRem++;
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	/*
	 ******************************************************************************************************************************
	 *fightCol simulates an astronaut and a alien colliding with each other and everything that comes from that.
	 */
	public void fightCol(){
		
		if (alienRem==0){
			System.out.println("It is not possible for a Astronaut-Alien collision because there are no aliens!");
			return;
		}
		else{
			Random num = new Random();
			int temp=num.nextInt(astroRem-1);
			Astronaut damsel = new Astronaut();
			IIterator it = damsel1.getIterator();
			for(int i =-1;i<temp;i++){
				damsel = (Astronaut) it.getNext();}
			
			damsel.setHealth(damsel.getHealth()-1);
			damsel.setColor(0,(damsel.getHealth()*50+5),0);
			damsel.setSpeed(damsel.getHealth());
			
			it.replace(damsel);
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	/*
	 ******************************************************************************************************************************
	 *scorePrint prints out the current score of the game.
	 */
	public void scorePrint(){
		
		System.out.println("Current Score: "+score+" # of Astronauts rescued: "+astroResc+" Number of Aliens on Spaceship: "+alienResc+" Aliens Left: "+alienRem);
	}
	
	/*
	 *closeProgram closes the game.
	 */
	public void closeProgram(){
		System.exit(0);
	}
	
	/*
	 ******************************************************************************************************************************
	 * invalidKey prints an error for when an invalid key is entered into the game.
	 */
	public void invalidKey(){
		System.out.println("The key that you entered is unforunately invalid. Please try again! :)");	
	}
	
}
