package com.mycompany.a2;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;

public class HelpCommand extends Command{

	public HelpCommand() {
		super("?");
	}
	
	public void actionPerformed(ActionEvent ev){
		Dialog ab = new Dialog("About");
		ab.setLayout(new FlowLayout());
		// span label accepts the text and the UIID for the dialog body
		ab.add(new SpanLabel("e = expand the door / c = contract the door / s = open the door and update score / r = move right / l = move left / u = move up / d = move down / o = move spaceship to random astronaut / a = move spaceship to random alien / w = create new alien / f = an alien-astronaut fight occurs / t = clock ticks / x = exit game", "DialogBody"));
		int h = Display.getInstance().getDisplayHeight();
		ab.setDisposeWhenPointerOutOfBounds(true);
		ab.show(0, h /9 * 7, 0, 0);
		
	}
}
