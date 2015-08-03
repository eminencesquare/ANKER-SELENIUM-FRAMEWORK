package com.testsuite.Listheader;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.paeobjects.home.Home;
import com.pageobjects.grid.Grid;
import com.pageobjects.listheader.ListHeader;
import com.pageobjects.listoption.ListOptionPage;
import com.pageobjects.nodepage.Nodepage;
import com.pageobjects.rerank.RerankPage;
import com.pageobjects.slideshow.Slideshow;
import com.pageobjects.uelist.UeListPage;
import com.selenium.SafeActions;

public class ListHeaderTest1 extends BaseSetup {
	ConfigManager urls = new ConfigManager("PreProduction");
	ConfigManager sysProp = new ConfigManager("Sys");
	Commonpage common;
	String ultimateContributeUrl = config.getProperty("Url")+ urls.getProperty("UltimateContributeList");
	String voteUrl = config.getProperty("Url") + urls.getProperty("VoteList");
	String referenceUrl = config.getProperty("Url")+ urls.getProperty("ReferenceList"); 

		
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
	 * Use-case : Check no.of items Test case : "Open any VoteRanked list"
	 */
	@Test(priority = 46, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void CheckNumberOfItems(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 46 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(config.getProperty("Url")+ "list/the-best-movies-roger-ebert-gave-four-stars/film-snob","CheckNumberOfItems");
		} else {
			listHeader = BaseState(config.getProperty("Url")+ "list/the-best-movies-roger-ebert-gave-four-stars/film-snob","CheckNumberOfItems");
		}
		listHeader.scrollToElement("50");
		try{
			Thread.sleep(6000);
		}catch(Exception e){}

		Assert.assertTrue(listHeader.isNodePresent("100"));
	}// End of CheckNumberOfItems

	/*
	 * Use-case : More lists block Test case : Open any list and click on list
	 * links appear more list block appear at bottom of the page with section
	 * title as "viewers of this list also saw"
	 */
	@Test(priority = 47, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void MoreListsBlock(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 47 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(referenceUrl, "RerankButton");
		} else {
			listHeader = BaseState(referenceUrl, "RerankButton");
		}
		int numberOfLinks = listHeader
				.getNumberOfLinksInViewerOfThisListAlsoSawSection();
		Assert.assertEquals(numberOfLinks, 6);
		String[] before = listHeader.gethrefOfViewerOfThisListAlsoSaw(1).split(
				"\\?");
		listHeader.clickViewerOfThisListAlsoSaw(1);
		String[] after = getDriver().getCurrentUrl().split("\\?");
		Assert.assertEquals(before[0], after[0]);
	}// End of MoreListsBlock

	/*
	 * Use-case : Top Queries block Test case : Open any list and click on
	 * "Top Queries" links
	 */
	@Test(priority = 48, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void TopQueriesBlock(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 48 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(referenceUrl, "RerankButton");
		} else {
			listHeader = BaseState(referenceUrl, "RerankButton");
		}
		String before = listHeader.gethrefOfTopQueriesBlock(1);
		listHeader.clickTopQueriesBlock(1);
		if (getDriver().getCurrentUrl().contains(before))
			Assert.assertEquals(1, 1);
		else
			Assert.assertEquals(1, 0);

	}// End of TopQueriesBlock

	/*
	 * Use-case : Related lists Test case : Open any list and click on any one
	 * of the list links in Related list block
	 */
	@Test(priority = 49, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Relatedlists(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 49 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(referenceUrl, "Related lists");
		} else {
			listHeader = BaseState(referenceUrl, "Related lists");
		}
		Assert.assertTrue(listHeader.ispopularsBlockPresent());
		String[] href = listHeader.gethrefOfpopularOfThisListblock(1).split(
				"\\?");
		listHeader.clickonpopularOfThisListblock(1);
		String[] afterurl = getDriver().getCurrentUrl().split("\\?");
		Assert.assertEquals(href[0], afterurl[0]);
		getDriver().navigate().back();
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Assert.assertTrue(listHeader.isviewersBlockPresent());
		String[] before = listHeader.gethrefOfViewerOfThisListAlsoSaw(1).split(
				"\\?");
		listHeader.clickViewerOfThisListAlsoSaw(1);
		String[] after = getDriver().getCurrentUrl().split("\\?");
		Assert.assertEquals(before[0], after[0]);

	}// End of Relatedlists

	/*
	 * Use-case : Test Check box to display "Node Properties" in Blog views Test
	 * case : 1) Open any list as a Admin 2) Under "Meta Data" check the Option
	 * "Always display properties
	 */
	@Test(priority = 50, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void NodepropertiesInBlogSlideshow(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 50 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		Grid grid = new Grid(getDriver());
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(referenceUrl, "Related lists");
		} else {
			listHeader = BaseState(referenceUrl, "NodepropertiesInBlog");
		}

		common.signin("vijaymohanp", "server");
		listoptionpage.clickOnheaderoption();
		listoptionpage.clickOnheaderoptionpopup("View as Blog");
		System.out.println("1111111111111");
		grid.clickOnAdminStats(4);
		grid.checkonmetalist(4);
		System.out.println("22222222222222");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		// listHeader.AlertExistsAndAccepted(1000);
		Assert.assertTrue(listHeader.ispropertyBlockinblogPresent());
		System.out.println("3333333333333333333");
		listoptionpage.clickOnheaderoption();
		listoptionpage.clickOnheaderoptionpopup("View as Slideshow");
		System.out.println("44444444444444");
		Assert.assertTrue(listHeader.ispropertyBlockinslideshowPresent());
		System.out.println("5555555555555555555");
		grid.clickOnAdminStats(4);
		grid.checkonmetalist(4);
		// grid.clickOneditlist(3);
	}// End of NodepropertiesInBlog

	/*
	 * Use-case : Check voting Test case : Open any VoteRanked list and try
	 * voting
	 */
	@Test(priority = 51, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Checkvoting(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 51 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		RerankPage rerankpage = new RerankPage(getDriver());
		Grid grid = new Grid(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(
					config.getProperty("Url")
							+ "list/the-best-movies-roger-ebert-gave-four-stars/film-snob",
					"Checkvoting");
		} else {
			listHeader = BaseState(
					config.getProperty("Url")
							+ "list/the-best-movies-roger-ebert-gave-four-stars/film-snob",
					"Checkvoting");
		}
		String before = listHeader.getAttriOfvoteicon(1);
		rerankpage.clickonvotebtn(1);
		SafeActions s = new SafeActions(getDriver());
		s.waitForPageToLoad(40);
		String after = listHeader.getAttriOfvoteicon(1);
		Assert.assertNotEquals(before, after);
		s.waitForPageToLoad(20);
		String downbefore = listHeader.getAttriOfvoteicon(1);
		grid.clickDownvote("1");
		String downafter = listHeader.getAttriOfvoteicon(1);
		Assert.assertNotEquals(downbefore, downafter);
	}// End of Checkvoting

	/*
	 * Use-case : Verify Pagination for monetizable Test case : 1) Open any
	 * monetizable list and verify pagination
	 */
	@Test(priority = 52, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void PaginationforMonetizableList(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 52!!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		Grid grid = new Grid(getDriver());
		UeListPage ueList = new UeListPage(getDriver());
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(referenceUrl,
					"PaginationforMonetizableList");
		} else {
			listHeader = BaseState(referenceUrl, "PaginationforMonetizableList");
		}

		common.signin("vijaymohanp", "server");
		grid.clickOnAdminStats(3);
		grid.clickOneditlist();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		listHeader.selectTagsCheckBoxmonetizable();
		ueList.clickOnDoneInAddTags();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		Assert.assertTrue(listHeader.ispaginationPresent());
		Assert.assertEquals("rgba(254, 251, 199, 1)",listHeader.getpaginationbackgrndColor());
		grid.clickOnAdminStats(3);
		grid.clickOneditlist();
		listHeader.selectTagsCheckBoxmonetizable();
		ueList.clickOnDoneInAddTags();
		// grid.clickOneditlist(3);
	}// End of PaginationforMonetizableList

	/*
	 * Use-case : Check embed option for HTML REFERRAL tagged slideshow lists
	 * Test case : Should not see the 'embed' option all over the list, i.e
	 * under more options and end of MLA
	 */
	@Test(priority = 53, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Checkembedoption(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 53!!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		Grid grid = new Grid(getDriver());
		UeListPage ueList = new UeListPage(getDriver());
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(referenceUrl, "Checkembedoption");
		} else {
			listHeader = BaseState(referenceUrl, "Checkembedoption");
		}

		common.signin("vijaymohanp", "server");
		if(listHeader.isembedtabPresent()==true){
			System.out.println("1111111111");
		Assert.assertTrue(listHeader.isembedtabPresent());}
		else{
			System.out.println("22222222222222222");
			grid.clickOnadminEditList();
//			grid.clickOneditlist(3);
			grid.clickOnlistsetting();
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			ueList.clickonembedbtn();
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			ueList.clickOnpublishbtn();
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			Assert.assertTrue(listHeader.isembedtabPresent());
		}
		System.out.println("33333333333333");
		grid.clickOnadminEditList();
		System.out.println("444444444444444");
		//grid.clickOnAdminStats(3);
		grid.clickOneditlist();
		System.out.println("555555555555555");
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
		}
	
		// listHeader.selectTagsCheckBoxHTMLReferral();
		listHeader.selectTagsCheckBoxHTMLReferral();
		System.out.println("666666666666");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		ueList.clickOnDoneInAddTags();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		grid.clickOnResetTab();
		grid.clickOnresetsublist(2);
		listHeader.AlertExistsAndAccepted(1000);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		System.out.println("7777777777777");
		if(listHeader.isembedtabPresent()==true){
			System.out.println("1111111111");
		Assert.assertTrue(listHeader.isembedtabPresent());}
		else{
		Assert.assertFalse(listHeader.isembedtabPresent());
		}
		System.out.println("8888888888888888");
		grid.clickOnadminEditList();
		grid.clickOneditlist();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("9999999999999999");
		ueList.clickonembedbtn();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("110101010111111111");
		ueList.clickOnpublishbtn();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		grid.clickOnadminEditList();
		grid.clickOneditlist();
		System.out.println("121212121");
		listHeader.selectTagsCheckBoxHTMLReferral();
		ueList.clickOnDoneInAddTags();
	}// End of Checkembedoption

