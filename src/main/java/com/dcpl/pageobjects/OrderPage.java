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
public class OrderPage extends Action {
	
	public OrderPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}

	//@FindBy(xpath = "xpath=\"//td[@class='cart_unit']/span/span")
	@FindBy(className = "price")
	private WebElement unitPrice;
	
	//@FindBy(xpath="//span[@id='total_price']")
	@FindBy(id="total_price")
	private WebElement totalPrice;
	
	@FindBy(xpath = "//td[@id='total_price_container']")
	private WebElement grandTotal;
	
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOut;
	
	public double getUnitPrice() {
		
		String uPrice = unitPrice.getText();
		//remove dollar symbol or remove all the special character
		String unit = uPrice.replaceAll("[^a-zA-Z0-9]", "");
		
		double finalUnitPrice= Double.parseDouble(unit);
		
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		
		String gtPrice = totalPrice.getText();
		String total = gtPrice.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice = Double.parseDouble(total);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut() {
		
		super.click(getDriver(), proceedToCheckOut);
		return new LoginPage();
	}
}
