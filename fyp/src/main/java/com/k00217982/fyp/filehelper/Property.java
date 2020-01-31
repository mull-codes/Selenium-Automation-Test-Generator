package com.k00217982.fyp.filehelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import com.k00217982.fyp.helper.Logger;
import com.k00217982.fyp.read.ReadFile;

public class Property {
	
	static String result = "";
	static InputStream inputStream;
	static FileOutputStream out;
	
	static File file;
	
	public static String getProperty(String propertyName, String fileOption) throws IOException {
		 
		try {
			Properties prop = new Properties();
			String propFileName = fileOption + ".properties";
			System.out.println("Initialized " +fileOption+ ".properties");
 
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
	
	
	public static boolean setProperty(String propertyName, String propertyValue, String fileOption) throws IOException {
		boolean updated = false;
		try{
			Properties prop = new Properties();
//			file = new File(fileOption + ".properties");
//			Properties writeProp = new Properties();
//			//out = new FileOutputStream(fileOption + ".properties");
//			writeProp.setProperty(propertyName, propertyValue);
//			saveProperties(writeProp);
			
			
			
			//Get property and check if the property was found and has exact match
			
			String propFileName = fileOption + ".properties";
			System.out.println("Initialized " +fileOption+ ".properties");

			inputStream = ReadFile.class.getClassLoader().getResourceAsStream(propFileName);
			System.out.println("Getting resourse file!");
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				Logger.log("property file '" + propFileName + "' not found in the classpath");
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			
			String property = getProperty(propertyName, fileOption);
			if(property.equals(propertyValue)){
				updated = true;
				Logger.logInfo("Property " + propertyName + " updated with the value: " + propertyValue);
			}else{
				Logger.logError("Property " + propertyName + " update failed with the value: " + propertyValue);
			}
					
		}catch (Exception e) {
			System.out.println("Exception: " + e);
			Logger.logError(e.toString());
		} finally {
			inputStream.close();
		}
		
		return updated;
	}
	
	
	static void saveProperties(Properties p) throws IOException
    {
        FileOutputStream fr = new FileOutputStream(file);
        p.store(fr, "Properties");
        fr.close();
        System.out.println("After saving properties: " + p);
    }


}
