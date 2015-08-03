package com.testsuite.RankBlockTests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.pageobjects.RankBlockPage.RankPage;
import com.pageobjects.rerank.RerankPage;
import com.pageobjects.rightrail.Rightrail;

public class RankBlockTest extends BaseSetup{
	ConfigManager urls=new ConfigManager("PreProduction");
	 Commonpage common;
	 String url=config.getProperty("Url")+urls.getProperty("RightrailPage");
	 ConfigManager sysProp=new ConfigManager("Sys");

	 /* 
	  * Use-case : Rank Rank ("the lists") block [CATEGORY/CLASS/TAG/VOTE LISTS] - popular now dropdown
	  * Test case : Select "Popular Now" in the sorting dropdown at the top right of the block.
	  */
	 @Test(priority=1,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PopularNowDropdown(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("PopularNowDropdown");
		 }else{
			 rankPage =BaseState("PopularNowDropdown");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(url);
		 links.add(config.getProperty("Url")+"lists/actors");
				 links.add(config.getProperty("Url")+"tags/babes");
				 
		 for (int i=0;i<links.size();i++){
			 if(i!=0){
				 String link = links.get(i);
				 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ "+link);
				 getDriver().get(link);
			 }
		 rankPage.selectFromDropdown("Most Recent");
		 rankPage.selectFromDropdown("Popular Now");
		 try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		 if(getDriver().getCurrentUrl().contains("filter=popular")){
			 Assert.assertEquals(1, 1);
		 }else{
			 Assert.assertEquals(1, 0);
		 }
		 Assert.assertTrue(rankPage.isListPresent(25));
		 }
	 }//End of PopularNowDropdown

	 /* 
	  * Use-case : Rank Rank ("the lists") block [CATEGORY/CLASS/TAG/VOTE LISTS] - most recent dropdown
	  * Test case : -Select "most recent" in the sorting dropdown at the top right of the block.
	  */
	 @Test(priority=2,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void MostRecentDropdown(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("MostRecentDropdown");
		 }else{
			 rankPage =BaseState("MostRecentDropdown");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(url);
		 links.add(config.getProperty("Url")+"lists/actors");
				 links.add(config.getProperty("Url")+"tags/babes");
				 
		 for (int i=0;i<links.size();i++){
			 if(i!=0){
				 String link = links.get(i);
				 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ "+link);
				 getDriver().get(link);
			 }
		 rankPage.selectFromDropdown("Most Recent");
		 try {
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		 if(getDriver().getCurrentUrl().contains("filter=recent")){
			 Assert.assertEquals(1, 1);
		 }else{
			 Assert.assertEquals(1, 0);
		 }
		 Assert.assertTrue(rankPage.isListPresent(25));
		 }
		
	 }//End of MostRecentDropdown
	 /* 
	  * Use-case : Rank Rank ("the lists") block [CATEGORY/CLASS/TAG/VOTE LISTS] - most viewed dropdown
	  * Test case : Select "Most Viewed" in the sorting dropdown at the top right of the block.
	  */
	 @Test(priority=3,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void MostViewedDropdown(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("MostViewedDropdown");
		 }else{
			 rankPage =BaseState("MostViewedDropdown");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(url);
		 links.add(config.getProperty("Url")+"lists/actors");
				 links.add(config.getProperty("Url")+"tags/babes");
				 
		 for (int i=0;i<links.size();i++){
			 if(i!=0){
				 String link = links.get(i);
				 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ "+link);
				 getDriver().get(link);
			 }
		 rankPage.selectFromDropdown("Most Viewed");
		 try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		 if(getDriver().getCurrentUrl().contains("filter=viewed")){
			 Assert.assertEquals(1, 1);
		 }else{
			 Assert.assertEquals(1, 0);
		 }
		 Assert.assertTrue(rankPage.isListPresent(25));
		 String firstview = rankPage.getTextOfViews(1);
		 String secondview = rankPage.getTextOfViews(2);
		 int fv = Integer.parseInt(firstview.split(" ")[0].replaceAll(",", "" ));
		 int sv = Integer.parseInt(secondview.split(" ")[0].replaceAll(",", "" ));
		 if(fv >= sv){
			 Assert.assertEquals(1, 1);
		 }else{
			 Assert.assertEquals(1, 0);
		 }}
	 }//End of MostViewedDropdown
	 /* 
	  * Use-case : Rank Rank block [CATEGORY/CLASS/TAG/VOTE LISTS] - list links
	  * Test case : Randomly click on three list links in fresh list block.
	  */
	 @Test(priority=4,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void Listlink(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("Listlink");
		 }else{
			 rankPage =BaseState("Listlink");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(url);
		 links.add(config.getProperty("Url")+"lists/actors");
				 links.add(config.getProperty("Url")+"tags/babes");
				 
		 for (int i=0;i<links.size();i++){
			 if(i!=0){
				 String link = links.get(i);
				 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ "+link);
				 getDriver().get(link);
			 }
			 for(int j=1;j<=3;j++){
				 try {
					Thread.sleep(9000);
				} catch (Exception e) {
					// TODO: handle exception
				}
		String before = rankPage.gethrefOfList(j);
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		rankPage.clickOnList(j);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(getDriver().getCurrentUrl().contains(before)){
			Assert.assertEquals(1, 1);
		}
		else{
			Assert.assertEquals(1, 0);
		}
		getDriver().navigate().back();
			 }
			 
		 }
		 
	 }//End of Listlink
	 /* 
	  * Use-case : Rank Rank block [CATEGORY/CLASS/TAG/VOTE LISTS] - profile links
	  * Test case : Click on any of the profile name appear just below the list names(for iList)
	  */
	 @Test(priority=5,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void profileLinks(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("profileLinks");
		 }else{
			 rankPage =BaseState("profileLinks");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(url);
		 links.add(config.getProperty("Url")+"lists/actors");
				 links.add(config.getProperty("Url")+"tags/babes");
				 
		 for (int i=0;i<links.size();i++){
			 if(i!=0){
				 String link = links.get(i);
				 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ "+link);
				 getDriver().get(link);
			 }
			 for(int j=1;j<=25;j++){
				 if (!rankPage.isListUltimate(j)){
					 String before = rankPage.gethrefOfProfile(j);
					 rankPage.clickOnProfile(j);
					 if(getDriver().getCurrentUrl().contains(before)){
						 Assert.assertEquals(1, 1);
					 }else{
						 Assert.assertEquals(1, 0);
					 }
					 break;
				 }
			 }
			 			 
		 }
	 }//End of profileLinks
	 /* 
	  * Use-case : -Rank Rank block [CATEGORY/CLASS/TAG/VOTE LISTS] - contributing list links for an Ultimate list
	  * Test case : Click on any of the profile names appear below the list description for an Ultimate list
	  */
	 @Test(priority=6,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ContributingListLinkForUltimateList(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("ContributingListLinkForUltimateList");
		 }else{
			 rankPage =BaseState("ContributingListLinkForUltimateList");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(url);
		 links.add(config.getProperty("Url")+"lists/actors");
				 links.add(config.getProperty("Url")+"tags/babes");
				 
		 for (int i=0;i<links.size();i++){
			 if(i!=0){
				 String link = links.get(i);
				 getDriver().get(link);
			 }
			 for(int j=1;j<=25;j++){
				 if (rankPage.isListUltimate(j)){
					 String before = rankPage.gethrefOfUltimateProfile(j);
					 rankPage.clickOnUltimateProfile(j);
					 try{
						 Thread.sleep(2000);
					 }catch( Exception e){}
					 if(getDriver().getCurrentUrl().contains(before)){
						 Assert.assertEquals(1, 1);
					 }else{
						 Assert.assertEquals(1, 0);
					 }
					 break;
				 }
			 }
			 
		 }
	 }//End of ContributingListLinkForUltimateList
 	 /* 
	  * Use-case : Refine Results block [CATEGORY/CLASS/TAG/VOTE LISTS] - add filte
	  * Test case : Click on any of the filters in Refine results block appear on top of the page
	  */
	 @Test(priority=7,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void AddFilter(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("AddFilter");
		 }else{
			 rankPage =BaseState("AddFilter");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(url);
		 links.add(config.getProperty("Url")+"lists/actors");
				 links.add(config.getProperty("Url")+"tags/babes");
		 for (int i=0;i<links.size();i++){
			 String link="";
			 if(i!=0){
				  link = links.get(i);
				  System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ "+link);
				  getDriver().get(link);
			 }
			 try {
				Thread.sleep(5000);
			} catch (Exception e) {
			}
				 rankPage.clickOnaddfilter(1);
		     for(int j=1;j<=2;j++){
			 Assert.assertTrue(rankPage.isfilterPresent(j));}
		 }
	 }//End of AddFilter
	 /* 
	  * Use-case : Refine Results block [CATEGORY/CLASS/TAG/VOTE LISTS] - show more
	  * Test case : 1) Open any category page
					2) Click on "show more..." button in refine results block
	  */
	 @Test(priority=8,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ShowMore(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("ShowMore");
		 }else{
			 rankPage =BaseState("ShowMore");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(url);
		 links.add(config.getProperty("Url")+"lists/actors");
				 links.add(config.getProperty("Url")+"tags/babes");
				 
		 for (int i=0;i<links.size();i++){
			 if(i!=0){
				 String link = links.get(i);
				 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ "+link);
				 getDriver().get(link);
			 }
		 rankPage.clickOnshowmore();
		 Assert.assertTrue(rankPage.isPresentmorefilters());
		 }
	 }//End of ShowMore
 	 /* 
	  * Use-case : Refine Results block [CATEGORY/CLASS/TAG/VOTE LISTS] - select more than one filter
	  * Test case : 1) Open any category page
					2) Click on any of the filters in Refine Results block
					3) Click on another filter
	  */
	 @Test(priority=9,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void AddMoreThenoneFilter(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 9 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("AddMoreThenoneFilter");
		 }else{
			 rankPage =BaseState("AddMoreThenoneFilter");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(url);
		 links.add(config.getProperty("Url")+"lists/actors");
				 links.add(config.getProperty("Url")+"tags/babes");
				 
		 for (int i=0;i<links.size();i++){
			 String link="";
			 if(i!=0){
				  link = links.get(i);
				 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ "+link);
				 getDriver().get(link);
			 }
			
					 rankPage.clickOnaddfilter(1);
					 rankPage.clickOnaddfilter(2);
					
//		 rankPage.clickOnaddfilter(1);
//		 rankPage.clickOnaddfilter(2);
		 for(int j=1;j<=3;j++){
		 Assert.assertTrue(rankPage.isfilterPresent(j));}
		 }
	 }//End of AddMoreThenoneFilter
	 /* 
	  * Use-case : Refine Results block [CATEGORY/CLASS/TAG/VOTE LISTS] - delete selected filter
	  * Test case : 1) Open any category page
					2) Click on any of the filters in Refine Results block
					3) Delete the selected filter displays on the top of refine results block with cat name
	  */
	 @Test(priority=10,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void DeleteFilter(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 10 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("DeleteFilter");
		 }else{
			 rankPage =BaseState("DeleteFilter");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(url);
		 links.add(config.getProperty("Url")+"lists/actors");
				 links.add(config.getProperty("Url")+"tags/babes");
				 
		 for (int i=0;i<links.size();i++){
			 if(i!=0){
				 String link = links.get(i);
				 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ "+link);
				 getDriver().get(link);
			 }
		 rankPage.clickOnaddfilter(1);
		 rankPage.clickOndeletefilter(2);
		 try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		 Assert.assertTrue(rankPage.isfilterPresent(1));
		 Assert.assertFalse(rankPage.isfilterPresent(2));
		 }
	 }//End of DeleteFilter
	 /* 
	  * Use-case : Refine Results block [CATEGORY/CLASS/TAG/VOTE LISTS] - add and delete filters
	  * Test case :  1) Click on 1 filter.
					 2) Click on another filter.
					 3) Delete second filter.
					 4) Click on a different filter.
					 5) Delete first filter.
					 4) Delete only remaining filter.
	  */
	 @Test(priority=11,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void AddAndDeleteFilter(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 11!!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("AddAndDeleteFilter");
		 }else{
			 rankPage =BaseState("AddAndDeleteFilter");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(url);
		 links.add(config.getProperty("Url")+"lists/actors");
				 links.add(config.getProperty("Url")+"tags/babes");
				 
		 for (int i=0;i<links.size();i++){
			 if(i!=0){
				 String link = links.get(i);
				 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ "+link);
				 getDriver().get(link);
			 }
		 rankPage.clickOnaddfilter(1);
		 rankPage.clickOnaddfilter(2);
		 Assert.assertTrue(rankPage.isfilterPresent(1));
		 Assert.assertTrue(rankPage.isfilterPresent(2));
		 rankPage.clickOndeletefilter(3);
		 try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}
		 Assert.assertFalse(rankPage.isfilterPresent(3));
		 rankPage.clickOnaddfilter(1);
		 Assert.assertTrue(rankPage.isfilterPresent(3));
		 try {
				Thread.sleep(7000);
			} catch (Exception e) {
			}
		 rankPage.clickOndeletefilter(2);
//		 try {
//				Thread.sleep(8000);
//			} catch (Exception e) {
//			}
		 rankPage.clickOndeletefilter(2);
		 try {
				Thread.sleep(7000);
			} catch (Exception e) {
			}
		 Assert.assertFalse(rankPage.isfilterPresent(2));
		 }
	 }//End of AddAndDeleteFilter
	 /* 
	  * Use-case : Refine Results block [CATEGORY/CLASS/TAG/VOTE LISTS] - show more/less
	  * Test case : 1) Click on "show more..."
					2) Click on "show less..."
	  */
	 @Test(priority=12,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ShowMoreShowLess(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("ShowMoreShowLess");
		 }else{
			 rankPage =BaseState("ShowMoreShowLess");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(url);
		 links.add(config.getProperty("Url")+"lists/actors");
				 links.add(config.getProperty("Url")+"tags/babes");
				 
		 for (int i=0;i<links.size();i++){
			 if(i!=0){
				 String link = links.get(i);
				 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ "+link);
				 getDriver().get(link);
			 }
			 
			 try {
					Thread.sleep(2000);
				} catch (Exception e) {
				}	 
		 rankPage.clickOnshowmore();
		 Assert.assertTrue(rankPage.isPresentmorefilters());
		 try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		 rankPage.clickOnshowmore();
		 Assert.assertTrue(rankPage.isPresentmorefilters());
		 }
	 }//End of ShowMoreShowLess
	 /* 
	  * Use-case : Featured List block [CATEGORY/CLASS/TAG] - list images and titles
	  * Test case : Open any category/class/tag page.
	  */
	 @Test(priority=13,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FeaturedListCheckImagesAndTitle(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 13 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("FeaturedListCheckImagesAndTitle");
		 }else{
			 rankPage =BaseState("FeaturedListCheckImagesAndTitle");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(url);
		 links.add(config.getProperty("Url")+"lists/actors");
				 links.add(config.getProperty("Url")+"tags/babes");
				 
		 for (int i=0;i<links.size();i++){
			 if(i!=0){
				 String link = links.get(i);
				 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ "+link);
				 getDriver().get(link);
			 }
			 for(int j=1;j<=6;j++){
				// System.out.println("jjjjj== "+j);
				  Assert.assertTrue(rankPage.isPresentfeaturedlistimage(j));	
				  Assert.assertTrue(rankPage.isPresentfeaturedlisttitle(j));
			 }
		 }
	 }//End of FeaturedListCheckImagesAndTitle
	 /* 
	  * Use-case : Featured List block [CATEGORY/CLASS/TAG] - vote icon hover
	  * Test case : Hover over the vote icon in the top left corner of the images in the Featured List block.
	  */
	 @Test(priority=14,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void HoverTheVoteIcon(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 14 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("HoverTheVoteIcon");
		 }else{
			 rankPage =BaseState("HoverTheVoteIcon");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(url);
		 links.add(config.getProperty("Url")+"lists/actors");
				 links.add(config.getProperty("Url")+"tags/babes");
				 
		 for (int i=0;i<links.size();i++){
			 if(i!=0){
				 String link = links.get(i);
				 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ "+link);
				 getDriver().get(link);
			 }
//			 try {
//				Thread.sleep(5000);
//			} catch (Exception e) {
//			}
			 for(int j=1;j<=6;j++){
				 rankPage.hoverOnvoteicon(1);
				 try {
						Thread.sleep(5000);
					} catch (Exception e) {
						// TODO: handle exception
					}
				 Assert.assertTrue(rankPage.isPresentlightbox());
			 }
		 }
	 }//End of HoverTheVoteIcon
	 /* 
	  * Use-case : Featured List block [CATEGORY/CLASS/TAG] - list links
	  * Test case : Click on any of the list links appear in Featured list block.
	  */
	 @Test(priority=15,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FeaturedListLinks(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 15 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("FeaturedListLinks");
		 }else{
			 rankPage =BaseState("FeaturedListLinks");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(url);
		 links.add(config.getProperty("Url")+"lists/actors");
				 links.add(config.getProperty("Url")+"tags/babes");
				 
		 for (int i=0;i<links.size();i++){
			 if(i!=0){
				 String link = links.get(i);
				 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ ");
				 getDriver().get(link);
			 }
			 try {
					Thread.sleep(5000);
				} catch (Exception e) {
				}
			 for(int j=1;j<=6;j++){
				 String before=rankPage.gethrefOffeaturedlisttitle(j);
				// System.out.println("before "+before);
				 rankPage.clickOnfeaturedlisttitle(j);
				 try {
						Thread.sleep(5000);
					} catch (Exception e) {
					}
				 String after[]=getDriver().getCurrentUrl().split("\\?");
				// System.out.println("after "+after[0]);
				 Assert.assertEquals(before, after[0]);
				 try {
						Thread.sleep(5000);
					} catch (Exception e) {
					}
				 getDriver().navigate().back();
				 try {
						Thread.sleep(5000);
					} catch (Exception e) {
					}
				 
			 }
		 }
	 }//End of FeaturedListLinks
	 /* 
	  * Use-case : Most Listed block - node pages
	  * Test case : 1) Open any category page.
					2) Click on nodes appearing in "most listed" category block.
	  */
	 @Test(priority=16,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void MostlistedBlock(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 16 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("MostlistedBlock");
		 }else{
			 rankPage =BaseState("MostlistedBlock");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(url);
		 Assert.assertTrue(rankPage.isPresentmostlidtedblock());
	     String before=rankPage.getnumberOfmostlisted(1);
	     rankPage.clickOnPaginationarrow("right",1);
	     String after=rankPage.getnumberOfmostlisted(7);
	     Assert.assertNotEquals(before, after);
	     rankPage.clickOnPaginationarrow("left",7);
		 before=rankPage.gethrefOfMostlistdlist(1);
		 rankPage.clickOnMostlistdlist(1);
		 after=getDriver().getCurrentUrl();
		 Assert.assertEquals(before, after);
	 }//End of MostlistedBlock
	 /* 
	  * Use-case :  Most Listed block - pagination arrows
	  * Test case : 1) Open any category page.
					2) Click on left and right arrows
	  */
	 @Test(priority=17,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PaginationArrow(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 17 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("PaginationArrow");
		 }else{
			 rankPage =BaseState("PaginationArrow");
		 }
		  ArrayList<String> links = new ArrayList<String>();
		  links.add(url);
		   
		   String before=rankPage.getnumberOfmostlisted(1);
		   rankPage.clickOnPaginationarrow("right",1);
		   String after=rankPage.getnumberOfmostlisted(7);
		   Assert.assertNotEquals(before, after);
		   try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		    before=rankPage.getnumberOfmostlisted(7);
		    rankPage.clickOnPaginationarrow("left",7);
		    after=rankPage.getnumberOfmostlisted(1);
		    Assert.assertNotEquals(before, after);

	 }//End of PaginationArrow
	 /* 
	  * Use-case : Check for Category link
	  * Test case : 1) Open any class page
					2) Click on "Category link" appear top left side below the nav bar
	  */
	 @Test(priority=18,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void CategoryLink(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 18 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("CategoryLink");
		 }else{
			 rankPage =BaseState("CategoryLink");
		 }
		// ArrayList<String> links = new ArrayList<String>();
		 common.getNewURL(config.getProperty("Url")+"lists/actors");
		 String before=rankPage.gethrefOfcategorylink();
		 rankPage.clickOncategorylink();
		 String after=getDriver().getCurrentUrl();
		 Assert.assertEquals(after, before);
		 
	 }//End of CategoryLink
	 /* 
	  * Use-case : Browse block - list links
	  * Test case : Click on any one of the class links appear in Browse block
	  */
	 @Test(priority=19,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void BrowseBlockLink(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 19 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("BrowseBlockLink");
		 }else{
			 rankPage =BaseState("BrowseBlockLink");
		 }
		// ArrayList<String> links = new ArrayList<String>();
		 common.getNewURL(config.getProperty("Url")+"lists/actors");
		 String before=rankPage.gethrefOfbrowseblocklist(1);
		 rankPage.clickOnbrowseblocklist(1);
		 String after=getDriver().getCurrentUrl();
		 Assert.assertEquals(after, before);
		 Assert.assertFalse(rankPage.isclickablebrowseblocklist(1));
	 }//End of BrowseBlockLink
	 /* 
	  * Use-case : Listopedia block - list links
	  * Test case : Click on any of the list links appear in Listopedia block
	  */
	 @Test(priority=20,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ListopediaBlockLink(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 20 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("ListopediaBlockLink");
		 }else{
			 rankPage =BaseState("ListopediaBlockLink");
		 }
		// ArrayList<String> links = new ArrayList<String>();
		 common.getNewURL(config.getProperty("Url")+"lists/actors");
		 String before=rankPage.gethrefOfListopediablocklist(1);
		 rankPage.clickOnListopediablocklist(1);
		 String after=getDriver().getCurrentUrl();
		 Assert.assertEquals(after, before);
	 }//End of ListopediaBlockLink
	 /* 
	  * Use-case : Listopedia block - see all
	  * Test case : Click the "see all" link at the bottom of the Listopedia block
	  */
	 @Test(priority=21,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ListopediaBlockSeeAll(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 21 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("ListopediaBlockSeeAll");
		 }else{
			 rankPage =BaseState("ListopediaBlockSeeAll");
		 }
		// ArrayList<String> links = new ArrayList<String>();
		 common.getNewURL(config.getProperty("Url")+"lists/actors");
		 try {
				Thread.sleep(5000);
			} catch (Exception e) {
			}
		 String before=rankPage.gethrefOfListopediablockseeall();
		 rankPage.clickOnListopediablockseeall();
		 try {
				Thread.sleep(5000);
			} catch (Exception e) {
			}
		 String after=getDriver().getCurrentUrl();
		 Assert.assertEquals(after, before);
	 }//End of ListopediaBlockSeeAll
	 
	 /* 
	  * Use-case : Images & Ads
	  * Test case : Open any category page
	  */
	 @Test(priority=22,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PresentAdsInCategory(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 22 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("PresentAdsInCategory");
		 }else{
			 rankPage =BaseState("PresentAdsInCategory");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(url);
		 try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 Assert.assertTrue(rankPage.isPresentads1());
		 
	 }//End of PresentAdsInCategory
	 /* 
	  * Use-case : Images & Ads
	  * Test case : Open any class page. 
	  */
	 @Test(priority=23,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PresentAdsInClass(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 23 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("PresentAdsInClass");
		 }else{
			 rankPage =BaseState("PresentAdsInClass");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(config.getProperty("Url")+"lists/actors");
		 try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 Assert.assertTrue(rankPage.isPresentads1());
		 
	 }//End of PresentAdsInClass
	 
	 /* 
	  * Use-case : Images & Ads
	  * Test case : Go to some tag pages
	  */
	 @Test(priority=24,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PresentAdsInTags(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 24 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("PresentAdsInTags");
		 }else{
			 rankPage =BaseState("PresentAdsInTags");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(config.getProperty("Url")+"tags/babes");
		 try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 Assert.assertTrue(rankPage.isPresentads1());
		 
	 }//End of PresentAdsInClass vote-ranked-list
	 
	 /* 
	  * Use-case : Images & Ads
	  * Test case : Open voterank landing page
	  */
	 @Test(priority=25,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PresentAdsInVoterrank(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 25 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("PresentAdsInVoterrank");
		 }else{
			 rankPage =BaseState("PresentAdsInVoterrank");
		 }
		 ArrayList<String> links = new ArrayList<String>();
		 links.add(config.getProperty("Url")+"vote-ranked-list");
		 try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 Assert.assertTrue(rankPage.isPresentads1());
		 
	 }//End of PresentAdsInVoterrank 
	 /* 
	  * Use-case  : Check page is loading all lists
	  * Test case :verify that the number of lists at the top of the page matches all the lists on the page
	  */
	 @Test(priority=26,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PresentNumberOfListInPage(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 26 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to page having right rail)
		 RankPage rankPage=null;
		 if(loginRequired.equals("YES")){
			 rankPage =BaseStateWithLogin("PresentNumberOfListInPage");
		 }else{
			 rankPage =BaseState("PresentNumberOfListInPage");
		 }
//		 ArrayList<String> links = new ArrayList<String>();
//		 links.add(config.getProperty("Url")+"tags/babes");
		 common.getNewURL(config.getProperty("Url")+"tags/babes");
		 try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		 rankPage.clickOnaddfilter(4);
		 try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		 if(url.contains("stage")){
			 rankPage.clickOnaddfilter(4);
		 }else
		 rankPage.clickOnaddfilter(6);
		 try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		 String listnum=rankPage.getNumbersOfList();
		 List<WebElement> list=rankPage.getOfListofnumber();
		 Assert.assertEquals(Integer.parseInt(listnum), list.size());
		 
	 }//End of PresentNumberOfListInPage 
	 
	 /*
	  * This is base state of the Rank Rank Block test-cases.
	  */
	 public RankPage BaseState(String testName){
		 try{
		 startRecording(testName);
		}catch(Exception e){}
		 common=new Commonpage(getDriver());
		 RankPage rankPage=common.getRankPage(url);
		 return rankPage;
	 } //End of BaseState()
	 /*
	  * This is base state of the Rank Rank block test-cases.
	  */
	 public RankPage BaseStateWithLogin(String testName){
		 try{
		 startRecording(testName);
		}catch(Exception e){}
		 common=new Commonpage(getDriver());
		 common.signin("testuserkallol1@mailinator.com", "testing");
		 RankPage rankPage=common.getRankPage(url);
		 return rankPage;
	 } //End of BaseStateWithLogin()
}
