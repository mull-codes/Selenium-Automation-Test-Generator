package com.k00217982.fyp.website.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class About_Us {
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


}