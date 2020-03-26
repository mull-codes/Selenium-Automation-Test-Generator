package com.k00217982.fyp.helper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.k00217982.fyp.config.Property;


public class Logger {
	public static String FILE_LOCATION;
	public static String FILE_NAME;
	public static File file;
	private static Scanner sc;
	
	
	/**
    * Initialises file and logs script name
    *
    * @param	String name		:	name of the script
    * @param	String author	:	author of the script file / code 
    * @param	String type		:	type of file to create, possible values [scraping, log, test]
    * 
    * @author	Nazmul Hasan
    * @return	void
    */
	public static void LogScript(String name, String author, String type) {
		//Get the file location from Property
		FILE_LOCATION = getLogFilePath();
		
		//FILE_NAME = type + "_" + getDateFormatFileName() + ".txt";
		FILE_NAME = createFileName(type);
		
		//Initialize a new file object
		file = new File(FILE_LOCATION + "/" + FILE_NAME);
		//Finally create the log file and save it
		CreateLog(ScriptNameFormatter(name, author));
	}
	
	
	public static void clearLogResource() {
		try {
			sc = new Scanner(System.in);
			//Prompt user for clear log
	    	Help.print("Would you like to clear log directory?\nEnter Y/N: ");
	    	String clear_directory_choice = sc.nextLine();
	    	//Check user's choice for clear log directory
	    	if(clear_directory_choice.toLowerCase().equals("y")) {
	    		clearLogs();
	    	}
		}catch(Exception ex) {
			Help.print(formatErrorLog(ex.toString()));
		}
	}
	
	public static String getLogFilePath() {
		String projectPath = System.getProperty("user.dir");
		return projectPath + "/logs";
	}
	
	public static boolean clearLogs() {
		//Check to see if folder is already empty, if so no need to execute further code
		if( !isLogEmpty() ) {
			//Folder is not empty we can go ahead and delete all contents
			File directory = new File(getLogFilePath());
			File[] contents = directory.listFiles();
			for (File f: contents) f.delete();
			System.out.println("Log directory has been emptied successfully!");
		}
		
		//Check to see if the folder is empty then return true else return false
		return isLogEmpty();
	}
	
	public static boolean isLogEmpty() {
		boolean isDrEmpty = false;
		File directory = new File(getLogFilePath());
		File[] contents = directory.listFiles();
		// the directory file is not really a directory..
		if (contents == null) {
			isDrEmpty = true;
		}
		// Folder is empty
		else if (contents.length == 0) {
			isDrEmpty = true;
			System.out.println("Log directory is empty!");
		}
		return isDrEmpty;
	}
	
	
	//Logs execution by default
	public static void log(String s) {
		Append(formatLogText(s));
		Help.print(formatLogText(s));
	}
	//Logs information
	public static void logInfo(String s) {
		Append(formatInfoText(s));
		Help.print(formatInfoText(s));
	}
	//Logs information, however TAG attribute override the [info] string
	public static void logInfo(String s, String TAG) {
		Append(formatInfoText(s, TAG));
		Help.print(formatInfoText(s, TAG));
	}
	//Logs errors
	public static void logError(String s) {
		Append(formatErrorLog(s));
		Help.print(formatErrorLog(s));
		//System.out.print(ANSI_RED + "" + s + "" + ANSI_RESET);
	}
	//Logs end of a script
	public static void logEndOfScript(String scriptName) {
		Append(ScriptEndFormatter(scriptName));
		Help.print(ScriptEndFormatter(scriptName));
	}
	
	
	public static void Append(String s) {
        //Create the file
        if (file.exists()){
        	try {
            	//Write Content
                FileWriter writer = new FileWriter(file, true);
                writer.write(s);
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else{
            try {
            	//Write Content
                FileWriter writer = new FileWriter(file);
                writer.write(s);
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
	
	public static void CreateLog(String s) {
        //Create the file
        if (file.exists()){
        	Help.println("File already exists!");
        }else{
            try {
            	//Write Content
                FileWriter writer = new FileWriter(file);
                writer.write(s);
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
        Help.print(s);
	}
	
	private static String ScriptNameFormatter(String scriptName, String author) {
		String name = "+----------------------------------------+\n"
						+ "Script Name: " + scriptName + "\n"
						+ "Author: " + author + "\n"
						+ "DateTime Started: " + getDateFormat() + "\n"
						+ "+----------------------------------------+\n";
		return name;
	}
	
	//End of script
	private static String ScriptEndFormatter(String scriptName) {
		String name = "+----------------------------------------+\n"
						+ "End of " + scriptName + " script execution\n"
						+ "DateTime Finished: " + getDateFormat() + "\n"
						+ "+----------------------------------------+\n";
		return name;
	}
	
	
	public static String formatErrorLog(String s) {
		s = "Log:[Error]\t" + getDateFormat() + "\t" + s + "\n";
		return s;
	}

	public static String formatLogText(String s) {
		return "Log:[exec]\t" + getDateFormat() + "\t" + s + "\n";
	}
	
	public static String formatInfoText(String s) {
		return "Log:[info]\t" + getDateFormat() + "\t" + s + "\n";
	}
	public static String formatInfoText(String s, String TAG) {
		return "Log:[" + TAG.toLowerCase() + "]\t" + getDateFormat() + "\t" + s + "\n";
	}
	
	public static String getDateFormatFileName() {
		Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy-hh#mm#ss");  
        String strDate = formatter.format(date);
        //Help.println(strDate);
        return strDate;
	}
	
	public static String createFileName(String type){
		if(type.equals("")){
			return "false";
		}else{
			return type + "_" + getDateFormatFileName() + ".txt";
		}
	}
	
	
	public static String getDateFormat() {
		Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy hh:mm:ss");  
        String strDate = formatter.format(date);
        //Help.println(strDate);
        return strDate;
	}
	
	public static String getDateOnly() {
		Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");  
        String strDate = formatter.format(date);
        //Help.println(strDate);
        return strDate;
	}
	
	
	
}
