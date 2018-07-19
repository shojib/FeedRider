/*
 * Title: FeedRider v0.1b1 - A Feed Reader Application
 * Copyright (C) 2007, 2009  Mahmud Hossain. All rights reserved.
 * License: Lesser GNU General Public License
 * 3rd Party Libraries: Project ROME, JDIC
 * http://code.google.com/p/feedrider/
 * http://sourceforge.net/projects/feedrider/
*/


import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class Headlines {
    private JScrollPane scroller;
    private JEditorPane headlinesEditor;
    private FeedProperties properties;

	public Headlines() {
	    headlinesEditor = new JEditorPane();
	    scroller = new JScrollPane();
    	properties = new FeedProperties();
        
        headlinesEditor.setContentType("text/html");
        headlinesEditor.setFont(new Font("Helvetica", 0, 13));

        headlinesEditor.setEditable(false);
        
        headlinesEditor.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        scroller.setBorder(BorderFactory.createTitledBorder("Headlines"));
        scroller.setSize(new Dimension(properties.getHeadlinesWidth(), properties.getHeadlinesHeight()));
        scroller.setMinimumSize(new Dimension(300, 100));
        scroller.getViewport().add(headlinesEditor);
        
	}
	
	public JEditorPane getHeadlinesEditor () {
		return this.headlinesEditor;
	}
	
	public JScrollPane getComponent() {
		return scroller;
	}
	
	public void setText (String s) {
		headlinesEditor.setText(s);
		headlinesEditor.setCaretPosition(0);
	}
	
}
