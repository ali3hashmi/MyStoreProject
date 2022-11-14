/**
 * 
 */
package com.dcpl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.dcpl.base.BaseClass;

/**
 * @author USER
 *
 */
public class OrderConfirmationPage extends BaseClass{

	public OrderConfirmationPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
		
		
	}
	
	@FindBy(xpath = "//strong[normalize-space()='Your order on My Store is complete.']")
	private WebElement orderConfirmation;
	
	public String verifyOrderConfirmation() {
		
		String orderConfirmMsg=orderConfirmation.getText();
		return orderConfirmMsg;
		
	}
}
