package com.testsuite.NodepageTests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.pageobjects.RankBlockPage.RankPage;
import com.pageobjects.listheader.ListHeader;
import com.pageobjects.listoption.ListOptionPage;
import com.pageobjects.nodepage.Nodepage;

public class NodepageTests extends BaseSetup{
	ConfigManager urls=new ConfigManager("PreProduction");
	ConfigManager sysProp=new ConfigManager("Sys");
	Commonpage common;
	 String url=config.getProperty("Url")+urls.getProperty("NodePage");
	 
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
	  * Use-case : What's	 the formula?
	  * Test case : Open any node page and click on the "< what's the formula?" informational link to the right of the Ranking Strip.
	  */
	 @Test(priority=1,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void WhatsTheFormula(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("WhatsTheFormula");
		 }else{
			 nodePage =BaseState("WhatsTheFormula");
		 }
		// browserWait();
		 common.facebookLikePresenceAndAccept();
		 nodePage.clickOnWhatsTheFormula();
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 Assert.assertTrue(nodePage.isWhatsTheFormulaDivPresent());
		 String text= nodePage.getTextWhatsTheFormulaPopup();//block text black
		 Assert.assertNotNull(text);
		// Assert.assertEquals("The rankings are based on the number of lists Jessica Alba appears on and the total number of votes this has received.", text);
		 nodePage.clickOnOkWhatsTheFormulaPopup();
	 }//End of WhatsTheFormula()

	 /* 
	  * Use-case : Node Name
	  * Test case : Open any node page and check for the node name.
	  */
	 @Test(priority=2,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void NodeName(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("NodeName");
		 }else{
			 nodePage =BaseState("NodeName");
		 }
		 Assert.assertEquals("Jessica Alba",nodePage.getTextOfNodeName());
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("Arial, Helvetica, sans-serif", nodePage.getFontFamilyOfNodeName());
			    }else
			    {
			     Assert.assertEquals("arial, helvetica, sans-serif", nodePage.getFontFamilyOfNodeName());
			    }
		 
		// Assert.assertEquals("Arial, Helvetica, sans-serif", nodePage.getFontFamilyOfNodeName());
		 Assert.assertEquals("40px", nodePage.getFontSizeOfNodeName());
		 Assert.assertEquals("rgba(0, 0, 0, 1)", nodePage.getNodeColor("border-bottom-color"));
		 Assert.assertEquals("rgba(0, 0, 0, 1)", nodePage.getNodeColor("border-left-color"));
		 Assert.assertEquals("rgba(0, 0, 0, 1)", nodePage.getNodeColor("border-right-color"));
		 Assert.assertEquals("rgba(0, 0, 0, 1)", nodePage.getNodeColor("border-top-color"));
		 
	 }//End of NodeName() 
	 /* 
	  * Use-case : Lists About & Listed On links
	  * Test case : Open any node page and click on the "lists about ([# lists about])" and "listed on ([# lists on])" page links located directly below the node name. If a node doesn't have any lists about it or isn't any any lists, the corresponding link should not be visible.
	  */
	 @Test(priority=3,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ListAboutListedOnLinks(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("ListAboutListedOnLinks");
		 }else{
			 nodePage =BaseState("ListAboutListedOnLinks");
		 }
		 Assert.assertTrue(nodePage.isListAboutLinkPresent());
		 Assert.assertTrue(nodePage.isListedOnLinkPresent());
		 Assert.assertNotNull(nodePage.getTextOfListsAboutAndListedOn());
		 nodePage.clickOnListAboutLink();
		 Assert.assertEquals("lists about Jessica Alba", nodePage.getTextOfListsAboutSection());
		 nodePage.clickOnListedOnLink();
		 Assert.assertEquals("Jessica Alba is listed on...", nodePage.getTextOfListedOnSection());
//review/revolver-_stereo-and-mono_/1898147
         //common.getNewURL(config.getProperty("Url")+"review/fate-and-stay-night/979404");
         common.getNewURL(config.getProperty("Url")+"review/revolver-_stereo-and-mono_/1898147");
		 Assert.assertFalse(nodePage.isListAboutLinkPresent());
		 Assert.assertFalse(nodePage.isListedOnLinkPresent());
	 }//End of ListAboutListedOnLinks()
	
	 /* 
	   * Use-case : Wikipedia Description
	   * Test case : Open any node page that has a Wiki desction and check the Wiki description for the node located directly below the "lists about" and "listed on" links.
	   */
	  @Test(priority=4,dataProviderClass = DataProviders.class, dataProvider = "Login")
	  public void WikipediaDescription(String loginRequired){
	   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
	   //Base state. (Navigate to node page)
	   Nodepage nodePage=null;
	   if(loginRequired.equals("YES")){
	    nodePage =BaseStateWithLogin("WikipediaDescription");
	   }else{
	    nodePage =BaseState("WikipediaDescription");
	   }
	   Assert.assertEquals("Jessica Marie Alba is an American television and film actress and model. She began her television and movie appearances at age 13 in Camp Nowhere and The Secret World of Alex Mack. Alba rose to prominence as the lead actress in the television series Dark Angel. Alba later appeared in various films, including Honey, Sin City, Fantastic Four, Into the Blue, Fantastic Four: Rise of the Silver Surfer and Good Luck Chuck both in 2007. Alba has been called a sex symbol. S...", nodePage.getTextWikiDesc());
	   Assert.assertEquals("15px", nodePage.getFontSizeOfWikiDesc());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
	    Assert.assertEquals("Arial, Helvetica, sans-serif", nodePage.getFontFamilyOfWikiDesc());
	     }else{
	      Assert.assertEquals("arial,helevtica,sans-serif", nodePage.getFontFamilyOfWikiDesc());
	     }
	   
	  // Assert.assertEquals("Arial, Helvetica, sans-serif", nodePage.getFontFamilyOfWikiDesc());
	   Assert.assertEquals("rgba(99, 99, 99, 1)", nodePage.getColorOfWikiDesc("border-bottom-color"));
	   Assert.assertEquals("rgba(99, 99, 99, 1)", nodePage.getColorOfWikiDesc("border-left-color"));
	   Assert.assertEquals("rgba(99, 99, 99, 1)", nodePage.getColorOfWikiDesc("border-right-color"));
	   Assert.assertEquals("rgba(99, 99, 99, 1)", nodePage.getColorOfWikiDesc("border-top-color"));   
	  }//End of WikipediaDescription()

	 /* 
	  * Use-case : More on Wikipedia
	  * Test case : Open any node page that has a long Wiki description and click on the "... more on Wikipedia" link directly below the Wiki description. If the Wiki description is not truncated on the 5th line or is shorter than 5 lines, the node page shouldn't have the "... more on Wikipedia" link.
	  */
	 @Test(priority=5,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void MoreWikipedia(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("MoreWikipedia");
		 }else{
			 nodePage =BaseState("MoreWikipedia");
		 }
		 Assert.assertTrue(nodePage.isMoreOnWikiPediaPresent());
		 Assert.assertEquals("rgba(8, 108, 184, 1)", nodePage.getColorOfMoreOnWikiPedia("border-bottom-color"));
		 Assert.assertEquals("rgba(8, 108, 184, 1)", nodePage.getColorOfMoreOnWikiPedia("border-left-color"));
		 Assert.assertEquals("rgba(8, 108, 184, 1)", nodePage.getColorOfMoreOnWikiPedia("border-right-color"));
		 Assert.assertEquals("rgba(8, 108, 184, 1)", nodePage.getColorOfMoreOnWikiPedia("border-top-color"));
		 nodePage.clickOnMoreOnWikiPedia();
		 common.facebookLikePresenceAndAccept();
		 ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
		 getDriver().switchTo().window(tabs2.get(1));
		 Assert.assertEquals("Jessica Alba", nodePage.getTextHeaderOfWikipediaPage());
		 getDriver().close();
		 getDriver().switchTo().window(tabs2.get(0));
		 getDriver().get(config.getProperty("Url")+"review/18-years-old/16843711");
		 Assert.assertFalse(nodePage.isMoreOnWikiPediaPresent());
	 }//End of MoreWikipedia()
	 
	 /* 
	  * Use-case : Lists About - header
	  * Test case : Open any node page that has a Lists About section and check the header of the List About section.
	  */
	 @Test(priority=6,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ListAboutHeader(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("ListAboutHeader");
		 }else{
			 nodePage =BaseState("ListAboutHeader");
		 }
		 Assert.assertEquals("lists about Jessica Alba", nodePage.getTextOfListsAboutSection());
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("bold", nodePage.getFontWeightyOfListAboutSection());
			     }else{
			      Assert.assertEquals("700", nodePage.getFontWeightyOfListAboutSection());
			     }
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("Arial, Helvetica, sans-serif", nodePage.getFontFamilyOfListAboutSection());
			    }
			    else{
			     Assert.assertEquals("arial, helvetica, sans-serif", nodePage.getFontFamilyOfListAboutSection());
			     }
		// Assert.assertEquals("bold", nodePage.getFontWeightyOfListAboutSection());
		 //Assert.assertEquals("Arial, Helvetica, sans-serif", nodePage.getFontFamilyOfListAboutSection());
		 Assert.assertEquals("28px", nodePage.getFontSizeOfListAboutSection());
		 
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("rgb(255, 255, 255) 1px 1px 0px", nodePage.getTextShadowOfListAboutSection());
			   }else
			   {
			    Assert.assertEquals("1px 1px 0px rgba(255,255,255,1)", nodePage.getTextShadowOfListAboutSection());
			   }
		// Assert.assertEquals("rgb(255, 255, 255) 1px 1px 0px", nodePage.getTextShadowOfListAboutSection());
		 Assert.assertEquals("rgba(0, 0, 0, 1)", nodePage.getColorOfListAboutSection("border-bottom-color"));
		 Assert.assertEquals("rgba(0, 0, 0, 1)", nodePage.getColorOfListAboutSection("border-left-color"));
		 Assert.assertEquals("rgba(0, 0, 0, 1)", nodePage.getColorOfListAboutSection("border-right-color"));
		 Assert.assertEquals("rgba(0, 0, 0, 1)", nodePage.getColorOfListAboutSection("border-top-color"));
		 
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("rgba(99, 99, 99, 1)", nodePage.getColorOfListAboutText());
			   }else
			   {
			    Assert.assertEquals("rgba(99, 99, 99, 1)", nodePage.getColorOfListAboutText());
			   }
		// Assert.assertEquals("rgba(99, 99, 99, 1)", nodePage.getColorOfListAboutText());
		 
	 }//End of ListAboutHeader()
	 
	 /* 
	  * Use-case : Lists About - list images
	  * Test case : Open any node page that has a Lists About section and check the images of the lists in the Lists About section.
	  */
	 @Test(priority=7,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ListAboutImage(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("ListAboutImage");
		 }else{
			 nodePage =BaseState("ListAboutImage");
		 }
		 Assert.assertEquals("76px",nodePage.getWidthOfListAboutImage("2"));
		 Assert.assertEquals("76px", nodePage.getHeightOfListAboutImage("2"));
		 Assert.assertEquals("rgba(160, 160, 160, 1)", nodePage.getOuterBorderColorOfListAboutImage("2"));
		 Assert.assertEquals("solid", nodePage.getOuterBorderStyleOfListAboutImage("2"));
		 Assert.assertEquals("1px", nodePage.getOuterBorderWidthOfListAboutImage("2"));
		 Assert.assertEquals("2px", nodePage.getInnerBorderOfListAboutImage("2"));	 
	 }//End of ListAboutHeader()

	 
	 /* 
	  * Use-case : Lists About - list titles
	  * Test case : Open any node page that has a Lists About section and check the list title in the Lists About section.
	  */
	 @Test(priority=8,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ListAboutTitles(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("ListAboutTitles");
		 }else{
			 nodePage =BaseState("ListAboutTitles");
		 }
		 Assert.assertEquals("28px",nodePage.getFontSizeOfListAboutTitle("2"));
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("Arial, Helvetica, sans-serif",nodePage.getFontFamilyOfListAboutTitle("2"));
			    }
			    else{
			     Assert.assertEquals("arial,helevtica,sans-serif",nodePage.getFontFamilyOfListAboutTitle("2"));
			     }
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("rgba(0, 0, 0, 1)",nodePage.getColorOfListAboutTitle("2"));
			   }else
			   {
			    Assert.assertEquals("rgba(0, 0, 0, 1)",nodePage.getColorOfListAboutTitle("2"));
			   }
		// Assert.assertEquals("Arial, Helvetica, sans-serif",nodePage.getFontFamilyOfListAboutTitle("2"));
		// Assert.assertEquals("rgba(0, 0, 0, 1)",nodePage.getColorOfListAboutTitle("2"));
		 Assert.assertEquals("normal",nodePage.getFontStyleOfListAboutTitle("2"));
		 String titleBefore = nodePage.getTextOfListAboutTitle("2");
		 nodePage.clickOnListAboutTitle("2");
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 common.facebookLikePresenceAndAccept();
		 Assert.assertEquals(titleBefore,nodePage.getTitleOfHeaderOnClickTitle());
	}//End of ListAboutTitles()

	 /* 
	  * Use-case : Lists About - list Description
	  * Test case : Open any node page that has a Lists About section and check the list description in the Lists About section.
	  */
	 @Test(priority=9,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ListAboutDescription(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 9 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("ListAboutDescription");
		 }else{
			 nodePage =BaseState("ListAboutDescription");
		 }
		 Assert.assertNotNull(nodePage.getTextOfListAboutDescription("3"));
		 Assert.assertEquals("14px",nodePage.getFontSizeOfListAboutDescription("2"));
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("rgba(99, 99, 99, 1)",nodePage.getColorOfListAboutDescription("2"));
			   }else
			   {
			    Assert.assertEquals("rgba(99, 99, 99, 1)",nodePage.getColorOfListAboutDescription("2"));
			   }
		 
		// Assert.assertEquals("rgba(99, 99, 99, 1)",nodePage.getColorOfListAboutDescription("2"));
		 Assert.assertEquals("normal",nodePage.getFontStyleOfListAboutDescription("2"));
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("Arial, Helvetica, sans-serif",nodePage.getFontFamilyOfListAboutDescription("2"));
			    }
			    else{
			     Assert.assertEquals("arial, helvetica, sans-serif",nodePage.getFontFamilyOfListAboutDescription("2"));
			     }
		 
		// Assert.assertEquals("Arial, Helvetica, sans-serif",nodePage.getFontFamilyOfListAboutDescription("2"));
		 Assert.assertEquals("read more",nodePage.getTextOfListAboutDescriptionReadMore("2"));
		 Assert.assertEquals("14px",nodePage.getFontSizeOfListAboutDescriptionReadMore("2"));
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("rgba(8, 108, 184, 1)",nodePage.getColorOfListAboutDescriptionReadMore("2"));
			   }else
			   {
			    Assert.assertEquals("rgba(8, 108, 184, 1)",nodePage.getColorOfListAboutDescriptionReadMore("2"));
			   }
		 
		 //Assert.assertEquals("rgba(8, 108, 184, 1)",nodePage.getColorOfListAboutDescriptionReadMore("2"));
		 Assert.assertEquals("italic",nodePage.getFontStyleOfListAboutDescriptionReadMore("2"));
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("Georgia, serif",nodePage.getFontFamilyOfListAboutDescriptionReadMore("2"));
			    }
			    else{
			     Assert.assertEquals("georgia, serif",nodePage.getFontFamilyOfListAboutDescriptionReadMore("2"));
			     }
		 
		// Assert.assertEquals("Georgia, serif",nodePage.getFontFamilyOfListAboutDescriptionReadMore("2"));
	}//End of ListAboutDescription()

	 /* 
	  * Use-case : Also found On - header
	  * Test case : Open any node page that has an Also found section and check the header of the section.
	  */
	 @Test(priority=10,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void AlsoFoundOnHeader(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 10 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("AlsoFoundOnHeader");
		 }else{
			 nodePage =BaseState("AlsoFoundOnHeader");
		 }
		 Assert.assertEquals("is also found on...",nodePage.getTextOfIsAlsoFound());
		 Assert.assertEquals("28px",nodePage.getFontSizeOfIsAlsoFound());
		 Assert.assertEquals("rgba(99, 99, 99, 1)",nodePage.getColorOfIsAlsoFound());
		 Assert.assertEquals("normal",nodePage.getFontStyleOfIsAlsoFound());
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			   Assert.assertEquals("Arial, Helvetica, sans-serif",nodePage.getFontFamilyOfIsAlsoFound());//change
			   }
			   else{
			    Assert.assertEquals("arial, helvetica, sans-serif",nodePage.getFontFamilyOfIsAlsoFoundNodeName());
			    }
			   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("rgb(255, 255, 255) 1px 1px 0px",nodePage.getTextShadowOfIsAlsoFound());
			   }else
			   {
			    Assert.assertEquals("1px 1px 0px rgba(255,255,255,1)",nodePage.getTextShadowOfIsAlsoFound());
			   }
