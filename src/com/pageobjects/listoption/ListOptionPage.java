package com.pageobjects.listoption;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.log.ShortTermMemoryHandler;
import org.testng.Assert;

import com.selenium.SafeActions;

public class ListOptionPage extends SafeActions {
	private WebDriver driver;

	/*
 * Constructor for the page.
 */
public ListOptionPage(WebDriver driver) {
	super(driver);
	this.driver = driver;
}

/*
 * Locator for Header in option.
 */
private By headeroption() {
	return By.xpath("//div[@id='mlaTab_actions']/div[@id='vMO']/span");
}

/*
 * Function to make click Header in option.
 */
public void clickOnheaderoption() {
	safeJavaScriptClick(headeroption(), MEDIUMWAIT);
}

/*
 * Locator for Header in option and check popup open.
 */
private By headeroptionpopup(String txt) {
	return By.xpath("//div[@id='vMO_list']/ul/li[contains(text(),'"+txt+"')]");
}

/*
 * Locator for Header in option and check popup open.
 */
private By headeroptionpopupNumber(int num) {
	return By.xpath("//div[@id='vMO_list']/ul/li["+num+"]");
}

/*
 * Function to check the presence of pop-up box appearing after click on
 * 'Header option'.
 */
public boolean isheaderoptionPopUpPresent(int num) {
	return isElementPresent(headeroptionpopupNumber(num));
}
/*
 * Function to make click Header in option open list item.
 */
public void clickOnheaderoptionpopup(String txt) {
	safeJavaScriptClick(headeroptionpopup(txt), MEDIUMWAIT);
}

/*
 * Locator for Header in option and click add item.
 */
private By additem() {
	return By.xpath("//div[@id='UE_search_container']");
}

/*
 * Function to check the presence of pop-up box appearing after click on
 * 'Header option'.
 */
public boolean isadditemPresent() {
	return isElementPresent(additem(),SHORTWAIT);
}


/*
 * Locator for Header in option and check print popup open .
 */
private By Printlist() {
	return By.xpath("//div[@id='main-container']/div[@id='preview-area']/div[@class='preview-area-plugin-wrapper']/embed");
}

/*
 * Function to check the presence of pop-up box appearing after click on
 * 'Header option'in print .
 */
public boolean isprintlistPresent() {
	System.out.println("com in this block");
	return isElementPresent(Printlist());
}

/*
 * Locator for various options in footer present after list.
 */
private By FooterAfterList(int num) {
	return By.xpath("//div[@id='listFooter']/span["+num+"]/span");
}

/*
 * Function to make click option in footer.
 */
public void clickOnFooterlistoption(int num) {
	safeJavaScriptClick(FooterAfterList(num), MEDIUMWAIT);
}

/*
 * Locator for clipboard pop-up.
 */
private By clipboardPopUp() {
	// return
// By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable clipboard']/div[@class='dialog ui-dialog-content ui-widget-content']");
return By
		.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front clipboard ui-draggable']");
}

/*
 * Function to check the presence of clipboard pop-up.
 */
public boolean isClipboardPopUpPresent() {
	return isElementPresent(clipboardPopUp());
}

/*
 * Locator for follow author popup.
 */
private By followLinks() {
	return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']");
}

/*
 * Function to check the presence of follow author popup.
 */
public boolean isFollowLinksPresent() {
	return isElementPresent(followLinks());
}

/*
 * Locator for sign in button.
 */
private By btnSignin() {
	return By.id("loginButton");
}

/*
 * Function to click on sign in button after click on reset votes.
 */
public void clickSubmit() {
	safeClick(btnSignin());
}

/*
 * Locator for facebook option.
 */
private By facebook() {
	return By.id("loginDialog_facebook");
}

/*
 * Function to make click on facebook.
 */
public void clickOnfacebook() {
	driver.findElement(facebook()).click();
	// safeClick(facebook(), VERYLONGWAIT);
}
/*
 * Locator for user image(after login with facebook and twitter).
 */
private By socialLinkUserImage(){
	return By.xpath("//div[@id='userArea']/img[@id='userProfileImg']");
}
/*
 * Function to check the user image(after login with facebook and twitter).
 */
public boolean isSocialLinkUserImagePresent(){
	//scrollIntoElementView(fbUserImage());
	//waitForPageToLoad(30);
	return isElementPresent(socialLinkUserImage(),SHORTWAIT);
}//booklet
/*
 * Locator for user image(after login with facebook and twitter).
 */
private By fbwindow(){
	return By.id("booklet");
}
/*
 * Function to check the user image(after login with facebook and twitter).
 */
public boolean isfbwindowPresent(){
	//scrollIntoElementView(fbUserImage());
	//waitForPageToLoad(30);
	return isElementPresent(fbwindow(),SHORTWAIT);
}//

/*
 * Locator for Twitter option.
 */
private By Twitter() {
	return By.id("loginDialog_twitter");
}

/*
 * Function to make click on Twitter.
 */
public void clickOnTwitter() {
	safeClick(Twitter(), VERYLONGWAIT);
}

/*
 * Locator for googlePlus option.
 */
private By googlePlus() {
	return By.id("loginDialog_google");
}

/*
 * Function to make click on googlePlus.
 */
public void clickOnGooglePlus() {
	safeClick(googlePlus(), VERYLONGWAIT);
}

/*
 * Locator for facebook option.
 */
private By facebookSignUp() {
	return By.id("signupDialog_facebook");
}

/*
 * Function to make click on facebook.
 */
public void clickOnfacebookSignUp() {
	safeJavaScriptClick(facebookSignUp(), MEDIUMWAIT);
	//
	//driver.findElement(facebookSignUp()).click();
	// safeClick(facebook(), VERYLONGWAIT);
}
/*
 * Locator for facebook share window.
 */
private By fbShareWindow(){
	return By.xpath("//div[@class='UIIntentionalStory_Share']/div[@class='unclickable']/div/div/div/div");
}
/*
 * Function to check the presence of facebook share window.
 */
public boolean isFbShareWindowPresent(){
	return isElementPresent(fbShareWindow());
}
/*
 * Locator for facebook share window.
 */
private By tiwtterWindow(){
	return By.xpath("//div[@class='Module PinCreate3 noDupWarning']");
}
/*
 * Function to check the presence of facebook share window.
 */
public boolean istiwtterWindowPresent(){
	return isElementPresent(tiwtterWindow(),SHORTWAIT);
}
/*
 * Locator for pintersetWindow 
 */
private By pintersetWindow(){
	
	return By.xpath("//div[@class='mainContainer']/div[@class='Module PinBookmarklet modalStyle']/div[@class='pinningBG']");
	//return By.xpath("//div[@class='Module PinCreate3 noDupWarning']/div[@class='pinContainer']/div[@class='pinModuleHolder']");
}
/*
 * Function to check the presence of pintersetWindow share window.
 */
public boolean ispintersetWindowPresent(){
	//System.out.println("aaaaaaaaaaaaaaaaaaaa");
	return isElementPresent(pintersetWindow(),SHORTWAIT);
}
//
/*
 * Locator for Twitter option.
 */
private By TwitterSignUp() {
	return By.id("signupDialog_twitter");
}

/*
 * Function to make click on Twitter.
 */
public void clickOnTwitterSignUp() {
	safeClick(TwitterSignUp(), VERYLONGWAIT);
}
/*
 * Locator for twitter image(user).
 */
private By twitImage(){
	return By.xpath("//div[@id='session']/h2/a/img");
}
/*
 * Function for verifying login for twitter
 */
public boolean isTwitLoginImagePresent(){
	return isElementPresent(twitImage(),SHORTWAIT);
}

/*
 * Locator for googlePlus option.
 */
private By googlePlusSignUp() {
	return By.id("signupDialog_google");
}

/*
 * Function to make click on googlePlus.
 */
public void clickOnGooglePlusSignUp() {
	safeJavaScriptClick(googlePlusSignUp(), VERYLONGWAIT);
}

public String switchToWindowAndGetTitle() {
	switchToNewWindow();
	return getTitle();
}

public void switchToParentWindow() {
	switchToWindow(0);
	
}

/*
 * Function to make click on 'edit rerank' option in list footer.
 */
public void clickOnEditRerankFoot(int num) {
	safeJavaScriptClick(FooterAfterList(num), MEDIUMWAIT);
}

/*
 * Locator for list pop-up after clicking on 'edit rerank' option in footer
 * after list.
 */
private By editRerankFootPopUp() {
	return By.id("UE_content");
}

/*
 * Function to check the presence of list pop-up after clicking on 'edit
 * rerank' option in footer after list.
 */
public boolean isEditRerankFootPopUpPresent() {
	return isElementPresent(editRerankFootPopUp());
}

/*
 * Function to get text of 'comment' option in list footer.
 */
public String getTextOfCommentFoot(int num) {
	return safeGetText(FooterAfterList(num), SHORTWAIT);
}

/*
 * Function to make click on 'comment' option in footer after list.
 */
public void clickOnCommentFoot(int num) {
	safeJavaScriptClick(FooterAfterList(num), SHORTWAIT);
}

/*
 * Locator for list pop-up after clicking on 'comment' option in footer
 * after list.
 */
private By commentBoxFoot() {
	return By.xpath("//section[@id='comments']/header/h3");
}

/*
 * Function to check the presence of comment box after clicking on 'comment'
 * option in footer after list.
 */
public boolean isCommentBoxFootPresent() {
	//waitForPageToLoad(30);
	return isElementPresent(commentBoxFoot(), MEDIUMWAIT);
}

/*
 * Function to get text of comment header after click on 'comment' option in
 * footer after list.
 */
public String getTextOfCommentBoxHeaderFoot() {
	return safeGetText(commentBoxFoot(), SHORTWAIT);
}

/*
 * Function to make click on 'Embed' option in list footer.
 */
public void clickOnEmbedFoot(int num) {
	safeJavaScriptClick(FooterAfterList(num), MEDIUMWAIT);
}

/*
 * Locator for embed page opening after click on embed option in list
 * footer.
 */
private By embedAfterClick() {
	return By
			.xpath("//div[@id='siteBody']/article[@id='widget']/div[@id='widgetBody']/span");
}

/*
 * Function to check the presence of embed page opening after click on embed
 * option in list footer.
 */
public boolean isEmbedHeaderAfterClickPresent() {
	return isElementPresent(embedAfterClick(), MEDIUMWAIT);
}

/*
 * Function to hover over 'share' option in list footer.
 */
public void hoverOverShareFoot(int num) {
	scrollIntoViewThroughJavaScriptExecuter(FooterAfterList(num));
	mouseHover(FooterAfterList(num), SHORTWAIT);
	
}

/*
 * Locator for social link pop-up after hovering over share option.
 */
private By sharePopUp() {
	return By.id("shareFooterSub");
}

/*
 * Function to check the presence of social link pop-up after hovering over
 * share option.
 */
public boolean isSharePopUpPresent() {
	return isElementPresent(sharePopUp());
}

/*
 * Locator for facebook option in list footer.
 */
private By facebookFoot() {
	return By.xpath("//div[@id='shareFooterSub']/span[@class='block item shareBox']/span[@id='share_facebook-share_listFoot']/span");
}

/*
 * Function to make click on facebook.
 */
public void clickOnfacebookFoot() {
	driver.findElement(facebookFoot()).click();
	//((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(facebookFoot()));
}

/*
 * Locator for Twitter option.
 */
private By TwitterFoot() {
	return By.xpath("//span[@id='share_twitter-share_listFoot']/span");
}

/*
 * Function to make click on Twitter.
 */
public void clickOnTwitterFoot() {
//	safeJavaScriptClick(TwitterFoot(), MEDIUMWAIT);
	driver.findElement(TwitterFoot()).click();
}

/*
 * Locator for pinterest option.
 */
private By pinterestFoot() {
	return By.xpath("//div[@id='shareFooterSub']/span[@class='block item shareBox']/span[@id='share_pinterest_listFoot']/span");
}

/*
 * Function to make click on pinterest.
 */
public void clickOnPinterestFoot() {
	//safeClick(pinterestFoot(), MEDIUMWAIT);
	driver.findElement(pinterestFoot()).click();
}

/*
 * Locator for 'next list' options in list footer.
 */
private By nextListInFooter() {
	return By.id("nextListFooter");
}

/*
 * Function to get href of 'next list' in list footer.
 */
public String getHrefOfNextListInFooter() {
	return driver.findElement(nextListInFooter()).getAttribute("data-href");
}

/*
 * Function to make click on 'next list' in list footer.
 */
public void clickOnNextListInFooter() {
	safeJavaScriptClick(nextListInFooter(), SHORTWAIT);
}

/*
 * Locator for 'rerank list' options in list footer.
 */
private By rerankListInFooter() {
	return By.xpath("//div[@id='listFooter']//span[@id='reRankFoot']//span[@class='relative inlineBlock text rnkrDBlue lowercase']");
}

/*
 * Function to make click on 'rerank list' in list footer.
 */
public void clickOnrerankListInFooter() {
	safeClick(rerankListInFooter(), SHORTWAIT);
}

/*
 * Locator for Rerank list  and check open UE.
 */
private By rerankbtnUE() {
	return By.xpath("//div[@id='UE_container']");
}

/*
 * Function to check the presence of UE appearing after click on 'Rerank
 * list button'.
 */
public boolean isPresentUE() {
	return isElementPresent(rerankbtnUE());
}
/*
 * Locator for + icon to add list in list.
 */
private By addItemInList(){
	return By.id("UE_search_openBtn");
}
/*
 * Function to click on + icon to add list in list.
 */
public void clickOnAddItemInList(){
	safeJavaScriptClick(addItemInList(),SHORTWAIT);
}
/*
 * Locator for list node.
 */
private By listNode(int num){
	return By.xpath("//section[@id='mainListCnt']/ol/li["+num+"]");
}
/*
 * Function to check the scrolling of list in presence of add item box.
 */
public void checkScrollOfList(int num){
	try{
		driver.findElement(listNode(num)).click();
    }catch(Exception e){
    	Assert.assertTrue(true);
    }
}
/*
 * Locator for text box at bottom of list(adding new list item).
 */
private By addListBox(){
	return By.xpath("//span[@id='UE_openSearch_inputWrap']/input");
}
/*
 * Function to give text in text box at bottom of list(adding new list item).
 */
public void putTextInAddListBox(String txt){
	safeClearAndType(addListBox(), txt, SHORTWAIT);
	driver.findElement(addListBox()).sendKeys(Keys.ENTER);
}
/*
 * Locator for message and grey arrow (near message in add item box) displayed after searching a list.
 */
private By listSearchMessageAndArrow(String txt){
	if(txt.equalsIgnoreCase("message"))
return By.xpath("//div[@id='UE_search_content']/ul/span");
else //arrow
return By.xpath("//div[@id='UE_search_content']/ul/span/i");
}
/*
 * Function to check the presence of message and grey arrow (near message in add item box) displayed after searching a list.
 */
public boolean isListSearchMessageAndArrowDisplayed(String txt){
	return isElementPresent(listSearchMessageAndArrow(txt));
}
/*
 * Function to get text of message displayed after searching a list.
 */
public String getTextOfMessage(String txt){
	return safeGetText(listSearchMessageAndArrow(txt), SHORTWAIT);
}
/*
 * Function to get color of arrow (near message in add item box) displayed after searching a list.
 */
public String getColorOfArrow(String txt){
	return driver.findElement(listSearchMessageAndArrow(txt)).getCssValue("color");
}
/*
 * Locator for adding a list-node from add item box after searching for it.
 */
private By addSearchItem(){
	return By.xpath("//div[@id='UE_search_container']/div[@id='UE_search_create']/span[@class='float relative block action center']/span[@id='UE_search_create_add']");
	//return By.id("UE_search_create_add");//UE_openSearch_input
	//return By.id("UE_openSearch_input");
}
/*
 * Function to click on + icon in add item box after searching for list.
 */
public void clickOnAddSearchItem(){
	safeClick(addSearchItem(),SHORTWAIT);
}
/*
 * Locator for closing the add item box pop up.
 */
private By closeAddItemBox(){
	return By.xpath("//div[@id='UE_openSearch_container']/div[@class='relative title center rnkrDBlueBg white']/i");
}
/*
 * Function to closing the add item box pop up.
 */
public void clickOnCloseAddItemBox(){
	safeClick(closeAddItemBox(), SHORTWAIT);
}
/*
 * Locator for image option in edit my item box.
 */
private By imageIconInEditItemBox(){
	//return By.xpath("//div[contains(@id,'UE_node_')]/div[contains(@id,'UE_node_')]/div[@class='inlineBlock center item pointer on']");
	return By.xpath("//div[@id='UE_node_container']/div[@id='UE_node_container_window']//div[@class='relative UE_node_header']/div[@class='float absolute center chalkBg UE_node_nav']/div[@class='inlineBlock center item pointer on']");
}
/*
 * Function to get attribute of image icon in edit my item box after adding a list node from add item box.
 */
public String getAttriOfImageIconInEditItemBox(){
	return driver.findElement(imageIconInEditItemBox()).getAttribute("class");
}
/*
 * Locator for image search results diplayed in edit my item box after adding a list node from add item box.
 */
private By imageResultInEditItemBox(int num){
	return By.xpath("//ul[@class='UE_flickrThumbs']/li["+num+"]/img");
}
/*
 * Locator for image count
 */
private By imagecount(){
	return By.xpath("//ul[contains(@id,'UE_flickrThumbs')]/li");
}
/*
 * Function to check the how manny  video present
 */
public int Imagecount(){
	return driver.findElements(imagecount()).size();
}
/*
 * Locator type video search items
 */
 private By imagesearch(){
	 return By.xpath("//div[@class='center lightGreyBg UE_flickrSearch']/input[contains(@class,'UE_flickrSearch')]");
 }	
 /*
 * Function to give text in text box at bottom of list(adding new list item).
 */
public void putTextInAddimage(String txt){
	//safeClick(imagesearch(), MEDIUMWAIT);
	safeClearAndType(imagesearch(), txt, MEDIUMWAIT);
}
/*
 * Function to check the presence of images displyed in edit my item box for added node.
 */
public boolean isImageResultInEditItemBoxPresent(int num){
	return isElementPresent(imageResultInEditItemBox(num),SHORTWAIT);
}
/*
 * Function to get attribute of image selected.
 */
public String getSrcOfImageResultInEditItemBox(int num){
	return driver.findElement(imageResultInEditItemBox(num)).getAttribute("src");
}
/*
 * Function to select any image from search results shown in edit my item box for added node.
 */
public void clickOnImageResultInEditItemBox(int num){
	safeClick(imageResultInEditItemBox(num), MEDIUMWAIT);
}
/*
 * Locator for 'select' button for selecting the image from edit my item box.
 */
private By selectButton(){
	return By.xpath("//div[@class='relative inner']/div[@class='center btns']/span[@class='inlineBlock btnBlue uppercase UE_flickrAdd external']");
}
/*
 * Function to click on 'select' button.
 */
public void clickOnSelectButton(){
	safeClick(selectButton(), MEDIUMWAIT);
}
/*
 * Locator for 'done' button.
 */
private By doneButton(){
	return By.id("UE_node_done");
}
/*
 * Function to click on 'done' button after adding image.
 */
public void clickOnDoneButton(){
	safeJavaScriptClick(doneButton(), MEDIUMWAIT);
}
	/*
	 * Locator for image of list-node.
	 */
	private By listNodeImage(String image){
		if(image.equalsIgnoreCase("image")){
			return By.xpath("//section[@id='mainListCnt']/ol/li[last()]/div[@class='float relative img']/img");
			}
		else{  //delete list node
			return By.xpath("//section[@id='mainListCnt']/ol/li[last()]/span[contains(@id,'_remove')]");	
		}
	}
	/*
	 * Locator for last list node.
	 */
	private By lastNode(){
		return By.xpath("//section[@id='mainListCnt']/ol/li[last()]");
	}
/*
 * Function to get attribute of image of list-node.
 */
public String getSrcOfListNodeImage(String image){
	return driver.findElement(listNodeImage(image)).getAttribute("src");
}
/*
 * Function to click on 'delete' button after adding image.
 */
public void clickOndeletelist(String node){
	scrollIntoElementView(listNodeImage(node));
	mouseHover(lastNode(), MEDIUMWAIT);
	safeJavaScriptClick(listNodeImage(node), MEDIUMWAIT);
}
/*
 * Locator for cancel of add item window.
 */
private By cancle(){
	return By.xpath("//div[@class='relative title center rnkrDBlueBg white']/i']");
}
/*
 * Function to click on 'cancle' button after adding image.
 */
public void clickOndcancle(){
	safeClick(cancle(), MEDIUMWAIT);
}
/*
 * Locator For 'Video edit sub option 
 */
private By editsubvideoIcon() {
	return By.xpath("//div[contains(@id,'_nav_video')]/span/i");
}

/*
 * Function to click on video icon.
 */
public void clickoneditsubvideoIcon() {
	safeJavaScriptClick(editsubvideoIcon(), MEDIUMWAIT);
}
///*
// * Locator For 'Video add 
// */
//private By addvideo(int linum) {
//	return By.xpath("//div[@class='relative width100 height100 chalkBg']/div[@id='UE_node_content']/ul[@class='UE_youtubeThumbs']/li["+linum+"]/img");
//}
///*
// * Locator For 'Video count in list
// */
//private By videocount() {
// return By.xpath("//div[contains(@class,'UE_node_content')]/ul[@class='UE_youtubeThumbs']/li");
//}
/*
 * Locator For 'Video add 
 */
private By addvideo(int num) {
 return By.xpath("//div[contains(@class,'UE_node_content')]/ul[@class='UE_youtubeThumbs']/li["+ num + "]/img");
 //return By.xpath("//div[@class='relative width100 height100 chalkBg']/div[@id='UE_node_content']/ul[@id='UE_youtubeThumbs']/li["+linum+"]/img");
}
/*
 * Locator For 'Video count in list
 */
private By videocount() {
 return By.xpath("//div[contains(@class,'UE_node_content')]/ul[@class='UE_youtubeThumbs']/li");
}
///*
// * Locator For 'Video count in list
// */
//private By videocount() {
//	return By.xpath("//div[@class='relative width100 height100 chalkBg']/div[@id='UE_node_content']/ul[@id='UE_youtubeThumbs']/li");
//}
/*
 * Function to check the how manny  video present
 */
public int Videocount(){
	return driver.findElements(videocount()).size();
}
/*
 * Function is used to get attribute of vedio
 */
public String getsrcaddvideo(int num) {
	return driver.findElement(addvideo(num)).getAttribute("src");
}
/*
 * Function to video add.
 */
public void clickonaddvideo(int num) {
	safeJavaScriptClick(addvideo(num), MEDIUMWAIT);
}
/*
 * Locator for 'select' button for selecting the image from edit my item box.
 */
private By videoselectButton(){
	return By.xpath("//div[@class='center btns']/span[contains(@id,'UE_youtube_')]");
}

/*
 * Function to click on 'select' button.
 */
public void clickOnvideoSelectButton(){
	safeJavaScriptClick(videoselectButton(), MEDIUMWAIT);
}
/*
 * Locator For 'add image in list.
 */
private By addedititemsinlist(int linum) {
	return By.xpath("//section[@id='mainListCnt']/ol/li[last()]/div[@class='float relative img']//img");
}
 /*
  * Function is used to get attribute of image
  */
   public String getsrcafteraddedititems(int num) {
	   return driver.findElement(addedititemsinlist(num)).getAttribute("src");
}
/*
 * Locator Alphabetically sorted list node's text.
 */
 private By sortedNodeText(int num){
	 return By.xpath("//div[@id='filLContent']/ol[@id='filLContBody']/li["+num+"]/div[contains(@class,'relative name')]/p//span[@class='inlineBlock oNode']");
	 //return By.xpath("//div[@id='filLContent']/ol[@id='filLContBody']/li["+num+"]/div[@class='relative name authored exclude']/p//span[@class='inlineBlock oNode']");
 }
 /*
  * Functiom to get text of node of alphabetically sorted list.
  */
  public String getTextOfSortedNodeText(int num){
	  return safeGetText(sortedNodeText(num), MEDIUMWAIT);
  }
//filLSidebar
 /*
 * Locator for ranking radio button
 */ 
 private By rankingradiobtn(){
	 return By.xpath("//div[@id='filList']/div[@id='filLSidebar']//input[@value='ranking']");
 }  
 /*
 * Function to select  ranking radio btn .
 */
public void clickOnrankingradiobtn(){
	safeSelectRadioButton(rankingradiobtn(), MEDIUMWAIT);
}
/*
 * Locator ranking sorted list
 */
 private By sortedranking(int num){
	 return By.xpath("//div[@id='filLContent']/ol[@id='filLContBody']/li["+num+"]/div[@class='float relative rank center']/span[@class='rank tableAlign']");
 }
 /*
  * Functiom to get text of node of ranking sorted list.
  */
  public String getrankOfSortedlist(int num){
	  return safeGetText(sortedranking(num), MEDIUMWAIT);
  }
    /*
	 * Locator type video search itmes
	 */
	 private By videosearch(){
		 return By.xpath("//input[@class='UE_youtubeSearch_input']");
	 }	
	 /*
		 * Function to give text in text box at bottom of list(adding new list item).
		 */
		public void putTextInAddvideo(String txt){
			safeClearAndType(videosearch(), txt, SHORTWAIT);
		}
		/*
		 * Locator for search filed
		 */
		private By searchfiled(){
			return By.id("filLInput");
		}
		/*
		 * This function is used to type on search field
		 */
		public void typeonsearchfield(String text){
			safeClearAndType(searchfiled(), text, MEDIUMWAIT);
		}
		/*
		 * Locator for search icon
		 */
		private By searchicon(){
			return By.id("filLTrigger");
		}
		/*
		 * This function is used to click on searchicon
		 */
		public void Clickonsearchicon(){
			safeJavaScriptClick(searchicon(),MEDIUMWAIT);
		}
/*
 * Locator for searching list
 */
 private By listaftersearch(){
	 return By.id("filLContBody");
 }
 /*
 * Function to check the presence of list after search
 */
public boolean isPresentSearchlist(){
	return isElementPresent(listaftersearch(),SHORTWAIT);
}
/*
 * Locator for searching list of text
 */
 private By searchlistText(int num){
	 return By.xpath("//div[@id='filLContent']/ol[@id='filLContBody']/li["+num+"]//p");
	// return By.xpath("//div[@id='filLContent']/ol[@id='filLContBody']/li[1]/div[@class='relative name anClip']/p/a/span[@class='block oNode']");
 
 }
 /*
  * Locator for searching list of text
  */
  private By filterlistText(String txt){
 	 return By.xpath("//span[contains(text(),'"+txt+"')]");
 	// return By.xpath("//div[@id='filLContent']/ol[@id='filLContBody']/li[1]/div[@class='relative name anClip']/p/a/span[@class='block oNode']");
  
  }
  /*
   * Functiom to get text of searchlist
   */
   public boolean getTextOffilterlist(String txt){
 	  return isElementPresent(filterlistText(txt), MEDIUMWAIT);
   }	
 /*
  * Functiom to get text of searchlist
  */
  public String getTextOfsearchlist(int num){
	  return safeGetText(searchlistText(num), MEDIUMWAIT);
  }	
  /*
   * Function to check the presence of list after search
   */
  public boolean isPresentbeforeSearchlist(int num){
  	return isElementPresent(searchlistText(num),SHORTWAIT);
  }
  /*
   * Locator for delete filter
   */
   private By deletefilter(){
  	 return By.xpath("//div[@id='filLSTerms']//span[@class='floatRight block ui-icon ui-icon-close white']");
  	// return By.xpath("//div[@id='filLContent']/ol[@id='filLContBody']/li[1]/div[@class='relative name anClip']/p/a/span[@class='block oNode']");
   
   }
   /*
    * Locator for searching list of text
    */
    private By beforesearchlistText(int num){
    	return By.xpath("//section[@id='mainListCnt']/ol/li["+num+"]//p/a/span");//[@class='block oNode']
   	// return By.xpath("//div[@id='filLContent']/ol[@id='filLContBody']/li[1]/div[@class='relative name anClip']/p/a/span[@class='block oNode']");
    
    }
    /*
     * Functiom to get text of searchlist
     */
     public String getTextOfbeforesearchlistText(int num){
   	  return safeGetText(beforesearchlistText(num), MEDIUMWAIT);
     }	
   /*
	 * This function is used to click on delete filter
	 */
	public void Clickondeletefilter(){
		safeJavaScriptClick(deletefilter(),MEDIUMWAIT);
	}
	/*
	 * Locator for selectparameter by dropdown
	 */ 
	 private By selectdropdown( ){
		 return By.xpath("//div[@id='showDataColumn']/select[@role='listbox']");
	 }
	 
