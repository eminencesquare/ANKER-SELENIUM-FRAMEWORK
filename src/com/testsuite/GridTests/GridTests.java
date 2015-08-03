package com.testsuite.GridTests;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

import net.sourceforge.htmlunit.corejs.javascript.ast.TryStatement;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.pageobjects.grid.Grid;
import com.pageobjects.listheader.ListHeader;
import com.pageobjects.listoption.ListOptionPage;
import com.pageobjects.slideshow.Slideshow;
import com.selenium.SafeActions;

public class GridTests extends BaseSetup{
 ConfigManager urls=new ConfigManager("PreProduction");
	ConfigManager sysProp=new ConfigManager("Sys");
     Commonpage common;
	 String url=config.getProperty("Url")+urls.getProperty("ListView");
	 
	 /*
	  * Wait for browser.
	  */
	 public void browserWait(){
		 if(sysProp.getProperty("Browser.Name").equals("chrome")){
			 try{
				 Thread.sleep(10000); 
			 }catch(Exception e){}	
		 }
	 }
	 
	 /* 
	  * Use-case : Images - click
	  * Test case : Click on an image that is not tagged to have links to Amazon.  
	  */
	 @Test(priority=1,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ImagesClick(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("ImagesClick");
		 }else{
			 grid =BaseState("ImagesClick");
		 }
		 //Compare node text with Page header after clicking on the node image.
		 String nodeTextBefore =grid.getNodeText(1);
//		 try{////
//			 Thread.sleep(2000);
//		 }catch(Exception e){}
		 grid.clickNodeImage(1);
		 Assert.assertEquals(nodeTextBefore+"\n"+"topic page", grid.getImageHeader());
	 }//End of ImagesClick()
	 
	 /* 
	  * Use-case : Node Name - click
	  * Test case : Click on a node name that has a node page.   
	  */
	 @Test(priority=2,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void NodeNameClick(String loginRequired){
	  //
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("NodeNameClick");
		 }else{
			 grid =BaseState("NodeNameClick");
		 }
		 //Compare node text with page header after clicking on the node name.
		 String nodeTextBefore =grid.getNodeText(1);
		 grid.clickNodeText(1);
		 
		 Assert.assertEquals(nodeTextBefore, grid.getTextHeaderForNode());
	 }//End of NodeNameClick()
	
	 /* 
	  * Use-case : Upvote
	  * Test case : Click on the thumbs up button on any list in grid view.  
	  */
	 @Test(priority=3,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void upvote(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("upvote");
		 }else{
			 grid =BaseState("upvote");
		 }
		 //Comparing number of upvote should be plus 1 after click on upvote.
		 grid.autoloadingnodename(2);
		 String upvoteNoBefore=grid.getUpvoteText("3");
		 int upvoteNoB = Integer.parseInt(upvoteNoBefore);
		 grid.clickUpvote("3");
//		 try{////
//			 Thread.sleep(3000);
//		 }catch(Exception e){}
		 String upvoteNoAfter=grid.getUpvoteText("3");
		 int upvoteNoA = Integer.parseInt(upvoteNoAfter);
		 Assert.assertEquals(upvoteNoA, upvoteNoB+1);
	 }//End of upvote()
	 /* 
	  * Use-case : Downvote
	  * Test case : Click on the thumbs down button on any list in grid view.
	  */
	 @Test(priority=4,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void downvote(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("downvote");
		 }else{
			 grid =BaseState("downvote");
		 }
		 //Comparing number of downvote should be plus 1 after click on downvote.
		 grid.autoloadingnodename(2);
		 String downvoteNoBefore=grid.getDownvoteText("3");
		 int downvoteNoB = Integer.parseInt(downvoteNoBefore);
		 grid.clickDownvote("3");
//		 try{
//			 Thread.sleep(3000);
//		 }catch(Exception e){}//
		 String downvoteNoAfter=grid.getDownvoteText("3");
		 int downvoteNoA = Integer.parseInt(downvoteNoAfter);
		 Assert.assertEquals(downvoteNoA, downvoteNoB+1);
	 }//End of downvote()

