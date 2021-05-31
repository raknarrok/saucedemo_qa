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
import pageObjects.CheckOutCompleteScreen;
import pageObjects.CheckOutOverViewScreen;
import pageObjects.CheckOutYourInformationScreen;
import pageObjects.ProductScreen;
import pageObjects.ProductsDetailsScreen;
import pageObjects.SignInScreen;


public class CompletePurchase extends TestReporter{
	
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
	
	@Test(dataProvider = "ExcelInfo", priority = 6, description = "7 - Complete Purchase Flow")
	public void completePurchase(String strUser, String strPassword, String strFirstName, String strLastName, String strZipCode) throws InterruptedException {
		/*
		 * Log The test Scenario Name 
		 */
		System.out.println(" Script Name -> " + new Object(){
		}.getClass().getEnclosingClass().getName());
		
		// Object Creation
		SignInScreen objSignIn = new SignInScreen(objDriver);
		
		// Set Account
		objSignIn.setAccount(strUser, strPassword);
		CompletePurchase.logStep("Step 1.- Access With Valid User");
		
		// Create Object
		ProductScreen objProducts = new ProductScreen(objDriver);
		
		objProducts.clickFilter();
		CompletePurchase.logStep("Step 2.- Click on Filter List");
				
		objProducts.selectPriceLowToHigh();
		CompletePurchase.logStep("Step 3.- Select Filter Low to High");
		
		objProducts.clickOnesie();
		CompletePurchase.logStep("Step 4.- Click on Onesie Item");
		
		// Create Object
		ProductsDetailsScreen objProductDetails = new ProductsDetailsScreen(objDriver);
				
		// Validate If Product Detail Title is Displayed
		CompletePurchase.assertValidationTrue(objProductDetails.isProductDetailTitleDisplayed(), "Step 5.- Validate If Product Detail Title is Displayed", "FAILED - Product detail screen is not displayed Correctly");
				
		objProductDetails.clickAddCart();
		CompletePurchase.logStep("Step 6.- Click Add to Cart button");
		
		// Create Object
		CartDetailsScreen objCartDetails = new CartDetailsScreen(objDriver);
		
		objCartDetails.clickCartIcon();
		CompletePurchase.logStep("Step 7.- Click Cart Icon");
		
		// Validate If Your Cart Title is Displayed
		CompletePurchase.assertValidationTrue(objCartDetails.isYourCartDisplayed(), "Step 8.- Your Cart title is displayed", "FAILED - Your Cart title is not displayed correctly");
		
		// Validate If Your Item was added Correctly
		CompletePurchase.assertValidationTrue(objCartDetails.isOnesieTextDisplayed(), "Step 9.- Oneside Was Added", "FAILED - Your Item Oneside is not displayed");
		
		objCartDetails.clickCheckOut();
		CompletePurchase.logStep("Step 10.- Click CheckOut button");
		
		// Create Object
		CheckOutYourInformationScreen objCheckOutInformation = new CheckOutYourInformationScreen(objDriver);
		
		// Validate If Your Item was added Correctly
		CompletePurchase.assertValidationTrue(objCheckOutInformation.isCheckOutTitleDisplayed(), "Step 11.- Your Infromation Was Displayed", "FAILED - Your Infromation is not displayed correctly");
		
		objCheckOutInformation.setUserInfo(strFirstName, strLastName, strZipCode);
		CompletePurchase.logStep("Step 12.- Set Valid User Information");
		
		objCheckOutInformation.clickContinue();
		CompletePurchase.logStep("Step 13.- Click Continue button");
		
		// Create Object 
		CheckOutOverViewScreen objCheckOutOverView = new CheckOutOverViewScreen(objDriver);
		
		objCheckOutOverView.scrollToFinish();
		CompletePurchase.logStep("Step 14.- Scroll to Finish button");
		
		objCheckOutOverView.clickFinish();;
		CompletePurchase.logStep("Step 15.- Scroll to Finish button");
		
		// Create Object
		CheckOutCompleteScreen objCheckOutComplete = new CheckOutCompleteScreen(objDriver);
		
		// Validate If Title is displayed Correctly
		CompletePurchase.assertValidationTrue(objCheckOutComplete.isCheckOutCompleteTitleDisplayed(), "Step 16.- Completed Screen was displayed", "FAILED - CheckOut: Completed title is not displayed correctly");
		
		// Validate If Thanks Text is displayed Correctly
		CompletePurchase.assertValidationTrue(objCheckOutComplete.isThanksYouTextDisplayed(), "Step 17.- Thanks Text was displayed", "FAILED -  Thanks Text is not displayed correctly");		
	}
	
	@AfterTest(alwaysRun = true)
	public void removeDriver() {
		
		// Close Driver
		objDriver.quit();
	}

}
