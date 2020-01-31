package com.k00217982.fyp.website.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Home {
	public static WebElement btnNavbar (WebDriver driver) {
		return driver.findElement(By.xpath("//a[@automationid='btn_home_logo']"));
	}

	public static WebElement btnHome (WebDriver driver) {
		return driver.findElement(By.xpath("//a[@automationid='btn_home']"));
	}

	public static WebElement btnContact (WebDriver driver) {
		return driver.findElement(By.xpath("//a[@automationid='btn_contact_us']"));
	}

	public static WebElement btnAbout (WebDriver driver) {
		return driver.findElement(By.xpath("//a[@automationid='btn_about_us']"));
	}

	public static WebElement formInputform_search_input_search (WebDriver driver) {
		return driver.findElement(By.xpath("//input[@automationid='form_search_input_search']"));
	}

	public static WebElement formInputform_article_input_fname (WebDriver driver) {
		return driver.findElement(By.xpath("//input[@automationid='form_article_input_fname']"));
	}

	public static WebElement formInputform_article_input_lname (WebDriver driver) {
		return driver.findElement(By.xpath("//input[@automationid='form_article_input_lname']"));
	}

	public static WebElement formInputform_article_btn_submit (WebDriver driver) {
		return driver.findElement(By.xpath("//input[@automationid='form_article_btn_submit']"));
	}


}