/*
 * Title: FeedRider v0.1b1 - A Feed Reader Application
 * Copyright (C) 2007, 2009  Mahmud Hossain. All rights reserved.
 * License: Lesser GNU General Public License
 * 3rd Party Libraries: Project ROME, JDIC
 * http://code.google.com/p/feedrider/
 * http://sourceforge.net/projects/feedrider/
*/

import java.awt.BorderLayout;
import java.net.MalformedURLException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import org.jdesktop.jdic.desktop.Desktop;
import org.jdesktop.jdic.desktop.DesktopException;


public class AboutBox extends JPanel {
    private Border border;
    private BorderLayout borderLayout1;
    private JTextPane disp;
    private FeedProperties properties;

    public AboutBox() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception, MalformedURLException {
        disp = new JTextPane();
    	border = BorderFactory.createEtchedBorder();
    	borderLayout1 = new BorderLayout();
    	
    	properties = new FeedProperties();
    	
        this.setLayout(borderLayout1);
        this.setBorder(border);
        disp.setEditable(false);
        disp.setContentType("text/html");
        disp.setBorder(border);
        
        disp.setText("<html><body style='background-color:#d0d6e2'><table cellpadding=0 cellspaing=0 border=0 width=309>"+
            "<tr><td><img src='"+AboutBox.class.getResource("images/FeedRider.png")+"'></td></tr>" +
            "<tr><td style='background-color:white'>"+ getInfo() +"</td></tr>" +
            "<tr><td align=center><br>" + properties.getCopyright() + "<br><br></td></tr>"+
            "</body></html>");

        this.add(disp, BorderLayout.CENTER);

        disp.addHyperlinkListener(new HyperlinkListener() {

            public void hyperlinkUpdate(HyperlinkEvent e) {

                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    try {

                        Desktop.browse(e.getURL());

                    } catch (DesktopException ex) { }
                
                }
            }
        });
                    
    }

    private StringBuffer getInfo() {
        return new StringBuffer("<br><table cellpadding=3 cellspacing=1 border=0 width=100%>" +
 "<tr><td style='font-size:10px' align=right>Programming:<br>&nbsp;</td><td>"+properties.getAuthor()+"<br><a href='mailto:"+properties.getEmail()+"'>"+properties.getEmail()+"</a><br></td></tr>" +
 "<tr><td style='font-size:10px' align=right>Third Party Library:<br>&nbsp;</td><td><a href='http://rome.dev.java.net/'>Project ROME</a><br><a href='https://jdic.dev.java.net/'>Project JDIC</a><br></td></tr>" +
 "<tr><td colspan=2 style='color:gray;font-size:9px'><br>" +
 
 "This file is part of " + properties.getAppName() + ".<br><br>" +
 
 "This program is free software: you can redistribute it and/or modify "+
 "it under the terms of the Lesser GNU General Public License as published by "+
 "the Free Software Foundation, either version 3 of the License, or "+
 "(at your option) any later version.<br><br>"+

 "This program is distributed in the hope that it will be useful, "+
 "but WITHOUT ANY WARRANTY; without even the implied warranty of "+
 "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the " +
 "Lesser GNU General Public License for more details.<br><br>"+

 "You should have received a copy of the Lesser GNU General Public License "+
 "along with this program.  If not, see http://www.gnu.org/licenses.<br><br>" +
 "</td></tr></table>");
 
    }
}
