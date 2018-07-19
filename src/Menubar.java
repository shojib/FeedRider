/*
 * Title: FeedRider v0.1b1 - A Feed Reader Application
 * Copyright (C) 2007, 2009  Mahmud Hossain. All rights reserved.
 * License: Lesser GNU General Public License
 * 3rd Party Libraries: Project ROME, JDIC
 * http://code.google.com/p/feedrider/
 * http://sourceforge.net/projects/feedrider/
*/


import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Menubar {
    private JMenuItem donateHelpItem, saveFileItem, saveAsFileItem, openFileItem, exitFileItem, aboutHelpItem, preferenceFileItem;
    //private JMenuItem saveFileItem;
    private JMenu helpMenu, fileMenu;
    private JMenuBar menuBar;
    //private JCheckBox newTab, newTabSelect;
    private JRadioButton externalBrowser, internalBrowser;
    private ButtonGroup radioGroup;
    private JLabel browserLabel;
    //private JTabbedPane tabbedPane;
    private Toolbar toolbar;
    private Object o[];
    //private boolean firstTime = true;
    private int keyMask;
    private FeedProperties properties;

	public Menubar () {

        menuBar = new JMenuBar();
        properties = new FeedProperties();
        
        fileMenu = new JMenu("File");
        openFileItem = new JMenuItem("Open File...");
        saveFileItem = new JMenuItem("Save");
        saveAsFileItem = new JMenuItem("Save As..");
        preferenceFileItem = new JMenuItem("Preferences...");
        exitFileItem = new JMenuItem("Exit");
        
        helpMenu = new JMenu("Help");
        aboutHelpItem = new JMenuItem("About");
        donateHelpItem = new JMenuItem("Donate");
        
        //newTabSelect = new JCheckBox();
        //newTab = new JCheckBox();
        
        externalBrowser = new JRadioButton();
        internalBrowser = new JRadioButton();
        radioGroup = new ButtonGroup();
        browserLabel = new JLabel();
        
        //tabbedPane = new JTabbedPane();

        fileMenu.add(openFileItem);
        fileMenu.addSeparator();
        fileMenu.add(saveFileItem);
        fileMenu.add(saveAsFileItem);
        fileMenu.addSeparator();
        fileMenu.add(preferenceFileItem);
        fileMenu.addSeparator();
        fileMenu.add(exitFileItem);
        menuBar.add(fileMenu);
        
        helpMenu.add(aboutHelpItem);
        helpMenu.addSeparator();
        helpMenu.add(donateHelpItem);
        menuBar.add(helpMenu);  
        
        keyMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        //fileMenu.setMnemonic('F');
        //helpMenu.setMnemonic('H');
        //fileMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, (InputEvent.ALT_MASK | keyMask)));
        //helpMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, (InputEvent.ALT_MASK | keyMask)));
        
        openFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, keyMask));
        saveFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, keyMask));
        saveAsFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, (InputEvent.SHIFT_MASK | keyMask)));
        preferenceFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_COMMA, keyMask));
        exitFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, keyMask));
        
        browserLabel.setText("Browse using");
        internalBrowser.setText("internal browser");
        externalBrowser.setText("external browser");

        if (properties.isBrowser())
            internalBrowser.setSelected(true);
        else
            externalBrowser.setSelected(true);
        
        radioGroup.add(internalBrowser);
        radioGroup.add(externalBrowser);

        o = new Object[3];
        o[0] = browserLabel;
        o[1] = internalBrowser;
        o[2] = externalBrowser;
        
	}
	
	public Object[] getObjects() {
		return o;
	}

	public JMenuItem getDonateHelpItem() {
		return donateHelpItem;
	}

	public JMenuItem getOpenFileItem() {
		return openFileItem;
	}

	public JMenuItem getSaveAsFileItem() {
		return saveAsFileItem;
	}

	public JMenu getHelpMenu() {
		return helpMenu;
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public JMenu getFileMenu() {
		return fileMenu;
	}

	public JMenuItem getExitFileItem() {
		return exitFileItem;
	}

	public JMenuItem getAboutHelpItem() {
		return aboutHelpItem;
	}

	public JMenuItem getPreferenceFileItem() {
		return preferenceFileItem;
	}

	public JRadioButton getExternalBrowser() {
		return externalBrowser;
	}

	public JRadioButton getInternalBrowser() {
		return internalBrowser;
	}

	public boolean isExternalBrowser() {
		return true;
	}

	public boolean isInternalBrowser() {
		return true;
	}

	public Toolbar getToolbar() {
		return toolbar;
	}
	
	
}
