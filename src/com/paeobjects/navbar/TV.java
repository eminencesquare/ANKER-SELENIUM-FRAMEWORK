package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public class TV extends SafeActions{
	
	private WebDriver driver;
	
	public TV(WebDriver driver){
		super(driver);
		this.driver=driver;
		try{Thread.sleep(3000);}catch (Exception e){}
		
	}
	/*
	 * Locator for TV Header.
	 */
	private By tvHeader(){
		return By.xpath("//div[@id='siteBody']/article[@id='landing']/header[@id='landingHead']/h1");
	}
	/*
	 * Locator for seeAllTvs.
	 */
	private By seeAllTvs(){
		return By.xpath("//div[@id='siteNavCatLists']/a");
	}
	/*
	 * This function is used to verify Tv Header
	 */
	public boolean verifyTvHeader(){
		return isElementPresent(tvHeader());
	}
	/*
	 * This function is used to click On SeeAllTv
	 */
	public void clickOnSeeAllTv(){
		safeClick(seeAllTvs());
	}


}
