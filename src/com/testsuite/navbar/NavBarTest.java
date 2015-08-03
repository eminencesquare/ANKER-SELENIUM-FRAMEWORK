package com.testsuite.navbar;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.DataProviders;
import com.paeobjects.home.Commonpage;
import com.paeobjects.home.Home;
import com.paeobjects.navbar.Film;
import com.paeobjects.navbar.Music;
import com.paeobjects.navbar.NavBar;
import com.paeobjects.navbar.New;
import com.paeobjects.navbar.People;
import com.paeobjects.navbar.Sports;
import com.paeobjects.navbar.TV;
import com.paeobjects.navbar.Videos;
import com.pageobject.search.SearchRanker;
import com.pageobjects.userProfilePage.UserProfilePage;
import com.pageobjects.widgetPage.WidgetPage;
import com.utilities.UtilityMethods;
import com.utilities.UtilityMethods.Mode;

public class NavBarTest extends BaseSetup{

	ConfigManager config=new ConfigManager();
	ConfigManager sysProp=new ConfigManager("Sys");
	String url=config.getProperty("Url");
	
	Commonpage common;
	@BeforeMethod
	public void beforeMethod(){
		if(!getDriver().getCurrentUrl().equals(new ConfigManager().getProperty("Url")))
		getDriver().get(new ConfigManager().getProperty("Url"));
	}
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
	  * Use-case : Ranker logo
	  * Test case : Go to any multiple pages (home, catagery, class, tag, list) on Ranker.
	 */
	@Test(priority=1)
	public void Ranker_logo(){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 1 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("Ranker_logo");
		navbar.clickPeople();
		//verify logo
		Assert.assertTrue(navbar.verifyRankerLogo(),"Ranker logo");
		navbar.clickNew();
		//verifylogo
		Assert.assertTrue(navbar.verifyRankerLogo(),"Ranker logo");
	}//End of Ranker logo
	/* 
	  * Use-case : New - hover and click
	  * Test case :"1) Hover over ""new"" in nav bar.
					2) Click on ""new""."
	 */
	@Test(priority=2)
	public void New_hoverandclick(){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 2!!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("New_hoverandclick");
		navbar.hoverNew();
		Assert.assertFalse(navbar.verifyOverlay());
		New nw=navbar.clickNew();
		Assert.assertTrue(nw.verifyRecentListHeader());
	}//End of New - hover and click
	/* 
	  * Use-case :  People - hover
	  * Test case :Hover over "people" in nav bar.
	 */
	@Test(priority=3)
	public void People_hover() throws Exception{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 3 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("People_hover");
		navbar.hoverPeople();
		//verify people
		browserWait();
		Assert.assertTrue(navbar.verifyoverlayblockActive(1),"people");
		//verify images
		for(int i=1;i<=8;i++){
			Assert.assertTrue(navbar.verifyoverlayImages(i),"OverlayImage : "+i);
		}
		//verify see all topics link
		Assert.assertTrue(navbar.verifySeeAlltopics(),"See all topics");
	}//End of New - hover and click
	/* 
	  * Use-case  : People - links
	  * Test case :"1) Click on "people" in the nav bar.
                    2) Click on "people" in the left of the overlay.
					3) Click on multiple tags/classes
					4) Click on multiple featured list images and links.
					5) Click on "see all people".
					6) Click on "all ranker topics".
	 */
	@Test(priority=4)
	public void People_links() throws Exception{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 4 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("People_links");
		browserWait();
		People people=navbar.clickPeople();
//		verify people
		browserWait();
		Assert.assertTrue(people.verifyPeopleHeader(),"people link");
		//verify people URLs
		navbar.hoverFilm();
		navbar.hoverPeople();
		navbar.clickOnOverlayPeople();
		String url=config.getProperty("Url")+"list-of/people";
		browserWait();
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"people URL");
		
		//verify Tags
		navbar.hoverFilm();
		navbar.hoverPeople();
		browserWait();
		if(navbar.clickonTag()){
			browserWait();
			Assert.assertTrue(navbar.verifyURL("tags"),"Veify tags");
		}
		
		//verify Class
		navbar.hoverFilm();
		navbar.hoverPeople();
		browserWait();
		if(navbar.clickonClass()){
			browserWait();
			Assert.assertTrue(navbar.verifyURL("list"),"Veify classes");
		}
		
		//verify Category
		navbar.hoverPeople();
		browserWait();
		if(navbar.clickonCateory()){
			browserWait();
			Assert.assertTrue(navbar.verifyURL("list-of"),"Veify categories"); 
		}
		
