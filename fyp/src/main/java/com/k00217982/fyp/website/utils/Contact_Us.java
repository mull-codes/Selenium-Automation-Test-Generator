package com.k00217982.fyp.website.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Contact_Us {
	public static WebElement btnNavbar (WebDriver driver) {
		return driver.findElement(By.xpath("//a[@automationid='main_menu_home']"));
	}

	public static WebElement btnHome (WebDriver driver) {
		return driver.findElement(By.xpath("//a[@automationid='main_ul_home']"));
	}

	public static WebElement btnContact (WebDriver driver) {
		return driver.findElement(By.xpath("//a[@automationid='main_ul_contact']"));
	}

	public static WebElement btnAbout (WebDriver driver) {
		return driver.findElement(By.xpath("//a[@automationid='main_ul_about']"));
	}

	public static WebElement formInputinputSearch (WebDriver driver) {
		return driver.findElement(By.xpath("//input[@automationid='inputSearch']"));
	}

	public static WebElement formInputinput_email (WebDriver driver) {
		return driver.findElement(By.xpath("//input[@automationid='input_email']"));
	}

	public static WebElement formInputinput_password (WebDriver driver) {
		return driver.findElement(By.xpath("//input[@automationid='input_password']"));
	}

	public static WebElement formInputinput_checkbox (WebDriver driver) {
		return driver.findElement(By.xpath("//input[@automationid='input_checkbox']"));
	}


}