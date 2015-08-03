package com.pageobjects.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dataprovider.ConfigManager;
import com.selenium.SafeActions;

public class FooterPage extends SafeActions{
	ConfigManager sysProp=new ConfigManager("Sys");
	public FooterPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	private WebDriver driver;
	
	/*
	 * Locator for footer of aboutranker
	 */
	private By footerofaboutranker(){
		return By.xpath("//footer[@id='siteFoot']/nav[@id='footNav']/ul/li[1]/span");
	}
	/*
	 * Function is used to get href Of footer of aboutranker
	 */
	 public String getHrefOfaboutranker(){
	    	return driver.findElement(footerofaboutranker()).getAttribute("data-internal-url");
	 }
	/*
	 * Function is used to click on footer of aboutranker.
	 */
	public void clickOnFooterofaboutranker(){
		//try{
			//safeClick(footerofaboutranker(), VERYLONGWAIT);
//		}catch(Exception e){
		safeJavaScriptClick(footerofaboutranker(), VERYLONGWAIT);
//		}
		 waitForPageToLoad();
	}
	/*
	 * Locator for footer of the ranker blog
	 */
	private By footeroftherankerblog(){
		return By.xpath("//footer[@id='siteFoot']/nav[@id='footNav']/ul/li[2]/a");
	}
	/*
	 * Function is used to get href Of footer of the ranker blog
	 */
	 public String getHrefOftherankerblog(){
	    	return driver.findElement(footeroftherankerblog()).getAttribute("href");
	 }
	/*
	 *  Function is used to click on footer of the ranker blog
	 */
	public void clickOnFooteroftherankerblog(){
			safeJavaScriptClick(footeroftherankerblog(), MEDIUMWAIT);
		
		// waitForPageToLoad();
	}
	/*
	 * Locator for footer of faq&help
	 */
	private By footeroffaqhelp(){
		return By.xpath("//footer[@id='siteFoot']/nav[@id='footNav']/ul/li[3]/span");
	}
	/*
	 * Function is used to get href Of footer of faq&help
	 */
	 public String getHrefOffaqhelp(){
	    	return driver.findElement(footeroffaqhelp()).getAttribute("data-internal-url");
	 }
	/*
	 * Function is used to click on footer of faq&help
	 */
	public void clickOnFooteroffaqhelp(){
		//try{
		safeJavaScriptClick(footeroffaqhelp(), MEDIUMWAIT);
//		}catch(Exception e){
//			safeJavaScriptClick(footeroffaqhelp(), MEDIUMWAIT);
//		}
		 waitForPageToLoad();
	}
	/*
	 * Locator for footer of sitemap
	 */
	private By footerofsitemap(){
		return By.xpath("//footer[@id='siteFoot']/nav[@id='footNav']/ul/li[4]/a");
	}
	/*
	 * Function is used to get href Of footer of sitemap
	 */
	 public String getHrefOfsitemap(){
	    	return driver.findElement(footerofsitemap()).getAttribute("href");
	 }
	 /*
	 * Function is used to click on footer of sitemap.
	 */
	public void clickOnFooterofsitemap(){
		//try{
		safeJavaScriptClick(footerofsitemap(), MEDIUMWAIT);
//		}catch(Exception e){
//			safeJavaScriptClick(footerofsitemap(), MEDIUMWAIT);
//		}
		 waitForPageToLoad();
	}
	/*
	 * Locator for footer of contact
	 */
	private By footerofcontact(){
		return By.xpath("//footer[@id='siteFoot']/nav[@id='footNav']/ul/li[5]/span");
	}
	/*
	 * Function is used to get href Of footer of contact
	 */
	 public String getHrefOfcontact(){
	    	return driver.findElement(footerofcontact()).getAttribute("data-internal-url");
	 }
	/*
	 * Function is used to click on footer of contact
	 */
	public void clickOnFooterofcontact(){
		//try{
		safeJavaScriptClick(footerofcontact(), MEDIUMWAIT);
//		}catch(Exception e){
//			safeJavaScriptClick(footerofcontact(), MEDIUMWAIT);
//		}
		 waitForPageToLoad();
	}
	/*
	 * Locator for footer of jobs
	 */
	private By footerofjobs(){
		return By.xpath("//footer[@id='siteFoot']/nav[@id='footNav']/ul/li[6]/span");
	}
	/*
	 * Function is used to get href Of footer of jobs
	 */
	 public String getHrefOfjobs(){
	    	return driver.findElement(footerofjobs()).getAttribute("data-internal-url");
	 }
	/*
	 * Function is used to click on footer of jobs
	 */
	public void clickOnFooterofjobs(){
	//	try{	
		safeJavaScriptClick(footerofjobs(), MEDIUMWAIT);
//		}catch(Exception e){
//			safeJavaScriptClick(footerofjobs(), MEDIUMWAIT);
//		}
		 waitForPageToLoad();
	}
	/*
	 * Locator for footer of widget
	 */
	private By footerofwidget(){
		return By.xpath("//footer[@id='siteFoot']/nav[@id='footNav']/ul/li[7]/span");
	}
	/*
	 * Function is used to get href Of footer of widget
	 */
	 public String getHrefOfwidget(){
	    	return driver.findElement(footerofwidget()).getAttribute("data-internal-url");
	 }
	/*
	 * Function is used to click on footer of widget
	 */
	public void clickOnFooterofwidget(){
		//try{
		safeJavaScriptClick(footerofwidget(), MEDIUMWAIT);
//		}catch(Exception e){
//			safeJavaScriptClick(footerofwidget(), MEDIUMWAIT);
//		}
		 waitForPageToLoad();
	}
	/*
	 * Locator for footer of terms
	 */
	private By footerofterms(){
		return By.xpath("//footer[@id='siteFoot']/nav[@id='footNav']/ul/li[8]/span");
	}
	/*
	 * Function is used to get href Of footer of terms
	 */
	public String getHrefOfterms(){
		return driver.findElement(footerofterms()).getAttribute("data-internal-url");
	}
	/*
	 * Function is used to click on footer of terms
	 */
	public void clickOnFooterofterms(){
		//try{
		safeJavaScriptClick(footerofterms(), MEDIUMWAIT);
//		}catch(Exception e){
//			safeJavaScriptClick(footerofterms(), MEDIUMWAIT);
//		}
		 waitForPageToLoad();
		
	}
	/*
	 * Locator for footer of privacy
	 */
	private By footerofprivacy(){
		return By.xpath("//footer[@id='siteFoot']/nav[@id='footNav']/ul/li[9]/span");
	}
	/*
	 * Function is used to get href Of footer of privacy
	 */
	public String getHrefOfprivacy(){
		return driver.findElement(footerofprivacy()).getAttribute("data-internal-url");
	}
	/*
	 * Function is used to click on footer of privacy
	 */
	public void clickOnFooterofprivacy(){
		//try{
			safeJavaScriptClick(footerofprivacy(), MEDIUMWAIT);
//		}catch(Exception e){
//			safeJavaScriptClick(footerofprivacy(), MEDIUMWAIT);
//		}
		 waitForPageToLoad();
	}
	/*
	 * Locator for footer of press
	 */
	private By footerofpress(){
		return By.xpath("//footer[@id='siteFoot']/nav[@id='footNav']/ul/li[10]/span");
	}
	/*
	 * Function is used to get href Of footer of press
	 */
	public String getHrefOfpress(){
		return driver.findElement(footerofpress()).getAttribute("data-internal-url");
	}
	/*
	 * Function is used to click on footer of press
	 */
	public void clickOnFooterofpress(){
		safeJavaScriptClick(footerofpress(), MEDIUMWAIT);
//		try{
//			safeClick(footerofpress(), MEDIUMWAIT);
//		}catch(Exception e){
//			safeJavaScriptClick(footerofpress(), MEDIUMWAIT);
//		}
		 waitForPageToLoad();
	}
	
