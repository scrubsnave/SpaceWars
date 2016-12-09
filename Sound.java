package com.mycompany.a4;

import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class Sound {
	private Media m;
	public Sound(String filename){
		try{
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/"+filename);			
			m=MediaManager.createMedia(is,  "audio/wav");
		}
		catch(Exception e){e.printStackTrace();}		
	}
	
	public void play(){
		m.setTime(0);;
		m.play();
	}
}
