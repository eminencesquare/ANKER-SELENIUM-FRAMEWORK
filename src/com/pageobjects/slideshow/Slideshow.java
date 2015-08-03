package com.pageobjects.slideshow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.CloseWindow;
import org.testng.Assert;
import com.selenium.SafeActions;

public class Slideshow extends SafeActions{
	
	private WebDriver driver;
	
	/*
	 * Locator for node heading.
	 */
	private By nodeHeading(){
		  return By.xpath("//span[@class='oNode']");
	}
	
	/*
	 * Locator for getting current slide number.
	 */
	private By currentSlideNo(){
		return By.xpath("//div[@class='relative slideTrackCntr']");
	}
	
	/*
	 * Locator for node number.
	 */
	private By nodeNumber(int linum){
		//return By.xpath("//div[@class='float rank center']/span[@class='rank tableAlign']");
		 return By.xpath("//ol[@class='mainList relative']/li["+linum+"]//span[@class='rank tableAlign']");
	}
	
	/*
	 * Locator for mini-carousel next button.
	 */
	private By 	miniCarouselNext(){
		//return By.xpath("//div[@id='slideNext']//span[contains(@class,'float block shape arrowRight')]");
		return By.xpath("//span[contains(@id,'slideThumbNext_')]/i");
	}
	
	/*
	 * Locator for list header.
	 */
	private By 	listHeader(){
		return By.xpath("//div[@id='listDesc']/h1[@class='width100']/span[contains(@class,'name internal pointer')]");
	}


	/*
	 * Locator for mini-carousel previous button.
	 */
	private By 	miniCarouselPrevious(){
		//float absolute pointer whiteBg slidePrev hidden
		return By.xpath("//span[contains(@class,'float absolute pointer whiteBg slidePrev hidden')]/i");
		//return By.xpath("//div[@id='slidePrev']//span[contains(@class,'float block shape arrowLeft')]");
	}
	
	/*
	 * Locator for next slide.
	 */
	private By nextSlide(){
		//return By.xpath("//div[@class='width100 center hidden slideCount']/span[@title='Next slide']");
		return By.xpath("//div[@class='float absolute pointer hidden slideImgNext']/div[@title='Next slide']");
		//div[@class='float absolute pointer hidden slideImgNext']/div[@title='Next slide']/span
	}
	
	/*
	 * Locator for node image.
	 */
	private By nodeImg(){
		return By.xpath("//div[@class='relative width100 sub center']/a[contains(@href, 'pics')]/img[contains(@src, 'user_node_img')]");
		//return By.xpath("//a[contains(@href, 'pics')]/img[contains(@src, 'user_node_img')]");
	}
	
	/*
	 * Locator for node image zoom.
	 */
	private By nodeImgzoom(){
		
		return By.xpath("//span[contains(@class, 'slideMagnify')]");
	}
	
