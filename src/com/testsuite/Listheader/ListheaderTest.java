package com.testsuite.Listheader;

import java.awt.color.ProfileDataException;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

public class ListheaderTest extends BaseSetup {
	ConfigManager urls = new ConfigManager("PreProduction");
	ConfigManager sysProp = new ConfigManager("Sys");
	Commonpage common;
	String ultimateContributeUrl = config.getProperty("Url")+ urls.getProperty("UltimateContributeList");
	String voteUrl = config.getProperty("Url") + urls.getProperty("VoteList");
	String referenceUrl = config.getProperty("Url")+ urls.getProperty("ReferenceList");

	/*
	 * Use-case : 1) Go to any Ultimate List 2) Go to any Vote List Test case :
	 * For Ultimate Lists, there should be a red list ribbon partially
	 * overlapping the list image and pointing to the beginning of the list
	 * title. For Vote Lists, there should be a blue list ribbon partially
	 * overlapping the list image and pointing to the beginning of the list
	 * title.
	 */
	@Test(priority = 1, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ListRibbon(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl, "ListRibbon");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "ListRibbon");
		}
		
		// list ribbon ultimate list.
		Assert.assertTrue(listHeader.isListRibbonPresent("ultimate"));
		Assert.assertEquals("Ultimate List",(listHeader.getTextOfListRibbon("ultimate")));
		Assert.assertEquals("rgba(129, 38, 46, 1)",(listHeader.getColorOfListRibbon("ultimate")));
		// list ribbon ultimate list.
		// getDriver().get(voteUrl);
		common.getNewURL(voteUrl);
		listHeader.cancelLoading();
		Assert.assertTrue(listHeader.isListRibbonPresent("vote"));
		Assert.assertEquals("Vote List",(listHeader.getTextOfListRibbon("vote")));
		Assert.assertEquals("rgba(8, 108, 184, 1)",(listHeader.getColorOfListRibbon("vote")));
	}// End of ListRibbon()

	/*
	 * Use-case : Go to any list. Test case : The more info link should be
	 * italicized, blue, and clickable. When clicked, a box should appear
	 * showing the breadcrumb, number of items in the list (verify this # is
	 * correct), and the list tags.
	 */
	@Test(priority = 2, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void MoreInfoLink(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"MoreInfoLink");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "MoreInfoLink");
		}
		Assert.assertEquals(listHeader.getColorOfMoreInfoLink(),"rgba(8, 108, 184, 1)");
		Assert.assertEquals(listHeader.getFontStyleOfmoreInfoLink(), "italic");
		listHeader.clickOnmoreInfoLink();
		Assert.assertTrue(listHeader.ismoreInfoBoxItemsPresent("breadCrumb"));
		Assert.assertTrue(listHeader.ismoreInfoBoxItemsPresent("item"));
		Assert.assertTrue(listHeader.ismoreInfoBoxItemsPresent("tags"));
	}// End of MoreInfoLink()

	/*
	 * Use-case : Go to any list. Test case : The breadcrumb should have a
	 * "home" link linking to the homepage at a minimum. If there are more links
	 * in the breadcrumb, those links should take you to the corresponding
	 * category/class page.
	 */
	@Test(priority = 3, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void MoreInfoBreadCrumb(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"MoreInfoBreadCrumb");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "MoreInfoBreadCrumb");
		}
		listHeader.clickOnmoreInfoLink();
		Assert.assertTrue(listHeader.isMoreInfoBreadCrumbPresent(1));
		String href = listHeader.getHrefOfMoreInfoBreadCrumb(1);
		listHeader.clickOnMoreInfoBreadCrumb(1);
		try {
			Thread.sleep(9000);
		} catch (Exception e) {
		}
		String url = listHeader.getCurrentURL();
		Assert.assertEquals(href, url);
		for (int i = 2; i < 4; i++) {
			getDriver().navigate().back();
			SafeActions s = new SafeActions(getDriver());
			s.waitForPageToLoad(30);
			try {
				Thread.sleep(9000);
			} catch (Exception e) {
			}
			common.facebookLikePresenceAndAccept();
			listHeader.clickOnmoreInfoLink();
			if (listHeader.isMoreInfoBreadCrumbPresent(i)) {
				href = listHeader.getHrefOfMoreInfoBreadCrumb(i);
				listHeader.clickOnMoreInfoBreadCrumb(i);
				try {
					Thread.sleep(5000);
				} catch (Exception e) {
				}
				url = listHeader.getCurrentURL();
				Assert.assertEquals(href, url);
			}
		}
	}// End of MoreInfoBreadCrumb()

	/*
	 * Use-case : Go to any list. Test case : Tags can either be clickable (if
	 * they have a tag page for that tag) or unclickable (if they don't have a
	 * tag page). Clicking on a clickable tag should take you to the
	 * corresponding tag page.
	 */
	@Test(priority = 4, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void MoreInfoTags(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"MoreInfoTags");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "MoreInfoTags");
		}
		for (int i = 1; i < 5; i++) {
			listHeader.clickOnmoreInfoLink();
			try {
				Thread.sleep(7000);
			} catch (Exception e) {
			}
			Assert.assertTrue(listHeader.isMoreInfoTagsPresent(i));
			if (listHeader.isMoreInfoTagsClickable(i)) {
				String href = listHeader.getHrefOfmoreInfoTags(i);
				listHeader.clickOnMoreInfoTags(i);
				try {
					Thread.sleep(7000);
				} catch (Exception e) {
				}
				String url = listHeader.getCurrentURL();
				Assert.assertEquals(href, url);
				getDriver().navigate().back();
			}
		}
	}// End of MoreInfoTags()

	/*
	 * Use-case : Go to any list that has List Criteria. Test case : Verify that
	 * the List Criteria is relevant to the list and is below the list title.
	 * "List Criteria" should be bold and dark red, and the criteria should be
	 * black.
	 */
	@Test(priority = 5, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ListCriteria(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"ListCriteria");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "ListCriteria");
		}
		Assert.assertTrue(listHeader.isListCriteriaPresent());
		String txt = listHeader.getTextOfListCriteriaText("criteria");
		Assert.assertEquals(
				"Upvote the least relevant (but formerly big-deal) actors", txt);
		Assert.assertEquals("rgba(0, 0, 0, 1)",
				(listHeader.getColorOflistCriteria("criteria")));
		Assert.assertEquals("rgba(129, 38, 46, 1)",
				(listHeader.getColorOflistCriteria("head")));

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (sysProp.getProperty("Browser.Name").equals("ie")) {
			Assert.assertEquals("700",
					(listHeader.getFontWeightOfListCriteriaHead("head")));
		} else
			Assert.assertEquals("bold",
					(listHeader.getFontWeightOfListCriteriaHead("head")));

		// Assert.assertEquals("bold",(listHeader.getFontWeightOfListCriteriaHead("head")));
	}// End of ListCriteria()

	/*
	 * Use-case : Go to any list that has List Description. Test case : Verify
	 * that the List Description is relevant to the list and is below the List
	 * Criteria (if applicable). The description should have a dark gray font,
	 * slightly but noticeably lighter than the List Criteria.
	 */
	@Test(priority = 6, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ListDescription(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"ListDescription");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "ListDescription");
		}
		Assert.assertTrue(listHeader.isListDescriptionPresent("short"));
		Assert.assertEquals("rgba(99, 99, 99, 1)",
				(listHeader.getColorOfListDescription("short")));
	}// End of ListDescription()

	/*
	 * Use-case : Go to any list that has long List Description. Test case :
	 * Clicking the "more" button in List Description should expand the section
	 * to show the full text. Clicking the "less" button in the expanded List
	 * Description state should reduce the section back to its original size.
	 */
	@Test(priority = 7, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void MoreLessButton(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"MoreLessButton");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "MoreLessButton");
		}
		listHeader.clickOnMoreLess();
		Assert.assertTrue(listHeader.isListDescriptionPresent("long"));
		listHeader.clickOnMoreLess();
		Assert.assertTrue(listHeader.isListDescriptionPresent("short"));
	}// End of MoreLessButton()

	/*
	 * Use-case : List Stats - votes & voters [ULTIMATE/VOTE]. Test case : 1) Go
	 * to any Ultimate List 2) Go to any Vote List.
	 */
	@Test(priority = 8, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void VotesAndVoters(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"VotesAndVoters");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "VotesAndVoters");
		}
		Assert.assertTrue(listHeader.isStatsPresent(2));
		Assert.assertTrue(listHeader.isStatsPresent(3));
		common.getNewURL(voteUrl);
		Assert.assertTrue(listHeader.isStatsPresent(3));
		Assert.assertTrue(listHeader.isStatsPresent(4));
	}// End of VotesAndVoters()

	/*
	 * Use-case : List Stats - reranks [ULTIMATE/RERANK/CONTRIBUTING]. Test case
	 * : 1) Go to any Ultimate List 2) Go to any Rerank List
	 */
	@Test(priority = 9, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ListReranks(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 9 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"ListReranks");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "ListReranks");
		}
		Assert.assertTrue(listHeader.isStatsPresent(5));
		Assert.assertEquals(listHeader.getFontStyleOfStatsRerank(5), "italic");
	}// End of ListReranks()

	/*
	 * Use-case : List Stats - views [ALL]. Test case : 1) Go to any Ultimate
	 * List 2) Go to any Vote List 3) Go to any Reference List
	 */
	@Test(priority = 10, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ListViews(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 10 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl, "ListViews");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "ListViews");
		}
		// ultimate list
		Assert.assertTrue(listHeader.isStatsPresent(4));
		Assert.assertEquals(listHeader.getFontStyleOfStatsRerank(4), "italic");
		// vote list
		common.getNewURL(voteUrl);
		// common.facebookLikePresenceAndAccept();
		Assert.assertTrue(listHeader.isStatsPresent(5));
		Assert.assertEquals(listHeader.getFontStyleOfStatsRerank(5), "italic");
		// reference list
		common.getNewURL(referenceUrl);
		// common.facebookLikePresenceAndAccept();
		Assert.assertTrue(listHeader.isStatsPresent(2));
		Assert.assertEquals(listHeader.getFontStyleOfStatsRerank(2), "italic");
	}// End of ListViews()

	/*
	 * Use-case : List Title. Test case : Go to any list.
	 */
	@Test(priority = 11, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ListTitle(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 11 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl, "ListTitle");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "ListTitle");
		}
		Assert.assertTrue(listHeader.isTitlePresent());
	}// End of ListTitle()

	/*
	 * Use-case : List Title - link. Test case : Paginate to new pages on a list
	 * that has multiple pages.
	 */
	@Test(priority = 12, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ListTitleLink(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"ListTitleLink");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "ListTitleLink");
		}
		common.getNewURL(config.getProperty("Url")
				+ "crowdranked-list/hottest-natural-beauties?page=2");
		// common.facebookLikePresenceAndAccept();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		listHeader.hoverOverTitle();
		Assert.assertEquals(listHeader.getColorOfTitleHover(),
				"rgba(0, 0, 0, 1)");// rgba(0, 0, 0, 1)
		String txtBefore = listHeader.getTextOfTitle();
		listHeader.clickOnTitle();
		String txtAfter = listHeader.getTextOfTitle();
		Assert.assertEquals(txtBefore, txtAfter);
	}// End of ListTitleLink()

	/*
	 * Use-case : Go to any list. Test case : Clicking region/age/men/women/ tab
	 * should open the groups tab in the overlay with the corresponding chosen
	 * demographic.
	 */
	@Test(priority = 13, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void OverLayTab(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 13 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl, "OverLayTab");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "OverLayTab");
		}
		listHeader.clickOverLaytab(2);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		common.facebookLikePresenceAndAccept();
		Assert.assertTrue(listHeader.ispresentOverLaytabPopUp());
	}// End of OverLayTab()

	/*
	 * Use-case : "1) Go to any list 2) Click on the list image" Test case :
	 * Clicking on the list image should take you to the list image pics page.
	 */
	@Test(priority = 14, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ListImageOpen(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 14 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"ListImageOpen");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "ListImageOpen");
		}

		String href = listHeader.getHrefOflistimage(1);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		common.votableLinkPresenceAndAccept();
		listHeader.clicklistimage(1);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		String url1 = listHeader.getCurrentURL();
		// System.out.println("url"+url1);
		Assert.assertEquals(url1, href);
	}// End of ListImageOpen()

	/*
	 * Use-case : See List Ranked By [EXPERT/ULTIMATE/RERANK]. Test case : 1) Go
	 * to any Expert List 2) Go to any Ultimate List 3) Go to any Rerank
	 * List.(Verify that there is a "SEE LIST RANKED BY" section in gray font
	 * below the List Description and that it has at least 1 tab users can click
	 * on.)
	 */
	@Test(priority = 15, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ListRankedBy(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 15 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"ListRankedBy");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "ListRankedBy");
		}
		Assert.assertTrue(listHeader.isListRerankedTabsPresent(3));
		Assert.assertEquals(listHeader.getColorOfListRankedBy(3),
				"rgba(160, 160, 160, 1)");
		for (int i = 1; i < 3; i++) {
			Assert.assertTrue(listHeader.isListRerankedTabsPresent(i));
			if (listHeader.isListRankedByTabsClickable(i))
				listHeader.clickOverLaytab(i);
		}
	}// End of ListRankedBy()

	/*
	 * Use-case : Go to any list that has Google AdChoices Test case :The Google
	 * AdChoices block should be below the List Description and have 3 links to
	 * Google Ads.
	 */
	@Test(priority = 16, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void AdChoices(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 16 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(config.getProperty("Url")+ "list/best-protein-powder-brands/werner-brandes","AdChoices");
		} else {
			listHeader = BaseState(config.getProperty("Url")+ "list/best-protein-powder-brands/werner-brandes","AdChoices");
		}
		for (int i = 1; i <= 3; i++) {
			System.out.println("111iiiiii="+i);
			String beforeclick = listHeader.gethrefOfadChoices(i);
			System.out.println("beforeclick="+beforeclick);
			listHeader.clickOnadChoices(i);
			System.out.println("111111111111111111111="+i);
			getDriver().switchTo().defaultContent();
			if (sysProp.getProperty("Browser.Name").equals("chrome")) {
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
				}
			}
			System.out.println("2222222222222222222222="+i);
			ArrayList<String> tabs2 = new ArrayList<String>(getDriver()	.getWindowHandles());
			getDriver().switchTo().window(tabs2.get(1));
			Assert.assertEquals(beforeclick, getDriver().getCurrentUrl());
			getDriver().close();
			getDriver().switchTo().window(tabs2.get(0));
		}
	}// End of AdChoices

	/*
	 * Use-case :Go to any list that has Wiki Links Test case :"Verify that
	 * there are 2 links under the List Description (or Google AdChoices if
	 * applicable) in blue italicized font smaller than the description. If the
	 * list description has a ""more"" button, the wiki links should be shown in
	 * the expanded state. The ""lists about"" link should send you to the node
	 * page and the ""on wikipedia"" link should send you to the wikipedia page
	 * for the node."
	 */
	@Test(priority = 17, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void WikiLinks(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 17 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(
					config.getProperty("Url")
							+ "list/list-of-justin-bieber-music-video-releases/music-videos",
					"WikiLinks");
		} else {
			listHeader = BaseState(
					config.getProperty("Url")
							+ "list/list-of-justin-bieber-music-video-releases/music-videos",
					"WikiLinks");
		}
		listHeader.clickOnMoreLess();
		for (int i = 1; i <= 2; i++) {
			Assert.assertEquals(listHeader.getFontStyleaftermorewikilist(1),
					"italic");
			Assert.assertEquals("rgba(8, 108, 184, 1)",
					(listHeader.getColorOfaftermorewikilist(i)));
		}
		String href = listHeader.gethrefOfwikilist(1);
		listHeader.clickOnwikilist(1);
		String url = listHeader.getCurrentURL();
		Assert.assertEquals(url, href);
		getDriver().navigate().back();
		// /wiki 2 list check
		listHeader.clickOnMoreLess();
		String href1 = listHeader.gethrefOfwikilist(2);
		listHeader.clickOnwikilist(2);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		ArrayList<String> tabs2 = new ArrayList<String>(getDriver()
				.getWindowHandles());
		getDriver().switchTo().window(tabs2.get(1));
		String url1 = listHeader.getCurrentURL();
		System.out.println("url1===" + url1);
		System.out.println("href1===" + href1);
		if (url1.contains("Justin_Bieber")) {
			Assert.assertEquals(1, 1);
		} else
			Assert.assertEquals(1, 0);
		// Assert.assertEquals(url1, href1);
		getDriver().close();
		getDriver().switchTo().window(tabs2.get(0));
	}// End of WikiLinks
		// //////////////////////////New testcases/////////////////////////

	/*
	 * Use-case : Go to any Ultimate List. Test case : Verify that the
	 * images/videos for the nodes in the overlay match those in the actual
	 * list. Make sure that the rankings in the overlay line up with the actual
	 * list. Click the arrows and the demographic icons to make sure all buttons
	 * are working.
	 */
	@Test(priority = 18, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void OverLayImageMatch(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 18 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"OverLayImageMatch");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "OverLayImageMatch");
		}
		common.getNewURL(config.getProperty("Url")
				+ "crowdranked-list/the-10-worst-u-s-presidents");
		common.votableLinkPresenceAndAccept();
		String name1 = listHeader.getTextOfNodeInList("name");
		String[] src1 = listHeader.getSrcOfNodeImageInList("image").split("/");
		listHeader.clickOverLaytab(2);

		for (int i = 1; i <= 10; i++) {
			String[] name2 = listHeader.getTextOfNodeInOverlay(i, "name")
					.split("\n");
			if (name2[0].equalsIgnoreCase(name1)) {
				String[] src2 = listHeader.getSrcOfNodeImageInOverlay(i).split(
						"/");
				Assert.assertEquals(src1[src1.length - 1],
						src2[src2.length - 1]);
				break;
			}
		}
	}// End of OverLayImageMatch()

	/*
	 * Use-case : Demo/Rerank Overlay: Adjust to match new list style. Test case
	 * : Click on Region and notice the images,font,border etc are matching with
	 * the list rows style.
	 */
	@Test(priority = 19, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void OverLayStyleMatch(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 19 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"OverLayImageMatch");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "OverLayImageMatch");
		}
		common.getNewURL(config.getProperty("Url")
				+ "crowdranked-list/the-10-worst-u-s-presidents");
		common.votableLinkPresenceAndAccept();
		// font
		String fname1 = listHeader.getTextOfNodeInList("name");
		String fsrc1 = listHeader.getFontOfNodeInList("name");
		// image
		String iname1 = listHeader.getTextOfNodeInList("name");
		String[] isrc1 = listHeader.getSrcOfNodeImageInList("image").split("/");
		// height
		String[] hname1 = listHeader.getHeightOfNodeInList("height")
				.split("px");
		int name1 = Integer.parseInt(hname1[0]);
		listHeader.clickOnOptionInOverlayTab(2);
		// font
		for (int i = 1; i <= 10; i++) {
			String[] fname2 = listHeader.getTextOfNodeInOverlay(i, "name")
					.split("\n");
			if (fname2[0].equalsIgnoreCase(fname1)) {
				String fsrc2 = listHeader.getFontOfNodeInOverlay(i, "name");
				Assert.assertEquals(fsrc1, fsrc2);
				break;
			}
		}
		// image
		for (int i = 1; i <= 10; i++) {
			String[] iname2 = listHeader.getTextOfNodeInOverlay(i, "name")
					.split("\n");
			if (iname2[0].equalsIgnoreCase(iname1)) {
				String[] isrc2 = listHeader.getSrcOfNodeImageInOverlay(i)
						.split("/");
				Assert.assertEquals(isrc1[isrc1.length - 1],
						isrc2[isrc2.length - 1]);
				break;
			}
		}
		// height
		for (int i = 1; i <= 10; i++) {
			String[] hname2 = listHeader.getHeightOfNodeInOverlay(i, "height")
					.split("px");
			int name2 = Integer.parseInt(hname2[0]);
			Assert.assertEquals((name1) - 1, name2);

		}
	}// End of OverLayStyleMatch()

	/*
	 * Use-case : Ranked by dropdown. Test case : 1) Open any UL list in info
	 * style 2) Select anyone from 'Ranked by' Dropdown
	 */
	@Test(priority = 20, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void rankByDropdown(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 20 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"rankByDropdown");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "rankByDropdown");
		}
		common.getNewURL(config.getProperty("Url")
				+ "list/actors-nobody-cares-about-anymore/ranker-celebrities");
		common.votableLinkPresenceAndAccept();
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
		}
		listHeader.clickOverLaytab(2);
		listHeader.clickOnRerankComboBox();
		listHeader.clickAndSelectOnRerankComboBox(2);
		for (int i = 1; i <= 50; i++) {
			listHeader.isNodesInOverlayPresent(i, "height");
		}
	}// End of rankByDropdown()

	/*
	 * Use-case : List Stats - views Test case : Go to any Reference List
	 */
	@Test(priority = 21, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void ListStatesviews(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 21 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(referenceUrl, "ListStatesviews");
		} else {
			listHeader = BaseState(referenceUrl, "ListStatesviews");
		}
		common.votableLinkPresenceAndAccept();
		Assert.assertTrue(listHeader.isListTagsPresent());
		Assert.assertTrue(listHeader.isListViewsPresent());
	} // end of ListStatesviews()

	/*
	 * Use-case : See List Ranked By - reranks overlay [ULTIMATE/RERANK] Test
	 * case : 1) Go to any Ultimate List 2) Go to any Rerank List
	 */
	@Test(priority = 22, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void RerankTabOverlay(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 22 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"RerankTabOverlay");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "RerankTabOverlay");
		}
		common.getNewURL(config.getProperty("Url")
				+ "crowdranked-list/the-10-worst-u-s-presidents");
		common.votableLinkPresenceAndAccept();
		String name1 = listHeader.getTextOfNodeInList("name");
		String[] src1 = listHeader.getSrcOfNodeImageInList("image").split("/");
		listHeader.clickOverLaytab(1);
		listHeader.clickOnRerankComboBox();
		listHeader.clickAndSelectOnRerankComboBox(4);

		for (int i = 1; i <= 25; i++) {
			String[] name2 = listHeader.getTextOfNodeInOverlay(i, "name")
					.split("\n");
			if (name2[0].equalsIgnoreCase(name1)) {
				String[] src2 = listHeader.getSrcOfNodeImageInOverlay(i).split(
						"/");
				Assert.assertEquals(src1[src1.length - 1],
						src2[src2.length - 1]);
				break;
			}
		}

	} // end of RerankTabOverlay
