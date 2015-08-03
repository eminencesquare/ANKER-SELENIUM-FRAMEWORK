package com.pageobject.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dataprovider.ConfigManager;
import com.selenium.SafeActions;
import com.utilities.TimeOuts;

public class SigninPage extends SafeActions{
	
	private WebDriver driver;
	ConfigManager config;
	
	public SigninPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		config=new ConfigManager();
	}
	
	private By signIn(){
		return By.xpath("//header[@id='siteHead']/div[@id='userArea']/span[@id='navLogin']");
	}
	
	private By loginUser(){
		return By.id("loginUser");
	}
	
	private By password(){
		return By.id("loginPass");
	}
	
	private By btnSignin(){
		return By.id("loginButton");
	}
	
	public void clickSignin(){
		safeClick(signIn(), SHORTWAIT);
	}
	
	public boolean verifyLoginPage() throws Exception
	{
		return isElementPresent(signIn(), SHORTWAIT);
	}
		
	public void enterCredentels(String strUName, String strPwd) {
		try{
		safeJavaScriptType(loginUser(), strUName,SHORTWAIT);
		safeJavaScriptType(password(), strPwd, SHORTWAIT);
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		
	}
	public ProfilePage clickSubmit(){
		safeJavaScriptClick(btnSignin(),SHORTWAIT);
		return new ProfilePage(driver);
	}

	

}
