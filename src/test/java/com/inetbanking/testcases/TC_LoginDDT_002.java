package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider= "loginData")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.SetUserName(user);
		logger.info("Username provided");
		lp.SetPassword(pwd);
		logger.info("Password provided");
		lp.clickSubmit();
		logger.info("clicked on Login Button");

		Thread.sleep(2000);
		if(isAlertPresent()== true) // invalid Scenario
		{
			driver.switchTo().alert().accept(); // close the alert
			driver.switchTo().defaultContent();
			logger.warn("Login failed");
			Assert.assertTrue(false);
			
		}
		else // valid scenario
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
			Thread.sleep(2000);
			logger.info("System Message: "+ driver.switchTo().alert().getText());
			driver.switchTo().alert().accept(); // close logout alert
			driver.switchTo().defaultContent();
		}

	}


	@DataProvider(name="loginData")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+ "/src/test/java/com/inetbanking/testData/LoginData.xlsx";

		int rows = XLUtils.getRowCount(path, "Sheet1");
		int cols = XLUtils.getCellCount(path, "Sheet1", 0);

		String loginData[][] = new String[rows][cols];

		for(int i=1;i<=rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				// array will start from 0
				// excel data will start from 1st row not 0
				loginData[i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
}
