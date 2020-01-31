package com.k00217982.fyp.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Platform {
	//LONG_TIME = 1 minute
	public static long LONG_TIME = 6000;
	//MED_TIME = 30 seconds
	public static long MED_TIME = 3000;
	//SHORT_TIME = 15 seconds
	public static long SHORT_TIME = 1500;
	
	
	
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
