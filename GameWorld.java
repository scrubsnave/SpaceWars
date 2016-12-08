package com.mycompany.a4;

import java.util.Observable;
import java.util.Random;
//CLEANED UP
public class GameWorld extends Observable {

	private int startingAliens = 3;
	private int startingAstronauts = 4;
	private int astroResc;//Astronauts Rescued
	private int alienResc;//Aliens Rescued
	private int astroRem;//Astronauts remaining
	private int alienRem;//aliens remaining
	private int score;//total score
	private boolean sound = true;//is sound ON or OFF
	private Spaceship mainChar = Spaceship.getInstance(); //create one instance of our spaceship
	private int worldHeight; //height of game window
	private int worldWidth;  //width of game window
	private GameObjectCollection allAiGameObj = new GameObjectCollection();
	private Sound scoreSound = new Sound("score.wav"); //this will be the sound when we open spaceship doors
	private boolean playPause = true; //sets game to play
	
	
	//initializes some stats
	public void init(){
		setAstroResc(0);  //sets 0 astronauts rescued
		setAlienResc(0);  //sets 0 aliens rescued
		setAstroRem(4);   //sets 4 astronauts remaining
		setAlienRem(3);   //sets 3 aliens remaining
		setScore(0);      //sets our score at 0
		
		
		for(int i =0;i<startingAstronauts;i++){
			allAiGameObj.add(new Astronaut());
		}		
		for(int i=0;i<startingAliens;i++){
			allAiGameObj.add(new Alien());
		}
	}
	
	public Spaceship getSpIt(){return mainChar;}	
	public IIterator getGOIt(){
		IIterator It = allAiGameObj.getIterator();
		return It;
	}
	
	public void switchPlayPause(){
		if (playPause == true){ //if game is play
			playPause = false;} //set game to pause
		else{					//else
			playPause = true;}  //set game to play
	}
	public boolean getPlayPause(){return playPause;} //return whether game is play or pause
	

	public void setAstroResc(int newAstroResc){astroResc=newAstroResc;} //sets new astronaut rescued number
	public int getAstroResc(){return astroResc;} //returns number of astronauts rescued
	
	public void setAlienResc(int newAlienResc){alienResc=newAlienResc;} //sets new alien rescued number
	public int getAlienResc(){return alienResc;} //returns number of aliens rescued
	
	public void setAstroRem(int newAstroRem){astroRem=newAstroRem;} //sets new astronaut remaining number
	public int getAstroRem(){return astroRem;} //returns number of astronauts remaining
	
	public void setAlienRem(int newAlienRem){alienRem=newAlienRem;} //sets number of aliens remaining
	public int getAlienRem(){return alienRem;} //returns number of aliens remaining
	
	public void setScore(int newScore){score=newScore;} //sets new score
	public int getScore(){return score;} //returns current score
	
	public void switchSound(){
		if(sound==true)		//if sound is turned on
			sound = false;  //set sound as off
		else				//else
			sound = true;	//set sound as on
		
		this.setAndNotify();  //set the game as changed
		 //notify observers to check the game and update screen
	}
	public boolean getSound(){return sound;}	//return sound	
	public String getSoundText() {
		if(getSound()==true) 	//if sound is on
			return "ON";		//return string "ON"
		else					//else
			return "OFF";		//return string "OFF"
	}
	
	private void setAndNotify(){
		this.setChanged(); //the game map has changed
		this.notifyObservers();  //let the observers know to change map
		}
	
	public void toMap(){
		//print some map data to console
		System.out.println(mainChar.toString());
		IIterator it = this.getGOIt();
		while(it.hasNext()){
			System.out.println(it.getNext().toString());
		}		
	}
	
