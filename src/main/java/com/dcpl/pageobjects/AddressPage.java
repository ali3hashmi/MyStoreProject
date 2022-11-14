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
public class AddressPage extends Action {

	public AddressPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOut;
	
	public ShippingPage clickOnCheckOut() {
		
		super.click(getDriver(), proceedToCheckOut);
		return new ShippingPage();
	}
}
