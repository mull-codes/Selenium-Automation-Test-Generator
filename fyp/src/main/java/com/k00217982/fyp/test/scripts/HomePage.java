package com.k00217982.fyp.test.scripts;

import org.openqa.selenium.WebDriver;

import com.k00217982.fyp.config.Property;
import com.k00217982.fyp.helper.Browser;
import com.k00217982.fyp.helper.Logger;
import com.k00217982.fyp.helper.Platform;
import com.k00217982.fyp.test.utils.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("HomePage")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HomePage {
	
	static WebDriver driver;
	static String pageTitle;
	static String scriptName = "Home Script";
	static String author = "K00217982";
	
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
        	ex.printStackTrace();
        }
    }

    @Test
    @DisplayName("First Header")
    @Order(1)
    public void home() {
      try {
	      
    	  String expectedResult = "Lorem Ipsum Dolar Soleh 1";

    	  Platform.sleep(Platform.FIVE_SECONDS);
	      
	      String actualResult = TestElement.ArticleOneHeader(driver).getText();
	      
	      
	      assertEquals(expectedResult, actualResult);
	      
	      Platform.sleep(Platform.THREE_SECONDS);
	      
	  }catch(Exception ex) {
		  ex.printStackTrace();
	  }
    }
    
    @AfterAll
    public static void tearDown() {
        try {
        	Browser.shutDownDriver(scriptName);
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
    }

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
//		
//		WebDriver driver = new ChromeDriver();
//        //WebDriverWait wait = new WebDriverWait(driver, 10);
//		driver.manage().window().maximize();
//		Platform.sleep(Platform.SHORT_TIME);
//        
//        try {
//            driver.get("http://localhost/fyp/");
//            
//            Platform.sleep(Platform.MED_TIME);
//            
//            String firstHeader = Test.ArticleOneHeader(driver).getText();
//            
//            System.out.println(firstHeader);
//            
//            Platform.sleep(Platform.SHORT_TIME);
//            //Help.println(Home.btnContact(driver).getText());
//            //Help.println(Home.btnContact(driver).getAttribute("href"));
//            
//            //Home.btnContact(driver).click();
//            
//            Platform.sleep(Platform.LONG_TIME);
//            
//        } finally {
//            driver.quit();
//        } 
//	}
	
	

}
