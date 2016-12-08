package com.mycompany.a1;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class Game extends Form{
	private GameWorld gw;
	
	public Game(){
		gw = new GameWorld();
		gw.init();
		play();
	}
	
	private void play()
	 {		
		
	 Label myLabel=new Label("Enter a Command:");
	 this.addComponent(myLabel);
	 final TextField myTextField=new TextField();
	 this.addComponent(myTextField);
	 this.show();
	 
	 myTextField.addActionListener(new ActionListener(){
		 
		 public void actionPerformed(ActionEvent evt) {

			 String sCommand=myTextField.getText().toString();
			 myTextField.clear();
			 switch (sCommand.charAt(0)) {
			 case 'a':{
			 		gw.toAlien();
			 		break;}
			 case 'o':{
			 		gw.toAstronaut();
			 		break;}
			 case 'r':{
			 		gw.spaceshipMoveR();
			 		break;}
			 case 'l':{
			 		gw.spaceshipMoveL();
			 		break;}
			 case 'u':{
			 		gw.spaceshipMoveU();
			 		break;}
			 case 'd':{
			 		gw.spaceshipMoveD();
			 		break;}
			 case 'e':{
			 		gw.expand();
			 		break;}
			 case 'c':{
			 		gw.contract();
			 		break;}
			 case 't':{
			 		gw.tick();
			 		break;}
			 case 's':{
			 		gw.collect();
			 		break;}
			 case 'w':{
			 		gw.alienCol();
			 		break;}
			 case 'f':{
			 		gw.fightCol();
			 		break;}
			 case 'p':{
			 		gw.scorePrint();
			 		break;}
			 case 'm':{
			 		gw.toMap();
			 		break;}
			 case 'x':{
			 		gw.closeProgram();
			 		break;}
			 case 'y':{
			 		gw.yEnter();
			 		break;}
			 case 'n':{
			 		gw.nEnter();
			 		break;}
			 	default:{
			 		gw.invalidKey();
			 	}
			 	//add code to handle rest of the commands
			 } //switch
	 } //actionPerformed
	 } //new ActionListener()
	 ); //addActionListener
	 } //play 
		 
	}