	public void toAlien(){
		//randomly teleport spaceship to a alien		
		if(this.getAlienRem()==0){													//if there are 0 aliens on the field
			System.out.println("No aliens remaining to teleport to!");		//print to console that there are 0 aliens left to tp to
			return;															//end method
			}
		
		Random num = new Random();			//create a random number
		int temp=(num.nextInt(this.getAlienRem()));	//randomize between 0 and number of aliens remaining
		IIterator it = this.getGOIt();	
		Opponent tempGameObj = new Alien();
		
		for(int i=0;i<temp;){  //this for loop iterates to the random alien
			while(it.hasNext()){
				tempGameObj= (Opponent) it.getNext();  //if it has next, set next to tempGameObj
				if(tempGameObj.returnType()=="Alien"){i++;}  //if curr game obj is of type alien, iterate i
			}
		}
		
		mainChar.setLocationX(tempGameObj.getLocationX());  //set main char's x location to that of the aliens
		mainChar.setLocationY(tempGameObj.getLocationY());  //set main char's y location to that of the aliens
		
		this.setAndNotify();
	}

	public void toAstronaut(){
		//randomly teleport spaceship to a astronaut		
		if(this.getAstroRem()==0){												//if there are 0 astronauts on the field
			System.out.println("No Astronauts remaining to teleport to!");		//print to console that there are 0 astronauts left to tp to
			return;																//end method
			}
		
		Random num = new Random();					//create a random number
		int temp=(num.nextInt(this.getAstroRem()));	//randomize between 0 and number of astronauts remaining
		IIterator it = this.getGOIt();
		Opponent tempGameObj = new Astronaut();
			
		for(int i=0;i<temp;){  //this for loop iterates to the random astronaut
			while(it.hasNext()){
				tempGameObj=(Opponent) it.getNext();  	//if it has next, set next to tempGameObj
				if(tempGameObj.returnType()=="Astronaut"){i++;}  //if curr game obj is of type Astronaut, iterate i
			}
		}
				
		mainChar.setLocationX(tempGameObj.getLocationX());  //set main char's x location to that of the aliens
		mainChar.setLocationY(tempGameObj.getLocationY());  //set main char's y location to that of the aliens
		
		this.setAndNotify();
}
	
	public void spaceshipMoveR(){		
		mainChar.moveRight(); 	//move the spaceship to the right		
		this.setAndNotify();
	}
	
	public void spaceshipMoveL(){		
		mainChar.moveLeft();		//move spaceship to the left
		this.setAndNotify();
	}
	
	public void spaceshipMoveU(){		
		mainChar.moveUp();			//move the spaceship up
		this.setAndNotify();
	}
	
	public void spaceshipMoveD(){		
		mainChar.moveDown();		//move the spaceship down
		this.setAndNotify();
	}
	
	public void expand(){		
		mainChar.setSize(mainChar.getSize()+10); //increase size of spaceship doors by 10
		this.setAndNotify();		
	}

	public void contract(){
		mainChar.setSize(mainChar.getSize()-10);  //decrease size of spaceship doors by 10
		this.setAndNotify();				
	}
	
	public void tick(){  //one tick of the game clock		
		IIterator it = this.getGOIt();				
		while(it.hasNext()){
			((Opponent) it.getNext()).move();		//move all the game objects
		}	
		
		outOfBounds(); //check to see if any objects are out of bounds
		checkAlienCollisions();  //check to see if any aliens have collided		
		checkAllAstronautHealth(); //check all astro health and remove dead ones
		cleanUpRem();				//set AstroRem and AlienRem to updated figures
		
		this.setAndNotify();		
	}

