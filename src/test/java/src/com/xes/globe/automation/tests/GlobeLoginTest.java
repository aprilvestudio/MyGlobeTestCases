/**  This is to call the methods we did on login page. We will execute the login function here.
 * ${0301218}

* ${xurpas-enterprise}
 */

package com.xes.globe.automation.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xes.globe.automation.base_setup.Test_BaseSetUp;
import com.xes.globe.automation.pages.BasePage;
import com.xes.globe.automation.pages.GlobeLogin;


public class GlobeLoginTest extends Test_BaseSetUp {
		
	    WebDriver driver; 
	    private GlobeLogin logInPage;
	    private BasePage basePage;


		@BeforeClass
		public void setUp (){
		driver = getDriver();
  
		}
	   
		@SuppressWarnings("unlikely-arg-type")
		@Test
		public void verifySignInFunction() throws Exception {
		   try {
			System.out.println("Sign In functionality details...");
			basePage = new BasePage(driver);
			logInPage = basePage.clickSignInBtn(); // to call the click sign in button method
			logInPage.verifySignIn();// to call the verify sign in method
			//logInPage.getErrorMessage();
		   }
		   catch (TimeoutException e){ 
			  System.out.println("Page:" + logInPage + "did not load within 40 seconds" );
			   
		   }
			//Assert.assertTrue(logInPage.verifySignIn(), "The username and password is invalid. Plsease try again. ");
		     // Assert is to report a failure in testNG
		   // Assert.assertTrue(logInPage.equals("errorMsgTxt : + The username and password is invalid. Please try again. "));

		}

	}
