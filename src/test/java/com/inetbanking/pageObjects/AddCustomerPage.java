package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH, using="//a[text()='New Customer']")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.NAME, using="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.NAME, using="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how = How.ID_OR_NAME, using="dob")
	@CacheLookup
	WebElement txtDob;
		
	@FindBy(how = How.NAME, using="addr")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(how=How.NAME, using="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how = How.NAME, using="state")
	@CacheLookup
	WebElement txtState;

	@FindBy(how = How.NAME, using="pinno")
	@CacheLookup
	WebElement txtPinNo;

	@FindBy(how = How.NAME, using="telephoneno")
	@CacheLookup
	WebElement txtMobileNo;

	@FindBy(how = How.NAME, using="emailid")
	@CacheLookup
	WebElement txtEmailId;

	@FindBy(how = How.NAME, using="password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(how = How.NAME, using="sub")
	@CacheLookup
	WebElement btnSubmit;

	@FindBy(how = How.NAME, using="res")
	@CacheLookup
	WebElement btnReset;

	public void clickAddNewCustomer()	{
		lnkAddNewCustomer.click();
	}
	
	public void addNewCustomerName(String name)	{
		txtCustomerName.sendKeys(name);
	}
		public void setGender(String gender)	{
		rdGender.click();
	}

	public void addCustDOB(String dd, String mm, String yy)	{
		txtDob.sendKeys(dd);
		txtDob.sendKeys(mm);
		txtDob.sendKeys(yy);
	}

	public void addCustAddress(String address){
		txtAddress.sendKeys(address);
	}
	
	public void addCustCity(String city){
		txtCity.sendKeys(city);
	}

	public void addCustState(String state){
		txtState.sendKeys(state);
	}

	public void addCustpinNo(int pinNo){
		txtPinNo.sendKeys(String.valueOf(pinNo));
	}

	public void addCustMobileNo(String cmob){
		txtMobileNo.sendKeys(cmob);
	}

	public void addCustEmail(String email){
		txtEmailId.sendKeys(email);
	}

	public void addCustPassword(String pwd){
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit(){
		btnSubmit.click();
	}
	
}
