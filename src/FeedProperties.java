/*
 * Title: FeedRider v0.1b1 - A Feed Reader Application
 * Copyright (C) 2007, 2009  Mahmud Hossain. All rights reserved.
 * License: Lesser GNU General Public License
 * 3rd Party Libraries: Project ROME, JDIC
 * http://code.google.com/p/feedrider/
 * http://sourceforge.net/projects/feedrider/
*/

import java.io.*;
import java.util.Properties;

public class FeedProperties {
	
    protected String 	appName, 
						appDesc,
						author,
						appVersion,
						appLogo,
						email,
						copyright, 
						homepage,
						paypalUrl,
						javaVersion,
						mainFrameWidth,
						mainFrameHeight,
						defaultUrl,
						channelsWidth, 
						channelsHeight, 
						headlinesWidth, 
						headlinesHeight, 
						browserWidth, 
						browserHeight,
						locationX, 
						locationY,
						browser;
    
    protected Properties properties;
    protected File file;
    protected String fileName = "properties";
    
    FeedProperties() {
    	
    	properties = new Properties();
    	
    	file = new File(fileName);
    	
    	if (!file.exists()) {
    		
    		loadDefaultVariables();
    		save();
	    	
    	}
    	
    	else {
    	
	    	try {
	    		
				properties.loadFromXML(new FileInputStream(fileName));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			loadVariables();
    	}
    }
    
    public void save() {
    	
    	setVariables();
    	
    	try {
    		
			properties.storeToXML(new FileOutputStream(fileName), appName, "UTF-8");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
    
    public Object[] getValues() {
    	return this.properties.values().toArray();
    }
    
    public Object[] getNames() {
    	return this.properties.keySet().toArray();
    }
    
    public void loadDefaultVariables() {

		appName = "FeedRider: A Feed Reader Application"; 
		appDesc = "FeedRider is a feed reader application with a built-in web browser. It works on Windows, Mac OS and Linux. It currently supports RSS 0.90 - RSS 2.0 and Atom 1.0. It is licensed under the GNU Lesser General Public License.";
		author = "Mahmud Hossain";
		
		appVersion = "0.1b1";
		appLogo = "http://feedrider.googlecode.com/files/feedrider.png";
		email = "feedrider1@gmail.com";
		copyright = "Copyright \u00a9 2007, 2009 Mahmud Hossain.<br>All rights reserved.";
		homepage = "http://feedrider.googlecode.com";
		paypalUrl = "https://www.paypal.com/cgi-bin/webscr?cmd=_xclick&business=mahmud%2epaypal%40gmail%2ecom&item_name=FeedRider%3a%20A%20Java%20Swing%20Application&no_shipping=0&no_note=1&tax=0&currency_code=USD&lc=US&bn=PP%2dDonationsBF&charset=UTF%2d8";
		javaVersion = System.getProperty("java.version");
		
		mainFrameWidth = "1200";
		mainFrameHeight = "800";
		defaultUrl = "http://feedrider.googlecode.com/files/default.xml";
		channelsWidth = "500"; 
		channelsHeight = "500"; 
		headlinesWidth = "500"; 
		headlinesHeight = "500"; 
		browserWidth = "500"; 
		browserHeight = "500";
		locationX = "0"; 
		locationY = "0";
		browser = "false";
		
    }
    
    public void loadVariables() {

		appName = properties.getProperty("appName"); 
		appDesc = properties.getProperty("appDesc"); 
		author = properties.getProperty("author"); 
		appVersion = properties.getProperty("appVersion"); 
		appLogo = properties.getProperty("appLogo"); 
		email = properties.getProperty("email"); 
		copyright = properties.getProperty("copyright"); 
		homepage = properties.getProperty("homepage"); 
		paypalUrl = properties.getProperty("paypalUrl"); 
		javaVersion = System.getProperty("java.version");
		defaultUrl = properties.getProperty("defaultUrl"); 
		mainFrameWidth = properties.getProperty("mainFrameWidth");
		mainFrameHeight = properties.getProperty("mainFrameHeight");
		channelsWidth = properties.getProperty("channelsWidth");
		channelsHeight = properties.getProperty("channelsHeight"); 
		headlinesWidth = properties.getProperty("headlinesWidth");
		headlinesHeight = properties.getProperty("headlinesHeight");
		browserWidth = properties.getProperty("browserWidth");
		browserHeight = properties.getProperty("browserHeight");
		locationX = properties.getProperty("locationX");
		locationY = properties.getProperty("locationY");
		browser = properties.getProperty("browser");
		
    }
    
    public void setVariables() {
		
    	properties.setProperty("appVersion", appVersion);
    	properties.setProperty("copyright", copyright);
    	properties.setProperty("javaVersion", javaVersion);
    	properties.setProperty("author", author);
    	properties.setProperty("email", email);
    	properties.setProperty("homepage", homepage);
    	properties.setProperty("appLogo", appLogo);
    	properties.setProperty("paypalUrl", paypalUrl);
    	properties.setProperty("appName", appName);
    	properties.setProperty("appDesc", appDesc);
    	properties.setProperty("defaultUrl", defaultUrl);
    	properties.setProperty("mainFrameWidth", mainFrameWidth);
    	properties.setProperty("mainFrameHeight", mainFrameHeight);
    	properties.setProperty("channelsWidth", channelsWidth);
    	properties.setProperty("channelsHeight", channelsHeight);
    	properties.setProperty("headlinesWidth", headlinesWidth);
    	properties.setProperty("headlinesHeight", headlinesHeight);
    	properties.setProperty("browserWidth", browserWidth);
    	properties.setProperty("browserHeight", browserHeight);
    	properties.setProperty("locationX", locationX);
    	properties.setProperty("locationY", locationY);
    	properties.setProperty("browser", browser);
    	
    }
    
    public int getLocationX() {
		return Integer.parseInt(locationX);
	}

	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}

	public int getLocationY() {
		return Integer.parseInt(locationY);
	}

	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}

	public boolean isBrowser() {
		return Boolean.parseBoolean(browser);
	}

	public void setBrowser(boolean b) {
		this.browser = Boolean.toString(b);
	}

	public String getAppName() {
		return appName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getJavaVersion() {
		return javaVersion;
	}

	public int getChannelsWidth() {
		return Integer.parseInt(channelsWidth);
	}

	public void setChannelsWidth(String channelsWidth) {
		this.channelsWidth = channelsWidth;
	}

	public int getChannelsHeight() {
		return Integer.parseInt(channelsHeight);
	}

	public void setChannelsHeight(String ChannelsHeight) {
		this.channelsHeight = ChannelsHeight;
	}

	public int getHeadlinesWidth() {
		return Integer.parseInt(headlinesWidth);
	}

	public void setHeadlinesWidth(String headlinesWidth) {
		this.headlinesWidth = headlinesWidth;
	}

	public int getHeadlinesHeight() {
		return Integer.parseInt(headlinesHeight);
	}

	public void setHeadlinesHeight(String headlinesHeight) {
		this.headlinesHeight = headlinesHeight;
	}

	public int getBrowserWidth() {
		return Integer.parseInt(browserWidth);
	}

	public void setBrowserWidth(String browserWidth) {
		this.browserWidth = browserWidth;
	}

	public int getBrowserHeight() {
		return Integer.parseInt(browserHeight);
	}

	public void setBrowserHeight(String browserHeight) {
		this.browserHeight = browserHeight;
	}

	public int getMainFrameWidth() {
		return Integer.parseInt(mainFrameWidth);
	}

	public void setMainFrameWidth(String mainFrameWidth) {
		this.mainFrameWidth = mainFrameWidth;
	}

	public int getMainFrameHeight() {
		return Integer.parseInt(mainFrameHeight);
	}

	public void setMainFrameHeight(String mainFrameHeight) {
		this.mainFrameHeight = mainFrameHeight;
	}

	public String getDefaultUrl() {
		return defaultUrl;
	}

	public void setDefaultUrl(String defaultUrl) {
		this.defaultUrl = defaultUrl;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getPaypalUrl() {
		return paypalUrl;
	}

	public void setPaypalUrl(String paypalUrl) {
		this.paypalUrl = paypalUrl;
	}

	public String getAppDesc() {
		return appDesc;
	}

	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}

	public String getAppLogo() {
		return appLogo;
	}

	public void setAppLogo(String appLogo) {
		this.appLogo = appLogo;
	}
    
}