package com.pageobjects.grid;

import java.io.File;
import java.io.InputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dataprovider.ConfigManager;
import com.selenium.SafeActions;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class Grid extends SafeActions {
	private WebDriver driver;

	public Grid(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/*
	 * Locator for Node text.
	 */
	private By nodeText(int nodeNumber) {
		return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+nodeNumber+"]/div[contains(@class,'relative name')]/p//span[@class='inlineBlock oNode']");
		//return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["+ nodeNumber	+ "]/div[contains(@class,'relative name')]//span[@class=='inlineBlock oNode']");
	}

	/*
	 * Function is used to get text of node.
	 */
	public String getNodeText(int nodeNumber) {
		return safeGetText(nodeText(nodeNumber), VERYLONGWAIT);
	}

	/*
	 * This function is used to click on Node text.
	 */
	public void clickNodeText(int nodeNumber) {
		safeJavaScriptClick(nodeText(nodeNumber), VERYLONGWAIT);
		waitForPageToLoad();
	}

	/*
	 * This function is used to get font size of text.
	 */
	public String getNodeTextFontSize(int nodeNumber) {
		return driver.findElement(nodeText(nodeNumber))
				.getCssValue("font-size");
	}

	/*
	 * This function is used to get color of text.
	 */
	public String getNodeTextColor(int nodeNumber) {
		return driver.findElement(nodeText(nodeNumber)).getCssValue("color");
	}

	/*
	 * This function is used to get font style of text.
	 */
	public String getNodeTextFontStyle(int nodeNumber) {
		return driver.findElement(nodeText(nodeNumber)).getCssValue(
				"font-style");
	}

	/*
	 * This function is used to get font family of text.
	 */
	public String getNodeTextFontFamily(int nodeNumber) {
		return driver.findElement(nodeText(nodeNumber)).getCssValue(
				"font-family");
	}

	/*
	 * Mouse hover on node text.
	 */
	public void mouseHoverNodeText(int nodeNumber) {
		mouseHover(nodeText(nodeNumber), SHORTWAIT);
		waitForElementVisible((nodeText(nodeNumber)), 30);
	}

	/*
	 * Locator for node image.
	 */
	private By nodeImage(int nodeNumber) {
		return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["+ nodeNumber+ "]/div[contains(@class,'float relative img')]//img");
		//return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["+ nodeNumber+ "]/div[contains(@class,'relative name')]/p//span");
	}

	/*
	 * This function is used to get outer border of image.
	 */
	public String getNodeImageOuterBorder(int nodeNumber) {return driver.findElement(nodeImage(nodeNumber)).getCssValue("margin-top");
	}

	/*
	 * This function is used to get inner border of image.
	 */
	public String getNodeImageInnerBorder(int nodeNumber) {
		return driver.findElement(nodeImage(nodeNumber)).getCssValue("z-index");
	}

	/*
	 * This function is used to get image border color.
	 */
	public String getNodeImageColor(String nodeNumber, String borderSide) {
		//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["+ nodeNumber+ "]/div[contains(@class,'relative name')]/p//span
		return driver.findElement(By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["+ nodeNumber+ "]/div[contains(@class,'float relative img')]//img")).getCssValue(borderSide);
		//return driver.findElement(By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["+ nodeNumber+ "]/div[contains(@class,'relative name')]/p//span")).getCssValue(borderSide);
	}

	/*
	 * Function to get src of node image.
	 */
	public String getSrcOfNodeImage(int nodeNumber) {
		return driver.findElement(nodeImage(nodeNumber)).getAttribute("src");
	}

	/*
	 * Locator for magnify glasses on image.
	 */
	private By magnifyingGlass(String nodeNumber) {
		return By
				.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["+nodeNumber+"]/div[contains(@class,'float relative img')]//span[@class='float absolute viewHint ui-state-hover']/span");
	}

	// Check the presence of magnifying glass on image.
	public boolean isMagnifyingGlassPresent(String nodeNumber) {
		return isElementPresent(magnifyingGlass(nodeNumber), VERYLONGWAIT);
	}
	/*
	 * Function for autoloading.
	 */
	public void autoloadingnodename(int number) {
		//System.out.println("aaaaa");
		scrollIntoViewThroughJavaScriptExecuter(nodeImage(number));
		// waitForElementVisible(cascaddinglist(number),40);
	}
	/*
	 * This function is used to mouse hover on node image.
	 */
	public void mouseHoverNodeImage(int nodeNumber) {
		//System.out.println("1111111111111111aaaaaaaaabbbb");
		mouseHover(nodeImage(nodeNumber), VERYLONGWAIT);
	}

	/*
	 * This function is used to get back color of row.
	 */
	public String getNodeRowBackColor(String nodeNumber) {
		return driver.findElement(node(nodeNumber)).getCssValue(
				"background-color");
	}

	/*
	 * This function is used to mouse hover on node row.
	 */
	public void mouseHoverNodeRow(String nodeNumber) {
		mouseHover(node(nodeNumber), VERYLONGWAIT);
	}

	/*
	 * This function is used to get width of image.
	 */
	public String getNodeImagewidth(String nodeNumber) {
		return driver.findElement(
				By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
						+ nodeNumber
						+ "]/div[contains(@class,'float relative img')]"))
				.getCssValue("width");
	}

	/*
	 * This function is used to get height of image.
	 */
	public String getNodeImageheight(String nodeNumber) {
		return driver.findElement(
				By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
						+ nodeNumber
						+ "]/div[contains(@class,'float relative img')]"))
				.getCssValue("height");
	}

	/*
	 * Function is used to click on node image.
	 */
	public void clickNodeImage(int nodeNumber) {
		safeJavaScriptClick(nodeImage(nodeNumber), MEDIUMWAIT);
	}

	/*
	 * Locator for image header.
	 */
	private By imageHeadder() {
		return By
				.xpath("//article[@id='image']/header[@id='imageHead']/span[@class='titleBlock float relative block']");
	}

	/*
	 * Function is used to get text of image header.
	 */
	public String getImageHeader() {
		return safeGetText(imageHeadder(), VERYLONGWAIT);
	}

	/*
	 * Locator for header.
	 */
	private By textHeaderForNode() {
		return By
				.xpath("//div[@id='nodeDesc']//h1[contains(@class,'heading')]");
	}

	/*
	 * Function is used to get text of header.
	 */
	public String getTextHeaderForNode() {
		return safeGetText(textHeaderForNode(), VERYLONGWAIT);
	}

	/*
	 * Locator for header.
	 */
	private By textHeaderForList() {
		return By
				.xpath("//div[@id='listDesc']/h1[@class='width100']/span[contains(@class,'name')]");
	}

	/*
	 * Function is used to get text of header.
	 */
	public String getTextHeaderForList() {
		return safeGetText(textHeaderForList(), VERYLONGWAIT);
	}

	/*
	 * Locator for upvote text.
	 */
	private By upvoteText(String nodeNumber) {
		return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+ nodeNumber+ "]/div[contains(@class,'float vote')]/div[@class='float relative']//span[contains(@class,'float clearLeft numVote grey center up')]");
		//return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["+ nodeNumber+ "]/div[contains(@class,'float vote cunlock_hide_also')]//span[contains(@class,'float clearLeft numVote grey center up')]");
	}

	/*
	 * This function is used for get upvote text.
	 */
	public String getUpvoteText(String nodeNumber) {
		return safeGetText(upvoteText(nodeNumber), VERYLONGWAIT);
	}

	/*
	 * Locator for upvote button.
	 */
	private By upvote(String nodeNumber) {
		return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+nodeNumber+"]/div[contains(@class,'float vote')]/div[@class='float relative']/span[contains(@role,'button')]/i");
		//return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+ nodeNumber+ "]/div[contains(@class,'float vote')]/div[@class='float relative']/span[contains(@class,'float relative block btnVote pointer up off')]/i");
	}

	/*
	 * This function is used to click on upvote button.
	 */
	public void clickUpvote(String nodeNumber) {
		safeJavaScriptClick(upvote(nodeNumber), VERYLONGWAIT);
		// safeClick(upvote(nodeNumber), VERYLONGWAIT);
	}

	/*
	 * Locator for down vote text.
	 */
	private By downvoteText(String nodeNumber) {
		return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+ nodeNumber+ "]/div[contains(@class,'float vote')]//span[contains(@class,'block numVote grey center down')]");
		//return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["+ nodeNumber+ "]/div[contains(@class,'float vote cunlock_hide_also')]//span[contains(@class,'block numVote grey center down')]");
	}

	/*
	 * This function is used to get downvote text.
	 */
	public String getDownvoteText(String nodeNumber) {
		return safeGetText(downvoteText(nodeNumber), VERYLONGWAIT);
	}

	/*
	 * Locator for down vote button.
	 */
	private By downvote(String nodeNumber) {
		return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+ nodeNumber+ "]/div[contains(@class,'float vote')]/div[2]/span");
		//return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["+ nodeNumber+ "]/div[contains(@class,'float vote cunlock_hide_also')]/div[2]/span");
		// return
		// By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["+nodeNumber+"]/div[contains(@class,'float vote cunlock_hide_also')]//span[contains(@class,'block numVote grey center down']");//sapn
	}

	/*
	 * This function is used to click on downvote button.
	 */
	public void clickDownvote(String nodeNumber) {
		safeJavaScriptClick(downvote(nodeNumber), VERYLONGWAIT);
	}

	/*
	 * Locator for Ultimate text.
	 */
	private By ultimateTxt() {
		return By
				.xpath("//div[@id='listData']//span[@class='inlineBlock txt']");
	}

	/*
	 * This function is used to get text ultimate list.
	 */
	public String getUltimateTxt() {
		return safeGetText(ultimateTxt(), VERYLONGWAIT);
	}

	/*
	 * This function to get font style of ultimate text.
	 */
	public String getFontStyleUltimateList() {
		isElementVisible(ultimateTxt(), VERYLONGWAIT);
		return driver.findElement(ultimateTxt()).getCssValue("font-style");
	}

	/*
	 * Locator for node badges.
	 */
	private By nodeBadgesTxt(String subString, String nodename) {
		return By.xpath("//span[contains(text(),'" + subString
				+ "')]/..//preceding-sibling::*[" + nodename + "]");
	}

	/*
	 * This function to get text of node badges.
	 */
	public String getNodeBadgesTxt(String subString, String num) {
		return safeGetText(nodeBadgesTxt(subString, num), VERYLONGWAIT);
	}

	/*
	 * This function to get font style of node badges.
	 */
	public String getFontStyleNodeBadges(String subString, String num) {
		isElementVisible(nodeBadgesTxt(subString, num), VERYLONGWAIT);
		return driver.findElement(nodeBadgesTxt(subString, num)).getCssValue(
				"font-style");
	}

	/*
	 * This function is used to click on node badges.
	 */
	public void clickNodeBadges(String subString, String num) {
		safeJavaScriptClick(nodeBadgesTxt(subString, num), MEDIUMWAIT);
		waitForPageToLoad();
	}

	/*
	 * Locator for peoples pop-up text.
	 */
	private By popupThePeoples() {
		return By.xpath("//div[@id='listBadgeSticky_The_People']");
	}

	// Check the presence of people pop up.
	public boolean isThePeoplePopupPresent() {
		return isElementPresent(popupThePeoples(), VERYLONGWAIT);
	}

	/*
	 * Locator of people popup.
	 */
	private By textOfPeoplePopup() {
		return By
				.xpath("//div[@id='listBadgeSticky_The_People']/span[@class='block text black']");
		// return
		// By.xpath("//div[@id='listBadgeSticky_The_People']/span[@class='block text grey']");
		// //block title lowercase black
	}

	/*
	 * This function is used to get text of people popup.
	 */
	public String getTextOfPeoplePopup() {
		return safeGetText(textOfPeoplePopup(), VERYLONGWAIT);
	}

	/*
	 * Locator for close people popup.
	 */
	private By closePeoplePopuplocator() {
		return By
				.xpath("//div[@id='listBadgeSticky_The_People']/p/span[@class='inlineBlock btnDBlue']");
	}

	/*
	 * This function is used to close the popup.
	 */
	public void closePeoplePopup() {
		safeJavaScriptClick(closePeoplePopuplocator(), VERYLONGWAIT);
	}

	/*
	 * Locator for added by.
	 */
	private By addedByForClick(String subString, String nodename) {
		return By.xpath("//span[contains(text(),'" + subString
				+ "')]/..//preceding-sibling::*[" + nodename + "]/span");
	}

	/*
	 * This function is used to click on added by.
	 */
	public void clickAddedBy(String subString, String nodeBadgeNumber) {
		safeJavaScriptClick(addedByForClick(subString, nodeBadgeNumber),
				VERYLONGWAIT);
	}

	/*
	 * Locator for header of added by user page.
	 */
	private By textForAddedByUser() {
		return By
				.xpath("//header[@id='userHead']/div[@id='userBio']/h1[@role='heading']");
	}

	/*
	 * This function is used for get header for Added by user page.
	 */
	public String getTextForAddedByUserPage() {
		return safeGetTextThroughJS(textForAddedByUser());
	}

	/*
	 * Locator for node score.
	 */
	private By nodeScore(String nodeNumber) {
		return By
				.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
						+ nodeNumber
						+ "]/div[contains(@class,'float absolute block scoreCircle large scoreCircleClosed center pointer')]/div[@class='relative inlineBlock pieChart']");
	}

	/*
	 * This function is used to click on node score.
	 */
	public void clickNodeScore(String nodeNumber) {
		safeJavaScriptClick(nodeScore(nodeNumber), SHORTWAIT);
	}

	/*
	 * Locator for score explain.
	 */
	private By scoreExplain(String nodeNumber) {
		return By
				.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
						+ nodeNumber
						+ "]/div[contains(@class,'float absolute scoreHover pointer')]/div[@class='float block scoreExplainCntr']");
	}

	/*
	 * This function is used to check presence of score explain.
	 */
	public boolean isScoreExplainPresent(String nodeNumber) {
		return isElementPresent(scoreExplain(nodeNumber), SHORTWAIT);
	}

	/*
	 * Locator for score voted up.
	 */
	private By scoreVotedUp(String nodeNumber) {
		return By
				.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
						+ nodeNumber
						+ "]/div[contains(@class,'float absolute scoreHover pointer')]//div[@class='float block relative center scoreVotedUp']");
	}

	/*
	 * This function is used to checl presence of score voted up.
	 */
	public boolean isScoreVotedUpPresent(String nodeNumber) {
		return isElementPresent(scoreVotedUp(nodeNumber), SHORTWAIT);
	}

	/*
	 * Locator for score listed it.
	 */
	private By scoreListedIt(String nodeNumber) {
		return By
				.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
						+ nodeNumber
						+ "]/div[contains(@class,'float absolute scoreHover pointer')]//div[@class='float block relative center scoreListed']");
	}

	/*
	 * This function is used to check presence of score listed it.
	 */
	public boolean isScoreListedItPresent(String nodeNumber) {
		return isElementPresent(scoreListedIt(nodeNumber), SHORTWAIT);
	}

	/*
	 * Locator for score ranked high.
	 */
	private By scoreRankedHigh(String nodeNumber) {
		return By
				.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
						+ nodeNumber
						+ "]/div[contains(@class,'float absolute scoreHover pointer')]//div[@class='float block relative center scoreRanked']");
	}

	/*
	 * This function is used to check presence of score ranked high.
	 */
	public boolean isScoreRankedHighPresent(String nodeNumber) {
		return isElementPresent(scoreRankedHigh(nodeNumber), SHORTWAIT);
	}

	/*
	 * Locator for the close facebook like popup.
	 */
	private By facebookLike() {
		return By
				.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front followDialog2']//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close']");
	}

	/*
	 * Function to check presence of facebook like page.
	 */
	public boolean isfacebookLikePresent() {
		return isElementPresent(facebookLike(), SHORTWAIT);
	}

	/*
	 * This function is used to close facebook like popup.
	 */
	public void clickFacebookLike() {
		safeClick(facebookLike(), SHORTWAIT);
	}

	/*
	 * Locator for the node position.
	 */
	private By locationForOpen(String nodeNumber) {
		return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
				+ nodeNumber + "]/div[contains(@class,'relative name')]");
	}

	/*
	 * This function is to get the position of the node.
	 */
	public Point getLocationToOpen(String nodeNumber) {
		return driver.findElement(locationForOpen(nodeNumber)).getLocation();
	}

	/*
	 * Locator for open button.
	 */
	private By openButton(String nodeNumber) {
		return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
				+ nodeNumber + "]/span[@title='Expand']");
	}

	/*
	 * This function is used to click on open button exists when mouse hover on
	 * the node. An autoit script is used for moving mouse physically on the
	 * node.
	 */
	public void clickOnOpenButton(int nodeNumber) {
		// safeClick(openButton(nodeNumber), VERYLONGWAIT);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		scrollIntoViewThroughJavaScriptExecuter(By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
						+ (nodeNumber-1) + "]"));
		mouseHover(
				By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
						+ nodeNumber + "]"), MEDIUMWAIT);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(openButton(nodeNumber + "")));
		// waitForPageToLoad();
		// WaitForPageToLoad;
		// driver.findElement(openButton(nodeNumber+"")).click();
	}

	/*
	 * Locator for the description of node.
	 */
	private By descriptionOfNode(String nodeNumber) {
		return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+ nodeNumber+ "]/div[contains(@class,'relative width100 expander')]/em[@class='relative block serif grey wikiText']");
		//return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["+ nodeNumber+ "]/div[contains(@class,'relative width100 expander expander')]/em[@class='relative block serif grey wikiText']");
	}

	/*
	 * This function is used to get description of node.
	 */
	public String getDescriptionOfNode(String nodeNumber) {
		return safeGetText(descriptionOfNode(nodeNumber), SHORTWAIT);
	}

	/*
	  * Locator for wiki scrape more.
	  */
	 private By wikiScrapeMore(String nodeNumber) {
	  return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["+ nodeNumber+ "]/div[contains(@class,'relative width100 expander')]/a[@class='inlineBlock moreLink']");
	 }

	/*
	 * This function is used to click on wiki scrape more.
	 */
	public void clickOnWikiScrapeMore(String nodeNumber) {
		safeClick(wikiScrapeMore(nodeNumber), SHORTWAIT);
		//waitForPageToLoad();
	}

	/*
	 * Locator for also ranked text.
	 */
	private By alsoRanked(String nodeNumber) {
		return By
				.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
						+ nodeNumber
						+ "]/div[contains(@class,'relative width100 expander')]/div[@class='relative rankedOn']/span[@class='float relative block item']");
	}

	/*
	 * This function is used to check presence of Also Ranked text.
	 */
	public boolean isAlsoRankedPresent(String nodeNumber) {
		return isElementPresent(alsoRanked(nodeNumber), MEDIUMWAIT);
	}

	/*
	 * Locator for Also ranked nodes.
	 */
	private By alsoRankedNodes(String nodeNumber, String rankedNode) {
		return By
				.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
						+ nodeNumber
						+ "]/div[contains(@class,'relative width100 expander')]/div[@class='relative rankedOn']/span["
						+ rankedNode + "]");
	}

	/*
	 * This function is used to check presence of Also Ranked node.
	 */
	public boolean isAlsoRankedNodePresent(String nodeNumber, String rankedNode) {
		return isElementPresent(alsoRankedNodes(nodeNumber, rankedNode),
				MEDIUMWAIT);
	}

	/*
	 * locator for Also Ranked nodes for click.
	 */
	private By alsoRankedNodesForClick(String nodeNumber, String rankedNode) {
		return By
				.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
						+ nodeNumber
						+ "]/div[contains(@class,'relative width100 expander')]/div[@class='relative rankedOn']/span["
						+ rankedNode + "]//a");
	}

	/*
	 * This function is used to click on Also Ranked nodes.
	 */
	public void clickAlsoRankedNode(String nodeNumber, String rankedNode) {
		safeClick(alsoRankedNodesForClick(nodeNumber, rankedNode), VERYLONGWAIT);
	}

	/*
	 * This function is used to get text of Also Ranked.
	 */
	public String getTextOfAlsoRanked(String nodeNumber, String rankedNode) {
		return safeGetText(alsoRankedNodesForClick(nodeNumber, rankedNode),
				VERYLONGWAIT);
	}

	/*
	 * Locator for more icon.
	 */
	private By moreIcon(String nodeNumber) {
		return By
				.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
						+ nodeNumber
						+ "]/div[contains(@class,'relative width100 expander')]/a[@class='inlineBlock moreLink']/span");
	}

	/*
	 * This function us used for check presence of more icon.
	 */
	public boolean isMoreIconPresent(String nodeNumber) {
		return isElementPresent(moreIcon(nodeNumber), VERYLONGWAIT);
	}

	/*
	 * Locator for more node name.
	 */
	private By moreNodeName(String nodeNumber) {
		return By
				.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
						+ nodeNumber
						+ "]/div[contains(@class,'relative width100 expander')]/a[@class='inlineBlock moreLink']");
	}

	/*
	 * This function is used to check presence of more node name.
	 */
	public boolean isMoreNodeNamePresent(String nodeNumber) {
		return isElementPresent(moreNodeName(nodeNumber), VERYLONGWAIT);
	}

	/*
	 * Locator for more info.
	 */
	private By moreInfo(String nodeNumber) {
		return By
				.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
						+ nodeNumber
						+ "]/div[contains(@class,'relative width100 expander')]/em[@class='inlineBlock serif grey moreInfo']");
	}

	/*
	 * This function is used to check presence of more info.
	 */
	public boolean isMoreInfoPresent(String nodeNumber) {
		return isElementPresent(moreInfo(nodeNumber), VERYLONGWAIT);
	}

	/*
	 * Locator for node property combo.
	 */
	private By nodePropertySelect() {
		return By.xpath("//div[@id='showDataColumn']/select[@class='custom']");
	}

	/*
	 * Locator for node property.
	 */
	private By nodeProperty(int num) {
		return By
				.xpath("//div[@id='showDataColumn']/select[@class='custom']/option["
						+ num + "]");
	}

	/*
	 * This function is used to select node property.
	 */
	public void selectNodeProperty(int num) {
		safeClick(nodePropertySelect(), MEDIUMWAIT);
		safeClick(nodeProperty(num), MEDIUMWAIT);
	}

	/*
	 * Locator for data node.
	 */
	private By dataNode(String nodeNumber) {
		return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["+ nodeNumber	+ "]/div[contains(@class,'relative name')]//span[@class='block grey data dataColumn']");
	}

	/*
	 * This function is used to hey text of data node.
	 */
	public String getTextOfDataNode(String nodeNumber) {

		return safeGetText(dataNode(nodeNumber), VERYLONGWAIT);
	}

	/*
	 * Locator for blather.
	 */
	private By blather(String nodeNumber) {
		return By
				.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
						+ nodeNumber
						+ "]/div[contains(@class,'relative name')]//em[@class='block black serif blather true']");
	}

	/*
	 * This function is used to get blather text.
	 */
	public String getBlatherText(String nodeNumber) {
		return safeGetText(blather(nodeNumber), VERYLONGWAIT);
	}

	/*
	 * This function is used to get font style for a blather.
	 */
	public String getBlatherFontSyle(String nodeNumber) {
		return driver.findElement(blather(nodeNumber))
				.getCssValue("font-style");
	}

	/*
	 * Locator for the node.
	 */
	private By node(String nodeNumber) {
		return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
				+ nodeNumber + "]");
	}

	/*
	 * This function is used to check presence of node.
	 */
	public boolean isNodePresent(String nodeNumber) {
		return isElementPresent(node(nodeNumber), VERYLONGWAIT);
	}

	/*
	 * This function is used to check presence of node.
	 */
	public void scrollToElement(String nodeNumber) {
		scrollIntoViewThroughJavaScriptExecuter(node(nodeNumber));
	}

	/*
	 * This function is used to vertical scrolling.
	 */
	public void verticalScrolling(int horizontal, int vertical) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 4500)"); // y value '250' can be altered
	}

	/*
	 * Locator for the Wiki text.
	 */
	private By wikiText(String nodeNumber) {
		return By
				.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["
						+ nodeNumber
						+ "]/div[contains(@class,'relative width100')]/em[@class='relative block serif grey wikiText']");
	}

	/*
	 * This function is used to get font style of wiki text.
	 */
	public String getFontStyleWikiText(String nodeNumber) {
		return driver.findElement(wikiText(nodeNumber)).getCssValue(
				"font-style");
	}

	/*
	 * Locator for the trivia popup.
	 */
	private By triviaPopup(String nodeNumber) {
		return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li[1]/div[@class='floatRight absolute trivia center whiteBg']");
		//return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["+nodeNumber+"]/div[@class='floatRight absolute trivia center rnkrLBlueBg']");
	}

	/*
	 * This function is used to check trivia popup presence.
	 */
	public boolean isTriviaPopupPresent(String nodeNumber) {
		return isElementPresent(triviaPopup(nodeNumber), SHORTWAIT);
	}
	/*
	 * Function to get color of triviaPopup.
	 */
	public String getColorOfTriviaPopup(String nodeNumber){
		return driver.findElement(triviaPopup(nodeNumber)).getCssValue("background-color");
	}
	
	/*
	 * Locator for node image to play video.
	 */
	private By videoImage(String nodeNumber) {
		return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li["+nodeNumber+"]/div[contains(@class,'float relative img')]//img[@class='float absolute width100 videoOverlay']");
	}

	/*
	 * This function is used to click on Node picture to play the video.
	 */
	public void clickOnVideoToPlay(String nodeNumber) {
		safeJavaScriptClick(videoImage(nodeNumber), VERYLONGWAIT);
	}

	/*
	 * Locator for running video.
	 */
	private By video() {
		return By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front videoPlayer']");
	}

	/*
	 * This function is used to check video presence.
	 */
	public boolean isVideoPresent() {
		return isElementPresent(video(), VERYLONGWAIT);
	}

	/*
	 * Locator for node video pop up for list node.
	 */
	private By nodeVideo() {
		return By
				.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front videoPlayer']");
	}

	/*
	 * Function to check the presence of node video pop up for list node.
	 */
	public boolean isNodeVideoPopupPresent() {
		return isElementPresent(nodeVideo(), MEDIUMWAIT);
	}

	/*
	 * Locator for RIGION in demographics option.
	 */
	private By rigion() {
		return By
				.xpath("//div[@id='mlaTabs2']/ul[@class='relative']/li[@id='mlaTab2_demographics']/ul[@id='mlaTab2_demographics_options']/li[contains(text(),'Region')]");
	}

	/*
	 * This function is used to click on RIGION in demographics option.
	 */
	public void clickOnRigion() {
		safeJavaScriptClick(rigion(), VERYLONGWAIT);
	}

	/*
	 * Locator for list node for 60
	 */
	private By listnodeno(int nodeno) {
		return By
				.xpath("//div[@id='listBody']/section[@id='mainListCnt']/ol//div[@class='float relative rank center']/span[contains(text(),'"
						+ nodeno + "')]");
		// return
		// By.xpath("//div[@id='listBody']/section[@id='mainListCnt']/ol/li[64]/div[@class='float relative rank center']/span[contains(text(),'60')]");
	}

	/*
	 * Locator for Add logic
	 */
	private By addlogic(int nodeno) {
		return By
				.xpath("//div[@id='listBody']/section[@id='mainListCnt']/ol//div[@class='float relative rank center']/span[contains(text(),'"
						+ nodeno
						+ "')]/../..//following-sibling::*[1]/div[@class='inlineBlock inlineAd']");
		// return
		// By.xpath("//div[@id='listBody']/section[@id='mainListCnt']/ol//div[@class='float relative rank center']/span[contains(text(),'60')]");//following-sibling::*[1]/li["+number+"]
	}

	/*
	 * This function is used to preasent node
	 */
	public boolean isPresentnode(int nodeno) {
		// scrollIntoViewThroughJavaScriptExecuter(addlogic(nodeno));
		return isElementPresent(listnodeno(nodeno), SHORTWAIT);
	}

	/*
	 * This function is used to preasent node
	 */
	public boolean isPresentadd(int nodeno) {
		scrollIntoViewThroughJavaScriptExecuter(listnodeno(nodeno));
		return isElementPresent(addlogic(nodeno), SHORTWAIT);
	}

	/*
	 * Locator for search filed
	 */
	private By searchfiled() {
		return By.id("filLInput");
	}

	/*
	 * This function is used to type on search field
	 */
	public void typeonsearchfield(String text) {
		safeClearAndType(searchfiled(), text, MEDIUMWAIT);
	}
	/*
	 * Locator for admin edit list.
	 */
	private By adminEditList() {
	return By.id("adminEditList");
	}
	/*
	 * Function to click on ' MetaData' in admin bar.
	 */
	public void clickOnadminEditList() {
		safeJavaScriptClick(adminEditList(), MEDIUMWAIT);
	}
	/*
	 * Locator for admin bar for checking stats.
	 */
	private By adminStats(int num) {
		return By.xpath("//div[@id='adminBar']/ul/[li["+num+"]/a");
		//return By.xpath("//div[@id='adminBar']/ul/li["+num+"]/a[@id='adminEditList']");
		//return By.xpath("//div[@id='adminBar']/ul/li["+num+"]/a[@id='adminEditList']");
		//return By.xpath("//div[@id='adminBar']/ul/li["+num+"]/a[@id='adminStats']");
	}
	/*
	 * Function to click on 'stats' in admin bar.
	 */
	public void clickOnAdminStats(int num) {
		safeClick(adminStats(num), MEDIUMWAIT);
	}
	/*
	 * Locator for reset tab in admin bar
	 */
	private By ResetTab() {
	return By.id("adminReset");
	}
	/*
	 * Function to click on 'reset tab' in admin bar.
	 */
	public void clickOnResetTab() {
		safeClick(ResetTab(), MEDIUMWAIT);
	}
	/*
	 * Locator for MetaData in admin bar.
	 */
	private By MetaData() {
	return By.id("adminMetaData");
	}
	/*
	 * Function to click on ' MetaData' in admin bar.
	 */
	public void clickOnMetaData() {
		safeJavaScriptClick(MetaData(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for listinfo in admin bar.
	 */
	private By listinfo() {
	return By.id("adminListEditInfo");
	}
	/*
	 * Function to click on ' MetaData' in admin bar.
	 */
	public void clickOnlistinfo() {
		safeJavaScriptClick(listinfo(), MEDIUMWAIT);
	}
	/*
	 * Locator for Stats in admin bar.
	 */
	private By Stats() {
	return By.id("adminStats");
	}
	/*
	 * Function to click on Stats in admin bar.
	 */
	public void clickOnStats() {
		safeJavaScriptClick(Stats(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for ListActionsTab in admin bar.
	 */
	private By ListActionsTab() {
	return By.id("adminListData");
	}
	/*
	 * Function to click on 'stats' in admin bar.
	 */
	public void clickOnListActionsTab() {
		safeJavaScriptClick(ListActionsTab(), MEDIUMWAIT);
	}
	/*
	 * Locator for admin bar for checking stats.
	 */
	private By adminStats1() {
		return By.id("adminReset");
	}
	/*
	 * Function to click on 'stats' in admin bar.
	 */
	public void clickOnadminStats1() {
		//System.out.println("aaaaaaaaaaaaaa");
		safeJavaScriptClick(adminStats1(), MEDIUMWAIT);
		//System.out.println("bbbbbbbbbbbb");
	}
	/*
	 * Locator for sub categories(of stats) of admin bar.
	 */
	private By subStats(int num) {
		return By.xpath("//ul[@id='adminStatsSub']/li[" + num + "]");
	}
	/*
	 * Locator for sub categories(of stats) of admin bar.
	 */
	private By subStatsListaction(int num) {
		return By.xpath("//ul[@id='adminListDataSub']/li[" + num + "]/input[@id='allowUserUploadImages']");
	}
	/*
	 * Locator for sub categories(of stats) of admin bar.
	 */
	private By RLstat() {
		return By.id("RLStats");
	}
	/*
	 * Function to select any of the sub categories(of stats) of admin bar.
	 */
	public void clickOnRLstat() {
		safeJavaScriptClick(RLstat(), SHORTWAIT);
	}
	/*
	 * Locator for sub categories(of stats) of admin bar.
	 */
	private By ROLstat() {
		return By.id("ROIStats");
	}
	/*
	 * Function to select any of the sub categories(of stats) of admin bar.
	 */
	public void clickOnROLstat() {
		safeJavaScriptClick(ROLstat(), SHORTWAIT);
	}
	/*
	 * Function to select any of the sub categories(of stats) of admin bar.
	 */
	public void clickOnSubStats(int num) {
		safeJavaScriptClick(subStats(num), SHORTWAIT);
	}
//	/*
//	 * Locator for sub categories(of stats) of admin bar.
//	 */
//	private By subStatsListaction(int num) {
//		return By.id("allowUserUploadImages");
//	}
//	private By subStatsListaction1(int num) {
//		return By.xpath("//ul[@id='adminStatsSub']/li[" + num + "]/input[@id='allowUserUploadImages']");
//	}
//	/*
//	 * This function is used to preasent node
//	 */
//	public boolean isPresencheckbox(int nodeno) {
//		// scrollIntoViewThroughJavaScriptExecuter(addlogic(nodeno));
//		return isElementPresent(subStatsListaction1(nodeno), SHORTWAIT);
//	}
	/*
	 * Function to select any of the sub categories(of stats) of admin bar.
	 */
	public void clickOnsubStatsListaction(int num) {
		//System.out.println("com in");
		safeJavaScriptClick(subStatsListaction(num), SHORTWAIT);
		//System.out.println("com in222222222222222222");
	}
	/*
	 * Locator for editlist of admin bar.
	 */
	private By editlist() {
		return By.id("adminListEditTags");
		
		//return By.xpath("//ul[@id='adminEditListSub']/li["+num+"]");
		//return By.xpath("//ul[@id='adminEditListSub']/li["+num+"]/a[@id='adminListEditTags']");
	}
	

	/*
	 * Function to select any of the editlistof admin bar.
	 */
	public void clickOneditlist( ) {
		safeClick(editlist(), SHORTWAIT);
	}
	/*
	 * Locator for editlist of admin bar.
	 */
	private By listsetting() {
		return By.id("adminOptions");
		
		//return By.xpath("//ul[@id='adminEditListSub']/li["+num+"]");
		//return By.xpath("//ul[@id='adminEditListSub']/li["+num+"]/a[@id='adminListEditTags']");
	}
	//adminOptions

	/*
	 * Function to select any of the editlistof admin bar.
	 */
	public void clickOnlistsetting() {
		safeClick(listsetting(), SHORTWAIT);
	}
	/*
	 * Locator for admin burry change
	 */
	private By adminburrychange() {
		return By.id("adminBuryChange");
		
		//return By.xpath("//ul[@id='adminEditListSub']/li["+num+"]");
		//return By.xpath("//ul[@id='adminEditListSub']/li["+num+"]/a[@id='adminListEditTags']");
	}
	//adminOptions

	/*
	 * Function to admin burry change
	 */
	public void clickOnadminburrychange() {
		safeClick(adminburrychange(), SHORTWAIT);
	}
	/*
	 * Locator for metadata of admin bar.
	 */
	private By metadatalist(int num) {
		return By.xpath("//ul[@id='adminMetaDataSub']/li[" + num + "]/input");
	}

	/*
	 * Function to select any of the editlistof admin bar.
	 */
	public void checkonmetalist(int num) {
		// safeCheckByOption(metadatalist(num), option, SHORTWAIT);
		safeCheck(metadatalist(num), SHORTWAIT);
	}

	/*
	 * Locator for Desktop and mobile data statistics under RL stats of admin
	 * bar.
	 */
	private By deskMobStatsData(String txt, int num) {
		if (txt.equalsIgnoreCase("desktop"))
			txt = "//div[@id='rlStatsDesktop']/ul/li[" + num + "]";
		else
			// mobile
			txt = "//div[@id='rlStatsMobile']/ul/li[" + num + "]";
		return By.xpath(txt);
	}

	/*
	 * Function to check the presence of Desktop and mobile data statistics
	 * under RL stats of admin bar.
	 */
	public boolean isdeskMobStatsDataPresent(String txt, int num) {
		return isElementPresent(deskMobStatsData(txt, num), VERYLONGWAIT);
	}

	/*
	 * Locator to close the Desktop and mobile data statistics box under RL
	 * stats of admin bar.
	 */
	private By close() {
		return By
				.xpath("//div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']/button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close']");
	}

	/*
	 * Function to close the Desktop and mobile data statistics box under RL
	 * stats of admin bar.
	 */
	public void clickOnClose() {
		safeJavaScriptClick(close(), MEDIUMWAIT);
	}

	/*
	 * Locator for ROI Statistics(page score).
	 */
	private By ROIStats(int num) {
		return By.xpath("//table[@id='roiStats']/tbody/tr[" + num + "]");
	}

	/*
	 * Function to check the presence of ROI (page score) statistics.
	 */
	public boolean isROIStatsPresent(int num) {
		return isElementPresent(ROIStats(num), SHORTWAIT);
	}

	// /*
	// * Locator for Image of the item for src.
	// */
	// private By imageofItemForsrc(int num){
	// return By.xpath("//ol[contains(@id,'rnkrwMLA_')]/li["+num+"]//img/..");
	// }
	// /*
	// * Function to get src of the image of a item.
	// */
	// public String getsrcOfImageOfItem(int num){
	// return driver.findElement(imageofItemForsrc(num)).getAttribute("href");
	// }
	/*
	 * Locator for image in the list.
	 */
	private By imageofItem(int num) {
		return By.xpath("//ol[contains(@id,'rnkrwMLA_')]/li[" + num + "]//img");
	}

	/*
	 * Function to click on image in the list.
	 */
	public void clickOnImageOfItem(int num) {
		safeClick(imageofItem(num), MEDIUMWAIT);
	}

	/*
	 * Locator for video in the list.
	 */
	private By videoofItem(int num) {
		return By
				.xpath("//ol[contains(@id,'rnkrwMLA_')]/li["
						+ num
						+ "]//img[@class='rnkrw-float rnkrw-absolute rnkrw-vidOverlay']");
	}

	/*
	 * Function to click on video in the list.
	 */
	public void clickOnVideoOfItem(int num) {
		safeClick(videoofItem(num), MEDIUMWAIT);
	}

	/*
	 * Locator for editlist of admin bar.
	 */
	private By resetsublist(int num) {
		return By.xpath("//ul[@id='adminResetSub']/li[" + num + "]/a[@id='adminResetCache']");
	}

	/*
	 * Function to select any of the editlistof admin bar.
	 */
	public void clickOnresetsublist(int num) {
		safeClick(resetsublist(num), SHORTWAIT);
	}

	/*
	 * Locator for FirstListFooter of next list
	 */
	private By FirstListCollection( int num) {
		return By.xpath("//div[@id='collectionScroller']/div[@id='collectionScrollCntr']/ol[contains(@id,'collectionItems')]/li["+num+"]/a[@class='relative block']");
	}

	/*
	 * Function to click on FirstListFooter
	 */
	public void clickOnFirstListCollection(int num) {
		safeClick(FirstListCollection(num), SHORTWAIT);
	}

	/*
	 * Function to get href of FirstListFooter
	 */
	public String gethrefOfFirstListCollection(int num) {
		return driver.findElement(FirstListCollection(num)).getAttribute("href");
	}

	/*
	 * Locator for ListsLikeThis block
	 */
	private By ListsLikeThis() {
		return By.xpath("//div[@class='blockHeaderBg relative']");
	}

	/*
	 * Function to check the presence ListsLikeThis.
	 */
	public boolean isListsLikeThisPresent() {
		return isElementPresent(ListsLikeThis(), MEDIUMWAIT);
	}

	/*
	 * Function to click onListsLikeThisPresent
	 */
	public void clickOnListsLikeThis() {
		safeClick(ListsLikeThis(), SHORTWAIT);
	}

	/*
	 * Locator for CloselyRelatedLists
	 */
	private By CloselyRelatedLists() {
		return By.xpath("//div[@id='closelyRelated']/ul/li[1]/a");
	}

	/*
	 * Function to get href of CloselyRelatedLists
	 */
	public String gethrefOfCloselyRelatedLists() {

		return driver.findElement(CloselyRelatedLists()).getAttribute("href");
	}

	/*
	 * Function to click on CloselyRelatedLists
	 */
	public void clickOnCloselyRelatedLists() {
		safeClick(CloselyRelatedLists(), SHORTWAIT);
	}

	/*
	 * Locator for CloselyRelatedLists
	 */
	private By CloselyRelatedLists(int num) {
		return By.xpath("//div[@id='closelyRelated']/ul/li[" + num + "]/a");
	}

	/*
	 * Function to get href of CloselyRelatedLists
	 */
	public String gethrefOfCloselyRelatedLists(int num) {

		return driver.findElement(CloselyRelatedLists(num))
				.getAttribute("href");
	}

	/*
	 * Function to click on CloselyRelatedLists
	 */
	public void clickOnCloselyRelatedLists(int num) {
		safeClick(CloselyRelatedLists(num), SHORTWAIT);
	}

	/*
	 * Locator for AlsoRankesOnlists
	 */
	private By AlsoRankesOnlists(int num) {
		return By.xpath("//div[@id='nodelyRelatedLists']/ul/li[" + num
				+ "]/a[2]");
	}

	/*
	 * Function to click on CloselyRelatedLists
	 */
	public void clickOnAlsoRankesOnlists(int num) {
		safeJavaScriptClick(AlsoRankesOnlists(num), SHORTWAIT);
	}

	/*
	 * Function to get href of AlsoRankesOnlists
	 */
	public String gethrefOfAlsoRankesOnlists(int num) {

		return driver.findElement(AlsoRankesOnlists(num)).getAttribute("href");
	}

	/*
	 * Locator for MoreByThisUser Block
	 */
	private By MoreByThisUser() {
		return By.xpath("//div[@id='moreByUser']/h3");
	}

	/*
	 * Function to check the presence MoreByThisUser
	 */
	public boolean isMoreByThisUserPresent() {
		scrollIntoElementView(MoreByThisUser());
		return isElementPresent(MoreByThisUser(), MEDIUMWAIT);
	}

	/*
	 * Locator for MoreByThisUserLists
	 */
	private By MoreByThisUserLists(int num) {
		return By.xpath("//div[@id='moreByUser']/ul/li[" + num + "]/a");
		// return
		// By.xpath("//div[@id='moreByUser']/ul/li["+num+"]/a[@class='thumbView relative']/img");
	}

	/*
	 * Function to click on MoreByThisUserLists
	 */
	public void clickOnMoreByThisUserLists(int num) {
		safeJavaScriptClick(MoreByThisUserLists(num), SHORTWAIT);
	}

	/*
	 * Function to get href of MoreByThisUserLists
	 */
	public String gethrefOfMoreByThisUserLists(int num) {

		return driver.findElement(MoreByThisUserLists(num))
				.getAttribute("href");
	}

	/*
	 * Locator for AlsoRanksONLists
	 */
	private By AlsoRanksONLists(int num) {
		return By.xpath("//div[@id='nodelyRelatedLists']/ul/li[" + num + "]/a");

	}

	/*
	 * Function to click on AlsoRanksONLists
	 */
	public void clickOnAlsoRanksONLists(int num) {
		safeJavaScriptClick(AlsoRanksONLists(num), SHORTWAIT);
	}

	/*
	 * Function to get href of AlsoRanksONLists
	 */
	public String gethrefOfAlsoRanksONLists(int num) {

		return driver.findElement(AlsoRanksONLists(num)).getAttribute("href");
	}

	/*
	 * Locator for Top righttrail
	 */
	private By toprighttrail(int num, int num1) {
		return By.xpath("//div[@class='relatedListsBlock'][" + num+ "]/ul/li[" + num1 + "]");
	}

	/*
	 * Function is used to section is present in top right trail
	 */
	public boolean isPresentListIntoprighttrail(int number, int num1) {
		return isElementPresent(toprighttrail(number, num1), SHORTWAIT);
	}

	/*
	 * Locator for Top righttrail in list
	 */
	private By toprighttraillist(int num, int num1) {
		return By.xpath("//div[@class='relatedListsBlock'][" + num1
				+ "]/ul/li[" + num
				+ "]/div[@class='inlineBlock listLink black']/a");
	}

	/*
	 * Function to click on Top right trail
	 */
	public void clickOntoprighttraillist(int num, int num1) {
		safeJavaScriptClick(toprighttraillist(num, num1), SHORTWAIT);
	}

	/*
	 * Function to get href of toprighttraillist
	 */
	public String gethrefOftoprighttraillist(int num, int num1) {

		return driver.findElement(toprighttraillist(num, num1)).getAttribute(
				"href");
	}

	/*
	 * Locator for bottom right trail in list
	 */
	private By bottomrighttraillistpresent(int num) {
		return By.xpath("//section[@id='listRelated']/ul[@class='related']/li["
				+ num + "]");
	}

	/*
	 * Locator for bottom right trail in list
	 */
	private By bottomrighttraillist(int num) {
		return By.xpath("//section[@id='listRelated']/ul[@class='related']/li["
				+ num + "]/a");
	}

	/*
	 * Function is used to section is present in top right trail
	 */
	public boolean isPresentListInbottomrighttraillist(int number) {
		return isElementPresent(bottomrighttraillistpresent(number), SHORTWAIT);
	}

	/*
	 * Function to click on bottom righttrail list
	 */
	public void clickOnbottomrighttraillist(int num) {
		safeJavaScriptClick(bottomrighttraillist(num), SHORTWAIT);
	}

	/*
	 * Function to get href of bottom right traillist
	 */
	public String gethrefOfbottomrighttraillist(int num) {

		return driver.findElement(bottomrighttraillist(num)).getAttribute(
				"href");
	}

	/*
	 * Locator for bottom right trail in list
	 */
	private By cascaddinglist(int num) {
		return By.xpath("//section[@id='relatedListsLazy2']/ul[" + num	+ "]/li[1]//img");
	}

	/*
	 * Function for autoloading.
	 */
	public void autoloading(int number) {
		System.out.println("aaaaa");
		scrollIntoViewThroughJavaScriptExecuter(cascaddinglist(number));
		// waitForElementVisible(cascaddinglist(number),40);
	}

	/*
	 * Locator for node name.
	 */
	private By nodenumber(int num) {
		return By.xpath("//section[@id='relatedListsLazy2']/ul[" + num+ "]/li[1]//span");
	}

	/*
	 * Function to check the presence of node list before loading and after
	 * autoloading.
	 */
	public boolean isnodePresent(int number) {
		scrollIntoViewThroughJavaScriptExecuter(cascaddinglist(number));
		return isElementPresent(nodenumber(number));
	}

	/*
	 * Locator for bottom right trail in list
	 */
	private By popularlist() {
//		return By.xpath("//section[@id='relatedListsLazy2']/ul[1]/li["+num+"]");
		return By.xpath("//section[@id='relatedListsLazy2']/header[@class='sectionHeaderBG']/h3");
	}

	/*
	 * Function to check the presence of node list before loading and after
	 * autoloading.
	 */
	public boolean ispopularlistPresent() {
		scrollIntoViewThroughJavaScriptExecuter(popularlist());
		return isElementPresent(popularlist());
	}
	/*
	 * Locator for more popular related lists
	 */
	private By popularRelatedlist(int num) {
		return By.xpath("//section[@id='relatedListsLazy2']/ul["+num+"]");
}
	/*
	 * Function to check the presence of more popular related lists
	 */
	public boolean ispopularRelatedlistPresent(int num) {
		scrollIntoViewThroughJavaScriptExecuter(popularRelatedlist(num));
		return isElementPresent(popularRelatedlist(num));
	}
	/*
	 * Locator for remove NSFW tag in admin bar.
	 */
	private By removeNSFW() {
		//adminNsfwTag
	return By.id("adminNsfwUntag");
	}
	/*
	 * Function to click on 'stats' in admin bar.
	 */
	public void clickOnremoveNSFW() {
		safeJavaScriptClick(removeNSFW(), MEDIUMWAIT);
	}
	/*
	 * Function to check the presence of more popular related lists
	 */
	public boolean isPresentremoveNSFW() {
		return isElementPresent(removeNSFW(),SHORTWAIT);
	}
	/*
	 * Locator for remove NSFW tag in admin bar.
	 */
	private By TagNSFW() {
	return By.id("adminNsfwTag");
	}
	/*
	 * Function to click on 'stats' in admin bar.
	 */
	public void clickOnTagNSFW() {
		safeClick(TagNSFW(), MEDIUMWAIT);
	}
	
	////////////////
	/*
	 * Locator for Header video
	 */
	private By Headervideo() {
		return By.xpath("//header[@id='listHead']/span[@role='link']/img");
}
	/*
	 * Function to click on 'Header video
	 */
	public void clickOnHeadervideo() {
		safeJavaScriptClick(Headervideo(), MEDIUMWAIT);
	}
	/*
	 * Locator for Header video background
	 */
	private By videobackground() {
		return By.xpath("//div[@class='width100 relative rnkrDBlueBg white center videoPlayerTitle']");
}
	/*
	 * This function is used to get color of text.
	 */
	public String getColorvideobackground() {
		return driver.findElement(videobackground()).getCssValue("background-color");
	}
	/*
	 * Locator for Header video upper   text
	 */
	private By videoheaderuppertext() {
		return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']/div[@class='width100 relative rnkrDBlueBg white center videoPlayerTitle']/strong");
   }
	/*
	 * This function is used to get color of text.
	 */
	public String getColorOfvideoheaderuppertext() {
		return driver.findElement(videobackground()).getCssValue("color");
	}
	/*
	 * This function is used to get font family of text.
	 */
	public String getFontOfvideoheaderuppertext() {
		return driver.findElement(videobackground()).getCssValue("font-family");
	}
	/*
	 * This function is used to get font-weight of text.
	 */
	public String getFontweightOfvideoheaderuppertext() {
		return driver.findElement(videobackground()).getCssValue("font-weight");
	}
	/*
	 * This function is used to get font-size of text
	 */
	public String getFontsizeOfvideoheaderuppertext() {
		return driver.findElement(videobackground()).getCssValue("font-size");
	}
	/*
	 * Locator for Header video upper   text
	 */
	private By videoheaderlowertext() {
		return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']/div[@class='width100 relative rnkrDBlueBg white center videoPlayerTitle']/em");
   }
	/*
	 * This function is used to get font family of text.
	 */
	public String getFontOfvideoheaderlowertext() {
		return driver.findElement(videoheaderlowertext()).getCssValue("font-family");
	}
	/*
	 * This function is used to get font style of text.
	 */
	public String getFonstyletOfvideoheaderlowertext() {
		return driver.findElement(videoheaderlowertext()).getCssValue("font-style");
	}
	/*
	 * This function is used to get color of text.
	 */
	public String getColorOfvideoheaderlowertext() {
		return driver.findElement(videoheaderlowertext()).getCssValue("color");
	}
	/*
	 * This function is used to get font-size of text.
	 */
	public String getFontsizeOfvideoheaderlowertext() {
		return driver.findElement(videoheaderlowertext()).getCssValue("font-size");
	}
	/*
	 * This function is used to get border-image-width
	 */
	public String getborderimagewidthvideo() {
		return driver.findElement(videobackground()).getCssValue("border-image-width");
	}
	/*
	 * locator for get value of triva popup
	 */
	private By trivavalue(int num) {
		return By.xpath("//section[@id='mainListCnt']/ol/li["+num+"]/div[contains(@class,'floatRight absolute trivia center')]/div[@class='tableAlign grey text']//strong");                                           
	}
	/*
	 * This function is used to get value of triva popup
	 */
	public String  gettestoftrivavalue(int num) {
		return safeGetText(trivavalue(num),SHORTWAIT);
	
	}
	/*
	 * Locator for burry display
	 */
	private By burrydisplay() {
		return By.xpath("//div[@id='adminBar']/ul/li[@class='float relative uppercase btn first']/span[@id='adminBuryDisplay']");
	}
	/*
	 * Function to burry display
	 */
	public String getTextOFburryubburry() {
		return safeGetText(burrydisplay(),SHORTWAIT);
	}
}