package com.userprofile.scholastic.test;



import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.userprofile.scholastic.base.*;
import com.userprofile.scholastic.pages.CommunityLoginPage;

public class CommunityLoginTest 
{
	@Test (dataProvider="gTestData")
	public void checkValidUser(Hashtable<String, String>data)
	{
		WebDriver driver = BaseSetup.setDriver();
		//WebDriver driver = BaseSetup.startBrowser("firefox", "http://community.scholastic.com/");
		driver.get("http://community.scholastic.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CommunityLoginPage login_page = PageFactory.initElements(driver, CommunityLoginPage.class);
		login_page.clickSignIn();
		String text_loginPopUp=login_page.checkSignInNowPopUp();
		Reporter.log("Login Popup for Stacks >"+text_loginPopUp,true);
		Assert.assertEquals("Sign in now.", text_loginPopUp);
		//System.out.println("******"+text_loginPopUp);
		login_page.typeUname(data.get("uName"));
		login_page.typePassword(data.get("password"));
		login_page.clickGo();
		BaseSetup.twait();
		boolean isPresent = login_page.checkCancelPopup();
		if (isPresent) {
			Reporter.log("Login In not successful",true);
			//Assert.assertEquals(true, false);
			SoftAssert asrt = BaseSetup.initSoftAssert();
			asrt.assertFalse(true);
			driver.quit();
			asrt.assertAll();
			asrt=null;
			
		} else {
			System.out.println("Login In successful");
			Reporter.log("Login In successful", true);
			Assert.assertEquals(true, true);
			
		}
		
		driver.quit();		
	}
		
	@BeforeTest
	public void checkRunmode()
	{
		 boolean run = RunControl.checkTestRunMode("CommunityLoginTest");
		 if(!run){
			 throw new SkipException("Skipping the test as Runmode is NO");
		 }
	}
	
	@DataProvider
	public Object[][] gTestData(){
		return RunControl.getTestData("CommunityLoginTest");
	}
	

}
