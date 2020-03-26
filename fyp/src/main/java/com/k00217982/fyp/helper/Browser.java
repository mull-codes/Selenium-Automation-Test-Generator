package com.k00217982.fyp.helper;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.k00217982.fyp.config.Property;
import com.k00217982.fyp.read.ReadFile;

public class Browser {
	
	public static String url;
	
	private static WebDriver driver;
	private static final String DRIVER_CHROME = "chrome";
	private static final String DRIVER_FIREFOX = "firefox";
	private static final String DRIVER_EDGE = "edge";
	//Internet Explorer (IE) has been deprecated, selenium no longer supports IE
	private static final String DRIVER_IE = "ie";
	
	
	/**
	 * initWebDriver() will initialise a new instance of the appropriate web driver
	 * @param none 
	 * @return void
	 * @see https://www.selenium.dev/documentation/en/
	 * @author Nazmul Hasan
	*/
	public static void initWebDriver() {
		String system_root = System.getProperty("user.dir");
		switch(Property.BROWSER) {
			case DRIVER_CHROME:
				//Set the system property to Chrome
				System.setProperty(Property.DRIVER_CHROME_NAME, system_root + Property.DRIVER_LOCATION + Property.DRIVER_CHROME_EXE_NAME);
				//Initialise new Chrome Driver
				driver = new ChromeDriver();
				break;
			case DRIVER_FIREFOX:
				//Set the system property to Firefox
				System.setProperty(Property.DRIVER_FIREFOX_NAME, system_root + Property.DRIVER_LOCATION + Property.DRIVER_FIREFOX_EXE_NAME);
				//Initialise new Firefox Driver
				driver = new FirefoxDriver();
				break;
			case DRIVER_EDGE:
				//Set the system property to Edge
				System.setProperty(Property.DRIVER_EDGE_NAME, system_root + Property.DRIVER_LOCATION + Property.DRIVER_EDGE_EXE_NAME);
				//Initialise new Edge Driver
				driver = new EdgeDriver();
				break;
			//case DRIVER_IE:
				//System.setProperty(Property.DRIVER_IE_NAME, system_root + Property.DRIVER_LOCATION + Property.DRIVER_IE_EXE_NAME);
				//driver = new ChromeDriver();
				//break;
			default:
				//Set the default system property to Chrome
				System.setProperty(Property.DRIVER_CHROME_NAME, system_root + Property.DRIVER_LOCATION + Property.DRIVER_CHROME_EXE_NAME);
				//Initialise new Edge Driver as default
				driver = new ChromeDriver();
				break;
		}
		
		//Log the browser being used
		Logger.logInfo("Starting " + Property.BROWSER.toLowerCase() + " browser");
		//Maximize the browser
		driver.manage().window().maximize();
		Logger.logInfo("Maximizing browser");
		//Put the platform to sleep for 15 seconds
		Platform.sleep(Platform.SHORT_TIME);
	}
	
	public static WebDriver getWebDriver() {
		return driver;
	}
	
	public static void shutDownDriver(String scriptName) {
		Logger.log("Shutting down driver");
		Logger.logEndOfScript(scriptName);
		driver.quit();
	}
	
	
	public static String getWebsiteUrl() throws IOException {
		return ReadFile.getPropValues("WEBSITE_URL");
	}
	
	public static String getProperty(String property) throws IOException {
		return ReadFile.getPropValues(property);
	}
}
