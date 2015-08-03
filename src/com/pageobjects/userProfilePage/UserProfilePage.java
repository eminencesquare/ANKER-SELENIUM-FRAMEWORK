package com.pageobjects.userProfilePage;

import java.util.Collections;
import java.util.List;

import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pageobject.login.ProfilePage;
import com.pageobject.login.SigninPage;
import com.selenium.SafeActions;

public class UserProfilePage extends SafeActions {
	private WebDriver driver;
	/*
	 * Constructor for the page.
	 */
	public UserProfilePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	} 
	/*
	 * Locator for tabs under settings pop-up. 
	 */
	private By settingPopUp(String txt){
		if(txt.equalsIgnoreCase("profile"))
			return By.xpath("//div[@id='userSettingsDialog']/div[@id='userSettingsNav']/div[@id='profileSettingsBtn']");
		else //account
			return By.xpath("//div[@id='userSettingsDialog']/div[@id='userSettingsNav']/div[@id='accountSettingsBtn']");
	}
	/*
	 * Function to check the presence of tabs under setting pop-up.
	 */
	public boolean isSettingPopUpTabsPresent(String txt){
		return isElementPresent(settingPopUp(txt),SHORTWAIT);
	}
	/*
	 * Locator for 'alert' tab.
	 */
	private By funTabs(int linum){
		
			return By.xpath("//div[@id='userTabs']/ul/li["+linum+"]/a");
		
	}
	/*
	 * Function to click on 'alert' tab.
	 */
	    public void clickOnFunTab(int num){
		safeJavaScriptClick(funTabs(num), MEDIUMWAIT);
//		Actions act= new Actions(driver);
//		act.click(driver.findElement(funTabs(num))).perform();
		
	}
	/*
	 * Locator for header under alert section.
	 */
	private By headerUnderAlert(){
		return By.xpath("//div[@id='alerts']/div/h4");
	}
	/*
	 * Function to get text of header in alert section.
	 */
	public String getTextOfHeaderUnderAlert(){
		return safeGetText(headerUnderAlert(), SHORTWAIT);
	}
	/*
	 * Locator for user name section in notes section.
	 */
	private By userNameInNote(String txt){
		if(txt.equalsIgnoreCase("user name"))
			return By.xpath("//section[@id='notes']/ol/li/div[@class='float absolute block name']/a");
		else // block/unblock this user
			return By.xpath("//section[@id='notes']/ol/li/div[contains(@class,'float absolute block name')]/span");
	}
	/*
	 * Function to check the presence of user name in notes section.
	 */
	public boolean isUserNameInNotePresent(String txt){
		return isElementPresent(userNameInNote(txt),SHORTWAIT);
	}
	/*
	 * Function to click on 'block/unblock this user' text under user name.
	 */
	public void clickOnBlockUnblockUser(String txt){
		safeClick(userNameInNote(txt), MEDIUMWAIT);
	}
	/*
	 * Function to get text under user name after blocking it.
	 */
	public String getTextOfUnblockUser(String txt){
		return safeGetText(userNameInNote(txt), MEDIUMWAIT);
	}
	/*
	 * Locator for sent and received messages in notes section.
	 */
	private By messageInNote(String txt){
		String locator="a";
		if(txt.equalsIgnoreCase("message"))
			locator="//section[@id='notes']/ol/li/p[@class='note']";
		else //send a note back
			locator="//section[@id='notes']/ol/li/div[@class='midGrey action']/span[@role='button']";
		return(By.xpath(locator));
	}
	/*
	 * Function to check the presence of message in note section.
	 */
	public boolean isMessageInNotePresent(String txt){
		return isElementPresent(messageInNote(txt),SHORTWAIT);
	}
	/*
	 * Function to get text of message in note section.
	 */
	public String getTextOfMessageInNote(String txt){
		return safeGetText(messageInNote(txt), MEDIUMWAIT);
	}
	/*
	 * Function to click on 'send a note back' text, in note section.
	 */
	public void clickOnSendNoteBack(String txt){
		safeClick(messageInNote(txt), MEDIUMWAIT);
	}
	/*
	 * Locator for time section in notes section.
	 */
	private By timeInNote(){
		return By.xpath("//section[@id='notes']/ol/li/div[@class='midGrey action']/span[@class='floatRight relative date']");
	}
	/*
	 * Function to check the presence of time in note section.
	 */
	public boolean isTimeInNotePresent(){
		return isElementPresent(timeInNote(),SHORTWAIT);
	}
	 /*
     * Locator for user profile on home page.
     */
    private By userProfile(){
            return By.xpath("//header[@id='siteHead']/div[@id='userArea']/img");///a
    }
    /*
     * Function to click on user profile on home page.
     */
    public void clickOnProfile(){
            safeJavaScriptClick(userProfile(),MEDIUMWAIT);
    }
    /*
     * Locator for view Profile home page.
     */
    private By viewProfile(){
            return By.xpath("//div[@id='userAreaMenu']/ul/li[1]/a");///a
    }
    /*
     * Function to click on user profile on home page.
     */
    public void clickOnviewProfile(){
            safeClick(viewProfile(),MEDIUMWAIT);
    }
    /*
     * Functioin to hover over user profile.
     */
    public void hoverOnProfile(){
    	mouseHover(userProfile(), SHORTWAIT);
    }
    
    /*
     * Locator for Organize my list button.
     */
    private By organizeMyListBtn(){
            return By.id("userOrganize");
    }
    /*
     * Function to click on Organize my list button.
     */
    public void clickBtnOrganizeMyList(){
    		waitForElementClickable(organizeMyListBtn(), 15);
            safeClick(organizeMyListBtn(),MEDIUMWAIT);
    }
    
    /*
     * Locator for list name on Organize My List Page.
     */
    private By ListNameOnOrganizeMyList(int num){
            return By.xpath("//ol[@id='userMLA']/li["+num+"]/span[@class='float block name']");
    }
    /*
     * Function to get text of list name on organize my list page.
     */
    public String getListNameOnOrganizeMyList(int num){
    		waitForElementVisible(ListNameOnOrganizeMyList(num), 35);
            return safeGetText(ListNameOnOrganizeMyList(num),SHORTWAIT);
    }
    
    /*
     * Locator for Order text box of first element on Organize My List Page.
     */
    private By OrderTxtboxOnOrganizeMyList(){
            return By.xpath("//ol[@id='userMLA']/li[1]/input");
    }
    /*
     * Function to write on order text box of first element.
     */
    public void changeOrderOfFirstListItem(int num){
    		waitForElementVisible(OrderTxtboxOnOrganizeMyList(), 15);
    		safeType(OrderTxtboxOnOrganizeMyList(), num+"", SHORTWAIT);
    		//sendKeysThroughAction(OrderTxtboxOnOrganizeMyList(), Keys.ENTER);
    		//driver.findElement(OrderTxtboxOnOrganizeMyList()).sendKeys(Keys.ENTER);
    		driver.findElement(By.xpath("//span[@class='float relative block uppercase grey order']")).click();
    }
    
    /*
     * Locator for element on Organize My List Page.
     */
    private By itemOnOrganizeMyList(int num){
            return By.xpath("//ol[@id='userMLA']/li["+num+"]");
    }
    /*
     * Function to drag and drop elements on organize my list page.
     */
    public void changePositionOfListItems(int source, int destination){
    		waitForElementVisible(itemOnOrganizeMyList(source), 15);
    		dragAndDrop(itemOnOrganizeMyList(source), itemOnOrganizeMyList(destination), MEDIUMWAIT);
    }
    
    /*
     * Locator for list name on List tab.
     */
    private By ListName(int num){
            return By.xpath("//ol[@id='userLists']/li["+num+"]/h3/a");
    }
    /*
     * Function to get text of list name on List tab.
     */
    public String getListName(int num){
    		waitForElementVisible(ListName(num), 15);
            return safeGetText(ListName(num),SHORTWAIT);
    }
    
    /*
     * Locator for hide check box of element on Organize My List Page.
     */
    private By HideChkBoxOfListItem(int num){
            return By.xpath("//ol[@id='userMLA']/li["+num+"]/span[@class='floatRight block hide center']/input");
    }
    /*
     * Function to check the check-box for hiding the element on Organize my list Page.
     */
    public void checkHideChkBoxOfListItem(int num){
    		waitForElementVisible(HideChkBoxOfListItem(num), 15);
    		safeClick(HideChkBoxOfListItem(num), SHORTWAIT);
    }
    
    /*
     * Locator for Save changes button on Organize My List Page.
     */
    private By SaveChangesBtn(){
            return By.xpath("//span[@onclick='RNKR.dialog.close();']");
    }
    /*
     * Function to click on save changes button on Organize my list Page.
     */
    public void clickOnSaveChangesBtn(){
    		waitForElementVisible(SaveChangesBtn(),30);
    		safeClick(SaveChangesBtn(), SHORTWAIT);
    		waitForPageToLoad(50);
    }
    
    /*
     * Locator for List item on list tab.
     */
    private By listItem(int num){
            return By.xpath("//ol[@id='userLists']/li["+num+"]");
    }
    
    /*
     * Locator for delete an item on list page.
     */
    private By deleteItem(int num){
            return By.xpath("//ol[@id='userLists']/li["+num+"]/div[@class='float absolute userRowEdit grey hidden']/span[contains(@id,'deleteList')]");
    }
    
    /*
     * Function to delete item from list .
     */
    public void deleteItemFromList(int num){
    		waitForElementVisible(listItem(num), 15);
    		mouseHover(listItem(num), SHORTWAIT);
    		driver.findElement(deleteItem(num)).click();
    		AlertExistsAndAccepted(15);    		
    }
    
    
    /*
     * Locator for edit list an item on list page.
     */
    private By editListItem(int num){
            return By.xpath("//ol[@id='userLists']/li["+num+"]/div[@class='float absolute userRowEdit grey hidden']/a[contains(@id,'editList')]");
    }
    
    /*
     * Function to delete item from list.
     */
    public void editListItemFromList(int num){
    		waitForElementVisible(listItem(num), 15);
    		mouseHover(listItem(num), SHORTWAIT);
    		driver.findElement(editListItem(num)).click(); 		
    }
    
    /*
	 * Locator for Rerank list button and check open UE.
	 */
	private By rerankbtnUE() {
		return By.xpath("//div[@id='UE_container']");
	}

	/*
	 * Function to check the presence of UE appearing 
	 */
	public boolean isPresentUE() {
		return isElementPresent(rerankbtnUE());
	}
	
	 /*
     * Locator for settings tab in user profile.
     */
    private By settingsBtn(){
            return By.xpath("//header[@id='userHead']/div[@id='userBio']/span[@id='editUserSettings']");
    }
    /*
     * Function to click on settings tab in user profile.
     */
    public void clickOnSettingsBtn(){
            safeClick(settingsBtn(), MEDIUMWAIT);
    }
    
    /*
     * Locator for about me on settings page.
     */
    private By aboutMe(){
            return By.id("aboutMe");
    }
    /*
     * Function to type text for about me on settings page.
     */
    public void typeAboutMe(String text){
    	waitForElementVisible(aboutMe(), 15);
    	safeClearAndType(aboutMe(), text, SHORTWAIT);
    }
    
    /*
     * Locator for close button on settings page.
     */
    private By closeSettings(){
    	 return By.id("aboutMe");
          // return By.xpath("//div[@id='closeBlock']/span");
    }
    public void scrollcloseSettingsforsociallinks()
    {
   	 scrollIntoViewThroughJavaScriptExecuter(closeSettingsforsociallinks());
    }
    /*
     * Function to click on close button on settings page.
     */
    public void clickOnCloseSettings(){
    	safeClick(closeSettings(), MEDIUMWAIT);
    }
    /*
     * Locator for close button on settings page.
     */
    private By closeSettingsforsociallinks(){
    	 return By.id("aboutMe");
          // return By.xpath("//div[@id='closeBlock']/span");
    }
    /*
     * Function to click on close button on settings page.
     */
    public void clickOncloseSettingsforsociallinks(){
    	safeClick(closeSettingsforsociallinks(), MEDIUMWAIT);
    } 
    /*
	 * Locator for Rerank list button and check open UE.
	 */
	private By aboutMeSection(String txt) {
		return By.xpath("//div[contains(text(),'"+txt+"')]");
	}

	/*
	 * Function to check the presence of UE appearing 
	 */
	public boolean isAboutMeSectionExist(String txt) {
		return isElementPresent(aboutMeSection(txt));
	}
	/*
	 * Locator for born tab in month
	 */
	private By birthmonth() {
		return By.id("monthdropdown");
	} 
	/*
     * Function to click on born tab in month button .
     */
    public void selectbirthmonth(String monthName){
    	safeSelectOptionInDropDown(birthmonth(), monthName, 30);
    }
    /*
	 * Locator for born tab in day
	 */
	private By birthday() {
		return By.id("daydropdown");
	} 
	/*
     * Function to click on born tab in day button .
     */
    public void selectbirthday(int day){
    	safeSelectOptionInDropDown(birthday(),day+"", 40);
    }
    /*
	 * Locator for born tab in year
	 */
	private By birthyear() {
		return By.id("yeardropdown");
	} 
	/*
     * Function to click on born tab in year button .
     */
    public void selectyear(long year){
    	safeSelectOptionInDropDown(birthyear(),year+"", 40);
    }
    /*
	 * Locator for year after close tab
	 */
	private By year() {
		return By.xpath("//div[@id='userDetails']/span[@class='inlineBlock' and contains(text(),'yrs')]");
	} 
	/*
     * Function to get year after close tab
     */
    public String getyear(){
    	return safeGetText(year(), SHORTWAIT);
    }
    /*
	 * Locator country
	 */
	private By country() {
		return By.id("countryDrop");
	} 
	/*
     * Function to click on country .
     */
    public void selectcountry(String countryname){
    	WebElement selectElement = driver.findElement(country()); 
    	List<WebElement> options = Collections.<WebElement>emptyList();
		setHighlight(selectElement);
		Select select = new Select(selectElement); 
		//Get a list of the options 
		options = select.getOptions(); 
		// For each option in the list, verify if it's the one you want and then click it
		if(!options.isEmpty())
		{
			for (WebElement option: options) 
			{ 
				if (option.getText().equals(countryname))
				{ 
					option.click(); 
					break; 
				}
			}
		}
	
    	//safeSelectOptionInDropDown(country(), countryname, 30);
    } 
    /*
	 * Locator for state.
	 */
	private By state() {
		return By.xpath("//div[@id='profileSettingsCont']/div[@class='formCont'][2]/p[@class='clear float inlineBlock width100 stateCont' and contains(text(),'State: ')]/input");
	} 
	/*
     * Function to type text for about me on settings page.
     */
    public void typestate(String text){
    	//waitForElementVisible(state(), 15);
    	safeClearAndType(state(), text, SHORTWAIT);
    }
    /*
	 * Locator for city.
	 */
	private By city() {
		return By.xpath("//div[@id='profileSettingsCont']/div[@class='formCont'][2]/p[@class='clear cityCont inlineBlock width100']/input[@id='cityInput']");
	} 
	/*
     * Function to type text for about me on settings page.
     */
    public void typecity(String text){
    	safeClearAndType(city(), text, SHORTWAIT);
    }
    /*
    * Locator for zip.
	 */
	private By zip() {
		return By.xpath("//div[@id='profileSettingsCont']/div[@class='formCont'][2]/p[@class='clear cityCont inlineBlock width100']/input[@id='zipInput']");
	} 
	/*
    * Function to type text for about me on settings page.
    */
   public void typezip(long zip){
   	safeClearAndType(zip(), zip+"", SHORTWAIT);
   }
   /*
	 * Locator for addredd after close tab
	 */
	private By address() {
		return By.xpath("//div[@id='userDetails']/span[@class='inlineBlock']");
	} 
	/*
    * Function to get address after close tab
    */
   public String getaddress(){
   	return safeGetText(address(), SHORTWAIT);
   }
     /*
     * Locator for Gender
	 */
	private By gender() {
		return By.xpath("//div[@class='formCont genderCont']/span[@data-gender='MALE']");
	} 
	/*
   * Function to click select gender 
   */
  public void clickongender(){
  	//waitForElementVisible(state(), 15);
  	safeJavaScriptClick(gender(), SHORTWAIT);
  }
  /*
   * Locator for Gender
	 */
	private By selctgender() {
		return By.xpath("//div[@class='formCont genderCont']/span[@class='inlineBock btnGrey gender floatRight center active' and contains(text(),'Male')]");
	} 
	/*
	 * Function to check the selction gender 
	 */
	public boolean isselctiongender() {
		scrollIntoViewThroughJavaScriptExecuter(selctgender());
		return isElementPresent(selctgender());
	}
	/*
	    * Locator for website
		 */
		private By website() {
			return By.id("websiteInput");
		} 
		/*
	    * Function to type text for about me on settings page.
	    */
	   public void typewebsite(String website){
	   	safeClearAndType(website(), website, SHORTWAIT);
	   }
	   /*
	    * Locator for facevbook
		 */
		private By facebook() {
			return By.id("facebookInput");
		} 
		/*
	    * Function to type text for about me on settings page.
	    */
	   public void typefacebook(String facebook){
	   	safeClearAndType(facebook(), facebook, SHORTWAIT);
	   }
	   /*
	    * Locator for twitter
		 */
		private By twitter() {
			return By.id("twitterInput");
		} 
		/*
	    * Function to type text for about me on settings page.
	    */
	   public void typetwitter(String twitter){
	   	safeClearAndType(twitter(), twitter, SHORTWAIT);
	   }
	   /*
	    * Locator for google
		 */
		private By google() {
			return By.id("googleInput");
		} 
		/*
	    * Function to type text for about me on settings page.
	    */
	   public void typegoogle(String google){
	   	safeClearAndType(google(), google, SHORTWAIT);
	   }
	    /*
		 * Locator for social window click open new window
		 */
		private By Socialwindow(String txt) {
			return By.xpath("//div[@id='userDetails']//a[contains(text(),'"+txt+"')]");
		} 
		/*
		 * This function is used to get href for social window
		 */
		public String gethrefofsocialwindow(String txt){
			return driver.findElement(Socialwindow(txt)).getAttribute("href");
		}
		/*
		   * Function to click social window
		   */
		  public void clickonSocialwindow(String txt){
		  	safeJavaScriptClick(Socialwindow(txt), SHORTWAIT);
		  }
		  /*
		     * Locator for cross on profile setting
			 */
			private By cross() {
				return By.xpath("//div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']/button/span[@class='ui-button-text']");
			} 
			/*
		   * Function to click select gender 
		   */
		  public void clickoncrossonprofilesetting(){
		  	safeJavaScriptClick(cross(), SHORTWAIT);
		  }
	/*
	* Locator for text box to send a note back.
	*/
	private By noteTextBox(){
	return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']/textarea");
	}
	/*
	* Function to type text in text box to send a note back.
	*/
	public void typeTextInNoteTextBox(String text){
	safeType(noteTextBox(), text, MEDIUMWAIT);
	}
	/*
	* Locator for send note button(in note text box).
	*/
	private By sendNoteBtn(){
		return By.id("msgUserSend");
	}
	/*
	* Function to click on send note button(in note text box).
	*/
	public void clickOnSendNoteBtn(){
		safeClick(sendNoteBtn(),MEDIUMWAIT);
	}
	/*
	* Locator for 'sent' and 'received' tabs in notes section.
	*/
	private By sentNote(int num){
	return By.xpath("//article[@id='user']/div[@id='contentTabs']/ul/li["+num+"]/a");
	}
	/*
	* Function to click on 'sent' and 'received' tabs in notes section.
	*/
	public void clickOnSentNote(int num){
	safeClick(sentNote(num), SHORTWAIT);
	}
	
	/*
	 * Locator for account settings in settings tab.
	 */
		private By accountSettings() {
	return By.id("accountSettingsBtn");
	}
	/*
	* Function to click on account settings in settings tab.
	*/
	public void clickOnaccountSettings(){
	safeClick(accountSettings(), MEDIUMWAIT); 
	}
	/*
	 * Locator for email-id in account settings.
	 */
	private By email(){
		return By.xpath("//div[@id='accountSettingsCont']/div[@class='formCont'][2]/p[@class='formInput']/input");
	}
	
	/*
	 * Function to click on email text box(in account setting).
	 */
	public void clickOnEmailBox(){
		safeClick(email(), SHORTWAIT);
	}
	/*
	 * Function to type new mail-id in email-id text box(in account setting).
	 */
	public void typeIdInEmail(String text){
		safeClearAndType(email(), text, MEDIUMWAIT);
	}
	/*
	 * Function to get text from email text box(in account setting).
	 */
	public String getTextOfEmailBox(){
		return driver.findElement(email()).getAttribute("value");
	}
	/*
	 * Locator for lists you follow under function tab.
	 */
	private By listsYouFollow3tab(int num) {
		return By.xpath("//div[@id='contentTabs']/ul/li["+num+"]");
	}
	/*
	 * Function to check the presence of lists you follow  
	 */
	public boolean isPresentfollw3tab(int num) {
		return isElementPresent(listsYouFollow3tab(num),SHORTWAIT);
	}
	/// non-logged user
	/*
	 * Locator for profile_name
	 */
	private By profile_name() {
		return By.xpath("//div[@id='userBio']/h1");
	}
	/*
	 * Function to check the presence of profile nameas a non logged user 
	 */
	public boolean isPresentprofile_name() {
		return isElementPresent(profile_name(),SHORTWAIT);
	}
	/*
	 * Locator for profile_image
	 */
	private By profile_image() {
		return By.xpath("//div[@id='userImg']/img");
	}
	/*
	 * Function to check the presence of  profile_image a non logged user 
	 */
	public boolean isPresentprofile_image() {
		return isElementPresent(profile_image(),SHORTWAIT);
	}
	/*
	 * Locator for profile_description
	 */
	private By profileDescription() {
		return By.xpath("//div[@class='relative grey desc init']");
	}
	/*
	 * Function to check the presence of  profile_image a non logged user 
	 */
	public boolean isPresentprofileDescription() {
		return isElementPresent(profileDescription(),SHORTWAIT);
	}
	/*
	 * This function to get text of node badges.
	 */
	public String getprofileDescription(){
		return safeGetText(profileDescription(), SHORTWAIT);
	}
	/*
	 * Locator Profile_statistics
	 */
	private By Profile_statistics(String txt) {
		return By.xpath("//div[@id='userData']//em[contains(text(),'"+txt+"')]");
	} 
	/*
	 * Function to check the presence of  Profile_statistics
	 */
	public boolean isPresentProfile_statistics(String txt) {
		return isElementPresent(Profile_statistics(txt),SHORTWAIT);
	}
	/*
	 * Locator sorting_dropdown
	 */
	private By sortingDropdown() {
		return By.xpath("//div[@id='contentTabs']/div[@id='userSort']/select");
	}
	/*
	 * Function to check the presence of  Profile_statistics
	 */
	public boolean isPresentsortingDropdown() {
		return isElementPresent(sortingDropdown(),SHORTWAIT);
	}
	/*
	 * Function to click on sorting
	 */
	public void clickonsortingDropdown()
	{
		safeClick(sortingDropdown(), SHORTWAIT);
	}
	/*
	 * Locator sorting_dropdown
	 */
	private By sortingMostViewed(int num) {
		return By.xpath("//div[@id='userSort']/select/option["+num+"]");
	}
	public void clickonsortingMostViewed(int num)
	{
		safeClick(sortingMostViewed(num), SHORTWAIT);
	}
	/*
	 * Locator before sorting viewed no.
	 */
	private By sortingViewed() {
		return By.xpath("//div[@class='rankrank']/ol/li[1]/h3/a");
	}
	/*
	 * This function to get no. of views before sorting.
	 */
	public String getviewbesortingViewed(){
		return safeGetText(sortingViewed(), SHORTWAIT);
	}
	/*
	 * Locator for follow
	 */
	private By follow() {
		return By.xpath("//div[@id='userBio']/span[@class='float block absolute rnkrBlue btnGrey proFollowUser follow']");
	}
	/*
	 * function for used to click  on follow 
	 */
	public void clickonfollow()
	{
		safeClick(follow(), SHORTWAIT);
	}
	/*
	 * Locator loginpopup
	 */
	private By loginpopup() {
		return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']");
	}
	/*
	 * Function to check the presence of  login popup after click on follow
	 */
	public boolean isPresentloginpopup() {
		return isElementPresent(loginpopup(),SHORTWAIT);
	}
	/*
	* Locator for Send a note link on profile page.
	*/
	private By sendNoteLink(){
	return By.xpath("//div[@id='userTabs']/span[contains(@id,'msgu')]");
	}
	/*
	* Function to click on 'sent' and 'received' tabs in notes section.
	*/
	public void clickOnSendaNoteLink(){
	safeClick(sendNoteLink(), SHORTWAIT);
	}
	public String getalertmsg()
	{
		Alert alert =driver.switchTo().alert();
		String msg=alert.getText();
		return msg;
	}
	/*
	 * Locator for rerank list
	 */
	private By reranklist(int num) {
		return By.xpath("//div[@class='rankrank']/ol/li["+num+"]/h3/a");
	}
	/*
	 * Function to check my rerank  25 list is presence 
	 */
	public boolean isPresent25list(int num) {
		return isElementPresent(reranklist(num),SHORTWAIT);
	}
	/*
	* Function to click on 'rerank list and open corresponding page
	*/
	public void clickOnreranklist(int num){
	safeClick(reranklist(num), SHORTWAIT);
	}
	/*
	 * Locator for my rerank search.
	 */
	private By rerank_list_search(int num,String txt) {
		if(txt.contains("my rerank of "))
		return By.xpath("//div[@class='rankrank']/ol/li["+num+"]/h3/span[contains(text(),'"+txt+"')]");
		else//original ranker of 
			return By.xpath("//div[@class='rankrank']/ol/li["+num+"]/h3/span[contains(text(),'"+txt+"')]");	
	}
	/*
	 * Function to check my rerank list in check presence
	 */
	public boolean isPresent_rank_list_search(int num,String txt) {
		return isElementPresent(rerank_list_search(num,txt),VERYSHORTWAIT);
	}
	 /*
	   * Locator for edit rerank search.
	 */
	private By editreranklistsearch(int num) {
		
		return By.xpath("//div[@class='rankrank']/ol/li["+num+"]/h3/span[contains(text(),'The Best Spectator Sports')]");
		
	}
	/*
	 * Function to check my edit rerank list in check presence 
	 */
	public boolean isPresenteditranklistsearch(int num) {
		return isElementPresent(editreranklistsearch(num),SHORTWAIT);
	}
	/*
	* This function to get text of rerank list
	*/
	public String gethrefofreranklist(int num){
		return driver.findElement(reranklist(num)).getAttribute("href");
		
	}
	public void hoveron_reranklist(int num)
	{
		scrollIntoViewThroughJavaScriptExecuter(reranklist(num));
		mouseHoverJScript(reranklist(num)," a", MEDIUMWAIT);
	}
	/*
	 * Locator for my rerank list in check presence icon 
	 */
	private By rerank_list_icon() {
		return By.xpath("//div[contains(@id,'rrSlide_')]/div[@class='float relative box rnkrLMBlueBg']/h5/i");
	}
	/*
	 * Function to check my rerank list in check presence icon 
	 */
	public boolean isPresent_rerank_list_icon() {
		return isElementPresent(rerank_list_icon(),SHORTWAIT);
	}
	/*
	 * Locator for my rerank list in check presence icon 
	 */
	private By rerank_list_3items(int num) {
		return By.xpath("//div[contains(@id,'rrSlide_')]/div[@class='float relative box rnkrLMBlueBg']/ol/li["+num+"]");
	}
	/*
	 * Function to check my rerank list in check presence icon 
	 */
	public boolean isPresent_rerank_list_3items(int num) {
		return isElementPresent(rerank_list_3items(num),SHORTWAIT);
	}
	/*
	 * Locator for my rerank list in check presence rerank button 
	 */
	private By reranklistbtn() {
		return By.xpath("//div[@class='btns']/a");
	}
	/*
	 * Function to check my rerank list in check presence rerank button 
	 */
	public boolean isPresentreranklistbtn() {
		return isElementPresent(reranklistbtn(),SHORTWAIT);
	}
	/*
	 * Locator for my rerank list in check presence rerank number 
	 */
	private By reranklistnumber() {
		return By.xpath("//div[@class='float relative box rnkrLMBlueBg']/a");
	}
	/*
	 * Function to check my rerank list in check presence rerank number 
	 */
	public boolean isPresentreranklistnumber() {
		return isElementPresent(reranklistnumber(),SHORTWAIT);
	}
	/*
	 * Locator for my rerank list in check presence rerank  list name 
	 */
	private By reranklistname() {
		return By.xpath("//div[@id='listDesc']/h1/span");
	}
	/*
	 * Function to check my rerank list in check presence list name
	 */
	public boolean isPresentreranklistname() {
		return isElementPresent(reranklistname(),SHORTWAIT);
	}
	/*
	* Locator for my rerank list in check presence rerank list Description 
	*/
	private By reranklistdescription() {
		return By.id("csstc__userDesc");
	}
	/*
	* Function to check my rerank list in check presence list name
	*/
	public boolean isPresentreranklistdescription() {
		return isElementPresent(reranklistdescription(),SHORTWAIT);
	}
	/*
	* Locator for My setting page.
	*/
	private By mySettings(){
	return By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front userSettings ui-draggable']");
	}
	/*
	* Function to click on 'sent' and 'received' tabs in notes section.
	*/
	public boolean isMySettingWindowPresent(){
	return isElementPresent(mySettings(), SHORTWAIT);
	}
	
	/*
	* Locator for My setting page.
	*/
	private By tab(int num){
	return By.xpath("//div[@id='userTabs']/ul/li["+num+"]");
	}
	/*
	* Function to click on 'sent' and 'received' tabs in notes section.
	*/
	public String getClassOfTabs(int num){
	return driver.findElement(tab(num)).getAttribute("class");
	}
	/*
	 * Locator for badge list
	 */
	private By badgelist() {
		return By.id("badgeList");
	}
	/*
	 * Function to check badge List
	 */
	public boolean isPresentbadgelist() {
		return isElementPresent(badgelist(),SHORTWAIT);
	}
	/*
	* Locator for pagination click 2 page
	*/
	private By pagination(){
	return By.xpath("//div[@id='paging']/nav[@class='floatRight absolute grey rnkrLYellowBg uppercase']/a");
	}
	/*
	* Function to click on 'pagination
	*/
	public void clickOnpagination(){
	safeClick(pagination(), SHORTWAIT);
	}
	/*
	 * This function is used to get href for pagination
	 */
	public String gethrefofpagination(){
		return driver.findElement(pagination()).getAttribute("href");
	}
	/*
	* Locator for follows list
	*/
	private By followslist(int num){
	return By.xpath("//div[@id='followFG']/ol/li["+num+"]/div[@class='title']/a");
	}
	/*
	* Function to click on 'followslist
	*/
	public void clickOnfollowslist(int num){
	safeClick(followslist(num), SHORTWAIT);
	}
	/*
	 * This function is used to get href for followslist
	 */
	public String gethrefoffollowslist(int num){
		return driver.findElement(followslist(num)).getAttribute("href");
	}
	/*
	 * Locator for  followinglist
	 */
	private By followinglist(int num) {
		return By.xpath("//div[@id='siteBody']/article[@id='user']/div[@id='contentTabs']/ul/li["+num+"]/p/a");
	}
	/*
	* Function to click on 'followinglist
	*/
	public void clickOnfollowinglist(int num){
	safeJavaScriptClick(followinglist(num), MEDIUMWAIT);
	}
	/*
	 * This function is used to get href for followinglist
	 */
	public String gethrefoffollowinglist(int num){
		return driver.findElement(followinglist(num)).getAttribute("href");
	}
	
	/////*
	//// * Locator for Logout.
	//// */
	////private By logout(){
	////	return By.xpath("//div[@id='userAreaMenu']/span[@class='float absolute block btn logout']/a");
	////}
	/////*
	//// * Function to click on logout.
	//// */
	////public void clickOnLogout(){
	////	safeClick(logout(), MEDIUMWAIT);
	////}
	/*
	 * Locator for  change old password in account settings on settings page.
	 */
	private By changePasswordold() {
	    return By.id("oldPassword");
	}
	/*
	 * Function to click on change old password in account settings on settings page.
	 */
	public void clickOnchangePasswordold(){
	    safeClick(changePasswordold(), MEDIUMWAIT); 
	}
	/*
	 * Function to type text for change old password  in account settings on settings page.
	 */
	public void typechangePasswordold(String text){
	    safeClearAndType(changePasswordold(), text, SHORTWAIT);
	}
	/*
	 * Locator for  change new password in account settings on settings page.
	 */
	private By changePasswordnew() {
	    return By.id("newPassword");
	}
	/*
	 * Function to click on change new password in account settings on settings page.
	 */
	public void clickOnchangePasswordnew(){
	    safeJavaScriptClick(changePasswordnew(), MEDIUMWAIT); 
	}
	/*
	 * Function to type text for change new password  in account settings on settings page.
	 */
	public void typechangePasswordnew(String text){
	    safeClearAndType(changePasswordnew(), text, SHORTWAIT);
	}
	/*
	 * Locator for close btn in account settings on settings page.
	 */
	private By closebtn(){
	    return By.xpath("//div[@id='closeBlock']/span[@class='inlineBlock btnGrey closeSettings center']");
	}
	/*
	 * Function to click on close btn in account settings on settings page.
	 */
	public void clickOnclosebtn(){
	    safeJavaScriptClick(closebtn(), MEDIUMWAIT); 
	    try{
	    	  Thread.sleep(4000);
	      }catch(Exception e){}
	}
	/*
	 * Function to scroll the close button in account settings on settings popup 
	 */
	public void scrollClosebtn(){
		scrollIntoElementView(closebtn());
	}
	/*
	 * Locator for text under password textbox on home page.
	 */
	private By messageUnderPwdBox(int num){
		return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']/div[@class='float relative form grey width33']/p["+num+"]/span[@id='loginPassMess']");
	}
	/*
	 * Function to get the text of message generated after entering wrong password(on home page).
	 */
	public String getTextOfMessageUnderPwdBox(int num){
		return safeGetText(messageUnderPwdBox(num), SHORTWAIT);
	}
	/*
	 * Locator for close of signin block on home page.
	 */
	private By closeSignIn(){
		return By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front auth nav loginView']/div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']/button/span");
	}
	/*
	 * Function to click on close of signin block on home page.
	 */
	public void clickOnCloseSignIn(){
		scrollIntoElementView(closeSignIn());
		safeJavaScriptClick(closeSignIn(), SHORTWAIT);
	}
	/*
	 * Locator for signin on home page.
	 */
	public void signin(String userName, String pwd){
			SigninPage signInPage = new SigninPage(driver);
			signInPage.clickSignin();
			signInPage.enterCredentels(userName,pwd);
		}
	/*
	 * Locator for login submit.
	 */
	private By btnSignin(){
		return By.id("loginButton");
	}
	/*
	 * Function to click on submit for signing in.
	 */
	public void clickSubmit(){
		safeClick(btnSignin());
	}
	/*
	 * Locator for 'comment digest' radio button in account settings
	 */
	private By commentDigest(int num){
		return By.xpath("//div[@id='accountSettingsCont']/div[@class='formCont'][4]/p["+num+"]/input");
	}
	/*
	 * Function to check the radio button is selected.
	 */
	public boolean isRadBtnCommentDigestSelected(int num){
		return isElementSelected(commentDigest(num));
		
	}
	/*
	 * Locator for 'activity digest' radio button in account settings
	 */
	private By activityDigest(int num){
		return By.xpath("//div[@id='accountSettingsCont']/div[@class='formCont'][5]/p["+num+"]/input");
	}
	/*
	 * Function to check the radio button is selected.
	 */
	public boolean isRadBtnActivityDigestSelected(int num){
		return isElementSelected(activityDigest(num));
	}
	/*
	 * Locator for signin(creating a new account).
	 */
	private By newAccSignIn(){
		return By.id("navLogin");
	}
	/*
	 * Function to click on signin.
	 */
	public void clickOnNewAccSignIn(){
		safeClick(newAccSignIn(), SHORTWAIT);
	}
	/*
	 * Locator for 'joining is easy' to create a new account.
	 */
	private By joining(){
		return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']/header[@id='welcome']/p/a");
	}
	/*
	 * Function to click on 'joining is easy' to create a new account.
	 */
	public void clickOnJoining(){
		safeClick(joining(), SHORTWAIT);
	}
	/*
	 * Locator for mail icon to create new account.
	 */
	private By mailIcon(){
		return By.xpath("//span[@id='authMailBtn']/img");
	}
	/*
	 * Function to click on mail icon.
	 */
	public void clickOnMailIcon(){
		safeJavaScriptClick(mailIcon(), SHORTWAIT);
	}
	/*
	 * Locator for email id, password, and username text boxes(new account).
	 */
	private By newAccount(String txt){
		String locator="a";
		if(txt.equalsIgnoreCase("username"))
			locator="//div[@id='formContainer']/p[1]/input";
		else //email
			if(txt.equalsIgnoreCase("email"))
				locator="//div[@id='formContainer']/p[2]/input";
			else //password
				if(txt.equalsIgnoreCase("password")) 
					locator="//div[@id='formContainer']/p[3]/input";
				else //terms and conditions accept check box
					if(txt.equalsIgnoreCase("termsAccept")) 
						locator="//div[@id='formContainer']/p[4]/input";
					else //sign up
						locator="//div[@id='formContainer']/p[5]/a";
		return(By.xpath(locator));
	}
	/*
	 * Function to type in email id, password, and username text boxes(new account).
	 */
	public void typeInNewAccount(String txt1,String txt2){
		safeType(newAccount(txt1), txt2, MEDIUMWAIT);
	}
	/*
	 * Function to click on check box to accept terms and conditions.
	 */
	public void checkAcceptTerms(String txt){
		safeCheck(newAccount(txt), MEDIUMWAIT);
	}
	/*
	 * Function to click on sign up.
	 */
	public void clickOnSignUp(String txt){
		safeClick(newAccount(txt), SHORTWAIT);
	}
	/*
	 * Locator for delete the account.
	 */
	private By deleteAccount(){
		return By.xpath("//div[@id='accountSettingsCont']/div[@class='formCont']/span[@id='deleteAccount']");
	}
	/*
	 * Function to click on delete the account.
	 */
	public void clickOnDeleteAccount(){
		safeClick(deleteAccount(), SHORTWAIT);
	}
	/*
	 * Locator for manage my list.
	 */
	private By ManageLists(){
		return By.id("userManageLists");
	}
	/*
	 * Function to click on delete the account.
	 */
	public void clickOnManageLists(){
		safeClick(ManageLists(), SHORTWAIT);
	}
}