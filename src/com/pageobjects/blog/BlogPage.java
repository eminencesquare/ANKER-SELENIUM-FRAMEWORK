package com.pageobjects.blog;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.SafeActions;


public class BlogPage  extends SafeActions{
	private WebDriver driver;
	
	public BlogPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	/*
	 * Locater for upvote.
	 */
	    private By upVote(){
		return By.xpath("//section[@id='mainListCnt']/ol/li[1]/div[@class='float vote']/div[1]/span/i");
		//return By.xpath("//section[@id='mainListCnt']/ol/li[1]/div[@class='float vote cunlock_hide_also ']/div[1]//span[@class='float icon liked grey imgText']");
	}
	/*
	 * Function to check the presence of upvote icon.
	 */
	public boolean isupVotePresent(){
		return isElementPresent(upVote());
	}
	/*
	 * Function to click on upVote.
	 */
	public void clickOnupVote(){
		safeClick(upVote(), VERYLONGWAIT);
	}
	/*
	 * Locator for downVote.
	 */
	private By downVote(){
		return By.xpath("//section[@id='mainListCnt']/ol/li[1]/div[@class='float vote']/div[2]/span/i");
		//return By.xpath("//section[@id='mainListCnt']/ol/li[1]/div[@class='float vote cunlock_hide_also ']/div[2]//span[@class='float icon unLiked grey imgText']");
	}
	/*
	 * Function to check the presence of downVote icon.
	 */
	public boolean isdownVotePresent(){
		return isElementPresent(downVote());
	}
	/*
	 * Function to make click on downVote icon.
	 */
	public void clickOndownVote(){
		safeClick(downVote(), VERYLONGWAIT);
	}
	/*
	 * Locator for counting of upVote.
	 */
	private By upVoteCount(){
		return By.xpath("//section[@id='mainListCnt']/ol/li[1]/div[@class='float vote']//span[contains(@class,'float clearLeft numVote grey center up')]");
	}
	/*
	 * Function to get count number of upVote.
	 */
	public String getupVoteCount(){
		return safeGetText(upVoteCount(), VERYLONGWAIT);
	}
	/*
	 * Locator for counting downVote.
	 */
	private By downVoteCount(){
		return By.xpath("//section[@id='mainListCnt']/ol/li[1]/div[@class='float vote']//span[contains(@class,'block numVote grey center down')]");
	}
	/*
	 * Function to get count number of downVote.
	 */
	public String getdownVoteCount(){
		return safeGetText(downVoteCount(), VERYLONGWAIT);
	}
	/*
	  * Locator for node name.
	  */
	 private By nodeName(String number){
	  //return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+number+"]/div[@class='float name nonVote']//span[@class='oNode']");
	  return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+number+"]/div[contains(@class,'float name ')]//span[@class='oNode']");
	 }
