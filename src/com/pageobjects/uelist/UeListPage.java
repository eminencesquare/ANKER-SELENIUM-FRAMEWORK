package com.pageobjects.uelist;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.paeobjects.home.Commonpage;
import com.paeobjects.navbar.NavBar;
import com.selenium.SafeActions;

//import com.testsuite.UeListTest.clickOn;

public class UeListPage extends SafeActions {
	private WebDriver driver;
	Commonpage common;

	/*
	 * Constructor for the page.
	 */
	public UeListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/*
	 * Locator for create List.
	 */
	private By createList() {
		return By.xpath("//div[@id='siteNavMore']/ul/li/span[@id='createAList']/span[@class='inlineBlock lowercase']");
	}

	/*
	 * Function to make click on create list
	 */
	public void clickOncreateList() {
		safeJavaScriptClick(createList(), MEDIUMWAIT);
	}

	/*
	 * Locator for create List.
	 */
	private By reranking() {
		return By.id("createSubmit");
	}

	/*
	 * Function to make click on create list
	 */
	public void clickOnreranking() {
		safeJavaScriptClick(reranking(), MEDIUMWAIT);
	}

	/*
	 * Locator for rerank button.
	 */
	private By reRankButton() {
		return By.xpath("//div[@id='mlaTab_actions']//span[@id='reRankBtn']");
		// return By.id("reRankBtn");
	}

	/*
	 * Function to make click on rerank button.
	 */
	public void clickOnRerankButton() {
//		Actions act=new Actions(driver);
//		act.click(driver.findElement(reRankButton())).perform();
		safeJavaScriptClick(reRankButton(), LONGWAIT);
		waitForElementVisible(imageIcon(), 15);
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
		safeJavaScriptClick(ideaTab(), MEDIUMWAIT);
	}

	/*
	 * Locator For '+' icon in UE.
	 */
	private By plusIcon(int linum) {// UE_suggestions_content
		return By.xpath("//div[@id='UE_search_content']/ul/li[" +linum+"]/span[@class='float relative block action center']/span");
	}

	/*
	 * Function to make click on '+' icon in UE.
	 */
	public void clickOnPlusIcon(int linum) {
		safeJavaScriptClick(plusIcon(linum), MEDIUMWAIT);
	}

	/*
	 * Locator for List name in UE.
	 */
	private By listName() {
		return By.id("UE_editListName_input");
	}

	/*
	 * Function to make click on List name in UE.
	 */
	public void clickOnListName() {
		safeJavaScriptClick(listName(), SHORTWAIT);
		//waitForPageToLoad();
	}

	/*
	 * Function to give text in textBox of list name in UE.
	 */
	public void putTextOnListNameBox(String txt) {
		driver.findElement(listName()).clear();
		safeClearAndType(listName(), txt, SHORTWAIT);
	}

	/*
	 * Function to get text which is in textBox of list name in UE.
	 */
	public String getTextOfListName() {
		return driver.findElement(listName()).getAttribute("value");
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
		safeJavaScriptClick(publishbtn(), SHORTWAIT);
		waitForPageToLoad(60);
		//waitForElementVisible(videoAfterPublish(), 20);
	}

	/*
	 * Locator for header after publishing list.
	 */
	private By headerAfterPublish() {
		return By.xpath("//div[@id='listDesc']/h1/span[contains(@class,'name ')]");
	}
	/*
	 * Function for header after publishing list.
	 */
	public String getTextOFlistHeaderAfterPublish() {
		//waitForPageToLoad(30);
		return driver.findElement(headerAfterPublish()).getAttribute("data-internal-url");
	}
	/*
	 * Function for header after publishing list.
	 */
	public String getTextOFHeaderAfterPublish() {
		return safeGetText(headerAfterPublish(), LONGWAIT);
	}

	/*
	 * Locator for List Image Icon in UE.
	 */
	private By imageIcon() {
		return By.xpath("//div[@id='UE_container']//div[@id='UE_listHead']/img[@id='UE_listImg']");
	}

	/*
	 * Function to make click on List Image Icon in UE.
	 */
	public void clickOnImageIcon() {
		scrollIntoElementView(imageIcon());
		safeClick(imageIcon(), MEDIUMWAIT);
	}

	/*
	 * Function to get attribute src of list image.
	 */
	public String getSrcOfImageIcon() {
		return driver.findElement(imageIcon()).getAttribute("src");
	}

	/*
	 * Locator for text box of uploading image in UE through url.
	 */
	private By uploadImageUrlBox() {
		return By.xpath("//input[contains(@class,'UE_fileUploadUrl_input')]");
	}

	/*
	 * Function to pass url of image to upload.
	 */
	public void putUrlInUploadImageUrlBox(String txt) {
		safeType(uploadImageUrlBox(), txt, MEDIUMWAIT);
	}// http://www.snatchedxo.com/wp-content/uploads/2015/03/I-heart-you-hanging-Happy-Valentines-Day-2015-Wallpaper.jpg

	/*
	 * Locator for upload button.
	 */
	private By uploadButton() {
		return By.xpath("//span[@class='inlineBlock btnBlue UE_fileUploadUrl_btn']");
	}

	/*
	 * Function to make click on upload button.
	 */
	public void clickOnUploadButton() {
		safeClick(uploadButton(), MEDIUMWAIT);
		waitForElementVisible(doneUpload(), 10);
	}

	/*
	 * Locator for 'done' for saving uploaded image.
	 */
	private By doneUpload() {
		return By.xpath("//div[@id='UE_list_details_actions']/span[@class='relative inlineBlock btnBlue']");
	}

	/*
	 * Function to make click on 'done' for saving uploaded image.
	 */
	public void clickOnDoneUpload() {
		safeClick(doneUpload(), SHORTWAIT);
		waitForElementVisible(imageIcon(), 15);
	}

	/*
	 * Locator for checking uploaded image after publish.
	 */
	private By publishImage() {
		return By.id("listImgTarget");
	}

	/*
	 * Function to get src attribute of uploaded image after publish.
	 */
	public String getSrcOfPublishImage() {
		return driver.findElement(publishImage()).getAttribute("src");
	}

	/*
	 * Locator for 'save' on UE.
	 */
	private By saveUe() {
		return By.id("UE_nav_close");
	}

	/*
	 * Function to click on 'save' on UE.
	 */
	public void clickOnSaveUe() {
		safeJavaScriptClick(saveUe(), SHORTWAIT);
	}

	/*
	 * Locator for search box.
	 */
	private By searchBox() {
		return By.id("UE_search_input");
	}

	/*
	 * Function to type text in search bar in UE.
	 */
	public void typesearchbtn(String num) {
		safeClearAndType(searchBox(), num, SHORTWAIT);
		driver.findElement(searchBox()).sendKeys(Keys.ENTER);
		waitForPageToLoad();
	}

	/*
	 * Locator for search box.
	 */
	private By searchaddbtn() {
		return By.id("UE_search_create_add");
	}

