package com.k00217982.fyp.website.scripts;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.k00217982.fyp.helper.Browser;
import com.k00217982.fyp.helper.Help;
import com.k00217982.fyp.helper.Logger;
import com.k00217982.fyp.helper.Platform;
import static com.k00217982.fyp.helper.Assert.assertEquals;

import com.k00217982.fyp.website.utils.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//@RunWith(JUnit4.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HomePage {
	
	static WebDriver driver;
	static String pageTitle;
	
	@BeforeClass
    public static void startBrowser() {
        Logger.LogScript("Home Script", "K00217982", "log");
        try {
        	Browser.initWebDriver();
            driver = Browser.getWebDriver();
            
            driver.get(Browser.getWebsiteUrl());
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
    }

    @Test
    @Order(1)
    public void home() {
      try {
	      
    	  pageTitle = driver.getTitle();
	      
    	  Platform.sleep(Platform.LONG_TIME);
    	  if(pageTitle.contains("Home")) {
    		  Home.btnHome(driver).click();
    	  }else if(pageTitle.contains("About")) {
    		  About_Us.btnHome(driver).click();
    	  }else if(pageTitle.contains("Contact")) {
    		  //TODO
    	  }else {
    		  //TODO
    	  }
    	  
    	  Platform.sleep(Platform.MED_TIME);
	      
	      String firstHeader = TestElement.ArticleOneHeader(driver).getText();
	      
	      System.out.println(firstHeader);
	      
	      assertEquals(firstHeader, "Lorem Ipsum Dolar Soleh 1");
	      
	      Platform.sleep(Platform.SHORT_TIME);
	      //Help.println(Home.btnContact(driver).getText());
	      //Help.println(Home.btnContact(driver).getAttribute("href"));
	      
	      //Home.btnContact(driver).click();
	      
	      Platform.sleep(Platform.LONG_TIME);
	      
	  }catch(Exception ex) {
		  ex.printStackTrace();
	  }
    }
    
    @Test
    @Order(2)
    public void visit_about() {
      try {
    	  pageTitle = driver.getTitle();
    	  
    	  Platform.sleep(Platform.LONG_TIME);
    	  if(pageTitle.contains("Home")) {
    		  Home.btnAbout(driver).click();;
    	  }else if(pageTitle.contains("About")) {
    		  About_Us.btnAbout(driver).click();
    	  }else if(pageTitle.contains("Contact")) {
    		  //TODO
    	  }else {
    		  //TODO
    	  }
    	  Platform.sleep(Platform.MED_TIME);
    	  assertEquals(About_Us.btnAbout(driver).getText().toString(), "About Usss");
    	  
	      
	  }catch(Exception ex) {
		  ex.printStackTrace();
	  }
    }

    @AfterClass
    public static void tearDown() {
        try {
        	Browser.shutDownDriver();
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
