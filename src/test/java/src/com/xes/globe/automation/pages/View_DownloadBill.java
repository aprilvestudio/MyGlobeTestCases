/**
 * Sep 27, 2018


* XEI
 */
package com.xes.globe.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.xes.globe.automation.base_setup.Test_BaseSetUp;


public class View_DownloadBill extends Test_BaseSetUp {

	WebDriver driver;
	private By ViewAccount = By.id("login-status");
	private By dashboard = By.cssSelector("div[class*=a.ng-scope");
	private By billspayment = By.linkText("Bills & Payment");
	private By viewbill = By.id("vieBillId-0");
	
	
	 
	 public View_DownloadBill(WebDriver driver){
	       this.driver=driver;
	 }
	 
	 
	 public void  ViewBill(){
		 ClickViewAccount ();
	     ClickDashboard();
	     ClickBillsPayment();
	     ClickViewbill();
		 
	 }	 
	 public void ClickViewAccount(){
		 try {
				System.out.println("View Account"); //to verify if method able to pull view account
				driver.findElement(ViewAccount).click();

				}
				catch (NullPointerException e) {
					e.printStackTrace();
					
				}
	     
	 }

	 public void ClickDashboard (){
	 
	 try {
			System.out.println("Click Dashboard"); //to verify if method able to pull the method
			driver.findElement(dashboard).click();

			}
			catch (NullPointerException e) {
				e.printStackTrace();
				
			}
	 }
	 
	public void ClickBillsPayment(){
		
		try {
			System.out.println("Click Bills and payment"); //to verify if  able to pull the method
			driver.findElement(billspayment).click();

			}
			catch (NullPointerException e) {
				e.printStackTrace();
				
			}
	}
		public void ClickViewbill(){
			
			try {
				System.out.println("Click view bill"); //to verify if  able to pull the method
				driver.findElement(viewbill).click();

				}
				catch (NullPointerException e) {
					e.printStackTrace();
					
				}
		}
	}
	

