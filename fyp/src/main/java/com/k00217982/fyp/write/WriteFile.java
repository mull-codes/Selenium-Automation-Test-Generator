package com.k00217982.fyp.write;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import com.k00217982.fyp.helper.Logger;
import com.k00217982.fyp.read.ReadFile;

public class WriteFile {
	
	static InputStream inputStream;
	
	public static boolean setProperty(String propertyName, String propertyValue) throws IOException {
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
		return true;
	}

}
