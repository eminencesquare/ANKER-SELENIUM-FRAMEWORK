package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public class Sports extends SafeActions{
	
	private WebDriver driver;
	
	public Sports(WebDriver driver){
		super(driver);
		this.driver=driver;
		try{Thread.sleep(3000);}catch (Exception e){}
		
	}
	/*
	 * Locator for sports Header.
	 */
	private By sportsHeader(){
		return By.xpath("//div[@id='siteBody']/article[@id='landing']/header[@id='landingHead']/h1");
	}
	/*
	 * Locator for see All Sports.
	 */
	private By seeAllSports(){
		return By.xpath("//div[@id='siteNavCatLists']/a");
	}
	/*
	 * This function is used to verify Sports Header 
	 */
	public boolean verifySportsHeader(){
		return isElementPresent(sportsHeader());
	}
	/*
	 * This function is used to click on see all sports 
	 */
	public void clickOnSeeAllSports(){
		safeClick(seeAllSports());
	}


}
