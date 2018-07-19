/*
 * Title: FeedRider v0.1b1 - A Feed Reader Application
 * Copyright (C) 2007, 2009  Mahmud Hossain. All rights reserved.
 * License: Lesser GNU General Public License
 * 3rd Party Libraries: Project ROME, JDIC
 * http://code.google.com/p/feedrider/
 * http://sourceforge.net/projects/feedrider/
*/

import com.sun.syndication.feed.synd.*;
import com.sun.syndication.fetcher.FeedFetcher;
import com.sun.syndication.fetcher.FetcherException;
import com.sun.syndication.fetcher.impl.*;
import com.sun.syndication.io.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultMutableTreeNode;


public class ReadWriteFeed {
    private SyndFeed feed;
    private SyndEntry entry;
    private SyndFeedInput input;
    private StringBuilder string;
    private PrintWriter writer;
    private SyndFeedOutput output;
	private List<SyndCategory> categories;
    private SyndCategory category;
    private int counter;
    private ArrayList entries;
    private FeedFetcherCache feedInfoCache;
    private FeedFetcher feedFetcher;
    private Date date = null;
    private String formattedDate;
    private ImageIcon imageIcon;
    private DefaultMutableTreeNode channels;
    private BufferedReader reader;
    private SyndImageImpl image;
    private SyndContentImpl content;
    private DefaultMutableTreeNode dmt[];
    private SyndCategory cat;
    private List<SyndEntry> entriesList;

    public ReadWriteFeed () {
        input = new SyndFeedInput();
        feedInfoCache = HashMapFeedInfoCache.getInstance();
        feedFetcher = new HttpURLFeedFetcher(feedInfoCache);
        imageIcon = new ImageIcon(AboutBox.class.getResource("images/FeedRider.png"));
        counter = 0;
    	feed = new SyndFeedImpl();
        entries = new ArrayList();
		image = new SyndImageImpl();
        string = new StringBuilder();
    }
    
    public StringBuilder getText() {
        return string;
    }
    
    void writeHeader(String feedType, String title, String cr, String link, String desc, String url) {
        
		feed.setFeedType(feedType);

        feed.setTitle(title);
        feed.setCopyright(cr);
        feed.setLink(link);
        feed.setDescription(desc);
		feed.setPublishedDate(new Date());
		
		image.setTitle(title);
		image.setLink(link);
		image.setUrl(url);
		
		feed.setImage(image);
    }
    
    void setCategory (String _category) {

    	categories = new ArrayList<SyndCategory>();
        category = new SyndCategoryImpl();
    	
        category.setName(_category);
        categories.add(category);
    	
    }
    
    void writeFeed (String _category, String title, String link, String desc) {

    	categories = new ArrayList<SyndCategory>();
        category = new SyndCategoryImpl();
    	
        category.setName(_category);
        categories.add(category);
        
        entry = new SyndEntryImpl();
        entry.setCategories(categories);
        entry.setTitle(title);
        entry.setLink(link);
        
        content = new SyndContentImpl();
        content.setValue(desc);
        entry.setDescription(content);
        
        entries.add(entry);
        feed.setEntries(entries);
    }
    
    public DefaultMutableTreeNode loadTree (String filename, String title) {
    	try {

            feed = input.build(new BufferedReader(new XmlReader(new File(filename))));
			
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (FeedException e1) {
			e1.printStackTrace();
		} 
		
		return loadFeedTree(title);
		
    }
    
    public DefaultMutableTreeNode loadTree (URL url, String title) {
    	try {
    		
			feed = feedFetcher.retrieveFeed(url);
			
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (FeedException e1) {
			e1.printStackTrace();
		} catch (FetcherException e1) {
			e1.printStackTrace();
		}
		
		return loadFeedTree(title);
    }
    
    protected DefaultMutableTreeNode loadFeedTree(String name) {

    entriesList = feed.getEntries();
    
	String oldCat = "";
	String newCat = "";
	
	dmt = new DefaultMutableTreeNode[entriesList.size()];
	
    if (entriesList != null) {
    	
        cat = new SyndCategoryImpl();
    	
        for (int i = 0; i < entriesList.size(); i++) {
        	cat = (SyndCategory) entriesList.get(i).getCategories().get(0);
        	oldCat = cat.getName().toString();
        	dmt[i] = new DefaultMutableTreeNode(oldCat);
            dmt[i].add(new DefaultMutableTreeNode("<html><a href='"+ entriesList.get(i).getLink() +"'>"+ entriesList.get(i).getTitle() +"</html>"));
            
        	for (int j = i+1; j < entriesList.size(); j++) {
            	cat = (SyndCategory) entriesList.get(j).getCategories().get(0);
            	newCat = cat.getName().toString();

        		if (oldCat.equals(newCat)) {
                   dmt[i].add(new DefaultMutableTreeNode("<html><a href='"+ entriesList.get(j).getLink() +"'>"+ entriesList.get(j).getTitle() +"</html>"));
                   entriesList.remove(j);
                   j-=1;
        		}
        	}
        }
    }

    channels = new DefaultMutableTreeNode(name);

    for (int k = 0; k < entriesList.size(); k++) {
    	channels.add(dmt[k]);
    }
    
    return channels;
    
    } 
    
    void saveToFile(String file) {
    		
    	try {

			writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            
		} catch (IOException e1) {
			e1.printStackTrace();
		}

        output = new SyndFeedOutput();
        
        try {
			output.output(feed, writer);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FeedException e) {
			e.printStackTrace();
		}
    }
    
    public StringBuilder getFeedString (String filename) {
    	try {
    		
            feed = input.build(new BufferedReader(new XmlReader(new File(filename))));
			
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (FeedException e1) {
			e1.printStackTrace();
		} 
		
		return readFeed();
		
    }
    
    public StringBuilder getFeedString (URL url) {
    	try {

			feed = feedFetcher.retrieveFeed(url);
			
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (FeedException e1) {
			e1.printStackTrace();
		} catch (FetcherException e1) {
			e1.printStackTrace();
		}
		
		return readFeed();
    }
    
    protected StringBuilder readFeed() {
    	
    	entriesList = feed.getEntries();
        
        string.delete(0, string.length());
    	
        if (entriesList != null) {
            
            string.append("<html>" +
                      "<table cellpadding=3 cellspacing=1 border=0 style='font-family:Lucida grande'>" +
                      "<tr><td style='font-weight:bold;color:blue;font-size:9px'>" +
                      "<a href='" + feed.getLink() + "'>" + 
                      "<img src='" + feed.getImage().getUrl() + "' border=0></a><br>" +
                      "<a href='" + feed.getLink() + "'>" + feed.getTitle() +
                      "</a><br>");

            try {
                if (date == null)
                    date = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy").parse(feed.getPublishedDate().toString());
            } catch (ParseException e) { e.printStackTrace(); }

            formattedDate =
                    new SimpleDateFormat("h:mma MM/dd/yy").format(date);

            string.append(new SimpleDateFormat("h:mma MM/dd/yy").format(date) +
                      "</td></tr>");

            for (int i = 1; i < entriesList.size(); i++) {
            	string.append("<tr><td style='font-weight:bold;background-color:#F1F5FA;font-size:11px'><a href='" +
                          entriesList.get(i).getLink() + "'>" +
                          entriesList.get(i).getTitle() +
                          "</a></td></tr><tr><td style='font-size:9.5px'>" +
                          entriesList.get(i).getDescription().getValue() +
                          "</td></tr>");
            }

            string.append("</table></html>");
        }

        return string;
                  
    } 
    
}