	/*
	 * Locator for footer of partnerprogram
	 */
	private By footerofpartnerprogram(){
		return By.xpath("//footer[@id='siteFoot']/nav[@id='footNav']/ul/li[11]/span");
	}
	/*
	 * Function is used to get href Of footer of partnerprogram
	 */
	public String getHrefOfpartnerprogram(){
		return driver.findElement(footerofpartnerprogram()).getAttribute("data-internal-url");
	}
	/*
	 * Function is used to click on footer of partnerprogram
	 */
	public void clickOnFooterofpartnerprogram(){
		safeJavaScriptClick(footerofpartnerprogram(), MEDIUMWAIT);
//		try{
//			safeClick(footerofpartnerprogram(), MEDIUMWAIT);
//		}catch(Exception e){
//			safeJavaScriptClick(footerofpartnerprogram(), MEDIUMWAIT);
//		}
		 waitForPageToLoad();
	}	
	/*
	 * Locator for footer of partnerprogram
	 */
	private By footeroftoprankers(){
		return By.xpath("//footer[@id='siteFoot']/nav[@id='footNav']/ul/li[12]/span");
	}
	/*
	 * Function is used to get href Of footer of partnerprogram
	 */
	public String getHrefOftoprankers(){
		return driver.findElement(footeroftoprankers()).getAttribute("data-internal-url");
	}
	/*
	 * Function is used to click on footer of partnerprogram
	 */
	public void clickOnFooteroftoprankers(){
		safeJavaScriptClick(footeroftoprankers(), MEDIUMWAIT);
//		try{
//			safeClick(footeroftoprankers(), MEDIUMWAIT);
//		}catch(Exception e){
//			safeJavaScriptClick(footeroftoprankers(), MEDIUMWAIT);
//		}
		 waitForPageToLoad();
	}	
	/*
	 * Locator for footer of edgecast
	 */
	private By footerofedgecast(){
		return By.xpath("//footer[@id='siteFoot']/nav[@id='footNav']/ul/li[13]/span");
	}
	/*
	 * Function is used to get href Of footer of edgecast
	 */
	public String getHrefOfedgecast(){
		return driver.findElement(footerofedgecast()).getAttribute("data-internal-url");
	}
	/*
	 * Function is used to click on footer of edgecast
	 */
	public void clickOnFooterofedgecast(){
		safeJavaScriptClick(footerofedgecast(), MEDIUMWAIT);
//		try{
//			safeClick(footerofedgecast(), MEDIUMWAIT);
//		}catch(Exception e){
//			safeJavaScriptClick(footerofedgecast(), MEDIUMWAIT);
//		}
		 waitForPageToLoad();
	}		
	
