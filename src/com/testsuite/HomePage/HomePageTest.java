package com.testsuite.HomePage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.paeobjects.home.Home;
import com.pageobjects.nodepage.Nodepage;
import com.selenium.SafeActions;

public class HomePageTest extends BaseSetup{
	ConfigManager urls=new ConfigManager("PreProduction");
	ConfigManager sysProp=new ConfigManager("Sys");
	 String url=config.getProperty("Url")+urls.getProperty("homepage"); 
	 Commonpage common;
	/*   // not open functionlity change
//	 /* 
//	  * Use-case : Live Ranking.
//	  * Test case : Go to home page.On hovering on the live ranking links their colour should change.
//	  */
//	 @Test(priority=1,dataProviderClass = DataProviders.class, dataProvider = "Login")
//	 public void LiveRanking(String loginRequired){
//		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
//		 //Base state. (Navigate to node page)
//		 Home homePage=null;
//		 if(loginRequired.equals("YES")){
//			 homePage =BaseStateWithLogin("LiveRanking");
//		 }else{
//			 homePage =BaseState("LiveRanking");
//		 }
//		 homePage.hoverOverLiveRanking(2);
////		 try{
////			 Thread.sleep(25000);
////		 }catch(Exception e){}
////		 SafeActions s=new SafeActions(getDriver());
////		 s.waitForPageToLoad(30);
//		 
//		 Assert.assertEquals("rgba(8, 108, 184, 1)",homePage.getColorOfLiveRanking(2));
//		 
//	 }//End of LiveRanking()*/ 
	
	 /* 
	  * Use-case : Film Section
	  * Test case : Go to Film Header and check  5 section is present and click respected link..
	  */
	 @Test(priority=2,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FilmSectionPresent(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("FilmSectionPresent");
		 }else{
			 homePage =BaseState("FilmSectionPresent");
		 }
		 
		 for(int i=1;i<=5;i++){
				Assert.assertTrue(homePage.isImagePresentInFilmSection(i));
		 }
		 boolean votetrue=false;
		 String beforetxt=" ";
// checking for vote 
		    if(homePage.isVotePresentInFilmSection(1)==true){
			// System.out.println("com in thiss");
		   Assert.assertTrue(homePage.isVotePresentInFilmSection(1));
	       beforetxt=homePage.getTextofvote(1);
	      // System.out.println("beforetxt===="+beforetxt);
	       votetrue=true;
		 }

         String before=homePage.gethrefOfFilmItem(1);
         
         try{
			 Thread.sleep(10000);
		 }catch(Exception e){}
         homePage.clickOnFilmSectionHeader(1);
         String Afterurl = getDriver().getCurrentUrl();
 		if (Afterurl.contains(before)) {
 			Assert.assertEquals(1, 1);
 		} else {
 			Assert.assertEquals(1, 0);
 		}
//	     String after=getDriver().getCurrentUrl();
//	     Assert.assertEquals(before, after);
	     if(votetrue==true)
	     {
	    	    String aftertxt=homePage.getTextofvoteafterclick();
	    	   // System.out.println("aftertxt===="+aftertxt);
//	            String[] txt = aftertxt.split(",");
//	            aftertxt="";
//	            for (int i=0;i<txt.length;i++){
//	            aftertxt = aftertxt+txt[i];
//	            }
	            Assert.assertEquals(beforetxt, aftertxt);
	     }
	 }//End FilmSectionPresent
	 /* 
	  * Use-case : Film Next Button
	  * Test case : Go to Film Header and click next button
	  */
	 @Test(priority=3,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FilmNextButton(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("FilmNextButton");
		 }else{
			 homePage =BaseState("FilmNextButton");
		 }
//		 try{
//			 Thread.sleep(20000);
//		 }catch(Exception e){}
		 homePage.clickonnextbuttoninfilm(); 
		 Assert.assertTrue(homePage.isPresentFilmHeaderaferclickonmore());
	 }//End FilmNextButton
//	 
	 /* 
	  * Use-case : Film Section in more
	  * Test case : Go to Film Header and click more to open realtive link
	  */
	 @Test(priority=4,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FilmSectioninMore(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("FilmSectioninMore");
		 }else{
			 homePage =BaseState("FilmSectioninMore");
		 }
        String before=homePage.gethrefOfFilmItem(1);
     // checking for vote 
        try{
			 Thread.sleep(20000);
		 }catch(Exception e){}
        homePage.clickonFilminmore(1);
        String after=getDriver().getCurrentUrl();
        String[] substring=after.split("\\?");
        Assert.assertEquals(before, substring[0]);
	 }//End Film Section in more
	 /* 
	  * Use-case : Film Section in MoreListaboutfilm
	  * Test case : Go to Film Header and click more to open relative link
	  */
	 @Test(priority=5,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void MoreListaboutfilm(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("MoreListaboutfilm");
		 }else{
			 homePage =BaseState("MoreListaboutfilm");
		 }
		 try{
			 Thread.sleep(3000);
		 }catch(Exception e){}
		 homePage.clickonmorelistaboutfilm();
		 try{
			 Thread.sleep(3000);
		 }catch(Exception e){}
		 Assert.assertTrue(homePage.isPresentFilmHeaderaferclickonmore());
	 }//End Film Section in MoreListaboutfilm	
//	/*  //  not open
//	 /* 
//	  * Use-case : Live Ranking Link.
//	  * Test case : Go to home page.On clicking on the live ranking links it should take to the corresponding page.
//	  */
//	 @Test(priority=6,dataProviderClass = DataProviders.class, dataProvider = "Login")
//	 public void LiveRankingLink(String loginRequired){
//		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
//		 //Base state. (Navigate to node page)
//		 Home homePage=null;
//		 if(loginRequired.equals("YES")){
//			 homePage =BaseStateWithLogin("LiveRankingLink");
//		 }else{
//			 homePage =BaseState("LiveRankingLink");
//		 }
//		 try{
//			 Thread.sleep(3000);
//		 }catch(Exception e){}
//		 homePage.hoverOverLiveRanking(2);
//		 try{
//			 Thread.sleep(3000);
//		 }catch(Exception e){}
//		 String linkTxtBefore=homePage.getTextOfLiveRankingLink(2);
//		 homePage.clickOnLiveRankingLink(2);
//		 try{
//			 Thread.sleep(3000);
//		 }catch(Exception e){}
//		 String linkTxtAfter=homePage.getTextHeaderOfNextPageLiveRanking();
//		 Assert.assertEquals(linkTxtAfter,linkTxtBefore);
//	 }//End of LiveRankingLink()*/
	 /* 
	  * Use-case : Slider.
	  * Test case : Go to home page.Count the number of images.
	  				On clicking on the image in slider, it should take to the corresponding image page.
	  */
	 @Test(priority=7,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void Slider(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("Slider");
		 }else{
			 homePage =BaseState("Slider");
		 }
		 for(int i=1;i<=5;i++){			
			 Assert.assertTrue(homePage.isholdingSliderImagePresent(i));
		 }
		 try{
			 Thread.sleep(8000);
		 }catch(Exception e){}
		 homePage.clickOnholdingSliderImage(3);
		 try{
			 Thread.sleep(7000);
		 }catch(Exception e){}
		 String befTxt=homePage.getHrefOfSliderImage(3);
		 homePage.clickOnSliderImage(3);
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 String Afterurl = getDriver().getCurrentUrl();
			if (Afterurl.contains(befTxt)) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}
		// String aftTxt=homePage.getCurrentURL();
//		 String after=getDriver().getCurrentUrl();
//	     String[] substring=after.split("\\?");
//	     Assert.assertEquals(befTxt, substring[0]);
		// Assert.assertEquals(aftTxt, befTxt);
			
	 }//End of Slider()
	 /* 
	  * Use-case : Ranking Right Now block.
	  * Test case : Go to home page. Count the number of sections in ranking right now block. On clicking on any of the section, corresponding link should open.
	  */
	 @Test(priority=8,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void RankingRightNow(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("RankingRightNow");
		 }else{
			 homePage =BaseState("RankingRightNow");
		 }
		 for(int i=1;i<=5;i++){
			 homePage.isrankingRightNowSectionPresent(i);
		 }
		 String befTxt=homePage.getHrefOfrankingRightNowSection(1);
		 boolean votetrue=false;
		 String beforetxt=" ";
// checking for vote 
		 if(homePage.isVotePresentInRightNow(1)==true){
			 Assert.assertTrue(homePage.isVotePresentInRightNow(1));
			 beforetxt=homePage.getTextofvoteRightNow(1);
			 
	         votetrue=true;
		 }
		 try{
			 Thread.sleep(2000);
		    }catch(Exception e){}
		    homePage.clickOnrankingRightNowSection(1);
		 try{
		 Thread.sleep(3000);
	    }catch(Exception e){}
		 String Afterurl = getDriver().getCurrentUrl();
		 if (Afterurl.contains(befTxt)) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}
