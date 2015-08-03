package com.pageobject.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dataprovider.ConfigManager;
import com.selenium.SafeActions;

public class ProfilePage extends SafeActions{
	
	private WebDriver driver;
	
	private By profileLogo(){
		return By.id("userProfileImg");
	}
	
	private By ProfileImage(){
		return By.id("profileImg");
	}
	private ConfigManager config;
	public ProfilePage(WebDriver driver) {
		super(driver);
		config=new ConfigManager();
		this.driver=driver;
		Assert.assertTrue(isElementPresent(profileLogo()),"Profile page");
	}
	
//	public boolean verifyProfileImage(){
//		return isElementPresent(ProfileImage());
//	}

}
