package com.qa.darksky.net.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.darksky.net.base.BasePage;



public class ElementUtil extends BasePage{
	
	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtil javaScriptUtil;
	AppConstants constants;
	
	public ElementUtil(WebDriver driver){
		this.driver=driver;
		wait = new WebDriverWait(driver, AppConstants.DEFAULT_TIMEOUT);
		javaScriptUtil = new JavaScriptUtil();
	}
	/**
	 * get Title
	 * @return
	 */
	public String doGetPageTitle(){
		
		try {
			return driver.getTitle();
			
		} catch (Exception e) {
			System.out.println("some exception occured while getting the title");
		}return null;
		
	}
	public void waitForElementPresentBy(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public void waitForGetTitle(String constants){
		
		wait.until(ExpectedConditions.titleIs(constants));
	}
	public WebElement getElement(By locator){
		waitForElementPresentBy(locator);
		WebElement element=null;
		
		try {
			element=driver.findElement(locator);
			if (highlightelement.equals("yes")) {
				javaScriptUtil.flash(element, driver);
			}
		} catch (Exception e) {
			System.out.println("some exception occured while getting the element" + locator);
		}return element;
		
	}
	
	public void doClick(By locator){
		
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception occured while clicking" + locator);
		}
	}
	public void cleanTheBox(By locator){
		driver.findElement(locator).clear();
	}
	public void doSendKeys(By locator, String value){
		try {
			WebElement element=getElement(locator);
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception occured while getting the value" + locator);
		}
		
	}
	
	public boolean doIsDisplayed(By locator){
		
		try {
			return getElement(locator).isDisplayed();
			
		} catch (Exception e) {
			System.out.println("some exception occured while getting the isDisplayed" + locator);
		}
		return false;
		
	}
	public boolean doIsSelected(By locator){
		
		try {
			return getElement(locator).isSelected();
			
		} catch (Exception e) {
			System.out.println("some exception occured while getting the isSelected "+ locator);
		}
		return false;
		
	}
public boolean doIsEnabled(By locator){
		
		try {
			return getElement(locator).isEnabled();
			
		} catch (Exception e) {
			System.out.println("some exception occured while getting the isEnabled "+ locator);
		}
		return false;
		
	}

public String doGetText(By locator){
	try {
		return getElement(locator).getText();
		
	} catch (Exception e) {
		System.out.println("some exception occured while getting the text from the page "+ locator);
	}
	return null;
	
}

public void Select(WebElement element,String value){
	Select select=new Select(element);
	select.selectByValue(value);
}
	
	
	

}
