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
import com.dcpl.pageobjects.AddToCartPage;
import com.dcpl.pageobjects.AddressPage;
import com.dcpl.pageobjects.IndexPage;
import com.dcpl.pageobjects.LoginPage;
import com.dcpl.pageobjects.OrderConfirmationPage;
import com.dcpl.pageobjects.OrderPage;
import com.dcpl.pageobjects.OrderSummaryPage;
import com.dcpl.pageobjects.PaymentPage;
import com.dcpl.pageobjects.SearchResultPage;
import com.dcpl.pageobjects.ShippingPage;
import com.dcpl.utility.Log;

/**
 * @author USER
 *
 */
public class EndToEndTest extends BaseClass{

	IndexPage ipage;
	SearchResultPage srpage;
	AddToCartPage atcpage;
	OrderPage opage;
	LoginPage lpage;
	AddressPage apage;
	ShippingPage spage;
	PaymentPage ppage;
	OrderSummaryPage ospage;
	OrderConfirmationPage ocpage;

	/**
	 * 
	 */
	public EndToEndTest() {
		// TODO Auto-generated constructor stub

		super();
	}

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {

		super.LaunchApp(browser);
	}

	@Test(groups = "Regression")
	public void endToEndTest() throws Throwable {
		Log.startTestCase("endToEndTest");
		ipage = new IndexPage();
		srpage = new SearchResultPage();
		atcpage = new AddToCartPage();
		opage = new OrderPage();
		lpage = new LoginPage();
		apage=new AddressPage();
		spage=new ShippingPage();
		ospage =new OrderSummaryPage();
		ocpage =new OrderConfirmationPage();

		srpage=ipage.searchProduct("t-shirt");
		atcpage=srpage.clickOnProduct();
		atcpage.enterQuantity("2");
		atcpage.enterSize("M");
		atcpage.clickOnAddToCart();
		boolean result= atcpage.validateAddToCartMsg();
		Assert.assertTrue(result);
		opage=atcpage.clickOnProceedToCheckOut();
		lpage=opage.clickOnCheckOut();
		apage=lpage.login(super.prop.getProperty("username"), super.prop.getProperty("password"),apage);
		spage=apage.clickOnCheckOut();
		spage.verifyTerms();
		ppage=spage.clickOnCheckOut();
		ospage=ppage.clickOnPayByBank();
		ospage.clickOnConfirmOrder();
		String actorderconfirmsg = ocpage.verifyOrderConfirmation();
		String expectedmsg="Your order on My Store is complete.";
		Assert.assertEquals(actorderconfirmsg, expectedmsg);
		Log.endTestCase("endToEndTest");
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {

		getDriver().quit();
	}
}
