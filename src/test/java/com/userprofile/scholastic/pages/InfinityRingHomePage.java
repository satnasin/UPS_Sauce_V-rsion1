package com.userprofile.scholastic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.userprofile.scholastic.base.BaseSetup;

public class InfinityRingHomePage {
	
	WebDriver driver ;
	
	public InfinityRingHomePage(WebDriver driver)
	{
		this.driver = driver;		
	}
	
	@FindBy(xpath="//div[@class='login-box']/a[1]")
	WebElement signIn;
	@FindBy(xpath="//div[@class='modal-content login hub-popup']/section[1]/div[2]/strong")
	WebElement textSignInWindow;
	@FindBy(xpath="//div[@class='modal-content login hub-popup']/section[2]/a")
	WebElement register;
	@FindBy(xpath="//div[@id='username-picker']/fieldset[1]/select[1]")
	WebElement category1;
	@FindBy(xpath="//div[@id='username-picker']/fieldset[1]/select[2]")
	WebElement word1;
	@FindBy(xpath="//div[@id='username-picker']/fieldset[2]/select[1]")
	WebElement category2;
	@FindBy(xpath="//div[@id='username-picker']/fieldset[2]/select[2]")
	WebElement word2;
	@FindBy(xpath="//div[@class='plus-screenname']/p/span")
	WebElement ousernameCreated;
	@FindBy(xpath="//div[@class='form-row labeled password']/label/input")
	WebElement passwrd;
	@FindBy(xpath="//div[@class='form-row labeled password_confirmation']/label/input")
	WebElement cnfrmPasswrd;
	@FindBy(xpath="//div[@class='form-row labeled email']/label/input")
	WebElement email;
	@FindBy(xpath="//div[@class='form-row labeled email-confirmation']/label/input")
	WebElement confirmEmail;
	@FindBy(xpath="//div[@class='submit']/input")
	WebElement joinButton;
	@FindBy(xpath="//div[@id='plus-modal']/div/section/form/div[4]/a[2]")
	WebElement doneButton;
	@FindBy(xpath="//div[@id='plus-modal']/div/section/form/div[4]/a[1]")
	WebElement buttonaddBook;
	@FindBy(xpath="//div[@id='top-bar']/div[1]/div/div[2]/a")
	WebElement signout;
	@FindBy(xpath="//div[1]/div/section[1]/form/div[1]/label/input")
	WebElement uName;
	@FindBy(xpath="//div[1]/div/section[1]/form/div[2]/label/input")
	WebElement password;
	@FindBy(xpath="//*[@id='log-in-button']")
	WebElement buttonSignIn;	
	@FindBy(xpath="//div[@class='modal-content login hub-popup']/section[2]/a")
	WebElement regPopUp;
	public void clicksigninLink()
	{
		signIn.click();
	}
	public boolean verifyRegistrationScreen()
	{
		BaseSetup.twait();
		try {
			regPopUp.isDisplayed();
				return true;
			} 	catch (Exception e) {
				System.out.println("insideCatch");
				return false;
		}
		
						
		
	}
	public String gettextSigninWindow()
	{
		String otextsigninWindow = textSignInWindow.getText();
		return otextsigninWindow;
	}
	
	public void clickRegisterLink()
	{
		register.click();
	}
	
	public void selectCategory1()
	{
		Select s1 = new Select(category1);
		s1.selectByIndex(1);
	}
	public void selectWord1()
	{
		Select s2 = new Select(word1);
		s2.selectByIndex(2);
	}
	
	public void selectCategory2()
	{
		Select s3 = new Select(category2);
		s3.selectByIndex(1);
	}
	public void selectWord2()
	{
		Select s4 = new Select(word2);
		s4.selectByIndex(1);
	}
	
	public void twait()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getTextforuserName()
	{
		String ouserNameCreated = ousernameCreated.getText();
		return ouserNameCreated;
	}
	
	public void typeEmail(String mailE)
	{
		email.sendKeys(mailE);
	}
	
	public void typeconfirmEmail(String mailE)
	{
		confirmEmail.sendKeys(mailE);
	}
	
	public void typePwd(String pss)
	{
		passwrd.sendKeys(pss);
	}
	
	public void typeconfirmPwd(String pss)
	{
		cnfrmPasswrd.sendKeys(pss);
	}
	
	public void clickJoin()
	{
		joinButton.click();
	}
	public String checkbuttonAddBook()
	{
		String chkaddBook = buttonaddBook.getText();
		return chkaddBook;
	}	
	public void clickbuttonDone()
	{
		doneButton.click();
	}
	
	
	public void typeuserName(String inputUserName)
	{
		uName.sendKeys(inputUserName);
	}
	
	public void typepassWord(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickSignIn()
	{
		buttonSignIn.click();
	}
	
	public boolean checkSignOut(){
		try {
			signout.isDisplayed();
				return true;
			} 	catch (Exception e) {
				System.out.println("insideCatch");
				return false;
		}
		
		// Commenting this for Sauce Run
		
				/*finally{
					BaseSetup.WebDriversetOff();
				}*/
		
	}
	
}
