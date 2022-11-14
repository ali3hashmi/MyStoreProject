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
import com.dcpl.pageobjects.AddToCartPage;
import com.dcpl.pageobjects.IndexPage;
import com.dcpl.pageobjects.SearchResultPage;
import com.dcpl.utility.Log;

/**
 * @author USER
 *
 */
public class AddToCartPageTest extends BaseClass{

	private AddToCartPage atcpage;
	private IndexPage ipage;
	private SearchResultPage srpage;

	public AddToCartPageTest() {
		// TODO Auto-generated constructor stub

		super();
	}

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {

		super.LaunchApp(browser);
	}

	@Test(dataProvider = "getProduct",dataProviderClass = DataProviders.class,
			groups = {"Regression","Sanity"})
	public void addToCartTest(String productName,String quantity,String size) throws Throwable {

		Log.startTestCase("AddToCartTest");
		ipage=new IndexPage();
		srpage=new SearchResultPage();
		atcpage = new AddToCartPage();

		srpage=ipage.searchProduct(productName);
		atcpage=srpage.clickOnProduct();
		atcpage.enterQuantity(quantity);
		atcpage.enterSize(size);
		atcpage.clickOnAddToCart();
		boolean result= atcpage.validateAddToCartMsg();
		Assert.assertTrue(result);
		atcpage.clickOnProceedToCheckOut();
		Log.endTestCase("AddToCartTest");



	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {

		getDriver().quit();
	}


}
