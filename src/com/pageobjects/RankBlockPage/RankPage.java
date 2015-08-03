package com.pageobjects.RankBlockPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.SafeActions;

public class RankPage extends SafeActions {
private WebDriver driver;
	
	/*
	 * Constructor for the page.
	 */
	public RankPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/*
	 * Locator for the Dropdown for selecting block.
	 */
	private By dropdown(){
	
		return By.id("freshSort");
	}
	
	/*
	 * This function is used to select value from dropdown.
	 */
	public void selectFromDropdown(String value){
		safeSelectOptionInDropDown(dropdown(),value, VERYLONGWAIT);
		
	}

	/*
	 * Locator for the list item.
	 */
	private By list(int num){
	
		return By.xpath("//section[@id='fresh']/ol/li["+num+"]");
	}
	
	/*
	 * This function is used to check presence of list item.
	 */
	public boolean isListPresent(int num){
		return isElementPresent(list(num),MEDIUMWAIT);
		
	}
	
	/*
	 * Locator for the list item.
	 */
	private By viewBlock(int num){
	
		return By.xpath("//section[@id='fresh']/ol/li["+num+"]/div[@class='listData midGrey']/span");
	}
	
	/*
	 * This function is used to check presence of list item.
	 */
	public String getTextOfViews(int num){
		return safeGetText(viewBlock(num),MEDIUMWAIT);
		
	}	

	/*
	 * Locator for the list item.
	 */
	private By listLink(int num){
	
		return By.xpath("//section[@id='fresh']/ol/li["+num+"]/h3/a");
	}
	
	/*
	 * This function is used to check presence of list item.
	 */
	public String gethrefOfList(int num){
		return driver.findElement(listLink(num)).getAttribute("href");
		
	}	

	/*
	 * This function is used to check presence of list item.
	 */
	public void clickOnList(int num){
		safeJavaScriptClick(listLink(num),MEDIUMWAIT);
		
	}	

	/*
	 * Locator for the list item.
	 */
	private By ultimateLikstIcon(int num){
	
		return By.xpath("//section[@id='fresh']/ol/li["+num+"]//span[@class='rnkrCRRed float capitalize']");
	}
	
	/*
	 * This function is used to check presence of list item.
	 */
	public boolean isListUltimate(int num){
		return isElementPresent(ultimateLikstIcon(num),VERYSHORTWAIT);
	}	
	
	/*
	 * Locator for the list item.
	 */
	private By profile(int num){
	
		return By.xpath("//section[@id='fresh']/ol/li["+num+"]//a[@class='openUP']");
	}
	
	/*
	 * This function is used to check presence of list item.
	 */
	public String gethrefOfProfile(int num){
		return driver.findElement(profile(num)).getAttribute("href");
	}		
	

	/*
	 * This function is used to check presence of list item.
	 */
	public void clickOnProfile(int num){
		safeJavaScriptClick(profile(num),MEDIUMWAIT);
	}		
	
	/*
	 * Locator for the list item.
	 */
	private By ultimateProfile(int num){
	
		return By.xpath("//section[@id='fresh']/ol/li["+num+"]//div[@class='float relative box newContributeBlk']/span[1]");
	}
	
	/*
	 * This function is used to check presence of list item.
	 */
	public String gethrefOfUltimateProfile(int num){
		return driver.findElement(ultimateProfile(num)).getAttribute("data-internal-url");
	}		
	

