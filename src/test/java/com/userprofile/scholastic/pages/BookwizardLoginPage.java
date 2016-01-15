package com.userprofile.scholastic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.userprofile.scholastic.base.BaseSetup;

public class BookwizardLoginPage 
{
	WebDriver driver;
	
	public BookwizardLoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath ="//div[@id='universal-account']/a[1]" )
	WebElement go;
	@FindBy(xpath="//input[@id='loginId']")
	WebElement iEmail;
	@FindBy(id="password")
	WebElement passwrd;
	@FindBy(id="nextbutton")
	WebElement signIn;
	@FindBy(xpath="//*[@id='universal-signInOut']/a")
	WebElement linkSignout;
	
	
	public void twait()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickGo()
	{
		go.click();
	}
	public void typeEmail(String inputemail)
	{
		iEmail.sendKeys(inputemail);
	}
	
	public void typePassword(String inputpass)
	{
		passwrd.sendKeys(inputpass);
	}
	public void clicksignIn()
	{
		signIn.click();
	}
	
	
	public boolean checkSignout(){
		try {
				linkSignout.isDisplayed();
				return true;
			} 	catch (Exception e) {
				System.out.println("insideCatch");
				return false;
		}
		
				
		
	}
	
		
	
}
