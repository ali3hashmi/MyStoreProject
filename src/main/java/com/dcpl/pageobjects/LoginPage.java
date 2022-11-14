/**
 * 
 */
package com.dcpl.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;

/**
 * @author USER
 *
 */
public class LoginPage extends Action {

	//Action action = new Action();

	//public static WebDriver driver;
	public LoginPage(){

		PageFactory.initElements(getDriver(), this);


	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement username;

	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement password;

	@FindBy(xpath = "//span[normalize-space()='Sign in']")
	private WebElement signInBtn;

	@FindBy(xpath = "//input[@id='email_create']")
	private WebElement email;

	@FindBy(xpath = "//span[normalize-space()='Create an account']")
	private WebElement emailCreate;

	public HomePage login(String username,String password,HomePage homePage) throws Throwable {

		//action.type(this.username, username);
		//action.type(this.password, password);
		//action.click(driver, signInBtn);
		super.scrollByVisibilityOfElement(getDriver(), this.username);
		super.type(this.username,username);
		super.type(this.password, password);
		super.JSClick(getDriver(), signInBtn);
		Thread.sleep(2000);
		return new HomePage();

	}

	public AddressPage login(String username,String password,AddressPage addressPage) throws Throwable {

		//action.type(this.username, username);
		//action.type(this.password, password);
		//action.click(driver, signInBtn);
		super.scrollByVisibilityOfElement(getDriver(), this.username);
		super.type(this.username,username);
		super.type(this.password, password);
		super.click(getDriver(), signInBtn);
		Thread.sleep(2000);
		return new AddressPage();

	}

	public AccountCreationPage createNewAccount(String email) throws Throwable {

		//action.type(this.email, email);
		//action.click(driver, emailCreate);
		super.type(this.email, email);
		super.click(getDriver(), emailCreate);
		return new AccountCreationPage();
	}

}
