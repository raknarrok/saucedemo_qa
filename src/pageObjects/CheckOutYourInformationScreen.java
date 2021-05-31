package pageObjects;

//Import Libraries
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class CheckOutYourInformationScreen {
	
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
	By txtCheckOutTitle = By.xpath("//span[@class='title']");
	
	// **** EDITBOX ELEMENTS ****
	// First Name
	By boxFirstName = By.id("first-name");
	
	// Last Name
	By boxLastName = By.id("last-name");
	
	// ZipCode
	By boxZipCode = By.id("postal-code");
	
	// **** BUTTON ELEMENTS ****	
	// Continue
	By btnContinue = By.id("continue");
	
	// Cancel
	By btnCancel = By.id("cancel");
	
	// Constructor Creation
	public CheckOutYourInformationScreen(WebDriver driver) {
		this.objDriver = driver;
	}
	
	/*
	 * **** 
	 * METHODS
	 * ****
	 */
	
	/**
	 * @summary Click on Add User Information
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return n/a
	 * */
	public void setUserInfo(String firstName, String lastName, String zipCode) {
		objDriver.findElement(boxFirstName).sendKeys(firstName);
		objDriver.findElement(boxLastName).sendKeys(lastName);
		objDriver.findElement(boxZipCode).sendKeys(zipCode);		
	}
	
	/**
	 * @summary Click on CONTINUE Button
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return n/a
	 * */
	public void clickContinue() {
		objDriver.findElement(btnContinue).click();
	}
	
	/**
	 * @summary Click on CANCEL To Products Button
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return n/a
	 * */
	public void clickCancel() {
		objDriver.findElement(btnCancel).click();
	}
	
	/**
	 * @summary Validate CheckOut Details Title is displayed
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return Boolean
	 * */
	public boolean isCheckOutTitleDisplayed() {
		objDriver.findElement(txtCheckOutTitle).getText();
		if(objDriver.findElement(txtCheckOutTitle).getText().toLowerCase().contains("your information")) {
			blRetrieveValue = true;
		}else {
			blRetrieveValue = false;
		}
		return blRetrieveValue;
	}	
}