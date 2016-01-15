package com.userprofile.scholastic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BookwizardRegistrationPage 
{
	WebDriver driver;
	public String eml ;
	
	public BookwizardRegistrationPage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  String genEmail(String eml)
	{
		double x = Math.random();
		String rx = eml+x+"@india.com";
		return rx;
	}
	
	public String textEmail = genEmail("test");
	
	@FindBy(xpath = "//*[@id='universal-account']/a[2]")
	WebElement register;
	@FindBy(xpath="//*[@id='teacherRegisterNow']/a")
	WebElement registerNow;
	@FindBy(id="salutations")
	WebElement salutation;
	@FindBy(id="firstName")
	WebElement fName;
	@FindBy(id="lastName")
	WebElement lName;
	@FindBy(id="email")
	WebElement email;
	@FindBy(id="cnfEmail")
	WebElement cnfEmail;
	@FindBy(id="pwd")
	WebElement passWd;
	@FindBy(id="cnfpwd")
	WebElement confirmPassWd;
	@FindBy(id="next")
	WebElement next;
	@FindBy(id="stateWid")
	WebElement state;
	@FindBy(id="cityWid")
	WebElement city;
	@FindBy(id="schools")
	WebElement schools;
	@FindBy(id="terms")
	WebElement term;
	@FindBy(id="privacy")
	WebElement privacy;
	@FindBy(xpath="//ul[@id='Administrator']/li[6]/label/input")
	WebElement teacherRole;
	@FindBy(xpath = "//*[@id='frame_close2']/span")
	WebElement closeReg;	
	public void twait()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickRegister()
	{
		register.click();
	}
	
	public void regNow()
	{
		registerNow.click();
	}
	
	public void selectTitle()
	{
		helperSelect(salutation);
	}
	
	public void typeFirstName(String fN)
	{
		fName.sendKeys(fN);
	}
	
	public void typeLastName(String Ln)
	{
		lName.sendKeys(Ln);
	}

	public void typeEmail(String temail)
	{
		email.sendKeys(temail);
		
		
	}
	public void typeCnfEmail(String temail)
	{
	
		cnfEmail.sendKeys(temail);
	}
	
	public void typePass(String ps)
	{
		passWd.sendKeys(ps);
	}
	
	public void typeCpass(String ps)
	{
		confirmPassWd.sendKeys(ps);
	}
	
	public void clickContinue()
	{
		next.click();
	}
	public void selectState()
	{
		helperSelect(state);
	}
	public void selectCity()
	{
		helperSelect(city);
		
	}	
	
	public void selectSchoolList()
	{ 
		helperSelect(schools);
	}
	
	public void tickTerms()
	{
		term.click();
	}
	public void tickPrivacy()
	{
		privacy.click();
	}
	
	public void selectTeacherRole()
	{
		teacherRole.click();
	}
	
	public void closeRegistration()
	{
		closeReg.click();
	}
	
	
	public void helperSelect(WebElement locator)
	{
		Select select = new Select(locator);
		select.selectByIndex(1);
	}
	
	
	
	
	
 
}
