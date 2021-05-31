package pageObjects;

// Import Libraries
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.By;

public class ProductScreen {
	
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
	// Text Products
	By txtProducts = By.xpath("//div[@id='header_container']//following::span[1]");
	
	// Sauce Labs Backpack
	By txtBackpack = By.xpath("//a[@id='item_4_title_link']");
	
	// Sauce Labs Onesie
	By txtOnesie = By.xpath("//a[@id='item_2_title_link']");
	
	// Bike Light
	By txtBikeLight = By.xpath("//a[@id='item_0_title_link']");
	
	// **** SELECT ELEMENTS ****
	// Filter
	By selFilter = By.xpath("//select[@class='product_sort_container']");
	
	// Filter Low To High
	By selFilterLowToHigh = By.xpath("//option[@value='lohi']");

	// Filter High To Low
	By selFilterHighToLow = By.xpath("//option[@value='hilo']");
	
	// Constructor Creation
	public ProductScreen(WebDriver driver) {
		this.objDriver = driver;
	}
	
	/*
	 * **** 
	 * METHODS
	 * ****
	 */
	
	/**
	 * @summary Validate if Product Text Is displayed
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return blRetrieveValue
	 * */
	public boolean isVisibleProducts() {
		return objDriver.findElement(txtProducts).isDisplayed();
	}
	
	/**
	 * @summary Click Filter Text
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return n/a
	 * */
	public void clickFilter() {
		objDriver.findElement(selFilter).click();
	}
	
	/**
	 * @summary Click Backpack Text
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return n/a
	 * */
	public void clickBackPack() {
		objDriver.findElement(txtBackpack).click();
	}
	
	/**
	 * @summary Click Onesie Text
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return n/a
	 * */
	public void clickOnesie() {
		objDriver.findElement(txtOnesie).click();
	}
	
	/**
	 * @summary Click Bike Light Text
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return n/a
	 * */
	public void clickBikeLight() {
		objDriver.findElement(txtBikeLight).click();
	}
	
	/**
	 * @summary Select Filter Low To High
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return blRetrieveValue
	 * @throws InterruptedException 
	 * */
	public void selectPriceLowToHigh() throws InterruptedException {
		Thread.sleep(2000);
		objDriver.findElement(selFilterLowToHigh).click();
	}
	
	/**
	 * @summary Select Filter Low To High
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return blRetrieveValue
	 * @throws InterruptedException 
	 * */
	public void selectPriceHighToLow() throws InterruptedException {
		Thread.sleep(2000);
		objDriver.findElement(selFilterHighToLow).click();
	}
	
	/**
	 * @summary Validate Sort By Price Filter Low To High
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return blRetrieveValue
	 * @throws InterruptedException 
	 * */
	public boolean isSortLowToHigh(){
		
		// Catch All the Elements Displayed
		List<WebElement> arrElements;
		boolean bolRetrieve = false;
		String strCurrentValue;
		String strNextValue;
		
		arrElements = objDriver.findElements(By.xpath("//div[@class='inventory_item']"));
		System.out.println("No Sort Lists");
		
		for(int iCounter = 0; iCounter <= arrElements.size()-1; iCounter++) {
			
			// Retrieve Current and Next Elements
			strCurrentValue = objDriver.findElement(By.xpath("//div[@class='inventory_item']["+ (iCounter+1) +"]//following::div[@class='inventory_item_price']")).getText();
			if(iCounter+2 > arrElements.size()) break; // If Counter is High break the flow
			strNextValue = objDriver.findElement(By.xpath("//div[@class='inventory_item']["+ (iCounter+2) +"]//following::div[@class='inventory_item_price']")).getText();
			
			// Remove Extra elements and Clean the value
			strCurrentValue = strCurrentValue.replace("$", "");
			strNextValue = strNextValue.replace("$", "");
			
			// Convert to Float
			float fltCurrent = Float.parseFloat(strCurrentValue);
			float fltNext = Float.parseFloat(strNextValue);
			
			// Get Current Value vs Next Value
			if(fltCurrent <= fltNext) {
				System.out.println("Validate Current Value is Equal or Low " + fltCurrent + " vs " + fltNext);
				bolRetrieve = true;
			}else {
				System.out.println("Validate Current Value isn't Equal or Low " + fltCurrent + " vs " + fltNext);
				bolRetrieve = false;
				break;
			}
		}
		
		int inTotalElements = arrElements.size();
		System.out.println("Total Elements Displayed - " + inTotalElements);
		
		return bolRetrieve;
	}
}
