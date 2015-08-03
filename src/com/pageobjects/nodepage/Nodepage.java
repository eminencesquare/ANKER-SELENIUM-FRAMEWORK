package com.pageobjects.nodepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public class Nodepage extends SafeActions {
	private WebDriver driver;
	
	/*
	 * Constructor for the page.
	 */
	public Nodepage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	/*
	 * Locator for What's the formula.
	 */
	private By whatsTheFormula(){
		return By.id("whatsRanking");
	}
	
	/*
	 * Function is used to click on whats the formula.
	 */
	public void clickOnWhatsTheFormula(){
		safeClick(whatsTheFormula(), VERYLONGWAIT);
	
	}
	
	/*
	 * This function is used to check presence of score explain.
	 */
	public boolean isWhatsTheFormulaPresent(){
		return isElementPresent(whatsTheFormula(), VERYLONGWAIT);
	}
	
	/*
	 * Locator for whats the formula div.
	 */
	private By WhatsTheFormulaDiv(){
		return By.xpath("//div[contains(@id,'whats_ranking_sticky')]");
	}
	
	/*
	 * This function is used to check presence of score explain.
	 */
	public boolean isWhatsTheFormulaDivPresent(){
		return isElementPresent(WhatsTheFormulaDiv(), VERYLONGWAIT);
	}
	
	/*
	 * Locator for header of added by user page.
	 */
	private By textWhatsTheFormulaPopup(){
		return By.xpath("//div[contains(@id,'whats_ranking_sticky')]/span[@class='block text black']");
	}
	
	/*
	 * This function is used for get header for Added by user page.
	 */
	public String getTextWhatsTheFormulaPopup(){
		return safeGetText(textWhatsTheFormulaPopup(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for Node text.
	 */
	private By okWhatsTheFormulaPopup(){
		return By.xpath("//div[contains(@id,'whats_ranking_sticky')]//span[@class='inlineBlock btnDBlue']");
	}
	
	/*
	 * Function is used to get text of node.
	 */
	public void clickOnOkWhatsTheFormulaPopup(){
		safeJavaScriptClick(okWhatsTheFormulaPopup(), VERYLONGWAIT);
	}
	
	/*
	 * Locator for header of added by user page.
	 */
	private By nodeName(){
		return By.xpath("//div[@id='nodeDesc']/h1[contains(@class,'heading')]");
	}
	
	/*
	 * This function is used for get header for Added by user page.
	 */
	public String getTextOfNodeName(){
		return safeGetText(nodeName(), VERYLONGWAIT);
	}
	
	public String getFontFamilyOfNodeName(){
		return driver.findElement(nodeName()).getCssValue("font-family");	
	}
	
	public String getFontSizeOfNodeName(){
		return driver.findElement(nodeName()).getCssValue("font-size");	
	}
	
	/*
	 * This function is used to get color.
	 */
	public String getNodeColor(String side){
		return driver.findElement(nodeName()).getCssValue(side);
		}
	
	/*
	 * Locator for list about.
	 */
	private By listAboutLink(){
		return By.xpath("//div[@id='nodeDesc']/div[@class='listed']/a[@href='#nodeListed']");
	}
	
	/*
	 * This function is used to check presence of list about.
	 */
	public boolean isListAboutLinkPresent(){
		return isElementPresent(listAboutLink(), SHORTWAIT);
	}
	
	/*
	 * Function to click on list about link.
	 */
	public void clickOnListAboutLink(){
		safeJavaScriptClick(listAboutLink(), VERYLONGWAIT);
	}
	/*
	 * Locator for listed on.
	 */
	private By listedOnLink(){
		return By.xpath("//div[@id='nodeDesc']/div[@class='listed']/a[@href='#theRanks']");
	}
	
	/*
	 * This function is used to check presence of Listed on link.
	 */
	public boolean isListedOnLinkPresent(){
		return isElementPresent(listedOnLink(), SHORTWAIT);
	}
	
	/*
	 * Function to click on listed on link.
	 */
	public void clickOnListedOnLink(){
		safeJavaScriptClick(listedOnLink(), VERYLONGWAIT);
	}
	
	/*
	 * Locator for list about section.
	 */
	private By listAboutSection(){
		return By.xpath("//section[@id='nodeListed']/header[@class='sectionHeaderBG']/h2[contains(@class,'sectionHeaderFont')]");
	}
	
	/*
	 * This function is used for get text of list about section.
	 */
	public String getTextOfListsAboutSection(){
		return safeGetText(listAboutSection(), VERYLONGWAIT);
	}
	
	/*
	 * Locator for listed on section.
	 */
	private By listedOnSection(){
		return By.xpath("//section[@id='theRanks']//h2[contains(@class,'sectionHeaderFont')]");
	}
	
	/*
	 * This function is used for get text of listed on section.
	 */
	public String getTextOfListedOnSection(){
		return safeGetText(listedOnSection(), VERYLONGWAIT);
	}
	
	
	/*
	 * Locator for list about and listed on section.
	 */
	private By listAboutAndListedOnSection(){
		return By.xpath("//div[@id='nodeDesc']/div[@class='listed']");
	}
	
	/*
	 * This function is used for get text of list about and listed on section.
	 */
	public String getTextOfListsAboutAndListedOn(){
		return safeGetText(listAboutAndListedOnSection(), VERYLONGWAIT);
	}
	
	/*
	 * Locator for text wiki description.
	 */
	private By textWikiDesc(){
		return By.xpath("//div[@id='nodeDesc']/div[@id='wiki']/p[@id='wikiDesc']");
	}
	
	/*
	 * This function is used for get text of wiki description.
	 */
	public String getTextWikiDesc(){
		return safeGetText(textWikiDesc(), VERYLONGWAIT);
	}
	
	/*
	 * Function to get font size of wiki description.
	 */
	public String getFontSizeOfWikiDesc(){
		return driver.findElement(textWikiDesc()).getCssValue("font-size");	
	}
	
	/*
	 * Function to get font family of wiki description.
	 */
	public String getFontFamilyOfWikiDesc(){
		return driver.findElement(textWikiDesc()).getCssValue("font-family");	
	}
	
	/*
	 * Function to get color of wiki description.
	 */
	public String getColorOfWikiDesc(String side){
		return driver.findElement(textWikiDesc()).getCssValue(side);
		}
	/*
	 * Locator for more on wikipedia.
	 */
	private By moreOnWikiPedia(){
		return By.xpath("//div[@id='nodeDesc']/div[@id='wiki']/span[@class='readMoreWiki block']/a");
	}
	
	/*
	 * This function is used to check presence of more wikipedia.
	 */
	public boolean isMoreOnWikiPediaPresent(){
		return isElementPresent(moreOnWikiPedia(), MEDIUMWAIT);
	}
	
	/*
	 * Function to get font weight of more on wikipedia.
	 */
	public String getFontWeightyOfMoreOnWikiPedia(){
		return driver.findElement(moreOnWikiPedia()).getCssValue("font-weight");	
	}
	
	/*
	 * Function to get color of more on wikipedia.
	 */
	public String getColorOfMoreOnWikiPedia(String side){
		return driver.findElement(moreOnWikiPedia()).getCssValue(side);
	}
	
	/*
	 * Function to click on more on wikipedia.
	 */
	public void clickOnMoreOnWikiPedia(){
		safeJavaScriptClick(moreOnWikiPedia(), VERYLONGWAIT);
	}
	
	/*
	 * Locator for header of wikipedia.
	 */
	private By headerOfWikipediaPage(){
		return By.xpath("//h1[@id='firstHeading']");
	}
	
	/*
	 * This function is used for get header for wikipedia page.
	 */
	public String getTextHeaderOfWikipediaPage(){
		return safeGetText(headerOfWikipediaPage(), VERYLONGWAIT);
	}

	/*
	 * Function to get font weight of list about Section.
	 */
	public String getFontWeightyOfListAboutSection(){
		scrollIntoViewThroughJavaScriptExecuter(listAboutSection());
		return driver.findElement(listAboutSection()).getCssValue("font-weight");	
	}

	/*
	 * Function to get font family of list about Section.
	 */
	public String getFontFamilyOfListAboutSection(){
		return driver.findElement(listAboutSection()).getCssValue("font-family");	
	}

	/*
	 * Function to get font size of list about Section.
	 */
	public String getFontSizeOfListAboutSection(){
		return driver.findElement(listAboutSection()).getCssValue("font-size");	
	}

	/*
	 * Function to get text-shadow of list about Section.
	 */
	public String getTextShadowOfListAboutSection(){
		return driver.findElement(listAboutSection()).getCssValue("text-shadow");	
	}

	/*
	 * Function to get color of list about Section.
	 */
	public String getColorOfListAboutSection(String side){
		return driver.findElement(listAboutSection()).getCssValue(side);
	}

	/*
	 * Locator for list about text.
	 */
	private By listAboutText(){
		return By.xpath("//section[@id='nodeListed']//h2[contains(@class,'sectionHeaderFont')]/span");
	}

	/*
	 * Function to get color of list about text.
	 */
	public String getColorOfListAboutText(){
		return driver.findElement(listAboutText()).getCssValue("color");
	}

	/*
	 * Locator for list about image.
	 */
	private By listAboutImage(String nodeNumber){
		return By.xpath("//section[@id='nodeListed']/ul/li["+nodeNumber+"]//img");
	}

	/*
	 * Function to get width of list about image.
	 */
	public String getWidthOfListAboutImage(String nodeNumber){
		return driver.findElement(listAboutImage(nodeNumber)).getCssValue("width");
	}

	/*
	 * Function to get height of list about image.
	 */
	public String getHeightOfListAboutImage(String nodeNumber){
		return driver.findElement(listAboutImage(nodeNumber)).getCssValue("height");
	}

	/*
	 * Function to get outer border color of list about image.
	 */
	public String getOuterBorderColorOfListAboutImage(String nodeNumber){
		return driver.findElement(listAboutImage(nodeNumber)).getCssValue("border-top-color");
	}

	/*
	 * Function to get outer border style of list about image.
	 */
	public String getOuterBorderStyleOfListAboutImage(String nodeNumber){
		return driver.findElement(listAboutImage(nodeNumber)).getCssValue("border-top-style");
	}

	/*
	 * Function to get outer border of list about image.
	 */
	public String getOuterBorderWidthOfListAboutImage(String nodeNumber){
		return driver.findElement(listAboutImage(nodeNumber)).getCssValue("border-top-width");
	}
	
	/*
	 * Function to get inner border of list about image.
	 */
	public String getInnerBorderOfListAboutImage(String nodeNumber){
		return driver.findElement(listAboutImage(nodeNumber)).getCssValue("padding-top");
	}
	
	/*
	 * Locator for list about title.
	 */
	private By listAboutTitle(String nodeNumber){
		return By.xpath("//div[@id='nodeInfo']/section[@id='nodeListed']/ul/li["+nodeNumber+"]/h3/a");
	}

	public void clickListAboutTitle(String nodeNumber){
		safeJavaScriptClick(listAboutTitle(nodeNumber), MEDIUMWAIT);
	}
	
	/*
	 * Function to get font size of list about title.
	 */
	public String getFontSizeOfListAboutTitle(String nodeNumber){
		return driver.findElement(listAboutTitle(nodeNumber)).getCssValue("font-size");
	}

	/*
	 * Function to get font family of list about title.
	 */
	public String getFontFamilyOfListAboutTitle(String nodeNumber){
		return driver.findElement(listAboutTitle(nodeNumber)).getCssValue("font-family");
	}

	/*
	 * Function to get color of list about title.
	 */
	public String getColorOfListAboutTitle(String nodeNumber){
		return driver.findElement(listAboutTitle(nodeNumber)).getCssValue("color");
	}
	
	/*
	 * Function to get font style of list about title.
	 */
	public String getFontStyleOfListAboutTitle(String nodeNumber){
		return driver.findElement(listAboutTitle(nodeNumber)).getCssValue("font-style");
	}
	
	/*
	 * Function to get text of list about title.
	 */
	public String getTextOfListAboutTitle(String nodeNumber){
		return safeGetText(listAboutTitle(nodeNumber), VERYLONGWAIT);
	}
	
	/*
	 * Function to click on list about title.
	 */
	public void clickOnListAboutTitle(String nodeNumber){
		safeJavaScriptClick(listAboutTitle(nodeNumber), VERYLONGWAIT);
	}
	
	/*
	 * Locator for title of header on click on list about title.
	 */
	private By titleOfHeaderClickOnlistAboutTitle(){
		return By.xpath("//header[@id='listHead']/div[@id='listDesc']/h1/span");
	}
	
	/*
	 * Function to get title of header on click title.
	 */
	public String getTitleOfHeaderOnClickTitle(){
		return safeGetText(titleOfHeaderClickOnlistAboutTitle(), VERYLONGWAIT);
	}

	/*
	 * Locator for list about description.
	 */
	private By listAboutDescription(String nodeNumber){
		return By.xpath("//section[@id='nodeListed']/ul/li["+nodeNumber+"]/p");
	}
	
	/*
	 * Function to get text of list about description.
	 */
	public String getTextOfListAboutDescription(String nodeNumber){
		return safeGetText(listAboutDescription(nodeNumber), VERYLONGWAIT);
	}
	
	/*
	 * Function to hey font size of list about description.
	 */
	public String getFontSizeOfListAboutDescription(String nodeNumber){
		return driver.findElement(listAboutDescription(nodeNumber)).getCssValue("font-size");
	}
	
	/*
	 * Function to get color of list about description.
	 */
	public String getColorOfListAboutDescription(String nodeNumber){
		return driver.findElement(listAboutDescription(nodeNumber)).getCssValue("color");
	}

	/*
	 * Function to get font style of list about description.
	 */
	public String getFontStyleOfListAboutDescription(String nodeNumber){
		return driver.findElement(listAboutDescription(nodeNumber)).getCssValue("font-style");
	}
	
	/*
	 * Function to get font family of list about description.
	 */
	public String getFontFamilyOfListAboutDescription(String nodeNumber){
		return driver.findElement(listAboutDescription(nodeNumber)).getCssValue("font-family");
	}
	
	/*
	 * Locator for list about description read more.
	 */
	private By listAboutDescriptionReadMore(String nodeNumber){
		return By.xpath("//section[@id='nodeListed']/ul/li["+nodeNumber+"]/p/a");
	}
	
	/*
	 * This function is used to get text of list about description read more.
	 */
	public String getTextOfListAboutDescriptionReadMore(String nodeNumber){
		return safeGetText(listAboutDescriptionReadMore(nodeNumber), VERYLONGWAIT);
	}
	
	/*
	 * This function is used to get font size of list about description read more.
	 */
	public String getFontSizeOfListAboutDescriptionReadMore(String nodeNumber){
		return driver.findElement(listAboutDescriptionReadMore(nodeNumber)).getCssValue("font-size");
	}
	
	/*
	 * Function to get color of list about description read more.
	 */
	public String getColorOfListAboutDescriptionReadMore(String nodeNumber){
		return driver.findElement(listAboutDescriptionReadMore(nodeNumber)).getCssValue("color");
	}
	
	/*
	 * Function to get font style of list about description read more.
	 */
	public String getFontStyleOfListAboutDescriptionReadMore(String nodeNumber){
		return driver.findElement(listAboutDescriptionReadMore(nodeNumber)).getCssValue("font-style");
	}
	
	/*
	 * Function to get font family of list about description read more.
	 */
	public String getFontFamilyOfListAboutDescriptionReadMore(String nodeNumber){
		return driver.findElement(listAboutDescriptionReadMore(nodeNumber)).getCssValue("font-family");
	}

	/*
	 *Locator for is also found node name.
	 */
	private By isAlsoFoundNodeName(){
		return By.xpath("//section[@id='nodeListopedia']/header[@class='sectionHeaderBG']/h2[@class='sectionHeaderFont']");
	}
	
	/*
	 * Function to get text of is also found node name.
	 */
	public String getTextOfIsAlsoFoundNodeName(){
		return safeGetText(isAlsoFoundNodeName(), VERYLONGWAIT);
	}
	
	/*
	 * Function to get font size is also found node name.
	 */
	public String getFontSizeOfIsAlsoFoundNodeName(){
		return driver.findElement(isAlsoFoundNodeName()).getCssValue("font-size");
	}
	
	/*
	 * Function to get color of is also found node name.
	 */
	public String getColorOfIsAlsoFoundNodeName(){
		return driver.findElement(isAlsoFoundNodeName()).getCssValue("border-top-color");
	}

	/*
	 * Function to get font style of is also found node name.
	 */
	public String getFontStyleOfIsAlsoFoundNodeName(){
		return driver.findElement(isAlsoFoundNodeName()).getCssValue("font-style");
	}
	
	/*
	 * Function to get font family of is also found node name.
	 */
	public String getFontFamilyOfIsAlsoFoundNodeName(){
		return driver.findElement(isAlsoFoundNodeName()).getCssValue("font-family");
	}
	
	/*
	 * Function to get text-shadow of is also found node name. 
	 */
	public String getTextShadowOfIsAlsoFoundNodeName(){
		return driver.findElement(isAlsoFoundNodeName()).getCssValue("text-shadow");
	}
	
	/*
	 * Locator for is also found.
	 */
	private By isAlsoFound(){
		return By.xpath("//section[@id='nodeListopedia']/header[@class='sectionHeaderBG']/h2[@class='sectionHeaderFont']/span");
	}
	
	/*
	 * function to get text of is also found.
	 */
	public String getTextOfIsAlsoFound(){
		return safeGetText(isAlsoFound(), VERYLONGWAIT);
	}
	
	/*
	 * Function to get font size of is also found.
	 */
	public String getFontSizeOfIsAlsoFound(){
		return driver.findElement(isAlsoFound()).getCssValue("font-size");
	}
	
	/*
	 * Function to get color of is also found.
	 */
	public String getColorOfIsAlsoFound(){
		return driver.findElement(isAlsoFound()).getCssValue("border-top-color");
	}

	/*
	 * Function to get font style of is also found.
	 */
	public String getFontStyleOfIsAlsoFound(){
		return driver.findElement(isAlsoFound()).getCssValue("font-style");
	}
	
	/*
	 * Function to get font family of is also found.
	 */
	public String getFontFamilyOfIsAlsoFound(){
		return driver.findElement(isAlsoFound()).getCssValue("font-family");
	}
	
	/*
	 * Function to get text-shadow of is also found.
	 */
	public String getTextShadowOfIsAlsoFound(){
		return driver.findElement(isAlsoFound()).getCssValue("text-shadow");
	}
	
	/*
	 * Locator for is also found link list.
	 */
	private By isAlsoFoundLinkList(String linkNumber){
		return By.xpath("//section[@id='nodeListopedia']/ul//li["+linkNumber+"]/a");
	}
	
	/*
	 * Function to get text of is also found link list.
	 */
	public String getTextOfIsAlsoFoundLinkList(String linkNumber){
		return safeGetText(isAlsoFoundLinkList(linkNumber), VERYLONGWAIT);
	}
	
	/*
	 * Function to click on is also found link list.
	 */
	public void clickIsAlsoFoundLinkList(String linkNumber){
		safeJavaScriptClick(isAlsoFoundLinkList(linkNumber), VERYLONGWAIT);
	}
	
	/*
	 * Locator for show more.
	 */
	private By showMore(){
		return By.id("csstc__details__more");
	}
	
	/*
	 * Function to get class attribute of show more.
	 */
	public String getClassOfShowMore(){
		return driver.findElement(showMore()).getAttribute("class");
	}
	
	/*
	 * Function to click on show more link.
	 */
	public void clickOnShowMore(){
		safeClick(showMore(), VERYLONGWAIT);
	}
	
	/*
	 * Locator for header of fans also vote for.
	 */
	private By fansAlsovoteForHeader(){
		return By.xpath("//div[@id='similarNodes']/div[@class='blockHeaderBg relative']/h3[@class='blockHeaderFont grey']");
	}
	
	/*
	 * This function is used to get text of header of fans also vote for.
	 */
	public String getTextOffansAlsovoteForHeader(){
		return safeGetText(fansAlsovoteForHeader(), VERYLONGWAIT);
	}
	
	/*
	 * Function is used to get font size of header of fans also vote for.
	 */
	public String getFontSizeOffansAlsovoteForHeader(){
		return driver.findElement(fansAlsovoteForHeader()).getCssValue("font-size");
	}
	
	/*
	 * Function used to get color of header of fans also vote.
	 */
	public String getColorOffansAlsovoteForHeader(){
		return driver.findElement(fansAlsovoteForHeader()).getCssValue("color");
	}

	/*
	 * Function is used to get font weight of headers of fans also vote.
	 */
	public String getFontWeightOffansAlsovoteForHeader(){
		return driver.findElement(fansAlsovoteForHeader()).getCssValue("font-weight");
	}
	
	/*
	 * Function to get font family of header of fans also vote.
	 */
	public String getFontFamilyOffansAlsovoteForHeader(){
		return driver.findElement(fansAlsovoteForHeader()).getCssValue("font-family");
	}
	
	/*
	 * Function to get text shadow of header of fans also vote.
	 */
	public String getTextShadowOffansAlsovoteForHeader(){
		return driver.findElement(fansAlsovoteForHeader()).getCssValue("text-shadow");
	}

	/*
	 * Locator for fans also vote for node name.
	 */
	private By fansAlsovoteForNodeName(){
		return By.xpath("//div[@id='similarNodes']/div[@class='blockHeaderBg relative']/h3[@class='blockHeaderFont grey']/em");
	}
	
	/*
	 * This function is used to get text of fans also vote for node name.
	 */
	public String getTextOffansAlsovoteForNodeName(){
		return safeGetText(fansAlsovoteForNodeName(), VERYLONGWAIT);
	}
	
	/*
	 * This function is used to font size of fans also vote for node name.
	 */
	public String getFontSizeOffansAlsovoteForNodeName(){
		return driver.findElement(fansAlsovoteForNodeName()).getCssValue("font-size");
	}
	
	/*
	 * This function is used to hey color of the fans also vote for node name.
	 */
	public String getColorOffansAlsovoteForNodeName(){
		return driver.findElement(fansAlsovoteForNodeName()).getCssValue("color");
	}

	/*
	 * This function is used to get font style of fans also vote for node name.
	 */
	public String getFontStyleOffansAlsovoteForNodeName(){
		return driver.findElement(fansAlsovoteForNodeName()).getCssValue("font-style");
	}
	
	/*
	 * This function is used to get font family of fans also vote for node name.
	 */
	public String getFontFamilyOffansAlsovoteForNodeName(){
		return driver.findElement(fansAlsovoteForNodeName()).getCssValue("font-family");
	}
	
	/*
	 * This function is used to get text-shadow of fans also vote for node name.
	 */
	public String getTextShadowOffansAlsovoteForNodeName(){
		return driver.findElement(fansAlsovoteForNodeName()).getCssValue("text-shadow");
	}
	
	/*
	 * Locator for the fact and data link.
	 */
	private By factAndDataLink(String linkNumber){
		return By.xpath("//div[@id='nodeAbout']/ul/li[1]/div[@id='nodeTags']/a["+linkNumber+"]");
	}
	
	/*
	 * This function is used to check presence of the fact and data link.
	 */
	public boolean isFactAndDataLinkPresent(String linkNumber){
		return isElementPresent(factAndDataLink(linkNumber));
	}
	
	/*
	 * This function is used to click on fact and data link.
	 */
	public void clickOnFactAndDataLink(String linkNumber){
		safeJavaScriptClick(factAndDataLink(linkNumber), VERYLONGWAIT);
	}
	
	/*
	 * This function is used to get text of of fact and data link.
	 */
	public String getTextFactAndDataLink(String linkNumber){
		return safeGetText(factAndDataLink(linkNumber),VERYLONGWAIT);
	}

	/*
	 * Locator for header on click on the fact and data link.
	 */
	private By hedearOnClickfactAndDataLink(){
		return By.xpath("//header[@id='landingHead']/ul[@id='facetSelected']/li[@class='float relative block lowercase btnFlatMBlue toolTip']");
	}
	
	/*
	 * This section is used to hey text of header on click on the fact and data link.
	 */
	public String getTextHeaderOnClickFactAndDataLink(){
		return safeGetText(hedearOnClickfactAndDataLink(),VERYLONGWAIT);
	}
	
	/*
	 * Locator for more or less in fact and data link section.
	 */
	private By moreOrLessFactAndDataLink(String propertyNumber){
		return By.xpath("//div[@id='nodeAbout']/ul/li["+propertyNumber+"]//span[contains(@class,'collapseMore')]");
		//return By.xpath("//span[contains(text(),'Credits (Film)')]/..//following-sibling::*[1]");
	}
	
	/*
	 * This function is used to hey text of more or less in the fact and data section.
	 */
	public String getTextOfMoreOrLessFactAndData(String propertyNumber){
		return safeGetText(moreOrLessFactAndDataLink(propertyNumber),SHORTWAIT);
	}
	
	/*
	 * Locator for more or less in fact and data link section.
	 */
	private By moreOrLessFactAndDataLinkFor33(String propertyNumber){
		//return By.xpath("//div[@id='nodeAbout']/ul/li["+propertyNumber+"]//span[contains(@class,'collapseMore')]");
		return By.xpath("//span[contains(text(),'Credits (Film)')]/..//following-sibling::*[1]");
	}
	/*
	 * This function is used to click on more or less in fact and data section.
	 */
	public void clickMoreOrLessFactAndDataFor15(String propertyNumber){
		safeJavaScriptClick(moreOrLessFactAndDataLink(propertyNumber),MEDIUMWAIT);
	}
	
	/*
	 * This function is used to click on more or less in fact and data section.
	 */
	public void clickMoreOrLessFactAndData(String propertyNumber){
		safeJavaScriptClick(moreOrLessFactAndDataLinkFor33(propertyNumber),MEDIUMWAIT);
	}
	
	/*
	 * Locator for the on the web header.
	 */
	private By onTheWebHeader(){
		return By.xpath("//div[@id='nodeWebLinks']/div[@class='blockHeaderBg relative']/h3[@class='blockHeaderFont grey']");
	}
	
	/*
	 * This function is used for get text of on the web.
	 */
	public String getTextOfOnTheWeb(){
		return safeGetText(onTheWebHeader(),VERYLONGWAIT);
	}
	
	/*
	 * This function is used to check presence of on the web.
	 */
	public boolean isOnTheWebPresent(){
		return isElementPresent(onTheWebHeader());
	}
	
	/*
	 * This function is used to get font style of on the web.
	 */
	public String getFontStyleOfOnTheWeb(){
		return driver.findElement(onTheWebHeader()).getCssValue("font-style");	
	}
	
	/*
	 * This function is used to hey font size of on the web.
	 */
	public String getFontSizeOfOnTheWeb(){
		return driver.findElement(onTheWebHeader()).getCssValue("font-size");	
	}
	
	/*
	 * This function is used to get color of on the web.
	 */
	public String getcolorOfOnTheWeb(){
		return driver.findElement(onTheWebHeader()).getCssValue("color");	
	}
	
	/*
	 * This function is used to get font family of on the web.
	 */
	public String getFontFamilyOfOnTheWeb(){
		return driver.findElement(onTheWebHeader()).getCssValue("font-family");	
	}
	
	/*
	 * This function is used to get text-shadow of the on the web. 
	 */
	public String getTextShadowOfOnTheWeb(){
		return driver.findElement(onTheWebHeader()).getCssValue("text-shadow");	
	}
	
	/*
	 * This function is used to hey font weight of the on the web.
	 */
	public String getFontWeightOfOnTheWeb(){
		return driver.findElement(onTheWebHeader()).getCssValue("font-weight");	
	}
	
	/*
	 * Locator for on the web node name.
	 */
	private By onTheWebNodeName(){
		return By.xpath("//div[@id='nodeWebLinks']/div[@class='blockHeaderBg relative']/h3[@class='blockHeaderFont grey']/em[@class='black serif block']");
	}
	 
	/*
	 * This function is used to get font style of the on the web node name.
	 */
	public String getFontStyleOfOnTheWebNodeName(){
		return driver.findElement(onTheWebNodeName()).getCssValue("font-style");	
	}
	
	/*
	 * This function is used to get font size of on the web node name.
	 */
	public String getFontSizeOfOnTheWebNodeName(){
		return driver.findElement(onTheWebNodeName()).getCssValue("font-size");	
	}
	
	/*
	 * This function is used to get color of the web node name.
	 */
	public String getcolorOfOnTheWebNodeName(){
		return driver.findElement(onTheWebNodeName()).getCssValue("color");	
	}
	
	/*
	 * This function is used to get font family of teh web node name.
	 */
	public String getFontFamilyOfOnTheWebNodeName(){
		return driver.findElement(onTheWebNodeName()).getCssValue("font-family");	
	}
	
	/*
	 * This function is used to get text-shadow of the web node name.
	 */
	public String getTextShadowOfOnTheWebNodeName(){
		return driver.findElement(onTheWebNodeName()).getCssValue("text-shadow");	
	}
	
	/*
	 * locator for on the web link.
	 */
	private By onTheWebLink(){
		return By.xpath("//div[@id='nodeWebLinks']/ul/li/a");
	}
	 
	/*
	 * This function is used to click on the web link.
	 */
	public void clickOnTheWebLink(){
		 safeJavaScriptClick(onTheWebLink(),VERYLONGWAIT);	
	}
	
	/*
	 * Locator for from our partners header.
	 */
	private By fromOurPartnersHeader(){
		return By.xpath("//div[@id='ourPartners']/div[@class='blockHeaderBg relative']/h3");
	}
	
	/*
	 * This function is used to check presence of form our partners header.
	 */
	public boolean isFromOurPartnersHeaderPresent(){
		return isElementPresent(fromOurPartnersHeader());
	}
	
	/*
	 * Locator for from our partner link.
	 */
	private By fromOurPartnerLink(String number){
		return By.xpath("//div[@id='ourPartners']/div[@id='_CI_widget_1']//table[@class='widget_table']/tbody/tr["+number+"]/td/div/a");
	}
	 
	/*
	 * This function is used to click on from our partner link.
	 */
	public void clickOnFromOurPartnerLink(String number){
		 safeJavaScriptClick(fromOurPartnerLink(number),VERYLONGWAIT);	
	}
	
	/*
	 * Locator for headers of page opened after clicking on from our partners link.
	 */
	private By headerOnClickFromOurPartners(){
		return By.xpath("//div[@id='header']/div[@class='header_wrapper']/a");
	}
	
	/*
	 * This function is used to get headers of page opened after clicking on from our partners link.
	 */
	public String getHeaderOnClickFromOurPartners(){
		return driver.findElement(headerOnClickFromOurPartners()).getAttribute("href");
	}
	
	/*
	 * Locator for buzzing link.
	 */
	private By buzzinglink(String number){
		return By.xpath("//footer[@id='buzzing']/ul/li["+number+"]/a");
	}
	 
	/*
	 * This function is used to click on buzzing link.
	 */
	public void clickOnBuzzingLink(String number){
		 safeJavaScriptClick(buzzinglink(number),VERYLONGWAIT);	
	}
	/*
	 * This function is used to hey href attribute for verification.
	 */
	public String gethrefOnBuzzingLink(String number){
		return driver.findElement(buzzinglink(number)).getAttribute("href");
	}
	
	/*
	 * Locator for buzzing link.
	 */
	private By backgroundImageOfHeader(){
		return By.xpath("//div[@id='nodeHead']");
	}
	 
	/*
	 * This function is used to click on buzzing link.
	 */
	public String getBackgroundImageOfHeader(){
		return driver.findElement(backgroundImageOfHeader()).getCssValue("background-image");
	}
	
	/*
	 * This function is used to click on buzzing link.
	 */
	public String getBorderImageWidthOfHeader(){
		return driver.findElement(backgroundImageOfHeader()).getCssValue("border-image-width");
	}
	
	/*
	 * Locator for buzzing link.
	 */
	private By headerImage(){
		return By.xpath("//div[@id='nodeDesc']/div[@class='imageView float']/a/img");
	}
	
	
	/*
	 * This function is used to click on buzzing link.
	 */
	public Boolean isNodeImgePresent(){
		return isElementPresent(headerImage(), VERYLONGWAIT);
	}
	
	/*
	 * Locator for buzzing link.
	 */
	private By rankingStrip(){
		return By.xpath("//div[@id='nodeDesc']//div[@class='rankingBlock float relative']");
	}
	
	
	/*
	 * This function is used to click on buzzing link.
	 */
	public Boolean isRankingStripPresent(){
		return isElementPresent(rankingStrip(), VERYLONGWAIT);
	}
	
	/*
	 * Locator for buzzing link.
	 */
	private By sharedChicklets(){
		return By.xpath("//div[@id='nodeDesc']//div[@class='floatRight relative inline shareBox']");
	}
	
	
	/*
	 * This function is used to click on buzzing link.
	 */
	public Boolean isSharedChickletsPresent(){
		return isElementPresent(sharedChicklets(), VERYLONGWAIT);
	}
	
	/*
	 * This function is used to click on buzzing link.
	 */
	public Boolean isNodeNamePresent(){
		return isElementPresent(nodeName(), VERYLONGWAIT);
	}
	
	/*
	 * This function is used to click on buzzing link.
	 */
	public Boolean isWikiDescriptionPresent(){
		return isElementPresent(textWikiDesc(), VERYLONGWAIT);
	}
	
	/*
	 * Locator for buzzing link.
	 */
	private By pieChart(){
		return By.xpath("//div[@id='nodePie']");
	}
	
	
	/*
	 * This function is used to click on buzzing link.
	 */
	public Boolean isPieChartPresent(){
		return isElementPresent(pieChart(), VERYLONGWAIT);
	}
	
	/*
	 * Locator for buzzing link.
	 */
	private By DataFactProperty(String propertyHeadNumber, String propertyNumber){
		return By.xpath("//div[@id='nodeAbout']/ul/li["+propertyHeadNumber+"]/div[@class='details']/span["+propertyNumber+"]");
	}
	/*
	 * Locator for buzzing link.
	 */
	private By DataFactPropertyWithMore(String propertyHeadNumber, String propertyNumber){
		return By.xpath("//div[@id='nodeAbout']/ul/li["+propertyHeadNumber+"]//div[@class='details']/span["+propertyNumber+"]");
		//return By.xpath("//span[contains(text(),'Credits (Film)')]/following-sibling::*[1]/span["+propertyNumber+"]");
	}
	
	/*
	 * Locator for buzzing link.
	 */
	private By DataFactPropertyWithMoreFor33(String propertyHeadNumber, String propertyNumber){
		//return By.xpath("//div[@id='nodeAbout']/ul/li["+propertyHeadNumber+"]//div[@class='details']/span["+propertyNumber+"]");
		return By.xpath("//span[contains(text(),'Credits (Film)')]/following-sibling::*[1]/span["+propertyNumber+"]");
	}
	
	/*
	 * This function is used to click on buzzing link.
	 */
	public String getTextOfDataFactPropertyWithMoreFor33(String propertyHeadNumber, String propertyNumber){
		return safeGetText(DataFactPropertyWithMoreFor33(propertyHeadNumber,propertyNumber),SHORTWAIT);
	}
	
	/*
	 * This function is used to click on buzzing link.
	 */
	public String getTextOfDataFactPropertyWithMore(String propertyHeadNumber, String propertyNumber){
		return safeGetText(DataFactPropertyWithMore(propertyHeadNumber,propertyNumber),SHORTWAIT);
	}
	
	public boolean isDataFactPropertyPresent(String propertyHeadNumber, String propertyNumber){
		return isElementPresent(DataFactProperty(propertyHeadNumber,propertyNumber),MEDIUMWAIT);
	}
		
	/*
	 * This function is used to click on buzzing link.
	 */
	public String getColorOfDataFactProperty(String propertyHeadNumber, String propertyNumber){
		return driver.findElement(DataFactProperty(propertyHeadNumber,propertyNumber)).getCssValue("color");
	}
	/*
	 * This function is used to click on buzzing link.
	 */
	public String getFontFamilyOfDataFactProperty(String propertyHeadNumber, String propertyNumber){
		return driver.findElement(DataFactProperty(propertyHeadNumber,propertyNumber)).getCssValue("font-family");
	}
	/*
	 * This function is used to click on buzzing link.
	 */
	public String getFontSizeOfDataFactProperty(String propertyHeadNumber, String propertyNumber){
		return driver.findElement(DataFactProperty(propertyHeadNumber,propertyNumber)).getCssValue("font-size");
	}
	/*
	 * This function is used to click on buzzing link.
	 */
	public String getTextOfDataFactProperty(String propertyHeadNumber, String propertyNumber){
		return safeGetText(DataFactProperty(propertyHeadNumber,propertyNumber),VERYLONGWAIT);
	}
	/*
	 * Locator for buzzing link.
	 */
	private By DataFactPropertyHeader(String propertyHeadNumber){
		return By.xpath("//div[@id='nodeAbout']/ul/li["+propertyHeadNumber+"]/span");
	}
	/*
	 * This function is used to click on buzzing link.
	 */
	public String getColorOfDataFactPropertyHeader(String propertyHeadNumber){
		return driver.findElement(DataFactPropertyHeader(propertyHeadNumber)).getCssValue("color");
	}
	/*
	 * This function is used to click on buzzing link.
	 */
	public String getFontFamilyOfDataFactPropertyHeader(String propertyHeadNumber){
		return driver.findElement(DataFactPropertyHeader(propertyHeadNumber)).getCssValue("font-family");
	}
	/*
	 * This function is used to click on buzzing link.
	 */
	public String getFontSizeOfDataFactPropertyHeader(String propertyHeadNumber){
		return driver.findElement(DataFactPropertyHeader(propertyHeadNumber)).getCssValue("font-size");
	}
	/*
	 * This function is used to click on buzzing link.
	 */
	public String getFontWidthOfDataFactPropertyHeader(String propertyHeadNumber){
		return driver.findElement(DataFactPropertyHeader(propertyHeadNumber)).getCssValue("font-weight");
	}
	/*
	 * Locator for buzzing link.
	 */
	private By photoStrip(){
		return By.xpath("//section[@id='nodeImg']");
	}
	/*
	 * This function is used to click on buzzing link.
	 */
	public Boolean isPhotoStripPresent(){
		return isElementPresent(photoStrip(), VERYLONGWAIT);
	}
	/*
	 * This function is used to click on buzzing link.
	 */
	public String getHeightOfPhotoStripImage(){
		return driver.findElement(photoStrip()).getCssValue("height");
	}
	/*
	 * Locator for buzzing link.
	 */
	private By imageInPhotoStrip(String imageNumber){
		return By.xpath("//section[@id='nodeImg']/div[@class='nodeThumb']/a["+imageNumber+"]");
	}
	/*
	 * This function is used to click on buzzing link.
	 */
	public void hoverPhotoStripImage(int imageNumber){
		mouseHover(imageInPhotoStrip(imageNumber+""), VERYLONGWAIT);
	}
	/*
	 * This function is used to click on buzzing link.
	 */
	public void clickPhotoStripImage(int imageNumber){
		safeJavaScriptClick(imageInPhotoStrip(imageNumber+""), VERYLONGWAIT);
	}
	/*
	 * This function is used to click on buzzing link.
	 */
	public String gethrefBeforeClickOnPhotoImageStrip(int imageNumber){
		return driver.findElement(imageInPhotoStrip(imageNumber+"")).getAttribute("href");
	}
	/*
	 * Locator for Node names in fans also vote for block.
	 */
	private By FansAlsoVoteFornodenames(String number){
		return By.xpath("//div[@id='similarNodes']/ul/li["+number+"]/a[@class='black name']");
	}
	/*
	 * Function to get text of node names in fans also vote for block.
	 */
	public String getTextOfFansAlsoVoteFornodenames(String number){
		return safeGetText(FansAlsoVoteFornodenames(number), VERYLONGWAIT);
	}
	/*
	 * Function to get font size of node names in fans also vote for block.
	 */
	public String getFontSizeOfFansAlsoVoteFornodenames(String number){
		return driver.findElement(FansAlsoVoteFornodenames(number)).getCssValue("font-size");
	}
	/*
	 * Function to get color of node names in fans also vote for block.
	 */
	public String getColorOfFansAlsoVoteFornodenames(String number){
		return driver.findElement(FansAlsoVoteFornodenames(number)).getCssValue("color");
	}
	/*
	 * Function to get font family of node names in fans also vote for block.
	 */ 
	public String getFontFamilyOfFansAlsoVoteFornodenames(String number){
		return driver.findElement(FansAlsoVoteFornodenames(number)).getCssValue("font-family");
	}
	/*
	 * Function to get font style of node names in fans also vote for block.
	 */
	public String getFontStyleOfFansAlsoVoteFornodenames(String number){
		return driver.findElement(FansAlsoVoteFornodenames(number)).getCssValue("font-style");
	}
	/*
	 * Function to make click on node names in fans also vote for block.
	 */
	public void clickOnFansAlsoVoteFornodenames(String number){
		safeJavaScriptClick(FansAlsoVoteFornodenames(number), VERYLONGWAIT);
	}
	/*
	 * Locator for sub class of node names in fans also vote for block.
	 */
	private By fansAlsovoteForClass(String number){
			return By.xpath("//div[@id='similarNodes']/ul/li["+number+"]/a[@class='black name']/span");	
	}
	/*
	 * Function to get font size of class of node names in fans also vote for block.
	 */
	public String getFontSizeOffansAlsovoteForClass(String number){
				return driver.findElement(fansAlsovoteForClass(number)).getCssValue("font-size");
	}
	/*
	 * Function to get color of class of node names in fans also vote for block.
	 */
	public String getColorOffansAlsovoteForClass(String number){
		return driver.findElement(fansAlsovoteForClass(number)).getCssValue("color");
	}
	/*
	 * Function to get font style of class of node names in fans also vote for block.
	 */
	public String getFontStyleOffansAlsovoteForClass(String number){
		return driver.findElement(fansAlsovoteForClass(number)).getCssValue("font-style");
	}
	/*
	 * Function to get font family of class of node names in fans also vote for block.
	 */
	public String getFontFamilyOffansAlsovoteForClass(String number){
		return driver.findElement(fansAlsovoteForClass(number)).getCssValue("font-family");
	}
    /*
     * Locator for heading of next page appearing after click on nodes in fans also vote for block.
     */
   private By fansAlsovoteForclick(){
	    return By.xpath("//div[@id='nodeDesc']//h1[@class=' heading']");
    }
   /*
	 * Function to get text of header on next page appearing after click on nodes in fans also vote for block.
	 */
   public String getTextOffansAlsovoteForclick(){
	    return safeGetText(fansAlsovoteForclick(), VERYLONGWAIT);
    }
	/*
	 * Locator for images of nodes in fans also vote for block.
	 */
   private By FansAlsoVoteForImages(String number){
		return By.xpath("//div[@id='similarNodes']/ul/li["+number+"]/a[@role='link']/img");
	}
	/*
	 * Function to check the presence of images of nodes in fans also vote for block.
	 */
	public boolean FansAlsoVoteForImagesPresent(String number){
		return isElementPresent(FansAlsoVoteForImages(number), VERYLONGWAIT);
	}
	/*
	 * Function to make click on images of nodes in fans also vote for block.
	 */
	public void ClickOnFansAlsoVoteForImages(String number){
		safeJavaScriptClick(FansAlsoVoteForImages(number), VERYLONGWAIT);
	}
	/*
	 * Function to get font size of text of images of nodes in fans also vote for block.
	 */
	public String getFontSizeOfFansAlsoVoteForImages(String number){
		return driver.findElement(FansAlsoVoteForImages(number)).getCssValue("border-top-width");
    }
/*
 * Function to get padding top value of images of nodes in fans also vote for block.
 */
	public String getPaddingTopOfFansAlsoVoteForImages(String number){
		return driver.findElement(FansAlsoVoteForImages(number)).getCssValue("padding-top");
    }
    /*
     * Locator for next page appearing after clicking on image in fans also vote for block.
     */
	private By fansAlsovoteForImageClick(){
		    return By.xpath("//div[@id='nodeDesc']//h1[@class=' heading']");
	}
	/*
	 * Function to get text of header of next page appearing after clicking on image in fans also vote for block.
	 */
	public String getTextOffansAlsovoteForImageClick(){
		    return safeGetText(fansAlsovoteForImageClick(), VERYLONGWAIT);
	}
    /*
     * Locator for node images.
     */
	private By NodeImages(){
			return By.xpath("//div[@class='imageView float']/a");
    }
	/*
	 * Function to check the presence of node images.
	 */
	public boolean NodeImagesPresent(){
	     return isElementPresent(NodeImages(), VERYLONGWAIT);
	}
	/*
	 * Function to click on node images.	
	 */
    public void ClickOnNodeImages(){
		safeJavaScriptClick(NodeImages(), VERYLONGWAIT);
	}
    /*
     * Function to get href of node images.
     */
	public String gethrefOfNodeImages(){
		return driver.findElement(NodeImages()).getAttribute("href");
	}
	/*
	 * Function to get width of outer border of node images.
	 */
	public String getOuterBorderWidthOfNodeImages(){
		return driver.findElement(NodeImages()).getCssValue("border-right-width");
	}
	/*
	 * Locator for ranking strip appearing on node page.
	 */
	private By rankingStripRank(){
		return By.xpath("//div[@id='nodeDesc']//div[@class='rankingBlock float relative']/span[@class='rankNumber']");
	}
	/*
	 * Function to check the presence of ranking strip.
	 */
	public boolean rankingStripRankPresent(){
		return isElementPresent(rankingStripRank(), VERYLONGWAIT);
	}
	/*
	 * Function to get font size of ranks in ranking strip.
	 */
	public String getFontSizeOfRankingStriprank(){
		return driver.findElement(rankingStripRank()).getCssValue("font-size");
	}
	/*
	 * Function to get color of ranks in ranking strip.
	 */
    public String getColorOfrankingStripRank(){
    	return driver.findElement(rankingStripRank()).getCssValue("color");
	}
    /*
     * Function to get the weight of font of ranks in ranking strip.
     */
	public String getFontWeightOfrankingStripRank(){
		return driver.findElement(rankingStripRank()).getCssValue("font-weight");
	}
	 /*
     * Function to get font family of ranks in ranking strip.
     */
	public String getFontFamilyOfrankingStripRank(){
		return driver.findElement(rankingStripRank()).getCssValue("font-family");
	}
	/*
     * Function to get text shadow of ranks in ranking strip.
     */
	public String getTextShadowOfrankingStripRank(){
		return driver.findElement(rankingStripRank()).getCssValue("text-shadow");
	}
	/*
     * Locator for copy of ranking strip.
     */	
	private By rankingStripCopy(){
		return By.xpath("//div[@class='rankTotal grey']/span[@class='block cat']");
	}
	/*
     * Function to check the presence of copy of ranking strip.
     */
    public boolean rankingStripCopyPresent(){
		return isElementPresent(rankingStripCopy(), VERYLONGWAIT);
	}
    /*
     * Function to get size of font of copy of ranking strip.
     */
    public String getFontSizeOfRankingStripCopy(){
		return driver.findElement(rankingStripCopy()).getCssValue("font-size");
    }
    /*
     * Function to get color of font of ranking strip copy.
     */
    public String getColorOfrankingStripCopy(){
         return driver.findElement(rankingStripCopy()).getCssValue("color");
    }
    /*
     * Function to get font style of ranking strip copy.
     */
    public String getFontStyleOfrankingStripCopy(){
        return driver.findElement(rankingStripCopy()).getCssValue("font-style");
    }
    /*
     * Function to get font family of ranking strip copy.
     */
    public String getFontFamilyOfrankingStripCopy(){
         return driver.findElement(rankingStripCopy()).getCssValue("font-family");
    }
    /*
     * Locator for header of facts and data block.
     */
    private By factsAndDataHeader(){
		return By.xpath("//div[@class='blockHeaderBg relative']/h3/em");
	}
    /*
     * Function to check the presence of header of facts and data block.
     */
    public boolean isfactsAndDataHeaderPresent(){
		return isElementPresent(factsAndDataHeader(), VERYLONGWAIT);
	}
    /*
     * Function to get font size of header of facts and data block.
     */
    public String getFontSizeOffactsAndDataHeader(){
		return driver.findElement(factsAndDataHeader()).getCssValue("font-size");
    }
    /*
     * Function to get colour of header of facts and data block.
     */
    public String getColorOffactsAndDataHeader(){
         return driver.findElement(factsAndDataHeader()).getCssValue("color");
    }
    /*
     * Function to get font style of header of facts and data block.
     */
    public String getFontStyleOffactsAndDataHeader(){
        return driver.findElement(factsAndDataHeader()).getCssValue("font-style");
    }
    /*
     * Function to get font family of header of facts and data block.
     */
    public String getFontFamilyOffactsAndDataHeader(){
         return driver.findElement(factsAndDataHeader()).getCssValue("font-family");
    }
    /*
     * Function to get text shadow of header of facts and data block.
     */
    public String getTextShadowOffactsAndDataHeader(){
		return driver.findElement(factsAndDataHeader()).getCssValue("text-shadow");
	}
    /*
     * Locator for nodes in facts and data block.
     */
    private By factsAndDataHeaderNode(){
		return By.xpath("//div[@class='blockHeaderBg relative']/h3");
	}
    /*
     * Function to check the presence of nodes in facts and data block.
     */
    public boolean isfactsAndDataHeaderNodePresent(){
		return isElementPresent(factsAndDataHeaderNode(), SHORTWAIT);
	}
    /*
     * Function to get size of font of nodes in facts and data block.
     */
    public String getFontSizeOffactsAndDataHeaderNode(){
		return driver.findElement(factsAndDataHeaderNode()).getCssValue("font-size");
    }
    /*
     * Function to get color of nodes in facts and data block.
     */
    public String getColorOffactsAndDataHeaderNode(){
         return driver.findElement(factsAndDataHeaderNode()).getCssValue("color");
    }
    /*
     * Function to get font weight of nodes in facts and data block.
     */
    public String getFontWeightOffactsAndDataHeaderNode(){
        return driver.findElement(factsAndDataHeaderNode()).getCssValue("font-Weight");
    }
    /*
     * Function to get font family of nodes in facts and data block.
     */
    public String getFontFamilyOffactsAndDataHeaderNode(){
         return driver.findElement(factsAndDataHeaderNode()).getCssValue("font-family");
    }
    /*
     * Function to get text shadow of nodes in facts and data block.
     */
    public String getTextShadowOffactsAndDataHeaderNode(){
		return driver.findElement(factsAndDataHeaderNode()).getCssValue("text-shadow");
    }
    /*
     * Locator for video header on node page.
     */
    private By videoHeader(){
    	return By.xpath("//section[@id='nodeVideo']/header[@class='sectionHeaderBG']/h2");
    	 //section[@id='nodeVideo']/header[@class='sectionHeaderBG']
    }
    /*
     * Function to check the presence of video header.
     */
    public boolean isvideoHeaderPresent(){
		return isElementPresent(videoHeader(), VERYLONGWAIT);
	}
    /*
     * Function to get color of image of video header.
     */
    public String getColorSizeOfvideoHeader(){
		return driver.findElement(videoHeader()).getCssValue("background-image");
    }
    /*
     * Locator for name of nodes in video section.
     */
    private By videoHeaderNodeName(){
		return By.xpath("//section[@id='nodeVideo']/header[@class='sectionHeaderBG']/h2");
	}
    /*
     * Function to check the presence of node names in video section.
     */
    public boolean isvideoHeaderNodeNamePresent(){
		return isElementPresent(videoHeaderNodeName(), VERYLONGWAIT);
	}
    /*
     * Function to get font size of node names in video section.
     */
    public String getFontSizeOfvideoHeaderNodeName(){
		return driver.findElement(videoHeaderNodeName()).getCssValue("font-size");
    }
    /*
     * Function to get color of node names in video section.
     */
    public String getColorOfvideoHeaderNodeName(){
         return driver.findElement(videoHeaderNodeName()).getCssValue("color");
    }
    /*
     * Function to get font weight of node names in video section.
     */
    public String getFontWeightOfvideoHeaderNodeName(){
        return driver.findElement(videoHeaderNodeName()).getCssValue("font-Weight");
    }
    /*
     * Function to get font family of node names in video section.
     */
    public String getFontFamilyOfvideoHeaderNodeName(){
         return driver.findElement(videoHeaderNodeName()).getCssValue("font-family");
    }
    /*
     * Function to get text shadow of node names in video section.
     */
    public String getTextShadowOfvideoHeaderNodeName(){
		return driver.findElement(videoHeaderNodeName()).getCssValue("text-shadow");
	}
    /*
     * Locator for videos in video section.
     */
    private By videoHeaderVideo(){
		return By.xpath("//section[@id='nodeVideo']/header[@class='sectionHeaderBG']/h2/span");
	}
    /*
     * Function to check the presence of videos in video section.
     */
    public boolean isvideoHeaderVideoPresent(){
		return isElementPresent(videoHeaderVideo(), VERYLONGWAIT);
	}
    /*
     * Function to get color of video's text in video section.
     */
    public String getColorOfvideoHeaderVideo(){
         return driver.findElement(videoHeaderVideo()).getCssValue("color");
    }
    /*
     * Function to get text shadow of header in video section.
     */
    public String getTextShadowOfvideoHeaderVideo(){
		return driver.findElement(videoHeaderVideo()).getCssValue("text-shadow");
	}
    /*
     * Locator for playing video.
     */
    private By videoPlay(String number){
  		return By.xpath("//div[@id='nodeInfo']/section[@id='nodeVideo']/ul[1]/li["+number+"]/a/img");
  	}
    /*
     * Function to check the presence of playing video in video section.
     */
    public boolean isvideoPlayPresent(String number){
    	return isElementPresent(videoPlay(number), VERYLONGWAIT);
  	}
    /*
     * Function to get heigth of playing video in video section.
     */
    public String getHeightOfvideoPlay(String number){
    	return driver.findElement(videoPlay(number)).getCssValue("height");
    }
    /*
     * Function to get width of playing video in video section.
     */
    public String getWidthOfvideoPlay(String number){
  		return driver.findElement(videoPlay(number)).getCssValue("width");
    }
    /*
     * Function to make click on video to play in video section.
     */
    public void clickOnvideoPlay(String number){
    	safeClick(videoPlay(number), VERYLONGWAIT);
  	}
    /*
     * Locator for text of videos in video section.  
     */
    private By videoPlayText(String number){
    	return By.xpath("//div[@id='nodeInfo']/section[@id='nodeVideo']/ul/li["+number+"]/p[1]/a");
  	}
    /*
     * Function to check the presence of text of videos in video section.
     */
    public boolean isvideoPlayTextPresent(String number){
  		return isElementPresent(videoPlayText(number), VERYLONGWAIT);
  	}
    /*
     * Function to get font size of text of videos in video section.
     */
    public String getFontSizeOfvideoPlayText(String number){
  		return driver.findElement(videoPlayText(number)).getCssValue("font-size");
    }
    /*
     * Function to get color of text of videos in video section.
     */
    public String getColorOfvideoPlayText(String number){
    	return driver.findElement(videoPlayText(number)).getCssValue("color");
    }
    /*
     * Function to get font weight of text of videos in video section.
     */
    public String getFontWeightOfvideoPlayText(String number){
        return driver.findElement(videoPlayText(number)).getCssValue("font-Weight");
    }
    /*
     * Function to get font family of text of videos in video section.
     */
    public String getFontFamilyOfvideoPlayText(String number){
    	return driver.findElement(videoPlayText(number)).getCssValue("font-family");
    }
    /*
     * Locator for video playing in pop-up.
     */
    private By videoPlaying(){
      	return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']");
      	//return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']/iframe[@title='YouTube video player']");
    }
    /*
     * Function to check the presence of playing video.
     */
    public boolean isvideoPlayingPresent(){
      	return isElementPresent(videoPlaying(), VERYLONGWAIT);
    }
    /*
     * Locator for photo strip numbers in more images section.
     */
    private By photoStripMoreImagesNumber(){
    	return By.xpath("//div[@class='nodeThumb']");
    }
    /*
     * Function to check the presence of photo strip numbers in more images section.
     */
    public Boolean isphotoStripMoreImagesNumberPresent(){
    	return isElementPresent(photoStripMoreImagesNumber(), VERYLONGWAIT);
    }
    /*
     * Locator for images in photo strip in more image section.
     */
    private By imageInPhotoStripNumber(String imageNumber){
    	return By.xpath("//section[@id='nodeImg']/div[@class='nodeThumb']/a["+imageNumber+"]");
    }
    /*
     * Function to hover over photo strip in more images section.
     */
    public void hoverphotoStripMoreImagesNumber(int imageNumber){
    	mouseHover(imageInPhotoStripNumber(imageNumber+""), VERYLONGWAIT);
    }
    /*
     * Locator for photo strip.
     */	
    private By photoStripMoreImages(){
  		return By.xpath("//div[@class='nodeThumb']/a[11]");
  	}
    /*
     * Function to check the presence of photo strip in more images section.
     */
  	public Boolean isphotoStripMoreImagesPresent(){
  		return isElementPresent(photoStripMoreImages(), VERYLONGWAIT);
  	}
  	/*
     * Function to get font size of photo strip in more images section.
     */
  	public String getFontSizeOfphotoStripMoreImages(){
  		return driver.findElement(photoStripMoreImages()).getCssValue("font-size");
  	}
  	/*
     * Function to get color of photo strip in more images section.
     */
  	    public String getColorOfphotoStripMoreImages(){
  		return driver.findElement(photoStripMoreImages()).getCssValue("color");
  	}
  	/*
     * Function to get font weight of photo strip in more image section.
     */
  	public String getFontWeightOfphotoStripMoreImages(){
  		return driver.findElement(photoStripMoreImages()).getCssValue("font-weight");
  	}
  	/*
     * Function to get font family of photo strip in more image section.
     */
  	public String getFontFamilyOfphotoStripMoreImages(){
  		return driver.findElement(photoStripMoreImages()).getCssValue("font-family");
  	}
  	/*
     * Function to get href of photo strip in more image section.
     */
  	public String gethrefphotoStripMoreImages(){
  		return driver.findElement(photoStripMoreImages()).getAttribute("href");
  	}
  	/*
     * Function to make click on photo strip in more images section.
     */
  	public void clickphotoStripMoreImages(){
  		safeJavaScriptClick(photoStripMoreImages(), VERYLONGWAIT);
  	}
  	/*
     * Locator for pie chart image.
     */
  	private By pieChartImage(){
  		return By.xpath("//div[@id='pie_nodePieChart']");
  	}
  	/*
     * Function to check the presence of pie chart.
     */
    public Boolean ispieChartImagePresent(){
  		return isElementPresent(pieChartImage(), VERYLONGWAIT);
  	}
    /*
     * Locator for red down vote percent in pie chart.
     */
    private By pieChartRedPercent(){
		return By.xpath("//div[@id='pie_nodePieChart']/span[@class='absolute block pieText pieText2 white center']");
	}
    /*
     * Function to check the presence of red down vote percent in pie chart.
     */
    public Boolean ispieChartRedPercentPresent(){
		return isElementPresent(pieChartRedPercent(), VERYLONGWAIT);
	}
    /*
     * Function to get color of red down vote percent in pie chart.
     */
  	public String getColorOfpieChartRedPercent(){
      return driver.findElement(pieChartRedPercent()).getCssValue("color");
 	}
  	/*
     * Locator for blue up vote percent in pie chart.
     */
  	private By pieChartBluePercent(){
		return By.xpath("//div[@id='pie_nodePieChart']/span[@class='absolute block pieText pieText1 white center']");
	}
  	/*
     * Function to check the presence of blue up vote percent in pie chart.
     */
  	public Boolean ispieChartBluePercentPresent(){
		return isElementPresent(pieChartBluePercent(), VERYLONGWAIT);
	}
  	/*
     * Function to get color of blue up vote percent in pie chart.
     */
  	public String getColorOfpieChartBluePercent(){
  		return driver.findElement(pieChartBluePercent()).getCssValue("color");
  	}
  	/*
  	 * Locator for up and down icons in pie chart.
  	 */
  	private By pieChartUpDown(){
		return By.xpath("//div[@id='nodeHead']/aside[@class='floatRight absolute']/ul/li[1]");
	}
  	/*
  	 * Function to check the presence of up and down icons in pie chart.
  	 */
  	public Boolean ispieChartUpDownPresent(){
		return isElementPresent(pieChartUpDown(), VERYLONGWAIT);
	}
  	/*
  	 * Locator for 'total votes' text in pie chart.
  	 */
  	private By pieChartTotalVotesHeader(){
		return By.xpath("//div[@id='nodeHead']/aside[@class='floatRight absolute']/ul/li[2]");
	}
  	/*
  	 * Function to check the presence of 'total votes' text in pie chart.
  	 */
  	public Boolean ispieChartTotalVotesHeaderPresent(){
		return isElementPresent(pieChartTotalVotesHeader(), VERYLONGWAIT);
	}
  	/*
  	 * Function to get color of 'total votes' text in pie chart.
  	 */
  	public String getColorOfpieChartTotalVotesHeader(){
    	return driver.findElement(pieChartTotalVotesHeader()).getCssValue("color");
	}
  	/*
  	 * Function to get font style of 'total votes' text in pie chart.
  	 */
  	public String getFontStyleOfpieChartTotalVotesHeader(){
  		return driver.findElement(pieChartTotalVotesHeader()).getCssValue("font-style");
	}
  	/*
  	 * Function to get family of 'total votes' text in pie chart.
  	 */
	public String getFontFamilyOfpieChartTotalVotesHeader(){
    	return driver.findElement(pieChartTotalVotesHeader()).getCssValue("font-family");
	}
	/*
  	 * Locator for number of total votes in pie chart.
  	 */
	private By pieChartTotalVotes(int number){
		return By.xpath("//div[@id='nodeHead']/aside[@class='floatRight absolute']/ul/li["+number+"]");
	}
	/*
  	 * Function to check the presence of number of total votes in pie chart.
  	 */
	public Boolean ispieChartTotalVotesPresent(int number){
		return isElementPresent(pieChartTotalVotes(number), VERYLONGWAIT);
	}
	/*
  	 * Function to get color of number of total votes in pie chart.
  	 */
	public String getColorOfpieChartTotalVotes(int number){
		return driver.findElement(pieChartTotalVotes(number)).getCssValue("color");
	}
	/*
  	 * Function to get font weight of number of total votes in pie chart.
  	 */
	public String getFontWeightOfpieChartTotalVotes(int number){
		return driver.findElement(pieChartTotalVotes(number)).getCssValue("font-weight");
	}
	/*
  	 * Function to get font family of number of total votes in pie chart.
  	 */
	public String getFontFamilyOfpieChartTotalVotes(int number){
		return driver.findElement(pieChartTotalVotes(number)).getCssValue("font-family");
	}
	/*
  	 * Function to check the presence of listed on section.
  	 */
	public Boolean islistedOnSectionPresent(){
		return isElementPresent(listedOnSection(), MEDIUMWAIT);
	}
	/*
  	 * Locator for background in header of listed on section.
  	 */
	private By listedOnSectionBackground(){
		return By.xpath("//section[@id='nodeListed']/header[@class='sectionHeaderBG']");
	}
	/*
  	 * Function to get background image of header of listed on section.
  	 */
	public String getBackgroundImageOflistedOnSectionBackground(){
		return driver.findElement(listedOnSectionBackground()).getCssValue("background-image");	
	}
	/*
  	 * Function to get font weight of header of listed on section.
  	 */
	public String getFontWeightOflistedOnSection(){
		return driver.findElement(listedOnSection()).getCssValue("font-weight");	
	}
   /*
 	* Function to get font family of listed on Section.
 	*/
	public String getFontFamilyOflistedOnSection(){
		return driver.findElement(listedOnSection()).getCssValue("font-family");	
	}
   /*
	* Function to get font size of listed on Section.
	*/
	public String getFontSizeOflistedOnSection(){
		return driver.findElement(listedOnSection()).getCssValue("font-size");	
	}
   /*
	* Function to get text-shadow of listed on Section.
	*/
	public String getTextShadowOflistedOnSection(){
		return driver.findElement(listedOnSection()).getCssValue("text-shadow");	
	}
	/*
	 * Function to get color of list about Section.
	 */
	public String getColorOflistedOnSection(){
		return driver.findElement(listedOnSection()).getCssValue("color");
	}
    /*
     * Locator for text of listed on section.
     */
	private By listedOnSectionText(){
		return By.xpath("//section[@id='nodeListed']/header[@class='sectionHeaderBG']/h2/span");
	}
	/*
	 * Function to check the presence of text of listed on section.
	 */
	public Boolean islistedOnSectionTextPresent(){
		return isElementPresent(listedOnSectionText(), VERYLONGWAIT);
	}
	/*
	 * Function to get color of text of listed on section.
	 */
	public String getColorOflistedOnSectionText(){
		return driver.findElement(listedOnSectionText()).getCssValue("color");
	}
	/*
	 * Function to get text shadow of text of listed on section.
	 */
	public String getTextShadowOflistedOnSectionText(){
		return driver.findElement(listedOnSectionText()).getCssValue("text-shadow");	
	}
	/*
	 * Locator for also found on link.
	 */
	private By isAlsoFoundOnLink(String number){
		return By.xpath("//section[@id='nodeListopedia']/ul/li["+number+"]/a");
	}
	/*
	 * Function to check the presence of also found on link.
	 */
	public void clickOnIsAlsoFoundOnLink(String number){
		safeJavaScriptClick(isAlsoFoundOnLink(number), SHORTWAIT);
	}
	/*
	 * Locator for property drop down.
	 */
	private By propertyDropDown(String number){
		return By.xpath("//section[@id='mainListCnt']/ol[@id='mainList']/li["+number+"]//p[@class='tableAlign visible']/span[@class='block grey data dataColumn']");
	}
	/*
	 * Function to check the presence of property drop down.
	 */
	public Boolean ispropertyDropDownPresent(String number){
		return isElementPresent(propertyDropDown(number), SHORTWAIT);
	}
	/*
	 * Function to get text of property drop down.
	 */
	public String getpropertyDropDown(String number){
		return safeGetText(propertyDropDown(number),SHORTWAIT);
	}
	/*
	 * Locator for over rated directors section.
	 */
	private By overRatedDirectors(){
		 // return By.xpath("//ul[@id='nodeRank']//li[@class='small']/div[@class='container']//div[@class='titleBlock']");
		  return By.xpath("//section[@id='theRanks']/ul[@id='nodeRank']/li[6]/a[@class='black link']/div[@class='container']/div[@class='title relative']/div[@class='titleBlock']/p[@class='listName black']");
		 }
	/*
	 * Function to check the presence of over rated directors section.
	 */
	public Boolean isoverRatedDirectorsPresent(){
		return isElementPresent(overRatedDirectors(), VERYLONGWAIT);
	}
	/*
	 * Function to make click on over rated directors.
	 */
	
	public void clickOnoverRatedDirectors(){
		safeJavaScriptClick(overRatedDirectors(), VERYLONGWAIT);
	}
	/*
	 * Function to get href of over rated directors.
	 */
	public String gethrefOfoverRatedDirectors(){
		return driver.findElement(overRatedDirectors()).getAttribute("href");
	}
	/*
	 * Locator for ranked on section with description.
	 */
	private By rankedOnWithDescription(int number){
		return By.xpath("//section[@id='theRanks']/ul[@id='nodeRank'][1]/li["+number+"]");// written li at a.
	}
	/*
	 * Function to check the presence of ranked on section with description.
	 */
	public Boolean isRankedOnWithDescriptionPresent(int number){
		return isElementPresent(rankedOnWithDescription(number), VERYLONGWAIT);
	}
    /*
     * Locator for listed ranked section.
     */
	private By listedRanked(int number){
		return By.xpath("//section[@id='theRanks']/ul[@id='nodeRank'][1]/li/a/div[@class='container']/div[@class='title relative']/ul[@class='rankBlock whiteBg block float relative']");
	}                                                       ///////a["+number+"]/// 
	/*
	 * Function to check the presence of listed ranked section.
	 */
	public Boolean isListedRankedPresent(int number){
		return isElementPresent(listedRanked(number), SHORTWAIT);
	}
	/*
     * Locator for listed title section.
     */
	private By listedTitle(int number){
		return By.xpath("//section[@id='theRanks']/ul[@id='nodeRank'][1]/li//div[@class='container']/div[@class='title relative']/div[@class='titleBlock']/p[@class='listName black']");
	}
	/*
	 * Function to check the presence of listed title section.
	 */
	public Boolean isListedTitlePresent(int number){
		return isElementPresent(listedTitle(number), SHORTWAIT);
	}
	/*
	 * Locator for listed description section.
	 */
	private By listedDescription(String number){
		return By.xpath("//section[@id='theRanks']/ul[@id='nodeRank'][1]/a["+number+"]/li/div[@class='desc']/p");
	}
	/*
	 * Function to check the presence of listed description section.
	 */
	public Boolean isListedDescriptionPresent(int number){
		return isElementPresent(listedDescription(number+""), SHORTWAIT);
	}
	/*
	 * Function to get height of ranked list box.
	 */
	public String getHeightOfRankedListedBox(int number){
		return driver.findElement(listedRanked(number)).getCssValue("height");
	}
	/*
	 * Function to check the presence of Height Of Ranked Listed Box.
	 */
	public Boolean isRankedListedBoxPresent(int number){
		return isElementPresent(listedRanked(number), SHORTWAIT);
	}
	/*
	 * Function to get width of ranked list box.
	 */
	public String getWidthOfRankedListedBox(int number){
		return driver.findElement(listedRanked(number)).getCssValue("width");
	}
	/*
	 * Function to get box shadow of ranked list box.
	 */
	public String getBoxShadowOfRankedListedBox(int number){
		return driver.findElement(listedRanked(number)).getCssValue("box-shadow");
	}
	/*
	 * Locator for listed ranked section list. 
	 */
	private By listedRankedListedTxt(int number){
		return By.xpath("//section[@id='theRanks']/ul[@id='nodeRank'][1]/li/a/div[@class='container']/div[@class='title relative']/ul[@class='rankBlock whiteBg block float relative']/li[1]");
	}                                                                    ///a["+number+"]
	/*
	 * Function to get font weight of listed ranked section list.
	 */
	public String getFontWeightOfRankedListedListedTxt(int number){
		return driver.findElement(listedRankedListedTxt(number)).getCssValue("font-weight");
	}
	/*
	 * Function to get font size of listed ranked section list.
	 */
	public String getFontSizeOfRankedListedListedTxt(int number){
		return driver.findElement(listedRankedListedTxt(number)).getCssValue("font-size");
	}
	/*
	 * Locator for text of listed ranked section rank.
	 */
	private By listedRankedRankTxt(int number){
		return By.xpath("//section[@id='theRanks']/ul[@id='nodeRank'][1]/li/a/div[@class='container']/div[@class='title relative']/ul[@class='rankBlock whiteBg block float relative']/li[2]");
	}
	/*
	 * Function to get font weight of listed ranked section rank text.
	 */
	public String getFontWeightOfRankedListedRankTxt(int number){
		return driver.findElement(listedRankedRankTxt(number)).getCssValue("font-weight");
	}
	/*
	 * Function to get font size of listed ranked section rank text.
	 */
	public String getFontSizeOfRankedListedRankTxt(int number){
		return driver.findElement(listedRankedRankTxt(number)).getCssValue("font-size");
	}
	/*
	 * Function to get color of listed ranked section rank text.
	 */
	public String getColorOfRankedListedRankTxt(int number){
		return driver.findElement(listedRankedRankTxt(number)).getCssValue("color");
	}
	/*
	 * Locator for listed ranked section rankOf text.
	 */
	private By listedRankedRankOfTxt(int number){
		return By.xpath("//section[@id='theRanks']/ul[@id='nodeRank'][1]/li/a/div[@class='container']/div[@class='title relative']/ul[@class='rankBlock whiteBg block float relative']/li[3]");
	}
	/*
	 * Function to get font weight of listed ranked section rankOf text.
	 */
	public String getFontWeightOfRankedListedRankOfTxt(int number){
		return driver.findElement(listedRankedRankOfTxt(number)).getCssValue("font-weight");
	}
	/*
	 * Function to get font size of listed ranked section rankOf text.
	 */
	public String getFontSizeOfRankedListedRankOfTxt(int number){
		return driver.findElement(listedRankedRankOfTxt(number)).getCssValue("font-size");
	}
	/*
	 * Function to get color of listed ranked section rankOf text.
	 */
	public String getColorOfRankedListedRankOfTxt(int number){
		return driver.findElement(listedRankedRankOfTxt(number)).getCssValue("color");
	}
	/*
	 * Locator for vote list.
	 */
	private By voteListed(){
		return By.xpath("//div[@id='listData']/div[@class='float relative block white serif tab visible rnkrBlueBg']/span[@class='inlineBlock txt']");
	}
	/*
	 * Function to get text of vote list.
	 */
	public String getTextOfVoteList(){
		return safeGetText(voteListed(), VERYLONGWAIT);
	}
	/*
	 * Locator for FACEBOOK.
	 */
	private By facebook(){
		return By.id("share_facebook-share_nodeHead");
	}
	/*
	 * Function to make click on facebook.
	 */
	public void clickOnfacebook(){
		driver.findElement(facebook()).click();
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
	 * Locator for twitter.
	 */
	private By Twitter(){
		return By.id("share_twitter-share_nodeHead");
	}
	/*
	 * Function to make click on twitter.
	 */
	public void clickOnTwitter(){
		safeJavaScriptClick(Twitter(), VERYLONGWAIT);
	}
	/*
	 * Function to switch to next window.
	 */
	public String switchToWindowAndGetTitle(){
		switchToNewWindow();
		return getTitle();
	}
	/*
	 * FUnction to switch to parent window.
	 */
	public void switchToParentWindow(){
			switchToWindow(0);
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
	  * This function is used to check presence of ads block is present
	  */
	 public boolean isnotdisplayPresentads1(){
	  //scrollIntoViewThroughJavaScriptExecuter(ads1());
	  return isElementNotDisplayed(ads1());
	 }
	 /*
		 * Locator for ISListedOnHeader
		 */
		private By ISListedOnHeader(){
			return By.xpath("//section[@id='theRanks']/header[@class='sectionHeaderBG']/h2[@class='sectionHeaderFont']");
		}
		/*
		  * This function is used to check presence of isISListedOnHeader
		  */
		 public boolean isISListedOnHeaderPresent(){
		  return isElementDisplayed(ISListedOnHeader());
		 }
	    /*
		 * Locator for  IsListedOnsection get size
		 */
		private By ISListedOnSize(){
			return By.xpath("//section[@id='theRanks']/ul/li");
		}
		 /*
		 * Locator for  section
		 */
		private By ISListedOn(int num){
			return By.xpath("//section[@id='theRanks']/ul/li["+num+"]");
		}
		public int ISListedOnSizecount(){
			return driver.findElements(ISListedOnSize()).size();
		}
		/*
		  * This function is used to check presence of ISListedOn
		  */
		 public boolean isISListedOnPresent(int num){
		   scrollIntoViewThroughJavaScriptExecuter(ISListedOn(num));
		  return isElementDisplayed(ISListedOn(num));
		 }
		 /*
			 * Locator for FansAlsoViewed section
			 */
			private By FansAlsoViewedHeader(){
				return By.xpath("//section[@id='relatedListsLazy2']/header[@class='sectionHeaderBG']/h3[@class='sectionHeaderFont']");
			}
			/*
			  * This function is used to check presence of FansAlsoViewed section
			  */
			 public boolean isFansAlsoViewedHeaderPresent(){
			  scrollIntoViewThroughJavaScriptExecuter(FansAlsoViewedHeader());
			  return isElementDisplayed(FansAlsoViewedHeader());
			 }
		
	 /*
		 * Locator for FansAlsoViewed section
		 */
		private By FansAlsoViewed(int num){
			return By.xpath("//section[@id='relatedListsLazy2']/ul["+num+"]");
		}
		
		/*
		  * This function is used to check presence of FansAlsoViewed section
		  */
		 public boolean isFansAlsoViewedPresent(int num){
		 scrollIntoViewThroughJavaScriptExecuter(FansAlsoViewed(num));
		  return isElementDisplayed(FansAlsoViewed(num));
		 }
		 /*
		  * This function is used to check presence of FansAlsoViewedHeader
		  */
		 public boolean isnotdisplayPresentFansAlsoViewedHeader(){
		    return isElementNotDisplayed(FansAlsoViewedHeader());
		 }
		 /*
			 * Locator for  Lists about header
			 */
			private By ListsAboutHeader(){
				return By.xpath("//section[@id='nodeListed']/header[@class='sectionHeaderBG']/h2[@class='sectionHeaderFont']");
			}
			/*
			  * This function is used to check presence of Lists about header
			  */
			 public boolean isListsAboutHeaderPresent(){
			  //scrollIntoViewThroughJavaScriptExecuter(ListsAboutHeader());
			  return isElementDisplayed(ListsAboutHeader());
			 }
			 /*
				 * Locator for  Lists about header Section
				 */
				private By ListsAboutHeaderSection(int num){
					return By.xpath("//section[@id='nodeListed']/ul/li["+num+"]");
				}
				/*
				  * This function is used to check presence of Lists about header Section
				  */
				 public boolean isListsAboutHeaderSectionPresent(int num){
				 // scrollIntoViewThroughJavaScriptExecuter(ListsAboutHeaderSection(num));
				  return isElementDisplayed(ListsAboutHeaderSection(num));
				 }
			 
}