//	/*
//	 * Locator for node name.
//	 */
//	private By nodeName(String number){
//		return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+number+"]/div[@class='float name nonVote']//span[@class='oNode']");
//	}
	/*
	 * Function to make click on node's name.
	 */
	public void clickOnNodeName(int number){
		 safeJavaScriptClick(nodeName(number+""), VERYLONGWAIT);
		 //waitForElementVisible(headerAfterClickOnNode(),10);
	}
	/*
	 * Function to get text of node's name.
	 */
	public String getTextOfNodeName(int number){
		return safeGetTextThroughJS(nodeName(number+""));//, VERYLONGWAIT);
	}
	/*
	 * Locator for header of next page after clicking on node name.
	 */
	private By headerAfterClickOnNode(){
		return By.xpath("//div[@id='nodeDesc']//h1[contains(@class,'heading')]");
	}
	/*
	 * Function to get the text of header of next page after clicking on node name.
	 */
	public String getHeaderAfterClickOnNode(){
		return safeGetText(headerAfterClickOnNode(), VERYLONGWAIT);
	}
	/*
	 * Locator for node image.
	 */
	private By nodeImage(int number){
		return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li[contains(@id,'n_')]["+number+"]/div[@class='float relative clear img']/div[@class='floatRight relative']//img");
		//return By.xpath("//section[@id='mainListCnt']/ol[@id='mainList']/li[contains(@class,'relative clear')]["+number+"]/div[@class='relative width100 img clear center']//img[contains(@class,'oImg')]");
		
	}
	/*
	 * Function to make click on node image.
	 */
	public void clickOnNodeImage(int number){
		 safeJavaScriptClick(nodeImage(number), SHORTWAIT);
	}
	/*
	 * Locator for the text of header of next page after clicking on node image.
	 */
	private By headerAfterClickOnNodeImage(){
		return By.xpath("//article[@id='image']/header[@id='imageHead']/span[@class='titleBlock float relative block']");
	}
	/*
	 * Function to get the text of header of next page after clicking on node image.
	 */
	public String getHeaderAfterClickOnNodeImage(){
		return safeGetText(headerAfterClickOnNodeImage(), VERYLONGWAIT);
	}
	/*
	 * Locator for description section.
	 */
	private By description(String number){
		return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+number+"]//div[contains(@class,'blogText serif')]");
	}
	/*
	 * Function to get text of decription section.
	 */
	public String getDescription(int number){
		return safeGetText(description(number+""), VERYLONGWAIT);
	}
	/*
	 * Function to check the presence of description section.
	 */
	public boolean isDescriptionPresent(int number){
		scrollIntoViewThroughJavaScriptExecuter(description(number+""));
		return isElementPresent(description(number+""), SHORTWAIT);
	}
	/*
	 * Locator for about section in node page.
	 */
	private By about(int number){
		return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+number+"]/div[@class='float relative clear img']/div[@class='blogText serif black']/div[@class='propText']/div[@class='leftMore inlineBlock relative']");
	}
	/*
	 * Function to check the presence of about section in node page.
	 */
	public boolean isAboutPresent(int number){
		return isElementPresent(about(number), MEDIUMWAIT);
	}
	/*
	 * Locator for text of about section.
	 */
	private By aboutText(String number){
		return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+number+"]/div[@class='float relative clear img']/div[@class='blogText serif black']/div[@class='propText']/div[@class='rightMore block relative']/span");
	}
	/*
	 * Function to get the text of about section.
	 */
	public String getTextAbout(int number){
		return safeGetText(aboutText(number+""), VERYLONGWAIT);
	}
	/*
	 * Locator for seeMore in about section.
	 */
	private By seeMoreInAboutSection(String number){
		return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+number+"]/div[@class='float relative clear img']/div[@class='blogText serif black']/div[contains(@class,'propSeeMore relative')]/a");
		//return By.xpath("//section[@id='mainListCnt']/ol[@id='mainList']/li["+number+"]/div[@class='float relative clear img']/div[@class='blogText serif black']/div[@class='propSeeMore relative width100']/a");
		//return By.xpath("//section[@id='mainListCnt']/ol[@id='mainList']/li["+number+"]//div[@class='blogText serif charcoal']/div[(@class='propText')]/a[@class='inlineBlock']");
	}
	/*
	 * Fuction to make click on seeMore link in about section.
	 */
	public void clickOnSeeMoreInAboutSection(int number){
		safeClick(seeMoreInAboutSection(number+""), MEDIUMWAIT);
	}
	/*
	 * Locater for Also Ranked section.
	 */
	private By alsoRankedText(){
		//System.out.println(" comin this alsoRankedText");
		return By.xpath("//div[contains(@class,'propRanks')]/div[@class='leftMore inlineBlock relative']");
		//return By.xpath("//div[@class='float relative clear img']/div[@class='blogText serif charcoal']/div[2]/span");
	}
	/*
	 * Function to check the presence of also ranked section in node page.
	 */
	public boolean isalsoRankedPresent(){
		scrollIntoViewThroughJavaScriptExecuter(alsoRankedText());
		//System.out.println(" comin this");
		return isElementPresent(alsoRankedText(),SHORTWAIT);
	}
	/*
	 * Locator for links in also ranked section.
	 */
	private By alsoRankedLinks(String num){
	//propRanksNoWiki relative propRanks changed
		return By.xpath("//div[@class='float relative clear img']/div[@class='blogText serif black']/div[@class='propRanksNoWiki relative propRanks']/ul/li[1]/a");
	}
	/*
	 * Function to make click on link in also ranked section.
	 */
	public void clickOnalsoRankedLinks(int num){
		safeJavaScriptClick(alsoRankedLinks(num+""), VERYLONGWAIT);
		//waitForElementVisible(alsoRankedNextPageHeader(), 30);
	}
	/*
	 * Function to get text of the link in also ranked section.
	 */
	public String getTextOfalsoRankedLinks(int num){
		return safeGetText(alsoRankedLinks(num+""), VERYLONGWAIT);
	}
	/*
	 * Locator for header of next page after clicking on link in also ranked section.
	 */
	private By alsoRankedNextPageHeader(){
		return By.xpath("//div[@id='listDesc']/h1/span");
	}
	/*
	 * Function to get text of header of next page after clicking on link in also ranked section.
	 */
	public String getTextalsoRankedNextPageHeader(){
		return safeGetText(alsoRankedNextPageHeader(),VERYLONGWAIT);
	}
	
	/*
	 * Locator for seeMore in about section.
	 */
	private By item(String number){
		return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+number+"]");
	}
	
	/*
	 * Function for autoloading.
	 */
 	public void autoloading(int number){
 		scrollIntoViewThroughJavaScriptExecuter(nodeImage(number));
 		waitForElementVisible(nodeImage(number),40);
 	}
 	/*
 	 * Function to check the presence of node list before loading and after autoloading.
 	 */
 	public boolean isnodePresent(int number){
 		return isElementPresent(nodeName(number+""));
 	}
 	/*
	 * Locator for in also ranked section.
	 */
	private By alsoRanked(){
		return By.xpath("//div[@class='float relative clear img']/div[@class='blogText serif black']/div[@class='propRanksNoWiki relative propRanks']/ul/li[1]/a");
	}
	/*
	  * Function to get href of also ranked section
	  */
	 public String gethrefOfalsoRanked(){
		 return driver.findElement(alsoRanked()).getAttribute("href");
	 }
	 
	 /*
		 * Fuction to make click on alsoRanked
		 */
		public void clickOnalsoRanked(){
			safeClick(alsoRanked(), MEDIUMWAIT);
		} 
		/*
		 * Locator for OverlayMsg
		 */
		private By OverlayMsg(){
			return By.id("nonGridOverlay");
		}
		/*
		 * Function to get text OverlayMsg
		 */
		public String getTextOfOverlayMsg(){
			return safeGetText(OverlayMsg(), VERYLONGWAIT);
		}
		/*
		 * Locator for BlatherNodeDesc
		 */
		private By BlatherNodeDesc(){
			return By.xpath("//div[@class='blogText serif black']/p[@class='block']");
		}
		/*
		 * Function to get font size of BlatherNodeDesc.
		 */
		public String getfontsizeOfBlatherNodeDesc(){
			return driver.findElement(BlatherNodeDesc()).getCssValue("font-size");
		}
		/*
		 * Function to get getNodeTextFontFamily of BlatherNodeDesc.
		 */
		public String getNodeTextFontFamily(){
			return driver.findElement(BlatherNodeDesc()).getCssValue("font-family");
		}
		/*
		 * Locator for MoreAboutDesc
		 */
		private By MoreAboutDesc(int num){
			return By.xpath("//div[@class='propText']/div[@class='rightMore block relative']/strong["+num+"]");
		}
		
		/*
		 * Function to get Font-weight of MoreAboutDesc.
		 */
		public String getFontWeightOfMoreAboutDesc(int num){
			return driver.findElement(MoreAboutDesc(num)).getCssValue("font-weight");
		}
		/*
		 * Locator for MoreAboutMetadata
		 */
		private By MoreAboutMetadata(int num){
			return By.xpath("//div[@class='propText']/div[@class='rightMore block relative']/span["+num+"]");
		}
		/*
		 * Function to get Font-weight of MoreAboutMetadata
		 */
		public String getFontWeightOfMoreAboutMetadata(int num){
			return driver.findElement(MoreAboutMetadata(num)).getCssValue("font-weight");
		}
		/*
		   * Locator for AlsoRankedDesc
		   */
		  private By AlsoRankedDesc(int num){
		   return By.xpath("//div[@class='propRanksNoWiki relative propRanks']/ul[@class='rightMore block relative']/li["+num+"]/strong");
		  }
		/*
		   * Function to get Font-weight of AlsoRankedDesc
		   */
		  public String getFontWeightOfAlsoRankedDesc(int num){
		   return driver.findElement(AlsoRankedDesc(num)).getCssValue("font-weight");
		  }
		  /*
		 	 * Function to check the presence of AlsoRankedDesc
		 	 */
		  public boolean isAlsoRankedDescPresent(int num){
				return isElementPresent(AlsoRankedDesc(num));
		 	}
		  /*
		   * Locator for NodeHeaderDisplay
		   */
		  private By NodeHeaderDisplay(){
			  return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li[1]/div[@class='float name ']/p/a/span");
		   //return By.xpath("//div[@class='float name']/p/a");
		  }
		  /*
			 * Function to get text NodeHeaderDisplay
			 */
			public String getTextOfNodeHeaderDisplay(){
				return safeGetText(NodeHeaderDisplay(), VERYLONGWAIT);
			}
			 /*
			   * Locator for SeeMoreHeader
			   */
			  private By SeeMoreHeader(){
				  return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li[1]/div[@class='float relative clear img']/div[2]/div[@class='propSeeMore relative large']/a");
			   //return By.xpath("//div[@class='propSeeMore relative large']/a");
			  }
			  /*
				 * Function to get text SeeMoreHeader
				 */
				public String getTextOfSeeMoreHeader(){
					return safeGetText(SeeMoreHeader(), VERYLONGWAIT);
				}
				/*
				 * Function to make click on SeeMoreHeader
				 */
				public void clickOnSeeMoreHeader(){
					 safeJavaScriptClick(SeeMoreHeader(), SHORTWAIT);
				}
				/*
				  * Function to get href of SeeMoreHeader
				  */
				 public String gethrefOfSeeMoreHeader(){
					 return driver.findElement(SeeMoreHeader()).getAttribute("href");
				 }
				 /*
				   * Locator for after click on SeeMoreHeader
				   */
				  private By AfterClickSeeMoreHeader(){
				   return By.xpath("//div[@id='nodeHead']/div[@id='nodeDesc']/h1");
				  }
				  /*
					 * Function to get text of AfterClickSeeMoreHeader
					 */
					public String getTextOfAfterClickSeeMoreHeader(){
						return safeGetText(AfterClickSeeMoreHeader(), VERYLONGWAIT);
					}
					
					
					
		  
}
