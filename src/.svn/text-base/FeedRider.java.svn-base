/*
 * Title: FeedRider v0.1b1 - A Feed Reader Application
 * Copyright (C) 2007, 2009  Mahmud Hossain. All rights reserved.
 * License: Lesser GNU General Public License
 * 3rd Party Libraries: Project ROME, JDIC
 * http://code.google.com/p/feedrider/
 * http://sourceforge.net/projects/feedrider/
*/


import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class FeedRider {
    private FeedRiderFrame frame;
    private String osname;
    
    public FeedRider() {

        osname = System.getProperty("os.name");

        if (osname.contains("Mac"))
            System.setProperty("apple.laf.useScreenMenuBar", "true");

    	frame  = new FeedRiderFrame();


        /*
        frame.setTitle(properties.getAppName());
        
        frame.setSize(properties.getMainFrameWidth(), properties.getMainFrameHeight());
        
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        
        locationX = properties.getLocationX();
        locationY = properties.getLocationY();
        
        if (locationX == 0) {
        	locationX = (screenSize.width - frameSize.width) / 2; 
            properties.setLocationX(Integer.toString(locationX));
        }
        if (locationY == 0) {
        	locationY = (screenSize.height - frameSize.height) / 2; 
            properties.setLocationY(Integer.toString(locationY));
        }
        
        frame.setLocation(locationX, locationY);
		*/
        //frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
		        
		        try {	
		                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		            
		        } catch (Exception e) {
		            e.printStackTrace();
		        }

		        new FeedRider();

		        
			}
		});

        

    }
}
