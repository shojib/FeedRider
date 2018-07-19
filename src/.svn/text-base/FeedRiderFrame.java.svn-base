/*
 * Title: FeedRider v0.1b1 - A Feed Reader Application
 * Copyright (C) 2007, 2009  Mahmud Hossain. All rights reserved.
 * License: Lesser GNU General Public License
 * 3rd Party Libraries: Project ROME, JDIC
 * http://code.google.com/p/feedrider/
 * http://sourceforge.net/projects/feedrider/
*/

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.*;
import org.jdesktop.jdic.desktop.Desktop;
import org.jdesktop.jdic.desktop.DesktopException;


public class FeedRiderFrame extends JFrame {
	private JSplitPane jSplitPane1, jSplitPane2;
    private BorderLayout borderLayout1;
    private JPanel jPanel1;
    private GridBagLayout gridBagLayout1;
	private Toolbar toolbar;
	private Menubar menubar;
    private Channels channels;
    private Statusbar statusbar;
    private CheapBrowser browser;
    private Headlines headlines;
    private DefaultTreeModel model;
    private DefaultMutableTreeNode node, node2[], dmt;
    private ReadWriteFeed feeder;
	private JFileChooser fc;
	private File file;
	private URL url, feedurl;
    private Object[] o;
    private FeedProperties properties;
    private int locationX, locationY;
    private Dimension screenSize, frameSize;

    public FeedRiderFrame() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void jbInit() {
    	initializer();
    	this.setJMenuBar(menubar.getMenuBar());
    	this.getContentPane().setLayout(borderLayout1);
    	this.setSize(new Dimension(properties.getMainFrameWidth(), properties.getMainFrameHeight()));
    	this.setTitle(properties.getAppName());
        callOnUI();
        callOnEventsHandler();

        this.setTitle(properties.getAppName());

        this.setSize(properties.getMainFrameWidth(), properties.getMainFrameHeight());
        
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize = this.getSize();

        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }

