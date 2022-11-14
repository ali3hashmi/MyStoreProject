/**
 * 
 */
package com.dcpl.testcase;

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

/**
 * @author USER
 *
 */
public class HomePageTest extends BaseClass {

	private IndexPage ipage;
	private LoginPage lpage;
	private HomePage hpage;


	public HomePageTest() {
		// TODO Auto-generated constructor stub

		super();
	}

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {

		super.LaunchApp(browser);
	}
	
	@Test(priority = 0,dataProvider = "Credentials",dataProviderClass = DataProviders.class,
			groups = "Smoke")
	public void verifyWishListTest(String username,String password) throws Throwable {

		ipage =new IndexPage();
		lpage=new LoginPage();
		lpage=ipage.clickOnSignIn();
		//hpage=lpage.login(prop.getProperty("username"), prop.getProperty("password"),hpage);
		hpage=lpage.login(username, password, hpage);
		boolean result= hpage.validateMyWishList();
		Assert.assertTrue(result);
		String hurl =hpage.getCurrentHomePageURL();
		System.out.println("Current Home Page URL is : " + hurl);


	}

	@Test(priority = 1,dataProvider = "Credentials",dataProviderClass = DataProviders.class,
			groups = "Smoke")
	public void verifyOrderHistoryTest(String username,String password) throws Throwable {

		ipage =new IndexPage();
		lpage=new LoginPage();
		lpage=ipage.clickOnSignIn();
		//hpage=lpage.login(prop.getProperty("username"), prop.getProperty("password"),hpage);
		hpage=lpage.login(username, password, hpage);				
		boolean result= hpage.validateOrderHistory();
		Assert.assertTrue(result);
		String hurl =hpage.getCurrentHomePageURL();
		System.out.println("Current Home Page URL is : " + hurl);


	}



	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {

		getDriver().quit();
	}
}
