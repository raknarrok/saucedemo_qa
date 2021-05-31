package pageObjects;

//Import External Libraries
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeftMenu {
	
	/* *****************
	 * Global Class Variables Definition
	 * *****************
	 */
	
	private WebDriver objDriver;
	private WebDriverWait objWait;
	
	/* *****************
	 * Page Class Elements
	 * *****************
	 */
	
	// **** BUTTON ****
	// Main Menu
	By btnBurgerMenu = By.id("react-burger-menu-btn");
	
	// LogOut
	By btnLogOut = By.id("logout_sidebar_link");	
	
	/*
	 * **** CONSTRUCTOR Creation ****
	 * */
	public LeftMenu(WebDriver driver) {
		this.objDriver = driver;
		this.objWait = new WebDriverWait(objDriver, 20);
	}
	
	/*
	 * **** 
	 * METHODS
	 * ****
	 */
	
	/**
	 * @summary Click Main Menu
	 * @version 04/24/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return n/a
	 * */
	public void clickMenu() {
		objDriver.findElement(btnBurgerMenu).click();
	}
	
	/**
	 * @summary Click Menu
	 * @version 04/24/2021
	 * @author Luis Fernandez
	 * @param n/a
	 * @return n/a
	 * @throws InterruptedException 
	 * */
	public void clickLogOut() throws InterruptedException {
		Thread.sleep(2000);
		objDriver.findElement(btnLogOut).click();
	}

}
