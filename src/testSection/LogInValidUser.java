package testSection;

import org.testng.annotations.Test;

// Import External Libraries
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

import functionSection.ReadExcel;
import functionSection.TestReporter;


// Import Page Libraries
import functionSection.WebDriverSetUp;
import pageObjects.ProductScreen;
import pageObjects.SignInScreen;

public class LogInValidUser extends TestReporter{
	
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
	
	@Test(dataProvider = "ExcelInfo", priority = 1, description = "1 - Login with a valid user")
	public void logInValidUser (String strUser, String strPassword) {
		/*
		 * Log The test Scenario Name 
		 */
		System.out.println(" Script Name -> " + new Object(){
		}.getClass().getEnclosingClass().getName());
		
		// Object Creation
		SignInScreen objSignIn = new SignInScreen(objDriver);
		
		// Set Account
		objSignIn.setAccount(strUser, strPassword);
		LogInValidUser.logStep("Step 1.- Access With Valid User");
		
		// Create Object
		ProductScreen objProducts = new ProductScreen(objDriver);

		// Validate if the User Was Logged
		LogInValidUser.assertValidationTrue(objProducts.isVisibleProducts(), "Step 2.- Validate Product Screen Displayed", "FAILED - User was not logged properly");
	}
	
	@AfterTest(alwaysRun = true)
	public void removeDriver() {
		
		// Close Driver
		objDriver.quit();
	}
}