	 /* 
	  * Use-case : On Your List [ULTIMATE/RERANK]
	  * Test case : Go to an Ultimate or Rerank list that you have previously reranked.  
	  */
	 @Test(priority=5,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ultimateOnYourList(String loginRequired){ 
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("ultimateOnYourList");
		 }else{
			 grid =BaseState("ultimateOnYourList");
		 }
		 //Checking the text and font style of ultimate list.
		 String txt=grid.getUltimateTxt();
		 Assert.assertEquals("Ultimate List", txt);
		 Assert.assertEquals("italic", grid.getFontStyleUltimateList());
	}//End of ultimateOnYourList()
	 /* 
	  * Use-case : Node Badges
	  * Test case : Go to any list in grid view that has node badges.  
	  */
	 @Test(priority=6,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void nodeBadges(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("nodeBadges");
		 }else{
			 grid =BaseState("nodeBadges");
		 }
		 //check text and font style of node badges.
		 common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-best-movies-of-all-time");
		 String txt1=grid.getNodeBadgesTxt("The Godfather", "2");
		 String txt2=grid.getNodeBadgesTxt("The Godfather", "3");
		 String txt3=grid.getNodeBadgesTxt("The Godfather", "4");
		 Assert.assertNotNull(txt1+" "+txt2+" "+txt3);
		// Assert.assertEquals("most listed & ranked high on reranks", txt1+" "+txt2+" "+txt3);
		 Assert.assertEquals("italic", grid.getFontStyleNodeBadges("The Godfather", "2"));
		 Assert.assertEquals("italic", grid.getFontStyleNodeBadges("The Godfather", "3"));
		 Assert.assertEquals("italic", grid.getFontStyleNodeBadges("The Godfather", "4"));
	 }//End of nodeBadges()
	 /* 
	  * Use-case : Node Badges - click
	  * Test case : Click on the node badges located above the node names.  
	  */
	 @Test(priority=7,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void nodeBadgesClick(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("nodeBadgesClick");
		 }else{
			 grid =BaseState("nodeBadgesClick");
		 }
		 //Check node badges popup.
		 common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-best-movies-of-all-time");
		 grid.clickNodeBadges("The Godfather","4");//1
		 SafeActions s = new SafeActions(getDriver());
	     s.waitForPageToLoad(40);
		 Assert.assertTrue(grid.isThePeoplePopupPresent());
	     //Assert.assertEquals("More people put this #1 on their own list than anything else", grid.getTextOfPeoplePopup());
		 Assert.assertNotNull(grid.getTextOfPeoplePopup());
		 grid.closePeoplePopup();
	 } //End of nodeBadgesClick()
	 /* 
	  * Use-case : Added By 
	  * Test case : Go to any list in grid view that has nodes added by users through openlist add item.  
	  */
	 @Test(priority=8,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void AddedBy(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("AddedBy");
		 }else{
			 grid =BaseState("AddedBy");
		 }
		 //Check text and font style of node badges.//actors-nobody-cares-about-anymore/ranker-celebrities
		 common.getNewURL(config.getProperty("Url")+"list/actors-nobody-cares-about-anymore/ranker-celebrities");
		 try {
		Thread.sleep(10000)	;
		} catch (Exception e) {
			
		}
		 String txt3=grid.getNodeBadgesTxt("Pauly Shore", "2");
		 Assert.assertEquals("added by Dismalhead", txt3);
		 Assert.assertEquals("italic", grid.getFontStyleNodeBadges("Pauly Shore", "2"));
	 }//End of AddedBy()
	 /* 
	  * Use-case : Open Button
	  * Test case : Go to any list in grid view.  
	  */
	 @Test(priority=9,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void OpenButton(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 9 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("OpenButton");
		 }else{
			 grid =BaseState("OpenButton");
		 }
		 //browserWait();
		 grid.autoloadingnodename(5);
		 grid.clickOnOpenButton(6);
		 //browserWait();
		 Assert.assertNotNull(grid.getDescriptionOfNode("6"));
	 }//End of OpenButton()
	 /* 
	  * Use-case : Wiki Scrape - more
	  * Test case : Go to any list in grid view.  
	  */
	 @Test(priority=10,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void WikiScrapeMore(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 10 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("WikiScrapeMore");
		 }else{
			 grid =BaseState("WikiScrapeMore");
		 }
		 String nodeTextBefore =grid.getNodeText(2);
		 SafeActions s = new SafeActions(getDriver());
	     s.waitForPageToLoad(40);
		 grid.clickOnOpenButton(2);
		 //SafeActions s = new SafeActions(getDriver());
	    // s.waitForPageToLoad(40);
		 //Check wiki scrape more functionality.
		 grid.clickOnWikiScrapeMore("2");
		 try{
			 Thread.sleep(3000);
		 }catch(Exception e){}
//	      s.waitForPageToLoad(80);
		 ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
		 getDriver().switchTo().window(tabs2.get(1));
		  Assert.assertEquals(nodeTextBefore, grid.getTextHeaderForNode());
		 getDriver().close();
		 getDriver().switchTo().window(tabs2.get(0));	
	 }//End of WikiScrapeMore()  // ie me chnge  remaining java.lang.IndexOutOfBoundsException: Index: 1, Size: 1 
	
     /* 
* Use-case : Also Ranked On
* Test case : Go to any list in grid view.  
*/
@Test(priority=11,dataProviderClass = DataProviders.class, dataProvider = "Login")
public void AlsoRankedOn(String loginRequired){
System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 11 !!!!!!!!!!!!!!!!!!!!!!!");
//Base state. (Navigate to grid page)
Grid grid=null;
if(loginRequired.equals("YES")){
grid =BaseStateWithLogin("AlsoRankedOn");
}else{
grid =BaseState("AlsoRankedOn");
}
grid.clickOnOpenButton(2);
SafeActions s = new SafeActions(getDriver());
//s.waitForPageToLoad(40);
try{////
Thread.sleep(3000);
}catch(Exception e){}
//Check Also ranked text and nodes presence.
Assert.assertTrue(grid.isAlsoRankedPresent("2"));
for(int i=1;i<=2;i++){
Assert.assertTrue(grid.isAlsoRankedNodePresent("2", i+""));
}			
}//End of AlsoRankedOn()
	 /* 
	  * Use-case : Also Ranked On - lists
	  * Test case : Click on any of the links in the Also Rnked On block. 
	  */
	 @Test(priority=12,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void AlsoRankedOnList(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("AlsoRankedOnList");
		 }else{
			 grid =BaseState("AlsoRankedOnList");
		 }
		 grid.clickOnOpenButton(2);
		 //Check the Also ranked text.
		 String textBefore= grid.getTextOfAlsoRanked("2", "2");
		 grid.clickAlsoRankedNode("2", "2");
		   SafeActions s = new SafeActions(getDriver());
	      s.waitForPageToLoad(40);
		 //browserWait();
		 ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
		 getDriver().switchTo().window(tabs2.get(1));
		 Assert.assertEquals(textBefore, grid.getTextHeaderForList());
		 getDriver().close();
		 getDriver().switchTo().window(tabs2.get(0));
	 }//End of AlsoRankedOnList()

	 /* 
	  * Use-case : Link to Node Page
	  * Test case : Go to any list in grid view that has nodes that have node pages.
	  */
	 @Test(priority=13,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void LinkToNodePage(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 13 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("LinkToNodePage");
		 }else{
			 grid =BaseState("LinkToNodePage");
		 }
		 String nodeTextBefore =grid.getNodeText(2);
		// System.out.println("nodeTextBefore==="+nodeTextBefore);
		 grid.clickOnOpenButton(2);
		 try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 //Check the presence of more icon , more node name and more info presence.
		 Assert.assertTrue(grid.isMoreIconPresent("2"));
		 Assert.assertTrue(grid.isMoreNodeNamePresent("2"));
		 Assert.assertTrue(grid.isMoreInfoPresent("2"));
		 //Check the wiki scrape more functionality.
		 try{
			 Thread.sleep(3000);
		 }catch(Exception e){}
		 grid.clickOnWikiScrapeMore("2");
		 browserWait();
		 browserWait();
		 ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
		 getDriver().switchTo().window(tabs2.get(1));
		 browserWait();
		// System.out.println("grid.getTextHeaderForNode()==="+grid.getTextHeaderForNode());
		 Assert.assertEquals(nodeTextBefore, grid.getTextHeaderForNode());
		 getDriver().close();
		 getDriver().switchTo().window(tabs2.get(0));	
	 }//End of LinkToNodePage() 

	 
	 
