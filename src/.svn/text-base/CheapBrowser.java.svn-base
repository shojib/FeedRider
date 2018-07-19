/*
 * Title: FeedRider v0.1b1 - A Feed Reader Application
 * Copyright (C) 2007, 2009  Mahmud Hossain. All rights reserved.
 * License: Lesser GNU General Public License
 * 3rd Party Libraries: Project ROME, JDIC
 * http://code.google.com/p/feedrider/
 * http://sourceforge.net/projects/feedrider/
*/

import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;


public class CheapBrowser {
	private JEditorPane browser;
	private JScrollPane scroller;
	private FeedProperties properties;

	public CheapBrowser() {
		browser = new JEditorPane();
    	properties = new FeedProperties();
		scroller = new JScrollPane();
        
		browser.setEditable(false);
		browser.setContentType("text/html");

        scroller.setBorder(BorderFactory.createTitledBorder("Browser"));
        scroller.setSize(new Dimension(properties.getBrowserWidth(), properties.getBrowserHeight()));
        scroller.setMinimumSize(new Dimension(400, 100));
        scroller.setBorder(BorderFactory.createTitledBorder("Browser"));
		scroller.getViewport().add(browser);
	}
	
	public void setURL (URL s) {
		try {
			this.browser.setPage(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public JScrollPane getComponent () {
		return scroller;
	}
	
	public JEditorPane getBrowser () {
		return browser;
	}
	
	public void setPage (String s) {
		try {
			this.browser.setPage(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setPage (URL u) {
		try {
			this.browser.setPage(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