		// verify see all people			
		navbar.hoverPeople();
		browserWait();
		people.clickOnSeeAllPeople();
		browserWait();
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"See all people URL");
		
		// verify all Ranker topics
		navbar.hoverPeople();
		navbar.clickOnAllRankerToics();
		browserWait();
		url=config.getProperty("Url")+"all-categories";
		browserWait();
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"All ranker topics");
	}//End of People - links
	/* 
	  * Use-case  : Film - hover
	  * Test case : Hover over "film" in nav bar.
	 */
	@Test(priority=5)
	public void Film_hover() throws Exception{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 5 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("Film_hover");
		browserWait();
		navbar.hoverFilm();
		//verify Film
		browserWait();
		Assert.assertTrue(navbar.verifyoverlayblockActive(2),"film");
		//verify Film images
		for(int i=1;i<=8;i++){
			//browserWait();
			Assert.assertTrue(navbar.verifyoverlayImages(i),"OverlayImage : "+i);
			System.out.println("#### "+i);
		}
		//verify see all topics link
		Assert.assertTrue(navbar.verifySeeAlltopics(), "See all topics");
	}// End of Film - hover

		/* 
	  * Use-case  : TV - hover
	  * Test case :"Hover over "tv" in nav bar.".
   */
	@Test(priority=6)
	public void TV_hover() throws Exception{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 6 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("TV_hover");
	browserWait();
		navbar.hoverTV();
		//verify TV
		Assert.assertTrue(navbar.verifyoverlayblockActive(3),"TV");
		//verify TV images
		for(int i=1;i<=8;i++){
			Assert.assertTrue(navbar.verifyoverlayImages(i),"OverlayImage : "+i);
		}
		//verify see all topics link
		Assert.assertTrue(navbar.verifySeeAlltopics(), "See all topics");
	}// End of TV - hover
	/* 
	  * Use-case  : Music - hover
	  * Test case :"Hover over "music" in nav bar.
	 */
	@Test(priority=7)
	public void Music_hover() throws Exception{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 7 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("Music_hover");
		navbar.hoverMusic();
		//verify Music
		Assert.assertTrue(navbar.verifyoverlayblockActive(4),"Music");
		//verify Music images
		for(int i=1;i<=8;i++){
			Assert.assertTrue(navbar.verifyoverlayImages(i),"OverlayImage : "+i);
		}
		//verify see all topics link
		Assert.assertTrue(navbar.verifySeeAlltopics(), "See all topics");
	} //End of  Music - hover
	/* 
	  * Use-case  : Sports - hover
	  * Test case :Hover over "sports" in nav bar.
	 */
	@Test(priority=8)
	public void Sports_hover() throws Exception{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 8 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("Sports_hover");
		navbar.hoverSports();
		//verify Sports
		browserWait();
		Assert.assertTrue(navbar.verifyoverlayblockActive(5),"Sports");
		//verify Sports images
		for(int i=1;i<=8;i++){
			Assert.assertTrue(navbar.verifyoverlayImages(i),"OverlayImage : "+i);
		}
		try{
			Thread.sleep(3000);
		}catch(Exception e){}
		//verify see all topics link
		Assert.assertTrue(navbar.verifySeeAlltopics(), "See all topics");
	}//End of Sports - hover
    /* 
	  * Use-case  : Film - links
	  * Test case :"1) Click on "film" in the nav bar.
					2) Click on "film" in the left of the overlay.
					3) Click on multiple tags/classes
					4) Click on multiple featured list images and links.
					5) Click on "see all film".
					6) Click on "all ranker topics".
	 */	
	@Test(priority=9)
	public void Film_links() throws Exception{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 9 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("Film_links");
		//NavBar navbar=new NavBar(getDriver());
		Film film=navbar.clickOnFilim();
		//verify film
		
		if(sysProp.getProperty("Browser.Name").equals("chrome")){
		    try{
		     Thread.sleep(2000); 
		    }catch(Exception e){}
		   
		   }
		Assert.assertTrue(film.verifyFilmHeader(),"film link");
		//verify film URL
		navbar.hoverPeople();
		navbar.hoverFilm();
		navbar.clickOnOverlayFilm();
		//System.out.println("33333");
		String url=config.getProperty("Url")+"list-of/film";
		if(sysProp.getProperty("Browser.Name").equals("chrome")){
		    try{
		     Thread.sleep(2000); 
		    }catch(Exception e){}
		   
		   }
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"film URL");
		//verify Tags
		navbar.hoverFilm();
		if(navbar.clickonTag()){
			if(sysProp.getProperty("Browser.Name").equals("chrome")){
			    try{
			     Thread.sleep(2000); 
			    }catch(Exception e){}
			   
			   }
			Assert.assertTrue(navbar.verifyURL("tags"),"Verify tags");
		}
		
		//verify Class
		navbar.hoverFilm();
		if(navbar.clickonClass()){
			if(sysProp.getProperty("Browser.Name").equals("chrome")){
			    try{
			     Thread.sleep(2000); 
			    }catch(Exception e){}
			   
			   }
			Assert.assertTrue(navbar.verifyURL("list"),"Verify classes");
		}
		
		//verify Category
		navbar.hoverFilm();
		if(navbar.clickonCateory()){
			if(sysProp.getProperty("Browser.Name").equals("chrome")){
			    try{
			     Thread.sleep(2000); 
			    }catch(Exception e){}
			   
			   }
			Assert.assertTrue(navbar.verifyURL("list-of"),"Verify categories");
		}
		
		// verify see all film
		navbar.hoverFilm();
		film.clickOnSeeAllFilms();
		if(sysProp.getProperty("Browser.Name").equals("chrome")){
		    try{
		     Thread.sleep(2000); 
		    }catch(Exception e){}
		   }
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"See all films URL");
		
		// verify all Ranker topics
		navbar.hoverFilm();
		navbar.clickOnAllRankerToics();
		url=config.getProperty("Url")+"all-categories";
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"All ranker topics");
	}//End of Film - links
	/* 
	  * Use-case  : TV - links
	  * Test case :"1) Click on "tv" in the nav bar.
					2) Click on "tv" in the left of the overlay.
					3) Click on multiple tags/classes
					4) Click on multiple featured list images and links.
					5) Click on "see all tv".
					6) Click on "all ranker topics"."
	 */
	@Test(priority=10)
	public void TV_links() throws Exception{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 10 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("TV_links");
		//NavBar navbar=new NavBar(getDriver());
		TV tv=navbar.clickOnTV();
//		verify Tv
		Assert.assertTrue(tv.verifyTvHeader(),"tv link");
		//verify Tv URL
		navbar.hoverFilm();
		navbar.hoverTV();
		navbar.clickOnOverlayTv();
		String url=config.getProperty("Url")+"list-of/tv";
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"Tv URL");
		
		//verify Tags
		navbar.hoverFilm();
		navbar.hoverTV();
		if(navbar.clickonTag()){
			Assert.assertTrue(navbar.verifyURL("tags"),"Verify tags");
		}
		//verify Class
		navbar.hoverTV();
		if(navbar.clickonClass()){
			Assert.assertTrue(navbar.verifyURL("list"),"Verify classes");
		}
		//verify Category
		navbar.hoverFilm();
		navbar.hoverTV();
		if(navbar.clickonCateory()){
			Assert.assertTrue(navbar.verifyURL("list-of"),"Verify categories");
		}
		// verify see all tv
		navbar.hoverTV();
		tv.clickOnSeeAllTv();
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"See all tv URL");
		// verify all Ranker topics
		navbar.hoverFilm();
		navbar.hoverTV();
		navbar.clickOnAllRankerToics();
		url=config.getProperty("Url")+"all-categories";
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"All ranker topics");
	}
	/* 
	  * Use-case  : Music - links
	  * Test case :"1) Click on "music" in the nav bar.
					2) Click on "music" in the left of the overlay.
					3) Click on multiple tags/classes
					4) Click on multiple featured list images and links.
					5) Click on "see all music".
					6) Click on "all ranker topics"..
	 */	
	@Test(priority=11)
	public void Music_links() throws Exception{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 11 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("Music_links");
		//NavBar navbar=new NavBar(getDriver());
		Music music=navbar.clickOnMusic();
//		verify Music
		Assert.assertTrue(music.verifyMusicHeader(),"Music link");
		//verify Music URL
		navbar.hoverFilm();
		navbar.hoverMusic();
		navbar.clickOnOverlayMusic();
		String url=config.getProperty("Url")+"list-of/music";
		if(sysProp.getProperty("Browser.Name").equals("chrome")){
		    try{
		     Thread.sleep(2000); 
		    }catch(Exception e){}
		   
		   }
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"Music URL");
		
		//verify Tags
		navbar.hoverMusic();
		if(navbar.clickonTag()){
			if(sysProp.getProperty("Browser.Name").equals("chrome")){
			    try{
			     Thread.sleep(2000); 
			    }catch(Exception e){}
			   }
			Assert.assertTrue(navbar.verifyURL("tags"),"Verify tags");
		}
		//verify Class
		navbar.hoverMusic();
		if(navbar.clickonClass()){
			if(sysProp.getProperty("Browser.Name").equals("chrome")){
			    try{
			     Thread.sleep(2000); 
			    }catch(Exception e){}
			   
			   }
			Assert.assertTrue(navbar.verifyURL("list"),"Verify classes");
		}
		//verify Category
		navbar.hoverMusic();
		if(navbar.clickonCateory()){
			if(sysProp.getProperty("Browser.Name").equals("chrome")){
			    try{
			     Thread.sleep(2000); 
			    }catch(Exception e){}
			   }
			Assert.assertTrue(navbar.verifyURL("list-of"),"Verify categories");
		}
		
		// verify see all music
		navbar.hoverMusic();
		music.clickOnSeeAllMusic();
		if(sysProp.getProperty("Browser.Name").equals("chrome")){
		    try{
		     Thread.sleep(2000); 
		    }catch(Exception e){}
		   
		   }
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"See all Music URL");
		
		// verify all Ranker topics
		navbar.hoverMusic();
		navbar.clickOnAllRankerToics();
		url=config.getProperty("Url")+"all-categories";
		if(sysProp.getProperty("Browser.Name").equals("chrome")){
		    try{
		     Thread.sleep(2000); 
		    }catch(Exception e){}
		   }
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"All ranker topics");
	}//End of Music - links