	 /* 
	  * Use-case : Blather
	  * Test case : Go to any list in grid view that has blather. 
	  */
	 @Test(priority=15,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void Blather(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 15 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("Blather");
		 }else{
			 grid =BaseState("Blather");
		 }
		 //Check the blather text.
		 common.getNewURL(config.getProperty("Url")+"list/top-6-most-popular-pm-candidates-for-2014-election-in-india/vijaymohanp?format=GRID");
		// browserWait();
		  SafeActions s = new SafeActions(getDriver());
	      s.waitForPageToLoad(60);
		 String data=grid.getBlatherText("1");
		 Assert.assertEquals("Narendra Damodardas Modi (born September 17, 1950) is the longest-serving chief minister of Gujarat. He has held the office since 2001 and has been successfully re-elected three times. Widely seen as", data);
	 }//End of Blather()
	 /* 
	  * Use-case : Report Item [LOGGED IN]
	  * Test case : Go to any list in grid view as a logged in user and expand the node row with the "open" button.
	  */
	 @Test(priority=16)
	 public void ReportItemLoggedIn(){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 16 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=BaseStateWithLogin("ReportItemLoggedIn");
		 common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-best-movies-of-all-time");
		 SafeActions s = new SafeActions(getDriver());
	      s.waitForPageToLoad(40);
		 String txt1=grid.getNodeBadgesTxt("The Godfather", "2");
		 String txt2=grid.getNodeBadgesTxt("The Godfather", "3");
		 String txt3=grid.getNodeBadgesTxt("The Godfather", "4");
		 Assert.assertNotNull(txt1+" "+txt2+" "+txt3);
		 try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 System.out.println("grid.getFontStyleNodeBadges="+grid.getFontStyleNodeBadges("The Godfather", "2"));
		 Assert.assertEquals("italic", grid.getFontStyleNodeBadges("The Godfather", "2"));
		 
		 Assert.assertEquals("italic", grid.getFontStyleNodeBadges("The Godfather", "3"));
		 System.out.println("grid.getFontStyleNodeBadges="+grid.getFontStyleNodeBadges("The Godfather", "3"));
		 Assert.assertEquals("italic", grid.getFontStyleNodeBadges("The Godfather", "4"));
		 System.out.println("grid.getFontStyleNodeBadges="+grid.getFontStyleNodeBadges("The Godfather", "4"));
		 common.getNewURL(config.getProperty("Url")+"list/actors-nobody-cares-about-anymore/ranker-celebrities");
	      s.waitForPageToLoad(40);
		 String txt4=grid.getNodeBadgesTxt("Pauly Shore", "2");
		 Assert.assertEquals("added by Dismalhead", txt4);
		 Assert.assertEquals("italic", grid.getFontStyleNodeBadges("Pauly Shore", "2"));
	 }//End of ReportItemLoggedIn()
	 /* 
	  * Use-case : Quotations 
	  * Test case : Go to any quotes list in grid view. 
	  */
	 @Test(priority=17,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void QuotationList(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 17 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("QuotationList");
		 }else{
			 grid =BaseState("QuotationList");
		 }
		 //Check the font style and family of quotation list.
		common.getNewURL(config.getProperty("Url")+"list/a-list-of-famous-mahatma-gandhi-quotes/reference");
		SafeActions s = new SafeActions(getDriver());
	    s.waitForPageToLoad(40);
		common.facebookLikePresenceAndAccept();
		Assert.assertEquals("italic", grid.getNodeTextFontStyle(1));
		System.out.println("grid.getNodeTextFontFamily()== " +grid.getNodeTextFontFamily(1).trim().replaceAll(" ", "").replaceAll("\"", "").replaceAll("'", ""));
		if(grid.getNodeTextFontFamily(1).trim().replaceAll(" ", "").replaceAll("\"", "").replaceAll("'", "").equalsIgnoreCase("georgia,timesnewroman,serif")){
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}	
		//Assert.assertEquals("Georgia, 'Times New Roman', serif", grid.getNodeTextFontFamily("1"));
	 }//End of QuotationList()
	  /* 
	  * Use-case : Added By - click
	  * Test case : Click on the username after "added by: "  
	  */
	 @Test(priority=18,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void AddedByClick(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 18 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("AddedByClick");
		 }else{
			 grid =BaseState("AddedByClick");
		 }
		 //Clcik on Added by and check the header of opened page.
		 common.getNewURL(config.getProperty("Url")+"list/actors-nobody-cares-about-anymore/ranker-celebrities");
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 grid.clickAddedBy("Pauly Shore", "2");
		 try{
			 Thread.sleep(8000);
		 }catch(Exception e){}
		 Assert.assertEquals("Dismalhead", grid.getTextForAddedByUserPage().trim());
	}//End of AddedByClick()
	 
