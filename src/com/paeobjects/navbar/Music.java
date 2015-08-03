package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public class Music extends SafeActions{
	
	private WebDriver driver;
	
	public Music(WebDriver driver){
		super(driver);
		this.driver=driver;
		try{Thread.sleep(3000);}catch (Exception e){}
		
	}
	/*
	 * Locator for Music Header.
	 */
	private By musicHeader(){
		return By.xpath("//div[@id='siteBody']/article[@id='landing']/header[@id='landingHead']/h1");
	}
	/*
	 * Locator for seeAllMusic.
	 */
	private By seeAllMusic(){
		return By.xpath("//div[@id='siteNavCatLists']/a");
	}
	/*
	 * This function is used to verify Music Header 
	 */
	public boolean verifyMusicHeader(){
		return isElementPresent(musicHeader());
	}
	/*
	 * This function is click on see all music
	 */
	public void clickOnSeeAllMusic(){
		safeClick(seeAllMusic());
	}


}