        else if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }

        locationX = properties.getLocationX();
        locationY = properties.getLocationY();

        if (locationX == 0) {
        	locationX = (screenSize.width - frameSize.width) / 2;
        }

        else if (locationY == 0) {
        	locationY = (screenSize.height - frameSize.height) / 2;
        }

        this.setLocation(locationX, locationY);

    }
    
    public void initializer () {
    	
    	properties = new FeedProperties();
    	
        jSplitPane1 = new JSplitPane();
        jSplitPane2 = new JSplitPane();
        
        browser = new CheapBrowser();

    	menubar = new Menubar();
        toolbar = new Toolbar();
        headlines = new Headlines();
        statusbar = new Statusbar();
        channels = new Channels();
        
    	feeder = new ReadWriteFeed();
    	o = menubar.getObjects();
    	node = channels.getNode();
    	fc = new JFileChooser();
    	file = new File("");
    	
    	try {
    		
			feedurl = new URL(properties.getDefaultUrl());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

        dmt = feeder.loadTree(feedurl, "Feed Channels");
        
        browser.setPage(properties.getHomepage());
        
        borderLayout1 = new BorderLayout();
        jPanel1 = new JPanel();
        gridBagLayout1 = new GridBagLayout();

    }
    
	public void callOnUI() {
                
        jSplitPane1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jSplitPane1.setDividerSize(7);
        jSplitPane1.setOneTouchExpandable(true);
        jSplitPane1.setBackground(SystemColor.window);
        jSplitPane2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jSplitPane2.setDividerSize(7);
        jSplitPane2.setOneTouchExpandable(true);
    
        jSplitPane2.add(headlines.getComponent(), JSplitPane.LEFT);

        jPanel1.setLayout(gridBagLayout1);  

        if (properties.isBrowser()) {
            jSplitPane2.add(browser.getComponent(), JSplitPane.RIGHT);
        } 
        else {
            jSplitPane2.getRightComponent().setVisible(false);
        }

        jSplitPane1.add(jSplitPane2, JSplitPane.RIGHT);

        jPanel1.add(channels.getComponent(dmt),
                    new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
                                           GridBagConstraints.CENTER,
                                           GridBagConstraints.BOTH,
                                           new Insets(0, 0, 2, 0), 17, 403));
/*
        jPanel1.add(channels.getButtonPanel(),
        			new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                                           GridBagConstraints.NONE,
                                           new Insets(0, 0, 0, 0), 0, 0));
*/
        jSplitPane1.add(jPanel1, JSplitPane.LEFT);

        this.getContentPane().add(jSplitPane1, BorderLayout.CENTER);
        this.getContentPane().add(statusbar.getComponent(), BorderLayout.SOUTH);
        this.getContentPane().add(toolbar.getComponent(), BorderLayout.NORTH);
        
	}
	

    public void callOnEventsHandler() {
    	
    	headlines.getHeadlinesEditor().addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent evt) {
            	callHeadlinesEvent(evt);
            }
        });

        channels.getChannelsTree().addTreeSelectionListener(new TreeSelectionListener() {
            public synchronized void valueChanged(TreeSelectionEvent e) {
            	callOnChannelsEvent();
            }
        });

    	menubar.getPreferenceFileItem().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
     	       JOptionPane.showConfirmDialog(null, menubar.getObjects(), "Preferences...", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            }
        });
    	
    	menubar.getExitFileItem().addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
                exitWindow();
    		}
    	});
    	
    	this.addWindowListener(new WindowListener() {

            public void windowOpened(WindowEvent e) {
            }

            public void windowClosing(WindowEvent e) {
                exitWindow();
            }

            public void windowClosed(WindowEvent e) {
            }

            public void windowIconified(WindowEvent e) {
            }

            public void windowDeiconified(WindowEvent e) {
            }

            public void windowActivated(WindowEvent e) {
            }

            public void windowDeactivated(WindowEvent e) {
            }
            
        });
    	
    	channels.getChannelsTree().addMouseListener(new MouseListener() {
    		
            public void mousePressed(MouseEvent e) {
                maybeShowPopup(e);
            }

            public void mouseReleased(MouseEvent e) {
                maybeShowPopup(e);
            }

            private void maybeShowPopup(MouseEvent e) {

                if (e.isPopupTrigger()) {
                   int row = channels.getChannelsTree().getClosestRowForLocation(e.getX(), e.getY());
                   channels.getChannelsTree().setSelectionRow(row);
                   channels.getPopupMenu().show(e.getComponent(), e.getX()+10, e.getY()+10);
                }
            }

            public void mouseClicked(MouseEvent e) {
                maybeShowPopup(e);
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        });
    	
    	menubar.getExternalBrowser().addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			browser.getComponent().setEnabled(false);
    			browser.getComponent().setVisible(false);
    			jSplitPane2.remove(browser.getComponent());
                properties.setBrowser(false);
    		}
    	});
    	
    	menubar.getInternalBrowser().addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			jSplitPane2.add(browser.getComponent(), JSplitPane.RIGHT);
    			browser.getComponent().setEnabled(true);
    			browser.getComponent().setVisible(true);
                properties.setBrowser(true);
    		}
    	});
    	
    	menubar.getSaveAsFileItem().addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				callOnSaveMethod();
    		}
    	});
    	
    	toolbar.getSaveButton().addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				callOnSaveMethod();
    		}
    	});
    	
    	toolbar.getBookmarkButton().addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			callBookmarkEvent();
    		}
    	});
    	
    	menubar.getOpenFileItem().addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			callOnOpenMethod();
    		}
    	});
    	
    	toolbar.getOpenButton().addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			callOnOpenMethod();
    		}
    	});

    	menubar.getDonateHelpItem().addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			callOnDonateMethod();
    		}
    	});

    	menubar.getAboutHelpItem().addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			callOnAboutMethod();
    		}
    	});
    	
    	toolbar.getAddressBar().addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			callGetUrlFrom();
    		}
    	});
    	
    	toolbar.getGoButton().addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			callGetUrlFrom();
    		}
    	});
    	
    	toolbar.getGoButton().addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			callGetUrlFrom();
    		}
    	});
        
    }

    public void exitWindow() {

        properties.setChannelsWidth(Integer.toString(channels.getScroller().getWidth()));
        properties.setChannelsHeight(Integer.toString(channels.getScroller().getHeight()));
        properties.setBrowserWidth(Integer.toString(browser.getComponent().getWidth()));
        properties.setBrowserHeight(Integer.toString(browser.getComponent().getHeight()));
        properties.setHeadlinesWidth(Integer.toString(headlines.getComponent().getWidth()));
        properties.setHeadlinesHeight(Integer.toString(headlines.getComponent().getHeight()));
        properties.setBrowser(menubar.isInternalBrowser());
        properties.setLocationY(Integer.toString(locationY));
        properties.setLocationX(Integer.toString(locationX));
        properties.setMainFrameWidth(Integer.toString(getWidth()));
        properties.setMainFrameHeight(Integer.toString(getHeight()));
        properties.save();
        System.exit(0);
        
    }

    public void callOnAboutMethod () {
            JOptionPane.showMessageDialog(this, new AboutBox(), "About", JOptionPane.PLAIN_MESSAGE);
    }
    
    public void callGetUrlFrom() {
        
        if (!toolbar.getAddressBar().getText().contains("http") && !toolbar.getAddressBar().getText().contains("feed") &&
        		!toolbar.getAddressBar().getText().contains("https") && !toolbar.getAddressBar().getText().contains("file")) {
            	
        	toolbar.getAddressBar().setText("http://" + toolbar.getAddressBar().getText());  
        
        }
            statusbar.setText(toolbar.getAddressBar().getText());

        if (toolbar.getAddressBar().getText().contains("http") || toolbar.getAddressBar().getText().contains("www")) {
            try {
                browser.setURL(new URL(toolbar.getAddressBar().getText()));
            } catch (MalformedURLException eb) {
                eb.printStackTrace();
            }
        } else {
            statusbar.setText("Loading: " + toolbar.getAddressBar().getText());
            
            headlines.setText(feeder.getFeedString(toolbar.getAddressBar().getText()).toString());
        }
    }
    
    public void callOnDonateMethod () {
        try {
            Desktop.browse(new URL(properties.getPaypalUrl()));
        } catch (DesktopException ef) {
            ef.printStackTrace();
        } catch (MalformedURLException ef) {
            ef.printStackTrace();
        } 
    }
    
    public void callOnChannelsEvent() {
		
    	node = (DefaultMutableTreeNode)channels.getChannelsTree().getLastSelectedPathComponent();
		
        if (node.isLeaf()) {
                String str = "" + node.toString().split("'")[1];
            
        if (str != "") {
        	toolbar.setURL(str);
            statusbar.setText("Loading: " + toolbar.getAddressBar().getText());

            headlines.setText("Loading...");

            try {
				headlines.setText(feeder.getFeedString(new URL(toolbar.getAddressBar().getText())).toString());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} 
       }
    }
    }
    
    public void callBookmarkEvent () {
		String value = "";
        value = JOptionPane.showInputDialog(null, "Give a name:");
        
        if (value != "" && value != null) {
        
            DefaultMutableTreeNode node =
                (DefaultMutableTreeNode)channels.getChannelsTree().getModel().getRoot();
            node =
            (DefaultMutableTreeNode)channels.getChannelsTree().getLastSelectedPathComponent();
            node.add(new DefaultMutableTreeNode("<html><a href='" +
            		toolbar.getAddressBar().getText() + "'>" + value + "</a></html>"));
            
            channels.getChannelsTree().updateUI();
        } 
    }
    
    public void callHeadlinesEvent(HyperlinkEvent evt) {
    	
    	headlines.getHeadlinesEditor().setCursor(new Cursor(Cursor.HAND_CURSOR));

		if (evt.getEventType() ==
            HyperlinkEvent.EventType.ACTIVATED) {
            
            toolbar.setURL(evt.getURL().toString());

            try {
            	url = new URL(toolbar.getAddressBar().getText());
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			
			if (properties.isBrowser()) {
					browser.setURL(url);
			}
			
			else if (!properties.isBrowser()) {
                try {
					Desktop.browse(url);
				} catch (DesktopException e) {
					e.printStackTrace();
				}

			}
			
			else return;
        }
    }
    
    protected void callOnSaveMethod () {
		
	    // Start in current directory
		fc.setCurrentDirectory (file.getAbsoluteFile());
	
	    // Set filter for Java source files.
	    fc.setFileFilter (new javax.swing.filechooser.FileFilter() {
	        @Override
			public boolean accept(File f) {
	            return f.getName().toLowerCase().endsWith(".xml") || f.getName().toLowerCase().endsWith(".rss") 
	                || f.isDirectory();
	          }
	
	          @Override
			public String getDescription() {
	            return "XML & RSS Files";
	          }
	        });
	
	    // Set to a default name for save.
	    fc.setSelectedFile (new File("default.rss"));
	
	    // Open chooser dialog
	    int result = fc.showSaveDialog (null);
	
	    if (result == JFileChooser.CANCEL_OPTION) {
	
	    } else if (result == JFileChooser.APPROVE_OPTION) {
	    	file = new File(fc.getSelectedFile().getName());
	
	        if (file.exists ()) {
	            JOptionPane.showConfirmDialog (null,
	              "Overwrite existing file?","Confirm Overwrite",
	               JOptionPane.OK_CANCEL_OPTION,
	               JOptionPane.QUESTION_MESSAGE);
	        }
	
	        node = (DefaultMutableTreeNode)channels.getChannelsTree().getModel().getRoot();
	        
	        feeder.writeHeader("rss_2.0", 
	    			properties.getAppName(), 
	    			properties.getCopyright(), 
	    			properties.getHomepage(),
	    			properties.getAppDesc(),
	    			properties.getAppLogo());
	        
			for (int i = 0; i < node.getChildCount(); i++) {
				
				for (int j = 0; j < node.getChildAt(i).getChildCount(); j++) {
					feeder.writeFeed(node.getChildAt(i).toString(),
							node.getChildAt(i).getChildAt(j).toString().substring(
							node.getChildAt(i).getChildAt(j).toString().indexOf("'>")+2, 
							node.getChildAt(i).getChildAt(j).toString().indexOf("</")),
							node.getChildAt(i).getChildAt(j).toString().substring(
							node.getChildAt(i).getChildAt(j).toString().indexOf("='")+2,
							node.getChildAt(i).getChildAt(j).toString().indexOf("'>")),
							"");
				}
			}
			
			if (file.getName().contains(".xml") || file.getName().contains(".rss"))
				feeder.saveToFile(file.getName());
			else 
				feeder.saveToFile(file.getName()+".rss");
			
		    } 
    }
    
    protected void callOnOpenMethod () {
		
		// Start in current directory
		fc.setCurrentDirectory (file.getAbsoluteFile());

        // Set filter for Java source files.
        fc.setFileFilter (new FileFilter() {

			@Override
			public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".xml") || f.getName().toLowerCase().endsWith(".rss")
                    || f.isDirectory();
              }

              @Override
			public String getDescription() {
                return "XML & RSS Files";
              }
            });
            
        int result = fc.showOpenDialog (null);

        if (result == JFileChooser.CANCEL_OPTION) {

        } else if (result == JFileChooser.APPROVE_OPTION) {
            file = new File(fc.getSelectedFile().getName());

			node = feeder.loadTree(file.getName(), 
					file.getName().substring(0, 
					file.getName().contains("rss") ? file.getName().indexOf(".rss") : file.getName().indexOf(".xml")));
            
            node2 = new DefaultMutableTreeNode[node.getChildCount()];

    		for (int i = 0; i < node.getChildCount(); i++) {
    			node2[i] = new DefaultMutableTreeNode(node.getChildAt(i));
    			
    			for (int j = 0; j < node.getChildAt(i).getChildCount(); j++) {
    				node2[i].add(new DefaultMutableTreeNode(node.getChildAt(i).getChildAt(j)));
    			}
    		}
    		
    		model = new DefaultTreeModel(node);
    		channels.getChannelsTree().setModel(model);
    		
        } else {

        }
    }
    
    public void callGoButtonEvent () {

        if (!toolbar.getAddressBar().getText().contains("http") && !toolbar.getAddressBar().getText().contains("feed") &&
        		!toolbar.getAddressBar().getText().contains("https") && !toolbar.getAddressBar().getText().contains("file")) {
            	
        	toolbar.getAddressBar().setText("http://" + toolbar.getAddressBar().getText());  
        
        }
            statusbar.setText(toolbar.getAddressBar().getText());

        if (toolbar.getAddressBar().getText().contains("http") || toolbar.getAddressBar().getText().contains("www")) {
            	browser.setPage(toolbar.getAddressBar().getText());
        } else {
            statusbar.setText("Loading: " + toolbar.getAddressBar().getText());


            try {
				headlines.setText(feeder.getFeedString(new URL(toolbar.getAddressBar().getText())).toString());
			} catch (MalformedURLException m) {
				// TODO Auto-generated catch block
				m.printStackTrace();
			} 
        }
	}
    
}
