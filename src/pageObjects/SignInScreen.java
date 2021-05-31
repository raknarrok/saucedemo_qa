package pageObjects;

// Import External Libraries
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

// Import Dev Lirbaries

public class SignInScreen {
	
	/* *****************
	 * Global Class Variables Definition
	 * *****************
	 */
	
	private WebDriver objDriver;
	
	/* *****************
	 * Page Class Elements
	 * *****************
	 */
	
	// **** TEXT BOX ****
	// UserName
	By tbxUserName = By.id("user-name");
	
	// Password
	By tbxPassword = By.id("password");
	
	// Epic SadFace
	By txtErrorSadFace = By.xpath("//h3[@data-test='error']");
	
	// **** BUTONS ****
	// LogIn
	By btnLogin = By.id("login-button");
	
	/*
	 * **** CONSTRUCTOR Creation ****
	 * */
	public SignInScreen(WebDriver driver) {
		this.objDriver = driver;		
	}
	
	/*
	 * **** 
	 * METHODS
	 * ****
	 */
	
	/**
	 * @summary Set Name
	 * @version 04/24/2021
	 * @author Luis Fernandez
	 * @param username, password
	 * @return n/a
	 * */
	public void setAccount(String userName, String password) {
		objDriver.findElement(tbxUserName).sendKeys(userName);
		objDriver.findElement(tbxPassword).sendKeys(password);
		objDriver.findElement(btnLogin).click();
		objDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	/**
	 * @summary  Login Validation
	 * @version 04/24/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return boolean
	 * */
	public boolean isDisplayedLogIn() {
		return objDriver.findElement(btnLogin).isDisplayed();
	}
	
	/**
	 * @summary Sad Face Error Validation
	 * @version 04/24/2021
	 * @author Luis Fernandez
	 * @param username, password
	 * @return boolean
	 * */
	public boolean isDisplayedErrorSadFace() {
		return objDriver.findElement(txtErrorSadFace).isDisplayed();
	}
}