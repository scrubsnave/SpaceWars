package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;

public class Game extends Form implements ActionListener{
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	
	public Game(){
		 gw = new GameWorld(); // create “Observable” GameWorld
		 gw.init(); // initialize world
		 mv = new MapView(); // create an “Observer” for the map
		 sv = new ScoreView(); // create an “Observer” for the game state data
		 gw.addObserver(mv); // register the map observer
		 gw.addObserver(sv); // register the score observer
		
		 //sets whole screen layout as borderlayout		 
		 this.setLayout(new BorderLayout());
		 Toolbar myToolbar = new Toolbar();
		 this.setToolbar(myToolbar);
		 myToolbar.setTitle("Space Fights Game");
		 
		 
		
		 
		 
		 
		 
		 
		 
		 
		 //create containers and add them to their respective places
		 //TOP CONTAINER *****************************************************************************************************
		 sv.getAllStyles().setPadding(0, 0,100,100);
		 Label topLabel = new Label("Total Score: "+gw.getScore()+" Astronauts Rescued: "+gw.getAstroResc()+" Aliens Sneaked In: "+gw.getAlienResc()+" Astronauts Remaining: "+gw.getAstroRem()+" Aliens Remaining: "+gw.getAlienRem()+" Sound: "+gw.getSound());
		 topLabel.getUnselectedStyle().setFgColor(ColorUtil.MAGENTA);
		 sv.add(topLabel);
		 
		//BOTTOM CONTAINER *****************************************************************************************************
		 Container bottomContainer = new Container(new GridLayout(1,3));
		 bottomContainer.getAllStyles().setPadding(0,0,700,700);
		 
		 Button newAlienButton = new Button("NewAlien");
		 newAlienButton.getUnselectedStyle().setBgTransparency(255);
		 newAlienButton.getUnselectedStyle().setBgColor(ColorUtil.MAGENTA);
		 newAlienButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 newAlienButton.getAllStyles().setPadding(5,5,0,0);
		 AlienColCommand myAlienColCommand = new AlienColCommand(gw);
		 newAlienButton.setCommand(myAlienColCommand);
		 addKeyListener('w',myAlienColCommand);
		 
		 Button fightButton = new Button("Fight");
		 fightButton.getUnselectedStyle().setBgTransparency(255);
		 fightButton.getUnselectedStyle().setBgColor(ColorUtil.MAGENTA);
		 fightButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 fightButton.getAllStyles().setPadding(5,5,0,0);
		 FightColCommand myFightColCommand = new FightColCommand(gw);
		 fightButton.setCommand(myFightColCommand);
		 addKeyListener('f',myFightColCommand);
		 
		 Button tickButton = new Button("Tick");
		 tickButton.getUnselectedStyle().setBgTransparency(255);
		 tickButton.getUnselectedStyle().setBgColor(ColorUtil.MAGENTA);
		 tickButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 tickButton.getAllStyles().setPadding(5,5,0,0);
		 TickCommand myTickCommand = new TickCommand(gw);
		 tickButton.setCommand(myTickCommand);
		 addKeyListener('t',myTickCommand);
		 
		 bottomContainer.add(newAlienButton);
		 bottomContainer.add(fightButton);
		 bottomContainer.add(tickButton);
		 
		 
		//LEFT CONTAINER *****************************************************************************************************
		 Container leftContainer = new Container(new GridLayout(4,1));
		 leftContainer.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLACK));
		 leftContainer.getAllStyles().setPadding(200, 500,0,0);
		 
		 Button expandButton = new Button("Expand");
		 expandButton.getUnselectedStyle().setBgTransparency(255);
		 expandButton.getUnselectedStyle().setBgColor(ColorUtil.MAGENTA);
		 expandButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 ExpandCommand myExpandCommand = new ExpandCommand(gw);
		 expandButton.setCommand(myExpandCommand);
		 addKeyListener('e',myExpandCommand);
		 
		 Button upButton = new Button("Up");
		 upButton.getUnselectedStyle().setBgTransparency(255);
		 upButton.getUnselectedStyle().setBgColor(ColorUtil.MAGENTA);
		 upButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 SpaceshipMoveUpCommand mySpaceshipMoveUpCommand = new SpaceshipMoveUpCommand(gw);
		 upButton.setCommand(mySpaceshipMoveUpCommand);
		 addKeyListener('u',mySpaceshipMoveUpCommand);
		 
		 Button leftButton = new Button("Left");
		 leftButton.getUnselectedStyle().setBgTransparency(255);
		 leftButton.getUnselectedStyle().setBgColor(ColorUtil.MAGENTA);
		 leftButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 SpaceshipMoveLeftCommand mySpaceshipMoveLeftCommand = new SpaceshipMoveLeftCommand(gw);
		 leftButton.setCommand(mySpaceshipMoveLeftCommand);
		 addKeyListener('l',mySpaceshipMoveLeftCommand);
		 
		 Button moveToAstroButton = new Button("MoveToAstronaut");
		 moveToAstroButton.getUnselectedStyle().setBgTransparency(255);
		 moveToAstroButton.getUnselectedStyle().setBgColor(ColorUtil.MAGENTA);
		 moveToAstroButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 ToAstronautCommand myToAstronautCommand = new ToAstronautCommand(gw);
		 moveToAstroButton.setCommand(myToAstronautCommand);
		 addKeyListener('o',myToAstronautCommand);
		 
		 leftContainer.add(expandButton);
		 leftContainer.add(upButton);
		 leftContainer.add(leftButton);
		 leftContainer.add(moveToAstroButton);
		 
		//RIGHT CONTAINER *****************************************************************************************************
		 Container rightContainer = new Container(new GridLayout(5,1));
		 rightContainer.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLACK));
		 rightContainer.getAllStyles().setPadding(200, 300,0,0);
		 
		 Button contractButton = new Button("Contract");
		 contractButton.getUnselectedStyle().setBgTransparency(255);
		 contractButton.getUnselectedStyle().setBgColor(ColorUtil.MAGENTA);
		 contractButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 ContractCommand myContractCommand = new ContractCommand(gw);
		 contractButton.setCommand(myContractCommand);
		 addKeyListener('c',myContractCommand);
		 
		 Button downButton = new Button("Down");
		 downButton.getUnselectedStyle().setBgTransparency(255);
		 downButton.getUnselectedStyle().setBgColor(ColorUtil.MAGENTA);
		 downButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 SpaceshipMoveDownCommand mySpaceshipMoveDownCommand = new SpaceshipMoveDownCommand(gw);
		 downButton.setCommand(mySpaceshipMoveDownCommand);
		 addKeyListener('d',mySpaceshipMoveDownCommand);
		 
		 Button rightButton = new Button("Right");
		 rightButton.getUnselectedStyle().setBgTransparency(255);
		 rightButton.getUnselectedStyle().setBgColor(ColorUtil.MAGENTA);
		 rightButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 SpaceshipMoveRightCommand mySpaceshipMoveRightCommand = new SpaceshipMoveRightCommand(gw);
		 rightButton.setCommand(mySpaceshipMoveRightCommand);
		 addKeyListener('r',mySpaceshipMoveRightCommand);
		 
		 Button movetoAlButton = new Button("MoveToAlien");
		 movetoAlButton.getUnselectedStyle().setBgTransparency(255);
		 movetoAlButton.getUnselectedStyle().setBgColor(ColorUtil.MAGENTA);
		 movetoAlButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 ToAlienCommand myToAlienCommand = new ToAlienCommand(gw);
		 movetoAlButton.setCommand(myToAlienCommand);
		 addKeyListener('a',myToAlienCommand);
		 
		 Button scoreButton = new Button("Score");
		 scoreButton.getUnselectedStyle().setBgTransparency(255);
		 scoreButton.getUnselectedStyle().setBgColor(ColorUtil.MAGENTA);
		 scoreButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 ScoreCommand myScoreCommand = new ScoreCommand(gw);
		 scoreButton.setCommand(myScoreCommand);
		 addKeyListener('s',myScoreCommand);
		 //side menu(title bar) item
		 
		 rightContainer.add(contractButton);
		 rightContainer.add(downButton);
		 rightContainer.add(rightButton);
		 rightContainer.add(movetoAlButton);
		 rightContainer.add(scoreButton);
		 
		//MIDDLE CONTAINER *****************************************************************************************************
		 mv.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLACK));
		 
		 SoundCommand mySoundCommand = new SoundCommand(gw);
		 AboutCommand myAboutCommand = new AboutCommand();
		 ExitCommand myExitCommand = new ExitCommand(gw);
		 HelpCommand myHelpCommand = new HelpCommand();
		 //SIDE MENU
		 myToolbar.addCommandToSideMenu(myScoreCommand);
		 myToolbar.addCommandToSideMenu(mySoundCommand);
		 myToolbar.addCommandToSideMenu(myAboutCommand);
		 myToolbar.addCommandToSideMenu(myExitCommand);
		 myToolbar.addCommandToRightBar(myHelpCommand);
		 
		 this.add(BorderLayout.NORTH,sv);
		 this.add(BorderLayout.SOUTH,bottomContainer);
		 this.add(BorderLayout.WEST,leftContainer);
		 this.add(BorderLayout.EAST,rightContainer);
		 this.add(BorderLayout.CENTER, mv);
		 
		 this.show();
		 
		 
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

}

