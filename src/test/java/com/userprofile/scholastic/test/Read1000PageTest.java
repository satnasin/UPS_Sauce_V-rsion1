package com.userprofile.scholastic.test;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.userprofile.scholastic.base.BaseSetup;
import com.userprofile.scholastic.base.RunControl;
import com.userprofile.scholastic.pages.InfinityRingHomePage;
import com.userprofile.scholastic.pages.Read1000Page;

public class Read1000PageTest
{
	@Test(dataProvider="gTestData")
	public void parentRegistration(Hashtable<String,String> data)
	{
		WebDriver driver = BaseSetup.setDriver();
		driver.get("http://www.scholastic.com/ups/campaigns/minutes-2015");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriver driver = BaseSetup.startBrowser("firefox","http://www.scholastic.com/ups/campaigns/minutes-2015");
		Read1000Page read1000 = PageFactory.initElements(driver, Read1000Page.class);
		read1000.clickparentGo();
		read1000.typeDOB(data.get("doB"));
		read1000.clickSubmit();
		String url = read1000.verifyParentPage();
		if(url.equals("http://www.scholastic.com/ups/campaigns/minutes-2015/parent"))
		{
			Reporter.log("Parent Page is dispalyed", true);
		}else
		{
			Reporter.log("Parent Page is not displayed" + url, true);
		}

		//BaseSetup.WebDriversetOff();
		driver.quit();
		
		
	}
	@BeforeTest
	public void checkRunmode()
	{
		 boolean run = RunControl.checkTestRunMode("Read1000PageTest");
		 if(!run){
			 throw new SkipException("Skipping the test as Runmode is NO");
		 }
	}
	
	@DataProvider
	public Object[][] gTestData(){
		return RunControl.getTestData("Read1000PageTest");
	}
}
