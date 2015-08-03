package com.testsuite.ListOptionTests;

import java.awt.List;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.swing.text.html.ListView;

import org.openqa.selenium.remote.server.handler.SwitchToWindow;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.paeobjects.home.Home;
import com.paeobjects.navbar.NavBar;
import com.pageobject.login.SigninPage;
import com.pageobjects.grid.Grid;
import com.pageobjects.listheader.ListHeader;
import com.pageobjects.listoption.ListOptionPage;
import com.pageobjects.nodepage.Nodepage;
import com.pageobjects.uelist.UeListPage;
import com.selenium.SafeActions;
import com.testsuite.UeListTest.UeListTest;

public class ListOptionTest extends BaseSetup {
	ConfigManager urls = new ConfigManager("PreProduction");
	ConfigManager sysProp = new ConfigManager("Sys");
	Commonpage common;
	Home home= new Home(getDriver());
	String url = config.getProperty("Url") + urls.getProperty("VoteList");

	/*
	 * Wait for browser.
	 */
	public void browserWait() {
		if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			try {
				Thread.sleep(5000);
			} catch (Exception e) {}
		}
	}

	/*
	 * Use-case : More Options 
	 * Test case : 1) Open any list 
	 * 				2) Click on
	 * "More Options" link appear just above the list items
	 */
	@Test(priority = 1, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void HeaderOption(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("HeaderOption");
		} else {
			listoptionpage = BaseState("HeaderOption");
		}
		listoptionpage.clickOnheaderoption();
		for (int i = 1; i <= 8; i++) {
			Assert.assertTrue(listoptionpage.isheaderoptionPopUpPresent(i));
		}
	}// End of HeaderOption

	/*
	 * Use-case : More Options 
	 * Test case : 1) Open any list 
	 		       2) Click on "More Options" and click add item.
	 */
	@Test(priority = 2, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void HeaderOptionAdditem(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("HeaderOptionAdditem");
		} else {
			listoptionpage = BaseState("HeaderOptionAdditem");
		}
		listoptionpage.clickOnheaderoption();
		listoptionpage.clickOnheaderoptionpopup("Add Item");
		Assert.assertTrue(listoptionpage.isadditemPresent());
	}// End of HeaderOptionAdditem

	/*
	 * Use-case : More Options Test case : 1) Open any list 2) Click on
	 * "More Options" link appear and click view as list
	 */
	@Test(priority = 3, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void HeaderOptionViewslist(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("HeaderOptionViewslist");
		} else {
			listoptionpage = BaseState("HeaderOptionViewslist");
		}
		listoptionpage.clickOnheaderoption();
		listoptionpage.clickOnheaderoptionpopup("View as List");
		if (getDriver().getCurrentUrl().contains("format=GRID") && getDriver().getCurrentUrl().contains(url)){
			Assert.assertEquals(1, 1);
		}
		else{
			Assert.assertEquals(1, 0);
		    }
		//Assert.assertEquals(url + "?format=GRID", getDriver().getCurrentUrl());
	}// End of HeaderOptionViewslist

	/*
	 * Use-case : More Options Test case : 1) Open any list 2) Click on
	 * "More Options" link appear and click view as Blog
	 */
	@Test(priority = 4, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void HeaderOptionViewsBlog(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("HeaderOptionViewsBlog");
		} else {
			listoptionpage = BaseState("HeaderOptionViewsBlog");
		}
		listoptionpage.clickOnheaderoption();
		listoptionpage.clickOnheaderoptionpopup("View as Blog");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		if (getDriver().getCurrentUrl().contains("format=BLOG") && getDriver().getCurrentUrl().contains(url)){
		///if (getDriver().getCurrentUrl().contains(url +"?format=BLOG")){
			Assert.assertEquals(1, 1);
		}
		else{
			Assert.assertEquals(1, 0);
		}
		//Assert.assertEquals(url + "?format=BLOG", getDriver().getCurrentUrl());
	}// End of HeaderOptionViewsBlog

	/*
	 * Use-case : More Options Test case : 1) Open any list 2) Click on
	 * "More Options" link appear and click view as Slideshow
	 */
	@Test(priority = 5, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void HeaderOptionViewsSlideShow(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("HeaderOptionViewsSlideShow");
		} else {
			listoptionpage = BaseState("HeaderOptionViewsSlideShow");
		}
		listoptionpage.clickOnheaderoption();
		listoptionpage.clickOnheaderoptionpopup("View as Slideshow");
		if (getDriver().getCurrentUrl().contains("format=SLIDESHOW") && getDriver().getCurrentUrl().contains(url)){
			Assert.assertEquals(1, 1);
		}
		else{
			Assert.assertEquals(1, 0);
		}
	}// End of HeaderOptionViewsSlideShow
	/*
	 * Use-case : Option List -Paste to clipboard. Test case : .
	 */
	@Test(priority = 6, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void PasteToClipboard(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("PasteToClipboard");
		} else {
			listoptionpage = BaseState("PasteToClipboard");
		}
		listoptionpage.clickOnheaderoption();
		listoptionpage.clickOnheaderoptionpopup("Paste to Clipboard");
		Assert.assertTrue(listoptionpage.isClipboardPopUpPresent());
	}// End of PasteToClipboard()

	/*
	 * Use-case : Option List -Follow list author. Test case : .
	 */
	@Test(priority = 7, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FollowListAuthorFacebook(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("FollowListAuthorFacebook");
		} else {
			listoptionpage = BaseState("FollowListAuthorFacebook");
		}
		
		
		listoptionpage.clickOnheaderoption();
		listoptionpage.clickOnheaderoptionpopup("Follow List Author");
		Assert.assertTrue(listoptionpage.isFollowLinksPresent());
		
		// Click on facebook and check whether right page is opening or not.
		listoptionpage.clickOnfacebook();
		browserWait();
		//String title = listoptionpage.switchToWindowAndGetTitle();
		//Assert.assertEquals("Facebook", title);
		common.facebookLogin("vikas@ranker.com", "vikas@123");
	//	common.facebookLogin("salmankhantc", "Dehradun1");
		try{
			Thread.sleep(15000);
		}catch(Exception e){}
		//getDriver().close();
		listoptionpage.switchToParentWindow();
		
		Assert.assertTrue(listoptionpage.isSocialLinkUserImagePresent());
		//home.doLogout();
	}// End of FollowListAuthorFacebook()
	/*
	 * Use-case : Option List -Follow list author. Test case : .
	 */
	@Test(priority = 8, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FollowListAuthorTwitter(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		// ListHeader listHeader=new ListHeader(getDriver());
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("FollowListAuthorTwitter");
		} else {
			listoptionpage = BaseState("FollowListAuthorTwitter");
		}
			// Click on twitter and check whether right page is opening or not.
			listoptionpage.clickOnheaderoption();
			browserWait();
			listoptionpage.clickOnheaderoptionpopup("Follow List Author");
			Assert.assertTrue(listoptionpage.isFollowLinksPresent());
			try{
				Thread.sleep(5000);
			}catch(Exception e){}
			listoptionpage.clickOnTwitter();
			browserWait();
			//String title = listoptionpage.switchToWindowAndGetTitle();
			//Assert.assertEquals("Twitter / Authorize an application", title);
			common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
			try{
				Thread.sleep(15000);
			}catch(Exception e){}
//			if(listoptionpage.isPresenttiwtterlogin()==true){
//				Assert.assertEquals(1,1);
//			}else if(listHeader.isPresenttwitterwindowpresent()) {
//				Assert.assertEquals(1,1);
//			}else
//			{
//				Assert.assertEquals(1,0);	
//			}
			//getDriver().close();
			//listHeader.switchToWindow(0);
			//Assert.assertTrue(listoptionpage.isSocialLinkUserImagePresent());
			
			listoptionpage.switchToParentWindow();
			if(listoptionpage.isPresenttiwtterlogin()==true){
			Assert.assertEquals(1,1);
		}else if(listoptionpage.isSocialLinkUserImagePresent()) {
			Assert.assertEquals(1,1);
		}else
		{
			Assert.assertEquals(1,0);	
		}
			//home.doLogout();
	}// End of FollowListAuthorTwitter()
	/*
	 * Use-case : Option List -Follow list author. Test case : .
	 */
	@Test(priority = 9, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FollowListAuthorGoogle(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 9 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("FollowListAuthorGoogle");
		} else {
			listoptionpage = BaseState("FollowListAuthorGoogle");
		}
		// Click on google plus and check whether right page is opening or not.
		listoptionpage.clickOnheaderoption();
		browserWait();
		listoptionpage.clickOnheaderoptionpopup("Follow List Author");
		Assert.assertTrue(listoptionpage.isFollowLinksPresent());
		
		listoptionpage.clickOnGooglePlus();
		browserWait();
		common.googleLogin("kallol@ranker.com","9872305929");
		if(getDriver().getCurrentUrl().contains("accounts.google.com")){
			   Assert.assertEquals(1, 1);
		   }else{
			   Assert.assertEquals(1, 0);
		   }
		getDriver().close();	   
		   // listoptionpage.switchToParentWindow();
		//listoptionpage.clickSubmit();
		//home.doLogout();
		
	}// End of FollowListAuthorGoogle()
	/*
	 * Use-case : Option List -Follow this list. Test case : .
	 */
	@Test(priority = 10, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FollowThisListFacebook(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 10 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("FollowThisListFacebook");
		} else {
			listoptionpage = BaseState("FollowThisListFacebook");
		}
		listoptionpage.clickOnheaderoption();
		listoptionpage.clickOnheaderoptionpopup("Follow This List");
		// Assert.assertTrue(listoptionpage.isFollowLinksPresent());
		
		// Click on facebook and check whether right page is opening or not.
		listoptionpage.clickOnfacebookSignUp();
		//browserWait();
		common.facebookLogin("vikas@ranker.com", "vikas@123");
		//common.facebookLogin("salmankhantc", "Dehradun1");
		try{
			Thread.sleep(5000);
		}catch(Exception e){}
		//getDriver().close();
		listoptionpage.switchToParentWindow();
		Assert.assertTrue(listoptionpage.isSocialLinkUserImagePresent());
		getDriver().close();
//		listoptionpage.switchToParentWindow();
		//home.doLogout();
	}// End of FollowThisListFacebook()
	/*
	 * Use-case : Option List -Follow this list. Test case : .
	 */
	@Test(priority = 11, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FollowThisListTwitter(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 11 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		 ListHeader listHeader=new ListHeader(getDriver());
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("FollowThisListTwitter");
		} else {
			listoptionpage = BaseState("FollowThisListTwitter");
		}
		// Click on twitter and check whether right page is opening or not.
		listoptionpage.clickOnheaderoption();
		browserWait();
		listoptionpage.clickOnheaderoptionpopup("Follow This List");
		browserWait();
		listoptionpage.clickOnTwitterSignUp();
		browserWait();
		//String title = listoptionpage.switchToWindowAndGetTitle();
		//Assert.assertEquals("Twitter / Authorize an application", title);
		common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
		try{
			Thread.sleep(5000);
		}catch(Exception e){}
		listoptionpage.switchToParentWindow();
		if(listoptionpage.isPresenttiwtterlogin()==true){
			Assert.assertEquals(1,1);
		}else if(listoptionpage.isSocialLinkUserImagePresent()) {
			Assert.assertEquals(1,1);
		}else
		{
			Assert.assertEquals(1,0);	
		}
//	  getDriver().close();
//	  listHeader.switchToWindow(0);
		//listoptionpage.switchToParentWindow();
		//home.doLogout();
	}// End of FollowThisListTwitter()
	/*
	 * Use-case : Option List -Follow this list. Test case : .
	 */
	@Test(priority = 12, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FollowThisListGoogle(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("FollowThisListGoogle");
		} else {
			listoptionpage = BaseState("FollowThisListGoogle");
		}
		// Click on google plus and check whether right page is opening or not.
		listoptionpage.clickOnheaderoption();
		browserWait();
		listoptionpage.clickOnheaderoptionpopup("Follow This List");
		browserWait();
		listoptionpage.clickOnGooglePlusSignUp();
		browserWait();
		browserWait();
		common.googleLogin("kallol@ranker.com","9872305929");
		if(getDriver().getCurrentUrl().contains("accounts.google.com")){
			   Assert.assertEquals(1, 1);
		   }else{
			   Assert.assertEquals(1, 0);
		   }
		//home.doLogout();
		
	}// End of FollowThisListGoogle()

	/*
	 * Use-case : List Options Test case : 1) Open any list
	                                       2) Click on"List Options" link appear just above the list items
	 */
	@Test(priority = 13, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FooterOption(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 13 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("FooterOption");
		} else {
			listoptionpage = BaseState("FooterOption");
		}
		listoptionpage.clickOnFooterlistoption(1);
		try{
			Thread.sleep(2000);
		}catch(Exception e){}
		for (int i = 1; i <= 8; i++) {
			Assert.assertTrue(listoptionpage.isheaderoptionPopUpPresent(i));
		}
	}// End of FooterOption

	/*
	 * Use-case : List Options Test case : 1) Open any list 2) Click on
	 * "List option" and click additem
	 */
	@Test(priority = 14, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FooterOptionAdditem(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 14 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("FooterOptionAdditem");
		} else {
			listoptionpage = BaseState("FooterOptionAdditem");
		}
		listoptionpage.clickOnFooterlistoption(1);
		try{
			Thread.sleep(4000);
		}catch(Exception e){}
		listoptionpage.clickOnheaderoptionpopup("Add Item");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		Assert.assertTrue(listoptionpage.isadditemPresent());
	}// End of FooterOptionAdditem

	/*
	 * Use-case : List Options Test case : 1) Open any list 2) Click on
	 * "List Options" link appear and click view as list
	 */
	@Test(priority = 15, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FooterOptionViewslist(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 15 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("FooterOptionViewslist");
		} else {
			listoptionpage = BaseState("FooterOptionViewslist");
		}
		listoptionpage.clickOnFooterlistoption(1);
		try{
			Thread.sleep(5000);
		}catch(Exception e){}
		listoptionpage.clickOnheaderoptionpopup("View as List");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		if (getDriver().getCurrentUrl().contains("format=GRID") && getDriver().getCurrentUrl().contains(url)){
			Assert.assertEquals(1, 1);
		}
		else{
			Assert.assertEquals(1, 0);
		}
		//Assert.assertEquals(url + "?format=GRID", getDriver().getCurrentUrl());
	}// End of FooterOptionViewslist

	/*
	 * Use-case : List Options Test case : 1) Open any list 2) Click on
	 * "List Option" link appear and click view as Blog
	 */
	@Test(priority = 16, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FooterOptionViewsBlog(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 16 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("FooterOptionViewsBlog");
		} else {
			listoptionpage = BaseState("FooterOptionViewsBlog");
		}
		listoptionpage.clickOnFooterlistoption(1);
		try{
			Thread.sleep(4000);
		}catch(Exception e){}
		listoptionpage.clickOnheaderoptionpopup("View as Blog");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		//System.out.println("##################### "+getDriver().getCurrentUrl());
		if (getDriver().getCurrentUrl().contains("format=BLOG") && getDriver().getCurrentUrl().contains(url)){
			Assert.assertEquals(1, 1);
		}
		else{
			Assert.assertEquals(1, 0);
		}
	//	Assert.assertEquals(url + "?format=BLOG", getDriver().getCurrentUrl());
	}// End of FooterOptionViewsBlog

	/*
	 * Use-case : List Options Test case : 1) Open any list 2) Click on
	 * "List Option" link appear and click view as Slideshow
	 */
	@Test(priority = 17, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FooterOptionViewsSlideShow(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 17 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("FooterOptionViewsSlideShow");
		} else {
			listoptionpage = BaseState("FooterOptionViewsSlideShow");
		}
		
		listoptionpage.clickOnFooterlistoption(1);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {}
		listoptionpage.clickOnheaderoptionpopup("View as Slideshow");
		if (getDriver().getCurrentUrl().contains("format=SLIDESHOW") && getDriver().getCurrentUrl().contains(url)){
			Assert.assertEquals(1, 1);
		}
		else{
			Assert.assertEquals(1, 0);
		}
		//Assert.assertEquals(url + "?format=SLIDESHOW", getDriver().getCurrentUrl());
	}// End of FooterOptionViewsSlideShow
	/*
	 * Use-case : Option List -Paste to clipboard below the list. Test case : .
	 */
	@Test(priority = 18, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void PasteToClipboardFoot(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 18 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("PasteToClipboardFoot");
		} else {
			listoptionpage = BaseState("PasteToClipboardFoot");
		}
		listoptionpage.clickOnFooterlistoption(1);
		listoptionpage.clickOnheaderoptionpopup("Paste to Clipboard");
		Assert.assertTrue(listoptionpage.isClipboardPopUpPresent());
	}// End of PasteToClipboardFoot()

	/*
	 * Use-case : Option List -Follow list author below the list. Test case : .
	 */
	@Test(priority = 19, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FollowListAuthorFootFacebook(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 19 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("FollowListAuthorFootFacebook");
		} else {
			listoptionpage = BaseState("FollowListAuthorFootFacebook");
		}
		listoptionpage.clickOnFooterlistoption(1);
		browserWait();
		listoptionpage.clickOnheaderoptionpopup("Follow List Author");
		browserWait();
		Assert.assertTrue(listoptionpage.isFollowLinksPresent());
		browserWait();
		// Click on facebook and check whether right page is opening or not.
		listoptionpage.clickOnfacebook();
		browserWait();
		//String title = listoptionpage.switchToWindowAndGetTitle();
		//Assert.assertEquals("Facebook", title);
		common.facebookLogin("vikas@ranker.com", "vikas@123");
		//common.facebookLogin("salmankhantc", "Dehradun1");
		try{
			Thread.sleep(15000);
		}catch(Exception e){}
		//getDriver().close();
		listoptionpage.switchToParentWindow();
		Assert.assertTrue(listoptionpage.isSocialLinkUserImagePresent());
		//home.doLogout();
	} // End of FollowListAuthorFootFacebook()
	/*
	 * Use-case : Option List -Follow list author below the list. Test case : .
	 */
	@Test(priority = 20, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FollowListAuthorFootTwitter(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 20 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		//ListHeader listHeader=new ListHeader(getDriver());
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("FollowListAuthorFootTwitter");
		} else {
			listoptionpage = BaseState("FollowListAuthorFootTwitter");
		}
			// Click on twitter and check whether right page is opening or not.
			listoptionpage.clickOnFooterlistoption(1);
			
			browserWait();
			listoptionpage.clickOnheaderoptionpopup("Follow List Author");
			Assert.assertTrue(listoptionpage.isFollowLinksPresent());
			
			listoptionpage.clickOnTwitter();
			browserWait();
			try{
				Thread.sleep(5000);
			}catch(Exception e){}
			//String title = listoptionpage.switchToWindowAndGetTitle();
			//Assert.assertEquals("Twitter / Authorize an application", title);
			common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
			try{
				Thread.sleep(5000);
			}catch(Exception e){}
			listoptionpage.switchToParentWindow();
			if(listoptionpage.isPresenttiwtterlogin()==true){
				Assert.assertEquals(1,1);
			}else if(listoptionpage.isSocialLinkUserImagePresent()) {
				Assert.assertEquals(1,1);
			}else
			{
				Assert.assertEquals(1,0);	
			}
//		  getDriver().close();
//		  listHeader.switchToWindow(0);
	} // End of FollowListAuthorFootTwitter()
	/*
	 * Use-case : Option List -Follow list author below the list. 
	 * Test case : .
	 */
	@Test(priority = 21, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FollowListAuthorFootGoogle(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 21 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("FollowListAuthorFootGoogle");
		} else {
			listoptionpage = BaseState("FollowListAuthorFootGoogle");
		}
		
		// Click on google plus and check whether right page is opening or not.
		listoptionpage.clickOnFooterlistoption(1);
		try{
			Thread.sleep(4000);
		}catch(Exception e){}
		listoptionpage.clickOnheaderoptionpopup("Follow List Author");
		Assert.assertTrue(listoptionpage.isFollowLinksPresent());
		
		listoptionpage.clickOnGooglePlus();
		browserWait();
		browserWait();
		common.googleLogin("kallol@ranker.com","9872305929");
		if(getDriver().getCurrentUrl().contains("accounts.google.com")){
			   Assert.assertEquals(1, 1);
		   }else{
			   Assert.assertEquals(1, 0);
		   }
		//home.doLogout();
		
	}// End of FollowListAuthorFootGoogle()

	/*
	 * Use-case : Option List -Follow this list below the list. Test case : .
	 */
	@Test(priority = 22, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FollowThisListFootFacebook(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 22 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("FollowThisListFootFacebook");
		} else {
			listoptionpage = BaseState("FollowThisListFootFacebook");
		}
		listoptionpage.clickOnFooterlistoption(1);
		listoptionpage.clickOnheaderoptionpopup("Follow This List");
		// Assert.assertTrue(listoptionpage.isFollowLinksPresent());
		
		// Click on facebook and check whether right page is opening or not.
		listoptionpage.clickOnfacebookSignUp();
		browserWait();
		//String title = listoptionpage.switchToWindowAndGetTitle();
		//Assert.assertEquals("Facebook", title);
		common.facebookLogin("vikas@ranker.com", "vikas@123");
	//	common.facebookLogin("salmankhantc", "Dehradun1");
		try{
			Thread.sleep(15000);
		}catch(Exception e){}
		//getDriver().close();
		listoptionpage.switchToParentWindow();
		Assert.assertTrue(listoptionpage.isSocialLinkUserImagePresent());
		//home.doLogout();
	} // End of FollowThisListFootFacebook()
	/*
	 * Use-case : Option List -Follow this list below the list. Test case : .
	 */
	@Test(priority = 23, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FollowThisListFootTwitter(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 23 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		 ListHeader listHeader=new ListHeader(getDriver());
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("FollowThisListFootTwitter");
		} else {
			listoptionpage = BaseState("FollowThisListFootTwitter");
		}
			// Click on twitter and check whether right page is opening or not.
			listoptionpage.clickOnFooterlistoption(1);
			browserWait();
			listoptionpage.clickOnheaderoptionpopup("Follow This List");
			
			listoptionpage.clickOnTwitterSignUp();
			browserWait();
			//String title = listoptionpage.switchToWindowAndGetTitle();
			//Assert.assertEquals("Twitter / Authorize an application", title);
			common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
			try{
				Thread.sleep(5000);
			}catch(Exception e){}
			listoptionpage.switchToParentWindow();
			if(listoptionpage.isPresenttiwtterlogin()==true){
				Assert.assertEquals(1,1);
			}else if(listoptionpage.isSocialLinkUserImagePresent()) {
				Assert.assertEquals(1,1);
			}else
			{
				Assert.assertEquals(1,0);	
			}
//		  getDriver().close();
//		  listHeader.switchToWindow(0);
	} // End of FollowThisListFootTwitter()
	/*
	 * Use-case : Option List -Follow this list below the list. Test case : .
	 */
	@Test(priority = 24, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FollowThisListFootGoogle(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 24 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("FollowThisListFootGoogle");
		} else {
			listoptionpage = BaseState("FollowThisListFootGoogle");
		}
		// Click on google plus and check whether right page is opening or not.
		listoptionpage.clickOnFooterlistoption(1);
		browserWait();
		listoptionpage.clickOnheaderoptionpopup("Follow This List");
		browserWait();
		listoptionpage.clickOnGooglePlusSignUp();
		
		browserWait();
		common.googleLogin("kallol@ranker.com","9872305929");
		if(getDriver().getCurrentUrl().contains("accounts.google.com")){
			   Assert.assertEquals(1, 1);
		   }else{
			   Assert.assertEquals(1, 0);
		   }
	}// End of FollowThisListFootGoogle()
	/*
	 * Use-case : Edit Rerank in list footer. 
	 *  Test case : 1) Open any list page.
	                2) Click on "Edit Rerank" option after the list. Make sure on clicking, pop-up containing list to edit should open.
	 */
	@Test(priority = 25, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void EditRerankFoot(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 25 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("EditRerankFoot");
		} else {
			listoptionpage = BaseState("EditRerankFoot");
		}
		try{
			Thread.sleep(8000);
		}catch(Exception e){}
		listoptionpage.clickOnEditRerankFoot(2);
		try{
			Thread.sleep(8000);
		}catch(Exception e){}
		Assert.assertTrue(listoptionpage.isEditRerankFootPopUpPresent());
	}// End of EditRerankFoot.
	/*
	 * Use-case : Comment in list footer. Test case : 1) Open any list page. 2)
	 * Click on "Comment" option after the list. On clicking, comment block
	 * shoul appear on the same page.
	 */
	@Test(priority = 26, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void CommentFoot(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 26 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("CommentFoot");
		} else {
			listoptionpage = BaseState("CommentFoot");
		}
		String befTxt = listoptionpage.getTextOfCommentFoot(3);
		listoptionpage.clickOnCommentFoot(3);
		try{
			Thread.sleep(4000);
		}catch(Exception e){}
		Assert.assertTrue(listoptionpage.isCommentBoxFootPresent());
		String aftTxt = listoptionpage.getTextOfCommentBoxHeaderFoot();
		Assert.assertEquals(befTxt, aftTxt);
	}// End CommentFoot()

	/*
	 * Use-case : Embed in list footer. Test case : 1) Open any list page. 2)
	 * Click on "Embed" option after the list. On clicking, it should take to
	 * the corresponding page.
	 */
	@Test(priority = 27, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void EmbedFoot(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 27 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("EmbedFoot");
		} else {
			listoptionpage = BaseState("EmbedFoot");
		}
		listoptionpage.clickOnEmbedFoot(4);
		try{
			Thread.sleep(4000);
		}catch(Exception e){}
		Assert.assertTrue(listoptionpage.isEmbedHeaderAfterClickPresent());
	}// End EmbedFoot()
	/*
	 * Use-case : Share in list footer. 
	   Test case : 1) Open any list page. 
	 		       2)Hover over "Share" option after the list.
	 		       On hovering, it should display the various social links icons, and on clicking on which should open corresponding link.
	 */
	@Test(priority = 28, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ShareFootFacebook(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 28 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("ShareFootFacebook");
		} else {
			listoptionpage = BaseState("ShareFootFacebook");
		}
		try {
			Thread.sleep(4000);
		} catch (Exception e) {}
		listoptionpage.cancelLoading();
		listoptionpage.hoverOverShareFoot(5);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		// Assert.assertTrue(listoptionpage.isSharePopUpPresent());
			// Click on facebook and check whether right page is opening or not.
			listoptionpage.clickOnfacebookFoot();
			browserWait();
			//String title = listoptionpage.switchToWindowAndGetTitle();
			//Assert.assertEquals("Facebook", title);
			common.facebookLogin("vikas@ranker.com", "vikas@123");
			//common.facebookLogin("salmankhantc", "Dehradun1");
			Assert.assertTrue(listoptionpage.isFbShareWindowPresent());
			getDriver().close();
			listoptionpage.switchToParentWindow();
	} // End of ShareFootFacebook()
	/*
	 * Use-case : Share in list footer. 
	   Test case : 1) Open any list page. 
	 		       2)Hover over "Share" option after the list.
	 		       On hovering, it should display the various social links icons, and on clicking on which should open corresponding link.
	 */
	@Test(priority = 29, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ShareFootTwitter(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 29 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		 ListHeader listHeader=new ListHeader(getDriver());
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("ShareFootTwitter");
		} else {
			listoptionpage = BaseState("ShareFootTwitter");
		}
			listoptionpage.hoverOverShareFoot(5);
//			try {
//				Thread.sleep(7000);
//			} catch (Exception e) {}
			// Click on twitter and check whether right page is opening or not.
			//listoptionpage.hoverOverShareFoot(5);
//			try {
//				Thread.sleep(10000);
//			} catch (Exception e) {
//			}
			listoptionpage.clickOnTwitterFoot();
			try {
				Thread.sleep(5000);
			} catch (Exception e) {}
			common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(listoptionpage.isPresenttiwtterlogin()==true){
				Assert.assertEquals(1,1);
			}else if(listHeader.isPresenttwitterwindowpresent()) {
				Assert.assertEquals(1,1);
			}else
			{
				Assert.assertEquals(1,0);	
			}
			getDriver().close();
			listoptionpage.switchToParentWindow();
	} // End of ShareFootTwitter()	
	/*
	 * Use-case : Share in list footer. 
	   Test case : 1) Open any list page. 
	 		       2)Hover over "Share" option after the list.
	 		       On hovering, it should display the various social links icons, and on clicking on which should open corresponding link.
	 */
	@Test(priority = 30, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ShareFootPinterest(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 30 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("ShareFootPinterest");
		} else {
			listoptionpage = BaseState("ShareFootPinterest");
		}
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		listoptionpage.hoverOverShareFoot(5);
		try {
			Thread.sleep(7000);
		} catch (Exception e) {
		}		
		// Click on pinterest and check whether right page is opening or not.
		//listoptionpage.hoverOverShareFoot(5);
		listoptionpage.clickOnPinterestFoot();
		browserWait();
		common.clickOnPintLoginFBbutton();
		common.facebookLogin("salmankhantc", "Dehradun1");
		try{
			Thread.sleep(3000);
		}catch(Exception e){}
		SafeActions sf = new SafeActions(getDriver());
		sf.switchToWindow(1);
		Assert.assertTrue(listoptionpage.ispintersetWindowPresent());
		
		getDriver().close();
		
	}// End of ShareFootPinterest()
	/*
	 * Use-case : Next List in list footer. Test case : 1) Open any list page.
	 * 2) Click on "Next List" option in the list footer. On clicking, it should
	 * take to the corresponding new list page.
	 */
	@Test(priority = 31, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void NextListFoot(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 31 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		ListHeader listHeader=new ListHeader(getDriver());
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("NextListFoot");
		} else {
			listoptionpage = BaseState("NextListFoot");
		}
		common.getNewURL(config.getProperty("Url")+"list/actors-nobody-cares-about-anymore/ranker-celebrities?format=SLIDESHOW");
		 int state =0;
		 try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		listHeader.clickOnmoreInfoLink();
		// String before= listHeader.getTextOftagscategory();
		 try {
				Thread.sleep(8000);
			} catch (Exception e) {}
		// slideshow.clickNext();
		 listHeader.clickonnextlistfooter();
		 try {
				Thread.sleep(8000);
			} catch (Exception e) {}
		 listHeader.clickOnmoreInfoLink();
		 for(int i=1;i<=4;i++){
			 System.out.println("this is i "+i+" "+listHeader.getTextOfnextlisttags(i));
			 if(listHeader.getTextOfnextlisttags(i).trim().equalsIgnoreCase("PEOPLE,")){
				 browserWait();
				 state = 1;
				 break;
				 }
		 }
			 if(state==1){
					Assert.assertEquals(1, 1);
				}else{
					Assert.assertEquals(1, 0);
				}
				 
   }// End NextListFoot()

	/*
	 * Use-case : Next List in list footer. Test case : 1) Open any list page.
	 * 2) Click on "rerank List" option in the list footer. On clicking, it
	 * should take to the corresponding new list page.
	 */
	@Test(priority = 32, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void RerankListFoot(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 32 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("RerankListFoot");
		} else {
			listoptionpage = BaseState("RerankListFoot");
		}
		//listoptionpage.clickOnrerankListInFooter();
		listoptionpage.clickOnFooterlistoption(2);
		try {
			Thread.sleep(4000);
		} catch (Exception e) {}
		listoptionpage.isPresentUE();
	}// End NextListFoot()
	/*
	 * Use-case : Lock scrolling when open list lightbox open.
	 * Test case : Open lightbox after clicking on  from Add item textbox.
                   Scroll down from mouse
	 */
	@Test(priority = 33, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddItemInList(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 33 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("AddItemInList");
		} else {
			listoptionpage = BaseState("AddItemInList");
		}
		listoptionpage.clickOnAddItemInList();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}
		Assert.assertTrue(listoptionpage.isadditemPresent());
		listoptionpage.checkScrollOfList(1);
	}// End of AddItemInList
	/*
	 * Use-case : Add item message for no search results.
	 * Test case : Enter " ABCD" in the Add item box and click enter.Notice the "No exact matches found" should display.
	 */
	@Test(priority = 34, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void SearchItemMessage(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 34 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("SearchItemMessage");
		} else {
			listoptionpage = BaseState("SearchItemMessage");
		}
		listoptionpage.putTextInAddListBox("abcd");
		Assert.assertTrue(listoptionpage.isListSearchMessageAndArrowDisplayed("message"));
		if(listoptionpage.getTextOfMessage("message").contains("No matches found. Create a custom item here  "))
			Assert.assertEquals(1, 1);
		else
			Assert.assertEquals(1, 0);
		Assert.assertTrue(listoptionpage.isListSearchMessageAndArrowDisplayed("arrow"));
		String col=listoptionpage.getColorOfArrow("arrow");
		Assert.assertEquals(col, "rgba(160, 160, 160, 1)");
		
	}// End of AddItemInList
	/*
	 * Use-case : Prompt users to add image when they add a node.
	 * Test case : 1-Open any open list
                   2-Add any Authored node
	 */
	@Test(priority = 35, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddImagePrompt(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 35 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("AddImagePrompt");
		} else {
			listoptionpage = BaseState("AddImagePrompt");
		}
		common.signin("testuserkallol1@mailinator.com", "testing");
		listoptionpage.putTextInAddListBox("abcd");
		listoptionpage.clickOnAddSearchItem();
		try{
			Thread.sleep(2000);
		}catch(Exception e){}
		if(listoptionpage.getAttriOfImageIconInEditItemBox().contains("on"))
			
			Assert.assertEquals(1,1);
		else
			Assert.assertEquals(1,0);
		Assert.assertTrue(listoptionpage.isImageResultInEditItemBoxPresent(1));
		
	}// End of AddImagePrompt
	/*
	 * Use-case : Move add item into a lightbox.
	 * Test case : 1-Go to any openlist and scroll to the bottom of the list.
                   2-Enter a node into the openlist input box.
	 */
	@Test(priority = 36, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddSearchItemAndImage(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 36 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("AddSearchItemAndImage");
		} else {
			listoptionpage = BaseState("AddSearchItemAndImage");
		}
		common.getNewURL(config.getProperty("Url")+"crowdranked-list/best-marvel-villains");
//		 UeListPage uePage= new UeListPage(getDriver());
			common.signin("testuserkallol1@mailinator.com", "testing");
		listoptionpage.putTextInAddListBox("abcd");
		listoptionpage.clickOnAddSearchItem();
		try{
			Thread.sleep(2000);
		}catch(Exception e){}
		if(listoptionpage.getAttriOfImageIconInEditItemBox().contains("on")){
			Assert.assertEquals(1,1);
		}
		else{
			Assert.assertEquals(1,0);
		}
		try {
			Thread.sleep(2000);
		} catch (Exception e) {}
		listoptionpage.putTextInAddimage("salman");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {}
		int count=listoptionpage.Imagecount();
		if(count>2){
			try {
				Thread.sleep(5000);
			} catch (Exception e) {}
			String src1=listoptionpage.getSrcOfImageResultInEditItemBox(1);
			listoptionpage.clickOnImageResultInEditItemBox(1);
			listoptionpage.clickOnSelectButton();
			try {
				Thread.sleep(10000);
			} catch (Exception e) {}
			listoptionpage.clickOnDoneButton();
			try {
				Thread.sleep(10000);
			} catch (Exception e) {}
			String src2=listoptionpage.getSrcOfListNodeImage("image");
			Assert.assertEquals(src1, src2);
		}
		else
		{
			Assert.fail("flickr is not being working");
		}
		listoptionpage.clickOndeletelist("delete");
	}// End of AddSearchItemAndImage
	/*
	 * Use-case :  Open list Add item
	 * Test case : 1) Open any Ultimate list
				   2) try adding open list item at the bottom of the page. Test adding a system node/Authored node.
	 */
	@Test(priority = 37, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddAuthoredNode(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 37 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("AddAuthoredNode");
		} else {
			listoptionpage = BaseState("AddAuthoredNode");
		}
		common.signin("testuserkallol1@mailinator.com", "testing");
		listoptionpage.putTextInAddListBox("testing");
		listoptionpage.clickOnAddSearchItem();
		try{
			Thread.sleep(10000);
		}catch(Exception e){}
		listoptionpage.clickoneditsubvideoIcon();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		listoptionpage.putTextInAddvideo("salman");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		int count=listoptionpage.Videocount();
		if(count>2){
		String beforesrc = listoptionpage.getsrcaddvideo(1);
		//System.out.println("beforesrc==="+beforesrc);
		try{
			Thread.sleep(12000);
		}catch(Exception e){}
		listoptionpage.clickonaddvideo(1);
		try {
			Thread.sleep(4000);
		} catch (Exception e){
		}
		listoptionpage.clickOnvideoSelectButton();
		listoptionpage.clickOnDoneButton();
		try{
			Thread.sleep(6000);
		}catch(Exception e){}
		String after = listoptionpage.getsrcafteraddedititems(1);
		//System.out.println("after=="+after);
		Assert.assertEquals(beforesrc, after);
		}
		else
		{
			Assert.fail("youtube video is not being working");
		}
		listoptionpage.clickOndeletelist("delete");
	}// End of AddAuthoredNode
	/*
	 * Use-case :  Maintain the flow for non-logged in users adding to open lists
	 * Test case : Try to add item to open list as a guest user, it should open sign up prompt, enter the credentials
	 */
	@Test(priority = 38, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddNodeguestuser(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 38 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("AddNodeguestuser");
		} else {
			listoptionpage = BaseState("AddNodeguestuser");
		}
		common.getNewURL(config.getProperty("Url")+"crowdranked-list/best-marvel-villains");
		common.signin("testuserkallol1@mailinator.com", "testing");
		listoptionpage.putTextInAddListBox("abcd");
		try{
			Thread.sleep(5000);
		}catch(Exception e){}
		listoptionpage.clickOnAddSearchItem();
		try{
			Thread.sleep(5000);
		}catch(Exception e){}
		if(listoptionpage.getAttriOfImageIconInEditItemBox().contains("on")){
			Assert.assertEquals(1,1);
		}
		else{
			Assert.assertEquals(1,0);
		}
		System.out.println("111111111");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {}
		listoptionpage.putTextInAddimage("salman");
		try {
			Thread.sleep(8000);
		} catch (Exception e) {}
		int count=listoptionpage.Imagecount();
		if(count>2){
			try {
				Thread.sleep(8000);
			} catch (Exception e) {}
			String src1=listoptionpage.getSrcOfImageResultInEditItemBox(1);
			listoptionpage.clickOnImageResultInEditItemBox(1);
			try {
				Thread.sleep(2000);
			} catch (Exception e) {}
			listoptionpage.clickOnSelectButton();
			try {
				Thread.sleep(10000);
			} catch (Exception e) {}
			try {
				Thread.sleep(2000);
			} catch (Exception e) {}
			listoptionpage.clickOnDoneButton();
			try {
				Thread.sleep(5000);
			} catch (Exception e) {}
			String src2=listoptionpage.getSrcOfListNodeImage("image");
			Assert.assertEquals(src1, src2);
		}
		else
		{
			Assert.fail("flickr is not being working");
		}
		listoptionpage.clickOndeletelist("delete");
	}
	/*
	 * Use-case : Sort List: According to list name. 
	 * Test case : Open any list.Sort the list alphabetically.
	 */
	@Test(priority = 39, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Sorting_Alphabet_Header(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 39 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("Sorting_Alphabet_Header");
		} else {
			listoptionpage = BaseState("Sorting_Alphabet_Header");
		}
		listoptionpage.clickOnheaderoption();
		listoptionpage.clickOnheaderoptionpopup("Sort Alphabetically (A-Z)");
		//for(int i=1;i<=3;i++){
			if(listoptionpage.getTextOfSortedNodeText(1).contains("A"))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);
		//}
	}//End of Sorting_Alphabet_Header
	/*
	 * Use-case : Sort List: According to list name. 
	 * Test case : Open any list.Sort the list alphabetically.
	 */
	@Test(priority = 40, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Sorting_Alphabet_Foot(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 40 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("Sorting_Alphabet_Foot");
		} else {
			listoptionpage = BaseState("Sorting_Alphabet_Foot");
		}
		listoptionpage.clickOnFooterlistoption(1);
		listoptionpage.clickOnheaderoptionpopup("Sort Alphabetically (A-Z)");
		//for(int i=1;i<=3;i++){
			if(listoptionpage.getTextOfSortedNodeText(1).contains("A"))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);
		//}
	}//End of Sorting_Alphabet_Foot
	/*
	 * Use-case : Sort List: According to list name. 
	 * Test case : Open any list.Sort the list alphabetically.
	 */
	@Test(priority = 41, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Sorting_Ranking_Header(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 41 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		String before="";
		String after="";
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("Sorting_Ranking_Header");
		} else {
			listoptionpage = BaseState("Sorting_Ranking_Header");
		}
		listoptionpage.clickOnheaderoption();
		listoptionpage.clickOnheaderoptionpopup("Sort Alphabetically (A-Z)");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		for(int i=1;i<=3;i++){
			 before=listoptionpage.getrankOfSortedlist(i);}
		listoptionpage.clickOnrankingradiobtn();
		for(int i=1;i<=3;i++){
			 after=listoptionpage.getrankOfSortedlist(i);}
		Assert.assertNotEquals(before, after);
				
		
	}//End of Sorting_Alphabet_Header	
	/*
	 * Use-case : Sort List: According to list name. 
	 * Test case : Open any list.Sort the list alphabetically.
	 */
	@Test(priority = 42, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void SortingRankingFooter(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 42 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listoptionpage = BaseStateWithLogin("Sorting_Ranking_footer");
		} else {
			listoptionpage = BaseState("Sorting_Ranking_footer");
		}
		listoptionpage.clickOnFooterlistoption(1);
		listoptionpage.clickOnheaderoptionpopup("Sort Alphabetically (A-Z)");
		String before=listoptionpage.getrankOfSortedlist(1);
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
		}
		listoptionpage.clickOnrankingradiobtn();
		String after=listoptionpage.getrankOfSortedlist(1);
		Assert.assertNotEquals(before, after);
	}//End of Sorting_Alphabet_Header
	 /* 
	  * Use-case : Score Column
	  * Test case : 1) Open any Ultimate list
					2) click on score appear on right side of each node
	  */
	 @Test(priority=43,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ScoreColumn(String loginRequired){
		 //
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 43 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to grid page)
		 common=new Commonpage(getDriver());
		 Grid grid=common.getGridView(url);
		 ListOptionPage listoptionpage = null;
		 if (loginRequired.equals("YES")) {
			 listoptionpage = BaseStateWithLogin("ScoreColumn");
			} else {
				listoptionpage = BaseState("ScoreColumn");
			}
		 common.getNewURL(config.getProperty("Url")+"list/actors-nobody-cares-about-anymore/ranker-celebrities");
		 grid.clickNodeScore("1"); //To open node score div.
		 SafeActions s = new SafeActions(getDriver());
	     s.waitForPageToLoad(30);
		 Assert.assertTrue(grid.isScoreExplainPresent("1"));
		 Assert.assertTrue(grid.isScoreListedItPresent("1"));
		 Assert.assertTrue(grid.isScoreRankedHighPresent("1"));
		 Assert.assertTrue(grid.isScoreVotedUpPresent("1"));
		 s.waitForPageToLoad(30);
		 grid.clickNodeScore("1");
	 }//End of ScoreColumn
	   /*
		 * Use-case : Advance Filters: Check search field
		 * Test case :  1) Open any list
						2) Click on "Search Filters" appears below the list strip
		 */
		@Test(priority = 44, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void CheckSearchField(String loginRequired) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 44 !!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to node page)
			ListOptionPage listoptionpage = null;
			if (loginRequired.equals("YES")) {
				listoptionpage = BaseStateWithLogin("CheckSearchField");
			} else {
				listoptionpage = BaseState("CheckSearchField");
			}
			common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-10-worst-u-s-presidents?");
			listoptionpage.typeonsearchfield("bill");
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
			}
			listoptionpage.Clickonsearchicon();
			Assert.assertTrue(listoptionpage.isPresentSearchlist());
			
		}//End of CheckSearchField
		 /*
		 * Use-case : Advance Filters: Check Search filed with a keyword
		 * Test case :   1) Open any list
						 2) Click on "Search Filters" appears below the list strip and enter a text
		 */
		@Test(priority = 45, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void SearchFilters(String loginRequired) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 45 !!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to node page)
			ListOptionPage listoptionpage = null;
			if (loginRequired.equals("YES")) {
				listoptionpage = BaseStateWithLogin("SearchFilters");
			} else {
				listoptionpage = BaseState("SearchFilters");
			}
			common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-10-worst-u-s-presidents?");
			listoptionpage.typeonsearchfield("Bill");
			try {
				Thread.sleep(4000);
			} catch (Exception e) {
			}
			listoptionpage.Clickonsearchicon();
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
			}
			
			String text=listoptionpage.getTextOfsearchlist(1);
			if(text.contains("Bill")){
			Assert.assertTrue(true);}
		else{
			Assert.assertTrue(false);}
			
		}//End of SearchFilters
		 /*
		 * Use-case : Advanced Filters: Delete searched keyword
		 * Test case :  1) Open any list
						2) Click on "Search Filters" below the list strip, just above the list items
						3) Enter your search keyword and hit enter
						4) Delete your searched keyword by clicking on keyword appear below the search field
		 */
		@Test(priority = 46, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void DeleteFilters(String loginRequired) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 46 !!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to node page)
			ListOptionPage listoptionpage = null;
			if (loginRequired.equals("YES")) {
				listoptionpage = BaseStateWithLogin("DeleteFilters");
			} else {
				listoptionpage = BaseState("DeleteFilters");
			}
			common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-10-worst-u-s-presidents?");
		     String before="";String after="";
		     try {
					Thread.sleep(4000);
				} catch (Exception e) {}
			 before=listoptionpage.getTextOfbeforesearchlistText(1);	
			
			listoptionpage.typeonsearchfield("Bill");
			try {
				Thread.sleep(4000);
			} catch (Exception e) {}
			listoptionpage.Clickonsearchicon();
			
			try {
				Thread.sleep(3000);
			} catch (Exception e) {}
		listoptionpage.Clickondeletefilter();	
		try {
			Thread.sleep(8000);
		} catch (Exception e) {}
			 after=listoptionpage.getTextOfsearchlist(1);
		Assert.assertEquals(before, after);
	}//End of DeleteFilters
	/*
	  * Use-case : Perform This test on 2 separate Ultimate pages (1 with a lot of content, 1 less popular one)
	  * Test case : Open any Ultimate/Contributing list
	  */
	   @Test(priority = 47, dataProviderClass = DataProviders.class, dataProvider = "Login")
	   public void ImagesAdsTitleCheck(String loginRequired) {
		   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 47 !!!!!!!!!!!!!!!!!!!!!!!");
		   // Base state. (Navigate to node page)
		   ListOptionPage listoptionpage = null;
		   if (loginRequired.equals("YES")) {
			   listoptionpage = BaseStateWithLogin("SearchFilters");
		   } else {
			   listoptionpage = BaseState("SearchFilters");
		   }
		   // Ultimate page with lot of contents.
		   common.getNewURL(config.getProperty("Url")+"crowdranked-list/best-books-of-all-time-_fiction_");
		   for(int i=1;i<=10;i++){
			  Assert.assertTrue(listoptionpage.isListNodeImagePresent(i,"image"));
			  Assert.assertTrue(listoptionpage.isListNodeTitlePresent(i,"title"));
			  Assert.assertTrue(listoptionpage.isListNodeMdataPresent(i,"MetaData"));
		   }
		   // Ads Check
		   listoptionpage.scrollToNode(50);
		   try{
			   Thread.sleep(8000);
		   }catch(Exception e){}
		   listoptionpage.scrollToNode(90);
		   try{
			   Thread.sleep(8000);
		   }catch(Exception e){}
		   //int num=listoptionpage.getNumberOfAds();
		   List arr = new List();
		   arr.add("20");
		   arr.add("40");
		   arr.add("60");
		   arr.add("75");
		   arr.add("90");
		   for(int i=1;i<=5;i++){
//			  // listoptionpage.scrollToNode(Integer.parseInt(arr.getItem(i-1)));
//			   String actual =listoptionpage.getlistNumber(i);
//			   Assert.assertEquals(actual, arr.getItem(i-1));
			   Assert.assertTrue(listoptionpage.isAdNodePresent(Integer.parseInt(arr.getItem(i-1))));
			   
		   }
		// Ultimate page with less contents.
		   common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-most-influential-politicians-in-american-history");
		   for(int i=1;i<=10;i++){
			  Assert.assertTrue(listoptionpage.isListNodeImagePresent(i,"image"));
			  Assert.assertTrue(listoptionpage.isListNodeTitlePresent(i,"title"));
			  Assert.assertTrue(listoptionpage.isListNodeMdataPresent(i,"MetaData"));
		   }
		   // Ads Check
		   listoptionpage.scrollToNode(30);
		   try{
			   Thread.sleep(8000);
		   }catch(Exception e){}
		   listoptionpage.scrollToNode(50);
		   try{
			   Thread.sleep(8000);
		   }catch(Exception e){}
		   //int num=listoptionpage.getNumberOfAds();
		   arr.add("20");
		   arr.add("40");
		  // arr.add("60");
		   for(int i=1;i<=2;i++){
			   Assert.assertTrue(listoptionpage.isAdNodePresent(Integer.parseInt(arr.getItem(i-1))));
		   }
	   }//End of ImagesAdsTitleCheck
	   /*
		 * Use-case : Check Comments tab
		 * Test case :  1) Open any list
						2) Click on 'comments' tab appear in list strip
		 */
		@Test(priority = 48, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void CommentTab(String loginRequired) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 48 !!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to node page)
			ListOptionPage listoptionpage = null;
			if (loginRequired.equals("YES")) {
				listoptionpage = BaseStateWithLogin("DeleteFilters");
			} else {
				listoptionpage = BaseState("DeleteFilters");
			}
			listoptionpage.clickOnCommentAtHead();
			listoptionpage.isCommentBoxFootVisible();
	   } //End of CommentTab()
		 /*
		  * Use-case : Test 'no comments' tag to hide comments section.
		  * Test case :  1) Open any list as Admin.
						 2) Add tag "nocomments' and update.
		  */
			@Test(priority = 49, dataProviderClass = DataProviders.class, dataProvider = "Login")
			public void NoCommentSection(String loginRequired) {
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 49 !!!!!!!!!!!!!!!!!!!!!!!");
				// Base state. (Navigate to node page)
				ListOptionPage listoptionpage = null;
				if (loginRequired.equals("YES")) {
					listoptionpage = BaseStateWithLogin("DeleteFilters");
				} else {
					listoptionpage = BaseState("DeleteFilters");
				}
				common.signin("vijaymohanp", "server");
				UeListPage ueList= new UeListPage(getDriver());
				ueList.clickCreateListAndAdd3Items();
			
				ueList.clickOnoptionbtn();
				ueList.clickOnAddTagsInUe();
				listoptionpage.selectTagsCheckBox();

				String tagtxt=listoptionpage.getTextOfNoCommentsTag("noComments");
				Assert.assertEquals(tagtxt, "no comments");
				ueList.clickOnDoneInAddTags();
				try{
					Thread.sleep(2000);
				}catch(Exception e){}
				ueList.clickOnpublishbtn();
				try{
					Thread.sleep(8000);
				}catch(Exception e){}
				Assert.assertFalse(listoptionpage.isCommentAtHeadPresent());
				//Resetting the above done process.
				ueList.clicksettingafterpublish();
				ueList.clickOnoptionbtn();
				ueList.clickOnAddTagsInUe();
				listoptionpage.clickOnNoCommentsTag("cross");
				ueList.clickOnDoneInAddTags();
				ueList.clickOnpublishbtn();
			Assert.assertTrue(listoptionpage.isCommentAtHeadPresent());
				
	} //End of NoCommentSection()	
		
			/*
			 * Use-case : Advance Filters: Check Search filed with a keyword
			 * Test case :   1) Open any list
							 2) Click on "Search Filters" appears below the list strip and enter a text
			 */
			@Test(priority = 50, dataProviderClass = DataProviders.class, dataProvider = "Login")
			public void AdvanceFilterbyProfessionparemeter(String loginRequired) {
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 50 !!!!!!!!!!!!!!!!!!!!!!!");
				// Base state. (Navigate to node page)
				ListOptionPage listoptionpage = null;
				if (loginRequired.equals("YES")) {
					listoptionpage = BaseStateWithLogin("AdvanceFilterbyBirthplaceparemeter");
				} else {
					listoptionpage = BaseState("AdvanceFilterbyBirthplaceparemeter");
				}
				//String	before="";String after="";
				common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-most-influential-contemporary-americans?");
				listoptionpage.Clickonselectdropdown();
				listoptionpage.Clickonselectparameterr("Profession");
				try {
					Thread.sleep(8000);
				} catch (Exception e) {
				}
				ArrayList<String> beforeArr = new ArrayList<String>();
				for(int i=1;i<=10;i++){
				if(listoptionpage.getTextOparameter(i).contains("Politician")){
					beforeArr.add(listoptionpage.getTextOfbeforesearchlistText(i));
				}
				}
				listoptionpage.clickOnheaderoption();
				listoptionpage.clickOnheaderoptionpopup("Sort Alphabetically (A-Z)");
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
				}
				listoptionpage.clickOnrankingradiobtn();
				listoptionpage.Clickonfilterresultselect(1);
				try {
					Thread.sleep(4000);
				} catch (Exception e) {
				}
				listoptionpage.Clickonfilterresultselectsuboption(1, "Politician");
				try {
					Thread.sleep(4000);
				} catch (Exception e) {
				}
				for (int j=0;j<beforeArr.size();j++){
					Assert.assertTrue(listoptionpage.getTextOffilterlist(beforeArr.get(j)));
//					int state =0;
//					for (int k=1;k<=10;k++){
//						//beforeArr.get(j);
//						try {
//							Thread.sleep(15000);
//						} catch (Exception e) {
//						}
//						if(listoptionpage.getTextOfsearchlist(k).contains(beforeArr.get(j))){
//							System.out.println("10101010101010");
//							state =1;
//							break;
//						}
//						
//						}
//					if(state==1){
//						Assert.assertEquals(1, 1);
//					}else{
//						Assert.assertEquals(1, 0);
//					}
				}
				
			}//End of AdvanceFilterbyBirthplaceparemeter
		
		/*
		 * Use-case : Advance Filters: Check Search filed with a keyword
		 * Test case :   1) Open any list
						 2) Click on "Search Filters" appears below the list strip and enter a text
		 */
		@Test(priority = 51, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void AdvanceFilterbyAgeparemeter(String loginRequired) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 51 !!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to node page)
			ListOptionPage listoptionpage = null;
			if (loginRequired.equals("YES")) {
				listoptionpage = BaseStateWithLogin("AdvanceFilterbyAgeparemeter");
			} else {
				listoptionpage = BaseState("AdvanceFilterbyAgeparemeter");
			}
			//String	before="";String after="";
			common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-most-influential-contemporary-americans?");
			listoptionpage.Clickonselectdropdown();
			listoptionpage.Clickonselectparameterr("Age");
			try {
				Thread.sleep(3000);
			} catch (Exception e) {}
			ArrayList<String> beforeArr = new ArrayList<String>();
			for(int i=1;i<=10;i++){
				if(listoptionpage.getTextOparameter(i).contains("age 61")){
					beforeArr.add(listoptionpage.getTextOfbeforesearchlistText(i));
				}
			}
			listoptionpage.clickOnheaderoption();
			listoptionpage.clickOnheaderoptionpopup("Sort Alphabetically (A-Z)");
			try {
				Thread.sleep(3000);
			} catch (Exception e) {}
			listoptionpage.clickOnrankingradiobtn();
			listoptionpage.Clickonfilterresultselect(2);
			try {
				Thread.sleep(4000);
			} catch (Exception e) {}
			listoptionpage.Clickonfilterresultselectsuboption(2, "61");
			try {
				Thread.sleep(4000);
			} catch (Exception e) {}
			for (int j=0;j<beforeArr.size();j++){
				Assert.assertTrue(listoptionpage.getTextOffilterlist(beforeArr.get(j)));

			}
			
		}//End of AdvanceFilterbyAgeparemeter 
		/*
		 * Use-case : Add long authored node in list
		 * Test case : Open open infostyle list : http://www.ranker-stage.com/crowdranked-list/the-most-influential-contemporary-americans?
           Add long authored node
		 */
		@Test(priority = 52, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void AddLongAuthoredNode(String loginRequired) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 52 !!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to node page)
			ListOptionPage listoptionpage = null;
			if (loginRequired.equals("YES")) {
				listoptionpage = BaseStateWithLogin("AddAuthoredNode");
			} else {
				listoptionpage = BaseState("AddAuthoredNode");
			}
			common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-most-influential-contemporary-americans?");
			
			common.signin("testuserkallol1@mailinator.com", "testing");
			listoptionpage.putTextInAddListBox("Pablo Diego José Francisco de Paula Juan Nepomuceno María de los Remedios Cipriano de la Santísima Trinidad Ruiz y Picasso");
			listoptionpage.clickOnAddSearchItem();
			try{
				Thread.sleep(10000);
			}catch(Exception e){}
			listoptionpage.clickoneditsubvideoIcon();
			try {
				Thread.sleep(8000);
			} catch (Exception e) {
			}
			listoptionpage.putTextInAddvideo("salman");
			try {
				Thread.sleep(4000);
			} catch (Exception e) {
			}
			int count=listoptionpage.Videocount();
			if(count>2){
			String beforesrc = listoptionpage.getsrcaddvideo(1);
			try{
				Thread.sleep(12000);
			}catch(Exception e){}
			listoptionpage.clickonaddvideo(1);
			try {
				Thread.sleep(5000);
			} catch (Exception e){
			}
			listoptionpage.clickOnvideoSelectButton();
			try{
				Thread.sleep(2000);
			}catch(Exception e){}
			listoptionpage.clickOnDoneButton();
			try{
				Thread.sleep(6000);
			}catch(Exception e){}
			String after = listoptionpage.getsrcafteraddedititems(1);
			Assert.assertEquals(beforesrc, after);
			Assert.assertEquals("normal", listoptionpage.getFontStyleauthorednode());
			}
			else
			{
				Assert.fail("This is not being working");
			}
			listoptionpage.clickOndeletelist("delete");
		}//End of AddLongAuthoredNode
		/*
		 * Use-case : Long Authored quotations
		 * Test case : Open open infostyle list : http://www.ranker-stage.com/crowdranked-list/the-most-influential-contemporary-americans?
           Add long authored node
		 */
		@Test(priority = 53, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void AddLongAuthoredQuotations(String loginRequired) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 53 !!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to node page)
			ListOptionPage listoptionpage = null;
			if (loginRequired.equals("YES")) {
				listoptionpage = BaseStateWithLogin("AddLongAuthoredQuotations");
			} else {
				listoptionpage = BaseState("AddLongAuthoredQuotations");
			}
			if(config.getProperty("Url").contains("stage")){
				common.getNewURL(config.getProperty("Url")+"list/paul-ryan-quotes/speakeasy");
				}
			else{
				common.getNewURL(config.getProperty("Url")+"list/best-quotes/testvikas2");
				}	
			common.signin("testuserkallol1@mailinator.com", "testing");
			listoptionpage.cancelLoading();
			listoptionpage.putTextInAddListBox("Pablo Diego José Francisco de Paula Juan Nepomuceno María de los Remedios Cipriano de la Santísima Trinidad Ruiz y Picasso");
			try{
				Thread.sleep(8000);
			}catch(Exception e){}
			
			listoptionpage.clickOnAddSearchItem();
			try{
				Thread.sleep(5000);
			}catch(Exception e){}
			//listoptionpage.clickoneditsubvideoIcon();
