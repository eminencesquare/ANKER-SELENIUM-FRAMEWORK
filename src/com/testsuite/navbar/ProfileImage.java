package com.testsuite.navbar;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.AppGlobalVariables;
import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.paeobjects.home.Home;
import com.paeobjects.navbar.NavBar;
import com.pageobjects.uelist.UeListPage;
import com.pageobjects.userProfilePage.UserProfilePage;
import com.selenium.SafeActions;

public class ProfileImage extends BaseSetup{
	ConfigManager sysProp=new ConfigManager("Sys");
	 String url=config.getProperty("Url"); 
	 
	 
	@Test(priority=1)
	public void ProfileImage_profilepage(){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
		try {
			startRecording("ProfileImage_profilepage");
		} catch (Exception e) {
		}
		Commonpage common = new Commonpage(getDriver());
		Home home = common.getHomePage(url);
		common.signin("testuserkallol1@mailinator.com", "testing");
		home.clickUserLogo();
		Assert.assertTrue(home.veriifyUserLogo(),"User Image");
	}
	
	/* 
	  * Use-case  : Check "my latest lists" in dropdown after creating new list
	  * Test case :"1) Create a list and close the UE
					2) Click on your lists dropdown"
	 */	
	@Test(priority=2,dataProviderClass = DataProviders.class, dataProvider ="Login")
	public void ProfileImageDropdown_mylatestlists(String loginRequired){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2 !!!!!!!!!!!!!!!!!!!!!!!");
		try {
			startRecording("ProfileImageDropdown_mylatestlists");
		} catch (Exception e) {
		}
		Commonpage common = new Commonpage(getDriver());
		UeListPage ueList = common.getUeListPage(url);
		common.signin("testuserkallol1@mailinator.com", "testing");
		ueList.clickOncreateList();
		ueList.clickOnreranking();
		 if(ueList.isStickyPresent()==true){
		 ueList.clickStickyOK();
		 }
		ueList.clickOnListName();
		ueList.putTextOnListNameBox("CheckForUnSavedList");
		ueList.clickOnSearch();
		ueList.typesearchbtn("Batman");
		for (int i = 1; i <= 5; i++) {
			ueList.clickOnPlusIcon(i);
			SafeActions s = new SafeActions(getDriver());
		    s.waitForPageToLoad(60);
		}
		
		 ueList.clickOncancel();
		 Home home= new Home(getDriver());
		 home.hoverOnUserLogo();
	
		 String latestListName= home.getLatestMyListName();
		 Assert.assertEquals("CheckForUnSavedList", latestListName);
		 home.clickOnListInMyLatestList(1);
		 ueList.clickOnoptionbtn();
		 ueList.clickOnAdvancedOption();
		 ueList.clickOndeletelist();
		 ueList.AlertExistsAndAccepted(1000);
	}
		/* 
		  * Use-case  : Profile Image Dropdown - " my latest alerts"
		  * Test case :"1) Enter Ranker as a logged in user
						2) Hover on profile image in top right to see latest alerts"
		 */	
		@Test(priority=3,dataProviderClass = DataProviders.class, dataProvider ="Login")
		public void ProfileImageDropdownMylatestAlerts(String loginRequired){
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
			try {
				startRecording("ProfileImageDropdownMylatestAlerts");
			} catch (Exception e) {
			}
			  Commonpage common = new Commonpage(getDriver());
			  Home home = common.getHomePage(url);
			  common.signin("testvikas2", "123456");
			 getDriver().get(config.getProperty("Url")+"profile-of/testuserkallol1");
			 UserProfilePage userProfilePage = new UserProfilePage(getDriver());
			 userProfilePage.clickOnSendaNoteLink();
			 try {
					Thread.sleep(5000);
				} catch (Exception e) {
					
				}
			 userProfilePage.typeTextInNoteTextBox("Hi, How are you?");
			 userProfilePage.clickOnSendNoteBtn();
			 home.doLogout();
			 common.signin("testuserkallol1@mailinator.com", "testing");
			 Assert.assertTrue(home.isNumberOfAlerts());
			 try {
				Thread.sleep(5000);
			} catch (Exception e) {
				
			}
			 home.hoverOnUserLogo();
			 home.clickFirstAlert();
			 Assert.assertFalse(home.isNumberOfAlerts());
			 
		}
		