//	
	/* 
	  * Use-case  : Sports - links
	  * Test case :"1) Click on "sports" in the nav bar.
					2) Click on "sports" in the left of the overlay.
					3) Click on multiple tags/classes
					4) Click on multiple featured list images and links.
					5) Click on "see all sports".
					6) Click on "all ranker topics"..
	 */	
	@Test(priority=12)
	public void Sports_links() throws Exception{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 12!!!!!!!!!!!!!!!!!!!!!!!");
		//NavBar navbar=new NavBar(getDriver());
		NavBar navbar=BaseState("Sports_links");
		Sports sports=navbar.clickOnSports();
		if(sysProp.getProperty("Browser.Name").equals("chrome")){
		    try{
		     Thread.sleep(2000); 
		    }catch(Exception e){}
		   
		   }
		Assert.assertTrue(sports.verifySportsHeader(),"Sports link");
		//verify Sorts URL
		navbar.hoverFilm();
		navbar.hoverSports();
		navbar.clickOnOverlaySports();
		String url=config.getProperty("Url")+"list-of/sports";
		if(sysProp.getProperty("Browser.Name").equals("chrome")){
		    try{
		     Thread.sleep(2000); 
		    }catch(Exception e){}
		   
		   }
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"Sports URL");
		
		//verify Tags
		navbar.hoverSports();
		if(navbar.clickonTag()){
			if(sysProp.getProperty("Browser.Name").equals("chrome")){
			    try{
			     Thread.sleep(2000); 
			    }catch(Exception e){}
			   
			   }
			Assert.assertTrue(navbar.verifyURL("tags"),"Verify tags");
		}
		
		//verify Class
		navbar.hoverSports();
		if(navbar.clickonClass()){
			if(sysProp.getProperty("Browser.Name").equals("chrome")){
			    try{
			     Thread.sleep(2000); 
			    }catch(Exception e){}
			   
			   }
			Assert.assertTrue(navbar.verifyURL("list"),"Verify classes");
		}
		
		//verify Category
		navbar.hoverSports();
		if(navbar.clickonCateory()){
			if(sysProp.getProperty("Browser.Name").equals("chrome")){
			    try{
			     Thread.sleep(2000); 
			    }catch(Exception e){}
			   
			   }
			Assert.assertTrue(navbar.verifyURL("list-of"),"Verify categories");
		}
		
		// verify see all sports
		navbar.hoverSports();
		sports.clickOnSeeAllSports();
		if(sysProp.getProperty("Browser.Name").equals("chrome")){
		    try{
		     Thread.sleep(2000); 
		    }catch(Exception e){}
		   
		   }
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"See all Music URL");
		
		// verify all Ranker topics
		navbar.hoverSports();
		navbar.clickOnAllRankerToics();
		url=config.getProperty("Url")+"all-categories";
		if(sysProp.getProperty("Browser.Name").equals("chrome")){
		    try{
		     Thread.sleep(2000); 
		    }catch(Exception e){}
		   
		   }
		Assert.assertEquals(getDriver().getCurrentUrl(),url,"All ranker topics");
	}//End of Sports - links
	/* 
	  * Use-case  : Videos - hover and click
	  * Test case :"1) Hover over "videos" in nav bar.
                    2) Click on "videos".
	 */	
	@Test(priority=13)
	public void Video_hover() throws Exception{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 13 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("Video_hover");
		//NavBar navbar=new NavBar(getDriver());
		navbar.hoverVideos();
		
		Assert.assertFalse(navbar.verifyoverlayblockActive(4),"Video");
		//verify Video
		Videos videos=navbar.clickOnVideos();
		Assert.assertEquals(videos.getCurrentURL(),config.getProperty("Url")+"videos");
	}//End of Videos - hover and click
	/* 
	  * Use-case  : More - hover
	  * Test case :"Hover over "more" in nav bar.
	 */	
	@Test(priority=14)
	public void More_hover() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 14 !!!!!!!!!!!!!!!!!!!!!!!");
		//NavBar navbar=new NavBar(getDriver());
		NavBar navbar=BaseState("More_hover");
		navbar.hoverMore();
		Assert.assertEquals(navbar.cctlinksCount(), 28, "category/class/tag links");
		Assert.assertTrue(navbar.verifySeeAlltopics(),"see all topics");
		Assert.assertTrue(navbar.verifyFAQPresent(),"Frequently asked questions");
		Assert.assertTrue(navbar.verifyContactus(),"Contact us");
