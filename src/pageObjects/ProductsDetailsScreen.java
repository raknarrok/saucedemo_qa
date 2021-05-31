package pageObjects;

//Import Libraries
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ProductsDetailsScreen {
	
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
	// Product Detail Title
	By txtProductTitle = By.xpath("//div[@class='inventory_details_name large_size']");
	
	// Cart Item Counter
	By txtCartItems = By.xpath("//span[@class='shopping_cart_badge']");
	
	// **** BUTTON ELEMENTS ****
	// Back To Products
	By btnBack = By.xpath("//button[@id='back-to-products']");
	
	// Add To Cart
	By btnAddToCart = By.xpath("//button[contains(@id,'add-to-cart-sauce-labs')]");
	
	// Remove
	By btnRemove = By.xpath("//button[@id='remove-sauce-labs-backpack']");
	
	// Constructor Creation
	public ProductsDetailsScreen(WebDriver driver) {
		this.objDriver = driver;
	}
	
	/*
	 * **** 
	 * METHODS
	 * ****
	 */
	
	/**
	 * @summary Click on Add To Cart Button
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return n/a
	 * */
	public void clickAddCart() {
		objDriver.findElement(btnAddToCart).click();
	}
	
	/**
	 * @summary Click on Remove Button
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return n/a
	 * */
	public void clickRemove() {
		objDriver.findElement(btnRemove).click();
	}
	
	/**
	 * @summary Click on Back To Products Button
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return n/a
	 * */
	public void clickBack() {
		objDriver.findElement(btnBack).click();
	}
	
	/**
	 * @summary Validate Product Details Title is displayed
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return Boolean
	 * */
	public boolean isProductDetailTitleDisplayed() {	
		return objDriver.findElement(txtProductTitle).isDisplayed();
	}
	
	/**
	 * @summary Validate Back Button is displayed
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return Boolean
	 * */
	public boolean isBackButtonDisplayed() {	
		return objDriver.findElement(btnBack).isDisplayed();
	}
	
}
