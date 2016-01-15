package com.userprofile.scholastic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Read1000Page
{
 WebDriver driver;


	public Read1000Page(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath="(//div[@class='wrap'])[2]/div/section[3]/a")
	WebElement parentsGo;
	
	@FindBy(xpath="//*[@id='age_verify']")
	WebElement dobInputBox;
	@FindBy(xpath = "//*[@id='popup-age']/table/tbody/tr/td/div/article/form/button")
	WebElement submitButton;
	
	
	
	public void clickparentGo()
	{
		parentsGo.click();
	}
	
	public void typeDOB(String dateofBirth)
	{
		dobInputBox.sendKeys(dateofBirth);
	}
	
	public void clickSubmit()
	{
		submitButton.click();
	}
	
	public String verifyParentPage()
	{
		String getUrl = driver.getCurrentUrl();
		return getUrl;
	}
}