//		Assert.assertTrue(navbar.verifyForms(),"Forms");
//		System.out.println("66666666666666");
		Assert.assertTrue(navbar.verifyTopRankers(),"Top Rankers");
		Assert.assertTrue(navbar.verifylistopedia(), "listopedia");
		Assert.assertTrue(navbar.verifyembedList(), "Embed List");
		Assert.assertTrue(navbar.verifyMoreOverlay(), "more");
	} //End of More - hover
	/* 
	  * Use-case  :More - links
	  * Test case :"1) Click on multiple category/class/tag links.
					2) Click on "see all topics".
					3) Click on all the links on the right part of the overlay....
	 */	
	@Test(priority=15)
	public void More_link() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 15 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("More_link");
		//NavBar navbar=new NavBar(getDriver());
		navbar.hoverMore();
		browserWait();
		Assert.assertTrue(navbar.verifyMoreblockActive());
		Assert.assertEquals(navbar.cctlinksCount(), 28);
		
		//navbar.clickOnMoreRightOverlay(1);
		
		navbar.clickOnSeeAllTopicLink();
		String url=getDriver().getCurrentUrl();
		if(url.contains("/all-categories")){
			Assert.assertEquals(1, 1);
		}
		else
			Assert.assertEquals(1, 0);
		
	}//End of More - links
	 /*
	  * Use-case  :Search Bar - empty search
	  * Test case :"1) Click on multiple category/class/tag links.
					2) Click on "see all topics".
					3) Click on all the links on the right part of the overlay....
	 */		
	@Test(priority=16)
	public void SearchBar_emptysearch(){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 16 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("SearchBar_emptysearch");
		//NavBar navbar=new NavBar(getDriver());
		SearchRanker search=navbar.clickOnsearch();
		Assert.assertTrue(search.verifySearchbox(), "Big seacrch bar");
		Assert.assertEquals(search.getCurrentURL(), config.getProperty("Url")+"app/search.htm?q=", "Search url");
	}
	/* 
	  * Use-case  : Search Bar - non-empty search
	  * Test case :"1) Click in the search bar.
				    2) Entery a search query.
				    3) Hit the "Enter" key or click on the magnifying glass."..
	 */		
	@Test(priority=17)
	    public void SearchBar_nonemptysearch() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 17 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("SearchBar_nonemptysearch");
		//NavBar navbar=new NavBar(getDriver());
		String txt=UtilityMethods.generateRandomString(10, Mode.ALPHANUMERIC);
		navbar.enterSearchText(txt);
		SearchRanker search=navbar.clickOnsearch();
		Assert.assertEquals(search.getCurrentURL(), config.getProperty("Url")+"app/search.htm?q="+txt, "Search url");
	}
	 /* 
	  * Use-case  : Test "need ideas?" in "create a list"
	  * Test case :"1) Click on "create a list" on the top of the page
                    2) Click on "+" link in the bottom right.
					3) Click on different category names and make sure 4 lists load for each.
					4) Click on list title links from each category."..
	 */		
	@Test(priority=18)
	    public void CreateListNeedIdeas() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 18 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseStateWithLogin("CreateList");
		System.out.println("comin this");
		try{
			Thread.sleep(2000);
		}catch(Exception e){}
		
		for(int i=1;i<=7;i++)
		{
		  navbar.hoverMore();	
		 navbar.clickOnCreatelist();
		 navbar.clickonaddbutton();
		 navbar.clickonaddoption(i);
		 Assert.assertEquals("rgba(0, 0, 0, 1)",navbar.getoptionColorList(i));
		 navbar.clickcreateListcategoryoption(1);
		 try{
			 Thread.sleep(2000);
		 }catch(Exception e){}
		 navbar.clickcreateListcategoryclosebtn();
		}
	}
	/* 
	  * Use-case  : Create a List - no list title
	  * Test case :"1) Click on "create a list" on the top of the page
					2) Leave the "Name your list" box blank and click on "skip this step".
					3) Leave the "Name your list" box blank and click on "start ranking!"
	 */		
	@Test(priority=19)
	    public void CreateListNOTitle() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 19 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseStateWithLogin("CreateListNOTitle");
		common = new Commonpage(getDriver());
		UserProfilePage profile = new UserProfilePage(getDriver());
		System.out.println("comin this");
		navbar.hoverMore();
		navbar.clickOnCreatelist();
		navbar.clickOnreranking();
		navbar.clickOnSearch();
		navbar.typesearchbtn("Batman");
 		for(int i=1;i<=3;i++){
 			navbar.clickOnPlusIcon(i);
 		 }	
 		navbar.clickOncancel();
 		try{
 			Thread.sleep(2000);
 		}catch(Exception e){}
 		profile.clickOnProfile();
 	//	navbar.hoverOnprofile();
 		try{
 			Thread.sleep(2000);
 		}catch(Exception e){}
 		navbar.clickOnmanagelistbtn();
 		navbar.clickondraftbtn();
        String txt=navbar.getTextOflistunnamedcheck();
        Assert.assertEquals(txt, "Unnamed List");
        navbar.clickonlistunnamedcheck();
        navbar.clickOnoptionbtn();
        navbar.clickOndeletelist();
		navbar.AlertExistsAndAccepted(1000);
	}//End for CreateListNOTitle
	 /* 
	  * Use-case  : Create a List
	  * Test case :"1) Click on "create a list" on the top of the page
                    2) Enter name of list and "start ranking!" button.
	 */		
	@Test(priority=20)
	    public void CreateList() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 20 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseStateWithLogin("CreateList");
		System.out.println("comin this");
		navbar.hoverMore();
		navbar.clickOnCreatelist();
		navbar.clickOncrateliststart();
		navbar.typcreatelist("testing123");
		navbar.clickOnreranking();
		Assert.assertTrue(navbar.isPresenceUeopen());
		navbar.clickOnoptionbtn();
        navbar.clickOndeletelist();
		navbar.AlertExistsAndAccepted(1000);

	}//End for CreateList
	
	/* 
	  * Use-case  : Comics - hover and click
	  * Test case :"1) Hover over ""comics"" in nav bar.
					2) Click on ""comics""."
	 */	
	@Test(priority=21)
	public void Comics_hover() throws Exception{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 21 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("Video_hover");
		//NavBar navbar=new NavBar(getDriver());
		navbar.hoverComics();
		
		Assert.assertFalse(navbar.verifyoverlayblockActive(4),"Comics");
		//verify Video
		navbar.clickOnComics();
		Assert.assertEquals(getDriver().getCurrentUrl(),config.getProperty("Url")+"list-of/comics");
	}//End of Videos - hover and click
	/*
	 * Use-case :Adding "Video Games" category to drop down Nav
	 * Test case :"Below is the following tags and lists to add to the call out.
				   Tags to add to Video Game Link:
					video game genres - http://www.ranker.com/tags/video-game-genres
					video game characters - http://www.ranker.com/tags/video-game-characters
					best video games - http://www.ranker.com/tags/best-video-games
					casual games - http://www.ranker.com/tags/casual-games
					retro - http://www.ranker.com/tags/Retro
					game consoles - http://www.ranker.com/tags/game-consoles
					Playstation - http://www.ranker.com/tags/playstation
					Xbox - http://www.ranker.com/tags/xbox
					Nintendo - http://www.ranker.com/tags/nintendo
					RPGs - http://www.ranker.com/tags/rpgs
					FPS - http://www.ranker.com/tags/fps
					simulation - http://www.ranker.com/tags/simulation"
	 */
	@Test(priority = 22, dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void VideoGame(String loginRequired) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 22 !!!!!!!!!!!!!!!!!!!!!!!");
		// Base state. (Navigate to node page)
		NavBar navbar=BaseState("VideoGame");
		navbar.hoverSports();
		navbar.hoverOnVideoGames();
		navbar.clickOnVideoGameOption("video game genres");
		if (getDriver().getCurrentUrl().contains("tags/video-game-genres")){
			Assert.assertEquals(1, 1);
		}else{
			Assert.assertEquals(1, 0);
		}
		navbar.hoverFilm();
		navbar.hoverSports();
		navbar.hoverOnVideoGames();
		navbar.clickOnVideoGameOption("video game characters");
		if (getDriver().getCurrentUrl().contains("tags/video-game-characters")){
			Assert.assertEquals(1, 1);
		}else{
			Assert.assertEquals(1, 0);
		}
		navbar.hoverFilm();
		navbar.hoverSports();
		navbar.hoverOnVideoGames();
		navbar.clickOnVideoGameOption("best video games");
		if (getDriver().getCurrentUrl().contains("tags/best-video-games")){
			Assert.assertEquals(1, 1);
		}else{
			Assert.assertEquals(1, 0);
		}
		navbar.hoverFilm();
		navbar.hoverSports();
		navbar.hoverOnVideoGames();
		navbar.clickOnVideoGameOption("casual games");
		if (getDriver().getCurrentUrl().contains("tags/casual-games")){
			Assert.assertEquals(1, 1);
		}else{
			Assert.assertEquals(1, 0);
		}
		navbar.hoverFilm();
		navbar.hoverSports();
		navbar.hoverOnVideoGames();
		navbar.clickOnVideoGameOption("retro");
		if (getDriver().getCurrentUrl().contains("tags/Retro")){
			Assert.assertEquals(1, 1);
		}else{
			Assert.assertEquals(1, 0);
		}
		navbar.hoverFilm();
		navbar.hoverSports();
		navbar.hoverOnVideoGames();
		navbar.clickOnVideoGameOption("game consoles");
		if (getDriver().getCurrentUrl().contains("tags/game-consoles")){
			Assert.assertEquals(1, 1);
		}else{
			Assert.assertEquals(1, 0);
		}
		navbar.hoverSports();
		navbar.hoverOnVideoGames();
		navbar.clickOnVideoGameOption("Playstation");
		if (getDriver().getCurrentUrl().contains("tags/playstation")){
			Assert.assertEquals(1, 1);
		}else{
			Assert.assertEquals(1, 0);
		}
		navbar.hoverFilm();
		navbar.hoverSports();
		navbar.hoverOnVideoGames();
		navbar.clickOnVideoGameOption("Xbox");
		if (getDriver().getCurrentUrl().contains("tags/xbox")){
			Assert.assertEquals(1, 1);
		}else{
			Assert.assertEquals(1, 0);
		}
		navbar.hoverFilm();
		navbar.hoverSports();
		navbar.hoverOnVideoGames();
		navbar.clickOnVideoGameOption("Nintendo");
		if (getDriver().getCurrentUrl().contains("tags/nintendo")){
			Assert.assertEquals(1, 1);
		}else{
			Assert.assertEquals(1, 0);
		}
		navbar.hoverFilm();
		navbar.hoverSports();
		navbar.hoverOnVideoGames();
		navbar.clickOnVideoGameOption("RPGs");
		if (getDriver().getCurrentUrl().contains("tags/rpgs")){
			Assert.assertEquals(1, 1);
		}else{
			Assert.assertEquals(1, 0);
		}
		navbar.hoverFilm();
		navbar.hoverSports();
		navbar.hoverOnVideoGames();
		navbar.clickOnVideoGameOption("FPS");
		if (getDriver().getCurrentUrl().contains("tags/fps")){
			Assert.assertEquals(1, 1);
		}else{
			Assert.assertEquals(1, 0);
		}
		navbar.hoverFilm();
		navbar.hoverSports();
		navbar.hoverOnVideoGames();
		navbar.clickOnVideoGameOption("simulation");
		if (getDriver().getCurrentUrl().contains("tags/simulation")){
			Assert.assertEquals(1, 1);
		}else{
			Assert.assertEquals(1, 0);
		}
	}// End of Check_Sorting()
	/* 
	  * Use-case  : Profile image dropdown
	  * Test case :"1) Open Ranker as a logged in user.
					2) Click on profile image and click on "create a list" 
					3) Again Click on profile image and remove your cursor and wait for 2 seconds 
	 */		
	@Test(priority=23)
	    public void ProfileDropdown() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 23 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseStateWithLogin("ProfileDropdown");
		UserProfilePage profile = common.getUserProfilePage(url);
