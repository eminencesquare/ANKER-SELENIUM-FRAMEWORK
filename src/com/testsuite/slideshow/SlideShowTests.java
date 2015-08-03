package com.testsuite.slideshow;

import java.io.File;
import java.io.InputStream;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.pageobjects.grid.Grid;
import com.pageobjects.listheader.ListHeader;
import com.pageobjects.listoption.ListOptionPage;
import com.pageobjects.slideshow.PicsPage;
import com.pageobjects.slideshow.Slideshow;
import com.pageobjects.uelist.UeListPage;
import com.thoughtworks.selenium.webdriven.commands.GetAlert;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import com.selenium.SafeActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SlideShowTests extends BaseSetup{
	
	 ConfigManager urls=new ConfigManager("PreProduction");
	 Commonpage common;
	 String url=config.getProperty("Url")+urls.getProperty("SlideShow");
	 ConfigManager sysProp=new ConfigManager("Sys");
	 
	 /*
	  * Wait for browser.
	  */
	 public void browserWait(){
		 if(sysProp.getProperty("Browser.Name").equals("chrome")){
			 try{
				 Thread.sleep(15000); 
			 }catch(Exception e){}	
		 }
	 }
	 /* 
	  * Use-case : Node Ranking
	  * Test case : Check the node rankings of multiple slides in a slideshow.  
	  */
	 @Test(priority=1,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void Node_Ranking(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("Node_Ranking");
		 }else{
			 slideshow =BaseState("Node_Ranking");
		 }
       //  common.getNewURL(url);
		 //
		// common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?");
		// common.getNewURL(config.getProperty("Url")+"list/lessons-from-movies/derrick-deane?format=SLIDESHOW&page=31&action=lastpage");
		 for(int i=1;i<5;i++){
			 if(i>1){
				 slideshow.clickNext();
				 browserWait();
			 }
			 Assert.assertEquals(String.valueOf(i), slideshow.getSlideNo());
		 }
	 }
	 
	 /* 
	  * Use-case : Node Name
	  * Test case : Check the node name of multiple slides in a slideshow.  
	  */
	 @Test(priority=2,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void Node_Name(String loginRequired){
		 //  common common=new Commonpage(getDriver());
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("Node_Name");
		 }else{
			 slideshow =BaseState("Node_Name");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?");
		// common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
       // common.getNewURL(url);
		 System.out.println(slideshow.getSlideHeading());
		 Assert.assertTrue(!slideshow.getSlideHeading().contains("\\."));	  
	 }
	 /* 
	  * Use-case : Node Image - hover
	  * Test case : Hover over multiple node images in a slideshow.  
	  */
	 @Test(priority=3,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void NodeImage_hover(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("NodeImage_hover");
		 }else{
			 slideshow =BaseState("NodeImage_hover");
		 }
		 common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?");
		// common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
		 slideshow.mousehovernodeimg();
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		Assert.assertFalse(slideshow.nodeImageAttribute());
		/////////Behaviour changed, so the lines are commented
			//String s=slideshow.nodeImageAttribute();
			// Assert.assertFalse(s.contains("display: inline"), "Img Zoom button");
	 }
	 /* 
	  * Use-case : Node Image - click
	  * Test case : Click on multiple node images in a slideshow. 
	  */
	 @Test(priority=4,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void NodeImageClick(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("NodeImage_click");
		 }else{
			 slideshow =BaseState("NodeImage_click");
		 }

     // common.getNewURL(url);
		 common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?");
		 //common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
	  PicsPage picspge=slideshow.clickOnNodepic();
	  try {
		Thread.sleep(2000);
	} catch (Exception e) {
		// TODO: handle exception
	}
	  Assert.assertTrue(picspge.verifyPicsGallery(), "Pics Gallery in Pics page");
	  browserWait();
	  picspge.hoveronSlideNxt();
	  String s=picspge.nxtBGround();
	  System.out.println(s);
	 }
	 
	 /* 
	  * Use-case : Node Image - click
	  * Test case : Click on multiple node images in a slideshow. 
	  */
	@Test(priority=5,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void SlideShow(String loginRequired){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("SlideShow");
		 }else{
			 slideshow =BaseState("SlideShow");
		 }
		for(int i=1;i<4;i++){
			if(i>1){
				slideshow.clickNext();
				browserWait();
			}
			System.out.println("Slide No :- "+slideshow.getSlideNo());
			Assert.assertEquals(String.valueOf(i), slideshow.getSlideNo());
		}
	}
	/*
	 * Use-case : Carousel - hover next slide
	 * Test case : Hover over the next slide arrow on multiple slides in a slideshow. 
	 */
	@Test(priority=6,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void NextSlideArrowHover(String loginRequired){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("NextSlideArrow_hover");
		 }else{
			 slideshow =BaseState("NextSlideArrow_hover");
		 }
		//Hover next slide arrow
		 WebElement we = getDriver().findElement(By.xpath("//*[@class='float absolute pointer hidden slideImgNext']/div/span"));
		slideshow.carousel_nextSlideHover();
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(we.getCssValue("color").equals("rgba(212, 210, 210, 1)")){
		     Assert.assertEquals("rgba(212, 210, 210, 1)", we.getCssValue("color"));
		}
		else{
		    Assert.assertEquals("rgba(8, 108, 184, 1)", we.getCssValue("color"));
		}
	} //end of NextSlideArrowHover()
	
	/*
	 * Use-case : NEXT >> Button
	 * Test case : Click on the NEXT >> button on any slide except the last.
	 */	
	@Test(priority=7,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void NextButton_click(String loginRequired){
		//
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("NextButton_click");
		 }else{
			 slideshow =BaseState("NextButton_click");
		 }
		
		//Check the behavior of the next button functionality.
		String slideNoBeforeNext = slideshow.getSlideNo();
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		int slideIntegerBefore = Integer.parseInt(slideNoBeforeNext);
		slideshow.clickOnNextButton();
		browserWait();
		String slideNoAfterNext = slideshow.getSlideNo();
		int slideIntegerAfter = Integer.parseInt(slideNoAfterNext);
		Assert.assertEquals(slideIntegerBefore, slideIntegerAfter-1);
	}// End of NextButton_click()
	
	/*
	 * Use-case : NEXT >> Button
	 * Test case : Click on the NEXT >> button on the last slide.
	 */	
	@Test(priority=8,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void NextButtonOnLastSlide_click(String loginRequired){
		//
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("NextButtonOnLastSlide_click");
		 }else{
			 slideshow =BaseState("NextButtonOnLastSlide_click");
		 }
		 slideshow.clickOnSlide(28);
		
		//Click on last slide and check the behavior of the Next button.
		//slideshow.clickOnLastSlide();
		slideshow.clickOnNextButton();	
		browserWait();
	   for(int i=1;i<=8;i++){
			Assert.assertTrue(slideshow.isImgNextToLastSlidePresent(i));
		}
	}// End of NextButtonOnLastSlide_click()
	/*
	 * Use-case : << PREV Button
	 * Test case : Click on the << PREV button on any slide except the first.
	 */	
	@Test(priority=9,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void PreviousButton_click(String loginRequired){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 9 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("PreviousButton_click");
		 }else{
			 slideshow =BaseState("PreviousButton_click");
		 }
		
		//Click on 3rd slide and check the behavior of previous button.
		// common.votableLinkPresenceAndAccept();
		slideshow.clickOnSlide(3);
		String slideNoBeforePrevious = slideshow.getSlideNo();
		int slideIntegerBefore = Integer.parseInt(slideNoBeforePrevious);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		slideshow.clickOnPreviousButton();
		browserWait();
		browserWait();
		String slideNoAfterPrevious = slideshow.getSlideNo();
		int slideIntegerAfter = Integer.parseInt(slideNoAfterPrevious);
		Assert.assertEquals(slideIntegerBefore, slideIntegerAfter+1);
	} //End of PreviousButton_click()
	/*
	 * Use-case : << PREV Button
	 * Test case : Click on the << PREV button on the first slide.
	 */	
	@Test(priority=10,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void PreviousButtonOnFirstSlide_click(String loginRequired){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 10 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("PreviousButtonOnFirstSlide_click");
		 }else{
			 slideshow =BaseState("PreviousButtonOnFirstSlide_click");
		 }
		//slideshow.clickOnSlide(2);
		//Check the previous button functionality when on first slide.
		slideshow.clickOnpreviousSlideButton();
		browserWait();
		String slideNoAfterPrevious = slideshow.getSlideNo();
		int slideIntegerAfter = Integer.parseInt(slideNoAfterPrevious);
		Assert.assertEquals(1, slideIntegerAfter);
	} // End of PreviousButtonOnFirstSlide_click()
	
	/*
	 * Use-case : |< Button
	 * Test case : Click on the "|<" button on any slide except the first.
	 */	
	@Test(priority=11,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FirstSlideButton_click(String loginRequired){
		//
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 11 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("FirstSlideButton_click");
		 }else{
			 slideshow =BaseState("FirstSlideButton_click");
		 }
		
		//Check the functionality when on first slide.
		slideshow.clickOnSlide(2);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
        slideshow.clickOnFirstSlideButton();
		browserWait();
		String slideNo = slideshow.getSlideNo();
		int slideIntegerAfter = Integer.parseInt(slideNo);
		Assert.assertEquals(1, slideIntegerAfter);
	} //End of FirstSlideButton_click()

	/*
	 * Use-case : |< Button
	 * Test case : Click on the "|<" button on any slide except the first.
	 */	
	@Test(priority=12,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void FirstSlideButtonOnAnySlide_click(String loginRequired){
		//
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("FirstSlideButtonOnAnySlide_click");
		 }else{
			 slideshow =BaseState("FirstSlideButtonOnAnySlide_click");
		 }
		
		//Click on 5th slide and then check "|<" button functionality.
		slideshow.clickOnSlide(5);
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		slideshow.clickOnFirstSlideButton();
		browserWait();
		String slideNo = slideshow.getSlideNo();
		int slideIntegerAfter = Integer.parseInt(slideNo);
		Assert.assertEquals(1, slideIntegerAfter);
	}// End of FirstSlideButtonOnAnySlide_click()
	
	/*
	 * Use-case : Mini Carousel Image - click
	 * Test case : Click on multiple images in the mini image carousel.
	 */	
	@Test(priority=13,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void MiniCarouselImage_click(String loginRequired)
	{
		//
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 13 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("MiniCarouselImage_click");
		 }else{
			 slideshow =BaseState("MiniCarouselImage_click");
		 }
		
		//Click on 5th slide in the mini carousel.
		slideshow.clickOnSlide(5);
		browserWait();
		String nodeNo = slideshow.getNodeNumber(5);
		int intNodeNo = Integer.parseInt(nodeNo);
		Assert.assertEquals(5, intNodeNo);
	}//End of MiniCarouselImage_click()
//	
//	///  chnage functionlaity
////		/*
////		 * Use-case : Mini Carousel - next hover
////		 * Test case : Hover over the next arrow in the mini carousel.
////		 */	
////		@Test(priority=14,dataProviderClass = DataProviders.class, dataProvider = "Login")
////		public void MiniCarouselNext_hover(String loginRequired){
////			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 14 !!!!!!!!!!!!!!!!!!!!!!!");
////			 Slideshow slideshow=null;
////			 if(loginRequired.equals("YES")){
////				 slideshow =BaseStateWithLogin("MiniCarouselNext_hover");
////			 }else{
////				 slideshow =BaseState("MiniCarouselNext_hover");
////			 }
////			
////			//Checking for the hover of 
////			WebElement we = getDriver().findElement(By.xpath("//div[contains(@id,'slideThumbCntr_')]/span[contains(@id,'slideThumbNext_')]/i"));
////			System.out.println("1111111111111111");
////			slideshow.hoverOverslide();
////			slideshow.miniCarouselNextHover();
////			System.out.println("222222222222");
////			System.out.println("Colour comparison blue "+ we.getCssValue("border-left-color"));
////			if ("rgba(8, 108, 184, 1".equals(we.getCssValue("border-left-color"))){
////				System.out.println("33333333333333333");
////			Assert.assertEquals("rgba(8, 108, 184, 1)", we.getCssValue("border-left-color"));
////			}
////			if("rgba(10, 125, 212, 1)".equals(we.getCssValue("border-left-color"))){
////				Assert.assertEquals("rgba(10, 125, 212, 1)", we.getCssValue("border-left-color"));
////			}
////		}// End of MiniCarouselNext_hover()
//		
		/*
	     * Use-case : Mini Carousel - next click
	     * Test case : Click on the next arrow in the mini carousel.
	     */	
		@Test(priority=15,dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void MiniCarouselNext_click(String loginRequired){
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 15 !!!!!!!!!!!!!!!!!!!!!!!");
			 Slideshow slideshow=null;
			 if(loginRequired.equals("YES")){
				 slideshow =BaseStateWithLogin("MiniCarouselNext_click");
			 }else{
				 slideshow =BaseState("MiniCarouselNext_click");
			 }
		
		
			//Clicking on next mini carousel button and checking for next 7 slides display.
			slideshow.hoverOverslide();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			slideshow.miniCarouselNextClick();
			browserWait();
			for (int i=6;i<=14;i++)
			{
				
				slideshow.clickOnSlide(i);
				browserWait();
				String nodeNo = slideshow.getSlideNo();
			//	String nodeNo = slideshow.getNodeNumber();
				int intNodeNo = Integer.parseInt(nodeNo);
				Assert.assertEquals(i, intNodeNo);
			}
			///functionlity changed
//			//Checking behaviour of next mini carousel when on last slide.
//			slideshow.clickOnLastSlide();
//			WebElement we = getDriver().findElement(By.xpath("//div[contains(@id,'slideThumbCntr_')]/span[contains(@id,'slideThumbNext_')]/i"));
//			//WebElement we = getDriver().findElement(By.xpath("//div[@id='slideNext']/span[contains(@class,'float block shape arrowRight')]"));
//			slideshow.miniCarouselNextHover();
//		//System.out.println("Colour comparison blue "+ we.getCssValue("border-left-color"));
//		Assert.assertEquals("rgba(229, 229, 229, 1)", we.getCssValue("border-left-color"));
	} // End of MiniCarouselNext_click()
//		
//	 //Functionlity chnage
////	 /*
////	  * Use-case : Mini Carousel - previous hover
////	  * Test case : Hover over the previous arrow in the mini carousel.
////	  */	
////	 @Test(priority=16,dataProviderClass = DataProviders.class, dataProvider = "Login")
////		public void MiniCarouselPrevious_hover(String loginRequired)
////	 {
////		 //
////		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 16 !!!!!!!!!!!!!!!!!!!!!!!");
////		 Slideshow slideshow=null;
////		 if(loginRequired.equals("YES")){
////			 slideshow =BaseStateWithLogin("MiniCarouselPrevious_hover");
////		 }else{
////			 slideshow =BaseState("MiniCarouselPrevious_hover");
////		 }
////		 //Check hover actions when on first slide.				
////		 WebElement we = getDriver().findElement(By.xpath("//div[@id='slidePrev']/span[contains(@class,'float block shape arrowLeft')]"));
////		 slideshow.miniCarouselPreviousHover();
////		 System.out.println("Colour comparison blue "+ we.getCssValue("border-right-color"));
////		 Assert.assertEquals("rgba(229, 229, 229, 1)", we.getCssValue("border-right-color"));
////		 
////		 //Check hover actions when on next mini carousel
////		 slideshow.miniCarouselNextClick();
////		 try{
////				Thread.sleep(2000);
////		 }catch(Exception e){}
////		 slideshow.miniCarouselPreviousHover();
////		 System.out.println("Colour comparison blue "+ we.getCssValue("border-right-color"));
////		 if ("rgba(8, 108, 184, 1".equals(we.getCssValue("border-right-color"))){
////			 Assert.assertEquals("rgba(8, 108, 184, 1)", we.getCssValue("border-right-color"));
////		 }
////		 if("rgba(10, 125, 212, 1)".equals(we.getCssValue("border-right-color"))){
////			 Assert.assertEquals("rgba(10, 125, 212, 1)", we.getCssValue("border-right-color"));
////		 }
////	} // End of MiniCarouselPrevious_hover()
//	 	
	 /*
	  * Use-case : Mini Carousel - previous click
	  * Test case : Click on the previous arrow in the mini carousel.
	  */
	 @Test(priority=17,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void MiniCarouselPrevious_click(String loginRequired)
	 {
		 //
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 17 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("MiniCarouselPrevious_click");
		 }else{
			 slideshow =BaseState("MiniCarouselPrevious_click");
		 }
				
		 //Click on Next mini carousel list, to get previous button enabled.
		// common.votableLinkPresenceAndAccept();
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 slideshow.hoverOverslide();
		 slideshow.miniCarouselNextClick();
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 slideshow.clickOnSlide(8);
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 String nodeNo = slideshow.getSlideNo();
		// String nodeNo = slideshow.getNodeNumber();
		 int intNodeNo = Integer.parseInt(nodeNo);
		 Assert.assertEquals(8, intNodeNo);
					
		 //Click on previous mini carousel list and check for the previous 7 slides display.
		 slideshow.hoverOverslide();
		 slideshow.miniCarouselPreviousClick();
		 try{
			 Thread.sleep(5000);
		 }catch(Exception e){}
		 for (int i=1;i<=7;i++)
		 {
			 slideshow.clickOnSlide(i);
			 try{
				 Thread.sleep(5000);
			 }catch(Exception e){}
			 String nodeNo1 = slideshow.getSlideNo();
			// String nodeNo1 = slideshow.getNodeNumber();
			 int intNodeNo1 = Integer.parseInt(nodeNo1);
			 Assert.assertEquals(i, intNodeNo1);
		 }
	 } // End of MiniCarouselPrevious_click()
	 	/*
		 * Use-case : NEXT LIST >> Button [LOGGED IN USER]
		 * Test case : Go to the last slide of a slideshow as a logged in user.
		 */	
		@Test(priority=18)
		public void NextListButton_click(){
			//
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 18 !!!!!!!!!!!!!!!!!!!!!!!");
			Slideshow slideshow = BaseStateWithLogin("NextListButton_click");
			//Click on last slide and check the behavior of the Next List button.
			slideshow.clickOnLastSlide();
			try{
				Thread.sleep(3000);
			}catch(Exception e){}
			String listHeadingBeforeClick=slideshow.getListHading();
			slideshow.clickOnNextListButton();
			try{
				Thread.sleep(2000);
			}catch(Exception e){}
			String listHeadingAfterClick=slideshow.getListHading();
			Assert.assertEquals(listHeadingBeforeClick, listHeadingAfterClick);
		}// End of NextListButton_click()
		/*
		 * Use-case : Mini Carousel Images - hover
		 * Test case : Hover over the images in the mini image carousel.
		 */	
		@Test(priority=19,dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void MiniCarouselImages_hover(String loginRequired){
			//
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 19 !!!!!!!!!!!!!!!!!!!!!!!");
			 Slideshow slideshow=null;
			 if(loginRequired.equals("YES")){
				 slideshow =BaseStateWithLogin("MiniCarouselImages_hover");
			 }else{
				 slideshow =BaseState("MiniCarouselImages_hover");
			 }
			//selected node is not opaque in the carousel
			
			String slideName = slideshow.getSlideHeading();
			Assert.assertNotNull(slideName);
//			try{
// 				Thread.sleep(5000);
// 			}catch(Exception e){}
			//Image verification.
			//slideshow.clickOnSlide(1);
			//Assert.assertTrue(slideshow.isimagePresent());
			
			//Checking for the 7 nodes presence in the mini carousel.
			for (int i=1;i<=7;i++)
		 		{
		 			slideshow.clickOnSlide(i);
		 			try{
		 				Thread.sleep(5000);
		 			}catch(Exception e){}
		 			 String nodeNo1 = slideshow.getSlideNo();
		 			 System.out.println("nodeNo1"+nodeNo1);
		 			//String nodeNo1 = slideshow.getNodeNumber();
		 			int intNodeNo1 = Integer.parseInt(nodeNo1);
		 			Assert.assertEquals(i, intNodeNo1);
		 		}
			
		}// End of MiniCarouselImages_hover()
		
	 
		/*
		 * Use-case : Carousel - click next slide
		 * Test case : 1) Click on the next slide arrow on any slide except the last.
					   2) Click on the next slide arrow on the last slide.
		 */	
		@Test(priority=20,dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void CarouselClickNextSlide(String loginRequired){
			//
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 20 !!!!!!!!!!!!!!!!!!!!!!!");
			 Slideshow slideshow=null;
			 if(loginRequired.equals("YES")){
				 slideshow =BaseStateWithLogin("CarouselClickNextSlide");
			 }else{
				 slideshow =BaseState("CarouselClickNextSlide");
			 }
			//Check the behavior of the Next Slide button when not on last slide.
			String slideNoBeforeNext = slideshow.getSlideNo();
			int slideIntegerBefore = Integer.parseInt(slideNoBeforeNext);
			slideshow.clickNext();
			try{
				Thread.sleep(4000);
			}catch(Exception e){}
			 String slideNoAfterNext = slideshow.getSlideNo();
			//String slideNoAfterNext = slideshow.getSlideNo();
			int slideIntegerAfter = Integer.parseInt(slideNoAfterNext);
			Assert.assertEquals(slideIntegerBefore, slideIntegerAfter-1);
			
			//Check the behavior of the Next Slide button when on last slide.
			slideshow.clickOnLastSlide();
			try{
				Thread.sleep(4000);
			}catch(Exception e){}
			slideshow.clickNext();
			try{
				Thread.sleep(5000);
			}catch(Exception e){}
			for(int i=1;i<=8;i++){
				Assert.assertTrue(slideshow.isImgNextToLastSlidePresent(i));
			}
			
		}// End of CarouselClickNextSlide()
	 /*
		 * Use-case : Carousel - click previous slide
		 * Test case : 1) Click on the previous slide arrow on any slide except the first.
					   2) Click on the previous slide arrow on the first slide.
		 */	
		@Test(priority=21,dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void Carousel_clickPreviousSlide(String loginRequired){
			//
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 21 !!!!!!!!!!!!!!!!!!!!!!!");
			 Slideshow slideshow=null;
			 if(loginRequired.equals("YES")){
				 slideshow =BaseStateWithLogin("Carousel_clickPreviousSlide");
			 }else{
				 slideshow =BaseState("Carousel_clickPreviousSlide");
			 }
			
			//Check the previous slide functionality when on first slide.
			slideshow.hoverOverslide();
			slideshow.clickOnSlide(1);
			try {
				Thread.sleep(8000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			slideshow.clickPrevious();
			
			browserWait();
			String slideNoAfterPrevious = slideshow.getSlideNo();
			int slideIntegerAfter = Integer.parseInt(slideNoAfterPrevious);
			Assert.assertEquals(1, slideIntegerAfter);
			
			//Check the previous slide functionality when not on first slide.
			slideshow.clickOnSlide(3);
			browserWait();
			String slideNoBeforePrevious = slideshow.getSlideNo();
			int slideIntegerBefore = Integer.parseInt(slideNoBeforePrevious);
			slideshow.clickPrevious();
			browserWait();
			slideNoAfterPrevious = slideshow.getSlideNo();
			slideIntegerAfter = Integer.parseInt(slideNoAfterPrevious);
			Assert.assertEquals(slideIntegerBefore, slideIntegerAfter+1);
		}// End of Carousel_clickPreviousSlide()
	 
		/*
		 * Use-case : Last Page - view again
		 * Test case : Go to the last page of a slideshow (the slide after the last slide) and click on the "view again" link in the top left corner 
		 */	
		@Test(priority=22,dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void lastPageViewAgain(String loginRequired){
			//
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 22 !!!!!!!!!!!!!!!!!!!!!!!");
			 Slideshow slideshow=null;
			 if(loginRequired.equals("YES")){
				 slideshow =BaseStateWithLogin("lastPageViewAgain");
			 }else{
				 slideshow =BaseState("lastPageViewAgain");
			 }
			
			//Go to the next slide after last slide.
			slideshow.clickOnLastSlide();
			browserWait();
			slideshow.clickNext();
			browserWait();
			//Clicking on view again button and verifying it is on first slide.
			slideshow.clickOnViewAgain();
			browserWait();
			String nodeNo = slideshow.getNodeNumber(1);
			int intNodeNo = Integer.parseInt(nodeNo);
			Assert.assertEquals(1, intNodeNo);
			
		}// End of Carousel_clickNextSlide()
		 /*
		   * Use-case : Last Page - Related Lists
		   * Test case : Go to the last page of a slideshow. 
		   */ 
		  @Test(priority=23,dataProviderClass = DataProviders.class, dataProvider = "Login")
		  public void lastPageRelatedLists(String loginRequired){
		   //
		   System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 23 !!!!!!!!!!!!!!!!!!!!!!!");
		    Slideshow slideshow=null;
		    if(loginRequired.equals("YES")){
		     slideshow =BaseStateWithLogin("lastPageRelatedLists");
		    }else{
		     slideshow =BaseState("lastPageRelatedLists");
		    }
		   
		   //Go to the last slide and click on next button.
		   slideshow.clickOnLastSlide();
		   browserWait();
		   slideshow.clickNext();
		   browserWait();
		   slideshow.cancelLoading();
		   //Verifying 8 related links presence.
		   for(int i=1;i<=8;i++){
		    Assert.assertTrue(slideshow.isImgNextToLastSlidePresent(i));
		   }
		   //Clicking on image and verifying correct list opening.
		      for(int i=1;i<=8;i++){
		       if(i!=1){
			        common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?format=SLIDESHOW");
			        slideshow.clickOnLastSlide();
			        browserWait();
			        slideshow.clickNext();
			        browserWait();
			        System.out.println("333333333333333333333333333333 ");
		       }
		       browserWait();
		       String[] titleImage = slideshow.getTextOfImgNextToLastSlide(i).split("\\?");
		       slideshow.clickOnImgNextToLastSlide(i);
		       browserWait();
		       String listHeadingAfterClick=getDriver().getCurrentUrl();
		       if(listHeadingAfterClick.contains(titleImage[0]))
		        Assert.assertEquals(1, 1);
		       else
		        Assert.assertEquals(1, 0);
		       
		       //Assert.assertEquals(titleImage[0], listHeadingAfterClick);
		       //getDriver().navigate().back();
		       //common.getNewURL(config.getProperty("Url")+"list/best-nicolas-cage-freak-out-scenes/derrick-deane?format=SLIDESHOW&page=17&action=lastpage");
		      //getDriver().get("http://www.ranker.com/list/best-nicolas-cage-freak-out-scenes/derrick-deane?format=SLIDESHOW&page=17&action=lastpage");
		      }
		  }// End of lastPageRelatedLists
    /*
	 * Use-case : Upvote
	 * Test case : Upvote multiple nodes in a slideshow.
	 */	
	@Test(priority=24,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void upvote(String loginRequired){
		//
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 24 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("upvote");
		 }else{
			 slideshow =BaseState("upvote");
		 }
        common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
		String upVoteNumber = slideshow.getTextOfUpvote();
		int upVoteNumberBefore =Integer.parseInt(upVoteNumber);
	    String nodeNo = slideshow.getNodeNumber(1);
		int intNodeNoBefore = Integer.parseInt(nodeNo);
		
		slideshow.clickOnUpvote();
		browserWait();
		
		nodeNo = slideshow.getNodeNumber(2);
		int intNodeNoAfter = Integer.parseInt(nodeNo);
		Assert.assertEquals(intNodeNoBefore, intNodeNoAfter-1);
		slideshow.clickOnSlide(intNodeNoBefore);
		upVoteNumber = slideshow.getTextOfUpvote();
		int upVoteNumberAfter = Integer.parseInt(upVoteNumber);
		Assert.assertEquals(upVoteNumberBefore, upVoteNumberAfter-1);
	}// End of upvote
		
	/*
	 * Use-case : Downvote
	 * Test case : Downvote multiple nodes in a slideshow.
	 */	
	@Test(priority=25,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void Downvote(String loginRequired){
		//
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 25 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("Downvote");
		 }else{
			 slideshow =BaseState("Downvote");
		 }
        common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
		String downVoteNumber = slideshow.getTextOfDownvote();
		int downVoteNumberBefore =Integer.parseInt(downVoteNumber);
		System.out.println("---------"+downVoteNumberBefore);
		String nodeNo = slideshow.getNodeNumber(1);
		int intNodeNoBefore = Integer.parseInt(nodeNo);
		slideshow.clickOnDownvote();
		browserWait();
		nodeNo = slideshow.getNodeNumber(2);
		int intNodeNoAfter = Integer.parseInt(nodeNo);
		Assert.assertEquals(intNodeNoBefore, intNodeNoAfter-1);
		
		
		slideshow.clickOnSlide(intNodeNoBefore);
		browserWait();
		downVoteNumber = slideshow.getTextOfDownvote();
		int downVoteNumberAfter = Integer.parseInt(downVoteNumber);
		Assert.assertEquals(downVoteNumberBefore, downVoteNumberAfter-1);
	}// End of Downvote()
	 /*
	 * Use-case : Node Image - click social share buttons
	 * Test case : Click on the social share buttons that appear when you hover over a node image for a couple seconds.
	 */	
	@Test(priority=26,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void SocialShareButtons(String loginRequired){
		//
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 26 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 ListOptionPage listoptionpage =new ListOptionPage(getDriver());
		 ListHeader listHeader=new ListHeader(getDriver());
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("SocialShareButtons");
		 }else{
			 slideshow =BaseState("SocialShareButtons");
		 }
        common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
		slideshow.scroll();
		slideshow.clickOnShareBtnlastslide();
		
		//Click on facebook and check whether right page is opening or not.	
			slideshow.clickOnfacebook();
			browserWait();
		    common.facebookLogin("salmankhantc", "Dehradun1");
		    Assert.assertTrue(slideshow.isFbShareWindowPresent());
			getDriver().close();
			slideshow.switchToParentWindow();
			slideshow.scroll();
		
			//Click on twitter and check whether right page is opening or not.	
			slideshow.clickOnTwitter();
			browserWait();
			common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
			try{
				Thread.sleep(5000);
			}catch(Exception e){}
			if(listoptionpage.isPresenttiwtterlogin()==true){
				Assert.assertEquals(1,1);
			}else if(listHeader.isPresenttwitterwindowpresent()) {
				Assert.assertEquals(1,1);
			}else
			{
				Assert.assertEquals(1,0);	
			}
		    getDriver().close();
		    slideshow.switchToParentWindow();
			slideshow.scroll();
			
			//Click on google plus and check whether right page is opening or not.	
			slideshow.clickOnGooglePlus();
			browserWait();
			common.googleLogin("kallol@ranker.com","9872305929");
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
			}
			SafeActions sf = new SafeActions(getDriver());
			sf.switchToWindow(1);
			Assert.assertTrue(listoptionpage.isPresentpresencegooglelogin());
			getDriver().close();
			slideshow.switchToParentWindow();
			slideshow.scroll();
			
			//Click on Reddit and check whether right page is opening or not.	
			slideshow.clickOnReddit();
			browserWait();
			common.redditLogin("vikasranker", "vikas@123");
			String txt=slideshow.getTextOfRedditUserName();
			Assert.assertEquals(txt, "vikasranker");
			getDriver().close();
			slideshow.switchToParentWindow();
			
			
	}// End of SocialShareButtons()
	
	 /*
	 * Use-case : Last Page - share buttons
	 * Test case : Go to the last page of a slideshow.
	 */	
	@Test(priority=27,dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void SocialShareButtonsOnLastPage(String loginRequired){
		//
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 27 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 ListOptionPage listoptionpage =new ListOptionPage(getDriver());
		 ListHeader listHeader=new ListHeader(getDriver());
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("SocialShareButtonsOnLastPage");
		 }else{
			 slideshow =BaseState("SocialShareButtonsOnLastPage");
		 }
        common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?format=SLIDESHOW&page=28&action=lastpage");
//		slideshow.clickOnLastSlide();
//		slideshow.scroll();
		
		//Click on facebook and check whether right page is opening or not.	
		slideshow.clickOnfacebooklastslide();
		browserWait();
	    common.facebookLogin("salmankhantc", "Dehradun1");
	    Assert.assertTrue(slideshow.isFbShareWindowPresent());
		getDriver().close();
		slideshow.switchToParentWindow();
		//slideshow.scroll();
			
			//Click on twitter and check whether right page is opening or not.	
		slideshow.clickOntwitterlastslide();
		browserWait();
		common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
		try{
			Thread.sleep(5000);
		}catch(Exception e){}
		if(listoptionpage.isPresenttiwtterlogin()==true){
			Assert.assertEquals(1,1);
		}else if(listHeader.isPresenttwitterwindowpresent()) {
			Assert.assertEquals(1,1);
		}else
		{
			Assert.assertEquals(1,0);	
		}
	    getDriver().close();
	    slideshow.switchToParentWindow();
			
//			//Click on google plus and check whether right page is opening or not.	
		slideshow.clickOngooglelastslide();
		browserWait();
		common.googleLogin("kallol@ranker.com","9872305929");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		SafeActions sf = new SafeActions(getDriver());
		sf.switchToWindow(1);
		Assert.assertTrue(listoptionpage.isPresentpresencegooglelogin());
		getDriver().close();
		slideshow.switchToParentWindow();
			
			//Click on Reddit and check whether right page is opening or not.	
		slideshow.clickOnredditlastslide();
		browserWait();
		common.redditLogin("vikasranker", "vikas@123");
		String txt=slideshow.getTextOfRedditUserName();
		Assert.assertEquals(txt, "vikasranker");
		getDriver().close();
		slideshow.switchToParentWindow();

			
	}// End of SocialShareButtonsOnLastPage()

	 ///////////////new TC.//////

	 /* Use-case : >| Button [LOGGED IN USER] for Admin
	  * Test case : Go to any slide in a slideshow except the last as a logged in user.
	  */
	 @Test(priority=28,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void ForwardButtonCarousel(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 28 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("ForwardButtonCorousel");
		 }else{
			 slideshow =BaseState("ForwardButtonCorousel");
		 }
		 common.signin("vijaymohanp","server");
		 int num1=slideshow.lastSlideNoCal();
		 slideshow.clickOnSlide(3);
		 int num2=Integer.parseInt(slideshow.getSlideNo());
		 Assert.assertNotEquals(num1, num2);
		 slideshow.clickOnLastSlideButton();
		 int num3=Integer.parseInt(slideshow.getSlideNo());
		 Assert.assertEquals(num1, num3);
		 
	}// End of ForwardButtonCorousel()

	 /* Use-case : Carousel - hover previous slide
	  * Test case : Hover over the previous slide arrow on multiple slides in a slideshow.
	  */
	 @Test(priority=29,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void CarouselImagesPrev(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 29 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("CarouselImagesPrev");
		 }else{
			 slideshow =BaseState("CarouselImagesPrev");
		 }
		slideshow.hoverOverImagePreviousArrows();
		String col=slideshow.getColorOfImagePreviousArrows();
		if(col.equals("rgba(212, 210, 210, 1)")){
		     Assert.assertEquals("rgba(212, 210, 210, 1)", col);
		}
		else{
		    Assert.assertEquals("rgba(8, 108, 184, 1)", col);
		}
	}// End of CarouselImagesPrev()
	 
	 /* 
	  * Use-case : Slide show/Image pagination
	  * Test case :"1) Open any slide show style list
					2) Click on the left / right arrow navigation on each image"
	  */
	 @Test(priority=30,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void SlideShowImagePagination(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 30 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("SlideShowImagePagination");
		 }else{
			 slideshow =BaseState("SlideShowImagePagination");
		 }
		 browserWait();
		 slideshow.clickNext();
		 browserWait();
		 String classOfNode= slideshow.getClassOfNodeInSlider(2);
		 try{
			 Thread.sleep(4000);
		 }catch(Exception e){}
		 if (classOfNode.contains("active"))
			 Assert.assertEquals(1, 1);
		 else
			 Assert.assertEquals(1, 0);
		 
		 slideshow.clickPrevious();
		 browserWait();
		 classOfNode= slideshow.getClassOfNodeInSlider(1);
		 if (classOfNode.contains("active"))
			 Assert.assertEquals(1, 1);
		 else
			 Assert.assertEquals(1, 0);
	 }
	 
	 /* 
	  * Use-case : Slide show/navigation
	  * Test case :"1) Open any slide show style list
					2) Navigate images with the help of left-right arrows on your keyboard"
	  */
	 @Test(priority=31,dataProviderClass = DataProviders.class, dataProvider = "Login")
	 public void SlideShowNavigation(String loginRequired){
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 31 !!!!!!!!!!!!!!!!!!!!!!!");
		 Slideshow slideshow=null;
		 if(loginRequired.equals("YES")){
			 slideshow =BaseStateWithLogin("SlideShowNavigation");
		 }else{
			 slideshow =BaseState("SlideShowNavigation");
		 }
		 browserWait();
		 slideshow.rightArrowPress();
		 browserWait();
		 String classOfNode= slideshow.getClassOfNodeInSlider(2);
		 browserWait();
		 System.out.println("$$$$$$---------"+classOfNode);
		 if (classOfNode.contains("active"))
			 Assert.assertEquals(1, 1);
		 else
			 Assert.assertEquals(1, 0);
		 
		 slideshow.leftArrowPress();
		 browserWait();
		 classOfNode= slideshow.getClassOfNodeInSlider(1);
		 System.out.println("&&&&&&---------"+classOfNode);
		 if (classOfNode.contains("active"))
			 Assert.assertEquals(1, 1);
		 else
			 Assert.assertEquals(1, 0);
	 }
	 
	 /*
		 * Use-case : Next List page/Slide show: Check the back link to view the same list again
		 * Test case : 1) Open any list in slide show view
					   2) Navigate to the next list page
		 */	
		@Test(priority=32,dataProviderClass = DataProviders.class, dataProvider = "Login")
		public void NextListButtonOnLastSlide(String loginRequired){
			//
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 32 !!!!!!!!!!!!!!!!!!!!!!!");
			 Slideshow slideshow=null;
			 if(loginRequired.equals("YES")){
				 slideshow =BaseStateWithLogin("NextListButtonOnLastSlide");
			 }else{
				 slideshow =BaseState("NextListButtonOnLastSlide");
			 }
			 try{
				Thread.sleep(8000);
				}catch(Exception e){}
			//Click on last slide and check the behavior of the Next button.
			slideshow.clickOnLastSlide();
			browserWait();
			String before = getDriver().getCurrentUrl();
			slideshow.clickOnNextListButton();
			browserWait();
			String after = getDriver().getCurrentUrl();
			Assert.assertNotEquals(before, after);
		}// End of NextListButtonOnLastSlide()
		/* 
		  * Use-case : 		Next list Page/Slide show: Check navigation arrows
		  * Test case :"    1) Open any list in slide show view
							2) Navigate to the next list page
							3) Play with navigation arrows or left right buttons in keyboard
		  */
		 @Test(priority=33,dataProviderClass = DataProviders.class, dataProvider = "Login")
		 public void SlideShowNavigationNextList(String loginRequired){
			 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 33 !!!!!!!!!!!!!!!!!!!!!!!");
			 Slideshow slideshow=null;
			 if(loginRequired.equals("YES")){
				 slideshow =BaseStateWithLogin("SlideShowNavigationNextList");
			 }else{
				 slideshow =BaseState("SlideShowNavigationNextList");
			 }
			// browserWait();
			 slideshow.clickOnSlide(1);
			 try {
				Thread.sleep(4000);
			} catch (Exception e) {
			}
			 slideshow.clickNext();
			// slideshow.rightArrowPress();
			 String classOfNode= slideshow.getClassOfNodeInSlider(2);
			 if (classOfNode.contains("active")){
				 Assert.assertEquals(1, 1);
			 }else{
				 Assert.assertEquals(1, 0);
			 }
			 try{
					Thread.sleep(5000);
					}catch(Exception e){}
				 slideshow.clickPrevious();
			 //slideshow.leftArrowPress();
			 browserWait();
			 classOfNode= slideshow.getClassOfNodeInSlider(1);
			 if (classOfNode.contains("active")){
				 Assert.assertEquals(1, 1);
			 }else{
				 Assert.assertEquals(1, 0);
			 }
			     
			 browserWait();
			     slideshow.clickOnSlide(28);
			     browserWait();
			     slideshow.clickNext();
			     browserWait();
					String before = getDriver().getCurrentUrl();
			        slideshow.clickOnnextlistonheader();
			    	browserWait();
					String after = getDriver().getCurrentUrl();
					Assert.assertNotEquals(before, after);
		 }//end of SlideShowNavigationNextList
		 /*
			 * Use-case : Node Image - click social share buttons
			 * Test case : Click on the social share buttons that appear when you hover over a node image for a couple seconds.
			 */	
			@Test(priority=34,dataProviderClass = DataProviders.class, dataProvider = "Login")
			public void SocialShareButtonsPinterest(String loginRequired){
				//
				 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 34 !!!!!!!!!!!!!!!!!!!!!!!");
				 Slideshow slideshow=null;
				 ListOptionPage listoptionpage =new ListOptionPage(getDriver());
				 ListHeader listHeader=new ListHeader(getDriver());
				 if(loginRequired.equals("YES")){
					 slideshow =BaseStateWithLogin("SocialShareButtonsPinterest");
				 }else{
					 slideshow =BaseState("SocialShareButtonsPinterest");
				 }
		        common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports?format=SLIDESHOW&page=24");
//				slideshow.scroll();
//				slideshow.clickOnShareBtnlastslide();
					//Click on pinterest and check whether right page is opening or not.
		        slideshow.clickOnShareBtnlastslide();
		        try{
					Thread.sleep(2000);
					}catch(Exception e){}
					slideshow.clickOnPinterest();
					browserWait();
					common.clickOnPintLoginFBbutton();
					common.facebookLogin("salmankhantc", "Dehradun1");
					SafeActions sf1 = new SafeActions(getDriver());
					sf1.switchToWindow(1);
					Assert.assertTrue(listoptionpage.istiwtterWindowPresent());
					getDriver().close();
					slideshow.switchToParentWindow();
					
			}// End of SocialShareButtonsPinterest()
			/*
			 * Use-case : Last Page - share buttons
			 * Test case : Go to the last page of a slideshow.
			 */	
			@Test(priority=35,dataProviderClass = DataProviders.class, dataProvider = "Login")
			public void PinterestShareButtonsOnLastPage(String loginRequired){
				//
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 35 !!!!!!!!!!!!!!!!!!!!!!!");
				 Slideshow slideshow=null;
				 ListOptionPage listoptionpage =new ListOptionPage(getDriver());
				 ListHeader listHeader=new ListHeader(getDriver());
				 if(loginRequired.equals("YES")){
					 slideshow =BaseStateWithLogin("PinterestShareButtonsOnLastPage");
				 }else{
					 slideshow =BaseState("PinterestShareButtonsOnLastPage");
				 }
				 common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?format=SLIDESHOW&page=28&action=lastpage");
				 //common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?");
		      //  common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
//				slideshow.clickOnLastSlide();
//				slideshow.scroll();
				
					
//					//Click on pinterest and check whether right page is opening or not.	
				slideshow.clickOnpinterestlastslide();
				browserWait();
				common.clickOnPintLoginFBbutton();
				common.facebookLogin("salmankhantc", "Dehradun1");
				SafeActions sf1 = new SafeActions(getDriver());
				sf1.switchToWindow(1);
				Assert.assertTrue(listoptionpage.istiwtterWindowPresent());
				getDriver().close();
				//slideshow.switchToParentWindow();
					
			}// End of PinterestShareButtonsOnLastPage()
			/*
			 * Use-case : Top 6 right rail RLs 
			 * Test case :Open any slideshow list
			 */
			@Test(priority = 36, dataProviderClass = DataProviders.class, dataProvider = "Login")
			public void Top6Rightrail(String loginRequired) {
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 36 !!!!!!!!!!!!!!!!!!!!!!!");
				// Base state. (Navigate to grid page)
				 Slideshow slideshow=null;
				 Grid grid = new Grid(getDriver());
				if (loginRequired.equals("YES")) {
					slideshow = BaseStateWithLogin("Top6Rightrail");
				} else {
					slideshow = BaseState("Top6Rightrail");
				}
				common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?");
				//common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
				
				for (int i=1; i<= 6;i++) {
					Assert.assertTrue(grid.isPresentListIntoprighttrail(1,i));
				}
				String href[] = grid.gethrefOftoprighttraillist(1, 1).split("\\?");
				System.out.println("href[0]"+href[0]);
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				grid.clickOntoprighttraillist(1, 1);
//				try {
//					Thread.sleep(3000);
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
				String afterurl = getDriver().getCurrentUrl();
				System.out.println("afterurl"+afterurl);
				Assert.assertEquals(href[0], afterurl);

			}// end for Top6Rightrail
			/*
			 * Use-case : Second 6 right rail RLs 
			 * Test case :Open any slideshow list
			 */
			@Test(priority = 37, dataProviderClass = DataProviders.class, dataProvider = "Login")
			public void Second6Rightrail(String loginRequired) {
				System.out
						.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 37 !!!!!!!!!!!!!!!!!!!!!!!");
				// Base state. (Navigate to grid page)
				Slideshow slideshow=null;
				 Grid grid = new Grid(getDriver());
				if (loginRequired.equals("YES")) {
					slideshow = BaseStateWithLogin("Top6Rightrail");
				} else {
					slideshow = BaseState("Top6Rightrail");
				}
				common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?");
			//	common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
				}
				
				String href[] = grid.gethrefOftoprighttraillist(1, 2).split("\\?");
				System.out.println("href[]=="+href[0]);
				grid.clickOntoprighttraillist(1, 2);
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
				}
				String afterurl = getDriver().getCurrentUrl();
				Assert.assertEquals(href[0], afterurl);

			}// end for Second6Rightrail
			/*
			 * Use-case : Second 6 right rail RLs 
			 * Test case :Open any slideshow list
			 */
			@Test(priority = 38, dataProviderClass = DataProviders.class, dataProvider = "Login")
			public void Bottom6MiddleRightrail(String loginRequired) {
				System.out
						.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 38 !!!!!!!!!!!!!!!!!!!!!!!");
				// Base state. (Navigate to grid page)
				Slideshow slideshow=null;
				 Grid grid = new Grid(getDriver());
				if (loginRequired.equals("YES")) {
					slideshow = BaseStateWithLogin("Top6Rightrail");
				} else {
					slideshow = BaseState("Top6Rightrail");
				}
				common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?");
				//common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
				}
				String href[] = grid.gethrefOfbottomrighttraillist(1).split("\\?");
				grid.clickOnbottomrighttraillist(1);
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
				}
				String afterurl[] = getDriver().getCurrentUrl().split("\\?");
				Assert.assertEquals(href[0], afterurl[0]);

			}// end for Bottom6MiddleRightrail

			/*
			 * Use-case : Cascading (pinterest style) RLs 
			 * Test case : Open any slideshow list
			 */
			@Test(priority = 39, dataProviderClass = DataProviders.class, dataProvider = "Login")
			public void CascadingRightrailAutoLoading(String loginRequired) {
				System.out
						.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 39 !!!!!!!!!!!!!!!!!!!!!!!");
				// Base state. (Navigate to grid page)
				Slideshow slideshow=null;
				 Grid grid = new Grid(getDriver());
				if (loginRequired.equals("YES")) {
					slideshow = BaseStateWithLogin("Top6Rightrail");
				} else {
					slideshow = BaseState("Top6Rightrail");
				}
				common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?");
				//common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
				try {
					Thread.sleep(4000);
				} catch (Exception e) {
				}
				Assert.assertTrue(grid.ispopularlistPresent());// 12
				grid.autoloading(6);
				try {
					Thread.sleep(8000);
				} catch (Exception e) {
				}
				Assert.assertTrue(grid.isnodePresent(8));// 12
			}// end for CascadingRightrailAutoLoading
			/*
			 * Use-case : Nodely Related
			 * Test case : Open any slideshow list that has an "also ranks on" block in the right rail: http://www.ranker-stage.com/list/best-taylor-swift-songs-written-about-her-boyfriends/amylindorff%20?format=SLIDESHOW
			 */
			@Test(priority = 40, dataProviderClass = DataProviders.class, dataProvider = "Login")
			public void AlsoRankesOnSlideShowList(String loginRequired) {
				System.out
						.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 40 !!!!!!!!!!!!!!!!!!!!!!!");
				// Base state. (Navigate to grid page)
				Slideshow slideshow=null;
				 Grid grid = new Grid(getDriver());
				if (loginRequired.equals("YES")) {
					slideshow = BaseStateWithLogin("AlsoRankesOnSlideShowList");
				} else {
					slideshow = BaseState("AlsoRankesOnSlideShowList");
				}
				common.getNewURL(config.getProperty("Url")+ "list/best-taylor-swift-songs-written-about-her-boyfriends/amylindorff%20?format=SLIDESHOW");
				
				String txt[] = grid.gethrefOfAlsoRankesOnlists(1).split("\\?");
				grid.clickOnAlsoRankesOnlists(1);
				String CurrUrl[] = getDriver().getCurrentUrl().split("\\?");;
				Assert.assertEquals(txt[0], CurrUrl[0]);
			}//End of AlsoRankesOnSlideShowList
			/*
			 * Use-case : More By User
			 * Test case : Open any slideshow list that has a "more by this user" block in the right rail
							ttp://www.ranker-stage.com/list/adult-jokes-in-kids-shows/jacob-shelton?
			 */
			@Test(priority = 41, dataProviderClass = DataProviders.class, dataProvider = "Login")
			public void MoreByUserSlideShowList(String loginRequired) {
				System.out
						.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 41 !!!!!!!!!!!!!!!!!!!!!!!");
				// Base state. (Navigate to grid page)
				Slideshow slideshow=null;
				 Grid grid = new Grid(getDriver());
				if (loginRequired.equals("YES")) {
					slideshow = BaseStateWithLogin("MoreByUserSlideShowList");
				} else {
					slideshow = BaseState("MoreByUserSlideShowList");
				}
				common.getNewURL(config.getProperty("Url")+"list/adult-jokes-in-kids-shows/jacob-shelton?");
				Assert.assertTrue(grid.isMoreByThisUserPresent());
				String txt[] = grid.gethrefOfMoreByThisUserLists(1).split("\\?");
				System.out.println("txt[0]"+txt[0]);
				grid.clickOnMoreByThisUserLists(1);
				String CurrUrl = getDriver().getCurrentUrl();
				System.out.println("CurrUrl"+CurrUrl);
				Assert.assertEquals(txt[0], CurrUrl);
			}//End of MoreByUserSlideShowList
			/* 
			  * Use-case : Collections
			  * Test case : Open any slideshow list that is in a collection
							http://www.ranker-stage.com/list/american-politicians-in-the-illuminati/mike-rothschild?ref=rltdlsts&pos=1&a=8&ltype=l&l=2068179&g=1
			  */
			 @Test(priority=42,dataProviderClass = DataProviders.class, dataProvider = "Login")
			 public void collectionInSlideShowList(String loginRequired){
				 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 42 !!!!!!!!!!!!!!!!!!!!!!!");
				//Base state. (Navigate to grid page)
				 Slideshow slideshow=null;
				 Grid grid = new Grid(getDriver());
				 if(loginRequired.equals("YES")){
					 slideshow =BaseStateWithLogin("collectionInSlideShowList");
				 }else{
					 slideshow =BaseState("collectionInSlideShowList");
				 }
				 common.getNewURL(config.getProperty("Url")+"list/american-politicians-in-the-illuminati/mike-rothschild?ref=rltdlsts&pos=1&a=8&ltype=l&l=2068179&g=1");
			
				 for(int i=1;i<=5;i++){
					// System.out.println("iiii="+i);
				 String txt[]=grid.gethrefOfFirstListCollection(i).split("\\?");
				 grid.clickOnFirstListCollection(i);
				 try{
					 Thread.sleep(2000);
				 }catch(Exception e){}
				 String CurrUrl[]=getDriver().getCurrentUrl().split("\\?");
				 Assert.assertEquals(txt[0],CurrUrl[0]);
				 }
				 }//end of collectionInSlideShowList
			 /* 
			  * Use-case : Closely Related
			  * Test case : Open any slideshow list that has a "lists like this" block
							http://www.ranker-stage.com/list/the-greatest-mvp-seasons-in-nfl-history/muzziac?format=SLIDESHOW
			  */
			 @Test(priority=43,dataProviderClass = DataProviders.class, dataProvider = "Login")
			 public void ListsLikeThisInSlideShow(String loginRequired){
				 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 43 !!!!!!!!!!!!!!!!!!!!!!!");
				//Base state. (Navigate to grid page)
				 Slideshow slideshow=null;
				 Grid grid = new Grid(getDriver());
				 if(loginRequired.equals("YES")){
					 slideshow =BaseStateWithLogin("ListsLikeThisInSlideShow");
				 }else{
					 slideshow =BaseState("ListsLikeThisInSlideShow");
				 }
				 common.getNewURL(config.getProperty("Url")+"list/the-greatest-mvp-seasons-in-nfl-history/muzziac?format=SLIDESHOW");
				 slideshow.cancelLoading();
				 Assert.assertTrue(grid.isListsLikeThisPresent());
				 try{
					 Thread.sleep(2000);
				 }catch(Exception e){}
				 String txt[]=grid.gethrefOfCloselyRelatedLists(1).split("\\?");
				 try{
					 Thread.sleep(5000);
				 }catch(Exception e){}
				 grid.clickOnCloselyRelatedLists(1);
				 try{
					 Thread.sleep(4000);
				 }catch(Exception e){}
				 String CurrUrl[]=getDriver().getCurrentUrl().split("\\?");
				 Assert.assertEquals(txt[0],CurrUrl[0]);
			 }//End of ListsLikeThisInSlideShow
			 
			 /* 
			  * Use-case : "next list >" in footer
			  * Test case : Open any slideshow list
			  */
			 @Test(priority=44,dataProviderClass = DataProviders.class, dataProvider = "Login")
			 public void NextListFooterInSlideShow(String loginRequired){
				 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 44 !!!!!!!!!!!!!!!!!!!!!!!");
				//Base state. (Navigate to grid page)
				 Slideshow slideshow=null;
				 Grid grid = new Grid(getDriver());
				 if(loginRequired.equals("YES")){
					 slideshow =BaseStateWithLogin("NextListFooterLink");
				 }else{
					 slideshow =BaseState("NextListFooterLink");
				 }
				 ListHeader listHeader=new ListHeader(getDriver());
				// common.getNewURL(config.getProperty("Url")+"list/best-atlanta-hawks-of-all-time/ranker-nba");
//				 slideshow.cancelLoading();
				 String txt[]=listHeader.gethrefOfnextlistfooter().split("\\?");
				 listHeader.clickonnextlistfooter();
				// slideshow.cancelLoading();
//				 try{
//					 Thread.sleep(5000);
//				 }catch(Exception e){}
				 String CurrUrl[]=getDriver().getCurrentUrl().split("\\?");
				 Assert.assertNotEquals(txt[0],CurrUrl[0]);
			 }//End of NextListFooterLink
			 
			 /*
				 * Use-case : "NEXT LIST >>" button on last slide
				 * Test case : Open any slideshow list and scroll to the last slide
				 */	
				@Test(priority=45,dataProviderClass = DataProviders.class, dataProvider = "Login")
				public void NextListArrowOnLastSlide(String loginRequired){
					//
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 45 !!!!!!!!!!!!!!!!!!!!!!!");
					 Slideshow slideshow=null;
					 if(loginRequired.equals("YES")){
						 slideshow =BaseStateWithLogin("NextListArrowOnLastSlide");
					 }else{
						 slideshow =BaseState("NextListArrowOnLastSlide");
					 }
					 slideshow.cancelLoading();
					 try{
						Thread.sleep(5000);
						}catch(Exception e){}
					//Click on last slide and check the behavior of the Next button.
					slideshow.clickOnLastSlide();
					 try{
							Thread.sleep(5000);
							}catch(Exception e){}
//					browserWait();
					String before = getDriver().getCurrentUrl();
					slideshow.clickOnNextListButton();
					String after = getDriver().getCurrentUrl();
					Assert.assertNotEquals(before, after);
				}// End of NextListArrowOnLastSlide()
				/* 
				  * Use-case : 		"next list ->" link on last slide
				  * Test case :"    Open any slideshow list and scroll to the last slide
				  */
				 @Test(priority=46,dataProviderClass = DataProviders.class, dataProvider = "Login")
				 public void NextListLinkOnLastSlide(String loginRequired){
					 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 46 !!!!!!!!!!!!!!!!!!!!!!!");
					 Slideshow slideshow=null;
					 if(loginRequired.equals("YES")){
						 slideshow =BaseStateWithLogin("SlideShowNavigationNextList");
					 }else{
						 slideshow =BaseState("SlideShowNavigationNextList");
					 }
					     browserWait();
					     slideshow.clickOnLastSlide();
					     browserWait();
					     slideshow.clickNext();
					     browserWait();
						 String before = getDriver().getCurrentUrl();
					     slideshow.clickOnnextlistonheader();
					     browserWait();
						 String after = getDriver().getCurrentUrl();
						 Assert.assertNotEquals(before, after);
				 }//end of SlideShowNavigationNextList
				 /*
					 * Use-case : Slideshow last page(RL section):Shared link should redirect to corresponding lists from social sites
					 * Test case : Open list: http://www.ranker-stage.com/list/lessons-from-movies/derrick-deane?format=SLIDESHOW&page=31&action=lastpage
									Share link through share options eg: twitter,Email 
									Go to Social sites and click on shared link

					 */	
					@Test(priority=47,dataProviderClass = DataProviders.class, dataProvider = "Login")
					public void FacebookOnSlideShowLastPage(String loginRequired){
						//
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 47 !!!!!!!!!!!!!!!!!!!!!!!");
						 Slideshow slideshow=null;
						 ListOptionPage listoptionpage =new ListOptionPage(getDriver());
						 ListHeader listHeader=new ListHeader(getDriver());
						 if(loginRequired.equals("YES")){
							 slideshow =BaseStateWithLogin("FacebookOnSlideShowLastPage");
						 }else{
							 slideshow =BaseState("FacebookOnSlideShowLastPage");
						 }
				        common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?format=SLIDESHOW&page=28&action=lastpage");
						
						//Click on facebook and check whether right page is opening or not.	
						slideshow.clickOnfacebooklastslide();
						try {
							Thread.sleep(2000);
						} catch (Exception e) {
							// TODO: handle exception
						}
						//browserWait();
					    common.facebookLogin("salmankhantc", "Dehradun1");
					    Assert.assertTrue(slideshow.isFbShareWindowPresent());
					    getDriver().close();
						slideshow.switchToParentWindow();
					}// End of FacebookOnSlideShowLastPage()
					/*
					 * Use-case : Slideshow last page(RL section):Shared link should redirect to corresponding lists from social sites
					 * Test case : Open list: http://www.ranker-stage.com/list/lessons-from-movies/derrick-deane?format=SLIDESHOW&page=31&action=lastpage
									Share link through share options eg: twitter,Email 
									Go to Social sites and click on shared link

					 */	
					@Test(priority=48,dataProviderClass = DataProviders.class, dataProvider = "Login")
					public void TwitterOnSlideShowLastPage(String loginRequired){
						//
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 48 !!!!!!!!!!!!!!!!!!!!!!!");
						 Slideshow slideshow=null;
						 ListOptionPage listoptionpage =new ListOptionPage(getDriver());
						 ListHeader listHeader=new ListHeader(getDriver());
						 if(loginRequired.equals("YES")){
							 slideshow =BaseStateWithLogin("TwitterOnSlideShowLastPage");
						 }else{
							 slideshow =BaseState("TwitterOnSlideShowLastPage");
						 }
				        common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?format=SLIDESHOW&page=28&action=lastpage");
							//Click on twitter and check whether right page is opening or not.	
						slideshow.clickOntwitterlastslide();
						browserWait();
						common.twitterLogin("vikassolanki1809@gmail.com", "vikas@123");
						try{
							Thread.sleep(5000);
						}catch(Exception e){}
						if(listoptionpage.isPresenttiwtterlogin()==true){
							Assert.assertEquals(1,1);
						}else if(listHeader.isPresenttwitterwindowpresent()) {
							Assert.assertEquals(1,1);
						}else
						{
							Assert.assertEquals(1,0);	
						}
					    getDriver().close();
					    slideshow.switchToParentWindow();
					}// End of TwitterOnSlideShowLastPage()
					/*
					 * Use-case : Slideshow last page(RL section):Shared link should redirect to corresponding lists from social sites
					 * Test case : Open list: http://www.ranker-stage.com/list/lessons-from-movies/derrick-deane?format=SLIDESHOW&page=31&action=lastpage
									Share link through share options eg: twitter,Email 
									Go to Social sites and click on shared link

					 */	
					@Test(priority=49,dataProviderClass = DataProviders.class, dataProvider = "Login")
					public void googleOnSlideShowLastPage(String loginRequired){
						//
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 49 !!!!!!!!!!!!!!!!!!!!!!!");
						 Slideshow slideshow=null;
						 ListOptionPage listoptionpage =new ListOptionPage(getDriver());
						 ListHeader listHeader=new ListHeader(getDriver());
						 if(loginRequired.equals("YES")){
							 slideshow =BaseStateWithLogin("googleOnSlideShowLastPage");
						 }else{
							 slideshow =BaseState("googleOnSlideShowLastPage");
						 }
				        common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?format=SLIDESHOW&page=28&action=lastpage");
							
							
//							//Click on google plus and check whether right page is opening or not.	
						slideshow.clickOngooglelastslide();
						browserWait();
						common.googleLogin("kallol@ranker.com","9872305929");
						try {
							Thread.sleep(3000);
						} catch (Exception e) {
						}
						SafeActions sf = new SafeActions(getDriver());
						sf.switchToWindow(1);
						Assert.assertTrue(listoptionpage.isPresentpresencegooglelogin());
						getDriver().close();
						slideshow.switchToParentWindow();
					}// End of googleOnSlideShowLastPage()
					/*
					 * Use-case : Slideshow last page(RL section):Shared link should redirect to corresponding lists from social sites
					 * Test case : Open list: http://www.ranker-stage.com/list/lessons-from-movies/derrick-deane?format=SLIDESHOW&page=31&action=lastpage
									Share link through share options eg: twitter,Email 
									Go to Social sites and click on shared link

					 */	
					@Test(priority=50,dataProviderClass = DataProviders.class, dataProvider = "Login")
					public void RedditOnSlideShowLastPage(String loginRequired){
						//
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 50 !!!!!!!!!!!!!!!!!!!!!!!");
						 Slideshow slideshow=null;
						 ListOptionPage listoptionpage =new ListOptionPage(getDriver());
						 ListHeader listHeader=new ListHeader(getDriver());
						 if(loginRequired.equals("YES")){
							 slideshow =BaseStateWithLogin("RedditOnSlideShowLastPage");
						 }else{
							 slideshow =BaseState("RedditOnSlideShowLastPage");
						 }
						 
				     common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?format=SLIDESHOW&page=28&action=lastpage");
							
							//Click on Reddit and check whether right page is opening or not.	
						 
						slideshow.clickOnredditlastslide();
						browserWait();
						common.redditLogin("vikasranker", "vikas@123");
						String txt=slideshow.getTextOfRedditUserName();
						Assert.assertEquals(txt, "vikasranker");
						getDriver().close();
						slideshow.switchToParentWindow();

							
					}// End of RedditOnSlideShowLastPage()
					/*
					 * Use-case : Slideshow last page(RL section):Shared link should redirect to corresponding lists from social sites
					 * Test case : Open list: http://www.ranker-stage.com/list/lessons-from-movies/derrick-deane?format=SLIDESHOW&page=31&action=lastpage
									Share link through share options eg: twitter,Email 
									Go to Social sites and click on shared link

					 */	
					@Test(priority=51,dataProviderClass = DataProviders.class, dataProvider = "Login")
					public void PinterestOnSlideShowLastPage(String loginRequired){
						//
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 51 !!!!!!!!!!!!!!!!!!!!!!!");
						 Slideshow slideshow=null;
						 ListOptionPage listoptionpage =new ListOptionPage(getDriver());
						 ListHeader listHeader=new ListHeader(getDriver());
						 if(loginRequired.equals("YES")){
							 slideshow =BaseStateWithLogin("PinterestOnSlideShowLastPage");
						 }else{
							 slideshow =BaseState("PinterestOnSlideShowLastPage");
						 }
				        common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?format=SLIDESHOW&page=28");
				        slideshow.clickOnShareBtnlastslide();
				        try {
							Thread.sleep(5000);
						} catch (Exception e) {
							// TODO: handle exception
						}
				        slideshow.clickOnPinterest();
						browserWait();
						common.clickOnPintLoginFBbutton();
						common.facebookLogin("salmankhantc", "Dehradun1");
						SafeActions sf1 = new SafeActions(getDriver());
						sf1.switchToWindow(1);
						Assert.assertTrue(listoptionpage.istiwtterWindowPresent());
						getDriver().close();
						slideshow.switchToParentWindow();	
					}// End of PinterestOnSlideShowLastPage()
					/* 
					  * Use-case : Verify magnifying glass should not display on image hover
					  * Test case : 1) Go to any slide show list
									 http://www.ranker-stage.com/list/arya-stark-quotes/ranker-of-thrones
									2) Now hover over any of the node images
					  */
					 @Test(priority=52,dataProviderClass = DataProviders.class, dataProvider = "Login")
					 public void VarifymagnifyglassInSlideShow(String loginRequired){
						 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 52 !!!!!!!!!!!!!!!!!!!!!!!");
						 Slideshow slideshow=null;
						 if(loginRequired.equals("YES")){
							 slideshow =BaseStateWithLogin("VarifymagnifyglassInSlideShow");
						 }else{
							 slideshow =BaseState("VarifymagnifyglassInSlideShow");
						 }
						 common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?");
						// common.getNewURL(config.getProperty("Url")+"list/worst-athletes-2014/ranker-sports");
						 slideshow.mousehovernodeimg();
						 try{
							 Thread.sleep(2000);
						 }catch(Exception e){}
						Assert.assertFalse(slideshow.nodeImageAttribute());
					 }//End of VarifymagnifyglassInSlideShow
					 /* 
					  * Use-case :  Italicize words in the blather
					  * Test case : Open list : http://www.ranker-stage.com/list/arya-stark-quotes/ranker-of-thrones
									Edit any node and click 'command+i' to italicize something in the blather
					  */
					 @Test(priority=53,dataProviderClass = DataProviders.class, dataProvider = "Login")
					 public void VarifyBlatherItalics(String loginRequired){
						 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 53 !!!!!!!!!!!!!!!!!!!!!!!");
						 Slideshow slideshow=null;
						 Grid grid = new Grid(getDriver());
						 UeListPage ueList = new UeListPage(getDriver());
						 if(loginRequired.equals("YES")){
							 slideshow =BaseStateWithLogin("VarifyBlatherItalics");
						 }else{
							 slideshow =BaseState("VarifyBlatherItalics");
						 }
						 common.getNewURL(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?");
						 common.signin("vijaymohanp", "server");
						 grid.clickOnadminEditList();
						 grid.clickOnlistsetting();
						 try {
							 Thread.sleep(5000);
						} catch (Exception e) {
							// TODO: handle exception
						}
						 ueList.hoverOnNodeEdit("edit");
						 ueList.clickOnEditIconsOnNode("comment");
						 try{
						 Thread.sleep(5000);
						 }catch(Exception e){}
						 ueList.typeInCommentBoxInEdit("This is Blather Testing");
						 ueList.getfontblatheritalic();
						 try{
							 Thread.sleep(8000);
						 }catch(Exception e){}
						 System.out.println("getfontOfcommentBoxInEdit=="+ueList.getfontOfcommentBoxInEdit());
						 Assert.assertEquals("italic", ueList.getfontOfcommentBoxInEdit()); 
					 }//End of VarifyBlatherItalics
					 /* 
					  * Use-case :  ">>" flipper on last slide
					  * Test case : Open any slideshow list and scroll to the last slide
					  */
					 @Test(priority=54,dataProviderClass = DataProviders.class, dataProvider = "Login")
					 public void FlipperOnLastSlide(String loginRequired){
						 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 54 !!!!!!!!!!!!!!!!!!!!!!!");
						 Slideshow slideshow=null;
						 Grid grid = new Grid(getDriver());
						 UeListPage ueList = new UeListPage(getDriver());
						 if(loginRequired.equals("YES")){
							 slideshow =BaseStateWithLogin("FlipperOnLastSlide");
						 }else{
							 slideshow =BaseState("FlipperOnLastSlide");
						 }					 
						 browserWait();
					     slideshow.clickOnLastSlide();
					     browserWait();
					     slideshow.clickNext();
					     browserWait();
					     String before = getDriver().getCurrentUrl();
					        slideshow.clickOnnextlistonheader();
					    	browserWait();
							String after = getDriver().getCurrentUrl();
							Assert.assertNotEquals(before, after);
					 }
				
					 /* 
					  * Use-case :  Verify crousal
					  * Test case : 1. Go to any slideshow list
									Eg:http://www.ranker-stage.com/list/catcon-los-angeles-2015-products/ashley-reign?
									2. Now selected image on carousal of slideshow
					  */
					 @Test(priority=55,dataProviderClass = DataProviders.class, dataProvider = "Login")
					 public void VerifyCrousal(String loginRequired){
						 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 55 !!!!!!!!!!!!!!!!!!!!!!!");
						 Slideshow slideshow=null;
						 Grid grid = new Grid(getDriver());
						 UeListPage ueList = new UeListPage(getDriver());
						 if(loginRequired.equals("YES")){
							 slideshow =BaseStateWithLogin("VerifyCrousal");
						 }else{
							 slideshow =BaseState("VerifyCrousal");
						 }	
						 slideshow.clickOnSlideMiniCarousel(3);
						 Assert.assertEquals("rgba(8, 108, 184, 1)", slideshow.getColorOfSlideMiniCarousel(3));	
						 Assert.assertEquals("rgba(255, 255, 255, 1)", slideshow.getColorOfpreviousSlideButton("background-color"));
						 try{
							 Thread.sleep(2000);
						 }catch(Exception e){}
						Assert.assertEquals("rgba(255, 255, 255, 1)", slideshow.getColorOfnextButton("background-color"));
					 }//End of verifycrousel
		/*
	 	 * This is base state of the slide show test-cases.
	 	 */
	 	public Slideshow BaseState(String testName){
			 try{
				 startRecording(testName);
				}catch(Exception e){}
	 		common=new Commonpage(getDriver());
	 		Slideshow slideshow=common.getSlideshow(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?");
	 		common.votableLinkPresenceAndAccept();
			return slideshow;
	 	} //End of BaseState()
	 	/*
	 	 * This is base state with log in of the slide show test-cases.
	 	 */
	 	public Slideshow BaseStateWithLogin(String testName){
			 try{
				 startRecording(testName);
				}catch(Exception e){}
	 		 common=new Commonpage(getDriver());
	 		 
	 		Slideshow slideshow=common.getSlideshow(config.getProperty("Url")+"list/catcon-los-angeles-2015-products/ashley-reign?");
	 		common.signin("testuserkallol1@mailinator.com", "testing");
	 		common.votableLinkPresenceAndAccept();
	 		return slideshow;
	 	} //End of BaseStateWithLogin()
		
}
