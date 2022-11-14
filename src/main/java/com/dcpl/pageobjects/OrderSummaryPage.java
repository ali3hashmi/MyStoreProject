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
public class OrderSummaryPage extends Action {

	public OrderSummaryPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//span[normalize-space()='I confirm my order']")
	private WebElement confirmOrder;
	
	public OrderConfirmationPage clickOnConfirmOrder() {
		
		super.click(getDriver(), confirmOrder);
		return new OrderConfirmationPage();
	}
}
