package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	
	@Test
	public void loginTest() throws IOException 
	{
		LoginPage lp= new LoginPage(driver);
		lp.SetUserName(userName);
		logger.info("Entered Username");
		lp.SetPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Verification is successful.");
		}
		else
		{
			logger.error("verification failed");
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		}
	}
	
}
