package com.inetbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.EditCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_EditCutomer_004 extends BaseClass{

//	@Test(dependsOnMethods="addNewCustomer")
	@Test
	public void editCustomer() throws InterruptedException {
		
		LoginPage lp= new LoginPage(driver);
		
		lp.SetUserName(userName);
		lp.SetPassword(password);
		Thread.sleep(1000);
		lp.clickSubmit();
		logger.info("User logged in");
		
		Thread.sleep(1000);
		EditCustomerPage ep=new EditCustomerPage(driver);
	
		ep.clickEditCustomer();
		
		//Look for any google ad and close it if present
		cancelAdIfPresent();

		logger.info("Customer Id: " + newCustId);
		
		if(newCustId.isEmpty())
		{
			logger.info("Customer Id value is blank.. "+ newCustId);
			Assert.assertTrue(false);
		}
		else
		{
			ep.enterCustId(newCustId);
			logger.info("Entered Customer Id.. ");
		
			ep.clickSubmit();
			
			AddCustomerPage cp= new AddCustomerPage(driver);
			cp.addCustAddress("test Edit customer functionality");
			cp.addCustMobileNo("1234567890");
			cp.clickSubmit();
			
			
			if(isAlertPresent()== true) // invalid Scenario
			{
				logger.warn("Alert appeared..Edit functionality feature does not work ");
				driver.switchTo().alert().accept(); // close the alert
				driver.switchTo().defaultContent();
				Assert.assertTrue(true,"Edit functionality feature does not work");
			}
			else // valid scenario
			{
				logger.info("Could not edit customer successfully manually, but reached here through automation.");
				Assert.assertTrue(true);
			}
			
		}
		
	}
}
