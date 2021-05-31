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
import pageObjects.ProductScreen;
import pageObjects.SignInScreen;

public class SortProducts extends TestReporter{
	
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
		
		System.out.println("Current Browser - " + strBrowser);
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
	
	@Test(dataProvider = "ExcelInfo", priority = 1, description = "4 - Sort Products")
	public void sortProductsLowToHigh(String strUser, String strPassword) throws InterruptedException {
		/*
		 * Log The test Scenario Name 
		 */
		System.out.println(" Script Name -> " + new Object(){
		}.getClass().getEnclosingClass().getName());
		
		// Object Creation
		SignInScreen objSignIn = new SignInScreen(objDriver);
		
		// Set Account
		objSignIn.setAccount(strUser, strPassword);
		SortProducts.logStep("Step 1.- Access With Valid User");

		// Create Object
		ProductScreen objProducts = new ProductScreen(objDriver);
		
		objProducts.clickFilter();
		SortProducts.logStep("Step 2.- Click on Filter List");
				
		objProducts.selectPriceLowToHigh();
		SortProducts.logStep("Step 3.- Select Filter Low to High");

		// Validate if the User is Logged Out
		SortProducts.assertValidationTrue(objProducts.isSortLowToHigh(), "Step 4.- Validate If Items are Sort from Low to High", "FAILED - Sort is not displayed Correctly");
		}
	
	@AfterTest(alwaysRun = true)
	public void removeDriver() {
		
		// Close Driver
		objDriver.quit();
	}

}