//		 String aftTxt=homePage.getCurrentURL();
//		 Assert.assertEquals(aftTxt, befTxt);
		 
		 if(votetrue==true)
	     {
//			  String[] txt1 = beforetxt.split(",");
//		        beforetxt="";
//		        for (int i=0;i<txt1.length;i++){
//		        	beforetxt = beforetxt+txt1[i];
//		        }
			    String aftertxt=homePage.getTextofvoteafterclick();
//		        String[] txt = aftertxt.split(",");
//		        aftertxt="";
//		        for (int i=0;i<txt.length;i++){
//		        aftertxt = aftertxt+txt[i];
//		        }
	            Assert.assertEquals(beforetxt, aftertxt);
	     }
	 }//End of RankingRightNow()
	 /* 
	  * Use-case : Popular on FaceBook block facebook link.
	  * Test case : Go to home page. Go to Popular on FaceBook block. On clicking on facebook like link, corresponding link should open.
	  */
	 @Test(priority=10,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PopularOnFacebookLikeLink(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 10 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PopularOnFacebookLikeLink");
		 }else{
			 homePage =BaseState("PopularOnFacebookLikeLink");
		 }
		//Click on facebook and check whether right page is opening or not.	
		 try{
				Thread.sleep(40000);
				}catch(Exception e){}
//		 SafeActions s=new SafeActions(getDriver());
//		 s.waitForPageToLoad(30);
		 		homePage.clickOnfacebook();
//		 		try{
//		 			Thread.sleep(5000);
//		 		}catch(Exception e){}
		 		homePage.clickOnfacebook();
				//String title = homePage.switchToWindowAndGetTitle();
				//Assert.assertEquals("Facebook", title);
		 		common.facebookLogin("salmankhantc", "Dehradun1");
				getDriver().close();
				homePage.switchToParentWindow();
	 }//End of PopularOnFacebookLikeLink()
	 /* 
	  * Use-case : Most Tweeted block.
	  * Test case : Go to home page. Count the number of sections in Most Tweeted block. On clicking on any of the section, corresponding link should open.
	  */
	 @Test(priority=11,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void MostTweeted(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 11 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("MostTweeted");
		 }else{
			 homePage =BaseState("MostTweeted");
		 }
		 for(int i=1;i<=5;i++){
			 Assert.assertTrue(homePage.isMostTweetedPresent(i));
		 }	
		 boolean votetrue=false;
		 String beforetxt=" ";
// checking for vote 
		 if(homePage.isVotePresentInMostTweeted(1)==true){
			 Assert.assertTrue(homePage.isVotePresentInMostTweeted(1));
			 beforetxt=homePage.getTextofvoteMostTweeted(1);
	         votetrue=true;
		 }
		 String befTxt=homePage.getHrefOfMostTweetedSection(1);
		 homePage.clickOnMostTweetedSection(1);
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 String aftTxt=homePage.geturlOfNextPageMostTweetedSection();
		 Assert.assertEquals(aftTxt, befTxt);
		 if(votetrue==true)
	     {
	    	    //System.out.println("isVotePresentInPeople===="+homePage.isVotePresentInPeople(1));
			    String aftertxt=homePage.getTextofvoteafterclick();
//		        String[] txt = aftertxt.split(",");
//		        aftertxt="";
//		        for (int i=0;i<txt.length;i++){
//		        aftertxt = aftertxt+txt[i];
//		        }
	            Assert.assertEquals(beforetxt, aftertxt);
	     }
	 }//End of MostTweeted()
	 /* 
	  * Use-case : Recently reranked block.
	  * Test case : Go to home page. Count the number of sections in Recently reranked block. On clicking on any of the section, corresponding link should open.
	  */
	 @Test(priority=12,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void RecentlyReranked(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("RecentlyReranked");
		 }else{
			 homePage =BaseState("RecentlyReranked");
		 }
		 for(int i=1;i<=5;i++){
			 homePage.isRecentlyRerankedPresent(i);
		 }
		 boolean votetrue=false;
		 String beforetxt=" ";
		// checking for vote 
		     if(homePage.isVotePresentInMostTweeted(1)==true){
			 Assert.assertTrue(homePage.isVotePresentInRecentlyReranked(1));
			 beforetxt=homePage.getTextofvoteRecentlyReranked(1);
	         votetrue=true;
		 }
		 String befTxt=homePage.getHrefOfRecentlyRerankedSection(1);
		 homePage.clickOnRecentlyRerankedSection(1);
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 String aftTxt=homePage.geturlOfNextPageRecentlyRerankedSection();
		 Assert.assertEquals(aftTxt, befTxt);
		 if(votetrue==true)
	     {
	    	    //System.out.println("isVotePresentInPeople===="+homePage.isVotePresentInPeople(1));
			    String aftertxt=homePage.getTextofvoteafterclick();//getTextofvoteafterclick
//		        String[] txt = aftertxt.split(",");
//		        aftertxt="";
//		        for (int i=0;i<txt.length;i++){
//		        aftertxt = aftertxt+txt[i];
//		        }
	            Assert.assertEquals(beforetxt, aftertxt);
	     }
	 }//End of RecentlyReranked()
	 /* 
	  * Use-case : Recently reranked block arrow.
	  * Test case : Go to home page.On clicking on arrow, corresponding link should open.
	  */
	 @Test(priority=13,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void RecentlyRerankedArrow(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 13 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("RecentlyRerankedArrow");
		 }else{
			 homePage =BaseState("RecentlyRerankedArrow");
		 }
		
		    homePage.clickOnrecentlyRerankedArrow();
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 
		 Assert.assertTrue(homePage.isrecentlyRerankedNextPagePresent());
	 }//End of RecentlyRerankedArrow()
	 /* 
	  * Use-case : Recently reranked block profile link.
	  * Test case : Go to home page. On clicking on any of the profile link in any section, corresponding link should open.
	  */
	 @Test(priority=14,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void RecentlyRerankedProfileLink(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 14 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("RecentlyRerankedProfileLink");
		 }else{
			 homePage =BaseState("RecentlyRerankedProfileLink");
		 }
		 
		 String befTxt=homePage.getHrefOfRecentlyRerankedSectionProfile(1,2);
		 homePage.clickOnrecentlyRerankedProfileLink(1,2);
		 try{
			 Thread.sleep(10000);
		 }catch(Exception e){}
		 String aftTxt=homePage.geturlOfNextPageRecentlyRerankedSection();
		 String substring[]=befTxt.split("\\?");
		 Assert.assertEquals(substring[0], aftTxt);
	 }//End of recentlyRerankedProfileLink()
	 /* 
	  * Use-case : TV Section
	  * Test case : Go to TV Header and check  5 section is present and click respected link..
	  */
	 @Test(priority=15,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void TVSectionPresent(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 15 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("TVSectionPresent");
		 }else{
			 homePage =BaseState("TVSectionPresent");
		 }
		 for(int i=1;i<=5;i++){
		 Assert.assertTrue(homePage.isImagePresentInTVSection(i));
		 }
		 boolean votetrue=false;
		 String beforetxt=" ";
        // checking for vote 
		 if(homePage.isVotePresentInTv(1)==true){
		   Assert.assertTrue(homePage.isVotePresentInTv(1));
	       beforetxt=homePage.getTextofvoteTv(1);
	       votetrue=true;
		 } 
        String before=homePage.gethrefOfTVItem(1);
        try{
 		   Thread.sleep(2000);
 		}catch(Exception e){}
        homePage.clickOnTVSectionHeader(1);
        String Afterurl = getDriver().getCurrentUrl();
		if (Afterurl.contains(before)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
	 //String aftTxt=homePage.geturlOfNextPageRecentlyRerankedSection();
	 //String substring[]=before.split("\\?");
	 //Assert.assertEquals(substring[0], aftTxt);
	 if(votetrue==true)
     {
		 try{
	 		   Thread.sleep(2000);
	 		}catch(Exception e){}
            String aftertxt=homePage.getTextofvoteafterclick();
//            String[] txt = aftertxt.split(",");
//            aftertxt="";
//            for (int i=0;i<txt.length;i++){
//            aftertxt = aftertxt+txt[i];
//            }
            Assert.assertEquals(beforetxt, aftertxt);
     }
	 }//End TVSectionPresent 
	 /* 
	  * Test case : Go to TV Header and click next button
	  */
	 @Test(priority=16,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void TVNextButton(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 16 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("TVNextButton");
		 }else{
			 homePage =BaseState("TVNextButton");
		 }
		 homePage.clickonnextbuttoninTV(); 
		 Assert.assertTrue(homePage.isPresentTVHeaderaferclickonmore());
	 }//End TVNextButton
	 /* 
	  * Use-case : TV Section in more
	  * Test case : Go to TV section and click TVSectioninMore to open relative link
	  */
	 @Test(priority=17,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void TVSectioninMore(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 17 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("TVSectioninMore");
		 }else{
			 homePage =BaseState("TVSectioninMore");
		 }
		 String before=homePage.gethrefOfTVItem(1);
         homePage.clickonTVinmore(1);
         String Afterurl = getDriver().getCurrentUrl();
 		if (Afterurl.contains(before)) {
 			Assert.assertEquals(1, 1);
 		} else {
 			Assert.assertEquals(1, 0);
 		}
         //String afterurl=getDriver().getCurrentUrl();
		 //Assert.assertEquals(before,afterurl);
	 }//End TVSectioninMore	 
	 /* 
	  * Use-case : TV Section in MoreListaboutTV
	  * Test case : Go to TV Header and click MoreListaboutTV to open relative link
	  */
	 @Test(priority=18,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void MoreListaboutTV(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 18 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("MoreListaboutTV");
		 }else{
			 homePage =BaseState("MoreListaboutTV");
		 }
		 homePage.clickonmorelistaboutTV();
		 Assert.assertTrue(homePage.isPresentTVHeaderaferclickonmore());
	 }//End MoreListaboutTV 
	 /* 
	  * Use-case : Comics Section
	  * Test case : Go to Comics Header and check  5 section is present and click respected link..
	  */
	 @Test(priority=19,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ComicsSectionPresent(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 19 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("ComicsSectionPresent");
		 }else{
			 homePage =BaseState("ComicsSectionPresent");
		 }
		
		 for(int i=1;i<=5;i++){
				Assert.assertTrue(homePage.isImagePresentInComicsSection(i));
		 }
		 boolean votetrue=false;
		 String beforetxt=" ";
        // checking for vote 
		 if(homePage.isVotePresentIncomics(1)==true){
		   Assert.assertTrue(homePage.isVotePresentIncomics(1));
	       beforetxt=homePage.getTextofvotecomics(1);
	       votetrue=true;
		 } 
         String before=homePage.gethrefOfComicsItem(1);
         homePage.clickOnComicsSectionHeader(1);
         String Afterurl = getDriver().getCurrentUrl();
 		if (Afterurl.contains(before)) {
 			Assert.assertEquals(1, 1);
 		} else {
 			Assert.assertEquals(1, 0);
 		}
//	     String after=getDriver().getCurrentUrl();
//	     String[] substring=after.split("\\?");
//	     Assert.assertEquals(before, substring[0]);
		 if(votetrue==true)
	     {
	            String aftertxt=homePage.getTextofvoteafterclick();
//	            String[] txt = aftertxt.split(",");
//	            aftertxt="";
//	            for (int i=0;i<txt.length;i++){
//	            aftertxt = aftertxt+txt[i];
//	            }
	            Assert.assertEquals(beforetxt, aftertxt);
	     }
	 }//End ComicsSectionPresent 
	 /* 
	  * Use-case : Comics Next Button
	  * Test case : Go to Comics Header and click next button
	  */
	 @Test(priority=20,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ComicsNextButton(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 20 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("ComicsNextButton");
		 }else{
			 homePage =BaseState("ComicsNextButton");
		 }
		 homePage.clickonnextbuttoninComics(); 
		 Assert.assertTrue(homePage.isPresentComicsHeaderaferclickonmore());
	 }//End TVNextButton
	 /* 
	  * Use-case : Comics Section in more
	  * Test case : Go to Comics section and click Comics SectioninMore to open relative link
	  */
	 @Test(priority=21,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ComicsSectioninMore(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 21 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("ComicsSectioninMore");
		 }else{
			 homePage =BaseState("ComicsSectioninMore");
		 }
		 String before=homePage.gethrefOfComicsItem(1);
         homePage.clickonComicsinmore(1);
         String Afterurl = getDriver().getCurrentUrl();
 		if (Afterurl.contains(before)) {
 			Assert.assertEquals(1, 1);
 		} else {
 			Assert.assertEquals(1, 0);
 		}
//	 String after=getDriver().getCurrentUrl();
//     String[] substring=after.split("\\?");
//     Assert.assertEquals(before, substring[0]);
	 }//End ComicsSectioninMore
	 /* 
	  * Use-case : Comics Section in MoreListaboutcomics
	  * Test case : Go to Comics Header and click MoreListaboutComics to open relative link
	  */
	 @Test(priority=22,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void MoreListaboutComics(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 22 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("MoreListaboutComics");
		 }else{
			 homePage =BaseState("MoreListaboutComics");
		 }
		 homePage.clickonmorelistaboutComics();
		 try{
		 Thread.sleep(2000);
		 }catch(Exception e){}
		 Assert.assertTrue(homePage.isPresentComicsHeaderaferclickonmore());
	 }//End MoreListaboutComics 
	 /* 
	  * Use-case : People Section
	  * Test case : Go to People Header and check  5 section is present and click respected link..
	  */
	 @Test(priority=23,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PeopleSectionPresent(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 23 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PeopleSectionPresent");
		 }else{
			 homePage =BaseState("PeopleSectionPresent");
		 }
		
		 for(int i=1;i<=5;i++){
			Assert.assertTrue(homePage.isImagePresentInPeopleSection(i));
		 }
		// checking for vote 
				 boolean votetrue=false;
	           String beforetxt=" ";
		  if(homePage.isVotePresentInPeople(1)==true){
		   Assert.assertTrue(homePage.isVotePresentInPeople(1));
	       beforetxt=homePage.getTextofvotePeople(1);
	       votetrue=true;
		 }
            String before=homePage.gethrefOfPeopleItem(1);
            homePage.clickOnPeopleSectionHeader(1);
      try{
 		 Thread.sleep(2000);
 		 }catch(Exception e){}
      String Afterurl = getDriver().getCurrentUrl();
		if (Afterurl.contains(before)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
//	     String after=getDriver().getCurrentUrl();
//	     String[] substring=after.split("\\?");
//	     Assert.assertEquals(before, substring[0]);
	     // checking vote
	     if(votetrue==true)
	     {
	    	    //System.out.println("isVotePresentInPeople===="+homePage.isVotePresentInPeople(1));
	            String aftertxt=homePage.getTextofvoteafterclick();
//	            String[] txt = aftertxt.split(",");
//	            aftertxt="";
//	            for (int i=0;i<txt.length;i++){
//	            aftertxt = aftertxt+txt[i];
//	            }
	            Assert.assertEquals(beforetxt, aftertxt);
	     }
	 }//End PeopleSectionPresent 
	 /* 
	  * Use-case : People Next Button
	  * Test case : Go to TV Header and People next button
	  */
	 @Test(priority=24,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PeopleNextButton(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 24 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PeopleNextButton");
		 }else{
			 homePage =BaseState("PeopleNextButton");
		 }
		 homePage.clickonnextbuttoninPeople(); 
		 
		 Assert.assertTrue(homePage.isPresentPeopleHeaderaferclickonmore());
	 }//End PeopleNextButton
	 /* 
	  * Use-case :  People Section in more
	  * Test case : Go to People section and click People SectioninMore to open relative link
	  */
	 @Test(priority=25,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PeopleSectioninMore(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 25 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PeopleSectioninMore");
		 }else{
			 homePage =BaseState("PeopleSectioninMore");
		 }
		 
		 String before=homePage.gethrefOfPeopleItem(1);
         homePage.clickonPeopleinmore(1);
         String Afterurl = getDriver().getCurrentUrl();
 		if (Afterurl.contains(before)) {
 			Assert.assertEquals(1, 1);
 		} else {
 			Assert.assertEquals(1, 0);
 		}
//         String afterurl=getDriver().getCurrentUrl();
//		 Assert.assertEquals(before,afterurl);
	 }//End PeopleSectioninMore
	 /* 
	  * Use-case : Popular on FaceBook block.
	  * Test case : Go to home page. Count the number of sections in Popular on FaceBook block. On clicking on any of the section, corresponding link should open.
	  */
	 @Test(priority=26,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PopularOnFacebook(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 26 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PopularOnFacebook");
		 }else{
			 homePage =BaseState("PopularOnFacebook");
		 }
		 for(int i=1;i<=5;i++){
			 Assert.assertTrue(homePage.isPopularOnFacebookPresent(i));
		 }	
		 boolean votetrue=false;
         String beforetxt=" ";
	       if(homePage.isVotePresentInPeople(1)==true){
	          Assert.assertTrue(homePage.isVotePresentInPopularon(1));
              beforetxt=homePage.getTextofvotePopularon(1);
              votetrue=true;
	      }
		 String befTxt=homePage.getHrefOfPopularOnFacebookSection(1);
		 homePage.clickOnPopularOnFacebookSection(1);
		 String aftTxt=homePage.geturlOfNextPagePopularOnFacebookSection();
		 Assert.assertEquals(aftTxt, befTxt);
		 if(votetrue==true)
		     {
		            String aftertxt=homePage.getTextofvoteafterclick();
//		            String[] txt = aftertxt.split(",");
//		            aftertxt="";
//		            for (int i=0;i<txt.length;i++){
//		            aftertxt = aftertxt+txt[i];
//		            }
		            Assert.assertEquals(beforetxt, aftertxt);
		     }
	 }//End of PopularOnFaceBookBlock()
	 /* 
	  * Use-case : Most Tweeted block tweeter follow link.
	  * Test case : Go to home page. Count the number of sections in Most Tweeted block. On clicking on any of the section, corresponding link should open.
	  */
	 @Test(priority=27,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void MostTweetedFollowLink(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 27 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("MostTweetedFollowLink");
		 }else{
			 homePage =BaseState("MostTweetedFollowLink");
		 }
		//Click on twitter and check whether right page is opening or not.	
		 try{
				Thread.sleep(5000);
				}catch(Exception e){}
		 homePage.clickOnTwitter();
			try{
				Thread.sleep(7000);
				}catch(Exception e){}
			String title = homePage.switchToWindowAndGetTitle();
			Assert.assertEquals("Ranker.com (@Ranker) on Twitter", title);
			getDriver().close();
			homePage.switchToParentWindow();
	 }//End of MostTweetedFollowLink()
////	 
	 /* 
	  * Use-case : Ranker TV block arrow.
	  * Test case : Go to home page.On clicking on arrow in ranker TV block, corresponding link should open.
	  */
	 @Test(priority=28,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void RankerTvArrow(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 28 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("RankerTvArrow");
		 }else{
			 homePage =BaseState("RankerTvArrow");
		 }
		 String href=homePage.gethrefOfrankerTvArrow();
		 homePage.clickOnrankerTvArrow();
		 String Afterurl = getDriver().getCurrentUrl();
			if (Afterurl.contains(href)) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}
//		 String url=getDriver().getCurrentUrl();
//		 Assert.assertEquals(url,href);
	 }//End of RankerTvArrow()
	 /* 
	  * Use-case : Ranker TV block.
	  * Test case : Go to home page. Check the presence of total sections in the ranker TV block. On clicking on any section, corresponding page should open.
	  */
	 @Test(priority=29,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void RankerTvBlock(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 29 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("RankerTvBlock");
		 }else{
			 homePage =BaseState("RankerTvBlock");
		 }
		 for(int i=1;i<=4;i++){
			 homePage.isrankerTvBlockPresent(i);
		 }
		 boolean votetrue=false;
         String beforetxt=" ";
		 if(homePage.isVotePresentInrankertv(1)==true){
			   Assert.assertTrue(homePage.isVotePresentInrankertv(1));
		       beforetxt=homePage.getTextofvoterankertv(1);
		       votetrue=true;
			   }
		 String href=homePage.getHrefOfrankerTvBlock(1);
		 homePage.clickOnRankerTvVideo(1);
		 String Afterurl = getDriver().getCurrentUrl();
			if (Afterurl.contains(href)) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}
//         String url=homePage.getCurrentURL();
//         Assert.assertEquals(url,href);
         if(votetrue==true)
	     {
	            String aftertxt=homePage.getTextofvoteafterclick();
//	            String[] txt = aftertxt.split(",");
//	            aftertxt="";
//	            for (int i=0;i<txt.length;i++){
//	            aftertxt = aftertxt+txt[i];
//	            }
	            Assert.assertEquals(beforetxt, aftertxt);
	     }
	 }//End of RankerTvBlock()
	 /* 
	  * Use-case : More Ranker TV .
	  * Test case : Go to home page. On clicking on more ranker TV link in Ranker TV block, corresponding page should open.
	  */
	 @Test(priority=30,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void MoreRankerTv(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 30 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("MoreRankerTv");
		 }else{
			 homePage =BaseState("MoreRankerTv");
		 }
		 String href=homePage.gethrefOfrankerTvArrow();
		 homePage.clickOnmoreRankerTv();
		 String Afterurl = getDriver().getCurrentUrl();
			if (Afterurl.contains(href)) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}
