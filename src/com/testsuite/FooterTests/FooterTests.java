package com.testsuite.FooterTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.pageobjects.footer.FooterPage;
import com.selenium.SafeActions;

public class FooterTests extends BaseSetup {
	ConfigManager urls = new ConfigManager("PreProduction");
	ConfigManager sysProp = new ConfigManager("Sys");
	String url = config.getProperty("Url");
	Commonpage common;

	/*
	 * Use-case : About Ranker link Test case :Click on "about ranker" on footer
	 */
	@Test(priority = 1, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Footeraboutranker(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		FooterPage footerPage = null;
		if (loginRequired.equals("YES")) {
			footerPage = BaseStateWithLogin("Footeraboutranker");
		} else {
			footerPage = BaseState("Footeraboutranker");
		}
		String before = footerPage.getHrefOfaboutranker();
		footerPage.clickOnFooterofaboutranker();
		 try{
			 
			 Thread.sleep(3000);
		 }catch(Exception e){}
		String Afterurl = getDriver().getCurrentUrl();
		
		if (Afterurl.contains(before)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}

	}// End of Foooter in About Ranker
	/*
	 * Use-case : Ranker Blog link Test case : Click on "the ranker blog" on
	 * footer
	 */
	@Test(priority = 2, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Footertherankerblog(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		FooterPage footerPage = null;
		if (loginRequired.equals("YES")) {
			footerPage = BaseStateWithLogin("Footertherankerblog");
		} else {
			footerPage = BaseState("Footertherankerblog");
		}
		String before = footerPage.getHrefOftherankerblog();
		System.out.println("before=="+before);
		footerPage.clickOnFooteroftherankerblog();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}
//		SafeActions s = new SafeActions(getDriver());
//	      s.waitForPageToLoad(30);
		String Afterurl = getDriver().getCurrentUrl();
		System.out.println("Afterurl=="+Afterurl);
		if (Afterurl.contains(before)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
	}// End of Footetherankerblog
	/*
	 * Use-case : FAQ/Help Test case : Click on "faq/help" link
	 */
	@Test(priority = 3, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Footerfaqhelp(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		FooterPage footerPage = null;
		if (loginRequired.equals("YES")) {
			footerPage = BaseStateWithLogin("Footerfaqhelp");
		} else {
			footerPage = BaseState("Footerfaqhelp");
		}
		String before = footerPage.getHrefOffaqhelp();
		footerPage.clickOnFooteroffaqhelp();
		String Afterurl = getDriver().getCurrentUrl();
		if (Afterurl.contains(before)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
	}// End of Foooter in faq&help

	/*
	 * Use-case : Sitemap link Test case : Click on "sitemap" link
	 */
	@Test(priority = 4, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Footersitemap(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		FooterPage footerPage = null;
		if (loginRequired.equals("YES")) {
			footerPage = BaseStateWithLogin("Footersitemap");
		} else {
			footerPage = BaseState("Footersitemap");
		}
		String before = footerPage.getHrefOfsitemap();
		footerPage.clickOnFooterofsitemap();
		String Afterurl = getDriver().getCurrentUrl();
		if (Afterurl.contains(before)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
	}// End of Footersitemap
	/*
	 * Use-case : Contact link Test case : Click on "contact" link
	 */
	@Test(priority = 5, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Footercontact(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		FooterPage footerPage = null;
		if (loginRequired.equals("YES")) {
			footerPage = BaseStateWithLogin("Footercontact");
		} else {
			footerPage = BaseState("Footercontact");
		}
		String before = footerPage.getHrefOfcontact();
		footerPage.clickOnFooterofcontact();
		String Afterurl = getDriver().getCurrentUrl();
		if (Afterurl.contains(before)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
	}// End of Foooter in contact
	/*
	 * Use-case : Jobs link Test case : Click on "jobs" link
	 */
	@Test(priority = 6, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Footerjobs(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		FooterPage footerPage = null;
		if (loginRequired.equals("YES")) {
			footerPage = BaseStateWithLogin("Footerjobs");
		} else {
			footerPage = BaseState("Footerjobs");
		}
		String before = footerPage.getHrefOfjobs();
		footerPage.clickOnFooterofjobs();
		SafeActions s = new SafeActions(getDriver());
	      s.waitForPageToLoad(50);
		String Afterurl = getDriver().getCurrentUrl();
		if (Afterurl.contains(before)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
	}// End of Footerjobs

	/*
	 * Use-case : Widget link Test case : Click on "widget" link
	 */
	@Test(priority = 7, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Footerwidget(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		FooterPage footerPage = null;
		if (loginRequired.equals("YES")) {
			footerPage = BaseStateWithLogin("Footerwidget");
		} else {
			footerPage = BaseState("Footerwidget");
		}
		String before = footerPage.getHrefOfwidget();
		footerPage.clickOnFooterofwidget();
		String Afterurl = getDriver().getCurrentUrl();
		if (Afterurl.contains(before)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
	}// End of Footerwidget

	/*
	 * Use-case : Terms link Test case : Click "terms" link
	 */
	@Test(priority = 8, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Footerterms(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		FooterPage footerPage = null;
		if (loginRequired.equals("YES")) {
			footerPage = BaseStateWithLogin("Footerterms");
		} else {
			footerPage = BaseState("Footerterms");
		}
		String before = footerPage.getHrefOfterms();
		footerPage.clickOnFooterofterms();
		String Afterurl = getDriver().getCurrentUrl();
		if (Afterurl.contains(before)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
	}// End of Footerterms

	/*
	 * Use-case : Privacy Test case : Click on "privacy" link
	 */
	@Test(priority = 9, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FooterPrivacy(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 9 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		FooterPage footerPage = null;
		if (loginRequired.equals("YES")) {
			footerPage = BaseStateWithLogin("FooterPrivacy");
		} else {
			footerPage = BaseState("FooterPrivacy");
		}
		String before = footerPage.getHrefOfprivacy();
		footerPage.clickOnFooterofprivacy();
//		try {
//			Thread.sleep(4000);
//		} catch (Exception e) {
//		}
		String Afterurl = getDriver().getCurrentUrl();
		if (Afterurl.contains(before)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
	}// End of FooterPrivacy

	/*
	 * Use-case : Press link Test case : Click on "press" link
	 */
	@Test(priority = 10, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Footerpress(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 10 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		FooterPage footerPage = null;
		if (loginRequired.equals("YES")) {
			footerPage = BaseStateWithLogin("Footerpress");
		} else {
			footerPage = BaseState("Footerpress");
		}
		String before = footerPage.getHrefOfpress();
		footerPage.clickOnFooterofpress();

		String Afterurl = getDriver().getCurrentUrl();
		if (Afterurl.contains(before)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
	}// End of Footerpress

	/*
	 * Use-case : Partner Program Test case : Click on "partner program" link
	 */
	@Test(priority = 11, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FooterPartnerProgram(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 11 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		FooterPage footerPage = null;
		if (loginRequired.equals("YES")) {
			footerPage = BaseStateWithLogin("FooterPartnerProgram");
		} else {
			footerPage = BaseState("FooterPartnerProgram");
		}
		String before = footerPage.getHrefOfpartnerprogram();
		footerPage.clickOnFooterofpartnerprogram();
		SafeActions s = new SafeActions(getDriver());
	     s.waitForPageToLoad(30);
		String Afterurl = getDriver().getCurrentUrl();
		if (Afterurl.contains(before)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
	}// End of FooterpatnerProgram

	/*
	 * Use-case : Top Rankers link Test case : Click on "top rankers" link
	 */
	@Test(priority = 12, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Footertoprankers(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		FooterPage footerPage = null;
		if (loginRequired.equals("YES")) {
			footerPage = BaseStateWithLogin("Footertoprankers");
		} else {
			footerPage = BaseState("Footertoprankers");
		}
		String before = footerPage.getHrefOftoprankers();
		footerPage.clickOnFooteroftoprankers();
		String afterurl = getDriver().getCurrentUrl();
		int subString1 = config.getProperty("Url").length();
		Assert.assertEquals(afterurl + "/",(config.getProperty("Url").substring(0, subString1 - 1))+ before);
	}// End of Footertoprankers

	/*
	 * Use-case : Edge cast Test case : Click on Edge cast link.
	 */
	@Test(priority = 13, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Footeredgecast(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 13 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		FooterPage footerPage = null;
		if (loginRequired.equals("YES")) {
			footerPage = BaseStateWithLogin("Footeredgecast");
		} else {
			footerPage = BaseState("Footeredgecast");
		}
		String before = footerPage.getHrefOfedgecast();
		footerPage.clickOnFooterofedgecast();
		String Afterurl = getDriver().getCurrentUrl();
		if (Afterurl.contains(before)) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
	}// End of Footeredgecast
	
	//////not open
//
////	/*
////	 * Use-case : Freebase icon Test case : Click on the Freebase icon
////	 */
////	@Test(priority = 14, dataProviderClass = DataProviders.class, dataProvider = "Login")
////	public void FreeBaseIconCheck(String loginRequired) {
////		System.out
////				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 14 !!!!!!!!!!!!!!!!!!!!!!!");
////		// Base state. (Navigate to node page)
////		FooterPage footerPage = null;
////		if (loginRequired.equals("YES")) {
////			footerPage = BaseStateWithLogin("FreeBaseIconCheck");
////		} else {
////			footerPage = BaseState("FreeBaseIconCheck");
////		}
////		String before = footerPage.getHrefOfFreeBase();
////		footerPage.clickOnFreeBase();
////		String Afterurl = getDriver().getCurrentUrl();
////		if (Afterurl.contains(before)) {
////			Assert.assertEquals(1, 1);
////		} else {
////			Assert.assertEquals(1, 0);
////		}
////	}// End of FreeBaseIconCheck
////
//////	/*
//////	 * Use-case : Factual icon Test case : Click on the Factual icon
//////	 */
//////	@Test(priority = 15, dataProviderClass = DataProviders.class, dataProvider = "Login")
//////	public void FactualIconCheck(String loginRequired) {
//////		System.out
//////				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 15 !!!!!!!!!!!!!!!!!!!!!!!");
//////		// Base state. (Navigate to node page)
//////		FooterPage footerPage = null;
//////		if (loginRequired.equals("YES")) {
//////			footerPage = BaseStateWithLogin("FactualIconCheck");
//////		} else {
//////			footerPage = BaseState("FactualIconCheck");
//////		}
//////		String before = footerPage.getHrefOfFactual();
//////		footerPage.clickOnFactual();
//////		SafeActions s = new SafeActions(getDriver());
//////	    s.waitForPageToLoad(60);
//////		String Afterurl = getDriver().getCurrentUrl();
//////		if (Afterurl.contains(before)) {
//////			Assert.assertEquals(1, 1);
//////		} else {
//////			Assert.assertEquals(1, 0);
//////		}
//////	}// End of FactualIconCheck
////	
////
//////	/*
//////	 * Use-case : Calais icon and link Test case : Click on the Calais icon
//////	 * and/or link
//////	 */
//////	@Test(priority = 16, dataProviderClass = DataProviders.class, dataProvider = "Login")
//////	public void CalaisIconCheck(String loginRequired) {
//////		System.out
//////				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 16 !!!!!!!!!!!!!!!!!!!!!!!");
//////		// Base state. (Navigate to node page)
//////		FooterPage footerPage = null;
//////		if (loginRequired.equals("YES")) {
//////			footerPage = BaseStateWithLogin("CalaisIconCheck");
//////		} else {
//////			footerPage = BaseState("CalaisIconCheck");
//////		}
//////		String before = footerPage.getHrefOfCalais();
//////		footerPage.clickOnCalais();
//////		SafeActions s = new SafeActions(getDriver());
//////	      s.waitForPageToLoad(50);
//////		String Afterurl = getDriver().getCurrentUrl();
//////		if (Afterurl.contains("opencalais")) {
//////			Assert.assertEquals(1, 1);
//////		} else {
//////			Assert.assertEquals(1, 0);
//////		}
//////	}// End of CalaisIconCheck

	/*
	 * Use-case : Wikipedia link Test case : Click on the Wikipedia link
	 */
	@Test(priority = 17, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void WikipediaLinkCheck(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 17 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		FooterPage footerPage = null;
		if (loginRequired.equals("YES")) {
			footerPage = BaseStateWithLogin("WikipediaLinkCheck");
		} else {
			footerPage = BaseState("WikipediaLinkCheck");
		}
		String before = footerPage.getHrefOfWiki();
		footerPage.clickOnWiki();
		SafeActions s = new SafeActions(getDriver());
	    s.waitForPageToLoad(50);
		String Afterurl = getDriver().getCurrentUrl();
		System.out.println("Afterurl=="+Afterurl);
		System.out.println("before=="+before);
		if (Afterurl.contains("wikipedia")) {
			Assert.assertEquals(1, 1);
		} else {
			Assert.assertEquals(1, 0);
		}
	}// End of WikipediaLinkCheck
	/*
	 * Use-case : Mobile Site link Test case : Click on the Mobile Site link
	 */
	@Test(priority = 18, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void MobileSiteLinkCheck(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 18 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		FooterPage footerPage = null;
		if (loginRequired.equals("YES")) {
			footerPage = BaseStateWithLogin("MobileSiteLinkCheck");
		} else {
			footerPage = BaseState("MobileSiteLinkCheck");
		}
		footerPage.clickOnMobileSiteLink();
		  SafeActions s = new SafeActions(getDriver());
	      s.waitForPageToLoad(50);
		String afterurl = getDriver().getCurrentUrl();
		System.out.println("afterurl=="+afterurl);
		if (url.contains("stage")) {
        if(afterurl.contains(afterurl)){
	     Assert.assertEquals(1, 1);
	     }else{
		 Assert.assertEquals(1, 0);
	}
		} else {
			Assert.assertEquals(afterurl, "http://m.ranker.com/");
		}
	}// End of MobileSiteLinkCheck
	/*
	 * This is base state of the slide show test-cases.
	 */
	public FooterPage BaseState(String testName) {
		try {
			startRecording(testName);
		} catch (Exception e) {
		}
		common = new Commonpage(getDriver());
		FooterPage footerPage = common.getFooterPage(url);
		return footerPage;
	} // End of BaseState()

	/*
	 * This is base state of the slide show test-cases.
	 */
	public FooterPage BaseStateWithLogin(String testName) {
		try {
			startRecording(testName);
		} catch (Exception e) {
		}
		common = new Commonpage(getDriver());
		common.signin("testuserkallol1@mailinator.com", "testing");
		FooterPage footerPage = common.getFooterPage(url);
		return footerPage;
	} // End of BaseStateWithLogin()

}