//			try {
//				Thread.sleep(2000);
//			} catch (Exception e) {
//			}
			//listoptionpage.putTextInAddvideo("salman");
			try {
				Thread.sleep(8000);
			} catch (Exception e) {}
			int count=listoptionpage.Imagecount();
			try {
				Thread.sleep(5000);
			} catch (Exception e) {}
			//System.out.println("111111111111111111 "+count);
			if(count>2){
				try {
					Thread.sleep(5000);
				} catch (Exception e) {}
				String src1=listoptionpage.getSrcOfImageResultInEditItemBox(1);
				listoptionpage.clickOnImageResultInEditItemBox(1);
				listoptionpage.clickOnSelectButton();
				try {
					Thread.sleep(10000);
				} catch (Exception e) {}
				listoptionpage.clickOnDoneButton();
				try {
					Thread.sleep(10000);
				} catch (Exception e) {}
				String src2=listoptionpage.getSrcOfListNodeImage("image");
				Assert.assertEquals(src1, src2);
			Assert.assertEquals("italic", listoptionpage.getFontStyleauthorednode());
		}
			else
			{
				Assert.fail("youtube video is not being working");
				listoptionpage.clickOndeletelist("delete");
			}
			listoptionpage.clickOndeletelist("delete");
		}//End of AddLongAuthoredQuotations
		/*
		 * Use-case :    ad_noads tag should hiding ads on all lists
		 * Test case :      Login as admin and
							Open : Info ex: http://www.ranker.com/list/best-current-hbo-shows/ranker-tv
							Blog ex: http://www.ranker-stage.com/list/annoying-instagram-cliches/jacob-shelton
							Slideshow ex: http://www.ranker-stage.com/list/hillary-clinton-facts/devon-ashby
		 */
		@Test(priority = 54, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void AdnoadsTagHideInInfo(String loginRequired) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 54!!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to node page)
			ListHeader listHeader=new ListHeader(getDriver());;
			 Grid grid = new Grid(getDriver());
			 UeListPage ueList= new UeListPage(getDriver());
			 Nodepage nodePage=new  Nodepage(getDriver());
			 ListOptionPage listoptionpage =null;
			 if(loginRequired.equals("YES")){
				 listoptionpage =BaseStateWithLogin("AdnoadsTagHideInInfo");
			 }else{
				 listoptionpage =BaseState("AdnoadsTagHideInInfo");
			 }
			 common.getNewURL(config.getProperty("Url")+"list/best-current-hbo-shows/ranker-tv");
			 common.signin("vijaymohanp", "server");
		     grid.clickOnadminEditList();
			 grid.clickOneditlist();
			 listHeader.clickOnaddnoads();
			 ueList.clickOnDoneInAddTags();
			 grid.clickOnResetTab();
		     grid.clickOnresetsublist(2);
	         listHeader.AlertExistsAndAccepted(1000);
			 Assert.assertTrue(nodePage.isnotdisplayPresentads1());
			try{
				 Thread.sleep(5000);
			 }catch(Exception e){}
			grid.clickOnadminEditList();
			grid.clickOneditlist();
			listHeader.clickOnaddnoads();
			ueList.clickOnDoneInAddTags();
			grid.clickOnResetTab();
			grid.clickOnresetsublist(2);
			listHeader.AlertExistsAndAccepted(1000);
		}//End of AdnoadsTagHideInInfo
		
		/*
		 * Use-case :    ad_noads tag should hiding ads on all lists
		 * Test case :      Login as admin and
							Open : Info ex: http://www.ranker.com/list/best-current-hbo-shows/ranker-tv
							Blog ex: http://www.ranker-stage.com/list/annoying-instagram-cliches/jacob-shelton
							Slideshow ex: http://www.ranker-stage.com/list/hillary-clinton-facts/devon-ashby
		 */
		@Test(priority = 55, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void AdnoadsTagHideInBlog(String loginRequired) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 55!!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to node page)
			ListHeader listHeader=new ListHeader(getDriver());;
			 Grid grid = new Grid(getDriver());
			 UeListPage ueList= new UeListPage(getDriver());
			 Nodepage nodePage=new  Nodepage(getDriver());
			 ListOptionPage listoptionpage =null;
			 if(loginRequired.equals("YES")){
				 listoptionpage =BaseStateWithLogin("AdnoadsTagHideInBlog");
			 }else{
				 listoptionpage =BaseState("AdnoadsTagHideInBlog");
			 }
			 common.getNewURL(config.getProperty("Url")+"list/annoying-instagram-cliches/jacob-shelton");
			 common.signin("vijaymohanp", "server");
			 Assert.assertTrue(nodePage.isPresentads1());
		    // grid.clickOnAdminStats(3);
			 grid.clickOnadminEditList();
			 grid.clickOneditlist();
			 try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			 listHeader.clickOnaddnoads();
			 ueList.clickOnDoneInAddTags();
		     grid.clickOnResetTab();
		     grid.clickOnresetsublist(2);
	         listHeader.AlertExistsAndAccepted(1000);
			 Assert.assertTrue(nodePage.isnotdisplayPresentads1());
			try{
				 Thread.sleep(5000);
			 }catch(Exception e){}
			 grid.clickOnadminEditList();
			//grid.clickOnAdminStats(3);
			grid.clickOneditlist();
			listHeader.clickOnaddnoads();
			ueList.clickOnDoneInAddTags();
			grid.clickOnResetTab();
			grid.clickOnresetsublist(2);
			listHeader.AlertExistsAndAccepted(1000);
		}//End of AdnoadsTagHideInBlog
		
		/*
		 * Use-case :    ad_noads tag should hiding ads on all lists
		 * Test case :      Login as admin and
							Open : Info ex: http://www.ranker.com/list/best-current-hbo-shows/ranker-tv
							Blog ex: http://www.ranker-stage.com/list/annoying-instagram-cliches/jacob-shelton
							Slideshow ex: http://www.ranker-stage.com/list/hillary-clinton-facts/devon-ashby
		 */
		@Test(priority =56, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void AdnoadsTagHideInSlideShow(String loginRequired) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 56!!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to node page)
			ListHeader listHeader=new ListHeader(getDriver());
			 Grid grid = new Grid(getDriver());
			 UeListPage ueList= new UeListPage(getDriver());
			 Nodepage nodePage=new  Nodepage(getDriver());
			 ListOptionPage listoptionpage =null;
			 if(loginRequired.equals("YES")){
				 listoptionpage =BaseStateWithLogin("AdnoadsTagHideInSlideShow");
			 }else{
				 listoptionpage =BaseState("AdnoadsTagInSlideShow");
			 }
			 common.getNewURL(config.getProperty("Url")+"list/annoying-instagram-cliches/jacob-shelton");
			 common.signin("vijaymohanp", "server");
			 Assert.assertTrue(nodePage.isPresentads1());
		    // grid.clickOnAdminStats(3);
			 grid.clickOnadminEditList();
			 grid.clickOneditlist();
			 listHeader.clickOnaddnoads();
			 ueList.clickOnDoneInAddTags();
			 grid.clickOnResetTab();
		     grid.clickOnresetsublist(2);
	         listHeader.AlertExistsAndAccepted(1000);
			 Assert.assertTrue(nodePage.isnotdisplayPresentads1());
			try{
				 Thread.sleep(5000);
			 }catch(Exception e){}
			 grid.clickOnadminEditList();
			//  grid.clickOnAdminStats(3);
			  grid.clickOneditlist();
			listHeader.clickOnaddnoads();
			ueList.clickOnDoneInAddTags();
			grid.clickOnResetTab();
			grid.clickOnresetsublist(2);
			listHeader.AlertExistsAndAccepted(1000);
		}//End of AdnoadsTagHideInSlideShow
