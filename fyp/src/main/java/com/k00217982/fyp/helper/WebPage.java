package com.k00217982.fyp.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
//JSoup
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.k00217982.fyp.config.Property;

/**
 * @author Mull
 *
 */
public class WebPage {
	
	//Project home / base page url values
	public final static String		BASE_INDEX_PAGE			=		"index";
	public final static String		BASE_HOME_PAGE			=		"home";
	
	//Common WebPage values
	public final static String		formTagOpening		=		"<form"; //s.substring(0,5);
	public final static String		formTagClosing		=		"</form>"; //s.substring(s.length - 7, s.length);
	
	//Get attribute value of either, automationid, id, class or div
	public static HashMap<String, String> getDomAttributeXPath(Element element) {
		
		HashMap<String, String> attribute = new HashMap<String, String>();
		
		//Check if automationid is not empty
		if( !element.attr("automationid").equals("") ) {
			//Log process
			Logger.log("Found automationid for xpath");
			
			//automationid is not empty string or null or empty
			//Set attribute name
			attribute.put("attributeName", "automationid");
			
			//Log process
			Logger.log("Added attributeName: automationid");
			
			//Set attribute value
			attribute.put("attributeValue", element.attr("automationid"));
			
			//Log process
			Logger.log("Added attributeValue: " + element.attr("automationid"));
			

    	//Now we check if html tag attribute id is not empty
		}else if( !element.attr("id").equals("") ) {
			//html tag attribute id is not empty string or null or empty
			//Set attribute name
			attribute.put("attributeName", "id");
			//Set attribute value
			attribute.put("attributeValue", element.attr("id"));
		
		//Now check if html tag attribute name is not empty
		}else if( !element.attr("class").equals("") ) {
			//Log process
			Logger.log("Found automationid for xpath");
			
			//html tag attribute name is not empty string or null or empty
			//Set attribute name
			attribute.put("attributeName", "class");
			
			//Log process
			Logger.log("Added attributeName: class");
			
			//Set attribute value
			attribute.put("attributeValue", element.attr("class"));
			
			//Log process
			Logger.log("Added attributeValue: " + element.attr("class"));
		
		//Script have failed to find the following attributes: automationid, id, class, now we must target the root of this form if there are any
    	//If the input does not have <form> tag as root then we must get the <div> tag as root
		}else{
			//Log process
			Logger.logInfo("Could not find attributes for xpath, targetting cssSelector", "WARNING");
			
			//Get unique naming tag
			attribute.put("tagName", element.tagName());
			
			//Log process
			Logger.log("Added tagName: " + element.tagName() + " to HashMap<String, String> attributes");
			
			//Get css selector
			attribute.put("cssSelector", element.cssSelector());
			
			//Log process
			Logger.log("Added cssSelector: " + element.cssSelector() + " to HashMap<String, String> attributes");
		}
		
		return attribute;
	}
	
	//Form xPath code
	/**
	 * @param domAttribute
	 * @param comments
	 * @return
	 */
	public static StringBuilder generateXpathObjectCode(HashMap<String, String> domAttribute, String type, String target, String comments) {
		
		String attributeName = null, attributeValue = null, cssSelector = null;
		
		StringBuilder code = new StringBuilder();
		
		//Check if attribute has attribute value
		if(domAttribute.containsKey("attributeValue")) {
			//Process Log
			Logger.log("Found key: attributeValue for Hashmap<String, String> domAttribute");
			
			//Assign dom attribute values
			attributeName = Help.sanitiseString(domAttribute.get("attributeName"));

			//Process Log
			Logger.log("Assigning value of: " + domAttribute.get("attributeName") + " to String attributeName");
			
			attributeValue = Help.sanitiseString(domAttribute.get("attributeValue"));
			
			//Process Log
			Logger.log("Assigning value of: " + attributeValue + " to String attributeValue");
    		
			//Form findElement(By.xpath())
			String methodName = "WebElement " + type + "_" +  Help.capitalize(attributeValue) + Help.capitalize(attributeName) + "(WebDriver driver)";
			code.append("\t/**\n");
			code.append("\t* " + comments + "\n");
			code.append("\t* @method " + methodName + "\n");
			code.append("\t*/\n");
			code.append("\tpublic static " + methodName + "{\n");
			code.append("\t\treturn driver.findElement(By.xpath(\"//"+target+"[@"+attributeName+"='"+attributeValue+"']\"));\n");
			code.append("\t}\n\n");
		}else {
			//Process Log
			Logger.log("Could not find key: attributeValue for Hashmap<String, String> domAttribute, targetting cssSelector");
			
			//Assign dom css selector
			cssSelector = domAttribute.get("cssSelector");

			String uniqueMethodName = Help.generaterandomCharacters(10);
			
			//Process Log
			Logger.log("Generated random number: " + uniqueMethodName);
			
			//Form findElement(By.cssSelector())
			String methodName = "WebElement " + type + "_" + uniqueMethodName + "(WebDriver driver)";
			code.append("\t/**\n");
			code.append("\t* " + comments + "\n");
			code.append("\t* @method " + methodName + "\n");
			code.append("\t*/\n");
			code.append("\tpublic static " + methodName + " {\n");
			code.append("\t\treturn driver.findElement(By.cssSelector(\"" + cssSelector + "\"));\n");
			code.append("\t}\n\n");
		}
		
		//Process Log
		Logger.log("Returning code\n" + code);
		
		return code;
	}

