package com.paeobjects.home;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.paeobjects.navbar.NavBar;
import com.pageobject.login.SigninPage;
import com.pageobjects.leaderboard.LeaderBoardPage;
import com.pageobjects.listheader.ListHeader;
import com.pageobjects.listoption.ListOptionPage;
import com.pageobjects.nodepage.Nodepage;
import com.pageobjects.rerank.RerankPage;
import com.pageobjects.rightrail.Rightrail;
import com.pageobjects.slideshow.Slideshow;
import com.pageobjects.uelist.UeListPage;
import com.pageobjects.userProfilePage.UserProfilePage;
import com.pageobjects.widgetPage.WidgetPage;
import com.pageobjects.PicsPage.PicsPage;
import com.pageobjects.RankBlockPage.RankPage;
import com.pageobjects.blog.BlogPage;
import com.pageobjects.footer.FooterPage;
import com.pageobjects.grid.Grid;
import com.selenium.SafeActions;

public class Commonpage extends SafeActions{
	
	private WebDriver driver;
	
	public void signin(String userName, String pwd){
		SigninPage signInPage = new SigninPage(driver);
		signInPage.clickSignin();
		signInPage.enterCredentels(userName,pwd);
		signInPage.clickSubmit();
	}
	public Commonpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	private By rankerLogo(){
		return By.xpath("//a[@id='logo']");
	}
    private By list(String i){
		return By.xpath("//section[@id='edCarousel']/div[@id='edCarouselContainer']/article["+i+"]/a");
	}
	
	private By carouselNavigation(String i){
		return By.xpath("//div[@id='siteBody']//section[@id='edCarousel']/div[@id='edCarouselNav']/span["+i+"]");
	}
	public void clickOnLogo() throws Exception{
		safeClick(rankerLogo());
		waitForPageToLoad();
	}
	public boolean verifyRankerLogo(){
		return isElementPresent(rankerLogo());
	}
	public Slideshow getSlideshow(String url){
		getNewURL(url);
		return new Slideshow(driver);
	}
	public Grid getGridView(String url){
		getNewURL(url);
		return new Grid(driver);
	}
	public Nodepage getNodePage(String url){ 
		getNewURL(url);
		return new Nodepage(driver);
	}
	public Rightrail getRightrailPage(String url){ 
		getNewURL(url);
		return new Rightrail(driver);
	}

	public RankPage getRankPage(String url){ 
		getNewURL(url);
		return new RankPage(driver);
	}
	
