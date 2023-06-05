package com.adminz.testcases;

import org.testng.annotations.Test;

import com.adminzonrender.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void loginTest() {

		Logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		Logger.info("Entered username");
		lp.setPassword(password);
		Logger.info("Entered password");
		lp.clickLogin();
		if (driver.getTitle().equals("B2C ADMIN DASHBOARD")) {
			org.testng.Assert.assertTrue(true);
			Logger.info("Test passed");
		} else {
			org.testng.Assert.assertTrue(false);
			Logger.info("Test failed");
		}
	}
}
