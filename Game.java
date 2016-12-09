package com.mycompany.a4;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;

@SuppressWarnings("rawtypes")
public class Game extends Form implements ActionListener, Runnable{
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	private UITimer count = new UITimer(this);
	private BGSound background = new BGSound("background.wav");
	private Button playButton = new Button("Play");
	private Button expandButton = new Button("Expand");
	private Button upButton = new Button("Up");
	private Button contractButton = new Button("Contract");
	private Button downButton = new Button("Down");
	private Button rightButton = new Button("Right");
	private Button movetoAlButton = new Button("MoveToAlien");
	private Button scoreButton = new Button("Score");
	private Button leftButton = new Button("Left");
	private Button moveToAstroButton = new Button("MoveToAstronaut");
	private Button healButton = new Button("Heal");
	
	public Game(){
		 gw = new GameWorld(); // create “Observable” GameWorld		 
		 mv = new MapView(); // create an “Observer” for the map
		 sv = new ScoreView(); // create an “Observer” for the game state data
		 gw.addObserver(mv); // register the map observer
		 gw.addObserver(sv); // register the score observer		 
		 count.schedule(5,true,this);
		 mv.update(gw, "fun");
		 
		 
		 //sets whole screen layout as borderlayout		 
		 this.setLayout(new BorderLayout());
		 Toolbar myToolbar = new Toolbar();
		 this.setToolbar(myToolbar);
		 myToolbar.setTitle("Space Fights Game");		 
		 
		 
		 //create containers and add them to their respective places
		 //TOP CONTAINER *****************************************************************************************************
		 sv.getAllStyles().setPadding(0, 0,100,100);
		 Label topLabel = new Label("Total Score: "+gw.getScore()+" Astronauts Rescued: "+gw.getAstroResc()+" Aliens Sneaked In: "+gw.getAlienResc()+" Astronauts Remaining: "+gw.getAstroRem()+" Aliens Remaining: "+gw.getAlienRem()+" Sound: "+gw.getSound());
		 topLabel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		 sv.add(topLabel);
		 
		//BOTTOM CONTAINER *****************************************************************************************************
		 Container bottomContainer = new Container(new GridLayout(1,3));
		 bottomContainer.getAllStyles().setPadding(0,0,750,700);
		 
		 playButton.getUnselectedStyle().setBgTransparency(255);
		 playButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		 playButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 playButton.getAllStyles().setPadding(5,5,0,0);
		 playPauseCommand myPlayCommand = new playPauseCommand(gw, "poop");
		 playButton.setCommand(myPlayCommand);
		 addKeyListener(' ',myPlayCommand);		
		 
		 healButton.getUnselectedStyle().setBgTransparency(255);
		 healButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		 healButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 healButton.getDisabledStyle().setBgTransparency(255);
		 healButton.getDisabledStyle().setBgColor(ColorUtil.MAGENTA);
		 healButton.getDisabledStyle().setFgColor(ColorUtil.WHITE);
		 HealCommand myHealCommand = new HealCommand(gw);
		 healButton.setCommand(myHealCommand);	 
		 healButton.setEnabled(false);

		 bottomContainer.add(playButton);
		 bottomContainer.add(healButton);
		 
		//LEFT CONTAINER *****************************************************************************************************
		 Container leftContainer = new Container(new GridLayout(4,1));
		 leftContainer.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLACK));
		 leftContainer.getAllStyles().setPadding(200, 500,0,0);		 
		 
		 expandButton.getUnselectedStyle().setBgTransparency(255);
		 expandButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		 expandButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 expandButton.getDisabledStyle().setBgTransparency(255);
		 expandButton.getDisabledStyle().setBgColor(ColorUtil.MAGENTA);
		 expandButton.getDisabledStyle().setFgColor(ColorUtil.WHITE);
		 ExpandCommand myExpandCommand = new ExpandCommand(gw);
		 expandButton.setCommand(myExpandCommand);
		 addKeyListener('e',myExpandCommand);		 
		 
		 upButton.getUnselectedStyle().setBgTransparency(255);
		 upButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		 upButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 upButton.getDisabledStyle().setBgTransparency(255);
		 upButton.getDisabledStyle().setBgColor(ColorUtil.MAGENTA);
		 upButton.getDisabledStyle().setFgColor(ColorUtil.WHITE);
		 SpaceshipMoveUpCommand mySpaceshipMoveUpCommand = new SpaceshipMoveUpCommand(gw);
		 upButton.setCommand(mySpaceshipMoveUpCommand);
		 addKeyListener('u',mySpaceshipMoveUpCommand);
		 
		
		 leftButton.getUnselectedStyle().setBgTransparency(255);
		 leftButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		 leftButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 leftButton.getDisabledStyle().setBgTransparency(255);
		 leftButton.getDisabledStyle().setBgColor(ColorUtil.MAGENTA);
		 leftButton.getDisabledStyle().setFgColor(ColorUtil.WHITE);
		 SpaceshipMoveLeftCommand mySpaceshipMoveLeftCommand = new SpaceshipMoveLeftCommand(gw);
		 leftButton.setCommand(mySpaceshipMoveLeftCommand);
		 addKeyListener('l',mySpaceshipMoveLeftCommand);
		 
		 moveToAstroButton.getUnselectedStyle().setBgTransparency(255);
		 moveToAstroButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		 moveToAstroButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 moveToAstroButton.getDisabledStyle().setBgTransparency(255);
		 moveToAstroButton.getDisabledStyle().setBgColor(ColorUtil.MAGENTA);
		 moveToAstroButton.getDisabledStyle().setFgColor(ColorUtil.WHITE);
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
		 
		 
		 contractButton.getUnselectedStyle().setBgTransparency(255);
		 contractButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		 contractButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 contractButton.getDisabledStyle().setBgTransparency(255);
		 contractButton.getDisabledStyle().setBgColor(ColorUtil.MAGENTA);
		 contractButton.getDisabledStyle().setFgColor(ColorUtil.WHITE);
		 ContractCommand myContractCommand = new ContractCommand(gw);
		 contractButton.setCommand(myContractCommand);
		 addKeyListener('c',myContractCommand);
		 
		 downButton.getUnselectedStyle().setBgTransparency(255);
		 downButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		 downButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 downButton.getDisabledStyle().setBgTransparency(255);
		 downButton.getDisabledStyle().setBgColor(ColorUtil.MAGENTA);
		 downButton.getDisabledStyle().setFgColor(ColorUtil.WHITE);
		 SpaceshipMoveDownCommand mySpaceshipMoveDownCommand = new SpaceshipMoveDownCommand(gw);
		 downButton.setCommand(mySpaceshipMoveDownCommand);
		 addKeyListener('d',mySpaceshipMoveDownCommand);
		 
		 rightButton.getUnselectedStyle().setBgTransparency(255);
		 rightButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		 rightButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 rightButton.getDisabledStyle().setBgTransparency(255);
		 rightButton.getDisabledStyle().setBgColor(ColorUtil.MAGENTA);
		 rightButton.getDisabledStyle().setFgColor(ColorUtil.WHITE);
		 SpaceshipMoveRightCommand mySpaceshipMoveRightCommand = new SpaceshipMoveRightCommand(gw);
		 rightButton.setCommand(mySpaceshipMoveRightCommand);
		 addKeyListener('r',mySpaceshipMoveRightCommand);
		 
		 movetoAlButton.getUnselectedStyle().setBgTransparency(255);
		 movetoAlButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		 movetoAlButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 movetoAlButton.getDisabledStyle().setBgTransparency(255);
		 movetoAlButton.getDisabledStyle().setBgColor(ColorUtil.MAGENTA);
		 movetoAlButton.getDisabledStyle().setFgColor(ColorUtil.WHITE);
		 ToAlienCommand myToAlienCommand = new ToAlienCommand(gw);
		 movetoAlButton.setCommand(myToAlienCommand);
		 addKeyListener('a',myToAlienCommand);
		 
		 scoreButton.getUnselectedStyle().setBgTransparency(255);
		 scoreButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		 scoreButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		 scoreButton.getDisabledStyle().setBgTransparency(255);
		 scoreButton.getDisabledStyle().setBgColor(ColorUtil.MAGENTA);
		 scoreButton.getDisabledStyle().setFgColor(ColorUtil.WHITE);
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
		 
		 //SIDE MENU
		 SoundCommand mySoundCommand = new SoundCommand(gw);
		 AboutCommand myAboutCommand = new AboutCommand();
		 ExitCommand myExitCommand = new ExitCommand(gw);
		 HelpCommand myHelpCommand = new HelpCommand();
		 
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
		 
		 
		 if(gw.getSound()==true)
			 background.play();
		 
		 this.show();
		 gw.setWorldSize(mv.getWidth(),mv.getHeight());
		 gw.init(); // initialize world
		 
	}
	

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		if(gw.getPlayPause()==true){
			gw.tick(); //ticks the game one more frame
			playPauseCommand myPlayCommand = new playPauseCommand(gw, 3);  //these two lines set the button
			playButton.setCommand(myPlayCommand);                           // to say pause
			if(gw.getSound()==true)
				background.play();
			enablePlay();}                         
		else{
			playPauseCommand myPlayCommand = new playPauseCommand(gw, "poop");  //these two lines set the button
			playButton.setCommand(myPlayCommand);                                // to say play
			background.pause();
			disablePause();
		}		
	}
	
	
	public void enablePlay(){
		playButton.setEnabled(true);
		expandButton.setEnabled(true);
		upButton.setEnabled(true);
		contractButton.setEnabled(true);
		downButton.setEnabled(true);
		rightButton.setEnabled(true);
		movetoAlButton.setEnabled(true);
		scoreButton.setEnabled(true);
		leftButton.setEnabled(true);
		moveToAstroButton.setEnabled(true);		
		healButton.setEnabled(false);
	}

	public void disablePause(){		
		expandButton.setEnabled(false);
		upButton.setEnabled(false);
		contractButton.setEnabled(false);
		downButton.setEnabled(false);
		rightButton.setEnabled(false);
		movetoAlButton.setEnabled(false);
		scoreButton.setEnabled(false);
		leftButton.setEnabled(false);
		moveToAstroButton.setEnabled(false);	
		healButton.setEnabled(true);
		
	}
}