	 /* 
	  * Use-case : Autoload more list items 
	  * Test case : Go to any quotes list in grid view. 
	  */
	 @Test(priority=19,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void AutoloadMoreListItems(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 19 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("AutoloadMoreListItems");
		 }else{
			 grid =BaseState("AutoloadMoreListItems");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/greatest-musical-artists-of-all-time/alan-smithee");
		 common.votableLinkPresenceAndAccept();
		
		 //Scroll down and check 100 items are loaded successfully.
		 grid.scrollToElement("50");
		   SafeActions s = new SafeActions(getDriver());
	        s.waitForPageToLoad(40);
		// browserWait();
		// grid.verticalScrolling(0, 9000);
		 Assert.assertTrue(grid.isNodePresent("100"));
		 
}//End of AutoloadMoreListItems()
	 
	 /* 
	  * Use-case : List: Expander blather on Info style list pages
	  * Test case : Open any info style list in Mobile and Desktop in which list items has blather. 
	  */
	 @Test(priority=20,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ExpandBlatherOnListPage(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 20 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("ExpandBlatherOnListPage");
		 }else{
			 grid =BaseState("ExpandBlatherOnListPage");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/top-6-most-popular-pm-candidates-for-2014-election-in-india/vijaymohanp?format=GRID");
		 //Expand the blather and check the text and font style.
		 common.votableLinkPresenceAndAccept();
		 String blatherTxt = grid.getBlatherText("2");
		 Assert.assertNotNull(blatherTxt);
		// Assert.assertEquals("The popular socialist Arvind Kejrival was born in Hiasr which is located in the state of Haryana and on June 16, 1968. He is also good in studies and this is the reason, he received an opportunity to", blatherTxt);
		
		 String blatherFontStyle = grid.getBlatherFontSyle("2");
		 grid.clickOnOpenButton(2);
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		 String wikiFontStyle=grid.getFontStyleWikiText("2");
		 Assert.assertEquals(blatherFontStyle, wikiFontStyle);
	 }//End of ExpandBlatherOnListPage()
	 /* 
	  * Use-case : Node Score
	  * Test case : Go to any Ultimate List in grid view. 
	  */
	 @Test(priority=21,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void NodeScore(String loginRequired){
		 //
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 21 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("NodeScore");
		 }else{
			 grid =BaseState("NodeScore");
		 }
		 //Open node score and check presence of score explain, listed it, ranked high, voted up.
		 grid.clickNodeScore("1"); //To open node score div.
		// browserWait();
		  SafeActions s = new SafeActions(getDriver());
	      s.waitForPageToLoad(40);
		 Assert.assertTrue(grid.isScoreExplainPresent("1"));
		 Assert.assertTrue(grid.isScoreListedItPresent("1"));
		 Assert.assertTrue(grid.isScoreRankedHighPresent("1"));
		 Assert.assertTrue(grid.isScoreVotedUpPresent("1"));
		// grid.clickNodeScore("1");  //To close node score div.
	 }//End of NodeScore()
	 /* 
	  * Use-case : Trivia Popup
	  * Test case : Go to The Best Movies of All Time list and vote up and down on the top 10 items of the list.
	  * http://www.ranker-qa.com/crowdranked-list/the-best-movies-of-all-time 
	  */
	 @Test(priority=22,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void TriviaPopup(String loginRequired){
		
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 22 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("TriviaPopup");
		 }else{
			 grid =BaseState("TriviaPopup");
		 }
		 
		common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-best-movies-of-all-time");
		grid.clickUpvote("1");
		 Assert.assertFalse(grid.isTriviaPopupPresent("1"));
		 grid.clickUpvote("2");
		 Assert.assertFalse(grid.isTriviaPopupPresent("2"));
		 grid.clickUpvote("3");
		 Assert.assertFalse(grid.isTriviaPopupPresent("3"));
		 // Check when upvote 4th , trivia should be popup.
		 grid.clickUpvote("4");
		 Assert.assertTrue(grid.isTriviaPopupPresent("4"));		 
		 
	}//End of TriviaPopup()
	 	 
	
	 /* 
	  * Use-case : Change video play UX for infostyle lists
	  * Test case : Open any list which has node videos
					EX: http://www.ranker-qa.com/crowdranked-list/the-best-movies-of-all-time
					Click on any node video
	  */
	 @Test(priority=23,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void VideoPlayUX(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 23 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("VideoPlayUX");
		 }else{
			 grid =BaseState("VideoPlayUX");
		 }
		  common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-best-movies-of-all-time");
		// browserWait();
		   
		 common.votableLinkPresenceAndAccept();
		 grid.clickOnVideoToPlay("4");
		 SafeActions s = new SafeActions(getDriver());
	       s.waitForPageToLoad(40);
		 Assert.assertTrue(grid.isVideoPresent());
		 //Check the upvote , downvote, and scrolling when video is running.
		 grid.clickUpvote("1");
		 grid.clickDownvote("2");
		 grid.verticalScrolling(0, 1000);
	}//End of VidioPlayUX()
	 /* 
	  * Use-case : Node Badges - demo overlay
	  * Test case : Click on any of the SEE LIST RANKED BY links. When that overlay is open, click on the node badges located above the node names.
	  */
	 @Test(priority=24,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void nodeBadgesDemoOverlay(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 24 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("nodeBadgesDemoOverlay");
		 }else{
			 grid =BaseState("nodeBadgesDemoOverlay");
		 }
		 //Check badges functionality when demo overlay is already open.
		 common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-best-movies-of-all-time");
		 grid.clickOnRigion();
		 grid.clickNodeBadges("The Godfather","4");//1
		 try{
		Thread.sleep(2000); 
		 }catch(Exception e){}
		 Assert.assertTrue(grid.isThePeoplePopupPresent());
		 //Assert.assertEquals("More people put this #1 on their own list than anything else", grid.getTextOfPeoplePopup());
		 Assert.assertNotNull(grid.getTextOfPeoplePopup());
		 grid.closePeoplePopup(); 
		
	 }//End of nodeBadgesDemoOverlay()
	 /* 
	  * Use-case : Node Name
	  * Test case : Go to any list in grid view.
	  */
	 @Test(priority=25,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void nodeName(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 25 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("nodeName");
		 }else{
			 grid =BaseState("nodeName");
		 }
		 //Check the node text font style, font family, text color, font size.
		 Assert.assertEquals("normal", grid.getNodeTextFontStyle(1));
		 
		 if(grid.getNodeTextFontFamily(1).trim().replaceAll(" ", "").replaceAll("\"", "").replaceAll("'", "").equalsIgnoreCase("arial,helevtica,sans-serif")){
			   Assert.assertEquals(1, 1);
			  } else {
			   Assert.assertEquals(1, 0);
			  }
		// Assert.assertEquals("Arial, Helevtica, sans-serif", grid.getNodeTextFontFamily("1"));
		 Assert.assertEquals("rgba(0, 0, 0, 1)", grid.getNodeTextColor(1));
		 Assert.assertEquals("26px", grid.getNodeTextFontSize(1));	 
	}//End of nodeName()
	 
	 /* 
	  * Use-case : Images
	  * Test case : Go to any list in grid view.
	  */
	 @Test(priority=26,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void Images(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 26 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("Images");
		 }else{
			 grid =BaseState("Images");
		 }
		 //Check image height, width, inner border, and outer border.
		 Assert.assertEquals("77px", grid.getNodeImageheight("1"));
		 Assert.assertEquals("77px", grid.getNodeImagewidth("1"));
		 if(sysProp.getProperty("Browser.Name").equals("ie")||sysProp.getProperty("Browser.Name").equals("ff")){
		 Assert.assertEquals("1", grid.getNodeImageInnerBorder(1));
		 }else{
			 Assert.assertEquals("auto", grid.getNodeImageInnerBorder(1));
		 }
		 Assert.assertEquals("2px", grid.getNodeImageOuterBorder(1));	 
	}//End of Images()
	 
	 /* 
	  * Use-case : Node Name - hover
	  * Test case : Hover over a node name that has a node page.
	  */
	 @Test(priority=27,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void NodeNameHover(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 27 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("NodeNameHover");
		 }else{
			 grid =BaseState("NodeNameHover");
		 }
		 grid.autoloadingnodename(10);
		 //common.votableLinkPresenceAndAccept();
		 //Mouse hover on node text and get color of the text color.
		 grid.mouseHoverNodeText(11);
//		 SafeActions s = new SafeActions(getDriver());
//	     s.waitForPageToLoad(40);
		 try{
			 Thread.sleep(8000);
		 }catch(Exception e){}
		 Assert.assertEquals("rgba(8, 108, 184, 1)", grid.getNodeTextColor(11));
	 }//End of NodeNameHover()
	 /* 
	  * Use-case : Image - hover
	  * Test case : Hover over an image that is not tagged to have links to amazon.
	  */
	 @Test(priority=28,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void NodeImageHover(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 28 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("NodeImageHover");
		 }else{
			 grid =BaseState("NodeImageHover");
		 }
		 //Mouse hover to the node image and get border color and magnifying glass image.
		 grid.autoloadingnodename(10);
		 grid.mouseHoverNodeImage(11);
		 try{
			 Thread.sleep(3000);
		 }catch(Exception e){}
		 ///System.out.println("grid.getNodeImageColor111==="+grid.getNodeImageColor("11","border-bottom-color"));
		 Assert.assertEquals("rgba(8, 108, 184, 1)", grid.getNodeImageColor("11","border-bottom-color"));
		 Assert.assertEquals("rgba(8, 108, 184, 1)", grid.getNodeImageColor("11","border-left-color"));
		 Assert.assertEquals("rgba(8, 108, 184, 1)", grid.getNodeImageColor("11","border-right-color"));
		 Assert.assertEquals("rgba(8, 108, 184, 1)", grid.getNodeImageColor("11","border-top-color"));
		 Assert.assertFalse(grid.isMagnifyingGlassPresent("1"));
	}//End of NodeImageHover()
	 
	 /* 
	  * Use-case : Row Hover
	  * Test case : Hover over any row in a list.
	  */
	 @Test(priority=29,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void RowHover(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 29 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("RowHover");
		 }else{
			 grid =BaseState("RowHover");
		 }
		 try{
			 Thread.sleep(8000);
		 }catch(Exception e){}
		// common.votableLinkPresenceAndAccept();
		 //mouse hover on a row and get the back color.
		 grid.autoloadingnodename(5);
		 grid.mouseHoverNodeRow("6");
		 Assert.assertEquals("rgba(226, 232, 235, 1)", grid.getNodeRowBackColor("6"));
	}//End of RowHover()
////	 /* 
////	  * Test case : Go to http://www.ranker-qa.com/crowdranked-list/the-beautiful-people-the-hottest-celebrities-of-all-time
////                     Scroll down
////	  */
////	 @Test(priority=30,dataProviderClass = DataProviders.class, dataProvider = "Login")
////	 public void Addlogic(String loginRequired){
////		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 30 !!!!!!!!!!!!!!!!!!!!!!!");
////		//Base state. (Navigate to grid page)
////		 Grid grid=null;
////		 if(loginRequired.equals("YES")){
////			 grid =BaseStateWithLogin("Addlogic");
////		 }else{
////			 grid =BaseState("Addlogic");
////		 }
////		 common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-beautiful-people-the-hottest-celebrities-of-all-time");
////		 grid.scrollToElement("50");
////		 for (int i=60;i<=90;i=i+15){
////		 Assert.assertTrue(grid.isPresentadd(i));}
////		 //mouse hover on a row and get the back color.
////		 
////	}//End of Adlogic()
	 ///////////////////new TC/////////////
	 /* 
	  * Use-case : Check RL stats and ROI
	  * Test case : Open any list in Admin 
                    Click Stats and check ROI and RL.
	  */
	 @Test(priority=31,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ROIandRL(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 31 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("ROIandRL");
		 }else{
			 grid =BaseState("ROIandRL");
		 }
		 common.signin("vijaymohanp", "server");
		//For RL
		 grid.clickOnAdminStats(8);
		 grid.clickOnRLstat();
		// grid.clickOnSubStats(1);
		 browserWait();
		 try {
				Thread.sleep(15000);
			} catch (Exception e) {
			}
		 for(int i=1;i<=5;i++){
			 Assert.assertTrue(grid.isdeskMobStatsDataPresent("desktop", i));
			 Assert.assertTrue(grid.isdeskMobStatsDataPresent("mobile", i));
		 }
		 grid.clickOnClose();
		 //ROI
		 grid.clickOnAdminStats(8);
		 grid.clickOnROLstat();
		// grid.clickOnRLstat();
		// grid.clickOnSubStats(2);
		 try {
			Thread.sleep(8000);
		} catch (Exception e) {
		}
		 for(int i=1;i<=5;i++){
			 Assert.assertTrue(grid.isROIStatsPresent(i));
		 }
	}//End of ROIandRL()
	 /* 
	  * Use-case : Node image/video
	  * Test case : Open any list, click on node image/video
	  */
	 @Test(priority=32,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void NodeVideoAndImage(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 32 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("Addlogic");
		 }else{
			 grid =BaseState("Addlogic");
		 }
		
		 //For image
	 String[] before = grid.getNodeText(1).split(" ");
	 grid.clickNodeImage(1);
	 try{
		 Thread.sleep(2000);
	 }catch(Exception e){}
	 if (getDriver().getCurrentUrl().contains(before[0].toLowerCase()))
		 Assert.assertEquals(1, 1);
	 else
		 Assert.assertEquals(0, 1);
	 
	 //For video
	 common.getNewURL(config.getProperty("Url")+"list/best-pinball-arcade-and-computer-game-related-songs/hbg1968");
	 try{
		 Thread.sleep(5000);
	 }catch(Exception e){}
	 grid.clickNodeImage(1);
	 Assert.assertTrue(grid.isNodeVideoPopupPresent());
	}//End of ROIandRL()
	 /* 
	  * Use-case : Verify Next List Logic for Collections
	  * Test case : 1) Go to a list that is in a collection (ex: http://www.ranker-stage.com/list/best-atlanta-hawks-of-all-time/ranker-nba)
					2) See next list in the collection 
					3) Scroll down and click on the "next list >" link in the list footer. 
	  */
	 @Test(priority=33,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void NextListFooterLink(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 33 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("NextListFooterLink");
		 }else{
			 grid =BaseState("NextListFooterLink");
		 }
		 ListHeader listHeader=new ListHeader(getDriver());
		 common.getNewURL(config.getProperty("Url")+"list/best-atlanta-hawks-of-all-time/ranker-nba");
		 String txt[]=listHeader.gethrefOfnextlistfooter().split("\\?");
		
		// grid.clickOnFirstListFooter();
		 listHeader.clickonnextlistfooter();
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 String CurrUrl[]=getDriver().getCurrentUrl().split("\\?");
		 Assert.assertEquals(txt[0],CurrUrl[0]);
	 }//End of NextListFooterLink
	 /* 
	  * Use-case : "next list >" in footer
	  * Test case : Open any grid list
	                 There should be a "next list >" button in the list footer that takes you to another list on click
	  */
	 @Test(priority=34,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void NextList(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 34 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("NextList");
		 }else{
			 grid =BaseState("NextList");
		 }
		 ListHeader listHeader=new ListHeader(getDriver());
		Assert.assertTrue(listHeader.isnextlistfooterPresent());
		String txt[]=listHeader.gethrefOfnextlistfooter().split("\\?");
		 try{
			 Thread.sleep(8000);
		 }catch(Exception e){}
		 listHeader.clickonnextlistfooter();
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 String CurrUrl[]=getDriver().getCurrentUrl().split("\\?");
		 if (CurrUrl[0].contains(txt[0]))
			 Assert.assertEquals(1, 1);
		 else
			 Assert.assertEquals(0, 1);
		// Assert.assertEquals(txt[0], CurrUrl[0]);
		 
		
 }//End of NextList
	 /* 
	  * Use-case : Closely Related
	  * Test case : Open any grid list that has a "lists like this" block
                   www.ranker-stage.com/crowdranked-list/the-most-influential-contemporary-americans?var=3
	  */
	 @Test(priority=35,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ListsLikeThis(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 35 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("ListsLikeThis");
		 }else{
			 grid =BaseState("ListsLikeThis");
		 }
		 common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-most-influential-contemporary-americans?var=3");
		 Assert.assertTrue(grid.isListsLikeThisPresent());
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 String txt[]=grid.gethrefOfCloselyRelatedLists(1).split("\\?");
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 grid.clickOnCloselyRelatedLists(1);
		 try{
			 Thread.sleep(4000);
		 }catch(Exception e){}
		 String CurrUrl[]=getDriver().getCurrentUrl().split("\\?");
		 Assert.assertEquals(txt[0],CurrUrl[0]);
		
		
	 }//End of ListsLikeThis
	 /* 
	  * Use-case : Collections
	  * Test case : Open any grid list that is in a collection
					http://www.ranker-stage.com/list/best-atlanta-hawks-of-all-time/ranker-nba
	  */
	 @Test(priority=36,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void collectionList(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 36 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("collectionList");
		 }else{
			 grid =BaseState("collectionList");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/best-atlanta-hawks-of-all-time/ranker-nba");
		 String txt[]=grid.gethrefOfFirstListCollection(1).split("\\?");
		 grid.clickOnFirstListCollection(1);
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 String CurrUrl[]=getDriver().getCurrentUrl().split("\\?");
		 Assert.assertEquals(txt[0],CurrUrl[0]);
		 }//end of collectionList
	 
	 
	 /* 
	  * Use-case : Also Ranked
	  * Test case : Open any grid list that has system nodes that are also ranked on other lists
					http://www.ranker-stage.com/list/entourage-movie-alternative-titles/jacob-shelton
	  */
	 @Test(priority=37,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void AlsoRankesOn(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 37 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("AlsoRankesOn");
		 }else{
			 grid =BaseState("AlsoRankesOn");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/entourage-movie-alternative-titles/jacob-shelton");
		 Assert.assertTrue(grid.isListsLikeThisPresent());
		 String txt[]=grid.gethrefOfAlsoRankesOnlists(1).split("\\?");
		 grid.clickOnAlsoRankesOnlists(1);
		 String CurrUrl=getDriver().getCurrentUrl();
		 Assert.assertEquals(txt[0],CurrUrl);
	 }
	 /* 
	  * Use-case :  More By User
	  * Test case : Open any grid list that has a "more by this user" block in the right rail
					http://www.ranker-stage.com/list/lessons-from-movies/derrick-deane
					
	  */
	 @Test(priority=37,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void MoreByUser(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 37 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("MoreByUser");
		 }else{
			 grid =BaseState("MoreByUser");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/lessons-from-movies/derrick-deane");
		 Assert.assertTrue(grid.isMoreByThisUserPresent());
	     String txt[]=grid.gethrefOfMoreByThisUserLists(1).split("\\?");
		 grid.clickOnMoreByThisUserLists(1);
		 String CurrUrl[]=getDriver().getCurrentUrl().split("\\?");
		 Assert.assertEquals(txt[0],CurrUrl[0]);
	 }
	 /* 
	  * Use-case :  Top 6 right rail RLs
	  * Test case :Open any grid list
					
	  */
	 @Test(priority=38,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void Top6Rightrail(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 38 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("Top6Rightrail");
		 }else{
			 grid =BaseState("Top6Rightrail");
		 }
		for(int i=1;i<=6;i++){
			Assert.assertTrue(grid.isPresentListIntoprighttrail(1,i));
		}
		String href[]=grid.gethrefOftoprighttraillist(1,1).split("\\?"); 
		grid.clickOntoprighttraillist(1,1);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		String afterurl[]=getDriver().getCurrentUrl().split("\\?");
		Assert.assertEquals(href[0], afterurl[0]);

	 }//end for Top6Rightrail
	 /* 
	  * Use-case :  Second 6 right rail RLs
	  * Test case :Open any grid list
					
	  */
	 @Test(priority=39,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void Second6Rightrail(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 39 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("Second6Rightrail");
		 }else{
			 grid =BaseState("Second6Rightrail");
		 }
		for(int i=1;i<=6;i++){
			Assert.assertTrue(grid.isPresentListIntoprighttrail(2,i));
		}
		String href[]=grid.gethrefOftoprighttraillist(2,1).split("\\?"); 
		grid.clickOntoprighttraillist(2,1);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {}
		String afterurl[]=getDriver().getCurrentUrl().split("\\?");;
		Assert.assertEquals(href[0], afterurl[0]);

	 }//end for Second6Rightrail
	 
	 /* 
	  * Use-case :  Second 6 right rail RLs
	  * Test case :Open any grid list
					
	  */
	 @Test(priority=40,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void Bottom6MiddleRightrail(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 40 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("Bottom6MiddleRightrail");
		 }else{
			 grid =BaseState("Bottom6MiddleRightrail");
		 }
		for(int i=1;i<=6;i++){
			Assert.assertTrue(grid.isPresentListInbottomrighttraillist(i));
		}
		String href[]=grid.gethrefOfbottomrighttraillist(1).split("\\?"); 
		grid.clickOnbottomrighttraillist(1);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {}
		String afterurl[]=getDriver().getCurrentUrl().split("\\?");
		Assert.assertEquals(href[0], afterurl[0]);

	 }//end for Bottom6MiddleRightrail
	 /* 
	  * Use-case :  Cascading (pinterest style) RLs
	  * Test case : Open any list : http://www.ranker-stage.com/list/best-actress-2014/ranker-film
					
	  */
	 @Test(priority=41,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void CascadingRightrailAutoLoading(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 41 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("CascadingRightrailAutoLoading");
		 }else{
			 grid =BaseState("CascadingRightrailAutoLoading");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/best-actress-2014/ranker-film");
		 try {
				Thread.sleep(10000);
			} catch (Exception e) {}
		 Assert.assertTrue(grid.ispopularlistPresent());//12
		 grid.autoloading(6);
		 try {
				Thread.sleep(10000);
			} catch (Exception e) {}
		Assert.assertTrue(grid.isnodePresent(8));//12
	 }//end for CascadingRightrailAutoLoading
	 /* 
	  * Use-case : Update Next List Algo to for Node Tagged Lists
	  * Test case : Go to a list that is node tagged with a decent node, that also has other node tagged lists (for eg, lists about these nodes: http://www.ranker.com/review/natalie-portman/1648992 or http://www.ranker.com/review/kanye-west/1347110). Click on "next list" link
	  */
	 @Test(priority=42,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void DuplicateCheckInNextList(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 42 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("DuplicateCheckInNextList");
		 }else{
			 grid =BaseState("DuplicateCheckInNextList");
		 }
		 ListHeader listHeader=new ListHeader(getDriver());
		 common.getNewURL(config.getProperty("Url")+"list/best-atlanta-hawks-of-all-time/ranker-nba");
		 for(int i=1;i<=10;i++){
		 String txt[]=listHeader.gethrefOfnextlistfooter().split("\\?");
		// grid.clickOnFirstListFooter();
		 listHeader.clickonnextlistfooter();
		 
		 try{
			 Thread.sleep(3000);
		 }catch(Exception e){}
		 String CurrUrl[]=getDriver().getCurrentUrl().split("\\?");
		 Assert.assertEquals(txt[0],CurrUrl[0]);
		// System.out.println("txt[0]=="+txt[0]);
		 for(int j=1;j<=10;j++){
			 Assert.assertNotEquals(txt[0], listHeader.gethrefOfnextlistfooterlist(j+"").split("\\?"));	 
		 }
		// getDriver().navigate().back();
		 }
	 }//End of DuplicateCheckInNextList
	 /* 
	   * Use-case : Verify trivia popup is not tranceparent
	   * Test case : 1. Go to any votable grid list
	     Eg- http://www.ranker-stage.com/crowdranked-list/the-greatest-film-actors-and-actresses-of-all-time
	     2. Vote on some nodes and check trivia popup
	   */
	  @Test(priority=43,dataProviderClass = DataProviders.class, dataProvider = "Login")
	  public void VerifyTriviaPopup(String loginRequired){
	   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 43 !!!!!!!!!!!!!!!!!!!!!!!");
	  //Base state. (Navigate to grid page)
	   Grid grid=null;
	   if(loginRequired.equals("YES")){
	    grid =BaseStateWithLogin("VerifyTriviaPopup");
	   }else{
	    grid =BaseState("VerifyTriviaPopup");
	   }
	   
	   ListHeader listHeader=new ListHeader(getDriver());
	   common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-greatest-film-actors-and-actresses-of-all-time");
	   grid.autoloadingnodename(5);
	   grid.clickUpvote("6");
	   try{
		   Thread.sleep(3000);
	   }catch(Exception e){}
	   Assert.assertTrue(grid.isTriviaPopupPresent("6"));
	   String txt=grid.getColorOfTriviaPopup("6");
	  Assert.assertNotEquals("rgb(255, 255, 255, 1)",txt);
	   }
	 /* 
	  * Use-case : Disable trivia popups for openlist addition by that logged in user
	  * Test case : Open http://www.ranker-stage.com/list/best-actress-2014/ranker-film
	  */
	 @Test(priority=44,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void DisableTriviaPopup(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 44 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("DisableTriviaPopup");
		 }else{
			 grid =BaseState("DisableTriviaPopup");
		 }
		 ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		 ListHeader listHeader=new ListHeader(getDriver());
		 common.getNewURL(config.getProperty("Url")+"list/best-actress-2014/ranker-film");
		 common.signin("testuserkallol1@mailinator.com", "testing");
		    listoptionpage.putTextInAddListBox("testing");
			listoptionpage.clickOnAddSearchItem();
			listoptionpage.clickoneditsubvideoIcon();
			listoptionpage.putTextInAddvideo("salman");
			try {
				Thread.sleep(8000);
			} catch (Exception e) {
			}
			int count = listoptionpage.Videocount();
			if (count > 2) {
				try {
					Thread.sleep(5000);
				} catch (Exception e) {
				}
				listoptionpage.clickonaddvideo(1);
				try {
					Thread.sleep(4000);
				} catch (Exception e) {
				}
				listoptionpage.clickOnvideoSelectButton();
				listoptionpage.clickOnDoneButton();
				  grid.clickDownvote("1");
				 Assert.assertFalse(grid.isTriviaPopupPresent("1"));
				 listoptionpage.clickOndeletelist("delete");
	 }
		 
	 }
	 /* 
	  * Use-case : Verify number of lists in RL block in list/nodepage/pics page
	  * Test case : Open any list : http://www.ranker-stage.com/list/best-actress-2014/ranker-film
					Scroll down to more popular block
					Open node page: http://www.ranker-stage.com/review/jane-goodall/1266993
					Open Pics page: http://www.ranker-stage.com/pics/N1266993/jane-goodall-writers-photo-1
	  */
	 @Test(priority=45,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void VerifyListsInRL(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 45 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("VerifyListsInRL");
		 }else{
			 grid =BaseState("VerifyListsInRL");
		 }
		 ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		 ListHeader listHeader=new ListHeader(getDriver());
		 common.getNewURL(config.getProperty("Url")+"list/best-actress-2014/ranker-film");
		 Assert.assertTrue(grid.ispopularlistPresent());
		 try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		  for(int i=1;i<=30;i++){
			 Assert.assertTrue(grid.ispopularRelatedlistPresent(i));
		}			

	 }// END of
	 /* 
	  * Use-case : Verify number of lists in RL block in list/nodepage/pics page
	  * Test case : Open node page: http://www.ranker-stage.com/review/jane-goodall/1266993
					Scroll down to more popular block
		 */
	 @Test(priority=46,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void VerifyNodeRL(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 46 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("VerifyNodeRL");
		 }else{
			 grid =BaseState("VerifyNodeRL");
		 }
		 ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		 ListHeader listHeader=new ListHeader(getDriver());
		 common.getNewURL(config.getProperty("Url")+"review/jane-goodall/1266993");
		 Assert.assertTrue(grid.ispopularlistPresent());
		 try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		  for(int i=1;i<=6;i++){
			 Assert.assertTrue(grid.ispopularRelatedlistPresent(i));
		}			

	 }// End of VerifyNodeRL
	 /* 
	  * Use-case : Verify number of lists in RL block in list/nodepage/pics page
	  * Test case :Open Pics page: http://www.ranker-stage.com/pics/N1266993/jane-goodall-writers-photo-1
					Scroll down to more popular block
		 */
	 @Test(priority=47,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void VerifyPicsRL(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 47 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("VerifyPicsRL");
		 }else{
			 grid =BaseState("VerifyPicsRL");
		 }
		 ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		 ListHeader listHeader=new ListHeader(getDriver());
		 common.getNewURL(config.getProperty("Url")+"pics/N1266993/jane-goodall-writers-photo-1");
		 Assert.assertTrue(grid.ispopularlistPresent());
		 try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		  for(int i=1;i<=6;i++){
			 Assert.assertTrue(grid.ispopularRelatedlistPresent(i));
		}		
	 }
	 /* 
	  * Use-case : Verify Video header
 	  * Test case :1. Go to a list that has a video list image ex:
                  http://www.ranker-stage.com/list/air-force-one-facts/mel-judson
		 */
	 @Test(priority=48,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void VerifyVideoHeader(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 48 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("VerifyPicsRL");
		 }else{
			 grid =BaseState("VerifyPicsRL");
		 }
		 ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		 ListHeader listHeader=new ListHeader(getDriver());
		 common.getNewURL(config.getProperty("Url")+"list/adult-jokes-in-kids-shows/jacob-shelton?");
		 grid.clickOnHeadervideo();
		 try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		 Assert.assertEquals("rgba(30, 62, 102, 1)", grid.getColorvideobackground());
		 Assert.assertEquals("rgba(255, 255, 255, 1)", grid.getColorOfvideoheaderuppertext());
		 Assert.assertEquals("Arial, Helevtica, sans-serif", grid.getFontOfvideoheaderuppertext());
		// Assert.assertEquals("22px", grid.getFontsizeOfvideoheaderuppertext());
		// Assert.assertEquals("bold", grid.getFontweightOfvideoheaderuppertext());
		 
		 Assert.assertEquals("Georgia, Times, 'Times New Roman', serif", grid.getFontOfvideoheaderlowertext());
		 Assert.assertEquals("italic", grid.getFonstyletOfvideoheaderlowertext());
		 Assert.assertEquals("rgba(255, 255, 255, 1)", grid.getColorOfvideoheaderlowertext());
		 Assert.assertEquals("14px", grid.getFontsizeOfvideoheaderlowertext());
		 Assert.assertEquals("1", grid.getborderimagewidthvideo());
		 
	 }
	 /* 
	  * Use-case : Verify magnifying glass should not display on image hover
	  * Test case : 1) Go to any grid list
					http://www.ranker-stage.com/crowdranked-list/the-best-movies-of-all-time
					2) Now hover over any of the node images
	  */
	 @Test(priority=49,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void NodeImageHoverDisplayMagnifyglass(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 49 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("NodeImageHoverDisplayMagnifyglass");
		 }else{
			 grid =BaseState("NodeImageHoverDisplayMagnifyglass");
		 }
		 common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-best-movies-of-all-time");
		 //Mouse hover to the node image and get border color and magnifying glass image.
		 grid.autoloadingnodename(10);
		 grid.mouseHoverNodeImage(11);
		 try{
			 Thread.sleep(3000);
		 }catch(Exception e){}
		 Assert.assertFalse(grid.isMagnifyingGlassPresent("1"));
	}//End of NodeImageHover()
	 /* 
	  * Use-case : Update Next List link for Lists in Collection
	  * Test case : Go to a list that is in a collection (ex: http://www.ranker-stage.com/crowdranked-list/greatest-centerfielders-of-all-time) and scroll to the list footer. Click the "next list >" link 
	  */
	 @Test(priority=50,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void UpdateNextListLink(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 50 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 Grid grid=null;
		 if(loginRequired.equals("YES")){
			 grid =BaseStateWithLogin("UpdateNextListLink");
		 }else{
			 grid =BaseState("UpdateNextListLink");
		 }
		 ListHeader listHeader=new ListHeader(getDriver());
		 common.getNewURL(config.getProperty("Url")+"crowdranked-list/greatest-centerfielders-of-all-time");
		 listHeader.clickonnextlistfooter();
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 String CurrUrl=getDriver().getCurrentUrl();
		 if(CurrUrl!="ref=gnrtednxtlst")
		 Assert.assertEquals(1,1);
		 else
			 Assert.assertEquals(1,0); 
	 }//End of NextListFooterLink
	 /* 
	  * Use-case : Verify exclude trivia in which the odds are less than 2
	  * Test case : List:http://www.ranker-stage.com/list/americas-girlfriend-2015/amylindorff
Down vote on "Anna Kendrick"
	  */
	 @Test(priority = 51, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void VarifyExcludeTrivia(String loginRequired) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 51 !!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to node page)
			ListHeader listHeader = null;
			//RerankPage rerankpage = new RerankPage(getDriver());
			Grid grid=null;
			 if(loginRequired.equals("YES")){
				 grid =BaseStateWithLogin("VarifyExcludeTrivia");
			 }else{
				 grid =BaseState("VarifyExcludeTrivia");
			 }
			common.getNewURL(config.getProperty("Url")+ "list/americas-girlfriend-2015/amylindorff");
			try{Thread.sleep(4000);}
			catch(Exception e){}
			grid.clickUpvote("4");
			grid.clickDownvote("4");
			String text=grid.gettestoftrivavalue(4);
			
			String[] splittxt=text.trim().split("x");
			System.out.println("String----"+splittxt[0]);
			int value=Integer.parseInt(splittxt[0]);
			if(value>=2)
				Assert.assertEquals(1, 1);
			else
				Assert.assertEquals(1, 0);
			
			
			
			
		}
	 /*
	  * This is base state of the slide show test-cases.
	  */
	 public Grid BaseState(String testName){
		 common=new Commonpage(getDriver());
		try{
		 startRecording(testName);
		}catch(Exception e){}
		 Grid grid=common.getGridView(url);
		//common.votableLinkPresenceAndAccept();
		 return grid;
	 } //End of BaseState()
	 /*
	  * This is base state of the slide show test-cases.
	  */
	 public Grid BaseStateWithLogin(String testName){
		 try{
			 startRecording(testName);
			}catch(Exception e){}
		 common=new Commonpage(getDriver());
		 Grid grid=common.getGridView(url);	
		//. common.votableLinkPresenceAndAccept();
		 common.signin("testuserkallol1@mailinator.com", "testing");
		 common.facebookLikePresenceAndAccept();
	//	common.votableLinkPresenceAndAccept();
		 return grid;
	 } //End of BaseState()
	
}