//
//	/*
//	 * Use-case : Facebook share copy //new testcase Test case :Click on the
//	 * Facebook social share button.
//	 */
//	@Test(priority = 23, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void FacebookShareButton(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 23 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"FacebookShareButton");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl, "FacebookShareButton");
//		}
//		try {
//			Thread.sleep(9000);
//		} catch (Exception e) {
//		}
//		listHeader.clickOnfacebook();
//		try {
//			Thread.sleep(7000);
//		} catch (Exception e) {
//		}
//		common.facebookLogin("salmankhantc", "Dehradun1");
//		try {
//			Thread.sleep(7000);
//		} catch (Exception e) {
//		}
//		listoptionpage.switchToParentWindow();
////		getDriver().close();
//		System.out.println("!!!1111111111111111111");
//		getDriver().get("http://www.facebook.com");
//		try {
//			Thread.sleep(20000);
//		} catch (Exception e) {
//		}
//		System.out.println("!!!33333333333333333");
//		//listHeader.hoverOverfacebookAfterlogin();
//		System.out.println("!!!qddddddddddddddddddddd");
//		Assert.assertTrue(listHeader.isPresentfacebookAfterlogin());
//		
//		System.out.println("!!!qqqqqqqqqqqqqqqqqqqqqq");
//		//String href=listHeader.getHrefOfFacebookshare(ultimateContributeUrl);
//		//Assert.assertTrue(listHeader.isFacebooksharePresent());
//		listHeader.clickOnFacebookshare();
//		
//		System.out.println("!!!4444444444444444");
//		 try {
//				Thread.sleep(2000);
//			} catch (Exception e) {
//			}
//		 
//		 ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
//		 getDriver().switchTo().window(tabs2.get(1));
//		 String afterurl[]= getDriver().getCurrentUrl().split("\\?");
//		// Assert.assertEquals(href, afterurl[0]);
//		 getDriver().close();
//		 getDriver().switchTo().window(tabs2.get(0));	
//		 
//		 
//		//Assert.assertTrue(listHeader.isPresentfacebookwindowpresent());
//		//Assert.assertFalse(listHeader.isPresentfacebookErrorpresent());
//		//getDriver().close();
//		//listoptionpage.switchToParentWindow();
//	}// End of FacebookShareButton()
	/*
	  * Use-case : Facebook share copy //new testcase Test case :Click on the
	  * Facebook social share button.
	  */
	 @Test(priority = 23, dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FacebookShareButton(String loginRequired) {
	  System.out
	    .println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 23 !!!!!!!!!!!!!!!!!!!!!!!");
	  // Base state. (Navigate to node page)
	  ListHeader listHeader = null;
	  ListOptionPage listoptionpage = new ListOptionPage(getDriver());
	  if (loginRequired.equals("YES")) {
	   listHeader = BaseStateWithLogin(ultimateContributeUrl,
	     "FacebookShareButton");
	  } else {
	   listHeader = BaseState(ultimateContributeUrl, "FacebookShareButton");
	  }
	  try {
	   Thread.sleep(9000);
	  } catch (Exception e) {
	  }
	  listHeader.clickOnfacebook();
	  try {
	   Thread.sleep(7000);
	  } catch (Exception e) {
	  }
	  common.facebookLogin("salmankhantc", "Dehradun1");
	  try {
	   Thread.sleep(7000);
	  } catch (Exception e) {
	  }

	  Assert.assertTrue(listHeader.isPresentfacebookwindowpresent());
	  Assert.assertFalse(listHeader.isPresentfacebookErrorpresent());
	  getDriver().close();
	  listoptionpage.switchToParentWindow();
	 }// End of FacebookShareButton()
	/*
	 * Use-case : Twitter share copy //new testcase Test case :Click on the
	 * Twitter social share button.
	 */
	@Test(priority = 24, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void TwitterShareButton(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 24 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		// ListOptionPage listoptionpage = null;
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"TwitterShareButton");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "TwitterShareButton");
		}
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		listHeader.clickOntwitter();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		// listoptionpage.switchToParentWindow();
		if (listoptionpage.isPresenttiwtterlogin() == true) {
			Assert.assertEquals(1, 1);
		} else if (listHeader.isPresenttwitterwindowpresent()) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
		getDriver().close();
		listoptionpage.switchToParentWindow();
		// Assert.assertTrue(listHeader.isPresenttwitterwindowpresent());

	}// End of TwitterShareButton()

	/*
	 * Use-case : pinterest share copy //new testcase Test case :Click on the
	 * pinterest social share button.
	 */
	@Test(priority = 25, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void pinterestShareButton(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 25 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"pinterestShareButton");
		} else {
			listHeader = BaseState(ultimateContributeUrl,
					"pinterestShareButton");
		}
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		listHeader.clickOnpinterest();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		common.clickOnPintLoginFBbutton();
		common.facebookLogin("salmankhantc", "Dehradun1");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		SafeActions sf = new SafeActions(getDriver());
		sf.switchToWindow(1);
		Assert.assertTrue(listoptionpage.ispintersetWindowPresent());
		getDriver().close();
		listoptionpage.switchToParentWindow();
		// getDriver().close();
	}// End of pinterestShareButton()

	/*
	 * Use-case : UE: Rerank button Test case : 1) Open any
	 * Ultimate/Contributing list 2) Click on "Rerank this list" appear just
	 * below list Strip tab
	 */
	@Test(priority = 26, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void RerankButton(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 26 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"RerankButton");
		} else {
			listHeader = BaseState(ultimateContributeUrl, "RerankButton");
		}
		// common.getNewURL(config.getProperty("Url")+"list/actors-nobody-cares-about-anymore/ranker-celebrities");
		//common.votableLinkPresenceAndAccept();
		for (int i = 1; i <= 4; i++) {
			listHeader.clickonvotebtn(i);
		}
		try {
			Thread.sleep(9000);
		} catch (Exception e) {
		}
		Assert.assertTrue(listHeader.isPresentminiedit());

		// rerankpage.clickonrerankaftervote();
		// try {
		// Thread.sleep(4000);
		// } catch (Exception e) {
		// }
	}// End of RerankButton

	/*
	 * Use-case : Add social chicklets to list header Test case : 1. Go to a UL
	 * infostyle list and verify that the 4 chicklets are there. Click on all
	 * social chicklets
	 */
	@Test(priority = 27, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialULInfoFB(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 27 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"FloterSocialULInfoFB");
		} else {
			listHeader = BaseState(ultimateContributeUrl,
					"FloterSocialULInfoFB");
		}
		// UL info style list
		// Facebook
		listHeader.clickOnFloterSocialChicklets(1);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		common.facebookLogin("salmankhantc", "Dehradun1");
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
	 * Use-case : Add social chicklets to list header Test case : Go to a UL
	 * blog list and verify that the facebook chicklets is there Click on
	 * Facebook social chicklets
	 */
	@Test(priority = 28, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialULBlogFB(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 28 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"FloterSocialULBlogFB");
		} else {
			listHeader = BaseState(ultimateContributeUrl,
					"FloterSocialULBlogFB");
		}
		// UL blog style list
		ListOptionPage listOption = new ListOptionPage(getDriver());
		listOption.clickOnheaderoption();
		listOption.clickOnheaderoptionpopup("View as Blog");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		// Facebook
		listHeader.clickOnFloterSocialChicklets(1);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		common.facebookLogin("salmankhantc", "Dehradun1");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		Assert.assertTrue(listHeader.isPresentfacebookwindowpresent());
		Assert.assertFalse(listHeader.isPresentfacebookErrorpresent());
		getDriver().close();
		listHeader.switchToWindow(0);
	} // End of FloterSocialBlogFB

	/*
	 * Use-case : Add social chicklets to list header Test case : Go to a UL
	 * SlideShow list and verify that the facebook chicklets is there Click on
	 * Facebook social chicklets
	 */
	@Test(priority = 29, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialULSlideFB(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 29 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"FloterSocialULSlideFB");
		} else {
			listHeader = BaseState(ultimateContributeUrl,
					"FloterSocialULSlideFB");
		}
		// UL Slideshow style list
		ListOptionPage listOption = new ListOptionPage(getDriver());
		listOption.clickOnheaderoption();
		listOption.clickOnheaderoptionpopup("View as Slideshow");
		// Facebook
		listHeader.clickOnFloterSocialChicklets(1);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}

		common.facebookLogin("salmankhantc", "Dehradun1");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		Assert.assertTrue(listHeader.isPresentfacebookwindowpresent());
		Assert.assertFalse(listHeader.isPresentfacebookErrorpresent());
		getDriver().close();
		listHeader.switchToWindow(0);
	} // End of FloterSocialSlideFB()

	/*
	 * Use-case : Add social chicklets to list header Test case : Go to a NON UL
	 * infostyle list and verify that the facebook chicklets is there Click on
	 * Facebook social chicklets
	 */
	@Test(priority = 30, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialInfoFB(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 30 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl, "FloterSocialInfoFB");
		} else {
			listHeader = BaseState(voteUrl, "FloterSocialInfoFB");
		}
		// NON UL infostyle list

		// Facebook
		listHeader.clickOnFloterSocialChicklets(1);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		common.facebookLogin("salmankhantc", "Dehradun1");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		Assert.assertTrue(listHeader.isPresentfacebookwindowpresent());
		Assert.assertFalse(listHeader.isPresentfacebookErrorpresent());
		getDriver().close();
		listHeader.switchToWindow(0);
	} // End of FloterSocialInfoFB

	/*
	 * Use-case : Add social chicklets to list header Test case : Go to a NON UL
	 * Blog list and verify that the facebook chicklets is there Click on
	 * Facebook social chicklets
	 */
	@Test(priority = 31, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialBlogFB(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 31 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl, "FloterSocialBlogFB");
		} else {
			listHeader = BaseState(voteUrl, "FloterSocialBlogFB");
		}
		// NON UL blog style list
		ListOptionPage listOption = new ListOptionPage(getDriver());
		listOption.clickOnheaderoption();
		listOption.clickOnheaderoptionpopup("View as Blog");
		// Facebook
		listHeader.clickOnFloterSocialChicklets(1);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		common.facebookLogin("salmankhantc", "Dehradun1");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		Assert.assertTrue(listHeader.isPresentfacebookwindowpresent());
		Assert.assertFalse(listHeader.isPresentfacebookErrorpresent());
		getDriver().close();
		listHeader.switchToWindow(0);
	} // End of FloterSocialBlogFB

	/*
	 * Use-case : Add social chicklets to list header Test case : Go to a NON UL
	 * SlideShow list and verify that the facebook chicklets is there Click on
	 * Facebook social chicklets
	 */
	@Test(priority = 32, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialSlideFB(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 32 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl, "FloterSocialSlideFB");
		} else {
			listHeader = BaseState(voteUrl, "FloterSocialSlideFB");
		}
		// NON UL Slideshow style list
		ListOptionPage listOption = new ListOptionPage(getDriver());
		listOption.clickOnheaderoption();
		listOption.clickOnheaderoptionpopup("View as Slideshow");
		// Facebook
		listHeader.clickOnFloterSocialChicklets(1);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		common.facebookLogin("salmankhantc", "Dehradun1");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		Assert.assertTrue(listHeader.isPresentfacebookwindowpresent());
		Assert.assertFalse(listHeader.isPresentfacebookErrorpresent());
		getDriver().close();
		listHeader.switchToWindow(0);
	}// End of FloterSocialSlideFB

	/*
	 * Use-case : Add social chicklets to list header Test case : 1. Go to a UL
	 * infostyle list and verify that the twitter chicklets is there. Click on
	 * all social chicklets
	 */
	@Test(priority = 33, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialULInfoTW(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 33 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		ListOptionPage listOption = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"FloterSocialULInfoTW");
		} else {
			listHeader = BaseState(ultimateContributeUrl,
					"FloterSocialULInfoTW");
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
	 * Use-case : Add social chicklets to list header Test case : 1. Go to a UL
	 * blog list and verify that the twitter chicklets is there. Click on all
	 * social chicklets
	 */
	@Test(priority = 34, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialULBlogTW(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 34 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"FloterSocialULBlogTW");
		} else {
			listHeader = BaseState(ultimateContributeUrl,
					"FloterSocialULBlogTW");
		}
		// UL blog style list
		// Twitter
		ListOptionPage listOption = new ListOptionPage(getDriver());
		listOption.clickOnheaderoption();
		listOption.clickOnheaderoptionpopup("View as Blog");
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
	} // End of FloterSocialULBlogTW

	/*
	 * Use-case : Add social chicklets to list header Test case : 1. Go to a UL
	 * Slide list and verify that the twitter chicklets is there. Click on all
	 * social chicklets
	 */
	@Test(priority = 35, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialULSlideTW(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 35 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"FloterSocialULSlideTW");
		} else {
			listHeader = BaseState(ultimateContributeUrl,
					"FloterSocialULSlideTW");
		}
		// UL blog style list
		ListOptionPage listOption = new ListOptionPage(getDriver());
		listOption.clickOnheaderoption();
		listOption.clickOnheaderoptionpopup("View as Slideshow");
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
	} // End of FloterSocialULSlideTW

	/*
	 * Use-case : Add social chicklets to list header Test case : Go to a NON UL
	 * infostyle list and verify that the twitter chicklets is there Click on
	 * twitter social chicklets
	 */
	@Test(priority = 36, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialInfoTW(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 36 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		ListOptionPage listOption = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl, "FloterSocialInfoTW");
		} else {
			listHeader = BaseState(voteUrl, "FloterSocialInfoTW");
		}
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
	} // End of FloterSocialInfoTW

	/*
	 * Use-case : Add social chicklets to list header Test case : Go to a NON UL
	 * Blog list and verify that the twitter chicklets is there Click on twitter
	 * social chicklets
	 */
	@Test(priority = 37, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialBlogTW(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 37 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		ListOptionPage listOption = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl, "FloterSocialBlogTW");
		} else {
			listHeader = BaseState(voteUrl, "FloterSocialBlogTW");
		}
		// Twitter

		listOption.clickOnheaderoption();
		listOption.clickOnheaderoptionpopup("View as Blog");
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
	} // End of FloterSocialBlogTW

	/*
	 * Use-case : Add social chicklets to list header Test case : Go to a NON UL
	 * SlideShow list and verify that the twitter chicklets is there Click on
	 * twitter social chicklets
	 */
	@Test(priority = 38, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialSlideTW(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 38 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		ListOptionPage listOption = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl, "FloterSocialSlideTW");
		} else {
			listHeader = BaseState(voteUrl, "FloterSocialSlideTW");
		}
		// Twitter

		listOption.clickOnheaderoption();
		listOption.clickOnheaderoptionpopup("View as Slideshow");
		listHeader.clickOnFloterSocialChicklets(2);
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
		}

		common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
		try {
			Thread.sleep(5000);
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
	}

	/*
	 * Use-case : Add social chicklets to list header Test case : 1. Go to a UL
	 * infostyle list and verify that the twitter chicklets is there. Click on
	 * all social chicklets
	 */
	@Test(priority = 39, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialULInfoPinterest(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 39 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		ListOptionPage listOption = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"FloterSocialULInfoPinterest");
		} else {
			listHeader = BaseState(ultimateContributeUrl,
					"FloterSocialULInfoPinterest");
		}
		// UL info style list
		listHeader.clickOnFloterSocialChicklets(3);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		common.clickOnPintLoginFBbutton();
		common.facebookLogin("salmankhantc", "Dehradun1");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		SafeActions sf = new SafeActions(getDriver());
		sf.switchToWindow(1);
		Assert.assertTrue(listOption.ispintersetWindowPresent());
		getDriver().close();
		listHeader.switchToWindow(0);
	} // End of FloterSocialULInfoPinterest

	/*
	 * Use-case : Add social chicklets to list header Test case : 1. Go to a UL
	 * blog list and verify that the twitter chicklets is there. Click on all
	 * social chicklets
	 */
	@Test(priority = 40, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialULBlogPinterest(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 40 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"FloterSocialULBlogPinterest");
		} else {
			listHeader = BaseState(ultimateContributeUrl,
					"FloterSocialULBlogPinterest");
		}
		// UL blog style list
		ListOptionPage listOption = new ListOptionPage(getDriver());
		listOption.clickOnheaderoption();
		listOption.clickOnheaderoptionpopup("View as Blog");
		listHeader.clickOnFloterSocialChicklets(3);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		common.clickOnPintLoginFBbutton();
		common.facebookLogin("salmankhantc", "Dehradun1");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		SafeActions sf = new SafeActions(getDriver());
		sf.switchToWindow(1);
		Assert.assertTrue(listOption.ispintersetWindowPresent());
		getDriver().close();
		listHeader.switchToWindow(0);
	} // End of FloterSocialULBlogPinterest

	/*
	 * Use-case : Add social chicklets to list header Test case : 1. Go to a UL
	 * Slide list and verify that the twitter chicklets is there. Click on all
	 * social chicklets
	 */
	@Test(priority = 41, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialULSlidePinterest(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 41 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(ultimateContributeUrl,
					"FloterSocialULSlidePinterest");
		} else {
			listHeader = BaseState(ultimateContributeUrl,
					"FloterSocialULSlidePinterest");
		}
		ListOptionPage listOption = new ListOptionPage(getDriver());
		listOption.clickOnheaderoption();
		listOption.clickOnheaderoptionpopup("View as Slideshow");
		listHeader.clickOnFloterSocialChicklets(3);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		common.clickOnPintLoginFBbutton();
		common.facebookLogin("salmankhantc", "Dehradun1");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		SafeActions sf = new SafeActions(getDriver());
		sf.switchToWindow(1);
		Assert.assertTrue(listOption.ispintersetWindowPresent());

		getDriver().close();
		listHeader.switchToWindow(0);
	} // End of FloterSocialULSlidePinterest

	/*
	 * Use-case : Add social chicklets to list header Test case : Go to a NON UL
	 * infostyle list and verify that the twitter chicklets is there Click on
	 * twitter social chicklets
	 */
	@Test(priority = 42, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialInfoPinterest(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 42 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		ListOptionPage listOption = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl,
					"FloterSocialInfoPinterest");
		} else {
			listHeader = BaseState(voteUrl, "FloterSocialInfoPinterest");
		}
		listHeader.clickOnFloterSocialChicklets(3);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		common.clickOnPintLoginFBbutton();
		common.facebookLogin("salmankhantc", "Dehradun1");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		SafeActions sf = new SafeActions(getDriver());
		sf.switchToWindow(1);
		Assert.assertTrue(listOption.ispintersetWindowPresent());

		getDriver().close();
		listHeader.switchToWindow(0);
	} // End of FloterSocialInfoPinterest

	/*
	 * Use-case : Add social chicklets to list header Test case : Go to a NON UL
	 * Blog list and verify that the twitter chicklets is there Click on twitter
	 * social chicklets
	 */
	@Test(priority = 43, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialBlogPinterest(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 43 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		ListOptionPage listOption = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl,
					"FloterSocialBlogPinterest");
		} else {
			listHeader = BaseState(voteUrl, "FloterSocialBlogPinterest");
		}
		listOption.clickOnheaderoption();
		listOption.clickOnheaderoptionpopup("View as Blog");
		listHeader.clickOnFloterSocialChicklets(3);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		common.clickOnPintLoginFBbutton();
		common.facebookLogin("salmankhantc", "Dehradun1");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		SafeActions sf = new SafeActions(getDriver());
		sf.switchToWindow(1);
		Assert.assertTrue(listOption.ispintersetWindowPresent());

		getDriver().close();
		listHeader.switchToWindow(0);
	} // End of FloterSocialBlogPinterest

	/*
	 * Use-case : Add social chicklets to list header Test case : Go to a NON UL
	 * SlideShow list and verify that the twitter chicklets is there Click on
	 * twitter social chicklets
	 */
	@Test(priority = 44, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FloterSocialSlidePinterest(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 44 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;
		ListOptionPage listOption = new ListOptionPage(getDriver());
		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(voteUrl,
					"FloterSocialSlidePinterest");
		} else {
			listHeader = BaseState(voteUrl, "FloterSocialSlidePinterest");
		}

		listOption.clickOnheaderoption();
		listOption.clickOnheaderoptionpopup("View as Slideshow");
		listHeader.clickOnFloterSocialChicklets(3);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		common.clickOnPintLoginFBbutton();
		common.facebookLogin("salmankhantc", "Dehradun1");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		SafeActions sf = new SafeActions(getDriver());
		sf.switchToWindow(1);
		Assert.assertTrue(listOption.ispintersetWindowPresent());

		getDriver().close();
		listHeader.switchToWindow(0);
	}// end of FloterSocialSlidePinterest

	/*
	 * Use-case : Next lists link Test case : "1) Open any Reference list 2)
	 * Click on any of the list links in ""Next 6:"" block appear below
	 * ""viewers of this list also saw""
	 */
	@Test(priority = 45, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void NextListLink(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 45 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		ListHeader listHeader = null;

		if (loginRequired.equals("YES")) {
			listHeader = BaseStateWithLogin(referenceUrl, "RerankButton");
		} else {
			listHeader = BaseState(referenceUrl, "RerankButton");
		}
		String[] before = listHeader
				.gethrefOfNextListLinkBelowViewerOfThisListAlsoSaw(1).split(
						"\\?");
		listHeader.clickNextListLinkBelowViewerOfThisListAlsoSaw(1);
		String[] after = getDriver().getCurrentUrl().split("\\?");
		if (after[0].contains("reference"))
			Assert.assertEquals(1, 1);
		else
			Assert.assertEquals(1, 0);
		Assert.assertEquals(before[0], after[0]);
	}// End of NextListLink

//	/*
//	 * Use-case : Check no.of items Test case : "Open any VoteRanked list"
//	 */
//	@Test(priority = 46, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void CheckNumberOfItems(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 46 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(
//					config.getProperty("Url")
//							+ "list/the-best-movies-roger-ebert-gave-four-stars/film-snob",
//					"RerankButton");
//		} else {
//			listHeader = BaseState(
//					config.getProperty("Url")
//							+ "list/the-best-movies-roger-ebert-gave-four-stars/film-snob",
//					"RerankButton");
//		}
//		listHeader.scrollToElement("50");
//		SafeActions s = new SafeActions(getDriver());
//		s.waitForPageToLoad(40);
//		Assert.assertTrue(listHeader.isNodePresent("100"));
//	}// End of CheckNumberOfItems
//
//	/*
//	 * Use-case : More lists block Test case : Open any list and click on list
//	 * links appear more list block appear at bottom of the page with section
//	 * title as "viewers of this list also saw"
//	 */
//	@Test(priority = 47, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void MoreListsBlock(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 47 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(referenceUrl, "RerankButton");
//		} else {
//			listHeader = BaseState(referenceUrl, "RerankButton");
//		}
//		int numberOfLinks = listHeader
//				.getNumberOfLinksInViewerOfThisListAlsoSawSection();
//		Assert.assertEquals(numberOfLinks, 6);
//		String[] before = listHeader.gethrefOfViewerOfThisListAlsoSaw(1).split(
//				"\\?");
//		listHeader.clickViewerOfThisListAlsoSaw(1);
//		String[] after = getDriver().getCurrentUrl().split("\\?");
//		Assert.assertEquals(before[0], after[0]);
//	}// End of MoreListsBlock
//
//	/*
//	 * Use-case : Top Queries block Test case : Open any list and click on
//	 * "Top Queries" links
//	 */
//	@Test(priority = 48, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void TopQueriesBlock(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 48 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(referenceUrl, "RerankButton");
//		} else {
//			listHeader = BaseState(referenceUrl, "RerankButton");
//		}
//		String before = listHeader.gethrefOfTopQueriesBlock(1);
//		listHeader.clickTopQueriesBlock(1);
//		if (getDriver().getCurrentUrl().contains(before))
//			Assert.assertEquals(1, 1);
//		else
//			Assert.assertEquals(1, 0);
//
//	}// End of TopQueriesBlock
//
//	/*
//	 * Use-case : Related lists Test case : Open any list and click on any one
//	 * of the list links in Related list block
//	 */
//	@Test(priority = 49, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void Relatedlists(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 49 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(referenceUrl, "Related lists");
//		} else {
//			listHeader = BaseState(referenceUrl, "Related lists");
//		}
//		Assert.assertTrue(listHeader.ispopularsBlockPresent());
//		String[] href = listHeader.gethrefOfpopularOfThisListblock(1).split(
//				"\\?");
//		listHeader.clickonpopularOfThisListblock(1);
//		String[] afterurl = getDriver().getCurrentUrl().split("\\?");
//		Assert.assertEquals(href[0], afterurl[0]);
//		getDriver().navigate().back();
//		try {
//			Thread.sleep(8000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		Assert.assertTrue(listHeader.isviewersBlockPresent());
//		String[] before = listHeader.gethrefOfViewerOfThisListAlsoSaw(1).split(
//				"\\?");
//		listHeader.clickViewerOfThisListAlsoSaw(1);
//		String[] after = getDriver().getCurrentUrl().split("\\?");
//		Assert.assertEquals(before[0], after[0]);
//
//	}// End of Relatedlists
//
//	/*
//	 * Use-case : Test Check box to display "Node Properties" in Blog views Test
//	 * case : 1) Open any list as a Admin 2) Under "Meta Data" check the Option
//	 * "Always display properties
//	 */
//	@Test(priority = 50, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void NodepropertiesInBlogSlideshow(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 50 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//		Grid grid = new Grid(getDriver());
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(referenceUrl, "Related lists");
//		} else {
//			listHeader = BaseState(referenceUrl, "NodepropertiesInBlog");
//		}
//
//		common.signin("vijaymohanp", "server");
//		listoptionpage.clickOnheaderoption();
//		listoptionpage.clickOnheaderoptionpopup("View as Blog");
//		grid.clickOnAdminStats(4);
//		grid.checkonmetalist(4);
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		// listHeader.AlertExistsAndAccepted(1000);
//		Assert.assertTrue(listHeader.ispropertyBlockinblogPresent());
//		listoptionpage.clickOnheaderoption();
//		listoptionpage.clickOnheaderoptionpopup("View as Slideshow");
//		Assert.assertTrue(listHeader.ispropertyBlockinslideshowPresent());
//		grid.clickOnAdminStats(4);
//		grid.checkonmetalist(4);
//		// grid.clickOneditlist(3);
//	}// End of NodepropertiesInBlog
//
//	/*
//	 * Use-case : Check voting Test case : Open any VoteRanked list and try
//	 * voting
//	 */
//	@Test(priority = 51, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void Checkvoting(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 51 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//		RerankPage rerankpage = new RerankPage(getDriver());
//		Grid grid = new Grid(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(
//					config.getProperty("Url")
//							+ "list/the-best-movies-roger-ebert-gave-four-stars/film-snob",
//					"Checkvoting");
//		} else {
//			listHeader = BaseState(
//					config.getProperty("Url")
//							+ "list/the-best-movies-roger-ebert-gave-four-stars/film-snob",
//					"Checkvoting");
//		}
//		String before = listHeader.getAttriOfvoteicon(1);
//		rerankpage.clickonvotebtn(1);
//		SafeActions s = new SafeActions(getDriver());
//		s.waitForPageToLoad(40);
//		String after = listHeader.getAttriOfvoteicon(1);
//		Assert.assertNotEquals(before, after);
//		s.waitForPageToLoad(20);
//		String downbefore = listHeader.getAttriOfvoteicon(1);
//		grid.clickDownvote("1");
//		String downafter = listHeader.getAttriOfvoteicon(1);
//		Assert.assertNotEquals(downbefore, downafter);
//	}// End of Checkvoting
//
//	/*
//	 * Use-case : Verify Pagination for monetizable Test case : 1) Open any
//	 * monetizable list and verify pagination
//	 */
//	@Test(priority = 52, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void PaginationforMonetizableList(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 52!!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//		Grid grid = new Grid(getDriver());
//		UeListPage ueList = new UeListPage(getDriver());
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(referenceUrl,
//					"PaginationforMonetizableList");
//		} else {
//			listHeader = BaseState(referenceUrl, "PaginationforMonetizableList");
//		}
//
//		common.signin("vijaymohanp", "server");
//		grid.clickOnAdminStats(3);
//		grid.clickOneditlist(4);
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		listHeader.selectTagsCheckBoxmonetizable();
//		ueList.clickOnDoneInAddTags();
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//		}
//		Assert.assertTrue(listHeader.ispaginationPresent());
//		Assert.assertEquals("rgba(254, 251, 199, 1)",
//				listHeader.getpaginationbackgrndColor());
//		grid.clickOnAdminStats(3);
//		grid.clickOneditlist(4);
//		listHeader.selectTagsCheckBoxmonetizable();
//		ueList.clickOnDoneInAddTags();
//		// grid.clickOneditlist(3);
//	}// End of PaginationforMonetizableList
//
//	/*
//	 * Use-case : Check embed option for HTML REFERRAL tagged slideshow lists
//	 * Test case : Should not see the 'embed' option all over the list, i.e
//	 * under more options and end of MLA
//	 */
//	@Test(priority = 53, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void Checkembedoption(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 53!!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//		Grid grid = new Grid(getDriver());
//		UeListPage ueList = new UeListPage(getDriver());
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(referenceUrl, "Checkembedoption");
//		} else {
//			listHeader = BaseState(referenceUrl, "Checkembedoption");
//		}
//
//		common.signin("vijaymohanp", "server");
//		Assert.assertTrue(listHeader.isembedtabPresent());
//		grid.clickOnAdminStats(3);
//		grid.clickOneditlist(4);
//		try {
//			Thread.sleep(8000);
//		} catch (Exception e) {
//		}
//		// listHeader.selectTagsCheckBoxHTMLReferral();
//		listHeader.selectTagsCheckBoxHTMLReferral();
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		ueList.clickOnDoneInAddTags();
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//		}
//		grid.clickOnAdminStats(9);
//		grid.clickOnresetsublist(2);
//		listHeader.AlertExistsAndAccepted(1000);
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		Assert.assertFalse(listHeader.isembedtabPresent());
//		grid.clickOnAdminStats(3);
//		grid.clickOneditlist(3);
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		ueList.clickonembedbtn();
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		ueList.clickOnpublishbtn();
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		grid.clickOnAdminStats(3);
//		grid.clickOneditlist(4);
//		listHeader.selectTagsCheckBoxHTMLReferral();
//		ueList.clickOnDoneInAddTags();
//	}// End of Checkembedoption
//
//	/*
//	 * Use-case : Add social chicklets to list header Test case : 1. Go to a UL
//	 * infostyle list and verify that the 4 chicklets are there. Click on all
//	 * social chicklets
//	 */
//	@Test(priority = 54, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void FloterSocialrefrencelistFB(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 54 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(config.getProperty("Url")
//					+ "list/best-r-rated-spy-film-movies/reference",
//					"FloterSocialrefrencelistFB");
//			// listHeader
//			// =BaseStateWithLogin(referenceUrl,"FloterSocialULInfoFB");
//		} else {
//			listHeader = BaseState(config.getProperty("Url")
//					+ "list/best-r-rated-spy-film-movies/reference",
//					"FloterSocialULInfoFB");
//		}
//		// UL info style list
//		// Facebook
//
//		listHeader.clickOnFloterSocialChicklets(1);
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//		}
//
//		common.facebookLogin("salmankhantc", "Dehradun1");
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//		}
//		Assert.assertTrue(listHeader.isPresentfacebookwindowpresent());
//		Assert.assertFalse(listHeader.isPresentfacebookErrorpresent());
//		getDriver().close();
//		listHeader.switchToWindow(0);
//	} // End of FloterSocialULInfoFB
//
//	/*
//	 * Use-case : Add social chicklets to list header Test case : 1. Go to a UL
//	 * infostyle list and verify that the twitter chicklets is there. Click on
//	 * all social chicklets
//	 */
//	@Test(priority = 55, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void FloterSocialrefrencelistTW(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 55 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//		ListOptionPage listOption = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(config.getProperty("Url")
//					+ "list/best-r-rated-spy-film-movies/reference",
//					"FloterSocialrefrencelistTW");
//			// listHeader
//			// =BaseStateWithLogin(referenceUrl,"FloterSocialULInfoFB");
//		} else {
//			listHeader = BaseState(config.getProperty("Url")
//					+ "list/best-r-rated-spy-film-movies/reference",
//					"FloterSocialrefrencelistTW");
//		}
//		// UL info style list
//		// Twitter
//		listHeader.clickOnFloterSocialChicklets(2);
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//		}
//		common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//		}
//		if (listOption.isPresenttiwtterlogin() == true) {
//			Assert.assertEquals(1, 1);
//		} else if (listHeader.isPresenttwitterwindowpresent()) {
//			Assert.assertEquals(1, 1);
//		} else {
//			Assert.assertEquals(1, 0);
//		}
//		getDriver().close();
//		listHeader.switchToWindow(0);
//	} // End of FloterSocialULInfoTW
//
//	/*
//	 * Use-case : Add social chicklets to list header Test case : Go to a NON UL
//	 * infostyle list and verify that the twitter chicklets is there Click on
//	 * twitter social chicklets
//	 */
//	@Test(priority = 56, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void FloterSocialrefrencelistPinterest(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 56 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//		ListOptionPage listOption = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(config.getProperty("Url")
//					+ "list/best-r-rated-spy-film-movies/reference",
//					"FloterSocialrefrencelistPinterest");
//			// listHeader
//			// =BaseStateWithLogin(referenceUrl,"FloterSocialULInfoFB");
//		} else {
//			listHeader = BaseState(config.getProperty("Url")
//					+ "list/best-r-rated-spy-film-movies/reference",
//					"FloterSocialrefrencelistPinterest");
//		}
//		listHeader.clickOnFloterSocialChicklets(3);
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//		}
//		common.clickOnPintLoginFBbutton();
//		common.facebookLogin("salmankhantc", "Dehradun1");
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		SafeActions sf = new SafeActions(getDriver());
//		sf.switchToWindow(1);
//		Assert.assertTrue(listOption.istiwtterWindowPresent());
//		getDriver().close();
//		listHeader.switchToWindow(0);
//	} // End of FloterSocialrefrencelistPinterest
//
//	/*
//	 * Use-case : Slide show Pagination: Button to slide first slide Test case :
//	 * This should take you to first slide of the list
//	 */
//	@Test(priority = 57, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void SlideFirstSlide(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 57 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//		Slideshow slideshow = new Slideshow(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(voteUrl, "SlideFirstSlide");
//		} else {
//			listHeader = BaseState(voteUrl, "SlideFirstSlide");
//		}
//		// Slideshow style list
//		common.signin("vijaymohanp", "server");
//		ListOptionPage listOption = new ListOptionPage(getDriver());
//		listOption.clickOnheaderoption();
//		listOption.clickOnheaderoptionpopup("View as Slideshow");
//		slideshow.clickOnSlide(5);
//		// browserWait();
//		slideshow.clickOnFirstSlideButton();
//		// browserWait();
//		String slideNo = slideshow.getSlideNo();
//		int slideIntegerAfter = Integer.parseInt(slideNo);
//		Assert.assertEquals(1, slideIntegerAfter);
//	}// End of SlideFirstSlide
//
//	/*
//	 * Use-case : Node tagged page Test case : Go to any node tagged page and
//	 * click on the next list button (should be on the last slide of slideshows;
//	 * currently doesn't exist on grid & blog).
//	 */
//	@Test(priority = 58, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void Nodetaggedpage(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 58 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//		int state = 0;
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(
//					config.getProperty("Url")
//							+ "list/actors-nobody-cares-about-anymore/ranker-celebrities?format=SLIDESHOW",
//					"Nodetaggedpage");
//			// listHeader
//			// =BaseStateWithLogin(referenceUrl,"FloterSocialULInfoFB");
//		} else {
//			listHeader = BaseState(
//					config.getProperty("Url")
//							+ "list/actors-nobody-cares-about-anymore/ranker-celebrities?format=SLIDESHOW",
//					"Nodetaggedpage");
//		}
//		ListOptionPage listOption = new ListOptionPage(getDriver());
//		listHeader.clickOnmoreInfoLink();
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		String before = listHeader.getTextOftagscategory();
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		// slideshow.clickNext();
//		listHeader.clickonnextlistfooter();
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		listHeader.clickOnmoreInfoLink();
//		for (int i = 1; i <= 5; i++) {
//			if (listHeader.getTextOfnextlisttags(i).equalsIgnoreCase("PEOPLE,")) {
//				state = 1;
//				break;
//
//			}
//		}
//		if (state == 1) {
//			Assert.assertEquals(1, 1);
//		} else {
//			Assert.assertEquals(1, 0);
//		}
//
//	}// End of SlideFirstSlide
//
//	/*
//	 * Use-case : Reranks Tab Test case : go to any ultimate list and click on
//	 * reranks btn and check whether the list opened does not match with the
//	 * list given.
//	 */
//	@Test(priority = 59, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void RerankTabOverlayCheck(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 59 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader;
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"RerankTabOverlayCheck");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl,
//					"RerankTabOverlayCheck");
//		}
//		// common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-10-worst-u-s-presidents");
//		common.votableLinkPresenceAndAccept();
//		String name1 = listHeader.getTextOfNodeInList("name");
//		listHeader.clickonrerankstab();
//		String name2 = listHeader.getTextOfrerankOverlayNode();
//		Assert.assertNotEquals(name1, name2);
//	} // end of RerankTabOverlayCheck
//
//	/*
//	 * Use-case : overlay Tab Test case : go to any ultimate list and click on
//	 * overlay tab named as age and check whether the node selected does not
//	 * match with the previous node before click .
//	 */
//	@Test(priority = 60, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void OverlayCheck(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 60 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//		int state = 0;
//		Slideshow slideshow = new Slideshow(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl, "overlayTab");
//
//		} else {
//			listHeader = BaseState(ultimateContributeUrl, "overlayTab");
//		}
//		listHeader.clickOverLaytab(2);
//		try {
//			Thread.sleep(9000);
//		} catch (Exception e) {
//		}
//		String beforeClick = listHeader.getTextOfrerankOverlayNode();
//		System.out.println("beforeClick" + beforeClick);
//		try {
//			Thread.sleep(8000);
//		} catch (Exception e) {
//		}
//		listHeader.clickOndropDownlist();
//		listHeader.clickOnselectdropdownOption();
//		try {
//			Thread.sleep(10000);
//		} catch (Exception e) {
//		}
//		String afterClick = listHeader.getTextOfrerankOverlayNode();
//		;
//		System.out.println("afterClick" + afterClick);
//		Assert.assertNotEquals(beforeClick, afterClick);
//	}// End of overlayTab
//
//	/*
//	 * Use-case : Verify "views" logic in list stats Test case : 1. Go to a list
//	 * with >=1000 views
//	 * http://www.ranker-stage.com/list/best-sportscenter-anchors
//	 * -of-all-time/surag 2. Check list stats 3. Go to a list with <1000 views
//	 * http://www.ranker-stage.com/list/the-best-movie-streaming-services/surag
//	 * 4. Check list stats
//	 */
//	@Test(priority = 61, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void ViewsLogicInListStats(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 61 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//		int state = 0;
//		ListOptionPage listOption = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(voteUrl, "ViewsLogicInListStats");
//			// listHeader
//			// =BaseStateWithLogin(referenceUrl,"FloterSocialULInfoFB");
//		} else {
//			listHeader = BaseState(voteUrl, "ViewsLogicInListStats");
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/best-sportscenter-anchors-of-all-time/surag");
//		if (listHeader.isStatsPresent(4)) {
//			String views = listHeader.getviewsinlist(5);
//			// System.out.println("views==="+views);
//			int view = Integer.parseInt(views.split("views")[0].replaceAll(",",
//					"").replaceAll(" ", ""));
//			// System.out.println("view==="+view);
//			if (1000 <= view)
//				state = 1;
//		}
//		if (state == 1) {
//			Assert.assertEquals(1, 1);
//		} else {
//			Assert.assertEquals(1, 0);
//		}
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/the-best-movie-streaming-services/surag");
//		if (listHeader.isStatsPresent(4) == false) {
//
//			state = 1;
//		}
//		if (state == 1) {
//			Assert.assertEquals(1, 1);
//		} else {
//			Assert.assertEquals(1, 0);
//		}
//	} // End of ViewsLogicInListStats
//
//	/*
//	 * Use-case : Verify ad_noads tag Test case : Open following list with admin
//	 * and Untag :"ad_noads" Eg: Info ex:
//	 * http://www.ranker.com/list/best-current-hbo-shows/ranker-tv Blog ex:
//	 * http://www.ranker-stage.com/list/annoying-instagram-cliches/jacob-shelton
//	 * Slideshow ex:
//	 * http://www.ranker-stage.com/list/hillary-clinton-facts/devon-ashby
//	 */
//	@Test(priority = 62, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void AdnoadsTagInInfo(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 62!!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//		Grid grid = new Grid(getDriver());
//		UeListPage ueList = new UeListPage(getDriver());
//		Nodepage nodePage = new Nodepage(getDriver());
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(referenceUrl, "AdnoadsTagInInfo");
//		} else {
//			listHeader = BaseState(referenceUrl, "AdnoadsTagInInfo");
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/best-current-hbo-shows/ranker-tv");
//		common.signin("vijaymohanp", "server");
//
//		Assert.assertTrue(nodePage.isPresentads1());
//		grid.clickOnAdminStats(3);
//		grid.clickOneditlist(4);
//		listHeader.clickOnaddnoads();
//		ueList.clickOnDoneInAddTags();
//		grid.clickOnAdminStats(9);
//		grid.clickOnresetsublist(2);
//		listHeader.AlertExistsAndAccepted(1000);
//		Assert.assertTrue(nodePage.isnotdisplayPresentads1());
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//		}
//		grid.clickOnAdminStats(3);
//		grid.clickOneditlist(4);
//		listHeader.clickOnaddnoads();
//		ueList.clickOnDoneInAddTags();
//		grid.clickOnAdminStats(9);
//		grid.clickOnresetsublist(2);
//		listHeader.AlertExistsAndAccepted(1000);
//	}// End of AdnoadsTagInInfo
//
//	/*
//	 * Use-case : Verify ad_noads tag Test case : Open following list with admin
//	 * and Untag :"ad_noads" Eg: Info ex:
//	 * http://www.ranker.com/list/best-current-hbo-shows/ranker-tv Blog ex:
//	 * http://www.ranker-stage.com/list/annoying-instagram-cliches/jacob-shelton
//	 * Slideshow ex:
//	 * http://www.ranker-stage.com/list/hillary-clinton-facts/devon-ashby
//	 */
//	@Test(priority = 63, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void AdnoadsTagInBlog(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 63!!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//		Grid grid = new Grid(getDriver());
//		UeListPage ueList = new UeListPage(getDriver());
//		Nodepage nodePage = new Nodepage(getDriver());
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(referenceUrl, "AdnoadsTagInBlog");
//		} else {
//			listHeader = BaseState(referenceUrl, "AdnoadsTagInBlog");
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/annoying-instagram-cliches/jacob-shelton");
//		common.signin("vijaymohanp", "server");
//		Assert.assertTrue(nodePage.isPresentads1());
//		grid.clickOnAdminStats(3);
//		grid.clickOneditlist(4);
//		listHeader.clickOnaddnoads();
//		ueList.clickOnDoneInAddTags();
//		grid.clickOnAdminStats(9);
//		grid.clickOnresetsublist(2);
//		listHeader.AlertExistsAndAccepted(1000);
//		Assert.assertTrue(nodePage.isnotdisplayPresentads1());
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//		}
//		grid.clickOnAdminStats(3);
//		grid.clickOneditlist(4);
//		listHeader.clickOnaddnoads();
//		ueList.clickOnDoneInAddTags();
//		grid.clickOnAdminStats(9);
//		grid.clickOnresetsublist(2);
//		listHeader.AlertExistsAndAccepted(1000);
//	}// End of AdnoadsTagInBlog
//
//	/*
//	 * Use-case : Verify ad_noads tag Test case : Open following list with admin
//	 * and Untag :"ad_noads" Eg: Info ex:
//	 * http://www.ranker.com/list/best-current-hbo-shows/ranker-tv Blog ex:
//	 * http://www.ranker-stage.com/list/annoying-instagram-cliches/jacob-shelton
//	 * Slideshow ex:
//	 * http://www.ranker-stage.com/list/hillary-clinton-facts/devon-ashby
//	 */
//	@Test(priority = 64, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void AdnoadsTagInSlideShow(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 64!!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//		Grid grid = new Grid(getDriver());
//		UeListPage ueList = new UeListPage(getDriver());
//		Nodepage nodePage = new Nodepage(getDriver());
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(referenceUrl,
//					"AdnoadsTagInSlideShow");
//		} else {
//			listHeader = BaseState(referenceUrl, "AdnoadsTagInSlideShow");
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/annoying-instagram-cliches/jacob-shelton");
//		common.signin("vijaymohanp", "server");
//		Assert.assertTrue(nodePage.isPresentads1());
//		grid.clickOnAdminStats(3);
//		grid.clickOneditlist(4);
//		listHeader.clickOnaddnoads();
//		ueList.clickOnDoneInAddTags();
//		grid.clickOnAdminStats(9);
//		grid.clickOnresetsublist(2);
//		listHeader.AlertExistsAndAccepted(1000);
//		Assert.assertTrue(nodePage.isnotdisplayPresentads1());
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//		}
//		grid.clickOnAdminStats(3);
//		grid.clickOneditlist(4);
//		listHeader.clickOnaddnoads();
//		ueList.clickOnDoneInAddTags();
//		grid.clickOnAdminStats(9);
//		grid.clickOnresetsublist(2);
//		listHeader.AlertExistsAndAccepted(1000);
//	}// End of AdnoadsTagInSlideShow
//
//	/*
//	 * Use-case : Remove the expander icon when it's an authored node Test case
//	 * : Go to a list that has only system nodes (ex:
//	 * http://www.ranker-stage.com/list/best-r-rated-spy-film-movies/reference),
//	 * only authored nodes
//	 * (ex:http://www.ranker-stage.com/list/annoying-foodie-words
//	 * /jacob-shelton), and both system and authored nodes (ex:
//	 * http://www.ranker-stage.com/list/best-2015-nfl-draft-prospects/surag).
//	 */
//	@Test(priority = 65, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void ExpanderIconInSystemNode(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 65 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader;
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"ExpanderIconInSystemNode");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl,
//					"ExpanderIconInSystemNode");
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/best-r-rated-spy-film-movies/reference");
//		common.signin("testuserkallol1@mailinator.com", "testing");
//		// try {
//		// Thread.sleep(2000);
//		// } catch (Exception e) {
//		// }
//		Assert.assertTrue(listHeader.isExpandiconPresentInlist(1));
//		listoptionpage.putTextInAddListBox("testing");
//		listoptionpage.clickOnAddSearchItem();
//		// try{
//		// Thread.sleep(5000);
//		// }catch(Exception e){}
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
//		Assert.assertFalse(listHeader.isExpandiconPresent());
//		listoptionpage.clickOndeletelist("delete");
//
//	} // end of ExpanderIconInSystemNode
//
//	/*
//	 * Use-case : Add sticky after item is added to list Test case : 1 Go to any
//	 * open list :
//	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film?
//	 * vote list :
//	 * http://www.ranker-stage.com/list/best-bands-fronted-by-famous-
//	 * actors/ranker-music 2 Open non-votable list :
//	 * http://www.ranker-stage.com/
//	 * list/smartest-famous-people/celebrity-lists?page=2
//	 */
//	@Test(priority = 66, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void ItemAddedInVoteList(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 66 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader;
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"ItemAddedInVoteList");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl, "ItemAddedInVoteList");
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/best-r-rated-spy-film-movies/reference");
//		common.signin("testuserkallol1@mailinator.com", "testing");
//		// try {
//		// Thread.sleep(2000);
//		// } catch (Exception e) {
//		// }
//		listoptionpage.putTextInAddListBox("testing");
//		listoptionpage.clickOnAddSearchItem();
//		// try{
//		// Thread.sleep(5000);
//		// }catch(Exception e){}
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
//		Assert.assertTrue(listHeader.isStickeyInlistPresent());
//		listoptionpage.clickOndeletelist("delete");
//
//	} // end of ItemAddedInVoteList
//
//	/*
//	 * Use-case : Add sticky after item is added to list Test case : 1 Go to any
//	 * open list :
//	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film?
//	 * vote list :
//	 * http://www.ranker-stage.com/list/best-bands-fronted-by-famous-
//	 * actors/ranker-music 2 Open non-votable list :
//	 * http://www.ranker-stage.com/
//	 * list/smartest-famous-people/celebrity-lists?page=2
//	 */
//	@Test(priority = 67, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void ItemAddedInNonVoteList(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 67 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader;
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"ItemAddedInNonVoteList");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl,
//					"ItemAddedInNonVoteList");
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/smartest-famous-people/celebrity-lists?page=2");
//		common.signin("testuserkallol1@mailinator.com", "testing");
//		// try {
//		// Thread.sleep(2000);
//		// } catch (Exception e) {
//		// }
//		listoptionpage.putTextInAddListBox("testing");
//		listoptionpage.clickOnAddSearchItem();
//		// try{
//		// Thread.sleep(5000);
//		// }catch(Exception e){}
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
//		Assert.assertTrue(listHeader.ischickletsPresent());
//		Assert.assertFalse(listHeader.isStickeyInlistPresent());
//		listoptionpage.clickOndeletelist("delete");
//	} // end of ItemAddedInNonVoteList
//
//	/*
//	 * Use-case : Remove the expander icon when it's an authored node Test case
//	 * : Go to a list that has only system nodes (ex:
//	 * http://www.ranker-stage.com/list/best-r-rated-spy-film-movies/reference),
//	 * only authored nodes
//	 * (ex:http://www.ranker-stage.com/list/annoying-foodie-words
//	 * /jacob-shelton), and both system and authored nodes (ex:
//	 * http://www.ranker-stage.com/list/best-2015-nfl-draft-prospects/surag).
//	 */
//	@Test(priority = 68, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void ExpanderIconInAuthoredNode(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 68 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader;
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"ExpanderIconInAuthoredNode");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl,
//					"ExpanderIconInAuthoredNode");
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/annoying-foodie-words/jacob-shelton");
//		common.signin("testuserkallol1@mailinator.com", "testing");
//		// try {
//		// Thread.sleep(2000);
//		// } catch (Exception e) {
//		// }
//		Assert.assertTrue(listHeader.isExpandiconPresentInlist(1));
//		listoptionpage.putTextInAddListBox("testing");
//		listoptionpage.clickOnAddSearchItem();
//		// try{
//		// Thread.sleep(5000);
//		// }catch(Exception e){}
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
//		Assert.assertFalse(listHeader.isExpandiconPresent());
//		listoptionpage.clickOndeletelist("delete");
//
//	} // end of ExpanderIconInAuthoredNode
//
//	/*
//	 * Use-case : Remove the expander icon when it's an authored node Test case
//	 * : Go to a list that has only system nodes (ex:
//	 * http://www.ranker-stage.com/list/best-r-rated-spy-film-movies/reference),
//	 * only authored nodes
//	 * (ex:http://www.ranker-stage.com/list/annoying-foodie-words
//	 * /jacob-shelton), and both system and authored nodes (ex:
//	 * http://www.ranker-stage.com/list/best-2015-nfl-draft-prospects/surag).
//	 */
//	@Test(priority = 69, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void ExpanderIconInSystemAndAuthoredNode(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 69 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader;
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"ExpanderIconInSystemAndAuthoredNode");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl,
//					"ExpanderIconInSystemAndAuthoredNode");
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/best-2015-nfl-draft-prospects/surag");
//		common.signin("testuserkallol1@mailinator.com", "testing");
//		// try {
//		// Thread.sleep(2000);
//		// } catch (Exception e) {
//		// }
//		Assert.assertTrue(listHeader.isExpandiconPresentInlist(1));
//		listoptionpage.putTextInAddListBox("testing");
//		listoptionpage.clickOnAddSearchItem();
//		// try{
//		// Thread.sleep(5000);
//		// }catch(Exception e){}
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
//				Thread.sleep(2000);
//			} catch (Exception e) {
//			}
//			listoptionpage.clickOnvideoSelectButton();
//			listoptionpage.clickOnDoneButton();
//			try {
//				Thread.sleep(3000);
//			} catch (Exception e) {
//			}
//		} else {
//			Assert.fail("youtube video is not being working");
//		}
//		Assert.assertFalse(listHeader.isExpandiconPresent());
//		listoptionpage.clickOndeletelist("delete");
//
//	} // end of ExpanderIconInSystemAndAuthoredNode
//
//	/*
//	 * Use-case : Add "originally by" and original username to Ultimate Lists
//	 * Test case : Open various ultimate lists (ex:
//	 * http://www.ranker-stage.com/list/famous-women-beer-list/greg).
//	 */
//	@Test(priority = 70, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void OriginallyByuserName(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 70 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(referenceUrl,
//					"OriginallyByuserName");
//		} else {
//			listHeader = BaseState(referenceUrl, "OriginallyByuserName");
//		}
//
//		common.getNewURL(config.getProperty("Url")
//				+ "list/famous-women-beer-list/greg");
//		Assert.assertTrue(listHeader.isusernamePresent());
//	}// End of OriginallyByuserName
//
//	/*
//	 * Use-case : Verify admin is able to see list ID in the input text box on
//	 * the admin bar Test case :1) Go to any list logged in as an admin 2) Click
//	 * on the the List id in the input text box in the admin bar
//	 */
//	@Test(priority = 71, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void ListIdInputBox(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 71 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(voteUrl, "ListIdInputBox");
//		} else {
//			listHeader = BaseState(voteUrl, "ListIdInputBox");
//		}
//		common.signin("vijaymohanp", "server");
//		Assert.assertTrue(listHeader.isInputListBoxPresent());
//		listHeader.clickOnInputListBox();
//		Assert.assertEquals("rgba(51, 51, 51, 1)",
//				listHeader.getColorOfInputListBox());
//	}// End of ListIdInputBox
//
//	/*
//	 * Use-case : Verify Changed name of ROI scores in Admin bar Test case :1)
//	 * Log in as an admin 2) Go to any list 3) Click on STATS in the admin bar,
//	 */
//	@Test(priority = 72, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void ROIScores(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 72 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(voteUrl, "ROIScores");
//		} else {
//			listHeader = BaseState(voteUrl, "ROIScores");
//		}
//		common.signin("vijaymohanp", "server");
//		Grid grid = new Grid(getDriver());
//		grid.clickOnAdminStats(8);
//		grid.clickOnSubStats(1);
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		Assert.assertTrue(listHeader.isRLSubstatsPresent());
//		grid.clickOnClose();
//		grid.clickOnAdminStats(8);
//		grid.clickOnSubStats(2);
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		Assert.assertTrue(listHeader.isROISubstatsPresent());
//		grid.clickOnClose();
//	}// End of ROIScores
//
//	/*
//	 * Use-case : Node expand when click on full row area Test case :Open :
//	 * http:
//	 * //www.ranker-stage.com/list/best-deceased-saturday-night-live-cast-member
//	 * /lanayoshii Click on Node row area
//	 */
//	@Test(priority = 73, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void NodeExpand(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 73 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl, "NodeExpand");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl, "NodeExpand");
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/best-deceased-saturday-night-live-cast-member/lanayoshii");
//		listHeader.clickOnExpandiconInlist(1);
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		Assert.assertTrue(listHeader.isExpandiconPresent());
//	}// End of NodeExpand
//
//	/*
//	 * Use-case : Verify links in blather open in a new tab/window Test case
//	 * :Open : 1) Go to any list with external link in blather eg
//	 * http://www.ranker
//	 * -stage.com/list/the-top-8-celebrities-killed-by-the-internet/ivana-wynn
//	 * 2) Scroll down to blather and click on source link
//	 */
//	@Test(priority = 74, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void BlatherNewTab(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 74 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"BlatherNewTab");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl, "BlatherNewTab");
//		}
//
//		common.getNewURL(config.getProperty("Url")
//				+ "list/the-top-8-celebrities-killed-by-the-internet/ivana-wynn");
//		String href = listHeader.gethrefOfBlatherSource();
//		listHeader.clickOnBlatherSource();
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//		}
//		ArrayList<String> tabs2 = new ArrayList<String>(getDriver()
//				.getWindowHandles());
//		getDriver().switchTo().window(tabs2.get(1));
//		String afterurl = getDriver().getCurrentUrl();
//		Assert.assertEquals(afterurl, href);
//		getDriver().close();
//		getDriver().switchTo().window(tabs2.get(0));
//	}// End of BlatherNewTab
//
//	/*
//	 * Use-case : Admin Bar: Add setting to display on INFO contracted state
//	 * Test case : 1. Go to an infostyle list Eg:
//	 * http://www.ranker-stage.com/crowdranked
//	 * -list/the-u-s-presidents-from-best-to-worst 2. Verify new setting
//	 * "show wiki in closed state on infostyle" with a checkbox in
//	 * "List Actions"
//	 */
//	@Test(priority = 75, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void CheckWikiDisplay(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 75 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"CheckWikiDisplay");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl, "CheckWikiDisplay");
//		}
//		Grid grid = new Grid(getDriver());
//		common.getNewURL(config.getProperty("Url")
//				+ "list/who-should-host-oscars-2016/ranker-film");
//		common.signin("vijaymohanp", "server");
//		grid.clickOnAdminStats(5);
//		listHeader.clickOnshowWiki();
//		listHeader.AlertExistsAndAccepted(2000);
//		grid.clickOnAdminStats(9);
//		grid.clickOnresetsublist(2);
//		listHeader.AlertExistsAndAccepted(2000);
//		Assert.assertTrue(listHeader.isFirstnodetextPresent());
//		grid.clickOnAdminStats(5);
//		listHeader.clickOnshowWiki();
//		listHeader.AlertExistsAndAccepted(2000);
//		grid.clickOnAdminStats(9);
//		grid.clickOnresetsublist(2);
//		listHeader.AlertExistsAndAccepted(2000);
//		Assert.assertFalse(listHeader.isFirstnodetextPresent());
//	}// End of CheckWikiDisplay
//
//	/*
//	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
//	 * open list :
//	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
//	 * Add any item 2-Similary add item in vote list :
//	 * http://www.ranker-stage.com
//	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
//	 * non-votable list :
//	 * http://www.ranker-stage.com/list/smartest-famous-people
//	 * /celebrity-lists?page=2
//	 */
//	@Test(priority = 76, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void AddSocialChickletsFacebookInOpenList(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 76 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader;
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"AddSocialChickletsFacebookInOpenList");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl,
//					"AddSocialChickletsFacebookInOpenList");
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/who-should-host-oscars-2016/ranker-film");
//		common.signin("testuserkallol1@mailinator.com", "testing");
//		listoptionpage.putTextInAddListBox("testing");
//		listoptionpage.clickOnAddSearchItem();
//		listoptionpage.clickoneditsubvideoIcon();
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
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		Assert.assertTrue(listHeader.ischickletsPresent());
//		// facebook
//		listHeader.clickOnsocialchicklets(1);
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		common.facebookLogin("salmankhantc", "Dehradun1");
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//
//		Assert.assertTrue(listHeader.isPresentfacebookwindowpresent());
//		Assert.assertFalse(listHeader.isPresentfacebookErrorpresent());
//		getDriver().close();
//		listoptionpage.switchToParentWindow();
//		listoptionpage.clickOndeletelist("delete");
//		//
//	} // end of AddSocialChickletsFacebookInOpenList
//
//	/*
//	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
//	 * open list :
//	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
//	 * Add any item 2-Similary add item in vote list :
//	 * http://www.ranker-stage.com
//	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
//	 * non-votable list :
//	 * http://www.ranker-stage.com/list/smartest-famous-people
//	 * /celebrity-lists?page=2
//	 */
//	@Test(priority = 77, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void AddSocialChickletsTwitterInOpenList(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 77 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader;
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"AddSocialChickletsTwitterInOpenList");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl,
//					"AddSocialChickletsTwitterInOpenList");
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/who-should-host-oscars-2016/ranker-film");
//		common.signin("testuserkallol1@mailinator.com", "testing");
//		listoptionpage.putTextInAddListBox("testing");
//		listoptionpage.clickOnAddSearchItem();
//		listoptionpage.clickoneditsubvideoIcon();
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
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		Assert.assertTrue(listHeader.ischickletsPresent());
//
//		// twitter
//		listHeader.clickOnsocialchicklets(2);
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//		}
//		if (listoptionpage.isPresenttiwtterlogin() == true) {
//			Assert.assertEquals(1, 1);
//		} else if (listHeader.isPresenttwitterwindowpresent()) {
//			Assert.assertEquals(1, 1);
//		} else {
//			Assert.assertEquals(1, 0);
//		}
//		getDriver().close();
//		listoptionpage.switchToParentWindow();
//		listoptionpage.clickOndeletelist("delete");
//
//	} // end of AddSocialChickletsTwitterInOpenList
//
//	/*
//	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
//	 * open list :
//	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
//	 * Add any item 2-Similary add item in vote list :
//	 * http://www.ranker-stage.com
//	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
//	 * non-votable list :
//	 * http://www.ranker-stage.com/list/smartest-famous-people
//	 * /celebrity-lists?page=2
//	 */
//	@Test(priority = 78, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void AddSocialChickletsPinterestInOpenList(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 78 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader;
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"AddSocialChickletsPinterestInOpenList");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl,
//					"AddSocialChickletsPinterestInOpenList");
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/who-should-host-oscars-2016/ranker-film");
//		common.signin("testuserkallol1@mailinator.com", "testing");
//		listoptionpage.putTextInAddListBox("testing");
//		listoptionpage.clickOnAddSearchItem();
//		listoptionpage.clickoneditsubvideoIcon();
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
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		Assert.assertTrue(listHeader.ischickletsPresent());
//		// pinterest
//		listHeader.clickOnsocialchicklets(3);
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		common.clickOnPintLoginFBbutton();
//		common.facebookLogin("salmankhantc", "Dehradun1");
//		SafeActions sf1 = new SafeActions(getDriver());
//		sf1.switchToWindow(1);
//		Assert.assertTrue(listoptionpage.istiwtterWindowPresent());
//		getDriver().close();
//		listoptionpage.switchToParentWindow();
//		listoptionpage.clickOndeletelist("delete");
//
//	} // end of AddSocialChickletsPinterestInOpenList
//
//	/*
//	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
//	 * open list :
//	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
//	 * Add any item 2-Similary add item in vote list :
//	 * http://www.ranker-stage.com
//	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
//	 * non-votable list :
//	 * http://www.ranker-stage.com/list/smartest-famous-people
//	 * /celebrity-lists?page=2
//	 */
//	@Test(priority = 79, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void AddItemsFacebookInVoteList(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 79 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader;
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"AddItemsFacebookInVoteList");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl,
//					"AddItemsFacebookInVoteList");
//		}
//		common.getNewURL(config.getProperty("Url")+ "list/best-bands-fronted-by-famous-actors/ranker-music");
//		common.signin("testuserkallol1@mailinator.com", "testing");
//		listoptionpage.putTextInAddListBox("testing");
//		listoptionpage.clickOnAddSearchItem();
//		listoptionpage.clickoneditsubvideoIcon();
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
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		Assert.assertTrue(listHeader.ischickletsPresent());
//		// facebook
//		listHeader.clickOnsocialchicklets(1);
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		common.facebookLogin("salmankhantc", "Dehradun1");
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//
//		Assert.assertTrue(listHeader.isPresentfacebookwindowpresent());
//		Assert.assertFalse(listHeader.isPresentfacebookErrorpresent());
//		getDriver().close();
//		listoptionpage.switchToParentWindow();
//		listoptionpage.clickOndeletelist("delete");
//		//
//	} // end of AddItemsFacebookInVoteList
//
//	/*
//	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
//	 * open list :
//	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
//	 * Add any item 2-Similary add item in vote list :
//	 * http://www.ranker-stage.com
//	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
//	 * non-votable list :
//	 * http://www.ranker-stage.com/list/smartest-famous-people
//	 * /celebrity-lists?page=2
//	 */
//	@Test(priority = 80, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void AddItemsTwitterInVoteList(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 80 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader;
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"AddItemsTwitterInVoteList");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl,
//					"AddItemsTwitterInVoteList");
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/who-should-host-oscars-2016/ranker-film");
//		common.signin("testuserkallol1@mailinator.com", "testing");
//		listoptionpage.putTextInAddListBox("testing");
//		listoptionpage.clickOnAddSearchItem();
//		listoptionpage.clickoneditsubvideoIcon();
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
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		Assert.assertTrue(listHeader.ischickletsPresent());
//
//		// twitter
//		listHeader.clickOnsocialchicklets(2);
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//		}
//		if (listoptionpage.isPresenttiwtterlogin() == true) {
//			Assert.assertEquals(1, 1);
//		} else if (listHeader.isPresenttwitterwindowpresent()) {
//			Assert.assertEquals(1, 1);
//		} else {
//			Assert.assertEquals(1, 0);
//		}
//		getDriver().close();
//		listoptionpage.switchToParentWindow();
//		listoptionpage.clickOndeletelist("delete");
//
//	} // end of AddItemsTwitterInVoteList
//
//	/*
//	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
//	 * open list :
//	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
//	 * Add any item 2-Similary add item in vote list :
//	 * http://www.ranker-stage.com
//	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
//	 * non-votable list :
//	 * http://www.ranker-stage.com/list/smartest-famous-people
//	 * /celebrity-lists?page=2
//	 */
//	@Test(priority = 81, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void AddItemsPinterestInVoteList(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 81 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader;
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"AddItemsPinterestInVoteList");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl,
//					"AddItemsPinterestInVoteList");
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/who-should-host-oscars-2016/ranker-film");
//		common.signin("testuserkallol1@mailinator.com", "testing");
//		listoptionpage.putTextInAddListBox("testing");
//		listoptionpage.clickOnAddSearchItem();
//		listoptionpage.clickoneditsubvideoIcon();
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
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		Assert.assertTrue(listHeader.ischickletsPresent());
//		// pinterest
//		listHeader.clickOnsocialchicklets(3);
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		common.clickOnPintLoginFBbutton();
//		common.facebookLogin("salmankhantc", "Dehradun1");
//		SafeActions sf1 = new SafeActions(getDriver());
//		sf1.switchToWindow(1);
//		Assert.assertTrue(listoptionpage.istiwtterWindowPresent());
//		getDriver().close();
//		listoptionpage.switchToParentWindow();
//		listoptionpage.clickOndeletelist("delete");
//
//	} // end of AddItemsPinterestInVoteList
//
//	/*
//	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
//	 * open list :
//	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
//	 * Add any item 2-Similary add item in vote list :
//	 * http://www.ranker-stage.com
//	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
//	 * non-votable list :
//	 * http://www.ranker-stage.com/list/smartest-famous-people
//	 * /celebrity-lists?page=2
//	 */
//	@Test(priority = 82, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void AddItemsFacebookInNonVoteList(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 79 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader;
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"AddItemsFacebookInNonVoteList");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl,
//					"AddItemsFacebookInNonVoteList");
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/smartest-famous-people/celebrity-lists?page=2");
//		common.signin("testuserkallol1@mailinator.com", "testing");
//		listoptionpage.putTextInAddListBox("testing");
//		listoptionpage.clickOnAddSearchItem();
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		Assert.assertTrue(listHeader.ischickletsPresent());
//		// facebook
//		listHeader.clickOnsocialchicklets(1);
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		common.facebookLogin("salmankhantc", "Dehradun1");
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//
//		Assert.assertTrue(listHeader.isPresentfacebookwindowpresent());
//		Assert.assertFalse(listHeader.isPresentfacebookErrorpresent());
//		getDriver().close();
//		listoptionpage.switchToParentWindow();
//		listoptionpage.clickOndeletelist("delete");
//		//
//	} // end of AddItemsFacebookInVoteList
//
//	/*
//	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
//	 * open list :
//	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
//	 * Add any item 2-Similary add item in vote list :
//	 * http://www.ranker-stage.com
//	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
//	 * non-votable list :
//	 * http://www.ranker-stage.com/list/smartest-famous-people
//	 * /celebrity-lists?page=2
//	 */
//	@Test(priority = 83, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void AddItemsTwitterInNonVoteList(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 80 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader;
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,"AddItemsTwitterInNonVoteList");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl,"AddItemsTwitterInNonVoteList");
//		}
//		common.getNewURL(config.getProperty("Url")+ "list/smartest-famous-people/celebrity-lists?page=2");
//		common.signin("testuserkallol1@mailinator.com", "testing");
//		listoptionpage.putTextInAddListBox("testing");
//		listoptionpage.clickOnAddSearchItem();
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		Assert.assertTrue(listHeader.ischickletsPresent());
//
//		// twitter
//		listHeader.clickOnsocialchicklets(2);
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//		}
//		if (listoptionpage.isPresenttiwtterlogin() == true) {
//			Assert.assertEquals(1, 1);
//		} else if (listHeader.isPresenttwitterwindowpresent()) {
//			Assert.assertEquals(1, 1);
//		} else {
//			Assert.assertEquals(1, 0);
//		}
//		getDriver().close();
//		listoptionpage.switchToParentWindow();
//		listoptionpage.clickOndeletelist("delete");
//
//	} // end of AddItemsTwitterInNonVoteList
//
//	/*
//	 * Use-case : Add social chicklets to items you own Test case : 1-Go to any
//	 * open list :
//	 * http://www.ranker-stage.com/list/who-should-host-oscars-2016/ranker-film
//	 * Add any item 2-Similary add item in vote list :
//	 * http://www.ranker-stage.com
//	 * /list/best-bands-fronted-by-famous-actors/ranker-music 3-Add item on
//	 * non-votable list :
//	 * http://www.ranker-stage.com/list/smartest-famous-people
//	 * /celebrity-lists?page=2
//	 */
//	@Test(priority = 84, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void AddItemsPinterestInNonVoteList(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 81 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader;
//		ListOptionPage listoptionpage = new ListOptionPage(getDriver());
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"AddItemsPinterestInNonVoteList");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl,
//					"AddItemsPinterestInNonVoteList");
//		}
//		common.getNewURL(config.getProperty("Url")
//				+ "list/smartest-famous-people/celebrity-lists?page=2");
//		common.signin("testuserkallol1@mailinator.com", "testing");
//		listoptionpage.putTextInAddListBox("testing");
//		listoptionpage.clickOnAddSearchItem();
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		Assert.assertTrue(listHeader.ischickletsPresent());
//		// pinterest
//		listHeader.clickOnsocialchicklets(3);
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		common.clickOnPintLoginFBbutton();
//		common.facebookLogin("salmankhantc", "Dehradun1");
//		SafeActions sf1 = new SafeActions(getDriver());
//		sf1.switchToWindow(1);
//		Assert.assertTrue(listoptionpage.istiwtterWindowPresent());
//		getDriver().close();
//		listoptionpage.switchToParentWindow();
//		listoptionpage.clickOndeletelist("delete");
//
//	} // end of AddItemsPinterestInNonVoteList
//
//	/*
//	 * Use-case : Remove next list link on yellow pagination strip for
//	 * monetizable tagged lists Test case : Open any monetizable list :
//	 * http://www
//	 * .ranker-stage.com/crowdranked-list/most-influential-djs-of-all-time
//	 * Scroll down to list footer
//	 */
//	@Test(priority = 85, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void MonetizableTaggedLists(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 85 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"MonetizableTaggedLists");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl,
//					"MonetizableTaggedLists");
//		}
//		UeListPage ueList = new UeListPage(getDriver());
//		Grid grid = new Grid(getDriver());
//		common.getNewURL(config.getProperty("Url")
//				+ "crowdranked-list/most-influential-djs-of-all-time");
//		common.signin("vijaymohanp", "server");
//		grid.clickOnAdminStats(3);
//		grid.clickOneditlist(4);
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		listHeader.selectTagsCheckBoxmonetizable();
//		ueList.clickOnDoneInAddTags();
//		grid.clickOnAdminStats(9);
//		grid.clickOnresetsublist(2);
//		listHeader.AlertExistsAndAccepted(2000);
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//		}
//		Assert.assertTrue(listHeader.isnextFooterPresent());
//		grid.clickOnAdminStats(3);
//		grid.clickOneditlist(4);
//		try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//		}
//		listHeader.selectTagsCheckBoxmonetizable();
//		ueList.clickOnDoneInAddTags();
//		grid.clickOnAdminStats(9);
//		grid.clickOnresetsublist(2);
//		listHeader.AlertExistsAndAccepted(2000);
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//		}
//		Assert.assertFalse(listHeader.isnextFooterPresent());
//	}// End of MonetizableTaggedLists
//	/*
//	 * Use-case : update to keywords display on list pages Test case : Open list
//	 * : http://www.ranker-stage.com/crowdranked-list/the-most-influential-
//	 * contemporary-americans with admin Click on metadata Click on View top
//	 * keywords
//	 */
//	@Test(priority = 86, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void KeywordsDisplay(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 86 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,
//					"KeywordsDisplay");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl, "KeywordsDisplay");
//		}
//		UeListPage ueList = new UeListPage(getDriver());
//		Grid grid = new Grid(getDriver());
//		common.getNewURL(config.getProperty("Url")
//				+ "crowdranked-list/the-most-influential-contemporary-americans");
//		common.signin("vijaymohanp", "server");
//		grid.clickOnAdminStats(4);
//		listHeader.clickOnViewTopkeywords();
//		Assert.assertTrue(listHeader.isSourcePresent());
//	}// End of KeywordsDisplay
//	/*
//	 * Use-case : Interstitial NSFW Page
//	 * Test case: Open any nsfw interstitial page on desktop (ex: http://www.ranker-stage.com/relatedcontent/1448628)
//	 */
//	@Test(priority = 87, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void InterstitialNSFWPage(String loginRequired) {
//		System.out
//				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 87 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		ListHeader listHeader = null;
//
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,"InterstitialNSFWPage");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl, "InterstitialNSFWPage");
//		}
//		UeListPage ueList = new UeListPage(getDriver());
//		Grid grid = new Grid(getDriver());
//		common.getNewURL(config.getProperty("Url")+ "relatedcontent/1448628");
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//		}
//		String largerblock[]=listHeader.getWidthoflargerblock().split("px");
//		int largerwidth=Integer.parseInt(largerblock[0]);
//		for(int i=1;i<=4;i++){
//		String smallblock[]=listHeader.getWidthofsmallblock(i).split("px");
//		int smallwidth=Integer.parseInt(smallblock[0]);
//		if(largerwidth>smallwidth){
//			Assert.assertEquals(1, 1);
//		}
//		else
//			Assert.assertEquals(1, 0);	
//		}
//	}// End of InterstitialNSFWPage
//	
//	/*
//	 * Use-case : UE: Disable image uploads on rereanks if disabled on original/ultimate list
//	 *  Test case : Open Ul list: http://www.ranker-stage.com/crowdranked-list/the-most-influential-contemporary-americans?
//				   Which has image upload is disabled
//				  Rerank it and open reranked list from non-admin user in UE
//				  1 Try to upload image on list items and list
//				  2 Now add item through open list and try to upload image
//	 */
//	@Test(priority = 88, dataProviderClass = DataProviders.class, dataProvider = "Login")
//	public void DisableImageUploadsOnRereank(String loginRequired) {
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 88 !!!!!!!!!!!!!!!!!!!!!!!");
//		// Base state. (Navigate to node page)
//		RerankPage rerankpage = new RerankPage (getDriver());
//		UeListPage ueList = new UeListPage(getDriver()); 
//		Grid grid = new Grid(getDriver());
//		Home home = new Home(getDriver());
//		ListHeader listHeader = null;
//		if (loginRequired.equals("YES")) {
//			listHeader = BaseStateWithLogin(ultimateContributeUrl,"DisableImageUploadsOnRereank");
//		} else {
//			listHeader = BaseState(ultimateContributeUrl,"DisableImageUploadsOnRereank");
//		}
//		common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-most-influential-contemporary-americans?");
//		common.signin("vijaymohanp", "server");
//		listHeader.cancelLoading();
//		System.out.println("11111111111111");
//		 grid.clickOnAdminStats(5);
//		 System.out.println("22222222222222");
//		 grid.clickOnsubStatsListaction(7);
//		 System.out.println("33333333333333");
//		 listHeader.AlertExistsAndAccepted(1000);
//		 System.out.println("444444444444444444");
////		 grid.clickOnresetsublist(2);
////		 listHeader.AlertExistsAndAccepted(1000);
//		 listHeader.cancelLoading();
//		 home.doLogout();
//	        
//	  		common.signin("testuserkallol1@mailinator.com", "testing");
//	  		 try {
//					Thread.sleep(3000);
//				} catch (Exception e) {}
//         rerankpage.clickOnrerankbtn();
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//		}
//		rerankpage.hoverOneditIcon(1);
//		rerankpage.stickyLikePresenceAndAccept();
//		rerankpage.clickoneditimageoption();
//		try {
//			Thread.sleep(2000);
//		} catch (Exception e) {
//		}
//		Assert.assertFalse(listHeader.isPresentuploadimage());
//		grid.clickOnAdminStats(5);
//		 grid.clickOnsubStatsListaction(7);
//		 listHeader.AlertExistsAndAccepted(1000);
//		 grid.clickOnresetsublist(2);
//		 listHeader.AlertExistsAndAccepted(1000);
////		String beforesrc = rerankpage.getsrcedititemsadd(1);
////		String[] substring = beforesrc.split("/");
////		rerankpage.clickonedititemsaddoption(1);
////		try {
////			Thread.sleep(5000);
////		} catch (Exception e) {
////		}
////
////		// substring[substring.length-1]
////		try {
////			Thread.sleep(5000);
////		} catch (Exception e) {
////		}
////		rerankpage.clickonselectbtn();
////		rerankpage.clickondonebtn();
////		String after = rerankpage.getsrcafteraddedititems(1);
////		String[] substring1 = after.split("/");
////		Assert.assertEquals(substring[substring.length - 1],substring[substring1.length - 1]);
//
//	}// AddEditItemsImage
//
//	// Confusion testcase incomplete
//	// /*
//	// * Use-case : Bury/Unbury Through Admin Bar should display message bout
//	// noindex on action
//	// * Test case : Open any list from admin login
//	// Click on change link to bury/unburry
//	// Select bury/unburry.
//	// */
//	// @Test(priority = 87, dataProviderClass = DataProviders.class,
//	// dataProvider = "Login")
//	// public void BuryUnbury(String loginRequired) {
//	// System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 87 !!!!!!!!!!!!!!!!!!!!!!!");
//	// // Base state. (Navigate to node page)
//	// ListHeader listHeader=null;
//	//
//	// if(loginRequired.equals("YES")){
//	// listHeader =BaseStateWithLogin(ultimateContributeUrl,"BuryUnbury");
//	// }else{
//	// listHeader =BaseState(ultimateContributeUrl,"BuryUnbury");
//	// }
//	// UeListPage ueList= new UeListPage(getDriver());
//	// Grid grid=new Grid(getDriver());
//	// common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-most-influential-contemporary-americans");
//	// common.signin("vijaymohanp", "server");
//	// grid.clickOnAdminStats(2);
//	// listHeader.clickOnBurylist();
//	// Alert alert = getDriver().switchTo().alert();
//	// String s1=alert.getText();
//	// System.out.println("s1--"+s1);
//	// Assert.assertEquals(s1,"Also noIndexed. Toggle to change");
//	// grid.clickOnAdminStats(9);
//	// grid.clickOnresetsublist(2);
//	// listHeader.AlertExistsAndAccepted(2000);
//	// grid.clickOnAdminStats(2);
//	// listHeader.clickOnBurylist();
//	// Alert alert1 = getDriver().switchTo().alert();
//	// String s2=alert1.getText();
//	// System.out.println("s2--"+s2);
//	// // Assert.assertEquals(s1,"Also doIndexed. Toggle to change");
//	// // listHeader.AlertExistsAndAccepted(2000);
//	//
//	// }
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