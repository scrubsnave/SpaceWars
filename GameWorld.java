package com.mycompany.a3;

import java.util.Observable;
import java.util.Random;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.layouts.FlowLayout;

public class GameWorld extends Observable {

	private int astroResc;//Astronauts Rescued
	private int alienResc;//Aliens Rescued
	private int astroRem;//Astronauts remaining
	private int alienRem;//aliens remaining
	private int score;//total score
	private boolean sound = true;//is sound ON or OFF
	private Spaceship vlad; //vlad is the hero of this story
	private int gameHeight;
	private int gameWidth;
	private GameObjectCollection damsel1 = new GameObjectCollection();
	private GameObjectCollection et1 = new GameObjectCollection();
	private Sound scoreSound = new Sound("score.wav");
	private boolean playPause = true;
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
	
	public void setMaxMin(int height, int width){
		gameHeight = height;
		gameWidth = width;
	}
	
	public Spaceship getSpIt(){return vlad;}
	
	public IIterator getAlIt(){
		IIterator It = et1.getIterator();
		return It;
	}
	
	public IIterator getAsIt(){
		IIterator It = damsel1.getIterator();
		return It;
	}
	public void setPlayPause(){
		if (playPause == true){
			playPause = false;}
		else{
			playPause = true;}
	}
	
	public boolean getPlayPause(){return playPause;}
	
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
		if(astroRem==0){
			Dialog ab = new Dialog("GAME OVER");
			ab.setLayout(new FlowLayout());
			// span label accepts the text and the UIID for the dialog body
			ab.add(new SpanLabel("Your final score is "+this.getScore(), "DialogBody"));
			int h = Display.getInstance().getDisplayHeight();
			ab.setDisposeWhenPointerOutOfBounds(true);
			ab.show(0, h /9 * 7, 0, 0);
		}
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
		score=newScore;
	}
	public int getScore(){
		return score;
	}
	
	/*
	 ****************************************************************************************************************************** 
	 * setter and getter for SOUND.
	 */
	public void setSound(boolean newSound){
		sound=newSound;	
		
		this.setChanged();
		this.notifyObservers();
	}
	public boolean getSound(){
		return sound;
	}
	
	public String getSoundText() {
		if(getSound()==true)
			return "ON";
		else
			return "OFF";
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
	
	public void healAstro() {
		IIterator it = damsel1.getIterator();
		Astronaut newAstro = new Astronaut();
		
		if (this.getPlayPause()==false){			
			while(it.hasNext()){
				newAstro = (Astronaut) it.getNext();
				if (newAstro.isSelected())
					newAstro.setHealth(5);}				
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
			int temp=(num.nextInt(alienRem));
			IIterator it = et1.getIterator();
			Alien curAl=new Alien();
			for(int i =-1;i<temp;i++){
				if(it.hasNext())
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
		int temp=(num.nextInt(astroRem));
		IIterator it = damsel1.getIterator();
		Astronaut curAs=new Astronaut();
		for(int i =-1;i<temp;i++){
			if(it.hasNext())
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
	public void tick(int num){
		
		IIterator it = et1.getIterator();		
		//move all the aliens
		while(it.hasNext()){
			Alien curAl = (Alien) it.getNext();
			curAl.move(num);
			it.replace(curAl);
		}
		
		//move all the astronauts
		it = damsel1.getIterator();
		while(it.hasNext()){
			Astronaut curAs = (Astronaut) it.getNext();
			curAs.move(num);
			it.replace(curAs);
		}
		
		outOfBounds();
		
		//check all alien collisions
		it = et1.getIterator();
		while(it.hasNext()){
			Alien curObj = (Alien) it.getNext();
			
			//check alien on alien collision
			IIterator it2 = et1.getIterator();
			while(it2.hasNext()){
				Alien otherObj = (Alien) it2.getNext();
				
				if (!curObj.equals(otherObj)){
					if(curObj.collidesWith(otherObj)){
						curObj.handleCollision(otherObj,et1, this);
					}
					else
						curObj.removeObj(otherObj);
				}
			}
			
			//check alien on astronaut collision
			it2 = damsel1.getIterator();
			while(it2.hasNext()){
				Astronaut otherObj = (Astronaut) it2.getNext();
				
				if(curObj.collidesWith(otherObj)){
					otherObj.handleCollision(curObj, this);
				}
				else
					curObj.removeObj(otherObj);
			}
		}
		
		//check astronaut health and remove dead ones
		it = damsel1.getIterator();
		while(it.hasNext()){
			if(((Astronaut) it.getNext()).getHealth()==0)
				it.remove();
		}
		
		
		//update scoreview
		setAstroRem(damsel1.getSize());
		setAlienRem(et1.getSize());
		
		this.setChanged();
		this.notifyObservers();
		
	}
	
	private void outOfBounds() {
		IIterator it = et1.getIterator();
		while(it.hasNext()){
			((Alien) it.getNext()).checkOutOfBounds(1500, 1200);
		}
		
		it = damsel1.getIterator();
		while(it.hasNext()){
			((Astronaut) it.getNext()).checkOutOfBounds(1500, 1200);
		}

	}

	/*
	 ******************************************************************************************************************************
	 *collect tells the spaceship to take all aliens/astronauts in his door space 
	 */
	public void collect(){
		
		double curLocX=vlad.getLocationX();
		double curLocY=vlad.getLocationY();
		
		IIterator it = damsel1.getIterator();		
		for(int i = 0;i<astroRem+10;i++){
			if(it.hasNext()){
				Astronaut curAst = (Astronaut) it.getNext();
				if(curAst.getLocationX() <= (curLocX+(vlad.getSize()/2)) && curAst.getLocationX() >= (curLocX-(vlad.getSize()/2)))
					if(curAst.getLocationY() <= (curLocY+(vlad.getSize()/2)) && curAst.getLocationY() >= (curLocY-(vlad.getSize()/2))){
						setScore(getScore()+5+curAst.getHealth());
						it.remove();
						setAstroRem(getAstroRem()-1);
						setAstroResc(getAstroResc()+1);
					}	
			}
		}
		
		it = et1.getIterator();
		for(int i = 0;i<alienRem+10;i++){
			if(it.hasNext()){
				Alien curAl = (Alien) it.getNext();
				if(curAl.getLocationX() <= (curLocX+(vlad.getSize()/2)) && curAl.getLocationX() >= (curLocX-(vlad.getSize()/2)))
					if(curAl.getLocationY() <= (curLocY+(vlad.getSize()/2)) && curAl.getLocationY() >= (curLocY-(vlad.getSize()/2))){
						setScore(getScore()-10);
						it.remove();
						setAlienRem(getAlienRem()-1);
						setAlienResc(getAlienResc()+1);
					}
				}
		}
		
		if(this.getSound()==true)
			scoreSound.play();
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
				if(it.hasNext())
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
			setAlienRem(getAlienRem()+1);
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
			int temp=num.nextInt(astroRem);
			Astronaut damsel = new Astronaut();
			IIterator it = damsel1.getIterator();
			for(int i =-1;i<temp;i++){
				if(it.hasNext())
					damsel = (Astronaut) it.getNext();}
			
			damsel.setHealth(damsel.getHealth()-1);
			damsel.setColor(0,(damsel.getHealth()*50+5),0);
			damsel.setSpeed(damsel.getHealth());
			if (damsel.getHealth()==0){
				it.remove();
				setAstroRem(getAstroRem()-1);}
			else			
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