	/*
	 * Function to click on share button..
	 */
	public void clickonsearchaddbtn() {
		safeClick(searchaddbtn(), SHORTWAIT);
		waitForElementVisible(nodeName("lastNode"), 10);
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
	 * Locator for added node in UE List.
	 */
	private By nodeName(String name) {
		if (name.equalsIgnoreCase("lastNode"))
			return By.xpath("//div[@id='UE_content']/ol/li[last()]/div[@class='relative width100 height100 rowWrapper']/div[@class='relative block name height100 move']/p/span[@class='txt']");
		else
			// first node
			return By.xpath("//div[@id='UE_content']/ol/*[1]/div[@class='relative width100 height100 rowWrapper']/div[@class='relative block name height100 move']/p/span[@class='txt']");
	}

	/*
	 * Function to get text of added node in UE List.
	 */
	public String getTextOfAddedNode(String name) {
		
		return safeGetText(nodeName(name), MEDIUMWAIT);
	}

	/*
	 * Locator for added node after publish.
	 */
	private By publishAddedNode(String txt) {
		if (txt.equalsIgnoreCase("text"))
			//
			return By.xpath("//section[@id='mainListCnt']/ol/li[last()]/div[@class='relative name authored exclude anClip']/p[@class='tableAlign visible']/span[@class='inlineBlock oNode']");
			//return By.xpath("//div[@id='UE_content']/ol/li[last()]//div[@class='relative width100 height100 rowWrapper']");
		else {
			if (txt.equalsIgnoreCase("img")) {
				return By.xpath("//div[@id='listBody']/section[@id='mainListCnt']/ol/*[1]/div[@class='float relative img']/a[@class='relative block oImg trigger']/img");
			} else
				// blather
				return By.xpath("//section[@id='mainListCnt']/ol/*[1]/div[@class='relative name anClip']/p/em[@itemprop='description']");
		}
	}
	private By nodecheckclickable() {
			return By.xpath("//section[@id='mainListCnt']/ol/li[last()]/div[contains(@class,'relative name')]/p/a/span[@itemprop='name']");}

	/*
	 * Function to get text of added node after publish.
	 */
	public String getTextOfPublishAddedNodeText(String txt) {
		scrollIntoViewThroughJavaScriptExecuter(publishAddedNode(txt));
		return safeGetText(publishAddedNode(txt), SHORTWAIT);
	}

	/*
	 * Function to get src of added image node after publish.
	 */
	public String getSrcOfPublishAddedNodeImage(String txt) {
		return driver.findElement(publishAddedNode(txt)).getAttribute("src");
	}
	/*
	 * Function to check the clickable of Authorednode
	 */
	public boolean isclickableAuthorednode(String txt) {
		System.out.println("aaaaaaaaaaaaa");
		return isElementVisible(nodecheckclickable(), SHORTWAIT);
	}
	/*
	 * Function to get blather text after publish.
	 */
	public String getTextOfPublishAddedNodeBlather(String txt) {
		return safeGetText(publishAddedNode(txt), LONGWAIT);
	}

	/*
	 * Locator For adding node image from various image options in edit.
	 */
	private By imageadd(int linum) {
		return By.xpath("//div[contains(@class,'UE_node_content')]/ul/li[" + linum + "]/img");
	}

	/*
	 * Function to click on image to be added in edit.
	 */
	public void clickonimageaddoption(int num) {
		scrollIntoElementView(imageadd(num));
		safeClick(imageadd(num), MEDIUMWAIT);
		waitForElementVisible(selectbtn(), 30);
	}

	/*
	 * Function to get attribute of node image.
	 */
	public String getsrcimage(int num) {
		return driver.findElement(imageadd(num)).getAttribute("src");
	}

	/*
	 * Locator For 'select' button.
	 */
	private By selectbtn() {
		return By.xpath("//div[@class='center btns']/span[1]");
	}

	/*
	 * Function to click on select button.
	 */
	public void clickonselectbtn() {
		safeJavaScriptClick(selectbtn(), MEDIUMWAIT);
	}

	/*
	 * Locator For done button on edit.
	 */
	private By donetbtn() {
		return By.id("UE_node_done");
	}

	/*
	 * Function to click done button.
	 */
	public void clickondonebtn() {
		safeClick(donetbtn(), MEDIUMWAIT);
	}
	/*
	 * Locator For done button on edit.
	 */
	private By doneinfobtn() {
		return By.xpath("//div[@id='UE_info_container_actions']/span[@class='relative inlineBlock btnBlue']");
	}

	/*
	 * Function to click done button.
	 */
	public void clickondoneinfobtn() {
		safeJavaScriptClick(doneinfobtn(), MEDIUMWAIT);
	}
	/*
	 * Locator For added node image in list.
	 */
	private By addimageinlist(int linum) {
		return By.xpath("//div[@id='UE_content']/ol/li[" + linum + "]//img");
	}

	/*
	 * Function to get attribute of node image after change.
	 */
	public String getsrcaddimage(int num) {
		return driver.findElement(addimageinlist(num)).getAttribute("src");
	}

	/*
	 * Locator for node image.
	 */
	private By nodeImage(int linum) {
		return By.xpath("//div[@id='UE_content']/ol/li["+linum+ "]/div[@class='relative width100 height100 rowWrapper']/span[@class='float relative block img whiteBg pointer']");
	}

	/*
	 * Function to click on node image.
	 */
	public void clickOnNodeImage(int linum) {
		safeClick(nodeImage(linum), SHORTWAIT);
	}

	/*
	 * Locator for edit icon beside any node name.
	 */
	private By nodeEditAndDelete(String txt) {
		if (txt.equalsIgnoreCase("edit"))
			return By.xpath("//div[@id='UE_content']/ol/*[1]/div[@class='relative width100 height100 rowWrapper']/span[contains(@id,'edit')]/i");
		else
			// delete
			return By.xpath("//div[@id='UE_content']/ol/*[1]/div[@class='relative width100 height100 rowWrapper']/span[contains(@id,'delete')]/i");
	}

	/*
	 * Function to hover over edit icon beside any node name.
	 */
	public void hoverOnNodeEdit(String txt) {
		mouseHover(nodeEditAndDelete(txt), MEDIUMWAIT);
		// mouseHoverJScript(nodeEditAndDelete(txt),"a", MEDIUMWAIT);
	}

	/*
	 * Function to click on 'delete' icon beside any node name.
	 */
	public void clickOnDelete(String txt) {
		safeClick(nodeEditAndDelete(txt), SHORTWAIT);
	}

	private By deleteForLastnode() {
		return By.xpath("//div[@id='UE_content']/ol/li[last()]/div[@class='relative width100 height100 rowWrapper']/span[contains(@id,'delete')]/i");
		
		// div[@id='UE_content']/ol/*[1]/div[@class='relative width100 height100
		// rowWrapper']/span[contains(@id,'delete')]/i
	}

	/*
	 * Function to click on 'delete' icon beside any node name.
	 */
	public void deleteLastNode() {
		safeClick(deleteForLastnode(), SHORTWAIT);
		waitForElementVisible(nodeName("lastNode"), 20);
	}

	/*
	 * Locator for edit icon beside any node name.
	 */
	private By editIconsOnNode(String name) {
		if (name.equalsIgnoreCase("comment"))
			return By.xpath("//div[@id='UE_content']/ol/*[1]/div[@class='relative width100 height100 rowWrapper']/div[contains(@class,'float absolute editHover')]//i[contains(@id,'_editHover_comment')]");
		else {
			if (name.equalsIgnoreCase("video"))
				return By.xpath("//div[@id='UE_content']/ol/*[1]/div[@class='relative width100 height100 rowWrapper']/div[contains(@class,'float absolute editHover')]//i[contains(@id,'editHover_video')]");
			else {// rating
				if (name.equalsIgnoreCase("rating"))
					return By.xpath("//div[@id='UE_content']/ol/*[1]/div[@class='relative width100 height100 rowWrapper']/div[contains(@class,'float absolute editHover')]//i[contains(@id,'editHover_ratings')]");
				else
					// info
					return By.xpath("//div[@id='UE_content']/ol/*[1]/div[@class='relative width100 height100 rowWrapper']/div[contains(@class,'float absolute editHover')]//i[contains(@id,'editHover_info')]");
			}
		}
	}

	/*
	 * Function to click on various editing icons(comment,video,camera,info)
	 * beside any node name.
	 */
	public void clickOnEditIconsOnNode(String name) {
		safeJavaScriptClick(editIconsOnNode(name), LONGWAIT);
		//waitForElementClickable(commentBoxInEdit(), 10);
	}
//	private By videosearch(){
//		 return By.id("UE_youtubeSearch_input");
//	 }	
//	 /*
//		 * Function to give text in text box at bottom of list(adding new list item).
//		 */
//		public void putTextInAddvideo(String txt){
//			safeClearAndType(videosearch(), txt, SHORTWAIT);
//		}
	/*
	 * Locator for comment box in edit my item.
	 */
	private By commentBoxInEdit() {
		return By.xpath("//div[contains(@class,'UE_node_content')]/div[@class='relative editable visible']/div");
	}
	//driver.findElement(nodeImg()).sendKeys(Keys.CONTROL+"i");
	/*
	 * Function to type text in comment box in edit my item.
	 */
	public void typeInCommentBoxInEdit(String txt) {
		safeClick(commentBoxInEdit(), MEDIUMWAIT);
		safeClearAndType(commentBoxInEdit(), txt, MEDIUMWAIT);
	}
	/*
	 * Function to get src attribute of video(img) after adding it from 'edit'
	 * in the node.
	 */
	public void getfontblatheritalic() {
		//driver.findElement(searchBox()).sendKeys(Keys.ENTER);
		System.out.println("com in this");
		 driver.findElement(commentBoxInEdit()).sendKeys(Keys.CONTROL+"i");
		}
	/*
	 * Function to get text of node blather in UE.
	 */
	public String getfontOfcommentBoxInEdit() {
		return driver.findElement(commentBoxInEdit()).getCssValue("font-style");
		//driver.findElement(commentBoxInEdit().c)
	}
	/*
	 * Locator for node blather in UE.
	 */
	private By nodeBlather() {
		return By.xpath("//div[@id='UE_content']/ol/*[1]/div[@class='relative width100 height100 rowWrapper']/div[@class='relative block name height100 move']/p/em");
	}

	/*
	 * Function to get text of node blather in UE.
	 */
	public String getTextOfNodeBlather() {
		return safeGetText(nodeBlather(), MEDIUMWAIT);
	}

	/*
	 * Locator for video selection in edit(pane).
	 */
	private By videoInEdit(int num) {
		return By.xpath("//div[contains(@class,'UE_node_content')]/ul[@class='UE_youtubeThumbs']/li["+ num + "]/img");
	}

	/*
	 * Function to select the video in edit box as node image.
	 */
	public void clickOnVideoInEdit(int num) {
		safeJavaScriptClick(videoInEdit(num), SHORTWAIT);
		waitForElementVisible(selectbtn(), 10);
	}

	/*
	 * Locator for video(img) after adding it from 'edit' in the node.
	 */
	private By videoInNode() {
		return By.xpath("//div[@id='UE_content']/ol/*[1]/div[@class='relative width100 height100 rowWrapper']/span[contains(@id,'_imgEdit')]/img[@class='float absolute videoOverlay']");
	}

	/*
	 * Function to get src attribute of video(img) after adding it from 'edit'
	 * in the node.
	 */
	public String getSrcOfVideoInNode() {
		return driver.findElement(videoInNode()).getAttribute("src");
	}

	/*
	 * Locator for video(img) after publish.
	 */
	private By videoAfterPublish() {
		return By.xpath("//section[@id='mainListCnt']/ol/*[1]/div[@class='float relative img']/span[@class='internal pointer relative block pVid trigger']/img[@class='float absolute width100 videoOverlay']");
	}

	/*
	 * Function to get src of video(img) after publish.
	 */
	public String getSrcOfVideoAfterPublish() {
		return driver.findElement(videoAfterPublish()).getAttribute("src");
	}

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
		return By
				.xpath("//div[@id='UE_node_content']/input[contains(@id,'property_1')]");
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
		return By
				.xpath("//div[@id='UE_node_content']/input[contains(@id,'property_2')]");
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
		return By
				.xpath("//div[@id='UE_node_content']/input[contains(@id,'property_3')]");
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
		return By
				.xpath("//div[@id='UE_node_content']/input[contains(@id,'property_4')]");
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
		return By
				.xpath("//div[@id='UE_node_content']/input[contains(@id,'property_5')]");
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
				.xpath("//div[@id='UE_node_content']/input[contains(@id,'property_6')]");
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
				.xpath("//div[@id='UE_node_content']/input[contains(@id,'property_7')]");
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
				.xpath("//div[@id='UE_node_content']/input[contains(@id,'property_8')]");
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
				.xpath("//div[@id='UE_node_content']/input[contains(@id,'property_9')]");
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
	 * Locator for node name box in 'edit'.
	 */
	private By nodeNameBoxInEdit() {
		return By
				.xpath("//div[@id='UE_node_container_window']/div[@class='relative width100 height100 chalkBg']/div[@class='relative UE_node_header']/div[@class='float relative nameContainer']/textarea");
	}

	/*
	 * Function to change node name in 'edit'.
	 */
	public void putTextInNodeNameBoxInEdit(String text) {
		safeClearAndType(nodeNameBoxInEdit(), text, MEDIUMWAIT);
	}

	/*
	 * Locator for any node rank number in UE.
	 */
	private By nodeRank(int num) {
		return By
				.xpath("//div[@id='UE_content']/ol/li["
						+ num
						+ "]/div[@class='relative width100 height100 rowWrapper']/input[contains(@id,'rank')]");
	}

	/*
	 * Function to get rank number of the node in UE(MyList).
	 */
	public String getNodeRank(int num) {
		return driver.findElement(nodeRank(num)).getAttribute("value");
	}

	/*
	 * Locator for node in UE.
	 */
	private By node(int i) {
		return By.xpath("//div[@id='UE_content']/ol/*[" + i + "]");
	}

	/*
	 * Function to drag and change the position of node.
	 */
	public void dragChangeNode(int source, int destination) {
		Actions builder = new Actions(driver);
//		builder.click(driver.findElement(node(source)))
//		.build()
//				.perform();
		
//				builder.clickAndHold(driver.findElement(node(source)))
//				.moveToElement(driver.findElement(node(destination))).release()
//				.build().perform();
		// Actions builder = new Actions(driver);
		 //
		 builder.click(driver.findElement(node(source))).keyDown(Keys.CONTROL).click(driver.findElement(node(source))).click(driver.findElement(node(source)))
		  .build().perform();
		 builder.clickAndHold()
		 .moveToElement(driver.findElement(node(destination))).release()
		 .build().perform();

//		WebElement element = driver.findElement(node(source)); 
//		System.out.println("#aaaaaaaaaaaaaaaaaaaa");
//		WebElement target = driver.findElement(node(destination));
//		System.out.println("#bbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
//		Actions dragAndDrop = new Actions(driver);
////		Actions action = (Actions) dragAndDrop.dragAndDrop(element, target).build();
////        action.perform();
//		Actions moveAndDrop = new Actions(driver);
		//moveAndDrop.click(element).clickAndHold().moveToElement(target)
		//.release(element).build().perform();//.perform();
		// System.out.println("#aaaaaaaaaaaaaaaaaaaa");
//		moveAndDrop.moveToElement(target)
//				.release(element).build().perform();
		System.out.println("#bbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		// moveAndDrop.release().perform();
		System.out.println("#ccccccccccccccccccccccc");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
	}

	/*
	 * Function for multiple drag and drop.
	 */
	public void multiDrag(int src1, int src2, int destination) {
		Actions builder = new Actions(driver);
		builder.click(driver.findElement(node(src1))).keyDown(Keys.CONTROL)
				.click(driver.findElement(node(src2))).build()
				.perform();
		
		builder.clickAndHold()
				.moveToElement(driver.findElement(node(destination))).release()
				.build().perform();
	}

	/*
	 * Locator for Authored node .
	 */
	private By Authorednode() {
		return By
				.xpath("//div[@id='UE_search_create']/span[@class='float relative block name height100']");
	}

	/*
	 * Function to check the presence of Authorednode
	 */
	public boolean isPresenceAuthorednode() {
		return isElementPresent(Authorednode(), SHORTWAIT);
	}

	/*
	 * Locator for Authored node .
	 */
	private By Authorednodeinediticon() {
		return By
				.xpath("//div[@id='UE_search_create']/span[@class='floatRight relative block center pointer edit']");
	}

	/*
	 * Function to check the presence of Authorednode in edit icn
	 */
	public boolean isPresenceAuthorednodeinediticon() {
		return isElementPresent(Authorednodeinediticon(), SHORTWAIT);
	}

	/*
	 * Locator for Authored node in camera icon .
	 */
	private By Authorednodeintxtnew() {
		return By
				.xpath("//div[@id='UE_search_create']/span[@class='float relative block img whiteBg']//span[@class='float block absolute new midGrey uppercase center']");
	}

	/*
	 * Function to check the presence of Authorednode
	 */
	public boolean isPresenceAuthorednodecameraicon() {
		return isElementPresent(Authorednode(), SHORTWAIT);
	}

	/*
	 * Function for get text of authororenode
	 */
	public String getTextOFAuthorednode() {
		return safeGetText(Authorednodeintxtnew(), LONGWAIT);
	}

	/*
	 * Locator for node image change numbering.
	 */
	private By nodeImagechangeno(int linum) {
		return By
				.xpath("//div[@id='UE_content']/ol/li["
						+ linum
						+ "]/div[@class='relative width100 height100 rowWrapper']/input[contains(@ id,'UE_mlaRow_')]");
	}

	/*
	 * Function for type of node number
	 */
	public void getTypeofnumberingnode(String text, int num) {
		scrollIntoViewThroughJavaScriptExecuter(nodeImagechangeno(num));
		safeClearAndType(nodeImagechangeno(num), text, LONGWAIT);
	}

	/*
	 * Locator for optionbtn in UE
	 */
	private By optionbtn() {
		return By.xpath("//div[@id='UE_listTabs']/span[@id='UE_listTabs_customize']/i");
	}

	/*
	 * Function to make click option btn in UE.
	 */
	public void clickOnoptionbtn() {
		//scrollIntoElementView(optionbtn());
		safeJavaScriptClick(optionbtn(), MEDIUMWAIT);
	}

	/*
	 * Locator for style change
	 */
	private By stylechnage() {
		return By.xpath("//span[@id='UE_settings_display_blog']/span[1]");
	}

	/*
	 * Function to make click option btn in UE.
	 */
	public void clickOnstylechnage() {
		safeClick(stylechnage(), MEDIUMWAIT);
	}
	/*
	 * Locator for style change
	 */
	private By stylechnageslideshow() {
		return By.xpath("//span[@id='UE_settings_display_slideshow']/span[1]");
	}

	/*
	 * Function to make click option btn in UE.
	 */
	public void clickOnstylechnageslideshow() {
		safeClick(stylechnageslideshow(), MEDIUMWAIT);
	}
	/*
	 * Function to get Header color of TextHeader.
	 */
	public String getborderColorlist() {
		return driver.findElement(stylechnage()).getCssValue(
				"border-bottom-color");
	}

	/*
	 * Locator for advanced option in UE.
	 */
	private By advancedOption() {
		return By.xpath("//div[@id='UE_settings_advancedTrigger']/span[@class='relative inlineBlock btnGrey']/i");
	}

	/*
	 * Function to click on advanced option button in UE.
	 */
	public void clickOnAdvancedOption() {
		safeJavaScriptClick(advancedOption(), SHORTWAIT);
	}

	/*
	 * Locator for url and display name text boxes in UE under Advanced Options.
	 */
	private By websiteUrl(String text) {
		if (text.equalsIgnoreCase("link"))
			return By.id("UE_settings_website_link");
		else
			// title
			return By.id("UE_settings_website_title");
	}

	/*
	 * Function to pass url as text in url text box in UE under Advanced
	 * Options.
	 */
	public void putTextInUrlNameBox(String text, String url) {
		safeType(websiteUrl(text), url, SHORTWAIT);
	}
	public void clickInUrlNameBox(String text) {
		safeClick(websiteUrl(text),SHORTWAIT);
	}

	/*
	 * Function to pass name in 'display name of your site' text box in UE under
	 * Advanced Options.
	 */
	public void putTextInDisplayNameBox(String text, String name) {
		//safeClick(websiteUrl(text), SHORTWAIT);
//		try {
//			Thread.sleep(500);
//		} catch (Exception e) {
//		}
		safeType(websiteUrl(text), name, SHORTWAIT);
	}

	/*
	 * Locator for website url after publish.
	 */
	private By webstieUrlAfterPublish() {
		return By.xpath("//div[@id='siteBody']/article[@id='list']/header[@id='listHead']/div[@id='listData']/div/span/a[@id='listRelLink']");
		// By.xpath("//div[@id='listData']/div/span//a[@rel='nofollow']");
	}

	/*
	 * Function to check the presence of website url after publish.
	 */
	public boolean isWebstieUrlAfterPublishPresent() {
		return isElementPresent(webstieUrlAfterPublish(), MEDIUMWAIT);
	}

	/*
	 * Function to get text of website url after publish.
	 */
	public String getTextOfWebstieUrlAfterPublish() {
		return safeGetText(webstieUrlAfterPublish(), SHORTWAIT);
	}

	/*
	 * Locator for 'add tags' in UE settings.
	 */
	private By addTagsInUe() {
		return By.id("UE_settings_tagsTrigger_btn");
	}

	/*
	 * Function to click on 'add tags' button in UE settings.
	 */
	public void clickOnAddTagsInUe() {
		safeClick(addTagsInUe(), SHORTWAIT);
	}
	/*
	 * Function to get text of website url after publish.
	 */
	public String getTextOfaddTagsInUe() {
		return safeGetText(addTagsInUe(), SHORTWAIT);
	}
	
	/*
	 * Locator for adding tags in tag text box and 'add tags' button.
	 */
	private By tagTextBoxAndButton(String txt) {
		if (txt.equalsIgnoreCase("textbox"))
			return By.xpath("//div[@id='UE_settings_tags_create']/input");
		else
			// button
			return By.xpath("//div[@id='UE_settings_tags_create']/span");
	}

	/*
	 * Function to send text in tags text box.
	 */
	public void putTextInTagTextBox(String txt, String tagName) {
		safeType(tagTextBoxAndButton(txt), tagName, SHORTWAIT);
	}

	/*
	 * Function to make click on 'add tags' button in add tags to my list pop
	 * up.
	 */
	public void clickOnAddTagsPopup(String txt) {
		safeClick(tagTextBoxAndButton(txt), SHORTWAIT);
	}

	/*
	 * Locator for tags already in popup and new added.
	 */
	private By exsistingAddedTags() {
		return By
				.xpath("//div[@id='UE_tags_container']//div[@id='UE_settings_tags']/ul[@id='UE_settings_tags_remove']/li[@class='float block tag midGreyBg']/span[@class='inlineBlock txt lowercase']");
		// else //'x' on tag
		// return
		// By.xpath("//ul[@id='UE_settings_tags_remove']/li[last()]/span[@class='inlineBlock tag rnkrDBlueBg']/span[@class='Remove this tag']");
	}

	/*
	 * Function to get text of recently added tag.
	 */
	public String getTextOfRecentlyAddedTag() {
		return safeGetText(exsistingAddedTags(), MEDIUMWAIT);
	}

	private By deleteRecentAddedTags(String name) {
		return By
				.xpath("//div[@id='UE_tags_container']//div[@id='UE_settings_tags']/ul[@id='UE_settings_tags_remove']/li[@class='float block tag midGreyBg']/span[@class='inlineBlock txt lowercase']");
		// return
		// By.xpath("//span[contains(text(),'"+name+"')]/preceding-sibling::span");
	}

	/*
	 * Function to click on 'x' on recently added tag to delete it.
	 */
	public void clickOnDeleteRecentAddedTags(String name) {
		safeJavaScriptClick(deleteRecentAddedTags(name), SHORTWAIT);
	}

	/*
	 * Locator for done button in add tags popup.
	 */
	private By doneInAddTags() {
		return By
				.xpath("//div[@id='UE_tags_container_actions']/span[@class='relative inlineBlock btnBlue']");
	}

	/*
	 * Function to click on done in add tags popup.
	 */
	public void clickOnDoneInAddTags() {
		safeJavaScriptClick(doneInAddTags(), SHORTWAIT);
	}

	/*
	 * Locator for 'tags' after publish.
	 */
	private By tagHeadAfterPublish() {
		return By.id("listDataMore_trigger");
	}

	/*
	 * Function to click on 'tags' after publish.
	 */
	public void clickOnTagHeadAfterPublish() {
		safeJavaScriptClick(tagHeadAfterPublish(), LONGWAIT);
	}

	/*
	 * Locator for recent tag in 'tags' popup after publish.
	 */
	private By recentTagInPopUpAfterPublish() {
		return By
				.xpath("//div[@id='listDataMore']/span[@id='listTags']/a[last()]");
	}

	/*
	 * Function to get text of recently added tag after publishing.
	 */
	public String getTextOfRecentTagInPopUpAfterPublish() {
		return safeGetText(recentTagInPopUpAfterPublish(), SHORTWAIT);
	}

	/*
	 * Locator for tags in add tag to my list popup in UE.
	 */
	private By totalTags() {
		return By
				.xpath("//div[@id='UE_tags_container']//div[@id='UE_settings_tags']/ul[@id='UE_settings_tags_remove']/li[@class='float block tag midGreyBg']");
		// return By.xpath("//ul[@id='UE_settings_tags_remove']/li");
	}

	/*
	 * Function to count total number of tags.
	 */
	public int getNumberOfTotalTags() {
		return driver.findElements(totalTags()).size();
	}

	/*
	 * Locator for embed button chnage yes or no.
	 */
	private By embedbtn() {
		return By.xpath("//span[@id='UE_settings_embed_option']/span[1]");
	}

	/*
	 * Function to Make click embedbtn chnage yes or no
	 */
	public void clickonembedbtn() {
		safeJavaScriptClick(embedbtn(), MEDIUMWAIT);
		// safeClick(embedbtn(), false, MEDIUMWAIT, MEDIUMWAIT);
	}

	/*
	 * Locator for embed button after publish list
	 */
	private By embedbtnafterpublishlist() {
		return By.xpath("//div[@id='mlaTab_embed']");
	}

	/*
	 * Function to check the presence of embed button after publish list
	 */
	public boolean isPresenceembedbtnafterpublishlist() {
		return isElementPresent(embedbtnafterpublishlist(), SHORTWAIT);
	}

	/*
	 * locator for unpublished button
	 */
	private By unpublishedbtn() {
		return By.xpath("//div[@id='UE_settings_unpublish']/span[@id='UE_settings_unpublish_btn']");
	}

	/*
	 * Function is used to click on unpublished button
	 */
	public void clickonunpublishedbtn() {
		safeJavaScriptClick(unpublishedbtn(), MEDIUMWAIT);
	}
	
	/*
	 * Function is used to get text of unpublished button
	 */
	public String getTextofunpublishedbutton() {
		return safeGetText(unpublishedbtn(), MEDIUMWAIT);
	}
	/*
	 * Function to check the presence of unpublished button
	 */
	public boolean isPresentunpublishedbtn() {
		//scrollIntoViewThroughJavaScriptExecuter(unpublishedbtn());
		return isElementVisible(unpublishedbtn(),SHORTWAIT);
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

	private By sticky() {
		return By.xpath("//div[@id='UE_sticky_iListStart']");
	}

	private By stickyafterpublish() {
			return By.id("stickyPayoffSettings");
		}
	

	public boolean isPresentstickyafterpublish() {
		return isElementPresent(stickyafterpublish(), SHORTWAIT);
	}

	public boolean isStickyPresent() {
		return isElementPresent(sticky(), SHORTWAIT);
	}

	private By stickyOK() {
		  return By.xpath("//div[@id='UE_sticky_iListStart']//span[@class='inlineBlock btnDBlue']");
		 }
	private By stickyokafterpublished() {
		return By.xpath("//div[@id='stickyPayoffSettings']/p/span[@class='inlineBlock btnDBlue']");
	}
	/*
	 * Locator for sticky at ultimate list.
	 */
	private By stickyOnUL(){
		return By.xpath("//div[@id='stickyWorstOfList']/p/span[@class='inlineBlock btnDBlue']");
	}
	/*
	 * Function to click on ok of sticky at ultimate list.
	 */
	public void clickOnstickyOnUL(){
		safeClick(stickyOnUL(), MEDIUMWAIT);
	}
	
	public void clickStickyOK() {
		safeClick(stickyOK(), SHORTWAIT);
	}

	public void clickstickyokafterpublished() {
		safeJavaScriptClick(stickyokafterpublished(), SHORTWAIT);
	}
//	public boolean isstickyokafterpublishedPresent() {
//		return isElementPresent(stickyokafterpublished(), SHORTWAIT);
//	}
	/*
	 * Locator for added node in UE List.
	 */
	private By nodetext(int name) {
		return By
				.xpath("//div[@id='UE_content']/ol/li["
						+ name
						+ "]/div[@class='relative width100 height100 rowWrapper']/div[@class='relative block name height100 move']/p/span[@class='txt']");
	}

	/*
	 * Function to get text of added node in UE List.
	 */
	public String getTextOfNode(int name) {
		return safeGetText(nodetext(name), MEDIUMWAIT);
	}

	/*
	 * Locator for edit after published list
	 */
	private By editafterpublish() {
		return By.xpath("//div[@id='payoffTriggers']/div[@id='payoffEdit']/span[1]/i");
	}
	/*
	 * function for edit after published list
	 */
	public void clickeditafterpublish() {
		safeJavaScriptClick(editafterpublish(), MEDIUMWAIT);
	}
	/*
	 * function for edit after published list
	 */
	public boolean isPresenteditafterpublish() {
	return isElementPresent(editafterpublish(), MEDIUMWAIT);
	}
	/*
	 * Locator for setting after published list
	 */
	private By settingafterpublish() {
		return By.xpath("//div[@id='payoffOptions']/span[@class='float block inner']/i");
	}

	public void clicksettingafterpublish() {
		safeClick(settingafterpublish(), MEDIUMWAIT);
		// waitForPageToLoad();
	}
	/*
	 * function for edit after published list
	 */
	public boolean isPresentsettingafterpublish() {
	return isElementPresent(editafterpublish(), MEDIUMWAIT);
	}

	/*
	 * Locator For get class.
	 */
	private By classpiker(int linum) {// UE_suggestions_content
		return By.xpath("//div[@id='UE_search_content']/ul/li["+ linum+ "]/span[@class='float relative block name height100']//span[@class='disambi midGrey']");
	}

	/*
	 * Function to get text of class pikear.
	 */
	public String getTextclass(int name) {
		return safeGetText(classpiker(name), MEDIUMWAIT);
	}

	/*
	 * Locator For drop down filter.
	 */
	private By dropdown() {// UE_suggestions_content
		return By.xpath("//div[@id='UE_classResultsOptions']/select");
	}

	/*
	 * Function to make click on dropdown
	 */
	public void clickOndropdown() {
		safeClick(dropdown(), LONGWAIT);
	}

	/*
	 * Locator For drop down and select film.
	 */
	private By dropdownselection( String text) {// UE_suggestions_content
		return By
				.xpath("//div[@id='UE_classResultsOptions']/select/option[contains(text(),'"+text+"')]");
	}
	/*
	 * Locator For drop down and select film.
	 */
	private By dropdownselection1( ) {// UE_suggestions_content
		return By.xpath("//div[@id='UE_classResultsOptions']/select/option[contains(text(),'Songs')]");
	}
	/*
	 * Function to make click on dropdown and select film
	 */
	public void clickOndropdownselection(String text) {
		safeJavaScriptClick(dropdownselection(text), LONGWAIT);
	}
	/*
	 * Function to make click on dropdown and select film
	 */
	public void clickOndropdownselection1() {
		safeJavaScriptClick(dropdownselection1(), LONGWAIT);
	}
	/*
	 * Locator For search node. for song class
	 */
	private By Songsearchnode(int linum) {// UE_suggestions_content
		return By
				.xpath("//div[@id='UE_search_content']/ul/li["+ linum+ "]/span[@class='float relative block name height100']//em[@class='note serif rnkrDGreen']");
	}

	/*
	 * Function to get text of search node.
	 */
	public String getTextofSongsearchnode(int num) {
		return safeGetText(Songsearchnode(num), MEDIUMWAIT);
	}
	/*
	 * Locator For my list description
	 */
	private By mylistdescription() {// UE_suggestions_content
		return By.xpath("//div[@id='UE_listHead']/em/span");
	}

	/*
	 * Function to make click on dropdown and select film
	 */
	public void clickOnmylistdescription() {
		safeJavaScriptClick(mylistdescription(), LONGWAIT);
		waitForPageToLoad();
	}

	/*
	 * Locator For my list description
	 */
	private By mylistdescriptiontxtbox() {// UE_suggestions_content
		return By.xpath("//div[@class='edD']");
	}

	/*
	 * Function to type text in comment box in edit my item.
	 */
	public void typeInlistdescription(String txt) {
		safeClearAndType(mylistdescriptiontxtbox(), txt, MEDIUMWAIT);
	}

	/*
	 * Function to get text of my list description.
	 */
	public String getTextlistdescription() {
		return safeGetText(mylistdescription(), MEDIUMWAIT);
	}

	/*
	 * Locator For done button in mylist description in txtbox
	 */
	private By listdescriptiontxtboxdonebtn() {
		return By
				.xpath("//div[@id='UE_list_details_actions']/span[@class='relative inlineBlock btnBlue']");
	}

	/*
	 * Function to make click on dropdown and select film
	 */
	public void clickOnlistdescriptiondonebtn() {
		safeClick(listdescriptiontxtboxdonebtn(), LONGWAIT);
	}

	/*
	 * Locator For list description after published list
	 */
	private By listdescriptionafterpublish() {
		return By
				.xpath("//div[@id='csstc__userDesc__inner']/div[@class='relative desc init grey']");
	}

	/*
	 * Function to get text of my list description after published
	 */
	public String getTextlistdescriptionafterpublish() {
		return safeGetText(listdescriptionafterpublish(), MEDIUMWAIT);
	}

	/*
	 * Locator For list criteria
	 */
	private By listcriteria() {
		return By.id("UE_list_criteria_input");
	}

	/*
	 * Function to make type list criteria
	 */
	public void typelistcriteria(String txt) {
		safeClearAndType(listcriteria(), txt, MEDIUMWAIT);
	}
	/*
	 * Function to get color of input list criteria button
	 */
	public String getcoloroflistcriteria(){
		return driver.findElement(listcriteria()).getCssValue("color");	
	}

	/*
	 * Locator For list criteria after published list
	 */
	private By listcriteriaafterpublish() {
		return By.xpath("//div[@id='listDesc']/p/span[@class='criteria']");
	}

	/*
	 * Function to get text of my list description after published
	 */
	public String getTextlistcriteriaafterpublish() {
		return safeGetText(listcriteriaafterpublish(), MEDIUMWAIT);
	}
	/*
	 * Function to get color of list criteria after publish
	 */
	public String getcoloroflistcriteriaafterpublish(){
		return driver.findElement(listcriteriaafterpublish()).getCssValue("color");	
	}
	/*
	 */
	private By votingoption() {
		return By.id("UE_settings_vote_option");
	}

	/*
	 * Function to make click on voting option turn yes
	 */
	public void clickOnvotingoption() {
		safeJavaScriptClick(votingoption(), LONGWAIT);
	}

	/*
	 * Locator For voting show in list after published
	 */
	private By votingoptionafterpublish() {
		return By.xpath("//section[@id='mainListCnt']/ol/li[1]/div[@class='float vote']");
		// return By.xpath("");
	}

	/*
	 * function is used to present voting option show in list after published
	 */
	public boolean isPresentsvoteoption() {
		return isElementPresent(votingoptionafterpublish(), SHORTWAIT);
	}

	/*
	 * Locator For adding itmes in my list
	 */
	private By additmesinmylist() {
		return By.id("UE_settings_open_option");
	}

	/*
	 * Function to make click on voting option turn yes
	 */
	public void clickOnadditmesinmylist() {
		safeJavaScriptClick(additmesinmylist(), LONGWAIT);
		//waitForPageToLoad();
	}

	/*
	 * Locator For add items in mylist after published
	 */
	private By additmesinmylistafterpublish() {
		return By.xpath("//div[@id='UE_openSearch']/div[@class='wrap relative']");
		// return By.xpath("");
	}

	/*
	 * function is used to present add itmes in mylist after publish
	 */
	public boolean isPresentsmylist() {
		scrollIntoViewThroughJavaScriptExecuter(additmesinmylistafterpublish());
		return isElementPresent(additmesinmylistafterpublish(), SHORTWAIT);
	}

	/*
	 * Locator For rerank list
	 */
	private By reranklist() {
		return By.id("UE_settings_rerank_option");
	}

	/*
	 * Function to make click on rerank list turn yes or no.
	 */
	public void clickOnreranklist() {
		safeJavaScriptClick(reranklist(), LONGWAIT);
	}

	/*
	 * function is used to present rerank option
	 */
	public boolean isPresentsreranklist() {
		// scrollIntoViewThroughJavaScriptExecuter(additmesinmylistafterpublish());
		return isElementPresent(reranklist(), SHORTWAIT);
	}

	/*
	 * function is used to present rerank option button after publish
	 */
	public boolean isPresentsreranklistafterpublish() {
		// scrollIntoViewThroughJavaScriptExecuter(additmesinmylistafterpublish());
		return isElementPresent(reRankButton(), SHORTWAIT);
	}

	/*
	 * Locator For countdown list
	 */
	private By countdownlist() {
		return By.id("UE_settings_countdown_option");
	}

	/*
	 * Function to make click on countdown list turn yes
	 */
	public void clickOncountdownlist() {
		safeJavaScriptClick(countdownlist(), LONGWAIT);
	}

	/*
	 * Locator For get node number click count down option
	 */
	private By getnumberofnode() {
		//return By.xpath("//div[@id='siteBody']/article[@id='list']//div[@id='listBody']/section[@id='mainListCnt']/ol/li[1]/div[@class='float relative rank center']/span");
		return By.xpath("//div[@class='float relative rank center']/span");
		// return By.xpath("");
	}

	/*
	 * Function to get text of get node number click count down option turn no
	 */
	public String getnumberofnodebeforecountdown() {
		return safeGetText(getnumberofnode(), MEDIUMWAIT);
	}

	/*
	 * Locator For items number list
	 */
	private By itemnumberlist() {
		return By.id("UE_settings_numbers_option");
	}

	/*
	 * Function to make click on item number list turn no.
	 */
	public void clickOnitemnumberlist() {
		safeJavaScriptClick(itemnumberlist(), MEDIUMWAIT);
	}

	/*
	 * function is used to present rerank option button after publish
	 */
	public boolean isPresentsitemnumberlistafterpublish() {
		// scrollIntoViewThroughJavaScriptExecuter(additmesinmylistafterpublish());
		return isElementPresent(getnumberofnode(), SHORTWAIT);
	}

	/*
	 * Locator For item info in list
	 */
	private By iteminfolist() {
		return By.id("UE_settings_properties_option");
	}

	/*
	 * function is used to present item info option button
	 */
	public boolean isPresentsiteminfolist() {
		//scrollIntoViewThroughJavaScriptExecuter(iteminfolist());
		return isElementVisible(iteminfolist(), SHORTWAIT);
	}

	/*
	 * Function to make click on item number list turn no.
	 */
	public void clickOniteminfolist() {
		safeJavaScriptClick(iteminfolist(), MEDIUMWAIT);
	}

	/*
	 * Locator For get text info after pubished list
	 */
	private By getinfolist() {
		return By.xpath("//div[@class='blogText serif black']");
		// return By.xpath("");
	}

	/*
	 * Function to get text of my list description after published
	 */
	public String getTextiteminfolistafterpublish() {
		return safeGetText(getinfolist(), SHORTWAIT);
	}

	/*
	 * Locator For deletelist
	 */
	private By deletelist() {
		return By.xpath("//div[@id='UE_settings_delete']/span[@id='UE_settings_delete_btn']");
	}
	/*
	 * Locator For deletelist
	 */
	private By deleteButtonlast() {
		return By.xpath("//div[@id='UE_settings_advanced']/div[last()]");
	}
	/*
	 * function is used to present delete option in last
	 */
	public boolean isPresentdeleteButtonlast() {
		
		return isElementPresent(deleteButtonlast(), SHORTWAIT);
	}
	//div[@id='UE_settings_advanced']/div[last()]
	/*
	 * Function to make click on deletelist
	 */
	public void clickOndeletelist() {
		safeJavaScriptClick(deletelist(), MEDIUMWAIT);
		//waitForAlert(50);
	}
	/*
	 * Function to get text of deletelist
	 */
	public String getTextOfdeletelist() {
		return safeGetText(deletelist(), SHORTWAIT);
	}

	// UE_classSuggest_yes
	/*
	 * Locator For is list about as a film or music to button yes
	 */
	private By islistabout_yes() {
		return By.id("UE_classSuggest_yes");
	}

	/*
	 * Function to click on button yes is list about
	 */
	public void clickOnislistabout_yes() {
		safeJavaScriptClick(islistabout_yes(), MEDIUMWAIT);
	}

	/*
	 * Locator For add auto video
	 */
	private By addautovideo() {
		return By.id("UE_settings_videos_option");
	}

	/*
	 * Function to click on add auto video turn yes
	 */
	public void clickOnaddautovideo_yes() {
		safeJavaScriptClick(addautovideo(), MEDIUMWAIT);
	}

	/*
	 * Locator For video image check
	 */
	private By videoimage() {
		return By
				.xpath("//section[@id='mainListCnt']/ol/li[1]/div[@class='float relative img']//img");
	}

	/*
	 * function is used to present video image
	 */
	public boolean isPresentsvideoimage() {
		return isElementPresent(videoimage(), VERYLONGWAIT);
	}

	/*
	 * Locator For display addition info.(customize)
	 */
	private By displayProperty() {
	//	return By.id("UE_settings_infoTrigger_btn");
		return By.xpath("//div[@id='UE_settings_infoTrigger']/span[@id='UE_settings_infoTrigger_btn']");
	}

	/*
	 * Function to click on add auto video turn yes
	 */
	public void clickOndisplayProperty() {
		
		//System.out.println("com in");
		safeJavaScriptClick(displayProperty(), MEDIUMWAIT);
	}
	/*
	 * Function to get text of my list description after published
	 */
	public String getTextOfdisplayProperty() {
		return safeGetText(displayProperty(), SHORTWAIT);
	}
	/*
	 * Locator For default propert selction
	 */
	private By defaultProprty(int num,String opt) {
		System.out.println("11111111");
		if(opt.equalsIgnoreCase("radioBtn"))
			opt="//div[@id='UE_info_container_window']/ul/li[" + num + "]/span[@class='float relaive default center block']/input[@type='radio']";
		else //checkBox
			opt="//div[@id='UE_info_container_window']/ul/li[" + num + "]/span[@class='float relaive block display center']/input";
		return By.xpath(opt);
	}
	/*
	 * Function to check whether the check box of selected default property is clickable or not.
	 */
	public boolean isPropertyCheckBoxClickable(int num,String opt){
		return isElementClickable(defaultProprty(num,opt), MEDIUMWAIT);
	}
	/*
	 * Function to click on default propert selction
	 */
	public void clickOndefaultProprty(int num,String opt) {
		safeSelectRadioButton(defaultProprty(num,opt), SHORTWAIT);
	}
	/*
	 * Function to click on default propert selction
	 */
	public void clickOndefaultProprty1(int num,String opt) {
		safeSelectRadioButton(defaultProprty(num,opt), SHORTWAIT);
		//safeJavaScriptClick(defaultProprty(num,opt), SHORTWAIT);
	}
	/*
	 * Locator For default propert selction
	 */
	private By defaultProprtychange(int num) {
		return By.xpath("//div[@id='UE_info_container_window']/ul/li[@class='block width100'][" + num + "]/span[@class='float relative block name']");
	}
	/*
	 * Function to get text of default propert selction
	 */
	public String getTextOfdefaultProprtychange(int num) {
		return safeGetText(defaultProprtychange(num), SHORTWAIT);
	}
	/*
	 * Locator for toggeling button in add additional info to your items pop-up.
	 */
	private By additionalInfoToggle(){
		return By.xpath("//span[@id='UE_settings_properties_option']/span[@class='float absolute block txt white']");
	}
	/*
	 * Function to click on toggeling button in add additional info to your items pop-up.
	 */
	public void clickOnAdditionalInfoToggle(){
		safeClick(additionalInfoToggle(), MEDIUMWAIT);
	}
	/*
	 * Function to get text of toggeling button in add additional info to your items pop-up.
	 */
	public String getTextOfAdditionalInfoToggle(){
		return safeGetText(additionalInfoToggle(), MEDIUMWAIT);
	}

	/*
	 * Locator For default propert selction done button
	 */
	private By defaultProprtyDonebtn() {
		return By.xpath("//div[@id='UE_info_container_actions']//span[@class='relative inlineBlock btnBlue']");
	}

	/*
	 * Function to click on default propert selction done button
	 */
	public void clickOndefaultProprtyDonebtn() {
		safeSelectRadioButton(defaultProprtyDonebtn(), MEDIUMWAIT);
	}

	/*
	 * Locator For default propert selction done button
	 */
	private By default_proprty_afterpublish() {
		return By
				.xpath("//div[@id='siteBody']/article[@id='list']/div[@id='listBody']/section[@id='mainListCnt']/ol/li[1]/div[@class='relative name anClip']/p/span[@class='block grey data dataColumn']");
	}

	/*
	 * Function to get text of default propert after published
	 */
	public String getTextdefault_proprty_afterpublish() {

		return safeGetText(default_proprty_afterpublish(), SHORTWAIT);
	}


	/*
	 * Locator For display addition info.(custmize)
	 */
	private By enable_rating() {
		return By.id("UE_settings_ratings_option");
	}

	/*
	 * Function to click on rating turn yes
	 */
	public void clickOnenable_rating() {
		safeJavaScriptClick(enable_rating(), MEDIUMWAIT);
	}

	// ui-slider-handle ui-state-default ui-corner-all
	/*
	 * Locator For rating set
	 */
	private By rating_set() {
		////div[@class='relative width100 height100 chalkBg']/div[@class='clear UE_node_content']/div[@class='center UE_node_rating']/span[@class='inlineBlock box']/span[@class='block UE_node_rating_track ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']/a
		return By.xpath("//div[@class='relative width100 height100 chalkBg']/div[@class='clear UE_node_content']/div[@class='center UE_node_rating']/span[@class='inlineBlock box']/span/a");
	}

	/*
	 * Function to set the rating
	 */
	public void getsetOfRating(String value) {
		Actions moveAndDrop = new Actions(driver);
//		moveAndDrop.clickAndHold(driver.findElement(rating_set())).perform();
//		moveAndDrop.moveByOffset(50, 0).perform();
		moveAndDrop.clickAndHold(driver.findElement(rating_set())).moveByOffset(50, 0).release().build().perform();

	}

	/*
	 * Locator For rating set
	 */
	private By rating_value() {
		return By.xpath("//div[@class='clear UE_node_content']/div[@class='center UE_node_rating']/span[@class='inlineBlock white center UE_node_rating_value  green']/span[@class='inlineBlock value']");
		//return By.xpath("//div[@class='clear UE_node_content']/div[@class='center UE_node_rating']/span[@class='inlineBlock white center UE_node_rating_value green']/span[@class='inlineBlock value']");
	}

	/*
	 * Function to get rating.
	 */
	public String ratingofnode() {
		System.out.println("1aaaaaaaa");
		return safeGetText(rating_value(), LONGWAIT);
	}

	/*
	 * Function to click on rating VALUE
	 */
	public void clickOn_rating_value() {
		safeJavaScriptClick(rating_value(), MEDIUMWAIT);
	}

	// //div[@id='siteBody']/article[@id='list']//div[@id='listBody']/section[@id='mainListCnt']/ol/li[1]/div[@class='float
	// vote cunlock_hide_also ']/div"
	/*
	 * Locator For rating after publish
	 */
	private By rating_value_afterpublish() {
		return By
				.xpath("//section[@id='mainListCnt']/ol/li[1]/div[@class='relative name anClip']/p/em");
	}

	/*
	 * Function to get rating of node after publish.
	 */
	public String rating_afterpublish() {
		return safeGetText(rating_value_afterpublish(), LONGWAIT);
	}

	/*
	 * Locator For check publish list is open
	 */
	private By published_listcheck() {
		return By.xpath("//div[@id='siteBody']/article[@id='list']");
		// return By.xpath("");
	}

	/*
	 * function is used to present published list
	 */
	public boolean isPresenpublished_list() {
		return isElementPresent(published_listcheck(), VERYLONGWAIT);
	}

	/*
	 * Locator For search node.
	 */
	private By search_node(int linum) {// UE_suggestions_content
		return By
				.xpath("//div[@id='UE_search_content']/ul/li["
						+ linum
						+ "]/span[@class='float relative block name height100']//span[@class='node']");
	}

	/*
	 * Function to get text of search node.
	 */
	public String getTextofsearch_node(int num) {
		return safeGetText(search_node(num), MEDIUMWAIT);
	}

	/*
	 * Locator for vote buttons after publish.
	 */
	private By voting(int num, String vote) {
		if (vote.equalsIgnoreCase("up"))
			return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+ num+ "]/div[contains(@class,'float vote')]/div[@class='float relative']/span[contains(@class,'float relative block btnVote pointer up off')]/i");
			//return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+num+"]/div[contains(@class,'float vote')]//span");
			//return By.xpath("//section[@id='mainListCnt']/ol/li["+num+"]/div[contains(@class,'float vote cunlock_hide_also')]/div[1]/span[@class='float relative block btnVote pointer up off']/i");
		else
			// down
			return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+ num+ "]/div[contains(@class,'float vote')]/div[2]/span/i");
			//return By.xpath("//section[@id='mainListCnt']/ol/li["+num+"]/div[contains(@class,'float vote cunlock_hide_also')]/div[2]/span[@class='block relative block btnVote pointer down off']/i");
			//return By.xpath("//section[@id='mainListCnt']/ol/li["+ num+"]/div[contains(@class,'float vote cunlock_hide_also')]/div[2]/span[@class='block relative block btnVote pointer down off']/i");
	}

	/*
	 * Function to click on voting after publish.
	 */
	public void clickOnVoting(int num, String vote) {
		safeClick(voting(num, vote), MEDIUMWAIT);
	}

	/*
	 * Locator for list-node after publish.
	 */
	private By listNodeName(int num) {
		//return By.xpath("//section[@id='mainListCnt']/ol/li[" + num+ "]/div[contains(@class,'relative name')]/p/a/span");
	return By.xpath("//section[@id='mainListCnt']/ol/li["+num+"]/div[contains(@class,'relative name anClip')]/p/a/span");
	}
	/*
	 * Function to get text of name of list-node after publish.
	 */
	public String getTextOfListNodeNameAfterPublish(int num) {
		return safeGetText(listNodeName(num), SHORTWAIT);
	}
	 /*
		 * Function to click on listNodeName
		 */
		public void clickOnlistNodeName(int num) {
			safeJavaScriptClick(listNodeName(num), SHORTWAIT);
		}
		/*
		 * Locator for list-node after publish.
		 */
		private By listNodeNameofhref(int num) {
			return By.xpath("//section[@id='mainListCnt']/ol/li[" + num+ "]/div[contains(@class,'relative name')]/p/a");
		}
		/*
		  * Function to get href of list node name 
		  */
		 public String gethrefOfnodename(int num){
			 return driver.findElement(listNodeNameofhref(num)).getAttribute("href");
		 }
	
	/*
	 * Locator for 'Copy & view button' in UE settings.
	 */
	private By copy_viewbutton() {
		return By.id("UE_settings_copy_btn");
	}

	 /*
	 * Function to click on 'Copy & view' button in UE settings.
	 */
	public void clickOncopy_viewbutton() {
		safeClick(copy_viewbutton(), SHORTWAIT);
	}////div[@id='UE_content']/ol/*[1]/div[@class='relative width100 height100 rowWrapper']/div[@class='relative block name height100 move']/p/span[@class='txt']
	/*
	 * function is used to present 'Copy & view' button in UE settings.
	 */
	public boolean isPresentcopy_viewbutton() {
		return isElementPresent(copy_viewbutton(), VERYLONGWAIT);
	}

	
	/* 
	 * Locator for 'first node after publish.
	 */
	private By Publish_firstnode() {
		//return By.xpath("//div[@class='relative width100 expander expander2']/a");
		return By.xpath("//section[@id='mainListCnt']/ol/li[1]/div[contains(@class,'relative name')]/p/a/span[@itemprop='name']");
		//return By.xpath("//section[@id='mainListCnt']/ol/li[1]/div[@class='relative name authored exclude anClip']/p/span[@class='inlineBlock oNode']");
		//return By.xpath("//section[@id='mainListCnt']/ol/li[1]/div[@class='relative name authored exclude anClip']/p/span[@class='inlineBlock oNode']");
	}//
	private By PublishCopyfirstnode() {
		return By.xpath("//section[@id='mainListCnt']/ol/li[1]/div[contains(@class,'relative name anClip')]/p/a/span[@class='inlineBlock oNode']");
		//return By.xpath("//section[@id='mainListCnt']/ol/li[1]/div[@class='relative name authored exclude anClip']/p/span[@class='inlineBlock oNode']");
		//return By.xpath("//section[@id='mainListCnt']/ol/li[1]/div[@class='relative name authored exclude anClip']/p/span[@class='inlineBlock oNode']");
	}//
	/*
	 * Function to get text of name of list-node after publish.
	 */
	public String getTextOfcopy_firstnode() {
		return safeGetText(PublishCopyfirstnode(), SHORTWAIT);
	//	return safeGetTextThroughJS(Publish_firstnode());
	}
	/* 
	 * Locator for 'first node 
	 */
	private By firstnode() {
		return By.xpath("//div[@id='UE_content']/ol/li[1]/div[@class='relative width100 height100 rowWrapper']/div[contains(@class,'relative block name height100')]/p/span");
	}

	/*
	 * Function to get text of name of first list-node 
	 */
	 public String getTextOffirstnode(){
		 
		return safeGetText(firstnode(), SHORTWAIT);
	}
	 /*
		 * Locator for 'preview'
		 */
		private By preview() {
			return By.id("UE_list_preview");
		}

		/*
		 * Function to preview.
		 */
		public void clickOnpreview() {
			safeClick(preview(), LONGWAIT);
		}//ui-dialog ui-widget ui-widget-content ui-corner-all ui-front UE_listPreview
		/*
		 * Locator For listPreview is open
		 */
		private By listPreview() {
			return By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front UE_listPreview']");
			// return By.xpath("");
		}
		/*
		 * function is used to present published list
		 */
		public boolean isPresentlistPreview() {
			return isElementPresent(listPreview(), SHORTWAIT);
		}
		/*
		 * function is used to present published list
		 */
		public boolean isDisplaylistPreview() {
			return isElementDisplayed(listPreview());
		}
		/* 
		 * Locator for 'view of list as blog or slide show...after preview 
		 */
		private By viewlistmode_afterpreview() {
		//	WebElement frameele= 	driver.findElement(By.id("UE_listPreviewFrame"));
		
			
			return By.xpath("//div[@id='cmn_wrap']/div[@id='siteBody']/article[@id='list']/div[@id='listBody']/section[@id='mainListCnt']/ol/li[1]");
		}
		/*
		 * Function to get text of name of  list-node 
		 */
		 public String getTextOflistitem(){
			return safeGetText(viewlistmode_afterpreview(), SHORTWAIT);
		}
		/*
		 * Function to view list after preview
		 */
		    public boolean getTextOfviewlistmode_afterpreview() {
		    	driver.switchTo().frame(driver.findElement(By.id("UE_listPreviewFrame")));
			boolean value = driver.findElement(viewlistmode_afterpreview()).getAttribute("class").contains("grid");
			driver.switchTo().defaultContent();
			return value;
		}
		/* 
		 * Locator for 'view of list as blog or slide show... 
		 */
		private By viewlistmode() {
			return By.xpath("//div[@id='UE_settings_display']/span[@id='UE_settings_display_grid']");
		}
		 /*
		 * Function to click on 'Copy & view' button in UE settings.
		 */
		public void clickOnviewlistmode() {
			safeClick(viewlistmode(), SHORTWAIT);
		}
		/*
		 * Function to view list
		 */
		
		public boolean getTextOfviewlistmode() {
			return driver.findElement(viewlistmode()).getAttribute("id").contains("grid");
		}
		 /*
		 * Locator for 'cross' on preview
		 */
		private By cross() {
			return By.xpath("//div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']/i");
		}
		/* Locator for 'cross' on preview
		 */
		private By crosspopup() {
			return By.xpath("//div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']");
		}
		/*
		 * Function to cross.
		 */
		public void clickOncrosspopup() {
			safeJavaScriptClick(crosspopup(), SHORTWAIT);
		}//
		/*
		 * Function to cross.
		 */
		public void clickOncross() {
			safeClick(cross(), SHORTWAIT);
		}//
		 /*
		 * Locator for 'facebook
		 */
		private By facebook() {
			return By.id("signupDialog_facebook");
		}
		/*
		 * Function to facebook.
		 */
		public void clickOnfacebook() {
			safeClick(facebook(), SHORTWAIT);
		}
		/*
		 * Locator for 'facebook
		 */
		private By facebooksignin() {
			return By.id("loginDialog_facebook");
		}
		/*
		 * Function to facebook.
		 */
		public void clickOnfacebooksignin() {
			safeClick(facebooksignin(), SHORTWAIT);
		}
		/*
		 * Locator for 'twitter
		 */
		private By twitter() {
			return By.id("signupDialog_twitter");
		}
		/*
		 * Locator for 'twitter
		 */
		private By twittersignin() {
			return By.xpath("//div[@class='float relative authSocialBtns width60']/span[@id='loginDialog_twitter']");
			//return By.id("loginDialog_twitter");
		}
		
		/*
		 * Function to twitter.
		 */
		public void clickOntwittersignin() {
			safeClick(twittersignin(), SHORTWAIT);
		}
		/*
		 * Function to twitter.
		 */
		public void clickOntwitter() {
			safeClick(twitter(), SHORTWAIT);
		}
		/*
		 * Locator for 'google
		 */
		private By email() {
			return By.id("authMailBtn");
		}
		/*
		 * Function to google.
		 */
		public void clickOnemail() {
			safeClick(email(), SHORTWAIT);
		}
		/*
		 * Locator for 'sign in
		 */
		private By signin() {
			return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']/header[@id='welcome']/p[@class='signUpSubHead grey center switch']/a[@class='signup rnkrBlue']");
		}
		/*
		 * Function to signin.
		 */
		public void clickOnsignin() {
			safeJavaScriptClick(signin(), SHORTWAIT);
		}
		/*
		 * Locator for 'google
		 */
		private By google() {
			return By.id("signupDialog_google");
		}
		/*
		 * Function to google.
		 */
		public void clickOngoogle() {
			safeClick(google(), SHORTWAIT);
		}
		/*
		 * Locator for 'google
		 */
		private By googlesignin() {
			return By.id("loginDialog_google");
		}
		/*
		 * Function to google.
		 */
		public void clickOngooglesignin() {
			safeClick(googlesignin(), SHORTWAIT);
		}
		/*
		 * Locator For voting show in list after published
		 */
		private By listafterpublisedonprofile() {
			return By.xpath("//div[@class='rankrank']/ol/li[1]/h3/a");
			
		}

		/*
		 * function is used to present voting option show in list after published
		 */
		public boolean isPresentlistafterpublisedonprofile() {
			return isElementPresent(listafterpublisedonprofile(), SHORTWAIT);
		}
		/*
		 * Locator For external link
		 */
		private By extenallink() {
			return By.xpath("//div[@class='float relative nameContainer']/input[contains(@class,'inlineBlock pointer addExternalLink ')]");
				}
		/*
		 * Locator For 
		 */
		private By extenallinkdropdown() {
			return By.xpath("//div[@class='float relative nameContainer']/select[@class='addExternalLinkType']");
				}
		/*
		 * Function to external link dropdown
		 */
		public void clickOnextenallinkdropdown() {
			safeClick(extenallinkdropdown(), SHORTWAIT);
		}
		/*
		 * function is used to present external link dropdown
		 */
		public boolean isPresentextenallinkdropdown() {
			return isElementPresent(extenallinkdropdown(), SHORTWAIT);
		}
		/*
		 * Locator For external link dropdown in option 
		 */
		private By extenallinkdropdownoption(int num) {
			return By.xpath("//div[@class='float relative nameContainer']/select[@class='addExternalLinkType']/option["+num+"]");
				}
		/*
		 * function is used to present external link dropdown
		 */
		public boolean isPresenextenallinkdropdownoption(int num) {
			return isElementPresent(extenallinkdropdownoption(num), SHORTWAIT);
		}
		/*
		 * Function to  click external link
		 */
		public void clickOnextenallink() {
			safeClick(extenallink(), SHORTWAIT);
		}
		 /*
		 * Function to type on extenallink
		 */
		public void putTextInextenallink(String txt){
			safeClearAndType(extenallink(), txt, SHORTWAIT);
		}
		/*
		 * Function to  click firestnode after publish
		 */
		public void clickOnfirstnodeafterpublish() {
			safeJavaScriptClick(Publish_firstnode(), SHORTWAIT);
		}
		/*
		 * Function to get text of particular section in most tweeted. 
		 */
		public String getValueOfexternallink(){
			return driver.findElement(extenallink()).getAttribute("value");
		}
		/*
		 * Locator for blatherinblogview after publish.
		 */
		private By blatherinblogview() {
			return By.xpath("//section[@id='mainListCnt']/ol/*[1]/div[@class='float relative clear img']/div[@class='blogText serif black']/p");
			
		}
		/*
		 * Function to get text of added node after publish.
		 */
		public String getTextOfblatherinblogview() {
			return safeGetText(blatherinblogview(), SHORTWAIT);
		}
		
		public void clickCreateListAndAdd3Items() {
			NavBar navBar= new NavBar(driver);
			
			navBar.hoverMore();
			clickOncreateList();
			clickOnreranking();
//			 if(isStickyPresent()==true){
//			 clickStickyOK();
//			 }
			clickOnListName();
			putTextOnListNameBox("Testing List");
			clickOnSearch();
			typesearchbtn("Batman");
			for (int i = 1; i <= 5; i++) {
				clickOnPlusIcon(i);
			}
		}
		/*
		 * Locator for edit all icon.
		 */
		private By editAllIcon(){
			return By.xpath("//div[@id='UE_nav_editAll']/i");
		}
		/*
		 * Function to click on edit all icon.
		 */
		public void clickOnEditAllIcon(){
			safeJavaScriptClick(editAllIcon(), MEDIUMWAIT);
		}
		/*
		 * Locator for all node numbers in the edit overlay.
		 */
		private By nodeNumInEditOverlay(int num,int value){
			return By.xpath("//div[@id='UE_node_container']//div[@class='relative UE_node_header']["+num+"]/input[@value="+value+"]");
		}
		/*
		 * Function to check the presence of added node in edit overlay.
		 */
		public boolean isNodeInEditOverlayPresent(int num,int value){
			return isElementPresent(nodeNumInEditOverlay(num,value), MEDIUMWAIT);
		}
		/*
		 * Function to get color of done button
		 */
		public String getcolorofdonebtn(){
			return driver.findElement(donetbtn()).getCssValue("color");	
		}
		/*
		 * Function to get background color of done button
		 */
		public String getbackgrouncolorofdonebtn(){
			return driver.findElement(donetbtn()).getCssValue("background-color");	
		}
		/*
		 * Locator for all node numbers in the edit overlay.
		 */
		private By nodeNumInEditblather(int num){
			return By.xpath("//div[@class='relative UE_node_header']["+num+"]/div[@class='float absolute center chalkBg UE_node_nav']/div[@class='inlineBlock center item pointer on']/span/i");
			//return By.xpath("//div[@id='UE_node_container']//div[@class='relative UE_node_header']["+num+"]/input[@value="+value+"]/div[@class='float absolute center chalkBg UE_node_nav']/div[@class='inlineBlock center item pointer']/span/i");
		}
		/*
		 * Function to click on edit all icon.
		 */
		public void clickOnEditAllblather(int num){
			safeClick(nodeNumInEditblather(num), MEDIUMWAIT);
		}
		/*
		 * Locator for comment box in edit my item.
		 */
		private By commentBoxInEditall( int num) {
			return By.xpath("//div[contains(@class,'UE_node_content')]["+num+"]/div[@class='relative editable visible']/div");
		}
		/*
		 * Function to type text in comment box in edit my item.
		 */
		public void typeIncommentBoxInEditall(String txt,int num) {
			safeClick(commentBoxInEditall(num), MEDIUMWAIT);
			safeClearAndType(commentBoxInEditall(num), txt, MEDIUMWAIT);
		}
		/*
		 * Locator for node blather in UE.
		 */
		private By allnodeBlather(int num) {
			return By.xpath("//div[@id='UE_content']/ol/li["+num+"]/div[@class='relative width100 height100 rowWrapper']/div[@class='relative block name height100 move']/p/em");
		}
		/*
		 * Function to get text of node blather in UE.
		 */
		public String getTextOfAllNodeBlather(int num) {
			return safeGetText(allnodeBlather(num), MEDIUMWAIT);
		}
		/*
		 * Locator for all node numbers in the edit overlay.
		 */
		private By nodeNumInEditImage(int num){
			return By.xpath("//div[@class='relative UE_node_header']["+num+"]/div[@class='float absolute center chalkBg UE_node_nav']/div[@class='inlineBlock center item pointer']/span/i");
			////div[@class='relative UE_node_header'][1]/div[@class='float absolute center chalkBg UE_node_nav']/div[@class='inlineBlock center item pointer'][2]/span/i
		}
		/*
		 * Function to click on edit all icon.
		 */
		public void clickOnEditAllImage(int num){
			safeClick(nodeNumInEditImage(num), MEDIUMWAIT);
		}
		/*
		 * Locator For adding node image from various image options in edit.
		 */
		private By imageaddallnode(int linum, int num) {
			return By.xpath("//div[contains(@class,'UE_node_content')]["+num+"]/ul/li[" + linum + "]/img");
		}
		/*
		 * Function to get attribute of node image.
		 */
		public String getsrcimageallnode(int num,int num1) {
			return driver.findElement(imageaddallnode(num, num1)).getAttribute("src");
		}

		
		/*
		 * Locator for all node numbers in the edit overlay.
		 */
		private By nodeNumInEditViedo(int num){
			return By.xpath("//div[@class='relative UE_node_header'][1]/div[@class='float absolute center chalkBg UE_node_nav']/div[@class='inlineBlock center item pointer'][2]/span/i");
		}
		/*
		 * Function to click on edit all icon.
		 */
		public void clickOnnodeNumInEditViedo(int num){
			safeClick(nodeNumInEditViedo(num), MEDIUMWAIT);
		}
		/*
		 * Locator for all node numbers in the edit overlay.
		 */
		private By nodeNumInEditInfo(int num){
			return By.xpath("//div[@class='relative UE_node_header'][1]/div[@class='float absolute center chalkBg UE_node_nav']/div[@class='inlineBlock center item pointer'][3]/span/i");
		}
		/*
		 * Function to click on edit all icon.
		 */
		public void clickOnnodeNumInEditInfo(int num){
			safeClick(nodeNumInEditInfo(num), MEDIUMWAIT);
		}
		/*
		 * Locator for reset tab in admin bar
		 */
		private By adminsubstat() {
		return By.id("adminOptions");
		}
		/*
		 * Function to click on 'reset tab' in admin bar.
		 */
		public void clickOnadminsubstat() {
			safeClick(adminsubstat(), MEDIUMWAIT);
		}
		/*
		 * Locator for main image
		 */
		private By listimage() {
		return By.id("listImgTarget");
		}
		/*
		 * Function to get attribute of main image.
		 */
		public String getsrclistimage() {
			return driver.findElement(listimage()).getAttribute("src");
		}
		/*
		 * Locator for selectparameter by dropdown
		 */ 
		 private By selectdropdownproperty( ){
			 return By.xpath("//div[@id='showDataColumn']/select[@role='listbox']");
		 }
		 /*
			 * Locator for selectparameter by dropdown
			 */ 
			 private By selectdropdownpropertyoption( ){
				 return By.xpath("//div[@id='showDataColumn']/select[@role='listbox']/option[1]");
			 }
		    /*
			 * Function to get text of select dropdown property
			 */
			public String getTextOfselectdropdownpropertyoption() {
				return safeGetText(selectdropdownproperty(), MEDIUMWAIT);
			}
			/*
			 * Function to click on 'selectparameter by dropdown
			 */
			public void clickOnselectparameterbydropdown() {
				safeClick(selectdropdownproperty(), MEDIUMWAIT);
			}
			
			/*
			 * Locator for change button wiki to yes
			 */
			private By wikitextoption() {
			return By.id("UE_settings_wikitext_option");
			}
			/*
			 * Function to click change button wiki to yes
			 */
			public void clickOnwikitextoption() {
				safeClick(wikitextoption(), MEDIUMWAIT);
			}
			/*
			 * Locator for change button rerank to yes
			 */
			private By wikitoption() {
			return By.xpath("//div[@class='relative group noWrap']/span[@id='UE_settings_wikitext_option']//span[@class='float absolute block txt white']");
			}
			/*
			 * Function to get text of change button rerank
			 */
			public String getTextOfwikitoption() {
				return safeGetText(wikitoption(), MEDIUMWAIT);
			}
			/*
			 * Locator for change button rerank to yes
			 */
			private By reranktoption() {
			return By.id("UE_settings_rankedon_option");
			}
			/*
			 * Function to click change button wiki to yes
			 */
			public void clickOnreranktoption() {
				safeClick(reranktoption(), MEDIUMWAIT);
			}
			
			/*
			 * Locator for change button rerank to yes
			 */
			private By reranktextoption() {
			return By.xpath("//div[@class='relative group noWrap']/span[@id='UE_settings_rankedon_option']//span[@class='float absolute block txt white']");
			}
			/*
			 * Function to click change button rerank to yes
			 */
			public void clickOnreranktextoption() {
				safeClick(reranktextoption(), MEDIUMWAIT);
			}
			  /*
			 * Function to get text of change button rerank
			 */
			public String getTextOfreranktextoption() {
				return safeGetText(reranktextoption(), MEDIUMWAIT);
			}
			/*
			 * Locator for wiki  text
			 */
			private By wikitext(int number){
				return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+number+"]/div[@class='float relative clear img']/div[@class='blogText serif black']/em");
			}
			/*
			 * Function to get text of change button rerank
			 */
			public String getTextOfwikitext(int num) {
				return safeGetText(wikitext(num), MEDIUMWAIT);
			}
			/*
			 * Locator for change yes to center blog image option
			 */
			private By blogcenterimage() {
				return By.id("UE_settings_largeimages_option");
			}
			/*
			 * Function to google.
			 */
			public void clickOnblogcenterimage() {
				safeClick(blogcenterimage(), SHORTWAIT);
			}
			/*
			 * Locator for center image on blog list after publish
			 */
			private By centerblogimageafterpublish(int number){
				return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+number+"]/div[@class='float relative clear img']/div[@class='center largeImages relative']//img");
			}
			/*
			 * Function to get image is allign center of node blather in UE.
			 */
			public String gettextalignofBlogImage(int number) {
				return driver.findElement(centerblogimageafterpublish(number)).getCssValue("text-align");
				
			}
			/*
			 * Locator for signup popup is center
			 */
			private By signuppopupalign(){
				return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']/header[@id='welcome']/h1");
				//return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+number+"]/div[@class='float relative clear img']/div[@class='center largeImages relative']//img");
			}
			/*
			 * Function to signup image is allign center 
			 */
			public String gettextsignuppopupalign() {
				return driver.findElement(signuppopupalign()).getCssValue("text-align");
				
			}
			
			
}
