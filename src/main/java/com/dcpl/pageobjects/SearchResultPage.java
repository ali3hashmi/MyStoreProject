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
public class SearchResultPage extends Action{

	public SearchResultPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
	private WebElement productResult;
	
	public boolean isProductAvailable() {
		
		return super.isDisplayed(getDriver(), productResult);
		
		
	}
	public AddToCartPage clickOnProduct() {
		
		super.click(getDriver(), productResult);
		return new AddToCartPage();
	}
	
}
