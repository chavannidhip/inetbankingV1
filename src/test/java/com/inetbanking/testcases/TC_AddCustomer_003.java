package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp= new LoginPage(driver);
	
		lp.SetUserName(userName);
		lp.SetPassword(password);
		Thread.sleep(1000);
		lp.clickSubmit();
		logger.info("User logged in");
		
		Thread.sleep(1000);
		AddCustomerPage cp= new AddCustomerPage(driver);
		cp.clickAddNewCustomer();
		
		//Look for any google ad and close it if present
		cancelAdIfPresent();

		logger.info("Providing new Customer details");
		
		cp.addNewCustomerName("Nidhi");
		cp.setGender("female");
		cp.addCustDOB("10", "07","1984");
		cp.addCustAddress("Cranston Way");
		cp.addCustCity("Dublin");
		cp.addCustState("OH"); 
		cp.addCustEmail(randomString() + "@gmail.com");	// Need unique email address
		cp.addCustMobileNo("9343463876");
		cp.addCustpinNo(430175);
		cp.addCustPassword("abcdefgh");
		Thread.sleep(1000);
		cp.clickSubmit();
		Thread.sleep(1000);
		logger.info("submitted new details.. Validation starts here..");
		
		if(driver.getPageSource().contains("Customer Registered Successfully!!!")) {
			newCustId = cp.getCustId();
			logger.info("Validation successful.. " + newCustId);
		//	captureScreen(driver, "New Customer details" + randomNumber());
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "TC_AddCustomer_003 - addNewCustomer");
			logger.info("Validation Unsuccessful.. No new Customer added");
			newCustId = "";
			Assert.assertTrue(false);
		}		
	}
	
}
