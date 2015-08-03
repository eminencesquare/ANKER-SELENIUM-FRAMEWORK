package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pageobjects.list.ListAwesomeness;
import com.selenium.SafeActions;

public class CreateList extends SafeActions{
	
	private WebDriver driver;
	/*
	 * Locator for skip Create.
	 */
	private By skipCreate(){
		return By.id("createSkip");
	}
	/*
	 * Locator for create List.
	 */
	private By createList(){
		return By.id("createSubmit");
	}
	/*
	 * Locator for list Name.
	 */
	private By listName(){
		return By.xpath("//input[@id='createName']");
	}
	
	public CreateList(WebDriver driver){
		super(driver);
		this.driver=driver;
		try{Thread.sleep(3000);}catch (Exception e){}
	}
	/*
	 * This function is used to click On Skip
	 */
	public ListAwesomeness clickOnSkip(){
		safeClick(skipCreate());
		return new ListAwesomeness(driver);
	}
	/*
	 * This function is used to click On Create
	 */
	public ListAwesomeness clickOnCreate(){
		safeClick(createList());
		return new ListAwesomeness(driver);
	}
	/*
	 * This function is used to enter List Name 
	 */
	public void enterListName(String strName){
		safeType(listName(), strName);
	}
	

}
