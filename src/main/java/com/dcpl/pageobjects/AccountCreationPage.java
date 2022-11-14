/**
 * 
 */
package com.dcpl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;

/**
 * @author USER
 *
 */
public class AccountCreationPage extends Action{

	public AccountCreationPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//h1[text()='Create an account']")
	private WebElement formTitle;
	
	@FindBy(id = "uniform-id_gender1")
	private WebElement mr;
	
	@FindBy(id = "id_gender2")
	private WebElement mrs;

	@FindBy(name = "customer_firstname")
	private WebElement firstName;

	@FindBy(name = "customer_lastname")
	private WebElement lastName;

	@FindBy(name = "passwd")
	private WebElement passWord;

	@FindBy(name = "days")
	private WebElement days;

	@FindBy(name = "months")
	private WebElement months;

	@FindBy(name = "years")
	private WebElement years;

	@FindBy(name = "firstname")
	private WebElement customerNirstName;

	@FindBy(name = "lastname")
	private WebElement customerLastName;

	@FindBy(name = "company")
	private WebElement companyName;

	@FindBy(name = "address1")
	private WebElement address;

	@FindBy(name = "city")
	private WebElement city;

	@FindBy(name = "id_state")
	private WebElement state;

	@FindBy(name = "postcode")
	private WebElement postCode;

	@FindBy(name = "id_country")
	private WebElement country;

	@FindBy(name = "phone")
	private WebElement phone;

	@FindBy(name = "phone_mobile")
	private WebElement mobile;

	@FindBy(name = "alias")
	private WebElement ref;

	@FindBy(name = "submitAccount")
	private WebElement registerBtn;
	
	
	
	public void createAccount(String gender,String fName, 
			String lName, 
			String pswd, 
			String day, 
			String month, 
			String year,
			String comPany, 
			String addr, 
			String cityString, 
			String stateName, 
			String zip, 
			String countryName,
			String mobilePhone) throws Throwable {
		
		if(gender.equalsIgnoreCase("Mr")) {
			super.click(getDriver(), mr);
		} else {
			super.click(getDriver(), mrs);
		}
		
		super.type(firstName, fName);
		super.type(lastName, lName);
		super.type(passWord, pswd);
		super.selectByValue(days, day);
		super.selectByValue(months, month);
		super.selectByValue(years, year);
		super.type(companyName, comPany);
		super.type(address, addr);
		super.type(city, cityString);
		super.selectByVisibleText(stateName, state);
		super.type(postCode, zip);
		super.selectByVisibleText(countryName, country);
		super.type(mobile, mobilePhone);
	}
	
	public HomePage validateRegistration() throws Throwable {
		//registerBtn.click();
		super.click(getDriver(), registerBtn);
		return new HomePage();
	}
	
	public boolean validateAcountCreatePage() throws Throwable {
		 return super.isDisplayed(getDriver(), formTitle);
	}
}
