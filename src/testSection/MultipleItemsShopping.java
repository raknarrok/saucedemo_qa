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


public class MultipleItemsShopping extends TestReporter{
	
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
	
	@Test(dataProvider = "ExcelInfo", priority = 5, description = "5 - Add Multiple Items to the shopping cart")
	public void multipleItemsShopping(String strUser, String strPassword) {
		/*
		 * Log The test Scenario Name 
		 */
		System.out.println(" Script Name -> " + new Object(){
		}.getClass().getEnclosingClass().getName());
		
		// Object Creation
		SignInScreen objSignIn = new SignInScreen(objDriver);
		
		// Set Account
		objSignIn.setAccount(strUser, strPassword);
		MultipleItemsShopping.logStep("Step 1.- Access With Valid User");
		
		// Create Object
		ProductScreen objProducts = new ProductScreen(objDriver);
		
		objProducts.clickBackPack();
		MultipleItemsShopping.logStep("Step 2.- Select Backpack product");
		
		// Create Object
		ProductsDetailsScreen objProductDetails = new ProductsDetailsScreen(objDriver);
		
		// Validate If Product Detail Title is Displayed
		MultipleItemsShopping.assertValidationTrue(objProductDetails.isProductDetailTitleDisplayed(), "Step 3.- Validate If Product Detail Title is Displayed", "FAILED - Product detail screen is not displayed Correctly");
		
		objProductDetails.clickAddCart();
		MultipleItemsShopping.logStep("Step 4.- Click Add to Cart button");
		
		// Validate If Product Detail Remove button is Displayed
		MultipleItemsShopping.assertValidationTrue(objProductDetails.isBackButtonDisplayed(), "Step 5.- Validate If Product Detail Remove button is Displayed", "FAILED - Product detail Remove button is not displayed Correctly");
		
		objProductDetails.clickBack();
		MultipleItemsShopping.logStep("Step 6.- Click Back To Products button");
		
		objProducts.clickBikeLight();
		MultipleItemsShopping.logStep("Step 7.- Select Bike Light product");
		
		objProductDetails.clickAddCart();
		MultipleItemsShopping.logStep("Step 8.- Click Add to Cart button");
		
		// Validate If Product Detail Title is Displayed
		MultipleItemsShopping.assertValidationTrue(objProductDetails.isProductDetailTitleDisplayed(), "Step 9.- Validate If Product Detail Title is Displayed", "FAILED - Product detail screen is not displayed Correctly");
		
		// Validate If Product Detail Remove button is Displayed
		MultipleItemsShopping.assertValidationTrue(objProductDetails.isBackButtonDisplayed(), "Step 10.- Validate If Product Detail Remove button is Displayed", "FAILED - Product detail Remove button is not displayed Correctly");
		
		// Create Object
		CartDetailsScreen objCartDetails = new CartDetailsScreen(objDriver);
		
		objCartDetails.clickCartIcon();
		MultipleItemsShopping.logStep("Step 11.- Click Cart Icon");
		
		// Validate If Your Cart Title is Displayed
		MultipleItemsShopping.assertValidationTrue(objCartDetails.isYourCartDisplayed(), "Step 12.- Your Cart title is displayed", "FAILED - Your Cart title is not displayed correctly");
		
		// Validate If Your Item was added Correctly
		MultipleItemsShopping.assertValidationTrue(objCartDetails.isBackPackTextDisplayed(), "Step 13.- Backpack Was Added", "FAILED - Your Item Backpack is not displayed");
		
		// Validate If Your Item was added Correctly
		MultipleItemsShopping.assertValidationTrue(objCartDetails.isBikeLightTextDisplayed(), "Step 14.- Bike Light Was Added", "FAILED - Your Item  Bike Light is not displayed");
	}
	
	@AfterTest(alwaysRun = true)
	public void removeDriver() {
		
		// Close Driver
		objDriver.quit();
	}

}