//		 String url=getDriver().getCurrentUrl();
//		 Assert.assertEquals(url,href);
	 }//End of MoreRankerTv()

	 /* 
	  * Use-case : Ranker Tv YouTube.
	  * Test case : Go to home page. Go to Ranker TV block. On clicking on youTube button, corresponding link should open.
	  */
	 @Test(priority=31,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void YouTubeButton(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 31 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("YouTubeButton");
		 }else{
			 homePage =BaseState("YouTubeButton");
		 }
		//Click on youtube and check whether right page is opening or not.	
		 try{
				Thread.sleep(5000);
				}catch(Exception e){}
		 homePage.clickOnYouTube();
		 		try{
					Thread.sleep(5000);
					}catch(Exception e){}
				String title = homePage.switchToWindowAndGetTitle();
				Assert.assertEquals("YouTube", title);
				getDriver().close();
				homePage.switchToParentWindow();
	 }//End of YouTubeButton()
	 /* 
	  * Use-case : People Section in MoreListaboutPeople
	  * Test case : Go to People Header and click MoreListaboutComics to open relative link
	  */
	 @Test(priority=32,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void MoreListaboutPeople(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 32 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("MoreListaboutPeople");
		 }else{
			 homePage =BaseState("MoreListaboutPeople");
		 }
		 homePage.clickonmorelistaboutPepole();
		 Assert.assertTrue(homePage.isPresentPeopleHeaderaferclickonmore());
	 }//End MoreListaboutPeople 
