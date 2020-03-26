package com.k00217982.fyp.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import com.k00217982.fyp.helper.Browser;
import com.k00217982.fyp.interfaces.CustomWebElement;

public class Button implements CustomWebElement  {
	
	private WebElement element;
	
	public void ClickJS() {
		//JavaScript Click
		JavascriptExecutor executor = (JavascriptExecutor)Browser.getWebDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void clear() {
		// TODO Auto-generated method stub
		element.clear();
	}

	public void click() {
		// TODO Auto-generated method stub
		element.click();
	}

	public WebElement findElement(By arg0) {
		// TODO Auto-generated method stub
		return element.findElement(arg0);
	}

	public List<WebElement> findElements(By arg0) {
		// TODO Auto-generated method stub
		return element.findElements(arg0);
	}

	public String getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return element.getAttribute(arg0);
	}

	public String getCssValue(String arg0) {
		// TODO Auto-generated method stub
		return element.getCssValue(arg0);
	}

	public Point getLocation() {
		// TODO Auto-generated method stub
		return element.getLocation();
	}

	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return element.getRect();
	}

	public Dimension getSize() {
		// TODO Auto-generated method stub
		return element.getSize();
	}

	public String getTagName() {
		// TODO Auto-generated method stub
		return element.getTagName();
	}

	public String getText() {
		// TODO Auto-generated method stub
		return element.getText();
	}

	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return element.isDisplayed();
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return element.isEnabled();
	}

	public boolean isSelected() {
		// TODO Auto-generated method stub
		return element.isSelected();
	}

	public void sendKeys(CharSequence... arg0) {
		// TODO Auto-generated method stub
		element.sendKeys(arg0);
	}

	public void submit() {
		// TODO Auto-generated method stub
		element.submit();
	}

	public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
