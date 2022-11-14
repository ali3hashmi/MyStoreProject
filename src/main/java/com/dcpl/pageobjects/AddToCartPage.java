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
public class AddToCartPage extends Action{

	public AddToCartPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@id='quantity_wanted']")
	private WebElement productQuantity;
	
	@FindBy(name = "group_1")
	private WebElement productSize;
	
	@FindBy(xpath = "//span[normalize-space()='Add to cart']")
	private WebElement addToCart;
	
	@FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
	private WebElement validateAddToCart;
	
	@FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
	private WebElement checkOut;
	
	
	public void enterQuantity(String productQuantity) {
		
		super.type(this.productQuantity, productQuantity);
		
	}
	
	public void enterSize(String productSize) {
		
		super.selectByVisibleText(productSize, this.productSize);
	}
	
	public void clickOnAddToCart() {
		
		super.click(getDriver(), addToCart);
		
	}
	
	public boolean validateAddToCartMsg() {
		super.fluentWait(getDriver(), validateAddToCart, 10);
		return super.isDisplayed(getDriver(), validateAddToCart);
		
	}
	
	public OrderPage clickOnProceedToCheckOut() {
		super.fluentWait(getDriver(), checkOut, 10);
		super.JSClick(getDriver(), checkOut);
		
		return new OrderPage();
		
	}
	
	
}