	/*
	 * Locator for selectparameter by dropdown
	 */ 
	 private By selectparameterdropdown( String txt){
		 return By.xpath("//div[@id='showDataColumn']/select[@role='listbox']/option[contains(text(),'"+txt+"')]");
	 }
	 /*
		 * This function is used to click on select option of parameter
		 */
		public void Clickonselectdropdown(){
			safeClick(selectdropdown(),MEDIUMWAIT);
		} 
		/*
		 * This function is used to click on select option of parameter
		 */
		public void Clickonselectparameterr(String txt){
			safeClick(selectparameterdropdown(txt),MEDIUMWAIT);
		} 
//	/*
//	 * Locator for filterparameter
//	 */ 
//	 private By filterparameter( int number){
//		 return By.xpath("//div[@id='filList']/div[@id='filLSidebar']/div[@id='filLSResCont']/ul[@id='filLSResults']/li["+number+"]//p//span");
//	 }
//	    /*
//		 * This function is used to click on delete filter
//		 */
//		public void Clickonfilterparameter(int num){
//			safeJavaScriptClick(filterparameter(num),MEDIUMWAIT);
//		} 
		/*
		 * Locator for filterparameter
		 */ 
		 private By parameteroftext( int num){
			 return By.xpath("//section[@id='mainListCnt']/ol/li["+num+"]//p/span");
		 }
		 /*
	     * Functiom to get text of searchlist
	     */
	      public String getTextOparameter(int num){
	   	  return safeGetText(parameteroftext(num), MEDIUMWAIT);
	     }	
	      /*
			 * Locator for filter result select
			 */ 
			 private By filterresultselect( int num){
				 return By.xpath("//div[@id='filList']/div[@id='filLSidebar']/div[@id='filLSResCont']/ul[@id='filLSResults']/li["+num+"]/span");
			 } 
			 /*
				 * This function is used to click on filter result select
				 */
				public void Clickonfilterresultselect(int num){
					safeJavaScriptClick(filterresultselect(num),MEDIUMWAIT);
				} 
				/*
				 * Locator for filter result select
				 */ 
				 private By filterresultselectsuboption( int num,String txt){
					// return By.xpath("//div[@id='filList']/div[@id='filLSidebar']/div[@id='filLSResCont']/ul[@id='filLSResults']/li["+num+"]/ul/li["+num1+"]");
					 return By.xpath("//div[@id='filLSResCont']/ul[@id='filLSResults']/li["+num+"]/ul/li[contains(text(),'"+txt+"')]");
				 } 
				 /*
				  * This function is used to click on filter result select
				  */
				 public void Clickonfilterresultselectsuboption(int num,String txt){
					 safeJavaScriptClick(filterresultselectsuboption(num,txt),MEDIUMWAIT);
				 } 
   /*
 	* Locator for images of nodes in list.
 	*/
	private By listNodeImage(int num,String name){
		if(name.equalsIgnoreCase("image"))
			name="//section[@id='mainListCnt']/ol/li["+num+"]/div[@class='float relative img']";
		else
			if(name.equalsIgnoreCase("title"))
				name="//section[@id='mainListCnt']/ol/li["+num+"]/div[@class='relative name']/p/a/span";
			else
				name="//section[@id='mainListCnt']/ol/li["+num+"]/div[@class='relative name']/p/span";
		return By.xpath(name);
	}
	/*
	 * Function to check the presence of node images(loading properly).
	 */
	public boolean isListNodeImagePresent(int num,String name){
		return isElementPresent(listNodeImage(num,name),SHORTWAIT);
	}
	/*
	 * Function to check the presence of node title(loading properly).
	 */
	public boolean isListNodeTitlePresent(int num,String name){
		return isElementPresent(listNodeImage(num,name),SHORTWAIT);
	}
	/*
	 * Function to check the presence of node meta-data(loading properly).
	 */
	public boolean isListNodeMdataPresent(int num,String name){
		return isElementPresent(listNodeImage(num,name),SHORTWAIT);
	}
	/*
	 * Locator for the Ad nodes.
	 */
	private By node(int nodeNumber){
		//return By.xpath("//section[@id='mainListCnt']/ol[@id='mainList']/li["+nodeNumber+"]");
		return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["+nodeNumber+"]/following-sibling::*[1]/div/div");
	}
	/*
	 * This function is used to scroll upto a node.
	 */
	public void scrollToNode(int nodeNumber){
		scrollIntoViewThroughJavaScriptExecuter(node(nodeNumber));
	}
	/*
	 * Function to check the presence of Ads.
	 */
	public boolean isAdNodePresent(int i){
		return isElementPresent(node(i));
	}
	/*
	 * Locator for comment in header(above list).
	 */
	private By commentAtHead(){
		return By.id("mlaTab_comment");
	}
	/*
	 * Function to click on comment in header.
	 */
	public void clickOnCommentAtHead(){
		safeClick(commentAtHead(), SHORTWAIT);
	}
	/*
	 * Function to check the scrolling of comment box after click on comment at header.
	 */
	public boolean isCommentBoxFootVisible(){
		return isElementVisible(commentBoxFoot(), SHORTWAIT);
	}
	/*
	 * Locator for check box in add tags pop-up in UE. 
	 */
	private By tagsCheckBox(){
		
		return By.xpath("//input[@data-name='no comments']");
	}
	/*
	 * Function to select check box of tag 'no comments'.
	 */
	public void selectTagsCheckBox(){
		safeCheck(tagsCheckBox(), MEDIUMWAIT);
	}
	/*
	 * Locator for 'no comments' tag.
	 */
	private By noCommentsTag(String txt){
		if(txt.contains("noComments"))
			txt="//ul[@id='UE_settings_tags_remove']/li[@class='float block tag rnkrCRRedBg']/span[@class='inlineBlock txt lowercase']";
		else // 'cross'
			txt="//ul[@id='UE_settings_tags_remove']/li[@class='float block tag rnkrCRRedBg']/i";
		return By.xpath(txt);
	}
	/*
	 * Function to get text of the tag 'no comments'.
	 */
	public String getTextOfNoCommentsTag(String txt){
		return safeGetText(noCommentsTag(txt), MEDIUMWAIT);
	}
	/*
	 * Function to check the presence of comment in header.
	 */
	public boolean isCommentAtHeadPresent(){
		return isElementPresent(commentAtHead());
	}
	/*
	 * Function to click on 'x' on tag.
	 */
	public void clickOnNoCommentsTag(String txt){
		safeClick(noCommentsTag(txt), MEDIUMWAIT);
	}
	////5 june
	