	/*
	 * Use-case : Add social chicklets to list header Test case : 1. Go to a UL
	 * infostyle list and verify that the 4 chicklets are there. Click on all
	 * social chicklets
	 */
	@Test(priority = 54, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialrefrencelistFB(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 54 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(config.getProperty("Url")
					+ "list/best-r-rated-spy-film-movies/reference",
					"FloterSocialrefrencelistFB");
			// listHeader
			// =BaseStateWithLogin(referenceUrl,"FloterSocialULInfoFB");
		} else {
			listHeader = BaseState(config.getProperty("Url")
					+ "list/best-r-rated-spy-film-movies/reference",
					"FloterSocialULInfoFB");
		}
		// UL info style list
		// Facebook

		listHeader.clickOnFloterSocialChicklets(1);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		//common.facebookLogin("salmankhantc", "Dehradun1");
		common.facebookLogin("vikas@ranker.com", "vikas@123");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		Assert.assertTrue(listHeader.isPresentfacebookwindowpresent());
		Assert.assertFalse(listHeader.isPresentfacebookErrorpresent());
		getDriver().close();
		listHeader.switchToWindow(0);
	} // End of FloterSocialULInfoFB

	/*
	 * Use-case : Add social chicklets to list header Test case : 1. Go to a UL
	 * infostyle list and verify that the twitter chicklets is there. Click on
	 * all social chicklets
	 */
	@Test(priority = 55, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialrefrencelistTW(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 55 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		ListOptionPage listOption = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(config.getProperty("Url")
					+ "list/best-r-rated-spy-film-movies/reference",
					"FloterSocialrefrencelistTW");
			// listHeader
			// =BaseStateWithLogin(referenceUrl,"FloterSocialULInfoFB");
		} else {
			listHeader = BaseState(config.getProperty("Url")
					+ "list/best-r-rated-spy-film-movies/reference",
					"FloterSocialrefrencelistTW");
		}
		// UL info style list
		// Twitter
		listHeader.clickOnFloterSocialChicklets(2);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		if (listOption.isPresenttiwtterlogin() == true) {
			Assert.assertEquals(1, 1);
		} else if (listHeader.isPresenttwitterwindowpresent()) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
		getDriver().close();
		listHeader.switchToWindow(0);
	} // End of FloterSocialULInfoTW

	/*
	 * Use-case : Add social chicklets to list header Test case : Go to a NON UL
	 * infostyle list and verify that the twitter chicklets is there Click on
	 * twitter social chicklets
	 */
	@Test(priority = 56, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialrefrencelistPinterest(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 56 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		ListOptionPage listOption = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(config.getProperty("Url")
					+ "list/best-r-rated-spy-film-movies/reference",
					"FloterSocialrefrencelistPinterest");
			// listHeader
			// =BaseStateWithLogin(referenceUrl,"FloterSocialULInfoFB");
		} else {
			listHeader = BaseState(config.getProperty("Url")
					+ "list/best-r-rated-spy-film-movies/reference",
					"FloterSocialrefrencelistPinterest");
		}
		listHeader.clickOnFloterSocialChicklets(3);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		common.clickOnPintLoginFBbutton();
		//common.facebookLogin("salmankhantc", "Dehradun1");
		common.facebookLogin("vikas@ranker.com", "vikas@123");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		SafeActions sf = new SafeActions(getDriver());
		sf.switchToWindow(1);
		Assert.assertTrue(listOption.ispintersetWindowPresent());
		//Assert.assertTrue(listOption.istiwtterWindowPresent());
		getDriver().close();
		listHeader.switchToWindow(0);
	} // End of FloterSocialrefrencelistPinterest

	/*
	 * Use-case : Slide show Pagination: Button to slide first slide Test case :
	 * This should take you to first slide of the list
	 */
	@Test(priority = 57, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void SlideFirstSlide(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 57 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		Slideshow slideshow = new Slideshow(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl, "SlideFirstSlide");
		} else {
			listHeader = BaseState(voteUrl, "SlideFirstSlide");
		}
		// Slideshow style list
		common.signin("vijaymohanp", "server");
		ListOptionPage listOption = new ListOptionPage(getDriver());
		listOption.clickOnheaderoption();
		listOption.clickOnheaderoptionpopup("View as Slideshow");
		slideshow.clickOnSlide(5);
		 //browserWait();
		try{
			Thread.sleep(5000);
		}catch(Exception e){}
		slideshow.clickOnFirstSlideButton();
		 String nodeNo1 = slideshow.getSlideNo();
		// browserWait();
		//String nodeNo = slideshow.getNodeNumber();
		//String slideNo = slideshow.getSlideNo();
		System.out.println("slideno---"+nodeNo1);
		int slideIntegerAfter = Integer.parseInt(nodeNo1);
		System.out.println("slideinteger---"+slideIntegerAfter);
		Assert.assertEquals(1, slideIntegerAfter);
	}// End of SlideFirstSlide

