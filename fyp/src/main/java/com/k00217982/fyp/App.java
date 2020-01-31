package com.k00217982.fyp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.k00217982.fyp.cloud.mysqldb.MySQL;
import com.k00217982.fyp.download.webpage.DownloadWebPage;
import com.k00217982.fyp.filehelper.Property;

//Imports

import com.k00217982.fyp.helper.*;
import com.k00217982.fyp.read.ReadFile;
import com.k00217982.fyp.website.scripts.HomePage;
import com.k00217982.fyp.write.CreateFile;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;



public class App 
{
	private static Document document;
	private static String utilFileLocation, testFileLocation, automation_id, url, className;
	private static StringBuilder source, scriptSource;
	private static List<String> hrefList, hrefListCompare;
	
	private static Scanner sc;
	
	private static Map<String, String> hrefLinks = new HashMap<String, String>();
	
    public static void main( String[] args ) throws IOException{
    	
    	sc = new Scanner(System.in);
    	
    	Logger.LogScript("Scraping " + url, "K00217982", "scraping");
    	
    	//JUnit script class
    	scriptSource = new StringBuilder();
    	
    	String projectPath = System.getProperty("user.dir");
    	
    	Help.print("Would you like to load properties from config?\nEnter Y/N: ");
		String config_choice = sc.nextLine();
		
		if(config_choice.equals("n") || config_choice.equals("N")){
			//Prompt user for Website URL
			Help.print("Enter Website URL:");
			String url_input = sc.nextLine();
			//Update the property file with the new URL
			//Property.setProperty("WEBSITE_URL", url_input, "config");
			
			//Prompt user for Automation id
			Help.print("Enter automation ID: ");
			String automation_input = sc.nextLine();
			//Update the property file with the new automation ID
			//Property.setProperty("AUTOMATION_ID", automation_input, "config");
			
			url =  url_input;
			automation_id = automation_input;
		}else {
			url =  Property.getProperty("WEBSITE_URL", "config");
			automation_id = Property.getProperty("AUTOMATION_ID", "config");
		}
    	
    	//WebElement object class
//    	url =  ReadFile.getPropValues("WEBSITE_URL");
//    	utilFileLocation = projectPath + "/" + ReadFile.getPropValues("FILE_UTIL_URL");
//    	testFileLocation = projectPath + "/" + ReadFile.getPropValues("FILE_TEST_URL");
//    	automation_id = ReadFile.getPropValues("AUTOMATION_ID");
		
		
    	utilFileLocation = projectPath + "/" + Property.getProperty("FILE_UTIL_URL", "config");;
    	testFileLocation = projectPath + "/" + Property.getProperty("FILE_TEST_URL", "config");
    	
    	
    	
    	
    	
    	
    	source = new StringBuilder();
    	
    	className = "Home";
    	Logger.log("Creating class: " + className + ".java");
    	
    	final String IMPORTS = "import org.openqa.selenium.By;\r\n" + 
    			"import org.openqa.selenium.WebDriver;\r\n" + 
    			"import org.openqa.selenium.WebElement;";
    	Logger.log("Inserting imports in: " + className);
    	
    	String packageName = "package com.k00217982.fyp.website.utils;\n\n" + IMPORTS;
    	String sourceCodeStart = packageName + "\n"
    			+ "\n\npublic class " + className +  " {\n";
    	String sourceCodeEnd = "\n}";
    	Logger.log("Creating class constructure: " + className + ".java");
    	
    	hrefList = new ArrayList<String>();
    	
    	try {
    		//Scanner sc = new Scanner(System.in);
    		//Help.println("Enter URL: ");
    		//String url = sc.nextLine();
    		
         	//Get Document object after parsing the html from given url.
	    	document = Jsoup.connect(url).get();
	    	//Logger.log("Scraping the web document from: " + url);
	    	
	    	//Scrape all links
	    	source.append(ScrapeLinks(document));
	    	
	    	//Scrape forms
	    	source.append(ScrapeForms(document));

	    	//Add url to map list
	    	UpdateNewLinks(document);
	    	
	    	//Merge source code
	    	String sourceCode = sourceCodeStart + "" + source + "" + sourceCodeEnd;
	    	Logger.log("Building WebElement object methods completed");
	    	
	    	//Create a new file
	    	CreateFile.createFileUsingFileClass(utilFileLocation, className + ".java", sourceCode);
	    	Logger.log(className + ".java created successfully!\n\n");
	    	
	    	//Scrape all other documents from hrefList
//	    	for(String link : hrefList) {
//	    		StringBuilder newSource = new StringBuilder();
//	    		
//	    		//className = Help.getFirstWord(link.ge, 0);
//	    		
//	    		Document theDocument = Jsoup.connect(link).get();
//		    	Logger.log("Scraping the web document from: " + url);
//		    	newSource.append(ScrapeLinks(theDocument));
//	    		//Scrape forms
//		    	newSource.append(ScrapeForms(theDocument));
//		    	
//		    	
//		    	sourceCode = sourceCodeStart + "" + newSource + "" + sourceCodeEnd;
//		    	Logger.log("Building WebElement object methods completed");
//		    	
//		    	
//		    	//Create a new file
//		    	CreateFile.createFileUsingFileClass(utilFileLocation, className + ".java", sourceCode);
//		    	Logger.log(className + ".java created successfully!\n\n");
//	    	}
	    	
	    	for(Map.Entry<String,String> entry : hrefLinks.entrySet()) {
	    		StringBuilder newSource = new StringBuilder();
	    		
	    		//Get key and replace spaces, dashes with underline
	    		className = Help.formatClassName(entry.getKey());
	    		
	    		sourceCodeStart = packageName + "\n"
	        			+ "\n\npublic class " + className +  " {\n";
	    		
	    		Document theDocument = Jsoup.connect(entry.getValue()).get();
		    	//Logger.log("Scraping the web document from: " + entry.getValue());
		    	newSource.append(ScrapeLinks(theDocument));
	    		//Scrape forms
		    	newSource.append(ScrapeForms(theDocument));
		    	//Add url to map list
		    	UpdateNewLinks(document);
		    	
		    	
		    	sourceCode = sourceCodeStart + "" + newSource + "" + sourceCodeEnd;
		    	Logger.log("Building WebElement object methods completed");
		    	
		    	
		    	//Create a new file
		    	CreateFile.createFileUsingFileClass(utilFileLocation, className + ".java", sourceCode);
		    	Logger.log(className + ".java created successfully!\n\n");
	    	}
	    	
	    	
	    	
	    	
	    	

	    	//HomePage.main(null);
    	
        } catch (IOException e) {
        	Help.print("Error, could not parse document!");
        	e.printStackTrace();
        }
    }
    
    
    public static String ScrapeLinks(Document webDocument) {
    	
    	String documentLog = "\n+---------------------------------------------------------+\n"
				+ "Document Scraping:" + webDocument.title() + "\n"
				+ "URL:" + webDocument.baseUri() + "\n"
				+ "+---------------------------------------------------------+";
    	Logger.logInfo(documentLog);
    	
    	StringBuilder code = new StringBuilder();
    	String methodName = "";
    	
    	//Scrape anchor links
    	Elements links = webDocument.select("a");
    	for (Element link : links) {
    	    //System.out.println("Title - " + link.text());
    	    //System.out.println(link.attr("href"));
    		String anchorText = link.text();
    		methodName = Help.getFirstWord(anchorText, 0);
    		
    		String automationid = link.attr(automation_id);
    		Logger.log("Scraped automationid: " + automationid);
    		
    		String domId = automation_id;
    		
    		boolean idFound = false;
    		if(automationid.isEmpty() || automationid.equals(null) || automationid.equals("")) {
    			Logger.logInfo("Element automationid is empty");
    			Logger.log("Targetting element id!");
    			automationid = link.attr("id");
    			domId = "id";
    			idFound = true;
    		}
    		if(automationid.isEmpty() || automationid.equals(null) || automationid.equals("")) {
				Logger.logInfo("Element id is empty");
    			Logger.log("Targetting element class!");
    			automationid = link.attr("class");
    			domId = "class";
    			idFound = true;
			}
    		
    		if(idFound) {
    			Logger.log("[automationid] or [id] or [class] found for xpath");
    		}else {
    			Logger.logError("[automationid] or [id] or [class] not found for xpath");
    		}
    		
    		
    		StringBuilder strBuilder = new StringBuilder("\tpublic static WebElement btn" + methodName + " (WebDriver driver) {\n");
    		strBuilder.append("\t\treturn driver.findElement(By.xpath(\"//a[@"+domId+"='"+automationid+"']\"));\n");
    		strBuilder.append("\t}\n\n");
    		
    		Logger.log("Building WebElement object method string: btn" + methodName + "(WebDriver driver){}");
    		
    		code.append(strBuilder.toString());
    		Platform.sleep(Platform.SHORT_TIME);
    	}
    	return code.toString();
    }
    