//	 /* 
//	  * Use-case : Book Section
//	  * Test case : Go to Book Header and check  5 section is present and click respected link..
//	  */
//	 @Test(priority=33,dataProviderClass = DataProviders.class, dataProvider = "Login")
//	 public void QA_BookSectionPresent(String loginRequired){
//		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 33 !!!!!!!!!!!!!!!!!!!!!!!");
//		 //Base state. (Navigate to node page)
//		if(url.contains("stage")){
//		 Home homePage=null;
//		 if(loginRequired.equals("YES")){
//			 homePage =BaseStateWithLogin("QA_BookSectionPresent");
//		 }else{
//			 homePage =BaseState("QA_BookSectionPresent");
//		 }
//		 for(int i=1;i<=5;i++){
//				Assert.assertTrue(homePage.isImagePresentInBookSection(i));
//		 }
//		     boolean votetrue=false;
//             String beforetxt=" ";
//		     if(homePage.isVotePresentInbooks(1)==true){
//			   Assert.assertTrue(homePage.isVotePresentInbooks(1));
//		       beforetxt=homePage.getTextofvotebooks(1);
//		       votetrue=true;
//			   } 
//     String before=homePage.gethrefOfBookItem(1);
//     homePage.clickOnBookSectionHeader(1);
//     try{
//	 Thread.sleep(5000);
//	 }catch(Exception e){}
//     String Afterurl = getDriver().getCurrentUrl();
//		if (Afterurl.contains(before)) {
//			Assert.assertEquals(1, 1);
//		} else {
//			Assert.assertEquals(1, 0);
//		}
////	     String url=getDriver().getCurrentUrl();
////	     Assert.assertEquals(before, url);
//	     if(votetrue==true)
//		     {
//		            String aftertxt=homePage.getTextofvoteafterclick();
//		            String[] txt = aftertxt.split(",");
//		            aftertxt="";
//		            for (int i=0;i<txt.length;i++){
//		            aftertxt = aftertxt+txt[i];
//		            }
//		            Assert.assertEquals(beforetxt, aftertxt);
//		     }
//		}
//	 }//End BookSectionPresent 
//	 /* 
//	  * Use-case : Book Next Button
//	  * Test case : Go to Book Header and click next button
//	  */
//	 @Test(priority=34,dataProviderClass = DataProviders.class, dataProvider = "Login")
//	 public void QA_BookNextButton(String loginRequired){
//		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 34 !!!!!!!!!!!!!!!!!!!!!!!");
//		 //Base state. (Navigate to node page)
//		 if(url.contains("stage")){
//		 Home homePage=null;
//		 if(loginRequired.equals("YES")){
//			 homePage =BaseStateWithLogin("QA_BookNextButton");
//		 }else{
//			 homePage =BaseState("QA_BookNextButton");
//		 }
//		 homePage.clickonnextbuttoninBook();
//		 Assert.assertTrue(homePage.isPresentBookHeaderaferclickonmore());
//		 }
//	 }//End BookNextButton
//	 /* 
//	  * Use-case : Book Section in more
//	  * Test case : Go to People section and click People SectioninMore to open relative link
//	  */
//	 @Test(priority=35,dataProviderClass = DataProviders.class, dataProvider = "Login")
//	 public void QA_BookSectioninMore(String loginRequired){
//		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 35 !!!!!!!!!!!!!!!!!!!!!!!");
//		 //Base state. (Navigate to node page)
//		 if(url.contains("stage")){
//		 Home homePage=null;
//		 if(loginRequired.equals("YES")){
//			 homePage =BaseStateWithLogin("QA_BookSectioninMore");
//		 }else{
//			 homePage =BaseState("QA_BookSectioninMore");
//		 }
//		 String before=homePage.gethrefOfBookItem(1);
//        homePage.clickonBookinmore(1);
//        try{
//       	 Thread.sleep(2000);
//       	 }catch(Exception e){}
//        String Afterurl = getDriver().getCurrentUrl();
//		if (Afterurl.contains(before)) {
//			Assert.assertEquals(1, 1);
//		} else {
//			Assert.assertEquals(1, 0);
//		}
////       String afterurl=getDriver().getCurrentUrl();
////		 Assert.assertEquals(before,afterurl);
//		 }
//	 }//End BookSectioninMore
//	 
//	 /* 
//	  * Use-case : Book Section in MoreListaboutBook
//	  * Test case : Go to People Header and click MoreListaboutBook to open relative link
//	  */
//	 @Test(priority=36,dataProviderClass = DataProviders.class, dataProvider = "Login")
//	 public void QA_MoreListaboutBook(String loginRequired){
//		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 36 !!!!!!!!!!!!!!!!!!!!!!!");
//		 //Base state. (Navigate to node page)
//		 if(url.contains("stage")){
//		 Home homePage=null;
//		 if(loginRequired.equals("YES")){
//			 homePage =BaseStateWithLogin("QA_MoreListaboutBook");
//		 }else{
//			 homePage =BaseState("QA_MoreListaboutBook");
//		 }
//		 homePage.clickonmorelistaboutBook();
//	 try{
//		 Thread.sleep(2000);
//		 }catch(Exception e){}
//		 Assert.assertTrue(homePage.isPresentBookHeaderaferclickonmore());
//		 }
//	 }//End MoreListaboutBook
	 /* 
	  * Use-case : Recent List
	  * Test case : Go to Recent List and check 4 section is present and click respected link..
	  */
	 @Test(priority=37,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void RecentListPresent(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 37 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("RecentListPresent");
			 
		 }else{
			 homePage =BaseState("RecentListPresent");
		 }
		 for(int i=1;i<=4;i++){
			Assert.assertTrue(homePage.isImagePresentInRecentList(i));
		 }
		//checking vote
		 boolean votetrue=false;
         String beforetxt=" ";
	     if(homePage.isVotePresentInRecentLists(1)==true){
		   Assert.assertTrue(homePage.isVotePresentInRecentLists(1));
	       beforetxt=homePage.getTextofvoteRecentLists(1);
	       votetrue=true;
		   }  
    String before=homePage.gethrefOfRecentList(1);
    homePage.clickOnRecentListHeader(1);
    try{
	 Thread.sleep(2000);
	 }catch(Exception e){}
    String Afterurl = getDriver().getCurrentUrl();
	if (Afterurl.contains(before)) {
		Assert.assertEquals(1, 1);
	} else {
		Assert.assertEquals(1, 0);
	}
//	     String after=getDriver().getCurrentUrl();
//        String[] substring=after.split("\\?");
//        Assert.assertEquals(before, substring[0]);
        //checking vote
        if(votetrue==true)
	     {
	            String aftertxt=homePage.getTextofvoteafterclick();
//	            String[] txt = aftertxt.split(",");
//	            aftertxt="";
//	            for (int i=0;i<txt.length;i++){
//	            aftertxt = aftertxt+txt[i];
//	            }
	            Assert.assertEquals(beforetxt, aftertxt);
	     }
	 }//End Recent List Present 
