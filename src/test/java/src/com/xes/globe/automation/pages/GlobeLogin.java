/**  This is to set up the login page
 * ${0301218}

* ${xurpas-enterprise}
 */


package com.xes.globe.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xes.globe.automation.base_setup.Test_BaseSetUp;


public class GlobeLogin extends  Test_BaseSetUp{

	private WebDriver driver;
	private By headerText = By.cssSelector("a.signin-btn");
	private By username = By.id("capture_signIn_signInEmailAddress");
	private By password = By.id("capture_signIn_currentPassword");
	private By loginBtn = By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/form/div[5]/button");
	public By loginStatus = By.xpath("/html/body/div[1]/header/div[2]/div[1]/div/div[2]/ul[1]/li[1]/a/span[2]");
	private By errorMsgTxt = By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/form/div[2]/div/div");
    

	public GlobeLogin(WebDriver driver){

		this.driver = driver;
	}

	public String getSignInPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
		//return the page title
	}
	
	  public boolean verifySignInPageTitle() { 
		  String expectedTitle = "Sign In"; 
		  return getSignInPageTitle().contains(expectedTitle); 
		  
	}
	 
		
	  public boolean verifySignInPageText() { 
	  WebElement element = driver.findElement(headerText); 
	  String pageText = element.getText(); 
	  String expectedPageText = "Logged In"; 
	  return pageText.contains(expectedPageText); 
	}
	 

	public boolean verifySignIn() throws Exception  {
		enterUserName("abvestudio@gmail.com");
		enterPassword("Th#m1sycr@($!");
		clickLogin();
		Thread.sleep(20000);
		return loginStatus();
	}

	
		public void clickWhenAvailable(By username, int timeout) {
			WebElement element = null;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			element = wait.until(ExpectedConditions.elementToBeClickable(username));
			element.click();
		}
		
		public void enterUserName(String strUserName){
		System.out.println("typing username");
		WebElement usernameElement=driver.findElement(username);
		if(usernameElement.isDisplayed()||usernameElement.isEnabled())
			usernameElement.sendKeys(strUserName);
			else System.out.println("Incorrect username");
		//return new (driver);
	}

	//Set password in password textbox
	public void enterPassword(String strPassword){
		System.out.println("typing password");
		WebElement passwordElement=driver.findElement(password);
		if(passwordElement.isDisplayed()||passwordElement.isEnabled())
			passwordElement.sendKeys(strPassword);
		else System.out.println("Element not found");
	}

	public void clickWhenPresent(By loginBtn, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 20);
		element = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		element.click();
	}
	
	//Click on login button
	public void clickLogin() {
		System.out.println("click Submit");
		WebElement loginBtnElement=driver.findElement(loginBtn);
		if(loginBtnElement.isDisplayed()||loginBtnElement.isEnabled())
			loginBtnElement.click();
		else System.out.println("Element not found");
		/*
		 * driver.findElement(loginBtn).click();
		 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 */
	}
	
	
	public boolean loginStatus(){
		boolean status = true;
		WebElement LoginStatus = driver.findElement(loginStatus);
		if (LoginStatus.isDisplayed() && LoginStatus.isEnabled()){
			status = true;
			System.out.println("Successfully logged in");
			
		}	
		
		return status;
		
	}
		
	
  
	/*public String getErrorMessage() {
		String strErrorMsg = null;
		WebElement errorMsg = driver.findElement(errorMsgTxt);
		if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
			strErrorMsg = errorMsg.getText();
		return strErrorMsg;
	*/
	}

	


