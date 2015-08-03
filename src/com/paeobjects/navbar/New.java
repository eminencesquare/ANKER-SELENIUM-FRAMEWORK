package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.paeobjects.home.Commonpage;

public class New extends Commonpage{
	
	private WebDriver driver;
	
	public New(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	/*
	 * Locator for recentList.
	 */
	private By recentList(){
		if(isElementPresent(By.xpath("//h1[contains(text(),'Recent Lists')]"),SHORTWAIT)==true)
		{
			return By.xpath("//h1[contains(text(),'Recent Lists')]");
		}
		else
		{
			return By.xpath("//span[contains(text(),'Recent Lists')]");
		}
	}
	/*
	 * This function is used to verify Recent List on New in Navbar
	 */
	public boolean verifyRecentListHeader(){
		return isElementPresent(recentList(), MEDIUMWAIT);
	}

}
