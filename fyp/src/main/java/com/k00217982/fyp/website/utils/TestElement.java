package com.k00217982.fyp.website.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestElement {
	
	//private static WebDriver driver;
	
	public static WebElement ArticleOneHeader(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@automationid='fyp_article_1']//h1"));
	}
}