    public static String ScrapeForms(Document webDocument) {
    	StringBuilder code = new StringBuilder();
    	Elements forms = webDocument.getElementsByTag("input");
    	for(Element form : forms) {
    		String automationid = form.attr("automationid");
    		//Help.println(automationid);
    		
    		String domId = automation_id;
    		
    		boolean idFound = false;
    		if(automationid.isEmpty() || automationid.equals(null) || automationid.equals("")) {
    			Logger.logInfo("Element automationid is empty");
    			Logger.log("Targetting element id!");
    			automationid = form.attr("id");
    			domId = "id";
    			idFound = true;
    		}
    		if(automationid.isEmpty() || automationid.equals(null) || automationid.equals("")) {
				Logger.logInfo("Element id is empty");
    			Logger.log("Targetting element class!");
    			automationid = form.attr("name");
    			domId = "name";
    			idFound = true;
			}
    		
    		if(idFound) {
    			Logger.log("[automationid] or [id] or [class] found for xpath");
    		}else {
    			Logger.logError("[automationid] or [id] or [class] not found for xpath");
    		}
    		
    		StringBuilder strBuilder = new StringBuilder("\tpublic static WebElement formInput" + automationid + " (WebDriver driver) {\n");
    		strBuilder.append("\t\treturn driver.findElement(By.xpath(\"//input[@"+domId+"='"+automationid+"']\"));\n");
    		strBuilder.append("\t}\n\n");
    		
    		Logger.log("Building WebElement object method string: formInput" + automationid + "(WebDriver driver){}");
    		
    		code.append(strBuilder.toString());
    		
    		Platform.sleep(Platform.SHORT_TIME);
    		
    		
    		
    		//Generate code for Script Class
    		
    	}
    	Logger.log("Form Input WebElement objects created!");
    	return code.toString();
    }
    