	/*
	 * Locator for   twitter).
	 */
	private By presencetiwtter(){
		return By.xpath("//div[@class='TopNav']/div[@class='TopNav--container u-cf']");
	}
	/*
	 * Function to check the user image(after login with facebook and twitter).
	 */
	public boolean isPresenttiwtterlogin(){
		//scrollIntoElementView(fbUserImage());
		//waitForPageToLoad(40);
		return isElementPresent(presencetiwtter(),SHORTWAIT);
	}
	/*
	 * Locator for   twitter).
	 */
	private By presencegoogle(){
		return By.xpath("//div[@class='Ea-q']");
	}
	/*
	 * Function to check the user image(after login with facebook and twitter).
	 */
	public boolean isPresentpresencegooglelogin(){
		//scrollIntoElementView(fbUserImage());
		//waitForPageToLoad(40);
		return isElementPresent(presencegoogle(),SHORTWAIT);
	}
	private By authorednode() {
		return By.xpath("//section[@id='mainListCnt']/ol/li[last()]/div[contains(@class,'relative name')]/p/span[@itemprop='name']");}
	/*
	 * This function to get font style of ultimate text.
	 */
	public String getFontStyleauthorednode(){
		isElementVisible(authorednode(), VERYLONGWAIT);
		return driver.findElement(authorednode()).getCssValue("font-style");
	}
	/*
	 * Locator for defaultlists present in one page
	 */
	private By DefaultLists(int num){
		return By.xpath("//div[@id='listBody']/section[@id='mainListCnt']/ol/li["+num+"]");
	}
	/*
	 * Function to check the presence of 100 lists in one page by default.
	 */
	public boolean isPresentDefaultLists(int num){
		//waitForPageToLoad(100);
		return isElementPresent(DefaultLists(num));
		//return isElementPresent(DefaultLists(num),LONGWAIT);
	}
	/*
	 * Locator for loadmore btn
	 */
	private By LoadMoreBtn(){
		return By.id("loadMore_next_message");
	}
	/*
	 * This function is used to click on filter result select
	 */
	public void ClickonLoadMoreBtn(){
		safeJavaScriptClick(LoadMoreBtn(),MEDIUMWAIT);
	} 
	/*
	 * Function for autoloading.
	 */
 	public void autoloading(int number){
 		scrollIntoViewThroughJavaScriptExecuter(DefaultLists(number));
 		waitForElementVisible(DefaultLists(number),52);
 	}
	
		
	}
	

