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
import pageObjects.SignInScreen;

public class LogInInvalidUser extends TestReporter{
	
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
	
	@Test(dataProvider = "ExcelInfo", priority = 1, description = "2 - Login with an invalid user")
	public void logInInvalidValidUser(String strUser, String strPassword, String strFirstName, String strLastName) {
		/*
		 * Log The test Scenario Name 
		 */
		System.out.println(" Script Name -> " + new Object(){
		}.getClass().getEnclosingClass().getName());
		
		// Object Creation
		SignInScreen objSignIn = new SignInScreen(objDriver);
		
		// Set Account
		// objSignIn.setAccount("standard_user", "secret123");
		objSignIn.setAccount(strUser, strPassword);
		LogInValidUser.logStep("Step 1.- Access With Invalid User");

		// Validate if the User Was Logged
		LogInInvalidUser.assertValidationTrue(objSignIn.isDisplayedErrorSadFace(), "Step 2.- Validate Error Banner is Displayed", " FAILED - Error Msg was not displayed properly");
	}
	
	@AfterTest(alwaysRun = true)
	public void removeDriver() {
		
		// Close Driver
		objDriver.quit();
	}
}
