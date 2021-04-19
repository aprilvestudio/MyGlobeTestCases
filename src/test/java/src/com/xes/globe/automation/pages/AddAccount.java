package com.xes.globe.automation.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.xes.globe.automation.base_setup.Test_BaseSetUp;


public class AddAccount extends Test_BaseSetUp{
	 WebDriver driver;
	 private By AddAcc = By.xpath("/html/body/base-container/div/main/div/div/div/div/div[2]/hero-banner/div/div/div/div[2]/a/span");
	 private By acctno = By.name("inputNumber");
	 private By Next = By.cssSelector("button[title ='Next']");
	 //use if/else for validation/negative scenario
	 
	 public AddAccount(WebDriver driver){
	       this.driver=driver;
	       PageFactory.initElements(driver, this);
	     }
		 
		 public void addPostpaidAccount(){
			    clickViewAccount ();
			    clickAddAccount();
			    postpaidNumber("09175880013");
			    clickButton ();
		 }
		 
		 public void clickViewAccount(){
	
				System.out.println("Clicking GlobeOne Menu");
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
				WebElement LoggedInMenu = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/div/div[2]/ul[1]/li[1]/a/span[2]"));
				Actions action = new Actions(driver);
				action.moveToElement(LoggedInMenu).perform();
				
				//Go to Globe One option
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
				WebElement GlobeOne = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/div/div[2]/ul[1]/li[1]/div/div/ul/li[1]/a"));
				Actions action2 = new Actions(driver);
                action2.moveToElement(GlobeOne).click().build().perform();
                
		 }

		 public void clickAddAccount (){
			 driver.findElement(AddAcc).click();
			 
		 }
		 
		 public void postpaidNumber (String strPostpaidNumber){

				 System.out.println("Adding Number");
			 driver.findElement(acctno).sendKeys(strPostpaidNumber);
		
	 }
         public void clickButton (){
        	 WebElement buttonElement=driver.findElement(Next);
     		if(buttonElement.isDisplayed()||buttonElement.isEnabled())
     			buttonElement.click();
        	
      }
         
}

