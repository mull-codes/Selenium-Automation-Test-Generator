package com.k00217982.fyp.helper;

public class Help {
	
	//Shorten System.out.print()
    public static void print(String s) {
    	System.out.print(s);
    }
    //Shorten System.out.println()
    public static void println(String s) {
    	System.out.println(s);
    }
    
    
    public static String getFirstWord(String phrase, int INDEX) {
		String arr[] = phrase.split(" ", 2);
    	return arr[INDEX];
    }
    
    public static String formatClassName(String s) {
    	String formattedName = s.replace("-", "_").replace(" ", "_");
    	return formattedName;
    }

}
