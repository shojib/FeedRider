/*
 * Title: FeedRider v0.1b1 - A Feed Reader Application
 * Copyright (C) 2007, 2009  Mahmud Hossain. All rights reserved.
 * License: Lesser GNU General Public License
 * 3rd Party Libraries: Project ROME, JDIC
 * http://code.google.com/p/feedrider/
 * http://sourceforge.net/projects/feedrider/
*/

import java.awt.*;
import javax.swing.*;

public class Toolbar extends JComponent {
    private JToolBar jToolBar;
    //private JButton backButton, forwardButton, stopButton, reloadButton;
    private JButton openButton, saveButton, goButton, bookmarkButton;
    private JLabel jLabel1, jLabel2;
    private JTextField addressBar;
    
    public Toolbar() {
        jToolBar = new JToolBar();
        /*
        backButton = new JButton();
        forwardButton = new JButton();
        stopButton = new JButton();
        reloadButton = new JButton();
        */
        openButton = new JButton();
        saveButton = new JButton();
        goButton = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        addressBar = new JTextField();
        bookmarkButton = new JButton();
    }
    
        public JToolBar getComponent() {
        /*
        jToolBar.add(backButton, null);
        jToolBar.add(forwardButton, null);
        jToolBar.add(stopButton, null);
        jToolBar.add(reloadButton, null);
        */
        jToolBar.add(openButton, null);
        jToolBar.add(saveButton, null);
        jToolBar.add(jLabel2, null);
        jToolBar.add(addressBar, null);
        jToolBar.add(jLabel1, null);
        jToolBar.add(goButton, null);
        jToolBar.add(bookmarkButton, null);

        jToolBar.setFont(new Font("Lucida Grande", 0, 11));
        jToolBar.setBackground(SystemColor.menu);
        jToolBar.setFloatable(false);
        jToolBar.setAutoscrolls(true);
        //backButton.setText("Back");
        jLabel1.setText("  ");
        jLabel2.setText("  ");
        
        addressBar.setSize(new Dimension(200, 21));
        addressBar.setMinimumSize(new Dimension(300, 19));
        addressBar.setMaximumSize(new Dimension(800, 19));
        addressBar.setAutoscrolls(true);
        addressBar.setFont(new Font("Monaco", 0, 12));

        addressBar.setBackground(new Color(241, 245, 250));
 /*  
        backButton.setBackground(new Color(209, 209, 208));
        backButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        backButton_actionPerformed(e);
                    }
                });
        forwardButton.setText("Forward");
        forwardButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        forwardButton_actionPerformed(e);
                    }
                });
        stopButton.setText("Stop");
        stopButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        stopButton_actionPerformed(e);
                    }
                });
        reloadButton.setText("Reload");
        reloadButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        reloadButton_actionPerformed(e);
                    }
                });
*/
        goButton.setText("Go");

        bookmarkButton.setText("Bookmark");

        openButton.setText("Open");

        saveButton.setText("Save");

        return jToolBar;
    }
        
    public void setURL(String s) {
            this.addressBar.setText(s);
            this.addressBar.setCaretPosition(0);
    }
    
    public JButton getBookmarkButton() {
            return this.bookmarkButton;
    }
    
    public JButton getOpenButton() {
            return this.openButton;
    }
    
    public JButton getSaveButton() {
            return this.saveButton;
    }
    
    public JButton getGoButton() {
            return this.goButton;
    }
    
    public JTextField getAddressBar () {
        addressBar.setCaretPosition(0);
        return this.addressBar;
    }

    
/*
    public void backButton_actionPerformed(ActionEvent e) {
        browser.back();
    }

    public void forwardButton_actionPerformed(ActionEvent e) {
        browser.forward();
    }

    public void stopButton_actionPerformed(ActionEvent e) {
        browser.stop();
    }

    public void reloadButton_actionPerformed(ActionEvent e) {
        browser.reload();
    }
*/


}