	public void collect(){  //open doors and collect all game objects below the doors
		
		if(this.getSound()==true)		//if sound is turned on
			scoreSound.play();			//play score sound
		
		double leftFence = mainChar.getLocationX()-(mainChar.getSize()/2);  //left boundary
		double rightFence = mainChar.getLocationX()+(mainChar.getSize()/2);	//right boundary
		double topFence = mainChar.getLocationY()+(mainChar.getSize()/2);	//top boundary
		double bottomFence = mainChar.getLocationY()-(mainChar.getSize()/2);//bottom boundary
		
		IIterator it = this.getGOIt();
		while(it.hasNext()){
			Opponent tempObj = (Opponent) it.getNext();
			if( tempObj.getLocationX()>leftFence && tempObj.getLocationX() < rightFence && tempObj.getLocationY() < topFence && tempObj.getLocationY() > bottomFence){  //if tempObj is within doors
				this.setScore(this.getScore()+tempObj.getPoints());			//add to score whatever the object was worth
				it.remove();												//remove obj from map
				if (tempObj.returnType()=="Astronaut"){						//if obj is astro
					this.setAstroResc(this.getAstroResc()+1);				//add one to astro rec
					this.setAstroRem(this.getAstroRem()-1);					//remove one from astro rem
				}
				else if (tempObj.returnType()=="Alien"){					//if obj is alien
					this.setAlienResc(this.getAlienResc()+1);				//add one to alien resc
					this.setAlienRem(this.getAlienRem()-1);					//remove one from alien rem
				}
			}
		}
		
		this.setAndNotify();		
	}

	public void healAstro() {
		IIterator it = this.getGOIt();
		Opponent tempObj;
		
		while(it.hasNext()){
			tempObj = (Opponent) it.getNext();
			if(tempObj.returnType()=="Astronaut")											//if temp obj is astro
				if(((Astronaut) tempObj).isSelected()){((Astronaut) tempObj).setHealth(5);}	//if astro is selected, set health to 5
		}
	}
	

	public void setWorldSize(int x, int y) {
		this.setWorldHeight(y);
		this.setWorldWidth(x);		
	}

	public void closeProgram(){
		System.exit(0); //ENDS THE PROGRAM
	}
	
	private void setWorldWidth(int x) {worldWidth=x;}
	private int getWorldWidth(){return worldWidth;}

	private void setWorldHeight(int y) {worldHeight=y;}
	private int getWorldHeight(){return worldHeight;}
	
	private void outOfBounds() {
		IIterator it = this.getGOIt();
		while(it.hasNext()){((Opponent) it.getNext()).checkOutOfBounds(this.getWorldWidth(),this.getWorldHeight());} //iterate through game objects and make sure they are all in bounds 
	}
	
	private void checkAlienCollisions(){					//check all aliens to see if they collided with anything
		IIterator mainIt = this.getGOIt();					//main iterator
		while(mainIt.hasNext()){
			Opponent curObj = (Opponent) mainIt.getNext();	//cur object
			if(curObj.returnType()!="Alien"){continue;}	//if this cur obj is NOT an alien, skip to next object
			IIterator secondIt = this.getGOIt();			//second iterator
			while(secondIt.hasNext()){
				Opponent otherObj = (Opponent) secondIt.getNext();	//other object			
				if (curObj.equals(otherObj)){continue;}		//if main object is the same as the other object, skip this other object
				else{
					if (curObj.collidesWith(otherObj)){curObj.handleCollision(otherObj);}	//if curObj and otherObj are in each other space, handle the collision
					else{curObj.removeObj(otherObj);}										//else remove otherObj from curObj collision list
				}//else
			}//end iteration through second list
		}//end iteration through first list
	}//end method

	private void checkAllAstronautHealth() {
		IIterator it = this.getGOIt();
		while(it.hasNext()){
			Opponent tempGameObj = (Opponent) it.getNext();
			if(tempGameObj.returnType()!="Astronaut"){continue;}		//if cur obj is NOT astronaut, continue to next iteration
			else{if(((Astronaut) tempGameObj).getHealth()==0){						//if cur obj's health is 0
				it.remove();														//remove it from game obj list
				this.setAstroRem(this.getAstroRem()-1);}}							//lower astro rem number by one
		}
	}

	private void cleanUpRem() {
		int remAstro = 0;
		int remAlien = 0;
		IIterator it = this.getGOIt();
		while(it.hasNext()){
			Opponent tempObj = (Opponent) it.getNext();
			if(tempObj.returnType()=="Alien"){remAlien++;}
			else if (tempObj.returnType()=="Astronaut"){remAstro++;}
		}
		this.setAlienRem(remAlien);
		this.setAstroRem(remAstro);
	}

}