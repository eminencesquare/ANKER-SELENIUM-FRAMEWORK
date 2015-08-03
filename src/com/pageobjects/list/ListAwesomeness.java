package com.pageobjects.list;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.AppGlobalVariables;
import com.selenium.SafeActions;

public class ListAwesomeness extends SafeActions{

	private WebDriver driver;
	
	private By nameMyList(String lstName){
		return By.xpath("//span[text()='"+lstName+"']");
	}
	private By closeCreateLst(){
		return By.xpath("//span[@id='UE_nav_close']");
	}
	
	private By closePopup(){
		return By.xpath("//button[@title='close']");
	}
	
	public ListAwesomeness(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	public boolean verifyListName(String...lstName){
		String lstNm="";
		if(lstName.length<=0)
			{
			lstNm=AppGlobalVariables.CREATELIST_DEFAULTLISTNAME;
			}
		else
			lstNm=lstName[0];
		return isElementDisplayed(nameMyList(lstNm));
	}
	
	public void clickCloseLst(){
		safeClick(closeCreateLst(), VERYLONGWAIT);
	}
	
	public void clickClosePopup(){
		safeClick(closePopup());
	}
}
