package testSection;

//Import External Libraries
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

import functionSection.ReadExcel;
import functionSection.TestReporter;
import org.testng.annotations.Test;

//Import Page Libraries
import functionSection.WebDriverSetUp;
import pageObjects.LeftMenu;
import pageObjects.SignInScreen;

public class LogOutHomePage extends TestReporter{
	
	/* 
	 * *******************
	 * Test Class Fields
	 * *******************
	 */
	
	// Global Variable Definition And Declaration
	private WebDriver objDriver;
	private String testName;
	
	@BeforeTest(alwaysRun = true)
	@Parameters("browser")
	public void setDriver(String strBrowser) {
		
		// Set WebDriver
		WebDriverSetUp objDriveConfiguration = new WebDriverSetUp(objDriver, strBrowser);
		objDriver = objDriveConfiguration.setUp();
	}
	
	@DataProvider
	public Object[][] ExcelInfo() throws Exception{
			
		testName = new Object(){
		}.getClass().getEnclosingClass().getName();
		
		//Clear extra Folder added after get the class name
		String testName = this.testName.replace("testSection.", "");//Replace testSection text
		
		Object[][] arrObject = ReadExcel.leerExcel(testName);
		
		return (arrObject);
	}
	
	@Test(dataProvider = "ExcelInfo", priority = 1, description = "3 - Logout from the home page")
	public void logOutHomePage(String strUser, String strPassword) throws InterruptedException {
		/*
		 * Log The test Scenario Name 
		 */
		System.out.println(" Script Name -> " + new Object(){
		}.getClass().getEnclosingClass().getName());
		
		// Object Creation
		SignInScreen objSignIn = new SignInScreen(objDriver);
		
		// Set Account
		objSignIn.setAccount(strUser, strPassword);
		LogOutHomePage.logStep("Step 1.- Access With Valid User");

		// Create Object
		LeftMenu objMenu = new LeftMenu(objDriver);
		
		objMenu.clickMenu();
		LogOutHomePage.logStep("Step 2.- Click on Main Menu");
		
		
		objMenu.clickLogOut();
		LogOutHomePage.logStep("Step 3.- Click on Log Out");

		// Validate if the User is Logged Out
		LogOutHomePage.assertValidationTrue(objSignIn.isDisplayedLogIn(), "Step 4.- Validate Login Button is Displayed", "FAILED - Login Button IS NOT Displayed");
	}
	
	@AfterTest(alwaysRun = true)
	public void removeDriver() {
		
		// Close Driver
		objDriver.quit();
	}

}
