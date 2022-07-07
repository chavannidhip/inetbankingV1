package com.inetbanking.testcases;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig config = new ReadConfig();
	public String baseURl = config.getApplicationURL();
	public String userName = config.getUserName();
	public String password = config.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	public static String newCustId;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger = Logger.getLogger("Ebanking");
		PropertyConfigurator.configure("log4j.properties");

		// select browser for testing
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//		driver.manage().window().maximize();
			//		driver.manage().deleteAllCookies();
			driver.get(baseURl);
			logger.info("URL is opened.");

		}
		else
			logger.error("No other broswers are setup yet except chrome.");
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
	// this method should be called by a testcases in failure condition
	// and should pass driver instance and testcase name as arguments
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File (System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}

	// Generate Random String and numbers as required --  can be used by any testcases who inherites this class
	public String randomString() {
		return RandomStringUtils.randomAlphabetic(8);
	}
	public String randomNumber() {
		return RandomStringUtils.randomNumeric(4);
	}

	public void cancelAdIfPresent() throws InterruptedException {
		if(driver.getPageSource().contains("robot"))
		{
			// it means no webpage of Guru99 website.. now close the ad
			logger.info("Looking for Ad alert.. did not find Guru99 in page source");
			//driver.switchTo().defaultContent();
			Actions act = new Actions(driver);
			act.moveByOffset(100, 100);
			Thread.sleep(1000);
			act.click().build().perform();
			logger.info("Canceled the google ad");
		}
	}
	
	// Invalid scenario - User defined method for checking presence of Alert
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			logger.info("System Message: "+ driver.switchTo().alert().getText());
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}

}