//	 
	 /* 
	  * Use-case : Recent List Next Button
	  * Test case : Go to home page.On clicking on arrow, corresponding link should open.
	  */
	 @Test(priority=38,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void RecentListNextButton(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 38 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("RecentListNextButton");
		 }else{
			 homePage =BaseState("RecentListNextButton");
		 }
		 homePage.clickonnextbuttoninRecentList();
	    try{
		 Thread.sleep(2000);
		 }catch(Exception e){}
		 Assert.assertTrue(homePage.isPresentRecentListinNextButton());
	 }//End of RecentListNextButton
	 /* 
	  * Use-case : RecentListProfile
	  * Test case : Go to Recent List and Click profile and open relative link.
	  */
	 @Test(priority=39,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void RecentListProfile(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 39 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("RecentListProfile");
			 
		 }else{
			 homePage =BaseState("RecentListProfile");
		 }
    String before=homePage.gethrefOfRecentListProfileLink(1);
    homePage.clickOnRecentListProfileLink(1);
    try{
	 Thread.sleep(3000);
	 }catch(Exception e){}
    String Afterurl = getDriver().getCurrentUrl();
	if (Afterurl.contains(before)) {
		Assert.assertEquals(1, 1);
	} else {
		Assert.assertEquals(1, 0);
	}
//	 String after=getDriver().getCurrentUrl();
//     String[] substring=after.split("\\?");
//     Assert.assertEquals(before, substring[0]);
 }//End Recent List Present 
	 /* 
	  * Use-case : Recent List in MoreListRecentList
	  * Test case : Go to RecentList and click MoreListRecentList to open relative link
	  */
	 @Test(priority=40,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void MoreListRecentList(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 40 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("MoreListRecentList");
		 }else{
			 homePage =BaseState("MoreListRecentList");
		 }
		 homePage.clickonmorelistRecentList();
	 try{
		 Thread.sleep(5000);
		 }catch(Exception e){}
		 Assert.assertTrue(homePage.isPresentRecentListinNextButton());
	 }//End MoreListRecentList
	 /* 
	  * Use-case : Places & Travel Section
	  * Test case : Go to Places & Travel Header and check  5 section is present and click respected link..
	  */
	 @Test(priority=41,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PROD_Places_TravelPresent(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 41 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 if(url.contains("stage")){
		 }else{
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PROD_Places_TravelPresent");
		 }else{
			 homePage =BaseState("PROD_Places_TravelPresent");
		 }
		 
		 for(int i=1;i<=5;i++){
				Assert.assertTrue(homePage.isImagePresentInPlace_travelSection(i));
		 }
		 boolean votetrue=false;
		 String beforetxt=" ";
        // checking for vote 
		
		 if(homePage.isVotePresentInplaces_travel(1)==true){
		   Assert.assertTrue(homePage.isVotePresentInplaces_travel(1));
	       beforetxt=homePage.getTextofvoteplaces_travel(1);
	       votetrue=true;
		 }

         String before=homePage.gethrefOfPlace_travel(1);
         homePage.clickOnPlace_travelHeader(1);
         String Afterurl = getDriver().getCurrentUrl();
 		if (Afterurl.contains(before)) {
 			Assert.assertEquals(1, 1);
 		} else {
 			Assert.assertEquals(1, 0);
 		}
//	     String after=getDriver().getCurrentUrl();
//	     String[] substring=after.split("\\?");
//	     Assert.assertEquals(before, substring[0]);
	     if(votetrue==true)
	     {
	            String aftertxt=homePage.getTextofvoteafterclick();
//	            String[] txt = aftertxt.split(",");
//	            aftertxt="";
//	            for (int i=0;i<txt.length;i++){
//	            aftertxt = aftertxt+txt[i];
//	            }
	            Assert.assertEquals(beforetxt, aftertxt);
	     }
		 }
	 }//End Places & TravelPresent	 
	 /* 
	  * Use-case : Places & Travel Next Button
	  * Test case : Go to Places & Travel Header and click next button
	  */
	 @Test(priority=42,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PROD_Places_TravelNextButton(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 42 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 if(url.contains("stage")){
		 }else{
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PROD_Places_TravelNextButton");
		 }else{
			 homePage =BaseState("PROD_Places_TravelNextButton");
		 }
		 homePage.clickonnextbuttoninPlace_travel(); 
		 Assert.assertTrue(homePage.isPresentPlace_travelafterclickonmore());
		 }
	 }//End Places & Travel NextButton
	 /* 
	  * Use-case : Places & Travel in more
	  * Test case : Go to Places & Travel and click more to open realtive link
	  */
	 @Test(priority=43,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PROD_Places_TravelSectioninMore(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 43 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 if(url.contains("stage")){
		 }else{
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PROD_Places_TravelSectioninMore");
		 }else{
			 homePage =BaseState("PROD_Places_TravelSectioninMore");
		 }
		 String before=homePage.gethrefOfPlace_travel(1);
       homePage.clickonPlace_travelinmore(1);
       String Afterurl = getDriver().getCurrentUrl();
		if (Afterurl.contains(before)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
//       String after=getDriver().getCurrentUrl();
//       String[] substring=after.split("\\?");
//       Assert.assertEquals(before, substring[0]);
		 }
	 }//End Places & Travel Section in more
	 /* 
	  * Use-case : Places & Travel Section in MoreListaboutPlaces_Travel
	  * Test case : Go to Places & Travel Header and click more to open relative link
	  */
	 @Test(priority=44,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PROD_MoreListaboutPlaces_Travel(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 44 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 if(url.contains("stage")){
		 }else{
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PROD_MoreListaboutPlaces_Travel");
		 }else{
			 homePage =BaseState("PROD_MoreListaboutPlaces_Travel");
		 }
		 homePage.clickonmorelistaboutPlace_travel();
		 try{
			 Thread.sleep(3000);
		 }catch(Exception e){}
		 Assert.assertTrue(homePage.isPresentPlace_travelafterclickonmore());
		 }
	 }//End Places_Travel Section in MoreListaboutPlaces_Travel
	 /* 
	  * Use-case : Sports Section
	  * Test case : Go to Sports Header and check  5 section is present and click respected link..
	  */
	 @Test(priority=45,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PROD_SportsPresent(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 45 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 if(url.contains("stage")){
		 }else{
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PROD_SportsPresent");
		 }else{
			 homePage =BaseState("PROD_SportsPresent");
		 }
		 
		 for(int i=1;i<=5;i++){
				Assert.assertTrue(homePage.isImagePresentInSportsSection(i));
		 }
		 boolean votetrue=false;
		 String beforetxt=" ";
        // checking for vote 
		 if(homePage.isVotePresentInsports(1)==true){
		   Assert.assertTrue(homePage.isVotePresentInsports(1));
	       beforetxt=homePage.getTextofvotesports(1);
	       votetrue=true;
		 }
         String before=homePage.gethrefOfsports(1);
         homePage.clickOnsportsHeader(1);
         String Afterurl = getDriver().getCurrentUrl();
			if (Afterurl.contains(before)) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}
//	     String after=getDriver().getCurrentUrl();
//	     String[] substring=after.split("\\?");
//	     Assert.assertEquals(before, substring[0]);
	     //checking for vote
	     if(votetrue==true)
		     {
		            String aftertxt=homePage.getTextofvoteafterclick();
//		            String[] txt = aftertxt.split(",");
//		            aftertxt="";
//		            for (int i=0;i<txt.length;i++){
//		            aftertxt = aftertxt+txt[i];
//		            }
		            Assert.assertEquals(beforetxt, aftertxt);
		     }
		 }
	 }//End SportsPresent
	 /* 
	  * Use-case : Sports Next Button
	  * Test case : Go to Sports Header and click next button
	  */
	 @Test(priority=46,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PROD_SportsNextButton(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 46 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 if(url.contains("stage")){
		 }else{
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PROD_SportsNextButton");
		 }else{
			 homePage =BaseState("PROD_SportsNextButton");
		 }
		 homePage.clickonnextbuttoninsports(); 
		 Assert.assertTrue(homePage.isPresentSportsafterclickonmore());
		 }
	 }//End Sports NextButton
	 /* 
	  * Use-case : Sports in more
	  * Test case : Go to Sports and click more to open realtive link
	  */
	 @Test(priority=47,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PROD_SportsSectioninMore(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 47 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 if(url.contains("stage")){
		 }else{
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PROD_SportsSectioninMore");
		 }else{
			 homePage =BaseState("PROD_SportsSectioninMore");
		 }
		 String href=homePage.gethrefOfsports(1);
          homePage.clickonsportsinmore(1);
        String Afterurl = getDriver().getCurrentUrl();
		if (Afterurl.contains(href)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
//      String after=getDriver().getCurrentUrl();
//      String[] substring=after.split("\\?");
//      Assert.assertEquals(before, substring[0]);
		 }
	 }//End Sports Section in more
	 /* 
	  * Use-case : Sports Section in MoreListaboutSports
	  * Test case : Go to Sports Header and click more to open relative link
	  */
	 @Test(priority=48,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PROD_MoreListaboutSports(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 48 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 if(url.contains("stage")){
		 }else{
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PROD_MoreListaboutSports");
		 }else{
			 homePage =BaseState("PROD_MoreListaboutSports");
		 }
		 homePage.clickonmorelistaboutsports();
		 try{
			 Thread.sleep(3000);
		 }catch(Exception e){}
		 Assert.assertTrue(homePage.isPresentSportsafterclickonmore());
		 }
	 }//End Sports Section in MoreListaboutSports
	 /* 
	  * Use-case : thought provoking Section
	  * Test case : Go to thought provoking Header and check  5 section is present and click respected link..
	  */
	 @Test(priority=49,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PROD_ThoughtprovokingPresent(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 49 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 if(url.contains("stage")){
		 }else{
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PROD_ThoughtprovokingPresent");
		 }else{
			 homePage =BaseState("PROD_ThoughtprovokingPresent");
		 }

		 for(int i=1;i<=5;i++){
				Assert.assertTrue(homePage.isImagePresentInThoughtprovokingSection(i));
		 }
		// checking for vote 
	          boolean votetrue=false;
	          String beforetxt=" ";
				 if(homePage.isVotePresentInthoughtprovoking(1)==true){
				   Assert.assertTrue(homePage.isVotePresentInthoughtprovoking(1));
			       beforetxt=homePage.getTextofvotethoughtprovoking(1);
			       votetrue=true;
				 }
         String before=homePage.gethrefOfthoughtprovoking(1);
         homePage.clickOnthoughtprovokingHeader(1);
         try{
        	 Thread.sleep(3000);
         }catch(Exception e){}
         String Afterurl = getDriver().getCurrentUrl();
			if (Afterurl.contains(before)) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}
//	     String after=getDriver().getCurrentUrl();
//	     String[] substring=after.split("\\?");
//	     Assert.assertEquals(before, substring[0]);
	   //checking for vote
	     if(votetrue==true)
		     {
		            String aftertxt=homePage.getTextofvoteafterclick();
//		            String[] txt = aftertxt.split(",");
//		            aftertxt="";
//		            for (int i=0;i<txt.length;i++){
//		            aftertxt = aftertxt+txt[i];
//		            }
		            Assert.assertEquals(beforetxt, aftertxt);
		     }
		 }
	 }//End ThoughtprovokingPresent
	 /* 
	  * Use-case : thought provoking Next Button
	  * Test case : Go to thought provoking Header and click next button
	  */
	 @Test(priority=50,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PROD_ThoughtprovokingNextButton(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 50 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 if(url.contains("stage")){ 
		 }else{
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PROD_ThoughtprovokingNextButton");
		 }else{
			 homePage =BaseState("PROD_ThoughtprovokingNextButton");
		 }
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 homePage.clickonnextbuttoninthoughtprovoking();
		 Assert.assertTrue(homePage.isPresentThoughtprovokingafterclickonmore());
		 }
	 }//End thoughtprovoking NextButton
	 /* 
	  * Use-case : thought provoking in more
	  * Test case : Go to thought provoking and click more to open realtive link
	  */
	 @Test(priority=51,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PROD_ThoughtprovokingSectioninMore(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 51 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 if(url.contains("stage")){
		 }else{
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PROD_ThoughtprovokingSectioninMore");
		 }else{
			 homePage =BaseState("PROD_ThoughtprovokingSectioninMore");
		 }
		 String href=homePage.gethrefOfthoughtprovoking(1);
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
         homePage.clickonthoughtprovokinginmore(1);
         String Afterurl = getDriver().getCurrentUrl();
			if (Afterurl.contains(href)) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}
//     String after=getDriver().getCurrentUrl();
//     String[] substring=after.split("\\?");
//     Assert.assertEquals(before, substring[0]);
		 }
	 }//End thoughtprovoking Section in more
	 /* 
	  * Use-case : thoughtprovoking Section in MoreListaboutthoughtprovoking
	  * Test case : Go to thoughtprovoking Header and click more to open relative link
	  */
	 @Test(priority=52,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PROD_MoreListaboutthoughtprovoking(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 52 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 if(url.contains("stage")){
		 }else{
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PROD_MoreListaboutthoughtprovoking");
		 }else{
			 homePage =BaseState("PROD_MoreListaboutthoughtprovoking");
		 }
		 homePage.clickonmorelistaboutthoughtprovoking();
		 try{
			 Thread.sleep(3000);
		 }catch(Exception e){}
		 Assert.assertTrue(homePage.isPresentThoughtprovokingafterclickonmore());
		 }
	 }//End thoughtprovoking Section in MoreListaboutthoughtprovoking
	 /* 
	  * Use-case : Our Picks For 90's Block.
	  * Test case : Go to the our picks for Block on home page.Count for total sections in this block.Also on clicking on any section should take to the corresponding page. 
	  */
	 @Test(priority=53,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void OurPicksForBlock(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 53 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("OurPicksForBlock");
		 }else{
			 homePage =BaseState("OurPicksForBlock");
		 }
//		 for(int i=1;i<=3;i++)
//		 {
//			 Assert.assertTrue(homePage.isImagePresentInourPicksForSection(i));
//			 //Assert.assertTrue(homePage.ourPicksForBlockPresent(i));
//		 }
			// checking for vote 
              boolean votetrue=false;
              String beforetxt=" ";
			  if(homePage.isVotePresentInourpicksfor(1)==true)
			  {
			   Assert.assertTrue(homePage.isVotePresentInourpicksfor(1));
		       beforetxt=homePage.getTextofvoteourpicksfor(1);
		       votetrue=true;
			 }
	    String href=homePage.getHrefOfourPicksForBlock(1);
	    homePage.clickOnourPicksForBlockSection(1);
	    String Afterurl = getDriver().getCurrentUrl();
		if (Afterurl.contains(href)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
//	    String url1=homePage.getCurrentURL();
//	    if(url.contains("stage"))
//	    {
//	    	String suburl[]=url1.split("\\?");
//	    	Assert.assertEquals(suburl[0], href);
//	    }else{
//	    	Assert.assertEquals(url1, href);	}
		  // checking for vote
    if(votetrue==true)
	     {
	            String aftertxt=homePage.getTextofvoteafterclick();
//	            String[] txt = aftertxt.split(",");
//	            aftertxt="";
//	            for (int i=0;i<txt.length;i++){
//	            aftertxt = aftertxt+txt[i];
//	            }
	            Assert.assertEquals(beforetxt, aftertxt);
	     }
	}//End of ourPicksForBlock().
	 /* 
	  * Use-case : Our Picks For 90's Block Section's more link. 
	  * Test case : Go to the our picks for Block on home page.Clicking On more, should take to the corresponding page. 
	  */
	 @Test(priority=54,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void OurPicksForBlockMore(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 54 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("OurPicksForBlockMore");
		 }else{
			 homePage =BaseState("OurPicksForBlockMore");
		 }
		 String href=homePage.getHrefOfourPicksForBlock(1);
		 homePage.clickOnOurPicksForBlockMore(1);
		 try{
			 Thread.sleep(4000);
		 }catch(Exception e){}
		 String Afterurl = getDriver().getCurrentUrl();
			if (Afterurl.contains(href)) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}
//		 String url1=homePage.getCurrentURL();
//		 if(url.contains("stage")){
//		    	String suburl[]=url1.split("\\?");
//		    	Assert.assertEquals(suburl[0], href);
//		    }else
//		 Assert.assertEquals(url1, href);
	 }//End of ourPicksForBlockMore().
	 /* 
	  * Use-case : Music Block.
	  * Test case : Go to the music block in home page.Check the presence of total sections in the block. Also on clicking on any section should take to the corresponding page. 
	  */
	 @Test(priority=55,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PROD_MusicBlock(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 55 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 if(url.contains("stage")){}
		 else{
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PROD_MusicBlock");
		 }else{
			 homePage =BaseState("PROD_MusicBlock");
		 }
		 for(int i=1;i<=5;i++)
		 {
			Assert.assertTrue(homePage.isMusicSectionPresent(i)); 
		 }
		// checking for vote 
         boolean votetrue=false;
         String beforetxt=" ";
		 if(homePage.isVotePresentInmusic(1)==true){
		   Assert.assertTrue(homePage.isVotePresentInmusic(1));
	       beforetxt=homePage.getTextofvotemusic(1);
	       votetrue=true;
		 }
	     String href=homePage.getHrefOfMusicSection(1);
	     homePage.clickOnMusicSection(1);
	     String Afterurl = getDriver().getCurrentUrl();
			if (Afterurl.contains(href)) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}
//	     String url=homePage.getCurrentURL();s
	     if(votetrue==true)
	     {
	            String aftertxt=homePage.getTextofvoteafterclick();
//	            String[] txt = aftertxt.split(",");
//	            aftertxt="";
//	            for (int i=0;i<txt.length;i++){
//	            aftertxt = aftertxt+txt[i];
//	            }
	            Assert.assertEquals(beforetxt, aftertxt);
	     }
		 }
	 }//End of MusicBlock().
	 /* 
	  * Use-case : Music Block Next Arrow.
	  * Test case : Go to the music Block on home page.Clicking On arrow, should take to the corresponding page. 
	  */
	 @Test(priority=56,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PROD_MusicBlockArrow(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 56 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 if(url.contains("stage")){}
		 else{
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PROD_MusicBlockArrow");
		 }else{
			 homePage =BaseState("PROD_MusicBlockArrow");
		 }
		 String href=homePage.getHrefOfMusicArrow();
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 homePage.clickOnMusicArrow();
		 String Afterurl = getDriver().getCurrentUrl();
			if (Afterurl.contains(href)) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}
//		 String url=homePage.getCurrentURL();
//		 Assert.assertEquals(url, href);
		 }
	 }//End of MusicBlockArrow().
