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
public class ShippingPage extends Action {

	
	public ShippingPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@id='cgv']")
	private WebElement terms;
	
	@FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOut;
	
	public void verifyTerms() {
		
		super.click(getDriver(), terms);
	}
	public PaymentPage clickOnCheckOut() {
		
		super.click(getDriver(), proceedToCheckOut);
		return new PaymentPage();
	}
	
}
