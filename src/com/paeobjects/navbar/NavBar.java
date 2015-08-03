package com.paeobjects.navbar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.paeobjects.home.Commonpage;
import com.paeobjects.home.Home;
import com.pageobject.login.FBAPI;
import com.pageobject.login.ForgotPassword;
import com.pageobject.login.GooglePlusAPI;
import com.pageobject.login.TwitterAPI;
import com.pageobject.search.SearchRanker;
import com.utilities.TimeOuts;

public class NavBar extends Commonpage{
	
	private WebDriver driver;

	public NavBar(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/***************************Page locators*******************************/
	/*
	 * Locator for Ranker logo.
	 */
	private By newlnk(){
		return By.id("nav_recent");
	}
	/*
	 * Locator for overlayPeople.
	 */
	private By overlayPeople(){
		return By.xpath("//ul[@class='float relative lowercase main']//a[contains(text(),'People')]");
	}
	/*
	 * Locator for overlayFilm.
	 */
	private By overlayFilm(){
		return By.xpath("//ul[@class='float relative lowercase main']//a[contains(text(),'Film')]");
	}
	/*
	 * Locator for  overlayTv().
	 */
	private By overlayTv(){
		return By.xpath("//ul[@class='float relative lowercase main']//a[contains(text(),'TV')]");
	}
	/*
	 * Locator for overlayMusic.
	 */
	private By overlayMusic(){
		return By.xpath("//ul[@class='float relative lowercase main']//a[contains(text(),'Music')]");
	}
	/*
	 * Locator for overlaySports.
	 */
	private By overlaySports(){
		return By.xpath("//ul[@class='float relative lowercase main']//a[contains(text(),'Sports')]");
	}
	/*
	 * Locator for score explain.
	 */
	private By signIn(){
		return By.xpath("//span[contains(text(),'sign in')]");
	}
	/*
	 * Locator for People - hover.
	 */
	private By people(){
		return By.id("nav_people");
	}
	/*
	 * Locator for film in navbar.
	 */
	private By film(){
		return By.id("nav_film");
	}
	/*
	 * Locator for tv in Navbar.
	 */
	private By tv(){
		return By.id("nav_tv");
	}
	/*
	 * Locator for music in navbar.
	 */
	private By music(){
		return By.id("nav_music");
	}
	/*
	 * Locator for sports 
	 */
	private By sports(){
		return By.id("nav_sports");
	}
	/*
	 * Locator for videos.
	 */
	private By videos(){
		return By.xpath("//nav[@id='siteNav']/ul/li[7]/a");
	}
	/*
	 * Locator for comics.
	 */
	private By comics(){
		return By.xpath("//nav[@id='siteNav']/ul/li[8]/a");
	}
	
	/*
	 * Locator for more.
	 */
	private By more(){
		return By.id("nav_more");
	}
	/*
	 * Locator for overlay.
	 */
	private By overlay(){
		return By.id("siteNavCategories");
	}
	/*
	 * Locator for that 8 images in people n hover Navbar
	 */
	private By overlayImages(int i){
		return By.xpath("//div[@id='siteNavCatLists']//li["+i+"]/a/img");
	}
	/*
	 * Locator for People in Navbar
	 */
	private By overlayList(int i){
		return By.xpath("//div[@id='siteNavCategories']/ul/li["+i+"]/a");
	}
	/*
	 * Locator for seeAlltopics on hover People in navbar (all ranker topics)
	 */	
	private By seeAlltopics(){
		return By.xpath("//div[@id='siteNavCatAll']/a[@class='floatRight relative rnkrBlue pointer clear seeAll']");
	}
	/*
	 * Locator for tag on people overlay.
	 */
	private By tag(){
		return By.xpath("//div[@id='siteNavCategories']//a[contains(@href,'tags')]");
	}
	/*
	 * Locator for Class in people overlay.
	 */
	private By clazz(){
		return By.xpath("//div[@id='siteNavCategories']//a[contains(@href,'lists') and(not(contains(text(), 'lists-of')))]");
	}
	/*
	 * Locator for category in people overlay.
	 */
	private By category(){
		return By.xpath("//div[@id='siteNavCategories']//a[contains(@href,'lists-of')]");
	}
	/*
	 * Locator for all Ranker topics.
	 */
	private By allRankertoics(){
		return By.xpath("//a[contains(text(),'all ranker topics')]");
	}
	/*
	 * Locator for category/class/tag links in More Hover
	 */
	private By cctLinks(){
		return By.xpath("//div[@id='siteNavMoreSub']//a");
	}
	/*
	 * Locator for score explain.
	 */
	private By faq(){
		return By.xpath("//span[contains(text(),'frequently asked questions')]");
	}
	/*
	 * Locator for contact Us in more Hover.
	 */
	private By contactUs(){
		return By.xpath("//span[contains(text(),'contact us')]");
	}
	/*
	 * Locator for forms in More Hover .
	 */
	private By forms(){
		return By.xpath("//span[contains(text(),'forums')]");
	}
	/*
	 * Locator for topRankers.
	 */
	private By topRankers(){
		return By.xpath("//span[contains(text(),'top rankers')]");
	}
	/*
	 * Locator for listopedia in more hover.
	 */
	private By listopedia(){
		return By.xpath("//span[contains(text(),'listopedia')]");
	}
	/*
	 * Locator for embedList in more Hover.
	 */
	private By embedList(){
		return By.xpath("//span[contains(text(),'embed a list')]");
	}
	/*
	 * Locator for search botton
	 */	
	private By searchBtn(){
		return By.xpath("//span[@id='globalSearchBtn']");
	}
	/*
	 * Locator for searchBox
	 */
	private By searchBox(){
		return By.id("globalSearchInput");
	}
	/*
	 * Locator for createList
	 */
	private By createList(){
		return By.xpath("//span[contains(text(),'create a list')]");
	}
	/*
	 * Locator for score explain.
	 */
	private By joining(){
		return By.linkText("Joining is easy.");
	}
	/*
	 * Locator for score explain.
	 */
	private By forgotPwd(){
		return By.id("loginForgotPassword");
	}
	/*
	 * Locator for score explain.
	 */	
	private By signupEmail(){
		return By.xpath("//img[contains(@src, 'signup_mail')]");
	}
	/*
	 * Locator for score explain.
	 */
	private By signUpFB(){
		return By.xpath("//img[contains(@src, 'signup_facebook')]");
	}
	/*
	 * Locator for score explain.
	 */
	private By signUpTwitter(){
		return By.xpath("//img[contains(@src,'signup_twitter')]");
	}
	/*
	 * Locator for score explain.
	 */
	private By signUpGPlus(){
		return By.xpath("//img[contains(@src,'signup_google')]");
	}
	
	
	
													/*Reistration*/
	
	private By userName(){
		return By.id("loginUser");
	}
	
	private By email(){
		return By.id("loginEmail");
	}
	
	private By password(){
		return By.id("loginPass");
	}
	
	private By signInBtn(){
		return By.id("loginButton");
	}
	
	private By termsAgree(){
		return By.id("signupAgree");
	}
	
	private By signUp(){
		return By.id("signupButton");
	}
	
	private By unameErrorMSG(){
		return By.id("loginUserMess");
	}
	
	private By emailErrorMSG(){
		return By.id("loginEmailMess");
	}
	
	private By pwdErrorMSG(){
		return By.id("loginPassMess");
	}
	
	
	
	/******************************Safe operations**************************/
	
	/*
	 * This function is used for click on homePage
	 */
	public New clickNew(){
		safeClick(newlnk(),LONGWAIT);
		return new New(driver);
	}
	/*
	 * This function is used for Hover mouse
	 */
	public void hoverNew(){
		mouseHover(newlnk(),LONGWAIT);
	}
	/*
	 * This function is used for click on navbar people
	 */
	public People clickPeople(){
		safeClick(people(), LONGWAIT);
		return new People(driver);
	}
	/*
	 * This function is used for Hover People in Navbar
	 */
	public void hoverPeople(){
		mouseHover(people(), LONGWAIT);
	}
	/*
	 * This Function is Used for over Film
	 */
	public void hoverFilm(){
		mouseHover(film(), LONGWAIT);
	}
	/*
	 * This Function is Used for click On Film
	 */
	public Film clickOnFilim(){
		safeClick(film(), LONGWAIT);
		return new Film(driver);
	}
	/*
	 * This Function is Used for click On TV
	 */
	public TV clickOnTV(){
		safeClick(tv(), LONGWAIT);
		return new TV(driver);
	}
	/*
	 * This Function is Used for click On Music
	 */
	public Music clickOnMusic(){
		safeClick(music(), LONGWAIT);
		return new Music(driver);
	}
	/*
	 * This Function is Used for click On Sports
	 */
	public Sports clickOnSports(){
		safeClick(sports(),LONGWAIT);
		return new Sports(driver);
	}
	/*
	 * This function is used for Hover TV in Navbar
	 */
	public void hoverTV(){
		mouseHover(tv(), LONGWAIT);
	}
	/*
	 * This function is used for Hover Music in Navbar
	 */
	public void hoverMusic(){
		mouseHover(music(), LONGWAIT);
	}
	/*
	 * This function is used for Hover Sports in Navbar
	 */
	public void hoverSports(){
		mouseHover(sports(), MEDIUMWAIT);
	}
	
	/*
	 * This function is used for Hover Videos in Navbar
	 */
	public void hoverVideos(){
		mouseHover(videos(), MEDIUMWAIT);
	}
	/*
	 * This function is used for Hover Comics in Navbar
	 */
	public void hoverComics(){
		mouseHover(comics(), MEDIUMWAIT);
	}
	
	/*
	 * This function is used for Hover More
	 */
	public void hoverMore(){
		scrollIntoElementView(more());
		mouseHover(more(), MEDIUMWAIT);
	}
	/*
	 * This function is used to verify MoreOverlay in Hover More
	 */
	public boolean verifyMoreOverlay(){
		return driver.findElement(more()).getAttribute("class").equals("block active");
	}
	
	/*
	 * This fuction is used to to verify overlay in new hover
	 */
	public boolean verifyOverlay(){
		return isElementDisplayed(overlay());
	}
	/*
	 * This fuction is used to  verify hover on Pepole(any list) in navbar //same fuction is used in nave bar as people or Tv or Film
	 */
	public boolean verifyoverlayblockActive(int i){
		return driver.findElement(overlayList(i)).getAttribute("class").equals("block active");
	}
	/*
	 * This function is used to verify More Block is Active
	 */
	public boolean verifyMoreblockActive(){
		return driver.findElement(By.xpath("//nav[@id='siteNav']/ul/li[10]/a")).getAttribute("class").equals("block active");
	}
	/*
	 * This fuction is used to  verify that 8 images hover on Pepole in navbar 
	 */
	public boolean verifyoverlayImages(int i){
		return isElementPresent(overlayImages(i));
	}
	/*
	 * This fuction is used to verify "see all people " appear in the overlay on People
	 */
	public boolean verifySeeAlltopics(){
		return isElementPresent(seeAlltopics());
	}
	/*
	 * This fuction is used to click on People Overlay.
	 */
	public People clickOnOverlayPeople(){
		safeClick(overlayPeople());
		return new People(driver);
	}
	/*
	 * This fuction is used to click on Film Overlay.
	 */
	public Film clickOnOverlayFilm(){
		safeClick(overlayFilm());
		return new Film(driver);
	}
	/*
	 * This function is used to click on Video.
	 */
	public Videos clickOnVideos(){
		safeClick(videos());
		return new Videos(driver);
	}
	
	/*
	 * This function is used to click on clickOnComics.
	 */
	public void clickOnComics(){
		safeClick(comics());
	}
	/*
	 * This fuction is used to click on More.
	 */	
	public More clickOnMore(){
		safeClick(more());
		return new More(driver);
	}
	/*
	 * This fuction is used to click on TV Overlay.
	 */
	public TV clickOnOverlayTv(){
		safeClick(overlayTv());
		return new TV(driver);
	}
	/*
	 * This fuction is used to click on Music Overlay.
	 */
	public Music clickOnOverlayMusic(){
		safeClick(overlayMusic());
		return new Music(driver);
	}
	/*
	 * This fuction is used to click On Overlay Sports.
	 */
	public Sports clickOnOverlaySports(){
		safeClick(overlaySports());
		return new Sports(driver);
	}
	/*
	 * This fuction is used to verify URL People(any) Overlay.
	 */
	public boolean verifyURL(String parseURL){
		return getCurrentURL().contains(parseURL);
	}
	/*
	 * This fuction is used to click on Tag in People Overlay.
	 */
	public boolean clickonTag(){
		if(isElementPresent(tag()))
		{
			//System.out.println(" comin  1111111111111111111");
			safeJavaScriptClick(tag(),MEDIUMWAIT);
			//System.out.println(" comin  22222222222222222");
			return true;
		}
		else return false;
	}
	/*
	 * This fuction is used to click on Class in People Overlay.
	 */
	public boolean clickonClass(){
		if(isElementPresent(clazz()))
		{
			safeClick(clazz());
			return true;
		}
		else return false;
	}
	/*
	 * This fuction is used to click on Cateory in People Overlay.
	 */
	public boolean clickonCateory(){
		if(isElementPresent(category(),VERYSHORTWAIT))
		{
			safeClick(category());
			return true;
		}
		else return false;
	}
	/*
	 * This fuction is used to click on All RankerTopics in People Overlay.
	 */	
	public void clickOnAllRankerToics(){
		safeClick(allRankertoics());
	}
	/*
	 * This fuction is used to click on category/class/tag links.
	 */	
	public int cctlinksCount(){
		return driver.findElements(cctLinks()).size();
	}
	/*
	 * This fuction is used to  verify Frequently asked questions in More Hover 
	 */	
	public boolean verifyFAQPresent(){
		return isElementPresent(faq());
	}
	/*
	 * This fuction is used to verify Contact us in More Hover 
	 */	
	public boolean verifyContactus(){
		return isElementPresent(contactUs());
	}
	/*
	 * This fuction is used to  verify Forms in More Hover 
	 */	
	public boolean verifyForms(){
		return isElementPresent(forms());
	}
	/*
	 * This fuction is used to  verify Top Rankers in More Hover 
	 */	
	public boolean verifyTopRankers(){
		return isElementPresent(topRankers());
	}
	/*
	 * This fuction is used to  verify ListOpdia in More Hover 
	 */	
	public boolean verifylistopedia(){
		return isElementPresent(listopedia());
	}
	/*
	 * This fuction is used to  verify embed a List in More Hover 
	 */	
	public boolean verifyembedList(){
		return isElementPresent(embedList());
	}
	/*
	 * This fuction is used to  click On search
	 */	
	public SearchRanker clickOnsearch(){
		safeClick(searchBtn());
		return new SearchRanker(driver);
	}
	/*
	 * This fuction is used to enter search text
	 */	
	public void enterSearchText(String strText){
		safeType(searchBox(), strText);
	}
	
	public CreateList clickOnCreatelist(){
		safeClick(createList());
		return new CreateList(driver);
	}
	
	public void clickSignin(){
		safeClick(signIn(), TimeOuts.LONGWAIT);
	}
	
	public void clickOnJoining(){
		safeClick(joining());
	}
	
	public void clickSignupByEmail(){
		safeClick(signupEmail());
	}
	
	public FBAPI clickSinupByFB(){
//		safeClick(signUpFB());
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("document.getElementByClassName('float block rpxFacebook socialAuth socialAuthFacebook pointer')");
		safeJavaScriptClick(signUpFB(), VERYLONGWAIT);
		return new FBAPI(driver);
	}
	
	public TwitterAPI clickSinupBytwitter(){
		safeClick(signUpTwitter());
		return new TwitterAPI(driver);
	}
	
	public GooglePlusAPI clickSinupByGPlus(){
//		safeClick(signUpGPlus());
		safeJavaScriptClick(signUpGPlus(), LONGWAIT);
		return new GooglePlusAPI(driver);
	}
	
	public void enterregistrationdetails(String uname, String email, String pwd){
		safeType(userName(),uname);
		safeType(email(),email);
		safeType(password(),pwd);
		safeCheck(termsAgree());
	}
	
	public String verifyUnameError(){
		return waitForText(unameErrorMSG(),MEDIUMWAIT);
	}
	
	public String verifyEmailError(){
		return waitForText(emailErrorMSG(),MEDIUMWAIT);
	}
	
	public String verifyPWDError(){
		return waitForText(pwdErrorMSG(),MEDIUMWAIT);
	}
	
	public Home clickOnSinup(){
		safeClick(signUp());
		return new Home(driver);
	}
	
	public ForgotPassword clickForgotPwd(){
		safeClick(forgotPwd(), MEDIUMWAIT);
		return new ForgotPassword(driver);
	}
	
	public void enterCredentels(String strUName, String strPwd){
		safeClearAndType(userName(), strUName);
		safeClearAndType(password(), strPwd);
		
	}
	
	public boolean isSigninNotPresent(){
		return isElementNotDisplayed(signInBtn());
	}
	
	public Home clickSignInBtn(){
		safeClick(signInBtn(), MEDIUMWAIT);
		return new Home(driver);
	}
	
	public void clicksigninBtn(){
		safeClick(signInBtn(), MEDIUMWAIT);
	}
	/*
	 * Locator for createList in add button
	 */
	private By createListadd(){
		return By.xpath("//div[@id='createSuggest']//span");
	}
	/*
	 * Function is used to createList in add button
	 */
	public void clickonaddbutton(){
		safeClick(createListadd(), MEDIUMWAIT);
		//return new Home(driver);
	}
	/*
	 * Locator for createList in option film 
	 */
	private By createListaddoption(int num){
		return By.xpath("//div[@id='createSuggest']//span[@class='links serif rnkrBlue pointer']/span["+num+"]");
	}
	/*
	 * Function is used to  click createList in add button option
	 */
	public void clickonaddoption(int num){
		safeJavaScriptClick(createListaddoption(num), MEDIUMWAIT);
		//return new Home(driver);
	}
	/*
	 * Function to get title  color of list.
	 */
	public String getoptionColorList(int num){
		//scrollIntoViewThroughJavaScriptExecuter(Listcolorchange());
		return driver.findElement(createListaddoption(num)).getCssValue("color");
	}
	/*
	 * Locator for createList in option sub category
	 */
	private By createListcategoryoption(int num){
		return By.xpath("//div[@id='createLists']/ul/li["+num+"]/p");
	}
	/*
	 * Function is used to  click createList in add button option
	 */
	public void clickcreateListcategoryoption(int num){
		safeJavaScriptClick(createListcategoryoption(num), MEDIUMWAIT);
		//return new Home(driver);
	}
	/*
	 * Locator for createList in close list
	 */
	private By createListcategoryclosebtn(){
		return By.xpath("//div[@id='UE_tab_container']/span[@id='UE_tab_btn']/span");
	}
	/*
	 * Function is used to  click createList in add button option
	 */
	public void clickcreateListcategoryclosebtn(){
		safeClick(createListcategoryclosebtn(), MEDIUMWAIT);
		//return new Home(driver);
	}
	/*
	 * Locator for create List.
	 */
	private By reranking(){
		return By.id("createSubmit");
	}
	/*
	 * Function to make click on create list
	 */
	public void clickOnreranking() {
		safeJavaScriptClick(reranking(), MEDIUMWAIT);
	}
	/*
	 * Locator for search tab in UE.
	 */
	private By search() {
		return By.id("UE_listTabs_find");
	}

	/*
	 * Function to make click on search tab.
	 */
	public void clickOnSearch() {
		safeClick(search(), SHORTWAIT);
	}
	/*
	 * Locator for search box.
	 */
	private By searchBox_UE() {
		return By.id("UE_search_input");
	}

	/*
	 * Function to type text in search bar in UE.
	 */
	public void typesearchbtn(String num) {
		safeClearAndType(searchBox_UE(), num, SHORTWAIT);
		driver.findElement(searchBox_UE()).sendKeys(Keys.ENTER);
	}
	/*
	 * Locator For '+' icon in UE.
	 */
	private By plusIcon(int linum) {//UE_suggestions_content
		return By.xpath("//div[@id='UE_search_content']/ul/li[" + linum+ "]/span[@class='float relative block action center']/span");
	}

	/*
	 * Function to make click on '+' icon in UE.
	 */
	public void clickOnPlusIcon(int linum) {
		safeJavaScriptClick(plusIcon(linum), MEDIUMWAIT);
	}
	/*
	 * Locator for 'done' for saving uploaded image.
	 */
	private By cancel() {
		return By.id("UE_nav_cancel");
	}

	/*
	 * Function to make click on 'done' for saving uploaded image.
	 */
	public void clickOncancel() {
		safeClick(cancel(), LONGWAIT);
	}
	/*
	 * Locator for 'hover on profile.
	 */
	private By profile_hover() {
		return By.xpath("//div[@id='userArea']/a/img");
	}

	/*
	 * Function to make hover on profile
	 */
	public void hoverOnprofile() {
		mouseHover(profile_hover(), LONGWAIT);
	}
	/*
	 * Locator for 'draft btn
	 */
	private By draftbtn() {
		return By.xpath("//div[@id='userTabs']/ul/li[@class='float relative']/a");
	}

	/*
	 * Function to make click on draft button
	 */
	public void clickondraftbtn() {
		safeJavaScriptClick(draftbtn(), LONGWAIT);
	}
	/*
	 * Locator for 'draft btn
	 */
	private By listunnamedcheck() {
		return By.xpath("//div[@class='rankrank']/ol[@id='userLists']/li[@class='relative ']/h3/strong");
	}
	/*
	 * Function to get text of list unnamed 
	 */
	public String getTextOflistunnamedcheck(){
		return safeGetText(listunnamedcheck(),MEDIUMWAIT);
	}
	/*
	 * Function to make click on list unnamed 
	 */
	public void clickonlistunnamedcheck() {
		safeJavaScriptClick(listunnamedcheck(), LONGWAIT);
	}
	/*
	 * Locator for optionbtn in UE
	 */
	private By optionbtn() {
		return By.xpath("//div[@id='UE_listTabs']//span[@id='UE_listTabs_customize']/i");
	}
	/*
	 * Function to make click option btn in UE.
	 */
	public void clickOnoptionbtn() {
		safeClick(optionbtn(), MEDIUMWAIT);
	}
	/*
	 * Locator For deletelist
	 */
	private By deletelist(){
		return By.id("UE_settings_delete_btn");
	}
	/*
	 * Function to make click on deletelist
	 */
	public void clickOndeletelist() {
    safeJavaScriptClick(deletelist(), MEDIUMWAIT);
		}
	/*
	 * Locator For manage me list
	 */
	private By managelistbtn(){
		return By.xpath("//div[@id='userAreaMenu']/span[@id='userManageLists']/a");
	}
	/*
	 * Function to make click on deletelist
	 */
	public void clickOnmanagelistbtn() {
    safeJavaScriptClick(managelistbtn(), MEDIUMWAIT);
		}
	/*
	 * Locator For deletelist
	 */
	private By crateliststart(){
		return By.id("createName");
	}
	/*
	 * Function to make crate list
	 */
	public void clickOncrateliststart() {
    safeJavaScriptClick(crateliststart(), MEDIUMWAIT);
		}
	/*
	 * Function to type text in textbox in list name
	 */
	public void typcreatelist(String num) {
		safeClearAndType(crateliststart(), num, SHORTWAIT);
		driver.findElement(crateliststart()).sendKeys(Keys.ENTER);
	}
	/*
	 * Locator for open UE .
	 */
	private By Uepresent() {
		return By.xpath("//div[@id='UE_container']");
	}

	/*
	 * Function to check the presence of pen UE
	 */
	public boolean isPresenceUeopen() {
		return isElementPresent(Uepresent(),MEDIUMWAIT);
	}
	
	/*
	 * This function is used for Hover Music in Navbar
	 */
	private By VideoGames(){
		return By.id("nav_video-games_cat");
	}
	/*
	 * This function is used for Hover Sports in Navbar
	 */
	public void hoverOnVideoGames(){
		mouseHover(VideoGames(), MEDIUMWAIT);
	}
	
	/*
	 * This function is used for Hover Music in Navbar
	 */
	private By videogamegenres(String txt){
		return By.linkText(txt);
	}
	/*
	 * This function is used for Hover Sports in Navbar
	 */
	public void clickOnVideoGameOption(String txt){
		//safeClick(videogamegenres(txt), MEDIUMWAIT);
		driver.findElement(videogamegenres(txt)).click();
	}
	/*
	 * locator for open profile dropdown
	 */
	private By profileimagedropdown(){
		return By.id("userAreaMenu");
	}
	/*
	 * Function to check the presence of profile dropdown
	 */
	public boolean isPresentprofileimagedropdown() {
		return isElementPresent(profileimagedropdown(),MEDIUMWAIT);
		
	}//userAreaAlertsCntr
	/*
	 * Function to check the not displayed of profile dropdown
	 */
	public boolean isNotDisplayedprofileimagedropdown() {
		return isElementNotDisplayed(profileimagedropdown());
		
	}//userAreaAlertsCntr
	
	/*
	 * Function to check the not displayed of profile dropdown
	 */
	public void hoverOnProfileDropdown() {
		 mouseHover(profileimagedropdown(),SHORTWAIT);
		
	}//userAreaAlertsCntr
	
	/*
	 * Locator for see all topics in more link.
	 */
	private By seeAllTopicLink(){
		return By.linkText("see all topics");
	}
	/*
	 * Function to click on see all topics in more link.
	 */
	public void clickOnSeeAllTopicLink(){
		safeClick(seeAllTopicLink(), MEDIUMWAIT);
	}
	/*
	 * Locator for right part of more overlay.
	 */
	private By moreRightOverlay(int num){
		return By.xpath("//div[@id='siteNavMore']/ul/li["+num+"]/a");
	}
	/*
	 * Function to click on right part of more overlay.
	 */
	public void clickOnMoreRightOverlay(int num){
		safeJavaScriptClick(moreRightOverlay(num), MEDIUMWAIT);
	}
	
	/*
	 * Function to get href of 'next list' in list footer.
	 */
	public String getHrefOfMoreRightOverlay(int num) {
		return driver.findElement(moreRightOverlay(num)).getAttribute("href");
	}
//	private By searchList(){
//		return By.xpath("//div[@id='globalSearchCntr']/form[@id='globalSearchForm']/input[@id='globalSearchInput']");
//	}
//	public void clickOnsearchList(){
//		safeClick(searchList(), MEDIUMWAIT);
//	}
//	public void typesearchList(String num) {
//		safeClearAndType(searchList(), num, SHORTWAIT);
//	
//}
	private By searchbtn(){
	return By.id("globalSearchBtn");
}
	public void clickOnsearchbtn(){
		safeJavaScriptClick(searchbtn(), MEDIUMWAIT);
	}
	/*
	 * Locator for node image.
	 */
	private By nodename(int number){
		return By.xpath("//div[@class='google-results float']/ul[@id='searchResults']/li["+number+"]/a[@class='searchTitle']");
		//return By.xpath("//section[@id='mainListCnt']/ol[@id='mainList']/li[contains(@class,'relative clear')]["+number+"]/div[@class='relative width100 img clear center']//img[contains(@class,'oImg')]");
		
	}
	public void clickOnnodename(int num){
		safeJavaScriptClick(nodename(num), MEDIUMWAIT);
	}
	
	/*
	 * Function for autoloading.
	 */
 	public void autoloading(int number){
 		System.out.println(" com in this");
 		scrollIntoViewThroughJavaScriptExecuter(nodename(number));
 		//waitForElementVisible(nodename(number),40);
 		
 	}
 	/*
 	 * Function to check the presence of node list before loading and after autoloading.
 	 */
 	public boolean isnodePresent(int number){
 		return isElementPresent(nodename(number));
 	}
 	private By hoverimage(){
 		return By.xpath("//div[@id='edCarouselNav']/span[1]");
 	}
 	/*
	 * This function is used for Hover Sports in Navbar
	 */
	public void hoveronimage(){
		mouseHover(hoverimage(), MEDIUMWAIT);
	//	safeClick(hoverimage(), MEDIUMWAIT);
	}
	/*
	    * Function to get attribute of 'item' in searchbox
	    */
	   public String getAttributeOfsearchBox() {
	    return driver.findElement(searchBox()).getAttribute("placeholder");
	   }
	   /*
	    * locator for  voteOnHeader
	    */
	   private By voteOnHeader(){
	    return By.xpath("//div[@id='siteBody']/article[@id='landing']/header[@id='landingHead']/h1");
	   }
	   /*
	    * This function is used for Hover voteOnHeader in Navbar
	    */
	   public void hoverOnvoteOnHeader(){
	    mouseHover(voteOnHeader(), MEDIUMWAIT);
	   }
	   /*
	    * locator for closeBtn
	    */
	       private By closeBtn(){
	        return By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front create nav']/div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']/button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close']");
	       }
	       /*
	        * function to click on closeBtn
	        */
	     public void clickOncloseBtn(){
	    safeJavaScriptClick(closeBtn(), MEDIUMWAIT);
	  }
	     /*
	      * locator for createListPopup
	      */
	       private By createListPopup(){
	      //  return By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front create nav']");
	      return By.xpath("//div[@class='float createContent visible startlist_ilist_mainnav']/input[@id='createName']");
	       }
	       /*
	      * Function to check the presence of createListPopup
	      */
	     public boolean isPresentcreateListPopup() {
	      return isElementPresent(createListPopup(),MEDIUMWAIT);
	     }
	     /*
	      * locator for Video categeory
	      */
	       private By Videocategeory(){
	      //  return By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front create nav']");
	      return By.xpath("//*[text()='around the web']");
	       }
	       /*
		      * Function to check the presence of Videocategeory
		      */
		     public boolean isPresentVideocategeory() {
		      return isElementPresent(Videocategeory(),MEDIUMWAIT);
		     }
		     /*
		      * locator for Video categeory
		      */
		       private By Videoheading(){
		      //  return By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front create nav']");
		      return By.xpath("//*[text()='video of the week']");
		       }
		       /*
			      * Function to check the presence of Videocategeory
			      */
			     public boolean isPresentVideoheading() {
			      return isElementPresent(Videoheading(),MEDIUMWAIT);
			     }
}