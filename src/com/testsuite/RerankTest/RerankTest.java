package com.testsuite.RerankTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.paeobjects.navbar.NavBar;
import com.pageobjects.listheader.ListHeader;
import com.pageobjects.rerank.RerankPage;
import com.pageobjects.uelist.UeListPage;
import com.pageobjects.userProfilePage.UserProfilePage;

public class RerankTest extends BaseSetup {
	ConfigManager urls = new ConfigManager("PreProduction");
	ConfigManager sysProp = new ConfigManager("Sys");
	Commonpage common;
	String url = config.getProperty("Url") + urls.getProperty("rerank");

	/*
	 * Use-case : Rerank button functionality of Non-Votable list Test case : 1)
	 * Open Rerank enabled non-votable list 2) Click on "Rerank" button
	 */
	@Test(priority = 1, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void HeaderOption(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		RerankPage rerankpage = null;
		if (loginRequired.equals("YES")) {
			rerankpage = BaseStateWithLogin("HeaderOption");
		} else {
			rerankpage = BaseState("HeaderOption");
		}
		common.getNewURL(config.getProperty("Url")+ "list/the-funniest-stand-up-comedians-in-entertainment/clash1977");
		rerankpage.clickOnrerankbtn();
		Assert.assertTrue(rerankpage.isPresentUE());
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
	}

	/*
	 * Use-case : Recomeneded style for rerank Test case : 1) Rerank any info
	 * styled lists 2) In UE, open settings tab
	 */
	@Test(priority = 2, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Recomenededlist(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		RerankPage rerankpage = null;
		if (loginRequired.equals("YES")) {
			rerankpage = BaseStateWithLogin("Recomenededlist");
		} else {
			rerankpage = BaseState("Recomenededlist");
		}
		rerankpage.clickOnrerankbtn();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		rerankpage.clickOnoptionbtn();
		rerankpage.isPresentrecomeneded();
		Assert.assertEquals("rgba(8, 108, 184, 1)",
				rerankpage.getborderColorlist());
	}
	/*
	 * Use-case : UE: List Edit - Delete All/Confirm Delete Test case : 
					  1) Rerank any list 
					  2) In UE, come to 'My Version' tab and click on 'trash icon' appear on top right 
					  3) This triggers a confirmation popup, here click on 'Delete all items'
	 */
	@Test(priority = 3, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Deleteallitems(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		RerankPage rerankpage = null;
		if (loginRequired.equals("YES")) {
			rerankpage = BaseStateWithLogin("Deleteitems");
		} else {
			rerankpage = BaseState("Deleteitems");
		}
		rerankpage.clickOnrerankbtn();
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
		}
		rerankpage.clickOndeletebtn();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		rerankpage.stickyLikePresenceAndAccept();
		rerankpage.clickOnalertoppsbtn();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		// list is present check
		for (int i = 1; i < 3; i++) {
			Assert.assertTrue(rerankpage.isPresentlistitems(i));
		}
		rerankpage.clickOndeletebtn();
		rerankpage.stickyLikePresenceAndAccept();
		try {
			Thread.sleep(9000);
		} catch (Exception e) {
		}
		rerankpage.clickOnalertdeleteallbtn();
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
		}
		// list is not present after delete all items
		for (int i = 1; i < 3; i++) {
			Assert.assertFalse(rerankpage.isPresentlistitems(i));
		}
	}
	/*
	 * Functionality Changed, so is commented.
	 */
////	/*
////	 * Use-case : UE: Rerank Share Copy Change Test case : Rerank any list and click on fshare from list pay-off.
////	 				  The fShare copy should read as: "I Reranked: [list name] Check out my version of this list and see if you agree with my top picks, including [node 1], [node 2], and [node 3]." 
////				      2.Share this in FB. In the shared copy, "ranker.com" should display at the bottom.
////	 */
////	@Test(priority = 4, dataProviderClass = DataProviders.class, dataProvider = "Login")
////	public void Fshare(String loginRequired) {
////		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
////		// Base state. (Navigate to node page)
////		RerankPage rerankpage = null;
////		if (loginRequired.equals("YES")) {
////			rerankpage = BaseStateWithLogin("Deleteitems");
////		} else {
////			rerankpage = BaseState("Deleteitems");
////		}
////		common.signin("testuserkallol1@mailinator.com", "testing");
////		rerankpage.clickOnrerankbtn();
////		try {
////			Thread.sleep(4000);
////		} catch (Exception e) {
////		}
////		String txt1 = rerankpage.getTextOflistitemsnode1();
////		String txt2 = rerankpage.getTextOflistitemsnode2();
////		String txt3 = rerankpage.getTextOflistitemsnode3();
////		System.out.println("11111111111 ");
////		
////		rerankpage.clickOnpublishbtn();
////		try {
////			Thread.sleep(5000);
////		} catch (Exception e) {
////		}
////		System.out.println("2222222222 ");
////		rerankpage.clickOnfsharebtn();
////		try {
////			Thread.sleep(8000);
////		} catch (Exception e) {
////		}
////		rerankpage.facebooklogin("salmankhantc", "Dehradun1");
////		try {
////			Thread.sleep(5000);
////		} catch (Exception e) {
////		}
////		System.out.println("3333333333 ");
////		rerankpage.clickonloginbtn();
////		Assert.assertEquals("Check out my version of this list and see if you agree with my top picks, including "+ txt1 + ", " + txt2 + "," + txt3 + ".","Check out my version of this list and see if you agree with my top picks, including "+ txt1 + ", " + txt2 + "," + txt3 + ".");
////		rerankpage.clickonsharebtn();
////	}
	/*
	 * Use-case : UE: Check side bar nubbin Test case : 1) Open any
	 * Ultimate/Rerankable List 2) Vote on 3 items 3) Click on rerank button in
	 * nubbin killer sliding out from the right side
	 */
	@Test(priority = 5, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void SidebarNubbin(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		RerankPage rerankpage = null;
		if (loginRequired.equals("YES")) {
			rerankpage = BaseStateWithLogin("SidebarNubbin");
		} else {
			rerankpage = BaseState("SidebarNubbin");
		}
		// common.getNewURL(config.getProperty("Url")+"list/actors-nobody-cares-about-anymore/ranker-celebrities");
		for (int i = 1; i <= 3; i++) {
			rerankpage.clickonvotebtn(i);
		}
		try {
			Thread.sleep(9000);
		} catch (Exception e) {
		}
		rerankpage.clickonrerankaftervote();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}
		Assert.assertTrue(rerankpage.isPresentUE());
	}

	/*
	 * Use-case : UE: Add Items Test case : 1) Open any Ultimate list 2) Click
	 * on "rerank" button 3) It opens UE, search tab,Search for a node 4) Select
	 * any from the available results/add a authored node
	 */
	@Test(priority = 6, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void SearchAddButton(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		RerankPage rerankpage = null;
		if (loginRequired.equals("YES")) {
			rerankpage = BaseStateWithLogin("SearchAddButton");
		} else {
			rerankpage = BaseState("SearchAddButton");
		}
		// common.getNewURL(config.getProperty("Url")+"list/actors-nobody-cares-about-anymore/ranker-celebrities");
		for (int i = 1; i <= 3; i++) {
			rerankpage.clickonvotebtn(i);
		}
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		rerankpage.clickonrerankaftervote();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}
		rerankpage.clickOnSearch();
		rerankpage.typesearchbtn("testing123");
		try {
			Thread.sleep(9000);
		} catch (Exception e) {
		}
		rerankpage.clickonsearchaddbtn();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		String txt = rerankpage.getTextOfAddedNode();
		Assert.assertEquals(txt, "Testing123");
		// ueList.clickOnpublishbtn();

	}// SearchAddButton

	/*
	 * Use-case : UE: change label copy Test case : Vote on some items and Click
	 * on rerank,On UE select Search tab and enter list related item
	 * like"Beethoven" or" Dutch"
	 */
	@Test(priority = 7, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ChangeLabel(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		RerankPage rerankpage = null;
		if (loginRequired.equals("YES")) {
			rerankpage = BaseStateWithLogin("SearchAddButton");
		} else {
			rerankpage = BaseState("SearchAddButton");
		}
		// common.getNewURL(config.getProperty("Url")+"list/actors-nobody-cares-about-anymore/ranker-celebrities");
		for (int i = 1; i <= 3; i++) {
			rerankpage.clickonvotebtn(i);
		}
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		rerankpage.clickonrerankaftervote();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}
		rerankpage.clickOnSearch();
		rerankpage.typesearchbtn("Beethoven");
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
		}
		int status = 0;
		int num = 0;
		for (int i = 1; i <= 5; i++) {
			if(rerankpage.isPresentsearchlist(i) == true) {
				num = i;
				status = 1;
				break;
			}
		}
		if (status == 1) {
			Assert.assertEquals("best result",
					rerankpage.getTextOfsearchlist(num));
		} else {
			Assert.assertEquals(1, 0);
		}

		// rerankpage.clickonsearchaddbtn();
	}// Changelabel

