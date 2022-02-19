package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	private WebDriver driver;
	
	//1. By Locators
	private By emailId = By.id("email");
	private By passWord = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");
	
	//2. Constructors
	public loginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page Actions
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void enterPassWord(String password) {
		driver.findElement(passWord).sendKeys(password);
	}
	
	public AccountPage clickOnLogin() {
		driver.findElement(signInButton).click();
		return new AccountPage(driver);
	}
	
	public AccountPage dologin(String un, String pwd) {
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(passWord).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new AccountPage(driver);
		
	}

}
