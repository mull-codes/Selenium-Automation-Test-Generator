package com.k00217982.fyp.helper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Logger {
	public static String FILE_LOCATION;
	public static String FILE_NAME;
	public static File file;
	
	public static void LogScript(String name, String author, String type) {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Location: " + projectPath);
		FILE_LOCATION = projectPath + "/logs";
		
		FILE_NAME = type + "_" + getDateFormatFileName() + ".txt";
		
		
		file = new File(FILE_LOCATION + "/" + FILE_NAME);
		
		CreateLog(ScriptNameFormatter(name, author));
	}
	
	
	public static void log(String s) {
		Append(formatLogText(s));
		Help.print(formatLogText(s));
	}
	
	
	public static void logInfo(String s) {
		Append(formatInfoText(s));
		Help.print(formatInfoText(s));
	}
	
	
	public static void logInfo(String s, String TAG) {
		Append(formatInfoText(s, TAG));
		Help.print(formatInfoText(s, TAG));
	}
	
	
	public static void logError(String s) {
		Append(formatErrorLog(s));
		Help.print(formatErrorLog(s));
		//System.out.print(ANSI_RED + "" + s + "" + ANSI_RESET);
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
	
	public static String formatErrorLog(String s) {
		s = "Error:\t" + getDateFormat() + "\t" + s + "\n";
		return s;
	}
	
	public static String ScriptNameFormatter(String scriptName, String author) {
		String name = "+----------------------------------------+\n"
						+ "Script Name: " + scriptName + "\n"
						+ "Author: " + author + "\n"
						+ "Date: " + getDateFormat() + "\n"
						+ "+----------------------------------------+\n";
		return name;
	}
	
	
	public static String formatLogText(String s) {
		return "Log:\t" + getDateFormat() + "\t" + s + "\n";
	}
	
	public static String formatInfoText(String s) {
		return "Info:\t" + getDateFormat() + "\t" + s + "\n";
	}
	
	public static String formatInfoText(String s, String TAG) {
		return "" + TAG + ":\t" + getDateFormat() + "\t" + s + "\n";
	}
	
	public static String getDateFormatFileName() {
		Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy-hh-mm-ss");  
        String strDate = formatter.format(date);
        //Help.println(strDate);
        return strDate;
	}
	
	
	public static String getDateFormat() {
		Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy hh:mm:ss");  
        String strDate = formatter.format(date);
        //Help.println(strDate);
        return strDate;
	}
}
