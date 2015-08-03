package com.pageobject.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dataprovider.ConfigManager;
import com.selenium.SafeActions;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class AuthLoginPage extends SafeActions{
	
	private WebDriver driver;
	ConfigManager config;
	
	public AuthLoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		config=new ConfigManager();
	}
	
	private By submitBth(){
		return By.xpath("//input[@value='Submit']");
	}
	
	private By authUser(){
		return By.name("uname");
	}
	
	private By authPassword(){
		return By.name("pass");
	}
	
	
	
		
	public void enterCredentels(String strAuthUName, String strAuthPwd){
		safeType(authUser(), strAuthUName);
		safeType(authPassword(), strAuthPwd);
		
	}
	public SigninPage clickSubmit(){
		//safeClick(submitBth(),500);
		try{
		driver.findElement(submitBth()).click();
		}catch(Exception e){
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ");
			waitForPageToLoad();
		}
		return new SigninPage(driver);
	}
	
	public void authLogin(){
		driver.get(new ConfigManager().getProperty("Url"));
		enterCredentels(config.getProperty("Authuname"), config.getProperty("Authpwd"));
		clickSubmit();
	}

}