profile.clickOnProfile();
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {}
		navbar.hoverOnProfileDropdown();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {}
		navbar.hoveronimage();
		try {
			Thread.sleep(8000);
		} catch (Exception e) {}
		Assert.assertTrue(navbar.isNotDisplayedprofileimagedropdown());
        profile.clickOnProfile();
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {}
		navbar.hoverOnProfileDropdown();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Assert.assertTrue(navbar.isPresentprofileimagedropdown());
	}//End for ProfileDropdown
	/* 
	  * Use-case  :More - links
	  * Test case :"1) Click on multiple category/class/tag links.
					//2) Click on "see all topics".
					3) Click on all the links on the right part of the overlay....
	 */	
	@Test(priority=24)
	public void MoreOverlayFrequently() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 24 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("MoreOverlayFrequently");
		//NavBar navbar=new NavBar(getDriver());
		navbar.hoverMore();
		browserWait();
//		Assert.assertTrue(navbar.verifyMoreblockActive());
//		Assert.assertEquals(navbar.cctlinksCount(), 28);
		
		navbar.clickOnMoreRightOverlay(2);
		//System.out.println()
		//navbar.clickOnSeeAllTopicLink();
		String url=getDriver().getCurrentUrl();
		if(url.contains("app/faq")){
			Assert.assertEquals(1, 1);
		}
		else
			Assert.assertEquals(1, 0);
		
	}//End of More - links
	/* 
	  * Use-case  :More - links
	  * Test case :"1) Click on multiple category/class/tag links.
					//2) Click on "see all topics".
					3) Click on all the links on the right part of the overlay....
	 */	
	@Test(priority=25)
	public void MoreOverlayContact() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 25 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("MoreOverlayContact");
		//NavBar navbar=new NavBar(getDriver());
		navbar.hoverMore();
		browserWait();
