package com.k00217982.fyp.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Platform {
	//LONG_TIME = 1 minute
	public static final long LONG_TIME = 60000;
	//MED_TIME = 30 seconds
	public static final long MED_TIME = 30000;
	//SHORT_TIME = 15 seconds
	public static final long SHORT_TIME = 15000;
	//ONE SECONDS
	public static final long ONE_SECONDS = 1000;
	//TWO SECONDS
	public static final long TWO_SECONDS = 1000;
	//THREE SECONDS
	public static final long THREE_SECONDS = 1000;
	//FOUR SECONDS
	public static final long FOUR_SECONDS = 1000;
	//FIVE SECONDS
	public static final long FIVE_SECONDS = 1000;
	
	
	/**
	 * Puts the thread to sleep for x amount of time in seconds
	 * Converts the milliseconds into seconds
	 * use final variables from Platform.class instead of passing your own milliseconds
	 * 
	 * @param long time : this is the time in milliseconds
	 * @return void
	 * @author Nazmul Hasan
	*/
	public static void sleep(long time) {
		try {
			Logger.log("Platform sleeping for " + (time / 1000) + " seconds");
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



