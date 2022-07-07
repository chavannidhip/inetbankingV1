package com.inetbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

	WebDriver driver;
	
	public EditCustomerPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[text()='Edit Customer']")
	@CacheLookup
	WebElement lnkEditCustomer;
	
	@FindBy(name="cusid")
	@CacheLookup
	WebElement txtCustomerId;
	
	@FindBy(name="AccSubmit")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickEditCustomer() {
		lnkEditCustomer.click();
	}
	
	public void enterCustId(String custId) {
		txtCustomerId.sendKeys(custId);
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
}