//		Assert.assertTrue(navbar.verifyMoreblockActive());
//		Assert.assertEquals(navbar.cctlinksCount(), 28);
		
		navbar.clickOnMoreRightOverlay(3);
		//System.out.println()
		//navbar.clickOnSeeAllTopicLink();
		String url=getDriver().getCurrentUrl();
		if(url.contains("app/contactus")){
			Assert.assertEquals(1, 1);
		}
		else
			Assert.assertEquals(1, 0);
	}//End of More - links
	/* 
	  * Use-case  :More - links
	  * Test case :"1) Click on multiple category/class/tag links.
					//2) Click on "see all topics".
					3) Click on all the links on the right part of the overlay....
	 */	
	@Test(priority=26)
	public void MoreOverlayToprankers() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 26 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("MoreOverlayToprankers");
		//NavBar navbar=new NavBar(getDriver());
		navbar.hoverMore();
		browserWait();
		navbar.clickOnMoreRightOverlay(4);
		//System.out.println()
		//navbar.clickOnSeeAllTopicLink();
		String url=getDriver().getCurrentUrl();
		if(url.contains("leaderboard")){
			Assert.assertEquals(1, 1);
		}
		else
			Assert.assertEquals(1, 0);
	}//End of More - links
	/* 
	  * Use-case  :More - links
	  * Test case :"1) Click on multiple category/class/tag links.
					//2) Click on "see all topics".
					3) Click on all the links on the right part of the overlay....
	 */	
	@Test(priority=27)
	public void MoreOverlaylistopedia() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 27 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("MoreOverlaylistopedia");
		//NavBar navbar=new NavBar(getDriver());
		navbar.hoverMore();
		browserWait();