	//Form xPath code
	public static StringBuilder generateXpathObjectCode(HashMap<String, String> domAttribute, String type) {
		
		String attributeName = null, attributeValue = null, cssSelector = null;
		
		StringBuilder code = new StringBuilder();
		
		//Check if attribute has attribute value
		if(domAttribute.containsKey("attributeValue")) {
			//Process Log
			Logger.log("Found key: attributeValue for Hashmap<String, String> domAttribute");
			
			//Assign dom attribute values
			attributeName = Help.sanitiseString(domAttribute.get("attributeName"));

			//Process Log
			Logger.log("Assigning value of: " + domAttribute.get("attributeName") + " to String attributeName");
			
			attributeValue = Help.sanitiseString(domAttribute.get("attributeValue"));
			
			//Process Log
			Logger.log("Assigning value of: " + attributeValue + " to String attributeValue");
    		
			//Form findElement(By.xpath())
			String methodName = "WebElement " + type + "_" +  Help.capitalize(attributeValue) + Help.capitalize(attributeName) + "(WebDriver driver)";
			code.append("\t/**\n");
			code.append("\t* Describe method\n");
			code.append("\t* @method " + methodName + "\n");
			code.append("\t*/\n");
			code.append("\tpublic static " + methodName + " {\n");
			code.append("\t\treturn driver.findElement(By.xpath(\"//input[@"+attributeName+"='"+attributeValue+"']\"));\n");
			code.append("\t}\n\n");
		}else {
			//Process Log
			Logger.log("Could not find key: attributeValue for Hashmap<String, String> domAttribute, targetting cssSelector");
			
			//Assign dom css selector
			cssSelector = domAttribute.get("cssSelector");

			int uniqueMethodName = (int) Help.getRandomIntegerBetweenRange(0, 99);
			
			//Process Log
			Logger.log("Generated random number: " + uniqueMethodName);
			
			//Form findElement(By.cssSelector())
			String methodName = "WebElement " + type + "_" + uniqueMethodName + "(WebDriver driver)";
			code.append("\t/**\n");
			code.append("\t* Describe method\n");
			code.append("\t* @method " + methodName + "\n");
			code.append("\t*/\n");
			code.append("\tpublic static " + methodName + " {\n");
			code.append("\t\treturn driver.findElement(By.cssSelector(\"" + cssSelector + "\"));\n");
			code.append("\t}\n\n");
		}
		
		//Process Log
		Logger.log("Returning code\n" + code);
		
		return code;
	}
	
