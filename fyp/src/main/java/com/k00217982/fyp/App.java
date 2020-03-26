package com.k00217982.fyp;

//Imports
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

import com.k00217982.fyp.config.Property;
import com.k00217982.fyp.helper.*;
import com.k00217982.fyp.write.CreateFile;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;



public class App {
    private static Document document;
    private static String utilFileLocation, testFileLocation, className;
    //private static List<String> hrefList, hrefListCompare;

    

    //private static Map<String, String> hrefLinks = new HashMap<String, String>();
    //private static List<String> alreadyScrapedLinks = new ArrayList<String>();
    
    private static List<Links> hrefLinks = new CopyOnWriteArrayList<Links>();
	
    public static void main( String[] args ) throws IOException{
    	
    	
    	
    	String projectPath = System.getProperty("user.dir");
    	
    	//Clear log
    	Logger.clearLogResource();
    	
    	//Create new script
    	String scriptName = "WEBSITE SCRAPING";
    	Logger.LogScript(scriptName, "K00217982", "scraping");
    	
    	//Property configurations
    	Property.configFileSetup();
    	
        //Load all variables from config.properties
    	Property.loadConfigProperties();
		
    	utilFileLocation = projectPath + "/" + Property.FILE_UTIL_URL;
    	testFileLocation = projectPath + "/" + Property.FILE_TEST_URL;
    	

    	final String IMPORTS = "import org.openqa.selenium.By;\r\n" + 
    			"import org.openqa.selenium.WebDriver;\r\n" + 
    			"import org.openqa.selenium.WebElement;";
    	String packageName = "package com.k00217982.fyp.test.utils;\n\n" + IMPORTS;
    	String sourceCodeStart = null;
    	String sourceCodeEnd = "\n}";
    	
    	try {
    		
    		//Get all links for the base url
    		document = Jsoup.connect(Property.WEBSITE_URL).get();
    		
    		//Add all links
    		//WebPage.getAllLinks(document, true) will remove any duplicate in the list and return a clean list
    		hrefLinks.addAll(WebPage.getAllLinks(document, true));

            for(Links link : hrefLinks) {
                StringBuilder newSource = new StringBuilder();
                
                String scrape_url = link.getValue();
                
                if(!link.isUsed()) {
                	link.setUsed(true);
                	//Get key and replace spaces, dashes with underline
                    className = Help.formatClassName(link.getKey());

                    sourceCodeStart = packageName + "\n"
                                    + "\n\npublic class " + className +  " {\n";
                    
                    
                    Logger.log("Scraping the web document from: " + scrape_url);
                    
                    //Scrape document for the list being iterated
                    Document theDocument = Jsoup.connect(scrape_url).get();
                    
                    //Log document title being scraped
                    String documentLog = "\n+---------------------------------------------------------+\n"
                    		+ "Document Scraping:" + theDocument.title() + "\n"
                    		+ "URL:" + theDocument.baseUri() + "\n"
                    		+ "+---------------------------------------------------------+";
                    Logger.logInfo(documentLog);
                    
                    //Scrape document to generate object methods
                    //Scrape links
                    newSource.append(WebPage.ScrapeLinks(theDocument));
                    //Scrape forms
                    newSource.append(WebPage.ScrapeInputs(theDocument));
                    //Scrape tables
                    newSource.append(WebPage.ScrapeTable(theDocument));
                    
                    String sourceCode = sourceCodeStart + "" + newSource + "" + sourceCodeEnd;
                    Logger.log("Building WebElement object methods completed");
                    
                    //Create a new file
                    CreateFile.createFileUsingFileClass(utilFileLocation, className + ".java", sourceCode);
                    //Log the file that was just created
                    Logger.log(className + ".java created successfully!\n\n");
                            
					///////////////////////////////////////////////////////////////////////
					// TEST SCRIPT
					///////////////////////////////////////////////////////////////////////
					//String builder for Script testing
					StringBuilder scriptSource = new StringBuilder();
					//Set script class name
					String scriptClassName = className + "Test";
					//IMPORTS FOR SCRIPT
					scriptSource.append("package com.k00217982.fyp.test.scripts;\r\n" + 
					"\r\n" + 
					"import org.openqa.selenium.WebDriver;\r\n" + 
					"\r\n" + 
					"import com.k00217982.fyp.config.Property;\r\n" + 
					"import com.k00217982.fyp.helper.Browser;\r\n" + 
					"import com.k00217982.fyp.helper.Logger;\r\n" + 
					"import com.k00217982.fyp.helper.Platform;\r\n" + 
					"import com.k00217982.fyp.test.utils.*;\r\n" + 
					"\r\n" + 
					"import org.junit.jupiter.api.*;\r\n" + 
					"import static org.junit.jupiter.api.Assertions.assertEquals;\r\n");
					//Script class opening
					scriptSource.append("@DisplayName(\""+scriptClassName+"\")\r\n" + 
					"@TestMethodOrder(MethodOrderer.OrderAnnotation.class)\r\n" + 
					"public class " + scriptClassName + " {\r\n");
					
					//Script test variables
					scriptSource.append("\tstatic WebDriver driver;\r\n" + 
							"\tstatic String pageTitle;\r\n" + 
							"\tstatic String scriptName = \"" + scriptClassName + "\";\r\n" +
							"\t//Automated Test Generator for Web Application (ATGWA)\r\n" +
							"\tstatic String author = \"ATGWA\";\r\n");
					
					//Script test @BeforeAll
					scriptSource.append("\t@BeforeAll\r\n" + 
							"\tpublic static void startBrowser() {\r\n" + 
							"\t\t\t\r\n" + 
							"\t\t\tLogger.LogScript(scriptName, author, \"log\");\r\n" + 
							"\t\t\t\t\r\n" + 
							"\t\t\t//Load all variables from config.properties\r\n" + 
							"\t\t\t//Load Configurations must be called after Logger.logScript()\r\n" + 
							"\t\t\tProperty.loadConfigProperties();\r\n" + 
							"\t\t\t\t\r\n" + 
							"\t\t\t\ttry {\r\n" + 
							"\t\t\t\tBrowser.initWebDriver();\r\n" + 
							"\t\t\t\t\tdriver = Browser.getWebDriver();\r\n" + 
							"\t\t\t\t\t\r\n" + 
							"\t\t\t\t\t\tdriver.get(Browser.getWebsiteUrl());\r\n" + 
							"\t\t\t\t}catch(Exception ex) {\r\n" + 
							"\t\t\t\t\tLogger.logError(ex.toString());\r\n" + 
							"\t\t\t\t}\r\n" + 
							"\t\t\t}");
					
					//Script test main methods//
					//Test counter
					int testCounter = 1; //Assume the first test case is 1
					//Methods for links
					scriptSource.append(WebPage.createLinkTestMethods(theDocument, testCounter, className, link.getValue()));
					
					//Methods for inputs
					
					//Methods for tables
					
					//Script test @AfterAll
					scriptSource.append("\n\t@AfterAll\r\n" + 
							"    public static void tearDown() {\r\n" + 
							"        try {\r\n" + 
							"        	Browser.shutDownDriver(scriptName);\r\n" + 
							"        }catch(Exception ex) {\r\n" + 
							"        	Logger.logError(ex.toString());\r\n" + 
							"        }\r\n" + 
							"    }\r\n");
					
					//Script class ending
					scriptSource.append("}");
					
					//Create a new file
                    CreateFile.createFileUsingFileClass(testFileLocation, scriptClassName + ".java", scriptSource.toString());
                    //Log the JUnit test file which was just created
                    Logger.log(className + ".java created successfully!\n\n");
					///////////////////////////////////////////////////////////////////////
					

                }else {
                	Logger.logInfo("URL: " + scrape_url + " already been scraped!", "WARNING");
                }
            }
            //HomePage.main(null);
    	
        } catch (IOException e) {
        	Help.print("Error, could not parse document!");
        	e.printStackTrace();
        }
    	
    	
    	//End of scraping
    	Logger.logEndOfScript(scriptName);
    }
    
    
    

    
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    //GENERATE TEST FILES
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    //Prepare code for JUnit Script
//    public static StringBuilder getSQLSourceCode() {
//    	StringBuilder sqlSourceCode = new StringBuilder();
//    	sqlSourceCode.append("MySQL mysql = new MySQL(\"localhost\", \"root\", \"\");\r\n" + 
//    			"    	try {\r\n" + 
//    			"			mysql.connect();\r\n" + 
//    			"			String sql = \"SELECT * FROM user\";\r\n" + 
//    			"			List<HashMap<String,Object>> users = mysql.getResults(sql);\r\n" + 
//    			"			//System.out.println(users);\r\n" + 
//    			"		} catch (SQLException e1) {\r\n" + 
//    			"			// TODO Auto-generated catch block\r\n" + 
//    			"			e1.printStackTrace();\r\n" + 
//    			"		}");
//    	return sqlSourceCode;
//    }
//    public static StringBuilder getScriptImports() {
//    	StringBuilder junitImports = new StringBuilder();
//    	junitImports.append("import java.text.SimpleDateFormat;\r\n" + 
//    			"import java.time.LocalDateTime;\r\n" + 
//    			"import java.time.format.DateTimeFormatter;\r\n" + 
//    			"import java.util.Date;\r\n" + 
//    			"\r\n" + 
//    			"import org.junit.After;\r\n" + 
//    			"import org.junit.Before;\r\n" + 
//    			"import org.junit.Test;\r\n" + 
//    			"\r\n" + 
//    			"import org.openqa.selenium.By;\r\n" + 
//    			"import org.openqa.selenium.Keys;\r\n" + 
//    			"import org.openqa.selenium.WebDriver;\r\n" + 
//    			"import org.openqa.selenium.WebElement;\r\n" + 
//    			"import org.openqa.selenium.chrome.ChromeDriver;\r\n" + 
//    			"import org.openqa.selenium.support.ui.WebDriverWait;\r\n" + 
//    			"\r\n" + 
//    			"import com.k00217982.fyp.helper.Browser;\r\n" + 
//    			"import com.k00217982.fyp.helper.Help;\r\n" + 
//    			"import com.k00217982.fyp.helper.Logger;\r\n" + 
//    			"import com.k00217982.fyp.helper.Platform;\r\n" + 
//    			"import static com.k00217982.fyp.helper.Assert.assertEquals;\r\n" + 
//    			"\r\n" + 
//    			"import com.k00217982.fyp.website.utils.*;");
//    	return junitImports;
//    }
//    public static StringBuilder getScriptClassStart(String scriptClassName) {
//    	StringBuilder scriptClassStart = new StringBuilder();
//    	scriptClassStart.append("public class " + scriptClassName + " {");
//    	return scriptClassStart;
//    }
//    public static StringBuilder getTestStart() {
//    	StringBuilder scriptStart = new StringBuilder();
//    	scriptStart.append("WebDriver driver;\r\n" + 
//    			"	\r\n" + 
//    			"	@Before\r\n" + 
//    			"    public void startBrowser() {\r\n" + 
//    			"        Logger.LogScript(\"Home Script\", \"K00217982\", \"log\");\r\n" + 
//    			"        try {\r\n" + 
//    			"        	Browser.initWebDriver();\r\n" + 
//    			"            driver = Browser.getWebDriver();\r\n" + 
//    			"        }catch(Exception ex) {\r\n" + 
//    			"        	ex.printStackTrace();\r\n" + 
//    			"        }\r\n" + 
//    			"    }");
//    	return scriptStart;
//    }
    //Generate Link tests
//    public static StringBuilder generateLinkTest(String functionName, Document theDocument) {
//    	StringBuilder test = new StringBuilder();
//    	test.append("@Test\r\n" + 
//				"    public void " + functionName + "() {\r\n" + 
//				"        try {\r\n");
//    	
//    	//Generate actions for each link
//    	String action = "";
//    	test.append("        	" + action + "();\r\n" );
//    	
//		test.append(	
//				"        }catch(Exception ex) {\r\n" + 
//				"        	ex.printStackTrace();\r\n" + 
//				"        }\r\n" + 
//				"    }\r\n\r\n");
//    	return test;
//    	
//    }
    //Generate form tests
//    public static StringBuilder generateFormTest(String functionName, Document theDocument) {
//    	StringBuilder test = new StringBuilder();
//    	test.append("@Test\r\n" + 
//				"    public void " + functionName + "() {\r\n" + 
//				"        try {\r\n");
//    	
//    	//Generate actions for each form input, including button, followed by comment to expectation
//    	String action = "";
//    	test.append("        	" + action + "();\r\n" );
//    	
//		test.append(	
//				"        }catch(Exception ex) {\r\n" + 
//				"        	ex.printStackTrace();\r\n" + 
//				"        }\r\n" + 
//				"    }\r\n\r\n");
//    	return test;
//    }
    //Generate table tests
//    public static StringBuilder generateTableTest(String functionName, Document theDocument) {
//    	StringBuilder test = new StringBuilder();
//    	test.append("@Test\r\n" + 
//				"    public void " + functionName + "() {\r\n" + 
//				"        try {\r\n");
//    	
//    	//Generate actions for table columns
//    	String columnAction = "";
//    	test.append("        	" + columnAction + "();\r\n" );
//    	//Generate actions for table values
//    	String valueAction = "";
//    	test.append("        	" + valueAction + "();\r\n" );
//    	
//		test.append(	
//				"        }catch(Exception ex) {\r\n" + 
//				"        	ex.printStackTrace();\r\n" + 
//				"        }\r\n" + 
//				"    }\r\n\r\n");
//    	return test;
//    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    //GENERATE END OF TEST FILE
    ///////////////////////////////////////////////////////////////////////////////////////////////////
//    public static StringBuilder getTestEnd() {
//    	StringBuilder scriptEnd = new StringBuilder();
//		scriptEnd.append("@After\r\n" + 
//				"    public void tearDown() {\r\n" + 
//				"        try {\r\n" + 
//				"        	Browser.shutDownDriver();\r\n" + 
//				"        }catch(Exception ex) {\r\n" + 
//				"        	ex.printStackTrace();\r\n" + 
//				"        }\r\n" + 
//				"    }");
//    	return scriptEnd;
//    }
//    public static StringBuilder getScriptClassEnd() {
//    	StringBuilder scriptClassEnd = new StringBuilder();
//    	scriptClassEnd.append("}");
//    	return scriptClassEnd;
//    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    
}
