package com.pageobject.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public class GooglePlusAPI extends SafeActions{
	
	private WebDriver driver;
	
	private By GplusHeader(){
		return By.xpath("//img[@alt='Google']");
	}
	
	public GooglePlusAPI(WebDriver driver){
		super(driver);
		this.driver=driver;
		switchToNewWindow();
		waitForPageToLoad(MEDIUMWAIT);
	}
	
	public boolean verifyGPluslogo(){
		return isElementPresent(GplusHeader());
	}

}
