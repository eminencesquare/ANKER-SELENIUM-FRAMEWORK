package com.pageobjects.PicsPage;

import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.selenium.SafeActions;

public class PicsPage extends SafeActions{
	private WebDriver driver;
	
	public PicsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	/*
	 * Locator for Header on picture page.
	 */
	private By picsPageHeader(){
		return By.xpath("//div[@id='siteBody']/article[@id='image']/header[@id='imageHead']/span[1]");
	}
	/*
	 * Functiion to get the text of header on picture page.
	 */
	public String getTextOfpicPageHeader(){
		return safeGetText(picsPageHeader(), VERYLONGWAIT);
	}
	/*
	 * Locator for 'topic page' text.
	 */
	private By picsPageTopicPage(){
		return By.xpath("//div[@id='siteBody']/article[@id='image']/header[@id='imageHead']/span[1]/a/em");
	}
	/*
	 * Function to make click on topic page text.
	 */
	public void clickOnpicsPageTopicPage(){
		safeJavaScriptClick(picsPageTopicPage(), MEDIUMWAIT);
		waitForElementVisible(PicsimgListedOn(), 30);
	}
	/*
	 * Locator for header of next page of pics page.
	 */
	private By picsPageHeaderNextPage(){
		return By.xpath("//div[@id='nodeHead']/div[@id='nodeDesc']/h1");
	}
	/*
	 * Function to get text of header of next page of pics page.
	 */
	public String getTextOfpicsPageHeaderNextPage(){
		return safeGetText(picsPageHeaderNextPage(), MEDIUMWAIT);
	}
	/*
	 * Locator for adChoices Photo Image icon.
	 */
	private By adChoices(int number){
		return By.xpath("//table/tbody/tr[1]/td[5]/table/tbody/tr[1]/td["+number+"]/div/a");
	}
	/*
	 * Function to get href of the links in adChoices.
	 */
	public String gethrefOfadChoices(int number){
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='siteBody']/article[@id='image']//div[@id='imageInfo']//ins[contains(@class,'adsbygoogle')]//iframe[contains(@id,'aswift_')]")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'google_ads_frame')]")));
		return driver.findElement(adChoices(number)).getAttribute("href");
	}
	/*
	 * Function to make click on link in adChoices.
	 */
	public void clickOnadChoices(int number){
		//safeJavaScriptClick(adChoices(number+""), VERYLONGWAIT);
		
		driver.findElement(adChoices(number)).click();
		
	}
	/*
	 * Locator for next page header of the links.
	 */
	private By adChoiceNextPage(){
		return By.xpath("//table/tbody/tr[1]/td[1]/span[1]/span/span/a");
	}
	/*
	 * Function to get the text of header of next page after clicking on adChoices links.
	 */
	public String getTextadChoiceNextPageHeader(){
		return safeGetText(adChoiceNextPage(), VERYLONGWAIT);
	}
	/*
	 * Locator for image's previous button.
	 */
	 private By imagePreviousButton(){
		 return By.xpath("//div[@id='mainImage']/span[@id='slideImgPrev']");
	 }
	 /*
	  * Function to make click on previous button.
	  */
	 public void clickOnImagePreviousButton(){
		// scrollIntoViewThroughJavaScriptExecuter(imagePreviousButton()); 
		 safeJavaScriptClick(imagePreviousButton(), VERYLONGWAIT);
		 waitForElementVisible(mainImage(), 20);
	 }

	 /*
	  * Locator for image to be displayed next in image list.
	  */
	 private By listImage(String number){
		 return By.xpath("//div[@id='imageThumbs']/ul/li["+number+"]/a");
	 }
	 /*
	  * Function to get the href of next image in image list.
	  */
	 public String gethrefOfImageInList(int number){
		 return driver.findElement(listImage(number+"")).getAttribute("data-img-id");
	 }
	 /*
	  * Locator for next button in image shown.
	  */
	 private By imageNextButton(){
		 return By.xpath("//div[@id='mainImage']/span[@id='slideImgNext']");
	 }
	 /*
	  * Function to make click on next button in image shown.
	  */
	 public void clickOnImageNextButton(){
		 safeJavaScriptClick(imageNextButton(), VERYLONGWAIT);
	 }
	 /*
	  * Locator for image to be shown next after clicking.
	  */
	 private By mainImage(){
		 return By.xpath("//div[@id='mainImage']/div[@class='imageContent inlineBlock center']/a/img");
	 }
	 /*
	  * Function to get the href of next image to be displayed.
	  */
	 public String gethrefOfMainImage(){
		 return driver.findElement(mainImage()).getAttribute("data-img-id");
	 }
	 /*
	  * Locator for buzzink link.
	  */
	 private By buzzingBlock(String number){
		 return By.xpath("//footer[@id='buzzing']/ul/li["+number+"]/a");
	 }
	 /*
	  * Function to make click on buzzing block links.
	  */
	 public void clickOnBuzzingBlock(int number){
		 safeJavaScriptClick(buzzingBlock(number+""), VERYLONGWAIT);
		 waitForPageToLoad(30);
	 }
	 /*
	  * Function to get href of buzzing block link selected.
	  */
	 public String gethrefBuzzingBlock(int num){
		 return driver.findElement(buzzingBlock(num+"")).getAttribute("href");
	 }
	 /*
	  * Locator for report photo.
	  */
	 private By reportPhoto(){
		 return By.xpath("//div[@id='freebaseAttribution']//span[@id='reportImg']");
	 }
	 /*
	  * Function to make click on report photo.
	  */
	 public void clickOnreportPhoto(){
		 safeJavaScriptClick(reportPhoto(), VERYLONGWAIT);
	 }
	 /*
	  * Locator for report photo block which appears on click.
	  */
	 private By miscategorizedOnPopup(){
		 return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']/div[@id='reportChoice']/input[1]");
	 }
	 /*
	  * Function to get check the radio buttton in report photo block.
	  */
	 public void checkOnMiscategorizedOnPopup(){
		 safeJavaScriptClick(miscategorizedOnPopup(), VERYLONGWAIT);
	 }
	 /*
	  * Locator for report button in report photo block.
	  */
	 private By reportButton(){
		 return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']/span[@id='reportSubmit']");
	 }
	 /*
	  * Function to click on report button in report photo block.
	  */
	 public void clickOnreportButton(){
		 safeJavaScriptClick(reportButton(), VERYLONGWAIT);
	 }
	 /*
	  * Function to check and accept the alert comes for the already subscribed email.
	  */
	 public boolean AlertExistAndAcceptence(){
	    	return AlertExistsAndAccepted(MEDIUMWAIT);
	    }
	 
	 /*
	  * Locator pic image in gallery
	  */
	 	private By Picsimg(String number){
	 		return By.xpath("//div[@id='imageThumbs']/ul/li["+number+"]/a/img");
	 				}
	 	/*
	 	 * Locator pic image in gallery
	 	 */
	 	private By PicsimgMain(){
	 		return By.xpath("//div[@id='mainImage']/div[@class='imageContent inlineBlock center']/a");
	 	}
	 	/*
	 	 * Locator pic image in gallery to get href
	 	 */
	 	private By PicsimgForhref(String number){
	 		return By.xpath("//div[@id='imageThumbs']/ul/li["+number+"]/a");
	 	}	
	 	/*
	 	 * Locator pic image in listed on 
	 	 */
	 	private By PicsimgListedintitle(String number){
	 		return By.xpath("//section[@id='theRanks']/ul[@id='nodeRank']/li["+number+"]/a//div[@class='titleBlock']/p[@class='listName black']");
	 		//return By.xpath("//section[@id='theRanks']/ul[@id='nodeRank']/a["+number+"]/li[1]//div[@class='titleBlock']/p[@class='listName black']");// ranker
	 	}	
	 	 /*
		  *  This fuction is used to click on topic page is check to listed On in pics page
		  */  
		 public boolean isPresentPicsimgListedintitle(String number){
			 return isElementPresent(PicsimgListedintitle(number+""), VERYLONGWAIT);
		 }
