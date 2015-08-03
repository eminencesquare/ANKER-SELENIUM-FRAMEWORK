package com.pageobject.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public class TwitterAPI extends SafeActions{
	
	private WebDriver driver;
	
	private By twitterHeader(){
		return By.linkText("Twitter");
	}
	
	public TwitterAPI(WebDriver driver){
		super(driver);
		this.driver=driver;
		switchToNewWindow();
		waitForPageToLoad(MEDIUMWAIT);
	}
	
	public boolean verifyTwitterHeader(){
		return isElementPresent(twitterHeader());
	}

}
