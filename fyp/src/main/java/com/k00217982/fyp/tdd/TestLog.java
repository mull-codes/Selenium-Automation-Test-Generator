package com.k00217982.fyp.tdd;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.k00217982.fyp.config.Property;
import com.k00217982.fyp.helper.Help;
import com.k00217982.fyp.helper.Logger;

@DisplayName("Test Logger")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestLog {
	
	
	@BeforeAll
    public static void setupJUnitTests() {
		//Clear log
    	Logger.clearLogResource();
    	//Create a new script
        Logger.LogScript("Test Logger", "Nazmul Hasan", "tdd");
        //Prompt user for config.properties setup
        Property.configFileSetup();
    }

	//Test code to check if date format is working
	@Test
	@DisplayName("Test Date Format")
    @Order(1)
	public void A_testDateFormat(){
		Logger.logInfo("Test Date Format");
		
		//Create date
		Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");  
        String expected = formatter.format(date);
        String actual = Logger.getDateOnly();
        
        Logger.logInfo("Expected: " + expected + ", Actual: " + actual);
        
        assertEquals(expected, actual);
        
	}
	
	//Test file name formatting success
	@Test
	@DisplayName("Test File Name Format")
    @Order(2)
	public void B_testFileNameFormatting(){
		Logger.logInfo("Test File Name Format");
		
		//This should be the file format
		Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy-hh#mm#ss");  
        String strFileDateFormat = formatter.format(date);
        
        String fileType = "log";
        //File naming formatted version
        String expected = fileType + "_" + strFileDateFormat + ".txt";
        String actual = Logger.createFileName(fileType);
        
        Logger.logInfo("Expected: " + expected + ", Actual: " + actual);
        
        assertEquals(expected, actual); 
	}
	
	
	//Test file name formatting, expected false
	@Test
	@DisplayName("Test File Name Format Fail")
    @Order(3)
	public void C_testFileNameFormattingFail(){
		Logger.logInfo("Test File Name Format Fail");
		
		//This should be the file format
		Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy-hh-mm-ss");  
        String strFileDateFormat = formatter.format(date);
        
        String fileType = "log";
        //File naming formatted version, incorrect data
        String expected = fileType + "_" + strFileDateFormat + ".properties";
        
        String actual = Logger.createFileName(fileType);
        
        Logger.logInfo("Expected: " + expected + ", Actual: " + actual);
        
        assertFalse(expected.equals(actual));
	}
	
	
	//Test file name, first word, Scraped link text may contain multiple words
	@Test
	@DisplayName("Test Get First Word")
    @Order(4)
	public void D_testGetFirstWord(){
		Logger.logInfo("Test Get First Word");
		
		//Link text from a web page
		String linkText = "About Us";
		//Get the first word
		String splitWord[] = linkText.split(" ", 2);
		String expected = splitWord[0];
		
		String actual = Help.getWord(linkText, 0);
		
		Logger.logInfo("Expected: " + expected + ", Actual: " + actual);
		
		//Test to see if the first word returned by Help class is same as the one we are expecting
		//splitWord[0] is the expected word
		assertEquals(expected, actual);
	}
	
	//Test if file name contains (- hyphen), expected false
	@Test
	@DisplayName("Test File Name Contains Hyphen")
    @Order(5)
	public void E_testFileNameContainsHyphen(){
		Logger.logInfo("Test File Name Contains Hyphe");
		
		//Create fake file name
		String fileName = "file-name after space";
		
		//Get actual file name after formatting file name
		String actual = Help.formatClassName(fileName);
		
		assertFalse(actual.contains("-"));
	}
	
	
	//Test if file name contains (" " space), expected false
	@Test
	@DisplayName("Test File Name Contains Space")
    @Order(6)
	public void F_testFileNameContainsSpace(){
		Logger.logInfo("Test File Name Contains Space");
		
		//Create fake file name
		String fileName = "file-name after space";
		
		//Get actual file name after formatting file name
		String actual = Help.formatClassName(fileName);
		
		assertFalse(actual.contains(" "));
	}
	
	//Test if file name has correct format
	@Test
	@DisplayName("Test File Name With Spaces")
    @Order(7)
	public void G_testFileName(){
		Logger.logInfo("Test File Name With Spaces");
		
		//Create fake file name
		String fileName = "file-name after space";
		
		//After formatting the file name Help class should return -> file_name_after_space
		String expected = "file_name_after_space";
		//Get actual file name after formatting file name
		String actual = Help.formatClassName(fileName);
		
		Logger.logInfo("Expected: " + expected + ", Actual: " + actual);
		
		assertEquals(expected, actual);
	}
	
	
	@AfterAll
    public static void tearDown() {
        Logger.logInfo("Test Complete");
        Logger.logEndOfScript("Test Logger");
    }

}
