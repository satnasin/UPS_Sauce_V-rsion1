package com.userprofile.scholastic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.userprofile.scholastic.base.BaseSetup;

public class CommunityLoginPage 
{
	WebDriver driver;
	
	public CommunityLoginPage(WebDriver driver)
	{
		this.driver = driver;
		
	}

	@FindBy(xpath="//*[@id='schl3o']/div/div[4]/div[2]/div/div[2]/div[4]/span[1]/a")
	WebElement signLink;
	@FindBy(xpath="//div[@id='kids_registration_target']/div/form/p[1]/input")
	WebElement ScreenName;
	@FindBy(xpath="//div[@id='kids_registration_target']/div/form/p[2]/input")
	WebElement Pass;
	@FindBy(xpath="//div[@id='kids_registration_target']/div/form/div/input")
	WebElement Go;
	@FindBy(xpath="//div[@id='kids_registration_popup_container']/div/div/div[1]/h1")
	WebElement loginPopup;
	@FindBy(xpath="//*[@id='kids_registration_popup_container']/a/img")
	WebElement closeimgLoginPopup;
	
	public void clickSignIn()
	{
		signLink.click();
		
	}

	
	public void typeUname(String uName)
	{
		ScreenName.sendKeys(uName);
		
	}
	
	
	public void typePassword(String pwd)
	{
		Pass.sendKeys(pwd);
	}
	
	public void clickGo()
	{
		Go.click();
	}
	
	public String  checkSignInNowPopUp()
	{
		String text_loginPopup= loginPopup.getText();
		return text_loginPopup;
		
	}
	
	// To check if the close img is present on the popup
	
	public boolean checkCancelPopup(){
		try {
			closeimgLoginPopup.isDisplayed();
				return true;
				
			} 	catch (Exception e) {
				System.out.println("insideCatch");
				return false;
		}
		// due to null pointer on BaseSetup class
		
				/*finally{
					BaseSetup.WebDriversetOff();
				}*/
		
	}
	
}
