package com.testsuite.PicsPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetAlertText;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.pageobjects.PicsPage.PicsPage;
import com.pageobjects.blog.BlogPage;
import com.pageobjects.grid.Grid;
import com.pageobjects.listheader.ListHeader;
import com.pageobjects.listoption.ListOptionPage;
import com.pageobjects.nodepage.Nodepage;
import com.selenium.SafeActions;

public class PicsPageTest  extends BaseSetup{

	ConfigManager urls=new ConfigManager("PreProduction");
	ConfigManager sysProp=new ConfigManager("Sys");
	 Commonpage common;
	 SafeActions s = new SafeActions(getDriver());
	 String url=config.getProperty("Url")+urls.getProperty("PicsPage");
	 
	 /* 
	  * Use-case : Topic Page on pics page.	  
	  * Test case : Go To any pics page. Topic Page text should take to the corresponding header's node page. 
	  */
	 @Test(priority=1,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void TopicPage(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 PicsPage picsPage=null;
		 if(loginRequired.equals("YES")){
			 picsPage =BaseStateWithLogin("TopicPage");
		 }else{
			 picsPage =BaseState("TopicPage");
		 }
		 String[] beforeTopic=picsPage.getTextOfpicPageHeader().split("\n");
		 picsPage.clickOnpicsPageTopicPage();
		 common.facebookLikePresenceAndAccept();
		 String afterTopic=picsPage.getTextOfpicsPageHeaderNextPage();
		 Assert.assertEquals(afterTopic, beforeTopic[0]);
	 }//End of TopicPage()

	 /* 
	  * Use-case : AdChoices.  
	  * Test case : Go to any pics page. The adChoices links displayed should take to the corresponding link page.  
	  */
	 @Test(priority=2,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void Adhoices(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 PicsPage picsPage=null;
		 if(loginRequired.equals("YES")){
			 picsPage =BaseStateWithLogin("Adhoices");
		 }else{
			 picsPage =BaseState("Adhoices");
		 }
		 try {
			Thread.sleep(4000);
		} catch (Exception e) {
			
		}
		  for(int i=1;i<=3;i++){
		    String beforeclick=picsPage.gethrefOfadChoices(i);
		    picsPage.clickOnadChoices(i);
		    
		    
		// s.waitForPageToLoad(30);
		 getDriver().switchTo().defaultContent();
			 try{
				 Thread.sleep(9000); 
			 }catch(Exception e){}
		 ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
		 getDriver().switchTo().window(tabs2.get(1));
		 Assert.assertEquals(beforeclick, getDriver().getCurrentUrl());
		 
		 System.out.println("getCurrentUrl---------"+getDriver().getCurrentUrl());
		 getDriver().close();
		 getDriver().switchTo().window(tabs2.get(0));
		}
	 }//End of Adhoices()
//
	 /* 
	  * Use-case : Images in pics page.	  
	  * Test case : Go to any pics page.On clicking on the previous and next arrow button pictures should be changed. 
	  */
	 @Test(priority=3,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ImageNextPrevious(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 PicsPage picsPage=null;
		 if(loginRequired.equals("YES")){
			 picsPage =BaseStateWithLogin("ImageNextPrevious");
		 }else{
			 picsPage =BaseState("ImageNextPrevious");
		 }
		 //previous
		 String listPrevHref=picsPage.gethrefOfImageInList(5);
		 picsPage.clickOnImagePreviousButton();
		 try{
			 Thread.sleep(15000);
		 }catch(Exception e){}
		 String showPrevHref=picsPage.gethrefOfMainImage();
//		 if(sysProp.getProperty("Browser.Name").equals("chrome")){
			 try{
				 Thread.sleep(2000); 
			 }catch(Exception e){}
//			
//		 }
		 Assert.assertEquals(listPrevHref, showPrevHref);
		 //next
		 String listNextHref=picsPage.gethrefOfImageInList(6);
		 picsPage.clickOnImageNextButton();
		 String showNextHref=picsPage.gethrefOfMainImage();
		 Assert.assertEquals(listNextHref, showNextHref);
	 }//End of ImageNextPrevious()

	 /* 
	  * Use-case : Buzzing Ranker Link  
	  * Test case : Go to any pics page.On clicking on the links in buzzing ranker section it should take to the corresponding links page. 
	  */
	 @Test(priority=4,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void BuzzingRanker(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 PicsPage picsPage=null;
		 if(loginRequired.equals("YES")){
			 picsPage =BaseStateWithLogin("BuzzingRanker");
		 }else{
			 picsPage =BaseState("BuzzingRanker");
		 } 
		 String href=picsPage.gethrefBuzzingBlock(1);
		 picsPage.clickOnBuzzingBlock(1);
//			 try{
//				 Thread.sleep(5000); 
//			 }catch(Exception e){}
		 String currentUrl=getDriver().getCurrentUrl();
		 String[] indexurl=currentUrl.split("\\?");
		 Assert.assertEquals(indexurl[0],href);
		
	 }//End of BuzzingRanker()

	 /* 
	  * Use-case : Report Photo.
	  * Test case : Go to any pics page.On clicking on the report photo list for reporting will generate. On selecting any option report should be generated. 
	  */
	 @Test(priority=5,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ReportPhoto(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 PicsPage picsPage=null;
		 if(loginRequired.equals("YES")){
			 picsPage = BaseStateWithLogin("ReportPhoto");
		 }else{
			 picsPage = BaseState("ReportPhoto");
		 }
		 picsPage.clickOnreportPhoto();
		 picsPage.checkOnMiscategorizedOnPopup();
		 picsPage.clickOnreportButton();
		Assert.assertTrue(picsPage.AlertExistsAndAccepted(MEDIUMWAIT));
		
	 }//End of BuzzingRanker()
 
	 /* 
	  * Use-case : Select a image in the gallery.
	  * Test case : 1) Open any pic page
	                2) Click on "any of the image" in the gallery appear below the main pic 
	  */
	 @Test(priority=6,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PicsImg(String loginRequired){
	 	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
	 	 //Base state. (Navigate to page having right rail)
	 	 PicsPage picsPage=null;
	 	 if(loginRequired.equals("YES")){
	 		 picsPage =BaseStateWithLogin("PicsImg");
	 	 }else{
	 		 picsPage =BaseState("PicsImg");
	 	 }
	 	 picsPage.clickOnPicsimg(5);
	 	 Assert.assertEquals(picsPage.gethrefOfMainImage(), picsPage.gethrefOfImageInList(5));
	      }//End of PicsImg;
	 /* 
	  * Use-case : Listed on any pics images and click topics page 
	  * Test case : Check listed on section with the topic page.            
	  */
	 @Test(priority=7,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void picsimgListedOn(String loginRequired){
	 	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
	 	 //Base state. (Navigate to page having right rail)
	 	 PicsPage picsPage=null;
	 	 if(loginRequired.equals("YES")){
	 		 picsPage =BaseStateWithLogin("picsimgListedOn");
	 	 }else{
	 		 picsPage =BaseState("picsimgListedOn");
	 	 }
	 	 Assert.assertTrue(picsPage.isListedOnLinkPresentPics());
	 	 for(int i=1;i<=3;i++)
	 	 {
	 		 Assert.assertTrue(picsPage.isPresentPicsimgListedintitle(i+""));
	 		 picsPage.clickOnpicsPageTopicPage();
	 		 try{
	 			 Thread.sleep(7000);
	 		 }catch(Exception e){}
	 		 Assert.assertTrue(picsPage.isListedOnclickLinkPresentPics());
	 		 Assert.assertTrue(picsPage.isPresentPicsimgListedintitle(i+""));
	 		  
	 		 //Assert.assertEquals(beforetext, aftertext);
	 		 getDriver().navigate().back();
	 	 }
	 }//End of Listed on any pics images
	 /* 
	 * Use-case : List in Horizontal view
	 * Test case : List in Horizontal view and Check Fans also view           
	 */
	@Test(priority=8,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void picsimgHorizontalview(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 PicsPage picsPage=null;
		 if(loginRequired.equals("YES")){
			 picsPage =BaseStateWithLogin("picsimgHorizontalview");
		 }else{
			 picsPage =BaseState("picsimgHorizontalview");
		 }
         common.getNewURL(config.getProperty("Url")+"pics/N1367318/kevin-pollak-writers-photo-1");
       //  s.waitForPageToLoad(20);
		 if(sysProp.getProperty("Browser.Name").equals("chrome")){
			 try{
				 Thread.sleep(6000); 
			 }catch(Exception e){}
		 }		 
		 Assert.assertTrue(picsPage.isfansPresentPicsinhorizontal());
	}//End of Listed on any pics images
	
	/* 
	 * Use-case : popular List
	 * Test case : Check popular list and corresponding links       
	 */
	@Test(priority=9,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void picsimgPopularList(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 9 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 PicsPage picsPage=null;
		 if(loginRequired.equals("YES")){
			 picsPage =BaseStateWithLogin("picsimgPopularList");
		 }else{
			 picsPage =BaseState("picsimgPopularList");
		 }
		 Assert.assertTrue(picsPage.isPresentpicsimgpopularlist());
		 String before=picsPage.getTextpicsimgpopularlistofimgHeader(2);
		 picsPage.clickOnpopularlistofimgHeader(2);
		 String after=picsPage.getTextpopularlistofimgHeaderonclick();
		 Assert.assertEquals(before, after);
	}//End of popular List

	/* 
	 * Use-case : Images Count
	 * Test case : Check Images is 48 images present in list
	 */
	@Test(priority=10,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void picsimgCount(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 10 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 PicsPage picsPage=null;
		 if(loginRequired.equals("YES")){
			 picsPage =BaseStateWithLogin("picsimgCount");
		 }else{
			 picsPage =BaseState("picsimgCount");
		 }
		 String[] numberOfImages= picsPage.getTextOfNumberOfImages().split(" ");
		 int imageCount = Integer.parseInt(numberOfImages[0]);
		 for(int i=1;i<=imageCount;i++){
				Assert.assertTrue(picsPage.isImagePresentInList(i));
		 }
	}//End of Images Count
	/* 
	 * Use-case : Social Links
	 * Test case : Check Social links available on the page.              
	 */
	@Test(priority=11,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void SocialLinks(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 11 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 PicsPage picsPage=null;
		 ListOptionPage listoptionpage =new ListOptionPage(getDriver());
		 ListHeader listHeader=new ListHeader(getDriver());
		 if(loginRequired.equals("YES")){
			 picsPage =BaseStateWithLogin("SocialLinks");
		 }else{
			 picsPage =BaseState("SocialLinks");
		 }
			
			//Click on twitter and check whether right page is opening or not.	
			picsPage.clickOnTwitter();
			try{
				Thread.sleep(2000);
			}catch(Exception e){}
		     
			common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
			if(listoptionpage.isPresenttiwtterlogin()==true){
				Assert.assertEquals(1,1);
			}else if(listHeader.isPresenttwitterwindowpresent()) {
				Assert.assertEquals(1,1);
			}else
			{
				Assert.assertEquals(1,0);	
			}
			//Assert.assertTrue(picsPage.isTwitLoginImagePresent());
			getDriver().close();
			picsPage.switchToParentWindow();
			
			//Click on facebook and check whether right page is opening or not.
			picsPage.clickOnfacebook();
			try{
				Thread.sleep(2000);
			}catch(Exception e){}
			common.facebookLogin("vikas@ranker.com", "vikas@123");
			//picsPage.switchToParentWindow();
			Assert.assertTrue(picsPage.isFbShareWindowPresent());
//			getDriver().close();
//			picsPage.switchToParentWindow();
			//Click on pinterest and check whether right page is opening or not.	
			
	}//End of SocialLinks
	
	/* 
	 * Use-case : Social Links
	 * Test case : Check Social links available on the page.              
	 */
	@Test(priority=12,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void SocialLinksPinterest(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 PicsPage picsPage=null;
		 ListOptionPage listoptionpage =new ListOptionPage(getDriver());
		 ListHeader listHeader=new ListHeader(getDriver());
		 if(loginRequired.equals("YES")){
			 picsPage =BaseStateWithLogin("SocialLinksPinterest");
		 }else{
			 picsPage =BaseState("SocialLinksPinterest");
		 }
			//Click on pinterest and check whether right page is opening or not.	
			picsPage.clickOnPinterest();
			//if(sysProp.getProperty("Browser.Name").equals("chrome")){
				 try{
					 Thread.sleep(2000); 
				 }catch(Exception e){}
			// }
			
		    common.clickOnPintLoginFBbutton();
			common.facebookLogin("salmankhantc", "Dehradun1");
			SafeActions sf = new SafeActions(getDriver());
			sf.switchToWindow(1);
			Assert.assertTrue(listoptionpage.ispintersetWindowPresent());
			try{
				Thread.sleep(3000);
			}catch(Exception e){}
			getDriver().close();
			picsPage.switchToParentWindow();
	}//End of SocialLinksPinterest
	
	/* 
	 * Use-case : List pics page logic for fans have also viewed
	 * Test case : Open any list pics page eg: http://www.ranker-stage.com/pics/L373705/the-most-influential-contemporary-americans-u1 
     */  		   
	@Test(priority=13,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FansHaveAlsoviewed(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 14 !!!!!!!!!!!!!!!!!!!!!!!");
		 PicsPage picsPage=null;
		// Alert alert = null;
		 ListOptionPage listoptionpage =new ListOptionPage(getDriver());
		 ListHeader listHeader=new ListHeader(getDriver());
		 Nodepage nodePage=new Nodepage(getDriver());
		 Grid grid=new Grid(getDriver());	
		 if(loginRequired.equals("YES")){
			 picsPage =BaseStateWithLogin("FansHaveAlsoviewed");
		 }else{
			 picsPage =BaseState("FansHaveAlsoviewed");
		 }
		 common.getNewURL(config.getProperty("Url")+"pics/L373705/the-most-influential-contemporary-americans-u1");
		 common.signin("vijaymohanp", "server");
		 Assert.assertTrue(nodePage.isFansAlsoViewedHeaderPresent());
		 for(int i=1;i<=6;i++){
			 Assert.assertTrue(nodePage.isFansAlsoViewedPresent(i));
				    }
	}
	/* 
	 * Use-case : Pics Page: untag nsfw
	 * Test case : Open pics page of a node that is NSFW (ex: http://www.ranker-stage.com/pics/N2082140/stacy-keibler-athletes-photo-u62). Click on "Remove NSFW Tag" from the admin bar. Since the node 2082140 is tagged nsfw (check ranker.node_tag table) 
     */  		   
	@Test(priority=14,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void RemoveUntagNsfw(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 13 !!!!!!!!!!!!!!!!!!!!!!!");
		 PicsPage picsPage=null;
		// Alert alert = null;
		 ListOptionPage listoptionpage =new ListOptionPage(getDriver());
		 ListHeader listHeader=new ListHeader(getDriver());
		 Grid grid=new Grid(getDriver());	
		 if(loginRequired.equals("YES")){
			 picsPage =BaseStateWithLogin("UntagNsfw");
		 }else{
			 picsPage =BaseState("UntagNsfw");
		 }
		 common.getNewURL(config.getProperty("Url")+"pics/N2082140/stacy-keibler-athletes-photo-u62");
		 common.signin("vijaymohanp", "server");
		 {
		 grid.clickOnremoveNSFW();
		 listHeader.AlertExistsAndAccepted(1000);
		 try{
			 Thread.sleep(3000);
		 }catch(Exception e){}
		           Alert alert1 = getDriver().switchTo().alert();
		           String showalert=alert1.getText();
		           if(showalert.contains("the node itself is tagged with that tag!"))
		        	   Assert.assertEquals(1, 1);
		           else
		        	   Assert.assertEquals(1, 0);
		 }
	}
	/* 
	 * Use-case : Pics Page: untag nsfw
	 * Test case : 1-Go to a pics page of a node that is NOT NSFW (ex: http://www.ranker-stage.com/pics/N1558135/megan-fox-people-in-tv-photo-u120). Click on "Remove NSFW Tag" from the admin bar. 
     */  		   
	@Test(priority=15,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void UntagNsfw(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 13 !!!!!!!!!!!!!!!!!!!!!!!");
		 PicsPage picsPage=null;
		// Alert alert = null;
		 ListOptionPage listoptionpage =new ListOptionPage(getDriver());
		 ListHeader listHeader=new ListHeader(getDriver());
		 Grid grid=new Grid(getDriver());	
		 if(loginRequired.equals("YES")){
			 picsPage =BaseStateWithLogin("UntagNsfw");
		 }else{
			 picsPage =BaseState("UntagNsfw");
		 }
		 common.getNewURL(config.getProperty("Url")+"pics/N1558135/megan-fox-people-in-tv-photo-u120");
		 common.signin("vijaymohanp", "server");
		 if(grid.isPresentremoveNSFW()==true){
		 grid.clickOnremoveNSFW();
		 listHeader.AlertExistsAndAccepted(1000);
		 try{
			 Thread.sleep(3000);
		 }catch(Exception e){}
		           Alert alert1 = getDriver().switchTo().alert();
			       Assert.assertEquals("NSFW tag successfully removed", alert1.getText());
		 }
		 else{
		      grid.clickOnTagNSFW();
		      listHeader.AlertExistsAndAccepted(1000);
		      listHeader.AlertExistsAndAccepted(1000);
		      try{
					 Thread.sleep(3000);
				 }catch(Exception e){}
		      grid.clickOnremoveNSFW();
				 listHeader.AlertExistsAndAccepted(1000);
				 try{
					 Thread.sleep(3000);
				 }catch(Exception e){}
				           Alert alert1 = getDriver().switchTo().alert();
					       Assert.assertEquals("NSFW tag successfully removed", alert1.getText());
		         }
	}
/*
 * This is base state of the Right rail test-cases.
 */
public PicsPage BaseState(String testName){
	 try{
	 startRecording(testName);
	}catch(Exception e){}
	 common=new Commonpage(getDriver());
	 PicsPage picsPage=common.getPicsPage(url);
	 return picsPage;
} //End of BaseState()
/*
 * This is base state of the Right rail test-cases.
 */
public PicsPage BaseStateWithLogin(String testName){
	 try{
	 startRecording(testName);
	}catch(Exception e){}
	 common=new Commonpage(getDriver());
	 common.signin("testuserkallol1@mailinator.com", "testing");
	 PicsPage picsPage=common.getPicsPage(url);
	 return picsPage;
} //End of BaseStateWithLogin()
}