//		 Assert.assertEquals("Arial, Helvetica, sans-serif",nodePage.getFontFamilyOfIsAlsoFound());
//		 Assert.assertEquals("rgb(255, 255, 255) 1px 1px 0px",nodePage.getTextShadowOfIsAlsoFound());
		 
		 Assert.assertEquals("Jessica Alba is also found on...",nodePage.getTextOfIsAlsoFoundNodeName());
		 Assert.assertEquals("28px",nodePage.getFontSizeOfIsAlsoFoundNodeName());
		 Assert.assertEquals("rgba(0, 0, 0, 1)",nodePage.getColorOfIsAlsoFoundNodeName());
		 Assert.assertEquals("normal",nodePage.getFontStyleOfIsAlsoFoundNodeName());
		 
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("Arial, Helvetica, sans-serif",nodePage.getFontFamilyOfIsAlsoFoundNodeName());//change
			    }
			    else{ 
			     
			     Assert.assertEquals("arial, helvetica, sans-serif",nodePage.getFontFamilyOfIsAlsoFoundNodeName());
			    }
			   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("rgb(255, 255, 255) 1px 1px 0px",nodePage.getTextShadowOfIsAlsoFound());
			   }else
			   {
			    Assert.assertEquals("1px 1px 0px rgba(255,255,255,1)",nodePage.getTextShadowOfIsAlsoFound());
			   }
		// Assert.assertEquals("Arial, Helvetica, sans-serif",nodePage.getFontFamilyOfIsAlsoFoundNodeName());
		// Assert.assertEquals("rgb(255, 255, 255) 1px 1px 0px",nodePage.getTextShadowOfIsAlsoFoundNodeName());
	}//End of ListAboutTitles()
	 
	 /* 
	  * Use-case : Also found On - list Links
	  * Test case : Open any node page that has an Also found section and click on the list links in the section.
	  */
	 @Test(priority=11,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void AlsoFoundOnListLinks(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 11 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("AlsoFoundOnListLinks");
		 }else{
			 nodePage =BaseState("AlsoFoundOnListLinks");
		 }
		 for(int i=1;i<=12;i++){
			 Assert.assertNotNull(nodePage.getTextOfIsAlsoFoundLinkList(i+""));
		 }
		 Assert.assertEquals("collapseMore", nodePage.getClassOfShowMore());
		 String textBefore = nodePage.getTextOfIsAlsoFoundLinkList("1");
		 nodePage.clickIsAlsoFoundLinkList("1");
		 Assert.assertEquals(textBefore, nodePage.getTitleOfHeaderOnClickTitle());
	}//End of AlsoFoundOnListLinks()

	 /* 
	  * Use-case : Also found On - Show more
	  * Test case : Open any node page that has more than 12 lists that it is also found on.
	  */
	 @Test(priority=12,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void AlsoFoundOnShowMore(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("AlsoFoundOnShowMore");
		 }else{
			 nodePage =BaseState("AlsoFoundOnShowMore");
		 }
		 nodePage.clickOnShowMore();
		 Assert.assertEquals("collapseMore open", nodePage.getClassOfShowMore());
		 for(int i=12;i<=15;i++){
			 Assert.assertNotNull(nodePage.getTextOfIsAlsoFoundLinkList(i+""));
		 }
		 nodePage.clickOnShowMore();
		 Assert.assertEquals("collapseMore", nodePage.getClassOfShowMore());
	}//End of AlsoFoundOnListLinks()
	 /* 
	  * Use-case : Fans Also Vote For - header
	  * Test case : Open any node page that has a Fans Also Vote On block in the right rail and check the header of the section.
	  */
	 @Test(priority=13,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FansAlsoVoteForHeader(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 13 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("FansAlsoVoteForHeader");
		 }else{
			 nodePage =BaseState("FansAlsoVoteForHeader");
		 }
		 Assert.assertEquals("Jessica Alba"+"\n"+"fans also vote for...", nodePage.getTextOffansAlsovoteForHeader());
		 Assert.assertEquals("22px", nodePage.getFontSizeOffansAlsovoteForHeader());
		 Assert.assertEquals("rgba(99, 99, 99, 1)", nodePage.getColorOffansAlsovoteForHeader());
		 
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("bold", nodePage.getFontWeightOffansAlsovoteForHeader()); 
			     }else{
			      Assert.assertEquals("700", nodePage.getFontWeightOffansAlsovoteForHeader()); 
			     }
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("rgba(255, 255, 255, 0.8) 1px 1px 0px", nodePage.getTextShadowOffansAlsovoteForHeader());
			   }else
			   {
			    Assert.assertEquals("1px 1px 0px rgba(255,255,255,0.8)", nodePage.getTextShadowOffansAlsovoteForHeader());
			   } 
		// Assert.assertEquals("bold", nodePage.getFontWeightOffansAlsovoteForHeader());		       Assert.assertEquals("Arial, Helevtica, sans-serif", nodePage.getFontFamilyOffansAlsovoteForHeader());
		// Assert.assertEquals("rgba(255, 255, 255, 0.8) 1px 1px 0px", nodePage.getTextShadowOffansAlsovoteForHeader());
		 Assert.assertEquals("Jessica Alba", nodePage.getTextOffansAlsovoteForNodeName());
		 Assert.assertEquals("12px", nodePage.getFontSizeOffansAlsovoteForNodeName());
		 Assert.assertEquals("rgba(0, 0, 0, 1)", nodePage.getColorOffansAlsovoteForNodeName());
		 Assert.assertEquals("italic", nodePage.getFontStyleOffansAlsovoteForNodeName());
		 if(sysProp.getProperty("Browser.Name").equals("ff") || sysProp.getProperty("Browser.Name").equals("ie")){
		      Assert.assertEquals("Georgia,Times,'Times New Roman',serif", nodePage.getFontFamilyOffansAlsovoteForNodeName());
		 }
		 if(sysProp.getProperty("Browser.Name").equals("chrome")){
		      Assert.assertEquals("Georgia, Times, 'Times New Roman', serif", nodePage.getFontFamilyOffansAlsovoteForNodeName());
		 }
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("rgba(255, 255, 255, 0.8) 1px 1px 0px", nodePage.getTextShadowOffansAlsovoteForNodeName());
			   }else
			   {
			    Assert.assertEquals("1px 1px 0px rgba(255,255,255,0.8)", nodePage.getTextShadowOffansAlsovoteForNodeName());
			   } 
		 
		 
		     // Assert.assertEquals("rgba(255, 255, 255, 0.8) 1px 1px 0px", nodePage.getTextShadowOffansAlsovoteForNodeName());
	}//End of AlsoFoundOnListLinks()
	 /* 
	  * Use-case : Facts & Data - found in
	  * Test case : Open any node page that has a Facts & Data block in the right rail and click on the "Found In" links within the block.
	  */
	 @Test(priority=14,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FactsAndDataFoundIn(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 14 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("FactsAndDataFoundIn");
		 }else{
			 nodePage =BaseState("FactsAndDataFoundIn");
		 }
		 
		 Assert.assertTrue(nodePage.isFactAndDataLinkPresent("1"));
		 Assert.assertTrue(nodePage.isFactAndDataLinkPresent("2"));
		 String text=nodePage.getTextFactAndDataLink("1");
		 nodePage.clickOnFactAndDataLink("1");
		 common.facebookLikePresenceAndAccept();
		 Assert.assertEquals(text.toUpperCase(), nodePage.getTextHeaderOnClickFactAndDataLink().toUpperCase());
		 getDriver().navigate().back();
		 common.facebookLikePresenceAndAccept();
		 text =nodePage.getTextFactAndDataLink("2"); 
		 nodePage.clickOnFactAndDataLink("2");
		 common.facebookLikePresenceAndAccept();
		 Assert.assertEquals(text.toUpperCase(), nodePage.getTextHeaderOnClickFactAndDataLink().toUpperCase());
	}//End of FactsAndDataFoundIn()
	 /* 
	  * Use-case : Facts & Data - more & less
	  * Test case : Open any node page that has a Facts & Data block in the right rail with more than 3 property values under any header and click on the "more" and "less" links in the block.
	  */
	 @Test(priority=15,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FactsAndDataPropertiesValues(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 15 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("FactsAndDataPropertiesValues");
		 }else{
			 nodePage =BaseState("FactsAndDataPropertiesValues");
		 }
		 String text = nodePage.getTextOfMoreOrLessFactAndData("12");
		 System.out.println("0000000000 "+text);
		 Assert.assertEquals("more", text);
		 nodePage.clickMoreOrLessFactAndDataFor15("12");
		 try{
			 Thread.sleep(8000);
		 }catch(Exception e){}
		 text = nodePage.getTextOfMoreOrLessFactAndData("12");
		 System.out.println("1111111 "+text);
		 Assert.assertEquals("less", text);
		 nodePage.clickMoreOrLessFactAndDataFor15("12");
		 text = nodePage.getTextOfMoreOrLessFactAndData("12");
		 System.out.println("222222222 "+text);
		 Assert.assertEquals("more", text);
	}//End of FactsAndDataPropertiesValues()
	 /* 
	   * Use-case : On The Web - header
	   * Test case : Open any node page that has a "on the web" block in the right rail and check the header of the section.
	   */
	  @Test(priority=16,dataProviderClass = DataProviders.class, dataProvider = "Login")
	  public void OnTheWebHeader(String loginRequired){
	   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 16 !!!!!!!!!!!!!!!!!!!!!!!");
	   //Base state. (Navigate to node page)
	   Nodepage nodePage=null;
	   if(loginRequired.equals("YES")){
	    nodePage =BaseStateWithLogin("OnTheWebHeader");
	   }else{
	    nodePage =BaseState("OnTheWebHeader");
	   }
	   Assert.assertTrue(nodePage.isOnTheWebPresent());
	   Assert.assertEquals("Jessica Alba"+"\n"+"on the web",nodePage.getTextOfOnTheWeb());
	   Assert.assertEquals("italic",nodePage.getFontStyleOfOnTheWebNodeName());
	   Assert.assertEquals("12px",nodePage.getFontSizeOfOnTheWebNodeName());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
	    Assert.assertEquals("rgba(0, 0, 0, 1)",nodePage.getcolorOfOnTheWebNodeName());
	   }else
	   {
	    Assert.assertEquals("rgba(0, 0, 0, 1)",nodePage.getcolorOfOnTheWebNodeName());
	   }
	  // Assert.assertEquals("rgba(0, 0, 0, 1)",nodePage.getcolorOfOnTheWebNodeName());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
	    Assert.assertEquals("Georgia, Times, 'Times New Roman', serif",nodePage.getFontFamilyOfOnTheWebNodeName());
	   }else
	   {
	    Assert.assertEquals("Georgia, Times, 'Times New Roman', serif",nodePage.getFontFamilyOfOnTheWebNodeName());
	   }
	   //Assert.assertEquals("Georgia, Times, 'Times New Roman', serif",nodePage.getFontFamilyOfOnTheWebNodeName());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
	    Assert.assertEquals("rgba(255, 255, 255, 0.8) 1px 1px 0px",nodePage.getTextShadowOfOnTheWebNodeName());
	   }else
	   {
	    Assert.assertEquals("rgba(255, 255, 255, 0.8) 1px 1px 0px",nodePage.getTextShadowOfOnTheWebNodeName());
	   }
	   //Assert.assertEquals("rgba(255, 255, 255, 0.8) 1px 1px 0px",nodePage.getTextShadowOfOnTheWebNodeName());
	   Assert.assertEquals("normal",nodePage.getFontStyleOfOnTheWeb());
	   Assert.assertEquals("22px",nodePage.getFontSizeOfOnTheWeb());
	   Assert.assertEquals("rgba(99, 99, 99, 1)",nodePage.getcolorOfOnTheWeb());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
	    Assert.assertEquals("Arial, Helevtica, sans-serif",nodePage.getFontFamilyOfOnTheWeb());
	   }else
	   {
	    Assert.assertEquals("Arial, Helevtica, sans-serif",nodePage.getFontFamilyOfOnTheWeb());
	   }
	   //Assert.assertEquals("Arial, Helevtica, sans-serif",nodePage.getFontFamilyOfOnTheWeb());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
	    Assert.assertEquals("rgba(255, 255, 255, 0.8) 1px 1px 0px",nodePage.getTextShadowOfOnTheWeb());
	   }else
	   {
	    Assert.assertEquals("rgba(255, 255, 255, 0.8) 1px 1px 0px",nodePage.getTextShadowOfOnTheWeb());
	   }
	   //Assert.assertEquals("rgba(255, 255, 255, 0.8) 1px 1px 0px",nodePage.getTextShadowOfOnTheWeb());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
	    Assert.assertEquals("bold",nodePage.getFontWeightOfOnTheWeb());
	   }else
	   {
	    Assert.assertEquals("700",nodePage.getFontWeightOfOnTheWeb());
	   }
	   //Assert.assertEquals("bold",nodePage.getFontWeightOfOnTheWeb());
	  }//End of FactsAndDataPropertiesValues()//
	
	 /* 
	  * Use-case : On The Web - links
	  * Test case : Open any node page that has a "on the web" block in the right rail and click on the links in the section.
	  */
	 @Test(priority=17,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void OnTheWebLink(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 17 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("OnTheWebLink");
		 }else{
			 nodePage =BaseState("OnTheWebLink");
		 }
		 nodePage.clickOnTheWebLink();
		 common.facebookLikePresenceAndAccept();
		  Assert.assertEquals("https://twitter.com/jessicaalba", getDriver().getCurrentUrl());
	 }//End of OnTheWebLink()
