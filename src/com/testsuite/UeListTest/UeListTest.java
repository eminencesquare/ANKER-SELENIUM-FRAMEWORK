package com.testsuite.UeListTest;

import java.io.File;
import java.sql.Driver;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.LengthDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.paeobjects.navbar.NavBar;
import com.pageobjects.blog.BlogPage;
import com.pageobjects.grid.Grid;
import com.pageobjects.listheader.ListHeader;
import com.pageobjects.listoption.ListOptionPage;
import com.pageobjects.rerank.RerankPage;
import com.pageobjects.uelist.UeListPage;
import com.pageobjects.userProfilePage.UserProfilePage;
import com.selenium.SafeActions;

public class UeListTest extends BaseSetup {
	ConfigManager urls = new ConfigManager("PreProduction");
	ConfigManager sysProp = new ConfigManager("Sys");
	String url = config.getProperty("Url");
	Commonpage common;
	//NavBar navBar;
	/*
	 * Use-case : UE: Check for List name change.
	 * Test case : 1) Create a list
	 2) Click on "edit" icon beside the list name(unnamed) appear on top left
	 3) Change the list in the text box opened and click on save
	 */
	 @Test(priority=1,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void ListNameChange(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
		 UeListPage ueList =BaseStateWithLogin("ListNameChange");
		 NavBar navBar= new NavBar(getDriver());
		 // clickCreateListAndAdd3Items(ueList);
		     navBar.hoverMore();
		     try {
					Thread.sleep(10000);
			 } catch (Exception e) {}
			ueList.clickOncreateList();
			ueList.clickOnreranking();
			if(ueList.isStickyPresent()==true){
			 ueList.clickStickyOK();
			 }
		 ueList.clickOnListName();
		 ueList.putTextOnListNameBox("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		 try {
			Thread.sleep(2000);
		} catch (Exception e) {
			
		}
		 String txt= ueList.getTextOfListName();
		 Assert.assertEquals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",txt);
		 ueList.putTextOnListNameBox("Testing List");
		 ueList.clickOnSearch();
		 ueList.typesearchbtn("Batman");
		 for(int i=1;i<=3;i++){
		 ueList.clickOnPlusIcon(i);
		 }
		 ueList.clickOnpublishbtn();
		 String head=ueList.getTextOFHeaderAfterPublish();
		 Assert.assertEquals(head, "Testing List");
//		 ueList.clicksettingafterpublish();
//		 ueList.clickOnAdvancedOption();
//		 ueList.clickOndeletelist();
//		 ueList.AlertExistsAndAccepted(1000);
	 }//End Of ListNameChange()
	 /*
	  * Use-case : UE: Add List Image.
	  * Test case : 1) Create a list and click on "camera icon" appear on top right
	 				2) Select image from flickr/from system or through url
	 */
	 @Test(priority=2,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void ListImage(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 UeListPage ueList =BaseStateWithLogin("ListImage");
		 NavBar navBar= new NavBar(getDriver());
		 ueList.clickCreateListAndAdd3Items();
		 ueList.clickOnoptionbtn();
		 ueList.clickOnImageIcon();
		 ueList.putUrlInUploadImageUrlBox("http://www.snatchedxo.com/wp-content/uploads/2015/03/I-heart-you-hanging-Happy-Valentines-Day-2015-Wallpaper.jpg");
		 try{
			 	Thread.sleep(5000);
		 }catch(Exception e){}
		 ueList.clickOnUploadButton();
		 try{
			 	Thread.sleep(5000);
		 }catch(Exception e){}
		 
		 ueList.clickOnDoneUpload();
//		 SafeActions s=new SafeActions(getDriver());
//		 s.waitForPageToLoad(50);
		 try{
			 	Thread.sleep(8000);
		 }catch(Exception e){}
		 String src=ueList.getSrcOfImageIcon();
		 Assert.assertEquals(src,"http://www.snatchedxo.com/wp-content/uploads/2015/03/I-heart-you-hanging-Happy-Valentines-Day-2015-Wallpaper.jpg");
		 ueList.clickOnpublishbtn();
		 try{
			 	Thread.sleep(2000);
		 }catch(Exception e){}
		 //SafeActions s=new SafeActions(getDriver());
		 //s.waitForPageToLoad(20);
		 ueList.clickOnRerankButton();
		 try{
			 	Thread.sleep(12000);
		 }catch(Exception e){}
		 String[] srcbef=ueList.getSrcOfImageIcon().split("/");
		 ueList.clickOncancel();
		 try{
			 	Thread.sleep(2000);
		 }catch(Exception e){}
		 String[] srcAfter=ueList.getSrcOfPublishImage().split("/");
		 Assert.assertEquals(srcAfter[srcAfter.length-1],srcbef[srcbef.length-1]);
	 }//End Of ListImage()
	 /*
		 * Use-case : UE: Add items.
		 * Test case :1) Create a list as guest/logged in user
					 2) Search for node and select any one in auto suggest/select authored node.
	 */
	 @Test(priority=3,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void AddItems(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
	 NavBar navBar= new NavBar(getDriver());
	 UeListPage ueList =BaseStateWithLogin("AddItems");
	 ueList.clickCreateListAndAdd3Items();
	 ueList.clickOnSearch();
	 ueList.typesearchbtn("testing123");
	 ueList.clickonsearchaddbtn();
	 try{
		 Thread.sleep(2000);
	 }catch(Exception e){}
	 String txt=ueList.getTextOfAddedNode("lastNode");
	 Assert.assertEquals(txt, "Testing123");
	 ueList.clickOnpublishbtn();
	 try{
		 Thread.sleep(9000);
	 }catch(Exception e){}
//	 SafeActions s= new SafeActions(getDriver());
//	 s.waitForPageToLoad(50);
	 String pubTxt=ueList.getTextOfPublishAddedNodeText("text");
	
	 Assert.assertEquals(txt, pubTxt);
	 
	 ueList.clicksettingafterpublish();
	 ueList.clickOnAdvancedOption();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 //ueList.clickOndeletelist();
	 }//End Of AddItems()
	 /*
		 * Use-case : UE: Add Node Image.
		 * Test case :1) Create a list as guest/logged in user.
						 2) Add a node and click back(make sure it shows all added items).
						 3) Here click on any node image or add image icon if node doesn't have any image.
						 4) It opens a page in UE where you can add image from flickr or system or throgh url. Add in any of the three ways.
	 */
	 @Test(priority=4,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void AddNodeImage(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("AddNodeImage");
	 NavBar navBar= new NavBar(getDriver());
	 ueList.clickCreateListAndAdd3Items();
	 ueList.clickOnNodeImage(1);
	 String beforesrc=ueList.getsrcimage(1);
	 String[] substring=beforesrc.split("/");
	 ueList.clickonimageaddoption(1);
	 try{
		 Thread.sleep(5000);
	 }catch(Exception e){}
	 ueList.clickonselectbtn();
	 ueList.clickondonebtn();
	 String after=ueList.getsrcaddimage(1);
	 String[] substring1=after.split("/");
	 Assert.assertEquals(substring[substring.length-1],substring1[substring1.length-1]);
	 try{
		 Thread.sleep(8000);
	 }catch(Exception e){}
	 ueList.clickOnpublishbtn();
	 try{
		 Thread.sleep(10000);
	 }catch(Exception e){}
	 SafeActions s=new SafeActions(getDriver());
	 s.waitForPageToLoad(20);
	 String[] aftPublish= ueList.getSrcOfPublishAddedNodeImage("img").split("/");
	 Assert.assertEquals(aftPublish[aftPublish.length-1],substring[substring.length-1]);
	 ueList.clicksettingafterpublish();
	 ueList.clickOnAdvancedOption();
	 ueList.clickOndeletelist();
	// s.waitForPageToLoad(50);
	//ueList.acceptAlert();
	ueList.AlertExistsAndAccepted(1000);
	 }//End Of AddNodeImage()
	 /*
	  * Use-case : UE: Add Node blather.
	  * Test case :1) Create a list as guest/logged in user
				   2) Add a node and click on 'My List' tab(make sure it shows all added items)
						 3) Here click on edit icon beside any node name
						 4) It opens a page in UE where you can see "comment", "image", "video",and "info" icons
						 5) Stay under "comment" and in the below text box add any text
	 */
	 @Test(priority=5,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void AddNodeBlather(String loginRequired) throws Exception{
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
	 UeListPage ueList =BaseStateWithLogin("AddNodeBlather");
	 NavBar navBar= new NavBar(getDriver());
	 ueList.clickCreateListAndAdd3Items();
	 //Base state. (Navigate to node page)
	
	 SafeActions s=new SafeActions(getDriver());
	 s.waitForPageToLoad(5);
	 ueList.hoverOnNodeEdit("edit");
	 ueList.clickOnEditIconsOnNode("comment");
//	 try{
//	 Thread.sleep(5000);
//	 }catch(Exception e){}
		s.waitForPageToLoad(20);
	 ueList.typeInCommentBoxInEdit("This is Blather Testing");
	 ueList.clickondonebtn();
	 String blath=ueList.getTextOfNodeBlather();
	 Assert.assertEquals(blath,"This is Blather Testing");
	 ueList.clickOnpublishbtn();
//	 try{
//		 Thread.sleep(2000);
//	 }catch(Exception e){}
	 
	 s.waitForPageToLoad(10);
	 String blathPub=ueList.getTextOfPublishAddedNodeBlather("blather");
	 Assert.assertEquals(blathPub,blath);
	 ueList.clicksettingafterpublish();
//	 try{
//		 Thread.sleep(2000);
//	 }catch(Exception e){}
	 s.waitForPageToLoad(10);
	 ueList.clickOnAdvancedOption();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End Of AddNodeBlather()
	 /*
	 * Test case :1) Create a list as guest/logged in user
	 				2) Add a node and click on 'My List' tab(make sure it shows all added items)
	 				3) Here click on edit icon beside any node name
		 			4) It opens a page in UE where you can see "comment", "image", "video",and "info" icons
	 				5) Click on video and select any one from suggested video's or search for any other and add
	 */
	 @Test(priority=6,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void AddNodeVideo(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 UeListPage ueList =BaseStateWithLogin("AddNodeVideo");
		 NavBar navBar= new NavBar(getDriver());
		 ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		 ueList.clickCreateListAndAdd3Items();
//		 try{
//			 	Thread.sleep(5000);
//		 }catch(Exception e){}
		 SafeActions s=new SafeActions(getDriver());
		 s.waitForPageToLoad(50);
		 ueList.hoverOnNodeEdit("edit");
		 ueList.clickOnEditIconsOnNode("video");
		 try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		 listoptionpage.putTextInAddvideo("sachin");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
			int count=listoptionpage.Videocount();
			if(count>2){
		     ueList.clickOnVideoInEdit(1);
//		 try{
//			 	Thread.sleep(2000);
//		 }catch(Exception e){}
		 
		 ueList.clickonselectbtn();
		 ueList.clickondonebtn();
		 try {
				Thread.sleep(8000);
			} catch (Exception e) {
			}
		 String[] srcbef=ueList.getSrcOfVideoInNode().split("/img");
		 try{
			 	Thread.sleep(5000);
		 }catch(Exception e){}
		// s.waitForPageToLoad(40);
		 ueList.clickOnpublishbtn();
		 try{
			 	Thread.sleep(15000);
		 }catch(Exception e){}
		 String[] srcAft=ueList.getSrcOfVideoAfterPublish().split("/img");
		 Assert.assertEquals(srcbef[srcbef.length-1], srcAft[srcAft.length-1]);
			}
			else
			{
				Assert.fail("youtube video is not being working");
			}
		  ueList.clicksettingafterpublish();
	      ueList.clickOnAdvancedOption();
		  ueList.clickOndeletelist();
		  ueList.AlertExistsAndAccepted(1000);
			
	 }//End Of AddNodeVideo()
	 /*
	   * Use-case : UE: Add node info(properties).
	   * Test case :1) Create a list as guest/logged in user
	      2) Add a node and click on 'My List' tab(make sure it shows all added items)
	      3) Here click on edit icon beside any node name
	      4) It opens a page in UE where you can see "comment", "image", "video", and "info" icons
	      5) Click on "info" and here add info in the corresponding text fields
	  */
	  @Test(priority=7,dataProviderClass = DataProviders.class, dataProvider ="Login")
	  public void AddNodeInfo(String loginRequired){
	  System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
	  //Base state. (Navigate to node page)
	  UeListPage ueList =BaseStateWithLogin("AddNodeInfo");
	  NavBar navBar= new NavBar(getDriver());
	  ueList.clickCreateListAndAdd3Items();
	//  try{
	//   Thread.sleep(3000);
	//  }catch(Exception e){}
	  SafeActions s=new SafeActions(getDriver());
	  s.waitForPageToLoad(20);
	  ueList.hoverOnNodeEdit("edit");
	//  try{
	//   Thread.sleep(2000);
	//  }catch(Exception e){}
	  s.waitForPageToLoad(40);
	  ueList.clickOnEditIconsOnNode("info");
	//  try{
	//   Thread.sleep(2000);
	//  }catch(Exception e){}
	  s.waitForPageToLoad(40);
	  ueList.putTextInFirstPropInfo("Film");
	  try{
	  Thread.sleep(2000);
	 }catch(Exception e){}
	  ueList.clickondonebtn();
	  try{
	   Thread.sleep(10000);
	  }catch(Exception e){}
	 
	  ueList.hoverOnNodeEdit("edit");
	  ueList.clickOnEditIconsOnNode("info");
	//  try{
	//   Thread.sleep(2000);
	//  }catch(Exception e){}
	  s.waitForPageToLoad(50);
	  Assert.assertEquals(ueList.getTextOfFirstPropInfo(), "Film");
	  s.waitForPageToLoad(40);
	  ueList.clickOnoptionbtn();
	////  try{
	////   Thread.sleep(2000);
	////  }catch(Exception e){}
	  s.waitForPageToLoad(20);
	  ueList.clickOnAdvancedOption();
	  ueList.clickOndeletelist();
	  ueList.AlertExistsAndAccepted(1000);
	  }//End Of AddNodeInfo()
	 /*
		 * Use-case : UE: Edit Node name.
		 * Test case :1) Create a list as guest/logged in user
					 2) Add a node and click 'My List' tab(make sure it shows all added items)
					 3) Here click on edit icon beside any node name
					 4) It opens a page in UE, here n top you can see the node name in a text field, change and click back
	 */
	 @Test(priority=8,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void EditNodeName(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("EditNodeName");
	 NavBar navBar= new NavBar(getDriver());
	 ueList.clickCreateListAndAdd3Items();
	 ueList.hoverOnNodeEdit("edit");
	 ueList.clickOnEditIconsOnNode("comment");
	 try{
		 Thread.sleep(5000);
	 }catch(Exception e){}
//	 SafeActions s= new SafeActions(getDriver());
//	 s.waitForPageToLoad(20);
	 ueList.putTextInNodeNameBoxInEdit("Node Name Changed");
	 try{
		 Thread.sleep(5000);
	 }catch(Exception e){}
	 ueList.clickondonebtn();
	 try{
		 Thread.sleep(9000);
	 }catch(Exception e){}
	// s.waitForPageToLoad(50);
	 
	 String txt=ueList.getTextOfAddedNode("firstNode");
	 Assert.assertEquals(txt, "Node Name Changed");
	 SafeActions s= new SafeActions(getDriver());
	 s.waitForPageToLoad(50);
	 ueList.clickOnoptionbtn();
	 s.waitForPageToLoad(20);
	 ueList.clickOnAdvancedOption();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End Of EditNodeName()
	 /*
		 * Use-case : UE: Delete node.
		 * Test case :1) Create a list as guest/logged in user
					 2) Add a node and click 'My List' tab(make sure it shows all added items)
					 3) Here click on "x" icon beside the node name
	 */
	 @Test(priority=9,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void DeleteNode(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 9 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("DeleteNode");
	 NavBar navBar= new NavBar(getDriver());
	 ueList.clickCreateListAndAdd3Items();
//	 try{
//		 Thread.sleep(2000);
//	 }catch(Exception e){}
	 SafeActions s= new SafeActions(getDriver());
	 s.waitForPageToLoad(20);
	 String first=ueList.getTextOfAddedNode("lastNode");
	 System.out.println("first"+first);
	 ueList.deleteLastNode();
	 try{
		 Thread.sleep(6000);
	 }catch(Exception e){}
	 String second=ueList.getTextOfAddedNode("lastNode");
	 Assert.assertNotEquals(first,second);
	 s.waitForPageToLoad(20);
	 ueList.clickOnoptionbtn();
	 s.waitForPageToLoad(20);
	 ueList.clickOnAdvancedOption();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End Of DeleteNode()
///*	 //////////////////////////
//	 
////	/*
////	 * Use-case : UE: Change items order by drag and drop. Test case :1) Create
////	 * a list as guest/logged in user 2) Add few nodes to the list and click
////	 * back, wher you can see all added items 3) Drag any item and drop in a any
////	 * position you want
////	 */
////	@Test(priority = 10, dataProviderClass = DataProviders.class, dataProvider = "Login")
////	public void DragAndDrop(String loginRequired) {
////		System.out
////				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 10 !!!!!!!!!!!!!!!!!!!!!!!");
////		// Base state. (Navigate to node page)
////		UeListPage ueList = BaseStateWithLogin("DragAndDrop");
////		clickCreateListAndAdd3Items(ueList);
////		try {
////			Thread.sleep(5000);
////		} catch (Exception e) {
////		}
////		String num1 = ueList.getTextOfNode(1);
////		try {
////			Thread.sleep(2000);
////		} catch (Exception e) {
////		}
////		ueList.dragChangeNode(1, 3);
////		try {
////			Thread.sleep(10000);
////		} catch (Exception e) {
////		}
////		String num2 = ueList.getTextOfNode(3);
////		System.out.println("##################2 " + num2);
////		Assert.assertEquals(num1, num2);
////		ueList.clickOnoptionbtn();
////		try {
////			Thread.sleep(2000);
////		} catch (Exception e) {
////		}
////		ueList.clickOndeletelist();
////		try {
////			Thread.sleep(2000);
////		} catch (Exception e) {
////		}
////		ueList.AlertExistsAndAccepted(1000);
////	}// End Of DragAndDrop()
////		 /*
////	 * Use-case : UE: Check multi select drag and drop.
////	 * Test case :1) Create a list as guest/logged in user
////	 2) Add few nodes to the list and click My list, wher you can see all
////	 added items
////	 3) Select more than one item using cntrl button in keyboared and drag all
////	 to required position
////	 */
////	 @Test(priority=11,dataProviderClass = DataProviders.class, dataProvider =
////	 "Login")
////	 public void MultiDragAndDrop(String loginRequired){
////	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 11 !!!!!!!!!!!!!!!!!!!!!!!");
////	 //Base state. (Navigate to node page)
////	 UeListPage ueList =BaseStateWithLogin("MultiDragAndDrop");
////	 clickCreateListAndAdd3Items(ueList);
////	 try{
////	 Thread.sleep(2000);
////	 }catch(Exception e){}
////	 String num3before=ueList.getTextOfNode(1);
////	 String num4before=ueList.getTextOfNode(2);
////	 ueList.multiDrag(1, 2, 4);
////	 try{
////	 Thread.sleep(5000);
////	 }catch(Exception e){}
////	
////	 String num3=ueList.getTextOfNode(3);
////	 Assert.assertEquals(num3before, num3);
////	 String num4=ueList.getTextOfNode(4);
////	 Assert.assertEquals(num4before, num4);
////	 try{
////	 Thread.sleep(2000);
////	 }catch(Exception e){}
////	 // ueList.clickOndeletelist();
////	 }//End Of MultiDragAndDrop()*/
	 /*
		 * Use-case : Check 'authored node' UX on adding to list
		 * Test case :1) Create a list and search for any text
		 				2) Add authored node to list(Click on '+' beside authored node
	 */
	 @Test(priority=12,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void AddAuthoredNode(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("AddAuthoredNode");
	 NavBar navBar= new NavBar(getDriver());
	 ueList.clickCreateListAndAdd3Items();
	 ueList.clickOnSearch();
	 ueList.typesearchbtn("test123");
	 ueList.clickonsearchaddbtn();
	 String txt=ueList.getTextOfAddedNode("lastNode");
	 SafeActions s=new SafeActions(getDriver());
	 s.waitForPageToLoad(10);
	 Assert.assertEquals(txt, "Test123");
	 Assert.assertTrue(ueList.isPresenceAuthorednode());
	 Assert.assertTrue(ueList.isPresenceAuthorednodeinediticon());
	 ueList.clickOnoptionbtn();
	 
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End of AddAuthoredNode()
	 /*
		 * Use-case : Check node image for authored node in search page in UE
		 * Test case :Create a list and search for a text
	 */
	 @Test(priority=13,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void AuthoredNodeiconcheck(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("AuthoredNodeiconcheck");
	 NavBar navBar= new NavBar(getDriver());
	 ueList.clickCreateListAndAdd3Items();
	 ueList.clickOnSearch();
	 ueList.typesearchbtn("test123");
	 ueList.clickonsearchaddbtn();
	 try{
	 Thread.sleep(2000);
	 }catch(Exception e){}
	 String txt=ueList.getTextOfAddedNode("lastNode");
//	 try{
//		 Thread.sleep(2000);
//		 }catch(Exception e){}
	 SafeActions s= new SafeActions(getDriver());
	 s.waitForPageToLoad(20);
	 Assert.assertEquals(txt, "Test123");
	 Assert.assertTrue(ueList.isPresenceAuthorednodecameraicon());
	 ueList.clickOnoptionbtn();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End of AuthoredNodeiconcheck()
	 /*
		 * Use-case : Change items order by numbering
		 * Test case : 1) Create a list as guest/logged in user
						 2) Add few nodes to the list and click on "My List' tab, wher you can see all added items
						 3) Click on any node position number and enter a valid position number
	 */
	 @Test(priority=14,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void NodeNumberChnage(String loginRequired){
	 UeListPage ueList =BaseStateWithLogin("NodeNumberChnage");
	 ueList.clickCreateListAndAdd3Items();
	 String text1=ueList.getTextOfAddedNode("1");
	 ueList.getTypeofnumberingnode("2", 1);
	 String text2=ueList.getTextOfAddedNode("2");
	 Assert.assertEquals(text1, text2);
	 ueList.clickOnoptionbtn();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End of NodeNumberChnage()
	 /*
		 * Use-case : Change list style
		 * Test case : 1) Create a list
						 2) Click on "Options' tab
						 3) This opens settings page, here at top select any one from "list","blog" or "slideshow"
	 */
	 @Test(priority=15,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void ListStyleChange(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 15 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("ListStyleChange");
	 ueList.clickCreateListAndAdd3Items();
	 ueList.clickOnoptionbtn();
	 ueList.clickOnstylechnage();
	 ueList.clickOnpublishbtn();
	 try{
		 Thread.sleep(8000);
	 }catch(Exception e){}
//	 SafeActions s=new SafeActions(getDriver());
//	 s.waitForPageToLoad(20);
	 ueList.clicksettingafterpublish();
	 try{
		 Thread.sleep(10000);
	 }catch(Exception e){}
	 Assert.assertEquals("rgba(8, 108, 184, 1)",ueList.getborderColorlist());
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 } //End of ListStyleChange
	/*
	 * Use-case : UE: Add url.
	 * Test case : 1) Create a list
					 2) Click on "Options" tab
					 3) This opens settings page, here enter a valid url and name to display under display my website url
	 */
	 @Test(priority=16,dataProviderClass = DataProviders.class, dataProvider ="Login")
		 public void AddUrl(String loginRequired){//updated
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 16 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 UeListPage ueList =BaseStateWithLogin("AddUrl");
		 ueList.clickCreateListAndAdd3Items();
		 ueList.clickOnoptionbtn();
		 ueList.clickOnAdvancedOption();
	 	ueList.putTextInUrlNameBox("link","www.google.com");
//	 	try{
//		 	Thread.sleep(6000);
//	 	}catch(Exception e){}
		 SafeActions s=new SafeActions(getDriver());
		 s.waitForPageToLoad(20);
	 	ueList.putTextInDisplayNameBox("title","testing");

	 	ueList.clickInUrlNameBox("link");//have made click here again for saving the text
	 	ueList.clickOnpublishbtn();
//	 	try{
//		 	Thread.sleep(5000);
//	 	}catch(Exception e){}
	 	s.waitForPageToLoad(20);
	 	Assert.assertTrue(ueList.isWebstieUrlAfterPublishPresent());
	 	String txt=ueList.getTextOfWebstieUrlAfterPublish();
	 	Assert.assertEquals(txt,"testing");
	 	ueList.clicksettingafterpublish();
	 	ueList.clickOndeletelist();
	 	ueList.AlertExistsAndAccepted(1000);
	 }//End of AddUrl()
	 /*
		 * Use-case : UE: Add tags.
		 * Test case : 1) Create a list
						 2) Click on "Options" tab
						 3) This opens settings page, here enter your tag name in text field under"add tegs to my list" and click "add tags"
	 */
	 @Test(priority=17,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void AddTags(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 17 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("AddTags");
	 ueList.clickCreateListAndAdd3Items();
//	 try{
//		 Thread.sleep(2000);
//	 }catch(Exception e){}
	 SafeActions s=new SafeActions(getDriver());
	 s.waitForPageToLoad(20);
	 ueList.clickOnoptionbtn();
	 ueList.clickOnAddTagsInUe();
	 ueList.putTextInTagTextBox("textbox", "drama");
	 ueList.clickOnAddTagsPopup("button");
	 try{
		 Thread.sleep(8000);
	 }catch(Exception e){}
	 s.waitForPageToLoad(30);
	 String name=ueList.getTextOfRecentlyAddedTag();
	 Assert.assertEquals("drama", name);
	 ueList.clickOnDoneInAddTags();
	 ueList.clickOnpublishbtn();
	 try{
		 Thread.sleep(2000);
	 }catch(Exception e){}
	 s.waitForPageToLoad(30);
	 ueList.clickOnTagHeadAfterPublish();
	 s.waitForPageToLoad(30);
	 String name1=ueList.getTextOfRecentTagInPopUpAfterPublish();
	 Assert.assertEquals(name.toUpperCase(), name1.toUpperCase());
	 //Deleting the tag.
	 ueList.clicksettingafterpublish();
	 ueList.clickOnAddTagsInUe();
	 int first=ueList.getNumberOfTotalTags();
	 try{
		 Thread.sleep(3000);
	 }catch(Exception e){}
	 s.waitForPageToLoad(30);
	 ueList.clickOnDeleteRecentAddedTags("drama");
	 ueList.clickOnDoneInAddTags();
	 //to check the presence of deleted tag
	 ueList.clickOnoptionbtn();
	 ueList.clickOnAddTagsInUe();
	 int sec=ueList.getNumberOfTotalTags();
	 Assert.assertEquals(first, sec);
//	 try{
//		 Thread.sleep(2000);
//	 }catch(Exception e){}
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End of AddTags()
	 /*
		 * Use-case : Allow your list to embed
		 * Test case : 1) Create a list and go to settings page
		 				2) Here turn "yes" for Embedded as a widget
	 */
	 @Test(priority=18,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void ListEmbedded(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 18 !!!!!!!!!!!!!!!!!!!!!!!");
	 UeListPage ueList =BaseStateWithLogin("ListEmbedded");
	 ueList.clickCreateListAndAdd3Items();
	 ueList.clickOnoptionbtn();
	 ueList.clickOnpublishbtn();
	 SafeActions s=new SafeActions(getDriver());
	 s.waitForPageToLoad(30);
	 Assert.assertTrue(ueList.isPresenceembedbtnafterpublishlist());
	 ueList.clicksettingafterpublish();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End for ListEmbedded
	 /*
		 * Use-case : Un-publish your list
		 * Test case : 1) Open any of your published list
		 				2) go to settings page, turn "yes" for Unpublish my list
	 */
	 @Test(priority=19,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void Unpublishlist(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 19 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("Unpublishlist");
	 ueList.clickCreateListAndAdd3Items();
	 ueList.clickOnpublishbtn();
	 SafeActions s=new SafeActions(getDriver());
	 s.waitForPageToLoad(50);
	 ueList.clicksettingafterpublish();
	 //ueList.clickOnAdvancedOption();
	 try{
		 Thread.sleep(3000);
	 }catch(Exception e){}
	// s.waitForPageToLoad(50);
	 ueList.clickonunpublishedbtn();
	// s.waitForPageToLoad(30);
	 ueList.AlertExistsAndAccepted(1000);
	 ueList.clickOnoptionbtn();
	 //ueList.clickOnAdvancedOption();
	 Assert.assertFalse(ueList.isPresentunpublishedbtn());
//	 ueList.clickOnoptionbtn();
//	 ueList.clickOndeletelist();
//	 ueList.AlertExistsAndAccepted(1000);
	 }//End for Unpublishlist
	 /*
		 * Use-case : Class picker
		 * Test case : 1) Create a list as guest/logged in user
						 2) Add three nodes of a common class
						 3) Search for any node, you will see a dropdown with class names
						 4) Select one from them
	 */
	 @Test(priority=20,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void Classpicker(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 20 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("Classpicker");
	 NavBar navBar= new NavBar(getDriver());
	 navBar.hoverMore();
	 ueList.clickOncreateList();
	 ueList.clickOnreranking();
	 ueList.clickOnListName();
	 ueList.putTextOnListNameBox("Testing List");
	 ueList.clickOnSearch();
	 ueList.typesearchbtn("batman");
	 for(int i=1;i<=10;i++){
		 if(ueList.getTextclass(i).equalsIgnoreCase("film")){
			 for(int j=1;j<=3;j++){
				 ueList.clickOnPlusIcon(i);
			 }
		 }
	 }
	 ueList.clickOndropdown();
//	 try{
//		 Thread.sleep(2000);
//	 }catch(Exception e){}
	 SafeActions s=new SafeActions(getDriver());
	 s.waitForPageToLoad(30);
	 ueList.clickOndropdownselection("Films");
	 try{
		 Thread.sleep(2000);
	 }catch(Exception e){}
	 s.waitForPageToLoad(30);
	 ueList.clickOnPlusIcon(1);
	 ueList.clickOnoptionbtn();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }
	 /*
	 * Use-case : Add List description
	 * Test case : 1) Create a list
	 2) Click on "options" tab
	 3) This opens settings page, enter list description in text field under
	 "Describe your list here"
	 */
	 @Test(priority=21,dataProviderClass = DataProviders.class, dataProvider =
	 "Login")
	 public void ListDescription(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 21 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("ListDescription");
	 ueList.clickCreateListAndAdd3Items();
	 ueList.clickOnmylistdescription();
	 try{
		 Thread.sleep(2000);
		 }catch(Exception e){}
	 ueList.typeInlistdescription("testing");
	 try{
	 Thread.sleep(2000);
	 }catch(Exception e){}
	 ueList.clickOnlistdescriptiondonebtn();
	 Assert.assertEquals("testing", ueList.getTextlistdescription());
	 ueList.clickOnpublishbtn();
	 Assert.assertEquals("testing",ueList.getTextlistdescriptionafterpublish());
	 ueList.clicksettingafterpublish();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End of ListDescription
	 /*
	 * Use-case : Add list criteria
	 * Test case : 1) Create a list
	 2) Click on "options" tab
	 3) This opens settings page, enter list description in text field under
	 "Describe your list here"
	 */
	 @Test(priority=22,dataProviderClass = DataProviders.class, dataProvider =
	 "Login")
	 public void ListCriteria(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 22 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("ListCriteria");
	 ueList.clickCreateListAndAdd3Items();
	 try{
		 Thread.sleep(2000);
		 }catch(Exception e){}
	 ueList.clickOnmylistdescription();
	 ueList.typelistcriteria("Testing criteria");
	 SafeActions s = new SafeActions(getDriver());
	    s.waitForPageToLoad(40);
	 try{
	 Thread.sleep(2000);
	 }catch(Exception e){}
	 ueList.clickOnlistdescriptiondonebtn();
	 ueList.clickOnpublishbtn();
	 try{
		 Thread.sleep(2000);
	 }catch(Exception e){}
	 Assert.assertEquals("Testing criteria",ueList.getTextlistcriteriaafterpublish());
	 ueList.clicksettingafterpublish();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End of ListCriteria
	 /*
	 * Use-case : Turn on voting
	 * Test case : 1) Create a list
	 2) Click on "Options" tab
	 3) This opens settings page, here check "yes" for "vote on my list"
	 */
	 @Test(priority=23,dataProviderClass = DataProviders.class, dataProvider =
	 "Login")
	 public void ListVoting(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 23 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("ListVoting");
	 ueList.clickCreateListAndAdd3Items();
	 ueList.clickOnoptionbtn();
	 ueList.clickOnvotingoption();
	 SafeActions s = new SafeActions(getDriver());
	    s.waitForPageToLoad(40);
	 try{
	 Thread.sleep(2000);
	 }catch(Exception e){}
	 ueList.clickOnpublishbtn();
	 try{
	 Thread.sleep(2000);
	 }catch(Exception e){}
	 Assert.assertTrue(ueList.isPresentsvoteoption());
	 ueList.clicksettingafterpublish();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End of ListVoting
	 /*
	 * Use-case : Make open list
	 * Test case : 1) Create a list
	 2) Click on "options" tab
	 3) This opens settings page, here check "yes" for "Add stuff to my list"
	 */
	 @Test(priority=24,dataProviderClass = DataProviders.class, dataProvider =
	 "Login")
	 public void AddMyList(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 24 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("AddMyList");
	 ueList.clickCreateListAndAdd3Items();
	 ueList.clickOnoptionbtn();
	 try{
		 Thread.sleep(5000);
		 }catch(Exception e){}
	 ueList.clickOnadditmesinmylist();
	 SafeActions s = new SafeActions(getDriver());
     s.waitForPageToLoad(60);
	 ueList.clickOnpublishbtn();
	 try{
		 Thread.sleep(5000);
		 }catch(Exception e){}
	 Assert.assertTrue(ueList.isPresentsmylist());
	 ueList.clicksettingafterpublish();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End of AddMyList
	 /*
	 * Use-case : Make your list as rerank enabled
	 * Test case : 1) Create a list
	 2) Click on "Options" tab
	 3) This opens settings page, here check "yes" for Make thier own version
	 */
	 @Test(priority=25,dataProviderClass = DataProviders.class, dataProvider =
	 "Login")
	 public void RerankList(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 25 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("RerankList");
	 ueList.clickCreateListAndAdd3Items();
	 ueList.clickOnoptionbtn();
	 Assert.assertTrue(ueList.isPresentsreranklist());
//	 SafeActions s = new SafeActions(getDriver());
//     s.waitForPageToLoad(40);
	  try{
	  Thread.sleep(5000);
	  }catch(Exception e){}
	 ueList.clickOnpublishbtn();
	  try{
	  Thread.sleep(5000);
	  }catch(Exception e){}
	 Assert.assertTrue(ueList.isPresentsreranklistafterpublish());
	 ueList.clicksettingafterpublish();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End of RerankList
	 /*
	 * Use-case : Make your list as countdown
	 * Test case : 1) Create a list
	 2) Click on "Options" tab
	 3) This opens settings page, here check "yes" for "Make it count down"
	 */
	 @Test(priority=26,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void CountDownList(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 26 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("CountDownList");
	 ueList.clickCreateListAndAdd3Items();
	 ueList.clickOnoptionbtn();
	 ueList.clickOnreranklist();
	 ueList.clickonembedbtn();
	 SafeActions s=new SafeActions(getDriver());
	 s.waitForPageToLoad(40);
	 ueList.clickOnpublishbtn();
	 try{
	 Thread.sleep(3000);
	 }catch(Exception e){}
	 String beforenum=ueList.getnumberofnodebeforecountdown();
	 ueList.clicksettingafterpublish();
	 ueList.clickonembedbtn();
	 ueList.clickOnAdvancedOption();
	 //SafeActions s=new SafeActions(getDriver());
	 s.waitForPageToLoad(40);
//	 try{
//	 Thread.sleep(3000);
//	 }catch(Exception e){}
	 ueList.clickOncountdownlist();
	 s.waitForPageToLoad(40);
//	 try{
//	 Thread.sleep(3000);
//	 }catch(Exception e){}
	 ueList.clickOnpublishbtn();
	 try{
	 Thread.sleep(5000);
	 }catch(Exception e){}
	 //s.waitForPageToLoad(60);
	 String afternum=ueList.getnumberofnodebeforecountdown();
	 s.waitForPageToLoad(40);
	 Assert.assertNotEquals(afternum, beforenum);
	 ueList.clicksettingafterpublish();
	 try{
	 Thread.sleep(2000);
	 }catch(Exception e){}
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End of CountDownList
	 /*
	 * Use-case : Dont show item numbers in your list
	 * Test case : 1) Create a list
	 2) Click on "Options" tab
	 3) This opens settings page, here check "no" for display item numbers
	 */
	 @Test(priority=27,dataProviderClass = DataProviders.class, dataProvider =
	 "Login")
	 public void ItemNumber(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 27 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("ItemNumber");
	 ueList.clickCreateListAndAdd3Items();
	 ueList.clickOnoptionbtn();
	 ueList.clickOnreranklist();
	 ueList.clickonembedbtn();
	 ueList.clickOnAdvancedOption();
	 ueList.clickOnitemnumberlist();
	 ueList.clickOnpublishbtn();
	 Assert.assertFalse(ueList.isPresentsitemnumberlistafterpublish());
	 ueList.clicksettingafterpublish();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End of ItemNumber
	 /*
	 * Use-case : Display item additional info
	 * Test case : 1) Create a list
					 2) Click on "options" tab
					 3) This opens settings page, here check "yes" for display additional item info
	 */
	 @Test(priority=28,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ItemInfo(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 28 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 UeListPage ueList =BaseStateWithLogin("ItemInfo");
		 ueList.clickCreateListAndAdd3Items();
		 ueList.clickOnoptionbtn();
		 ueList.clickOnAdvancedOption();
		 Assert.assertFalse(ueList.isPresentsiteminfolist());
		 ueList.clickOnstylechnage();
		 ueList.clickOnAdvancedOption();
		 ueList.clickOndisplayProperty();
		 ueList.clickondoneinfobtn();
		 try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		 ueList.clickOnpublishbtn();
		 try {
				Thread.sleep(8000);
			} catch (Exception e) {
			}
		 Assert.assertNotNull(ueList.getTextiteminfolistafterpublish());
		 ueList.clicksettingafterpublish();
		  try{
		  Thread.sleep(2000);
		  }catch(Exception e){}
		 ueList.clickOndeletelist();
		 ueList.AlertExistsAndAccepted(1000);
	 }//End of ItemInfo
	 /*
	 * Use-case : Add auto videos to list items
	 * Test case : 1) Create a lists in film/songs class
					 2) Click on "options" tab
					 3) This opens settings page, here check "yes" for "Auto add videos to items"
	 */
	 @Test(priority=29,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void AutoAddVideos(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 29 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("AutoAddVideos");
	 NavBar navBar= new NavBar(getDriver());
	 navBar.hoverMore();
	 ueList.clickOncreateList();
	 ueList.clickOnreranking();
	 ueList.clickOnListName();
	 ueList.putTextOnListNameBox("Testing Film");
	 ueList.clickOnSearch();
	 ueList.typesearchbtn("batman");
	 for(int i=1;i<=10;i++){
		 if(ueList.getTextclass(i).equalsIgnoreCase("film")){
			 for(int j=1;j<=3;j++){
				 ueList.clickOnPlusIcon(i);
					 try{
					 Thread.sleep(2000);
					 }catch(Exception e){}
			 }
		 }
	 }
	 ueList.clickOnSearch();
	 ueList.typesearchbtn("sachin");
	 try{
	 Thread.sleep(3000);
	 }catch(Exception e){}
	 ueList.clickOnPlusIcon(1);
	 ueList.clickOnislistabout_yes();
	// s.waitForPageToLoad(40);
	  try{
	  Thread.sleep(4000);
	  }catch(Exception e){}
	 ueList.clickOnoptionbtn();
	 ueList.clickOnAdvancedOption();
	// s.waitForPageToLoad(40);
	 try{
	 Thread.sleep(3000);
	 }catch(Exception e){}
	 ueList.clickOnaddautovideo_yes();
	  try{
	  Thread.sleep(3000);
	  }catch(Exception e){}
	 ueList.clickOnpublishbtn();
	  try{
	  Thread.sleep(6000);
	  }catch(Exception e){}
	 Assert.assertTrue(ueList.isPresentsvideoimage());
	 ueList.clicksettingafterpublish();
	  try{
	  Thread.sleep(2000);
	  }catch(Exception e){}
	 ueList.clickOndeletelist();
		//	  try{
		//	  Thread.sleep(2000);
		//	  }catch(Exception e){}
	 ueList.AlertExistsAndAccepted(2000);
}//End for AutoAddVideos
	 /*
	  * Use-case : Choose the default property to display
	  * Test case : 1) Create a list in any class
			 		2) Click on "options" tab
		 			3) This opens settings page, here select the type of property to be displayed in a dropdown beside "Change the kind of info displayed"
	 */
	 @Test(priority=30,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void PropertyDisplay(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 30 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 UeListPage ueList =BaseStateWithLogin("PropertyDisplay");
		 NavBar navBar= new NavBar(getDriver());
		 navBar.hoverMore();
		 ueList.clickOncreateList();
		 ueList.clickOnreranking();
		 ueList.clickOnListName();
		 ueList.putTextOnListNameBox("Testing Film3");
		 ueList.clickOnSearch();
		 ueList.typesearchbtn("batman");
		 for(int i=1;i<=10;i++){
			 if(ueList.getTextclass(i).equalsIgnoreCase("film")){
				 for(int j=1;j<=3;j++){
					 ueList.clickOnPlusIcon(i);
//					 try{
//					 		Thread.sleep(2000);
//				 	}catch(Exception e){}
			 	}
			 }
		 }
		 ueList.clickOnSearch();
		 ueList.typesearchbtn("sachin");
//		 SafeActions s=new SafeActions(getDriver());
//		 s.waitForPageToLoad(40);
		 try{
			 	Thread.sleep(5000);
		 }catch(Exception e){}
		 // ueList.clickOnPlusIcon(1);
		 ueList.clickOnislistabout_yes();
		// s.waitForPageToLoad(40);
		 // ueList.clickOnPlusIcon(1);
//		 try{
//			 	Thread.sleep(3000);
//		 }catch(Exception e){}
		 ueList.clickOnoptionbtn();
		 ueList.clickOnAdvancedOption();
		// s.waitForPageToLoad(40);
		 try{
			 	Thread.sleep(2000);
		 }catch(Exception e){}
		 ueList.clickOndisplayProperty();
		 ueList.clickOndefaultProprty(2,"radioBtn");
		// s.waitForPageToLoad(40);
//		 /tch(Exception e){}
		 ueList.clickOndefaultProprtyDonebtn();
		 ueList.clickOnpublishbtn();
		 try{
			 	Thread.sleep(3000);
		 }catch(Exception e){}
		 Assert.assertNotNull(ueList.getTextdefault_proprty_afterpublish());
		 ueList.clicksettingafterpublish();
		 ueList.clickOndeletelist();
		 ueList.AlertExistsAndAccepted(1000);
	 }//End for PropertyDisplay
	 /*
	 * Use-case : Enable Ratings
	 * Test case : 1) Create list in any of classes music, film, video games &
	 tv
	 2) Go to settings page, here chck "yes" for Enable ratings
	 */
	 @Test(priority=31,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void EnableRating(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 31 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("EnableRating");
	 NavBar navBar= new NavBar(getDriver());
	 navBar.hoverMore();
	 ueList.clickOncreateList();
	 ueList.clickOnreranking();
	 SafeActions s= new SafeActions(getDriver());
	 s.waitForPageToLoad(60);
	 ueList.clickOnListName();
	 ueList.putTextOnListNameBox("Testing Film3");
	 ueList.clickOnSearch();
	 ueList.typesearchbtn("batman");
	 for(int i=1;i<=10;i++){
		 if(ueList.getTextclass(i).equalsIgnoreCase("film")){
			 for(int j=1;j<=3;j++){
				 ueList.clickOnPlusIcon(i);
				 s.waitForPageToLoad(60);
			 }
		 }
	 }
	 ueList.clickOnSearch();
	 ueList.typesearchbtn("sachin");
	// SafeActions s= new SafeActions(getDriver());
	 s.waitForPageToLoad(60);
	 ueList.clickOnislistabout_yes();
	 ueList.clickOnoptionbtn();
	 ueList.clickOnAdvancedOption();
	 ueList.clickOnenable_rating();
	 ueList.clickOnpublishbtn();
	// SafeActions s= new SafeActions(getDriver());
	 s.waitForPageToLoad(80);
	 ueList.clickeditafterpublish();
	 try{
	 Thread.sleep(8000);
	 }catch(Exception e){}
	 ueList.hoverOnNodeEdit("edit");
	 ueList.clickOnEditIconsOnNode("rating");
	// s.waitForPageToLoad(70);
	 try{
	 Thread.sleep(8000);
	 }catch( Exception e){}
	 ueList.getsetOfRating("30");
	 //s.waitForPageToLoad(60);
	 try{
	 Thread.sleep(10000);
	 }catch(Exception e){}
	// ueList.clickOn_rating_value();
	 try{
	 Thread.sleep(3000);
	 }catch(Exception e){}
	 ueList.clickondonebtn();
	 ueList.hoverOnNodeEdit("delete");
	 s.waitForPageToLoad(50);
	 try{
	 Thread.sleep(5000);
	 }catch(Exception e){}
	 ueList.hoverOnNodeEdit("edit");
	 ueList.clickOnEditIconsOnNode("rating");
	// s.waitForPageToLoad(50);
	 try{
	 Thread.sleep(10000);
	 }catch(Exception e){}
	 String beforerating=ueList.ratingofnode();
	 try{
		 Thread.sleep(5000);
		 }catch(Exception e){}
	 ueList.clickondonebtn();
	 ueList.clickOnpublishbtn();
	// s.waitForPageToLoad(50);
	 try{
	 Thread.sleep(10000);
	 }catch(Exception e){}
	 String afterrating= ueList.rating_afterpublish();
	 Assert.assertEquals(afterrating, "rated: "+beforerating);
	 ueList.clicksettingafterpublish();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End for EnableRating
	 /*
	 * Use-case : Dont show item numbers in your list
	 * Test case : 1) Create a list
	 2) Click on "Options" tab
	 3) This opens settings page, here check "no" for display item numbers
	 */
	 @Test(priority=32,dataProviderClass = DataProviders.class, dataProvider =
	 "Login")
	 public void DeleteList(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 32 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("DeleteList");
	 ueList.clickCreateListAndAdd3Items();
	 ueList.clickOnoptionbtn();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End of DeleteList
	 /*
	 * Use-case : Dont show item numbers in your list
	 * Test case : 1) Create a list
	 2) Click on "Options" tab
	 3) This opens settings page, here check "no" for display item numbers
	 */
	 @Test(priority=33,dataProviderClass = DataProviders.class, dataProvider =
	 "Login")
	 public void PublishList(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 33 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("PublishList");
	 ueList.clickCreateListAndAdd3Items();
	 String beforelistname=ueList.getTextOfListName();
	 ueList.clickOnpublishbtn();
	 String afterlistname=ueList.getTextOFHeaderAfterPublish();
	 Assert.assertTrue(ueList.isPresenpublished_list());
	 Assert.assertEquals(afterlistname, beforelistname);
	 ueList.clicksettingafterpublish();
	// ueList.clickOnAdvancedOption();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End of PublishList
	 /*
	 * Use-case : Close the UE
	 * Test case : 1) Create a list or edit any of your esisting lists
	 2) Click 'close / save list' appear in bottom left of UE
	 */
	 @Test(priority=34,dataProviderClass = DataProviders.class, dataProvider =
	 "Login")
	 public void Close_UE(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 34 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("Close_UE");
	 ueList.clickCreateListAndAdd3Items();
	 String beforelistname=ueList.getTextOfListName();
	 ueList.clickOnpublishbtn();
	 try {
			Thread.sleep(10000);
		} catch (Exception e) {
		}
	 ueList.clicksettingafterpublish();
	 //ueList.clickeditafterpublish();
	 try {
		Thread.sleep(7000);
	} catch (Exception e) {
	}
	 ueList.clickOnSaveUe();
	 String afterlistname=ueList.getTextOFHeaderAfterPublish();
	 Assert.assertTrue(ueList.isPresenpublished_list());
	 Assert.assertEquals(afterlistname, beforelistname);
	 SafeActions s= new SafeActions(getDriver());
	 s.waitForPageToLoad(50);
	 ueList.clicksettingafterpublish();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End of Close_UE
	 /*
	 * Use-case : Test for long nodes
	 * Test case : 1) Create a list
	 2) Search for a long node i.e by entering long text in add your item
	 search field
	 */
	 @Test(priority=35,dataProviderClass = DataProviders.class, dataProvider =
	 "Login")
	 public void TestForLongNode(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 35 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("TestForLongNode");
	 ueList.clickCreateListAndAdd3Items();
	 ueList.clickOnSearch();
	 ueList.typesearchbtn("I'm a Celebrity...Get Me Out of Here!");
	 try{
	 Thread.sleep(3000);
	 }catch(Exception e){}
	 Assert.assertEquals("I'm a Celebrity...Get Me Out of Here!",
	 ueList.getTextofsearch_node(1));
	 //ueList.clickOnPlusIcon(1);
	 }//End of TestForLongNode_
	 /*
	  * Use-case : Check for special characters
	  * Test case : Attempt to enter alternate/foreign characters into each of the fields (node name, description, node title, node description).
	  *             Use the table found here: http://www.tedmontgomery.com/tutorial/altchrc.html
	 */
	 @Test(priority=36,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void EnterSpecialCharacter(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 36 !!!!!!!!!!!!!!!!!!!!!!!");
		 String chararcter="!@#$%^&*()_-=|\\}]{[<>,.?\''";
		 UeListPage ueList =BaseStateWithLogin("EnterSpecialCharacter");
		 ueList.clickCreateListAndAdd3Items();
		 ueList.clickOnSearch();
		 ueList.typesearchbtn(chararcter);
		 try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 ueList.clickonsearchaddbtn();
		 String txt=ueList.getTextOfAddedNode("lastNode");
		 Assert.assertEquals(chararcter, txt);
		 ueList.clickOnListName();
		 ueList.putTextOnListNameBox(chararcter);
		 String txt1= ueList.getTextOfListName();
		 Assert.assertEquals(chararcter, txt1);
		 ueList.clickOnmylistdescription();
		 try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		 ueList.typeInlistdescription(chararcter);
		 ueList.typelistcriteria(chararcter);
		 ueList.clickOnlistdescriptiondonebtn();
		 String text3=ueList.getTextlistdescription();
		 Assert.assertEquals(chararcter, text3);
		 ueList.clickOnpublishbtn();
		 try{
			 Thread.sleep(8000);
		 }catch(Exception e){}
		 String text4=ueList.getTextlistcriteriaafterpublish();
		 Assert.assertEquals(chararcter, text4);
		 ueList.clicksettingafterpublish();
		 ueList.clickOndeletelist();
		 ueList.AlertExistsAndAccepted(1000);
	 }//End of EnterSpecialCharacter
	 /*
		 * Use-case : Check Vote moving.
		 * Test case : Login to QA
					 - Create New List ON QA Named "Test Vote Moving List <DATE>"
					 - Add ten authored node items to list named "Item One","Item Two"....etc...to "Item Ten"
					 - Make list votable and Publish List
					 - Vote positively on the top 5 items (items named "Item One"...to "Item Five") and negatively on the bottom five items("Item Six"...to..."Item Ten")
					 - Check to make sure that items 1-5 remain above items 6-10, if not,create a ticket.
					 - Vote down on "Item Two" and make sure it goes to position 5, if not,create a ticket.
					 - Vote up on "Item Ten" and make sure it goes to position 5, if not,create a ticket.
	 */
	 @Test(priority=37,dataProviderClass = DataProviders.class, dataProvider ="Login")
		 public void VoteMoving(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 37 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 UeListPage ueList =BaseStateWithLogin("VoteMoving");
		 NavBar navBar= new NavBar(getDriver());
		 navBar.hoverMore();
		 ueList.clickOncreateList();
		 ueList.clickOnreranking();
		 ueList.clickOnListName();
		 ueList.putTextOnListNameBox("Test Vote Moving List");
		 ueList.clickOnSearch();
		 ueList.typesearchbtn("batman");
		 for(int i=1;i<=10;i++){
			 ueList.clickOnPlusIcon(i);
		 }
		 ueList.clickOnoptionbtn();
		 ueList.clickOnvotingoption();
		 ueList.clickOnpublishbtn();
		 for(int i=1;i<=5;i++){
			 String txt1=ueList.getTextOfListNodeNameAfterPublish(i);
			 ueList.clickOnVoting(i, "up");
			 String txt2=ueList.getTextOfListNodeNameAfterPublish(i);
			 Assert.assertEquals(txt1, txt2);
		 }
//		 try {
//			Thread.sleep(3000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		 for(int i=6;i<=10;i++){
			 String txt1=ueList.getTextOfListNodeNameAfterPublish(i);
			 try {
				Thread.sleep(3000);
			} catch (Exception e) {}
				// TODO: handle exception
		
			 ueList.clickOnVoting(i, "down");
			 String txt2=ueList.getTextOfListNodeNameAfterPublish(i);
			 Assert.assertEquals(txt1, txt2);
		 }
		 String txt1=ueList.getTextOfListNodeNameAfterPublish(2);
			 try{
			 Thread.sleep(4000);
			 }catch(Exception e){}
		 ueList.clickOnVoting(2, "down");
		 String txt2=ueList.getTextOfListNodeNameAfterPublish(5);
		 Assert.assertEquals(txt1, txt2);
		
		 txt1=ueList.getTextOfListNodeNameAfterPublish(10);
		 ueList.clickOnVoting(10, "up");
		 txt2=ueList.getTextOfListNodeNameAfterPublish(5);
		 Assert.assertEquals(txt1, txt2);
		 ueList.clickOndeletelist();
			 try{
			 Thread.sleep(2000);
			 }catch(Exception e){}
		 ueList.AlertExistsAndAccepted(1000);
	 }//End for VoteMoving()
	 /*
	 * Use-case : Verify copy and view functionality in UE
	 * Test case : Open any of your old vote list: http://www.ranker-qa.com/list/south-park-facts/testvikas1.Login from : testvikas1/123456
	 Click edit list Open Advance settings Click copy and view and publish new list
	 */
	 @Test(priority=38,dataProviderClass = DataProviders.class, dataProvider =
	 "Login")
	 public void CopyViewList(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 38 !!!!!!!!!!!!!!!!!!!!!!!");
	 try {
			startRecording("CopyViewList");
		} catch (Exception e) {
		}
	 common = new Commonpage(getDriver());
	 UeListPage ueList = common.getUeListPage(url);
	 //UeListPage ueList =BaseStateWithLogin("Copy_ViewList");
	    common.signin("tc111","testing");
	  // common.getNewURL(config.getProperty("Url")+"list/list-v1/testvikas1");
	    
	 common.getNewURL(config.getProperty("Url")+"list/best-singer-in-bollywood/tc111");
	 try{
		 Thread.sleep(10000);
		 }catch(Exception e){}
	 ueList.clickeditafterpublish();
	 String before=ueList.getTextOffirstnode();
	 System.out.println("before=="+before);
		 try{
		 Thread.sleep(5000);
		 }catch(Exception e){}
	 ueList.clickOnoptionbtn();
	 ueList.clickOnAdvancedOption();
		 try{
		 Thread.sleep(8000);
		 }catch(Exception e){}
	 ueList.clickOncopy_viewbutton();
		 try{
		 Thread.sleep(5000);
		 }catch(Exception e){}
	 ueList.putTextOnListNameBox("Copy List");
		 try{
		 Thread.sleep(2000);
		 }catch(Exception e){}
	 ueList.clickOnpublishbtn();
	 try{
		 Thread.sleep(10000);
		 }catch(Exception e){}
	 String after=ueList.getTextOfcopy_firstnode();
	 
	 System.out.println("after==="+after);
	 Assert.assertEquals(before, after);
	 try{
		 Thread.sleep(3000);
		 }catch(Exception e){}
	 ueList.clicksettingafterpublish();
	 ueList.clickOnAdvancedOption();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
}//End of Copy_ViewList
	 /*
	 * Use-case : Auto Assign Class
	 * Test case : 1) Create a list in anything class
					2) Add 10 items out of nine iteme in one class and other as authored node
	 */
	 @Test(priority=39,dataProviderClass = DataProviders.class, dataProvider =
	 "Login")
	 public void AutoAssignClass(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 39 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 UeListPage ueList =BaseStateWithLogin("AutoAssignClass");
	 NavBar navBar= new NavBar(getDriver());
	 navBar.hoverMore();
	 ueList.clickOncreateList();
	 ueList.clickOnreranking();
	 ueList.clickOnListName();
	 ueList.putTextOnListNameBox("Testing List");
	 ueList.clickOnSearch();
	 ueList.typesearchbtn("batman");
	 for(int i=1;i<=15;i++){
		 if(ueList.getTextclass(i).equalsIgnoreCase("film")){
			 for(int j=1;j<=5;j++){
				 ueList.clickOnPlusIcon(i);
			 }
	 	 }
	 }
	 
	 try{
		 Thread.sleep(2000);
		 }catch(Exception e){}
	 ueList.clickOnSearch();
	 ueList.typesearchbtn("test123");
	 ueList.clickonsearchaddbtn();
	 String txt=ueList.getTextOfAddedNode("lastNode");
	 try{
		 Thread.sleep(2000);
		 }catch(Exception e){}
	 Assert.assertEquals(txt, "Test123");
	 ueList.clickOnpublishbtn();
	 ueList.clicksettingafterpublish();
	 ueList.clickOnAdvancedOption();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);
	 }//End for AutoAssignClass
	 /*
		 * Use-case : UE:List preview for unpublish list
		 * Test case : 1-Create a list as guest/logged in user
					   2-Add some nodes in it
					   3-Click on "preview" button on bottom of popup
		 */
		 @Test(priority=40,dataProviderClass = DataProviders.class, dataProvider ="Login")
		 public void PreviewList(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 40 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 UeListPage ueList =BaseStateWithLogin("PreviewList");
		 NavBar navBar= new NavBar(getDriver());
		 navBar.hoverMore();
		 ueList.clickOncreateList();
		 ueList.clickOnreranking();
		 ueList.clickOnListName();
		 ueList.putTextOnListNameBox("Testing List");
		 ueList.clickOnSearch();
		 ueList.typesearchbtn("batman");
		 for(int i=1;i<=5;i++){
			 ueList.clickOnPlusIcon(i);
			 }
		 ueList.clickOnoptionbtn();
		 ueList.clickOnviewlistmode();
		 ueList.clickOnpreview();
		 Assert.assertTrue(ueList.isPresentlistPreview());
		 ueList.clickOncross();
		 try{
			 Thread.sleep(5000);
			 }catch(Exception e){}
		 Assert.assertFalse(ueList.isDisplaylistPreview());
		 }//End for AutoAssignClass
		 /*
		 * Use-case :   UE: Create a list as a guest, sign in after submit - Facebook
		 * Test case :" 1) Create a list while logged out
						2) Hit the Submit button
						3) The Sign Up dialogue should appear
						4) Click on the Sign In link then sign in to Ranker through your facebook+"
	*/
	@Test(priority=41,dataProviderClass = DataProviders.class, dataProvider ="Login")
	public void FacebookLoginGuestuser(String loginRequired){
	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 41 !!!!!!!!!!!!!!!!!!!!!!!");
	Commonpage common = new Commonpage(getDriver());
	RerankPage rerankpage = common.getRerankPage(url);
	UserProfilePage profile = common.getUserProfilePage(url);
	ListOptionPage listoptionpage = common.getListOptionPage(url);
	UeListPage ueList =BaseState("FacebookLoginGuestuser");
	NavBar navBar= new NavBar(getDriver());
	navBar.hoverMore();
	ueList.clickOncreateList();
	ueList.clickOnreranking();
	 if(ueList.isStickyPresent()==true){
	 ueList.clickStickyOK();
	 }
	ueList.clickOnListName();
	ueList.putTextOnListNameBox("Testing facebook");
	ueList.clickOnSearch();
	ueList.typesearchbtn("Batman");
	for (int i = 1; i <= 3; i++) {
		ueList.clickOnPlusIcon(i);
	}
	ueList.clickOnpublishbtn();
	try{
		 Thread.sleep(4000);
	}catch(Exception e){}
	ueList.clickOnfacebook();
	try {
		Thread.sleep(2000);
	} catch (Exception e) {
	}
	rerankpage.facebooklogin("vikas@ranker.com", "vikas@123");
	try {
		Thread.sleep(3000);
	} catch (Exception e) {
	}
	 rerankpage.clickonloginbtn();
	 try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	     
	     listoptionpage.switchToParentWindow();
	     try {
				Thread.sleep(25000);
			} catch (Exception e) {
			}
	     String head=ueList.getTextOFlistHeaderAfterPublish();
	     String afterurl[]=getDriver().getCurrentUrl().split("\\?");
		 Assert.assertEquals(head,afterurl[0]);
		
	}//End Of FacebookLoginGuestuser()
	 /*
	 * Use-case :   UE: Create a list as a guest, sign in after submit - Twitter
	 * Test case :" 1) Create a list while logged out
					2) Hit the Submit button
					3) The Sign Up dialogue should appear
					4) Click on the Sign In link then sign in to Ranker through your Twitter
*/
	@Test(priority=42,dataProviderClass = DataProviders.class, dataProvider ="Login")
	 public void TwitterLoginGuestuser(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 42 !!!!!!!!!!!!!!!!!!!!!!!");
	  common = new Commonpage(getDriver());
	 RerankPage rerankpage = new RerankPage(getDriver());//.getRerankPage(url);
	 UserProfilePage profile = new UserProfilePage(getDriver());//common.getUserProfilePage(url);
	 ListOptionPage listoptionpage = new ListOptionPage(getDriver());//common.getListOptionPage(url);
	 UeListPage ueList =BaseState("TwitterLoginGuestuser");
	 NavBar navBar= new NavBar(getDriver());
	 navBar.hoverMore();
	 ueList.clickOncreateList();
	 ueList.clickOnreranking();
	// if(ueList.isStickyPresent()==true){
	// ueList.clickStickyOK();
	// }
	 ueList.clickOnListName();
	 ueList.putTextOnListNameBox("Testing Twitter");
	 ueList.clickOnSearch();
	 ueList.typesearchbtn("Batman");
	 for (int i = 1; i <= 3; i++) {
	  ueList.clickOnPlusIcon(i);
	 }
	 ueList.clickOnpublishbtn();
	 try{
	   Thread.sleep(4000);
	 }catch(Exception e){}
	 ueList.clickOntwitter();
	 try {
	  Thread.sleep(5000);
	 } catch (Exception e) {
	 }
	 common.twitterLogin("vikassolanki1809@gmail.com","vikas@123");
	 //rerankpage.facebooklogin("salmankhantc", "Dehradun1");
	 try {
	  Thread.sleep(3000);
	 } catch (Exception e) {
	 }
	 listoptionpage.switchToParentWindow();
     try {
			Thread.sleep(25000);
		} catch (Exception e) {
		}
     String head=ueList.getTextOFlistHeaderAfterPublish();
     String afterurl[]=getDriver().getCurrentUrl().split("\\?");
	 Assert.assertEquals(head,afterurl[0]);
	 //list.switchToParentWindow(0);
	 }//End Of TwitterLoginGuestuser()
 
	
	 /*
	 * Use-case :    UE: Create a list as a guest, sign in after submit - Email
	 * Test case :" 1) Create a list while logged out
					2) Hit the Submit button
					3) The Sign Up dialogue should appear
					4) Click on the Sign In link then sign in to Ranker through your Google+
*/
	@Test(priority=43,dataProviderClass = DataProviders.class, dataProvider ="Login")
	public void EmailLoginGuestuser(String loginRequired){
	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 43 !!!!!!!!!!!!!!!!!!!!!!!");
	 common = new Commonpage(getDriver());
	RerankPage rerankpage = new RerankPage(getDriver());//.getRerankPage(url);
	UserProfilePage profile = new UserProfilePage(getDriver());//common.getUserProfilePage(url);
	ListOptionPage listoptionpage = new ListOptionPage(getDriver());//common.getListOptionPage(url);
	UeListPage ueList =BaseState("EmailLoginGuestuser");
	NavBar navBar= new NavBar(getDriver());
	navBar.hoverMore();
	ueList.clickOncreateList();
	ueList.clickOnreranking();
//	if(ueList.isStickyPresent()==true){
//	ueList.clickStickyOK();
//	}
	ueList.clickOnListName();
	ueList.putTextOnListNameBox("Testing email");
	ueList.clickOnSearch();
	ueList.typesearchbtn("Batman");
	for (int i = 1; i <= 3; i++) {
		ueList.clickOnPlusIcon(i);
	}
	ueList.clickOnpublishbtn();
	try{
		 Thread.sleep(7000);
	}catch(Exception e){}
	ueList.clickOnemail();
	try {
		Thread.sleep(7000);
	} catch (Exception e) {
	}
	common.emailLogin("kallol"+common.randInt(1, 10000),"kallol"+common.randInt(1, 10000)+"@ranker.com","123456");
	try {
		Thread.sleep(15000);
	} catch (Exception e) {}   
	    //listoptionpage.switchToParentWindow();
	    String head=ueList.getTextOFlistHeaderAfterPublish();
	    String afterurl[]=getDriver().getCurrentUrl().split("\\?");
		Assert.assertEquals(head,afterurl[0]);
		
		//Delete the Account
		profile.clickOnProfile();
    	profile.clickOnviewProfile();
    	profile.clickOnSettingsBtn();
    	profile.clickOnaccountSettings();
    	profile.clickOnDeleteAccount();
		common.AlertExistsAndAccepted(2000);

	}//End Of EmailLoginGuestuser()
	 /*
	 * Use-case :   UE: Create a list as a guest, sign in after submit - Google+
	 * Test case :" "1) Create a list while logged out
					 2) Hit the Submit button
					 3) The Sign Up dialogue should appear
					 4) Click on the Sign In link then sign in to Ranker through your Google+"
*/
	@Test(priority=44,dataProviderClass = DataProviders.class, dataProvider ="Login")
	public void GoogleLoginGuestuser(String loginRequired){
	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 44 !!!!!!!!!!!!!!!!!!!!!!!");
	 common = new Commonpage(getDriver());
	RerankPage rerankpage = new RerankPage(getDriver());//.getRerankPage(url);
	UserProfilePage profile = new UserProfilePage(getDriver());//common.getUserProfilePage(url);
	ListOptionPage listoptionpage = new ListOptionPage(getDriver());//common.getListOptionPage(url);
	UeListPage ueList =BaseState("GoogleLoginGuestuser");
	NavBar navBar= new NavBar(getDriver());
	navBar.hoverMore();
	ueList.clickOncreateList();
	ueList.clickOnreranking();
//	if(ueList.isStickyPresent()==true){
//	ueList.clickStickyOK();
//	}
	ueList.clickOnListName();
	ueList.putTextOnListNameBox("Testing google");
	ueList.clickOnSearch();
	ueList.typesearchbtn("Batman");
	for (int i = 1; i <= 3; i++) {
		ueList.clickOnPlusIcon(i);
	}
	ueList.clickOnpublishbtn();
	try{
		 Thread.sleep(4000);
	}catch(Exception e){}
	ueList.clickOngoogle();
	try {
		Thread.sleep(5000);
	} catch (Exception e) {
	}
	common.googleLogin("kallol@ranker.com","9872305929");
	try {
		Thread.sleep(3000);
	} catch (Exception e) {
	}

	   if(getDriver().getCurrentUrl().contains("accounts.google.com")){
		   Assert.assertEquals(1, 1);
	   }else{
		   Assert.assertEquals(1, 0);
	   }
		   
	    listoptionpage.switchToParentWindow();
//	    String head=ueList.getTextOFlistHeaderAfterPublish();
//	    String afterurl[]=getDriver().getCurrentUrl().split("\\?");
//		 Assert.assertEquals(head,afterurl[0]);

	}//End Of GoogleLoginGuestuser()
	/*
	 * Use-case : UE: Create a list as a guest, sign up after submit - Email
	 * Test case :" 1) Create a list while logged out 2) Hit the Submit button
	 * 3) The Sign Up dialogue should appear 4) Click on the Sign In link then
	 * sign in to Ranker through your email
	 */
	@Test(priority = 45, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void EmailSignintuser(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 45 !!!!!!!!!!!!!!!!!!!!!!!");
		common = new Commonpage(getDriver());
		RerankPage rerankpage = new RerankPage(getDriver());// .getRerankPage(url);
		UserProfilePage profile = new UserProfilePage(getDriver());// common.getUserProfilePage(url);
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());// common.getListOptionPage(url);
		UeListPage ueList = BaseState("EmailSignintuser");
		NavBar navBar= new NavBar(getDriver());
		navBar.hoverMore();
		ueList.clickOncreateList();
		ueList.clickOnreranking();
		ueList.clickOnListName();
		ueList.putTextOnListNameBox("Testing email");
		ueList.clickOnSearch();
		ueList.typesearchbtn("Batman");
		for (int i = 1; i <= 3; i++) {
			ueList.clickOnPlusIcon(i);
		}
		ueList.clickOnpublishbtn();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}
		ueList.clickOnsignin();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		common.emailsignin("testuserkallol1@mailinator.com", "testing");
		try {
			Thread.sleep(25000);
		} catch (Exception e) {
		}
		String head = ueList.getTextOFlistHeaderAfterPublish();
		System.out.println("head==" + head);
		String afterurl[] = getDriver().getCurrentUrl().split("\\?");
		Assert.assertEquals(head, afterurl[0]);
		ueList.clicksettingafterpublish();
		ueList.clickOnAdvancedOption();
		ueList.clickOndeletelist();
		ueList.AlertExistsAndAccepted(1000);

	}// End Of EmailSignintuser()
//
	/*
	 * Use-case : UE: Create a list as a guest, sign up after submit - Facebook
	 * Test case :" 1) Create a list while logged out 2) Hit the Submit button
	 * 3) The Sign Up dialogue should appear 4) Sign up to Ranker through your
	 * Facebook
	 */
	@Test(priority = 46, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Facebooksiginuser(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 46 !!!!!!!!!!!!!!!!!!!!!!!");
		Commonpage common = new Commonpage(getDriver());
		RerankPage rerankpage = common.getRerankPage(url);
		UserProfilePage profile = common.getUserProfilePage(url);
		ListOptionPage listoptionpage = common.getListOptionPage(url);
		UeListPage ueList = BaseState("Facebooksiginuser");
		NavBar navBar= new NavBar(getDriver());
		navBar.hoverMore();
		ueList.clickOncreateList();
		ueList.clickOnreranking();
		// if(ueList.isStickyPresent()==true){
		// ueList.clickStickyOK();
		// }
		ueList.clickOnListName();
		ueList.putTextOnListNameBox("Testing facebook");
		ueList.clickOnSearch();
		ueList.typesearchbtn("Batman");
		for (int i = 1; i <= 3; i++) {
			ueList.clickOnPlusIcon(i);
		}
		ueList.clickOnpublishbtn();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}
		ueList.clickOnsignin();
		ueList.clickOnfacebooksignin();
		rerankpage.facebooklogin("vikas@ranker.com", "vikas@123");
		//rerankpage.facebooklogin("salmankhantc", "Dehradun1");
		// try {
		// Thread.sleep(3000);
		// } catch (Exception e) {
		// }
		rerankpage.clickonloginbtn();
		 try {
		 Thread.sleep(3000);
		 } catch (Exception e) {
		 }
		listoptionpage.switchToParentWindow();
		try {
			Thread.sleep(15000);
		} catch (Exception e) {
		}
		String head = ueList.getTextOFlistHeaderAfterPublish();
		String afterurl[] = getDriver().getCurrentUrl().split("\\?");
		Assert.assertEquals(head, afterurl[0]);
		ueList.clicksettingafterpublish();
		ueList.clickOnAdvancedOption();
		ueList.clickOndeletelist();
		ueList.AlertExistsAndAccepted(1000);
	}// End Of Facebooksiginuser()

	/*
	 * Use-case : UE: Create a list as a guest, sign up after submit - Twitter
	 * Test case :" 1) Create a list while logged out 2) Hit the Submit button
	 * 3) The Sign Up dialogue should appear 4) Sign up to Ranker through your
	 * Twitter
	 */
	@Test(priority = 47, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void TwitterSigninuser(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 47 !!!!!!!!!!!!!!!!!!!!!!!");
		common = new Commonpage(getDriver());
		RerankPage rerankpage = new RerankPage(getDriver());// .getRerankPage(url);
		UserProfilePage profile = new UserProfilePage(getDriver());// common.getUserProfilePage(url);
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());// common.getListOptionPage(url);
		UeListPage ueList = BaseState("TwitterSigninuser");
		NavBar navBar= new NavBar(getDriver());
		navBar.hoverMore();
		ueList.clickOncreateList();
		ueList.clickOnreranking();
		// if(ueList.isStickyPresent()==true){
		// ueList.clickStickyOK();
		// }
		ueList.clickOnListName();
		ueList.putTextOnListNameBox("Testing Twitter");
		ueList.clickOnSearch();
		ueList.typesearchbtn("Batman");
		for (int i = 1; i <= 3; i++) {
			ueList.clickOnPlusIcon(i);
		}
		ueList.clickOnpublishbtn();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}
		ueList.clickOnsignin();
		ueList.clickOntwittersignin();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		listoptionpage.switchToParentWindow();
	     try {
				Thread.sleep(25000);
			} catch (Exception e) {
			}
	     String head=ueList.getTextOFlistHeaderAfterPublish();
	     String afterurl[]=getDriver().getCurrentUrl().split("\\?");
		 Assert.assertEquals(head,afterurl[0]);
		//Assert.assertTrue(listoptionpage.isSocialLinkUserImagePresent());
		getDriver().close();
		
	}// End Of TwitterSigninuser()
	 /*
		 * Use-case :   UE: Create a list as a guest, sign in after submit - Google+
		 * Test case :" "1) Create a list while logged out
						 2) Hit the Submit button
						 3) The Sign Up dialogue should appear
						 4) Click on the Sign In link then sign in to Ranker through your Google+"
	*/
		@Test(priority=48,dataProviderClass = DataProviders.class, dataProvider ="Login")
		public void GoogleSigninuser(String loginRequired){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 48 !!!!!!!!!!!!!!!!!!!!!!!");
		 common = new Commonpage(getDriver());
		RerankPage rerankpage = new RerankPage(getDriver());//.getRerankPage(url);
		UserProfilePage profile = new UserProfilePage(getDriver());//common.getUserProfilePage(url);
		ListOptionPage listoptionpage = new ListOptionPage(getDriver());//common.getListOptionPage(url);
		UeListPage ueList =BaseState("GoogleSigninuser");
		NavBar navBar= new NavBar(getDriver());
		navBar.hoverMore();
		ueList.clickOncreateList();
		ueList.clickOnreranking();
//		if(ueList.isStickyPresent()==true){
//		ueList.clickStickyOK();
//		}
		ueList.clickOnListName();
		ueList.putTextOnListNameBox("Testing Google");
		ueList.clickOnSearch();
		ueList.typesearchbtn("Batman");
		for (int i = 1; i <= 3; i++) {
			ueList.clickOnPlusIcon(i);
		}
		ueList.clickOnpublishbtn();
		try{
			 Thread.sleep(4000);
		}catch(Exception e){}
		ueList.clickOnsignin();
		ueList.clickOngooglesignin();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		common.googleLogin("kallol@ranker.com","9872305929");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		try {
				Thread.sleep(3000);
			} catch (Exception e) {
			}

		   if(getDriver().getCurrentUrl().contains("accounts.google.com")){
			   Assert.assertEquals(1, 1);
		   }else{
			   Assert.assertEquals(1, 0);
		   }
			   
		    listoptionpage.switchToParentWindow();
//		    String head=ueList.getTextOFlistHeaderAfterPublish();
//		    String afterurl[]=getDriver().getCurrentUrl().split("\\?");
//			 Assert.assertEquals(head,afterurl[0]);

		}//End Of GoogleSigninuser()
	    /*
		 * Use-case : UE:Add external link on nodes
		 * Test case :  1-Login from Admin
						2-Create a list with some nodes
						3-Edit node and add external link and save it
						4-Publish list
		 */
		 @Test(priority=49,dataProviderClass = DataProviders.class, dataProvider = "Login")
		 public void ExternalLinksOnNodes(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 49 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 //UeListPage ueList =BaseStateWithLogin("ExternalLinksOnNodes");
		 UeListPage ueList=BaseState("ExternalLinksOnNodes");
		 ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		 common.signin("vijaymohanp", "server");
		 ueList.clickCreateListAndAdd3Items();
		 ueList.hoverOnNodeEdit("edit");
		 ueList.clickOnEditIconsOnNode("video");
		 ueList.clickOnextenallink();
		 ueList.putTextInextenallink("http://www.google.com");
		 String before=ueList.getValueOfexternallink();
		 try {
				Thread.sleep(2000);
			} catch (Exception e) {}
		 ueList.clickondonebtn();
		 try {
			    Thread.sleep(8000);
		 } catch (Exception e) {}
		 ueList.clickOnpublishbtn();
		 try {
			Thread.sleep(12000);
		} catch (Exception e) {}
		 ueList.clickOnfirstnodeafterpublish(); 
		 try {
				Thread.sleep(8000);
		 } catch (Exception e) {}
		 ueList.switchToNewWindow();
		 String after=getDriver().getCurrentUrl();
		 try {
				Thread.sleep(4000);
			} catch (Exception e) {}
		 if(after.toLowerCase().contains("google")){
			 Assert.assertEquals(1, 1);
		 }
		 else
		 {
			 Assert.assertEquals(1, 0); 
		 }
		 getDriver().close();
		 listoptionpage.switchToParentWindow();
		 ueList.clicksettingafterpublish();
		 ueList.clickOnAdvancedOption();
		 ueList.clickOndeletelist();
		 ueList.AlertExistsAndAccepted(1000);

		 }//End of ExternalLinksOnNodes
		 /*
			 * Use-case : UE-Allow Closing ULs to closing open list Additions
			 * Test case :   Open any Ultimate list as Admin and in List options, toggle the option 'Add allow people to add item on my list' to 'Yes' and update the list. Reset the cache.
							 eg:http://www.ranker-qa.com/crowdranked-list/best-star-wars-movie
			 */
			 @Test(priority=50,dataProviderClass = DataProviders.class, dataProvider = "Login")
			 public void AdditemsBarInListView(String loginRequired){
			 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 50 !!!!!!!!!!!!!!!!!!!!!!!");
			 //Base state. (Navigate to node page)
			 //UeListPage ueList =BaseStateWithLogin("ExternalLinksOnNodes");
			 UeListPage ueList=BaseState("AdditemsBarInListView");
			// ListOptionPage listoptionpage = new ListOptionPage(getDriver());
			 Grid grid = new Grid(getDriver());
			 common.signin("vijaymohanp", "server");
			 common.getNewURL(config.getProperty("Url")+"crowdranked-list/best-star-wars-movie");
			 try {
					Thread.sleep(7000);
				} catch (Exception e) {}
			 grid.clickOnadminEditList();
			 grid.clickOneditlist();
			 ueList.clickOnadditmesinmylist();
			 try {
					Thread.sleep(15000);
				} catch (Exception e) {}
			 ueList.clickOnpublishbtn();
			 try {
					Thread.sleep(15000);
				} catch (Exception e) {}
			 Assert.assertTrue(ueList.isPresentsmylist());
			 try {
					Thread.sleep(7000);
				} catch (Exception e) {}
			 grid.clickOnAdminStats(3);
			 grid.clickOneditlist();
			 ueList.clickOnadditmesinmylist();
			// ueList.clickOnAdvancedOption();
			 }//End of AdditemsBarInListView
			 
			 /*
				 * Use-case : Node link
				 * Test case :   1) Open any list and click on any of the node link
				 */
				 @Test(priority=51,dataProviderClass = DataProviders.class, dataProvider = "Login")
				 public void NodeLink(String loginRequired){
				 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 51 !!!!!!!!!!!!!!!!!!!!!!!");
				 //Base state. (Navigate to node page)
				 //UeListPage ueList =BaseStateWithLogin("ExternalLinksOnNodes");
				 UeListPage ueList =BaseStateWithLogin("NodeLink");
				 ListOptionPage listoptionpage = new ListOptionPage(getDriver());
				 
				// common.getNewURL(config.getProperty("Url")+"list/actors-nobody-cares-about-anymore/ranker-celebrities");
				 common.getNewURL(config.getProperty("Url")+"crowdranked-list/best-doctors-of-doctor-who?");
				 try {
						Thread.sleep(7000);
					} catch (Exception e) {}
				 String before=ueList.gethrefOfnodename(1);
				 ueList.clickOnlistNodeName(1);
				 String after=getDriver().getCurrentUrl();
				 Assert.assertEquals(before, after);
				 getDriver().navigate().back();
				 try {
						Thread.sleep(7000);
					} catch (Exception e) {}
				    listoptionpage.putTextInAddListBox("testing");
					listoptionpage.clickOnAddSearchItem();
					 try {
							Thread.sleep(7000);
						} catch (Exception e) {}
					    listoptionpage.clickOnImageResultInEditItemBox(1);
						listoptionpage.clickOnSelectButton();
						listoptionpage.clickOnDoneButton();
						try {
							Thread.sleep(10000);
						} catch (Exception e) {}
					 Assert.assertFalse(ueList.isclickableAuthorednode("text"));
				 }//End of NodeLink
	/*
	 * Use-case : Check for property data in Blog style
	 * Test case :   Open any Ultimate list as Admin and in List options, toggle the option 'Add allow people to add item on my list' to 'Yes' and update the list. Reset the cache.
					eg:http://www.ranker-qa.com/crowdranked-list/best-star-wars-movie
	 */
		@Test(priority=52,dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void PropertydatainBlog(String loginRequired){
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 52 !!!!!!!!!!!!!!!!!!!!!!!");
			//Base state. (Navigate to node page)
			//UeListPage ueList =BaseStateWithLogin("ExternalLinksOnNodes");
			UeListPage ueList=BaseState("PropertydatainBlog");
			// ListOptionPage listoptionpage = new ListOptionPage(getDriver());
			Grid grid = new Grid(getDriver());
			ListHeader listHeader=new ListHeader(getDriver());
			common.signin("vijaymohanp", "server");
					
			ueList.clickCreateListAndAdd3Items();
					 
			SafeActions s=new SafeActions(getDriver());
			s.waitForPageToLoad(5);
			ueList.clickOnoptionbtn();
			ueList.clickOnstylechnage();
			ueList.hoverOnNodeEdit("edit");
			ueList.clickOnEditIconsOnNode("comment");
			s.waitForPageToLoad(20);
			ueList.typeInCommentBoxInEdit("This is Blather Testing");
			ueList.clickondonebtn();
			String blath=ueList.getTextOfNodeBlather();
			Assert.assertEquals(blath,"This is Blather Testing");
			ueList.clickOnpublishbtn();
			try {
				Thread.sleep(7000);
			} catch (Exception e) {}
			grid.clickOnAdminStats(4);
			grid.checkonmetalist(4);
			try {
				Thread.sleep(5000);
			} catch (Exception e) {}
			String blathPub=ueList.getTextOfblatherinblogview();
			Assert.assertEquals(blathPub,blath);
			Assert.assertTrue(listHeader.ispropertyBlockinblogPresent());
			grid.clickOnAdminStats(4);
			grid.checkonmetalist(4);
			ueList.clicksettingafterpublish();
			ueList.clickOnAdvancedOption();
			ueList.clickOndeletelist();
			ueList.AlertExistsAndAccepted(1000);
	}//End of PropertydatainBlog
					 
	/*
	 * Use-case : Check for property data in Blog style
	 * Test case : Open any Ultimate list as Admin and in List options, toggle the option 'Add allow people to add item on my list' to 'Yes' and update the list. Reset the cache.
					eg:http://www.ranker-qa.com/crowdranked-list/best-star-wars-movie
	 */
	@Test(priority=53,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Propertydatainslideshow(String loginRequired){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 53 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to node page)
		//UeListPage ueList =BaseStateWithLogin("ExternalLinksOnNodes");
		UeListPage ueList=BaseState("Propertydatainslideshow");
		// ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		Grid grid = new Grid(getDriver());
		ListHeader listHeader=new ListHeader(getDriver());
		common.signin("vijaymohanp", "server");
		ueList.clickCreateListAndAdd3Items();
		SafeActions s=new SafeActions(getDriver());
		s.waitForPageToLoad(5);
		ueList.clickOnoptionbtn();
		ueList.clickOnstylechnageslideshow();
		ueList.hoverOnNodeEdit("edit");
		ueList.clickOnEditIconsOnNode("comment");
		s.waitForPageToLoad(20);
		ueList.typeInCommentBoxInEdit("This is Blather Testing");
		ueList.clickondonebtn();
		String blath=ueList.getTextOfNodeBlather();
		Assert.assertEquals(blath,"This is Blather Testing");
		ueList.clickOnpublishbtn();
		try {
			Thread.sleep(7000);
		} catch (Exception e) {}
		grid.clickOnAdminStats(4);
		grid.checkonmetalist(4);
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {}
		Assert.assertTrue(listHeader.ispropertyBlockinslideshowPresent());
		grid.clickOnAdminStats(4);
		grid.checkonmetalist(4);
		//ueList.clickOnAdvancedOption();
		ueList.clicksettingafterpublish();
		ueList.clickOnAdvancedOption();
		ueList.clickOndeletelist();
		ueList.AlertExistsAndAccepted(1000);
	}//End of Propertydatainslideshow
	
	/*
	 * Use-case : Default Setting for Properties
	 * Test case :  1. Open UE and add some nodes.
					2. Create a list or rerank a list eg.
					http://www.ranker-stage.com/list/female-role-models/ericascheidt
					3. Add some items of same categories and go to options>>advance setting>>customize
					4. Select default property for the list.
	 */
		@Test(priority=54,dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void DefaultSettings(String loginRequired){
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 54 !!!!!!!!!!!!!!!!!!!!!!!");
			//Base state. (Navigate to node page)
			UeListPage ueList=BaseStateWithLogin("DefaultSettings");
			ListOptionPage listoptionpage = new ListOptionPage(getDriver());
			
			common.getNewURL(config.getProperty("Url")+"list/actors-nobody-cares-about-anymore/ranker-celebrities");
			SafeActions s=new SafeActions(getDriver());
			listoptionpage.putTextInAddListBox("batman");
			try{
				Thread.sleep(4000);
			}catch(Exception e){}
			listoptionpage.clickOnAddSearchItem();
			
			//s.waitForPageToLoad(30);
			try{
				Thread.sleep(10000);
			}catch(Exception e){}
			listoptionpage.clickOnDoneButton();
			try{
				Thread.sleep(4000);
			}catch(Exception e){}
			RerankPage rerankPage= new RerankPage(getDriver());
			ueList.clickOnstickyOnUL();
			rerankPage.clickOnrerankbtn();
			ueList.clickOnIdeaTab();
		ueList.clickOnSearch();
	    ueList.typesearchbtn("Batman");
			for (int i = 1; i <= 4; i++){
				ueList.clickOnPlusIcon(i);
			}
			ueList.clickOnoptionbtn();
			ueList.clickOnAdvancedOption();
			ueList.clickOndisplayProperty();
			if(ueList.getTextOfAdditionalInfoToggle().equalsIgnoreCase("No")){
				ueList.clickOnAdditionalInfoToggle();
				try{
					Thread.sleep(3000);
				}catch(Exception e){}
			}
			  ueList.clickOndefaultProprty(3,"radioBtn");
			 s.waitForPageToLoad(40);
			 Assert.assertFalse(ueList.isPropertyCheckBoxClickable(3, "checkBox"));
	}//End of DefaultSettings
	/*	
	 * Use-case : Edit All Pop Up.
	 * Test case :  1. Go to UE and add some nodes.
					2. Click on edit all setting.
	 */
	@Test(priority=55,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void EditAllPopupBlather(String loginRequired){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 55 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to node page)
		UeListPage ueList=BaseState("EditAllPopupBlather");
		ueList.clickCreateListAndAdd3Items();
		ueList.clickOnoptionbtn();
		ueList.clickOnEditAllIcon();
		try{
			Thread.sleep(4000);
		}catch(Exception e){}
		for(int i=1;i<=3;i++){
			Assert.assertTrue(ueList.isNodeInEditOverlayPresent(i, i));
		}
		
		Assert.assertEquals("rgba(5, 109, 187, 1)", ueList.getcolorofdonebtn());
		Assert.assertEquals("rgba(204, 204, 204, 1)", ueList.getbackgrouncolorofdonebtn());
		
		//edit blather  
		ueList.clickOnEditAllblather(1);
		ueList.typeIncommentBoxInEditall("This is  first Blather Testing",1);
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ueList.clickOnEditAllblather(2);
		ueList.typeIncommentBoxInEditall("This is  second Blather Testing",2);
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ueList.clickOnEditAllblather(3);
		ueList.typeIncommentBoxInEditall("This is  third Blather Testing",3);
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ueList.clickondonebtn();
		//for(int i=1;i<=3;i++){
		String blath=ueList.getTextOfAllNodeBlather(1);
		Assert.assertEquals(blath,"This is  first Blather Testing");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		String blath1=ueList.getTextOfAllNodeBlather(2);
		Assert.assertEquals(blath1,"This is  second Blather Testing");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		String blath2=ueList.getTextOfAllNodeBlather(3);
		Assert.assertEquals(blath2,"This is  third Blather Testing");
		}//End of EditAllPopup
				
	/*	
	 * Use-case : Edit All Pop Up.
	 * Test case :  1. Go to UE and add some nodes.
					2. Click on edit all setting.
	 */
	@Test(priority=56,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void EditAllPopupImage(String loginRequired){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 56 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to node page)
		UeListPage ueList=BaseState("EditAllPopupImage");
		ueList.clickCreateListAndAdd3Items();
		ueList.clickOnoptionbtn();
		ueList.clickOnEditAllIcon();
		try{
			Thread.sleep(4000);
		}catch(Exception e){}
		for(int i=1;i<=3;i++){
			Assert.assertTrue(ueList.isNodeInEditOverlayPresent(i, i));
		}
		
		//edit image
		 ueList.clickOnEditAllImage(1);
		 String beforesrc=ueList.getsrcimage(1);
		 String[] substring=beforesrc.split("/");
		 ueList.clickonimageaddoption(1);
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 ueList.clickonselectbtn();
		 ueList.clickondonebtn();
		 String after=ueList.getsrcaddimage(1);
		 String[] substring1=after.split("/");
		 Assert.assertEquals(substring[substring.length-1],substring1[substring1.length-1]);
		}//End of EditAllPopupImage
	
	/*	
	 * Use-case : Edit All Pop Up.
	 * Test case :  1. Go to UE and add some nodes.
					2. Click on edit all setting.
	 */
	@Test(priority=57,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void EditAllPopupVideo(String loginRequired){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 57 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to node page)
		UeListPage ueList=BaseState("EditAllPopupVideo");
		 ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		ueList.clickCreateListAndAdd3Items();
		ueList.clickOnoptionbtn();
		ueList.clickOnEditAllIcon();
		try{
			Thread.sleep(4000);
		}catch(Exception e){}
		for(int i=1;i<=3;i++){
			Assert.assertTrue(ueList.isNodeInEditOverlayPresent(i, i));
		}
		  ueList.clickOnnodeNumInEditViedo(1);
		  listoptionpage.putTextInAddvideo("sachin");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		int count=listoptionpage.Videocount();
		if(count>2)
		{
			 String beforesrc=ueList.getsrcimage(1);
			 String[] substring=beforesrc.split("/");
	         ueList.clickOnVideoInEdit(1);
	 
		 ueList.clickonselectbtn();
		 ueList.clickondonebtn();
		 try {
				Thread.sleep(8000);
			} catch (Exception e) {
			}
		 String after=ueList.getsrcaddimage(1);
		 String[] substring1=after.split("/"); 
		 Assert.assertEquals(substring[substring.length-1],substring1[substring1.length-1]);
			}
			
		}//End of EditAllPopupVideo
	/*	
	 * Use-case : Edit All Pop Up.
	 * Test case :  1. Go to UE and add some nodes.
					2. Click on edit all setting.
	 */
	@Test(priority=58,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void EditAllPopupInfo(String loginRequired){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 58 !!!!!!!!!!!!!!!!!!!!!!!");
		//Base state. (Navigate to node page)
		UeListPage ueList=BaseState("EditAllPopupInfo");
		 ListOptionPage listoptionpage = new ListOptionPage(getDriver());
		ueList.clickCreateListAndAdd3Items();
		ueList.clickOnoptionbtn();
		ueList.clickOnEditAllIcon();
		try{
			Thread.sleep(4000);
		}catch(Exception e){}
		for(int i=1;i<=3;i++){
			Assert.assertTrue(ueList.isNodeInEditOverlayPresent(i, i));
		}
		ueList.clickOnnodeNumInEditInfo(1);
		  try{
		   Thread.sleep(2000);
		  }catch(Exception e){}
		  ueList.putTextInFirstPropInfo("Film");
		  try{
		  Thread.sleep(2000);
		 }catch(Exception e){}
		  ueList.clickondonebtn();
		  try{
		   Thread.sleep(5000);
		  }catch(Exception e){}
		  ueList.hoverOnNodeEdit("edit");
		  ueList.clickOnEditIconsOnNode("info");
		  try{
		   Thread.sleep(3000);
		  }catch(Exception e){}
		//  s.waitForPageToLoad(50);
		  Assert.assertEquals(ueList.getTextOfFirstPropInfo(), "Film");  
			
		}//End of EditAllPopupInfo
	
	/*
	 * Use-case :   Verify Changed Tweak button size and caps
	 * Test case :" 1) Go to ranker-stage.com Open UE and click on Options tab
					2) Now click on the Open Advance options
	 */
	@Test(priority = 59, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void TweakButtonSizeAndCap(String loginRequired) {
		System.out
				.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 59 !!!!!!!!!!!!!!!!!!!!!!!");
		common = new Commonpage(getDriver());
		///RerankPage rerankpage = new RerankPage(getDriver());// .getRerankPage(url);
		///UserProfilePage profile = new UserProfilePage(getDriver());// common.getUserProfilePage(url);
		//ListOptionPage listoptionpage = new ListOptionPage(getDriver());// common.getListOptionPage(url);
		UeListPage ueList = BaseStateWithLogin("TweakButtonSizeAndCap");
		NavBar navBar= new NavBar(getDriver());
		navBar.hoverMore();
		ueList.clickCreateListAndAdd3Items();
		ueList.clickOnpublishbtn();
		try{
		   Thread.sleep(3000);		
		   }catch(Exception e){}
		ueList.clicksettingafterpublish();
		try{
		   Thread.sleep(3000);		
		   }catch(Exception e){}
		//ueList.clickOnoptionbtn();
		ueList.clickOnAdvancedOption();
		Assert.assertEquals("add tags", ueList.getTextOfaddTagsInUe());
		Assert.assertEquals("customize", ueList.getTextOfdisplayProperty());
		Assert.assertEquals("delete", ueList.getTextOfdeletelist());
		Assert.assertEquals("unpublish", ueList.getTextofunpublishedbutton());
		Assert.assertTrue(ueList.isPresentdeleteButtonlast());
		ueList.clickOndeletelist();
		ueList.AlertExistsAndAccepted(1000);
		
	}//End of TweakButtonSizeAndCap
	
	 /*
	 * Use-case : Allow https in the external link field
	 * Test case :   Login as Admin and open UE
					 Add some nodes
					 Click on edit link of node
					 Click on external link ,enter link : https://www.google.com
					 Publish list and Click on Node
	 */
	 @Test(priority=60,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void HttpInExternalLinksOnNodes(String loginRequired){
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 60 !!!!!!!!!!!!!!!!!!!!!!!");
	 //Base state. (Navigate to node page)
	 //UeListPage ueList =BaseStateWithLogin("ExternalLinksOnNodes");
	 UeListPage ueList=BaseState("HttpInExternalLinksOnNodes");
	 ListOptionPage listoptionpage = new ListOptionPage(getDriver());
	 common.signin("vijaymohanp", "server");
	 ueList.clickCreateListAndAdd3Items();
	 ueList.hoverOnNodeEdit("edit");
	 ueList.clickOnEditIconsOnNode("video");
	 ueList.clickOnextenallink();
	 ueList.putTextInextenallink("http://www.google.com");
	 String before=ueList.getValueOfexternallink();
	 try {
			Thread.sleep(2000);
		} catch (Exception e) {}
	 ueList.clickondonebtn();
	 try {
		    Thread.sleep(8000);
	 } catch (Exception e) {}
	 ueList.clickOnpublishbtn();
	 try {
		Thread.sleep(12000);
	} catch (Exception e) {}
	 ueList.clickOnfirstnodeafterpublish(); 
	 try {
			Thread.sleep(8000);
	 } catch (Exception e) {}
	 ueList.switchToNewWindow();
	 String after=getDriver().getCurrentUrl();
	 try {
			Thread.sleep(4000);
		} catch (Exception e) {}
	 if(after.toLowerCase().contains("google")){
		 Assert.assertEquals(1, 1);
	 }
	 else
	 {
		 Assert.assertEquals(1, 0); 
	 }
	 getDriver().close();
	 listoptionpage.switchToParentWindow();
	 ueList.clicksettingafterpublish();
	 ueList.clickOnAdvancedOption();
	 ueList.clickOndeletelist();
	 ueList.AlertExistsAndAccepted(1000);

	 }//End of ExternalLinksOnNodes
	    /*
		 * Use-case : UE: remove "copy and view" setting in UE for Uls
		 * Test case : Open list with Admin: http://www.ranker-stage.com/crowdranked-list/the-best-coupon-websites
               Edit list and go to options
		 */
		 @Test(priority=61,dataProviderClass = DataProviders.class, dataProvider =
		 "Login")
		 public void RemoveCopyandViewOption(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 61 !!!!!!!!!!!!!!!!!!!!!!!");
		 try {
				startRecording("RemoveCopyandViewOption");
			} catch (Exception e) {
			}
		 common = new Commonpage(getDriver());
		 UeListPage ueList = common.getUeListPage(url);
		 Grid grid = new Grid(getDriver());
		 common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-best-coupon-websites");
		 common.signin("vijaymohanp","server");
		  grid.clickOnAdminStats(3);
		  ueList.clickOnadminsubstat();
		  try {
				Thread.sleep(2000);
			} catch (Exception e) {}
		  ueList.clickOnAdvancedOption();
		  Assert.assertFalse(ueList.isPresentcopy_viewbutton());
		  common.getNewURL(config.getProperty("Url")+"list/best-tv-host-farewells/ranker-tv");
		  //common.signin("vijaymohanp","server");
		  grid.clickOnAdminStats(3);
		  ueList.clickOnadminsubstat();
		  try {
				Thread.sleep(2000);
			} catch (Exception e) {}
		  ueList.clickOnAdvancedOption();
		  Assert.assertTrue(ueList.isPresentcopy_viewbutton());
		 //ueList.clicksettingafterpublish();
		 
//		 ueList.clickOndeletelist();
//		 ueList.AlertExistsAndAccepted(1000);
	}//End of RemoveCopyandViewOption
		 /*
			 * Use-case : UE: Default to parent list's list image for rerank
			 * Test case : Open list: http://www.ranker-stage.com/crowdranked-list/the-most-influential-contemporary-americans
 								Rerank it and publish it
			 */
			 @Test(priority=62,dataProviderClass = DataProviders.class, dataProvider =
			 "Login")
			 public void DefaultParentList(String loginRequired){
			 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 62 !!!!!!!!!!!!!!!!!!!!!!!");
			 try {
					startRecording("DefaultParentList");
				} catch (Exception e) {
				}
			 common = new Commonpage(getDriver());
			 UeListPage ueList = common.getUeListPage(url);
			 RerankPage rerankpage = common.getRerankPage(url);
			 Grid grid = new Grid(getDriver());
			 common.getNewURL(config.getProperty("Url")+"crowdranked-list/the-most-influential-contemporary-americans");
			 String before=ueList.getsrclistimage();
			 rerankpage.clickOnrerankbtn();
			 try {
					Thread.sleep(4000);
				} catch (Exception e) {}
			 ueList.clickOnpublishbtn();
			 try {
					Thread.sleep(4000);
				} catch (Exception e) {}
			 String after=ueList.getsrclistimage();
			 Assert.assertEquals(after, before);
		}//End of DefaultParentList
			 /*
				 * Use-case : UE: Link Type external link drop down
				 * Test case :   1. Login as admin
								 2. Open UE 
								 3. Add some nodes and open node edit 
								 4. Check the drop down next to external link textbox
				 */
				 @Test(priority=63,dataProviderClass = DataProviders.class, dataProvider = "Login")
				 public void ExternalLinkDropDown(String loginRequired){
				 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 63 !!!!!!!!!!!!!!!!!!!!!!!");
				 //Base state. (Navigate to node page)
				 //UeListPage ueList =BaseStateWithLogin("ExternalLinksOnNodes");
				 UeListPage ueList=BaseState("HttpInExternalLinksOnNodes");
				 ListOptionPage listoptionpage = new ListOptionPage(getDriver());
				 common.signin("vijaymohanp", "server");
				 ueList.clickCreateListAndAdd3Items();
				 ueList.hoverOnNodeEdit("edit");
				 ueList.clickOnEditIconsOnNode("video");
				 ueList.clickOnextenallink();
				 ueList.putTextInextenallink("http://www.google.com");
				 Assert.assertTrue(ueList.isPresentextenallinkdropdown());
				 ueList.clickOnextenallinkdropdown();
				 try {
						Thread.sleep(2000);
					} catch (Exception e) {}
				 for(int i=1;i<=5;i++){
				 Assert.assertTrue(ueList.isPresenextenallinkdropdownoption(i));
				 }
				 ueList.clickondonebtn();
				 ueList.clickOnoptionbtn();
				 ueList.clickOnAdvancedOption();
				 ueList.clickOndeletelist();
				 ueList.AlertExistsAndAccepted(1000);
				 }//End of ExternalLinksOnNodes
				 /*
					 * Use-case : Verify Autosuggest: Songs class exact matches
					 * Test case :      1) Open UE and search for a song name that has a lot of exact matches 
										2) Now filter it in the Songs class. 
				 */
				 @Test(priority=64,dataProviderClass = DataProviders.class, dataProvider ="Login")
				 public void AutoSuggestSongClass(String loginRequired){
				 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 64 !!!!!!!!!!!!!!!!!!!!!!!");
				 //Base state. (Navigate to node page)
				 UeListPage ueList =BaseStateWithLogin("AutoSuggestSongClass");
				 NavBar navBar= new NavBar(getDriver());
				 navBar.hoverMore();
				 ueList.clickOncreateList();
				 ueList.clickOnreranking();
				 ueList.clickOnListName();
				 ueList.putTextOnListNameBox("Testing List");
				 ueList.clickOnSearch();
				 ueList.typesearchbtn("batman");
				 ueList.clickOndropdown();
				 try{
					 Thread.sleep(2000);
				 }catch(Exception e){}
				 ueList.clickOndropdownselection1();
				 try{
					 Thread.sleep(5000);
				 }catch(Exception e){}
				 for(int i=1;i<=10;i++){
				 Assert.assertEquals("exact match!", ueList.getTextofSongsearchnode(i));}
				 }
			 /*
				 * Use-case : Criteria color
				 * Test case : Go to any of your lists and open UE. Go to My List Details"
				 */
				 @Test(priority=65,dataProviderClass = DataProviders.class, dataProvider =
				 "Login")
				 public void ListCriteriaColor(String loginRequired){
				 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 65 !!!!!!!!!!!!!!!!!!!!!!!");
				 //Base state. (Navigate to node page)
				 UeListPage ueList =BaseStateWithLogin("ListCriteria");
				 ueList.clickCreateListAndAdd3Items();
				 try{
					 Thread.sleep(2000);
					 }catch(Exception e){}
				 ueList.clickOnmylistdescription();
				 ueList.typelistcriteria("Testing criteria");
				 try{
				 Thread.sleep(2000);
				 }catch(Exception e){}
				 Assert.assertEquals("rgba(0, 0, 0, 1)", ueList.getcoloroflistcriteria());
				 
				 ueList.clickOnlistdescriptiondonebtn();
				 ueList.clickOnpublishbtn();
				 try{
					 Thread.sleep(5000);
				 }catch(Exception e){}
				 Assert.assertEquals("rgba(0, 0, 0, 1)", ueList.getcoloroflistcriteriaafterpublish());
				 ueList.clicksettingafterpublish();
//					 s.waitForPageToLoad(40);
//					 System.out.println("666666666666666");
//					 ueList.clickOnAdvancedOption();
				 ueList.clickOndeletelist();
//					 s.waitForPageToLoad(40);
//					 System.out.println("7777777777");
//					// ueList.acceptAlert();
				 ueList.AlertExistsAndAccepted(1000);
				 }//End of ListCriteria
				 
				 /*
					 * Use-case :   UE: clicking (x) should close only overlay not UE
					 * Test case :" 1. Create a list as a guest user and Click on icon in top right side of UE
 									2. Now an overlay will open click on icon in top right side of overlay
				*/
				@Test(priority=66,dataProviderClass = DataProviders.class, dataProvider ="Login")
				public void CloseOverlay(String loginRequired){
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 66 !!!!!!!!!!!!!!!!!!!!!!!");
				Commonpage common = new Commonpage(getDriver());
				RerankPage rerankpage = common.getRerankPage(url);
				UserProfilePage profile = common.getUserProfilePage(url);
				ListOptionPage listoptionpage = common.getListOptionPage(url);
				UeListPage ueList =BaseState("CloseOverlay");
				NavBar navBar= new NavBar(getDriver());
				navBar.hoverMore();
				ueList.clickOncreateList();
				ueList.clickOnreranking();
				 if(ueList.isStickyPresent()==true){
				 ueList.clickStickyOK();
				 }
				ueList.clickOnListName();
				ueList.putTextOnListNameBox("Testing");
				ueList.clickOnSearch();
				ueList.typesearchbtn("Batman");
				for (int i = 1; i <= 3; i++) {
					ueList.clickOnPlusIcon(i);
				}
				ueList.clickOnpublishbtn();
				try{
					 Thread.sleep(4000);
				}catch(Exception e){}
				ueList.clickOncrosspopup();
				Assert.assertTrue(rerankpage.isPresentUE());
				}
				 /*
				  * Use-case : Meta Data UX
				  * Test case : Open Info list : http://www.ranker-stage.com/list/most-popular-democrats-that-were-once-republicans/jennifer-lee with admin
 								change the default property in Listinfo section of the node edit pop up
				 */
				 @Test(priority=67,dataProviderClass = DataProviders.class, dataProvider ="Login")
				 public void DefaultProprtyInGrid(String loginRequired){
				 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 67 !!!!!!!!!!!!!!!!!!!!!!!");
					 //Base state. (Navigate to node page)
					 UeListPage ueList =BaseState("DefaultProprtyInGrid");
					 NavBar navBar= new NavBar(getDriver());
					 Grid grid = new Grid(getDriver());
					 ListHeader listHeader=new ListHeader(getDriver());
					 System.out.println("111111111111");
					 common.getNewURL(config.getProperty("Url")+"list/most-popular-democrats-that-were-once-republicans/jennifer-lee");
					 System.out.println("222222222222222");
					 common.signin("vijaymohanp", "server");
					 try {
							Thread.sleep(5000);
						} catch (Exception e) {}
					 grid.clickOnadminEditList();
					 System.out.println("33333333333333");
					 grid.clickOnlistinfo();
					 System.out.println("4444444444444444");
					 try {
							Thread.sleep(12000);
						} catch (Exception e) {}
					 ueList.clickOndefaultProprty1(2,"radioBtn");
					 try {
							Thread.sleep(8000);
						} catch (Exception e) {}
					 System.out.println("55555555555555555");
					 String text=ueList.getTextOfdefaultProprtychange(2);
					 System.out.println("text===="+text);
					 ueList.clickOndefaultProprtyDonebtn();
					 try {
							Thread.sleep(10000);
						} catch (Exception e) {}
					 
					 grid.clickOnResetTab();
				     grid.clickOnresetsublist(2);
			         listHeader.AlertExistsAndAccepted(1000);
			         try {
							Thread.sleep(10000);
						} catch (Exception e) {}
			       //  ueList.clickOnselectparameterbydropdown();
			         try {
							Thread.sleep(20000);
						} catch (Exception e) {}
					 String aftertext=ueList.getTextOfselectdropdownpropertyoption();
					 System.out.println("aftertext===="+aftertext);
					 Assert.assertEquals(aftertext, text);

				 }//End for PropertyDisplay
				 
				 /*
				  * Use-case : Meta Data UX
				  * Test case : Open Info list : http://www.ranker-stage.com/list/most-popular-democrats-that-were-once-republicans/jennifer-lee with admin
 								change the default property in Listinfo section of the node edit pop up
				 */
				 @Test(priority=68,dataProviderClass = DataProviders.class, dataProvider ="Login")
				 public void DefaultProprtyInBlog(String loginRequired){
				 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 68 !!!!!!!!!!!!!!!!!!!!!!!");
					 //Base state. (Navigate to node page)
					 UeListPage ueList =BaseState("DefaultProprtyInBlog");
					 //NavBar navBar= new NavBar(getDriver());
					 BlogPage blogPage=new BlogPage(getDriver());
					 Grid grid = new Grid(getDriver());
					 ListHeader listHeader=new ListHeader(getDriver());
					 common.getNewURL(config.getProperty("Url")+"list/most-popular-democrats-that-were-once-republicans/jennifer-lee");
					 common.signin("vijaymohanp", "server");
					 try {
							Thread.sleep(5000);
						} catch (Exception e) {}
					 grid.clickOnadminEditList();
					 grid.clickOnlistsetting();
					 ueList.clickOnstylechnage();
					 ueList.clickOnpublishbtn();
					 try {
							Thread.sleep(5000);
						} catch (Exception e) {}
					 grid.clickOnadminEditList();
					 grid.clickOnlistinfo();
					 try {
							Thread.sleep(8000);
						} catch (Exception e) {}
					 String wikivalue=ueList.getTextOfwikitoption();
					 int num=0;
					 if(wikivalue=="YES"){
						num=1;
					 }else{
						 ueList.clickOnwikitextoption();
						 num=1;
					 }
					 
					 String value=ueList.getTextOfreranktextoption();
					 int count=0;
					 if(value=="YES"){
						 count=1;
					 }else
					 {
						ueList.clickOnreranktoption(); 
						count=1;
					 }
					 ueList.clickOndefaultProprtyDonebtn();
					 try {
							Thread.sleep(8000);
						} catch (Exception e) {}
					 
					 grid.clickOnResetTab();
				     grid.clickOnresetsublist(2);
				     listHeader.AlertExistsAndAccepted(1000);
				     try {
							Thread.sleep(8000);
					} catch (Exception e) {}
				     if(num==1){
				     Assert.assertNotNull(ueList.getTextOfwikitext(1));
				     }
				     if(count==1){
				    	Assert.assertTrue(blogPage.isAlsoRankedDescPresent(1));
				     }
				     grid.clickOnadminEditList();
				     grid.clickOnlistinfo();
				     ueList.clickOnwikitextoption();
				     ueList.clickOndefaultProprtyDonebtn();
				     try {
							Thread.sleep(8000);
						} catch (Exception e) {}
				     grid.clickOnadminEditList();
					 grid.clickOnlistsetting();
					 ueList.clickOnviewlistmode();
					 ueList.clickOnpublishbtn();
				 }//End for PropertyDisplay
				 
				 /////\30 july
				 /*
					 * Use-case : Verify Features for website url
					 * Test case :  1) Open UE click on Options tab
									2) Now click on the Open Advance options
									3) Enter your website link in the"Display my website URL" field,
									4) Enter website name 
									5) Go back to UE			 
					 */
					 @Test(priority=69,dataProviderClass = DataProviders.class, dataProvider ="Login")
						 public void DisplayMyWebsiteUrl(String loginRequired){//updated
						 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 69 !!!!!!!!!!!!!!!!!!!!!!!");
						 //Base state. (Navigate to node page)
						 UeListPage ueList =BaseStateWithLogin("DisplayMyWebsiteUrl");
						 ueList.clickCreateListAndAdd3Items();
						 ueList.clickOnoptionbtn();
						 ueList.clickOnAdvancedOption();
					 	 ueList.putTextInUrlNameBox("link","www.google.com");
//					 	try{
//						 	Thread.sleep(6000);
//					 	}catch(Exception e){}
						 SafeActions s=new SafeActions(getDriver());
						 s.waitForPageToLoad(20);
					 	ueList.putTextInDisplayNameBox("title","testing");

					 	ueList.clickInUrlNameBox("link");//have made click here again for saving the text
					 	
					 	///String text=ueList.getTextOfurltext();
					 	//System.out.println("text=="+text);
					 	ueList.clickOnpublishbtn();
					 	try{
						 	Thread.sleep(5000);
					 	}catch(Exception e){}
					 	
					 	Assert.assertTrue(ueList.isWebstieUrlAfterPublishPresent());
					 	String txt=ueList.getTextOfWebstieUrlAfterPublish();
					 	Assert.assertEquals(txt,"testing");
				     	ueList.clicksettingafterpublish();
					 	ueList.clickOndeletelist();
					 	ueList.AlertExistsAndAccepted(1000);
					 }//End of DisplayMyWebsiteUrl()
					 
					 /* 
				  	  * Use-case : Verify Burry/Unburry options.
				  	  * Test case : Create a new list/open any existing list Verify Burry/Un-burry options.
				  	  */
					 @Test(priority=70,dataProviderClass = DataProviders.class, dataProvider ="Login")
					 public void CheckBuryUnbury(String loginRequired){
					 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 70 !!!!!!!!!!!!!!!!!!!!!!!");
						 //Base state. (Navigate to node page)
						 UeListPage ueList =BaseState("DefaultProprtyInBlog");
					 
						 NavBar navBar= new NavBar(getDriver());
					  		Grid grid=new Grid(getDriver());
					  		ListHeader listHeader=new ListHeader(getDriver());
						 common.signin("vijaymohanp", "server");
						 
						 navBar.hoverMore();
					     try {
								Thread.sleep(10000);
						 } catch (Exception e) {}
						ueList.clickOncreateList();
						ueList.clickOnreranking();
						if(ueList.isStickyPresent()==true){
						 ueList.clickStickyOK();
						 }
					 ueList.clickOnListName();
					 try {
						Thread.sleep(2000);
					} catch (Exception e) {}
					 ueList.putTextOnListNameBox("Testing List");
					 ueList.clickOnSearch();
					 ueList.typesearchbtn("Batman");
					 for(int i=1;i<=3;i++){
					 ueList.clickOnPlusIcon(i);
					 }
					 ueList.clickOnpublishbtn();	 
					 try {
							Thread.sleep(2000);
						} catch (Exception e) {	 
						} 
					 grid.clickOnadminburrychange();
					 listHeader.clickOnBurylist();
//					 Alert alert = getDriver().switchTo().alert();
//					 String s1=alert.getText();
//					 System.out.println("s1--"+s1);
//					 Assert.assertEquals(s1,"Also doIndexed. Toggle to change");
					 listHeader.AlertExistsAndAccepted(1000);
					 
					 String unbury=grid.getTextOFburryubburry();
					 Assert.assertEquals(unbury,"NOT BURIED");
					 
					 grid.clickOnResetTab();
				     grid.clickOnresetsublist(2);
				     listHeader.AlertExistsAndAccepted(1000);
				     try{Thread.sleep(4000);}
				     catch(Exception e){}
					 grid.clickOnadminburrychange();
					 listHeader.clickOnBurylist();
//					 Alert alert1 = getDriver().switchTo().alert();
//					 String s2=alert1.getText();
//					 System.out.println("s2--"+s2);
//					  Assert.assertEquals(s2,"Also noIndexed. Toggle to change");
					  listHeader.AlertExistsAndAccepted(2000);
					  
					     String bury=grid.getTextOFburryubburry();
						 Assert.assertEquals(bury,"BURIED");
					 }//end of BuryUnbury
					 
					 /* 
				  	  * Use-case : Verify List description,name are displaying fine for unpublished list.Create a list and dont publish it.
				  	  * Test case : Notice the list name,description etc are displaying fine .
				  	  */
					 @Test(priority=71,dataProviderClass = DataProviders.class, dataProvider ="Login")
					 public void VerifyListdescriptionandName(String loginRequired){
					 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 71 !!!!!!!!!!!!!!!!!!!!!!!");
						 //Base state. (Navigate to node page)
						 UeListPage ueList =BaseState("DefaultProprtyInBlog");
					 
						 NavBar navBar= new NavBar(getDriver());
					  		Grid grid=new Grid(getDriver());
					  		
						 common.signin("vijaymohanp", "server");
						 
						 navBar.hoverMore();
					     try {
								Thread.sleep(10000);
						 } catch (Exception e) {}
						ueList.clickOncreateList();
						ueList.clickOnreranking();
						if(ueList.isStickyPresent()==true){
						 ueList.clickStickyOK();
						 }
					 ueList.clickOnListName();
					 try {
						Thread.sleep(2000);
					} catch (Exception e) {}
					 ueList.putTextOnListNameBox("Testing List");
					 ueList.clickOnSearch();
					 ueList.typesearchbtn("Batman");
					 for(int i=1;i<=3;i++){
					 ueList.clickOnPlusIcon(i);
					 }
					 
					 
					 ueList.clickOnmylistdescription();
					 try{
						 Thread.sleep(2000);
						 }catch(Exception e){}
					 ueList.typeInlistdescription("Test Description");
					 try{
					 Thread.sleep(2000);
					 }catch(Exception e){}
					 ueList.clickOnlistdescriptiondonebtn();
					 Assert.assertEquals("Test Description", ueList.getTextlistdescription());
					 Assert.assertEquals("Testing List", ueList.getTextOfListName());
					  }//end of VerifyListdescriptionandName
					 /*
						 * Use-case : Verify center blog images setting when making a blog list
						 * Test case :  1. Open UE
										2. Go to setting and Click on "Blog list"
					 */
					 @Test(priority=72,dataProviderClass = DataProviders.class, dataProvider ="Login")
					 public void CenterBlogImage(String loginRequired){
					 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 72 !!!!!!!!!!!!!!!!!!!!!!!");
					 //Base state. (Navigate to node page)
					 UeListPage ueList =BaseStateWithLogin("ListStyleChange");
					 ueList.clickCreateListAndAdd3Items();
					 ueList.clickOnoptionbtn();
					 ueList.clickOnstylechnage();
					 ueList.clickOnblogcenterimage();
					 ueList.clickOnpublishbtn();
					 try{
						 Thread.sleep(8000);
					 }catch(Exception e){}
					 Assert.assertEquals("center", ueList.gettextalignofBlogImage(1));
					 ueList.clicksettingafterpublish();
					 ueList.clickOndeletelist();
					 ueList.AlertExistsAndAccepted(1000);
					 } //End of ListStyleChange
					 /*
						 * Use-case :   Verify Sign Up UX on Publish
						 * Test case :" 1) Go to ranker-stage.com as a guest user
										2) Create a list and click on submit
										3) See the sign up pop up 
					*/
					@Test(priority=73,dataProviderClass = DataProviders.class, dataProvider ="Login")
					public void VerifySignUpPopup(String loginRequired){
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 73 !!!!!!!!!!!!!!!!!!!!!!!");
					Commonpage common = new Commonpage(getDriver());
					RerankPage rerankpage = common.getRerankPage(url);
					UserProfilePage profile = common.getUserProfilePage(url);
					ListOptionPage listoptionpage = common.getListOptionPage(url);
					UeListPage ueList =BaseState("VerifySignUpPopup");
					NavBar navBar= new NavBar(getDriver());
					navBar.hoverMore();
					ueList.clickOncreateList();
					ueList.clickOnreranking();
					 if(ueList.isStickyPresent()==true){
					 ueList.clickStickyOK();
					 }
					ueList.clickOnListName();
					ueList.putTextOnListNameBox("Testing");
					ueList.clickOnSearch();
					ueList.typesearchbtn("Batman");
					for (int i = 1; i <= 3; i++) {
						ueList.clickOnPlusIcon(i);
					}
					ueList.clickOnpublishbtn();
					try{
						 Thread.sleep(4000);
					}catch(Exception e){}
					 Assert.assertEquals("center", ueList.gettextsignuppopupalign());
					}
					 /*
						 * Use-case : Verify center blog images setting when making a blog list
						 * Test case :  1. Open UE
										2. Go to setting and Click on "Blog list"
					 */
					 @Test(priority=74,dataProviderClass = DataProviders.class, dataProvider ="Login")
					 public void VarifyBlogImageCenter(String loginRequired){
					 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 74 !!!!!!!!!!!!!!!!!!!!!!!");
					 //Base state. (Navigate to node page)
					 UeListPage ueList =BaseStateWithLogin("ListStyleChange");
					 ueList.clickCreateListAndAdd3Items();
					 ueList.clickOnoptionbtn();
					 ueList.clickOnstylechnage();
					 ueList.clickOnblogcenterimage();
					 ueList.clickOnpublishbtn();
					 try{
						 Thread.sleep(8000);
					 }catch(Exception e){}
					 Assert.assertEquals("center", ueList.gettextalignofBlogImage(1));
					 ueList.clicksettingafterpublish();
					 ueList.clickOndeletelist();
					 ueList.AlertExistsAndAccepted(1000);
					 } //End of ListStyleChange
//				 /*
//				  * Use-case : Meta Data UX
//				  * Test case : Open Info list : http://www.ranker-stage.com/list/most-popular-democrats-that-were-once-republicans/jennifer-lee with admin
// 								change the default property in Listinfo section of the node edit pop up
//				 */
//				 @Test(priority=69,dataProviderClass = DataProviders.class, dataProvider ="Login")
//				 public void DefaultProprtyInSlideShow(String loginRequired){
//				 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 69 !!!!!!!!!!!!!!!!!!!!!!!");
//					 //Base state. (Navigate to node page)
//					 UeListPage ueList =BaseState("DefaultProprtyInSlideShow");
//					 //NavBar navBar= new NavBar(getDriver());
//					 BlogPage blogPage=new BlogPage(getDriver());
//					 Grid grid = new Grid(getDriver());
//					 ListHeader listHeader=new ListHeader(getDriver());
//					 System.out.println("111111111111");
//					 common.getNewURL(config.getProperty("Url")+"list/most-popular-democrats-that-were-once-republicans/jennifer-lee");
//					 System.out.println("222222222222222");
//					 common.signin("vijaymohanp", "server");
//					 try {
//							Thread.sleep(5000);
//						} catch (Exception e) {}
//					 grid.clickOnadminEditList();
//					 grid.clickOnlistsetting();
//					 System.out.println("33333333333333");
//					 ueList.clickOnstylechnageslideshow();
//					 ueList.clickOnpublishbtn();
//					 try {
//							Thread.sleep(5000);
//						} catch (Exception e) {}
//					 grid.clickOnadminEditList();
//					 grid.clickOnlistinfo();
//					 System.out.println("4444444444444444");
//					 try {
//							Thread.sleep(8000);
//						} catch (Exception e) {}
//					 String wikivalue=ueList.getTextOfwikitoption();
//					 int num=0;
//					 if(wikivalue=="YES"){
//						 System.out.println("aaaaaaaaaaaaa");
//						num=1;
//					 }else{
//						 System.out.println("bbbbbbbbbbbbb");
//						 ueList.clickOnwikitextoption();
//						 num=1;
//					 }
//					 
//					 System.out.println("5555555555555555555");
//					 String value=ueList.getTextOfreranktextoption();
//					 System.out.println("value=="+value);
//					 int count=0;
//					 System.out.println("66666666666");
//					 if(value=="YES"){
//						 count=1;
//					 }else
//					 {
//						ueList.clickOnreranktoption(); 
//						count=1;
//					 }
//					 System.out.println("7777777777777");
//					 ueList.clickOndefaultProprtyDonebtn();
//					 System.out.println("888888888888");
//					 try {
//							Thread.sleep(8000);
//						} catch (Exception e) {}
//					 
//					 grid.clickOnResetTab();
//				     grid.clickOnresetsublist(2);
//				     listHeader.AlertExistsAndAccepted(1000);
//				     try {
//							Thread.sleep(8000);
//					} catch (Exception e) {}
//				     System.out.println("99999999999999");
//				     if(num==1){
//				     Assert.assertNotNull(ueList.getTextOfwikitext(1));
//				     }
//				     System.out.println("10101010");
//				     if(count==1){
//				    	 System.out.println("12121212121");
//				    	Assert.assertTrue(blogPage.isAlsoRankedDescPresent(1));
//				     }
//				     grid.clickOnadminEditList();
//				     System.out.println("13131313");
//				     grid.clickOnlistinfo();
//				     System.out.println("14141414");
//				     ueList.clickOnwikitextoption();
//				     System.out.println("15151515");
//				     ueList.clickOndefaultProprtyDonebtn();
//				     try {
//							Thread.sleep(8000);
//						} catch (Exception e) {}
//				     grid.clickOnadminEditList();
//					 grid.clickOnlistsetting();
//					 ueList.clickOnviewlistmode();
//					 ueList.clickOnpublishbtn();
//				 }//End for PropertyDisplay
	/*
	 * This is base state of the UE List test-cases.
	 */
	public UeListPage BaseState(String testName) {
		try {
			startRecording(testName);
		} catch (Exception e) {
		}
		common = new Commonpage(getDriver());
		UeListPage ueList = common.getUeListPage(url);
		return ueList;
	} // End of BaseState()

	/*
	 * This is base state of the UE List test-cases.
	 */
	public UeListPage BaseStateWithLogin(String testName) {
		try {
			startRecording(testName);
		} catch (Exception e) {
		}
		common = new Commonpage(getDriver());
		UeListPage ueList = common.getUeListPage(url);
		common.signin("testuserkallol1@mailinator.com", "testing");
		//ListOptionPage listoptionpage;
		// UeListPage ueList=common.getUeListPage(url);
		return ueList;
	} // End of BaseStateWithLogin()
//
////	public void clickCreateListAndAdd3Items(UeListPage ueList) {
////		NavBar navBar= new NavBar(getDriver());
////		
////		navBar.hoverMore();
////		ueList.clickOncreateList();
////		ueList.clickOnreranking();
////		 if(ueList.isStickyPresent()==true){
////		 ueList.clickStickyOK();
////		 }
////		ueList.clickOnListName();
////		ueList.putTextOnListNameBox("Testing List");
////		ueList.clickOnSearch();
////		ueList.typesearchbtn("Batman");
////		for (int i = 1; i <= 5; i++) {
////			ueList.clickOnPlusIcon(i);
//////			try{
//////			 	Thread.sleep(5000);
//////		 }catch(Exception e){}
//////			SafeActions s = new SafeActions(getDriver());
//////		     s.waitForPageToLoad(40);
////		}
////	}
//
	
	
//	@AfterMethod(alwaysRun=true)
//	public void deletelist(ITestResult result) throws Exception{
//		Properties Sys_property = System.getProperties();
//		File directory = new File ("");
//		String absolutepath	=	directory.getAbsolutePath();
//		String outputDir = Sys_property.getProperty("OutputFolder");
//		String failureScreenshotPath =absolutepath+File.separator+"Output"+File.separator+outputDir+File.separator+"FailureScreenshots";
//		UserProfilePage profile = common.getUserProfilePage(url);
//		String failureVedioPath =absolutepath+File.separator+"Output"+File.separator+outputDir+File.separator+"FailureVideos";
//
//		profile.clickOnProfile();
//		profile.clickOnviewProfile();	
//		String after=profile.getviewbesortingViewed();
//		for(int i=1;i<=10;i++){
//		if(after.contains("Test")){
//			profile.deleteItemFromList(i);
//		}
//		}
//		System.out.println(result.getStatus());
//    	if(getDriver()==null){}else{
//    	if(config.getProperty("Relaunch").equals("true"))
//    	{
//	    		stopRecording();
//	    		if(result.getStatus()==1){
//	    			File file = new File(failureVedioPath+File.separator+result.getMethod().getMethodName()+".avi");
//	    			file.delete();
//	    		}
//	    		if(result.getStatus()==2){
//	    				
//		    			File file1 = new File(failureScreenshotPath);
//		    			if (!file1.exists()){
//		    				file1.mkdir();
//		    			}
//		    			File Imagefile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
//		    			String FailureImageFileName = result.getMethod().getMethodName()+ ".png";
//		    			//File screenshotDestDirectory = new File(failureScreenshotPath+File.separator+ FailureImageFileName);
//		    			//FileUtils.moveFile(Imagefile, screenshotDestDirectory);
//		    			FileUtils.copyFile(Imagefile, new File(failureScreenshotPath+File.separator+ FailureImageFileName));
//	    		}
//	    		//if(driver!=null){
//	    		getDriver().close();
//	    		getDriver().quit();
//    	}
//      	}
//    	
//	}
}