//////
	 /* 
	  * Use-case : Music Block Link.
	  * Test case : Go to the music Block on home page.Clicking On link at bottom in the block, should take to the corresponding page. 
	  */
	 @Test(priority=57,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PROD_MusicBlockLink(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 57 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 if(url.contains("stage")){}
		 else{
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PROD_MusicBlockLink");
		 }else{
			 homePage =BaseState("PROD_MusicBlockLink");
		 }
		 String href=homePage.getHrefOfMusicArrow();
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 homePage.clickOnMusicBlockMoreAboutMusicLink();
		 String Afterurl = getDriver().getCurrentUrl();
			if (Afterurl.contains(href)) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}
//		 String url=homePage.getCurrentURL();
//		 try{
//			 Thread.sleep(2000);
//		 }catch(Exception e){}
//		 Assert.assertEquals(url, href);
		 }
	 }//End of MusicBlockLink().
	 /* 
	  * Use-case : Music Block Section's more link.
	  * Test case : Go to the music Block on home page.Clicking On link at bottom in the block, should take to the corresponding page. 
	  */
	 @Test(priority=58,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PROD_MusicSectionMore(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 58 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 if(url.contains("stage")){}
		 else{
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PROD_MusicSectionMore");
		 }else{
			 homePage =BaseState("PROD_MusicSectionMore");
		 }
		 String href=homePage.getHrefOfMusicSection(1);
		 homePage.clickOnMusicSectionMore();
		 String Afterurl = getDriver().getCurrentUrl();
			if (Afterurl.contains(href)) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}
//		 String url=homePage.getCurrentURL();
//		 Assert.assertEquals(url, href);
		 }
	 }//End of MusicSectionMore().
	  /* 
	  * Use-case : Popular on facebook Section in more
	  * Test case : Go to  Popular on facebook  Header and click more to open realtive link
	  */
	 @Test(priority=59,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PROD_PopularOnFacebookinMore(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 59 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 if(url.contains("stage")){}
		 else{
		 Home homePage=null;
		 //Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("PROD_PopularOnFacebookinMore");
		 }else{
			 homePage =BaseState("PROD_PopularOnFacebookinMore");
		 }
       String before=homePage.getHrefOfPopularOnFacebookSection(1);
       homePage.clickonPopularoninmore(1);
       try{
    	   Thread.sleep(6000);
       }catch(Exception e){}
       String Afterurl = getDriver().getCurrentUrl();
		if (Afterurl.contains(before)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
		 }
//       String after=getDriver().getCurrentUrl();
//       String[] substring=after.split("\\?");
//       Assert.assertEquals(before, substring[0]);
	 }//End  Popular on facebook  Section in more
	 /* 
	  * Use-case : Most Tweeted block. Section in more
	  * Test case : Go to  Most Tweeted block.  Header and click more to open realtive link
	  */
	 @Test(priority=60,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void MostTweetedinMore(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 60 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("MostTweetedinMore");
		 }else{
			 homePage =BaseState("MostTweetedinMore");
		 }
       String before=homePage.getHrefOfMostTweetedSection(1);
    
       homePage.clickOnMostTweetedSection(1);
       try{
    	   Thread.sleep(6000);
       }catch(Exception e){}
         String Afterurl = getDriver().getCurrentUrl();
		if (Afterurl.contains(before)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
//       String after=getDriver().getCurrentUrl();
//       String[] substring=after.split("\\?");
//       Assert.assertEquals(before, substring[0]);
	 }//End MostTweetedinMore
	
	 /* 
	  * Use-case  :  404page
	  * Test case : Go to a broken page on ranker 
                    Eg: http://www.ranker-stage.com/list//olivia-peterman
	  */
	 @Test(priority=61,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void errorPage(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 61 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("errorPage");
			  }else{
			 homePage =BaseState("errorPage");
			 }
		 common.getNewURL(config.getProperty("Url")+"list//olivia-peterman");
			 try {
				Thread.sleep(2000);
			} catch (Exception e) {}
         Assert.assertEquals("rgba(68, 171, 36, 1)",homePage.getColorOfuhohheader());
         Assert.assertEquals("rgba(30, 62, 102, 1)",homePage.getColorOfletsseeHeader());
         Assert.assertEquals("rgba(99, 99, 99, 1)",homePage.getColorOfmaybePara());
         Assert.assertTrue(homePage.isPresentbreakline());
         Assert.assertEquals("rgba(99, 99, 99, 1)",homePage.getColorOfwedohavePara());
         Assert.assertEquals("rgba(68, 171, 36, 1)",homePage.getColorOfdontBeMAdheader());
         Assert.assertTrue(homePage.isPresentrankyImg());
	     }
	 /* 
	  * Use-case : Homepage: add commas in vote counts for recently reranked
	  * Test case : Open Ranker home page
        And scroll to Recently reranked section
	  */
	 @Test(priority=62,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void CommasPresentInVoteCountForRecentlyRerank(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Home homePage=null;
		 if(loginRequired.equals("YES")){
			 homePage =BaseStateWithLogin("CommasPresentInVoteCountForRecentlyRerank");
		 }else{
			 homePage =BaseState("CommasPresentInVoteCountForRecentlyRerank");
		 }
		 for(int i=1;i<=5;i++){
			 homePage.isRecentlyRerankedPresent(i);
		 }
		 boolean votetrue=false;
		 String beforetxt=" ";
		// checking for vote 
		     if(homePage.isVotePresentInMostTweeted(1)==true){
			 Assert.assertTrue(homePage.isVotePresentInRecentlyReranked(1));
			 beforetxt=homePage.getTextofvoteRecentlyReranked(1);
			 if(beforetxt.contains(","))
		        {
		        	Assert.assertEquals(1, 1);
				} else {
					Assert.assertEquals(1, 0);
				}
		 }
	 }//End of CommasPresentInVoteCountForRecentlyRerank()
	 
	 /*
		  * This is base state of the slide show test-cases.
		  */
		     public Home BaseState(String testName){
		    	 try{
					 startRecording(testName);
					}catch(Exception e){}
			// Commonpage common=new Commonpage(getDriver());
		    	 common=new Commonpage(getDriver());
			 Home homePage=common.getHomePage(url);
			 return homePage;
		 } //End of BaseState()
		 /*
		  * This is base state of the slide show test-cases.
		  */
		 public Home BaseStateWithLogin(String testName){
			 try{
				 startRecording(testName);
				}catch(Exception e){}
			// Commonpage common=new Commonpage(getDriver());
			 common=new Commonpage(getDriver());
			 common.signin("testuserkallol1@mailinator.com", "testing");
			 Home homePage=common.getHomePage(url);
			 return homePage;
		 } //End of BaseStateWithLogin()

}