//	 	/*
//	 	 * This fuction is used to get text on title images
//	 	 */
//	 	public String getTextPicsimgListedintitle(String number){
//	 		return safeGetText(PicsimgListedintitle(number+""), VERYLONGWAIT);
//	 	}
	 	
	 	/*
	 	 *  This fuction is used to click  gallery images	
	 	 */
	 	public void clickOnPicsimg(int number){
	 		safeJavaScriptClick(Picsimg(number+""), VERYLONGWAIT);
	 	}
	 	
	 	/*
	 	 *  This fuction is used to click  gallery images	
	 	 */
	 	public boolean isImagePresentInList(int number){
	 		return isElementPresent(Picsimg(number+""), VERYSHORTWAIT);
	 	}
	 	
	 	/*
	 	 *  This fuction is used get href of  image	
	 	 */
	 	public String gethrefimg(int number){
	 		return driver.findElement(PicsimgForhref(number+"")).getAttribute("href");
	 		
	 }
	 	/*
	 	 *  This fuction is used get href  image of click  gallery images	
	 	 */
	 	public String gethrefOnclickimg(){
	 		return driver.findElement(PicsimgMain()).getAttribute("href");
	 		
	 }
	 	/*
	 	 * Locator pic image in listed On
	 	 */
	 	private By PicsimgListedOn(){
	 	return By.xpath("//section[@id='theRanks']/header[@class='sectionHeaderBG']/h2[@class='sectionHeaderFont']");	
	 }
	 	/*
	 	 *  This fuction is used to click on topic page in pics page
	 	 */
	 	private By clickOnpicsPageTopicPageListedOn(){
	 	return By.xpath("//section[@id='theRanks']/header[@class='sectionHeaderBG']/h2[@class='sectionHeaderFont']");	
	 }
	 		/*
	 		 *  This fuction is used to check is listed On in pics page
	 		 */ 		
	 public boolean isListedOnLinkPresentPics(){
	 	return isElementPresent(PicsimgListedOn(), VERYLONGWAIT);
	 }
	 /*
	  *  This fuction is used to click on topic page is check to listed On in pics page
	  */  
	 public boolean isListedOnclickLinkPresentPics(){
		 return isElementPresent(PicsimgListedOn(), VERYLONGWAIT);
	 }
	 	 /*
	 	  * Locator for pic image in Horizontal view in  list 
	 	  */
	 	 private By picsimghorizontalviewinfans(){
	 			//return By.xpath("//section[@id='relatedListsLazy2']/div[@class='relatedListsLazy2']/h1[@class='relatedListsLazy2']");	
	 		return By.xpath("//section[@id='relatedListsLazy2']/header[@class='sectionHeaderBG']/h3");
	 	 }
	 		/*
	 		 *  This fuction is used to check fans also view in horizontal list
	 		 */ 		
	 public boolean isfansPresentPicsinhorizontal(){
		 scrollIntoViewThroughJavaScriptExecuter(picsimghorizontalviewinfans());  
	 	return isElementPresent(picsimghorizontalviewinfans(), VERYLONGWAIT);
	 }
	 /*
	  * Locator for pic image in Popular list
	  */
	 private By picsimgpopularlist(){
	 	return By.xpath("//div[contains(@class,'relatedListsBlock')]/h3");	
	 	}
	 /*
	  *  This fuction is used to present popular list
	  */ 		
	 public boolean isPresentpicsimgpopularlist(){
	 return isElementPresent(picsimgpopularlist(), VERYLONGWAIT);
	 }
	 
	 /*
	  * Locator for pic image in Popular list check Header
	  */
	 private By picsimgpopularlistofimgHeader(String number){
	 	return By.xpath("//div[contains(@class,'relatedListsBlock')]/ul[@class='related']/li["+number+"]//div[@class='inlineBlock listLink black']/a");	
	 	}
	 /*
	  *  This fuction is used to get text from header in Popular List  
	  */ 
	 public String getTextpicsimgpopularlistofimgHeader(int number){
	 	return safeGetText(picsimgpopularlistofimgHeader(number+""), VERYLONGWAIT);
	 }
	 /*
	  *  This fuction is used to Click header in Popular List  
	  */ 
	 public void clickOnpopularlistofimgHeader(int number){
	 	 safeJavaScriptClick(picsimgpopularlistofimgHeader(number+""), MEDIUMWAIT);
	 }
	 /*
	    * Locator for pic image in Popular list to click Header
	    */
	      private By popularlistofimgHeaderonclick(){
	    return By.xpath("//div[@id='siteBody']/article[@id='list']/header[@id='listHead']/div[@id='listDesc']/h1//span[@class='name internal pointer']"); 
	    }
