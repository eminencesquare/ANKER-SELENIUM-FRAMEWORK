package com.testsuite.UserProfileTest;

import java.util.ArrayList;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.paeobjects.home.Home;
import com.pageobject.login.SigninPage;
import com.pageobjects.listoption.ListOptionPage;
import com.pageobjects.uelist.UeListPage;
import com.pageobjects.userProfilePage.UserProfilePage;
import com.selenium.SafeActions;
import com.pageobjects.uelist.UeListPage;
public class UserProfileTest extends BaseSetup{
	ConfigManager urls=new ConfigManager("PreProduction");
	ConfigManager sysProp=new ConfigManager("Sys");
	Commonpage common;
    String url=config.getProperty("Url");
//    
//    @AfterMethod
//    public void logout(){
//    	Home home = new Home(getDriver());
//		home.doLogout();
//    }
    
  /*
	 * Use-case : Settings page link 
	 * Test case : 1) Open your profile page as logged-in user
					2) Click on "Settings" link appear on top of the page
	 */
	@Test(priority = 1, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void SettingsPageLink(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		UserProfilePage profile =BaseStateWithLogin("SettingsPageLink","testuserkallol1@mailinator.com", "testing");
		profile.clickOnProfile();
		profile.clickOnviewProfile();
		profile.clickOnSettingsBtn();
		Assert.assertTrue(profile.isSettingPopUpTabsPresent("profile"));
		Assert.assertTrue(profile.isSettingPopUpTabsPresent("account"));
		
	}// End of SettingsPageLink()
	/*
	 * Use-case :Alerts Tab links 
	 * Test case :1) Open your profile page as logged-in user
                  2) Click on "alerts" tab appear Below the List statistics
	 * */
	@Test(priority = 2, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AlertsTab(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		UserProfilePage profile =BaseStateWithLogin("AlertsTab","testuserkallol1@mailinator.com", "testing");
		profile.clickOnProfile();
        profile.clickOnviewProfile();
        profile.clickOnFunTab(4);
		if (getDriver().getCurrentUrl().contains("dashboard")){
			Assert.assertEquals(1, 1);
		}
		else{
			Assert.assertEquals(1, 0);
		}
	}
    
	/*
	 * Use-case :notes Tab links 
	 * Test case :1) Open your profile page as logged-in user
                  2) Click on "notes" tab appear Below the List statistics
	 * */
	@Test(priority = 3, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void NotesTab(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		UserProfilePage profile =BaseStateWithLogin("NotesTablinks","testuserkallol1@mailinator.com", "testing");
		profile.clickOnProfile();
		profile.clickOnviewProfile();
		profile.clickOnFunTab(5);//nots tab
		if (getDriver().getCurrentUrl().contains("notes")){
			Assert.assertEquals(1, 1);
		}
		else{
			Assert.assertEquals(1, 0);
		}
	}
	 /*
	  * Use-case : Check Alerts page
	  * Test case : 1) Open your profile page as a logged in user
					2) Click on "Alerts" tab appear on top of the page
	  */
		@Test(priority = 4, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void CheckAlertsPage(String loginRequired) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to node page)
			UserProfilePage profile =BaseStateWithLogin("CheckAlertsPage","testuserkallol1@mailinator.com", "testing");
			profile.clickOnProfile();
			profile.clickOnviewProfile();
			profile.clickOnFunTab(4); //alert tab
			if(profile.getTextOfHeaderUnderAlert().trim().contains("prior alerts"))
			{	
				Assert.assertTrue(true);
			}
			else{
				Assert.assertTrue(false);
			}
	}// End of CheckAlertsPage()
	    /*
	     * Use-case : Check Notes
	     * Test case :1) Open your profile page as a logged in user
					  2) Click on "Notes" tab appear on top of the page     
		 */
			@Test(priority = 5, dataProviderClass = DataProviders.class, dataProvider = "Login")
			public void CheckNotes(String loginRequired) {
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
				// Base state. (Navigate to node page)
				UserProfilePage profile =BaseStateWithLogin("CheckAlertsPage","testuserkallol1@mailinator.com", "testing");
				profile.clickOnProfile();
				profile.clickOnviewProfile();
				profile.clickOnFunTab(5);// notes tab
				SafeActions s=new SafeActions(getDriver());
				s.waitForPageToLoad(40);
				Assert.assertTrue(profile.isUserNameInNotePresent("userName"));
				Assert.assertTrue(profile.isMessageInNotePresent("message"));
				Assert.assertTrue(profile.isTimeInNotePresent());
   }// End of CheckNotes eckNotes   
    /*
	 * Use-case : Organize your lists(display order)
	 * Test case : 1) Open your profile page as logged-in user
	               2) Click on "Organize my lists" link appear below the profile tabs
				   3) Re-order your lists by drag/drop or by numbering in the popup opened with all lists
	 */
	@Test(priority = 6, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void OrganizeYourList(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		UserProfilePage profile =BaseStateWithLogin("SettingsPageLink","testuserkallol1@mailinator.com", "testing");
		profile.clickOnProfile();
		profile.clickOnviewProfile();
		profile.clickBtnOrganizeMyList();
		String beforeListName=profile.getListNameOnOrganizeMyList(1);
		profile.changeOrderOfFirstListItem(3);
		String afterListName=profile.getListNameOnOrganizeMyList(3);
		Assert.assertEquals(beforeListName, afterListName);
	}// End of OrganizeYourList
	 /*
		 * Use-case : Hide lists from your profile page
		 * Test case : "1) Open your profile page as logged-in user
						2) Click on ""Organize my lists"" link appear below the profile tabs
						3) Check for the lists you don't want to display in your profile page"
	 */
		@Test(priority = 7, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void HideListFromYourProfilePage(String loginRequired) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to node page)
			UserProfilePage profile =BaseStateWithLogin("HideListFromYourProfilePage","testuserkallol1@mailinator.com", "testing");
			
			UeListPage ueList =new UeListPage(getDriver());
			ueList.clickOncreateList();
			ueList.clickOnreranking();
			 if(ueList.isStickyPresent()==true){
			 ueList.clickStickyOK();
			 }
			ueList.clickOnListName();
			ueList.putTextOnListNameBox("ListToBeHidden2");
			ueList.clickOnSearch();
			ueList.typesearchbtn("Batman");
			for (int i = 1; i <= 5; i++) {
				ueList.clickOnPlusIcon(i);
				SafeActions s = new SafeActions(getDriver());
			     s.waitForPageToLoad(40);
			}  
			ueList.clickOnpublishbtn();
			try{
				Thread.sleep(5000);
			}catch(Exception e){}
			profile.clickOnProfile();
	        profile.clickOnviewProfile();
			String beforeListName=profile.getListName(1);
			profile.clickBtnOrganizeMyList();
			profile.checkHideChkBoxOfListItem(1);
			profile.clickOnSaveChangesBtn();
			try{
				Thread.sleep(2000);
			}catch(Exception e){}
			String afterListName=profile.getListName(1);
			Assert.assertNotEquals(beforeListName, afterListName);
			profile.clickBtnOrganizeMyList();
			profile.checkHideChkBoxOfListItem(1);
			profile.clickOnSaveChangesBtn();
			try{
				Thread.sleep(5000);
			}catch(Exception e){}
			profile.deleteItemFromList(1);
			
		}// End of HideListFromYourProfilePage
	 /*
		 * Use-case : Delete list
		 * Test case : "1) Open your profile page as logged-in user
						2) Click on ""Delete"" button appear when you hover-over on a list
						3) Click ok in the confirmation popup opened"
	 */
		@Test(priority = 8, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void DeleteListFromYourProfilePage(String loginRequired) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to node page)
			UserProfilePage profile =BaseStateWithLogin("DeleteListFromYourProfilePage","testuserkallol1@mailinator.com", "testing");
			
			UeListPage ueList =new UeListPage(getDriver());
			ueList.clickOncreateList();
			ueList.clickOnreranking();
			 if(ueList.isStickyPresent()==true){
			 ueList.clickStickyOK();
			 }
			ueList.clickOnListName();
			ueList.putTextOnListNameBox("ListToBeDeleted");
			ueList.clickOnSearch();
			ueList.typesearchbtn("Batman");
			for (int i = 1; i <= 5; i++) {
				ueList.clickOnPlusIcon(i);
				SafeActions s = new SafeActions(getDriver());
			     s.waitForPageToLoad(40);
			}  
			ueList.clickOnpublishbtn();
			
			try{
				Thread.sleep(5000);
			}catch(Exception e){}
			profile.clickOnProfile();
			profile.clickOnviewProfile();
			try{
				Thread.sleep(3000);
			}catch(Exception e){}
			String beforeListName=profile.getListName(1);
			profile.deleteItemFromList(1);
			String afterListName=profile.getListName(1);
			Assert.assertNotEquals(beforeListName, afterListName);
		}// End of DeleteListFromYourProfilePage
		 /*
			 * Use-case : Check "Edit" link
			 * Test case :"1) Open your profile page as a logged in user
						   2) Click on ""Edit"" link apper on hover-over on list"
		  */
			@Test(priority = 9, dataProviderClass = DataProviders.class, dataProvider = "Login")
			public void EditListFromYourProfilePage(String loginRequired) {
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 9 !!!!!!!!!!!!!!!!!!!!!!!");
				// Base state. (Navigate to node page)
				UserProfilePage profile =BaseStateWithLogin("EditListFromYourProfilePage","testuserkallol1@mailinator.com", "testing");
				profile.clickOnProfile();
				profile.clickOnviewProfile();
				try{
				Thread.sleep(2000);}catch(Exception e){}
				profile.editListItemFromList(1);
				Assert.assertTrue(profile.isPresentUE());
	}// End of EditListFromYourProfilePage
    /*
  	 * Use-case : Profile Settings: Add about your self
  	 * Test case : "1) Open your profile page as a logged in user
					2) Click on ""settings"" link appear on right side top of the page
					3) Enter text in the ""About me"" text field
					4) Click on save on bottom of the page"
  	 */
  	@Test(priority = 10, dataProviderClass = DataProviders.class, dataProvider = "Login")
  	public void SettingsAddAboutYourSelf(String loginRequired) {
  		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 10 !!!!!!!!!!!!!!!!!!!!!!!");
  		// Base state. (Navigate to node page)
  		UserProfilePage profile =BaseStateWithLogin("SettingsAddAboutYourSelf","testuserkallol1@mailinator.com", "testing");
  		profile.clickOnProfile();
  		profile.clickOnviewProfile();
  		profile.clickOnSettingsBtn();
  		profile.typeAboutMe("This is me");
  		//profile.clickOnCloseSettings();
  		profile.clickOnclosebtn();
  		//profile.clickOnclosebtn();
  		Assert.assertTrue(profile.isAboutMeSectionExist("This is me"));
  	}// End of SettingsAddAboutYourSelf
   /*
  	 * Use-case : Profile Settings: Add your date of birth
  	 * Test case : "1) Open your profile page as a logged in user
					2) Click on ""settings"" link appear on right side top of the page
					3) Enter your date of birth using drop down's appear below ""about me"" text box
					4) Click on save on bottom of the page"
  	 */
  	@Test(priority = 11, dataProviderClass = DataProviders.class, dataProvider = "Login")
  	public void SettingsAddYourDOB(String loginRequired) {
  		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 11 !!!!!!!!!!!!!!!!!!!!!!!");
  		// Base state. (Navigate to node page)
  		int currentyear=2015;
  		UserProfilePage profile =BaseStateWithLogin("SettingsAddYourDOB","testuserkallol1@mailinator.com", "testing");
  		profile.clickOnProfile();
  		profile.clickOnviewProfile();
  		profile.clickOnSettingsBtn();
  		birthdate(profile);
  		profile.clickOnCloseSettings();
  		profile.clickOnCloseSettings();
//  		profile.clickOnclosebtn();
//  		profile.clickOnclosebtn();
  		try {
			Thread.sleep(10000);
		} catch (Exception e) {
		}
  		// if(sysProp.getProperty("Browser.Name").equals("ie")){
  	  		  Assert.assertEquals(profile.getyear(),((currentyear-2001))+ " yrs");//}
//  	  		 else{
//  	  			Assert.assertEquals(profile.getyear(),((currentyear-2001)-1)+ " yrs");
//  	  		 }
  	}// End of SettingsAddYourDOB
    /*
  	 * Use-case :   Profile Settings: Add your Address
  	 * Test case : "1) Open your profile page as a logged in user
					2) Click on "settings" link appear on right side top of the page
					3) Select you country using country drop down and city, state and Zip on corresponding text boxes
					4) Click on save on bottom of the page"
  	 */
  	@Test(priority = 12, dataProviderClass = DataProviders.class, dataProvider = "Login")
  	public void SettingsAddYourAddress(String loginRequired) {
  		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12 !!!!!!!!!!!!!!!!!!!!!!!");
  		// Base state. (Navigate to node page)
  		//int currentyear=2015;
  		UserProfilePage profile =BaseStateWithLogin("SettingsAddYourAddress","testuserkallol1@mailinator.com", "testing");
  		profile.clickOnProfile();
  		profile.clickOnviewProfile();
  		profile.clickOnSettingsBtn();
  		profile.selectcountry("India");
  		profile.typestate("mp");
  		profile.typecity("indore");
  		profile.typezip(452002);
  	    profile.clickOnCloseSettings();
  		profile.clickOnclosebtn();
  		//profile.clickOnCloseSettings();
		//profile.clickOnCloseSettings();
//  		profile.clickOnclosebtn();
//  		profile.clickOnclosebtn();
		//String add=profile.getaddress();
		if(profile.getaddress().trim().replaceAll(",", "").replaceAll("-", "").replaceAll(" ", "").equalsIgnoreCase("indorempIndia")){
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}	
  	}// End of SettingsAddYourAddress
  	/*
  	 * Use-case :   Profile Settings: Add your Gender
  	 * Test case : "1) Open your profile page as a logged in user
					2) Click on "settings" link appear on right side top of the page
					3) Check the Radio button beside the gender
					4) Click on save on bottom of the page
  	 */
  	@Test(priority = 13, dataProviderClass = DataProviders.class, dataProvider = "Login")
  	public void SettingsAddYourGender(String loginRequired) {
  		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 13 !!!!!!!!!!!!!!!!!!!!!!!");
  		// Base state. (Navigate to node page)
  		int currentyear=2015;
  		UserProfilePage profile =BaseStateWithLogin("SettingsAddYourGender","testuserkallol1@mailinator.com", "testing");
  		profile.clickOnProfile();
  		profile.clickOnviewProfile();
  		profile.clickOnSettingsBtn();
  		try{
  			Thread.sleep(3000);
  		}catch(Exception e){}
  		profile.clickongender();
  		profile.clickOnCloseSettings();
	    profile.clickOnCloseSettings();
//  		profile.clickOnclosebtn();
//  		profile.clickOnclosebtn();
  		Assert.assertTrue(profile.isselctiongender());
  	
  	}// End of SettingsAddYourGender
    /*
	 * Use-case :   Profile Settings: Add FB link, Twitter and Google+ link and your Own site link to your profile
	 * Test case : "1) Open your profile page as a logged in user
				2) Click on "settings" link appear on right side top of the page
				3) Enter a website link, website name to display, FB profile link and Twitter profile link in the corresponding fields with correct format of URL's
				4) Click on save on bottom of the page"
	 */
	@Test(priority = 14, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void SettingsAddYourSocialLinks(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 14 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		int currentyear=2015;
		UserProfilePage profile =BaseStateWithLogin("SettingsAddYourSocialLinks","testuserkallol1@mailinator.com", "testing");
		profile.clickOnProfile();
		profile.clickOnviewProfile();
		profile.clickOnSettingsBtn();
		profile.typewebsite("www.ranker.com");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		profile.typefacebook("https://www.facebook.com/vikas");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		profile.typetwitter("https://twitter.com/vikas");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		profile.typegoogle("https://www.plus.google.com/vikas");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		profile.scrollcloseSettingsforsociallinks();
		profile.clickOncloseSettingsforsociallinks();
		try {
		Thread.sleep(20000);
	} catch (Exception e) {
	}
    //profile.clickoncrossonprofilesetting();
    try {
		Thread.sleep(5000);
	} catch (Exception e) {
	}
     String href=profile.gethrefofsocialwindow("website");
     profile.clickonSocialwindow("website");
     ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
	 getDriver().switchTo().window(tabs2.get(1));
    try {
		Thread.sleep(5000);
	} catch (Exception e) {
	}
    String url1=getDriver().getCurrentUrl();
    if(url1.contains(href)){
    	Assert.assertEquals(1, 1);
    }else
    	Assert.assertEquals(1, 0);	
     getDriver().close();
	 getDriver().switchTo().window(tabs2.get(0));
    try {
		Thread.sleep(5000);
	} catch (Exception e) {
	}
    
    /// facebook///
     href=profile.gethrefofsocialwindow("facebook");
     profile.clickonSocialwindow("facebook");
     try {
			Thread.sleep(12000);
		} catch (Exception e) {
		}
     tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
	 getDriver().switchTo().window(tabs2.get(1));
    try {
		Thread.sleep(6000);
	} catch (Exception e) {
	}
    url1=getDriver().getCurrentUrl();
    if(href.contains(url1)){
    	Assert.assertEquals(1, 1);
    }else
    	Assert.assertEquals(1, 0);	
     getDriver().close();
	 getDriver().switchTo().window(tabs2.get(0));
    try {
		Thread.sleep(5000);
	} catch (Exception e) {
	}
  /// google+///
      href=profile.gethrefofsocialwindow("google+");
    profile.clickonSocialwindow("google+");
    try {
		Thread.sleep(12000);
	} catch (Exception e) {
	}
     tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
    getDriver().switchTo().window(tabs2.get(1));
    try {
		Thread.sleep(8000);
	} catch (Exception e) {
	}
    url1=getDriver().getCurrentUrl();
    if(url1.contains(".google.com")){
    	Assert.assertEquals(1, 1);
    }else
    	Assert.assertEquals(1, 0);	
     getDriver().close();
	 getDriver().switchTo().window(tabs2.get(0));
    try {
		Thread.sleep(5000);
	} catch (Exception e) {
	}
  /// twiter+///
     href=profile.gethrefofsocialwindow("twitter");
    profile.clickonSocialwindow("twitter");
    try {
		Thread.sleep(12000);
	} catch (Exception e) {
	}
    tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
    getDriver().switchTo().window(tabs2.get(1));
    try {
		Thread.sleep(9000);
	} catch (Exception e) {
	}
    url1=getDriver().getCurrentUrl();
    if(url1.contains(href)){
    	Assert.assertEquals(1, 1);
    }else
    	Assert.assertEquals(1, 0);	
    getDriver().close();
	 getDriver().switchTo().window(tabs2.get(0));
    try {
		Thread.sleep(5000);
	} catch (Exception e) {
	}
	}//  of SettingsAddYourSocialLinks
  /*
   * Use-case : Reply to a note
   * Test case : 1) Open your profile page as a logged in user
 				2) Click on "Notes" tab on top of the page
 				3) Click "Send note back" link appear just below the note content
 				4) Enter text in the text box opened and click on "send"
   */
 	@Test(priority = 15, dataProviderClass = DataProviders.class, dataProvider = "Login")
 	public void ReplyToNote(String loginRequired) {
 		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 15 !!!!!!!!!!!!!!!!!!!!!!!");
 		// Base state. (Navigate to node page)
 		UserProfilePage profile =BaseStateWithLogin("ReplyToNote","testuserkallol1@mailinator.com", "testing");
 		profile.clickOnProfile();
 		profile.clickOnviewProfile();
 		profile.clickOnFunTab(5);
 		profile.clickOnSendNoteBack("sendNoteBack");
 		profile.typeTextInNoteTextBox("This is testing note");
 		profile.clickOnSendNoteBtn();
 		try{
 			Thread.sleep(6000);
 		}catch(Exception e){}
 		profile.clickOnSentNote(2);
 		Assert.assertTrue(profile.isMessageInNotePresent("message"));//sent message
 	}// End of ReplyToNote
     /*
      * Use-case : Block a user to not to send you a note
      * Test case :1) Open your notes tab in profile page(Make sure you have an existing note)
 				  2) Click "Block this user" link appear just below the user name who sent you a note
      */
    	@Test(priority = 16, dataProviderClass = DataProviders.class, dataProvider = "Login")
    	public void BlockUser(String loginRequired) {
    		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 16 !!!!!!!!!!!!!!!!!!!!!!!");
    		// Base state. (Navigate to node page)
    		UserProfilePage profile =BaseStateWithLogin("BlockUser","testuserkallol1@mailinator.com", "testing");
    		profile.clickOnProfile();
    		profile.clickOnviewProfile();
    		profile.clickOnFunTab(5);
    		
    		String txt=profile.getTextOfUnblockUser("blockUser");
    		if(txt.contains("block this user")){
    			profile.clickOnBlockUnblockUser("blockUser");//user blocked
    		}
    		else{
    			profile.clickOnBlockUnblockUser("unblockUser");//user unblocked
    			profile.clickOnBlockUnblockUser("blockUser");//user blocked
    		}
    		txt=profile.getTextOfUnblockUser("unblockUser");
    		try{
    			Thread.sleep(6000);
    		}catch(Exception e){}
    		if(txt.contains("unblock this user")) 
    			Assert.assertTrue(true);
    		else
    			Assert.assertTrue(false);
    		try{
    			Thread.sleep(2000);
    		}catch(Exception e){}
    		profile.clickOnBlockUnblockUser("UnBlockUser");// user unblocked
    	}// End of BlockUser  
   /*
    * Use-case : Un-Block a user to allow to send you a note
    * Test case :1) Open your notes tab in profile page(Make sure you have an existing note and you have blocked a corresponding user)
 			     2) Click "unblock this user" link appear just below the user name whom you had blocked
    */
 	@Test(priority = 17, dataProviderClass = DataProviders.class, dataProvider = "Login")
 	public void UnblockUser(String loginRequired) {
 		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 17 !!!!!!!!!!!!!!!!!!!!!!!");
 		// Base state. (Navigate to node page)
 		UserProfilePage profile =BaseStateWithLogin("UnblockUser","testuserkallol1@mailinator.com", "testing");
 		profile.clickOnProfile();
 		profile.clickOnviewProfile();
 		profile.clickOnFunTab(5);
 		
 		String txt=profile.getTextOfUnblockUser("blockUser");
		if(txt.contains("block this user")){
			profile.clickOnBlockUnblockUser("blockUser");//user blocked
		}
		else{
			profile.clickOnBlockUnblockUser("unblockUser");//user unblocked
			profile.clickOnBlockUnblockUser("blockUser");//user blocked
		}
 		
 		//profile.clickOnBlockUnblockUser("blockUser");//user blocked
 		try{
 			Thread.sleep(2000);
 		}catch(Exception e){}
 		profile.clickOnBlockUnblockUser("UnBlockUser");// user unblocked
 		 txt=profile.getTextOfUnblockUser("unblockUser");
 		if(txt.contains("block this user")) 
 			Assert.assertTrue(true);
 		else
 			Assert.assertTrue(false);
 	}// End of UnblockUser
 
   /*
    * Use-case : Account settings: change your eMail
    * Test case :1) Open your profile page as a logged in user
				2) Click on "settings" link appear on right side top of the page
				3) Click on "my account" link in the page opened
				4) Change your email in change email address text field 
				5) Click on save on bottom of the page
    */
    @Test(priority = 18, dataProviderClass = DataProviders.class, dataProvider = "Login")
        public void EmailSettings(String loginRequired) {
    	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 18 !!!!!!!!!!!!!!!!!!!!!!!");
    	// Base state. (Navigate to node page)
    	UserProfilePage profile =BaseState("EmailSettings");
    	//Home home = new Home(getDriver());
		//home.doLogout();
		newAccount(profile,"username","emailAccount","email","TestNewEmailAccount@new.com","password","email123","termsAccept","signup");;
    	profile.clickOnProfile();
    	profile.clickOnviewProfile();
    	profile.clickOnSettingsBtn();
    	profile.clickOnaccountSettings();
    	profile.clickOnEmailBox();
    	profile.typeIdInEmail("test1@gmail.com");
    	try{
    		Thread.sleep(2000);
    	}catch(Exception e){}

    	//profile.clickOnclosebtn();
    	profile.clickOnaccountSettings();
    	profile.clickOnclosebtn();
    	//recheck of email-id entered
    	try{
    		Thread.sleep(4000);
    	}catch(Exception e){}
    	profile.clickOnSettingsBtn();
    	profile.clickOnaccountSettings();
    	String email=profile.getTextOfEmailBox();
    	Assert.assertEquals(email, "test1@gmail.com");
    	//profile.clickOnCloseSettings();
    	profile.clickOnclosebtn();
    	
    	//Delete the account.
    	profile.clickOnSettingsBtn();
    	profile.clickOnaccountSettings();
    	profile.clickOnEmailBox();
    	profile.typeIdInEmail("TestNewEmailAccount@new.com");
    	profile.clickOnaccountSettings();
    	//profile.clickOnclosebtn();
    	profile.clickOnDeleteAccount();
		common.AlertExistsAndAccepted(2000);
    	
    }// End of EmailSettings
	/*
  	 * Use-case : Check your feed
  	 * Test case : "1) Open your profile page as a logged in user
                    2) Click on "Following" tab appear on top of the page
                    3) Click on any of the links appear under "your feed"
  	 */
  	@Test(priority = 19, dataProviderClass = DataProviders.class, dataProvider = "Login")
  	public void Checkyourfeed(String loginRequired) {
  		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 19 !!!!!!!!!!!!!!!!!!!!!!!");
  		// Base state. (Navigate to node page)
  		UserProfilePage profile =BaseStateWithLogin("Checkyourfeed","testuserkallol1@mailinator.com", "testing");
  		profile.clickOnProfile();
  		profile.clickOnviewProfile();
		profile.clickOnFunTab(3);
		try{
			Thread.sleep(5000);
		}catch(Exception e){}
		if (getDriver().getCurrentUrl().contains("feed")){
			Assert.assertEquals(1, 1); 
		}
		else{
			Assert.assertEquals(1, 0);
		}
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		for(int i=1;i<=3;i++)
		{
			Assert.assertTrue(profile.isPresentfollw3tab(i));	
		}
 }// End of check your feed
  	/*
  	 * Use-case : Try sending note as Blocked user
  	 * Test case : 1) Open any other user profile page(Make sure that corresponding user has blocked you)
				   2) Send note by clicking "Send note" on top of profile page
  	 */
  	@Test(priority = 20, dataProviderClass = DataProviders.class, dataProvider = "Login")
  	public void BlockedUserNote(String loginRequired) {
  		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 20 !!!!!!!!!!!!!!!!!!!!!!!");
  		// Base state. (Navigate to node page)
  		common = new Commonpage(getDriver());
  		Home home = new Home(getDriver());
  		UserProfilePage profile =BaseStateWithLogin("BlockedUserNote","testuserkallol1@mailinator.com", "testing");
  		profile.clickOnProfile();
  		profile.clickOnviewProfile();
  		profile.clickOnFunTab(5); //notes
  		profile.clickOnBlockUnblockUser("block");
        home.doLogout();
        try {
			Thread.sleep(3000);
		} catch (Exception e) {}
  		common.signin("testvikas1", "123456");//testvikas1/123456
  		//common.getNewURL(config.getProperty("Url")+"profile-of/testuserkallol1");
  		profile.clickOnSendaNoteLink();
  		profile.typeTextInNoteTextBox("blocked user has sent a note");
  		profile.clickOnSendNoteBtn();
  		try{
  			Thread.sleep(2000);
  		}catch(Exception e){}
  		home.doLogout();
  		//
  		common.signin("testuserkallol1@mailinator.com", "testing");
  		profile.clickOnProfile();
  		profile.clickOnviewProfile();
  		profile.clickOnFunTab(5); //notes
  		String txt=profile.getTextOfMessageInNote("message");
  		Assert.assertNotEquals("blocked user has sent a note", txt);
  		profile.clickOnBlockUnblockUser("Unblock");
  	}// End of BlockedUserNote

   /*
     * Use-case : Account Settings: Change your password
     * Test case : "1) Open your profile page as a logged in user
                  2) Click on "settings" link appear on right side top of the page
                  3) Click on "my account" link in the page opened
                  4) Enter your Old password and New password in the corresponding fields 
                  5) Click on save on bottom of the page
     */
    @Test(priority = 21, dataProviderClass = DataProviders.class, dataProvider = "Login")
    public void Changeyourpassword(String loginRequired) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 21 !!!!!!!!!!!!!!!!!!!!!!!");
        // Base state. (Navigate to node page)
        UserProfilePage profile =BaseState("Changeyourpassword");
    	Home home = new Home(getDriver());
		//home.doLogout();
        newAccount(profile,"username","newAccount1","email","newAccount1@gmail.com","password","123456","termsAccept","signUp");
        profile.clickOnProfile();
        profile.clickOnviewProfile();
        profile.clickOnSettingsBtn();
        profile.clickOnaccountSettings();
        profile.clickOnchangePasswordold();
      profile.typechangePasswordold("123456");
      profile.clickOnchangePasswordnew();
      profile.typechangePasswordnew("654321");
      profile.clickOnaccountSettings();// Random Click for saving changes.
//      profile.scrollClosebtn();
//      try{
//    	  Thread.sleep(3000);
//      }catch(Exception e){}
//      profile.clickOnclosebtn();
      try{
    	  Thread.sleep(4000);
      }catch(Exception e){}
      //for closing the window
      profile.clickOnclosebtn();
      try{
         home.doLogout();
         //Checking for old password
	      profile.signin("newAccount1", "123456");
	  	  profile.clickSubmit();
	     String txt=profile.getTextOfMessageUnderPwdBox(2);
	     Assert.assertEquals(txt, "Oops, it's the wrong password (passwords are case-sensitive)");
	     profile.clickOnCloseSignIn();
      // resetting the changes
      common.signin("newAccount1", "654321");
      profile.clickOnProfile();
      profile.clickOnviewProfile();
      profile.clickOnSettingsBtn();
      profile.clickOnaccountSettings();
      profile.clickOnDeleteAccount();
      common.AlertExistsAndAccepted(2000);
      }catch(Exception e){
    	  common.signin("newAccount1", "654321");
          profile.clickOnProfile();
          profile.clickOnviewProfile();
          profile.clickOnSettingsBtn();
          profile.clickOnaccountSettings();
          profile.clickOnDeleteAccount();
          common.AlertExistsAndAccepted(2000);
      }
    }//End of Changeyourpassword()
  /*
	 * Use-case : Send note as UN-Blocked user
	 * Test case : 1) Open any other user profile page(Make sure that corresponding user has blocked you and un-blocked)
				   2) Try sending note by clicking "Send note" on top of profile page
	 */
	@Test(priority = 22, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void UnblockedUserNote(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 22 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		UserProfilePage profile =BaseStateWithLogin("UnblockedUserNote","testuserkallol1@mailinator.com", "testing");
		profile.clickOnProfile();
		profile.clickOnviewProfile();
		profile.clickOnFunTab(5); //notes
		
		String txt=profile.getTextOfUnblockUser("blockUser");
		if(txt.contains("block this user")){
			profile.clickOnBlockUnblockUser("blockUser");//user blocked
		}
		else{
			profile.clickOnBlockUnblockUser("unblockUser");//user unblocked
			profile.clickOnBlockUnblockUser("blockUser");//user blocked
		}
		
		//profile.clickOnBlockUnblockUser("block");
		profile.clickOnBlockUnblockUser("Unblock");
		Home home = new Home(getDriver());
        home.doLogout();
        //UN-blocked user sign in.
        common.signin("testvikas1", "123456");//testvikas1/123456
		profile.clickOnSendaNoteLink();
		profile.typeTextInNoteTextBox("UN-Blocked user has sent the note");
		profile.clickOnSendNoteBtn();
		try{
			Thread.sleep(6000);
		}catch(Exception e){}
		home.doLogout();
        //
		common.signin("testuserkallol1@mailinator.com", "testing");
		profile.clickOnProfile();
		profile.clickOnviewProfile();
		profile.clickOnFunTab(5); //notes
		String txt1=profile.getTextOfMessageInNote("message");
		try{
			Thread.sleep(4000);
		}catch(Exception e){}
		Assert.assertEquals("UN-Blocked user has sent the note", txt1);
	}// End of UnblockedUserNote()
  /*
	 * Use-case : Check the options to digest the comments and digest activities
	 * Test case : 1) Open your profile page as a logged in user
					2) Click on "settings" link appear on right side top of the page
					3) Click on "my account" link in the page opened
					4) Check the radio buttons beside "Comment digest type" and "Activities digest type"  
					5) Click on save on bottom of the page
	 */
	@Test(priority = 23, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void DigestCommentActivity(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 23 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		UserProfilePage profile =BaseStateWithLogin("UnblockedUserNote","testuserkallol1@mailinator.com", "testing");
		profile.clickOnProfile();
		profile.clickOnviewProfile();
		profile.clickOnSettingsBtn();
		profile.clickOnaccountSettings();
		Assert.assertTrue(profile.isRadBtnCommentDigestSelected(3));
		Assert.assertTrue(profile.isRadBtnActivityDigestSelected(2));
		profile.clickOnclosebtn();
		
	}// End of DigestCommentActivity()
    /*
	 * Use-case : Account settings: Delete your account
	 * Test case : 1) Open your profile page as a logged in user
					2) Click on "settings" link appear on right side top of the page
					3) Click on "my account" link in the page opened
					4) Click on "Delete Account" appear on bottom of the page and click yes ins the popup opened

	 */
	@Test(priority = 24, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void DeleteAccount(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 24 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		UserProfilePage profile =BaseState("UnblockedUserNote");
//		Home home = new Home(getDriver());
//		home.doLogout();
		newAccount(profile,"username","TestNewAccount","email","TestNewAccount@new.com","password","delete123","termsAccept","signUp");
		profile.clickOnProfile();
		profile.clickOnviewProfile();
		profile.clickOnSettingsBtn();
		profile.clickOnaccountSettings();
		profile.clickOnDeleteAccount();
		common.AlertExistsAndAccepted(2000);
		
	}// End of DeleteAccount()
//    ////  non login user
     /*
	 * Use-case : Check for profile Name and profile Image
	 * Test case : Open any profile page
	 */
	@Test(priority = 25, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void CheckProfile_Name_Image(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 25 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		UserProfilePage profile =BaseState("CheckProfile_Name_Image");
		common.getNewURL(config.getProperty("Url")+"profile-of/testvikas2");
		Assert.assertTrue(profile.isPresentprofile_image());
		Assert.assertTrue(profile.isPresentprofile_name());
	}// End of CheckProfile_Name_Image()
	/*
	 * Use-case : Check for Profile Description
	 * Test case : Open any profile page
	 */
	@Test(priority = 26, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void CheckProfileDescription(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 26 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		UserProfilePage profile =BaseState("CheckProfile_Description");
		common.getNewURL(config.getProperty("Url")+"profile-of/testvikas2");
		Assert.assertTrue(profile.isPresentprofileDescription());
		Assert.assertNotNull(profile.getprofileDescription());
	}// End of CheckProfile_Description()
	/*
	 * Use-case : Check for social media links of user defined
	 * Test case : 1) Open any profile page
				   2) Click on any of the social media links(FB) just below the profile description
	 */
	@Test(priority = 27, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void CheckSocialLinks(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 27 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		 UserProfilePage profile =BaseState("Check_Social_links");
		 common.getNewURL(config.getProperty("Url")+"profile-of/testvikas2");
		 String href=profile.gethrefofsocialwindow("website");
	     profile.clickonSocialwindow("website");
	     ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
		 getDriver().switchTo().window(tabs2.get(1));
	    try {
				Thread.sleep(5000);
		} catch (Exception e) {}
	    String url1=getDriver().getCurrentUrl();
	    if(url1.contains("facebook")){
	    	Assert.assertEquals(1, 1);
	    }else
	    	Assert.assertEquals(1, 0);	
	     getDriver().close();
		 getDriver().switchTo().window(tabs2.get(0));
	    try {
			Thread.sleep(5000);
		} catch (Exception e) {}
	   
	    /// facebook///
		 href=profile.gethrefofsocialwindow("facebook");
	     profile.clickonSocialwindow("facebook");
	     try {
				Thread.sleep(12000);
			} catch (Exception e) {
			}
	     tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
	   //  tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
		 getDriver().switchTo().window(tabs2.get(1));
	    try {
			Thread.sleep(6000);
		} catch (Exception e) {
		}
        url1=getDriver().getCurrentUrl();
	    if(url1.contains("vikas")){
	    	Assert.assertEquals(1, 1);
	    }else
	    	Assert.assertEquals(1, 0);	
	     getDriver().close();
		 getDriver().switchTo().window(tabs2.get(0));
	    try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
	  /// google+///
	      href=profile.gethrefofsocialwindow("google+");
	    profile.clickonSocialwindow("google+");
	    try {
			Thread.sleep(12000);
		} catch (Exception e) {
		}
	     tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
	    getDriver().switchTo().window(tabs2.get(1));
	    try {
			Thread.sleep(8000);
		} catch (Exception e) {
		}
	    url1=getDriver().getCurrentUrl();
	    if(url1.contains("google")){
	    	Assert.assertEquals(1, 1);
	    }else
	    	Assert.assertEquals(1, 0);	
	     getDriver().close();
		 getDriver().switchTo().window(tabs2.get(0));
	    try {
			Thread.sleep(5000);
		} catch (Exception e) {}
	  
	    /// twiter+///
	     href=profile.gethrefofsocialwindow("twitter");
	    profile.clickonSocialwindow("twitter");
	    try {
			Thread.sleep(12000);
		} catch (Exception e) {
		}
	    tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
	    getDriver().switchTo().window(tabs2.get(1));
	    try {
			Thread.sleep(15000);
		} catch (Exception e) {}
	    url1=getDriver().getCurrentUrl();
	    if(url1.contains("twitter")){
	    	Assert.assertEquals(1, 1);
	    }else
	    	Assert.assertEquals(1, 0);	
	     getDriver().close();
		 getDriver().switchTo().window(tabs2.get(0));
		
	}// End of CheckSocialLinks()
    /*
	 * Use-case : Check for Profile statistics
	 * Test case : Open any profile page
	 */
	@Test(priority = 28, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void CheckProfile_statistics(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 28 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		UserProfilePage profile =BaseState("CheckProfile_Name_Image");
		common.getNewURL(config.getProperty("Url")+"profile-of/testvikas2");
		Assert.assertTrue(profile.isPresentProfile_statistics("lists"));
		Assert.assertTrue(profile.isPresentProfile_statistics("views"));
		Assert.assertTrue(profile.isPresentProfile_statistics("votes cast"));
	}// End of CheckProfile_statistics()
    /*
	 * Use-case : Check sorting dropdown
	 * Test case : 1) Open any profile page
				   2) Click on "My Top Lists" appear below the Profile Image
				   3) Select any one option the the dropdown opened
	 */
	@Test(priority = 29, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void CheckSorting(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 29!!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		UserProfilePage profile =BaseState("Check_Sorting");
		common.getNewURL(config.getProperty("Url")+"profile-of/testvikas2");
		Assert.assertTrue(profile.isPresentsortingDropdown());
		
		String before=profile.getviewbesortingViewed();
		profile.clickonsortingDropdown();
		profile.clickonsortingMostViewed(3);
		try {
			Thread.sleep(4000);
		} catch (Exception e) {}
		String after=profile.getviewbesortingViewed();
		Assert.assertNotEquals(before, after);
	}// End of Check_Sorting()
    /*
 	 * Use-case : Follow user
 	 * Test case : 1) Open any profile page
				   2) Click on "Follow" button appear beside the user profile page			
 	 */
 	@Test(priority = 30, dataProviderClass = DataProviders.class, dataProvider = "Login")
 	public void Follow_user(String loginRequired) {
 		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 30 !!!!!!!!!!!!!!!!!!!!!!!");
 		// Base state. (Navigate to node page)
 		UserProfilePage profile =BaseState("Follow_user");
 		common.getNewURL(config.getProperty("Url")+"profile-of/testvikas2");
 		profile.clickonfollow();
 		Assert.assertTrue(profile.isPresentloginpopup());
 	}// End of Follow_user()
    /*
 	 * Use-case :  Send a note
 	 * Test case :  1) Open any profile page
					2) Click on "Send Note" link appear below the profile statistics
					
 	 */
 	@Test(priority = 31, dataProviderClass = DataProviders.class, dataProvider = "Login")
 	public void Send_Note(String loginRequired) {
 		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 31 !!!!!!!!!!!!!!!!!!!!!!!");
 		// Base state. (Navigate to node page)
 		UserProfilePage profile =BaseState("Send_Note");
 		common.getNewURL(config.getProperty("Url")+"profile-of/testvikas2");
 		profile.clickOnSendaNoteLink();
 		try{
 			Thread.sleep(2000);
 		}catch(Exception e){}
 		String msg=profile.getalertmsg();
 		Assert.assertEquals("Please login or register to send a note!", msg);
 		//Assert.assertTrue(profile.isPresentloginpopup());
 	}// End of Send_Note()
    /*
 	 * Use-case :   Rerank list hover-over
 	 * Test case :  1) Open any Profile page
					2) Hover-over mouse on list name under reranked lists section
 	 */
 	@Test(priority = 32, dataProviderClass = DataProviders.class, dataProvider = "Login")
 	public void Rerank_List_hover(String loginRequired) {
 		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 32 !!!!!!!!!!!!!!!!!!!!!!!");
 		UserProfilePage profile =BaseState("Rerank_List_hover");
 		common.getNewURL(config.getProperty("Url")+"profile-of/hoserusc");
 		int search =0;
 		int num=0;
 		for(int i=1;i<=30;i++){
 		      if(profile.isPresent_rank_list_search(i,"my rerank of ")==true)
 		       {
 			     search=1;
 			     num=i;
 			     break;
 		       }
 		}
 		if(search==1){
 			profile.hoveron_reranklist(num);
	 		try {
				Thread.sleep(5000);
			} catch (Exception e) {}
	 		Assert.assertTrue(profile.isPresent_rerank_list_icon());
	 		for(int j=1;j<=3;j++){
	 		Assert.assertTrue(profile.isPresent_rerank_list_3items(j));
	 		}
	 		Assert.assertTrue(profile.isPresentreranklistbtn());
	 		Assert.assertTrue(profile.isPresentreranklistnumber());
 		}
 		
 	}// End of Rerank_List_hover()
    /*
	 * Use-case :   List links
	 * Test case :  1) Open any profile page
					2) Click on any of the list links	
	 */
	@Test(priority = 33, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void List_Links(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 33 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		UserProfilePage profile =BaseState("List_Links"); 
		common.getNewURL(config.getProperty("Url")+"profile-of/hoserusc");
		/// i list
		String before=profile.gethrefofreranklist(1);
		profile.clickOnreranklist(1);
		try{
			Thread.sleep(4000);
		}catch(Exception e){}
		profile.cancelLoading();
		System.out.println("1111111111111111111111111 ");
		String after=getDriver().getCurrentUrl();
		String[] substring1 = after.split("\\?");
		Assert.assertEquals(substring1[0], before);
		Assert.assertTrue(profile.isPresentreranklistname());
		Assert.assertNotNull(profile.isPresentreranklistdescription());
		getDriver().navigate().back();
		//"My Rerank of" list
		int search =0;
 		int num=0;
 		for(int i=1;i<=30;i++){
 		       if(profile.isPresent_rank_list_search(i,"my rerank of ")==true)
 		       {
 			     search=1;
 			     num=i;
 			     break;
 		       }
 		}
		if(search==1){
			before=profile.gethrefofreranklist(num);
			profile.clickOnreranklist(num);
			try{
				Thread.sleep(4000);
			}catch(Exception e){}
			System.out.println("222222222222222222222222222 ");
		    after=getDriver().getCurrentUrl();
		    String[] substring2 = after.split("\\?");
			Assert.assertEquals(substring2[0], before);
			Assert.assertTrue(profile.isPresentreranklistname());
			Assert.assertNotNull(profile.isPresentreranklistdescription());
 		}
		getDriver().navigate().back();
		//"Original Ranker of" list
		 search =0;
 		 num=0;
 		for(int i=1;i<=30;i++){
 		       if(profile.isPresent_rank_list_search(i,"original ranker of ")==true)
 		       {
 			     search=1;
 			     num=i;
 			     break;
 		       }
 		}
		if(search==1){
			before=profile.gethrefofreranklist(num);
			profile.clickOnreranklist(num);
			try{
				Thread.sleep(4000);
			}catch(Exception e){}
			System.out.println("33333333333333333333333333 ");
		    after=getDriver().getCurrentUrl();
		    String[] substring3 = after.split("\\?");
			Assert.assertEquals(substring3[0], before);
			Assert.assertTrue(profile.isPresentreranklistname());
			Assert.assertNotNull(profile.isPresentreranklistdescription());
 		}
	}// End of List_Links()
	/*
	 * Use-case  : Badges tab
	 * Test case :1) Open any profile page
                  2) Click on "badges" tab appear below the profile statistics
	 * */
	@Test(priority = 34, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void BadgesTab(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 34 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		UserProfilePage profile =BaseState("BadgesTab"); 
		common.getNewURL(config.getProperty("Url")+"profile-of/testvikas2");
        profile.clickOnFunTab(3);
		if (getDriver().getCurrentUrl().contains("badges")){
			Assert.assertEquals(1, 1);
		}
		else{
			Assert.assertEquals(1, 0);
		}
		Assert.assertTrue(profile.isPresentbadgelist());
	}//end of BadgesTab
    /*
	 * Use-case : Following tab
	 * Test case : "1) Open any Profile page
                    2) Click on "Following" link below the profile statistics
	 */
	@Test(priority = 35, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FollowingTab(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 35 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		UserProfilePage profile =BaseState("FollowingTab"); 
		common.getNewURL(config.getProperty("Url")+"profile-of/testvikas2");
        profile.clickOnFunTab(2);
	try{
		Thread.sleep(5000);
	}catch(Exception e){}
    //System.out.println("getDriver().getCurrentUrl()==="+getDriver().getCurrentUrl());
	if (getDriver().getCurrentUrl().contains("following")){
		Assert.assertEquals(1, 1); 
	}
	else{
		Assert.assertEquals(1, 0);
	}
	for(int i=1;i<=2;i++)
	{
		Assert.assertTrue(profile.isPresentfollw3tab(i));	
	}
	}// End of FollowingTab
    /*
	 * Use-case :  Lists tab pagination
	 * Test case : "1) Open any Profile page
					2) Paginate to next page
	 */
	@Test(priority = 36, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ListPagination(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 36 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		UserProfilePage profile =BaseState("ListPagination"); 
		common.getNewURL(config.getProperty("Url")+"profile-of/testvikas2");
		for(int i=1;i<=25;i++){
		Assert.assertTrue(profile.isPresent25list(i));}
		String before=profile.gethrefofpagination();
		profile.clickOnpagination();
		try{
			Thread.sleep(8000);
		}catch(Exception e){}
		String after=getDriver().getCurrentUrl();
		Assert.assertEquals(before, after);
	}// End of ListPagination
	/*
	 * Use-case :  Profile page and List links in Following and Follower's pages
	 * Test case :  1) Open any profile page
					2) Click on "Following" link appear on the top of the page
					3) Click on any of the profile page links appear in any of the two tabs
	 */
	@Test(priority = 37, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FollowingFollowersPage(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 37 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		UserProfilePage profile =BaseState("FollowingFollowersPage"); 
		common.getNewURL(config.getProperty("Url")+"profile-of/testvikas2");
        profile.clickOnFunTab(2);
		try{
			Thread.sleep(2000);
		}catch(Exception e){}
		String before=profile.gethrefoffollowslist(1);
		profile.clickOnfollowslist(1);
		try{
			Thread.sleep(2000);
		}catch(Exception e){}
		String after=getDriver().getCurrentUrl();
		Assert.assertEquals(before, after);
		getDriver().navigate().back();
		//profile.clickOnFunTab(2);
		profile.clickOnfollowinglist(2);
		try{
			Thread.sleep(4000);
		}catch(Exception e){}
	//	profile.clickOnfollowslist(1);
		 before=profile.gethrefoffollowslist(1);
		 try{
				Thread.sleep(2000);
			}catch(Exception e){}
		profile.clickOnfollowslist(1);
		 try{
				Thread.sleep(2000);
			}catch(Exception e){}
		after=getDriver().getCurrentUrl();
		Assert.assertEquals(before, after);
 }// End of FollowingFollowersPage
  	/*
  	 * 
  	 */
 	public void birthdate(UserProfilePage  profile)
  	{
  	profile.selectbirthmonth("Jan");
 	profile.selectbirthday(3);
 	profile.selectyear(2001);
  	} 
 	/*
 	 * Function for creating a new account.
 	 */
 	public void newAccount(UserProfilePage profile, String txt1, String txt2, String txt3, String txt4, String txt5, String txt6, String terms, String signup){
 		profile.clickOnNewAccSignIn();
 		profile.clickOnJoining();
 		profile.clickOnMailIcon();
 		profile.typeInNewAccount(txt1,txt2);//username,TestNewAccount
 		profile.typeInNewAccount(txt3,txt4);//"email","TestNewAccount@new.com"
 		profile.typeInNewAccount(txt5,txt6);//"password","delete123"
 		profile.checkAcceptTerms(terms);//"termsAccept"
 		profile.clickOnSignUp(signup);//"signUp"
 	} // End of newAccount()
    /*
	  * This is base state of the slide show test-cases.
	  */
	 public UserProfilePage BaseState(String testName){
		 try{
		 startRecording(testName);
		}catch(Exception e){}
		 common=new Commonpage(getDriver());
		 UserProfilePage profile=common.getUserProfilePage(url);
		 return profile;
	 } //End of BaseState()
	 /*
		 * This is base state of the UE List test-cases.
		 */
		public UserProfilePage BaseStateWithLogin(String testName,String id,String pwd) {
			try {
				startRecording(testName);
			} catch (Exception e) {
			}
			common = new Commonpage(getDriver());
			UserProfilePage profile = common.getUserProfilePage(url);
			common.signin(id,pwd);
			//common.signin("testuserkallol1@mailinator.com", "testing");
			// UeListPage ueList=common.getUeListPage(url);
			return profile;
		} // End of BaseStateWithLogin()
}
