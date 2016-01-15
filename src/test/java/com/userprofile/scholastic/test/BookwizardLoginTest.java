package com.userprofile.scholastic.test;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.userprofile.scholastic.base.BaseSetup;
import com.userprofile.scholastic.base.RunControl;
import com.userprofile.scholastic.pages.BookwizardLoginPage;

public class BookwizardLoginTest
{
	SoftAssert sf ;
	
	@Test(dataProvider="gTestData")
	public void bookwizardLogin(Hashtable<String,String> data)
 {
			
			WebDriver driver = BaseSetup.setDriver();
			driver.get("http://www.scholastic.com/bookwizard/");
			//WebDriver driver = BaseSetup.startBrowser("firefox", "http://www.scholastic.com/bookwizard/");
			BookwizardLoginPage lpage = PageFactory.initElements(driver, BookwizardLoginPage.class);
			lpage.clickGo();
			lpage.twait();
			driver.switchTo().frame("GB_frame");
			lpage.typeEmail(data.get("Email"));
			lpage.typePassword(data.get("Password"));
			lpage.clicksignIn();
			lpage.twait();
			
			if (lpage.checkSignout()) {
					Reporter.log("Login In successful",true);
					Assert.assertTrue(true);
					driver.quit();
					
				} else {
					
					Reporter.log("Login is not successful", true);
					//Assert.assertEquals(false, true);
					sf = new SoftAssert();
					sf.assertFalse(true);
					driver.quit();
					sf.assertAll();
				}
		}
	@BeforeTest
	public void checkRunmode()
	{
		 boolean run = RunControl.checkTestRunMode("BookwizardLoginTest");
		 if(!run){
			 throw new SkipException("Skipping the test as Runmode is NO");
		 }
	}
	
	@DataProvider
	public Object[][] gTestData(){
		return RunControl.getTestData("BookwizardLoginTest");
	}
	
	
	
}