	public BlogPage getBlogPage(String url){ 
		getNewURL(url);
		return new BlogPage(driver);
	}
	public PicsPage getPicsPage(String url){ 
		getNewURL(url);
		return new PicsPage(driver);
	}
	public Home getHomePage(String url){ 
		  getNewURL(url);
		  return new Home(driver);
    }
	public WidgetPage getWidgetPage(String url){ 
		  getNewURL(url);
		  return new WidgetPage(driver);
  }
	public NavBar getNavBar(String url){ 
		  getNewURL(url);
		  return new NavBar(driver);
}
	/*
	 * Locator for the close facebook like popup.
	 */
	private By facebookLike(){
		return By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front followDialog2']//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close']");
	}
	/*
	 * Function to check presence of facebook like page.
	 */
	public boolean isfacebookLikePresent(){
		return isElementPresent(facebookLike(),VERYSHORTWAIT);
	}
	
	public void facebookLikePresenceAndAccept(){
		  if(isfacebookLikePresent()){
		    clickFacebookLike();
		   } 
		 }
	/*
	 * This function is used to close facebook like popup.
	 */
	public void clickFacebookLike(){
		safeClick(facebookLike(),VERYLONGWAIT);
	}
	public void getNewURL(String url){ 

		 driver.get(url);
		 if(isfacebookLikePresent()){
		 clickFacebookLike();
		 }
//		 if(islistVotableLinkPresent()){
//				clicklistVotableLink();
//			 }	
		 //votableLinkPresenceAndAccept();
	}/*
	 * Locator for the close list Votable Link popup.
	 */
	private By listVotableLink(){
		return By.xpath("//div[@id='overlay']/div[@id='overlayClose']/img");
	}
	/*
	 * Function to check presence of list Votable Link page.
	 */
	public boolean islistVotableLinkPresent(){
		return isElementPresent(listVotableLink(),SHORTWAIT);
	}
	/*
	 * This function is used to close list Votable Link popup.
	 */
	public void clicklistVotableLink(){
		safeJavaScriptClick(listVotableLink(),SHORTWAIT);
	}
	public void votableLinkPresenceAndAccept(){
		if(islistVotableLinkPresent()){
			clicklistVotableLink();
		 }	
	}
	public ListHeader getListHeader(String url){ 
		getNewURL(url);
	    return new ListHeader(driver);
	}
	public LeaderBoardPage getLeaderBoard(String url){ 
		getNewURL(url);
		return new LeaderBoardPage(driver);
	}
	
	public FooterPage getFooterPage(String url){ 
		getNewURL(url);
		return new FooterPage(driver);
	}
	public ListOptionPage getListOptionPage(String url){ 
		getNewURL(url);
		return new ListOptionPage(driver);
	}
	public RerankPage getRerankPage(String url){ 
		getNewURL(url);
		return new RerankPage(driver);
	}
	public UeListPage getUeListPage(String url){ 
		 // getNewURL(url);
		 driver.get(url);
		 return new UeListPage(driver);
	}
	
	
	public UserProfilePage getUserProfilePage(String url){ 
		driver.get(url);
        return new UserProfilePage(driver);
       }
	
	
	public static int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	/*
	  * Function for twitter login.
	  */
	 public void twitterLogin(String userName, String pwd){
	  switchToNewWindow();
	  safeType(twitUser(), userName);
	  safeType(twitPwd(), pwd);
	  safeClick(twitLoginbtn(), MEDIUMWAIT);
	 }
	 /*
	  * Locator for twitter user name for login.
	  */
	 private By twitUser(){//form[@id='update-form']/div[3]
	  return By.xpath("//div[@role='main']//fieldset[@class='sign-in']/div[@class='row user']/input");
	 }
	 /*
	  * Locator for twitter password for login.
	  */
	 private By twitPwd(){
	  return By.xpath("//div[@role='main']//fieldset[@class='sign-in']/div[@class='row password']/input");
	 }
	 /*
	  * Locator for twitter login button.
	  */
	 private By twitLoginbtn() {
	  return By.xpath("//div[@role='main']//fieldset[2]/input[@type='submit']");
	 }
	 
	 /*
	  * Function for facebook login.
	  */
	 public void facebookLogin(String userName, String pwd){
		 switchToNewWindow();
		 safeType(fbUser(), userName);
		 safeType(fbPwd(), pwd);
		 safeClick(fbLoginBtn(), MEDIUMWAIT);
		 //safeClick(sharebtn(), MEDIUMWAIT);
	 }
	 /*
	  * Locator for facebook user name for login.
	  */
	 private By fbUser(){
		 
		 return By.xpath("//div[@id='loginform']/div[@class='form_row clearfix'][1]/input");
	 }
	 /*
	  * Locator for facebook password for login.
	  */
	 private By fbPwd(){
		 return By.xpath("//div[@id='loginform']/div[@class='form_row clearfix'][2]/input");
	 }
	 /*
	  * Locator for facebook login button.
	  */
	 private By fbLoginBtn(){
		 return By.xpath("//form[@id='login_form']/div[@id='dialog_buttons']/label/input");
	 }
	 private By sharebtn(){
			return By.id("publish");
		}
	 /*
	  * Locator for Pinterest login through facebook login.
	  */
	 private By pintLogin(){
		 return By.xpath("//div[@class='Login LoginBase Module compact lite inspiredWallLogin  register']/form[@method='post']/div[@class='socialLogin']/button[@type='button']");
		// return By.xpath("//div[@class='savePinDialog']/div[@class='signupForm']//div[@class='buttonWrapper']//div[@class='Login LoginBase Module compact lite inspiredWallLogin  register']/form/div[@class='socialLogin']/button/span[@class='buttonText']");
	 }
	 /*
	  * Function to click on 'continue with facebook' on pinterest login.
	  */
	 public void clickOnPintLoginFBbutton(){
		 switchToNewWindow();
//		 Actions act=new Actions(driver);
//		  act.click(driver.findElement(pintLogin())).perform();
		 safeJavaScriptClick(pintLogin(), MEDIUMWAIT);
	 }
	 /*
	  * Function for twitter login.
	  */
	 public void redditLogin(String userName, String pwd){
	  switchToNewWindow();
	  safeType(redUser(), userName);
	  safeType(redPwd(), pwd);
	  safeClick(redLoginbtn(), MEDIUMWAIT);
	 }
	 /*
	  * Locator for reddit user name for login.
	  */
	 private By redUser(){
		 return By.xpath("//form[@id='login-form']/div[contains(@class,'c-form-group')][1]/input");
	 }
	 /*
	  * Locator for reddit password for login.
	  */
	 private By redPwd(){
		 return By.xpath("//form[@id='login-form']/div[contains(@class,'c-form-group')][2]/input");
	 }
	 /*
	  * Locator for reddit login button.
	  */
	 private By redLoginbtn(){
		 return By.xpath("//form[@id='login-form']/div[@class='c-clearfix c-submit-group']/button");
	 }
	 /*
	  * Locator for google user name for login.
	  */
	 private By googleUser(){//form[@id='update-form']/div[3]
	  return By.id("Email");
	 }
	 /*
	  * Locator for google password for login.
	  */
	 private By googlePwd(){
	  return By.id("Passwd");
	 }
	 /*
	  * Locator for google login button.
	  */
	 private By googleLoginbtn() {
	  return By.id("signIn");
	 } //next
	 /*
	  * Locator for google login button.
	  */
	 private By googlenextbtn() {
	  return By.id("next");
	 } //
	/*
	  * Function for google login.
	  */
	 public void googleLogin(String userName, String pwd){
	  switchToNewWindow();
	  safeClearAndType(googleUser(), userName);
	  safeClick(googlenextbtn(), MEDIUMWAIT);
	  safeClearAndType(googlePwd(), pwd);
	  safeClick(googleLoginbtn(), MEDIUMWAIT);
	 }
	 /*
	  * Locator for email user name for login.
	  */
	 private By emailUser(){
	  return By.id("loginUser");
	 }
	 /*
	  * Locator for email addressfor login.
	  */
	 private By emailaddress(){
	  return By.id("loginEmail");
	 }
	 /*
	  * Locator for email password for login.
	  */
	 private By emailPwd(){
	  return By.id("loginPass");
	 }
	 /*
	  * Locator for email login button.
	  */
	 private By emailLoginbtn() {
	  return By.id("signupButton");
	 } 
	 /*
	  * Locator for checkbox seletion
	  */
	 private By checkboxselect() {
	  return By.id("signupAgree");
	 } 
	 private By btnSignin(){
			return By.id("loginButton");
		}
	 
	/*
	  * Function for email login.
	  */
	 public void emailLogin(String userName,String eadd, String pwd){
	 // switchToNewWindow();
	  safeClearAndType(emailUser(), userName);
	  safeClearAndType(emailaddress(), eadd);
	  safeClearAndType(emailPwd(), pwd);
	  safeCheck(checkboxselect(),SHORTWAIT);
	  safeClick(emailLoginbtn(), MEDIUMWAIT);
	 }
	 /*
	  * Function for email login.
	  */
	 public void emailsignin(String userName, String pwd){
	 // switchToNewWindow();
	  safeClearAndType(emailUser(), userName);
	  safeClearAndType(emailPwd(), pwd);
	  safeClick(btnSignin(), MEDIUMWAIT);
	 }
	 public void twittercheck()
		{
			ListHeader listHeader=null;
			  ListOptionPage listOption=null;  
			if(listOption.isPresenttiwtterlogin()==true){
				Assert.assertEquals(1,1);
			}else if(listHeader.isPresenttwitterwindowpresent()) {
				Assert.assertEquals(1,1);
			}else
			{
				Assert.assertEquals(1,0);	
			}
//			 getDriver().close();
//			 listHeader.switchToWindow(0);
		}
	 //facebook share button
	 
//	 /*
//	  * Function for email login.
//	  */
//	 public void clicksharebtn(){
//	 
//	  safeClick(sharebtn(), MEDIUMWAIT);
//	 }
	 
}