	//Form xPath code
		public static String generateObjectMethodName(HashMap<String, String> domAttribute, String type) {
			
			String attributeName = null, attributeValue = null;
			
			String methodName = null;
			
			//Check if attribute has attribute value
			if(domAttribute.containsKey("attributeValue")) {
				//Process Log
				Logger.log("Found key: attributeValue for Hashmap<String, String> domAttribute");
				
				//Assign dom attribute values
				attributeName = Help.sanitiseString(domAttribute.get("attributeName"));

				//Process Log
				Logger.log("Assigning value of: " + domAttribute.get("attributeName") + " to String attributeName");
				
				attributeValue = Help.sanitiseString(domAttribute.get("attributeValue"));
				
				//Process Log
				Logger.log("Assigning value of: " + attributeValue + " to String attributeValue");
	    		
				//Form findElement(By.xpath())
				methodName = type + "_" +  Help.capitalize(attributeValue) + Help.capitalize(attributeName);
			}else {
				//Process Log
				Logger.log("Could not find key: attributeValue for Hashmap<String, String> domAttribute, targetting cssSelector");

				String uniqueMethodName = Help.generaterandomCharacters(10);
				
				//Process Log
				Logger.log("Generated random number: " + uniqueMethodName);
				
				//Form findElement(By.cssSelector())
				methodName = type + "_" + uniqueMethodName;
			}
			
			//Process Log
			Logger.log("Returning object method name => " + methodName);
			
			return methodName;
		}
	
	//Generate object method for the search table
	public static StringBuilder generateXpathSearchResultObjectCode(Element element) {
		StringBuilder code = new StringBuilder();
		return code;
	}
	
