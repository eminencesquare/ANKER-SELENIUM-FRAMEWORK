package com.pageobjects.slideshow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public class PicsPage extends SafeActions{
	
	private By photoGallery(){
		return By.xpath("//p[@class='txtShadow']");
	}
	
	private By slideNxt(){
		return By.xpath("//span[@id='slideImgNext']");
	}
	
	private WebDriver driver;

	public PicsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public boolean verifyPicsGallery(){
		return isElementPresent(photoGallery(), LONGWAIT);
	}
	
	public void hoveronSlideNxt(){
		mouseHover(slideNxt(), LONGWAIT);
	}
	
	public String nxtBGround(){
		return driver.findElement(slideNxt()).getCssValue("background");
	}

}
