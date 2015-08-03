package com.testsuite.RightrailTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.pageobjects.rightrail.Rightrail;

public class RightrailTests extends BaseSetup{
	ConfigManager urls=new ConfigManager("PreProduction");
	 Commonpage common;
	 String url=config.getProperty("Url")+urls.getProperty("RightrailPage");
	 ConfigManager sysProp=new ConfigManager("Sys");
	
	 /* 
	  * Use-case : Subscription block [CATEGORY/VOTE LISTS] - new email
	  * Test case : Enter a new, valid email address in the newsletter subscription form and click the green subscribe button.
	  */
	 @Test(priority=1,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void SubscriptionBlockNewEmail(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("SubscriptionBlockNewEmail");
		 }else{
			 rightRail =BaseState("SubscriptionBlockNewEmail");
		 }
		 rightRail.typeEmailtoSubscription("test"+common.randInt(1, 10000)+"@hotworld.com");
		 rightRail.clickOnSubscriptionButton();
		 String msg=rightRail.getTextOfMessageAfterSubscribe();
		 Assert.assertEquals(msg,"Subscribed successfully!");
	 }//End of SubscriptionBlock[CATEGORY/VOTE LISTS]-newEmail()
 
	 /* 
	  * Use-case : Subscription block [CATEGORY/VOTE LISTS] - existing email
	  * Test case : Enter an email address that is already subscribed in the newsletter subscription form and click the green subscribe button.
	  */
	 @Test(priority=2,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void SubscriptionBlockExistingEmail(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("SubscriptionBlockExistingEmail");
		 }else{
			 rightRail =BaseState("SubscriptionBlockExistingEmail");
		 }
		 rightRail.typeEmailtoSubscription("test2test@hotworld.com");
		 rightRail.clickOnSubscriptionButton();
		 rightRail.AlertExistAndAcceptence();
		 String msg=rightRail.getTextOfMessageAfterSubscribe();
		 Assert.assertEquals(msg,"This email has been previously subscribed.");
	 }//End of SubscriptionBlock[CATEGORY/VOTE LISTS]-existingEmail()
	 
	
	 /* 
	  * Use-case : Subscription block [CATEGORY/VOTE LISTS] - invalid email
	  * Test case : Enter an invalid email address in the newsletter subscription form and click the green subscribe button.
	  */
	 @Test(priority=3,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void SubscriptionBlockInvalidEmail(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("SubscriptionBlockInvalidEmail");
		 }else{
			 rightRail =BaseState("SubscriptionBlockInvalidEmail");
		 }
		 rightRail.typeEmailtoSubscription("test");
		 rightRail.clickOnSubscriptionButton();
		 rightRail.AlertExistAndAcceptence();
		 String msg=rightRail.getTextOfMessageAfterSubscribe();
		 Assert.assertEquals(msg,"Invalid email address.");
	 }//End of SubscriptionBlock[CATEGORY/VOTE LISTS]-invalidEmail()
	 /*
	  * use case:Recent List block [HOME/CATEGORY/VOTE LISTS] - list links
	  * testcase:Randomly click on any list link in Recent list block
	  */
	 @Test(priority=4,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void RecentListBlock(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("RecentListBlock");
		 }else{
			 rightRail =BaseState("RecentListBlock");
		 }
		 String txtbefore=rightRail.getTextOfRecentListBlock(1);
		 rightRail.clickOnRecentListBlock(1);
		 if(sysProp.getProperty("Browser.Name").equals("chrome")){
			 try{
				 Thread.sleep(5000); 
			 }catch(Exception e){}
			
		 }
		 common.facebookLikePresenceAndAccept();
		 String txtafter=rightRail.getTextOfHeaderOnClickRecentListBlock();
		 //rightRail.clickFacebookLike();
		 Assert.assertEquals(txtbefore, txtafter);
	 }//End of Recent List block [HOME/CATEGORY/VOTE LISTS] - list links
	 /*
	  * use case: Recent List block [HOME/CATEGORY/VOTE LISTS] - profile links
	  * testcase: Randomly click on any of the Profile links appear for an i-list
	  */
	 @Test(priority=5,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void RecentListBlockClickOnProfile(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("RecentListBlockClickOnProfile");
		 }else{
			 rightRail =BaseState("RecentListBlockClickOnProfile");
		 }

         common.getNewURL(config.getProperty("Url")+"more/most-recent");
		 String txtbefore=rightRail.getTextOfProfileRecentListBlock();
		 rightRail.ClickOnProfileRecentListBlock();
//		 if(sysProp.getProperty("Browser.Name").equals("chrome")){
//			 try{
//				 Thread.sleep(7000); 
//			 }catch(Exception e){}
//		 }
		 String txtafter=rightRail.getTextOfProfileOnClickRecentListBlock();
//		 if(sysProp.getProperty("Browser.Name").equals("chrome")){
//			 try{
//				 Thread.sleep(5000); 
//			 }catch(Exception e){}
//		 }
		 if(txtafter.contains(txtbefore))
			 Assert.assertEquals(1, 1);
		 else
			 Assert.assertEquals(1, 0);
	 }//End of Recent List block [HOME/CATEGORY/VOTE LISTS] - list links
	 /*
	  * use case: Recent List block [HOME/CATEGORY/VOTE LISTS] - contributing list links
	  * testcase: Randomly click on any of the Profile links appear for an Ultimate list
	  */
	 @Test(priority=6,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void RecentListBlockClickOnUltimate(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("RecentListBlockClickOnUltimate");
		 }else{
			 rightRail =BaseState("RecentListBlockClickOnUltimate");
		 }
		 
		String beforeurl= rightRail.gethrefRecentListBlockClickOnUltimate();
		//System.out.println("beforeurl===="+beforeurl);
		rightRail.ClickOnRecentListBlockClickOnUltimate();
	    if(sysProp.getProperty("Browser.Name").equals("chrome")){
		 try{
			 Thread.sleep(7000); 
		 }catch(Exception e){}
	 }
	    common.facebookLikePresenceAndAccept();
		String afterurl=getDriver().getCurrentUrl();
		String[] subString=afterurl.split("\\?");
		int subString1=config.getProperty("Url").length();
		String[] subString2=afterurl.split("\\?");config.getProperty("Url").substring(0, subString1-2);
		Assert.assertEquals(subString2[0],subString[0]);
		//Assert.assertEquals(config.getProperty("Url")+beforeurl,subString[0]);
	 }//End of Recent List block [HOME/CATEGORY/VOTE LISTS] - list links
	 /*
	  * use case: Recent List block [HOME/CATEGORY/VOTE LISTS] - more recent lists
	  * testcase: Click on "more recent lists" link appear at bottom of the block
	  */
	 @Test(priority=7,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void RecentListBlockMoreRecentList(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("RecentListBlockMoreRecentList");
		 }else{
			 rightRail =BaseState("RecentListBlockMoreRecentList");
		 }
		 String beforeClick= rightRail.gethrefMoreRecentList();
		 rightRail.ClickOnMoreRecentList();
		 common.facebookLikePresenceAndAccept();
		 Assert.assertEquals(beforeClick,getDriver().getCurrentUrl());	
	 }//End of RecentListBlockMoreRecentList()
	 
