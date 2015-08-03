package com.paeobjects.home;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;

import com.dataprovider.ConfigManager;
import com.paeobjects.navbar.NavBar;
import com.selenium.SafeActions;

public class Home extends SafeActions{
	ConfigManager sysProp=new ConfigManager("Sys");
	public Home(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	private WebDriver driver;
	
	private By userLogo(){
		return By.xpath("//img[@id='userProfileImg']");
	}
	
	private By close(){
		return By.xpath("//button[@title='close']/span");
	}
	
	private By logout(){
		return By.linkText("logout");
	}
	
	public boolean veriifyUserLogo(){
		return isElementPresent(userLogo());
	}
	
	public void doclose(){
		safeClick(close(), MEDIUMWAIT);
	}
	public NavBar doLogout(){
		try{Thread.sleep(5000);}catch (Exception e) {}
		safeJavaScriptClick(userLogo(), MEDIUMWAIT);//mousehover
		safeJavaScriptClick(logout(), MEDIUMWAIT);
		return new NavBar(driver);
	}
	
	public void clickUserLogo(){
		safeClick(userLogo());
	}
	
	public boolean isUserLogoPresent(){
		return isElementPresent(userLogo(),SHORTWAIT);
	}
	/*
	 * Locator for header of live ranking's link page.
	 */
	private By latestMyListName(int i){
		return By.xpath("//div[@id='userAreaListsCntr']/ul[@id='userAreaLists']/li["+i+"]/p/span");
	}
	
	private By numberOfAlert(){
		return By.xpath("//div[@id='userArea']/span[@class='float absolute block rnkrVRRedBg white userAlertCount']");
	}
	
	public String getNumberOfAlerts(){
		return safeGetText(numberOfAlert(), MEDIUMWAIT);
	}
	
	public boolean isNumberOfAlerts(){
		return isElementPresent(numberOfAlert(), MEDIUMWAIT);
	}
	
	private By FirstAlert(){
		return By.xpath("//div[@id='userAreaAlertsCntr']/ul[@id='userAreaAlerts']/li[1]/p/a[1]");
	}
	
	public void clickFirstAlert(){
		safeJavaScriptClick(FirstAlert(), MEDIUMWAIT);
	}
	
	private By editSettings(){
		return By.xpath("//div[@id='userAreaMenu']/ul[@class='floatRight relative main']/li[2]/a");
	}
	
	public void clickOnEditSettings(){
		safeClick(editSettings(), MEDIUMWAIT);
	}
	
	private By badges(){
		return By.xpath("//div[@id='userAreaMenu']/ul[@class='floatRight relative main']/li[3]/a");
	}
	
	public void clickOnBadges(){
		safeClick(badges(), MEDIUMWAIT);
	}
	
	private By following(){
		return By.xpath("//div[@id='userAreaMenu']/ul[@class='floatRight relative main']/li[4]/a");
	}
	
	public void clickOnFollowing(){
		safeClick(following(), MEDIUMWAIT);
	}
	
	/*
	 * Function to get text of the header of page appearing on click on live ranking links.
     */
	public String getLatestMyListName(){
		return safeGetText(latestMyListName(1), MEDIUMWAIT);
	}
	
	public void clickOnListInMyLatestList(int i){
		safeClick(latestMyListName(i), SHORTWAIT);
	}
	
	/*
	 * Function to hover on user logo.
	 */
	public void hoverOnUserLogo(){
		safeJavaScriptClick(userLogo(), MEDIUMWAIT);
	}
	/*
	 * Locator for live ranking.
	 */
	private By liveRanking(String number){
		return By.xpath("//div[@id='ivTicker']/ul[@id='ivtList']/li["+number+"]/a");
	}
	/*
	 * Function to hover on live ranking links.
	 */
	public void hoverOverLiveRanking(int number){
		 mouseHover(liveRanking(number+""), LONGWAIT);
	}
	/*
	 * Locator for color of live ranking links.
	 */
	private By liveRankingColor(String num){
		return By.xpath("//div[@id='ivTicker']/ul[@id='ivtList']/li["+num+"]/a/em");
	}
	/*
	 * Function to get color of live ranking links on hovering.
	 */
	public String getColorOfLiveRanking(int num){
		return driver.findElement(liveRankingColor(num+"")).getCssValue("color");
	}
	/*
	 * Locator for header of live ranking's link page.
	 */
	private By headerOfNextPageLiveRanking(){
		return By.xpath("//div[@id='listDesc']/h1/span");
	}
	/*
	 * Function to get text of the header of page appearing on click on live ranking links.
     */
	public String getTextHeaderOfNextPageLiveRanking(){
		return safeGetText(headerOfNextPageLiveRanking(), VERYLONGWAIT);
	}
	/*
	 * Locator for color of live ranking links.
	 */
	private By liveRankingLink(String num){
		return By.xpath("//div[@id='ivTicker']/ul[@id='ivtList']/li["+num+"]/a/em");
	}
	/*
	 * Function to get text of link in live ranking.
	 */
	public String getTextOfLiveRankingLink(int number){
		return driver.findElement(liveRankingLink(number+"")).getText();
		//return safeGetText(liveRankingLink(number+""), VERYLONGWAIT);
	}
	/*
	 * Function to make click on link in live ranking.
	 */
	public void clickOnLiveRankingLink(int number){
		WebElement element = driver.findElement(liveRankingLink(number+""));
		try{
			element.click();
		}catch(Exception e){
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
			//safeClick(liveRankingLink(number+""), VERYLONGWAIT);
	}
	
	/*
	 * Locator for header of Film 
	 */
	private By FilmSection(String number){
		return By.xpath("//strong[contains(text(),'film')]/../../..//following-sibling::*[1]/li["+number+"]/a//img");
		//return By.xpath("//section[@class='featuredTagBlock'][3]/ol/li["+number+"]/a//img");
	}
	/*
	 * Locator for header of Film section
	 */
	private By FilmSectionHeader(String number){
		return By.xpath("//strong[contains(text(),'film')]/../../..//following-sibling::*[1]/li["+number+"]/a/span");
	}
	/*
	 * Locator for ClickonFilmSectionHeader
	 */
	 private By ClickonFilmSectionHeader(){
			return By.xpath("//div[@id='listDesc']/h1/span");
	 }
	 /*
	  * Function is used to section is present in film section
	  */
	 public boolean isImagePresentInFilmSection(int number){
		 return isElementPresent(FilmSection(number+""), VERYLONGWAIT);
	 }
	 /*
	  * Function is used to get Text of film section Header
	  */
	 public String getTextfilmsectionHeader(int number){
		 return safeGetText(FilmSectionHeader(number+""), VERYLONGWAIT);
	 }
	/*
	 * Locator for hrefOfFilmItem
	 */
	 private By hrefOfFilmItem(String number){
		 return By.xpath("//strong[contains(text(),'film')]/../../..//following-sibling::*[1]/li["+number+"]/a");
	 }
	 public String gethrefOfFilmItem(int number){
		 return driver.findElement(hrefOfFilmItem(number+"")).getAttribute("href");
	 }
	 /*
	  * Function is used to Click on film section Header
	  */
	 public void clickOnFilmSectionHeader(int number){
		 
			 safeJavaScriptClick(FilmSectionHeader(number+""), VERYLONGWAIT);
			  
		// safeJavaScriptClick(FilmSectionHeader(number+""), MEDIUMWAIT);
	 }
	 /*
	 * Function is used to get Text of film section Header afert click on header
	 */	
	 public String getTextofclickOnFilmSectionHeader(int number){
		 	return safeGetText(ClickonFilmSectionHeader(), MEDIUMWAIT);
	 }
	 /*
	  * Locator for vote in film section
	  */
	 private By voteinfilm(String number){
		 return By.xpath("//strong[contains(text(),'film')]/../../..//following-sibling::*[1]/li["+number+"]/a//em[contains(text(),'votes')]");
	 }	
	 /*
	  * function is used to check vote in film
	  */
	 public boolean isVotePresentInFilmSection(int number){
		 return isElementPresent(voteinfilm(number+""), MEDIUMWAIT);
	 }
		    
	 /*
	  * Function to get text of the header of page appearing on click on live ranking links.
	  */
	 public String getTextofvote(int number){
		 return safeGetText(voteinfilm(number+""), MEDIUMWAIT);
	 }
	 
	 /*
	  * Locator for header of Film 
	  */
	 private By Filmnextbutton(){
		 return By.xpath("//strong[contains(text(),'film')]/..//following-sibling::*[1]");
		 //return By.xpath("//section[@class='featuredTagBlock'][3]/header/h2/a[2]");
	}
	 /*
	  * This function is used to click on next button in film section
	  */
	 public void clickonnextbuttoninfilm(){
//		 try{
//			   safeClick(Filmnextbutton(), VERYLONGWAIT);
//			  }catch(Exception e){
			   safeJavaScriptClick(Filmnextbutton(), VERYLONGWAIT);
			 // }
		// safeClick(Filmnextbutton(),MEDIUMWAIT);
	 }	
	 /*
	  * Locator for  Film innext button
	  */
	 private By ClickonFilmnextbutton(){
		 return By.xpath("//div[@id='siteBody']/article[@id='landing']/header[@id='landingHead']/h1");
	 }
	 /*
	  * function is used to check on more in film
	  */
	 public boolean isPresentFilmHeaderaferclickonmore(){
		 return isElementPresent(ClickonFilmnextbutton(),VERYLONGWAIT);
	 }	
	 /*
	  * Locator for  Film in more
	  */
	 private By Filminmore(String number){
		 return By.xpath("//strong[contains(text(),'film')]/../../..//following-sibling::*[1]/li["+number+"]/a//span[@class='rnkrBlue']");
	 }	
		
	 /*
	  * function is used to clickon more
	  */
	public void clickonFilminmore(int number){
		 
			   safeJavaScriptClick(Filminmore(number+""), VERYLONGWAIT);
			
		//safeClick(Filminmore(number+""),MEDIUMWAIT);
	}
		
	private By morelistaboutfilm(){
		//strong[contains(text(),'film')]/..//following-sibling::*[1]"
		//return By.xpath("//section[@class='featuredTagBlock'][3]/a");
		return By.xpath("//strong[contains(text(),'film')]/../../..//following-sibling::*[2]");
	}
	public void clickonmorelistaboutfilm(){
		//(Filminmore(number+"")); 
//		 try{
//			   safeClick(morelistaboutfilm(), VERYLONGWAIT);
//			  }catch(Exception e){
			   safeJavaScriptClick(morelistaboutfilm(), VERYLONGWAIT);
			//  }
		//safeClick(morelistaboutfilm(),MEDIUMWAIT);
	}
		
	/*
	 * Locator of slider image.
	 */
	private By slider(int num){
		return By.xpath("//section[@id='edCarousel']/div[@id='edCarouselContainer']/article["+num+"]/a/strong");
	}
	/*
	 * Locator of  get href slider image.
	 */
	private By gethrefslider(String num){
		return By.xpath("//div[@id='landingBody']/section[@id='edCarousel']/div[@id='edCarouselContainer']/article["+num+"]/a");
	}
	/*
	 * Function to get href attribute of image in slider.
	 */
	public String getHrefOfSliderImage(int number){
		return driver.findElement(gethrefslider(number+"")).getAttribute("href");
	}
	/*
	 * Locator for holding the slider images.
	 */
	private By holdingSliderImage(int number){  
		return By.xpath("//div[@id='edCarouselNav']/span["+number+"]");
	}
		
	/*
	 * Function to make click on the buttons on slider.
	 */
	public void clickOnholdingSliderImage(int num){
//		try{
//			safeClick(holdingSliderImage(num), VERYLONGWAIT);
//			  }catch(Exception e){
			   safeJavaScriptClick(holdingSliderImage(num), VERYLONGWAIT);
			//  }
		//safeClick(holdingSliderImage(num+""), LONGWAIT);
	}
	/*
	 * Function to check the presence of total slider images.
	 */
	public Boolean isholdingSliderImagePresent(int num){
		return isElementPresent(holdingSliderImage(num),MEDIUMWAIT);
	}
	/*
	 * Function to make click on image in slider.
	 */
	public void clickOnSliderImage(int number){
//		try{
//			safeClick(slider(number), VERYLONGWAIT);
//			  }catch(Exception e){
//			   safeJavaScriptClick(slider(number), VERYLONGWAIT);
//			  }
		safeJavaScriptClick(slider(number), LONGWAIT);
	}
	/*
	 * Locator for ranking right now sections.
	 */
	private By rankingRightNowSection(String number){
			return By.xpath("//strong[contains(text(),'Ranking Right Now')]/../../..//following-sibling::*[1]/li["+number+"]/a");
	}
	/*
	 * Function to check the presence of total sections in ranking right now block.
	 */
	public Boolean isrankingRightNowSectionPresent(int num){
		return isElementPresent(rankingRightNowSection(num+""),MEDIUMWAIT);
	}
	/*
	 * Function to make click on sections in ranking right now.
	 */
	public void clickOnrankingRightNowSection(int num){
//		try{
//			safeClick(rankingRightNowSection(num+""), VERYLONGWAIT);
//			  }catch(Exception e){
			   safeJavaScriptClick(rankingRightNowSection(num+""), VERYLONGWAIT);
			 // }
		//safeClick(rankingRightNowSection(num+""), MEDIUMWAIT);
	}
	/*
	 * Function to get text of particular section in ranking right now block. 
	 */
	public String getHrefOfrankingRightNowSection(int num){
		return driver.findElement(rankingRightNowSection(num+"")).getAttribute("href");
	}
	/*
	 * Locator for vote in RightNow section
	 */
	private By voteinRightNow(String number){
		return By.xpath("//strong[contains(text(),'Ranking Right Now')]/../../..//following-sibling::*[1]/li["+number+"]/a//em[contains(text(),'votes')]");
	}
	/*
	 * function is used to check vote in RightNow
	 */
	public boolean isVotePresentInRightNow(int number){
		return isElementPresent(voteinRightNow(number+""), MEDIUMWAIT);
	}
	
	/*
	 * Function to get text of the header of page appearing on click on live ranking links.
	 */
	public String getTextofvoteRightNow(int number){
		return safeGetText(voteinRightNow(number+""), VERYLONGWAIT);
	}
	/*
	 * Locator for Popular On Facebook.
	 */
	private By PopularOnFacebook(String number){
		return By.xpath("//strong[contains(text(),'popular on')]/../..//following-sibling::*[1]/li["+number+"]/a");
	}
	/*
	 * Function to check the presence of total sections in Popular On Facebook.
	 */
	public Boolean isPopularOnFacebookPresent(int num){
		return isElementPresent(PopularOnFacebook(num+""));
	}
	/*
	 * Function to make click on sections in Popular On Facebook.
	 */
	public void clickOnPopularOnFacebookSection(int num){
		safeJavaScriptClick(PopularOnFacebook(num+""), MEDIUMWAIT);
	}
	/*
	 * Function to get text of particular section in Popular On Facebook. 
	 */
	public String getHrefOfPopularOnFacebookSection(int num){
		return driver.findElement(PopularOnFacebook(num+"")).getAttribute("href");
	}
	/*
	 * Locator for header of next page on clicking on any section in Popular On Facebook.
	 */
	private By headerOfNextPagePopularOnFacebookSection(){
		return By.xpath("//div[@id='siteBody']/article[@id='list']/header[@id='listHead']/div[@id='listDesc']/h1/span");
	}
	/*
	 * Function to get the text of header of next page coming on clicking on any section in Popular On Facebook.
	 */
	public String geturlOfNextPagePopularOnFacebookSection(){
		return driver.findElement(headerOfNextPagePopularOnFacebookSection()).getAttribute("data-internal-url");
	}
		
	/*
	 * Locator for facebook like button. 
	 */
	private By facebook(){
		return By.xpath("//table[contains(@class,'pluginConnectButtonLayoutRoot')]/tbody/tr[1]/td[1]//form[@action='/plugins/like/connect']/div[@class='pluginConnectButton']/div[@title='Like']//div[@class='pluginButtonContainer']/div[@class='pluginButtonImage']/button[@type='submit']/i");
	}
		
	/*
	 * Locator for facebook frame. 
	 */
	private By facebookFrame(){
		return By.xpath("//strong[contains(text(),'popular on ')]/../../..//following-sibling::*[1]//div[@class='inlineBlock fb-like fb_iframe_widget']//iframe[@title='fb:like Facebook Social Plugin']");
	}
		
	/*
	 * Function to click on facebook like button.
	 */
	public void clickOnfacebook(){
		driver.switchTo().frame(driver.findElement(facebookFrame()));
		waitForElementVisible(facebook(), 70);
		//try{
			safeJavaScriptClick(facebook(), VERYLONGWAIT);
//		 }catch(Exception e){
//			safeClick(facebook(), VERYLONGWAIT);
//		 }	
		//safeClick(facebook(), MEDIUMWAIT);
		driver.switchTo().defaultContent();
	}
		
	/*
	 * Switch to new window and get title. 
	 */
	public String switchToWindowAndGetTitle(){
		switchToNewWindow();
		return getTitle();
	}
		
	/*
	 * Switch to parent window.
	 */
	public void switchToParentWindow(){
		switchToWindow(0);	
	}	

	/*
	 * Locator for most tweeted.
	 */
	private By mostTweeted(String number){
		return By.xpath("//strong[contains(text(),'most')]/../../..//following-sibling::*[1]/li["+number+"]/a");
	}
	/*
	 * Function to check the presence of total sections in most tweeted.
	 */
	public Boolean isMostTweetedPresent(int num){
		return isElementPresent(mostTweeted(num+""));
	}
	/*
	 * Function to make click on sections in most tweeted.
	 */
	public void clickOnMostTweetedSection(int num){
		safeJavaScriptClick(mostTweeted(num+""), MEDIUMWAIT);
	}
	/*
	 * Function to get text of particular section in most tweeted. 
	 */
	public String getHrefOfMostTweetedSection(int num){
		return driver.findElement(mostTweeted(num+"")).getAttribute("href");
	}
	/*
	 * Locator for header of next page on clicking on any section in most tweeted.
	 */
	private By headerOfNextPageMostTweetedSection(){
		return By.xpath("//div[@id='siteBody']/article[@id='list']/header[@id='listHead']/div[@id='listDesc']/h1/span");
	}
	/*
	 * Function to get the text of header of next page coming on clicking on any section in most tweeted.
	 */
	public String geturlOfNextPageMostTweetedSection(){
		return driver.findElement(headerOfNextPageMostTweetedSection()).getAttribute("data-internal-url");
	}
	/*
	 * Locator for twitter frame.
	 */
	private By twitterFrame(){
		return By.xpath("//strong[contains(text(),'most')]/../../..//following-sibling::*[1]/iframe[@title='Twitter Follow Button']");
	}
	/*
	 * Locator for twitter follow link.
	 */
	private By twitter(){
		return By.xpath("//div[@id='widget']/div[@class='btn-o']/a[@id='follow-button']");
	}
	/*
	 * Function to make click on twitter follow link.
	 */
	public void clickOnTwitter(){
		driver.switchTo().frame(driver.findElement(twitterFrame()));
		safeClick(twitter(), MEDIUMWAIT);
		driver.switchTo().defaultContent();
	}
	/*
	 * Locator for recently reranked.
	 */
	private By recentlyReranked(int number){
		return By.xpath("//strong[contains(text(),'Recently Reranked')]/../../..//following-sibling::*[1]/li["+number+"]/a");
	}
	/*
	 * Function to check the presence of total sections in recently reranked.
	 */
	public Boolean isRecentlyRerankedPresent(int num){
		return isElementPresent(recentlyReranked(num));
	}
	/*
	 * Function to make click on sections in recently reranked.
	 */
	public void clickOnRecentlyRerankedSection(int num){
		safeJavaScriptClick(recentlyReranked(num), MEDIUMWAIT);
	}
	/*
	 * Function to get text of particular section in recently reranked. 
	 */
	public String getHrefOfRecentlyRerankedSectionProfile(int num1,int num2){
		return driver.findElement(recentlyRerankedProfileLink(num1+"",num2+"")).getAttribute("href");
	}
	/*
	 * Function to get text of particular section in recently reranked. 
	 */
	public String getHrefOfRecentlyRerankedSection(int num){
		return driver.findElement(recentlyReranked(num)).getAttribute("href");
	}
	/*
	 * Locator for header of next page on clicking on any section in recently reranked.
	 */
	private By headerOfNextPageRecentlyRerankedSection(){
		return By.xpath("//div[@id='siteBody']/article[@id='list']/header[@id='listHead']/div[@id='listDesc']/h1/span");
	}
	/*
	 * Function to get the text of header of next page coming on clicking on any section in recently reranked.
	 */
	public String geturlOfNextPageRecentlyRerankedSection(){
		return driver.findElement(headerOfNextPageRecentlyRerankedSection()).getAttribute("data-internal-url");
	}
	/*
	 * Locator for recently reranked arrow.
	 */
	private By recentlyRerankedArrow(){
		return By.xpath("//article[@id='landing']/div[@id='landingBody']/section[@class='rerankOnlyUltimate']/header/h2/a");
	}
	/*
	 * Function to make click on arrow in recently reranked section.
	 */
	public void clickOnrecentlyRerankedArrow(){
		safeClick(recentlyRerankedArrow(), MEDIUMWAIT);
	}
	/*
	 * Locator for recently reranked next page on arrow click.
	 */
	private By recentlyRerankedNextPage(){
		return By.xpath("//div[@id='siteBody']/article[@id='landing']/header[@id='landingHead']/h1");
	}
	/*
	 * Function to check the presence of next page header after clicking on arrow.
	 */
	public Boolean isrecentlyRerankedNextPagePresent(){
		return isElementPresent(recentlyRerankedNextPage());
	}
	/*
	 * Locator for recently reranked profile link.
	 */
	private By recentlyRerankedProfileLink(String number,String num){
		return By.xpath("//strong[contains(text(),'Recently Reranked')]/../../..//following-sibling::*[1]/li["+number+"]/em["+num+"]/a");
	}
		
	/*
	 * Function to make click on recently reranked block's profile link.
	 */
	public void clickOnrecentlyRerankedProfileLink(int number,int num){
		safeClick(recentlyRerankedProfileLink(number+"",num+""), LONGWAIT);
	}
		
	/*
	 * Locator for header of Tv
	 */
	private By TVSection(String number){
		return By.xpath("//strong[contains(text(),'tv')]/../../..//following-sibling::*[1]/li["+number+"]/a//img");
	}
	/*
	 * Locator for header of TV section
	 */
	private By TvSectionHeader(String number){
		return By.xpath("//strong[contains(text(),'tv')]/../../..//following-sibling::*[1]/li["+number+"]/a/span");
	}	
	/*
	 * Function is used to images is present in TV section
	 */
	public boolean isImagePresentInTVSection(int number){
		return isElementPresent(TVSection(number+""), VERYLONGWAIT);
	 }	
	/*
	 * Locator of TV section in href of image
	 */
	private By hrefOfTVItem(String number){
		return By.xpath("//strong[contains(text(),'tv')]/../../..//following-sibling::*[1]/li["+number+"]/a");
	}
	/*
	 * Function is used to get href Of TV Item
	 */
	public String gethrefOfTVItem(int number){
		return driver.findElement(hrefOfTVItem(number+"")).getAttribute("href");
	}
	/*
	 * Function is used to click OnTV Section Header
	 */
	public void clickOnTVSectionHeader(int number){
		safeClick(TvSectionHeader(number+""), MEDIUMWAIT);
	}	 
	/*
	 * Locator for header of TV next button 
	 */
	private By TVnextbutton(){
		return By.xpath("//strong[contains(text(),'tv')]/..//following-sibling::*[1]");
	}
	/*
	 * Function is used to click On TV Section Header in next button
	 */
	public void clickonnextbuttoninTV(){
		safeClick(TVnextbutton(),MEDIUMWAIT);
	}
	/*
	 * Locator for TV next button after click
	 */
	private By ClickonTVnextbutton(){
		return By.xpath("//div[@id='siteBody']/article[@id='landing']/header[@id='landingHead']/h1");
	}
	/*
	 * Funtion is used to click on next button in TV and link corresponding link
	 */
	public boolean isPresentTVHeaderaferclickonmore(){
		return isElementPresent(ClickonTVnextbutton(),MEDIUMWAIT);
	}
	/*
	 * Locator for  TV in more
	 */
	private By TVinmore(String number){
		return By.xpath("//strong[contains(text(),'tv')]/../../..//following-sibling::*[1]/li["+number+"]/a//span[@class='rnkrBlue']");
	}
	
	/*
	 * function is used to click on more in TV
	 */
	public void clickonTVinmore(int number){
		safeClick(TVinmore(number+""),MEDIUMWAIT);
	}
	/*
	 * Locator for  TV in morelistaboutTV
	 */
	private By morelistaboutTV(){
		return By.xpath("//strong[contains(text(),'tv')]/../../..//following-sibling::*[2]");
	}	
	/*
	 * function is used to click on morelistaboutTV
	 */
	public void clickonmorelistaboutTV(){
		safeClick(morelistaboutTV(),MEDIUMWAIT);
	}
	/*
	 * Locator for vote in Tv section
	 */
	private By voteinTv(String number){
		return By.xpath("//strong[contains(text(),'tv')]/../../..//following-sibling::*[1]/li["+number+"]/a//em[contains(text(),'votes')]");
	}
	/*
	 * function is used to check vote in Tv
	 */
	public boolean isVotePresentInTv(int number){
		return isElementPresent(voteinTv(number+""), VERYLONGWAIT);
	}
	
	/*
	 * Function to get text of the header of page appearing on click on Tv.
	 */
	public String getTextofvoteTv(int number){
		return safeGetText(voteinTv(number+""), VERYLONGWAIT);
	}
	
	/*
	 * Locator for header of Comics
	 */
	private By ComicsSection(String number){
		return By.xpath("//strong[contains(text(),'comics')]/../../..//following-sibling::*[1]/li["+number+"]/a//img");	
	}
	/*
	 * Locator for header of Comics section
	 */
	private By ComicsSectionHeader(String number){
		return By.xpath("//strong[contains(text(),'comics')]/../../..//following-sibling::*[1]/li["+number+"]/a/span");
	}	
	/*
	 * Function is used to images is present in Comics section
	 */
	public boolean isImagePresentInComicsSection(int number){
		return isElementPresent(ComicsSection(number+""), VERYLONGWAIT);
	}	
	/*
	 * Locator of Comics section in href of image
	 */
	private By hrefOfComicsItem(String number){
		return By.xpath("//strong[contains(text(),'comics')]/../../..//following-sibling::*[1]/li["+number+"]/a");
	}
	/*
	 * Function is used to get href Of Comics Item
	 */
	public String gethrefOfComicsItem(int number){
		return driver.findElement(hrefOfComicsItem(number+"")).getAttribute("href");
	}
	/*
	 * Function is used to click On Comics Section Header
	 */
	public void clickOnComicsSectionHeader(int number){
		safeClick(ComicsSectionHeader(number+""), MEDIUMWAIT);
	}	
	/*
	 * Locator for header of TV next button 
	 */
	private By Comicsnextbutton(){
		return By.xpath("//strong[contains(text(),'comics')]/..//following-sibling::*[1]");
	}
	/*
	 * Function is used to click On Comics Section Header in next button
	 */
	public void clickonnextbuttoninComics(){
		safeJavaScriptClick(Comicsnextbutton(),MEDIUMWAIT);
	}
	/*
	 * Locator for Comics next button after click
	 */
	private By ClickonComicsnextbutton(){
		return By.xpath("//div[@id='siteBody']/article[@id='landing']/header[@id='landingHead']/h1");
	}
	/*
	 * Function is used to click on next button in Comics and link corresponding link
	 */
	public boolean isPresentComicsHeaderaferclickonmore(){
		return isElementPresent(ClickonComicsnextbutton(),MEDIUMWAIT);
	}
	/*
	 * Locator for  Comics in more
	 */
	private By Comicsinmore(String number){
		return By.xpath("//strong[contains(text(),'comics')]/../../..//following-sibling::*[1]/li["+number+"]/a//span[@class='rnkrBlue']");
	}
				
	/*
	 * function is used to click on more in Comics
	 */
	public void clickonComicsinmore(int number){
		safeJavaScriptClick(Comicsinmore(number+""),MEDIUMWAIT);
	}
	/*
	 * Locator for  Comics in morelistaboutTV
	 */
	private By morelistaboutComics(){
		return By.xpath("//strong[contains(text(),'comics')]/../../..//following-sibling::*[2]");
	}	
	/*
	 * function is used to click on morelistaboutTV
	 */
	public void clickonmorelistaboutComics(){
		safeJavaScriptClick(morelistaboutComics(),MEDIUMWAIT);
	}
	/*
	 * Locator for vote in comics section
	 */
	private By voteincomics(String number){
		return By.xpath("//strong[contains(text(),'comics')]/../../..//following-sibling::*[1]/li["+number+"]/a//em[contains(text(),'votes')]");
	}
	/*
	 * function is used to check vote in comics
	 */
	public boolean isVotePresentIncomics(int number){
		return isElementPresent(voteincomics(number+""), VERYLONGWAIT);
	}
	
	/*
	 * Function to get text of the header of page appearing on click on comics.
	 */
	public String getTextofvotecomics(int number){
		return safeGetText(voteincomics(number+""), VERYLONGWAIT);
	}
	/*
	 * Locator for header of People
	 */
	private By PeopleSection(String number){
		return By.xpath("//strong[contains(text(),'people')]/../../..//following-sibling::*[1]/li["+number+"]/a//img");
	}
	/*
	 * Locator for header of People section
	 */
	private By PeopleSectionHeader(String number){
		return By.xpath("//strong[contains(text(),'people')]/../../..//following-sibling::*[1]/li["+number+"]/a/span");
	}	
	/*
	 * Function is used to images is present in Comics section
	 */
	public boolean isImagePresentInPeopleSection(int number){
		return isElementPresent(PeopleSection(number+""), VERYLONGWAIT);
	}	
	/*
	 * Locator of People section in href of image
	 */
	private By hrefOfPeopleItem(String number){
		return By.xpath("//strong[contains(text(),'people')]/../../..//following-sibling::*[1]/li["+number+"]/a");
	}
	/*
	 * Function is used to get href Of People Item
	 */
	public String gethrefOfPeopleItem(int number){
		return driver.findElement(hrefOfPeopleItem(number+"")).getAttribute("href");
	}
	/*
	 * Function is used to click On People Section Header
	 */
	public void clickOnPeopleSectionHeader(int number){
		
			safeJavaScriptClick(PeopleSectionHeader(number+""), VERYLONGWAIT);
		
		
	}	
	
	/*
	 * Locator for header of People next button 
	 */
	private By Peoplenextbutton(){
		return By.xpath("//strong[contains(text(),'people')]/..//following-sibling::*[1]");
	}
	/*
	 * Function is used to click On People Section Header in next button
	 */
	public void clickonnextbuttoninPeople(){
		safeJavaScriptClick(Peoplenextbutton(),MEDIUMWAIT);
	}
	/*
	 * Locator for People next button after click
	 */
	private By ClickonPeoplenextbutton(){
		return By.xpath("//div[@id='siteBody']/article[@id='landing']/header[@id='landingHead']/h1");
	}
	/*
	 * Function is used to click on next button in People and link corresponding link
	 */
	public boolean isPresentPeopleHeaderaferclickonmore(){
		return isElementPresent(ClickonPeoplenextbutton(),MEDIUMWAIT);
	}
	/*
	 * Locator for  People in more
	 */
	private By Peopleinmore(String number){
		return By.xpath("//strong[contains(text(),'people')]/../../..//following-sibling::*[1]/li["+number+"]/a//span[@class='rnkrBlue']");
	}
	
	/*
	 * function is used to click on more in People
	 */
	public void clickonPeopleinmore(int number){
		safeJavaScriptClick(Peopleinmore(number+""),MEDIUMWAIT);
	}
		
	/*	
	 * Locator for next arrow on ranker tv block.
	 */
	private By rankerTvArrow(){
		return By.xpath("//strong[contains(text(),'Ranker TV')]/..//following-sibling::*[2]");
	} 
	/*
	 * Function to make click on arrow in recently reranked section.
	 */
	public void clickOnrankerTvArrow(){
		safeClick(rankerTvArrow(), MEDIUMWAIT);
	}
	/*
	 * Function to get href of next page header after clicking on arrow.
	 */
	public String gethrefOfrankerTvArrow(){
		return driver.findElement(rankerTvArrow()).getAttribute("href");
	}
	/*
	 * Locator for Ranker TV Block.
	 */
	private By rankerTvBlock(String number){
		return By.xpath("//strong[contains(text(),'Ranker TV')]/../../..//following-sibling::*[1]/li["+number+"]/a");
	}
	/*
	 * Function to check the presence of total sections in ranker tv block.
	 */
	public Boolean isrankerTvBlockPresent(int num){
		return isElementPresent(rankerTvBlock(num+""));
	}
	/*
	 * Function to make click on video.
	 */
	public void clickOnRankerTvVideo(int num){
		safeClick(rankerTvBlock(num+""), MEDIUMWAIT);
	}
	/*
	 * Function to get href of video in ranker tv block.
	 */
	public String getHrefOfrankerTvBlock(int num){
		return driver.findElement(rankerTvBlock(num+"")).getAttribute("href");
	}
	/*
	 * Locator for more ranker tv.
	 */
	private By moreRankerTv(){
		return By.xpath("//strong[contains(text(),'Ranker TV')]/..//following-sibling::*[2]");
	}
	/*
	 * function to make click on more ranker TV link.
	 */
	public void clickOnmoreRankerTv(){
		safeClick(moreRankerTv(), MEDIUMWAIT);
	}
	/*
	 * Locator for youtube frame.
	 */
	private By youTubeFrame(){
		return By.xpath("//section[@class='rankerVideoBlock']/header/h2/div[contains(@id,'ytsubscribe')]/iframe");
	}
	/*
	 * Locator for youTube.
	 */
	private By youTube(){
		return By.xpath("//div[@id='yt-subscribe']/span[1]/button");
	}
	/*
	 * Function to make click on youTube link.
	 */
	public void clickOnYouTube(){
		driver.switchTo().frame(driver.findElement(youTubeFrame()));
		safeClick(youTube(), MEDIUMWAIT);
		driver.switchTo().defaultContent();
	}
	/*
	 * Locator for vote in ranker tv section
	 */
	private By voteinrankertv(String number){
		return By.xpath("//strong[contains(text(),'Ranker TV')]/../../..//following-sibling::*[1]/li["+number+"]/a//em[contains(text(),'votes')]");
	}
	/*
	 * function is used to check vote in rankertv
	 */
	public boolean isVotePresentInrankertv(int number){
		return isElementPresent(voteinrankertv(number+""), VERYLONGWAIT);
	}
	    
	/*
	 * Function to get text of the header of page appearing on click on rankertv.
	 */
	public String getTextofvoterankertv(int number){
		return safeGetText(voteinrankertv(number+""), VERYLONGWAIT);
	}
	/*
	 * Locator for  Pepole in morelistaboutPepole
	 */
	private By morelistaboutPepole(){
		return By.xpath("//strong[contains(text(),'people')]/../../..//following-sibling::*[2]");
	}	
	/*
	 * function is used to click on morelistaboutPeople
	 */
	public void clickonmorelistaboutPepole(){
		safeJavaScriptClick(morelistaboutPepole(),MEDIUMWAIT);
	}
	
	/*
	 * Locator for header of Book section
	 */
	private By BookSectionHeader(String number){
		return By.xpath("//strong[contains(text(),'books')]/../../..//following-sibling::*[1]/li["+number+"]/a/span");
	}	
	/*
	 * Function is used to images is present in Book section
     */
	public boolean isImagePresentInBookSection(int number){
		scrollIntoElementView(BookSectionHeader(number+""));
 		return isElementPresent(BookSectionHeader(number+""), VERYLONGWAIT);
 	}	
	/*
	 * Locator of Book section in href of image
     */
	private By hrefOfBookItem(String number){
		return By.xpath("//strong[contains(text(),'books')]/../../..//following-sibling::*[1]/li["+number+"]/a");
	}
	/*
	 * Function is used to get href Of Book Item
	 */
	 public String gethrefOfBookItem(int number){
	    	return driver.findElement(hrefOfBookItem(number+"")).getAttribute("href");
	 }
	 /*
	  * Function is used to click On People Section Header
	  */
	 public void clickOnBookSectionHeader(int number){
		 safeClick(BookSectionHeader(number+""), MEDIUMWAIT);
	 }	
	 /*
	  * Locator for header of Book next button 
	  */
	 private By Booknextbutton(){
		 return By.xpath("//strong[contains(text(),'books')]/..//following-sibling::*[1]");	
	 }
	 /*
	  * Function is used to click On Book Section Header in next button
	  */
	 public void clickonnextbuttoninBook(){
		 safeClick(Booknextbutton(),MEDIUMWAIT);
	 }	
	 /*
	  * Locator of Clickon Books next button
	  */
	 private By ClickonBooksnextbutton(){
		 return By.xpath("//div[@id='siteBody']/article[@id='landing']/header[@id='landingHead']/h1");
	 }
	 /*
	  * Function is used to click on next button in Book and link corresponding link
	  */
	 public boolean isPresentBookHeaderaferclickonmore(){
		 return isElementPresent(ClickonBooksnextbutton(),MEDIUMWAIT);
	 }
	 /*
	  * Locator for  Book in more
	  */
	 private By Bookinmore(String number){
		 return By.xpath("//strong[contains(text(),'books')]/../../..//following-sibling::*[1]/li["+number+"]/a//span[@class='rnkrBlue']");
	 }
	 
	 /*
	  * function is used to click on more in Book
	  */
	 public void clickonBookinmore(int number){
		 safeClick(Bookinmore(number+""),MEDIUMWAIT);
	 }
	 /*
	  * Locator for  Book in morelistaboutBook
	  */
	 private By morelistaboutBook(){
		 return By.xpath("//strong[contains(text(),'books')]/../../..//following-sibling::*[2]");
	 }	
	 /*
	  * function is used to click on morelistaboutBook
	  */
	 public void clickonmorelistaboutBook(){
		 safeJavaScriptClick(morelistaboutBook(),MEDIUMWAIT);
	 }
	 /*
	  * Locator for vote in books section
	  */
	 private By voteinbooks(String number){
		 return By.xpath("//strong[contains(text(),'books')]/../../..//following-sibling::*[1]/li["+number+"]/a//em[contains(text(),'votes')]");
	 }
	 /*
	  * function is used to check vote in books
	  */
	 public boolean isVotePresentInbooks(int number){
		 return isElementPresent(voteinbooks(number+""), VERYLONGWAIT);
	 }
	 
	 /*
	  * Function to get text of the header of page appearing on click on live ranking links.
	  */
	 public String getTextofvotebooks(int number){
		 return safeGetText(voteinbooks(number+""), VERYLONGWAIT);
	 }
	 /*
	  * Locator for header of RecentList
	  */
	 private By RecentListHeader(String number){
		//strong[contains(text(),'books')]/../../..//following-sibling::*[1]/li["+number+"]/a/span
		// return By.xpath("//section[@class='recentExcludeUltimate']/ol/li["+number+"]/a/span");// 
		 return By.xpath("//strong[contains(text(),'New lists')]/../../..//following-sibling::*[1]/li["+number+"]/a/span");
	 }	
	 /*
	  * Function is used to images is present in Book section
	  */
	 public boolean isImagePresentInRecentList(int number){
		 return isElementPresent(RecentListHeader(number+""), VERYLONGWAIT);
	 }	
	 
	 /*
	  * Locator of RecentList in href of image
	  */
	 private By hrefOfRecentListItem(String number){
		 return By.xpath("//strong[contains(text(),'New lists')]/../../..//following-sibling::*[1]/li["+number+"]/a");
		// return By.xpath("//section[@class='recentExcludeUltimate']/ol/li["+number+"]/a");
	 }
	 /*
	  * Function is used to get href Of RecentList Item
	  */
	 public String gethrefOfRecentList(int number){
		 return driver.findElement(hrefOfRecentListItem(number+"")).getAttribute("href");
	 }
	 /*
	  * Function is used to click On RecentList sections
	  */
	 public void clickOnRecentListHeader(int number){
		 safeClick(RecentListHeader(number+""), MEDIUMWAIT);
	 }		
	 /*
	  * Locator for recent List next button
	  */ 
	 private By RecentListnextbutton(){
		 return By.xpath("//strong[contains(text(),'New lists')]/..//following-sibling::*[1]");
	 }
	 /*
	  * Function is used to click On RecentListHeader in next button
	  */
	 public void clickonnextbuttoninRecentList(){
		 safeClick(RecentListnextbutton(),MEDIUMWAIT);
	 }
	 /*
	  * Locator for recent List after click on next button
	  */
	 private By ClickonNextButtonRecentList(){
		 return By.xpath("//div[@id='siteBody']/article[@id='landing']/header[@id='landingHead']/h1");
	 }
	 /*
	  * Function to check the presence of recent List after click on next button.
	  */
	 public Boolean isPresentRecentListinNextButton(){
		 return isElementPresent(ClickonNextButtonRecentList());
	 }	
	 /*
	  * Locator for Recent List ProfileLink
	  */
	 private By RecentListProfileLink(String number){
		 return By.xpath("//strong[contains(text(),'New lists')]/../../..//following-sibling::*[1]/li["+number+"]/a//em");
		 //return By.xpath("//strong[contains(text(),'Recent Lists')]/../../..//following-sibling::*[1]/li["+number+"]/a//em");
	 }
	 /*
	  * Locator for vote in Recent Lists section
	  */
	 private By voteinRecentLists(String number){
		 
		 return By.xpath("//strong[contains(text(),'New lists')]/../../..//following-sibling::*[1]/li["+number+"]/a//em[contains(text(),'votes')]");
	 }
	 /*
	  * function is used to check vote in Recent Lists
	  */
	 public boolean isVotePresentInRecentLists(int number){
		 return isElementPresent(voteinRecentLists(number+""), MEDIUMWAIT);
	 }
	 
	 /*
	  * Function to get text of the header of page appearing on click on Recent Lists.
	  */
	 public String getTextofvoteRecentLists(int number){
		 return safeGetText(voteinRecentLists(number+""), MEDIUMWAIT);
	 }
	 /*
	  * Function to make click on recently reranked block's profile link.
	  */
	 public void clickOnRecentListProfileLink(int number){
		 safeClick(RecentListProfileLink(number+""), MEDIUMWAIT);
	 }
	 /*
	  * Locator of RecentList in href of image
	  */
	 private By hrefOfRecentListProfileLink(String number){
		 return By.xpath("//strong[contains(text(),'New lists')]/../../..//following-sibling::*[1]/li["+number+"]/a");
	}
	 /*
	  * Function is used to get href Of RecentList Item
	  */
	 public String gethrefOfRecentListProfileLink(int number){
		 return driver.findElement(hrefOfRecentListProfileLink(number+"")).getAttribute("href");
	 }
	 /*
	  * Locator for  RecentList in morelistRecentList
	  */
	 private By morelistRecentList(){
		 return By.xpath("//strong[contains(text(),'New lists')]/../../..//following-sibling::*[2]");
	 }	
	 /*
	  * function is used to click on morelistRecentList
	  */
	 public void clickonmorelistRecentList(){
		 safeJavaScriptClick(morelistRecentList(),MEDIUMWAIT);
	 }
	 
	 /*
	  * Locator for header of places/travel
	  */
	 private By Place_travel(String number){
		 return By.xpath("//strong[contains(text(),'places/travel')]/../../..//following-sibling::*[1]/li["+number+"]/a//img");
	 }
	 /*
	  * Function is used to section is present in Place & travel section
	  */
	 public boolean isImagePresentInPlace_travelSection(int number){
		 return isElementPresent(Place_travel(number+""), VERYLONGWAIT);
	 }
	 /*
	  * Locator for places/travel to get href
	  */
	 private By hrefOfPlace_travel(String number){
		 return By.xpath("//strong[contains(text(),'places/travel')]/../../..//following-sibling::*[1]/li["+number+"]/a");
	 }
	 /*
	  * Function is used to get Href of Place-travel
	  */
	 public String gethrefOfPlace_travel(int number){
		 return driver.findElement(hrefOfPlace_travel(number+"")).getAttribute("href");
	 }	
	 /*
	  * Locator for header of Place_travel section
	  */
	 private By Place_travelHeader(String number){
		 return By.xpath("//strong[contains(text(),'places/travel')]/../../..//following-sibling::*[1]/li["+number+"]/a/span");
	 }
	 /*
	  * Function is used to Click on Place_travel Header
	  */
	 public void clickOnPlace_travelHeader(int number){
		 safeClick(Place_travelHeader(number+""), MEDIUMWAIT);
	 }
	 /*
	  * Locator for header of Place_travel next button 
	  */
	 private By Place_travelnextbutton(){
		 return By.xpath("//strong[contains(text(),'places/travel')]/..//following-sibling::*[1]");
	}
	 /*
	  * This function is used to click on next button in Place_travel section
	  */
	 public void clickonnextbuttoninPlace_travel(){
		 safeClick(Place_travelnextbutton(),MEDIUMWAIT);
	 }
	 /*
	  * Locator for  Place_travel in next button
	  */
	 private By ClickonPlace_travelnextbutton(){
		 return By.xpath("//div[@id='siteBody']/article[@id='landing']/header[@id='landingHead']/h1");
	 }
	 /*
	  * function is used to click on more in Place_travel
	  */
	 public boolean isPresentPlace_travelafterclickonmore(){
		 return isElementPresent(ClickonPlace_travelnextbutton(),MEDIUMWAIT);
	 }
	 /*
	  * Locator for  Place_travel  in more
	  */
	 private By Place_travelinmore(String number){
		 return By.xpath("//strong[contains(text(),'places/travel')]/../../..//following-sibling::*[1]/li["+number+"]/a//span[@class='rnkrBlue']");
	 }
	 
	 /*
	  * function is used to click on more Place_travel
	  */
	 public void clickonPlace_travelinmore(int number){
		 safeClick(Place_travelinmore(number+""),MEDIUMWAIT);
	 }
	 /*
	  * locator for morelistaboutPlace_travel
	  */
	 private By morelistaboutPlace_travel(){
		 return By.xpath("//strong[contains(text(),'places/travel')]/../../..//following-sibling::*[2]");
	 }
	 /*
	  * function is used for click on morelistaboutPlace_travel
	  */
	 public void clickonmorelistaboutPlace_travel(){
		 safeClick(morelistaboutPlace_travel(),VERYLONGWAIT);
	 }
	 /*
	  * Locator for vote in places_travel section
	  */
	 private By voteinplaces_travel(String number){
		 return By.xpath("//strong[contains(text(),'places/travel')]/../../..//following-sibling::*[1]/li["+number+"]/a//em[contains(text(),'votes')]");
	 }
	 /*
	  * function is used to check vote in places_travel
	  */
	 public boolean isVotePresentInplaces_travel(int number){
		 return isElementPresent(voteinplaces_travel(number+""), VERYLONGWAIT);
	 }
	 
	 /*
	  * Function to get text of the header of page appearing on click places_travel.
	  */
	 public String getTextofvoteplaces_travel(int number){
		 return safeGetText(voteinplaces_travel(number+""), VERYLONGWAIT);
	 }
	 /*
	  * Locator for header of Sports
	  */
	 private By sports(String number){
		 return By.xpath("//strong[contains(text(),'sports')]/../../..//following-sibling::*[1]/li["+number+"]/a//img");
	 }
	 /*
	  * Function is used to section is present in sports section
	  */
	 public boolean isImagePresentInSportsSection(int number){
		 return isElementPresent(sports(number+""), VERYLONGWAIT);
	 }
	 /*
	  * Locator for sports to get href
	  */
	 private By hrefOfsports(String number){
		 return By.xpath("//strong[contains(text(),'sports')]/../../..//following-sibling::*[1]/li["+number+"]/a");
	 }
	 /*
	  * Function is used to get Href of sports
	  */
	 public String gethrefOfsports(int number){
		 return driver.findElement(hrefOfsports(number+"")).getAttribute("href");
	 }	
	 /*
	  * Locator for header of sports section
	  */
	 private By sportsHeader(String number){
		 return By.xpath("//strong[contains(text(),'sports')]/../../..//following-sibling::*[1]/li["+number+"]/a/span");
	 }
	 /*
	  * Function is used to Click on sports Header
	  */
	 public void clickOnsportsHeader(int number){
		 safeClick(sportsHeader(number+""), MEDIUMWAIT);
	 }
	 /*
	  * Locator for header of sports next button 
	  */
	 private By sportsnextbutton(){
		 return By.xpath("//strong[contains(text(),'sports')]/..//following-sibling::*[1]");
	 }
	 /*
	  * This function is used to click on next button in sports section
	  */
	 public void clickonnextbuttoninsports(){
		 safeClick(sportsnextbutton(),MEDIUMWAIT);
	 }
	 /*
	  * Locator for  sports in next button
	  */
	 private By Clickonsportsnextbutton(){
		 return By.xpath("//div[@id='siteBody']/article[@id='landing']/header[@id='landingHead']/h1");
	 }
	 /*
	  * function is used to click on more in sports
	  */
	 public boolean isPresentSportsafterclickonmore(){
		 return isElementPresent(Clickonsportsnextbutton(),MEDIUMWAIT);
	 }
	 /*
	  * Locator for  sports  in more
	  */
	 private By sportsinmore(String number){
		 return By.xpath("//strong[contains(text(),'sports')]/../../..//following-sibling::*[1]/li["+number+"]/a//span[@class='rnkrBlue']");
	 }
	 
	 /*
	  * function is used to click on more sports
	  */
	 public void clickonsportsinmore(int number){
//		 try{
//			   safeClick(sportsinmore(number+""), VERYLONGWAIT);
//			  }catch(Exception e){
			   safeJavaScriptClick(sportsinmore(number+""), VERYLONGWAIT);
			//  }
		// safeJavaScriptClick(sportsinmore(number+""),MEDIUMWAIT);
	 }
	 /*
	  * locator for morelistaboutsports
	  */
	 private By morelistaboutsports(){
		 return By.xpath("//strong[contains(text(),'sports')]/../../..//following-sibling::*[2]");
	 }
	 /*
	  * function is used for click on morelistaboutsports
	  */
	 public void clickonmorelistaboutsports(){
		 safeJavaScriptClick(morelistaboutsports(),MEDIUMWAIT);
	 }
	 /*
	  * Locator for vote in sports section
	  */
	 private By voteinsports(String number){
		 return By.xpath("//strong[contains(text(),'sports')]/../../..//following-sibling::*[1]/li["+number+"]/a//em[contains(text(),'votes')]");
	 }
	 /*
	  * function is used to check vote in sports
	  */
	 public boolean isVotePresentInsports(int number){
		 return isElementPresent(voteinsports(number+""), VERYLONGWAIT);
	 }
	 
	 /*
	  * Function to get text of the header of page appearing on click sports.
	  */
	 public String getTextofvotesports(int number){
		 return safeGetText(voteinsports(number+""), VERYLONGWAIT);
	 }
	 
	 /*
	  * Locator for header of thought provoking
	  */
	 private By thoughtprovoking(String number){
		 return By.xpath("//strong[contains(text(),'thought provoking')]/../../..//following-sibling::*[1]/li["+number+"]/a//img");
	 }
	 /*
	  * Function is used to section is present in thought provoking section
	  */
	 public boolean isImagePresentInThoughtprovokingSection(int number){
		 return isElementPresent(thoughtprovoking(number+""), VERYLONGWAIT);
	 }
	 /*
	  * Locator for thoughtprovoking to get href
	  */
	 private By hrefOfthoughtprovoking(String number){
		 return By.xpath("//strong[contains(text(),'thought provoking')]/../../..//following-sibling::*[1]/li["+number+"]/a");
	 }
	 /*
	  * Function is used to get Href of thoughtprovoking
	  */
	 public String gethrefOfthoughtprovoking(int number){
		 return driver.findElement(hrefOfthoughtprovoking(number+"")).getAttribute("href");
	 }	
	 /*
	  * Locator for header of thoughtprovoking section
	  */
	 private By thoughtprovokingHeader(String number){
		 return By.xpath("//strong[contains(text(),'thought provoking')]/../../..//following-sibling::*[1]/li["+number+"]/a/span");
	 }
	 /*
	  * Function is used to Click on sports Header
	  */
	 public void clickOnthoughtprovokingHeader(int number){
		 safeClick(thoughtprovokingHeader(number+""), MEDIUMWAIT);
	 }
	 /*
	  * Locator for header of thoughtprovoking next button 
	  */
	 private By thoughtprovokingnextbutton(){
		 return By.xpath("//strong[contains(text(),'thought provoking')]/..//following-sibling::*[1]");
	 }
	 /*
	  * This function is used to click on next button in thoughtprovoking section
	  */
	 public void clickonnextbuttoninthoughtprovoking(){
		 safeClick(thoughtprovokingnextbutton(),VERYLONGWAIT);
	 }
	 /*
	  * Locator for  thoughtprovoking in next button
	  */
	 private By Clickonthoughtprovokingnextbutton(){
		 return By.xpath("//div[@id='siteBody']/article[@id='landing']/header[@id='landingHead']/h1");
	 }
	 /*
	  * function is used to click on more in thoughtprovoking
	  */
	 public boolean isPresentThoughtprovokingafterclickonmore(){
		 return isElementPresent(Clickonthoughtprovokingnextbutton(),MEDIUMWAIT);
	 }
	 /*
	  * Locator for  thoughtprovoking  in more
	  */
	 private By thoughtprovokinginmore(String number){
		 return By.xpath("//strong[contains(text(),'thought provoking')]/../../..//following-sibling::*[1]/li["+number+"]/a/span/span[@class='rnkrBlue']");
	 }
	 
	 /*
	  * function is used to click on more thoughtprovoking
	  */
	 public void clickonthoughtprovokinginmore(int number){
		   try{
				safeJavaScriptClick(thoughtprovokinginmore(number+""), VERYLONGWAIT);
			 }catch(Exception e){
				safeClick(thoughtprovokinginmore(number+""), VERYLONGWAIT);
			 }	
		 //safeClick(thoughtprovokinginmore(number+""),MEDIUMWAIT);
	 }
	 /*
	  * locator for morelistaboutthoughtprovoking
	  */
	 private By morelistaboutthoughtprovoking(){
		 return By.xpath("//strong[contains(text(),'thought provoking')]/../../..//following-sibling::*[2]");
	 }
	 /*
	  * Locator for vote in thought provoking section
	  */
	 private By voteinthoughtprovoking(String number){
		 return By.xpath("//strong[contains(text(),'thought provoking')]/../../..//following-sibling::*[1]/li["+number+"]/a//em[contains(text(),'votes')]");
	 }
	 /*
	  * function is used to check vote in thought provoking
	  */
	 public boolean isVotePresentInthoughtprovoking(int number){
		 return isElementPresent(voteinthoughtprovoking(number+""), VERYLONGWAIT);
	 }
	 
	 /*
	  * Function to get text of the header of page appearing on click thought provoking.
	  */
	 public String getTextofvotethoughtprovoking(int number){
		 return safeGetText(voteinthoughtprovoking(number+""), VERYLONGWAIT);
	 }
	 /*
	  * function is used for click on morelistaboutsports
	  */
	 public void clickonmorelistaboutthoughtprovoking(){
		 safeJavaScriptClick(morelistaboutthoughtprovoking(),MEDIUMWAIT);
	 }
	 	
	 /*
	  * Locator for our picks block.											
	  */
	 private By ourPicksForBlock(String number){
		 return By.xpath("//section[@class='relative seasonalBlock']/div[@class='itemWrap']/article["+number+"]/a");
		// return By.xpath("//section[@class='relative seasonalBlock']/ol/li[2]/a");	
	 }
	 /*
	  * Function is used to section is present in thought provoking section
	  */
	 public boolean isImagePresentInourPicksForSection(int number){
		 return isElementPresent(ourPicksForBlock(number+""), VERYLONGWAIT);
	 }
//	 /*
//	  * Function to check the presence of total sections in our picks block. 
//	  */
//	 public boolean ourPicksForBlockPresent(int num){
//		 return isElementPresent(ourPicksForBlock(num+""));
//	 }
	 /*
	  * Function to get the href of particular section in our picks for block.
	  */
	 public String getHrefOfourPicksForBlock(int num){
		 return driver.findElement(ourPicksForBlock(num+"")).getAttribute("href");
	 }
	 /*
	  * Function to make click on any section in our picks for block.
	  */
	 public void clickOnourPicksForBlockSection(int num){
//		 try{
//			  safeJavaScriptClick(ourPicksForBlock(num+""), VERYLONGWAIT);
//			  }catch(Exception e){
		 safeJavaScriptClick(ourPicksForBlock(num+""), VERYLONGWAIT);
			 // }
		// safeJavaScriptClick(ourPicksForBlock(num+""), MEDIUMWAIT);
	 }
	 /*
	  * Locator for more in sections of our picks for block.
	  */
	 private By ourPicksForBlockMore(int num){
		 return By.xpath("//section[@class='relative seasonalBlock']/div[@class='itemWrap']/article[@class='float relative block large'][1]/a/span");
		 //return By.xpath("//section[@class='relative seasonalBlock']/ol/li["+num+"]/a/span/span[@class='rnkrBlue']");
		// return By.xpath("//strong[contains(text(),'our picks for: ')]/../..//following-sibling::*[1]/li["+num+"]/a/span/span[@class='rnkrBlue']");
	 }
	 /*
	  * Function to make click on more in section of our picks for block.
	  */
	 public void clickOnOurPicksForBlockMore(int num){
		 safeJavaScriptClick(ourPicksForBlockMore(num), MEDIUMWAIT);
	 }
	 /*
	  * Locator for vote in our picks for: section
	  */
	 private By voteinourpicksfor(String number){
		 return By.xpath("//section[@class='relative seasonalBlock']/div[@class='itemWrap']/article[@class='float relative block large'][1]/a//em");
//		 return By.xpath("//strong[contains(text(),'our picks for: ')]/../..//following-sibling::*[1]/li["+number+"]/a//em[contains(text(),'votes')]");
	 }
	 /*
	  * function is used to check vote in our picks for:
	  */
	 public boolean isVotePresentInourpicksfor(int number){
		 return isElementPresent(voteinourpicksfor(number+""), VERYLONGWAIT);
	 }
	 
	 /*
	  * Function to get text of the header of page appearing on click our picks for:
	  */
	 public String getTextofvoteourpicksfor(int number){
		 return safeGetText(voteinourpicksfor(number+""), VERYLONGWAIT);
	 }
	 /*
	  * Locator for Music Block.
	  */
	 private By musicBlock(String number){
		 return By.xpath("//strong[contains(text(),'music')]/../../..//following-sibling::*[1]/li["+number+"]/a");
	 }
	 /*
	  * Function to check the presence of total sections in music block.
	  */
	 public boolean isMusicSectionPresent(int num){
		 return isElementPresent(musicBlock(num+""));
	 }
	 /*
	  * Function to get the href of sections in music block.
	  */
	 public String getHrefOfMusicSection(int num){
		 return driver.findElement(musicBlock(num+"")).getAttribute("href");
	 }
	 /*
	  * Function to make click on any section in music block.
	  */
	 public void clickOnMusicSection(int num){
		 safeJavaScriptClick(musicBlock(num+""), MEDIUMWAIT);
	 }
	 /*
	  * Locator for vote in our picks for: music
	  */
	 private By voteinmusic(String number){
		 return By.xpath("//strong[contains(text(),'music')]/../../..//following-sibling::*[1]/li["+number+"]/a//em[contains(text(),'votes')]");
	 }
	 /*
	  * function is used to check vote in music
	  */
	 public boolean isVotePresentInmusic(int number){
		 return isElementPresent(voteinmusic(number+""), VERYLONGWAIT);
	 }
	 
	 /*
	  * Function to get text of the header of page appearing on click our picks for:
	  */
	 public String getTextofvotemusic(int number){
		 return safeGetText(voteinmusic(number+""), VERYLONGWAIT);
	 }
	 /*
	  * Locator for after click on vote in our picks for: section
	  */
	 private By voteinafterclick(){
		 return By.xpath("//div[@class='midGrey serif data']/span");
		// return By.xpath("//div[@class='midGrey serif data']/span[@class='inlineBlock item'][1]");
	 }
	 /*
	  * Function to get text of the header of page appearing on click on our picks for:.
	  */
	 public String getTextofvoteafterclick(){
		 String txt="";
		 List<WebElement> spans=driver.findElements(voteinafterclick());
		 for (WebElement span : spans){
			 if(span.getText().contains("votes")){
				 txt = span.getText();
			 }
		 }
		 return txt;
	 }
	 /*
	  * Locator for Music Block Arrow.
	  */
	 private By musicArrow(){
		 return By.xpath("//div[@id='siteBody']/article[@id='landing']/div[@id='landingBody']/section[11]/header/h2/a[2]");
	 }
	 /*
	  * Function to make click on the arrow.
	  */
	 public void clickOnMusicArrow(){
		 try{
			 safeJavaScriptClick(musicArrow(), VERYLONGWAIT);
			  }catch(Exception e){
		 safeClick(musicArrow(), MEDIUMWAIT);}
	 }
	 /*
	  * Function to get href of arrow on music block.
	  */
	 public String getHrefOfMusicArrow(){
		 return driver.findElement(musicArrow()).getAttribute("href");
	 }
	 /*
	  * Locator for more list about music link.
	  */
	 private By musicBlockMoreAboutMusicLink(){
		 return By.xpath("//strong[contains(text(),'music')]/../../..//following-sibling::*[2]");
	 }
	 /*
	  * Function to make click on the more list about music link.
	  */
	 public void clickOnMusicBlockMoreAboutMusicLink(){
		 try{
			 safeJavaScriptClick(musicBlockMoreAboutMusicLink(), VERYLONGWAIT);
			  }catch(Exception e){
		 safeClick(musicBlockMoreAboutMusicLink(), MEDIUMWAIT);}
		// safeClick(musicBlockMoreAboutMusicLink(), VERYLONGWAIT);
	 }
	 /*
	  * Locator for more in sections of music block.
	  */
	 private By musicSectionMore(){
		 return By.xpath("//strong[contains(text(),'music')]/../../..//following-sibling::*[1]/li[1]/a/span/span[@class='rnkrBlue']");
	 }
	 /*
	  * Function to make click on more in sections of music block.
	  */
	 public void clickOnMusicSectionMore(){
		 try{
			 safeJavaScriptClick(musicSectionMore(), VERYLONGWAIT);
			  }catch(Exception e){
		 safeClick(musicSectionMore(), MEDIUMWAIT);}
		// safeClick(musicSectionMore(), VERYLONGWAIT);
	 }	
	 /*
	  * Locator for vote in Popular on  section
	  */
	 private By voteinPopularon(String number){
		 return By.xpath("//strong[contains(text(),'popular on')]/../../..//following-sibling::*[1]/li["+number+"]/a//em[contains(text(),'votes')]");
	 }
	 /*
	  * function is used to check vote in Popular on
	  */
	 public boolean isVotePresentInPopularon(int number){
		 return isElementPresent(voteinPopularon(number+""), VERYLONGWAIT);
	 }
	 
	 /*
	  * Function to get text of the header of page appearing on click on Popular on.
	  */
	 public String getTextofvotePopularon(int number){
		 return safeGetText(voteinPopularon(number+""), VERYLONGWAIT);
	 }
	 /*
	  * Locator for  Popular onin more
	  */
	 private By Popularoninmore(String number){
		 return By.xpath("//strong[contains(text(),'popular on')]/../../..//following-sibling::*[1]/li["+number+"]/a//span[@class='rnkrBlue']");
	 }
																				
	 /*
	  * function is used to clickon Popularon more
	  */
	 public void clickonPopularoninmore(int number){
		 safeJavaScriptClick(Popularoninmore(number+""),VERYLONGWAIT);
	 }
	 /*
	  * Locator for vote in MostTweeted  section
	  */
	 private By voteinMostTweeted(String number){
		 return By.xpath("//strong[contains(text(),'most')]/../../..//following-sibling::*[1]/li["+number+"]/a//em[contains(text(),'votes')]");
	 }
	 /*
	  * function is used to check vote in MostTweeted
	  */
	 public boolean isVotePresentInMostTweeted(int number){
		 return isElementPresent(voteinMostTweeted(number+""), VERYLONGWAIT);
	 }
	 /*
	  * Function to get text of the header of page appearing on click on Popular on.
	  */
	 public String getTextofvoteMostTweeted(int number){
		 return safeGetText(voteinMostTweeted(number+""), VERYLONGWAIT);
	 }
	 /*
	  * Locator for MostTweetedin more
	  */
	 private By MostTweetedinmore(String number){
		 return By.xpath("//strong[contains(text(),'most')]/../../..//following-sibling::*[1]/li["+number+"]/a//span[@class='rnkrBlue']");
	 }
																						
	 /*
	  * function is used to clickon MostTweeted more
	  */
	 public void clickonMostTweetedinmore(int number){
		 safeClick(MostTweetedinmore(number+""),VERYLONGWAIT);
	 }
	 /*
	  * Locator for vote in RecentlyReranked section
	  */
	 private By voteinRecentlyReranked(String number){
		 return By.xpath("//strong[contains(text(),'Recently Reranked')]/../../..//following-sibling::*[1]/li["+number+"]/a//em[contains(text(),'votes')]");
	 }
	 /*
	  * function is used to check vote in RecentlyReranked
	  */
	 public boolean isVotePresentInRecentlyReranked(int number){
		 return isElementPresent(voteinRecentlyReranked(number+""), VERYLONGWAIT);
	 }
	 
	 /*
	  * Function to get text of the header of page appearing on click on RecentlyReranked.
	  */
	 public String getTextofvoteRecentlyReranked(int number){
		 return safeGetText(voteinRecentlyReranked(number+""), VERYLONGWAIT);
	 }
	 /*
	  * Locator for vote in People section
	  */
	 private By voteinPeople(String number){
		 return By.xpath("//strong[contains(text(),'people')]/../../..//following-sibling::*[1]/li["+number+"]/a//em[contains(text(),'votes')]");
	 }
	 /*
	  * function is used to check vote in People
	  */
	 public boolean isVotePresentInPeople(int number){
		 return isElementPresent(voteinPeople(number+""), VERYLONGWAIT);
	 }
	 
	 /*
	  * Function to get text of the header of page appearing on click on People.
	  */
	 public String getTextofvotePeople(int number){
		 return safeGetText(voteinPeople(number+""), VERYLONGWAIT);
	 }
	 /*
	  * Locator for uhoh header
	  */
	 private By uhohheader(){
		 return By.xpath("//div[@id='siteBody']/article[@id='e404']/h1");
	 }
	 /*
		 * Function to hover on uhohheader
		 */
		public void hoverOveruhohheader(){
			 mouseHover(uhohheader(), LONGWAIT);
		}
     	/*
		 * Function to get color of uhohheaderon hovering.
		 */
		public String getColorOfuhohheader(){
			return driver.findElement(uhohheader()).getCssValue("color");
		}
		/*
		  * Locator for letsseeHeader()
		  */
		private By letsseeHeader(){
		return By.xpath("//div[@id='siteBody']/article[@id='e404']/header[@class='width25 inlineBlock relative']/div[@class='eReasons relative center']/h2");
}
		/*
		 * Function to hover on letsseeHeader
		 */
		public void hoverOverletsseeHeader(){
			 mouseHover(letsseeHeader(), LONGWAIT);
		}
     	/*
		 * Function to get color of letsseeHeader on hovering.
		 */
		public String getColorOfletsseeHeader(){
			return driver.findElement(letsseeHeader()).getCssValue("color");
		}
		/*
		  * Locator for maybePara()
		  */
		private By maybePara(){
		return By.xpath("//div[@id='siteBody']/article[@id='e404']/header[@class='width25 inlineBlock relative']/div[@class='eReasons relative center']/p[@class='grey']");
}
		/*
		 * Function to hover on maybePara
		 */
		public void hoverOvermaybePara(){
			 mouseHover(maybePara(), LONGWAIT);
		}
     	/*
		 * Function to get color of maybePara on hovering.
		 */
		public String getColorOfmaybePara(){
			return driver.findElement(maybePara()).getCssValue("color");
		}
		
		/*
		  * Locator for wedohavePara
		  */
		private By wedohavePara(){
		return By.xpath("//div[@id='siteBody']/article[@id='e404']/header[@class='width25 inlineBlock relative']/div[@class='eReasons relative center']/p[2]");
}
		/*
		 * Function to hover on wedohavePara
		 */
		public void hoverOverwedohavePara(){
			 mouseHover(wedohavePara(), LONGWAIT);
		}
    	/*
		 * Function to get color of wedohavePara on hovering.
		 */
		public String getColorOfwedohavePara(){
			return driver.findElement(wedohavePara()).getCssValue("color");
		}
		/*
		  * Locator for  breakline
		  */
		private By breakline(){
			return By.xpath("//div[@id='siteBody']/article[@id='e404']/header[@class='width25 inlineBlock relative']/div[@class='eReasons relative center']/br");
		}
		/*
		  * function is used to check breakline bw paragraphs
		  */
		 public boolean isPresentbreakline(){
			 return isElementPresent(breakline(), SHORTWAIT);
		 }
		 /*
		  * Locator for  dontBeMAdheader
		  */
		  private By dontBeMAdheader(){
			 return By.xpath("//div[@id='siteBody']/article[@id='e404']/header[@class='width25 inlineBlock relative']/div[@class='eReasons relative center']/div[@id='ranky']/p[@class='rnkrGreen']");
		 }
		 /*
			 * Function to hover on dontBeMAdheader
			 */
			public void hoverOverdontBeMAdheader(){
				 mouseHover(dontBeMAdheader(), LONGWAIT);
			}
	    	/*
			 * Function to get color of dontBeMAdheader on hovering.
			 */
			public String getColorOfdontBeMAdheader(){
				return driver.findElement(dontBeMAdheader()).getCssValue("color");
			}
			/*
			  * Locator for rankyImg
			  */
			 private By rankyImg(){
				 return By.xpath("//div[@id='siteBody']/article[@id='e404']/header[@class='width25 inlineBlock relative']/div[@class='eReasons relative center']/div[@id='ranky']/img[@class='relative']");
			 }
			 /*
			  * function is used to check rankyImage 
			  */
			 public boolean isPresentrankyImg(){
				 return isElementPresent(rankyImg(), SHORTWAIT);
			 }
}
