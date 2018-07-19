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
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.tree.*;


public class Channels {
    private JScrollPane scroller;
    private static JTree channelsTree;
    private DefaultTreeModel model;
    private DefaultMutableTreeNode dmtn, channels;
    private ImageIcon feedIcon;
    private FeedProperties properties;
    private JPopupMenu popmenu;
    private JMenuItem openItem, cutItem, copyItem, pasteItem, addItem, editItem, deleteItem;
	
	public Channels() {
		scroller = new JScrollPane();
		channelsTree = new JTree();
		properties = new FeedProperties();

		channels = new DefaultMutableTreeNode("Feed Channels");
		
	    feedIcon = new ImageIcon(FeedRiderFrame.class.getResource("images/feed_icon.png"));
	    
	    scroller.getViewport().add(channelsTree);
        scroller.setBorder(BorderFactory.createTitledBorder("Channels"));
        scroller.setSize(new Dimension(properties.getChannelsWidth(), properties.getChannelsHeight()));
        scroller.setMinimumSize(new Dimension(170, 100));
        
	}

    public JPopupMenu getPopupMenu() {
        
        popmenu = new JPopupMenu("Menu");

        openItem = new JMenuItem("Open");
        cutItem = new JMenuItem("Cut");
        copyItem = new JMenuItem("Copy");
        pasteItem = new JMenuItem("Paste");
        addItem = new JMenuItem("Add");
        addItem.setActionCommand("add");
        addItem.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent arg0) {
            actionForPopup(arg0);
        }});

        editItem = new JMenuItem("Edit");
        deleteItem = new JMenuItem("Delete");
        deleteItem.setActionCommand("delete");
        deleteItem.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent arg0) {
            actionForPopup(arg0);
        }});

        popmenu.setPopupSize(150, 170);
        popmenu.add(openItem);
        popmenu.addSeparator();
        popmenu.add(cutItem);
        popmenu.add(copyItem);
        popmenu.add(pasteItem);
        popmenu.addSeparator();
        popmenu.add(editItem);
        popmenu.addSeparator();
        popmenu.add(addItem);
        popmenu.add(deleteItem);

        int keyMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, keyMask));
        copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, keyMask));
        pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, keyMask));
        editItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, keyMask));
        deleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));

        return popmenu;
        
    }

    public void actionForPopup(ActionEvent ae) {

        DefaultMutableTreeNode node;
        
        TreePath path = channelsTree.getSelectionPath();

        channelsTree.setSelectionPath(path);

        node = (DefaultMutableTreeNode)path.getLastPathComponent();
        
        if (ae.getActionCommand().equals("add")) {
            
            //((DefaultTreeModel )channelsTree.getModel()).nodeStructureChanged((TreeNode)dmtn);

            JTextField feedName = new JTextField("");
            JTextField feedLink = new JTextField("");

            Object a[] =
            { "Enter a Feed Name:", feedName, "Enter a Feed Link:",
              feedLink };

            JOptionPane.showMessageDialog(null, a, "Add a Feed", JOptionPane.PLAIN_MESSAGE);


            if (!feedName.getText().equals("") && !feedLink.getText().equals("")) {

                node.add(new DefaultMutableTreeNode("<html><a href='" +
                                                    feedLink.getText() + "'>" +
                                                    feedName.getText() +
                                                    "</a></html>"));
                //dmtn.add(node);
                
                channelsTree.updateUI();

            } else if (!feedName.getText().equals("") && feedLink.getText().equals("")) {

                node.add(new DefaultMutableTreeNode(feedName.getText()));
                //dmtn.add(node);

                channelsTree.updateUI();
                
            } else if (feedName.getText().equals("") && !feedLink.getText().equals("")) {

                node.add(new DefaultMutableTreeNode("<html><a href='" +
							                        feedLink.getText() + "'>" +
							                        "Untitled Feed" +
							                        "</a></html>"));
                //dmtn.add(node);

                channelsTree.updateUI();
            }

        }

        if (ae.getActionCommand().equals("delete")) {

            int verify = JOptionPane.showConfirmDialog(null,
                    "Are you sure?",
                    "Remove",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (verify == 0) {
            	
	            dmtn = (DefaultMutableTreeNode) path.getLastPathComponent();
	            node = (DefaultMutableTreeNode)dmtn.getParent();
	            int nodeIndex = node.getIndex(dmtn); 
	            dmtn.removeAllChildren();         
	            node.remove(nodeIndex);            
	            //((DefaultTreeModel )channelsTree.getModel()).nodeStructureChanged((TreeNode)dmtn);
	
	            channelsTree.updateUI();
            }
        }
        
    }
	
	public JScrollPane getComponent(DefaultMutableTreeNode name) {

        channelsTree = new JTree();

        channelsTree.setModel(new DefaultTreeModel(name));

        channelsTree.setFont(new Font("Helvetica", 0, 13));

        channelsTree.setShowsRootHandles(true);
        channelsTree.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        channelsTree.setAutoscrolls(true);  
    
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setLeafIcon(feedIcon);
        
        channelsTree.setCellRenderer(renderer);
        
        channelsTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        scroller.getViewport().add(channelsTree, null);
        
        return scroller;

	}
	
	public JScrollPane getScroller() {
		return this.scroller;
	}
	
	public DefaultMutableTreeNode getNode() {
		return this.dmtn;
	}

	public void setChannelsTree(JTree channelsTree) {
		this.channelsTree = channelsTree;
	}
	
	public JTree getChannelsTree() {
		channelsTree.setCursor(new Cursor(Cursor.HAND_CURSOR));
		return channelsTree;
	}

	public void setModel(DefaultTreeModel model) {
		this.model = model;
	}

	public void setNode(DefaultMutableTreeNode node) {
		this.dmtn = node;
	}
	
	
}
