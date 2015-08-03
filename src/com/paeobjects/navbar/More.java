package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public class More extends SafeActions{
	
	private WebDriver driver;
	
	
	
	public More(WebDriver driver){
		super(driver);
		this.driver=driver;
		try{Thread.sleep(3000);}catch (Exception e){}
		
	}
	
	
}