//		Assert.assertTrue(navbar.verifyMoreblockActive());
//		Assert.assertEquals(navbar.cctlinksCount(), 28);
		
		navbar.clickOnMoreRightOverlay(5);
		//System.out.println()
		//navbar.clickOnSeeAllTopicLink();
		String url=getDriver().getCurrentUrl();
		if(url.contains("fact-lists")){
			Assert.assertEquals(1, 1);
		}
		else
			Assert.assertEquals(1, 0);
	}//End of More - links
	/* 
	  * Use-case  :More - links
	  * Test case :"1) Click on multiple category/class/tag links.
					//2) Click on "see all topics".
					3) Click on all the links on the right part of the overlay....
	 */	
	@Test(priority=28)
	public void MoreOverlayembed() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 28 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("MoreOverlayembed");
		//NavBar navbar=new NavBar(getDriver());
		navbar.hoverMore();
		browserWait();
		navbar.clickOnMoreRightOverlay(6);
		String url=getDriver().getCurrentUrl();
		if(url.contains("widget")){
			Assert.assertEquals(1, 1);
		}
		else
			Assert.assertEquals(1, 0);
	}//End of More - links
	/* 
	  * Use-case  :Internal Search: auto load more search results
	  * Test case :"Search for text "cat" it opens search page with all cat results
	 */	
	@Test(priority=29)
	public void AutoLoadMoreSearchResult() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 29 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("AutoLoadMoreSearchResult");
		navbar.enterSearchText("cat");
		browserWait();
		navbar.clickOnsearchbtn();
		browserWait();
		navbar.autoloading(10);
		browserWait();
		Assert.assertTrue(navbar.isnodePresent(15));//12
		//NavBar navbar=new NavBar(getDriver());
	}//End of AutoLoadMoreSearchResult
	/* 
	  * Use-case  :Verify UX of Proile Click
	  * Test case :"1. Log in and click on your profile link at the top right side of the screen
					2. click over the profile link and hover away
	 */	
	@Test(priority=30)
	public void ProfileClick() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 29 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseStateWithLogin("ProfileClick");
		UserProfilePage profile = new UserProfilePage(getDriver());
		//Home homePage=new Home(getDriver());
		profile.clickOnProfile();
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {}
		navbar.hoverOnProfileDropdown();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {}
		navbar.hoveronimage();
		try {
			Thread.sleep(8000);
		} catch (Exception e) {}
		Assert.assertTrue(navbar.isNotDisplayedprofileimagedropdown());
        profile.clickOnProfile();
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {}
		navbar.hoverOnProfileDropdown();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Assert.assertTrue(navbar.isPresentprofileimagedropdown());
		//profile.clickOnProfile();
		//NavBar navbar=new NavBar(getDriver());
	}//End of AutoLoadMoreSearchResult
	
	   /* 
	   * Use-case  :Verify that all links to fourm are removed
	   * Test case :Go to ranker and Click on "more" in nav bar
	    */ 
	 @Test(priority=31)
	 public void fourmLinks() {
	  System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 30 !!!!!!!!!!!!!!!!!!!!!!!");
	  NavBar navbar=BaseState("MoreOverlayembed");
	  //NavBar navbar=new NavBar(getDriver());
	  navbar.hoverMore();
	  browserWait();
	  Assert.assertFalse(navbar.verifyForms(),"Forms");
	 
	 }//End of fourmLinks
	
	 /* 
	   * Use-case  :Clear out search box the way we do in autosuggest when click into it
	   * Test case :Search for any text in search bar
	      */  
	 @Test(priority=32)
	 public void clearSearchBox() {
	  System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 31 !!!!!!!!!!!!!!!!!!!!!!!");
	  NavBar navbar=BaseState("MoreOverlayembed");
	  //NavBar navbar=new NavBar(getDriver());
	  navbar.enterSearchText("cat");
	    browserWait();
	    navbar.clickOnsearchbtn();
	    try{
	     Thread.sleep(4000);
	    }catch(Exception e){}
	  String text=navbar.getAttributeOfsearchBox();
	 
	  if(text.contains("find a list or topic")){
	   Assert.assertEquals(1, 1);
	  }
	  else
	   Assert.assertEquals(1, 0);
	    
	 }//End of clearSearchBox
	   /* Use-case  :    Make create a list box stay open unless user clicks on the x
	   * Test case :     Open ranker-stage.com
	       Click on "create a list" link on top right,pop up opens
	       Now move cursor away from the popup
	       */
	  
	 @Test(priority=33)
	 public void Createalist() {
	  System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 32 !!!!!!!!!!!!!!!!!!!!!!!");
	  NavBar navbar=BaseState("Createalist");
	  navbar.hoverMore();
	  browserWait();
	  navbar.clickOnCreatelist();
	  try {
	   Thread.sleep(2000);
	  } catch (Exception e) {
	   
	  }
	  Assert.assertTrue(navbar.isPresentcreateListPopup());
	  navbar.hoverOnvoteOnHeader();
	  Assert.assertTrue(navbar.isPresentcreateListPopup());
	  try {
	   Thread.sleep(7000);
	  } catch (Exception e) {
	   
	  }
	  navbar.clickOncloseBtn();
	  try {
	   Thread.sleep(5000);
	  } catch (Exception e) {
	  }
	  Assert.assertFalse(navbar.isPresentcreateListPopup());
	 }//End of Createalist
	 /* 
	  * Use-case  : Video category
	  * Test case :"Verify removed sections
	 */	
	@Test(priority=34)
	public void VideoCategoryRemoveSection() throws Exception{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 34!!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("Video_hover");
		//NavBar navbar=new NavBar(getDriver());
		
		Videos videos=navbar.clickOnVideos();
		Assert.assertFalse(navbar.isPresentVideocategeory());
		Assert.assertFalse(navbar.isPresentVideoheading());
		//Assert.assertEquals(videos.getCurrentURL(),config.getProperty("Url")+"videos");
	}//End of Videos - hover and click 
	
	/* 
	  * Use-case  : Make sure Search lists should not show related list query param
	  * Test case :"Enter "best modern family episodes" in search bar and click search icon
						Search page opens with many results 
						Now open first list"Best Modern Family Episodes"
	 */		
	@Test(priority=35)
	    public void SearchListQueryParam() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! TEST CASE 35 !!!!!!!!!!!!!!!!!!!!!!!");
		NavBar navbar=BaseState("SearchListQueryParam");
		//NavBar navbar=new NavBar(getDriver());
		String txt=UtilityMethods.generateRandomString(10, Mode.ALPHANUMERIC);
		navbar.enterSearchText("best modern family episodes");
		SearchRanker search=navbar.clickOnsearch();
		try{
			Thread.sleep(3000);
		}catch(Exception e){}
		navbar.clickOnnodename(1);
		try{
			Thread.sleep(3000);
		}catch(Exception e){}
		String url=getDriver().getCurrentUrl();
		if(url!="param"){
			Assert.assertEquals(1,1);
		}else
			Assert.assertEquals(1,0);
	}
	/*
	  * This is base state of the slide show test-cases.
	  */
	 public NavBar BaseState(String testName){
		 try{
		 startRecording(testName);
		}catch(Exception e){}
		 //NavBar navbar=new NavBar(getDriver());
		 common=new Commonpage(getDriver());
		 NavBar navbar=common.getNavBar(config.getProperty("Url"));
		 return navbar;
	 } //End of BaseState()
	 
	
	 /*
	  * This is base state of the slide show test-cases.
	  */
	 public NavBar  BaseStateWithLogin(String testName){
		 try{
		 startRecording(testName);
		}catch(Exception e){}
		 common=new Commonpage(getDriver());
		 common.signin("testuserkallol1@mailinator.com", "testing");
		 NavBar navbar=common.getNavBar(config.getProperty("Url"));
		 return navbar;
	 } //End of BaseStateWithLogin() 
}