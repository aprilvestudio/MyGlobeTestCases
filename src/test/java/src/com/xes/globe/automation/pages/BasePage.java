/**  This is for signInbutton object
 * ${0301218}

* ${xurpas-enterprise}
 */

package com.xes.globe.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	private By signInButton = By.cssSelector("a.signin-btn");

	//Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
    //to wait for the element before clicking
	public void clickWhenReady(By signInButton, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
		element.click();
	}
	//main method for login button. The if/else condition for login button
	public GlobeLogin clickSignInBtn() {
		System.out.println("clicking on sign in button");
		WebElement signInBtnElement=driver.findElement(signInButton);
		if(signInBtnElement.isDisplayed()||signInBtnElement.isEnabled())
			signInBtnElement.click();
		else System.out.println("Element not found");
		return new GlobeLogin(driver);
	}

	public String getPageTitle(){
		String title = driver.getTitle();
		return title;
	}

	public boolean verifyBasePageTitle() {
		String expectedPageTitle="Globe";
		return getPageTitle().contains(expectedPageTitle);
	}
}
