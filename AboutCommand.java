package com.mycompany.a3;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.FlowLayout;

public class AboutCommand extends Command{

	public AboutCommand() {
		super("About");
	}
	
	public void actionPerformed(ActionEvent ev){
		Dialog ab = new Dialog("About");
		ab.setLayout(new FlowLayout());
		// span label accepts the text and the UIID for the dialog body
		ab.add(new SpanLabel("Name: Richard Evans / Course Name: CSc 133 / Version: 0.0.0.0.0.2", "DialogBody"));
		int h = Display.getInstance().getDisplayHeight();
		ab.setDisposeWhenPointerOutOfBounds(true);
		ab.show(h /8 * 7, 0, 0, 0);
		
	}
}
