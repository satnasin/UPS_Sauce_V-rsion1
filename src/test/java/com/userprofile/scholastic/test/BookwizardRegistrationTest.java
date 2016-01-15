package com.userprofile.scholastic.test;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.userprofile.scholastic.base.*;
import com.userprofile.scholastic.pages.BookwizardRegistrationPage;


public class BookwizardRegistrationTest 
{

	@Test(dataProvider="gTestData")
	public void teacherRegistration(Hashtable<String, String>data)
 {
		WebDriver driver = BaseSetup.setDriver();
		driver.get("http://www.scholastic.com/bookwizard/");
		//WebDriver driver = BaseSetup.startBrowser("chrome", "http://www.scholastic.com/bookwizard/");
		BookwizardRegistrationPage regTeacher = PageFactory.initElements(driver, BookwizardRegistrationPage.class);
		regTeacher.clickRegister();
		regTeacher.twait();
		driver.switchTo().frame("GB_frame");
		regTeacher.twait();
		regTeacher.regNow();
		regTeacher.selectTitle();
		regTeacher.typeFirstName(data.get("firstName"));
		regTeacher.typeLastName(data.get("lasName"));
		regTeacher.typeEmail(data.get("email"));
		regTeacher.typeCnfEmail(data.get("email"));
		regTeacher.typePass(data.get("pass"));
		regTeacher.typeCpass(data.get("pass"));
		regTeacher.clickContinue();
		regTeacher.twait();
		regTeacher.selectState();
		regTeacher.twait();
		regTeacher.selectCity();
		regTeacher.twait();
		regTeacher.twait();
		regTeacher.selectSchoolList();
		regTeacher.tickTerms();
		regTeacher.tickPrivacy();
		regTeacher.clickContinue();
		regTeacher.twait();
		regTeacher.selectTeacherRole();
		regTeacher.clickContinue();
		regTeacher.twait();
		regTeacher.clickContinue();
		regTeacher.twait();
		regTeacher.closeRegistration();
		//BaseSetup.WebDriversetOff();
		driver.close();
	}	
	@BeforeTest
	public void checkRunmode()
	{
		 boolean run = RunControl.checkTestRunMode("BookwizardRegistrationTest");
		 if(!run){
			 throw new SkipException("Skipping the test as Runmode is NO");
		 }
	}
	
	@DataProvider
	public Object[][] gTestData(){
		return RunControl.getTestData("BookwizardRegistrationTest");
	}
}
