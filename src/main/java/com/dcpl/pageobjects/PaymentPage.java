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
public class PaymentPage extends Action {

	public PaymentPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	private WebElement payByBankWire;
	
	@FindBy(xpath = "//a[@title='Pay by check.']")
	private WebElement payByCheque;
	
	public OrderSummaryPage clickOnPayByBank() {
		
		super.click(getDriver(), payByBankWire);
		return new OrderSummaryPage();
	}
	
	
}
