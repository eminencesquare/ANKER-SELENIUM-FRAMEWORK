package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public class Videos extends SafeActions{
	
	private WebDriver driver;
	
	public Videos(WebDriver driver){
		super(driver);
		this.driver=driver;
		try{Thread.sleep(3000);}catch (Exception e){}
		
	}
	/*
	 * Locator for Video Header.
	 */
	private By videosHeader(){
		return By.xpath("//h1[contains(text(),'video of the week')]");
	}
	/*
	 * This function is used to verify viedo header
	 */
	public boolean verifyVidoesHeader(){
		return isElementPresent(videosHeader());
	}
}