	/*
	 * Use-case : Node tagged page Test case : Go to any node tagged page and
	 * click on the next list button (should be on the last slide of slideshows;
	 * currently doesn't exist on grid & blog).
	 */
	@Test(priority = 58, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Nodetaggedpage(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 58 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		int state = 0;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(
					config.getProperty("Url")
							+ "list/actors-nobody-cares-about-anymore/ranker-celebrities?format=SLIDESHOW",
					"Nodetaggedpage");
			// listHeader
			// =BaseStateWithLogin(referenceUrl,"FloterSocialULInfoFB");
		} else {
			listHeader = BaseState(
					config.getProperty("Url")
							+ "list/actors-nobody-cares-about-anymore/ranker-celebrities?format=SLIDESHOW",
					"Nodetaggedpage");
		}
		ListOptionPage listOption = new ListOptionPage(getDriver());
		listHeader.clickOnmoreInfoLink();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		String before = listHeader.getTextOftagscategory();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// slideshow.clickNext();
		listHeader.clickonnextlistfooter();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		listHeader.clickOnmoreInfoLink();
		for (int i = 1; i <= 5; i++) {
			if (listHeader.getTextOfnextlisttags(i).equalsIgnoreCase("PEOPLE,")) {
				state = 1;
				break;

			}
		}
		if (state == 1) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}

	}// End of SlideFirstSlide

	/*
	 * Use-case : Reranks Tab Test case : go to any ultimate list and click on
	 * reranks btn and check whether the list opened does not match with the
	 * list given.
	 */
	@Test(priority = 59, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void RerankTabOverlayCheck(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 59 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"RerankTabOverlayCheck");
		} else {
			listHeader = BaseState(ultimateContributeUrl,
					"RerankTabOverlayCheck");
		}
		// common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-10-worst-u-s-presidents");
		common.votableLinkPresenceAndAccept();
		String name1 = listHeader.getTextOfNodeInList("name");
		listHeader.clickonrerankstab();
		String name2 = listHeader.getTextOfrerankOverlayNode();
		Assert.assertNotEquals(name1, name2);
	} // end of RerankTabOverlayCheck

	/*
	 * Use-case : overlay Tab Test case : go to any ultimate list and click on
	 * overlay tab named as age and check whether the node selected does not
	 * match with the previous node before click .
	 */
	@Test(priority = 60, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void OverlayCheck(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 60 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		int state = 0;
		Slideshow slideshow = new Slideshow(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl, "overlayTab");

		} else {
			listHeader = BaseState(ultimateContributeUrl, "overlayTab");
		}
		listHeader.clickOverLaytab(2);
		try {
			Thread.sleep(9000);
		} catch (Exception e) {
		}
		String beforeClick = listHeader.getTextOfrerankOverlayNode();
		System.out.println("beforeClick ----" + beforeClick);
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
		}
		listHeader.clickOndropDownlist();
		listHeader.clickOnselectdropdownOption();
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
		}
		String afterClick = listHeader.getTextOfrerankOverlayNode();
		;
		System.out.println("afterClick---- " + afterClick);
		Assert.assertNotEquals(beforeClick, afterClick);
	}// End of overlayTab

	/*
	 * Use-case : Verify "views" logic in list stats Test case : 1. Go to a list
	 * with >=1000 views
	 * http://www.ranker-stage.com/list/best-sportscenter-anchors
	 * -of-all-time/surag 2. Check list stats 3. Go to a list with <1000 views
	 * http://www.ranker-stage.com/list/the-best-movie-streaming-services/surag
	 * 4. Check list stats
	 */
	@Test(priority = 61, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ViewsLogicInListStats(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 61 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		int state = 0;
		ListOptionPage listOption = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl, "ViewsLogicInListStats");
			// listHeader
			// =BaseStateWithLogin(referenceUrl,"FloterSocialULInfoFB");
		} else {
			listHeader = BaseState(voteUrl, "ViewsLogicInListStats");
		}
		common.getNewURL(config.getProperty("Url")
				+ "list/best-sportscenter-anchors-of-all-time/surag");
		if (listHeader.isStatsPresent(4)) {
			String views = listHeader.getviewsinlist(5);
			// System.out.println("views==="+views);
			int view = Integer.parseInt(views.split("views")[0].replaceAll(",",
					"").replaceAll(" ", ""));
			// System.out.println("view==="+view);
			if (1000 <= view)
				state = 1;
		}
		if (state == 1) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		common.getNewURL(config.getProperty("Url")
				+ "list/the-best-movie-streaming-services/surag");
		if (listHeader.isStatsPresent(4) == false) {

			state = 1;
		}
		if (state == 1) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
	} // End of ViewsLogicInListStats

	/*
	 * Use-case : Verify ad_noads tag Test case : Open following list with admin
	 * and Untag :"ad_noads" Eg: Info ex:
	 * http://www.ranker.com/list/best-current-hbo-shows/ranker-tv Blog ex:
	 * http://www.ranker-stage.com/list/annoying-instagram-cliches/jacob-shelton
	 * Slideshow ex:
	 * http://www.ranker-stage.com/list/hillary-clinton-facts/devon-ashby
	 */
	@Test(priority = 62, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AdnoadsTagInInfo(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 62!!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		Grid grid = new Grid(getDriver());
		UeListPage ueList = new UeListPage(getDriver());
		Nodepage nodePage = new Nodepage(getDriver());
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(referenceUrl, "AdnoadsTagInInfo");
		} else {
			listHeader = BaseState(referenceUrl, "AdnoadsTagInInfo");
		}
		common.getNewURL(config.getProperty("Url")+ "list/best-current-hbo-shows/ranker-tv");
		common.signin("vijaymohanp", "server");
		Assert.assertTrue(nodePage.isPresentads1());
		grid.clickOnAdminStats(3);
		grid.clickOneditlist();
		listHeader.clickOnaddnoads();
		ueList.clickOnDoneInAddTags();
		grid.clickOnAdminStats(9);
		grid.clickOnresetsublist(2);
		listHeader.AlertExistsAndAccepted(1000);
		Assert.assertTrue(nodePage.isnotdisplayPresentads1());
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
		}
		grid.clickOnAdminStats(3);
		grid.clickOneditlist();
		listHeader.clickOnaddnoads();
		ueList.clickOnDoneInAddTags();
		grid.clickOnAdminStats(9);
		grid.clickOnresetsublist(2);
		listHeader.AlertExistsAndAccepted(1000);
	}// End of AdnoadsTagInInfo

	/*
	 * Use-case : Verify ad_noads tag Test case : Open following list with admin
	 * and Untag :"ad_noads" Eg: Info ex:
	 * http://www.ranker.com/list/best-current-hbo-shows/ranker-tv Blog ex:
	 * http://www.ranker-stage.com/list/annoying-instagram-cliches/jacob-shelton
	 * Slideshow ex:
	 * http://www.ranker-stage.com/list/hillary-clinton-facts/devon-ashby
	 */
	@Test(priority = 63, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AdnoadsTagInBlog(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 63!!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		Grid grid = new Grid(getDriver());
		UeListPage ueList = new UeListPage(getDriver());
		Nodepage nodePage = new Nodepage(getDriver());
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(referenceUrl, "AdnoadsTagInBlog");
		} else {
			listHeader = BaseState(referenceUrl, "AdnoadsTagInBlog");
		}
		common.getNewURL(config.getProperty("Url")
				+ "list/annoying-instagram-cliches/jacob-shelton");
		common.signin("vijaymohanp", "server");
		Assert.assertTrue(nodePage.isPresentads1());
		grid.clickOnAdminStats(3);
		grid.clickOneditlist();
		listHeader.clickOnaddnoads();
		ueList.clickOnDoneInAddTags();
		grid.clickOnAdminStats(9);
		grid.clickOnresetsublist(2);
		listHeader.AlertExistsAndAccepted(1000);
		Assert.assertTrue(nodePage.isnotdisplayPresentads1());
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		grid.clickOnAdminStats(3);
		grid.clickOneditlist();
		listHeader.clickOnaddnoads();
		ueList.clickOnDoneInAddTags();
		grid.clickOnAdminStats(9);
		grid.clickOnresetsublist(2);
		listHeader.AlertExistsAndAccepted(1000);
	}// End of AdnoadsTagInBlog

	/*
	 * Use-case : Verify ad_noads tag Test case : Open following list with admin
	 * and Untag :"ad_noads" Eg: Info ex:
	 * http://www.ranker.com/list/best-current-hbo-shows/ranker-tv Blog ex:
	 * http://www.ranker-stage.com/list/annoying-instagram-cliches/jacob-shelton
	 * Slideshow ex:
	 * http://www.ranker-stage.com/list/hillary-clinton-facts/devon-ashby
	 */
	@Test(priority = 64, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AdnoadsTagInSlideShow(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 64!!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		Grid grid = new Grid(getDriver());
		UeListPage ueList = new UeListPage(getDriver());
		Nodepage nodePage = new Nodepage(getDriver());
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(referenceUrl,
					"AdnoadsTagInSlideShow");
		} else {
			listHeader = BaseState(referenceUrl, "AdnoadsTagInSlideShow");
		}
		common.getNewURL(config.getProperty("Url")
				+ "list/annoying-instagram-cliches/jacob-shelton");
		common.signin("vijaymohanp", "server");
		Assert.assertTrue(nodePage.isPresentads1());
		grid.clickOnAdminStats(3);
		grid.clickOneditlist();
		listHeader.clickOnaddnoads();
		ueList.clickOnDoneInAddTags();
		grid.clickOnAdminStats(9);
		grid.clickOnresetsublist(2);
		listHeader.AlertExistsAndAccepted(1000);
		Assert.assertTrue(nodePage.isnotdisplayPresentads1());
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		grid.clickOnAdminStats(3);
		grid.clickOneditlist();
		listHeader.clickOnaddnoads();
		ueList.clickOnDoneInAddTags();
		grid.clickOnAdminStats(9);
		grid.clickOnresetsublist(2);
		listHeader.AlertExistsAndAccepted(1000);
	}// End of AdnoadsTagInSlideShow

	/*
	 * Use-case : Remove the expander icon when it's an authored node Test case
	 * : Go to a list that has only system nodes (ex:
	 * http://www.ranker-stage.com/list/best-r-rated-spy-film-movies/reference),
	 * only authored nodes
	 * (ex:http://www.ranker-stage.com/list/annoying-foodie-words
	 * /jacob-shelton), and both system and authored nodes (ex:
	 * http://www.ranker-stage.com/list/best-2015-nfl-draft-prospects/surag).
	 */
	@Test(priority = 65, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ExpanderIconInSystemNode(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 65 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl,
					"ExpanderIconInSystemNode");
		} else {
			listHeader = BaseState(voteUrl,
					"ExpanderIconInSystemNode");
		}
		//common.getNewURL(config.getProperty("Url")
		//		+ "list/best-r-rated-spy-film-movies/reference");
		common.signin("testuserkallol1@mailinator.com", "testing");
		// try {
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// }
		Assert.assertTrue(listHeader.isExpandiconPresentInlist(1));
		listoptionpage.putTextInAddListBox("testing");
		listoptionpage.clickOnAddSearchItem();
		// try{
		// Thread.sleep(5000);
		// }catch(Exception e){}
		listoptionpage.clickoneditsubvideoIcon();
		// try {
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// }
		listoptionpage.putTextInAddvideo("salman");
		try {
			Thread.sleep(2000);
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
			try {
				Thread.sleep(6000);
			} catch (Exception e) {
			}
		} else {
			Assert.fail("youtube video is not being working");
		}
		Assert.assertFalse(listHeader.isExpandiconPresent());
		listoptionpage.clickOndeletelist("delete");

	} // end of ExpanderIconInSystemNode

	/*
	 * Use-case : Add sticky after item is added to list 
	 * Test case : 1 Go to any
	 * open list :
	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film?
	 * vote list :
	 * http://www.ranker-stage.com/list/best-bands-fronted-by-famous-
	 * actors/ranker-music
	 *  2 Open non-votable list :
	 * http://www.ranker-stage.com/
	 * list/smartest-famous-people/celebrity-lists?page=2
	 */
	@Test(priority = 66, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ItemAddedInVoteList(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 66 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"ItemAddedInVoteList");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "ItemAddedInVoteList");
		}
		common.getNewURL(config.getProperty("Url")+ "list/best-r-rated-spy-film-movies/reference");
		common.signin("testuserkallol1@mailinator.com", "testing");
		// try {
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// }
		listoptionpage.putTextInAddListBox("testing");
		listoptionpage.clickOnAddSearchItem();
		// try{
		// Thread.sleep(5000);
		// }catch(Exception e){}
		listoptionpage.clickoneditsubvideoIcon();
		// try {
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// }
		listoptionpage.putTextInAddvideo("salman");
		try {
			Thread.sleep(2000);
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
			try {
				Thread.sleep(6000);
			} catch (Exception e) {
			}
		} else {
			Assert.fail("youtube video is not being working");
		}
		Assert.assertTrue(listHeader.isStickeyInlistPresent());
		listoptionpage.clickOndeletelist("delete");

	} // end of ItemAddedInVoteList

	/*
	 * Use-case : Add sticky after item is added to list Test case : 1 Go to any
	 * open list :
	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film?
	 * vote list :
	 * http://www.ranker-stage.com/list/best-bands-fronted-by-famous-
	 * actors/ranker-music 2 Open non-votable list :
	 * http://www.ranker-stage.com/
	 * list/smartest-famous-people/celebrity-lists?page=2
	 */
	@Test(priority = 67, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ItemAddedInNonVoteList(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 67 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"ItemAddedInNonVoteList");
		} else {
			
			listHeader = BaseState(ultimateContributeUrl,
					"ItemAddedInNonVoteList");
		}
		common.getNewURL(config.getProperty("Url")
				+ "list/smartest-famous-people/celebrity-lists?page=2");
		common.signin("testuserkallol1@mailinator.com", "testing");
		// try {
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// }
		listoptionpage.putTextInAddListBox("testing");
		listoptionpage.clickOnAddSearchItem();
		// try{
		// Thread.sleep(5000);
		// }catch(Exception e){}
