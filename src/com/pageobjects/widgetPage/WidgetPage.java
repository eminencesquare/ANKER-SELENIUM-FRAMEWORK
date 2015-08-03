package com.pageobjects.widgetPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.locators.BrowserInstallation;
import org.openqa.selenium.interactions.Actions;

import com.selenium.SafeActions;

public class WidgetPage extends SafeActions {
	private WebDriver driver;
	/*
	 * Constructor for the page.
	 */
	public WidgetPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	} 
	 /*
	  * Locator for Embed tab on any list page.
	  */
	 private By embedTab(){
	  return By.xpath("//div[@id='listBody']/div[@id='mlaHeadCont']/div[@id='mlaHead2']/div[@id='mlaTab_embed']/i");
	 }
	 /*
	  * Function to make click on embed tab.
	  */
	 public void clickOnEmbedTab(){
		 safeJavaScriptClick(embedTab(), MEDIUMWAIT);
	 }
	 
	/*
	 * Locator for NBA Players in Widget page.
	 */
	private By Widgetfooter(){
		return By.xpath("//div[@id='widgetPreview']/a");
	}
	/*
	 * Function to get href of other ranker header.
	 */
	public String getHrefOfWidgetfooter(){
		return driver.findElement(Widgetfooter()).getAttribute("href");
	}
	/*
	 * Function to make click on NBA Players in Widget page.
	 */
	public void clickOnWidgetFooter(){
		safeClick(Widgetfooter(), MEDIUMWAIT);
	}
	/*
	 * Locator for WidgetHeaderbakground
	 */
	private By WidgetHeader(){
		return By.xpath("//div[@id='widgetHeader']/p");
	}
	/*
	 * Function to make click on WidgetHeaderbakground
	 */
	public void clickWidgetHeaderbakground(){
		 safeClick(WidgetHeader(), MEDIUMWAIT);
	}
	/*
	 *Locator of colorchangebackground
	 */
	private By colorchangebackground(int num){
		return By.xpath("//div[@id='widgetHeader']/p[@class='visible']["+num+"]/a");
	}
	/*
	 * Locator is  to used to open color popup
	 */
	private By colorpopup(){
		return By.xpath("//div[@class='miniColors-colorPicker']");
	}
	/*
	 * Function to used to chanage the color pixle
	 */
	public void colorchange(String x, String y)
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement element = driver.findElement(colorpopup());
		 js.executeScript("arguments[0].setAttribute('style','top: "+x+"; left: "+y+"; display: block;')",element);
		 clickoncolorpopup();
	}
	/*
	 * Locator for font style open popup 
	 */
	private By stylepopup(){
		//return By.xpath("//div[@id='widgetHeader']/p[@class='visible']["+num+"]/select[@id='widgetHeaderFontFace']");
		return By.xpath("//select[@id='widgetHeaderFontFace']");
	}
	/*
	 * Locator for chanage the font style  
	 */
	private By stylechange(){
		return By.xpath("//select[@id='widgetHeaderFontFace']/option[3]");
	}
	/*
	 * Function to used to open color popup
	 */
	public void clickoncolorpopup()
	{
		safeClick(colorpopup(), MEDIUMWAIT);
	}
	/*
	 * Function to used to open popup font style 
	 */
	public void clickonstylechange()
	{
		safeJavaScriptClick(stylepopup(), MEDIUMWAIT);
	}
	/*
	 * Function to used to chnage font style 
	 */
	public void clickonstylechangepopup()
	{
		safeClick(stylechange(), MEDIUMWAIT);
	}
	/*
	 * Function to get font family of  title.
	 */
	public String getFontFamilyTitle(){
		return driver.findElement(headerstylechange()).getCssValue("font-family");
	}
	/*
	 * Function to click on change background
	 */
	public void clickoncolorchange(int num)
	{
		safeClick(colorchangebackground(num), MEDIUMWAIT);
	}
	 /*
	  * Locator for Header color
	  */
	private By headercolorchange()
	{
		return By.xpath("//div[contains(@id,'rnkrwc')]/article[@class='rnkrw rnkrw-relative rnkrw-width100']/header[@class='rnkrwHead rnkrw-width100']");
		//return By.xpath("//div[@class='rnkrwWrap']/header[contains(@id,'rnkrwHead')]");
	}
	/*
	  * Locator for Header style
	  */
	private By headerstylechange()
	{
		return By.xpath("//div[contains(@id,'rnkrwc')]/article[@class='rnkrw rnkrw-relative rnkrw-width100']/header[@class='rnkrwHead rnkrw-width100']/h1/span");
	}
	/*
	 * Function to get Header color of TextHeader.
	 */
	public String getheaderColor(){
	//	System.out.println("ccccccccccc");
		scrollIntoViewThroughJavaScriptExecuter(headercolorchange());
		//System.out.println("dddddddddd");
		return driver.findElement(headercolorchange()).getCssValue("background-color");
		
	}
	/*
	 * Function to get title  color of TextHeader.
	 */
	public String gettitleColor(){
		scrollIntoViewThroughJavaScriptExecuter(headercolorchange());
		return driver.findElement(headercolorchange()).getCssValue("color");
	}
	/*
	 * Locator for list 
	 */
	private By List()
	{
		return By.xpath("//div[@id='widgetList']/p");
	}
	/*
	 * Locator for list checkbox 
	 */
	private By Listcheckbox()
	{
		return By.xpath("//div[@id='widgetList']/p/input[@type='checkbox']");
	}
	/*
	 * Function to click on List
	 */
	public void clickOnListcheckbox(){
		//safeCheck(locator, optionWaitTime)
		safeCheck(Listcheckbox(), MEDIUMWAIT);
	}
	/*
	 * Function to click on List
	 */
	public void clickOnList(){
		safeClick(List(), MEDIUMWAIT);
	}
	/*
	 *Locator of color change of background
	 */
	private By colorchangeList(){
		return By.xpath("//div[@id='widgetList']/p[@class='visible']/a");
	}
	/*
	 * Function to click on change background
	 */
	public void clickoncolorchangeList()
	{
		safeJavaScriptClick(colorchangeList(), MEDIUMWAIT);
	}
	/*
	  * Locator for List color
	  */
	 private By Listcolorchange()
	 {
		 //
	  return By.xpath("//div[contains(@class,'rnkrwBody rnkrw-relative rnkrw-width100')]/ol/li[1]/div[@class='rnkrw-relative rnkrw-name']/p/a");
	 }
	
	/*
	 * Function to get title  color of list.
	 */
	public String gettitleColorList(){
		return driver.findElement(Listcolorchange()).getCssValue("color");
	}
	/*
	 * Locator for font style open popup 
	 */
	private By stylepopupList(){
		//return By.xpath("//div[@id='widgetHeader']/p[@class='visible']["+num+"]/select[@id='widgetHeaderFontFace']");
		return By.xpath("//select[@id='widgetListFontFace']");
	}
	/*
	 * Locator for chanage the font style  
	 */
	private By stylechangeList(){
		return By.xpath("//select[@id='widgetListFontFace']/option[3]");
	}
	
	/*
	 * Function to used to open popup font style 
	 */
	 public void clickonstylechangeList()
	 {
	  mouseHover(stylepopupList(), MEDIUMWAIT);
	  //safeJavaScriptClick(stylepopupList(), MEDIUMWAIT);
	  Actions act = new Actions(driver);
	  act.click().build().perform();
	 }
	 public void clickonstylechangepopupList()
	 {
	  safeClick(stylechangeList(), MEDIUMWAIT);
	 }
	/*
	 * Function to get font family of  title.
	 */
	public String getFontFamilyList(){
		return driver.findElement(Listcolorchange()).getCssValue("font-family");
	}
	/*
	 *Locator of List deatils checkbox list name
	 */
	private By listname(){
		return By.xpath("//div[@id='widgetHeader']//input[contains(@id,'widgetName')]");//[contains(@id,'rnkrwHead')
	}
	/*
	 *Locator of List deatils checkbox list Image
	 */
	private By listimage(){
		return By.xpath("//div[@id='widgetHeader']//input[contains(@id,'widgetImage')]");//[contains(@id,'rnkrwHead')
	}
	/*
	 *Locator of List deatils checkbox widgetUsername
	 */
	private By listusername(){
		return By.xpath("//div[@id='widgetHeader']//input[contains(@id,'widgetUsername')]");//[contains(@id,'rnkrwHead')
	}
	/*
	 * Function to click on List detailss in listname
	 */
	public void clickOnListname(boolean option){
		safeCheckByOption(listname(), option, SHORTWAIT);
	}
	/*
	 * Function to click on List detailss in listimage
	 */
	public void clickOnlistimage(boolean option){
		safeCheckByOption(listimage(), option, SHORTWAIT);
	}
	/*
	 * Function to click on List detailss in listusername
	 */
	public void clickOnlistusername(boolean option){
		safeCheckByOption(listusername(), option, SHORTWAIT);
	}
	/*
	 *Locator of List deatils Check header
	 */
	private By headernamecheck(){
		
		return By.xpath("//div[contains(@id,'rnkrwc')]/article[@class='rnkrw rnkrw-relative rnkrw-width100']/header/h1/span");//[contains(@id,'rnkrwHead')
	}
	/*
	 * Function to check the presence of List deatils Check header
	 */
	public boolean isPresentHeadername(){
		return isElementPresent(headernamecheck(),MEDIUMWAIT);
	}
	/*
	 *Locator of List deatils Check image
	 */
	private By listimagecheck(){
		return By.xpath("//div[contains(@id,'rnkrwc')]/article[@class='rnkrw rnkrw-relative rnkrw-width100']/header/img");//[contains(@id,'rnkrwHead')
	}
	/*
	 * Function to check the presence of List deatils Check image
	 */
	public boolean isPresentlistimagecheck(){
		return isElementPresent(listimagecheck(),SHORTWAIT);
	}
	/*
	 *Locator of List deatils Check user name
	 */
	private By listusernamecheck(){
		return By.xpath("//div[contains(@class,'rnkrw-inlineBlock rnkrw-user')]");//[contains(@id,'rnkrwHead')
	}
	/*
	 * Function to check the presence of List deatils Check image
	 */
	public boolean isPresentlistusernamecheck(){
		return isElementPresent(listusernamecheck(),SHORTWAIT);
	}
	/*
	 * Locator for Footer color
	 */
	private By footercolor()
	{
		return By.id("widgetFooter");
	}
	/*
	 * Function to used to click footer color 
	 */
	public void clickonfootercolor()
	{
		safeClick(footercolor(), MEDIUMWAIT);
		//safeJavaScriptClick(stylechange(2), MEDIUMWAIT);
	}
	/*
	 * Locator for Footer background color chanage
	 */
	private By footerBckgrdcolorchange()
	{
		return By.xpath("//div[@id='widgetFooter']/p[@class='visible'][1]/a");
	}
	/*
	 * Function to used to click footer background color chnage 
	 */
	public void clickonfooterBckgrdcolorchange()
	{
		safeJavaScriptClick(footerBckgrdcolorchange(), MEDIUMWAIT);
	}
	/*
	 * Locator for Footer text color chanage
	 */
	private By footerTextcolorchange()
	{
		return By.xpath("//div[@id='widgetFooter']/p[@class='visible'][2]/a");
	}
	/*
	 * Function used to click footer text color chnage 
	 */
	public void clickonfooterTextcolorchange()
	{
		safeJavaScriptClick(footerTextcolorchange(), MEDIUMWAIT);
	}
	/*
	 * Locator for footer background and text colour.
	 */
	private By getfootercolor()
	{
		return By.xpath("//footer[@class='rnkrwFoot rnkrw-width100 rnkrw-center']");
	}
	/*
	 * Function to get background color of footer.
	 */
	public String getfooterBckgrdColorchange(){
		scrollIntoViewThroughJavaScriptExecuter(getfootercolor());
		//waitForPageToLoad(30);
		return driver.findElement(getfootercolor()).getCssValue("background-color");
	}
    /*
	 * Function to get background color of footer.
	 */
	public String getfooterTextColorchange(){
		scrollIntoViewThroughJavaScriptExecuter(getfootercolor());
		//waitForPageToLoad(30);
		return driver.findElement(getfootercolor()).getCssValue("border-bottom-color");
	} 
	/*
	 * Locator for Height 
	 */
	private By height()
	{
		return By.xpath("//div[@id='widgetSize']/p");
	}
	/*
	 * Function to used to click on height
	 */
	public void clickonHeight()
	{
		safeClick(height(), MEDIUMWAIT);
	}
	/*
	 * Locator for height checkbox uncheck
	 */
	private By heightcheckbox(boolean option)
	{
		return By.xpath("//div[@id='widgetSize']/p[2]/span[@class='toolTip']/input");
	}
	/*
	 * Function to click on height checkbox
	 */
	public void clickOnheightcheckbox(boolean option){
		safeCheckByOption(heightcheckbox(option), option, SHORTWAIT);
	}
	/*
	 * Locator for height of list.
	 */
	private By heightOfList()
	{
		return By.xpath("//div[@id='widgetPreview']/a");
	}
	/*
	 * Function to get height of list after changing number of rows.
	 */
	public String getheightOfList(){
		
		return driver.findElement(heightOfList()).getAttribute("data-rnkrw-rows");
	}
	/*
	 * Locator for input height
	 */
	private By heightinput()
	{
		return By.xpath("//div[@id='widgetSize']/p[2]/input");
	}
	public void typeheightinput(int num)
	{
		safeType(heightinput(), num+"", MEDIUMWAIT);
	}
	/*
	 * Locator for reset to zero block.
	 */
	private By resetVotes(){
		return By.id("widgetVotes_reset");
		//return By.xpath("//div[@id='widgetPreview']/div[@id='widgetVotes']/p[2]/input[@type='radio']");widgetVotes
	}
	/*
	 * Function to click on radio button of reset votes to zero.
	 */
	public void clickOnResetVotes(){
		System.out.println(" com in function");
		safeSelectRadioButton(resetVotes(), MEDIUMWAIT);
	}
	 /*
	   * Locator for existing vote
	 */
	private By ExistingVotes(){
		return By.id("widgetVotes");
		//return By.xpath("//div[@id='widgetPreview']/div[@id='widgetVotes']/p[2]/input[@type='radio']");widgetVotes
	}
	/*
	 * Function to click on radio button of reset votes to zero.
	 */
	public void clickOnExistingVotes(){
		System.out.println(" com in function");
		safeSelectRadioButton(ExistingVotes(), MEDIUMWAIT);
	}
	/*
	 * Locator for sign-up popUp.
	 */
	private By signUpPopUp(){
		return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']");
	}
	/*
	 * Function to check the presence of sign-up pop up.
	 */
	public boolean isSignUpPopUpPresent(){
		return isElementPresent(signUpPopUp(),SHORTWAIT);
	}
	/*
	 * Locator for up vote and down vote after sign in.
	 */
	private By upVote(int num){
		//div[@id='widgetPreview']/div[@class='rnkrw-lists rnkrw-whiteBg rnkrw-typeLarge']/article[@class='rnkrw rnkrw-relative rnkrw-width100']/div[@class='rnkrwBody rnkrw-relative rnkrw-width100 ']/ol/li[1]/div[@class='rnkrw-float rnkrw-relative rnkrw-votes']/div[@class='rnkrw-float rnkrw-relative rnkrw-center']/span[@class='rnkrw-block rnkrw-votesNum rnkrw-up rnkrw-grey rnkrw-arial']
		  return By.xpath("//div[@id='widgetPreview']/div[@class='rnkrw-lists rnkrw-whiteBg rnkrw-typeLarge']/article[@class='rnkrw rnkrw-relative rnkrw-width100']/div[@class='rnkrwBody rnkrw-relative rnkrw-width100 ']/ol/li["+num+"]/div[@class='rnkrw-float rnkrw-relative rnkrw-votes notranslate']/div[@class='rnkrw-float rnkrw-relative rnkrw-center']/span[2]");  
		//return By.xpath("//div[@class='rnkrwWrap']/div[@class='rnkrwBody rnkrw-relative rnkrw-width100 ']/ol/li["+num+"]/div[@class='rnkrw-float rnkrw-relative rnkrw-votes']/div[1]/span[@class='rnkrw-block rnkrw-votesNum rnkrw-up rnkrw-grey rnkrw-arial']");
		//return By.xpath("//div[@id='widgetPreview']/div[@class='rnkrw-lists rnkrw-whiteBg rnkrw-typeLarge']/article[@class='rnkrw rnkrw-relative rnkrw-width100']/div[@class='rnkrwBody rnkrw-relative rnkrw-width100 ']/ol/li[1]/div[@class='rnkrw-float rnkrw-relative rnkrw-votes']/div[@class='rnkrw-float rnkrw-relative rnkrw-center']/span[@class='rnkrw-block rnkrw-votesNum rnkrw-up rnkrw-grey rnkrw-arial']");
	}
	private By downVote(int num){
			return By.xpath("//div[@id='widgetPreview']/div[@class='rnkrw-lists rnkrw-whiteBg rnkrw-typeLarge']/article[@class='rnkrw rnkrw-relative rnkrw-width100']/div[@class='rnkrwBody rnkrw-relative rnkrw-width100 ']/ol/li["+num+"]/div[@class='rnkrw-float rnkrw-relative rnkrw-votes notranslate']/div[2]/span[2]");
	}//div[@id='widgetPreview']/div[@class='rnkrw-lists rnkrw-whiteBg rnkrw-typeLarge']/article[@class='rnkrw rnkrw-relative rnkrw-width100']/div[@class='rnkrwBody rnkrw-relative rnkrw-width100 ']/ol/li[1]/div[@class='rnkrw-float rnkrw-relative rnkrw-votes']/div[@class='rnkrw-float rnkrw-relative rnkrw-center']/span[@class='rnkrw-block rnkrw-votesNum rnkrw-down rnkrw-grey rnkrw-arial']
	/*
	 * Function to get text of up vote after sign in.
	 */
	public String getTextOfUpVote(int num){
		return safeGetText(upVote(num), SHORTWAIT);
	}
	/*
	 * Function to get text of down vote after sign in.
	 */
	public String getTextOfDownVote(int num){
		return safeGetText(downVote(num), SHORTWAIT);
	}
	/*
	 * Locator for sign in button.
	 */
	private By btnSignin(){
		return By.id("loginButton");
	}
	/*
	 * Function to click on sign in button after click on reset votes.
     */
	public void clickSubmit(){
	    safeClick(btnSignin());
	}
	/*
	 * Locator for 'List' in left side rail on widget page.
	 */
	private By widgetList(int num){
		return By.xpath("//div[@id='widgetSettings']/div[@class='relative box whiteBg']/div[@id='widgetList']/p["+num+"]");
	}
	/*
	 * Function to make click on 'List' option on widget page.
	 */
	public void clickOnWidgetList(int num){
		safeClick(widgetList(num), SHORTWAIT);
	}
	/*
	 * Locator for 'Edit this widget' option under 'list' heading on left side rail on widget page.
	 */
	private By editWidget(int num){
		return By.xpath("//div[@id='widgetSettings']/div[@class='relative box whiteBg']/div[@id='widgetList']/p["+num+"]/span");
	}
	/*
	 * Function to make click on 'Edit this widget' option under 'list' heading on left side rail widget page.
	 */
	public void clickOnEditWidget(int num){
		safeClick(editWidget(num), SHORTWAIT);
	}
	/*
	 * Locator for pop-up box appearing after click on 'edit this widget'.
	 */
	private By editListPopUp(){
		return By.id("UE_content");
	}
	/*
	 * Function to check the presence of pop-up box appearing after click on 'edit this widget'.
	 */
	public boolean isEditListPopUpPresent(){
		return isElementPresent(editListPopUp(),SHORTWAIT);
	}
	/*
	 * Locator for embed tab in footer.
	 */
	private By embedFooter(){
		return By.id("embedFooter");
	}
	/*
	 * Function to make click on embed tab.
	 */
	public void clickOnEmbedFooter(){
		scrollIntoViewThroughJavaScriptExecuter(embedFooter());
		safeJavaScriptClick(embedFooter(), SHORTWAIT);
	}
	/*
	 * Locator for image(image 1 appering on the page after click on embed tab at footer).
	 */
	private By image1(){
		return By.xpath("//article[@class='rnkrw rnkrw-relative rnkrw-width100']/div[contains(@id,'rnkrwBody_')]/ol/li/div[@class='rnkrw-relative rnkrw-img rnkrw-clear rnkrw-center']/div[@class='rnkrw-relative rnkrw-width100 rnkrw-sub rnkrw-center']/a/img");
	}
	/*
	 * Function to get attribute of image.
	 */
	public String getSrcOfImage1(){
		return driver.findElement(image1()).getAttribute("src");
	}
	/*
	 * Locator for image(image 1 appering on the page after click on embed tab at footer).
	 */
	private By image2(){
		return By.xpath("//article[@class='rnkrw rnkrw-relative rnkrw-width100']/div[contains(@id,'rnkrwBody_')]/ol/li[2]/div[@class='rnkrw-relative rnkrw-img rnkrw-clear rnkrw-center']/div[@class='rnkrw-relative rnkrw-width100 rnkrw-sub rnkrw-center']/a/img");
	}
	/*
	 * Function to get attribute of image.
	 */
	public String getSrcOfImage2(){
		return driver.findElement(image2()).getAttribute("src");
	}
	/*
	 * Locator for next button on image(image appering on the page after click on embed tab at footer).
	 */
	private By nextButtonOnImage(){
		return By.xpath("//div[@class='rnkrw-float rnkrw-absolute rnkrw-pointer rnkrwSlideImgNext']/i");
	}
	/*
	 * Function to make click on next button on image.
	 */
	public void clickOnNextButtonOnImage(){
		safeJavaScriptClick(nextButtonOnImage(), MEDIUMWAIT);
	}
	/*
	 * Locator for previous button on image(image appering on the page after click on embed tab at footer).
	 */
	private By prevButtonOnImage(){
		return By.xpath("//div[@class='rnkrw-float rnkrw-absolute rnkrw-pointer rnkrwSlideImgPrev']/i");
	}
	/*
	 * Function to make click on previous button image.
	 */
	public void clickOnPrevButtonOnImage(){
		safeJavaScriptClick(prevButtonOnImage(), SHORTWAIT);
	}
	/*
	 * Locator for embed tab in slide-show footer.
	 */
	private By slideFooterEmbed(){
		return By.xpath("//div[@id='listFooter']/span[@id='embedFooter']/span[@class='relative inlineBlock text rnkrDBlue lowercase']");
	}
	/*
	 * Function to click on embed tab in slide-show footer.
	 */
	public void clickOnSlideFooterEmbed(){
		safeJavaScriptClick(slideFooterEmbed(),SHORTWAIT);
	}
	/*
	 * Locator for widget pick up page ,opening the list in slide show form. 
	 */
	private By widgetPageAfterEmbedClick(){
		return By.id("widgetPreview");//div[@class='float slideshowPreview center']");
	}
	/*
	 * Function to get attribute of widget pick up page opened after click on embed tab.
	 */
	public String getAttributeOfWidgetPageAfterEmbedClick(){
		return driver.findElement(widgetPageAfterEmbedClick()).getAttribute("class");
	}
	/*
	 * Locator for next button on widget pick up page(Slide-show).
	 */
	private By nextButtonOnWidgetSlideShow(){
		return By.xpath("//div[contains(@id,'rnkrwSlideImgNext')]/div[@class='rnkrw-float rnkrw-absolute rnkrw-pointer rnkrw-btn']");
	}
	/*
	 * Function to click on next button on widget pick up page(Slide-show).
	 */
	public void clickOnNextButtonOnWidgetSlideShow(){
		safeClick(nextButtonOnWidgetSlideShow(),MEDIUMWAIT);
	}
	/*
	 * Function to check the presence of next button on widget pick up page(Slide-show).
	 */
	public boolean isNextButtonOnWidgetSlideShowPresent(){
		return isElementPresent(nextButtonOnImage(),MEDIUMWAIT);//change
	}
	/*
	 * Locator for number on image in widget pick up page(Slide-show).
	 */
	private By imageNumOnWidgetSlideShow(){
		return By.xpath("//div[@class='width100 center hidden slideCount']/span[@class='inlineBlock relative count']/span");
	}
	/*
	 * Function to get number on image in widget pick up page(Slide-show).
	 */
	public String getImageNumOnWidgetSlideShow(){
		return safeGetText(imageNumOnWidgetSlideShow(), SHORTWAIT);
	}
	/*
	 * Locator for last slide on widget pick up page(Slide-show).
	 */
	private By lastSlideOnWidgetSlideShow(){
		return By.xpath("//div[@class='rnkrw-float rnkrw-absolute rnkrw-width100 rnkrw-rlWrap']/ul");
	}
	/*
	 * Function to get size of last slide(no. of image link) on widget pick up page(Slide-show).
	 */
	public int getSizeOfLastSlideOnWidgetSlideShow(){
		return driver.findElement(lastSlideOnWidgetSlideShow()).findElements(By.tagName("li")).size();
	}
	/*
	 * Locator for votes on widget pick up page(Slide-show).
	 */
	private By voteOnWidgetSlideShow(){
		return By.xpath("//div[contains(@id,'rnkrwSlideVote')]/div[@class='rnkrw-float rnkrw-relative rnkrw-votes']");
	}
	/*
	 * Function to check the presence of votes button on widget pick up page(Slide-show).
	 */
	public boolean isVoteOnWidgetSlideShow(){
		return isElementVisible(voteOnWidgetSlideShow(),MEDIUMWAIT);
	}
	/*
	 * Locator for text over sliding image on widget pick up page(Slide-show).
	 */
	private By slidingImageUpTextAndNumber(String name){
		if(name.equalsIgnoreCase("text"))
			return By.xpath("//div[contains(@id,'rnkrwBody')]/ol/li/div[@class='rnkrw-clear rnkrw-width100 rnkrwSlideName']/span[contains(@class,'rnkrw-relative rnkrw-tableAlign rnkrw-name')]");
		else //number
			return By.xpath("//div[contains(@id,'rnkrwBody')]/ol/li/div[@class='rnkrw-clear rnkrw-width100 rnkrwSlideName']/span[contains(@class,'rnkrw-float rnkrw-relative rnkrw-center rnkrw-tableAlign rnkrw-rank')]");
			
	}
	/*
	 * Locator for text over sliding image 2 on widget pick up page(Slide-show).
	 */
	private By slidingImage2UpNumber(){
		return By.xpath("//div[contains(@id,'rnkrwBody')]/ol/li[2]/div[@class='rnkrw-clear rnkrw-width100 rnkrwSlideName']/span[contains(@class,'rnkrw-float rnkrw-relative rnkrw-center rnkrw-tableAlign rnkrw-rank')]");
	}
	/*
	 * Function to get number over sliding image on widget pick up page(Slide-show). 
	 */
	public String getTextOfSlidingImage2UpNumber(String name){
		return safeGetText(slidingImage2UpNumber(), MEDIUMWAIT);
	}
	/*
	 * Function to check the presence of text over sliding image on widget pick up page(Slide-show).
	 */
	public boolean isSlidingImageUpTextPresent(String name){
		return isElementPresent(slidingImageUpTextAndNumber(name),MEDIUMWAIT);
	}
	/*
	 * Function to get number over sliding image on widget pick up page(Slide-show). 
	 */
	public String getTextOfSlidingImage1UpNumber(String name){
		return safeGetText(slidingImageUpTextAndNumber(name), MEDIUMWAIT);
	}
	/*
	 * Function to get attribute of text over sliding image on widget pick up page(Slide-show).
	 */
	public String getAttributeOfSlidingImageUpText(String name){
		return driver.findElement(slidingImageUpTextAndNumber(name)).getCssValue("font-family");
	}
	
	
	/*
	 * Locator for image in the list.
	 */
	private By imageofItem(int num){
		return By.xpath("//ol[contains(@id,'rnkrwMLA_')]/li["+num+"]//img");
	}
	/*
	 * Function to click on image in the list. 
	 */
	public void clickOnImageOfItem(int num){
		 safeJavaScriptClick(imageofItem(num), MEDIUMWAIT);
	}
	
	/*
	 * Locator for Image of the item for href.
	 */
	private By imageofItemForhref(int num){
		return By.xpath("//ol[contains(@id,'rnkrwMLA_')]/li["+num+"]//img/..");
	}
	/*
	 * Function to get href of the image of a item. 
	 */
	public String gethrefOfImageOfItem(int num){
		return driver.findElement(imageofItemForhref(num)).getAttribute("href");
	}
	
	
	/*
	 * Locator for video in the list.
	 */
	private By videoofItem(int num){
		return By.xpath("//ol[contains(@id,'rnkrwMLA_')]/li["+num+"]//img[@class='rnkrw-float rnkrw-absolute rnkrw-vidOverlay']");
	}
	/*
	 * Function to click on video in the list. 
	 */
	public void clickOnVideoOfItem(int num){
		 safeClick(videoofItem(num), MEDIUMWAIT);
	}
	/*
	 * Locator for video of the item for href.
	 */
	private By presenceOfVideo(){
		return By.xpath("//div[@id='rnkrw-dialog-loader']");
	}
	/*
	 * Function to get href of the video of a item. 
	 */
	public boolean isVideoPresent(){
		return isElementPresent(presenceOfVideo(),MEDIUMWAIT);
	}
	/*
	 * Locator for image in the list.
	 */
	private By widgetListDisplayThumbnails(){
		return By.id("widgetListDisplayThumbnails");
	}
	/*
	 * Function to click on image in the list. 
	 */
	public void clickOnwidgetListDisplayThumbnails(){
		 safeJavaScriptClick(widgetListDisplayThumbnails(), MEDIUMWAIT);
	}//rnkrw-relative rnkrw-width100 rnkrwSlideThumbs
	/*
	 * Locator for image in the list.
	 */
	private By DisplayThumbnails(){
		return By.xpath("//div[@class='rnkrw-relative rnkrw-width100 rnkrwSlideThumbs']");
	}
	/*
	 * Function to get href of the video of a item. 
	 */
	public boolean isPresentDisplayThumbnails(){
		return isElementPresent(DisplayThumbnails(),MEDIUMWAIT);
	}
	 /*
	  * Locator for WidgetOFInSlideNumber
	  */
	 private By WidgetOFInSlideNumber(){
	  return By.xpath("//div[@class='rnkrw-relative rnkrw-right rnkrwSlideNavCount rnkrw-grey rnkrw-arial']");
	 }
	 /*
		 * Function to get text ofWidgetOFInSlideNumber
		 */
		public String getTextofWidgetOFInSlideNumber(){
			return safeGetText(WidgetOFInSlideNumber(), SHORTWAIT);
		}
		/*
		  * Locator for UpDownVote
		  */
		 private By UpDownVote(){
			 return By.xpath("//div[@class='rnkrw-relative rnkrw-width100 rnkrwSlideVote']/div[@class='rnkrw-float rnkrw-relative rnkrw-votes notranslate']");
			 //return By.xpath("//div[@id='rnkrwSlideVote_1000546834_1751589']/div[@class='rnkrw-float rnkrw-relative rnkrw-votes']");
		 }
		 /*
			 * Function to UpDownVote
			 */
			public boolean isUpDownVotePresent(){
				return isElementPresent(UpDownVote(),MEDIUMWAIT);
			}
			/*
			  * Locator for Blather
			  */
			 private By Blather(){
			  return By.xpath("//div[@class='rnkrw-relative rnkrw-blather rnkrw-arial']");
			 }
			 /*
			 * Function to get text BlatherText
			 */
			public String getTextofBlather(){
				return safeGetText(Blather(), SHORTWAIT);
			}
			/*
			 * Locator for video on node
			 */
			private By Videonode(int num){
				  return By.xpath("//div[contains(@class,'rnkrwBody rnkrw-relative rnkrw-width100 ')]/ol/li["+num+"]/div[@class='rnkrw-float rnkrw-relative rnkrw-img']/span//img[@class='rnkrw-float rnkrw-absolute rnkrw-vidOverlay']");  
			}	
			
			/*
			 * Function to click on image in the list. 
			 */
			public void clickOnVideonode(int num){
				 safeJavaScriptClick(Videonode(num), MEDIUMWAIT);
			}
			/*
			 * Locator for video window 
			 */
			private By videowindow(){
				//div[@id='player']/div/div[@class='html5-video-controls']
				return By.id("rnkrw-dialog-loader");
				//return By.xpath("//div[@id='player']/div/div[@class='html5-video-container']/div[@class='html5-video-controls']");
			}
			/*
			 * Function is used to play video
			 */
			public boolean isPresentvideowindow(){
				return isElementDisplayed(videowindow());
			}
			/*
			 * Locator for last slide on widget pick up page(Slide-show).
			 */
			private By lastSlideOnWidget4Rls(int num){
			return By.xpath("//div[@class='rnkrw-float rnkrw-absolute rnkrw-width100 rnkrw-rlWrap']/ul/li["+num+"]/a");
			}
			/*
			 * Locator for last slide on widget pick up page(Slide-show).
			 */
			private By lastSlideOnWidget4Rlsonhover(int num){
			return By.xpath("//div[@class='rnkrw-float rnkrw-absolute rnkrw-width100 rnkrw-rlWrap']/ul/li["+num+"]/a/div[@class='rnkrw-float rnkrw-absolute rnkrwLastSlideTitle']/span");
			}
			/*
			 * Function to get href of other ranker header.
			 */
			public String getHrefOflastSlideOnWidget4Rls(int num){
				return driver.findElement(lastSlideOnWidget4Rls(num)).getAttribute("href");
			}
			/*
			 * Function to used to open popup font style 
			 */
			 public void HoveronlastSlideOnWidget4Rls(int num)
			 {
			  mouseHover(lastSlideOnWidget4Rlsonhover(num), MEDIUMWAIT);
			 }
			 /*
			  * Locator for on widget page show  reset default 
			  */
			 private By resetdefault(){
			  return By.id("widgetReset");
			 }
			 /*
			 * Function to get text widget page show  reset default 
			 */
			public String getTextofresetdefault(){
				return safeGetText(resetdefault(), SHORTWAIT);
			}	 
			/*
			  * Locator for on widget footer
			  */
			 private By widgetfooter(){
			  return By.xpath("//div[@class='caption']/p/a");
			 }
			 /*
				 * Function to get font family of  title.
				 */
				public String getFontwidgetfooter(){
					return driver.findElement(widgetfooter()).getCssValue("font-style");
				}
}
