package com.k00217982.fyp.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.configuration.PropertiesConfiguration;

import com.k00217982.fyp.config.Property;
import com.k00217982.fyp.helper.Help;
import com.k00217982.fyp.helper.Logger;
import com.k00217982.fyp.helper.Platform;
import com.k00217982.fyp.read.ReadFile;

public class Property {
	
	//VARIABLE NAMES
	public static final String 		VARIABLE_WEBSITE_URL		=		"WEBSITE_URL";
	public static final String 		VARIABLE_AUTOMATION_ID		=		"AUTOMATION_ID";
	
	public static final String 		VARIABLE_DATABASE			=		"DATABASE";
	
	public static final String 		VARIABLE_MYSQL_SERVER_NAME	=		"MYSQL_SERVER_NAME";
	public static final String 		VARIABLE_MYSQL_DB_NAME		=		"MYSQL_DB_NAME";
	public static final String 		VARIABLE_MYSQL_USER			=		"MYSQL_USER";
	public static final String 		VARIABLE_MYSQL_PASSWORD		=		"MYSQL_PASSWORD";
	
	public static final String 		VARIABLE_ORACLE_SERVER_NAME	=		"ORACLE_SERVER_NAME";
	public static final String 		VARIABLE_ORACLE_DB_NAME		=		"ORACLE_DB_NAME";
	public static final String 		VARIABLE_ORACLE_USER		=		"ORACLE_USER";
	public static final String 		VARIABLE_ORACLE_PASSWORD	=		"ORACLE_PASSWORD";
	
	public static final String 		VARIABLE_MONGO_SERVER_NAME	=		"MONGO_SERVER_NAME";
	public static final String 		VARIABLE_MONGO_DB_NAME		=		"MONGO_DB_NAME";
	public static final String 		VARIABLE_MONGO_USER			=		"MONGO_USER";
	public static final String 		VARIABLE_MONGO_PASSWORD		=		"MONGO_PASSWORD";
	
	//File names
	public static final String		FILE_TYPE_CONFIG			=		"config";
	public static final String		CONFIG_FILE_NAME			=		"config.properties";
	public static final String		DATABASE_FILE				=		"database";
	public static final String		FILE_TYPE_DATABASE			=		"database.properties";
	
	//Config final String values of Website
	public static String			WEBSITE_URL;
	public static String			AUTOMATION_ID;
	
	//Config final String values of properties file settings
	public static String			FILE_UTIL_URL;
	public static String			FILE_TEST_URL;
	
	//Config final String values of Database connection
	public static final String		DB_MYSQL			=		"mysql";
	public static final String		DB_ORACLE			=		"oracle";
	public static final String		DB_MONGO			=		"mongo";
	
	//MYSQL SETTINGS
	public static final String		DATABASE_MYSQL				=	"MYSQL";
	
	//ORACLE SETTINGS
	public static final String		DATABASE_ORACLE				=	"ORACLE";
	
	//MONGODB SETTINGS
	public static final String		DATABASE_MONGO				=	"MONGO";
	
	//Database settings
	public static final String		SERVER_PROPERTY_NAME			=	"SERVER_NAME";
	public static final String		DB_NAME_PROPERTY_NAME			=	"DB_NAME";
	public static final String		USER_PROPERTY_NAME				=	"USER";
	public static final String		PASSWORD_PROPERTY_NAME			=	"PASSWORD";
	
	public static String			DATABASE;
	
	public static String			DB_SERVER_NAME;
	public static String			DB_NAME;
	public static String			DB_USERNAME;
	public static String			DB_PASSWORD;
	
	//Browser settings
	public static String			BROWSER;
	public static String			USE_DEFAULT_DRIVER_LOCATION;
	public static String			DRIVER_LOCATION;
	
	public static String			DRIVER_CHROME_EXE_NAME;
	public static String			DRIVER_CHROME_NAME;
	
	public static String			DRIVER_EDGE_EXE_NAME;
	public static String			DRIVER_EDGE_NAME;
	
	public static String			DRIVER_FIREFOX_EXE_NAME;
	public static String			DRIVER_FIREFOX_NAME;
	
