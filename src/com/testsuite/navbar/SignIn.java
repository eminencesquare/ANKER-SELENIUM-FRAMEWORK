package com.testsuite.navbar;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.AppGlobalVariables;
import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.paeobjects.home.Home;
import com.paeobjects.navbar.NavBar;
import com.pageobject.login.FBAPI;
import com.pageobject.login.ForgotPassword;
import com.pageobject.login.GooglePlusAPI;
import com.pageobject.login.TwitterAPI;
import com.utilities.UtilityMethods;
import com.utilities.UtilityMethods.Mode;

public class SignIn extends BaseSetup{
	
	
	String uname="";
	String email="";
	String pwd=AppGlobalVariables.PASSWORD;
				
	@BeforeMethod
	public void beforeMethod(){
		if(!getDriver().getCurrentUrl().equals(new ConfigManager().getProperty("Url")))
		getDriver().get(new ConfigManager().getProperty("Url"));
	}
	
	
	@Test(priority=1)
	public void forgotpassword(){
		NavBar navbar=new NavBar(getDriver());
		navbar.clickSignin();
		ForgotPassword forgotPwd=navbar.clickForgotPwd();
		Assert.assertTrue(forgotPwd.verifyForgotEmailBox(),"Forgot email box");
	}
	
	@Test(priority=2)
	public void SignIn_leavingpasswordblank() throws Exception{
		NavBar navbar=new NavBar(getDriver());
		navbar.clickSignin();
		navbar.clickSignInBtn();
		//verify
		Alert alert=getDriver().switchTo().alert();
		Assert.assertEquals(alert.getText(), AppGlobalVariables.WARNING_EMPTY_CREDENTIALS, "verify warning message");
		alert.accept();
	}
	
	@Test(priority=3)
	public void SignIn_invalidcredentials() throws Exception{
		NavBar navbar=new NavBar(getDriver());
		if(navbar.isSigninNotPresent())
		navbar.clickSignin();
		navbar.enterCredentels(AppGlobalVariables.USER, UtilityMethods.generateRandomString(6, Mode.ALPHANUMERIC));
		navbar.clicksigninBtn();
		//verify
		Assert.assertEquals(navbar.verifyPWDError(), AppGlobalVariables.ERROR_WRONG_PASSWORD, "verify error message");
	}
	
	@Test(priority=4)
	public void SignIn_validcredentials() throws Exception{
		NavBar navbar=new NavBar(getDriver());
		if(navbar.isSigninNotPresent())
		navbar.clickSignin();
		navbar.enterCredentels(AppGlobalVariables.USER,AppGlobalVariables.PASSWORD);
		Home home=navbar.clickSignInBtn();
		//verify login
		Assert.assertTrue(home.veriifyUserLogo(), "verify login");
//		home.doLogout();
	}
	
	@Test(priority=5)
	public void SignIn_Facebook() throws Exception{
		NavBar navbar=new NavBar(getDriver());
		navbar.clickSignin();
		FBAPI fbapi=navbar.clickSinupByFB();
		//Verify Facebook API page URL
		Assert.assertTrue(fbapi.verifyFBHeader(), "FB header");
		Assert.assertTrue(fbapi.getCurrentURL().toLowerCase().contains(AppGlobalVariables.API_FACEBOOKURL), "Verify FB API url");
		getDriver().close();
		getDriver().switchTo().window(getDriver().getWindowHandles().toArray()[0].toString());
	}
	
	@Test(priority=6)
	public void SignIn_Twitter() throws Exception{
		NavBar navbar=new NavBar(getDriver());
		navbar.clickSignin();
		TwitterAPI twiterapi=navbar.clickSinupBytwitter();
		//Verify Twitter API page URL
		Assert.assertTrue(twiterapi.verifyTwitterHeader(), "Twitter header");
		Assert.assertTrue(twiterapi.getCurrentURL().toLowerCase().contains(AppGlobalVariables.API_TWITTERURL), "Verify Twitter API url");
		getDriver().close();
		getDriver().switchTo().window(getDriver().getWindowHandles().toArray()[0].toString());
	}
	
	@Test(priority=7)
	public void SignIn_GooglePlus() throws Exception{
		NavBar navbar=new NavBar(getDriver());
		navbar.clickSignin();
		GooglePlusAPI gpapi=navbar.clickSinupByGPlus();
		//Verify Google+ API page URL
		Assert.assertTrue(gpapi.verifyGPluslogo(), "Google+ header");
		Assert.assertTrue(gpapi.getCurrentURL().toLowerCase().contains(AppGlobalVariables.API_GPLUS), "Verify Goole+ API url");
		getDriver().close();
		getDriver().switchTo().window(getDriver().getWindowHandles().toArray()[0].toString());
	}
}