//	 
////	///  not open
////	 /* 
////	  * Use-case : From Our Partners
////	  * Test case : Open any node page that has a "from our partners" block in the right rail.
////	  */
////	 @Test(priority=18,dataProviderClass = DataProviders.class, dataProvider = "Login")
////	 public void FromOurPartners(String loginRequired){
////		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 18 !!!!!!!!!!!!!!!!!!!!!!!");
////		 //Base state. (Navigate to node page)
////		 Nodepage nodePage=null;
////		 if(loginRequired.equals("YES")){
////			 nodePage =BaseStateWithLogin("FromOurPartners");
////		 }else{
////			 nodePage =BaseState("FromOurPartners");
////		 }
////		 nodePage.isFromOurPartnersHeaderPresent();
////		 nodePage.clickOnFromOurPartnerLink("1");
////		 common.facebookLikePresenceAndAccept();
////		 ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
////		 getDriver().switchTo().window(tabs2.get(1));
////		 common.facebookLikePresenceAndAccept();
////		 Assert.assertEquals("http://www.craveonline.com/", nodePage.getHeaderOnClickFromOurPartners());
////		 getDriver().close();
////		 getDriver().switchTo().window(tabs2.get(0));	
////		// Assert.assertEquals("https://twitter.com/jessicaalba", getDriver().getCurrentUrl());
////	}//End of FromOurPartners()
//	 
	 /* 
	  * Use-case : Buzzing on Ranker
	  * Test case : Open any node page that has the Buzzing on Ranker block at the bottom of the page and click on the links in the section.
	  */
	 @Test(priority=19,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void BuzzingOnRanker(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 19 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("BuzzingOnRanker");
		 }else{
			 nodePage =BaseState("BuzzingOnRanker");
		 }
		 String text= nodePage.gethrefOnBuzzingLink("1");
		 nodePage.clickOnBuzzingLink("1");
		 common.facebookLikePresenceAndAccept();
		 String currentUrl=getDriver().getCurrentUrl();
		 String[] indexurl=currentUrl.split("\\?"); 
		 Assert.assertEquals(text, indexurl[0]);
	}//End of BuzzingOnRanker()
	 /* 
	  * Use-case : Header Section
	  * Test case : Open any node page and check the header section.
	  */
	 @Test(priority=20,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void HeaderSection(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 20 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){ 
			 nodePage =BaseStateWithLogin("HeaderSection");
		 }else{
			 nodePage =BaseState("HeaderSection");
		 }
		Assert.assertEquals("linear-gradient(to right, rgb(255, 255, 255) 50%, rgb(227, 227, 227) 100%)",nodePage.getBackgroundImageOfHeader());
		Assert.assertEquals("1",nodePage.getBorderImageWidthOfHeader());
		Assert.assertTrue(nodePage.isNodeImgePresent());
		Assert.assertTrue(nodePage.isRankingStripPresent());
		Assert.assertTrue(nodePage.isWhatsTheFormulaPresent());
		Assert.assertTrue(nodePage.isSharedChickletsPresent());
		Assert.assertTrue(nodePage.isNodeNamePresent());
		Assert.assertTrue(nodePage.isListAboutLinkPresent());
		Assert.assertTrue(nodePage.isListedOnLinkPresent());
		Assert.assertTrue(nodePage.isWikiDescriptionPresent());
		Assert.assertTrue(nodePage.isPieChartPresent());
	}//End of HeaderSection()
	 
	 /* 
	  * Use-case : Facts & Data - properties & values
	  * Test case : Open any node page that has a Facts & Data block in the right rail and check the property headers and their values in the block.
	  */
	 @Test(priority=21,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FactsAndDataPropertiesAndValues(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 21 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){ 
			 nodePage =BaseStateWithLogin("FactsAndDataPropertiesAndValues");
		 }else{
			 nodePage =BaseState("FactsAndDataPropertiesAndValues");
		 }
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("rgba(78, 78, 78, 1)",nodePage.getColorOfDataFactProperty("2","1"));
			   }else
			   {
			    Assert.assertEquals("rgba(78, 78, 78, 1)",nodePage.getColorOfDataFactProperty("2","1"));
			   }
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("rgba(78, 78, 78, 1)",nodePage.getColorOfDataFactPropertyHeader("2"));
			   }else
			   {
			    Assert.assertEquals("rgba(78, 78, 78, 1)",nodePage.getColorOfDataFactPropertyHeader("2"));
			   }
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			   Assert.assertEquals("Arial, Helevtica, sans-serif",nodePage.getFontFamilyOfDataFactProperty("2","1"));
			  }
			    else{
			     Assert.assertEquals("arial,helevtica,sans-serif",nodePage.getFontFamilyOfDataFactProperty("2","1"));
			     }
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			   Assert.assertEquals("Arial, Helevtica, sans-serif",nodePage.getFontFamilyOfDataFactPropertyHeader("2"));
			  }
			    else{
			     Assert.assertEquals("arial,helevtica,sans-serif",nodePage.getFontFamilyOfDataFactPropertyHeader("2"));
			     }
		 
		//Assert.assertEquals("rgba(78, 78, 78, 1)",nodePage.getColorOfDataFactProperty("2","1"));
		//Assert.assertEquals("rgba(78, 78, 78, 1)",nodePage.getColorOfDataFactPropertyHeader("2"));
		//Assert.assertEquals("Arial, Helevtica, sans-serif",nodePage.getFontFamilyOfDataFactProperty("2","1"));
		//Assert.assertEquals("Arial, Helevtica, sans-serif",nodePage.getFontFamilyOfDataFactPropertyHeader("2"));
		Assert.assertEquals("15px",nodePage.getFontSizeOfDataFactProperty("2","1"));
		Assert.assertEquals("15px",nodePage.getFontSizeOfDataFactPropertyHeader("2")); 
		
		if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			   Assert.assertEquals("bold",nodePage.getFontWidthOfDataFactPropertyHeader("2"));
			    }else{
			     Assert.assertEquals("700",nodePage.getFontWidthOfDataFactPropertyHeader("2"));
			    }
		//Assert.assertEquals("bold",nodePage.getFontWidthOfDataFactPropertyHeader("2"));
		String text1=nodePage.getTextOfDataFactPropertyWithMore("12","1");
		for(int i=2;i<=4;i++){
			Assert.assertNotEquals(text1, nodePage.getTextOfDataFactPropertyWithMore("12",i+""));
		}
		
		text1=nodePage.getTextOfDataFactPropertyWithMore("13","1");
		for(int i=2;i<=32;i++){
			Assert.assertNotEquals(text1, nodePage.getTextOfDataFactPropertyWithMore("13",i+""));
		}		
	}//End of FactsAndDataPropertiesAndValues()
	 
	 /* 
	  * Use-case : Photo Strip - images
	  * Test case : Open any node page that has at least 8 images to check the photo strip. If a node has less than 8 images, the photo strip should not appear on its node page.
	  */
	 @Test(priority=22,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void PhotoStripImages(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 22 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){ 
			 nodePage =BaseStateWithLogin("PhotoStripImages");
		 }else{
			 nodePage =BaseState("PhotoStripImages");
		 }
		 nodePage.isPhotoStripPresent();
		 nodePage.getHeightOfPhotoStripImage();
		 for(int i=1;i<=8;i++){
			 nodePage.hoverPhotoStripImage(i);
		 }
		 String beforehref =nodePage.gethrefBeforeClickOnPhotoImageStrip(1);
		 nodePage.clickPhotoStripImage(1);
		 common.facebookLikePresenceAndAccept();
		 Assert.assertEquals(beforehref, getDriver().getCurrentUrl());		
	}//End of FactsAndDataPropertiesAndValues()
	  /* 
	   * Use-case : Fans Also Vote For - node name & classes
	   * Test case : Open any node page that has a Fans Also Vote On block in the right rail and click on the node names.
	  */
	 @Test(priority=23,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FansAlsoVoteFornodenames(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 23 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("FansAlsoVoteFornodenames");
		 }else{
			 nodePage =BaseState("FansAlsoVoteFornodenames");
		 }
		 Assert.assertEquals("18px", nodePage.getFontSizeOfFansAlsoVoteFornodenames("1"));
		 
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("rgba(0, 0, 0, 1)", nodePage.getColorOfFansAlsoVoteFornodenames("1"));
			   }else
			   {
			    Assert.assertEquals("rgba(0, 0, 0, 1)", nodePage.getColorOfFansAlsoVoteFornodenames("1"));
			   }
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("Arial, Helevtica, sans-serif", nodePage.getFontFamilyOfFansAlsoVoteFornodenames("1"));
			   }
			     else{
			      Assert.assertEquals("arial,helevtica,sans-serif", nodePage.getFontFamilyOfFansAlsoVoteFornodenames("1"));
			      } 
		 //Assert.assertEquals("rgba(0, 0, 0, 1)", nodePage.getColorOfFansAlsoVoteFornodenames("1"));
		// Assert.assertEquals("Arial, Helevtica, sans-serif", nodePage.getFontFamilyOfFansAlsoVoteFornodenames("1"));
		 Assert.assertEquals("normal", nodePage.getFontStyleOfFansAlsoVoteFornodenames("1"));
		 Assert.assertEquals("11px", nodePage.getFontSizeOffansAlsovoteForClass("1"));
		 
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("rgba(160, 160, 160, 1)", nodePage.getColorOffansAlsovoteForClass("1"));
			   }else
			   {
			    Assert.assertEquals("rgba(160, 160, 160, 1)", nodePage.getColorOffansAlsovoteForClass("1"));
			   }
		 
		// Assert.assertEquals("rgba(160, 160, 160, 1)", nodePage.getColorOffansAlsovoteForClass("1"));
		 Assert.assertEquals("italic", nodePage.getFontStyleOffansAlsovoteForClass("1"));
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("Georgia, Times, 'Times New Roman', serif", nodePage.getFontFamilyOffansAlsovoteForClass("1"));
			    }
			    else{
			     Assert.assertEquals("georgia,times,\"times new roman\",serif", nodePage.getFontFamilyOffansAlsovoteForClass("1"));
			     }
		// Assert.assertEquals("Georgia, Times, 'Times New Roman', serif", nodePage.getFontFamilyOffansAlsovoteForClass("1"));

		 String name=nodePage.getTextOfFansAlsoVoteFornodenames("1");
		 String[] subName= name.split("\n");
		 nodePage.clickOnFansAlsoVoteFornodenames("1");
		 common.facebookLikePresenceAndAccept();
		 String node=nodePage.getTextOffansAlsovoteForclick();
		 Assert.assertEquals(subName[0], node);
	}//End of FansAlsoVoteFornodenames()
	 /* Use-case : Fans Also Vote For - node images
	  * Test case : Open any node page that has a Fans Also Vote On block in the right rail and click on the node images.
	  */
	 @Test(priority=24,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FansAlsoVoteForImages(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 24 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("FansAlsoVoteForImages");
		 }else{
			 nodePage =BaseState("FansAlsoVoteForImages");
		 }

		 Assert.assertEquals("1px", nodePage.getFontSizeOfFansAlsoVoteForImages("1"));
		 Assert.assertEquals("2px", nodePage.getPaddingTopOfFansAlsoVoteForImages("1"));
		 Assert.assertTrue(nodePage.FansAlsoVoteForImagesPresent("1"));
		 String name=nodePage.getTextOfFansAlsoVoteFornodenames("1");
		 String[] subName= name.split("\n");
		 nodePage.ClickOnFansAlsoVoteForImages("1");
		 common.facebookLikePresenceAndAccept();
		 String node=nodePage.getTextOffansAlsovoteForclick();
		 Assert.assertEquals(subName[0], node);
	}//End of FansAlsoVoteForImages()
	 
	 /* 
	  * Use-case : Node Image
	  * Test case : "1) Open any node page
					 2) Click on Node image on top right side of the page."
	  */
	 @Test(priority=25,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void NodeImages(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 25 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("NodeImages");
		 }else{
			 nodePage =BaseState("NodeImages");
		 }
		 Assert.assertTrue(nodePage.NodeImagesPresent());
		 String txt=nodePage.gethrefOfNodeImages();
		 nodePage.ClickOnNodeImages();
		 common.facebookLikePresenceAndAccept();
	     Assert.assertEquals(txt, getDriver().getCurrentUrl());
			
	}//End of NodeImages()
	 
	 /* Use-case : Ranking Strip
	   * Test case : Open any node page and check the ranking strip located to the right from the top of the default node image
	         */
	  @Test(priority=26,dataProviderClass = DataProviders.class, dataProvider = "Login")
	  public void RankingStrip(String loginRequired){
	   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 26 !!!!!!!!!!!!!!!!!!!!!!!");
	   //Base state. (Navigate to node page)
	   Nodepage nodePage=null;
	   if(loginRequired.equals("YES")){
	    nodePage =BaseStateWithLogin("RankingStrip");
	   }else{
	    nodePage =BaseState("RankingStrip");
	   }
	   Assert.assertTrue(nodePage.isRankingStripPresent()); 
	   Assert.assertEquals("26px",nodePage.getFontSizeOfRankingStriprank());
	   Assert.assertEquals("rgba(0, 0, 0, 1)",nodePage.getColorOfrankingStripRank());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
	    Assert.assertEquals("bold",nodePage.getFontWeightOfrankingStripRank());
	    }
	    else{
	     Assert.assertEquals("700",nodePage.getFontWeightOfrankingStripRank());
	     }

	   //Assert.assertEquals("bold",nodePage.getFontWeightOfrankingStripRank());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
	    Assert.assertEquals("Arial, Helvetica, sans-serif",nodePage.getFontFamilyOfrankingStripRank());
	    }
	    else{
	     Assert.assertEquals("arial, helvetica, sans-serif",nodePage.getFontFamilyOfrankingStripRank());
	     }

	//   Assert.assertEquals("Arial, Helvetica, sans-serif",nodePage.getFontFamilyOfrankingStripRank());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
	    Assert.assertEquals("rgb(255, 255, 255) 1px 1px 0px",nodePage.getTextShadowOfrankingStripRank());
	    }
	    else{
	     Assert.assertEquals("1px 1px 0px rgba(255,255,255,1)",nodePage.getTextShadowOfrankingStripRank());
	     }

	   //Assert.assertEquals("rgb(255, 255, 255) 1px 1px 0px",nodePage.getTextShadowOfrankingStripRank());
	   Assert.assertEquals("12px",nodePage.getFontSizeOfRankingStripCopy());
	   Assert.assertEquals("rgba(99, 99, 99, 1)",nodePage.getColorOfrankingStripCopy());
	   Assert.assertEquals("italic",nodePage.getFontStyleOfrankingStripCopy());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
	    Assert.assertEquals("Georgia, serif",nodePage.getFontFamilyOfrankingStripCopy());
	    }
	    else{
	     Assert.assertEquals("arial,helevtica,sans-serif",nodePage.getFontFamilyOfrankingStripCopy());
	     }

	//   Assert.assertEquals("Georgia, serif",nodePage.getFontFamilyOfrankingStripCopy());
	 }//End of RankingStrip()
	 
	 /* Use-case : Facts And Data - Header
	  * Test case : Open any node page that has a facts and data block in the right rail and check the header of the section
	  *  		  */
	 @Test(priority=27,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void FactsAndDataHeader(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 27 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("FactsAndDataHeader");
		 }else{
			 nodePage =BaseState("FactsAndDataHeader");
		 }

		 Assert.assertTrue(nodePage.isfactsAndDataHeaderPresent());	
		 Assert.assertEquals("12px",nodePage.getFontSizeOffactsAndDataHeader());
		 Assert.assertEquals("rgba(0, 0, 0, 1)",nodePage.getColorOffactsAndDataHeader());
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("Georgia, Times, 'Times New Roman', serif",nodePage.getFontFamilyOffactsAndDataHeader());
			    }
			    else{
			     Assert.assertEquals("georgia,times,\"times new roman\",serif",nodePage.getFontFamilyOffactsAndDataHeader());
			     }

			  //change// Assert.assertEquals("Georgia, Times, 'Times New Roman', serif",nodePage.getFontFamilyOffactsAndDataHeader());
			   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("rgba(255, 255, 255, 0.8) 1px 1px 0px",nodePage.getTextShadowOffactsAndDataHeader());
			   }else
			   {
			    Assert.assertEquals("1px 1px 0px rgba(255,255,255,0.8)",nodePage.getTextShadowOffactsAndDataHeader());
			   }
		 
