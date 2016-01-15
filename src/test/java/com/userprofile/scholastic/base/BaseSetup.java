package com.userprofile.scholastic.base;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

public class BaseSetup {
	static WebDriver driver;
	static SoftAssert asrt;
	public static final String USERNAME = "Satnam_Singh";
	public static final String ACCESS_KEY = "1487948d-6389-4270-8d57-49267de9daf2";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	public static WebDriver setDriver() {
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "23.0");

		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new java.net.URL(URL), caps);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		
		}
		return driver;
	}
	
	public static void twait() {
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) { // TODO Auto-generated catch block
			
		}
		
	}	
	
	public static SoftAssert initSoftAssert(){
		asrt = new SoftAssert();
		return asrt;
		
	}
}	

// OLD CODE=================================================
    /*public class BaseSetup {
    	
    static WebDriver driver;	
	public static WebDriver startBrowser(String browserName, String appURL) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\SeleniumChromeDriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Launching Chrome browser..");
		}
		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Launching Firefox browser..");

		}

		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	public static void WebDriversetOff() {
		driver.close();
	}

	public static void twait() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  
    } */

