package com.dcpl.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;


public class IndexPage extends Action {
	
	//public static WebDriver driver;
	
	@FindBy(xpath = "//a[@class='login']")
	private WebElement signInBtn;
	
	@FindBy(xpath = "//img[@alt='My Store']")
	private WebElement myStoreLogo;
	
	@FindBy(xpath = "//input[@id='search_query_top']")
	private WebElement searchProductBox;
	
	@FindBy(xpath = "//button[@name='submit_search']")
	private WebElement searchBtn;
	
	public IndexPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(),this); 
	}
	
	public LoginPage clickOnSignIn() {
		
		super.fluentWait(getDriver(), signInBtn, 10);
		super.click(getDriver(), signInBtn);
		//Action.click(driver, signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		
		//return Action.isDisplayed(driver, myStoreLogo);
		return super.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String getMyStoreTitle() {
		
		//String myStoreTitle=Action.getTitle(driver);
		String myStoreTitle = super.getTitle(getDriver());
		return myStoreTitle;
	}

	public SearchResultPage searchProduct(String productName) throws Throwable {
		
		//Action.type(searchProductBox,productName);
		//Action.click(driver, searchBtn);
		super.type(searchProductBox, productName);
		super.scrollByVisibilityOfElement(getDriver(), searchBtn);
		super.click(getDriver(), searchBtn);
		Thread.sleep(3000);
		return new SearchResultPage();
		
	}
}
