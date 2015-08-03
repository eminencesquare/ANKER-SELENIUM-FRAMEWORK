package com.testsuite.login;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.pageobject.login.AuthLoginPage;
import com.pageobject.login.ProfilePage;
import com.pageobject.login.SigninPage;

public class Signin extends BaseSetup{

	
	SigninPage signpg;
	ConfigManager config=new ConfigManager();
	
	@BeforeClass
	public void methodSetup(){
		AuthLoginPage authlpg=new AuthLoginPage(getDriver());
		getDriver().get(new ConfigManager().getProperty("Url"));
		authlpg.enterCredentels(config.getProperty("Authuname"), config.getProperty("Authpwd"));
		signpg=authlpg.clickSubmit();
	}
	@Test(priority=1,groups={"smoke"})
	public void logInITest() throws Exception{
		signpg.clickSignin();
		signpg.enterCredentels("ramnavuluri","bhanu1071");
		ProfilePage hmpge=signpg.clickSubmit();
		//verify login
		}
}