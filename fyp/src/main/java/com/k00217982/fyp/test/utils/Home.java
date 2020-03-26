package com.k00217982.fyp.test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Home {
	/**
	* Link object
	* @method WebElement link_Btn_home_logoAutomationid(WebDriver driver)
	*/
	public static WebElement link_Btn_home_logoAutomationid(WebDriver driver){
		return driver.findElement(By.xpath("//a[@automationid='btn_home_logo']"));
	}

	/**
	* Link object
	* @method WebElement link_Btn_homeAutomationid(WebDriver driver)
	*/
	public static WebElement link_Btn_homeAutomationid(WebDriver driver){
		return driver.findElement(By.xpath("//a[@automationid='btn_home']"));
	}

	/**
	* Link object
	* @method WebElement link_Btn_contact_usAutomationid(WebDriver driver)
	*/
	public static WebElement link_Btn_contact_usAutomationid(WebDriver driver){
		return driver.findElement(By.xpath("//a[@automationid='btn_contact_us']"));
	}

	/**
	* Link object
	* @method WebElement link_Btn_search_tableAutomationid(WebDriver driver)
	*/
	public static WebElement link_Btn_search_tableAutomationid(WebDriver driver){
		return driver.findElement(By.xpath("//a[@automationid='btn_search_table']"));
	}

	/**
	* Input object
	* @method WebElement formInput_Form_search_input_searchAutomationid(WebDriver driver)
	*/
	public static WebElement formInput_Form_search_input_searchAutomationid(WebDriver driver){
		return driver.findElement(By.xpath("//input[@automationid='form_search_input_search']"));
	}

	/**
	* Input object
	* @method WebElement formInput_Form_article_input_fnameAutomationid(WebDriver driver)
	*/
	public static WebElement formInput_Form_article_input_fnameAutomationid(WebDriver driver){
		return driver.findElement(By.xpath("//input[@automationid='form_article_input_fname']"));
	}

	/**
	* Input object
	* @method WebElement formInput_Form_article_input_lnameAutomationid(WebDriver driver)
	*/
	public static WebElement formInput_Form_article_input_lnameAutomationid(WebDriver driver){
		return driver.findElement(By.xpath("//input[@automationid='form_article_input_lname']"));
	}

	/**
	* Input object
	* @method WebElement formInput_Form_article_btn_submitAutomationid(WebDriver driver)
	*/
	public static WebElement formInput_Form_article_btn_submitAutomationid(WebDriver driver){
		return driver.findElement(By.xpath("//input[@automationid='form_article_btn_submit']"));
	}


}