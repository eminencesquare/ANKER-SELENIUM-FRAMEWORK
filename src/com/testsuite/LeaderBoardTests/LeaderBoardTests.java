package com.testsuite.LeaderBoardTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.paeobjects.navbar.NavBar;
import com.pageobjects.grid.Grid;
import com.pageobjects.leaderboard.LeaderBoardPage;
import com.pageobjects.uelist.UeListPage;
import com.selenium.SafeActions;

public class LeaderBoardTests extends BaseSetup{
	ConfigManager urls=new ConfigManager("PreProduction");
	ConfigManager sysProp=new ConfigManager("Sys");
	Commonpage common;
    String url=config.getProperty("Url")+urls.getProperty("LeaderBoard");
   SafeActions safeAction = new SafeActions(getDriver());
     /* 
	  * Use-case : Top Rankers block - categories dropdown
	  * Test case : 1) Open leaderboard page.
                    2) Select any category in categories dropdown.
	  */
	 @Test(priority=1,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void CategoriesDropdown(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 LeaderBoardPage leaderBoard=null;
		 if(loginRequired.equals("YES")){
			 leaderBoard =BaseStateWithLogin("CategoriesDropdown");
		 }else{
			 leaderBoard =BaseState("CategoriesDropdown");
		 }
		leaderBoard.clickOncategoriesDropdown();
		leaderBoard.clickOncategoriesDropdownOptions("Music");
		String afterClick=getDriver().getCurrentUrl();
		Assert.assertEquals(url+"/music", afterClick);
	 }//End of CategoriesDropdown()
	 /* 
	  * Use-case : Top Rankers block - top ranker
	  * Test case : Open Leaderboard page and make sure the #1 ranker stands out.
	  */
	 @Test(priority=2,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void TopRanker(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 LeaderBoardPage leaderBoard=null;
		 if(loginRequired.equals("YES")){
			 leaderBoard =BaseStateWithLogin("TopRanker");
		 }else{
			 leaderBoard =BaseState("TopRanker");
		 }
		String[] arr1=leaderBoard.getHeightAndWidthOfTopRankerImage();	
		String[] arr2=leaderBoard.getHeightAndWidthOfOtherRankerImage(1);
		Assert.assertNotEquals(arr1[0], arr2[0]);
		Assert.assertNotEquals(arr1[1], arr2[1]);
		String head1=leaderBoard.getSizeOfTopRankerHeader();
		String head2=leaderBoard.getSizeOfOtherRankerHeader(1);
		Assert.assertNotEquals(head1,head2);
		Assert.assertTrue(leaderBoard.isTopRankerRibbonPresent());
		for(int i=1;i<=4;i++){
		    Assert.assertTrue(leaderBoard.isTopScoreBarPresent(i));
		    Assert.assertNotNull(leaderBoard.getTextOfTopProfileScore(i));
		}
	 }//End of TopRanker()
	 /* 
	  * Use-case : Top Rankers block - username hover-over
	  * Test case : Open Leaderboard page and hover over on any of the user names appear.
	  */
	 @Test(priority=3,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void UserNameHover(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 LeaderBoardPage leaderBoard=null;
		 if(loginRequired.equals("YES")){
			 leaderBoard =BaseStateWithLogin("UserNameHover");
		 }else{
			 leaderBoard =BaseState("UserNameHover");
		 }
	 leaderBoard.hoverOverOtherRankerHeader(1);
	 leaderBoard.isHoverBoxOfOtherRankerHeaderPresent();
	 leaderBoard.hoverOverOtherRankerSection(1);
	 for(int i=1;i<=4;i++){
	       Assert.assertTrue(leaderBoard.isScoreBarPresent(1,i));
	 }
}//End of UserNameHover()
    /* 
	  * Use-case : Top Rankers block - profile row hover
	  * Test case : Hover over various profile rows in the Top Rankers block.
	  */
	 @Test(priority=4,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void RowHover(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 LeaderBoardPage leaderBoard=null;
		 if(loginRequired.equals("YES")){
			 leaderBoard =BaseStateWithLogin("RowHover");
		 }else{
			 leaderBoard =BaseState("RowHover");
		 }
		 leaderBoard.hoverOverOtherRankerSection(1);
		 System.out.println("2222222222");
//		 try{
//			 Thread.sleep(10);
//		 }catch(Exception e){}
		 Assert.assertEquals("rgba(30, 62, 102, 1)", leaderBoard.getColorOfScoreBarProfileScore(1));//rgb(30, 62, 102)
	     for(int j=2;j<=4;j++){
	    	 System.out.println("3333333333333");
	           Assert.assertTrue(leaderBoard.isScoreBarPresent(1,j));
		 }
}//End of RowHover()
    /* 
 	  * Use-case : Leaderboard Primer block.
 	  * Test case : Open Leaderboard page and make sure Leaderboard Primer block is in the right rail.
 	  */
 	 @Test(priority=5,dataProviderClass = DataProviders.class, dataProvider = "Login")
 	 public void PrimerBlock(String loginRequired){
 		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
 		 //Base state. (Navigate to node page)
 		 LeaderBoardPage leaderBoard=null;
 		 if(loginRequired.equals("YES")){
 			 leaderBoard =BaseStateWithLogin("PrimerBlock");
 		 }else{
 			 leaderBoard =BaseState("PrimerBlock");
 		 }
 		  SafeActions s = new SafeActions(getDriver());
	      s.waitForPageToLoad(40);
 		Assert.assertTrue(leaderBoard.isPrimerBlockPresent());
 		Assert.assertTrue(leaderBoard.isPrimerBlockRankyPresent("image"));
 		Assert.assertNotNull(leaderBoard.getTextOfPrimerBlockDescription("description"));
 }//End of PrimerBlock()
    /* 
  	  * Use-case : Category Leaders block - category icons.
  	  * Test case : Open Leaderboard page and make sure all categories are present in the Category Leaders block.
  	  */
  	 @Test(priority=6,dataProviderClass = DataProviders.class, dataProvider = "Login")
  	 public void CategoryLeadersIcons(String loginRequired){
  		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
  		 //Base state. (Navigate to node page)
  		 LeaderBoardPage leaderBoard=null;
  		 if(loginRequired.equals("YES")){
  			 leaderBoard =BaseStateWithLogin("CategoryLeadersIcons");
  		 }else{
  			 leaderBoard =BaseState("CategoryLeadersIcons");
  		 }
  		 for(int i=1;i<=18;i++){
  		      leaderBoard.isCategoryBlockIconsPresent(i);
  		      String[] catTxt=leaderBoard.getTextOfCategoryBlockDescription(i).split("#1 in");
  		      leaderBoard.clickOnCategoryBlockIcons(i);
  		      SafeActions s = new SafeActions(getDriver());
		      s.waitForPageToLoad(30);
  		      String comboTxt=leaderBoard.getTextOfCategoryOnComboBox().trim();
  		      Assert.assertEquals(catTxt[1].trim(),comboTxt);
  		 }
 }//End of CategoryLeadersIcons()
    /* 
  	  * Use-case : Category Leaders block - profile links.
  	  * Test case : Open Leaderboard page and make sure all profile links are clickable.
  	  */
  	 @Test(priority=7,dataProviderClass = DataProviders.class, dataProvider = "Login")
  	 public void CategoryLeadersProfileLinks(String loginRequired){
  		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
  		 //Base state. (Navigate to node page)
  		 LeaderBoardPage leaderBoard=null;
  		 if(loginRequired.equals("YES")){
  			 leaderBoard =BaseStateWithLogin("CategoryLeadersProfileLinks");
  		 }else{
  			 leaderBoard =BaseState("CategoryLeadersProfileLinks");
  		 }
  		for(int i=1;i<=18;i++){
  			if(leaderBoard.isCategoryLeadersProfileLinksClickable(i))
  			{
  				String href=leaderBoard.getHrefOfCategoryLeadersProfileLinks(i);
  				try{
  					 Thread.sleep(5000);
  				 }catch(Exception e){}
  				
  				leaderBoard.clickOnCategoryLeadersProfileLinks(i);
  				SafeActions s = new SafeActions(getDriver());
  			    s.waitForPageToLoad(40);
  				String url1=getDriver().getCurrentUrl();
  				Assert.assertEquals(href, url1);
  				getDriver().navigate().back();
  			}
  		}
  }//End of CategoryLeadersProfileLinks()
    /* 
  	  * Use-case : Top Rankers block - username & profile image links.
  	  * Test case : Open Leaderboard page and click on any of the usernames and profile images.(1-This should open corresponding user's profile page
                                                                                                2-Make sure the page displays top 200 users)
  	  */
  	 @Test(priority=8,dataProviderClass = DataProviders.class, dataProvider = "Login")
  	 public void OtherRankerNameAndImage(String loginRequired){
  		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
  		 //Base state. (Navigate to node page)
  		 LeaderBoardPage leaderBoard=null;
  		 if(loginRequired.equals("YES")){
  			 leaderBoard =BaseStateWithLogin("OtherRankerNameAndImage");
  		 }else{
  			 leaderBoard =BaseState("OtherRankerNameAndImage");
  		 }
  		 Assert.assertTrue(leaderBoard.isOtherRankerSectionPresent(199));
  		 String href=leaderBoard.getHrefOfOtherRankerHeader(1);
  		 leaderBoard.clickOnOtherRankerHeader(1);
  		 try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
  		 String url=getDriver().getCurrentUrl();
  		 Assert.assertEquals(href, url);
  		 //Assert.assertTrue(leaderBoard.isOtherRankerSectionPresent(199));
 }//End of OtherRankerNameAndImage()
//  	 /* 
//  	  * Use-case :  Log in as an administrator
//  	  * Test case : - Load up a list page and ensure all admin UI elements on the admin bar are functioning correctly
//                       
//  	  */
//  	 @Test(priority=9,dataProviderClass = DataProviders.class, dataProvider = "Login")
//  	 public void AdminUIelements(String loginRequired){
//  		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 9 !!!!!!!!!!!!!!!!!!!!!!!");
//  		 //Base state. (Navigate to node page)
//  		 LeaderBoardPage leaderBoard=null;
//  		 if(loginRequired.equals("YES")){
//  			 leaderBoard =BaseStateWithLogin("AdminUIelements");
//  		 }else{
//  			 leaderBoard =BaseState("AdminUIelements");
//  		 }
//  		UeListPage ueList = new UeListPage(getDriver());
//  		common.signin("vijaymohanp", "server");
//  		 NavBar navBar= new NavBar(getDriver());
//  		  navBar.hoverMore();
//  		 try {
//				Thread.sleep(5000);
//		 } catch (Exception e) {}
//  		ueList.clickOncreateList();
//  		 try {
//				Thread.sleep(5000);
//		 } catch (Exception e) {}
//		ueList.clickOnreranking();
//		 try {
//				Thread.sleep(5000);
//		 } catch (Exception e) {}
//		ueList.putTextOnListNameBox("Testing List");
//		ueList.clickOnSearch();
//		 ueList.typesearchbtn("Batman");
//		 for(int i=1;i<=3;i++){
//		 ueList.clickOnPlusIcon(i);
//		 }
//  	 }
//  	 
  	 
  	 
  	 
  	 
  	 /*
	  * This is base state of the slide show test-cases.
	  */
	 public LeaderBoardPage BaseState(String testName){
		 try{
		 startRecording(testName);
		}catch(Exception e){}
		 common=new Commonpage(getDriver());
		 LeaderBoardPage leaderBoard=common.getLeaderBoard(url);
		 return leaderBoard;
	 } //End of BaseState()
	 /*
	  * This is base state of the slide show test-cases.
	  */
	 public LeaderBoardPage BaseStateWithLogin(String testName){
		 try{
		 startRecording(testName);
		}catch(Exception e){}
		 common=new Commonpage(getDriver());
		 common.signin("testuserkallol1@mailinator.com", "testing");
		 LeaderBoardPage leaderBoard=common.getLeaderBoard(url);
		 return leaderBoard;
	 } //End of BaseStateWithLogin() 

}