	/*
	 * This function is used to check presence of list item.
	 */
	public void clickOnUltimateProfile(int num){
		safeJavaScriptClick(ultimateProfile(num),MEDIUMWAIT);
	}
	/*
	 * Locator for the filter item.
	 */
	private By filteradd(int num){
		if (isElementPresent(By.xpath("//ul[@id='facetTags']/li["+num+"]/span"),30))
			return By.xpath("//ul[@id='facetTags']/li["+num+"]/span");
			else
				return By.xpath("//ul[@id='facetTags']/li["+num+"]/a");
		//return By.xpath("//div[@id='facetList']/ul[@id='facetTags']/li["+num+"]");
	}
	/*
	 * This function is used add filter
	 */
	public void clickOnaddfilter(int num){
		safeJavaScriptClick(filteradd(num),MEDIUMWAIT);
	}
//	/*
//	 * Locator for the filter item.
//	 */
//	private By filteraddclass(int num){
//		if (isElementPresent(By.xpath("//ul[@id='facetTags']/li["+num+"]/span"),30))
//		return By.xpath("//ul[@id='facetTags']/li["+num+"]/span");
//		else
//			return By.xpath("//ul[@id='facetTags']/li["+num+"]/a");
//		//return By.xpath("//div[@id='facetList']/ul[@id='facetTags']/li["+num+"]");
//	}
//	/*
//	 * This function is used add filter
//	 */
//	public void clickOnaddfilterclass(int num){
//		safeJavaScriptClick(filteraddclass(num),MEDIUMWAIT);
//	}
	/*
	 * Locator for the selected  filter item.
	 */
	private By selectfilter(int num){
		return By.xpath("//ul[@id='facetSelected']/li["+num+"]");
	}
	/*
	 * This function is used to check presence of list item.
	 */
	public boolean isfilterPresent(int num){
		return isElementPresent(selectfilter(num),MEDIUMWAIT);
	}
	/*
	 * Locator for the show more
	 */
	private By showmore(){
		return By.id("facetMore");
	}
	/*
	 * This function is used add filter
	 */
	public void clickOnshowmore(){
		safeJavaScriptClick(showmore(),MEDIUMWAIT);
	}
	/*
	 * Locator for more filters
	 */
	private By morefilters(){
		return By.id("facetTags");
	}
	/*
	 * This function is used to check presence of list item.
	 */
	public boolean isPresentmorefilters(){
		return isElementPresent(morefilters(),MEDIUMWAIT);
	}
	/*
	 * Locator for the delete filter
	 */
	private By deletefilter(int num){
		return By.xpath("//ul[@id='facetSelected']/li["+num+"]//span[@class='ui-icon ui-icon-close white']");
	}
	/*
	 * This function is used add filter
	 */
	public void clickOndeletefilter(int num){
		safeJavaScriptClick(deletefilter(num),MEDIUMWAIT);
	}
	/*
	 * Locator for Featured List images count
	 */
	private By featuredlistimage(int num){
		return By.xpath("//section[@id='voteRank']/article["+num+"]");
	}
	/*
	 * This function is used to check presence of featured list in images
	 */
	public boolean isPresentfeaturedlistimage(int num){
		return isElementPresent(featuredlistimage(num),MEDIUMWAIT);
	}
	/*
	 * Locator for Featured List title count
	 */
	private By featuredlisttitle(int num){
		return By.xpath("//section[@id='voteRank']/article["+num+"]/h2/a");
	}
	/*
	 * This function is used click on featured list block
	 */
	public void clickOnfeaturedlisttitle(int num){
		safeJavaScriptClick(featuredlisttitle(num),MEDIUMWAIT);
	}
	/*
	 * Function to get href of featured list block
	 */
	public String gethrefOffeaturedlisttitle(int num) {
		return driver.findElement(featuredlisttitle(num)).getAttribute("href");
	}
	/*
	 * This function is used to check presence of featured list in images
	 */
	public boolean isPresentfeaturedlisttitle(int num){
		return isElementPresent(featuredlisttitle(num),MEDIUMWAIT);
	}
	/*
	 * Locator for Featured List in hover vote icon
	 */
	private By hovervoteicon(int num){
		return By.xpath("//section[@id='voteRank']/article["+num+"]/div[@class='float absolute center white details help toolTip']");
	}
	/*
	 * Function to hover over vote icon
	 */
	public void hoverOnvoteicon(int num) {
		mouseHover(hovervoteicon(num), MEDIUMWAIT);
		// mouseHoverJScript(nodeEditAndDelete(txt),"a", MEDIUMWAIT);
	}
	/*
	 * Locator for Featured List in hover vote icon
	 */
	private By lightboxhoveronvoteicon(){
		return By.xpath("//div[@class='float absolute center white details help toolTip']");
	}
	/*
	 * This function is used to check presence of light box hover on vote icon
	 */
	public boolean isPresentlightbox(){
		return isElementPresent(lightboxhoveronvoteicon(),SHORTWAIT);
	}
	/*
	 * Locator for Featured List in most listed block
	 */
	private By mostlidtedblock(){
		return By.id("nodeScrollTitle");
	}
	/*
	 * This function is used to check presence of light box hover on vote icon
	 */
	public boolean isPresentmostlidtedblock(){
		return isElementPresent(mostlidtedblock(),SHORTWAIT);
	}
	/*
	 * Locator for mostd Listed block in click any link
	 */
	private By Mostlistdlist(int num){
		return By.xpath("//section[@id='nodeScroll']/div[@id='nodeScrollOuter']/div[@id='nodeScrollInner']/ol/li["+num+"]/a");
	}
	/*
	 * This function is used click on featured list block
	 */
	public void clickOnMostlistdlist(int num){
		waitForElementVisible(Mostlistdlist(num),40);
		safeClick(Mostlistdlist(num),MEDIUMWAIT);
	}
	/*
	 * Function to get href of featured list block
	 */
	public String gethrefOfMostlistdlist(int num) {
		waitForElementVisible(Mostlistdlist(num), 30);
		return driver.findElement(Mostlistdlist(num)).getAttribute("href");
	}
	/*
	 * Locator for mosted Listed block in get number of list
	 */
	    private By Mostlistdnumber(int num){
		return By.xpath("//section[@id='nodeScroll']/div[@id='nodeScrollOuter']/div[@id='nodeScrollInner']/ol/li["+num+"]/a/span");
	}
	   /*
		 * Function to get number of most listed block 
		 */
		 public String getnumberOfmostlisted(int num) {
			 waitForElementVisible(Mostlistdnumber(num), 30);
			return safeGetText(Mostlistdnumber(num), MEDIUMWAIT);
		}
		   /*
			 * This function is used to check presence of listed block list is present
			 */
			public boolean isPresentMostlistdnumber(int num){
				return isElementPresent(Mostlistdnumber(num),SHORTWAIT);
			}
			/*
			 * Locator for mostd Listed block in click any link
			 */
			private By Paginationarrow(String txt){
				if(txt.equalsIgnoreCase("right"))
					return By.xpath("//div[@id='nodeScrollNav']//span[@class='inlineBlock shape arrowSmallRight white pointer']");
				else{
					return	By.xpath("//div[@id='nodeScrollNav']//span[@class='inlineBlock shape arrowSmallLeft white pointer']");
				}
				
			}
			/*
			 * This function is used click on featured list block
			 */
			public void clickOnPaginationarrow(String txt, int num){
				waitForElementVisible(Mostlistdnumber(num), 50);
				safeClick(Paginationarrow(txt),MEDIUMWAIT);
			}
			/*
			 * Locator for categorylink in class page
			 */
			private By categorylink(){
				
					return By.xpath("//div[@id='siteBody']/article[@id='landing']/header[@id='landingHead']/h1/a");
			}
			/*
			 * This function is used click on featured list block
			 */
			public void clickOncategorylink(){
				safeClick(categorylink(),MEDIUMWAIT);
			}
			/*
			 * Function to get href of categorylink
			 */
			public String gethrefOfcategorylink() {
				return driver.findElement(categorylink()).getAttribute("href");
			}
			/*
			 * Locator for browseblocklist in class page
			 */
			private By browseblocklist (int num){
					return By.xpath("//div[@id='browseCat']/ol/li["+num+"]/a");
			}
			/*
			 * This function is used click on browse block list 
			 */
			public void clickOnbrowseblocklist(int num){
				safeClick(browseblocklist(num),MEDIUMWAIT);
			}
			/*
			 * Function to get href of browse block list
			 */
			public String gethrefOfbrowseblocklist(int num) {
				return driver.findElement(browseblocklist(num)).getAttribute("href");
			}
			 /*
			 * This function is used to check clickable of browse block list
			 */
			public boolean isclickablebrowseblocklist(int num){
				return isElementClickable(browseblocklist(num),SHORTWAIT);
			}
			/*
			 * Locator for Listopediablocklist in class page
			 */
			private By Listopediablocklist (int num){
					return By.xpath("//div[@id='browseCat']/ol/li["+num+"]/a");
			}
			/*
			 * This function is used click on Listopedia block list
			 */
			public void clickOnListopediablocklist(int num){
				safeClick(Listopediablocklist(num),MEDIUMWAIT);
			}
			/*
			 * Function to get href of Listopedia block list
			 */
			public String gethrefOfListopediablocklist(int num) {
				return driver.findElement(Listopediablocklist(num)).getAttribute("href");
			}	
			/*
			 * Locator for Listopediablocklist in class page "see-all"
			 */
			private By Listopediablockseeall (){
					return By.xpath("//div[@class='viewAll rnkrBGreyBg center lowercase']/a");
			}
			/*
			 * This function is used click on Listopedia block list in "see-all"
			 */
			public void clickOnListopediablockseeall(){
				safeClick(Listopediablockseeall(),MEDIUMWAIT);
			}
			/*
			 * Function to get href of Listopedia block list in "see-all"
			 */
			public String gethrefOfListopediablockseeall() {
				return driver.findElement(Listopediablockseeall()).getAttribute("href");
			}
			/*
			 * Locator for ads block"
			 */
			private By ads1(){
				
			return By.xpath("//div[contains(@id,'google')]");
			}
			/*
			 * This function is used to check presence of listed block list is present
			 */
			public boolean isPresentads1(){
				scrollIntoViewThroughJavaScriptExecuter(ads1());
				return isElementPresent(ads1(),SHORTWAIT);
			}
			/*
			 * Locator for Featured List in most listed block
			 */
			private By numberoflistitems(){
				return By.id("facetCount");
			}
			/*
			 * This function is used to get number of list
			 */
			public String getNumbersOfList(){
				return safeGetText(numberoflistitems(),MEDIUMWAIT);
			}
			/*
			 * Locator for number  of list item
			 */
			private By numberoflistitem(){
			return By.xpath("//div[@id='landingInfo']/section[@id='fresh']/ol/li");
			}/*
			 * This function is used to get number of list
			 */
			public List<WebElement> getOfListofnumber(){
				return driver.findElements(numberoflistitem());
			}
			
}
