package com.pageobjects.rerank;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.selenium.SafeActions;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class RerankPage extends SafeActions {
	private WebDriver driver;

	public RerankPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/*
	 * Locator for Rerank list button.
	 */
	private By rerankbtn() {
		return By.xpath("//span[@id='reRankBtn']");
	}

	/*
	 * Function to make click Rerank list button.
	 */
	public void clickOnrerankbtn() {
		safeJavaScriptClick(rerankbtn(), MEDIUMWAIT);
	}

	/*
	 * Locator for Rerank list button and check open UE.
	 */
	private By rerankbtnUE() {
		return By.xpath("//div[@id='UE_container']");
	}

	/*
	 * Function to check the presence of UE appearing after click on 'Rerank
	 * list button'.
	 */
	public boolean isPresentUE() {
		return isElementPresent(rerankbtnUE(),MEDIUMWAIT);
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
	 * Locator for Recomeneded in UE
	 */
	private By recomeneded() {
		return By.xpath("//div[@id='UE_settings_display']/em");
	}

	/*
	 * Function to check the presence of recomeneded in option btn in UE.
	 */
	public boolean isPresentrecomeneded() {
		return isElementPresent(recomeneded(),MEDIUMWAIT);
	}//

	/*
	 * Locator for Recomeneded in UE check border color list
	 */
	private By listboder() {
		return By.xpath("//span[@id='UE_settings_display_grid']/span[1]");
	} //

	/*
	 * Function to get Header color of TextHeader.
	 */
	public String getborderColorlist() {
		return driver.findElement(listboder()).getCssValue(
				"border-bottom-color");
	}

	/*
	 * Locator for delete all button.
	 */
	private By deletekbtn() {
		return By.xpath("//div[@id='UE_nav_deleteAll']/i[@class='absolute midGrey trash']");
	}

	/*
	 * Function to make click delete all btn in UE.
	 */
	public void clickOndeletebtn() {
		safeJavaScriptClick(deletekbtn(), MEDIUMWAIT);
	}

	/*
	 * Locator for alert show in opps.no. button.
	 */
	private By alertoppsbtn() {
		return By.xpath("//div[@id='UE_sticky_deleteAll']/div[@class='block html black']/p[@class='center']/span[@class='inlineBlock btnGrey']");
	}

	/*
	 * Function to make click alert in opps.no btn.
	 */
	public void clickOnalertoppsbtn() {
		safeJavaScriptClick(alertoppsbtn(), MEDIUMWAIT);
	}

	/*
	 * Locator for alert show in opps.no. button.
	 */
	private By alertdeleteallbtn() {
		return By.xpath("//div[@id='UE_container']/div[@id='UE_content']/div[@id='UE_sticky_deleteAll']/div[@class='block html black']/p[@class='center']/span[@class='inlineBlock btnBlue']");
	}

	/*
	 * Function to make click delete all btn in Alert.
	 */
	public void clickOnalertdeleteallbtn() {
		safeJavaScriptClick(alertdeleteallbtn(), MEDIUMWAIT);
	}

	/*
	 * Locator for the close sticky like popup.
	 */
	private By stickyLike() {
		return By.xpath("//span[@class='inlineBlock btnDBlue']");
	}

	/*
	 * Function to check presence of sticky like page.
	 */
	public boolean isstickyLikePresent() {
		return isElementPresent(stickyLike(), VERYSHORTWAIT);
	}

	public void stickyLikePresenceAndAccept() {
		if (isstickyLikePresent()) {
			clickstickyLike();
		}
	}

	/*
	 * This function is used to close sticky like popup.
	 */
	public void clickstickyLike() {
		safeClick(stickyLike(), SHORTWAIT);
	}

	/*
	 * Locator for list items.
	 */
	private By listitems(int num) {
		return By.xpath("//div[@id='UE_content']/ol/li[" + num+ "]/div[@class='relative width100 height100 rowWrapper']");
	}

	/*
	 * Function to check the presence of list.
	 */
	public boolean isPresentlistitems(int num) {
		return isElementPresent(listitems(num),SHORTWAIT);
	}

	/*
	 * Locator for publish button.
	 */
	private By publishbtn() {
		return By.xpath("//div[@id='UE_nav']/span[@id='UE_nav_done']");
	}

	/*
	 * Function to make click on publish button..
	 */
	public void clickOnpublishbtn() {
		waitForPageToLoad();
		safeJavaScriptClick(publishbtn(), MEDIUMWAIT);
	}

	/*
	 * Locator for Publish button.
	 */
	private By fsharebtn() {
		return By.id("share_facebook-share_payoffShareBtn");
	}

	/*
	 * Function to make click on fshare button..
	 */
	public void clickOnfsharebtn() {
		safeJavaScriptClick(fsharebtn(), MEDIUMWAIT);
	}

	/*
	 * Locator for fshare in login user.
	 */
	private By loginUser() {
		return By.xpath("//div[@class='form_row clearfix']//input[@type='text']");
	}

	/*
	 * Locator for fshare in passward.
	 */
	private By password() {
		return By.xpath("//div[@class='form_row clearfix']//input[@type='password']");
	}

	/*
	 * Locator for fshare in login button.
	 */
	private By loginbtn() {
		return By.name("login");
	}

	/*
	 * Function to make login facebook..
	 */
	public void facebooklogin(String name, String paswd) {
		switchToNewWindow();
		safeType(loginUser(), name);
		safeType(password(), paswd);
	}

	/*
	 * Function to click on login button..
	 */
	public void clickonloginbtn() {
		safeClick(loginbtn(), SHORTWAIT);
	}

	/*
	 * Locator for list items.
	 */
	private By listitemsnode1() {
		return By
				.xpath("//div[@id='UE_content']/ol/li[1]/div[@class='relative width100 height100 rowWrapper']/div[@class='relative block name height100 move']/p//span[@class='txt']");
	}

	/*
	 * Function to get text of listitemsnode1
	 */
	public String getTextOflistitemsnode1() {
		return safeGetText(listitemsnode1(), MEDIUMWAIT);
	}

	/*
	 * Locator for list items 2.
	 */
	private By listitemsnode2() {
		return By
				.xpath("//div[@id='UE_content']/ol/li[2]/div[@class='relative width100 height100 rowWrapper']/div[@class='relative block name height100 move']/p//span[@class='txt']");
	}

	/*
	 * Function to get text of listitemsnode2
	 */
	public String getTextOflistitemsnode2() {
		return safeGetText(listitemsnode2(), MEDIUMWAIT);
	}

	/*
	 * Locator for list items 3.
	 */
	private By listitemsnode3() {
		return By
				.xpath("//div[@id='UE_content']/ol/li[3]/div[@class='relative width100 height100 rowWrapper']/div[@class='relative block name height100 move']/p//span[@class='txt']");
	}

	/*
	 * Function to get text of listitemsnode 3
	 */
	public String getTextOflistitemsnode3() {
		return safeGetText(listitemsnode3(), MEDIUMWAIT);
	}

	/*
	 * Locator for share button.
	 */
	private By sharebtn() {
		return By.name("publish");
	}

	/*
	 * Function to click on share button..
	 */
	public void clickonsharebtn() {
		safeJavaScriptClick(sharebtn(), SHORTWAIT);
	}

	/*
	 * Locator for vote button.
	 */
	private By votebtn(int num) {
		
		return By.xpath("//section[@id='mainListCnt']/ol/li["+ num+ "]/div[@class='float vote']/div[@class='float relative']//i");
		//return By.xpath("//section[@id='mainListCnt']/ol/li["+ num+ "]/div[@class='float vote cunlock_hide_also ']/div[@class='float relative']//i");
	}

	/*
	 * Function to click on vote button..
	 */
	public void clickonvotebtn(int num) {
		safeJavaScriptClick(votebtn(num), SHORTWAIT);
	}
	

	/*
	 * Locator for rerankaftervote button.
	 */

	private By rerankaftervote() {
		return By
				.xpath("//div[@id='voteCounter2']/div[@id='voteCounter2Data']/span[@class='float absolute block btnGrey top']//span");
		// return By.name("login");
	}

	/*
	 * Function to click on login button..
	 */
	public void clickonrerankaftervote() {
		safeJavaScriptClick(rerankaftervote(), SHORTWAIT);
	}

	/*
	 * Locator for search box.
	 */
	private By searchbtn() {
		return By.id("UE_search_input");
	}

	/*
	 * Function to click on vote button..
	 */
	public void typesearchbtn(String num) {
		safeType(searchbtn(), num, SHORTWAIT);
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
	private By searchaddbtn() {
		return By.xpath("//div[@id='UE_search_container']/div[@id='UE_search_create']/span[@class='float relative block action center']/span[@id='UE_search_create_add']");
	}

	/*
	 * Function to click on share button..
	 */
	public void clickonsearchaddbtn() {
		scrollIntoViewThroughJavaScriptExecuter(searchaddbtn());
		safeClick(searchaddbtn(), SHORTWAIT);
	}

	/*
	 * Locator For '+' icon in UE.
	 */
	private By plusIcon(int linum) {
		return By.xpath("//div[@id='UE_suggestions_content']/ul/li[" + linum+ "]/span[@class='float relative block action center']/span");
	}

	/*
	 * Function to make click on '+' icon in UE.
	 */
	public void clickOnPlusIcon(int linum) {
		safeClick(plusIcon(linum), MEDIUMWAIT);
	}

	/*
	 * Locator for added node in UE List.
	 */
	private By addedNode() {
		return By.xpath("//div[@id='UE_content']/ol/li[last()]/div[@class='relative width100 height100 rowWrapper']/div/p/span");
	}

	/*
	 * Function to get text of added node in UE List.
	 */
	public String getTextOfAddedNode() {
		return safeGetText(addedNode(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for added node in UE List.
	 */
	private By firstNode() {
		return By.xpath("//div[@id='UE_content']/ol/li[1]/div[@class='relative width100 height100 rowWrapper']/div/p/span");
	}

	/*
	 * Function to get text of added node in UE List.
	 */
	public String getTextOfFirstNode() {
		return safeGetText(firstNode(), MEDIUMWAIT);
	}

	/*
	 * Locator For 'delete in UE.
	 */
	private By deleteIcon(int linum) {
		return By.xpath("//div[@id='UE_content']/ol/li[" + linum+ "]//span[3]/i");
	}

	/*
	 * Function to make click on '+' icon in UE.
	 */
	public void clickOndeleteIcon(int linum) {
		safeClick(deleteIcon(linum), MEDIUMWAIT);
	}

	/*
	 * Locator For 'edit in UE.
	 */
	private By editIcon(int linum) {
		return By.xpath("//div[@id='UE_content']/ol/li[" + linum+ "]//span[2]/i");
	}

	/*
	 * Function to hover on edit icon.
	 */
	public void hoverOneditIcon(int num) {
		mouseHover(editIcon(num), MEDIUMWAIT);
	}

	/*
	 * Locator For 'edit image option.
	 */
	private By editsubimageIcon() {
		return By.xpath("//i[contains(@id,'editHover_image')]");
	}

	/*
	 * Function to click on image icon.
	 */
	public void clickoneditimageoption() {
		safeJavaScriptClick(editsubimageIcon(), MEDIUMWAIT);
	}

	/*
	 * Locator For ' image add option in edit.
	 */
	private By edititemsadd(int linum) {
		return By.xpath("//ul[@class='UE_flickrThumbs']/li["+linum+"]/img");
		//ul[@class='UE_flickrThumbs']/li["+num+"]/img
		//return By.xpath("//div[contains(@class,'UE_node_content')]/ul[@class='UE_flickrThumbs']/li[@id='UE_ranker_addImg_0']["+ linum + "]/img");
		//return By.xpath("//div[@id='UE_node_content']/ul[@id='UE_youtubeThumbs']/li[contains(@id='UE_youtube_560557_addVid_0]["+ linum + "]/img");
	}
	/*
	 * Locator For ' vedio add option in edit.
	 */
	private By edititemsaddvedio(int linum) {
		//return By.xpath("//div[@id='UE_node_content']/ul[@id='UE_flickrThumbs']/li[@id='UE_ranker_addImg_0']["+ linum + "]/img");
		return By.xpath("//div[contains(@class,'UE_node_content')]/ul[@class='UE_youtubeThumbs']/li["+linum+"]/img");
		//return By.xpath("//div[@id='UE_node_content']/ul[@id='UE_youtubeThumbs']/li[contains(@id='UE_youtube_560557_addVid_0]["+ linum + "]/img");
	}
	/*
	 * Function to addimage.
	 */
	public void clickonedititemsaddoption(int num) {
		safeJavaScriptClick(edititemsadd(num), MEDIUMWAIT);
	}
	/*
	 * Function to vedio add.
	 */
	public void clickonedititemsaddvedio(int num) {
		safeJavaScriptClick(edititemsaddvedio(num), MEDIUMWAIT);
	}
	/*
	 * Function is used to get attribute of image
	 */
	public String getsrcedititemsadd(int num) {
		return driver.findElement(edititemsadd(num)).getAttribute("src");
	}/*
	 * Function is used to get attribute of vedio
	 */
	public String getsrcedititemsaddvedio(int num) {
		return driver.findElement(edititemsaddvedio(num)).getAttribute("src");
	}

	/*
	 * Locator For ' select button.
	 */
	private By selectbtn() {
		return By.xpath("//div[@class='center btns']/span[1]");
	}

	/*
	 * Function to click select button.
	 */
	public void clickonselectbtn() {
		safeJavaScriptClick(selectbtn(), MEDIUMWAIT);
	}

	/*
	 * Locator For done button.
	 */
	private By donetbtn() {
		return By.id("UE_node_done");
	}

	/*
	 * Function to click select button.
	 */
	public void clickondonebtn() {
		safeJavaScriptClick(donetbtn(), MEDIUMWAIT);
	}

	/*
	 * Locator For 'add image in list.
	 */
	private By addedititemsinlist(int linum) {
		//return By.xpath("//section[@id='mainListCnt']/ol/li[last()]/div[@class='float relative img']/img");
		return By.xpath("//div[@id='UE_content']/ol/li[" + linum + "]//img");
	}

	/*
	 * Function is used to get attribute of image
	 */
	public String getsrcafteraddedititems(int num) {
		return driver.findElement(addedititemsinlist(num)).getAttribute("src");
	}

	/*
	 * Locator For 'edit sub option in UE.
	 */
	private By editsubviedoIcon() {
		return By.xpath("//i[contains(@id,'editHover_video')]");
	}

	/*
	 * Function to click on image icon.
	 */
	public void clickoneditsubviedoIcon() {
		safeJavaScriptClick(editsubviedoIcon(), MEDIUMWAIT);
	}

	/*
	 * Locator For 'edit sub option in UE.
	 */
	private By editsubblatherIcon() {
		return By.xpath("//i[contains(@id,'editHover_comment')]");
	}

	/*
	 * Function to click on blather icon.
	 */
	public void clickoneditsubblatherIcon() {
		safeJavaScriptClick(editsubblatherIcon(), MEDIUMWAIT);
		// safeType(editsubblatherIcon(),num, SHORTWAIT);
	}

	/*
	 * Locator For 'edit sub option in UE.
	 */
	private By enterblather() {
		return By.xpath("//div[contains(@class,'UE_node_content')]//div[@role='textbox']");
	}

	/*
	 * Function to click on image icon.
	 */
	public void typeblather(String num) {
		safeType(enterblather(), num, SHORTWAIT);
	}

	/*
	 * Locator For 'blather add in list.
	 */
	private By addedblatherinlist(int linum) {
		return By.xpath("//div[@id='UE_content']/ol/li[" + linum + "]//p/em");
	}

	/*
	 * Function to get text of listitemsnode 3
	 */
	public String getTextOfblather(int num) {
		return safeGetText(addedblatherinlist(num), MEDIUMWAIT);
	}

	/*
	 * Locator For 'edit sub option in UE.
	 */
	private By editsubPropertyIcon() {
		return By.xpath("//i[contains(@id,'editHover_info')]");
	}

	/*
	 * Function to click on blather icon.
	 */
	public void clickoneditsubPropertyIcon() {
		safeJavaScriptClick(editsubPropertyIcon(), MEDIUMWAIT);
		// safeType(editsubblatherIcon(),num, SHORTWAIT);
	}

	// /*
	// * Function to click on various editing icons(comment,video,camera,info)
	// beside any node name.
	// */
	// public void clickOnEditIconsOnNode(String name){
	// safeClick(editIconsOnNode(name), MEDIUMWAIT);
	// }
	// /////////////////////////
	/*
	 * Locator for 1st property in edit window under 'info' heading.
	 */
	private By firstPropInfo() {
		return By.xpath("//div[contains(@class,'UE_node_content')]/input[contains(@id,'_property_0')]");
	}

	/*
	 * Function to edit in 1st property in edit window under 'info' heading.
	 */
	public void putTextInFirstPropInfo(String text) {
		safeClearAndType(firstPropInfo(), text, SHORTWAIT);
	}

	/*
	 * Function to get text after editing from 1st property in edit window under
	 * 'info' heading.
	 */
	public String getTextOfFirstPropInfo() {
		return driver.findElement(firstPropInfo()).getAttribute("value");
	}

	/*
	 * Locator for 2nd property in edit window under 'info' heading.
	 */
	private By secondPropInfo() {
		return By.xpath("//div[contains(@class,'UE_node_content')]/input[contains(@id,'_property_1')]");
	}

	/*
	 * Function to edit in 2nd property in edit window under 'info' heading.
	 */
	public void putTextInSecondPropInfo(String text) {
		safeClearAndType(secondPropInfo(), text, SHORTWAIT);
	}

	/*
	 * Function to get text after editing from 2nd property in edit window under
	 * 'info' heading.
	 */
	public String getTextOfSecondPropInfo() {
		return driver.findElement(secondPropInfo()).getAttribute("value");
	}

	/*
	 * Locator for 3rd property in edit window under 'info' heading.
	 */
	private By thirdPropInfo() {
		return By.xpath("//div[contains(@class,'UE_node_content')]/input[contains(@id,'_property_2')]");
	}

	/*
	 * Function to edit in 3rd property in edit window under 'info' heading.
	 */
	public void putTextInThirdPropInfo(String text) {
		safeClearAndType(thirdPropInfo(), text, SHORTWAIT);
	}

	/*
	 * Function to get text after editing from 3rd property in edit window under
	 * 'info' heading.
	 */
	public String getTextOfThirdPropInfo() {
		return driver.findElement(thirdPropInfo()).getAttribute("value");
	}

	/*
	 * Locator for 4th property in edit window under 'info' heading.
	 */
	private By fourPropInfo() {
		return By.xpath("//div[contains(@class,'UE_node_content')]/input[contains(@id,'_property_3')]");
	}

	/*
	 * Function to edit in 4th property in edit window under 'info' heading.
	 */
	public void putTextInFourPropInfo(String text) {
		safeClearAndType(fourPropInfo(), text, SHORTWAIT);
	}

	/*
	 * Function to get text after editing from 4th property in edit window under
	 * 'info' heading.
	 */
	public String getTextOfFourPropInfo() {
		return driver.findElement(fourPropInfo()).getAttribute("value");
	}

	/*
	 * Locator for 5th property in edit window under 'info' heading.
	 */
	private By fivePropInfo() {
		return By.xpath("//div[contains(@class,'UE_node_content')]/input[contains(@id,'property_4')]");
	}

	/*
	 * Function to edit in 5th property in edit window under 'info' heading.
	 */
	public void putTextInFivePropInfo(String text) {
		safeClearAndType(fivePropInfo(), text, SHORTWAIT);
	}

	/*
	 * Function to get text after editing from 5th property in edit window under
	 * 'info' heading.
	 */
	public String getTextOfFivePropInfo() {
		return driver.findElement(fivePropInfo()).getAttribute("value");
	}

	/*
	 * Locator for 6th property in edit window under 'info' heading.
	 */
	private By sixPropInfo() {
		return By.xpath("//div[contains(@class,'UE_node_content')]/input[contains(@id,'property_5')]");
	}

	/*
	 * Function to edit in 6th property in edit window under 'info' heading.
	 */
	public void putTextInSixPropInfo(String text) {
		safeClearAndType(sixPropInfo(), text, SHORTWAIT);
	}

	/*
	 * Function to get text after editing from 6th property in edit window under
	 * 'info' heading.
	 */
	public String getTextOfSixPropInfo() {
		return driver.findElement(sixPropInfo()).getAttribute("value");
	}

	/*
	 * Locator for 7th property in edit window under 'info' heading.
	 */
	private By sevenPropInfo() {
		return By
				.xpath("//div[contains(@class,'UE_node_content')]/input[contains(@id,'property_6')]");
	}

	/*
	 * Function to edit in 7th property in edit window under 'info' heading.
	 */
	public void putTextInSevenPropInfo(String text) {
		safeClearAndType(sevenPropInfo(), text, SHORTWAIT);
	}

	/*
	 * Function to get text after editing from 7th property in edit window under
	 * 'info' heading.
	 */
	public String getTextOfSevenPropInfo() {
		return driver.findElement(sevenPropInfo()).getAttribute("value");
	}

	/*
	 * Locator for 8th property in edit window under 'info' heading.
	 */
	private By eightPropInfo() {
		return By
				.xpath("//div[contains(@class,'UE_node_content')]/input[contains(@id,'property_7')]");
	}

	/*
	 * Function to edit in 8th property in edit window under 'info' heading.
	 */
	public void putTextInEightPropInfo(String text) {
		safeClearAndType(eightPropInfo(), text, SHORTWAIT);
	}

	/*
	 * Function to get text after editing from 8th property in edit window under
	 * 'info' heading.
	 */
	public String getTextOfEightPropInfo() {
		return driver.findElement(eightPropInfo()).getAttribute("value");
	}

	/*
	 * Locator for 9th property in edit window under 'info' heading.
	 */
	private By ninePropInfo() {
		return By
				.xpath("//div[contains(@class,'UE_node_content')]/input[contains(@id,'property_8')]");
	}

	/*
	 * Function to edit in 9th property in edit window under 'info' heading.
	 */
	public void putTextInNinePropInfo(String text) {
		safeClearAndType(ninePropInfo(), text, SHORTWAIT);
	}

	/*
	 * Function to get text after editing from 9th property in edit window under
	 * 'info' heading.
	 */
	public String getTextOfNinePropInfo() {
		return driver.findElement(ninePropInfo()).getAttribute("value");
	}

	/*
	 * Locator for 10th property in edit window under 'info' heading.
	 */
	private By tenPropInfo() {
		return By
				.xpath("//div[contains(@class,'UE_node_content')]/input[contains(@id,'property_9')]");
	}

	/*
	 * Function to edit in 10th property in edit window under 'info' heading.
	 */
	public void putTextInTenPropInfo(String text) {
		safeClearAndType(tenPropInfo(), text, SHORTWAIT);
	}

	/*
	 * Function to get text after editing from 10th property in edit window
	 * under 'info' heading.
	 */
	public String getTextOfTenPropInfo() {
		return driver.findElement(tenPropInfo()).getAttribute("value");
	}

	/*
	 * Locator for 'idea' button in UE.
	 */
	private By ideaTab() {
		return By.id("UE_listTabs_suggestions");
	}

	/*
	 * Function to make click on 'idea' tab.
	 */
	public void clickOnIdeaTab() {
		safeClick(ideaTab(), MEDIUMWAIT);
	}

	/*
	 * Locator For 'published list.
	 */
	private By publishlist() {
		return By.xpath("//div[@id='siteBody']/article[@id='list']");
	}

	/*
	 * Function to check the presence of list after published.
	 */
	public boolean isPresentpublishlist() {
		return isElementPresent(publishlist(),MEDIUMWAIT);
	}

	/*
	 * Locator For 'Search list .
	 */
	private By Searchlist(int num) {
		return By
				.xpath("//div[@id='UE_container']/div[@id='UE_search_container']/div[@id='UE_search_content']/ul/li["
						+ num
						+ "]/span[@class='float relative block name height100']");
	}

	/*
	 * Locator For 'Search list get text .
	 */
	private By gettxtofSearchlist(int num) {
		return By
				.xpath("//div[@id='UE_container']/div[@id='UE_search_container']/div[@id='UE_search_content']/ul/li["
						+ num
						+ "]/span[@class='float relative block name height100']//em");
	}

	/*
	 * Function to check the presence of Search list
	 */
	public boolean isPresentsearchlist(int num) {
		return isElementPresent(Searchlist(num),MEDIUMWAIT);
	}

	/*
	 * Function to get text of search list.
	 */
	public String getTextOfsearchlist(int num) {
		return safeGetText(gettxtofSearchlist(num), VERYLONGWAIT);
	}

}