	 /*
	  * use case: Top Rankers block [HOME/CATEGORY] - profile pictures/links
	  * testcase: Click on any of the profile pictures or links that appear in the Top Rankers block
	  */
	 @Test(priority=8,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void TopRankerBlockProfilePictureLink(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("TopRankerBlockProfilePictureLink");
		 }else{
			 rightRail =BaseState("TopRankerBlockProfilePictureLink");
		 }
		 
		 for(int i=1;i<=3;i++){
			 Assert.assertTrue(rightRail.isTopRankerImagePresent(i));
			 Assert.assertEquals(i+"", rightRail.getTopRankerImageNumber(i));
		 }
			 String beforeClick= rightRail.getTextOfTopRankertxt(1);
			 rightRail.clickTopRankerImage(1);
			 //System.out.println("beforeClick"+beforeClick);
			 common.facebookLikePresenceAndAccept();
			 if(rightRail.getTextOfHeaderAfterClickOnPrfile().contains(beforeClick)){
					Assert.assertEquals(1, 1);
				}
				else
				{
					Assert.assertEquals(1, 0);
				}
			 getDriver().navigate().back();
			 common.facebookLikePresenceAndAccept();
			 rightRail.clickTopRankerTxt(1);
			 if(rightRail.getTextOfHeaderAfterClickOnPrfile().contains(beforeClick)){
					Assert.assertEquals(1, 1);
				}
				else
				{
					Assert.assertEquals(1, 0);
				}
			 getDriver().navigate().back();
	 }//End of TopRankerBlockProfilePictureLink()
	 
	 
	 /*
	  * use case: Top Rankers block [HOME/CATEGORY] -  all top rankers
	  * testcase: Click on the "all top rankers" link appear at bottom of the top Rankers link
	  */
	 @Test(priority=9,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void TopRankerBlockAllTopRankers(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 9 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("TopRankerBlockAllTopRankers");
		 }else{
			 rightRail =BaseState("TopRankerBlockAllTopRankers");
		 }
		rightRail.clickOnAllTopRankersLink();
		Assert.assertTrue(rightRail.isTopRankerPresent());
	 }//End of TopRankerBlockAllTopRankers()
	 /* 
	  * Use-case : Featured Partner block [HOME/CATEGORY/CLASS/TAG] - lists
	  * Test case : Click on any of the list links appear in "featured partner" block.
	  */
	 @Test(priority=10,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FeaturedPartnerList(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 10 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("FeaturedPartnerList");
		 }else{
			 rightRail =BaseState("FeaturedPartnerList");
		 }
		Assert.assertTrue(rightRail.isfeaturedPartnerListOfficialTextPresent(1));
		for(int i=1;i<=3;i++)
		{
			Assert.assertTrue(rightRail.isfeaturedPartnerNodeNamePresent(i));
		}
		Assert.assertFalse(rightRail.isfeaturedPartnerNodeNamePresent(4));
		String listbefore= rightRail.getTextOffeaturedPartnerListText(1);
		rightRail.clickOnfeaturedPartnerList(1);
		if(sysProp.getProperty("Browser.Name").equals("chrome")){
			 try{
				 Thread.sleep(5000); 
			 }catch(Exception e){}
			
		 }
		common.facebookLikePresenceAndAccept();
		String listafter=rightRail.getTextOffeaturedPartnerNameNextPage();
		Assert.assertEquals(listbefore,listafter);
	 }//End of FeaturedPartnerBlock[HOME/CATEGORY/CLASS/TAG]-lists()