//	 /*
//	   * Locator for pic image in Popular list to click Header
//	   */
//	     private By popularlistofimgHeaderonclick(){
//	   return By.xpath("//div[@id='siteBody']/article[@id='list']/header[@id='listHead']/div[@id='listDesc']/h1//span[@class='name ']"); 
//	   }
//	 /*
//	  * Locator for pic image in Popular list to click Header
//	  */
//	    private By popularlistofimgHeaderonclick(){
//	 	return By.xpath("//div[@id='listDesc']/h1//span[@class='name ']");	
//	 	}
	 /*
	  *  This fuction is used to get text from header in Popular List after click 
	  */
	 public String getTextpopularlistofimgHeaderonclick(){
	 	return safeGetText(popularlistofimgHeaderonclick(), VERYLONGWAIT);
	 }

	 /*
	  * Locator for pic image in Popular list to click Header
	  */
	 private By PicsImagesCount(){
	 	return By.xpath("//div[@id='siteBody']/article[@id='image']/header[@id='imageHead']//span[@class='titleBlock float relative block'][2]//em");	
	 	}
	 /*
	  *  This fuction is used to present popular list
	  */ 		
	 public boolean isPresentPicsImagesCount(){
	 return isElementPresent(PicsImagesCount(), VERYLONGWAIT);
	 }
	 
	 /*
	  *  This fuction is used to get text for number of images present.
	  */ 
	 public String getTextOfNumberOfImages(){
		 return safeGetText(PicsImagesCount(), VERYLONGWAIT);
	}
	 
	 
	 /*
	  * Locator for 48 image in Popular list to click Header
	  */
	 private By countImages(int i){
	 	return By.xpath("//div[@id='imageThumbs']/ul/li["+i+"]//a//img");
	 	
	 }
	 /*
	  *  This fuction is verify 48 images is present
	  */ 
	 public boolean verifycountImages(int i){
	 	return isElementPresent(countImages(i));
	 }
    /*
     * Locator for facebook.
     */
	 
	 private By facebook(){
			return By.xpath("//span[@id='share_facebook-share_picsImage']/i");
		}
	    /*
	     * Function to click on facebook.
	     */
		public void clickOnfacebook(){
			safeClick(facebook(), VERYLONGWAIT);
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
			//waitForPageToLoad(30);
			return isElementPresent(fbShareWindow());
		}
		
		/*
	     * Locator for Twitter.
	     */
		private By Twitter(){
			return By.xpath("//span[@id='share_twitter-share_picsImage']/i");
		}
		/*
		 * Function to click on twitter.
		 */
		public void clickOnTwitter(){
			safeClick(Twitter(), VERYLONGWAIT);
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
	     * Locator for pinterest.
	     */
		private By pinterest(){
			return By.xpath("//span[@id='share_pinterest_picsImage']/i");
		}
		/*
		 * Function to click on pinterest.
		 */
		public void clickOnPinterest(){
			safeClick(pinterest(), VERYLONGWAIT);
		}
		public String switchToWindowAndGetTitle(){
			switchToNewWindow();
			return getTitle();
		}
		public void switchToParentWindow(){
				switchToWindow(0);
			
		}		
}
