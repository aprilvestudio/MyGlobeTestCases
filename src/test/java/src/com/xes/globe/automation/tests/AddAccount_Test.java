/**
 * @author Xurpas-Enterprise
 * test page for Add Account
 */
package com.xes.globe.automation.tests;
//import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xes.globe.automation.base_setup.Test_BaseSetUp;
import com.xes.globe.automation.pages.BasePage;
import com.xes.globe.automation.pages.AddAccount;
import com.xes.globe.automation.pages.GlobeLogin;

public class AddAccount_Test extends Test_BaseSetUp {
	private WebDriver driver; 
	private GlobeLogin logInPage;
    private BasePage basePage;
    private AddAccount AddAccPage;
    
    @BeforeClass
    public void setUp() {
    	driver = getDriver();
    	
    }
    
    @Test 
    public void AddAccount() throws Exception {
    	System.out.println("Logging in...");
    	basePage = new BasePage (driver);
    	logInPage = basePage.clickSignInBtn();
    	logInPage.verifySignIn();
    	   	
    	System.out.println("Adding Account Number...");
    	try {
        AddAccPage = new AddAccount (driver);
    	AddAccPage.addPostpaidAccount();
    	}
    	catch (NullPointerException e){ 
    		e.printStackTrace();
    	}
    }
   
}