	/*
	 * This function us used to get webdriver object.
	 */
	public Slideshow(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	/*
	 * This function is used to get slide number.
	 */
	public String getSlideNo(){
		//scrollIntoViewThroughJavaScriptExecuter(currentSlideNo());
		return waitForText(currentSlideNo(), LONGWAIT);
	}
	
	/*
	 * This function is used to click on next slide.
	 */
	public void clickNext(){
		//scrollIntoViewThroughJavaScriptExecuter(nextSlide());
		safeJavaScriptClick(nextSlide(), VERYLONGWAIT);
	}
	
	/*
	 * This function is used to click on previous slide.(previous button on big images)
	 */
	public void clickPrevious(){
		safeJavaScriptClick(previousSlide(), VERYLONGWAIT);
	}
	
	/*
	 * This function is used to mouse hovering on node image.
	 */
	public void mousehovernodeimg(){
		//scrollIntoViewThroughJavaScriptExecuter(nodeImg());
		mouseHover(nodeImg(), VERYLONGWAIT);
	}
	
	/*
	 * This function to get attribute for node image.
	 */
	public boolean nodeImageAttribute(){
		return isElementVisible(nodeImgzoom(), SHORTWAIT);
		//return driver.findElement(nodeImgzoom()).getAttribute("style");
	}
	
	/*
	 * This function is used to click on node image.
	 */
	public PicsPage clickOnNodepic(){
		scrollIntoElementView(nodeImg());
		safeClick(nodeImg());
		return new PicsPage(driver);
	}
	
	/*
	 * Function is used to get node number.
	 */
	public String getNodeNumber(int linum){
		return waitForText(nodeNumber(linum), LONGWAIT);
	}
	
	public void carousel_nextSlideHover(){
		//scrollIntoViewThroughJavaScriptExecuter(nextSlide());
		mouseHoverJScript(nextSlide(),"",VERYLONGWAIT);
	}
		
	/*
	 * This function is used for getting current slide number.
	 */
	public void miniCarouselNextHover(){
		scrollIntoViewThroughJavaScriptExecuter(miniCarouselNext());
		mouseHover(miniCarouselNext(),VERYLONGWAIT);
	}
		
	/*
	 * This function is used for getting current slide number.
	 */
	public void miniCarouselPreviousHover(){
		mouseHover(miniCarouselPrevious(),VERYLONGWAIT);
	}
		
	/*
	 * This function is used for getting current slide number.
	 */
	public void miniCarouselPreviousClick(){
		safeJavaScriptClick(miniCarouselPrevious(),VERYLONGWAIT);
	}
		
	/*
	 * This function is used for getting current slide number.
	 */
	public void miniCarouselNextClick(){
		safeJavaScriptClick(nextSlideList(), VERYLONGWAIT);
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
	}
				
	/*
	 * Locator for previous slide.(previous button on big images)
	 */
	private By previousSlide(){
		//return By.xpath("//span[contains(@id,'slideThumbPrev_')]/i");
		//return By.xpath("//*[@id='slideImgPrev']/div/span");
		return By.xpath("//div[@class='float absolute pointer hidden slideImgPrev']/div[@title='Previous slide']/i");
	}
		
	/*
	 * This function is used to hey last slide number .
	 */
	public String getLastSlideNo(){
		return waitForText(lastSlideNo(), LONGWAIT);
	}
		
	/*
	 * Locator for getting last slide number.
	 */
	private By lastSlideNo(){
		return By.xpath("//div[@class='width100 center hidden slideCount']//span[@class='of']");
	}
		
	/*
	 * locator for Next List button.
	 */
	private By nextSlideList(){
		//
		return By.xpath("//span[contains(@id,'slideThumbNext_')]/i[@class='block rnkrBlue']");
		//return By.xpath("//div[@class='float absolute pointer hidden slideImgNext']/span[contains(@class,'float block shape arrowRight')]");
	}
		
	/*
	 * Locator for slide to click in mini carousel.
	 */
	private By slide(int lastSlideNo){
		return By.xpath("//div[@class='relative slideTrackCntr']/ul/li["+lastSlideNo+"]/img");
	}
		
	/*
	 * Locator for next button NEXT>>.
	 */
	private By nextButton(){
		return By.xpath("//div[@class='width100 center hidden slideCount']/span[@class='inlineBlock relative btnWhite nextBtn']");
	}
		
	/*
	 * Locator for Next List button.
	 */
	private By nextListButton(){
		return By.xpath("//div[@class='width100 center hidden slideCount']/span[@class='inlineBlock relative btnWhite nextBtn']");
	}
		
	/*
	 * Locator for  previous button <<PREV.
	 */
	private By previousButton(){
		return By.xpath("//div[@class='width100 center hidden slideCount']/span[@class='relative btnWhite prevBtn hidden']");
	}
		
	/*
	 * Locator for first slide button(|<).
	 */
	private By firstSlideButton(){
		return By.xpath("//div[@class='width100 center hidden slideCount']/span[contains(@title,'First slide')]");
		//return By.xpath("//div[@class='width100 center hidden slideCount']/span[contains(@class,'relative btnWhite firstBtn inlineBlock')]");
	}
		
	/*
	 * Locator for previousSlideButton<<
	 */
	private By  previousSlideButton(){
		return By.xpath("//div[@class='width100 center hidden slideCount']/span[contains(@title,'Previous slide')]");
	}
	/*
	 * Function to get color of previousSlideButton<<
	 */
	public String getColorOfpreviousSlideButton(String side){
		return driver.findElement(previousSlideButton()).getCssValue("background-color");
		}
	/*
	 * This function is used to click on the previousSlideButton<<.
	 */
	public void clickOnpreviousSlideButton(){
		safeJavaScriptClick(previousSlideButton(), VERYLONGWAIT);
	}
		
		
	/*
	 * This function is used to click on the next button NEXT>>.
	 */
	public void clickOnNextButton(){
		safeJavaScriptClick(nextButton(), VERYLONGWAIT);
	}
	/*
	 * Function to get color of NextButton
	 */
	public String getColorOfnextButton(String side){
		return driver.findElement(nextButton()).getCssValue("background-color");
		}
		
	/*
	 * This function is used to click on the Next List button.
	 */
	public void clickOnNextListButton(){
		safeJavaScriptClick(nextListButton(), VERYLONGWAIT);
		//waitForPageToLoad();
	}
		
	/*
	 * This function is used to click on previous button <<PREV.
	 */
	public void clickOnPreviousButton(){
		safeJavaScriptClick(previousButton(), VERYLONGWAIT);
	}
	/*
	 * This function is used to click on first slide button |<.
	 */
	public void clickOnFirstSlideButton(){
		safeClick(firstSlideButton(), VERYLONGWAIT);
		
	}
	/*
	 * Locator for last slide button (>|).
	 */
	private By lastSlideButton(){
		return By.xpath("//div[contains(@id,'slideCount')]/span[@class='inlineBlock relative btnWhite lastBtn']");
	}
	/*
	 * Function to click on last slide button (>|).
	 */
	public void clickOnLastSlideButton(){
		safeJavaScriptClick(lastSlideButton(), SHORTWAIT);
	}
	/*
	 * Function to get number of last slide(total number of slide).
	 */
	public int lastSlideNoCal(){
		String lastSlideNo=getLastSlideNo();
		String lastSlide = lastSlideNo.substring(3);
		int slideIntegerBefore = Integer.parseInt(lastSlide);
		return (slideIntegerBefore);
	}
	/*
	 * Locator for hover on slide
	 */
	private By hoveronslide(){
		return By.xpath("//div[@class='relative slideTrackCntr']");
	}
	/*
	 * Function to hover over the slide
	 */
	public void hoverOverslide(){
		mouseHover(hoveronslide(), SHORTWAIT);
	}
	//relative slideTrackCntr
	/*
	 * This function is used to click on the last slide in the mini carousel.
	 */
	public void clickOnLastSlide(){
		int slideIntegerBefore = lastSlideNoCal();
		int slideIntegerBefore1=slideIntegerBefore/7;
		
		for (int i_slideListNext =1; i_slideListNext<=slideIntegerBefore1; i_slideListNext++){
			 hoverOverslide();
			 try{
				 Thread.sleep(3000);
			 }catch(Exception e){}
			safeJavaScriptClick(nextSlideList(), MEDIUMWAIT);
			try{
				Thread.sleep(3000);
			}catch(Exception e){}
		}
		safeJavaScriptClick(slide(slideIntegerBefore), VERYLONGWAIT);	
	}
	/*
	 * This function is used to get text of list heading of the displayed list.
	 */
	public String getListHading(){
		return safeGetText(listHeader(), VERYLONGWAIT);
	}
		
	/*
	 * This function is used to click on given slide in the carousel.
	 */
	public void clickOnSlide(int slideNo){
		safeJavaScriptClick(slide(slideNo), VERYLONGWAIT);	
	}
	/*
	 * Locator for slide to click in mini carousel.
	 */
	private By SlideMiniCarousel(int num){
		return By.xpath("//div[@class='relative slideTrackCntr']/ul/li["+num+"]");
	}
	/*
	 * This function is used to click on given slide in the carousel.
	 */
	public void clickOnSlideMiniCarousel(int num){
		safeJavaScriptClick(SlideMiniCarousel(num), VERYLONGWAIT);	
	}
	
	/*
	 * This function is used to get color of SlideMiniCarousel. .
	 */
	public String getColorOfSlideMiniCarousel(int num){
		return driver.findElement(SlideMiniCarousel(num)).getCssValue("border-top-color");
		}
		
	/*
	 * This function is used to get text for the slide heading
	 */
	public String getSlideHeading(){
		return safeGetText(nodeHeading(), MEDIUMWAIT);
	}
		
	/*
	 * This function is used to check whether image is present in the Slide panel.
	 */
	public boolean isimagePresent(){
		return isElementPresent(nodeImg(), LONGWAIT);
	}
	
	/*
	 * Locator for images of related links present in the next slide after last slide.
	 */
	private By imgNextToLastSlide(int imageNumber){
		return By.xpath("//section[@id='mainListCnt']/ul[@id='lastSlideContent']/li["+imageNumber+"]/a/img");
		//return By.xpath("//div[@class='relative width100 img clear center']/ul[@id='lastSlideContent']/li["+imageNumber+"]/a/img");
	}
		
	/*
	 * This function is used to check images on the next slide of the last slide in carousel.
	 */
	public boolean isImgNextToLastSlidePresent(int imageNumber){
		return isElementPresent(imgNextToLastSlide(imageNumber), LONGWAIT);
	}
		
	/*
	 * This function is used to click on images of related links.(Images present on the next slide after the last slide).
	 */
	public void clickOnImgNextToLastSlide(int imageNumber){
		safeJavaScriptClick(imgNextToLastSlide(imageNumber), VERYLONGWAIT);
	}
		
	/*
	 * Locator for  View Again link.
	 */
	private By viewAgain(){
		return By.xpath("//div[@id='lastSlideHead']/span[@id='lastSlideHead_back']");
	}
		
	/*
	 * This function is used to click on View Again link.
	 */
	public void clickOnViewAgain(){
		safeJavaScriptClick(viewAgain(), VERYLONGWAIT);
	}
		
	/*
	 * Locator for text for image present for related link page.(Next slide after last slide.)
	 */
	private By txtOfImgNextToLastSlide(int imageNumber){
		return By.xpath("//section[@id='mainListCnt']/ul[@id='lastSlideContent']/li["+imageNumber+"]/a");
	}
		
	/*
	 * This function is used to get text for image present for related link page.(Next slide after last slide.)
	 */
	public String getTextOfImgNextToLastSlide(int imageNumber){
		//return safeGetText(txtOfImgNextToLastSlide(imageNumber), MEDIUMWAIT);
		return driver.findElement(txtOfImgNextToLastSlide(imageNumber)).getAttribute("href");
		//return driver.findElement(imgNextToLastSlide(imageNumber)).getAttribute("href");
	}
	/*
	 * Locator for upvote.
	 */
	private By upVote(){
		return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li[1]/div[@class='float vote']/div[@class='float relative'][1]/span[@class='float relative block btnVote pointer up off']/i");
	}
	/*
	 * Function to click on upvote.
	 */
	public void clickOnUpvote(){
		try{
		safeClick(upVote(), VERYLONGWAIT);
		}
		catch(Exception e){
			safeClick(upVote(), VERYLONGWAIT);
		}
	}
	/*
	 * Locator for number of upvote.
	 */
	private By upVoteNumber(){
		try{
			//return By.xpath("//section[@id='mainListCnt']/ol[@id='mainList']/li[1]/div[contains(@class,'float vote clear cunlock_hide_also')]/div[@class='float relative'][1]/span[contains(@class,'float clearLeft numVote')]");
			return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li[1]/div[@class='float vote']/div[@class='float relative'][1]/span[contains(@class,'float clearLeft numVote')]");
		}
		catch(Exception e){
			//return By.xpath("//section[@id='mainListCnt']/ol[@id='mainList']/li[1]/div[contains(@class,'float vote clear cunlock_hide_also')]/div[@class='float relative'][1]/span[contains(@class,'float clearLeft numVote')]");
			return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li[1]/div[@class='float vote']/div[@class='float relative'][1]/span[contains(@class,'float clearLeft numVote')]");
		}
	}
	/*
	 * This function is used to get the number of up vote.
	 */
	public String getTextOfUpvote(){
		return safeGetText(upVoteNumber(), MEDIUMWAIT);
	}
	/*
	 * Locator for number of downVote.
	 */
	private By downVoteNumber(){
		return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li[1]/div[@class='float vote']/div[@class='float relative'][2]/span[contains(@class,'block numVote')]");
		
	}
	/*
	 * This function is used to get text for image present for related link page.(Next slide after last slide.)
	 */
	public String getTextOfDownvote(){
		return safeGetText(downVoteNumber(), MEDIUMWAIT);
	}
	/*
	 * Locator for downVote.
	 */
	private By downVote(){
		return By.xpath("//section[@id='mainListCnt']/ol[contains(@id,'mainList')]/li[1]/div[@class='float vote']/div[@class='float relative'][2]/span[@class='block relative block btnVote pointer down off']/i");
	}
	/*
	 * Function to click on downVote.
	 */
	public void clickOnDownvote(){
		safeClick(downVote(), VERYLONGWAIT);
	}
	
	/*
	 * Locator for facebook on slideshow nodes hover.
	 */
	private By facebook(){
		return By.id("share_facebook-share_shareImage");
		//return By.xpath("//div[@id='mainImageShare']/span[@id='share_facebook-share_slideshowImage']");
	}
	/*
	 * Function to click on facebook on slideshow nodes hover.
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
	 * Locator for Twitter on slideshow nodes hover.
	 */
	private By Twitter(){
		return By.id("share_twitter-share_shareImage");
		//return By.xpath("//div[@id='mainImageShare']/span[@id='share_twitter-share_slideshowImage']");
	}
	/*
	 * Function to click on Twitter on slideshow nodes hover.
	 */
	public void clickOnTwitter(){
		safeJavaScriptClick(Twitter(), VERYLONGWAIT);
	}
	/*
	 * Locator for googlePlus.
	 */
	private By googlePlus(){
		return By.xpath("//div[@id='mainImageShare']/span[@id='share_google_slideshowImage']");
	}
	/*
	 * Function to click on googlePlus.
	 */
	public void clickOnGooglePlus(){
		safeClick(googlePlus(), VERYLONGWAIT);
	}
	/*
	 * Locator for reddit.
	 */
	private By reddit(){
		return By.xpath("//div[@id='mainImageShare']/span[@id='share_reddit_slideshowImage']");
	}
	/*
	 * Function to click on reddit.
	 */
	public void clickOnReddit(){
		safeClick(reddit(), VERYLONGWAIT);
	}
	/*
	 * Locator for reddit image after sign in.
	 */
	private By redditUserName(){
		return By.xpath("//div[@id='header-bottom-right']/span[@class='user']/a");
	}
	/*
	 * Function to get text of reddit image after signing in.
	 */
	public String getTextOfRedditUserName(){
		return safeGetText(redditUserName(), MEDIUMWAIT);
	}
	/*
	 * Locator for pinterest on slideshow nodes hover..
	 */
	private By pinterest(){
		return By.id("share_pinterest_shareImage");
		//return By.xpath("//div[@id='shareFooterSub']/span[@class='block item shareBox']/span[@id='share_pinterest_listFoot']");
		//return By.xpath("//div[@id='mainImageShare']/span[@id='share_pinterest_slideshowImage']");
	}
	/*
	 * Function to click on pinterest on slideshow nodes hover.
	 */
	public void clickOnPinterest(){
		safeJavaScriptClick(pinterest(), VERYLONGWAIT);
	}
	
	public void scroll(){
		scrollIntoViewThroughJavaScriptExecuter(By.xpath("//a[contains(@href, 'pics')]/img[contains(@src, 'user_node_img')]"));
		mouseHover(By.xpath("//a[contains(@href, 'pics')]/img[contains(@src, 'user_node_img')]"), MEDIUMWAIT);
	}
	public String switchToWindowAndGetTitle(){
		switchToNewWindow();
		return getTitle();
	}
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
	 * Locator for image previous arrows on big carousel.
	 */
	private By imagePreviousArrows(){
		return By.xpath("//section[@id='mainListCnt']/div[contains(@id,'slideImgPrev')]/div[@class='float absolute pointer btn varTest']/i");
	}
	/*
	 * Function to hover over the previous arrows on big carousel.
	 */
	public void hoverOverImagePreviousArrows(){
		mouseHover(imagePreviousArrows(), MEDIUMWAIT);
	}
	/*
	 * Function to get the css value of previous arrows on big carousel.
	 */
	public String getColorOfImagePreviousArrows(){
		return driver.findElement(imagePreviousArrows()).getCssValue("color");
	}
	
	/*
	 * Locator for slide to click in mini carousel.
	 */
	private By slideInCouresal(int slideNo){
		return By.xpath("//div[contains(@id,'slideTrackCntr')]/ul/li["+slideNo+"]");
	}
		
	/*
	 * This function is used to hey last slide number .
	 */
	public String getClassOfNodeInSlider(int slideNo){
		return driver.findElement(slideInCouresal(slideNo)).getAttribute("class");
	}
	
	/*
	 * This function is used to press right arrow from keyboard.
	 */
	public void rightArrowPress(){
		Actions action = new Actions(driver); 
		  action.sendKeys(Keys.ARROW_RIGHT).perform();
	}
	/*
	 * This function is used to press left arrow from keyboard.
	 */
	public void leftArrowPress(){
		Actions action = new Actions(driver); 
		  action.sendKeys(Keys.ARROW_LEFT).perform();
	}
	/*
	 * Locator for pinterest.
	 */
	private By nextlistonheader(){
		return By.id("lastSlideHead_next");
	}
	/*
	 * Function to click on pinterest.
	 */
	public void clickOnnextlistonheader(){
		safeJavaScriptClick(nextlistonheader(), VERYLONGWAIT);
	}
	/*
	 * Locator for facebook last slide.
	 */
	private By facebooklastslide(){
		return By.id("share_facebook-share_nodeHead");
	}
	/*
	 * Function to click on facebook last slide.
	 */
	public void clickOnfacebooklastslide(){
		driver.findElement(facebooklastslide()).click();
	}
	/*
	 * Locator for twitter last slide.
	 */
	private By twitterlastslide(){
		return By.id("share_twitter-share_nodeHead");
	}
	/*
	 * Function to click on twitter last slide
	 */
	public void clickOntwitterlastslide(){
		driver.findElement(twitterlastslide()).click();
	}
	/*
	 * Locator for google last slide.
	 */
	private By googlelastslide(){
		return By.id("share_google_nodeHead");
	}
	/*
	 * Function to click on google last slide
	 */
	public void clickOngooglelastslide(){
		driver.findElement(googlelastslide()).click();
	}
	/*
	 * Locator for reddit last slide.
	 */
	private By redditlastslide(){
		return By.id("share_reddit_nodeHead");
	}
	/*
	 * Function to click on google last slide
	 */
	public void clickOnredditlastslide(){
		driver.findElement(redditlastslide()).click();
	}
	/*
	 * Locator for google last slide.
	 */
	private By pinterestlastslide(){
		return By.id("share_pinterest_nodeHead");
	}
	/*
	 * Function to click on google last slide
	 */
	public void clickOnpinterestlastslide(){
		driver.findElement(pinterestlastslide()).click();
	}
	/*
	 * Locator for ShareBtn last slide.
	 */
	private By ShareBtnlastslide(){
		//i[contains(@id,'imageShareIcon')]
		return By.xpath("//i[contains(@id,'imageShareIcon')]");
	}
	/*
	 * Function to click on google last slide
	 */
	public void clickOnShareBtnlastslide(){
		scrollIntoViewThroughJavaScriptExecuter(ShareBtnlastslide());
		safeJavaScriptClick(ShareBtnlastslide(),LONGWAIT);
	}
	/*
	 * Locator for FirstButton slide click in mini carousel 
	 */
	private By FirstButtonSlide(){
		return By.xpath("//div[@class='relative width100 slideThumbCntr']/span[contains(@class,'float absolute pointer whiteBg slidePrev hidden')]/i[@class='block rnkrBlue']");
	}
	/*
	 * Function to click on FirstButton slide in mini carousel
	 */
	public void clickOnFirstButtonSlide(){
		scrollIntoViewThroughJavaScriptExecuter(FirstButtonSlide());
		safeClick(FirstButtonSlide(),LONGWAIT);
	}

	
}