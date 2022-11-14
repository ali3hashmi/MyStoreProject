/**
 * 
 */
package com.dcpl.testcase;

import java.lang.reflect.InvocationTargetException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dcpl.base.BaseClass;
import com.dcpl.dataprovider.DataProviders;
import com.dcpl.pageobjects.HomePage;
import com.dcpl.pageobjects.IndexPage;
import com.dcpl.pageobjects.LoginPage;
import com.dcpl.utility.Log;

/**
 * @author USER
 *
 */
public class LoginPageTest extends BaseClass{
	
	private LoginPage lpage=new LoginPage();
	
	private IndexPage indexpage;
	private HomePage hpage;
	
	public LoginPageTest() {
		// TODO Auto-generated constructor stub
		
		super();
	}
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {

		super.LaunchApp(browser);
	}
	
	@Test(groups = {"Sanity","Smoke"}, dataProvider = "Credentials",dataProviderClass = DataProviders.class)
	public void loginTest(String username,String password){
		
		Log.startTestCase("Login Test");
		indexpage = new IndexPage();
		hpage=new HomePage();
		Log.info("user is going to click on signin button");
		lpage=indexpage.clickOnSignIn();
		try {
			//storing into homepage object
			Log.info("enter username and password");
			//reading data from configuration file
			//hpage=lpage.login(prop.getProperty("username"),prop.getProperty("password"),hpage);
			hpage =lpage.login(username, password, hpage);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualhomepageurl= hpage.getCurrentHomePageURL();
		String expectedhomepageurl="http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verifying user able to login");
		Assert.assertEquals(actualhomepageurl, expectedhomepageurl);
		Log.info("Login Success");
		Log.endTestCase("Login Test");
		
	}
	
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {

		getDriver().quit();
	}
}