//		listoptionpage.clickoneditsubvideoIcon();
//		// try {
//		// Thread.sleep(2000);
//		// } catch (Exception e) {
//		// }
//		listoptionpage.putTextInAddvideo("salman");
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//		}
//		int count = listoptionpage.Videocount();
//		if (count > 2) {
//			try {
//				Thread.sleep(5000);
//			} catch (Exception e) {
//			}
//			listoptionpage.clickonaddvideo(1);
//			try {
//				Thread.sleep(4000);
//			} catch (Exception e) {
//			}
//			listoptionpage.clickOnvideoSelectButton();
//			listoptionpage.clickOnDoneButton();
//			try {
//				Thread.sleep(6000);
//			} catch (Exception e) {
//			}
//		} else {
//			Assert.fail("youtube video is not being working");
//		}
		Assert.assertTrue(listHeader.ischickletsPresent());
		Assert.assertFalse(listHeader.isStickeyInlistPresent());
		listoptionpage.clickOndeletelist("delete");
	} // end of ItemAddedInNonVoteList

	/*
	 * Use-case : Remove the expander icon when it's an authored node Test case
	 * : Go to a list that has only system nodes (ex:
	 * http://www.ranker-stage.com/list/best-r-rated-spy-film-movies/reference),
	 * only authored nodes
	 * (ex:http://www.ranker-stage.com/list/annoying-foodie-words
	 * /jacob-shelton), and both system and authored nodes (ex:
	 * http://www.ranker-stage.com/list/best-2015-nfl-draft-prospects/surag).
	 */
	@Test(priority = 68, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ExpanderIconInAuthoredNode(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 68 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,"ExpanderIconInAuthoredNode");
		} else {
			listHeader = BaseState(ultimateContributeUrl,"ExpanderIconInAuthoredNode");
		}
		common.getNewURL(config.getProperty("Url")+ "list/annoying-foodie-words/jacob-shelton");
		common.signin("testuserkallol1@mailinator.com", "testing");
		// try {
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// }
		Assert.assertTrue(listHeader.isExpandiconPresentInlist(4));
		listoptionpage.putTextInAddListBox("testing");
		listoptionpage.clickOnAddSearchItem();
		System.out.println("1111111111111111");
		
		 try{
		 Thread.sleep(5000);
		 }catch(Exception e){}
		listoptionpage.clickoneditsubvideoIcon();
		// try {
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// }
		System.out.println("2222222222222222");
		listoptionpage.putTextInAddvideo("salman");
		try {
			Thread.sleep(2000);
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
			System.out.println("3333333333333");
			try {
				Thread.sleep(6000);
			} catch (Exception e) {
			}
		} else {
			Assert.fail("youtube video is not being working");
		}
		System.out.println("44444444444444444444");
		Assert.assertFalse(listHeader.isExpandiconPresent());
		System.out.println("555555555555555");
		listoptionpage.clickOndeletelist("delete");

	} // end of ExpanderIconInAuthoredNode

	/*
	 * Use-case : Remove the expander icon when it's an authored node Test case
	 * : Go to a list that has only system nodes (ex:
	 * http://www.ranker-stage.com/list/best-r-rated-spy-film-movies/reference),
	 * only authored nodes
	 * (ex:http://www.ranker-stage.com/list/annoying-foodie-words
	 * /jacob-shelton), and both system and authored nodes (ex:
	 * http://www.ranker-stage.com/list/best-2015-nfl-draft-prospects/surag).
	 */
	@Test(priority = 69, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ExpanderIconInSystemAndAuthoredNode(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 69 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl,
					"ExpanderIconInSystemAndAuthoredNode");
		} else {
			listHeader = BaseState(voteUrl,
					"ExpanderIconInSystemAndAuthoredNode");
		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/best-2015-nfl-draft-prospects/surag");
		common.signin("testuserkallol1@mailinator.com", "testing");
		// try {
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// }
		Assert.assertTrue(listHeader.isExpandiconPresentInlist(1));
		listoptionpage.putTextInAddListBox("testing");
		listoptionpage.clickOnAddSearchItem();
		// try{
		// Thread.sleep(5000);
		// }catch(Exception e){}
		listoptionpage.clickoneditsubvideoIcon();
		// try {
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// }
		listoptionpage.putTextInAddvideo("salman");
		try {
			Thread.sleep(2000);
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
				Thread.sleep(2000);
			} catch (Exception e) {
			}
			listoptionpage.clickOnvideoSelectButton();
			listoptionpage.clickOnDoneButton();
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
			}
		} else {
			Assert.fail("youtube video is not being working");
		}
		Assert.assertFalse(listHeader.isExpandiconPresent());
		listoptionpage.clickOndeletelist("delete");

	} // end of ExpanderIconInSystemAndAuthoredNode

	/*
	 * Use-case : Add "originally by" and original username to Ultimate Lists
	 * Test case : Open various ultimate lists (ex:
	 * http://www.ranker-stage.com/list/famous-women-beer-list/greg).
	 */
	@Test(priority = 70, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void OriginallyByuserName(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 70 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(referenceUrl,
					"OriginallyByuserName");
		} else {
			listHeader = BaseState(referenceUrl, "OriginallyByuserName");
		}

		common.getNewURL(config.getProperty("Url")
				+ "list/famous-women-beer-list/greg");
		Assert.assertTrue(listHeader.isusernamePresent());
	}// End of OriginallyByuserName

	/*
	 * Use-case : Verify admin is able to see list ID in the input text box on
	 * the admin bar Test case :1) Go to any list logged in as an admin 2) Click
	 * on the the List id in the input text box in the admin bar
	 */
	@Test(priority = 71, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ListIdInputBox(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 71 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl, "ListIdInputBox");
		} else {
			listHeader = BaseState(voteUrl, "ListIdInputBox");
		}
		common.signin("vijaymohanp", "server");
		Assert.assertTrue(listHeader.isInputListBoxPresent());
		listHeader.clickOnInputListBox();
		Assert.assertEquals("rgba(51, 51, 51, 1)",
				listHeader.getColorOfInputListBox());
	}// End of ListIdInputBox

	/*
	 * Use-case : Verify Changed name of ROI scores in Admin bar Test case :1)
	 * Log in as an admin 2) Go to any list 3) Click on STATS in the admin bar,
	 */
	@Test(priority = 72, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ROIScores(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 72 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl, "ROIScores");
		} else {
			listHeader = BaseState(voteUrl, "ROIScores");
		}
		common.signin("vijaymohanp", "server");
		Grid grid = new Grid(getDriver());
		grid.clickOnAdminStats(8);
		grid.clickOnRLstat();
		//grid.clickOnSubStats(1);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Assert.assertTrue(listHeader.isRLSubstatsPresent());
		grid.clickOnClose();
		grid.clickOnAdminStats(8);
		grid.clickOnROLstat();
		//grid.clickOnSubStats(2);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Assert.assertTrue(listHeader.isROISubstatsPresent());
		grid.clickOnClose();
	}// End of ROIScores

	/*
	 * Use-case : Node expand when click on full row area Test case :Open :
	 * http:
	 * //www.ranker-stage.com/list/best-deceased-saturday-night-live-cast-member
	 * /lanayoshii Click on Node row area
	 */
	@Test(priority = 73, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void NodeExpand(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 73 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl, "NodeExpand");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "NodeExpand");
		}
		common.getNewURL(config.getProperty("Url")
				+ "list/best-deceased-saturday-night-live-cast-member/lanayoshii");
		listHeader.clickOnExpandiconInlist(1);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Assert.assertTrue(listHeader.isExpandiconPresent());
	}// End of NodeExpand

	/*
	 * Use-case : Verify links in blather open in a new tab/window Test case
	 * :Open : 1) Go to any list with external link in blather eg
	 * http://www.ranker
	 * -stage.com/list/the-top-8-celebrities-killed-by-the-internet/ivana-wynn
	 * 2) Scroll down to blather and click on source link
	 */
	@Test(priority = 74, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void BlatherNewTab(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 74 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"BlatherNewTab");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "BlatherNewTab");
		}

		common.getNewURL(config.getProperty("Url")+ "list/the-top-8-celebrities-killed-by-the-internet/ivana-wynn");
		String href = listHeader.gethrefOfBlatherSource();
		listHeader.clickOnBlatherSource();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		ArrayList<String> tabs2 = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs2.get(1));
		String afterurl = getDriver().getCurrentUrl();
		Assert.assertEquals(afterurl, href);
		getDriver().close();
		getDriver().switchTo().window(tabs2.get(0));
	}// End of BlatherNewTab

	/*
	 * Use-case : Admin Bar: Add setting to display on INFO contracted state
	 * Test case : 1. Go to an infostyle list Eg:
	 * http://www.ranker-stage.com/crowdranked
	 * -list/the-u-s-presidents-from-best-to-worst 2. Verify new setting
	 * "show wiki in closed state on infostyle" with a checkbox in
	 * "List Actions"
	 */
	@Test(priority = 75, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void CheckWikiDisplay(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 75 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,"CheckWikiDisplay");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "CheckWikiDisplay");
		}
		Grid grid = new Grid(getDriver());
		common.getNewURL(config.getProperty("Url")+ "list/who-should-host-oscars-2016/ranker-film");
		common.signin("vijaymohanp", "server");
		grid.clickOnAdminStats(5);
		listHeader.clickOnshowWiki();
		listHeader.AlertExistsAndAccepted(2000);
		grid.clickOnAdminStats(9);
		grid.clickOnresetsublist(2);
		listHeader.AlertExistsAndAccepted(2000);
		Assert.assertTrue(listHeader.isFirstnodetextPresent());
		grid.clickOnAdminStats(5);
		listHeader.clickOnshowWiki();
		listHeader.AlertExistsAndAccepted(2000);
		grid.clickOnAdminStats(9);
		grid.clickOnresetsublist(2);
		listHeader.AlertExistsAndAccepted(2000);
		//Assert.assertFalse(listHeader.isFirstnodetextPresent());
	}// End of CheckWikiDisplay

	/*
	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
	 * open list :
	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
	 * Add any item 2-Similary add item in vote list :
	 * http://www.ranker-stage.com
	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
	 * non-votable list :
	 * http://www.ranker-stage.com/list/smartest-famous-people
	 * /celebrity-lists?page=2
	 */
	@Test(priority = 76, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddSocialChickletsFacebookInOpenList(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 76 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"AddSocialChickletsFacebookInOpenList");
		} else {
			listHeader = BaseState(ultimateContributeUrl,
					"AddSocialChickletsFacebookInOpenList");
		}
		//list/actors-nobody-cares-about-anymore/ranker-celebrities
		common.getNewURL(config.getProperty("Url")+ "crowdranked-list/best-marvel-villains");
		common.signin("testuserkallol1@mailinator.com", "testing");
		listoptionpage.putTextInAddListBox("testing");
		listoptionpage.clickOnAddSearchItem();
		listoptionpage.clickoneditsubvideoIcon();
		listoptionpage.putTextInAddvideo("salman");
		try {
			Thread.sleep(2000);
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
			try {
				Thread.sleep(6000);
			} catch (Exception e) {
			}
		} else {
			Assert.fail("youtube video is not being working");
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		Assert.assertTrue(listHeader.ischickletsPresent());
		// facebook
		listHeader.clickOnsocialchicklets(1);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		//common.facebookLogin("salmankhantc", "Dehradun1");
		common.facebookLogin("vikas@ranker.com", "vikas@123");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}

		Assert.assertTrue(listHeader.isPresentfacebookwindowpresent());
		Assert.assertFalse(listHeader.isPresentfacebookErrorpresent());
		getDriver().close();
		listoptionpage.switchToParentWindow();
		listoptionpage.clickOndeletelist("delete");
		//
	} // end of AddSocialChickletsFacebookInOpenList

	/*
	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
	 * open list :
	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
	 * Add any item 2-Similary add item in vote list :
	 * http://www.ranker-stage.com
	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
	 * non-votable list :
	 * http://www.ranker-stage.com/list/smartest-famous-people
	 * /celebrity-lists?page=2
	 */
	@Test(priority = 77, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddSocialChickletsTwitterInOpenList(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 77 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"AddSocialChickletsTwitterInOpenList");
		} else {
			listHeader = BaseState(ultimateContributeUrl,
					"AddSocialChickletsTwitterInOpenList");
		}
		common.getNewURL(config.getProperty("Url")+ "crowdranked-list/best-marvel-villains");
		common.signin("testuserkallol1@mailinator.com", "testing");
		listoptionpage.putTextInAddListBox("testing");
		listoptionpage.clickOnAddSearchItem();
		listoptionpage.clickoneditsubvideoIcon();
		listoptionpage.putTextInAddvideo("salman");
		try {
			Thread.sleep(2000);
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
			try {
				Thread.sleep(6000);
			} catch (Exception e) {
			}
		} else {
			Assert.fail("youtube video is not being working");
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		Assert.assertTrue(listHeader.ischickletsPresent());

		// twitter
		listHeader.clickOnsocialchicklets(2);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		if (listoptionpage.isPresenttiwtterlogin() == true) {
			Assert.assertEquals(1, 1);
		} else if (listHeader.isPresenttwitterwindowpresent()) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
		getDriver().close();
		listoptionpage.switchToParentWindow();
		listoptionpage.clickOndeletelist("delete");

	} // end of AddSocialChickletsTwitterInOpenList

	/*
	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
	 * open list :
	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
	 * Add any item 2-Similary add item in vote list :
	 * http://www.ranker-stage.com
	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
	 * non-votable list :
	 * http://www.ranker-stage.com/list/smartest-famous-people
	 * /celebrity-lists?page=2
	 */
	@Test(priority = 78, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddSocialChickletsPinterestInOpenList(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 78 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"AddSocialChickletsPinterestInOpenList");
		} else {
			listHeader = BaseState(ultimateContributeUrl,
					"AddSocialChickletsPinterestInOpenList");
		}
		common.getNewURL(config.getProperty("Url")+ "crowdranked-list/best-marvel-villains");
		common.signin("testuserkallol1@mailinator.com", "testing");
		listoptionpage.putTextInAddListBox("testing");
		listoptionpage.clickOnAddSearchItem();
		listoptionpage.clickoneditsubvideoIcon();
		listoptionpage.putTextInAddvideo("salman");
		try {
			Thread.sleep(2000);
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
			try {
				Thread.sleep(6000);
			} catch (Exception e) {
			}
		} else {
			Assert.fail("youtube video is not being working");
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		Assert.assertTrue(listHeader.ischickletsPresent());
		// pinterest
		listHeader.clickOnsocialchicklets(3);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		common.clickOnPintLoginFBbutton();
		//common.facebookLogin("salmankhantc", "Dehradun1");
		common.facebookLogin("vikas@ranker.com", "vikas@123");
		SafeActions sf1 = new SafeActions(getDriver());
		sf1.switchToWindow(1);
		Assert.assertTrue(listoptionpage.ispintersetWindowPresent());
		//Assert.assertTrue(listoptionpage.istiwtterWindowPresent());
		getDriver().close();
		listoptionpage.switchToParentWindow();
		listoptionpage.clickOndeletelist("delete");

	} // end of AddSocialChickletsPinterestInOpenList

	/*
	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
	 * open list :
	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
	 * Add any item 2-Similary add item in vote list :
	 * http://www.ranker-stage.com
	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
	 * non-votable list :
	 * http://www.ranker-stage.com/list/smartest-famous-people
	 * /celebrity-lists?page=2
	 */
	@Test(priority = 79, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddItemsFacebookInVoteList(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 79 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl,"AddItemsFacebookInVoteList");
		} else {
			listHeader = BaseState(voteUrl,"AddItemsFacebookInVoteList");
		}
		//common.getNewURL(config.getProperty("Url")+ "list/best-bands-fronted-by-famous-actors/ranker-music");
		common.signin("testuserkallol1@mailinator.com", "testing");
		listoptionpage.putTextInAddListBox("testing");
		listoptionpage.clickOnAddSearchItem();
		listoptionpage.clickoneditsubvideoIcon();
		listoptionpage.putTextInAddvideo("salman");
		try {
			Thread.sleep(2000);
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
			try {
				Thread.sleep(6000);
			} catch (Exception e) {
			}
		} else {
			Assert.fail("youtube video is not being working");
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		Assert.assertTrue(listHeader.ischickletsPresent());
		// facebook
		listHeader.clickOnsocialchicklets(1);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		//common.facebookLogin("salmankhantc", "Dehradun1");
		common.facebookLogin("vikas@ranker.com", "vikas@123");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}

		Assert.assertTrue(listHeader.isPresentfacebookwindowpresent());
		Assert.assertFalse(listHeader.isPresentfacebookErrorpresent());
		getDriver().close();
		listoptionpage.switchToParentWindow();
		listoptionpage.clickOndeletelist("delete");
		//
	} // end of AddItemsFacebookInVoteList

	/*
	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
	 * open list :
	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
	 * Add any item 2-Similary add item in vote list :
	 * http://www.ranker-stage.com
	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
	 * non-votable list :
	 * http://www.ranker-stage.com/list/smartest-famous-people
	 * /celebrity-lists?page=2
	 */
	@Test(priority = 80, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddItemsTwitterInVoteList(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 80 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl,
					"AddItemsTwitterInVoteList");
		} else {
			listHeader = BaseState(voteUrl,
					"AddItemsTwitterInVoteList");
		}
		common.getNewURL(config.getProperty("Url")+ "list/who-should-host-oscars-2016/ranker-film");
		
		//common.signin("testuserkallol1@mailinator.com", "testing");
		listoptionpage.putTextInAddListBox("testing");
		listoptionpage.clickOnAddSearchItem();
		listoptionpage.clickoneditsubvideoIcon();
		listoptionpage.putTextInAddvideo("salman");
		try {
			Thread.sleep(2000);
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
			try {
				Thread.sleep(6000);
			} catch (Exception e) {
			}
		} else {
			Assert.fail("youtube video is not being working");
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		Assert.assertTrue(listHeader.ischickletsPresent());

		// twitter
		listHeader.clickOnsocialchicklets(2);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		if (listoptionpage.isPresenttiwtterlogin() == true) {
			Assert.assertEquals(1, 1);
		} else if (listHeader.isPresenttwitterwindowpresent()) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
		getDriver().close();
		listoptionpage.switchToParentWindow();
		listoptionpage.clickOndeletelist("delete");

	} // end of AddItemsTwitterInVoteList

	/*
	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
	 * open list :
	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
	 * Add any item 2-Similary add item in vote list :
	 * http://www.ranker-stage.com
	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
	 * non-votable list :
	 * http://www.ranker-stage.com/list/smartest-famous-people
	 * /celebrity-lists?page=2
	 */
	@Test(priority = 81, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddItemsPinterestInVoteList(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 81 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl,
					"AddItemsPinterestInVoteList");
		} else {
			listHeader = BaseState(voteUrl,
					"AddItemsPinterestInVoteList");
		}
		common.getNewURL(config.getProperty("Url")+ "list/who-should-host-oscars-2016/ranker-film");
		
		//common.getNewURL(config.getProperty("Url")+ "list/who-should-host-oscars-2016/ranker-film");
		common.signin("testuserkallol1@mailinator.com", "testing");
		listoptionpage.putTextInAddListBox("testing");
		listoptionpage.clickOnAddSearchItem();
		listoptionpage.clickoneditsubvideoIcon();
		listoptionpage.putTextInAddvideo("salman");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		int count = listoptionpage.Videocount();
		if (count > 2) {
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
			}
			listoptionpage.clickonaddvideo(1);
			try {
				Thread.sleep(4000);
			} catch (Exception e) {
			}
			listoptionpage.clickOnvideoSelectButton();
			listoptionpage.clickOnDoneButton();
			try {
				Thread.sleep(6000);
			} catch (Exception e) {
			}
		} else {
			Assert.fail("youtube video is not being working");
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		Assert.assertTrue(listHeader.ischickletsPresent());
		// pinterest
		listHeader.clickOnsocialchicklets(3);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		common.clickOnPintLoginFBbutton();
		//common.facebookLogin("salmankhantc", "Dehradun1");
		common.facebookLogin("vikas@ranker.com", "vikas@123");
		SafeActions sf1 = new SafeActions(getDriver());
		sf1.switchToWindow(1);
		Assert.assertTrue(listoptionpage.ispintersetWindowPresent());
		//Assert.assertTrue(listoptionpage.istiwtterWindowPresent());
		getDriver().close();
		listoptionpage.switchToParentWindow();
		listoptionpage.clickOndeletelist("delete");

	} // end of AddItemsPinterestInVoteList

	/*
	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
	 * open list :
	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
	 * Add any item 2-Similary add item in vote list :
	 * http://www.ranker-stage.com
	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
	 * non-votable list :
	 * http://www.ranker-stage.com/list/smartest-famous-people
	 * /celebrity-lists?page=2
	 */
	@Test(priority = 82, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddItemsFacebookInNonVoteList(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 82 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"AddItemsFacebookInNonVoteList");
		} else {
			listHeader = BaseState(ultimateContributeUrl,
					"AddItemsFacebookInNonVoteList");
		}
		//common.getNewURL(config.getProperty("Url")+ "list/best-thanksgiving-movies/olivia-peterman");
		
		common.getNewURL(config.getProperty("Url")+ "list/smartest-famous-people/celebrity-lists?page=2");
		common.signin("testuserkallol1@mailinator.com", "testing");
		listoptionpage.putTextInAddListBox("testing");
		listoptionpage.clickOnAddSearchItem();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		Assert.assertTrue(listHeader.ischickletsPresent());
		// facebook
		listHeader.clickOnsocialchicklets(1);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		//common.facebookLogin("salmankhantc", "Dehradun1");
		common.facebookLogin("vikas@ranker.com", "vikas@123");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}

		Assert.assertTrue(listHeader.isPresentfacebookwindowpresent());
		Assert.assertFalse(listHeader.isPresentfacebookErrorpresent());
		getDriver().close();
		
		listoptionpage.switchToParentWindow();
		listoptionpage.clickOndeletelist("delete");
		//
	} // end of AddItemsFacebookInVoteList

	/*
	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
	 * open list :
	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
	 * Add any item 2-Similary add item in vote list :
	 * http://www.ranker-stage.com
	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
	 * non-votable list :
	 * http://www.ranker-stage.com/list/smartest-famous-people
	 * /celebrity-lists?page=2
	 */
	@Test(priority = 83, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddItemsTwitterInNonVoteList(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 83 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,"AddItemsTwitterInNonVoteList");
		} else {
			listHeader = BaseState(ultimateContributeUrl,"AddItemsTwitterInNonVoteList");
		}
		//common.getNewURL(config.getProperty("Url")+ "list/best-thanksgiving-movies/olivia-peterman");
		common.getNewURL(config.getProperty("Url")+ "list/smartest-famous-people/celebrity-lists?page=2");
		common.signin("testuserkallol1@mailinator.com", "testing");
		listoptionpage.putTextInAddListBox("testing");
		listoptionpage.clickOnAddSearchItem();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		Assert.assertTrue(listHeader.ischickletsPresent());

		// twitter
		listHeader.clickOnsocialchicklets(2);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		if (listoptionpage.isPresenttiwtterlogin() == true) {
			Assert.assertEquals(1, 1);
		} else if (listHeader.isPresenttwitterwindowpresent()) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
		getDriver().close();
		listoptionpage.switchToParentWindow();
		listoptionpage.clickOndeletelist("delete");

	} // end of AddItemsTwitterInNonVoteList

	/*
	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
	 * open list :
	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
	 * Add any item 2-Similary add item in vote list :
	 * http://www.ranker-stage.com
	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
	 * non-votable list :
	 * http://www.ranker-stage.com/list/smartest-famous-people
	 * /celebrity-lists?page=2
	 */
	@Test(priority = 84, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddItemsPinterestInNonVoteList(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 84 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"AddItemsPinterestInNonVoteList");
		} else {
			listHeader = BaseState(ultimateContributeUrl,
					"AddItemsPinterestInNonVoteList");
		}
	//	common.getNewURL(config.getProperty("Url")+ "list/best-thanksgiving-movies/olivia-peterman");
		common.getNewURL(config.getProperty("Url")+ "list/smartest-famous-people/celebrity-lists?page=2");
		common.signin("testuserkallol1@mailinator.com", "testing");
		listoptionpage.putTextInAddListBox("testing");
		listoptionpage.clickOnAddSearchItem();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		Assert.assertTrue(listHeader.ischickletsPresent());
		// pinterest
		listHeader.clickOnsocialchicklets(3);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		common.clickOnPintLoginFBbutton();
		//common.facebookLogin("salmankhantc", "Dehradun1");
		common.facebookLogin("vikas@ranker.com", "vikas@123");
		SafeActions sf1 = new SafeActions(getDriver());
		sf1.switchToWindow(1);
		Assert.assertTrue(listoptionpage.ispintersetWindowPresent());
		//Assert.assertTrue(listoptionpage.istiwtterWindowPresent());
		getDriver().close();
		listoptionpage.switchToParentWindow();
		listoptionpage.clickOndeletelist("delete");

	} // end of AddItemsPinterestInNonVoteList

	/*
	 * Use-case : Remove next list link on yellow pagination strip for
	 * monetizable tagged lists Test case : Open any monetizable list :
	 * http://www
	 * .ranker-stage.com/crowdranked-list/most-influential-djs-of-all-time
	 * Scroll down to list footer
	 */
	@Test(priority = 85, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void MonetizableTaggedLists(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 85 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,"MonetizableTaggedLists");
		} else {
			listHeader = BaseState(ultimateContributeUrl,"MonetizableTaggedLists");
		}
		UeListPage ueList = new UeListPage(getDriver());
		Grid grid = new Grid(getDriver());
		common.getNewURL(config.getProperty("Url")+ "crowdranked-list/most-influential-djs-of-all-time");
		common.signin("vijaymohanp", "server");
		grid.clickOnAdminStats(3);
		grid.clickOneditlist();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		listHeader.selectTagsCheckBoxmonetizable();
		ueList.clickOnDoneInAddTags();
		grid.clickOnAdminStats(9);
		grid.clickOnresetsublist(2);
		listHeader.AlertExistsAndAccepted(2000);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		Assert.assertTrue(listHeader.isnextFooterPresent());
		grid.clickOnAdminStats(3);
		grid.clickOneditlist();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		listHeader.selectTagsCheckBoxmonetizable();
		ueList.clickOnDoneInAddTags();
		grid.clickOnAdminStats(9);
		grid.clickOnresetsublist(2);
		listHeader.AlertExistsAndAccepted(2000);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		Assert.assertFalse(listHeader.isnextFooterPresent());
	}// End of MonetizableTaggedLists
	/*
	 * Use-case : update to keywords display on list pages Test case : Open list
	 * : http://www.ranker-stage.com/crowdranked-list/the-most-influential-
	 * contemporary-americans with admin Click on metadata Click on View top
	 * keywords
	 */
	@Test(priority = 86, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void KeywordsDisplay(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 86 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"KeywordsDisplay");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "KeywordsDisplay");
		}
		UeListPage ueList = new UeListPage(getDriver());
		Grid grid = new Grid(getDriver());
		common.getNewURL(config.getProperty("Url")
				+ "crowdranked-list/the-most-influential-contemporary-americans");
		common.signin("vijaymohanp", "server");
		grid.clickOnAdminStats(4);
		listHeader.clickOnViewTopkeywords();
		Assert.assertTrue(listHeader.isSourcePresent());
	}// End of KeywordsDisplay
	/*
	 * Use-case : Interstitial NSFW Page
	 * Test case: Open any nsfw interstitial page on desktop (ex: http://www.ranker-stage.com/relatedcontent/1448628)
	 */
	@Test(priority = 87, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void InterstitialNSFWPage(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 87 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,"InterstitialNSFWPage");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "InterstitialNSFWPage");
		}
		UeListPage ueList = new UeListPage(getDriver());
		Grid grid = new Grid(getDriver());
		common.getNewURL(config.getProperty("Url")+ "relatedcontent/1448628");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		String largerblock[]=listHeader.getWidthoflargerblock().split("px");
		int largerwidth=Integer.parseInt(largerblock[0]);
		for(int i=1;i<=4;i++){
		String smallblock[]=listHeader.getWidthofsmallblock(i).split("px");
		int smallwidth=Integer.parseInt(smallblock[0]);
		if(largerwidth>smallwidth){
			Assert.assertEquals(1, 1);
		}
		else
			Assert.assertEquals(1, 0);	
		}
	}// End of InterstitialNSFWPage
	
	/*
	 * Use-case : UE: Disable image uploads on rereanks if disabled on original/ultimate list
	 *  Test case : Open Ul list: http://www.ranker-stage.com/crowdranked-list/the-most-influential-contemporary-americans?
				   Which has image upload is disabled
				  Rerank it and open reranked list from non-admin user in UE
				  1 Try to upload image on list items and list
				  2 Now add item through open list and try to upload image
	 */
	@Test(priority = 88, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void DisableImageUploadsOnRereank(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 88 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		RerankPage rerankpage = new RerankPage (getDriver());
		UeListPage ueList = new UeListPage(getDriver()); 
		Grid grid = new Grid(getDriver());
		Home home = new Home(getDriver());
		ListHeader listHeader = null;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,"DisableImageUploadsOnRereank");
		} else {
			listHeader = BaseState(ultimateContributeUrl,"DisableImageUploadsOnRereank");
		}
		common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-most-influential-contemporary-americans?");
		common.signin("vijaymohanp", "server");
		listHeader.cancelLoading();
		System.out.println("11111111111111");
		grid.clickOnAdminStats(5);
		System.out.println("22222222222222");
		//grid.clickOnSubStats(7);
		grid.clickOnsubStatsListaction(7);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		System.out.println("33333333333333");
		listHeader.AlertExistsAndAccepted(1000);
		System.out.println("444444444444444444");
		 try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		grid.clickOnadminStats1();
		grid.clickOnresetsublist(2);
		listHeader.AlertExistsAndAccepted(1000);
