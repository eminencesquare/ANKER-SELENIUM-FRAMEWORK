package com.pageobjects.rightrail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;

public class Rightrail extends SafeActions {
private WebDriver driver;
	
	/*
	 * Constructor for the page.
	 */
	public Rightrail(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/*
	 * Locator for the email subscription.
	 */
	private By subscriptionemail(){
		return By.xpath("//div[@id='followRanker']/div[@class='emailBox']/input[@id='followEmail']");
	}
	
	/*
	 * This function is used to type email address in the subscription section.
	 */
	public void typeEmailtoSubscription(String emailId){
		safeType(subscriptionemail(),emailId, VERYLONGWAIT);
	}
	
	/*
	 * Locator for subscription button.
	 */
	private By subscribeButton(){
		return By.xpath("//div[@class='emailBox']//div[@class='subBox float']/a");
	}
	
	/*
	 * Function to click on subscription button.
	 */
	public void clickOnSubscriptionButton(){
		safeClick(subscribeButton(), VERYLONGWAIT);
		try{
		Thread.sleep(2000);
		}catch(Exception e){}
	}
	
	/*
	 * Locator for message appears after subscribe(Success and failure)
	 */
    private By messageAfterSubscribe(){
        return By.xpath("//div[@id='followRanker']/div[@class='emailBox']/span");
    }
    
    /*
     * Function to get message after subscription(Success and failure)
     */
    public String getTextOfMessageAfterSubscribe(){
    	return safeGetText(messageAfterSubscribe(), VERYLONGWAIT);
    }
    
    /*
     * Function to check and accept the alert comes for the already subscribed email.
     */
    public boolean AlertExistAndAcceptence(){
    	return AlertExistsAndAccepted(MEDIUMWAIT);
    }   
    
    /*
     * Locator For featured list.
     */
    private By featuredList(String number){
    	return By.xpath("//div[@id='featuredPartners']/li["+number+"]/h4/a");
    }
    /*
     * Function to click on featured list.
     */
    public void getClickOnfeaturedList(int number){
		safeClick(featuredList(number+""), VERYLONGWAIT);
	} 
    
    /*
	 * Locator for Recent List block 
	 */
    private By RecentListBlock(String num){
        return By.xpath("//div[@id='recentLists']/ol/li[@class='recentContribute']["+num+"]/h4//a[@role='link']");
     }
    /*
   	 * Locator for Recent List block after click list
   	 */
    private By HeaderOnClickRecentListBlock(){
        return By.xpath("//div[@id='listDesc']/h1/span[contains(@class,'name')]");
     }
    /*
	 * Function to click on Recent List block 
	 */
    public void clickOnRecentListBlock(int num){
		safeClick(RecentListBlock(num+""), VERYLONGWAIT);
	}
    /*
	 * Function to check Recent List block 
	 */
    public String getTextOfRecentListBlock(int num){
    	return safeGetText(RecentListBlock(num+""), VERYLONGWAIT);
    } 
    /*
     * This function is used to get headers of page opened after clicking on from our partners link Recent List block.
	 */
    public String getTextOfHeaderOnClickRecentListBlock(){
    	return safeGetText(HeaderOnClickRecentListBlock(), VERYLONGWAIT);
    } 
    /*
	 * Locator for Recent List block click on profile[i-list] 
	 */
    private By RecentListBlockClickOnProfile(){
       // return By.xpath("//div[@id='recentLists']/ol/li[4]//span[@class='capitalize block internal pointer']");
        return By.xpath("//aside[@id='sidebar']/div[@id='topLists']//ol/li[5]//span[@class='profileName block midGrey']/span[@class='internal pointer']");
     }
    
    /*
   	 * Locator for Recent List block after click list on profile[i-list] 
   	 */
    private By RecentListBlockAfterClickOnProfile(){
        return By.xpath("//header[@id='userHead']/div[@id='userBio']/h1[@role='heading']");
     }
    
    /*
   	 * Function to click on Recent List block 
   	 */
    public void ClickOnProfileRecentListBlock(){
   		safeJavaScriptClick(RecentListBlockClickOnProfile(), VERYLONGWAIT);
   	}
    
    /*
   	 * Function to check Recent List block 
   	 */
    public String getTextOfProfileRecentListBlock(){
    	scrollIntoViewThroughJavaScriptExecuter(RecentListBlockClickOnProfile());
    	return safeGetText(RecentListBlockClickOnProfile(), VERYLONGWAIT);
    }
    
    /*
     * This function is used to get headers of page opened after clicking on from our partners link Recent List block.
   	 */
    public String getTextOfProfileOnClickRecentListBlock(){
    	return safeGetText(RecentListBlockAfterClickOnProfile(), VERYLONGWAIT);
    } 
       
    /*
     * Locator for Recent List block after click list on profile ultimate list
     */
    private By RecentListBlockClickOnUltimate(){
    	return By.xpath("//aside[@id='sidebar']/div[@id='recentLists']/ol/li[@class='recentContribute']/p[@class='newContributeBlk floatRight']/span[@class='capitalize block internal pointer']");
    }
       
    /*
     * Function to click on Recent List block 
     */
    public void ClickOnRecentListBlockClickOnUltimate(){
    	scrollIntoViewThroughJavaScriptExecuter(RecentListBlockClickOnUltimate());
    	safeClick(RecentListBlockClickOnUltimate(), VERYLONGWAIT);
    }
    
    /*
     * function to get href attribute of recent list block
     */
     public String gethrefRecentListBlockClickOnUltimate(){
    	   return driver.findElement(RecentListBlockClickOnUltimate()).getAttribute("data-internal-url");
       }
       
      /*
       * Locator for more recent list.
       */
      private By moreRecentList(){
          return By.xpath("//div[@id='recentLists']/div[@class='viewAll rnkrBGreyBg center lowercase']/a");
      }
      
      /*
       * Function to click on more recent list 
       */
      public void ClickOnMoreRecentList(){
    	  safeClick(moreRecentList(), VERYLONGWAIT);
      }
         
      /*
       * Function to get href attribute.
       */
      public String gethrefMoreRecentList(){
    	  return driver.findElement(moreRecentList()).getAttribute("href");
      }
          
      /*
       * Locator for top ranker image.
       */
      private By topRankerImage(String number){
    	  return By.xpath("//div[@id='topRankers']/ol/li["+number+"]/a[@class='inlineBlock relative']/img");
      }
        
      /*
       * Function to check presence of top ranker image
       */
      public boolean isTopRankerImagePresent(int number){
    	  return isElementPresent(topRankerImage(number+""), VERYLONGWAIT);
       }
           
      /*
       * Function to check presence of top ranker image
       */
      public void clickTopRankerImage(int number){
    	  safeClick(topRankerImage(number+""), VERYLONGWAIT);
      }
           
      /*
       * Locator for top ranker image nummber.
       */
      private By topRankerImagenumber(String number){
    	  return By.xpath("//div[@id='topRankers']/ol/li["+number+"]/a[@class='inlineBlock relative']/span");
      }
           
      /*
       * Function to check presence of top ranker image number.
       */
      public String getTopRankerImageNumber(int number){
    	  return safeGetText(topRankerImagenumber(number+""), VERYLONGWAIT);
      }
              
      /*
       * Locator for top ranker image.
       */
      private By topRankerTxt(String number){
    	  return By.xpath("//div[@id='topRankers']/ol/li["+number+"]/a[@class='openUP profileName center block']");
      }
                 
      /*
       * Function to check presence of top ranker image
       */
      public void clickTopRankerTxt(int number){
    	  safeClick(topRankerTxt(number+""), VERYLONGWAIT);
      }
      
      /*
       * Function to check presence of top ranker image number.
       */
      public String getTextOfTopRankertxt(int number){
    	  return safeGetText(topRankerTxt(number+""), VERYLONGWAIT);
      }
            
      /*
       * Locator for top ranker image.
       */
      private By headerAfterClickOnPrfile(){
    	  return By.xpath("//header[@id='userHead']/div[@id='userBio']/h1");
      }
      
      /*
       * Function to check presence of top ranker image number.
       */
      public String getTextOfHeaderAfterClickOnPrfile(){
    	  return safeGetText(headerAfterClickOnPrfile(), VERYLONGWAIT);
      }
      
      /*
       * Locator for All Top Rankers Link.
       */
      private By allTopRankersLink(){
    	  return By.xpath("//div[@id='topRankers']/div[@class='viewAll rnkrBGreyBg center lowercase']/a");
      }
      
      /*
       * Function to click on all top rankers link.
       */
      public void clickOnAllTopRankersLink(){
    	  safeClick(allTopRankersLink(), VERYLONGWAIT);
      }
      
      /*
       * Locator for All Top Rankers Link.
       */
      private By topRanker(){
    	  return By.xpath("//header[@id='leaderHead']/h1[@class='lightGrey lowercase']/span[@class='rnkrDBlue']");
      }
      
      /*
       * Function to click on all top rankers link.
       */
      public boolean isTopRankerPresent(){
    	  return isElementPresent(topRanker(), VERYLONGWAIT);
      }
                                        
      /*
       * Locator for featured partner list
       */
      private By featuredPartnerList(String num){
    	  return By.xpath("//div[@id='featuredPartners']/ol/li["+num+"]/h4/a");
      }
      
      /*
       * Function to click on the featured list links and get to corresponding page.
       */
      public void clickOnfeaturedPartnerList(int num){
    	  scrollIntoViewThroughJavaScriptExecuter(favsBlocklistlink(num+"")); 
    	  safeClick(featuredPartnerList(num+""), VERYLONGWAIT);
      }
                                        
      /*
       * Locator for featured partner list Text.
       */
      private By featuredPartnerListText(String number){
    	  return By.xpath("//div[@id='featuredPartners']/ol/li["+number+"]/h4");
      }
      
      /*
       * Function to get text of featured list links and check it with corresponding page's text.
       */                           
      public String getTextOffeaturedPartnerListText(int number){
    	  return safeGetText(featuredPartnerListText(number+""), VERYLONGWAIT);
      }
      
      /*
       * Locator for featured partner list Text on corresponding list name page.
       */                         
      private By featuredPartnerNameNextPage(){
    	  return By.xpath("//div[@id='listDesc']/h1/span");
      }
      
      /*
       * Function to get text of featured partner list 
       */                                 
      public String getTextOffeaturedPartnerNameNextPage(){
    	  return safeGetText(featuredPartnerNameNextPage(), VERYLONGWAIT);
      }
                                        
      /*
       * Locator for featured list 'Official' Text.
       */
      private By featuredPartnerListOfficialText(String offtextnum){
    	  return By.xpath("//div[@id='featuredPartners']/ol/li["+offtextnum+"]/span[@class='profileName block']/span[@class='relative block']");
      }
      
      /*
       * Function to see the presence of 'Official' text.
       */                                 
      public boolean isfeaturedPartnerListOfficialTextPresent(int offtextnum){
    	  scrollIntoViewThroughJavaScriptExecuter(favsBlocklistlink(offtextnum+"")); 
    	  return isElementPresent(featuredPartnerListOfficialText(offtextnum+""),VERYLONGWAIT);
      }
      
      /*
       * Locator for featured partner's node names.
       */                                 
      private By featuredPartnerNodeName(String nodenum){
    	  return By.xpath("//div[@id='featuredPartners']/ol/li["+nodenum+"]");
      }
      
      /*
       * Function to see that featured partner's node is 3 in number.
       */
      public boolean isfeaturedPartnerNodeNamePresent(int nodenum){
    	  return isElementPresent(featuredPartnerNodeName(nodenum+""));
      }
      
      /*
       * Locator for featured partner profile.
       */
      private By featuredPartnerProfile(String userHeadNum){
    	  return By.xpath("//div[@id='featuredPartners']/ol/li["+userHeadNum+"]/span[@class='profileName block']/span[@class='block internal rnkrBlue pointer uppercase']");
      }
      
      /*
       * Function to get text of featured partner profile's text.
       */                                 
      public String getTextOffeaturedPartnerProfile(int userHeadNum){
    	  scrollIntoViewThroughJavaScriptExecuter(favsBlocklistlink(userHeadNum+"")); 
    	  return safeGetText(featuredPartnerProfile(userHeadNum+""),VERYLONGWAIT);
      }
      
      /*
       * Locator for featured partner profile clicking.
       */
      private By featuredPartnerProfileText(String num){
    	  return By.xpath("//div[@id='featuredPartners']/ol/li["+num+"]/span[@class='profileName block']/span[@class='block internal rnkrBlue pointer uppercase']");
      }
      
      /*
       * Function to click on featured partner profile's text.
       */                                 
      public void clickOnfeaturedPartnerProfileText(int num){
    	  safeClick(featuredPartnerProfileText(num+""), VERYLONGWAIT);
      }
      
      /*
       * Function to get text of featured partner profile links and check it with corresponding page's text.
       */                                 
      public String getTextOffeaturedPartnerProfileText(int number){
    	  return safeGetText(featuredPartnerProfileText(number+""), VERYLONGWAIT);
      }
      
      /*
       * Locator for featured partner profile text on Next page.
       */
      private By featuredPartnerProfileNextPage(){
    	  return By.xpath("//div[@id='userBio']/h1");
      }
                                     
      /*
       * Function to get text of featured partner profile links and check it with corresponding page's text.
       */                                 
      public String getTextOffeaturedPartnerProfileNextPage(){
    	  return safeGetText(featuredPartnerProfileNextPage(), VERYLONGWAIT);
      }
      
      /*
     	 * Locator for favs block list link.
     	 */
      private By favsBlocklistlink(String num){
      	return By.xpath("//div[@id='evergreen']/ul/li["+num+"]/a/span[@class='tableAlign']");
      }
      /*
       * Function to click on favs block list link text.
       */
      
      public void clickOnfavsBlockText(int num){
  		safeClick(favsBlocklistlink(num+""), VERYLONGWAIT);
  	}
      /*
       * Function to get text of favs block list links and check it with corresponding page's text.
       */
      
      public String getTextOffavsBlockText(int number){
      	return safeGetText(favsBlocklistlink(number+""), VERYLONGWAIT);
      }
      /*
     	 * Locator for favs block list link text on Next page.
     	 */
      private By favsBlocklistlinkNextPage(){
      	return By.xpath("//div[@id='listDesc']/h1/span[contains(@class,'name')]");
      }
   
      /*
       * Function to get text of favs block list links and check it with corresponding page's text.
       */
      
      public String getTextOffavsBlockListNextPage(){
      	return safeGetText(favsBlocklistlinkNextPage(), VERYLONGWAIT);
      }
      
      /*
    	 * Locator for favs block top list.
    	 */
       private By headerAfterClickFavlist(){
         	return By.xpath("//div[@id='listDesc']/h1/span");
         }
         /*
          * Function to get weight of favs block top list.
          */
    
      public String getHeaderAfterClickFavlist(){
      	return safeGetText(headerAfterClickFavlist(), VERYLONGWAIT);
      }
      
      /*
   	 * Locator for favs block list link.
   	 */
    private By moreFaves(){
    	return By.xpath("//div[@id='evergreen']/div[@class='viewAll rnkrBGreyBg center lowercase']/a");
    }
    /*
     * Function to click on favs block list link text.
     */
    
    public void clickOnMoreFaves(){
		safeClick(moreFaves(), VERYLONGWAIT);
	}
    /*
     * Function to get href of favs block top list.
     */
    
    public String gethrefMoreFaves(){
    	return driver.findElement(moreFaves()).getAttribute("href");
    }
    /*
   	 * Locator for hover over block's header of fav block list.
   	 */
      private By hoverOverFavBlockListHeader(){
    	  return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']/a[@class='block title undefined']");
      }
      /*
       * Function to check presence of header on hover over favs block list.
       */
      public boolean ishoverOverFavBlockListHeaderPresent(){
    	  return isElementPresent(hoverOverFavBlockListHeader());
      }
      /*
     	 * Locator for hover over block's image of fav block list.
     	 */
      private By hoverOverFavBlockListImage(){
    	  return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']/a[@class='float']/img");
      }
      /*
       * Function to check presence of image on hover over favs block list.
       */
      public boolean ishoverOverFavBlockListImagePresent(){
    	  return isElementPresent(hoverOverFavBlockListImage());
      }
      /*
     	 * Locator for hover over block's profile name of fav block list.
     	 */
      private By hoverOverFavBlockListProfileName(){
    	  return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']/span[@class='block midGrey']");
      }
      /*
       * Function to check presence of profile name on hover over favs block list.
       */
      public boolean ishoverOverFavBlockListProfileNamePresent(){
    	  return isElementPresent(hoverOverFavBlockListProfileName());
      }
      /*
     	 * Locator for hover over block's description of fav block list.
     	 */
      private By hoverOverFavBlockListDescription(){
    	  return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']/p");
      }
      /*
       * Function to check presence of description on hover over favs block list.
       */
      public boolean ishoverOverFavBlockListDescriptionPresent(){
    	  return isElementPresent(hoverOverFavBlockListDescription());
      }
      /*
       * Function to get hover over favs block list.
       */
      public void hoverOnMore(int number){
    	  scrollIntoViewThroughJavaScriptExecuter(favsBlocklistlink(number+"")); 
    	  mouseHover(favsBlocklistlink(number+""), VERYLONGWAIT);
      }
   
      /*
      * Locator for hover over more link in fav block list.
      */
      private By hoverMoreLink(){
    	  return By.xpath("//div[@class='dialog ui-dialog-content ui-widget-content']/a[@class='block more']");
      }
      /*
       * Function to click on more link in hovering box of fav block list.
       */
      public void clickOnHoverMore(){
    	  
    	  driver.findElement(hoverMoreLink()).click();
      }
      /*
       * Function to check presence of more link in hovering box of fav block list.
       */
       public boolean ishoverMoreLinkPresent(){
    	  return isElementPresent(hoverOverFavBlockListDescription(),MEDIUMWAIT);
      }
       /*
    	 * Locator for favs block text."top faves in Tv"
    	 */
     private By favsBlocktxt(){
     	return By.xpath("//div[@id='evergreen']/ul/li[1]/a/span[@class='float relative block subT midGrey uppercase']");
     }
     /*
      * Function to check presence of fav block list.of text "top faves in Tv"
      */
      public boolean isPresentfavsBlocktxt(){
   	  return isElementPresent(favsBlocktxt(),MEDIUMWAIT);
     }
      /*
  	 * Locator for favs block in first image
  	 */
   private By favsBlockfirstimage(){
   	return By.xpath("//div[@id='evergreen']/ul/li[1]/a/span[@class='float block']/img");
   }
   /*
    * Function to get image size of favs blocksection in 1 list
    */
 	public String getimageSizeOffirstfavsBlock(){
 		return driver.findElement(favsBlockfirstimage()).getCssValue("height");
 	}
 	/*
  	 * Locator for favs block in first image
  	 */
   private By favsBlocksecondimage(){
   	return By.xpath("//div[@id='evergreen']/ul/li[2]/a/span[@class='float block']/img");
   }
   /*
    * Function to get image size of favs blocksection in 1 list
    */
 	public String getimageSizeOfsecondfavsBlock(){
 		return driver.findElement(favsBlocksecondimage()).getCssValue("height");
 	}
 	/*
  	 * Locator for views in list
  	 */
   private By views(int num){
	   return By.xpath("//div[@id='landingInfo']/section[@id='fresh']/ol/li["+num+"]/div[@class='listData midGrey']/span[1]/em[contains(text(),'views')]");
   	//return By.xpath("//div[@id='landingInfo']/section[@id='fresh']/ol/li["+num+"]/div[@class='listData midGrey']/span[1]/em[contains(text(),'views')]");
   }
   /*
    * Function to check presence of fav block list.of text "top faves in Tv"
    */
    public boolean isPresentviewsinlist(int num){
 	  return isElementPresent(views(num),MEDIUMWAIT);
   }
    private By viewsinlist(int num){
 	   return By.xpath("//div[@id='landingInfo']/section[@id='fresh']/ol/li["+num+"]/div[@class='listData midGrey']/span[1]");
    	//return By.xpath("//div[@id='landingInfo']/section[@id='fresh']/ol/li["+num+"]/div[@class='listData midGrey']/span[1]/em[contains(text(),'views')]");
    }
    /*
     * Function to get views in list
     */

 public String getviewsinlist(int num){
 	return safeGetText(viewsinlist(num), VERYLONGWAIT);
 }
}