	public static String			DRIVER_IE_EXE_NAME;
	public static String			DRIVER_IE_NAME;
	
	
	static String result = "";
	static InputStream inputStream;
	static FileOutputStream out;
	private static Scanner sc;
	
	static File file;
	
	public static void loadConfigProperties() {
		WEBSITE_URL			=		getProperty("WEBSITE_URL", FILE_TYPE_CONFIG);
		AUTOMATION_ID		=		getProperty("AUTOMATION_ID", FILE_TYPE_CONFIG);
		
		//Config final String values of properties file settings
		FILE_UTIL_URL		=		getProperty("FILE_UTIL_URL", FILE_TYPE_CONFIG);
		FILE_TEST_URL		=		getProperty("FILE_TEST_URL", FILE_TYPE_CONFIG);
		
		BROWSER					=		getProperty("BROWSER", FILE_TYPE_CONFIG);
		USE_DEFAULT_DRIVER_LOCATION		=		getProperty("USE_DEFAULT_DRIVER_LOCATION", FILE_TYPE_CONFIG);
		
		if(USE_DEFAULT_DRIVER_LOCATION.equals("true")) {
			DRIVER_LOCATION			=		getProperty("DEFAULT_DRIVER_LOCATION", FILE_TYPE_CONFIG);
		}else {
			DRIVER_LOCATION			=		getProperty("DRIVER_LOCATION", FILE_TYPE_CONFIG);
		}
		
		
		DRIVER_CHROME_EXE_NAME	=		getProperty("DRIVER_CHROME_EXE_NAME", FILE_TYPE_CONFIG);
		DRIVER_CHROME_NAME		=		getProperty("DRIVER_CHROME_NAME", FILE_TYPE_CONFIG);
		
		DRIVER_EDGE_EXE_NAME	=		getProperty("DRIVER_EDGE_EXE_NAME", FILE_TYPE_CONFIG);
		DRIVER_EDGE_NAME		=		getProperty("DRIVER_EDGE_NAME", FILE_TYPE_CONFIG);
		
		DRIVER_FIREFOX_EXE_NAME	=		getProperty("DRIVER_FIREFOX_EXE_NAME", FILE_TYPE_CONFIG);
		DRIVER_FIREFOX_NAME		=		getProperty("DRIVER_FIREFOX_NAME", FILE_TYPE_CONFIG);
	
		DRIVER_IE_EXE_NAME		=		getProperty("DRIVER_IE_EXE_NAME", FILE_TYPE_CONFIG);
		DRIVER_IE_NAME			=		getProperty("DRIVER_IE_NAME", FILE_TYPE_CONFIG);
		
		DATABASE			=		getProperty("DATABASE", FILE_TYPE_CONFIG);
		
		DB_SERVER_NAME		=		getDatabaseCredentials(SERVER_PROPERTY_NAME, FILE_TYPE_CONFIG, DATABASE);
		DB_NAME				=		getDatabaseCredentials(DB_NAME_PROPERTY_NAME, FILE_TYPE_CONFIG, DATABASE);
		DB_USERNAME			=		getDatabaseCredentials(USER_PROPERTY_NAME, FILE_TYPE_CONFIG, DATABASE);
		DB_PASSWORD			=		getDatabaseCredentials(PASSWORD_PROPERTY_NAME, FILE_TYPE_CONFIG, DATABASE);
	}
	