//		 Assert.assertEquals("Georgia, Times, 'Times New Roman', serif",nodePage.getFontFamilyOffactsAndDataHeader());
//		 Assert.assertEquals("rgba(255, 255, 255, 0.8) 1px 1px 0px",nodePage.getTextShadowOffactsAndDataHeader());
		
		 Assert.assertEquals("22px",nodePage.getFontSizeOffactsAndDataHeaderNode());
		 Assert.assertEquals("rgba(99, 99, 99, 1)",nodePage.getColorOffactsAndDataHeaderNode());
		 
	 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
		   Assert.assertEquals("bold",nodePage.getFontWeightOffactsAndDataHeaderNode());
		   }else{
		    Assert.assertEquals("700",nodePage.getFontWeightOffactsAndDataHeaderNode());
		   }
		   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
		    Assert.assertEquals("Arial, Helevtica, sans-serif",nodePage.getFontFamilyOffactsAndDataHeaderNode());
		    }
	    else{
	     Assert.assertEquals("arial,helevtica,sans-serif",nodePage.getFontFamilyOffactsAndDataHeaderNode());
	     }
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
		    Assert.assertEquals("rgba(255, 255, 255, 0.8) 1px 1px 0px",nodePage.getTextShadowOffactsAndDataHeader());
		   }else
		   {
		    Assert.assertEquals("1px 1px 0px rgba(255,255,255,0.8)",nodePage.getTextShadowOffactsAndDataHeader());
		   } 
		 
		// Assert.assertEquals("bold",nodePage.getFontWeightOffactsAndDataHeaderNode());
		// Assert.assertEquals("Arial, Helevtica, sans-serif",nodePage.getFontFamilyOffactsAndDataHeaderNode());
		// Assert.assertEquals("rgba(255, 255, 255, 0.8) 1px 1px 0px",nodePage.getTextShadowOffactsAndDataHeader());
	}//FactsAndDataHeader()
	 
	 
	 /* Use-case : Video - header
	   * Test case : Open any node page that has a video section, which should only appear if there are less than 7 lists combined in the lists about and listed on blocks and there are any actual videos to show
	   */
	  @Test(priority=28,dataProviderClass = DataProviders.class, dataProvider = "Login")
	  public void VideoHeader(String loginRequired){
	   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 28 !!!!!!!!!!!!!!!!!!!!!!!");
	   //Base state. (Navigate to node page)
	   Nodepage nodePage=null;
	   if(loginRequired.equals("YES")){
	    nodePage =BaseStateWithLogin("VideoHeader");
	   }else{
	    nodePage =BaseState("VideoHeader");
	   }
	         common.getNewURL(config.getProperty("Url")+"review/katawa-shoujo/32513743");
	   Assert.assertTrue(nodePage.isvideoHeaderPresent());
	   //Assert.assertEquals("linear-gradient(to right, rgb(238, 238, 238) 0px, rgb(255, 255, 255) 100%)",nodePage.getColorSizeOfvideoHeader());
	   Assert.assertEquals("none",nodePage.getColorSizeOfvideoHeader());
	   Assert.assertEquals("28px",nodePage.getFontSizeOfvideoHeaderNodeName());
	   Assert.assertEquals("rgba(0, 0, 0, 1)",nodePage.getColorOfvideoHeaderNodeName());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) 
	   {
	    Assert.assertEquals("bold",nodePage.getFontWeightOfvideoHeaderNodeName());

	   }
	   else
	   {
	    Assert.assertEquals("700",nodePage.getFontWeightOfvideoHeaderNodeName());
	   }
	   //Assert.assertEquals("bold",nodePage.getFontWeightOfvideoHeaderNodeName());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) 
	   {
	    Assert.assertEquals("Arial, Helvetica, sans-serif",nodePage.getFontFamilyOfvideoHeaderNodeName());

	   }
	   else
	   {
	    Assert.assertEquals("arial, helvetica, sans-serif",nodePage.getFontFamilyOfvideoHeaderNodeName());
	   }
	 //  Assert.assertEquals("Arial, Helvetica, sans-serif",nodePage.getFontFamilyOfvideoHeaderNodeName());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) 
	   {
	    Assert.assertEquals("rgb(255, 255, 255) 1px 1px 0px",nodePage.getTextShadowOfvideoHeaderNodeName());
	   }
	   else
	   {
	    Assert.assertEquals("1px 1px 0px rgba(255,255,255,1)",nodePage.getTextShadowOfvideoHeaderNodeName());
	   }
	  // Assert.assertEquals("rgb(255, 255, 255) 1px 1px 0px",nodePage.getTextShadowOfvideoHeaderNodeName());
	   Assert.assertEquals("rgba(99, 99, 99, 1)",nodePage.getColorOfvideoHeaderVideo());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) 
	   {
	    Assert.assertEquals("rgb(255, 255, 255) 1px 1px 0px",nodePage.getTextShadowOfvideoHeaderVideo());
	   }
	   else
	   {
	    Assert.assertEquals("1px 1px 0px rgba(255,255,255,1)",nodePage.getTextShadowOfvideoHeaderVideo());
	   }
	   //Assert.assertEquals("rgb(255, 255, 255) 1px 1px 0px",nodePage.getTextShadowOfvideoHeaderVideo());
	  }//End of VideoHeader()

	 /* Use-case : Video - videos http://www.ranker-qa.com/review/ram-charan-teja/9487482
	   * Test case : Open any node page that has a video section, which should only appear if there are less than 7 lists combined in the lists about and listed on blocks and there are any(and maximum of 3) actual videos to show
	   */
	  @Test(priority=29,dataProviderClass = DataProviders.class, dataProvider = "Login")
	  public void VideoPlay(String loginRequired){
	   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 29 !!!!!!!!!!!!!!!!!!!!!!!");
	   //Base state. (Navigate to node page)
	   Nodepage nodePage=null;
	   if(loginRequired.equals("YES")){
	    nodePage =BaseStateWithLogin("VideoPlay");
	   }else{
	    nodePage =BaseState("VideoPlay");
	   }
	         common.getNewURL(config.getProperty("Url")+"review/katawa-shoujo/32513743");
	   Assert.assertTrue(nodePage.isvideoPlayPresent("1"));
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) 
	   {
	    Assert.assertEquals("143px", nodePage.getHeightOfvideoPlay("1"));

	   }
	   else
	   {
	    Assert.assertEquals("143.22px", nodePage.getHeightOfvideoPlay("1"));
	   }
	   //Assert.assertEquals("143.22px", nodePage.getHeightOfvideoPlay("1"));
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) 
	   {
	    Assert.assertEquals("190.953125px",nodePage.getWidthOfvideoPlay("1"));
	   }
	   else
	   {
	    Assert.assertEquals("190.96px",nodePage.getWidthOfvideoPlay("1"));
	   }
	   //Assert.assertEquals("190.96px",nodePage.getWidthOfvideoPlay("1"));
	   Assert.assertEquals("15px",nodePage.getFontSizeOfvideoPlayText("1"));
	   Assert.assertEquals("rgba(136, 136, 136, 1)",nodePage.getColorOfvideoPlayText("1"));
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) 
	   {
	   Assert.assertEquals("bold",nodePage.getFontWeightOfvideoPlayText("1"));
	   }
	   else
	   {
	    Assert.assertEquals("700",nodePage.getFontWeightOfvideoPlayText("1"));
	   }
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) 
	   {
	   Assert.assertEquals("Arial, Helevtica, sans-serif",nodePage.getFontFamilyOfvideoPlayText("1"));
	   }
	   else{
	    Assert.assertEquals("arial,helevtica,sans-serif",nodePage.getFontFamilyOfvideoPlayText("1"));
	   }
	   nodePage.clickOnvideoPlay("1");
	  Assert.assertTrue(nodePage.isvideoPlayingPresent());
	  }//End of VideoHeader()
	 /* 
	   * Use-case : Photo Strip - more images
	   * Test case : Open any node page that has more than 11 images to check the "more images" link on the right side of the photo strip. If a node has less than 8 images, there should be no photo strip at all, and if there are between 8 and 11 images, there should be the photo strip with no "more images" link.
	   */
	  @Test(priority=30,dataProviderClass = DataProviders.class, dataProvider = "Login")
	  public void PhotoStripMoreImagesNumber(String loginRequired){
	   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 30 !!!!!!!!!!!!!!!!!!!!!!!");
	   //Base state. (Navigate to node page)
	   Nodepage nodePage=null;
	   if(loginRequired.equals("YES")){ 
	    nodePage =BaseStateWithLogin("PhotoStripMoreImagesNumber");
	   }else{
	    nodePage =BaseState("PhotoStripMoreImagesNumber");
	   }
	   nodePage.isphotoStripMoreImagesNumberPresent();
	   
	   for(int i=1;i<=10;i++){
	    nodePage.hoverphotoStripMoreImagesNumber(i);
	   }
	   Assert.assertEquals("14px",nodePage.getFontSizeOfphotoStripMoreImages());
	   Assert.assertEquals("rgba(8, 108, 184, 1)",nodePage.getColorOfphotoStripMoreImages());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
	    Assert.assertEquals("bold",nodePage.getFontWeightOfphotoStripMoreImages());
	    }else{
	     Assert.assertEquals("700",nodePage.getFontWeightOfphotoStripMoreImages());
	    }
	  
	   //Assert.assertEquals("bold",nodePage.getFontWeightOfphotoStripMoreImages());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
	    Assert.assertEquals("Arial, Helevtica, sans-serif",nodePage.getFontFamilyOfphotoStripMoreImages());
	    }else{
	     Assert.assertEquals("arial,helevtica,sans-serif",nodePage.getFontFamilyOfphotoStripMoreImages());
	    }
	  
	   //Assert.assertEquals("Arial, Helevtica, sans-serif",nodePage.getFontFamilyOfphotoStripMoreImages());
	   String beforehref =nodePage.gethrefphotoStripMoreImages();
	   nodePage.clickphotoStripMoreImages();
	   Assert.assertEquals(beforehref, getDriver().getCurrentUrl());  
	 }
	  /* 
	   * Use-case : Pie- Chart
	   * Test case : Open any node page that has at least 20 total votes and check for the pie chart at the top right corner of the page.
	   */
	  @Test(priority=31,dataProviderClass = DataProviders.class, dataProvider = "Login")
	  public void PieChart(String loginRequired){
	   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 31 !!!!!!!!!!!!!!!!!!!!!!!");
	   //Base state. (Navigate to node page)
	   Nodepage nodePage=null;
	   if(loginRequired.equals("YES")){ 
	    nodePage =BaseStateWithLogin("PieChart");
	   }else{
	    nodePage =BaseState("PieChart");
	   }
	   nodePage.ispieChartImagePresent();
	   nodePage.ispieChartRedPercentPresent();
	   Assert.assertEquals("rgba(255, 255, 255, 1)",nodePage.getColorOfpieChartRedPercent());
	   nodePage.ispieChartBluePercentPresent();
	   Assert.assertEquals("rgba(255, 255, 255, 1)",nodePage.getColorOfpieChartBluePercent());
	   nodePage.isPieChartPresent();
	   nodePage.ispieChartUpDownPresent();
	   nodePage.ispieChartTotalVotesHeaderPresent();
	   Assert.assertEquals("rgba(0, 0, 0, 1)", nodePage.getColorOfpieChartTotalVotesHeader());
	   Assert.assertEquals("italic",nodePage.getFontStyleOfpieChartTotalVotesHeader());
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
	    Assert.assertEquals("Georgia, Times, 'Times New Roman', serif",nodePage.getFontFamilyOfpieChartTotalVotesHeader());
	    }
	    else{
	    Assert.assertEquals("georgia,times,\"times new roman\",serif",nodePage.getFontFamilyOfpieChartTotalVotesHeader());
	     }
	  
	  // Assert.assertEquals("Georgia, Times, 'Times New Roman', serif",nodePage.getFontFamilyOfpieChartTotalVotesHeader());
	   nodePage.ispieChartTotalVotesPresent(3);
	   Assert.assertEquals("rgba(0, 0, 0, 1)", nodePage.getColorOfpieChartTotalVotes(3));
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
	    Assert.assertEquals("bold", nodePage.getFontWeightOfpieChartTotalVotes(3));
	    }
	    else{
	     Assert.assertEquals("700", nodePage.getFontWeightOfpieChartTotalVotes(3));
	     }
	  
	   //Assert.assertEquals("bold", nodePage.getFontWeightOfpieChartTotalVotes(3));
	   if (sysProp.getProperty("Browser.Name").equals("chrome")) {
	    Assert.assertEquals("Arial, Helevtica, sans-serif", nodePage.getFontFamilyOfpieChartTotalVotes(3));
	    }
	    else{
	     Assert.assertEquals("arial,helevtica,sans-serif", nodePage.getFontFamilyOfpieChartTotalVotes(3));
	     }
	  
	  // Assert.assertEquals("Arial, Helevtica, sans-serif", nodePage.getFontFamilyOfpieChartTotalVotes(3));
	     
	 }//End of PieChart

	 /* 
	  * Use-case : Listed On - header
	  * Test case : Open any node page that has a Listed on section and check the header of the Listed on section.
	  */
	 @Test(priority=32,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ListOnHeader(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 32 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("ListOnHeader");
		 }else{
			 nodePage =BaseState("ListOnHeader");
		 }
		 nodePage.islistedOnSectionPresent();
		 Assert.assertEquals("linear-gradient(to right, rgb(238, 238, 238) 0px, rgb(255, 255, 255) 100%)",nodePage.getBackgroundImageOflistedOnSectionBackground());
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("bold",nodePage.getFontWeightOflistedOnSection());
			    }else{
			     Assert.assertEquals("700",nodePage.getFontWeightOflistedOnSection());
			    }
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("Arial, Helvetica, sans-serif",nodePage.getFontFamilyOflistedOnSection());
			    }
			    else{
			     Assert.assertEquals("arial, helvetica, sans-serif",nodePage.getFontFamilyOflistedOnSection());
			     } 
		 // Assert.assertEquals("bold",nodePage.getFontWeightOflistedOnSection());
		// Assert.assertEquals("Arial, Helvetica, sans-serif",nodePage.getFontFamilyOflistedOnSection());
		 Assert.assertEquals("28px",nodePage.getFontSizeOflistedOnSection());
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("rgb(255, 255, 255) 1px 1px 0px",nodePage.getTextShadowOflistedOnSection());
			   }else
			   {
			    Assert.assertEquals("1px 1px 0px rgba(255,255,255,1)",nodePage.getTextShadowOflistedOnSection());
			   }
		 
		 // Assert.assertEquals("rgb(255, 255, 255) 1px 1px 0px",nodePage.getTextShadowOflistedOnSection());
		 Assert.assertEquals("rgba(0, 0, 0, 1)",nodePage.getColorOflistedOnSection());
		 Assert.assertEquals("rgba(99, 99, 99, 1)",nodePage.getColorOflistedOnSectionText());
		 if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("rgb(255, 255, 255) 1px 1px 0px",nodePage.getTextShadowOflistedOnSectionText());
			   }else
			   {
			    Assert.assertEquals("1px 1px 0px rgba(255,255,255,1)",nodePage.getTextShadowOflistedOnSectionText());
			   }
		/// Assert.assertEquals("rgb(255, 255, 255) 1px 1px 0px",nodePage.getTextShadowOflistedOnSectionText());
	 }//End of ListOnHeader()
	 /* 
	  * Use-case : Remove duplicate text from properties & disambiguators
	  * Test case : "Go to http://www.ranker-qa.com/review/abel-magwitch/390468 and check the ""Appears In"" section of the facts & data block. Verify that Great Expectation only appears once. Then click on the ""All Great Expectations Characters"" link in the also found on block and verify that there aren't any duplicate properties when you select the various property dropdown options.
					2. Go to http://www.ranker-qa.com/review/gordon-ramsay/1088630 and check the ""Credits (TV)"" section in the facts & data block. Verify that there aren't any duplicate properties.
					3. Go to http://www.ranker-qa.com/review/m-night-shyamalan/1640810 and check the ""Credits (Film)"" section in the facts & data block. Verify that there aren't any duplicate properties. Click on ""The Most Overrated Directors of All Time"" in the listed on block and verify that there aren't duplicate properties when checking all the property dropdown options."
	  */
	 @Test(priority=33,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void RemoveDuplicateTxtFromProperties(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 33 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){ 
			 nodePage =BaseStateWithLogin("RemoveDuplicateTxtFromProperties");
		 }else{
			 nodePage =BaseState("RemoveDuplicateTxtFromProperties");
		 }
		
	    common.getNewURL(config.getProperty("Url")+"review/abel-magwitch/390468");
		String text1=nodePage.getTextOfDataFactPropertyWithMore("2","1");
		for(int i=2;i<=4;i++){
			if (nodePage.isDataFactPropertyPresent("2", i+"")){
				Assert.assertNotEquals(text1, nodePage.getTextOfDataFactPropertyWithMore("2",i+""));
			}
		}
		nodePage.clickOnIsAlsoFoundOnLink("1");
	    common.facebookLikePresenceAndAccept();
		for (int j=1;j<=24;j++){
			if(nodePage.ispropertyDropDownPresent(j+"")){
				String[] propertyValue=nodePage.getpropertyDropDown(j+"").split(",");
				for(int i=1;i<propertyValue.length;i++){
					for (int k=i+1;k<propertyValue.length;k++)
			        {
						Assert.assertNotEquals(propertyValue[k], propertyValue[i]);
			        }
				}
			}
		}
		//2. Go to http://www.ranker-qa.com/review/gordon-ramsay/1088630 and check the ""Credits (TV)"" section in the facts & data block. Verify that there aren't any duplicate properties.
		
	    common.getNewURL(config.getProperty("Url")+"review/gordon-ramsay/1088630");
		nodePage.clickMoreOrLessFactAndData("10");
		for(int j=1;j<=21;j++){
			text1=nodePage.getTextOfDataFactPropertyWithMore("10",j+"");
			for(int i=j+1;i<=21;i++){
				Assert.assertNotEquals(text1, nodePage.getTextOfDataFactPropertyWithMore("10",i+""));
			}
		}
		//3. Go to http://www.ranker-qa.com/review/m-night-shyamalan/1640810 and check the ""Credits (Film)"" section in the facts & data block. Verify that there aren't any duplicate properties. Click on ""The Most Overrated Directors of All Time"" in the listed on block and verify that there aren't duplicate properties when checking all the property dropdown options."
		
	    common.getNewURL(config.getProperty("Url")+"review/m-night-shyamalan/1640810");
		nodePage.clickMoreOrLessFactAndData("12");
		for(int j=1;j<=15;j++){
			 text1=nodePage.getTextOfDataFactPropertyWithMoreFor33("12",j+"");
			for(int i=j+1;i<=15;i++){
				Assert.assertNotEquals(text1, nodePage.getTextOfDataFactPropertyWithMoreFor33("12",i+""));
			}
		}
		nodePage.clickOnoverRatedDirectors();
        common.facebookLikePresenceAndAccept();
		for (int j=1;j<=51;j++){
			if(nodePage.ispropertyDropDownPresent(j+"")){
				String[] propertyValue=nodePage.getpropertyDropDown(j+"").split(",");
				for(int i=1;i<propertyValue.length;i++){
					for (int k=i+1;k<propertyValue.length;k++)
			        {
						Assert.assertNotEquals(propertyValue[k], propertyValue[i]);
			        }
				}
			}
		}
	}//End of FactsAndDataPropertiesAndValues()
	 /* 
	  * Use-case : Listed On - cascading lists
	  * Test case : Open any node page that has at least 8 lists in the Listed On section. If a node page has less than 8 lists in the Listed On section, it should not be in the cascading Related Lists styling.
	  */
	 @Test(priority=34,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ListOnCasecadingList(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 34 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("ListOnCasecadingList");
		 }else{
			 nodePage =BaseState("ListOnCasecadingList");
		 }
		nodePage.clickOnListedOnLink();
		for(int i=1;i<=8;i++){
			
			Assert.assertTrue(nodePage.isRankedOnWithDescriptionPresent(i));
			Assert.assertTrue(nodePage.isListedTitlePresent(1));
		}
		
	 }//End of ListOnCasecadingList()
	 /* 
	  * Use-case : Listed On - horizontal lists
	  * Test case : Open any node page that has less than 8 lists in the Listed On section. If a node page has 8 or more lists in the Listed On section, it should not be in the horizontal styling.
	  */
	 @Test(priority=35,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ListOnHorizontalList(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 35 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("ListOnHorizontalList");
		 }else{
			 nodePage =BaseState("ListOnHorizontalList");
		 }
		nodePage.clickOnListedOnLink();
		int status =0;
		int num=0;
		for(int i=1;i<=8;i++){
			if(nodePage.isRankedListedBoxPresent(i)==true){
				num=i;
				status=1;
				break;
			}
		}
		if(status == 1){
			Assert.assertEquals("75px", nodePage.getHeightOfRankedListedBox(num));
			Assert.assertEquals("75px", nodePage.getWidthOfRankedListedBox(num));
			
			if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("rgba(112, 112, 112, 0.8) 1px 1px 3px 0px", nodePage.getBoxShadowOfRankedListedBox(num));
			    }else
			    {
			     Assert.assertEquals("1px 1px 3px 0px rgba(112,112,112,0.8)", nodePage.getBoxShadowOfRankedListedBox(num));
			    }
			if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("bold", nodePage.getFontWeightOfRankedListedListedTxt(num));
			     }else{
			      Assert.assertEquals("700", nodePage.getFontWeightOfRankedListedListedTxt(num));
			     }
			//Assert.assertEquals("rgba(112, 112, 112, 0.8) 1px 1px 3px 0px", nodePage.getBoxShadowOfRankedListedBox(num));
			//Assert.assertEquals("bold", nodePage.getFontWeightOfRankedListedListedTxt(num));
			Assert.assertEquals("10px", nodePage.getFontSizeOfRankedListedListedTxt(num));
			if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("bold", nodePage.getFontWeightOfRankedListedRankTxt(num));
			     }else{
			      Assert.assertEquals("700", nodePage.getFontWeightOfRankedListedRankTxt(num));
			     }
			
		//	Assert.assertEquals("bold", nodePage.getFontWeightOfRankedListedRankTxt(num));
			Assert.assertEquals("25px", nodePage.getFontSizeOfRankedListedRankTxt(num));
			Assert.assertEquals("rgba(0, 0, 0, 1)", nodePage.getColorOfRankedListedRankTxt(num));
			
			if (sysProp.getProperty("Browser.Name").equals("chrome")) {
			    Assert.assertEquals("bold", nodePage.getFontWeightOfRankedListedRankOfTxt(num));
			     }else{
			      Assert.assertEquals("700", nodePage.getFontWeightOfRankedListedRankOfTxt(num));
			     }
			//Assert.assertEquals("bold", nodePage.getFontWeightOfRankedListedRankOfTxt(num));
			Assert.assertEquals("10px", nodePage.getFontSizeOfRankedListedRankOfTxt(num));
			Assert.assertEquals("rgba(0, 0, 0, 1)", nodePage.getColorOfRankedListedRankOfTxt(num));
			status=0;
		}else{
			Assert.assertEquals(0, 1);//Assert.assertEquals(1,1);
		}
	 }//End of ListOnHorizontalList()
	 /* 
	  * Use-case : Lists About - logic
	  * Test case : Open any node page that has a Lists About section and check that the lists showing up match the logic for the block.
	  */
	 @Test(priority=36,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ListsAboutLogic(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 36 !!!!!!!!!!!!!!!!!!!!!!!");
		 //Base state. (Navigate to node page)
		 Nodepage nodePage=null;
		 if(loginRequired.equals("YES")){
			 nodePage =BaseStateWithLogin("ListsAboutLogic");
		 }else{
			 nodePage =BaseState("ListsAboutLogic");
		 }
		nodePage.clickOnListAboutLink();
		nodePage.clickListAboutTitle("1");
		Assert.assertEquals("Vote List", nodePage.getTextOfVoteList());
	 }//End of ListOnHorizontalList()
	    /*
		 * Use-case : Node Image - Share Chicklets - Facebook
		 * Test case : Open any node page and click on the Facebook share icon in the Share Chicklets section at the top right of the page.
		 */	
		@Test(priority=37,dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void ShareChicklets_Facebook(String loginRequired){
			//
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 37 !!!!!!!!!!!!!!!!!!!!!!!");
			Nodepage nodePage=null;
			 if(loginRequired.equals("YES")){
				 nodePage =BaseStateWithLogin("ShareChicklets_Facebook");
			 }else{
				 nodePage =BaseState("ShareChicklets_Facebook");
			 }
			//Click on facebook and check whether right page is opening or not.	
			nodePage.clickOnfacebook();
			browserWait();
				//getDriver().switchTo().window("Facebook - Mozilla Firefox");
				//String title = nodePage.switchToWindowAndGetTitle();
				//Assert.assertEquals("Facebook", title);
			common.facebookLogin("salmankhantc", "Dehradun1");
			Assert.assertTrue(nodePage.isFbShareWindowPresent());
				getDriver().close();
				nodePage.switchToParentWindow();
								
		}// End of ShareChicklets_Facebook
		 /*
		 * Use-case : Node Image - Share Chicklets - Twitter
		 * Test case :Open any node page and click on the Twitter share icon in the Share Chicklets section at the top right of the page.
		 */	
		@Test(priority=38,dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void ShareChicklets_Twitter(String loginRequired){
			//
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 38 !!!!!!!!!!!!!!!!!!!!!!!");
			Nodepage nodePage=null;
			ListOptionPage listoptionpage =new ListOptionPage(getDriver());
			 ListHeader listHeader=new ListHeader(getDriver());
			 if(loginRequired.equals("YES")){
				 nodePage =BaseStateWithLogin("ShareChicklets_Twitter");
			 }else{
				 nodePage =BaseState("ShareChicklets_Twitter");
			 }
				//Click on twitter and check whether right page is opening or not.	
				nodePage.clickOnTwitter();
				//browserWait();
				//String title = nodePage.switchToWindowAndGetTitle();
				//Assert.assertEquals("Share a link on Twitter", title);
				common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
				if(listoptionpage.isPresenttiwtterlogin()==true){
					Assert.assertEquals(1,1);
				}else if(listHeader.isPresenttwitterwindowpresent()) {
					Assert.assertEquals(1,1);
				}else
				{
					Assert.assertEquals(1,0);	
				}
			  getDriver().close();
		     listHeader.switchToWindow(0);
		}// End of ShareChts_Twitter
		
		/* 
		  * Use-case : Images & Ads
		  * Test case : Open any Node page and check for all images and ads.
		  */
		 @Test(priority=39,dataProviderClass = DataProviders.class, dataProvider = "Login")
		 public void PresentAdsInNodepage(String loginRequired){
			 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 39 !!!!!!!!!!!!!!!!!!!!!!!");
			 //Base state. (Navigate to page having right rail)
			 Nodepage nodePage=null;
			 if(loginRequired.equals("YES")){
				 nodePage =BaseStateWithLogin("PresentAdsInNodepage");
			 }else{
				 nodePage =BaseState("PresentAdsInNodepage");
			 }
			 common.getNewURL(config.getProperty("Url")+"review/jessica-alba/1285612");
			 try {
				Thread.sleep(5000);
			} catch (Exception e) {}
			 Assert.assertTrue(nodePage.isPresentads1());
			 
		 }//End of PresentAdsInNodepage 
		 /* 
		  * Use-case : Node logic for fans have also viewed
		  * Test case :Open node page with less than 8 lists between lists about and listed on section eg:
					   http://www.ranker-stage.com/review/jean-valjean/1277962
		  */
		 @Test(priority=40,dataProviderClass = DataProviders.class, dataProvider = "Login")
		 public void NodeLogic(String loginRequired){
			 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 40!!!!!!!!!!!!!!!!!!!!!!!");
			 //Base state. (Navigate to page having right rail)
			 Nodepage nodePage=null;
			 if(loginRequired.equals("YES")){
				 nodePage =BaseStateWithLogin("NodeLogic");
			 }else{
				 nodePage =BaseState("NodeLogic");
			 }
			 common.getNewURL(config.getProperty("Url")+"review/jean-valjean/1277962");
			 nodePage.isISListedOnHeaderPresent();
			 int count=nodePage.ISListedOnSizecount();
			 if(count<8){
				 Assert.assertTrue(nodePage.isFansAlsoViewedHeaderPresent());
			 }
			  for(int i=1;i<=6;i++){
			      Assert.assertTrue(nodePage.isFansAlsoViewedPresent(i));
			 }
		 }
		 /* 
		  * Use-case : Node logic for fans have also viewed
		  * Test case :Open node page with at-least 8 lists between lists about and listed on section: eg: http://www.ranker-stage.com/review/charlie-sheen/706472
          */            
		 @Test(priority=41,dataProviderClass = DataProviders.class, dataProvider = "Login")
		 public void NodeLists(String loginRequired){
			 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 41!!!!!!!!!!!!!!!!!!!!!!!");
			 //Base state. (Navigate to page having right rail)
			 Nodepage nodePage=null;
			 if(loginRequired.equals("YES")){
				 nodePage =BaseStateWithLogin("NodeLists");
			 }else{
				 nodePage =BaseState("NodeLists");
			 }
			 common.getNewURL(config.getProperty("Url")+"review/charlie-sheen/706472");
			  Assert.assertTrue(nodePage.isListsAboutHeaderPresent());
			  // for(int i=1;i<=8;i++){
			  int count=nodePage.ISListedOnSizecount();
			  if(count>8){
				  for(int i=1;i<=8;i++){
				   Assert.assertTrue(nodePage.isListsAboutHeaderSectionPresent(i));
				    }
			  }
			   Assert.assertTrue(nodePage.isnotdisplayPresentFansAlsoViewedHeader());
			 }
		
		
	 /*
	  * This is base state of the slide show test-cases.
	  */
	 public Nodepage BaseState(String testName){
		 try{
		 startRecording(testName);
		}catch(Exception e){}
		 common=new Commonpage(getDriver());
		 Nodepage nodePage=common.getNodePage(url);
		 return nodePage;
	 } //End of BaseState()
	 /*
	  * This is base state of the slide show test-cases.
	  */
	 public Nodepage BaseStateWithLogin(String testName){
		 try{
		 startRecording(testName);
		}catch(Exception e){}
		 common=new Commonpage(getDriver());
		 common.signin("testuserkallol1@mailinator.com", "testing");
		 Nodepage nodePage=common.getNodePage(url);
		 return nodePage;
	 } //End of BaseStateWithLogin()
}
