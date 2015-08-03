package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.paeobjects.home.Commonpage;

public class People extends Commonpage{ 
	
	private WebDriver driver;
	/*
	 * Locator for people Header.
	 */
	private By peopleHeader(){
		return By.xpath("//div[@id='siteBody']/article[@id='landing']/header[@id='landingHead']/h1");
	}
	/*
	 * Locator for seeAllPeople in People overlay
	 */
	private By seeAllPeople(){
		return By.xpath("//div[@id='siteNavCatLists']/a");//div[@id='siteNavCatLists']/a
	}
	
	

	public People(WebDriver driver) {
		super(driver);
		this.driver=driver;
		try{Thread.sleep(3000);}catch (Exception e){}
	}
	/*
	 * This function is used to verify People Header 
	 */
	public boolean verifyPeopleHeader(){
		return isElementPresent(peopleHeader());
	}
	/*
	 * This function is used to click On SeeAllPeople in people overlay
	 */
	public void clickOnSeeAllPeople(){
		safeClick(seeAllPeople());
	}
	
}
