/**
 * 
 */
package com.dcpl.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dcpl.base.BaseClass;
import com.dcpl.dataprovider.DataProviders;
import com.dcpl.pageobjects.AccountCreationPage;
import com.dcpl.pageobjects.HomePage;
import com.dcpl.pageobjects.IndexPage;
import com.dcpl.pageobjects.LoginPage;
import com.dcpl.utility.Log;

/**
 * @author USER
 *
 */
public class AccountCreationPageTest extends BaseClass{

	private IndexPage ipage;
	private LoginPage lpage;
	private AccountCreationPage acpage;
	private HomePage hpage;

	public AccountCreationPageTest() {
		// TODO Auto-generated constructor stub

		super();
	}

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {

		super.LaunchApp(browser);
	}

	@Test(priority = 0, dataProvider = "email",dataProviderClass = DataProviders.class,groups = "Sanity")
	public void verifyCreateAccountPageTest(String email) throws Throwable {
		Log.startTestCase("verifyCreateAccountPageTest");
		ipage= new IndexPage();
		lpage=ipage.clickOnSignIn();
		acpage=lpage.createNewAccount(email);
		boolean result=acpage.validateAcountCreatePage();
		Assert.assertTrue(result);
		Log.endTestCase("verifyCreateAccountPageTest");
	}
	
	@Test(priority = 1,  dataProvider = "newAcountDetailsData",dataProviderClass = DataProviders.class,groups = "Regression")
	public void createAccountTest(HashMap<String,String> hashMapValue) throws Throwable {
		Log.startTestCase("createAccountTest");
		ipage= new IndexPage();
		lpage=ipage.clickOnSignIn();
		acpage=lpage.createNewAccount(hashMapValue.get("Email"));
		acpage.createAccount(
				hashMapValue.get("Gender"),
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year"),
				hashMapValue.get("Company"),
				hashMapValue.get("Address"),
				hashMapValue.get("City"),
				hashMapValue.get("State"),
				hashMapValue.get("Zipcode"),
				hashMapValue.get("Country"),
				hashMapValue.get("MobilePhone"));
		hpage=acpage.validateRegistration();
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", hpage.getCurrentURL(getDriver()));
		Log.endTestCase("createAccountTest");
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {

		getDriver().quit();
	}

}