	/*
	 * Use-case : UE: Delete items Test case : 1) Open any Ultimate list 2)
	 * Click on "rerank" button 3) Add few items to the list in UE 4) Click on
	 * "x" appear beside list items in your version tab
	 */
	@Test(priority = 8, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Deletelistitems(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		RerankPage rerankpage = null;
		if (loginRequired.equals("YES")) {
			rerankpage = BaseStateWithLogin("Deleteitems");
		} else {
			rerankpage = BaseState("Deleteitems");
		}
		// common.getNewURL(config.getProperty("Url")+"list/actors-nobody-cares-about-anymore/ranker-celebrities");
		for (int i = 1; i <= 3; i++) {
			rerankpage.clickonvotebtn(i);
		}
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		rerankpage.clickonrerankaftervote();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		rerankpage.clickOndeletebtn();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		rerankpage.clickOnalertdeleteallbtn();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {}
		for (int i = 1; i <= 3; i++) {
			rerankpage.clickOnPlusIcon(i);
		}
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		String before = rerankpage.getTextOfFirstNode();
		rerankpage.clickOndeleteIcon(1);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		String after = 	rerankpage.getTextOfFirstNode();
		Assert.assertNotEquals(before, after);
	
		
	}// Deletelistitems

	/*
	 * Use-case : UE: Add image/blather/video/properties Test case : 1) Open any
	 * Ultimate list 2) Click on "rerank Button" 3) Add few items to the list in
	 * UE 4) Click on "Edit" icons appear beside the lsit items
	 */
	@Test(priority = 9, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddEditItemsImage(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 9 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		RerankPage rerankpage = null;
		if (loginRequired.equals("YES")) {
			rerankpage = BaseStateWithLogin("AddEditItemsImage");
		} else {
			rerankpage = BaseState("AddEditItemsImage");
		}
		for (int i = 1; i <= 3; i++) {
			rerankpage.clickonvotebtn(i);
		}
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		rerankpage.clickonrerankaftervote();
		rerankpage.stickyLikePresenceAndAccept();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		rerankpage.hoverOneditIcon(1);
		rerankpage.stickyLikePresenceAndAccept();
		rerankpage.clickoneditimageoption();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		String beforesrc = rerankpage.getsrcedititemsadd(1);
		String[] substring = beforesrc.split("/");
		rerankpage.clickonedititemsaddoption(1);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}

		// substring[substring.length-1]
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		rerankpage.clickonselectbtn();
		rerankpage.clickondonebtn();
		String after = rerankpage.getsrcafteraddedititems(1);
		String[] substring1 = after.split("/");
		Assert.assertEquals(substring[substring.length - 1],substring[substring1.length - 1]);

	}// AddEditItemsImage
	/*
	 * Use-case : UE: Add image/blather/video/properties Test case : 1) Open any
	 * Ultimate list 2) Click on "rerank Button" 3) Add few items to the list in
	 * UE 4) Click on "Edit" icons appear beside the lsit items
	 */
	@Test(priority = 10, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddEditItemsVideo(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 10 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		RerankPage rerankpage = null;
		if (loginRequired.equals("YES")) {
			rerankpage = BaseStateWithLogin("AddEditItemsViedo");
		} else {
			rerankpage = BaseState("AddEditItemsViedo");
		}
		for (int i = 1; i <= 3; i++) {
			rerankpage.clickonvotebtn(i);
		}
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		rerankpage.clickonrerankaftervote();
		rerankpage.stickyLikePresenceAndAccept();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		rerankpage.hoverOneditIcon(1);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		//rerankpage.stickyLikePresenceAndAccept();
		rerankpage.clickoneditsubviedoIcon();
		try {
			Thread.sleep(12000);
		} catch (Exception e) {
		}
		String beforesrc = rerankpage.getsrcedititemsaddvedio(1);
		//String[] substring = beforesrc.split("/");
		rerankpage.clickonedititemsaddvedio(1);
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
		}
		rerankpage.clickonselectbtn();
		rerankpage.clickondonebtn();
		String after = rerankpage.getsrcafteraddedititems(1);
		Assert.assertEquals(beforesrc, after);
		//String[] substring1 = after.split("/");
		//Assert.assertEquals(substring[substring.length - 1],substring[substring1.length - 1]);
	}// AddEditItemsViedo
	/*
	 * Use-case : UE: Add image/blather/video/properties Test case : 1) Open any
	 * Ultimate list 2) Click on "rerank Button" 3) Add few items to the list in
	 * UE 4) Click on "Edit" icons appear beside the lsit items
	 */
	@Test(priority = 11, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddEditItemsBlather(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 11 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		RerankPage rerankpage = null;
		if (loginRequired.equals("YES")) {
			rerankpage = BaseStateWithLogin("AddEditItemsBlather");
		} else {
			rerankpage = BaseState("AddEditItemsBlather");
		}
		for (int i = 1; i <= 3; i++) {
			rerankpage.clickonvotebtn(i);
		}
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		rerankpage.clickonrerankaftervote();
		rerankpage.stickyLikePresenceAndAccept();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		rerankpage.hoverOneditIcon(1);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		rerankpage.clickoneditsubblatherIcon();
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
		}
		rerankpage.typeblather("This is blather");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		rerankpage.clickondonebtn();
		String after = rerankpage.getTextOfblather(1);
		Assert.assertEquals("This is blather", after);
	}// AddEditItemsBlather
	/*
	 * Use-case : UE: Add image/blather/video/properties Test case : 1) Open any
	 * Ultimate list 2) Click on "rerank Button" 3) Add few items to the list in
	 * UE 4) Click on "Edit" icons appear beside the lsit items
	 */
	@Test(priority = 12, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AddEditItemsProperty(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		RerankPage rerankpage = null;
		if (loginRequired.equals("YES")) {
			rerankpage = BaseStateWithLogin("AddEditItemsProperty");
		} else {
			rerankpage = BaseState("AddEditItemsProperty");
		}
		for (int i = 1; i <= 3; i++) {
			rerankpage.clickonvotebtn(i);
		}
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		rerankpage.clickonrerankaftervote();
		rerankpage.stickyLikePresenceAndAccept();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		rerankpage.hoverOneditIcon(1);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {}
		rerankpage.clickoneditsubPropertyIcon();
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		rerankpage.putTextInFirstPropInfo("Testing 1");
		rerankpage.putTextInSecondPropInfo("Testing 2");
		rerankpage.putTextInThirdPropInfo("Testing 3");
		rerankpage.putTextInFourPropInfo("Testing 4");
		rerankpage.putTextInFivePropInfo("Testing 5");
		rerankpage.putTextInSixPropInfo("Testing 6");
		rerankpage.putTextInSevenPropInfo("Testing 7");
		rerankpage.putTextInEightPropInfo("Testing 8");
		rerankpage.putTextInNinePropInfo("Testing 9");
		rerankpage.putTextInTenPropInfo("Testing 10");
		try{
			Thread.sleep(4000);
		}catch(Exception e){}
		rerankpage.clickondonebtn();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		rerankpage.hoverOneditIcon(1);
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
		}
		rerankpage.clickoneditsubPropertyIcon();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		Assert.assertEquals(rerankpage.getTextOfFirstPropInfo(), "Testing 1");
		Assert.assertEquals(rerankpage.getTextOfSecondPropInfo(), "Testing 2");
		Assert.assertEquals(rerankpage.getTextOfThirdPropInfo(), "Testing 3");
		Assert.assertEquals(rerankpage.getTextOfFourPropInfo(), "Testing 4");
		Assert.assertEquals(rerankpage.getTextOfFivePropInfo(), "Testing 5");
		Assert.assertEquals(rerankpage.getTextOfSixPropInfo(), "Testing 6");
		Assert.assertEquals(rerankpage.getTextOfSevenPropInfo(), "Testing 7");
		Assert.assertEquals(rerankpage.getTextOfEightPropInfo(), "Testing 8");
		Assert.assertEquals(rerankpage.getTextOfNinePropInfo(), "Testing 9");
		Assert.assertEquals(rerankpage.getTextOfTenPropInfo(), "Testing 10");
	}// AddEditItemsProperty
	/*
	 * Use-case : UE: Check Publish Test case : 1) Open any Ultimate list 
	 				  2)Click on "rerank Button" 
					  3) Add few items to the list in UE 
					  4) Click on "Publish" link appear on bottom of the page
	 */
	@Test(priority = 13, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void PublishList(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 13 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		RerankPage rerankpage = null;
		if (loginRequired.equals("YES")) {
			rerankpage = BaseStateWithLogin("PublishList");
		} else {
			rerankpage = BaseState("PublishList");
		}
		common.signin("testuserkallol1@mailinator.com", "testing");
		rerankpage.clickOnrerankbtn();
		try {
			Thread.sleep(7000);
		} catch (Exception e) {
		}
		rerankpage.clickOndeletebtn();
		// rerankpage.stickyLikePresenceAndAccept();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		rerankpage.clickOnalertdeleteallbtn();
		rerankpage.clickOnIdeaTab();
		for (int i = 1; i <= 3; i++) {
			rerankpage.clickOnPlusIcon(i);
		}
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		rerankpage.clickOnpublishbtn();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		Assert.assertTrue(rerankpage.isPresentpublishlist());
		// rerankpage.clickOndeleteIcon(1);
	}// PublishList
	/*
	 * Use-case : Verify reranks go to the main list with the person's rerank on top
	 * Test case: 1) Go to a rerank-able info style list and rerank the list
	 */
	@Test(priority = 14, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void VerifyPersonRerankOnTop(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		RerankPage rerankpage = null;
		 UeListPage ueList= new UeListPage(getDriver());
		 UserProfilePage profile= new UserProfilePage(getDriver());
		 ListHeader listheader=new ListHeader(getDriver());
		 if (loginRequired.equals("YES")) {
			rerankpage = BaseStateWithLogin("VerifyPersonRerankOnTop");
		} else {
			rerankpage = BaseState("VerifyPersonRerankOnTop");
		}
		 
		  common.getNewURL(config.getProperty("Url")+"list/best-spectator-sports/sports-lists?");
		//common.getNewURL(config.getProperty("Url")+"list/best-guilty-pleasure-tv-shows/ranker-tv?format=GRID&action=tab");
		  common.signin("testvikas1", "123456");
		try{
			Thread.sleep(3000);
		}catch(Exception e){}
		rerankpage.stickyLikePresenceAndAccept();
		rerankpage.clickOnrerankbtn();
		System.out.println("111111111111");
		try{
			Thread.sleep(3000);
		}catch(Exception e){}
//		 ueList.clickOnSearch();
//		 ueList.typesearchbtn("Batman");
//		 for(int i=1;i<=3;i++){
//		 ueList.clickOnPlusIcon(i);
//		 }
		 ueList.clickOnpublishbtn();
		 try{
				Thread.sleep(9000);
			}catch(Exception e){}
		 listheader.clickonrerankstab();
		 try{
				Thread.sleep(3000);
			}catch(Exception e){}
		 listheader.clickOndropDownrerank();
		 Assert.assertTrue(listheader.isPresentuserrerankovery());
		 String value=listheader.getTextOfdropDownrerankoverlay();
		 System.out.println("value==="+value);
		 Assert.assertEquals("testvikas1", value);
		 profile.clickOnProfile();
		 profile.clickOnviewProfile();
		 profile.deleteItemFromList(1);
//		 int search =0;
//	 		int num=0;
//		 for(int i=1;i<=30;i++){
//		      if(profile.isPresent_rank_list_search(i,"The Best Spectator Sports")==true)
//		       {
//			     search=1;
//			     num=i;
//			     break;
//		       }
//		}
//		if(search==1){
//		 profile.deleteItemFromList(1);
//		 }
	}  
	
	/*
	 * Use-case : Singular label for rerank
	 * Test case: 1) when there is only 1 rerank change it to say rerank instead of reranks in the rerank/demo tabs above the list
	 */
	@Test(priority = 15, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void SingularLabelForRerank(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		RerankPage rerankpage = null;
		 UeListPage ueList= new UeListPage(getDriver());
		 UserProfilePage profile= new UserProfilePage(getDriver());
		 ListHeader listheader=new ListHeader(getDriver());
		 if (loginRequired.equals("YES")) {
			rerankpage = BaseStateWithLogin("VerifyPersonRerankOnTop");
		} else {
			rerankpage = BaseState("VerifyPersonRerankOnTop");
		}
	
		 common.getNewURL(config.getProperty("Url")+"list/best-tony-award-winning-musicals/bustermcdermott");
		//common.getNewURL(config.getProperty("Url")+"list/best-guilty-pleasure-tv-shows/ranker-tv?format=GRID&action=tab");
		common.signin("testvikas1", "123456");
		try{
			Thread.sleep(3000);
		}catch(Exception e){}
		 rerankpage.stickyLikePresenceAndAccept();
		 String value=listheader.getTextOfreranktab();
		 Assert.assertEquals("1ReRank", value+"ReRank");
	}  
	/*
	 * This is base state of the slide show test-cases.
	 */
	public RerankPage BaseState(String testName) {
		try {
			startRecording(testName);
		} catch (Exception e) {
		}
		common = new Commonpage(getDriver());
		RerankPage rerankpage = common.getRerankPage(url);
		return rerankpage;
	} // End of BaseState()

	/*
	 * This is base state of the slide show test-cases.
	 */
	public RerankPage BaseStateWithLogin(String testName) {
		try {
			startRecording(testName);
		} catch (Exception e) {
		}
		common = new Commonpage(getDriver());
		common.signin("testuserkallol1@mailinator.com", "testing");
		RerankPage rerankpage = common.getRerankPage(url);
		return rerankpage;
	} // End of BaseStateWithLogin()
}
