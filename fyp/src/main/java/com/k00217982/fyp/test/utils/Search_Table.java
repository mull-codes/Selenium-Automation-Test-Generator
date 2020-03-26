package com.k00217982.fyp.test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Search_Table {
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
	* Link object
	* @method WebElement link_Btn_about_usAutomationid(WebDriver driver)
	*/
	public static WebElement link_Btn_about_usAutomationid(WebDriver driver){
		return driver.findElement(By.xpath("//a[@automationid='btn_about_us']"));
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
	* @method WebElement formInput_Input_search_without_nestedAutomationid(WebDriver driver)
	*/
	public static WebElement formInput_Input_search_without_nestedAutomationid(WebDriver driver){
		return driver.findElement(By.xpath("//input[@automationid='input_search_without_nested']"));
	}

	/**
	* Input object
	* @method WebElement formInput_Btn_submit_search_without_nestedAutomationid(WebDriver driver)
	*/
	public static WebElement formInput_Btn_submit_search_without_nestedAutomationid(WebDriver driver){
		return driver.findElement(By.xpath("//input[@automationid='btn_submit_search_without_nested']"));
	}

	/**
	* Input object
	* @method WebElement formInput_aao0KEHr2u(WebDriver driver)
	*/
	public static WebElement formInput_aao0KEHr2u(WebDriver driver) {
		return driver.findElement(By.cssSelector("#search > div.form > form.pr-0 > div.form-group.row.no-gutters.float-right.clearfix > div.col-sm-8 > input"));
	}

	/**
	* Input object
	* @method WebElement formInput_aWQgKDP32f(WebDriver driver)
	*/
	public static WebElement formInput_aWQgKDP32f(WebDriver driver) {
		return driver.findElement(By.cssSelector("#search > div.form > form.pr-0 > div.form-group.row.no-gutters.float-right.clearfix > input"));
	}

	/**
	* Table object
	* @method WebElement table_Tbl_search_without_nestedAutomationid(WebDriver driver)
	*/
	public static WebElement table_Tbl_search_without_nestedAutomationid(WebDriver driver){
		return driver.findElement(By.xpath("//table[@automationid='tbl_search_without_nested']"));
	}

	/**
	* Table object
	* @method WebElement table_Tbl_search_nestedAutomationid(WebDriver driver)
	*/
	public static WebElement table_Tbl_search_nestedAutomationid(WebDriver driver){
		return driver.findElement(By.xpath("//table[@automationid='tbl_search_nested']"));
	}


}