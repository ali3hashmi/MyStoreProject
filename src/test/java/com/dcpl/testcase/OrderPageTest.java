/**
 * 
 */
package com.dcpl.testcase;

import org.apache.poi.ss.formula.functions.Index;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dcpl.base.BaseClass;
import com.dcpl.dataprovider.DataProviders;
import com.dcpl.pageobjects.AddToCartPage;
import com.dcpl.pageobjects.IndexPage;
import com.dcpl.pageobjects.OrderPage;
import com.dcpl.pageobjects.SearchResultPage;

/**
 * @author USER
 *
 */
public class OrderPageTest extends BaseClass {

	private OrderPage opage;
	private IndexPage ipage;
	private SearchResultPage srpage;
	private AddToCartPage atcpage;

	/**
	 * 
	 */
	public OrderPageTest() {
		// TODO Auto-generated constructor stub

		super();
	}
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {

		super.LaunchApp(browser);
	}

	@Test(dataProvider = "getProduct",dataProviderClass = DataProviders.class,groups = "Regression")
	public void verifyTotalPrice() throws Throwable  {

		ipage=new IndexPage();
		srpage = new SearchResultPage();
		atcpage = new AddToCartPage();
		opage = new OrderPage();

		srpage=ipage.searchProduct("t-shirt");
		atcpage=srpage.clickOnProduct();
		atcpage.enterQuantity("2");
		atcpage.enterSize("M");
		atcpage.clickOnAddToCart();
		boolean result= atcpage.validateAddToCartMsg();
		Assert.assertTrue(result);
		opage=atcpage.clickOnProceedToCheckOut();
		Double unitprice = opage.getUnitPrice();
		Double totalprice=opage.getTotalPrice();
		Double expectedTotalPrice = (unitprice*2)+2;
		Assert.assertEquals(totalprice, expectedTotalPrice);


	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {

		getDriver().quit();
	}
}
