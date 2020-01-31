package com.k00217982.fyp.helper;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.k00217982.fyp.read.ReadFile;

public class Browser {
	
	public static String url;
	
	static WebDriver driver;
	
	public static void initWebDriver() {
		String system_root = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", system_root + "\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		Logger.log("Starting chrome browser");
		driver.manage().window().maximize();
		Logger.log("Maximizing browser");
		Platform.sleep(Platform.SHORT_TIME);
	}
	
	public static WebDriver getWebDriver() {
		return driver;
	}
	
	public static void shutDownDriver() {
		Logger.log("Shutting down driver");
		driver.quit();
	}
	
	
	public static String getWebsiteUrl() throws IOException {
		return ReadFile.getPropValues("WEBSITE_URL");
	}
	
	public static String getProperty(String property) throws IOException {
		return ReadFile.getPropValues(property);
	}
}
