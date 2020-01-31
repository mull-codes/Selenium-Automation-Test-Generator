package com.k00217982.fyp.read;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import com.k00217982.fyp.helper.Logger;

public class ReadFile {
	
	static String result = "";
	static InputStream inputStream;
	
	public static String getPropValues(String propertyName) throws IOException {
		 
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
			System.out.println("Initialized config.properties");
 
			inputStream = ReadFile.class.getClassLoader().getResourceAsStream(propFileName);
			System.out.println("Getting resourse file!");
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				Logger.log("property file '" + propFileName + "' not found in the classpath");
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			Date time = new Date(System.currentTimeMillis());
 
			// get the property value and print it out
			result = prop.getProperty(propertyName);
			//System.out.println("Reading[" +propertyName+ "]: " + result);
			Logger.log("Reading[" +propertyName+ "]");
		} catch (Exception e) {
			System.out.println("Exception: " + e);
			Logger.logError(e.toString());
		} finally {
			inputStream.close();
		}
		return result;
	}

}
