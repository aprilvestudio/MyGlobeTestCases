/**  This is to set up the webdriver object
 * ${0301218}

* ${xurpas-enterprise}
 */

package com.xes.globe.automation.base_setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Test_BaseSetUp {

	private WebDriver driver;
    static String driverPath = "/chromedriver";

	public WebDriver getDriver() {
		return driver;
	}
    //will open the browser you set up in xml (switch is used for choices)
	private void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			System.out.println("Launching Chrome as browser of choice");
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			System.out.println("Launching Firefox as browser of choice");
			break;
			default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			
			driver = initFirefoxDriver(appURL);
			driver = initChromeDriver(appURL);
		}
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome..");
		System.setProperty("webdriver.firefox.driver", driverPath
				+ "geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to(appURL);
		return driver;
	}

	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}

	
	 // @AfterClass 
	 // public void tearDown() {
		//  driver.quit(); }
	  
	 
}