	public static String getProperty(String propertyName, String fileName) {
		 
		try {
			PropertiesConfiguration config = new PropertiesConfiguration(System.getProperty("user.dir") + "/resources/" + fileName + ".properties");
 
			// get the property value and print it out
			result = config.getString(propertyName);
			//System.out.println("Reading[" +propertyName+ "]: " + result);
			Logger.log("Reading " +propertyName+ " : " + result);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
			Logger.logError(e.toString());
		}
		return result;
	}
	
	
	public static boolean setProperty(String propertyName, String propertyValue, String fileName) throws IOException {
		boolean updated = false;
		try{
			PropertiesConfiguration config = new PropertiesConfiguration(System.getProperty("user.dir") + "/resources/" + fileName + ".properties");
			config.setProperty(propertyName, propertyValue);
			config.save();
			
			//Allow System Hard Drive to write the new value
			//Platform.sleep(Platform.FIVE_SECONDS);
			
			//Read the updated value
			if(config.getString(propertyName).equals(propertyValue)) {
				updated = true;
				Logger.log("Property\t" + propertyName + " has been successfully update with the value: " + propertyValue);
			}else {
				Logger.log("Could not update Property\t" + propertyName);
			}	
		}catch (Exception e) {
			Logger.logError("Exception\n" + e);
		}
		
		return updated;
	}
	
	
	public static void saveProperties(Properties p) throws IOException
    {
        FileOutputStream fr = new FileOutputStream(file);
        p.store(fr, "Properties");
        fr.close();
        System.out.println("After saving properties: " + p);
    }
	
