package com.k00217982.fyp.download.webpage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DownloadWebPage {
	//GLOBAL SETTINGS
	final static String fileLocationUtils = "E://Year-4//Project FYP//fyp//src//main//java//com//k00217982//fyp//website//utils";
	final static String fileLocationTest = "E://Year-4//Project FYP//fyp//src//main//java//com//k00217982//fyp//website//test";
	
	public static void createFileUsingFileClass(String fileName, String sourceCode) throws IOException 
    { 
          File file = new File(fileLocationUtils + "/" + fileName);
  
          //Create the file
          if (file.createNewFile()){
            System.out.println("\nFile is created!");
          }else{
            System.out.println("\nFile already exists.");
          }
           
          //Write Content
          FileWriter writer = new FileWriter(file);
          writer.write(sourceCode);
          writer.close();
    }
}
