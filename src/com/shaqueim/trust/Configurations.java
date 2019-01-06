package com.shaqueim.trust;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Configurations {

	public static String configFile = "config.properties";
	public static Properties properties = new Properties();
	
	/**
	 * Populate database properties
	 */
	public static void loadProperties() {
		
		try {
			InputStream inStream = new FileInputStream(configFile);
			properties.load(inStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Save Database properties 
	 */
	public static void saveProperties() {
		
		try {
			OutputStream outputStream = new FileOutputStream(configFile);
			properties.store(outputStream, "Trust Configurations");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
