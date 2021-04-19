/**  This is to call the methods we did on base page. We will verfiy the title page. 
 * ${0301218}

* ${xurpas-enterprise}
 */


package com.xes.globe.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xes.globe.automation.pages.BasePage;
import com.xes.globe.automation.base_setup.Test_BaseSetUp;

public class BasePageTest extends Test_BaseSetUp {

	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}

	@Test
	public void verifyHomePage() {
		System.out.println("Home page test...");
		BasePage basePage = new BasePage(driver);
		Assert.assertTrue(basePage.verifyBasePageTitle(), "Home page title doesn't match");
	}

}
