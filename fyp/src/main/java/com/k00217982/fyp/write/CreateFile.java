package com.k00217982.fyp.write;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
	public static void createFileUsingFileClass(String fileLocation, String fileName, String sourceCode) throws IOException { 
          File file = new File(fileLocation + "/" + fileName);
  
          //Create the file
          if (file.createNewFile()){
            //System.out.println("\nFile is created!");
          }else{
            //System.out.println("\nFile already exists.");
          }
           
          //Write Content
          FileWriter writer = new FileWriter(file);
          writer.write(sourceCode);
          writer.close();
    }
}