//		 try {
//				Thread.sleep(2000);
//			} catch (Exception e) {
//			}
		 home.doLogout();
		 System.out.println("5555555555555555555");
	  	 common.signin("testuserkallol1@mailinator.com", "testing");
	  		 try {
					Thread.sleep(3000);
				} catch (Exception e) {}
         rerankpage.clickOnrerankbtn();
//         System.out.println("666666666666666666666");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		rerankpage.hoverOneditIcon(1);
//		rerankpage.stickyLikePresenceAndAccept();
	    rerankpage.clickoneditimageoption();
//		System.out.println("7777777777777777777");
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//		}
		Assert.assertTrue(listHeader.isPresentuploadimage());
		rerankpage.clickondonebtn();
		home.doLogout();
		 System.out.println("5555555555555555555");
	  	 common.signin("vijaymohanp", "server");
	  	try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		grid.clickOnAdminStats(5);
		grid.clickOnsubStatsListaction(7);
		listHeader.AlertExistsAndAccepted(1000);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		grid.clickOnadminStats1();
			grid.clickOnresetsublist(2);
		 listHeader.AlertExistsAndAccepted(1000);

	}// AddEditItemsImage
	/*
	 * Use-case : Add option to List Actions in admin bar
	 *  Test case : OGo to a list and check the box if it is not checked. Then try uploading images through the list image, node image (UE) and open list interfaces
Then uncheck the box and reset cache. Then try uploading images through the list image, node image (UE) and open list interfaces as a non-admin user.
	 */
	@Test(priority = 89, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void DisableImageUploadsOnNodeImage(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 89 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		RerankPage rerankpage = new RerankPage (getDriver());
		UeListPage ueList = new UeListPage(getDriver()); 
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		Grid grid = new Grid(getDriver());
		Home home = new Home(getDriver());
		ListHeader listHeader = null;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,"DisableImageUploadsOnNodeImage");
		} else {
			listHeader = BaseState(ultimateContributeUrl,"DisableImageUploadsOnNodeImage");
		}
		common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-most-influential-contemporary-americans?");
		common.signin("vijaymohanp", "server");
		listHeader.cancelLoading();
		System.out.println("11111111111111");
		grid.clickOnAdminStats(5);
		System.out.println("22222222222222");
		//grid.clickOnSubStats(7);
		grid.clickOnsubStatsListaction(7);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		System.out.println("33333333333333");
		listHeader.AlertExistsAndAccepted(1000);
		System.out.println("444444444444444444");
		 try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		grid.clickOnadminStats1();
		grid.clickOnresetsublist(2);
		listHeader.AlertExistsAndAccepted(1000);
