package com.shaqueim.trust;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Configurations {

	private static final String DATETIMEFORMAT = "dd MMMM, yyyy";
	public static final String configFile = "config.properties";
	public static Properties properties = new Properties();
	
	//Local File Handling
	public static final File LOANS_DATA = new File("LOANS.lst"); //loan list and payments.ex trust loans?
	public static final File PAYMENT_DATA = new File("PAYMENTS.lst"); //loan list and payments.ex trust loans?
	
	
	private static final int TIMEZONE = -5;
	
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

	public static ZoneOffset getZoneOffset() {
		// TODO Auto-generated method stub
		return ZoneOffset.ofHours(TIMEZONE);
	}

	public static DateTimeFormatter getDateTimeFormat() {
		return DateTimeFormatter.ofPattern(DATETIMEFORMAT);
	}
	
}
