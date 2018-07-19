/*
 * Title: FeedRider v0.1b1 - A Feed Reader Application
 * Copyright (C) 2007, 2009  Mahmud Hossain. All rights reserved.
 * License: Lesser GNU General Public License
 * 3rd Party Libraries: Project ROME, JDIC
 * http://code.google.com/p/feedrider/
 * http://sourceforge.net/projects/feedrider/
*/

import java.awt.Font;
import javax.swing.*;

public class Statusbar {
    private JLabel statusbar;
	
	public Statusbar () {
		statusbar = new JLabel();

        statusbar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        statusbar.setFont(new Font("Lucida Grande", 0, 10));
        
	}
	
	public void setText(String s) {
		statusbar.setText(s);
	}
	
	public JLabel getComponent() {
		return statusbar;
	}
	
}