	//Get databaseCredentials
	public static String getDatabaseCredentials(String propertyName, String fileName, String database) {
		String result = null;
		
		if(DATABASE.equals(DB_MYSQL)) {
			//LOAD MYSQL DATABASE SETTINGS
			result = getProperty(DATABASE_MYSQL + "_" + propertyName, fileName);
		}else if(DATABASE.equals(DB_ORACLE)) {
			//LOAD ORACLE DATABASE SETTINGS
			result = getProperty(DATABASE_ORACLE + "_" + propertyName, fileName);
		}else if(DATABASE.equals(DB_MONGO)) {
			//LOAD MONGO DATABASE SETTINGS
			result = getProperty(DATABASE_MONGO + "_" + propertyName, fileName);
		}else {
			//LOAD MYSQL BY DEFAULT
			result = getProperty(DB_MYSQL + "_" + propertyName, fileName);
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
	public static void configFileSetup() {
		try {
			sc = new Scanner(System.in);
			Help.print("\nYou can manually enter configuration, in doing so it will override the default values in .properties file!\nAre you sure you want to override\nEnter Y/N: ");
	        String user_input = sc.nextLine();

	        if(user_input.toLowerCase().equals("y")){
	            //Prompt user for Website URL
	            Help.print("Enter Website URL:");
	            user_input = sc.nextLine();
	            //Update the property file with the new URL
	            Property.setProperty("WEBSITE_URL", user_input, Property.FILE_TYPE_CONFIG);

	            //Prompt user for Automation id
	            Help.print("Enter automation ID: ");
	            user_input = sc.nextLine();
	            //Update the property file with the new automation ID
	            Property.setProperty(Property.VARIABLE_AUTOMATION_ID, user_input, Property.FILE_TYPE_CONFIG);
	            
	            //Prompt user for database configuration choice
	            Help.print("Would you like to alter database configurations?\nEnter Y/N:");
	            user_input = sc.nextLine();
	            if(user_input.toLowerCase().equals("y")) {
	            	//Prompt user for database configuration
	                Help.print("Which database would you like to use?\nOption 1: mysql\nOption 2: oracle\nOption 3: mongo\nEnter choice:");
	                user_input = sc.nextLine();
	                String database = Property.DATABASE_MYSQL;
	                switch(user_input) {
		                case "1":
		                	// Set database to mysql
		                	database = Property.DATABASE_MYSQL;
		                  break;
		                case "2":
		                	// Set database to oracle
		                	database = Property.DATABASE_ORACLE;
		                  break;
		                case "3":
		                	// Set database to mongo
		                	database = Property.DATABASE_MONGO;
		                default:
		                	// Set default database to mysql
		                	database = Property.DATABASE_MYSQL;
		                	break;
		            }
	                Property.setProperty(Property.VARIABLE_DATABASE, database, Property.FILE_TYPE_CONFIG);
	                
	                System.out.println("Database is use: " + database);
	                
	                //Prompt user for database server name
	                Help.print("What is the " + database + " server address?\nEnter server address:");
	                user_input = sc.nextLine();
	                switch(database) {
	                	case Property.DATABASE_MYSQL:
	                		// Set MySQL server name
	                		Property.setProperty(Property.VARIABLE_MYSQL_SERVER_NAME, user_input, Property.FILE_TYPE_CONFIG);
	                		break;
	                	case Property.DATABASE_ORACLE:
	                		// Set Oracle server name
	                		Property.setProperty(Property.VARIABLE_ORACLE_SERVER_NAME, user_input, Property.FILE_TYPE_CONFIG);
	                		break;
	                	case Property.DATABASE_MONGO:
	                		// Set Mongo server name
	                		Property.setProperty(Property.VARIABLE_MONGO_SERVER_NAME, user_input, Property.FILE_TYPE_CONFIG);
	                		break;
	                	default:
	                		// Set default to MySQL server name
	                		Property.setProperty(Property.VARIABLE_MYSQL_SERVER_NAME, user_input, Property.FILE_TYPE_CONFIG);
	                		break;
	                }
	                
	                //Prompt user for database server name
	                Help.print("What is the " + database + " database name?\nEnter database name:");
	                user_input = sc.nextLine();
	                switch(database) {
	                	case Property.DATABASE_MYSQL:
	                		// Set MySQL server name
	                		Property.setProperty(Property.VARIABLE_MYSQL_DB_NAME, user_input, Property.FILE_TYPE_CONFIG);
	                		break;
	                	case Property.DATABASE_ORACLE:
	                		// Set Oracle server name
	                		Property.setProperty(Property.VARIABLE_ORACLE_DB_NAME, user_input, Property.FILE_TYPE_CONFIG);
	                		break;
	                	case Property.DATABASE_MONGO:
	                		// Set Mongo server name
	                		Property.setProperty(Property.VARIABLE_MONGO_DB_NAME, user_input, Property.FILE_TYPE_CONFIG);
	                		break;
	                	default:
	                		// Set default to MySQL server name
	                		Property.setProperty(Property.VARIABLE_MYSQL_DB_NAME, user_input, Property.FILE_TYPE_CONFIG);
	                		break;
	                }
	                
	                //Prompt user for database username
	                Help.print("What is the " + database + " username?\nEnter database username:");
	                user_input = sc.nextLine();
	                switch(database) {
	                	case Property.DATABASE_MYSQL:
	                		// Set MySQL server name
	                		Property.setProperty(Property.VARIABLE_MYSQL_USER, user_input, Property.FILE_TYPE_CONFIG);
	                		break;
	                	case Property.DATABASE_ORACLE:
	                		// Set Oracle server name
	                		Property.setProperty(Property.VARIABLE_ORACLE_USER, user_input, Property.FILE_TYPE_CONFIG);
	                		break;
	                	case Property.DATABASE_MONGO:
	                		// Set Mongo server name
	                		Property.setProperty(Property.VARIABLE_MONGO_USER, user_input, Property.FILE_TYPE_CONFIG);
	                		break;
	                	default:
	                		// Set default to MySQL server name
	                		Property.setProperty(Property.VARIABLE_MYSQL_USER, user_input, Property.FILE_TYPE_CONFIG);
	                		break;
	                }
	                
	                //Prompt user for database password
	                Help.print("What is the " + database + " password?\nEnter database password:");
	                user_input = sc.nextLine();
	                switch(database) {
	                	case Property.DATABASE_MYSQL:
	                		// Set MySQL server name
	                		Property.setProperty(Property.VARIABLE_MYSQL_PASSWORD, user_input, Property.FILE_TYPE_CONFIG);
	                		break;
	                	case Property.DATABASE_ORACLE:
	                		// Set Oracle server name
	                		Property.setProperty(Property.VARIABLE_ORACLE_PASSWORD, user_input, Property.FILE_TYPE_CONFIG);
	                		break;
	                	case Property.DATABASE_MONGO:
	                		// Set Mongo server name
	                		Property.setProperty(Property.VARIABLE_MONGO_PASSWORD, user_input, Property.FILE_TYPE_CONFIG);
	                		break;
	                	default:
	                		// Set default to MySQL server name
	                		Property.setProperty(Property.VARIABLE_MYSQL_PASSWORD, user_input, Property.FILE_TYPE_CONFIG);
	                		break;
	                }
	            }
	        }
		}catch(Exception ex) {
			Help.print(Logger.formatErrorLog(ex.toString()));
		}
	}

}
