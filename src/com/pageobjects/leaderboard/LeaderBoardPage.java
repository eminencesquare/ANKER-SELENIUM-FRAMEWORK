package com.pageobjects.leaderboard;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.Select;

import com.selenium.SafeActions;

public class LeaderBoardPage extends SafeActions {
	private WebDriver driver;
	/*
	 * Constructor for the page.
	 */
	public LeaderBoardPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	/*
	 * Locator for categores dropdown in leader board page.
	 */
	private By categoriesDropdown(){
		return By.xpath("//header[@id='leaderHead']/h1/div[@id='leaderDrop']/div[@id='leaderCat']/select");
	}
	/*
	 * Function to make click on categories dropdown.
	 */
	public void clickOncategoriesDropdown(){
		safeClick(categoriesDropdown(), MEDIUMWAIT);
	}
	/*
	 * Function to get name of category on combo box.
	 */
	public String getTextOfCategoryOnComboBox(){
		String selectedOption = new Select(driver.findElement(categoriesDropdown())).getFirstSelectedOption().getText();

		return selectedOption;
	}
	/*
	 * Locator for categories dropdown options in leader board page.
	 */
	private By categoriesDropdownOptions(String opt){
		return By.xpath("//header[@id='leaderHead']/h1/div[@id='leaderDrop']/div[@id='leaderCat']/select/option[contains(text(),'"+opt+"')]");
	}
	/*
	 * Function to make click on any option in categories dropdown.
	 */
	public void clickOncategoriesDropdownOptions(String opt){
		safeClick(categoriesDropdownOptions(opt), MEDIUMWAIT);
		waitForPageToLoad(30);
	}
	/*
	 * Locator for top ranker Image.
	 */
	private By topRankerImage(){
		return By.xpath("//div[@id='leaderBody']/div[@id='leaderInfo']/div[@class='relevantCatg']/a/img");
	}
	/*
	 * Function to get height and width of image shown in top ranker.
	 */
	public String[] getHeightAndWidthOfTopRankerImage(){
		String[] arr = new String[2];
		arr[0] = driver.findElement(topRankerImage()).getCssValue("width");
		arr[1] = driver.findElement(topRankerImage()).getCssValue("height");
		return arr;
	}
	/*
	 * Locator for top ranker Header.
	 */
	private By topRankerHeader(){
		return By.xpath("//div[@id='leaderBody']/div[@id='leaderInfo']/div[@class='relevantCatg']/h4/a");
	}
	/*
	 * Function to get size of the header.
	 */
	public String getSizeOfTopRankerHeader(){
		return driver.findElement(topRankerHeader()).getCssValue("font-size");
	}
	/*
	 * Locator for image in list other than top ranker.
	 */
	private By otherRankerImage(int num){
		return By.xpath("//div[@id='leaderBody']/div[@id='leaderInfo']/div[@class='boardView rankerBlock clear']/ol/li["+num+"]/a[1]/img");
	}
	/*
	 * Function to get height and width of image in list other than top ranker.
	 */
	public String[] getHeightAndWidthOfOtherRankerImage(int num){
		String[] arr = new String[2];
		arr[0] = driver.findElement(otherRankerImage(num)).getCssValue("width");
		arr[1] = driver.findElement(otherRankerImage(num)).getCssValue("height");
		return arr;
	}
	/*
	 * Locator for other ranker header.
	 */
	private By otherRankerHeader(int num){
		return By.xpath("//div[@id='leaderBody']/div[@id='leaderInfo']/div[@class='boardView rankerBlock clear']/ol/li["+num+"]/a[2]");
	}
	/*
	 * Function to get size of other ranker header.
	 */
	public String getSizeOfOtherRankerHeader(int num){
		return driver.findElement(otherRankerHeader(num)).getCssValue("font-size");
	}
	/*
	 * Function to make click on the other ranker header.
	 */
	public void clickOnOtherRankerHeader(int num){
		safeClick(otherRankerHeader(num), SHORTWAIT);
	}
	/*
	 * Function to get href of other ranker header.
	 */
	public String getHrefOfOtherRankerHeader(int num){
		return driver.findElement(otherRankerHeader(num)).getAttribute("href");
	}
	/*
	 * Locator For ranker blue ribbon in top ranker.
	 */
	private By topRankerRibbon(){
		return By.xpath("//div[@id='leaderRibbon']");
	}
	/*
	 * Function to check the presence of ribbon.
	 */
	public boolean isTopRankerRibbonPresent(){
		return isElementPresent(topRankerRibbon());
	}
	/*
	 * Locator for top ranker's profile score.
	 */
	private By topScoreBar(int num){
		return By.xpath("//div[@id='leaderBody']/div[@id='leaderInfo']/div[@class='relevantCatg']/div[@class='rankStats']/span["+num+"]");
	}
	/*
	 * Function to check the presence of top ranker's profile score.
	 */
	public boolean isTopScoreBarPresent(int num){
		return isElementPresent(topScoreBar(num));
	}
	/*
	 * Function to get text of top ranker's profile score.
	 */
	public String getTextOfTopProfileScore(int num){
		return safeGetText(topScoreBar(num), MEDIUMWAIT);
	}
	/*
	 * Function to hover over other ranker header.
	 */
	public void hoverOverOtherRankerHeader(int num){
		mouseHover(otherRankerHeader(num), MEDIUMWAIT);
	}
	/*
	 * Locator for popUp box on hover on other ranker header.
	 */
	private By hoverBoxOfOtherRankerHeader(){
		return By.xpath("//div[@id='openUPInfo']");
	}
	/*
	 * Function to check the presence of popUp box on hovering over other ranker header.
	 */
	public boolean isHoverBoxOfOtherRankerHeaderPresent(){
		return isElementPresent(hoverBoxOfOtherRankerHeader());
	}
	/*
	 * Locator for other ranker section.
	 */
	private By otherRankerSection(int num){
		return By.xpath("//div[@id='leaderBody']/div[@id='leaderInfo']/div[@class='boardView rankerBlock clear']/ol/li["+num+"]");
	}
	/*
	 * Function to hover over other ranker section.
	 */
	public void hoverOverOtherRankerSection(int num){
	     mouseHover(otherRankerSection(num), MEDIUMWAIT);
	}
	/*
	 * Function to check the presence of other ranker section.
	 */
	public boolean isOtherRankerSectionPresent(int num){
		scrollIntoViewThroughJavaScriptExecuter(otherRankerSection(num));
		return isElementPresent(otherRankerSection(num));
	}
	/*
	 * Locator for other ranker section's score bar.
	 */
	private By scoreBar(int num,int number){
		return By.xpath("//div[@id='leaderBody']/div[@id='leaderInfo']/div[@class='boardView rankerBlock clear']/ol/li["+num+"]/div[@class='floatRight scoreCont']/span["+number+"]");
	}
	/*
	 * Function to check the presence of other ranker section's score bar after hovering over the section.
	 */
	public boolean isScoreBarPresent(int num,int number){
		return isElementPresent(scoreBar(num,number));
	}
	/*
	 * Locator for other ranker section's profile score.
	 */
	private By scoreBarProfileScore(int num){
		return By.xpath("//div[@id='leaderBody']/div[@id='leaderInfo']/div[@class='boardView rankerBlock clear']/ol/li["+num+"]/div[@class='floatRight scoreCont']/span[1]/div[@class='scoreCntr']/div[@class='relative inlineBlock pieChart']/span[5]");
	}
	/*
	 * Function to get color of profile score.
	 */
	public String getColorOfScoreBarProfileScore(int num){
		System.out.println("aaaaaaaaaaaa");
		//mouseHover(otherRankerSection(num), MEDIUMWAIT);
//		 Actions builder = new Actions(driver);
//		    WebElement HoverElement = driver.findElement(scoreBarProfileScore(num));
//		    builder.moveToElement(HoverElement)..build().perform();
		
		return driver.findElement(scoreBarProfileScore(num)).getCssValue("background-color");
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		String className = (String)js.executeScript("return arguments[0].getCssValue('background-color');",driver.findElement(scoreBarProfileScore(num)));
//		return className;
		
	}
	/*
	 * Locator for primer block on leaderBoard page.
	 */
	private By primerBlock(){
		return By.xpath("//div[@id='leaderBody']/aside[@id='sidebar']/div[@id='leaderBoardSide']");
	}
	/*
	 * Function to check the presence of primer block in rigth trail on leaderBoard page.
	 */
	public boolean isPrimerBlockPresent(){
		return isElementPresent(primerBlock());
	}
	/*
	 * Locator for Super Ranky in LeaderBoard Primer block.
	 */
	private By primerBlockRankyAndDescription(String txt){
		if(txt.equalsIgnoreCase("image"))
		  return By.xpath("//div[@id='leaderBody']/aside[@id='sidebar']/div[@id='leaderBoardSide']/img");
		else
			return By.xpath("//div[@id='leaderBody']/aside[@id='sidebar']/div[@id='leaderBoardSide']/p");
	}
	/*
	 * Function to check the presence of Super Ranky in LeaderBoard Primer block.
	 */
	public boolean isPrimerBlockRankyPresent(String txt){
		return isElementPresent(primerBlockRankyAndDescription(txt));
	}
	/*
	 * Function to check the presence of description in LeaderBoard Primer block.
	 */
	public String getTextOfPrimerBlockDescription(String txt){
		return safeGetText(primerBlockRankyAndDescription(txt), VERYSHORTWAIT);
	}
	/*
	 * Locator for Category icons in category Leader block on leaderBoard page.
	 */
	private By categoryBlockIcon(int num){
		return By.xpath("//div[@id='leaderBody']/aside[@id='sidebar']/div[@id='categoryLeaders']/ol/li["+num+"]/span[1]");
	}
	/*
	 * Function to check the presence of all the category icons in category leader block.
	 */
	public boolean isCategoryBlockIconsPresent(int num){
		return isElementPresent(categoryBlockIcon(num));
	}
	/*
	 * Function to make click on category icons in category leader block.
	 */
	public void clickOnCategoryBlockIcons(int num){
		safeClick(categoryBlockIcon(num), VERYSHORTWAIT);
		waitForPageToLoad();
	}
	/*
	 * Locator for category description in category Leader block on leaderBoard page.
	 */
	private By categoryBlockDescription(int num){
		return By.xpath("//div[@id='leaderBody']/aside[@id='sidebar']/div[@id='categoryLeaders']/ol/li["+num+"]/span[2]//span[@class='block rnkrGreen lowerCase leaderRank']");
	}
	/*
	 * Function to get text of category description in category Leader block on leaderBoard page.
	 */
	public String getTextOfCategoryBlockDescription(int num){
		return safeGetText(categoryBlockDescription(num), SHORTWAIT);
	}
	/*
	 * Locator for category name in category Leader block on leaderBoard page.
	 */
	private By categoryLeadersProfileLinks(int num){
		return By.xpath("//div[@id='leaderBody']/aside[@id='sidebar']/div[@id='categoryLeaders']/ol/li["+num+"]/span[2]/span[@class='float']//a");
	}
	/*
	 * Function to check whether the name link in category leader block is clickable or not.
	 */
	public boolean isCategoryLeadersProfileLinksClickable(int num){
		return isElementClickable(categoryLeadersProfileLinks(num), MEDIUMWAIT);
	}
	/*
	 * Function to get href of the name link in category leader block.
	 */
	public String getHrefOfCategoryLeadersProfileLinks(int num){
		return driver.findElement(categoryLeadersProfileLinks(num)).getAttribute("href");
	}
	/*
	 * Function to make click on name link in category leader block.
	 */
	public void clickOnCategoryLeadersProfileLinks(int num){
		safeJavaScriptClick(categoryLeadersProfileLinks(num), MEDIUMWAIT);
	}
}
