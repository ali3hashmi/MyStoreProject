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
import com.dcpl.pageobjects.IndexPage;
import com.dcpl.pageobjects.SearchResultPage;

/**
 * @author USER  BaseClass is used to load the config file and Initialize 
 * WebDriver
 *
 */
public class SearchResultPageTest extends BaseClass {

	IndexPage ipage;
	SearchResultPage srpage;


	public SearchResultPageTest() {
		// TODO Auto-generated constructor stub

		super();
	}

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {

		super.LaunchApp(browser);
	}


	@Test(dataProvider = "searchProduct",dataProviderClass = DataProviders.class,groups = "Smoke")
	public void productAvailabilityTest(String productName) throws Throwable {

		ipage = new IndexPage();
		srpage = new SearchResultPage();
		srpage=ipage.searchProduct(productName);
		boolean result = srpage.isProductAvailable();
		Assert.assertTrue(result);

	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {

		getDriver().quit();
	}
}