	//Does the list has more items
	public static boolean hasMoreItems(List<Links> linkList) {
		boolean hasMoreUnusedItems = false;
		for(Links link : linkList) {
			if(!link.isUsed()) {
				hasMoreUnusedItems = true;
			}
		}
		return hasMoreUnusedItems;
	}
	
	
	public static List<Links> addLinks(Document document, boolean firstRun) {
		List<Links> linkList = new ArrayList<Links>();
		
		if(firstRun) {
			Links theLink = new Links("Home", Property.WEBSITE_URL, false);
			linkList.add(theLink);
		}
		
		Elements anchors = document.select("a");
		if( !anchors.isEmpty() ) {
			for( Element link : anchors ) {
				if(link.attr("href").contains(Property.WEBSITE_URL)) {
					if(!isURLBase(link.attr("href")) && !isUrlSameAsConfig(link.attr("href")) ) {
						Links theLink = new Links(link.text(), link.attr("href"), false);
						linkList.add(theLink);
					}
				}
			}
		}
		return linkList;
	}
	
	
	//Get all links from the website without duplications
	public static List<Links> getAllLinks(Document document, boolean firstRun) {
		//All all links regradless of duplications
		List<Links> linkList = addLinks(document, firstRun);
		//Initialize an empty Links List
		List<Links> tmpList = new ArrayList<Links>();
		//Iterate over the given list and fetch document anchors
		for(Links link : linkList) {
			//Make the url isn't same as base, by checking this a lot time processing time will be saved while checking for duplicates
			if( !isURLBase( link.getValue() ) && !isUrlSameAsConfig( link.getValue() ) ) {
				//We have a new document
				try {
					Logger.log("Scraping more links from: " + link.getValue());
					Document tmpDocument = Jsoup.connect(link.getValue()).get();
					//Get all anchors from this document
					Elements anchorList = tmpDocument.select("a");
					//Iterate over the new anchorList
					for(Element anchor : anchorList) {
						Logger.log("---------------------------------------");
						//Match found flag
						boolean matchFound = false;
						//Check if this anchor attribute href does not matches the one from the given list
						for(Links checkLink : linkList) {
							//Check if it is same as base, if so no point iterating anymore
							if(isURLBase(anchor.attr("href")) || isUrlSameAsConfig(anchor.attr("href"))) {
								Logger.log("Same as base SKIP --> " + anchor.attr("href"));
								matchFound = true;
							}else {
								String linkComment = "New Link URL: " + anchor.attr("href") + " == " + checkLink.getValue() + " : List Link URL";
								if( checkLink.getValue().equals(anchor.attr("href")) ) {
									linkComment = linkComment + " => TRUE";
									matchFound = true;
								}else {
									linkComment = linkComment + " => FALSE";
								}
								Logger.log(linkComment);
							}
						}
						if( !matchFound ) {
							//We have a new anchor
							//Initialise a new Links object, Links(key, value, isUsed) set default isUsed to false as this is a new link
							Links tmpLink = new Links(anchor.text(), anchor.attr("href"), false);
							//Add this link to the tmpList
							tmpList.add(tmpLink);
							Logger.log( "\n------------------------\nLink item added: " + tmpLink.getValue() + "\n------------------------" );
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					Logger.logError(e.toString());
				}
			}else {
				Logger.log("List Link URL: " + link.getValue() + " == " + Property.WEBSITE_URL + " : Config Link URL");
			}
		}
		//remove all duplications
		linkList.addAll(removeDuplicateLinks(tmpList));
		//Process log
		Logger.log("----------------------------------------------------");
		Logger.log("Total links found: " + linkList.size());
		for(Links link : linkList) {
			//Log list of links without duplications
			Logger.log("Text-> " + link.getKey() + " : Link-> " + link.getValue() + " : Used-> " + link.isUsed());
		}
		Logger.log("----------------------------------------------------");
		//return the clean list
		return linkList;
	}
	
	//Remove duplicate items from Link list
	public static List<Links> removeDuplicateLinks(List<Links> linkList){
		List<Links> noRepeat = new ArrayList<Links>();

		for (Links link : linkList) {
		    boolean isFound = false;
		    // check if the event name exists in noRepeat
		    for (Links e : noRepeat) {
		        if (e.getValue().equals(link.getValue()) || (e.equals(link))) {
		            isFound = true;        
		            break;
		        }
		    }
		    if (!isFound) noRepeat.add(link);
		}
		
		return noRepeat;
	}
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	//SCRAPE WEB PAGES AND PREPARE OBJECT FILES
	///////////////////////////////////////////////////////////////////////////////////////////////////
	//Scrape Anchor Tags
	public static String ScrapeLinks(Document webDocument) {
		String documentLog = "################# Generating link objects #################";
        Logger.logInfo(documentLog);
		
		
		StringBuilder code = new StringBuilder();
		String methodName = "";
		
		//Scrape anchor links
		Elements links = webDocument.select("a");
		for (Element link : links) {
			
			HashMap<String, String> domAttribute = WebPage.getDomAttributeXPath(link);
			
			StringBuilder strBuilder = WebPage.generateXpathObjectCode(domAttribute, "link", "a", "Link object");
			
			Logger.log("Building WebElement object method string: btn" + methodName + "(WebDriver driver){}");
			
			code.append(strBuilder.toString());
			Platform.sleep(Platform.ONE_SECONDS);
		}
		return code.toString();
	}
	
    //Scrape Forms
    public static String ScrapeInputs(Document webDocument) {
    	String documentLog = "################# Generating input objects #################";
        Logger.logInfo(documentLog);
        
    	StringBuilder code = new StringBuilder();
    	Elements inputs = webDocument.select("input");
    	if(!inputs.isEmpty()) {
    		for(Element input : inputs) {
        		
        		HashMap<String, String> domAttribute = WebPage.getDomAttributeXPath(input);
    			
    			StringBuilder strBuilder = WebPage.generateXpathObjectCode(domAttribute, "formInput", "input", "Input object");
        		
        		//Logger.log("Building WebElement object method string: formInput" + attributeValue + "(WebDriver driver){}");
        		
        		code.append(strBuilder.toString());
        		
        		Platform.sleep(Platform.ONE_SECONDS);

        		//Generate code for Script Class
        		
        	}
        	Logger.log("Form Input WebElement objects created!");
    	}else {
    		Logger.logInfo("Input elements not found!");
    	}
    	
    	return code.toString();
    }
    
    //Scrape <table></table>
    public static String ScrapeTable(Document webDocument) {
    	String documentLog = "################# Generating table objects #################";
        Logger.logInfo(documentLog);
        
    	StringBuilder code = new StringBuilder();
    	Elements tables = webDocument.select("table");
    	if(!tables.isEmpty()) {
    		for(Element table : tables) {
    			if(WebPage.isSearchTable(table)) {
    				Logger.logInfo("This is a search table!");
    				//TODO next step
    			}else {
    				Logger.logInfo("This is a not a search table!");
    				//TODO next step
    			}
    			
    			HashMap<String, String> domAttribute = WebPage.getDomAttributeXPath(table);
    			
    			StringBuilder strBuilder = WebPage.generateXpathObjectCode(domAttribute, "table", "table", "Table object");
        		
        		//Logger.log("Building WebElement object method string: formInput" + attributeValue + "(WebDriver driver){}");
        		
        		code.append(strBuilder.toString());
        		
        		Platform.sleep(Platform.ONE_SECONDS);
    		}
    	}else {
    		Logger.logInfo("Table elements not found!");;
    	}
    	return code.toString();
    }
    
    
	///////////////////////////////////////////////////////////////////////////////////////////////////
	//SCRAPE WEB PAGES AND PREPARE OBJECT FILES
	///////////////////////////////////////////////////////////////////////////////////////////////////
	//Scrape Anchor Tags
	public static String createLinkTestMethods (Document webDocument, int testNumber, String sourceClassName, String sourceUrl) {
		String documentLog = "################# Generating link script method #################";
        Logger.logInfo(documentLog);
		
		
		StringBuilder code = new StringBuilder();
		
		String sourceObjectName = null;
		
		
		//Scrape anchor links
		Elements links = webDocument.select("a");
		
		for (Element link : links) {
			String baseUri = link.baseUri();
			if(sourceUrl.equals(baseUri)) {
				HashMap<String, String> domAttribute = WebPage.getDomAttributeXPath(link);
				
				//Get Object Method Name
				sourceObjectName = WebPage.generateObjectMethodName(domAttribute, "link");
			}
		}
		
		for (Element link : links) {
			
			try {
				
				if(isURLBase(link.attr("href")) || isUrlSameAsConfig(link.attr("href"))) {
					Logger.log("Same as base SKIP --> " + link.attr("href"));
				}else {
					if(link.attr("href").contains(Property.WEBSITE_URL)) {
						if(!sourceUrl.equals(link.attr("href"))) {
							//Temp document
							Document tmpDocument = Jsoup.connect(link.attr("href")).get();
							
							HashMap<String, String> domAttribute = WebPage.getDomAttributeXPath(link);
							
							String nextClassName = Help.formatClassName(link.text());
			    			
			    			String objectMethodName = WebPage.generateObjectMethodName(domAttribute, "link");
							
							String scriptMethodName = "visit_" + Help.formatClassName(link.text());
							
							//Start of test method
							code.append("\n\t@Test\r\n" + 
									"\t@DisplayName(\""+scriptMethodName+"\")\r\n" + 
									"\t@Order("+testNumber+")\r\n" + 
									"\tpublic void "+scriptMethodName+"() {\r\n" + 
									"\t\ttry {\r\n");
							
							//Methods main code
							code.append("\t\t\tString expectedResult = \""+tmpDocument.title()+"\";\r\n");
							code.append("\t\t\t" + nextClassName + "." + objectMethodName + "(driver).click();\r\n");
							code.append("\t\t\tLogger.logInfo(\"Navigating to "+objectMethodName+"\");\r\n");
							code.append("\t\t\tPlatform.sleep(Platform.SHORT_TIME);\r\n");
							code.append("\t\t\tString actualResult = driver.getTitle();\r\n");
							code.append("\t\t\tassertEquals(expectedResult, actualResult);\r\n");
							//Go back to source page
							code.append("\t\t\t"+sourceClassName+"."+sourceObjectName+"(driver).click();\r\n");
							//Make the browser wait 5 seconds
							code.append("\t\t\tPlatform.sleep(Platform.FIVE_SECONDS);\r\n");
							
							//End of test method
							code.append("\t\t}catch(Exception ex) {\r\n" + 
									"\t\t\tLogger.logError(ex.toString());\r\n" + 
									"\t\t}\r\n" + 
									"\t}\r\n\n");
							
							//Process Log
							Logger.log("Returning test code\n" + code);
							
							testNumber++;
						}
					}
				}

				Platform.sleep(Platform.ONE_SECONDS);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		return code.toString();
	}
	
    //Scrape Forms
    public static String createInputTestMethods (Document webDocument) {
    	String documentLog = "################# Generating input objects #################";
        Logger.logInfo(documentLog);
        
    	StringBuilder code = new StringBuilder();
    	Elements inputs = webDocument.select("input");
    	if(!inputs.isEmpty()) {
    		for(Element input : inputs) {
        		
        		HashMap<String, String> domAttribute = WebPage.getDomAttributeXPath(input);
    			
    			StringBuilder strBuilder = WebPage.generateXpathObjectCode(domAttribute, "formInput", "input", "Input object");
        		
        		//Logger.log("Building WebElement object method string: formInput" + attributeValue + "(WebDriver driver){}");
        		
        		code.append(strBuilder.toString());
        		
        		Platform.sleep(Platform.ONE_SECONDS);

        		//Generate code for Script Class
        		
        	}
        	Logger.log("Form Input WebElement objects created!");
    	}else {
    		Logger.logInfo("Input elements not found!");
    	}
    	
    	return code.toString();
    }
    
    //Scrape <table></table>
    public static String createTableTestMethods (Document webDocument) {
    	String documentLog = "################# Generating table objects #################";
        Logger.logInfo(documentLog);
        
    	StringBuilder code = new StringBuilder();
    	Elements tables = webDocument.select("table");
    	if(!tables.isEmpty()) {
    		for(Element table : tables) {
    			if(WebPage.isSearchTable(table)) {
    				Logger.logInfo("This is a search table!");
    				//TODO next step
    			}else {
    				Logger.logInfo("This is a not a search table!");
    				//TODO next step
    			}
    			
    			HashMap<String, String> domAttribute = WebPage.getDomAttributeXPath(table);
    			
    			StringBuilder strBuilder = WebPage.generateXpathObjectCode(domAttribute, "table", "table", "Table object");
        		
        		//Logger.log("Building WebElement object method string: formInput" + attributeValue + "(WebDriver driver){}");
        		
        		code.append(strBuilder.toString());
        		
        		Platform.sleep(Platform.ONE_SECONDS);
    		}
    	}else {
    		Logger.logInfo("Table elements not found!");;
    	}
    	return code.toString();
    }
   
    
    
    /**
	 * public static boolean isSearchTable(Element element)
	 * 
	 * Uses the element to find extract its' parent element and checks if (parent.substring(0,5).equals("<form"))
	 *
	 * @param	Element element		:	this should be a form element
	 * 
	 * @author	K00217982
	 * @return	returns true if a match found for String "<form"
    */
	public static boolean isSearchTable(Element element) {
		boolean searchTableFound = false;
		//Check if element is null
		if(element.equals(null)) {
			//element passed is null, return false
			searchTableFound = false;
		}else {
			Element parent = element.parent();
			//System.out.println("Parent: " + parent);
			if(parent.equals(null)) {
				//parent element is null, return false
				searchTableFound = false;
			}else {
				if(parent.toString().contains(formTagOpening)) {
					searchTableFound = true;
				}else {
					//Get parent of parent
					Element parentOfParent = parent.parent();
					if(parentOfParent.equals(null)) {
						searchTableFound = false;
					}else {
						if(parentOfParent.toString().contains(formTagOpening)) {
							searchTableFound = true;
						}else {
							searchTableFound = false;
						}
					}
				}
			}
		}
		return searchTableFound;
	}
    
    
    
    //Check if URL is project url or /index or /home
  	public static boolean isURLBase(String url) {
  		//if condition met we have found a match, all three urls are linked to home
  		if(url.contains(BASE_INDEX_PAGE) || url.contains(BASE_HOME_PAGE)) {
  			return true;
  		}else {
  			return false;
  		}
  	}
	public static boolean isUrlSameAsConfig(String url) {
		boolean matchFound = false;
		//Check if the given url is same as config;
		if(Property.WEBSITE_URL.equals(url)) {
			matchFound = true;
		}else {
			//Now get the last char of String url
			String lastUrlChar = url.substring(url.length() - 1);
			
			//Check if the last character is forward slash => /
			if(lastUrlChar.equals("/")) {
				//Remove the forward slash
				url = url.substring(0, url.length() - 1);
			}else {
				//Add a forward slash
				url = url + "/";
			}
			//now check if the modified url matches the config_url
			if(Property.WEBSITE_URL.equals(url)) {
				//A definite match have been found
				matchFound = true;
			}
		}
		return matchFound;
	}
	
	
}