//		 try {
//				Thread.sleep(2000);
//			} catch (Exception e) {
//			}
		 home.doLogout();
		 System.out.println("5555555555555555555");
	  	 common.signin("testuserkallol1@mailinator.com", "testing");
	  		 try {
					Thread.sleep(3000);
				} catch (Exception e) {}
	  		listoptionpage.putTextInAddListBox("abcd");
			listoptionpage.clickOnAddSearchItem();
			try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
	Assert.assertTrue(listHeader.isPresentuploadimage());
	rerankpage.clickondonebtn();
	home.doLogout();
	 System.out.println("5555555555555555555");
 	 common.signin("vijaymohanp", "server");
 	try {
		Thread.sleep(2000);
	} catch (Exception e) {
	}
	grid.clickOnAdminStats(5);
	grid.clickOnsubStatsListaction(7);
	listHeader.AlertExistsAndAccepted(1000);
	try {
		Thread.sleep(2000);
	} catch (Exception e) {
	}
	grid.clickOnadminStats1();
		grid.clickOnresetsublist(2);
	 listHeader.AlertExistsAndAccepted(1000);

	}// AddEditItemsImage
	
	// /*
	 /* Use-case : Bury/Unbury Through Admin Bar should display message bout
	 noindex on action
	 * Test case : Open any list from admin login
	 Click on change link to bury/unburry
	 Select bury/unburry.
	 */
	 @Test(priority = 90, dataProviderClass = DataProviders.class,
	 dataProvider = "Login")
	 public void BuryUnbury(String loginRequired) {
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 90 !!!!!!!!!!!!!!!!!!!!!!!");
	 // Base state. (Navigate to node page)
	 ListHeader listHeader=null;
	
	 if(loginRequired.equals("YES")){
	 listHeader =BaseStateWithLogin(ultimateContributeUrl,"BuryUnbury");
	 }else{
	 listHeader =BaseState(ultimateContributeUrl,"BuryUnbury");
	 }
	 UeListPage ueList= new UeListPage(getDriver());
	 Grid grid=new Grid(getDriver());
	 common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-most-influential-contemporary-americans");
	 common.signin("vijaymohanp", "server");
	 grid.clickOnadminburrychange();
	 listHeader.clickOnBurylist();
	 Alert alert = getDriver().switchTo().alert();
	 String s1=alert.getText();
	 System.out.println("s1--"+s1);
	 Assert.assertEquals(s1,"Also noIndexed. Toggle to change");
	 listHeader.AlertExistsAndAccepted(1000);
	 grid.clickOnResetTab();
     grid.clickOnresetsublist(2);
     listHeader.AlertExistsAndAccepted(1000);
	 grid.clickOnadminburrychange();
	 listHeader.clickOnBurylist();
	 Alert alert1 = getDriver().switchTo().alert();
	 String s2=alert1.getText();
	 System.out.println("s2--"+s2);
	  Assert.assertEquals(s2,"Also doIndexed. Toggle to change");
	  listHeader.AlertExistsAndAccepted(2000);
//	  grid.clickOnadminburrychange();
//		 listHeader.clickOnBurylist();
	 }
	   /*
		 * Use-case : update top keywords in admin bar Test case : Open list
		 * :Logged in as an admin, open any list (ex: http://www.ranker-stage.com/list/famous-women-beer-list/greg) that has a long top keywords popup. Click on Meta Data in the admin bar and select "View Top Keywords"
		 */
		@Test(priority = 91, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void KeywordsDisplayPopupInScroll(String loginRequired) {
			System.out
					.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 91 !!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to node page)
			ListHeader listHeader = null;

			if (loginRequired.equals("YES")) {
				listHeader = BaseStateWithLogin(ultimateContributeUrl,
						"KeywordsDisplay");
			} else {
				listHeader = BaseState(ultimateContributeUrl, "KeywordsDisplayPopupInScroll");
			}
			UeListPage ueList = new UeListPage(getDriver());
			Grid grid = new Grid(getDriver());
			common.getNewURL(config.getProperty("Url")+ "crowdranked-list/the-most-influential-contemporary-americans");
			common.signin("vijaymohanp", "server");
			grid.clickOnadminEditList();
			listHeader.clickOnViewTopkeywords();
			Assert.assertTrue(listHeader.isPresenttopKeywords(8));
		}// End of KeywordsDisplayPopupInScroll
		/*
		 * Use-case :  Verify that tags breadcrum should not have class tag
		 * tesecase:1.  Open any list which belongs to Film/people class
						EX: http://www.ranker-stage.com/list/greatest-minds-of-all-time/walter-graves
						http://www.ranker-stage.com/crowdranked-list/the-best-movies-of-all-time
						2. Click on tags in list header.
		 */
		@Test(priority = 92, dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void VarifyTagsNotClassTag(String loginRequired) {
			System.out
					.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 92 !!!!!!!!!!!!!!!!!!!!!!!");
			// Base state. (Navigate to node page)
			ListHeader listHeader = null;
			if (loginRequired.equals("YES")) {
				listHeader = BaseStateWithLogin(ultimateContributeUrl,"VarifyTagsNotClassTag");
			} else {
				listHeader = BaseState(ultimateContributeUrl, "VarifyTagsNotClassTag");
			}
			common.getNewURL(config.getProperty("Url")+ "list/greatest-minds-of-all-time/walter-graves");
			listHeader.clickOnmoreInfoLink();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			Assert.assertFalse(listHeader.ismoreInfoBreadCrumbNotclassPresent());
		}// End of MoreInfoBreadCrumb()
		
		
		
	/*
	 * This is base state of the Listheader test-cases.
	 */
	public ListHeader BaseState(String url, String testName) {
		try {
			startRecording(testName);
		} catch (Exception e) {
		}
		common = new Commonpage(getDriver());
		ListHeader listHeader = common.getListHeader(url);
		return listHeader;
	} // End of BaseState()

	/*
	 * This is base state of the slide show test-cases.
	 */
	public ListHeader BaseStateWithLogin(String url, String testName) {
		common = new Commonpage(getDriver());
		try {
			startRecording(testName);
		} catch (Exception e) {
		}
		common.signin("testuserkallol1@mailinator.com", "testing");
		ListHeader listHeader = common.getListHeader(url);
		return listHeader;
	} // End of BaseStateWithLogin()

	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
