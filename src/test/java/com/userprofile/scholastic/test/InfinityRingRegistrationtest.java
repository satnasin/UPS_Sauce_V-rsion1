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
import com.userprofile.scholastic.pages.InfinityRingHomePage;

public class InfinityRingRegistrationtest
{
	
	@Test(dataProvider="gTestData")
	public void clickSignin(Hashtable<String,String> data)
	{
		WebDriver driver = BaseSetup.setDriver();
		//WebDriver driver = BaseSetup.startBrowser("firefox", "http://infinityring.scholastic.com/#");
		driver.get("http://infinityring.scholastic.com/#");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		InfinityRingHomePage home_page = PageFactory.initElements(driver, InfinityRingHomePage.class);
		home_page.clicksigninLink();
		home_page.twait();
		/*String text_loginPopUp=home_page.gettextSigninWindow();		
		System.out.println(text_loginPopUp+"<<<<<>>>>>>");
		Assert.assertEquals(text_loginPopUp, "Enter your username and password");*/
		if(home_page.verifyRegistrationScreen()){
			Reporter.log("Registration Screen is present", true);
			Assert.assertEquals(true, true);
		}else {
			System.out.println("Pls check Reg Screen not displayed");
			Reporter.log("Registration Screen not displayed kindly chck", true);
			//Assert.assertEquals(false, true);
			SoftAssert asrt = BaseSetup.initSoftAssert();
			asrt.assertFalse(true);
			driver.close();
			asrt.assertAll();
			asrt=null;
			
		}
		
		home_page.clickRegisterLink();
		home_page.twait();		
		home_page.selectCategory1();
		home_page.twait();
		home_page.selectWord1();
		home_page.twait();
		home_page.selectCategory2();
		home_page.twait();
		home_page.selectWord2();
		home_page.twait();
		String text_registrationUserName = home_page.getTextforuserName();
		System.out.println("RegisterUserNameCreated"+text_registrationUserName);
		home_page.twait();
		home_page.typePwd(data.get("pass"));
		home_page.typeconfirmPwd(data.get("pass"));
		home_page.typeEmail(data.get("email"));
		home_page.typeconfirmEmail(data.get("email"));
		home_page.clickJoin();
		home_page.twait();
		String oButtonAddBook = home_page.checkbuttonAddBook();
		System.out.println("AddBookButton "+oButtonAddBook);
		home_page.clickbuttonDone();
		home_page.twait();
		if (home_page.checkSignOut()) {
			Reporter.log("Login In successful",true);
			Assert.assertEquals(true, true);
			
		} else {
			System.out.println("No Login");
			Reporter.log("Login not successful", true);
			Assert.assertEquals(false, true);
			
		}
		driver.quit();		
	}
	@BeforeTest
	public void checkRunmode()
	{
		 boolean run = RunControl.checkTestRunMode("InfinityRingRegistrationtest");
		 if(!run){
			 throw new SkipException("Skipping the test as Runmode is NO");
		 }
	}
	
	@DataProvider
	public Object[][] gTestData(){
		return RunControl.getTestData("InfinityRingRegistrationtest");
	}
	

}
