package com.testsuite.navbar;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.AppGlobalVariables;
import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.paeobjects.home.Home;
import com.paeobjects.navbar.NavBar;
import com.pageobject.login.FBAPI;
import com.pageobject.login.GooglePlusAPI;
import com.pageobject.login.TwitterAPI;
import com.testng.Retry;
import com.utilities.UtilityMethods;
import com.utilities.UtilityMethods.Mode;

public class SignUp extends BaseSetup{
	
	String uname="";
	String email="";
	String pwd=AppGlobalVariables.PASSWORD;
	
	@BeforeMethod
	public void beforeMethod(){
		if(!getDriver().getCurrentUrl().equals(new ConfigManager().getProperty("Url")))
		getDriver().get(new ConfigManager().getProperty("Url"));
	}
	
	@Test(priority=1)
	public void createNewAccountWithFacebook(){
		NavBar navbar=new NavBar(getDriver());
		navbar.clickSignin();
		navbar.clickOnJoining();
		FBAPI fbapi=navbar.clickSinupByFB();
		//Verify Facebook API page URL
		Assert.assertTrue(fbapi.verifyFBHeader(), "FB header");
		Assert.assertTrue(fbapi.getCurrentURL().toLowerCase().contains(AppGlobalVariables.API_FACEBOOKURL), "Verify FB API url");
		getDriver().close();
		getDriver().switchTo().window(getDriver().getWindowHandles().toArray()[0].toString());
	}
	
	@Test(priority=2)
	public void createNewAccountWithTwitter() throws InterruptedException{
		NavBar navbar=new NavBar(getDriver());
		navbar.clickSignin();
		navbar.clickOnJoining();
		TwitterAPI twitterapi=navbar.clickSinupBytwitter();
		//Verify Twitter API page URL
		Assert.assertTrue(twitterapi.verifyTwitterHeader(), "Twitter header");
		Assert.assertTrue(twitterapi.getCurrentURL().toLowerCase().contains(AppGlobalVariables.API_TWITTERURL), "Verify Twitter API url");
		getDriver().close();
		getDriver().switchTo().window(getDriver().getWindowHandles().toArray()[0].toString());
	}
	
	@Test(priority=3)
	public void createNewAccountWithGooglePlus(){
		NavBar navbar=new NavBar(getDriver());
		navbar.clickSignin();
		navbar.clickOnJoining();
		GooglePlusAPI gplusapi=navbar.clickSinupByGPlus();
		//Verify Gooleplus API page URL
		Assert.assertTrue(gplusapi.verifyGPluslogo(), "GPlus logo");
		Assert.assertTrue(gplusapi.getCurrentURL().toLowerCase().contains(AppGlobalVariables.API_GPLUS), "Verify Google plus API url");
		getDriver().close();
		getDriver().switchTo().window(getDriver().getWindowHandles().toArray()[0].toString());
	}
	
	@Test(priority=4, retryAnalyzer=Retry.class)
	public void createNewAccounstInvalidCredentials(){
		NavBar navbar=new NavBar(getDriver());
		navbar.clickSignin();
		navbar.clickOnJoining();
		navbar.clickSignupByEmail();
		uname=AppGlobalVariables.USERS_AUTOMATIONUSER1;
		email=UtilityMethods.generateRandomString(11, Mode.ALPHA);
		pwd=UtilityMethods.generateRandomString(5, Mode.ALPHA);
		navbar.enterregistrationdetails(uname,email,pwd);
		
		//Verify error messages
		
		Assert.assertEquals(navbar.verifyUnameError(), AppGlobalVariables.ERROR_EXISTINGUSER, "Existing username Error");
		Assert.assertEquals(navbar.verifyEmailError(), AppGlobalVariables.ERROR_INVALIDEMAIL, "Invalid email Error");
		Assert.assertEquals(navbar.verifyPWDError(), AppGlobalVariables.ERROR_INVALIDPWD, "Invalid password Error");
		
	}
	
	@Test(priority=5)
	public void createNewAccounstValidCredentials(){
		NavBar navbar=new NavBar(getDriver());
		navbar.clickSignin();
		navbar.clickOnJoining();
		navbar.clickSignupByEmail();
		uname=UtilityMethods.generateRandomString(1, Mode.ALPHA)+UtilityMethods.generateRandomString(5, Mode.ALPHANUMERIC);
		email=uname+AppGlobalVariables.EMAILEXTENCTION;
		pwd=AppGlobalVariables.PASSWORD;
		navbar.enterregistrationdetails(uname,email,pwd);
		Home home=navbar.clickOnSinup();
		//Verify signup
		Assert.assertTrue(home.veriifyUserLogo(),"Verify user logo(SignUp)");
		//logout
		home.doclose();
//		home.doLogout();
	}
	

}
