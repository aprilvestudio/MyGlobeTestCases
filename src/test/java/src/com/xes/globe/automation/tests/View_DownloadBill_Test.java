/**
 * Sep 27, 2018

* XEI
 */
package com.xes.globe.automation.tests;
import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xes.globe.automation.base_setup.Test_BaseSetUp;
import com.xes.globe.automation.pages.BasePage;
import com.xes.globe.automation.pages.GlobeLogin;
import com.xes.globe.automation.pages.View_DownloadBill;

public class View_DownloadBill_Test extends Test_BaseSetUp {
	private WebDriver driver;
	private GlobeLogin logInPage;
    private BasePage basePage;
    private View_DownloadBill viewbillpage;
    
    
    @BeforeClass
    public void setUp() {
    	driver = getDriver();
    	
    }
    
    @Test 
    public void ViewBill() throws Exception {
    	System.out.println("Logging in...");
    	basePage = new BasePage (driver);
    	logInPage = basePage.clickSignInBtn();
    	logInPage.verifySignIn();
    	System.out.println("logging in....");
    	
    	try {
        viewbillpage = new View_DownloadBill (driver);
    	viewbillpage.ViewBill();
    	}
    	catch (NullPointerException e){ 
    		e.printStackTrace();
    	}
    	
    }	   	

}
