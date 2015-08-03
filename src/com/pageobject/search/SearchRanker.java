package com.pageobject.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.BaseSetup;
import com.selenium.SafeActions;

public class SearchRanker extends SafeActions{
	
private WebDriver driver;
	
	public SearchRanker(WebDriver driver){
		super(driver);
		this.driver=driver;
		try{Thread.sleep(3000);}catch (Exception e){}
	}
	
	private By searchBox(){
		return By.id("searchStartInput");
	}
	
	public boolean verifySearchbox(){
		return isElementPresent(searchBox());
	}

	
}
