package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public class Film extends SafeActions{
	private WebDriver driver;
	/*
	 * Locator for filmHeader.
	 */
	private By filmHeader(){
		return By.xpath("//div[@id='siteBody']/article[@id='landing']/header[@id='landingHead']/h1");
	}
	/*
	 * Locator for seeAllFilms.
	 */
	private By seeAllFilms(){
		return By.xpath("//div[@id='siteNavCatLists']/a");
	}
	
	public Film(WebDriver driver){
		super(driver);
		this.driver=driver;
		try{Thread.sleep(3000);}catch (Exception e){}
	}	
	/*
	 * This function is used to verify Film Header 
	 */
	public boolean verifyFilmHeader(){
		return isElementPresent(filmHeader());
	}
	/*
	 * This function is used to click OnSeeAllFilms in Film Overlay 
	 */
	public void clickOnSeeAllFilms(){
		safeClick(seeAllFilms());
	}
}
