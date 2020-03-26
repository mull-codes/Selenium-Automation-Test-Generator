package com.k00217982.fyp.test.scripts;

import org.openqa.selenium.WebDriver;

import com.k00217982.fyp.config.Property;
import com.k00217982.fyp.helper.Browser;
import com.k00217982.fyp.helper.Logger;
import com.k00217982.fyp.helper.Platform;
import com.k00217982.fyp.test.utils.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
@DisplayName("Contact_UsTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Contact_UsTest {
	static WebDriver driver;
	static String pageTitle;
	static String scriptName = "Contact_UsTest";
	//Automated Test Generator for Web Application (ATGWA)
	static String author = "ATGWA";
	@BeforeAll
	public static void startBrowser() {
			
			Logger.LogScript(scriptName, author, "log");
				
			//Load all variables from config.properties
			//Load Configurations must be called after Logger.logScript()
			Property.loadConfigProperties();
				
				try {
				Browser.initWebDriver();
					driver = Browser.getWebDriver();
					
						driver.get(Browser.getWebsiteUrl());
				}catch(Exception ex) {
					Logger.logError(ex.toString());
				}
			}
	@Test
	@DisplayName("visit_Search_Table")
	@Order(1)
	public void visit_Search_Table() {
		try {
			String expectedResult = "Test Web Page Search Table";
			Search_Table.link_Btn_search_tableAutomationid(driver).click();
			Logger.logInfo("Navigating to link_Btn_search_tableAutomationid");
			Platform.sleep(Platform.SHORT_TIME);
			String actualResult = driver.getTitle();
			assertEquals(expectedResult, actualResult);
			Contact_Us.link_Btn_about_usAutomationid(driver).click();
			Platform.sleep(Platform.FIVE_SECONDS);
		}catch(Exception ex) {
			Logger.logError(ex.toString());
		}
	}


	@Test
	@DisplayName("visit_About_Us")
	@Order(2)
	public void visit_About_Us() {
		try {
			String expectedResult = "Test Web Page About";
			About_Us.link_Btn_about_usAutomationid(driver).click();
			Logger.logInfo("Navigating to link_Btn_about_usAutomationid");
			Platform.sleep(Platform.SHORT_TIME);
			String actualResult = driver.getTitle();
			assertEquals(expectedResult, actualResult);
			Contact_Us.link_Btn_about_usAutomationid(driver).click();
			Platform.sleep(Platform.FIVE_SECONDS);
		}catch(Exception ex) {
			Logger.logError(ex.toString());
		}
	}


	@AfterAll
    public static void tearDown() {
        try {
        	Browser.shutDownDriver(scriptName);
        }catch(Exception ex) {
        	Logger.logError(ex.toString());
        }
    }
}