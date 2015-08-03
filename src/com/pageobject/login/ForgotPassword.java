package com.pageobject.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public class ForgotPassword extends SafeActions{
	
	private WebDriver driver;
	
	private By forgotEmail(){
		return By.id("forgotEmail");
	}
	
	public ForgotPassword(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	public boolean verifyForgotEmailBox(){
		return isElementPresent(forgotEmail());
	}

}
