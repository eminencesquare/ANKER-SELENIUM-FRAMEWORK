package com.testsuite.WidgetTests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.pageobject.login.SigninPage;
import com.pageobjects.grid.Grid;
import com.pageobjects.leaderboard.LeaderBoardPage;
import com.pageobjects.listheader.ListHeader;
import com.pageobjects.listoption.ListOptionPage;
import com.pageobjects.widgetPage.WidgetPage;

public class WidgetTests extends BaseSetup{
	ConfigManager urls=new ConfigManager("PreProduction");
	ConfigManager sysProp=new ConfigManager("Sys");
	Commonpage common;
    String url=config.getProperty("Url")+urls.getProperty("VoteList");
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
	  * Use-case : Link at bottom of widget pointing to Listopedia page
	  * Test case : Make sure Embed list which has a category should have a link to that category at bottom of widget.
                    1- IF list is UL OR Admin owned iList/Rerank original then links to list itself 
	  */
	 @Test(priority=1,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void widgetOriginalList(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("widgetOriginalList");
		 }else{
			 widgetpage =BaseState("widgetOriginalList");
		 }
		 common.getNewURL(config.getProperty("Url")+"crowdranked-list/top-10-current-nba-players?format=GRID&action=tab&type=embed");
		 String href = widgetpage.getHrefOfWidgetfooter();
		 String subhref[]=href.split("\\?");
		 widgetpage.clickOnWidgetFooter();
		 try{
			 Thread.sleep(4000);
		 }catch(Exception e){}
		 ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
		 getDriver().switchTo().window(tabs2.get(1));
		 String url=getDriver().getCurrentUrl();
		 String substring[] =url.split("\\?");
		 Assert.assertEquals(subhref[0], substring[0]);
		 getDriver().close();
		 getDriver().switchTo().window(tabs2.get(0));
	 }//End of widgetOriginalList
	 /* 
	  * Use-case : Link at bottom of widget pointing to Listopedia page
	  * Test case : MIf the list is a Rerank/Contributing list AND the Top Parent List is a UL OR Admin Owned List then link to THAT list
	  */
	 @Test(priority=2,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void widgetOriginalListRerank(String loginRequired){
		 String href="",suburl="";
		 String substring[]=new String[0];
		 String subhref[]=new String[0];
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("widgetOriginalListRerank");
		 }else{
			 widgetpage =BaseState("widgetOriginalListRerank");
		 }
//		 if(url.contains("stage"))
//		 {
//		     common.getNewURL(config.getProperty("Url")+"list/the-best-football-movies-ever/testvikas2?format=GRID&action=tab&type=embed");
//		 }
//		 else{
		 common.getNewURL(config.getProperty("Url")+"crowdranked-list/top-10-current-nba-players?format=GRID&action=tab&type=embed");
			// common.getNewURL(config.getProperty("Url")+"list/the-scariest-threats-to-the-united-states/testvikas2?format=GRID&action=tab&type=embed");
		// } 
		  href = widgetpage.getHrefOfWidgetfooter();
		  subhref=href.split("\\?");
		 widgetpage.clickOnWidgetFooter();
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
		 getDriver().switchTo().window(tabs2.get(1));
		 suburl=getDriver().getCurrentUrl();
		 substring =suburl.split("\\?"); 
		 getDriver().close();
		    getDriver().switchTo().window(tabs2.get(0));
	 }//End of widgetOriginalListRerank
      /* 
	  * Use-case : Link at bottom of widget pointing to Listopedia page
	  * Test case :  If the list fails both conditions above then link to the category page of list with the text "<Category> Lists on Ranker" (Or "Lists on Ranker" )
	  */
	 @Test(priority=3,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void widgetCategoryList(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("widgetCategoryList");
		 }else{
			 widgetpage =BaseState("widgetCategoryList");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/best-memphis-grizzlies-of-all-time/grizzly-bear-blues?format=GRID&action=tab&type=embed");
		 String href = widgetpage.getHrefOfWidgetfooter();
		 widgetpage.clickOnWidgetFooter();
		 try{
			 Thread.sleep(4000);
		 }catch(Exception e){}
		 ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
		 getDriver().switchTo().window(tabs2.get(1));
		 String url=getDriver().getCurrentUrl();
		 Assert.assertEquals(href, url);
		 getDriver().close();
		 getDriver().switchTo().window(tabs2.get(0));
	 }//End of widgetCategoryList
    /* 
	  * Use-case : Link at bottom of widget pointing to Listopedia page
	  * Test case :  -For anything lists widget, if odd-numbered list ID use this anchor text
             "Ranker - Top 10 Lists and More", and link to our homepage
	  */
	 @Test(priority=4,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void widgetHomepage(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("widgetHomepage");
		 }else{
			 widgetpage =BaseState("widgetHomepage");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/bi-racial-hair-styles-advice-for-mamas-of-bi-racial-babies/mandyg?format=GRID&action=tab&type=embed");
		 String href = widgetpage.getHrefOfWidgetfooter();
		 widgetpage.clickOnWidgetFooter();
		 try{
			 Thread.sleep(4000);
		 }catch(Exception e){}
		 ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
		 getDriver().switchTo().window(tabs2.get(1));
		 String url=getDriver().getCurrentUrl();
		 Assert.assertEquals(href, url);
		 getDriver().close();
		 getDriver().switchTo().window(tabs2.get(0));
	 }//End of widgetHomepage
	 
	 /* 
	  * Use-case : Widget tab(Embed).
	  * Test case : 1) Open any list.
                    2) Click on 'Embed' tab appear in list strip.
	  */
	 @Test(priority=5,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void EmbedTab(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("EmbedTab");
		 }else{
			 widgetpage =BaseState("EmbedTab");
		 }
		 widgetpage.clickOnEmbedTab();
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
	 String afterUrl=getDriver().getCurrentUrl();
	 if(url.contains("stage"))
         Assert.assertEquals("http://www.ranker-stage.com/widget/1354428", afterUrl);
    else
      Assert.assertEquals("http://www.ranker.com/widget/1354428", afterUrl);
	 }//End of EmbedTab()
//	 
	 /* 
	  * Use-case :  Widget tab: Check 'Reset votes to 0' as Guest user.
	  * Test case : 1) Open any voteranked list as Guest user
                    2) Click on 'Embed' tab appear in list strip
                    3) In the widget pickup page opened, select radio button for 'Reset votes to zero'
	  */
	 @Test(priority=6,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ResetVotesGuest(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("ResetVotesGuest");
		 }else{
			 widgetpage =BaseState("ResetVotesGuest");
		 }
		 widgetpage.clickOnEmbedTab();
		 browserWait();
		 widgetpage.clickOnResetVotes();
		 try{
	    	 Thread.sleep(6000);
	     }catch(Exception e){}
		 Assert.assertTrue(widgetpage.isSignUpPopUpPresent()); 
		 SigninPage signInPage = new SigninPage(getDriver());
		 signInPage.enterCredentels("testuserkallol1@mailinator.com","testing");
	     widgetpage.clickSubmit();
	     try{
	    	 Thread.sleep(11000);
	     }catch(Exception e){}
		// common.getWidgetPage(config.getProperty("Url")+"widget/1918118");
		 Assert.assertEquals((widgetpage.getTextOfUpVote(1)), "0");
		 Assert.assertEquals((widgetpage.getTextOfDownVote(1)), "0");
		 }//End of ResetVotesGuest()
	 /* 
	  * Use-case :  Widget tab: Check 'Reset votes to 0' as Logged user.
	  * Test case : 1) Open any voteranked list as Logged user.
                    2) Click on 'Embed' tab appear in list strip.
                    3) In the widget pickup page opened, select radio button for 'Reset votes to zero'.
	  */
	 @Test(priority=7,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ResetVotesLogged(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("ResetVotesLogged");
		 }else{
			 widgetpage =BaseState("ResetVotesLogged");
		 }
		 common.signin("testuserkallol1@mailinator.com", "testing");
		 common.facebookLikePresenceAndAccept();
		 widgetpage.clickOnEmbedTab();
		 browserWait();
		 widgetpage.clickOnExistingVotes();
		 try {
			Thread.sleep(8000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 widgetpage.clickOnResetVotes();
		 browserWait();
		 
		 Assert.assertEquals((widgetpage.getTextOfUpVote(1)), "0");
		 Assert.assertEquals((widgetpage.getTextOfDownVote(1)), "0");
		 }//End of ResetVotesLogged()
	 /* 
	  * Use-case :  Widget tab: Check Edit this widget
	  * Test case : 1) Open any list
                    2) Click on 'embed' tab appear in list strip
                    3) Click on 'List' appear in settings in left side rail
                    4) Click ' Edit this widget' in the area expanded
	  */
	 @Test(priority=8,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void EditWidget(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("EditWidget");
		 }else{
			 widgetpage =BaseState("EditWidget");
		 }
		 common.signin("testuserkallol1@mailinator.com", "testing");
		 common.facebookLikePresenceAndAccept();
		 widgetpage.clickOnEmbedTab();
		 browserWait();
		 widgetpage.clickOnWidgetList(1);
		 widgetpage.clickOnEditWidget(6);
		 Assert.assertTrue(widgetpage.isEditListPopUpPresent());
		 }//End of EditWidget()
     /* 
	  *  Use-case : Widget tab: Check settings
	  *  Test case :1) Open any list
					2) Click on 'Embed' tab appear in list strip"
					3) Play with the embed settings(header)
	  */
	 @Test(priority=9,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void widgetListsettingHeader(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 9 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("widgetListsettingHeader");
		 }else{
			 widgetpage =BaseState("widgetListsettingHeader");
		 }
		 widgetpage.clickOnEmbedTab(); 
		 try{
			 Thread.sleep(8000);
		 }catch(Exception e){}
		 ////background color change
		 widgetpage.clickWidgetHeaderbakground();
		 try{
			 Thread.sleep(4000);
		 }catch(Exception e){}
		 widgetpage.clickoncolorchange(1);
		 try{
			 Thread.sleep(4000);
		 }catch(Exception e){}
		 widgetpage.colorchange("13px","38.5px");
		 try{
			 Thread.sleep(7000);
		 }catch(Exception e){}
		 Assert.assertEquals("rgba(224, 159, 159, 1)",widgetpage.getheaderColor());
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 ////title color change
		 widgetpage.clickWidgetHeaderbakground();
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 widgetpage.clickWidgetHeaderbakground();
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 widgetpage.clickoncolorchange(2);
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 widgetpage.colorchange("121px","125.5px");
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 Assert.assertEquals("rgba(224, 159, 159, 1)",widgetpage.getheaderColor());
		 /// title font change
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 widgetpage.clickWidgetHeaderbakground();
		 try{ 
			 Thread.sleep(10000);
		 }catch(Exception e){}
		 widgetpage.clickonstylechange();
		 try{
			 Thread.sleep(10000);
		 }catch(Exception e){}
		 widgetpage.clickonstylechangepopup();
		 try{
			 Thread.sleep(15000);
		 }catch(Exception e){}
		 Assert.assertEquals("Verdana, Geneva, sans-serif",widgetpage.getFontFamilyTitle());
	 }//End of widgetListsettingHeader
	 /* 
	   *  Use-case : Widget tab: Check settings
	   *  Test case :1) Open any list
	     2) Click on 'Embed' tab appear in list strip"
	     3) Play with the embed settings(list)
	   */
	  @Test(priority=10,dataProviderClass = DataProviders.class, dataProvider = "Login")
	  public void widgetListsetting(String loginRequired){
	   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 10 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	   WidgetPage widgetpage=null;
	   if(loginRequired.equals("YES")){
	    widgetpage =BaseStateWithLogin("widgetListsetting");
	   }else{
	    widgetpage =BaseState("widgetListsetting");
	   }
	   widgetpage.clickOnEmbedTab(); 
	   try{
	    Thread.sleep(8000);
	   }catch(Exception e){}
	   ////background color change
	   widgetpage.clickOnList();
	   try{
	    Thread.sleep(4000);
	   }catch(Exception e){}
	   widgetpage.clickoncolorchangeList();
	   try{
		    Thread.sleep(2000);
		   }catch(Exception e){}
		   widgetpage.colorchange("13px","38.5px");
		   try{
		    Thread.sleep(8000);
		   }catch(Exception e){}
		   Assert.assertEquals("rgba(255, 255, 255, 1)",widgetpage.getheaderColor());
		//   /// List font change
		   try{
		    Thread.sleep(4000);
		   }catch(Exception e){}
		    widgetpage.clickonstylechangeList();
		    System.out.println("66666");
		    widgetpage.clickonstylechangepopupList();
		   try{
		    Thread.sleep(16000);
		   }catch(Exception e){}
		    Assert.assertEquals("Verdana, Geneva, sans-serif",widgetpage.getFontFamilyList());
		   }//End of widgetListsetting
	 /* 
	  *  Use-case : Widget tab: Check settings
	  *  Test case :1) Open any list
					2) Click on 'Embed' tab appear in list strip"
					3) Play with the embed settings(header List detail)
	  */
	 @Test(priority=11,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void widgetHeaderListDetail(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 11 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("widgetHeaderListDetail");
		 }else{
			 widgetpage =BaseState("widgetHeaderListDetail");
		 }
		 widgetpage.clickOnEmbedTab(); 
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 widgetpage.clickWidgetHeaderbakground();
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 ///show list name uncheck box
		 widgetpage.clickOnListname(false);
		 try{
			 Thread.sleep(3000);
		 }catch(Exception e){}
		 
		 Assert.assertFalse(widgetpage.isPresentHeadername());
		 ///show list name check box
		 widgetpage.clickOnListname(true);
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 Assert.assertTrue(widgetpage.isPresentHeadername());
		 try{
			 Thread.sleep(4000);
		 }catch(Exception e){}
		 ////show list image
		 widgetpage.clickOnlistimage(true);
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 Assert.assertTrue(widgetpage.isPresentlistimagecheck());
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 // show user name
		 widgetpage.clickOnlistusername(true);
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 Assert.assertTrue(widgetpage.isPresentlistusernamecheck());
	 }//End of widgetHeaderListDetail
	 /* 
	   *  Use-case : Widget tab: Check settings
	   *  Test case :1) Open any list
	     2) Click on 'Embed' tab appear in list strip"
	     3) Play with the embed settings(footer)
	   */
	  @Test(priority=12,dataProviderClass = DataProviders.class, dataProvider = "Login")
	  public void widgetFooterListDetail(String loginRequired){
	   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12 !!!!!!!!!!!!!!!!!!!!!!!");
	   //Base state. (Navigate to node page)
	   WidgetPage widgetpage=null;
	   if(loginRequired.equals("YES")){
	    widgetpage =BaseStateWithLogin("widgetFooterListDetail");
	   }else{
	    widgetpage =BaseState("widgetFooterListDetail");
	   }
	   widgetpage.clickOnEmbedTab(); 
	   try{
	    Thread.sleep(7000);
	   }catch(Exception e){}
	   widgetpage.clickonfootercolor();
	//   try{
//	    Thread.sleep(8000);
	//   }catch(Exception e){}
	   widgetpage.clickonfooterBckgrdcolorchange();
	   widgetpage.colorchange("9px","135px");
	   try{
	    Thread.sleep(10000);
	   }catch(Exception e){}
	   
	   Assert.assertEquals("rgba(232, 16, 16, 1)",widgetpage.getfooterBckgrdColorchange());
	   try{
	    Thread.sleep(5000);
	   }catch(Exception e){}
	   widgetpage.clickonfooterTextcolorchange();
	  
	   try{
	    Thread.sleep(5000);
	   }catch(Exception e){}
	   widgetpage.colorchange("10px","133px");
	   try{
	    Thread.sleep(10000);
	   }catch(Exception e){}
	   Assert.assertEquals("rgba(230, 18, 18, 1)",widgetpage.getfooterTextColorchange());
	  } // End of widgetFooterListDetail()
	 /* 
	  *  Use-case : Widget tab: Check settings
	  *  Test case :1) Open any list
					2) Click on 'Embed' tab appear in list strip"
					3) Play with the embed settings(header)
	  */
	 @Test(priority=13,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void widgetHeightListDetail(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 13 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("widgetHeightListDetail");
		 }else{
			 widgetpage =BaseState("widgetHeightListDetail");
		 }
		 widgetpage.clickOnEmbedTab(); 
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 widgetpage.clickonHeight();
		 try{
			 Thread.sleep(8000);
		 }catch(Exception e){}
		 widgetpage.clickOnheightcheckbox(false);
		 try{
			 Thread.sleep(3000);
		 }catch(Exception e){}
		 
		 widgetpage.typeheightinput(5);
		 try{
			 Thread.sleep(8000);
		 }catch(Exception e){}
		 Assert.assertEquals("5",widgetpage.getheightOfList());
		 
	 } //End of widgetHeightListDetail()
	 /* 
	  *  Use-case : Embed in List Footer.
	  *  Test case : Go to the link www.ranker.com/list/worst-athletes-2014/ranker-sports.
	                 Click On Embed in list footer.On the page opened, On clicking on next and previous button the images appearing should be different.
	  */
	 @Test(priority=14,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void EmbedFooter(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 14 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("EmbedFooter");
		 }else{
			 widgetpage =BaseState("EmbedFooter");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
		 widgetpage.clickOnEmbedFooter();
		 try{
			 Thread.sleep(15000);
		 }catch(Exception e){}
		 String src1=widgetpage.getSrcOfImage1();
		 try{
			 Thread.sleep(3000);
		 }catch(Exception e){}
		 widgetpage.clickOnNextButtonOnImage();
		 try{
			 Thread.sleep(15000);
		 }catch(Exception e){}
		 String src2=widgetpage.getSrcOfImage2();
		 Assert.assertNotEquals(src1, src2);
		 widgetpage.clickOnPrevButtonOnImage();
		 try{
			 Thread.sleep(3000);
		 }catch(Exception e){}
		 Assert.assertNotEquals(src1, src2);
	 }
	 /* 
	  *  Use-case : Slide-Show : Open any Slideshow version widget.
	  *  Test case : 1) Open any default slide show list
					 2) Click on 'embed this list' under 'more options'
	  */
	 @Test(priority=15,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void SlideEmbedFooter(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 15 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("SlideEmbedFooter");
		 }else{
			 widgetpage =BaseState("SlideEmbedFooter");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
		 widgetpage.clickOnSlideFooterEmbed();
		 try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 String txt=widgetpage.getAttributeOfWidgetPageAfterEmbedClick();
		 if(txt.contains("slideshowPreview")){
			 Assert.assertEquals(1, 1);
		 }
		 else
			 Assert.assertEquals(1, 0);
	 }//End of SlideEmbedFooter()
	 /* 
	  *  Use-case : Slide-Show : Last slide RLs.
	  *  Test case : Go to any slideshow list and go the embed tab. 
	                 Paginate through the slideshow until you're on the last slide with the Related Lists.
	  */
	 @Test(priority=16,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void LastSlide(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 16 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("LastSlide");
		 }else{
			 widgetpage =BaseState("LastSlide");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
		 String[] first=(widgetpage.getImageNumOnWidgetSlideShow().split("of "));
		 int num=Integer.parseInt(first[1]);
		 widgetpage.clickOnSlideFooterEmbed();
		 for(int i=1;i<=num+2;i++){
			 try{
				 Thread.sleep(8000);
			 }catch(Exception e){}
		    if(widgetpage.isNextButtonOnWidgetSlideShowPresent())
			 widgetpage.clickOnNextButtonOnImage();
		    	//widgetpage.clickOnNextButtonOnWidgetSlideShow();
		 }
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 Assert.assertEquals(widgetpage.getSizeOfLastSlideOnWidgetSlideShow(), 4);
		 Assert.assertFalse(widgetpage.isVoteOnWidgetSlideShow());
		 Assert.assertTrue(widgetpage.isSlidingImageUpTextPresent("text"));
	 }// End of LastSlide()
	 /* 
	  *  Use-case : Slide-Show : Check pagination arrows.
	  *  Test case : 1) Open any slideshow version widget pickup page.
					 2) Click on 'Arrows' appear beside list images.
	  */
	 @Test(priority=17,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PaginationArrows(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 17 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("PaginationArrows");
		 }else{
			 widgetpage =BaseState("PaginationArrows");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
		 widgetpage.clickOnSlideFooterEmbed();
		 
		 int num1=Integer.parseInt(widgetpage.getTextOfSlidingImage1UpNumber("number"));
		 widgetpage.clickOnNextButtonOnImage();
//		 try{
//			 Thread.sleep(15000);
//		 }catch(Exception e){}
		 int num2=Integer.parseInt(widgetpage.getTextOfSlidingImage2UpNumber("number"));
		 Assert.assertNotEquals(num1, num2);
	 }// End of PaginationArrows()
     /* 
	  *  Use-case : Slide Show: Toggle with settings
	  *  Test case :1) Open any slideshow version widget
                    2) Toggle with settings under 'header'.
                    3) Click on done get code
	  */
	 @Test(priority=18,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void SlideSettingHeader(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 18 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("SlideSettingHeader");
		 }else{
			 widgetpage =BaseState("SlideSettingHeader");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
		 widgetpage.clickOnSlideFooterEmbed();
		 try{
			 Thread.sleep(8000);
		 }catch(Exception e){}
		 //background color change
		 widgetpage.clickWidgetHeaderbakground();
		 try{
			 Thread.sleep(4000);
		 }catch(Exception e){}
		 widgetpage.clickoncolorchange(1);
		 try{
			 Thread.sleep(4000);
		 }catch(Exception e){}
		 widgetpage.colorchange("13px","38.5px");
		 try{
			 Thread.sleep(7000);
		 }catch(Exception e){}
		 Assert.assertEquals("rgba(224, 159, 159, 1)",widgetpage.getheaderColor());
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 //title color change
		 widgetpage.clickWidgetHeaderbakground();
		 
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 widgetpage.clickWidgetHeaderbakground();
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 widgetpage.clickoncolorchange(2);
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 widgetpage.colorchange("121px","125.5px");
		
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 
		 Assert.assertEquals("rgba(224, 159, 159, 1)",widgetpage.getheaderColor());
		 /// title font change
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 widgetpage.clickWidgetHeaderbakground();
		 try{ 
			 Thread.sleep(10000);
		 }catch(Exception e){}
		 widgetpage.clickonstylechange();
		 try{
			 Thread.sleep(10000);
		 }catch(Exception e){}
		 widgetpage.clickonstylechangepopup();
		 try{
			 Thread.sleep(15000);
		 }catch(Exception e){}
		 Assert.assertEquals("Verdana, Geneva, sans-serif",widgetpage.getFontFamilyTitle());
	 }//End of widgetListsettingHeader
	 /* 
	  *  Use-case : Slide Show: Toggle with settings
	  *  Test case :1) Open any slideshow version widget
                    2) Toggle with settings under 'list'.
                    3) Click on done get code
	  */
	  @Test(priority=19,dataProviderClass = DataProviders.class, dataProvider = "Login")
	  public void SlideSettingList(String loginRequired){
	   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 19 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	   WidgetPage widgetpage=null;
	   if(loginRequired.equals("YES")){
	    widgetpage =BaseStateWithLogin("SlideSettingList");
	   }else{
	    widgetpage =BaseState("SlideSettingList");
	   }
	    common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
		 widgetpage.clickOnSlideFooterEmbed(); 
	   //background color change
	   widgetpage.clickOnList();
	   try{
	    Thread.sleep(4000);
	   }catch(Exception e){}
	    widgetpage.clickoncolorchangeList();
	    try{
		    Thread.sleep(2000);
		   }catch(Exception e){}
		   widgetpage.colorchange("13px","38.5px");
		   try{
		    Thread.sleep(12000);
		   }catch(Exception e){}
		   Assert.assertEquals("rgba(255, 255, 255, 1)",widgetpage.getheaderColor());
		//   /// List font change
		   try{
		    Thread.sleep(4000);
		   }catch(Exception e){}
		   widgetpage.clickonstylechangeList();
		    widgetpage.clickonstylechangepopupList();
		   try{
		    Thread.sleep(8000);
		   }catch(Exception e){}
		    Assert.assertEquals("Verdana, Geneva, sans-serif",widgetpage.getAttributeOfSlidingImageUpText("name"));
		   }//End of widgetListsetting
	  /* 
		  *  Use-case : Slide Show: Toggle with settings
		  *  Test case :1) Open any slideshow version widget
	                    2) Toggle with settings under 'list'.
	                    3) Click on done get code
		  */
	 @Test(priority=20,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void SlideSettingListMore(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 20 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("SlideSettingListMore");
		 }else{
			 widgetpage =BaseState("SlideSettingListMore");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
		 widgetpage.clickOnSlideFooterEmbed();
		 try{
			 Thread.sleep(8000);
		 }catch(Exception e){}
		 widgetpage.clickWidgetHeaderbakground();
		 try{
			 Thread.sleep(8000);
		 }catch(Exception e){}
		 ///show list name uncheck box
		 widgetpage.clickOnListname(false);
		 try{
			 Thread.sleep(3000);
		 }catch(Exception e){}
		 
		 Assert.assertFalse(widgetpage.isPresentHeadername());
		 ///show list name check box
		 widgetpage.clickOnListname(true);
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 Assert.assertTrue(widgetpage.isPresentHeadername());
		 try{
			 Thread.sleep(4000);
		 }catch(Exception e){}
		 ////show list image
		 widgetpage.clickOnlistimage(true);
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 Assert.assertTrue(widgetpage.isPresentlistimagecheck());
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 // show user name
		 widgetpage.clickOnlistusername(true);
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 Assert.assertTrue(widgetpage.isPresentlistusernamecheck());
	 }//End of SlideSettingListMore
	 
	 /* 
	  *  Use-case : Slide Show: Toggle with settings
	  *  Test case :1) Open any slideshow version widget
                    2) Toggle with settings under 'footer'.
                    3) Click on done get code
	  */
	 @Test(priority=21,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void SlideSettingFooter(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 21 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("SlideSettingFooter");
		 }else{
			 widgetpage =BaseState("SlideSettingFooter");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
		 widgetpage.clickOnSlideFooterEmbed();
		 try{
			 Thread.sleep(9000);
		 }catch(Exception e){}
		 widgetpage.clickonfootercolor();
		 try{
			 Thread.sleep(9000);
		 }catch(Exception e){}
		 widgetpage.clickonfooterBckgrdcolorchange();
		 try{
			 Thread.sleep(8000);
		 }catch(Exception e){}
		 widgetpage.colorchange("9px","135px");
		 try{
			 Thread.sleep(10000);
		 }catch(Exception e){}
		 System.out.println("widgetpage.getfooterBckgrdColorchange()==="+widgetpage.getfooterBckgrdColorchange());
		 
		 Assert.assertEquals("rgba(232, 16, 16, 1)",widgetpage.getfooterBckgrdColorchange());
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 widgetpage.clickonfooterTextcolorchange();
		 widgetpage.colorchange("10px","133px");
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 Assert.assertEquals("rgba(10, 10, 10, 1)",widgetpage.getfooterTextColorchange());
		 
//		 widgetpage.clickOnSlideFooterEmbed();
//		 try{
//			 Thread.sleep(7000);
//		 }catch(Exception e){}
//		 widgetpage.clickonfootercolor();
//		 try{
//			 Thread.sleep(8000);
//		 }catch(Exception e){}
//		 widgetpage.clickonfootercolorchange();
//		 try{
//			 Thread.sleep(8000);
//		 }catch(Exception e){}
//		 Assert.assertEquals("rgba(24, 96, 23, 1)",widgetpage.getfooterColorchnage());
		 
	 } // End of SlideSettingFooter
	 //////////////////NEW TESTCASE/////////////////
	 /*
	  * Use-case : Slideshow working in Non-Votable list
	  * Test case :  1. Go to any non-vote-able slide show type list say 
	                 http://www.ranker-qa.com/list/celebrities-who-were-widowed-young/celebrity-lists
	                 2. Embed The List
	  */
	 @Test(priority=22,dataProviderClass = DataProviders.class, dataProvider = "Login")
	  public void SlideNonVotableLink(String loginRequired){
	   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 22 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	   WidgetPage widgetpage=null;
	   if(loginRequired.equals("YES")){
	    widgetpage =BaseStateWithLogin("SlideNonVotableLink");
	   }else{
	    widgetpage =BaseState("SlideNonVotableLink");
	   }
	   common.getNewURL(config.getProperty("Url")+"list/celebrities-who-were-widowed-young/celebrity-lists");
		 widgetpage.clickOnSlideFooterEmbed(); 
		 int num1=Integer.parseInt(widgetpage.getTextOfSlidingImage1UpNumber("number"));
		 widgetpage.clickOnNextButtonOnImage();
		 try{
			 Thread.sleep(8000);
		 }catch(Exception e){}
		 int num2=Integer.parseInt(widgetpage.getTextOfSlidingImage2UpNumber("number"));
		 Assert.assertNotEquals(num1, num2);
		 
	}//End of SlideNonVotableLink
	 
	 /* 
	  *  Use-case : Side bar widget: image/video links
	  *  Test case :"1) Open any list
					 2) Click on node image/video"
	  */
	 @Test(priority=23,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void SideBarWidgetImageVideoLinks(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 23 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("widgetHeightListDetail");
		 }else{
			 widgetpage =BaseState("widgetHeightListDetail");
		 }
		 
		 //For image
		 getDriver().get("http://www.ranker.com/list/best-albums-released-posthumously/ranker-music");
		 
		 widgetpage.clickOnEmbedTab(); 
		 try{
			 Thread.sleep(10000);
		 }catch(Exception e){}
		 String before = widgetpage.gethrefOfImageOfItem(1);
		 widgetpage.clickOnImageOfItem(1);
		 widgetpage.switchToNewWindow();
		 try{
			 Thread.sleep(10000);
		 }catch(Exception e){}
		 if (getDriver().getCurrentUrl().contains(before))
			 Assert.assertEquals(0, 0);
		 else
			 Assert.assertEquals(0, 1);
		 getDriver().close();
		 widgetpage.switchToWindow(0);
		 try{
			 Thread.sleep(10000);
		 }catch(Exception e){}
		 //For video
		 getDriver().get("http://www.ranker.com/list/best-pinball-arcade-and-computer-game-related-songs/hbg1968");
		 try{
			 Thread.sleep(10000);
		 }catch(Exception e){}
		 widgetpage.clickOnEmbedTab(); 
		 try{
			 Thread.sleep(10000);
		 }catch(Exception e){}
		 widgetpage.clickOnVideoOfItem(1);
		 Assert.assertTrue(widgetpage.isVideoPresent());
	 } //End of widgetHeightListDetail()
	 /* 
	  *  Use-case : Check caursoal
	  *  Test case :"1) Open any slideshow version widget pickup page
                    2) Click on 'Arrows' appear beside list images
	  */
	 @Test(priority=24,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void CheckcaursoalSlideshow(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 24 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("CheckcaursoalSlideshow");
		 }else{
			 widgetpage =BaseState("CheckcaursoalSlideshow");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/top-8-pro-athletes-convicted-of-murder/awesomeballa");
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 widgetpage.clickOnSlideFooterEmbed();
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 widgetpage.clickOnList();
		 widgetpage.clickOnwidgetListDisplayThumbnails();
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 Assert.assertTrue(widgetpage.isPresentDisplayThumbnails());
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
	 } //End of CheckcaursoalSlideshow()
	 /* 
	  *  Use-case : Verify background and forebackground color setting in Header 
	  *  Test case :1. Go to any widget pickup page
					2. Go to footer options and change the color of both foreground and background 
					Grid: http://www.ranker-stage.com/widget/1902956
	  */
	 @Test(priority=25,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void widgetGridsettingHeader(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 25 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("widgetGridsettingHeader");
		 }else{
			 widgetpage =BaseState("widgetGridsettingHeader");
		 }
		 common.getNewURL(config.getProperty("Url")+"widget/1902956");
		widgetpage.clickWidgetHeaderbakground();
	 try{
		 Thread.sleep(4000);
	 }catch(Exception e){}
	 widgetpage.clickoncolorchange(1);
	 try{
		 Thread.sleep(4000);
	 }catch(Exception e){}
	 widgetpage.colorchange("13px","38.5px");
	 try{
		 Thread.sleep(7000);
	 }catch(Exception e){}
	 Assert.assertEquals("rgba(224, 159, 159, 1)",widgetpage.getheaderColor());
	 try{
		 Thread.sleep(5000);
	 }catch(Exception e){}
	 ////title color change
	 widgetpage.clickWidgetHeaderbakground();
	 try{
		 Thread.sleep(5000);
	 }catch(Exception e){}
	 widgetpage.clickWidgetHeaderbakground();
	 try{
		 Thread.sleep(2000);
	 }catch(Exception e){}
	 widgetpage.clickoncolorchange(2);
	 try{
		 Thread.sleep(2000);
	 }catch(Exception e){}
	 widgetpage.colorchange("121px","125.5px");
	 try{
		 Thread.sleep(5000);
	 }catch(Exception e){}
	 Assert.assertEquals("rgba(224, 159, 159, 1)",widgetpage.getheaderColor());
	 /// title font change
	 try{
		 Thread.sleep(5000);
	 }catch(Exception e){}
	 widgetpage.clickWidgetHeaderbakground();
	 try{ 
		 Thread.sleep(10000);
	 }catch(Exception e){}
	 widgetpage.clickonstylechange();
	 try{
		 Thread.sleep(10000);
	 }catch(Exception e){}
	 widgetpage.clickonstylechangepopup();
	 try{
		 Thread.sleep(15000);
	 }catch(Exception e){}
	 Assert.assertEquals("Verdana, Geneva, sans-serif",widgetpage.getFontFamilyTitle());
}//End of widgetGridsettingHeader
	 /* 
	   *  Use-case : Widget tab: Check settings
	   *  Test case :1) Open any list
	     2) Click on 'Embed' tab appear in list strip"
	     3) Play with the embed settings(footer)
	   */
	  @Test(priority=26,dataProviderClass = DataProviders.class, dataProvider = "Login")
	  public void widgetGridsettingFooter(String loginRequired){
	   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 26 !!!!!!!!!!!!!!!!!!!!!!!");
	   //Base state. (Navigate to node page)
	   WidgetPage widgetpage=null;
	   if(loginRequired.equals("YES")){
	    widgetpage =BaseStateWithLogin("widgetGridsettingFooter");
	   }else{
	    widgetpage =BaseState("widgetGridsettingFooter");
	   }
	   common.getNewURL(config.getProperty("Url")+"widget/1902956");
	   widgetpage.clickonfootercolor();
	   widgetpage.clickonfooterBckgrdcolorchange();
	   widgetpage.colorchange("9px","135px");
	   try{
	    Thread.sleep(10000);
	   }catch(Exception e){}
	   Assert.assertEquals("rgba(232, 16, 16, 1)",widgetpage.getfooterBckgrdColorchange());
	   try{
	    Thread.sleep(5000);
	   }catch(Exception e){}
	   widgetpage.clickonfooterTextcolorchange();
	   try{
	    Thread.sleep(5000);
	   }catch(Exception e){}
	   widgetpage.colorchange("10px","133px");
	   try{
	    Thread.sleep(10000);
	   }catch(Exception e){}
	   Assert.assertEquals("rgba(230, 18, 18, 1)",widgetpage.getfooterTextColorchange());
	  } // End of widgetGridsettingFooter
	 /* 
	  *  Use-case : Verify background and forebackground color setting in Header
	  *  Test case :1. Go to any widget pickup page
					2. Go to header options and change the color of both foreground and background 
					Slideshow : http://www.ranker-stage.com/widget/2065954
	  */
	 @Test(priority=27,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void widgetSlideshowsettingHeader(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 27 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 WidgetPage widgetpage=null;
		 if(loginRequired.equals("YES")){
			 widgetpage =BaseStateWithLogin("widgetSlideshowsettingHeader");
		 }else{
			 widgetpage =BaseState("widgetSlideshowsettingHeader");
		 }
		 common.getNewURL(config.getProperty("Url")+"widget/2065954");
		widgetpage.clickWidgetHeaderbakground();
	 try{
		 Thread.sleep(4000);
	 }catch(Exception e){}
	 widgetpage.clickoncolorchange(1);
	 try{
		 Thread.sleep(4000);
	 }catch(Exception e){}
	 widgetpage.colorchange("13px","38.5px");
	 try{
		 Thread.sleep(7000);
	 }catch(Exception e){}
	 Assert.assertEquals("rgba(224, 159, 159, 1)",widgetpage.getheaderColor());
	 try{
		 Thread.sleep(5000);
	 }catch(Exception e){}
	 ////title color change
	 widgetpage.clickWidgetHeaderbakground();
	 try{
		 Thread.sleep(5000);
	 }catch(Exception e){}
	 widgetpage.clickWidgetHeaderbakground();
	 try{
		 Thread.sleep(2000);
	 }catch(Exception e){}
	 widgetpage.clickoncolorchange(2);
	 try{
		 Thread.sleep(2000);
	 }catch(Exception e){}
	 widgetpage.colorchange("121px","125.5px");
	 try{
		 Thread.sleep(5000);
	 }catch(Exception e){}
	 Assert.assertEquals("rgba(224, 159, 159, 1)",widgetpage.getheaderColor());
	 /// title font change
	 try{
		 Thread.sleep(5000);
	 }catch(Exception e){}
	 widgetpage.clickWidgetHeaderbakground();
	 try{ 
		 Thread.sleep(10000);
	 }catch(Exception e){}
	 widgetpage.clickonstylechange();
	 try{
		 Thread.sleep(10000);
	 }catch(Exception e){}
	 widgetpage.clickonstylechangepopup();
	 try{
		 Thread.sleep(15000);
	 }catch(Exception e){}
	 Assert.assertEquals("Verdana, Geneva, sans-serif",widgetpage.getFontFamilyTitle());
}//END of widgetSlideshowsettingHeader
	 /* 
	   *  Use-case : Widget tab: Check settings
	   *  Test case :1) Open any list
	     2) Click on 'Embed' tab appear in list strip"
	     3) Play with the embed settings(footer)
	   */
	  @Test(priority=28,dataProviderClass = DataProviders.class, dataProvider = "Login")
	  public void widgetSlideshowsettingFooter(String loginRequired){
	   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 28 !!!!!!!!!!!!!!!!!!!!!!!");
	   //Base state. (Navigate to node page)
	   WidgetPage widgetpage=null;
	   if(loginRequired.equals("YES")){
	    widgetpage =BaseStateWithLogin("widgetSlideshowsettingFooter");
	   }else{
	    widgetpage =BaseState("widgetSlideshowsettingFooter");
	   }
	   common.getNewURL(config.getProperty("Url")+"widget/2065954");
	   widgetpage.clickonfootercolor();
	   widgetpage.clickonfooterBckgrdcolorchange();
	   widgetpage.colorchange("9px","135px");
	   try{
	    Thread.sleep(10000);
	   }catch(Exception e){}
	   Assert.assertEquals("rgba(232, 16, 16, 1)",widgetpage.getfooterBckgrdColorchange());
	   try{
	    Thread.sleep(5000);
	   }catch(Exception e){}
	   widgetpage.clickonfooterTextcolorchange();
	   try{
	    Thread.sleep(5000);
	   }catch(Exception e){}
	   widgetpage.colorchange("10px","133px");
	   try{
	    Thread.sleep(10000);
	   }catch(Exception e){}
	   Assert.assertEquals("rgba(230, 18, 18, 1)",widgetpage.getfooterTextColorchange());
	  } // End of widgetSlideshowsettingFooter
	  
	  /* 
	   *  Use-case : Widget:"OF" should be "of" in slide number
	   *  Test case :Open widget: http://www.ranker-stage.com/widget/1725719
	   */
	  @Test(priority=29,dataProviderClass = DataProviders.class, dataProvider = "Login")
	  public void WidgetOFInSlideNumber(String loginRequired){
	   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 29 !!!!!!!!!!!!!!!!!!!!!!!");
	   //Base state. (Navigate to node page)
	   WidgetPage widgetpage=null;
	   if(loginRequired.equals("YES")){
	    widgetpage =BaseStateWithLogin("WidgetOFInSlideNumber");
	   }else{
	    widgetpage =BaseState("WidgetOFInSlideNumber");
	   }
	   common.getNewURL(config.getProperty("Url")+"widget/1725719");
	   String txt=widgetpage.getTextofWidgetOFInSlideNumber();
	   System.out.print("txt"+txt);
	   if(txt.contains("of")){
		   Assert.assertEquals(1, 1);
		   }
	   else
		   Assert.assertEquals(1, 0);   
	  }
	  /* 
	   *  Use-case : swap the vote buttons and blather
	   *  Test case :Go to a slideshow widget that has blather (ex: http://www.ranker-stage.com/widget/1751589)
	   */
	  @Test(priority=30,dataProviderClass = DataProviders.class, dataProvider = "Login")
	  public void SwapVoteButtons(String loginRequired){
	   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 30 !!!!!!!!!!!!!!!!!!!!!!!");
	   //Base state. (Navigate to node page)
	   WidgetPage widgetpage=null;
	   if(loginRequired.equals("YES")){
	    widgetpage =BaseStateWithLogin("SwapVoteButtons");
	   }else{
	    widgetpage =BaseState("SwapVoteButtons");
	   }
	   common.getNewURL(config.getProperty("Url")+"widget/1751589");
	   Assert.assertTrue(widgetpage.isUpDownVotePresent());
	   Assert.assertNotNull(widgetpage.getTextofBlather());
	  }
	  /* 
	   *  Use-case : Widget:Verify video should play in lighbox widgets
	   *  Test case :open any list with nodes videos
					 click on embed 
	   */
	  @Test(priority=31,dataProviderClass = DataProviders.class, dataProvider = "Login")
	  public void VerifyVideoInWidget(String loginRequired){
	   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 31 !!!!!!!!!!!!!!!!!!!!!!!");
	   //Base state. (Navigate to node page)
	   WidgetPage widgetpage=null;
	   if(loginRequired.equals("YES")){
	    widgetpage =BaseStateWithLogin("VerifyVideoInWidget");
	   }else{
	    widgetpage =BaseState("VerifyVideoInWidget");
	   }
	   common.getNewURL(config.getProperty("Url")+"list/best-tv-host-farewells/ranker-tv");
	   widgetpage.clickOnEmbedTab();
	   try {
		Thread.sleep(3000);
	} catch (Exception e) {
	}
	   widgetpage.clickOnVideonode(1);
	   try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	   Assert.assertTrue(widgetpage.isPresentvideowindow());
	  }
	  
	  /* 
		  *  Use-case : Widget tracking
		  *  Test case : Go to a slideshow widget in the wild and scroll through the slideshow until you're on the last slide RLs. Hover over each of the 4 RLs
		  */
		 @Test(priority=32,dataProviderClass = DataProviders.class, dataProvider = "Login")
		 public void WidgetTracking(String loginRequired){
			 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 32 !!!!!!!!!!!!!!!!!!!!!!!");
			 //Base state. (Navigate to node page)
			 WidgetPage widgetpage=null;
			 if(loginRequired.equals("YES")){
				 widgetpage =BaseStateWithLogin("WidgetTracking");
			 }else{
				 widgetpage =BaseState("WidgetTracking");
			 }
			 common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
			 String[] first=(widgetpage.getImageNumOnWidgetSlideShow().split("of "));
			 int num=Integer.parseInt(first[1]);
			 widgetpage.clickOnSlideFooterEmbed();
			 for(int i=1;i<=num+2;i++){
				 try{
					 Thread.sleep(8000);
				 }catch(Exception e){}
			    if(widgetpage.isNextButtonOnWidgetSlideShowPresent())
				 widgetpage.clickOnNextButtonOnImage();
			 }
			    widgetpage.HoveronlastSlideOnWidget4Rls(1);
			    String href=widgetpage.getHrefOflastSlideOnWidget4Rls(1);
			    if(href.contains("utm_source=widget&utm_campaign=widget_"))
			    Assert.assertEquals(1, 1);	
			    else
			    	Assert.assertEquals(1, 0);		
			   
			 
		 }// End of LastSlide()
		 /* 
		  *  Use-case : Widget pickup missing reset to default link
		  *  Test case : Go to any embed page (ex: http://www.ranker-stage.com/widget/1839961)
		  */
		 @Test(priority=33,dataProviderClass = DataProviders.class, dataProvider = "Login")
		 public void WidgetDefaultLink(String loginRequired){
			 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 33 !!!!!!!!!!!!!!!!!!!!!!!");
			 //Base state. (Navigate to node page)
			 WidgetPage widgetpage=null;
			 if(loginRequired.equals("YES")){
				 widgetpage =BaseStateWithLogin("WidgetDefaultLink");
			 }else{
				 widgetpage =BaseState("WidgetDefaultLink");
			 }
			 common.getNewURL(config.getProperty("Url")+"widget/1839961");
			 Assert.assertEquals(widgetpage.getTextofresetdefault(), "reset to default");
			 
		 }// End of LastSlide()
		 /* 
		  *  Use-case : Widget: Italics footer
		  *  Test case : Publish a slide show and a grid list in your blog page
 							Eg:http://chantelles.tumblr.com/
		  */
		 @Test(priority=33,dataProviderClass = DataProviders.class, dataProvider = "Login")
		 public void ItalicsFooter(String loginRequired){
			 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 33 !!!!!!!!!!!!!!!!!!!!!!!");
			 //Base state. (Navigate to node page)
			 WidgetPage widgetpage=null;
			 if(loginRequired.equals("YES")){
				 widgetpage =BaseStateWithLogin("WidgetDefaultLink");
			 }else{
				 widgetpage =BaseState("WidgetDefaultLink");
			 }
			 common.getNewURL("http://chantelles.tumblr.com/");
			 try{
				 Thread.sleep(3000);
			 }catch(Exception e){}
			 Assert.assertNotEquals("italic", widgetpage.getFontwidgetfooter());
		 }// End of LastSlide()
	   /*
	  * This is base state of the slide show test-cases.
	  */
	 public WidgetPage BaseState(String testName){
		 try{
		 startRecording(testName);
		}catch(Exception e){}
		 common=new Commonpage(getDriver());
		 WidgetPage widgetpage=common.getWidgetPage(url);
		 return widgetpage;
	 } //End of BaseState()
	 /*
	  * This is base state of the slide show test-cases.
	  */
	 public WidgetPage BaseStateWithLogin(String testName){
		 try{
		 startRecording(testName);
		}catch(Exception e){}
		 common=new Commonpage(getDriver());
		 common.signin("testuserkallol1@mailinator.com", "testing");
		 WidgetPage widgetpage=common.getWidgetPage(url);
		 return widgetpage;
	 } //End of BaseStateWithLogin() 
    
}