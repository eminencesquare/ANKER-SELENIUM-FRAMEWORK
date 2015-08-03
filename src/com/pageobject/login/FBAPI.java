package com.pageobject.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public class FBAPI extends SafeActions{
	
	private WebDriver driver;
	
	private By fbHeader(){
		return By.id("header_container");
	}
	
	public FBAPI(WebDriver driver){
		super(driver);
		this.driver=driver;
		switchToNewWindow();
		waitForPageToLoad(MEDIUMWAIT);
	}
	
	public boolean verifyFBHeader(){
		return isElementPresent(fbHeader());
	}

}