	/*
	 * Locator for FreeBase icon in the footer.
	 */
	private By footerFreeBase(){
		return By.xpath("//footer[@id='siteFoot']//span[@class='inlineBlock logo freebase']/..");
	}
	/*
	 * Function is used to get href Of FreeBase
	 */
	public String getHrefOfFreeBase(){
		return driver.findElement(footerFreeBase()).getAttribute("data-internal-url");
	}
	/*
	 * Function is used to click on FreeBase.
	 */
	public void clickOnFreeBase(){
		safeJavaScriptClick(footerFreeBase(), SHORTWAIT);
//		try{
//			safeClick(footerFreeBase(), SHORTWAIT);
//		}catch(Exception e){
//			safeJavaScriptClick(footerFreeBase(), SHORTWAIT);
//		}
		 waitForPageToLoad();
	}	
	
	/*
	 * Locator for Factual icon in the footer.
	 */
	private By footerFactual(){
		return By.xpath("//footer[@id='siteFoot']//span[@class='inlineBlock logo factual']/..");
	}
	/*
	 * Function is used to get href Of Factual
	 */
	public String getHrefOfFactual(){
		return driver.findElement(footerFactual()).getAttribute("data-internal-url");
	}
	/*
	 * Function is used to click on Factual.
	 */
	public void clickOnFactual(){
		
			safeJavaScriptClick(footerFactual(), SHORTWAIT);
		
		 //waitForPageToLoad();
	}	
	
	/*
	 * Locator for Calais icon in the footer.
	 */
	private By footerCalais(){
		return By.xpath("//footer[@id='siteFoot']//span[@class='inlineBlock logo calais']/..");
	}
	/*
	 * Function is used to get href Of Calais.
	 */
	public String getHrefOfCalais(){
		return driver.findElement(footerCalais()).getAttribute("data-internal-url");
	}
	/*
	 * Function is used to click on Calais.
	 */
	public void clickOnCalais(){
		safeJavaScriptClick(footerCalais(), SHORTWAIT);
//		try{
//			safeClick(footerCalais(), SHORTWAIT);
//		}catch(Exception e){
//			safeJavaScriptClick(footerCalais(), SHORTWAIT);
//		}
		 waitForPageToLoad();
	}	
	
	/*
	 * Locator for Wikipedia icon in the footer.
	 */
	private By footerWiki(){
		return By.xpath("//footer[@id='siteFoot']//span[contains(text(),'Wikipedia')]");
	}
	/*
	 * Function is used to get href Of Wikipedia.
	 */
	public String getHrefOfWiki(){
		return driver.findElement(footerWiki()).getAttribute("data-internal-url");
	}
	/*
	 * Function is used to click on Wikipedia.
	 */
	public void clickOnWiki(){
		safeJavaScriptClick(footerWiki(), SHORTWAIT);
//		try{
//			safeClick(footerWiki(), SHORTWAIT);
//		}catch(Exception e){
//			safeJavaScriptClick(footerWiki(), SHORTWAIT);
//			
//		}
		   waitForPageToLoad();
	}
	
	/*
	 * Locator for Mobile Site icon in the footer.
	 */
	private By footerMobileSite(){
		return By.xpath("//footer[@id='siteFoot']//span[@id='modeSwitch_mobile']");
	}
	
	/*
	 * Function is used to click on Mobile Site.
	 */
	public void clickOnMobileSiteLink(){
		
		safeJavaScriptClick(footerMobileSite(), SHORTWAIT);
		waitForPageToLoad();
	//	}
	}	
	
}	
	