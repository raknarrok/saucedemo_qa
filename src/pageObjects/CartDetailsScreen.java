package pageObjects;

//Import Libraries
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.By;

public class CartDetailsScreen {
	
	/* *****************
	 * Global Class Variables Definition
	 * *****************
	 */
	
	private WebDriver objDriver;
	private boolean blRetrieveValue;
	
	/* *****************
	 * Page Class Elements
	 * *****************
	 */
	
	// **** TEXT ELEMENTS ****
	// Cart Detail Title
	By txtHeaderCart = By.xpath("//span[@class='title']");
	
	// Quantity Text
	By txtQty = By.xpath("//div[@class='cart_quantity_label']");
	
	// Description Text
	By txtDescription = By.xpath("//div[@class='cart_desc_label']");
	
	// Backpack Description
	By txtBackpack = By.xpath("//a[@id='item_4_title_link']");
	
	// Back Light Description
	By txtBikeLight = By.xpath("//a[@id='item_0_title_link']");
	
	// Onesie Description
	By txtOnesie = By.xpath("//a[@id='item_2_title_link']");
	
	// **** BUTON ELEMENTS ****
	
	// Header Cart Icon - Works for all screens with that icon
	By btnCartIcon = By.xpath("//a[@class='shopping_cart_link']");
	
	// Checkout
	By btnCheckOut = By.id("checkout");
	
	
	
	// Constructor Creation
	public CartDetailsScreen(WebDriver driver) {
		this.objDriver = driver;
	}
	
	/*
	 * **** 
	 * METHODS
	 * ****
	 */
	
	/**
	 * @summary Click on CartIcon Button
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return n/a
	 * */
	public void clickCartIcon() {
		objDriver.findElement(btnCartIcon).click();
	}
	
	/**
	 * @summary Click on CheckOut Button
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return n/a
	 * */
	public void clickCheckOut() {
		objDriver.findElement(btnCheckOut).click();
	}
	
	/**
	 * @summary Validate Cart Details Title is displayed
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return boolean
	 * */
	public boolean isYourCartDisplayed() {
		return objDriver.findElement(txtHeaderCart).isDisplayed();
	}
	/**
	 * @summary Validate Cart Details Item Backpack is displayed
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return boolean
	 * */
	public boolean isBackPackTextDisplayed() {		
		return objDriver.findElement(txtBackpack).isDisplayed();
	}
	
	/**
	 * @summary Validate Cart Details Item is Bike Light displayed
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return boolean
	 * */
	public boolean isBikeLightTextDisplayed() {		
		return objDriver.findElement(txtBikeLight).isDisplayed();
	}
	
	/**
	 * @summary Validate Cart Details Item Onesie is displayed
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return boolean
	 * */
	public boolean isOnesieTextDisplayed() {		
		return objDriver.findElement(txtOnesie).isDisplayed();
	}
}