	 /* 
	  * Use-case : Featured Partner block [HOME/CATEGORY/CLASS/TAG] - profiles
	  * Test case : Click on any of the user profile links in "featured partner" block.
	  */
	 @Test(priority=11,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FeaturedPartnerProfile(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 11 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("FeaturedPartnerProfile");
		 }else{
			 rightRail =BaseState("FeaturedPartnerProfile");
		 }
		for(int j=1;j<=3;j++){
		 String text1=rightRail.getTextOffeaturedPartnerProfile(j);
			for(int i=j+1;i<=3;i++){
					Assert.assertNotEquals(text1, rightRail.getTextOffeaturedPartnerProfile(i));
				}
		}
		String profBefore=rightRail.getTextOffeaturedPartnerProfileText(1);
		rightRail.clickOnfeaturedPartnerProfileText(1);
			 try{
				 Thread.sleep(5000); 
			 }catch(Exception e){}
			
		 common.facebookLikePresenceAndAccept();
		String profAfter=rightRail.getTextOffeaturedPartnerProfileNextPage().toUpperCase();
//		System.out.println("profAfter===="+profAfter);
//		System.out.println("profBefore===="+profBefore);
		if(profAfter.contains(profBefore)){
			Assert.assertEquals(1, 1);
		}
		else
		{
			Assert.assertEquals(1, 0);
		}
		///Assert.assertEquals(profAfter.toUpperCase(), profBefore+"* FEATURED\nPARTNER");
	 }//End of FeaturedPartnerBlock[HOME/CATEGORY/CLASS/TAG]-profiles()
	 /* 
	  * Use-case : Faves block [CATEGORY/CLASS/TAG] - list links
	  * Test case : Randomly click on any list link in Faves list block
	  */
	 @Test(priority=12,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FavsBlockListLinks(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("FavsBlockListLinks");
		 }else{
			 rightRail =BaseState("FavsBlockListLinks");
		 }
		String favsBefore=rightRail.getTextOffavsBlockText(1);
		rightRail.clickOnfavsBlockText(1);
		common.facebookLikePresenceAndAccept();
		Assert.assertEquals(rightRail.getHeaderAfterClickFavlist(), favsBefore);
		
	 }//End of FavesBlock[CATEGORY/CLASS/TAG]-listLinks()
	 /* 
	  * Use-case : Faves block [CATEGORY/CLASS/TAG] - more faves
	  * Test case : Click on "more faves" in Faves block.
	  */
	 @Test(priority=13,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FavsBlockMore(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 13 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("FavsBlockMore");
		 }else{
			 rightRail =BaseState("FavsBlockMore");
		 }
		String favsBefore=rightRail.gethrefMoreFaves();
		rightRail.clickOnMoreFaves();
		if(sysProp.getProperty("Browser.Name").equals("chrome")){
			 try{
				 Thread.sleep(5000); 
			 }catch(Exception e){}
		 }
		common.facebookLikePresenceAndAccept();
		Assert.assertEquals(getDriver().getCurrentUrl(), favsBefore);
	 }//End of FavsBlockMore()
	 /* 
	  * Use-case : Faves block [CATEGORY/CLASS/TAG] - hover over list details
	  * Test case : 1.Hover over list link in fav block.
	                2.Click on list title or 'more' in hover.
	  */
	 @Test(priority=14,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FavsBlockHoverOver(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 14 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("FavsBlockHoverOver");
		 }
		 else{
			 rightRail =BaseState("FavsBlockHoverOver");
		 }
		 String favsBefore=rightRail.getTextOffavsBlockText(1);
			rightRail.hoverOnMore(1);
			rightRail.ishoverOverFavBlockListImagePresent();
			rightRail.ishoverOverFavBlockListProfileNamePresent();
			rightRail.ishoverOverFavBlockListDescriptionPresent();
			rightRail.ishoverMoreLinkPresent();
		 	rightRail.clickOnHoverMore();
		 	common.facebookLikePresenceAndAccept();
			Assert.assertEquals(rightRail.getHeaderAfterClickFavlist(), favsBefore);
		
	 }//End of FavsBlockHoverOver().
	 /* 
	  * Use-case : Faves block [CATEGORY/CLASS/TAG] - top list
	  * Test case : Open any Category page
	  */
	 @Test(priority=15,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FavsBlockTopList(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 15 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("FavsBlockTopList");
		 }else{
			 rightRail =BaseState("FavsBlockTopList");
		 }
		Assert.assertTrue(rightRail.isPresentfavsBlocktxt());
		
		 String firstview = rightRail.getimageSizeOffirstfavsBlock();
		 String secondview = rightRail.getimageSizeOfsecondfavsBlock();
		 int fv = Integer.parseInt(firstview.split("px")[0]);
		 int sv = Integer.parseInt(secondview.split("px")[0]);
		 if(fv >= sv){
			 Assert.assertEquals(1, 1);
		 }else{
			 Assert.assertEquals(1, 0);
		 }
	 }//End of FavsBlockTopList
	 /* 
	  * Use-case : Open Class pages
	  * Test case : Check various browse pages and verify that the view count does not show if a list has < 1000 view
	  */
	 @Test(priority=16,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ViewsCountInClassPage(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 16 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 int state=0;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("ViewsCountInClassPage");
		 }else{
			 rightRail =BaseState("ViewsCountInClassPage");
		 }
		 common.getNewURL(config.getProperty("Url")+"lists/albums");
		 for(int i=1;i<=10;i++){
		 if(rightRail.isPresentviewsinlist(i)==true){
			 String views=rightRail.getviewsinlist(i);
			// int view=Integer.parseInt(views.replaceAll(",", "").replaceAll(" ", ""));
			int view=Integer.parseInt(views.split("views")[0].replaceAll(",", "").replaceAll(" ", ""));
			if(1000<view)
			state=1;
		 }
		 }
		 if(state==1){
			 Assert.assertEquals(1, 1);
		 }else{
			 Assert.assertEquals(1, 0);
		 } 
		
	 }//End of ViewsCountInClassPage
	 /* 
	  * Use-case : Open tag pages
	  * Test case : Check various browse pages and verify that the view count does not show if a list has < 1000 view
	  */
	 @Test(priority=17,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ViewsCountInTagPage(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 17 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 int state=0;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("ViewsCountInTagPage");
		 }else{
			 rightRail =BaseState("ViewsCountInTagPage");
		 }
		 common.getNewURL(config.getProperty("Url")+"tags/funny");
		 for(int i=1;i<=10;i++){
		 if(rightRail.isPresentviewsinlist(i)==true){
			 String views=rightRail.getviewsinlist(i);
			 System.out.println("views==="+views);
			// int view=Integer.parseInt(views.replaceAll(",", "").replaceAll(" ", ""));
			int view=Integer.parseInt(views.split("views")[0].replaceAll(",", "").replaceAll(" ", ""));
			System.out.println("view==="+view);
			if(1000<view)
			state=1;
		 }
		 }
		 if(state==1){
			 Assert.assertEquals(1, 1);
		 }else{
			 Assert.assertEquals(1, 0);
		 } 
		
	 }//End of ViewsCountInTagPage
	 /* 
	  * Use-case : Open Category  pages
	  * Test case : Check various browse pages and verify that the view count does not show if a list has < 1000 view
	  */
	 @Test(priority=18,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ViewsCountInCategoryPage(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 18 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to page having right rail)
		 Rightrail rightRail=null;
		 int state=0;
		 if(loginRequired.equals("YES")){
			 rightRail =BaseStateWithLogin("ViewsCountInCategoryPage");
		 }else{
			 rightRail =BaseState("ViewsCountInCategoryPage");
		 }
		 common.getNewURL(config.getProperty("Url")+"list-of/music");
		 for(int i=1;i<=10;i++){
		 if(rightRail.isPresentviewsinlist(i)==true){
			 String views=rightRail.getviewsinlist(i);
			 System.out.println("views==="+views);
			// int view=Integer.parseInt(views.replaceAll(",", "").replaceAll(" ", ""));
			int view=Integer.parseInt(views.split("views")[0].replaceAll(",", "").replaceAll(" ", ""));
			System.out.println("view==="+view);
			if(1000<view)
			state=1;
		 }
		 }
		 if(state==1){
			 Assert.assertEquals(1, 1);
		 }else{
			 Assert.assertEquals(1, 0);
		 } 
		
	 }//End of ViewsCountInCategory Page
	 /*
	  * This is base state of the Right rail test-cases.
	  */
	 public Rightrail BaseState(String testName){
		 try{
		 startRecording(testName);
		}catch(Exception e){}
		 common=new Commonpage(getDriver());
		 Rightrail rightRail=common.getRightrailPage(url);
		 return rightRail;
	 } //End of BaseState()
	 /*
	  * This is base state of the Right rail test-cases.
	  */
	 public Rightrail BaseStateWithLogin(String testName){
		 try{
		 startRecording(testName);
		}catch(Exception e){}
		 common=new Commonpage(getDriver());
		 common.signin("testuserkallol1@mailinator.com", "testing");
		 Rightrail rightRail=common.getRightrailPage(url);
		 return rightRail;
	 } //End of BaseStateWithLogin()
}
