package com.adminzonrender.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
	WebDriver localdriver;
	public LoginPage(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	@FindBy(name = "username") // uid
	WebElement txtUserName;
	@FindBy(name = "password") // password
	WebElement txtPassword;
	@FindBy(xpath = "//button[text()='LOGIN']")
	WebElement btnLogin;
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void clickLogin() {
		btnLogin.click();
	}
}