    public static void UpdateNewLinks(Document webDocument) {
    	Map<String, String> docLinks = new HashMap<String, String>();
    	
    	//Scrape anchor links
    	Elements links = webDocument.select("a");
    	for (Element link : links) {
    		if(!link.attr("href").contains("index.php") && !link.attr("href").equals(url)) {
    			//hrefList.add(link.attr("href"));
    			docLinks.put(link.text(), link.attr("href"));
	    		Logger.log("Adding " + link.attr("href") + " for scraping");
	    		
	    		Platform.sleep(Platform.SHORT_TIME);
    		}
    	}
    	
    	hrefLinks.putAll(docLinks);
    	Logger.log("Merging new HashMap with old HashMap");
    	
    }
    
    
    //Prepare code for JUnit Script
    public static StringBuilder getSQLSourceCode() {
    	StringBuilder sqlSourceCode = new StringBuilder();
    	sqlSourceCode.append("MySQL mysql = new MySQL(\"localhost\", \"root\", \"\");\r\n" + 
    			"    	try {\r\n" + 
    			"			mysql.connect();\r\n" + 
    			"			String sql = \"SELECT * FROM user\";\r\n" + 
    			"			List<HashMap<String,Object>> users = mysql.getResults(sql);\r\n" + 
    			"			//System.out.println(users);\r\n" + 
    			"		} catch (SQLException e1) {\r\n" + 
    			"			// TODO Auto-generated catch block\r\n" + 
    			"			e1.printStackTrace();\r\n" + 
    			"		}");
    	return sqlSourceCode;
    }
    public static StringBuilder getScriptImports() {
    	StringBuilder junitImports = new StringBuilder();
    	junitImports.append("import java.text.SimpleDateFormat;\r\n" + 
    			"import java.time.LocalDateTime;\r\n" + 
    			"import java.time.format.DateTimeFormatter;\r\n" + 
    			"import java.util.Date;\r\n" + 
    			"\r\n" + 
    			"import org.junit.After;\r\n" + 
    			"import org.junit.Before;\r\n" + 
    			"import org.junit.Test;\r\n" + 
    			"\r\n" + 
    			"import org.openqa.selenium.By;\r\n" + 
    			"import org.openqa.selenium.Keys;\r\n" + 
    			"import org.openqa.selenium.WebDriver;\r\n" + 
    			"import org.openqa.selenium.WebElement;\r\n" + 
    			"import org.openqa.selenium.chrome.ChromeDriver;\r\n" + 
    			"import org.openqa.selenium.support.ui.WebDriverWait;\r\n" + 
    			"\r\n" + 
    			"import com.k00217982.fyp.helper.Browser;\r\n" + 
    			"import com.k00217982.fyp.helper.Help;\r\n" + 
    			"import com.k00217982.fyp.helper.Logger;\r\n" + 
    			"import com.k00217982.fyp.helper.Platform;\r\n" + 
    			"import static com.k00217982.fyp.helper.Assert.assertEquals;\r\n" + 
    			"\r\n" + 
    			"import com.k00217982.fyp.website.utils.*;");
    	return junitImports;
    }
    public static StringBuilder getScriptClassStart(String scriptClassName) {
    	StringBuilder scriptClassStart = new StringBuilder();
    	scriptClassStart.append("public class " + scriptClassName + " {");
    	return scriptClassStart;
    }
    public static StringBuilder getTestStart() {
    	StringBuilder scriptStart = new StringBuilder();
    	scriptStart.append("WebDriver driver;\r\n" + 
    			"	\r\n" + 
    			"	@Before\r\n" + 
    			"    public void startBrowser() {\r\n" + 
    			"        Logger.LogScript(\"Home Script\", \"K00217982\", \"log\");\r\n" + 
    			"        try {\r\n" + 
    			"        	Browser.initWebDriver();\r\n" + 
    			"            driver = Browser.getWebDriver();\r\n" + 
    			"        }catch(Exception ex) {\r\n" + 
    			"        	ex.printStackTrace();\r\n" + 
    			"        }\r\n" + 
    			"    }");
    	return scriptStart;
    }
    //Generate Link tests
    public static StringBuilder generateLinkTest(String functionName, Document theDocument) {
    	StringBuilder test = new StringBuilder();
    	test.append("@Test\r\n" + 
				"    public void " + functionName + "() {\r\n" + 
				"        try {\r\n");
    	
    	//Generate actions for each link
    	String action = "";
    	test.append("        	" + action + "();\r\n" );
    	
		test.append(	
				"        }catch(Exception ex) {\r\n" + 
				"        	ex.printStackTrace();\r\n" + 
				"        }\r\n" + 
				"    }\r\n\r\n");
    	return test;
    	
    }
    //Generate form tests
    public static StringBuilder generateFormTest(String functionName, Document theDocument) {
    	StringBuilder test = new StringBuilder();
    	test.append("@Test\r\n" + 
				"    public void " + functionName + "() {\r\n" + 
				"        try {\r\n");
    	
    	//Generate actions for each form input, including button, followed by comment to expectation
    	String action = "";
    	test.append("        	" + action + "();\r\n" );
    	
		test.append(	
				"        }catch(Exception ex) {\r\n" + 
				"        	ex.printStackTrace();\r\n" + 
				"        }\r\n" + 
				"    }\r\n\r\n");
    	return test;
    }
    //Generate table tests
    public static StringBuilder generateTableTest(String functionName, Document theDocument) {
    	StringBuilder test = new StringBuilder();
    	test.append("@Test\r\n" + 
				"    public void " + functionName + "() {\r\n" + 
				"        try {\r\n");
    	
    	//Generate actions for table columns
    	String columnAction = "";
    	test.append("        	" + columnAction + "();\r\n" );
    	//Generate actions for table values
    	String valueAction = "";
    	test.append("        	" + valueAction + "();\r\n" );
    	
		test.append(	
				"        }catch(Exception ex) {\r\n" + 
				"        	ex.printStackTrace();\r\n" + 
				"        }\r\n" + 
				"    }\r\n\r\n");
    	return test;
    }
    public static StringBuilder getTestEnd() {
    	StringBuilder scriptEnd = new StringBuilder();
		scriptEnd.append("@After\r\n" + 
				"    public void tearDown() {\r\n" + 
				"        try {\r\n" + 
				"        	Browser.shutDownDriver();\r\n" + 
				"        }catch(Exception ex) {\r\n" + 
				"        	ex.printStackTrace();\r\n" + 
				"        }\r\n" + 
				"    }");
    	return scriptEnd;
    }
    public static StringBuilder getScriptClassEnd() {
    	StringBuilder scriptClassEnd = new StringBuilder();
    	scriptClassEnd.append("}");
    	return scriptClassEnd;
    }
}