//		
		/*
		 * Use-case :   On default the list should display 100 items in one page, if the list has more than 100 items then the load more button should open corresponding next pages. 
		 * Test case :      
		 */
		@Test(priority =57, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void DefaultList(String loginRequired) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 57!!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to node page)
			ListHeader listHeader=new ListHeader(getDriver());
			 Grid grid = new Grid(getDriver());
			 UeListPage ueList= new UeListPage(getDriver());
			 Nodepage nodePage=new  Nodepage(getDriver());
			 ListOptionPage listoptionpage =null;
			 if(loginRequired.equals("YES")){
				 listoptionpage =BaseStateWithLogin("DefaultList");
			 }else{
				 listoptionpage =BaseState("DefaultList");
			 }
			 common.getNewURL(config.getProperty("Url")+"list/actors-nobody-cares-about-anymore/ranker-celebrities");
			 listoptionpage.autoloading(52);
			 listoptionpage.isPresentDefaultLists(100);
			 try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			 listoptionpage.ClickonLoadMoreBtn();
			 Assert.assertTrue(listoptionpage.isPresentDefaultLists(105));
			 }// End of DefaultList
			 
			
		
	/*
	 * This is base state of the slide show test-cases.
	 */
	public ListOptionPage BaseState(String testName) {
		try {
			startRecording(testName);
		} catch (Exception e) {
		}
		common = new Commonpage(getDriver());
		ListOptionPage listoptionpage = common.getListOptionPage(url);
		return listoptionpage;
	} // End of BaseState()
	/*
	 * This is base state of the slide show test-cases.
	 */

	public ListOptionPage BaseStateWithLogin(String testName) {
		try {
			startRecording(testName);
		} catch (Exception e) {
		}
		common = new Commonpage(getDriver());
		common.signin("testuserkallol1@mailinator.com", "testing");
		ListOptionPage listoptionpage = common.getListOptionPage(url);
		return listoptionpage;
	} // End of BaseStateWithLogin()
}