/**
 * 
 */
package com.dcpl.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;

/**
 * @author USER
 *
 */
public class HomePage extends Action {
	
	//public static WebDriver driver;

	public HomePage() {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//span[normalize-space()='Order history and details']")
	private WebElement orderHistory;

	@FindBy(xpath = "//span[normalize-space()='My wishlists']")
	private WebElement wishList;


	public boolean validateOrderHistory() {

		return super.isDisplayed(getDriver(), orderHistory);

	}

	public boolean validateMyWishList() {

		return super.isDisplayed(getDriver(), wishList);
	}
	
	public String getCurrentHomePageURL() {
		
		//String homepageurl =getDriver().getCurrentUrl();
		String homepageurl = super.getCurrentURL(getDriver());
		return homepageurl;
		
	}



}