		/* 
		  * Use-case  : Profile Image Dropdown - edit settings
		  * Test case :"1) Enter Ranker as a logged in user.
						2) Hover on profile image in top right to see dropdown.
						3) Click on the Edit Settings."
		 */	
		@Test(priority=4,dataProviderClass = DataProviders.class, dataProvider ="Login")
		public void ProfileImageDropdownEditSettings(String loginRequired){
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
			try {
				startRecording("ProfileImageDropdownEditSettings");
			} catch (Exception e) {
			}
			 Commonpage common = new Commonpage(getDriver());
			 Home home = common.getHomePage(url);
			 common.signin("testuserkallol1@mailinator.com", "testing");
			 home.hoverOnUserLogo();
			 home.clickOnEditSettings();
			 UserProfilePage userProfilePage = new UserProfilePage(getDriver());
			 Assert.assertTrue(userProfilePage.isMySettingWindowPresent());
			 
		}
		/* 
		  * Use-case  : Profile Image Dropdown - badges
		  * Test case :"1) Enter Ranker as a logged in user.
						2) Hover on profile image in top right to see dropdown.
						3) Click on the badges link."
		 */	
		@Test(priority=5,dataProviderClass = DataProviders.class, dataProvider ="Login")
		public void ProfileImageDropdownBadges(String loginRequired){
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
			try {
				startRecording("ProfileImageDropdownBadges");
			} catch (Exception e) {
			}
			Commonpage common = new Commonpage(getDriver());
			Home home = common.getHomePage(url);
			 common.signin("testuserkallol1@mailinator.com", "testing");
			 home.hoverOnUserLogo();
			 home.clickOnBadges();
			 try{
			 Thread.sleep(2000);
			 }catch(Exception e){}
			 UserProfilePage userProfilePage = new UserProfilePage(getDriver());
			 String classOfBadgeTab= userProfilePage.getClassOfTabs(6);
			 if (classOfBadgeTab.contains("active")){
				 Assert.assertEquals(1, 1);
			 }else{
				 Assert.assertEquals(1, 0);
			 }
			 
		}
		/* 
		  * Use-case  : Profile Image Dropdown - following
		  * Test case :"1) Enter Ranker as a logged in user.
						2) Hover on profile image in top right to see dropdown.
						3) Click on the following link."
		 */	
		@Test(priority=6,dataProviderClass = DataProviders.class, dataProvider ="Login")
		public void ProfileImageDropdownFollowing(String loginRequired){
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
			try {
				startRecording("ProfileImageDropdownFollowing");
			} catch (Exception e) {
			}
			Commonpage common = new Commonpage(getDriver());
			Home home = common.getHomePage(url);
			 common.signin("testuserkallol1@mailinator.com", "testing");
			 home.hoverOnUserLogo();
			 home.clickOnFollowing();
			 try{
			 Thread.sleep(2000);
			 }catch(Exception e){}
			 UserProfilePage userProfilePage = new UserProfilePage(getDriver());
			 String classOfBadgeTab= userProfilePage.getClassOfTabs(3);
			 if (classOfBadgeTab.contains("active")){
				 Assert.assertEquals(1, 1);
			 }else{
				 Assert.assertEquals(1, 0);
			 }
		}
	 
	 /* 
	  * Use-case  : Profile Image Dropdown - logout
	  * Test case :"1) Enter Ranker as a logged in user.
					2) Hover on profile image in top right to see dropdown.
					3) Click on the logout link."
	 */	
	@Test(priority=7,dataProviderClass = DataProviders.class, dataProvider ="Login")
	public void ProfileImageDropdownLogout(String loginRequired){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
		try {
			startRecording("ProfileImageDropdownLogout");
		} catch (Exception e) {
		}
		Commonpage common = new Commonpage(getDriver());
		Home home = common.getHomePage(url);
		 common.signin("testuserkallol1@mailinator.com", "testing");
		 UserProfilePage userProfilePage = new UserProfilePage(getDriver());
		 userProfilePage.clickOnProfile();
		 String beforeUrl = getDriver().getCurrentUrl();
		 home.hoverOnUserLogo();
		 home.doLogout();
		 try{
		 Thread.sleep(2000);
		 }catch(Exception e){}
		 Assert.assertFalse(home.isUserLogoPresent());
		 Assert.assertEquals(getDriver().getCurrentUrl(), beforeUrl);
		 
	}
	 /*
	  * This is base state of the home page test-cases.
	  */
	     public Home BaseState(String testName){
	    	 try{
				 startRecording(testName);
				}catch(Exception e){}
		 Commonpage common=new Commonpage(getDriver());
		 Home homePage=common.getHomePage(url);
		 return homePage;
	 } //End of BaseState()
	 /*
	  * This is base state of the home page test-cases.
	  */
	 public Home BaseStateWithLogin(String testName){
		 try{
			 startRecording(testName);
			}catch(Exception e){}
		 Commonpage common=new Commonpage(getDriver());
		 common.signin("testuserkallol1@mailinator.com", "testing");
		 Home homePage=common.getHomePage(url);
		 return homePage;
	 } //End of BaseStateWithLogin()

}
