package pageObjects;

//Import Libraries
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class CheckOutOverViewScreen {
	
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
	// Check Out Overview Detail Title
	By txtCheckOutTitle = By.xpath("//span[@class='title']");
	
	// **** BUTTON ELEMENTS ****	
	// Finish
	By btnFinish = By.id("finish");
	
	// Cancel
	By btnCancel = By.id("cancel");
	
	// Constructor Creation
	public CheckOutOverViewScreen(WebDriver driver) {
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
		objDriver.findElement(btnFinish).click();
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
	 * @summary Validate CheckOut Overview Details Title is displayed
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return Boolean
	 * */
	public boolean isCheckOutOverViewTitleDisplayed() {
		objDriver.findElement(txtCheckOutTitle).getText();
		if(objDriver.findElement(txtCheckOutTitle).getText().toLowerCase().contains("overview")) {
			blRetrieveValue = true;
		}else {
			blRetrieveValue = false;
		}
		return blRetrieveValue;
	}
	
	/**
	 * @summary Scroll to FINISH Button
	 * @version Created 05/03/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return
	 * */
	public void scrollToFinish() {
		
		// Object Creation
		WebElement objElement = objDriver.findElement(btnFinish);
		JavascriptExecutor objScroll = (JavascriptExecutor) objDriver;
		
		// Do Scroll
		objScroll.executeScript("arguments[0].scrollIntoView();", objElement);
	}
		
}