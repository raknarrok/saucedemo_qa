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
import pageObjects.CartDetailsScreen;
import pageObjects.ProductScreen;
import pageObjects.ProductsDetailsScreen;
import pageObjects.SignInScreen;


public class AddSpecificProduct extends TestReporter{
	
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
	
	@Test(dataProvider = "ExcelInfo", priority = 6, description = "6 - Add Specific Items to the shopping cart")
	public void addSpecificProduct(String strUser, String strPassword) throws InterruptedException {
		/*
		 * Log The test Scenario Name 
		 */
		System.out.println(" Script Name -> " + new Object(){
		}.getClass().getEnclosingClass().getName());
		
		// Object Creation
		SignInScreen objSignIn = new SignInScreen(objDriver);
		
		// Set Account
		objSignIn.setAccount(strUser, strPassword);
		AddSpecificProduct.logStep("Step 1.- Access With Valid User");
		
		// Create Object
		ProductScreen objProducts = new ProductScreen(objDriver);
		
		objProducts.clickFilter();
		AddSpecificProduct.logStep("Step 2.- Click on Filter List");
				
		objProducts.selectPriceLowToHigh();
		AddSpecificProduct.logStep("Step 3.- Select Filter Low to High");
		
		objProducts.clickOnesie();
		AddSpecificProduct.logStep("Step 4.- Click on Onesie Item");
		
		// Create Object
		ProductsDetailsScreen objProductDetails = new ProductsDetailsScreen(objDriver);
				
		// Validate If Product Detail Title is Displayed
		AddSpecificProduct.assertValidationTrue(objProductDetails.isProductDetailTitleDisplayed(), "Step 5.- Validate If Product Detail Title is Displayed", "FAILED - Product detail screen is not displayed Correctly");
				
		objProductDetails.clickAddCart();
		AddSpecificProduct.logStep("Step 6.- Click Add to Cart button");
		
		// Create Object
		CartDetailsScreen objCartDetails = new CartDetailsScreen(objDriver);
		
		objCartDetails.clickCartIcon();
		AddSpecificProduct.logStep("Step 7.- Click Cart Icon");
		
		// Validate If Your Cart Title is Displayed
		AddSpecificProduct.assertValidationTrue(objCartDetails.isYourCartDisplayed(), "Step 8.- Your Cart title is displayed", "FAILED - Your Cart title is not displayed correctly");
		
		// Validate If Your Item was added Correctly
		AddSpecificProduct.assertValidationTrue(objCartDetails.isOnesieTextDisplayed(), "Step 9.- Oneside Was Added", "FAILED - Your Item Oneside is not displayed");
	}
	
	@AfterTest(alwaysRun = true)
	public void removeDriver() {
		
		// Close Driver
		objDriver.quit();
	}

}
