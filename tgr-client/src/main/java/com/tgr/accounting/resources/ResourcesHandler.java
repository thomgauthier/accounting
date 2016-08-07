package com.tgr.accounting.resources;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ResourcesHandler {
	
	private Properties appProperties;

	private static ResourcesHandler handler;
	
	private ResourcesHandler() {
		
	}
	
	public static ResourcesHandler getInstance() {
		if (handler == null) {
			handler = new ResourcesHandler();
		}
		return handler;
	}
	
	public Icon getIcon(String icon) {
		try {
			Image img = ImageIO.read(getClass().getResource("/icons/" + icon));
			return new ImageIcon(img);
		} catch (IOException ex) {
			return null;
		}
	}
	
	public String get(String key) {
		
		if (appProperties == null) {
			appProperties = new Properties();
			InputStream inputStream = getClass().getResourceAsStream("/application.properties");
			if (inputStream != null) {
				try {
					appProperties.load(inputStream);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return appProperties.getProperty(key);
	}
}
