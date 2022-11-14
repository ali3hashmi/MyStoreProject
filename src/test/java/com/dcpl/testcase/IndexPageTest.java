package com.dcpl.testcase;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dcpl.base.BaseClass;
import com.dcpl.pageobjects.IndexPage;


/**
 * @author USER
 *
 */
public class IndexPageTest extends BaseClass {


	private IndexPage indexpage =new IndexPage();

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {

		super.LaunchApp(browser);
	}


	@Test(priority = 0,groups = "Smoke")
	public void verifyLogo() {
		//indexpage =new IndexPage();
		boolean result =indexpage.validateLogo();
		Assert.assertTrue(result);

	}

	@Test(priority = 1,groups = "Smoke")
	public void verifyStoreTitle() {

		String actualTitle = indexpage.getMyStoreTitle();
		Assert.assertEquals(actualTitle, "My Store");
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {

		getDriver().quit();
	}

}

