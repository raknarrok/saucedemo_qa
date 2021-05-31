package pageObjects;

//Import Libraries
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class CheckOutCompleteScreen {
	
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
	// Check Out Complete Title
	By txtCheckOutTitle = By.xpath("//span[@class='title']");
	
	// Thanks Your Text
	By txtThasnkYou = By.xpath("//h2[@class='complete-header']");
	
	// **** BUTTON ELEMENTS ****	
	// Finish
	By btnBackHome = By.id("back-to-products");
	
	// Constructor Creation
	public CheckOutCompleteScreen(WebDriver driver) {
		this.objDriver = driver;
	}
	
	/*
	 * **** 
	 * METHODS
	 * ****
	 */
	
	/**
	 * @summary Click on FINISH Button
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return n/a
	 * */
	public void clickFinish() {
		objDriver.findElement(btnBackHome).click();
	}
	
	/**
	 * @summary Validate CheckOut Complete Details Title is displayed
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return Boolean
	 * */
	public boolean isCheckOutCompleteTitleDisplayed() {
		objDriver.findElement(txtCheckOutTitle).getText();
		if(objDriver.findElement(txtCheckOutTitle).getText().toLowerCase().contains("complete")) {
			blRetrieveValue = true;
		}else {
			blRetrieveValue = false;
		}
		return blRetrieveValue;
	}
	
	/**
	 * @summary Validate CheckOut Complete Details Title is displayed
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return Boolean
	 * */
	public boolean isThanksYouTextDisplayed() {
		objDriver.findElement(txtThasnkYou).getText();
		if(objDriver.findElement(txtThasnkYou).getText().toLowerCase().contains("thank")) {
			blRetrieveValue = true;
		}else {
			blRetrieveValue = false;
		}
		return blRetrieveValue;
	}
}