package com.testsuite.BlogTest;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.pageobjects.blog.BlogPage;
import com.pageobjects.grid.Grid;
import com.pageobjects.listheader.ListHeader;
import com.pageobjects.slideshow.Slideshow;
import com.selenium.SafeActions;

public class BlogTests  extends BaseSetup{

	ConfigManager urls=new ConfigManager("PreProduction");
	 Commonpage common;
	 String url=config.getProperty("Url")+urls.getProperty("BlogPage");
	 
	 /* 
	  * Use-case : Upvote and Downvote buttons 	  
	  * Test case : Go to any node page which should contain upvote and downvote buttons. Check their workin as well. 
	  */
	 @Test(priority=1,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void UpvoteDownvote(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 BlogPage blogPage=null;
		 if(loginRequired.equals("YES")){
			 blogPage =BaseStateWithLogin("UpvoteDownvote");
		 }else{
			 blogPage =BaseState("UpvoteDownvote");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/the-best-l-a-food-trucks/chef-jen");
		 common.votableLinkPresenceAndAccept();
		 Assert.assertTrue(blogPage.isupVotePresent());
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		 
		 
		 Assert.assertTrue(blogPage.isdownVotePresent());
		 String up=blogPage.getupVoteCount();
		 int upCountBefore = Integer.parseInt(up);
		 blogPage.clickOnupVote();
		 up=blogPage.getupVoteCount();
		 int upCountAfter = Integer.parseInt(up);
		 Assert.assertEquals(upCountBefore, upCountAfter-1);
		 String down=blogPage.getdownVoteCount();
		 int downCountBefore = Integer.parseInt(down);
		 blogPage.clickOndownVote();
		 down=blogPage.getdownVoteCount();
		 int downCountAfter = Integer.parseInt(down);
		 Assert.assertEquals(downCountBefore, downCountAfter-1);
	 }//End of UpvoteDownvote()
	 /* 
	  * Use-case : Node name click.
	  * Test case : Go to any node page which should contain Node Name. Check on node name. 
	  */
	 @Test(priority=2,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void NodeName(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 BlogPage blogPage=null;
		 if(loginRequired.equals("YES")){
			 blogPage =BaseStateWithLogin("NodeName");
		 }else{
			 blogPage =BaseState("NodeName");
		 }
		 String txtBefore = blogPage.getTextOfNodeName(1);
		 System.out.println("txtBefore"+txtBefore);
		 try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 blogPage.clickOnNodeName(1);
		 String txtafter = blogPage.getHeaderAfterClickOnNode();
		// System.out.println("txtafter"+txtafter);
		 Assert.assertEquals(txtBefore.trim(), blogPage.getHeaderAfterClickOnNode());
		// Assert.assertEquals(txtBefore, blogPage.getHeaderAfterClickOnNode());
	 }//End of NodeName()
	 /* 
	  * Use-case : Node Image click.
	  * Test case : Go to any node page which should contain node image. click on node image. 
	  */
	 @Test(priority=3,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void NodeImage(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 BlogPage blogPage=null;
		 if(loginRequired.equals("YES")){
			 blogPage =BaseStateWithLogin("NodeImage");
		 }else{
			 blogPage =BaseState("NodeImage");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/us-presidents-who-werent-elected/carly-kiel?format=BLOG");
		 try{
			 
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 String txtBefore = blogPage.getTextOfNodeName(1);
		 blogPage.clickOnNodeImage(1);
	/*
	 * Commented as changes : now new tab is not being opened.
	 	 try{
	 
			 Thread.sleep(6000);
		 }catch(Exception e){e.printStackTrace();}
		 ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
		 System.out.println("!!!222222222222222222222");
		 getDriver().switchTo().window(tabs2.get(1));
		 System.out.println("!!!33333333333333333333333");
		 Assert.assertEquals(txtBefore+"\ntopic page", blogPage.getHeaderAfterClickOnNodeImage());
		 System.out.println("!!!444444444444444444");
		 getDriver().close();
		 getDriver().switchTo().window(tabs2.get(0));	
		 System.out.println("!!!55555555555555");*/
		 Assert.assertEquals(txtBefore+"\ntopic page", blogPage.getHeaderAfterClickOnNodeImage());
		 
	 }//End of NodeImage()
	 /* 
	  * Use-case : Check the description.
	  * Test case : Go to any node page which should contain node description. 
	  */
	 @Test(priority=4,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void NodeDescription(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 BlogPage blogPage=null;
		 if(loginRequired.equals("YES")){
			 blogPage =BaseStateWithLogin("NodeDescription");
		 }else{
			 blogPage =BaseState("NodeDescription");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/us-presidents-who-werent-elected/carly-kiel?format=BLOG");
		// WebElement element=driver.findElement(By.id(""));
		 //for ranker
//		 String[] description = blogPage.getDesc
		// Assert.assertTrue(blogPage.isDescriptionPresent(2));
//		 String[] description = blogPage.getDescription(2).split("\n");
//		 Assert.assertEquals("Test Description", description[0]);
		 
		 //about..
		 Assert.assertTrue(blogPage.isAboutPresent(2));
		 String[] about = blogPage.getTextAbout(2).split("\n");
		 Assert.assertNotNull(about[0]);
		 String txt = blogPage.getTextOfNodeName(2);
		// System.out.println("@@@@@@@@@@@@@@@@@@@@@@@text"+ txt);
		 blogPage.clickOnSeeMoreInAboutSection(2);
		 Assert.assertEquals(txt, blogPage.getHeaderAfterClickOnNode());
	 }//End of NodeImage()
	 /* 
	  * Use-case : Check the also ranked section.
	  * Test case : Go to any node page which should contain also ranked section. Clicking on the links in also ranked section should take to the corresponding page. 
	  */
	 @Test(priority=5,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void AlsoRanked(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 BlogPage blogPage=null;
		 if(loginRequired.equals("YES")){
			 blogPage =BaseStateWithLogin("AlsoRanked");
		 }else{
			 blogPage =BaseState("AlsoRanked");
		 } 
		 common.getNewURL(config.getProperty("Url")+"list/us-presidents-who-werent-elected/carly-kiel?format=BLOG");
		 blogPage.autoloading(6);
		 Assert.assertTrue(blogPage.isalsoRankedPresent());
		 String linkBefore=blogPage.getTextOfalsoRankedLinks(1);
		 blogPage.clickOnalsoRankedLinks(1);
		 SafeActions s = new SafeActions(getDriver());
		  s.waitForPageToLoad(60);
//		 try{//section[@id='mainListCnt']/ol[@id='mainList']/li[contains(@id,'n_')][6]/div[@class='float relative clear img']/div[@class='floatRight relative']//img
//			Thread.sleep(2000);
//		 } catch(Exception e){}
		 //common.facebookLikePresenceAndAccept();
		 String linkAfter=blogPage.getTextalsoRankedNextPageHeader();
		 Assert.assertEquals(linkAfter, linkBefore);
		 
	 }//End of AlsoRanked()
	 /* 
	  * Use-case : Check the autoloading.
	  * Test case : Go to any node page and check the autoloading. 
	  */
	 @Test(priority=6,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void AutoLoading(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
		 BlogPage blogPage=null;
		 if(loginRequired.equals("YES")){
			 blogPage =BaseStateWithLogin("AutoLoading");
		 }else{
			 blogPage =BaseState("AutoLoading");
		 } 
		 common.getNewURL(config.getProperty("Url")+"list/us-presidents-who-werent-elected/carly-kiel?format=BLOG");
		 try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}
		 blogPage.autoloading(6);
         try{
			 
			 Thread.sleep(5000);
		 }catch(Exception e){}
		Assert.assertTrue(blogPage.isnodePresent(10));//12
	 }//End of AutoLoading()
	 /* 
	  * Use-case : Tracking also ranked on blog
	  * Test case : Open: blog list: http://www.ranker.com/list/best-guilty-pleasure-tv-shows/ranker-tv?format=BLOG
					info list: http://www.ranker.com/list/best-guilty-pleasure-tv-shows/ranker-tv
					Open node expander to view also ranked section lists
					Click on lists
	  */
	 @Test(priority=7,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void TrackingAlsoRanked(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
		 BlogPage blogPage=null;
		 if(loginRequired.equals("YES")){
			 blogPage =BaseStateWithLogin("TrackingAlsoRanked");
		 }else{
			 blogPage =BaseState("TrackingAlsoRanked");
		 } 
		 common.getNewURL(config.getProperty("Url")+"list/best-guilty-pleasure-tv-shows/ranker-tv?format=BLOG");
		 try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
			String href=blogPage.gethrefOfalsoRanked();
			blogPage.clickOnalsoRanked();
			if(href.contains("ref=also_ranked&pos"))
			{
			        	Assert.assertEquals(1, 1);
					} else {
						Assert.assertEquals(1, 0);
					}
			 }//End of TrackingAlsoRanked()
	 //////////////////incomplete////////////////
//	 /* 
//	  * Use-case : Verify  Vote Overlay
//	  * Test case : 1) Clear your cache and open ranker-stage.com in private browsing
//					2) Go to a Votable Blog list eg 
//					http://www.ranker-stage.com/list/the-best-l-a-food-trucks/chef-jen?var=2
//	  */
//	 @Test(priority=8,dataProviderClass = DataProviders.class, dataProvider = "Login")
//	 public void VerifyVoteOverlay(String loginRequired){
//		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
//		 BlogPage blogPage=null;
//		 if(loginRequired.equals("YES")){
//			 blogPage =BaseStateWithLogin("VerifyVoteOverlay");
//		 }else{
//			 blogPage =BaseState("VerifyVoteOverlay");
//		 } 
//		 common.getNewURL(config.getProperty("Url")+"list/the-best-l-a-food-trucks/chef-jen?var=2");
//		 common.islistVotableLinkPresent();
//		 String txt=blogPage.getTextOfOverlayMsg();
//		 System.out.println("txt----"+txt);
		 
//	 }
	 /* 
	  * Use-case  : DESKTOP -Blog: Metadata Updates for Also Ranked, Wiki, and Properties
	  * Test case : 1. Go to a blog list
					http://www.ranker.com/list/celebrities-who-should-be-more-famous/swiperight
					2. Check blog blather,image,also ranked on properties etc
	  */
	 @Test(priority=8,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void BlogMetadataUpdates(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
		 BlogPage blogPage=null;
		 if(loginRequired.equals("YES")){
			 blogPage =BaseStateWithLogin("BlogMetadataUpdates");
		 }else{
			 blogPage =BaseState("BlogMetadataUpdates");
		 } 
		 common.getNewURL(config.getProperty("Url")+"list/celebrities-who-should-be-more-famous/swiperight");
		 Assert.assertEquals("Georgia, Times, 'Times New Roman', serif",blogPage.getNodeTextFontFamily());
		 Assert.assertEquals("15px",blogPage.getfontsizeOfBlatherNodeDesc());
		
		
			/////blatherProperties/////
		 Assert.assertEquals("bold",blogPage.getFontWeightOfMoreAboutDesc(1));
		 Assert.assertEquals("normal",blogPage.getFontWeightOfMoreAboutMetadata(1));	
			 }//End of BlogMetadataUpdates
	 /*
		 * Use-case : Top 6 right rail RLs 
		 * Test case :Open any slideshow list
		 */
		@Test(priority = 9, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void Top6RightrailInBlog(String loginRequired) {
			System.out
					.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 9 !!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to grid page)
			 Grid grid = new Grid(getDriver());
			 BlogPage blogPage=null;
			 if(loginRequired.equals("YES")){
				 blogPage =BaseStateWithLogin("Top6RightrailInBlog");
			 }else{
				 blogPage =BaseState("Top6RightrailInBlog");
			 } 
			common.getNewURL(config.getProperty("Url")+"list/women-who-prince-has-dated/celebrityhookups?&format=BLOG");
			try {
				Thread.sleep(4000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			for (int i = 1; i <= 6; i++) {
				Assert.assertTrue(grid.isPresentListIntoprighttrail(1, i));
			}
			String href[] = grid.gethrefOftoprighttraillist(1, 1).split("\\?");
			grid.clickOntoprighttraillist(1, 1);
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			String afterurl = getDriver().getCurrentUrl();
			Assert.assertEquals(href[0], afterurl);

		}// end for Top6Rightrail
		/*
		 * Use-case : Second 6 right rail RLs 
		 * Test case :Open any slideshow list
		 */
		@Test(priority = 10, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void Second6Rightrail(String loginRequired) {
			System.out
					.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 10 !!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to grid page)
			Grid grid = new Grid(getDriver());
			 BlogPage blogPage=null;
			 if(loginRequired.equals("YES")){
				 blogPage =BaseStateWithLogin("Top6RightrailInBlog");
			 }else{
				 blogPage =BaseState("Top6RightrailInBlog");
			 } 
			common.getNewURL(config.getProperty("Url")+"list/women-who-prince-has-dated/celebrityhookups?&format=BLOG");
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
			}
			
			String href[] = grid.gethrefOftoprighttraillist(1, 2).split("\\?");
			System.out.println("href[]=="+href[0]);
			grid.clickOntoprighttraillist(1, 2);
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
			}
			String afterurl = getDriver().getCurrentUrl();
			Assert.assertEquals(href[0], afterurl);

		}// end for Second6Rightrail
		/*
		 * Use-case : Second 6 right rail RLs 
		 * Test case :Open any slideshow list
		 */
		@Test(priority = 11, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void Bottom6MiddleRightrail(String loginRequired) {
			System.out
					.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 11 !!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to grid page)
			Grid grid = new Grid(getDriver());
			 BlogPage blogPage=null;
			 if(loginRequired.equals("YES")){
				 blogPage =BaseStateWithLogin("Top6RightrailInBlog");
			 }else{
				 blogPage =BaseState("Top6RightrailInBlog");
			 } 
			common.getNewURL(config.getProperty("Url")+"list/women-who-prince-has-dated/celebrityhookups?&format=BLOG");
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
			}
			String href[] = grid.gethrefOfbottomrighttraillist(1).split("\\?");
			grid.clickOnbottomrighttraillist(1);
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
			}
			String afterurl[] = getDriver().getCurrentUrl().split("\\?");
			Assert.assertEquals(href[0], afterurl[0]);

		}// end for Bottom6MiddleRightrail

		/*
		 * Use-case : Cascading (pinterest style) RLs 
		 * Test case : Open any slideshow list
		 */
		@Test(priority = 12, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void CascadingRightrailAutoLoading(String loginRequired) {
			System.out
					.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12 !!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to grid page)
			Grid grid = new Grid(getDriver());
			 BlogPage blogPage=null;
			 if(loginRequired.equals("YES")){
				 blogPage =BaseStateWithLogin("Top6RightrailInBlog");
			 }else{
				 blogPage =BaseState("Top6RightrailInBlog");
			 } 
			common.getNewURL(config.getProperty("Url")+"list/women-who-prince-has-dated/celebrityhookups?&format=BLOG");
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
			}
			Assert.assertTrue(grid.ispopularlistPresent());// 12
			grid.autoloading(6);
			try {
				Thread.sleep(8000);
			} catch (Exception e) {
			}
			Assert.assertTrue(grid.isnodePresent(8));// 12
		}// end for CascadingRightrailAutoLoading
		/* 
		  * Use-case : "next list >" in footer
		  * Test case : Open any blog list
		  */
		 @Test(priority=13,dataProviderClass = DataProviders.class, dataProvider = "Login")
		 public void NextListFooterLink(String loginRequired){
			 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 13 !!!!!!!!!!!!!!!!!!!!!!!");
			//Base state. (Navigate to grid page)
			 Grid grid = new Grid(getDriver());
			 ListHeader listHeader=new ListHeader(getDriver());
			 BlogPage blogPage=null;
			 if(loginRequired.equals("YES")){
				 blogPage =BaseStateWithLogin("Top6RightrailInBlog");
			 }else{
				 blogPage =BaseState("Top6RightrailInBlog");
			 } 
			common.getNewURL(config.getProperty("Url")+"list/women-who-prince-has-dated/celebrityhookups?&format=BLOG");
			 
			 String txt[]=listHeader.gethrefOfnextlistfooter().split("\\?");
			 //System.out.println("txt=="+txt[0]);
			 listHeader.clickonnextlistfooter();
			 try{
				 Thread.sleep(5000);
			 }catch(Exception e){}
			 String CurrUrl[]=getDriver().getCurrentUrl().split("\\?");
			 //System.out.println("CurrUrl=="+CurrUrl[0]);
			 Assert.assertNotEquals(txt[0],CurrUrl[0]);
		 }//End of NextListFooterLink
		 /* 
		  * Use-case : Also Ranked
		  * Test case : Open any blog list that has system nodes that are also ranked on other lists and the also ranked setting is enabled in UE 
		  */
		 @Test(priority=14,dataProviderClass = DataProviders.class, dataProvider = "Login")
		 public void AlsoRankedInBlog(String loginRequired){
			 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 14 !!!!!!!!!!!!!!!!!!!!!!!");
			 //Base state. (Navigate to page having right rail)
			 BlogPage blogPage=null;
			 if(loginRequired.equals("YES")){
				 blogPage =BaseStateWithLogin("AlsoRanked");
			 }else{
				 blogPage =BaseState("AlsoRankedInBlog");
			 } 
			 common.getNewURL(config.getProperty("Url")+"list/us-presidents-who-werent-elected/carly-kiel?format=BLOG");
			 blogPage.autoloading(6);
			 Assert.assertTrue(blogPage.isalsoRankedPresent());
			 String linkBefore=blogPage.getTextOfalsoRankedLinks(1);
			 blogPage.clickOnalsoRankedLinks(1);
			 try {
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
			}
//			 SafeActions s = new SafeActions(getDriver());
//			  s.waitForPageToLoad(30);
			 String linkAfter=blogPage.getTextalsoRankedNextPageHeader();
			 Assert.assertEquals(linkAfter, linkBefore);
			 
		 }//End of AlsoRankedInBlog()
		 /* 
		  * Use-case : Closely Related
		  * Test case : Open any blog list that has a "lists like this" block
						http://www.ranker-stage.com/list/the-greatest-mvp-seasons-in-nfl-history/muzziac?format=BLOG
		  */
		 @Test(priority=15,dataProviderClass = DataProviders.class, dataProvider = "Login")
		 public void ListsLikeThisInBlog(String loginRequired){
			 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 15 !!!!!!!!!!!!!!!!!!!!!!!");
			//Base state. (Navigate to grid page)
			 Grid grid = new Grid(getDriver());
			 ListHeader listHeader=new ListHeader(getDriver());
			 BlogPage blogPage=null;
			 if(loginRequired.equals("YES")){
				 blogPage =BaseStateWithLogin("ListsLikeThisInBlog");
			 }else{
				 blogPage =BaseState("ListsLikeThisInBlog");
			 } 
			common.getNewURL(config.getProperty("Url")+"list/the-greatest-mvp-seasons-in-nfl-history/muzziac?format=BLOG");
			 
			 //common.getNewURL(config.getProperty("Url")+"list/the-greatest-mvp-seasons-in-nfl-history/muzziac?format=SLIDESHOW");
			   blogPage.cancelLoading();
			 Assert.assertTrue(grid.isListsLikeThisPresent());
			 try{
				 Thread.sleep(2000);
			 }catch(Exception e){}
			 String txt[]=grid.gethrefOfCloselyRelatedLists(1).split("\\?");
			 System.out.println("txt=="+txt[0]);
			 try{
				 Thread.sleep(5000);
			 }catch(Exception e){}
			 grid.clickOnCloselyRelatedLists(1);
			 try{
				 Thread.sleep(4000);
			 }catch(Exception e){}
			 String CurrUrl[]=getDriver().getCurrentUrl().split("\\?");
			 System.out.println("CurrUrl=="+CurrUrl[0]);
			 Assert.assertEquals(txt[0],CurrUrl[0]);
		 }//End of ListsLikeThisInSlideShow
		 /* 
		  * Use-case : Collections
		  * Test case : Open any slideshow list that is in a collection
						http://www.ranker-stage.com/list/american-politicians-in-the-illuminati/mike-rothschild?ref=rltdlsts&pos=1&a=8&ltype=l&l=2068179&g=1
		  */
		 @Test(priority=16,dataProviderClass = DataProviders.class, dataProvider = "Login")
		 public void collectionInBlog(String loginRequired){
			 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 16 !!!!!!!!!!!!!!!!!!!!!!!");
			//Base state. (Navigate to grid page)
			 Grid grid = new Grid(getDriver());
			 ListHeader listHeader=new ListHeader(getDriver());
			 BlogPage blogPage=null;
			 if(loginRequired.equals("YES")){
				 blogPage =BaseStateWithLogin("collectionInBlog");
			 }else{
				 blogPage =BaseState("collectionInBlog");
			 } 
			common.getNewURL(config.getProperty("Url")+"list/hipsters-trying-too-hard/amylindorff?format=BLOG");
		
			 for(int i=1;i<=3;i++){
				// System.out.println("iiii="+i);
			 String txt[]=grid.gethrefOfFirstListCollection(i).split("\\?");
			 grid.clickOnFirstListCollection(i);
			 try{
				 Thread.sleep(4000);
			 }catch(Exception e){}
			 String CurrUrl[]=getDriver().getCurrentUrl().split("\\?");
			 Assert.assertEquals(txt[0],CurrUrl[0]);
			 }
			 }//end of collectionInBlog
		 /*
			 * Use-case : More By User
			 * Test case : Open any slideshow list that has a "more by this user" block in the right rail
							ttp://www.ranker-stage.com/list/adult-jokes-in-kids-shows/jacob-shelton?
			 */
			@Test(priority = 17, dataProviderClass = DataProviders.class, dataProvider = "Login")
			public void MoreByUserInBlog(String loginRequired) {
				System.out
						.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 17 !!!!!!!!!!!!!!!!!!!!!!!");
				// Base state. (Navigate to grid page)
			 	 Grid grid = new Grid(getDriver());
				 BlogPage blogPage=null;
				 if(loginRequired.equals("YES")){
					 blogPage =BaseStateWithLogin("MoreByUserInBlog");
				 }else{
					 blogPage =BaseState("MoreByUserInBlog");
				 } 
				common.getNewURL(config.getProperty("Url")+"list/hipsters-trying-too-hard/amylindorff?format=BLOG");
				Assert.assertTrue(grid.isMoreByThisUserPresent());
				String txt[] = grid.gethrefOfMoreByThisUserLists(1).split("\\?");
				grid.clickOnMoreByThisUserLists(1);
				String CurrUrl = getDriver().getCurrentUrl();
				Assert.assertEquals(txt[0], CurrUrl);
			}//End of MoreByUserInBlog
			/*
			 * Use-case : Nodely Related
			 * Test case : Open any slideshow list that has an "also ranks on" block in the right rail: http://www.ranker-stage.com/list/best-taylor-swift-songs-written-about-her-boyfriends/amylindorff%20?format=SLIDESHOW
			 */
			@Test(priority = 18, dataProviderClass = DataProviders.class, dataProvider = "Login")
			public void AlsoRankesOnBlog(String loginRequired) {
				System.out
						.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 18 !!!!!!!!!!!!!!!!!!!!!!!");
				// Base state. (Navigate to grid page)
				
				Grid grid = new Grid(getDriver());
				 ListHeader listHeader=new ListHeader(getDriver());
				 BlogPage blogPage=null;
				 if(loginRequired.equals("YES")){
					 blogPage =BaseStateWithLogin("AlsoRankesOnBlog");
				 }else{
					 blogPage =BaseState("AlsoRankesOnBlog");
				 } 
				common.getNewURL(config.getProperty("Url")+"list/best-taylor-swift-songs-written-about-her-boyfriends/amylindorff?format=BLOG");
				
				String txt[] = grid.gethrefOfAlsoRankesOnlists(1).split("\\?");
				grid.clickOnAlsoRankesOnlists(1);
				String CurrUrl[] = getDriver().getCurrentUrl().split("\\?");;
				Assert.assertEquals(txt[0], CurrUrl[0]);
			}//End of AlsoRankesOnBlog
			

			  /* 
			   * Use-case  : Desktop Blog: tweaks
			   * Test case : Open any blog list with properties(More about)
			     eg: http://www.ranker-stage.com/list/best-directorial-debut/anncasano
			   */
			  @Test(priority=19,dataProviderClass = DataProviders.class, dataProvider = "Login")
			  public void BlogTweaks(String loginRequired){
			   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 19 !!!!!!!!!!!!!!!!!!!!!!!");
			   BlogPage blogPage=null;
			   if(loginRequired.equals("YES")){
			    blogPage =BaseStateWithLogin("BlogTweaks");
			   }else{
			    blogPage =BaseState("BlogTweaks");
			   } 
			   common.getNewURL(config.getProperty("Url")+"list/best-directorial-debut/anncasano");
			   Assert.assertEquals("bold",blogPage.getFontWeightOfMoreAboutDesc(1));
			   Assert.assertEquals("normal",blogPage.getFontWeightOfMoreAboutMetadata(1));
			   Assert.assertEquals("bold",blogPage.getFontWeightOfAlsoRankedDesc(1));
			   Assert.assertTrue(blogPage.isAlsoRankedDescPresent(1));
			   }//End of BlogTweaks
		//////incomplete/////////
//			  /* 
//			   * Use-case  :Desktop Blog: have copy line up when "see more" line wraps
//			   * Test case : Open list : http://www.ranker-stage.com/list/the-most-successful-charity-singles-ever/marc-cuenco?page=2
//			                    Scroll to "That's What Friends Are For" node
//			   */
//			  @Test(priority=11,dataProviderClass = DataProviders.class, dataProvider = "Login")
//			  public void DesktopBlog(String loginRequired){
//			   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 11 !!!!!!!!!!!!!!!!!!!!!!!");
//			   BlogPage blogPage=null;
//			   if(loginRequired.equals("YES")){
//			    blogPage =BaseStateWithLogin("DesktopBlog");
//			   }else{
//			    blogPage =BaseState("DesktopBlog");
//			   } 
//			   common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-funniest-movies-of-all-time?page=4&format=BLOG");
//			  }
			  /* 
			   * Use-case  : Desktop Blog: make link to node page actual node name
			   * * Test case : Open list :http://www.ranker-stage.com/list/most-frequent-snl-hosts/best-of-snl 
			   */
			  @Test(priority=20,dataProviderClass = DataProviders.class, dataProvider = "Login")
			  public void BlogLink(String loginRequired){
			   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 20 !!!!!!!!!!!!!!!!!!!!!!!");
			   BlogPage blogPage=null;
			   if(loginRequired.equals("YES")){
			    blogPage =BaseStateWithLogin("BlogLink");
			   }else{
			    blogPage =BaseState("BlogLink");
			   } 
			   common.getNewURL(config.getProperty("Url")+"list/most-frequent-snl-hosts/best-of-snl");
			   String text1=blogPage.getTextOfSeeMoreHeader();
			   String text2=blogPage.getTextOfNodeHeaderDisplay();
			   Assert.assertNotEquals(text1,text2);
			   blogPage.clickOnSeeMoreHeader();
			   String afterclick=blogPage.getTextOfAfterClickSeeMoreHeader();
			   if(text1.contains("Christopher Walken") && afterclick.contains("Christopher Walken")){
				   Assert.assertEquals(1, 1);
			   }
			   else{
				   Assert.assertEquals(1, 0);
			   }
					 
			  }   
			 
			  
	 /*
	  * This is base state of the Right rail test-cases.
	  */
	 public BlogPage BaseState(String testName){
		 try{
			 startRecording(testName);
			}catch(Exception e){}
		 common=new Commonpage(getDriver());
		 BlogPage blogPage=common.getBlogPage(url);
		 return blogPage;
	 } //End of BaseState()
	 /*
	  * This is base state of the Right rail test-cases.
	  */
	 public BlogPage BaseStateWithLogin(String testName){
		 try{
		 startRecording(testName);
		}catch(Exception e){}
		 common=new Commonpage(getDriver());
		 common.signin("testuserkallol1@mailinator.com", "testing");
		 BlogPage blogPage=common.getBlogPage(url);
		 return blogPage;
	 } //End of BaseStateWithLogin()
}
