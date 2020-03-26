package com.k00217982.fyp.helper;

import java.util.Random;

public class Help {
	
	//Shorten System.out.print()
    public static void print(String s) {
    	System.out.print(s);
    }
    //Shorten System.out.println()
    public static void println(String s) {
    	System.out.println(s);
    }
    
    
    public static String getWord(String phrase, int INDEX) {
		String arr[] = phrase.split(" ", 2);
    	return arr[INDEX];
    }
    
    public static String formatClassName(String s) {
    	String formattedName = s.replace("-", "_").replace(" ", "_").replace("(", "").replace(")", "");
    	return formattedName;
    }
    
    public static String sanitiseString(String s) {
    	String formattedName = s.replace("-", "_").replace(" ", "_").replace("(", "").replace(")", "");
    	return formattedName;
    }
    
    public static String generaterandomCharacters(int n) {

    	// chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString();

    }

	public static double getRandomIntegerBetweenRange(double min, double max){
	    double x = (int)(Math.random()*((max-min)+1))+min;
	    return x;
	}
	
	
	public static String capitalize(String str) {
	    if(str == null || str.isEmpty()) {
	        return str;
	    }

	    return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

}
