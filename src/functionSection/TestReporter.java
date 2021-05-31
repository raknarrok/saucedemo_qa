package functionSection;

// Import Libraries
import static org.testng.Assert.assertFalse;
import org.testng.Assert;
import org.testng.Reporter;

public class TestReporter {
	
	/**
	 * Method to construct the HTML final report
	 * @param strStep
	 */
	public static void logStep(String strStep){
	
		Reporter.log("<br>" + strStep + "<br>");
		System.out.println(strStep + "-----");
	}
	
	/**
	 * Method to validate if the screen is displayed
	 * @param bolCondition
	 * @param strDescription
	 */
	public static void assertTrue(boolean bolCondition, String strDescription){
		
		if(bolCondition == true){
			assertTrue(bolCondition,strDescription);
			System.out.println();
		}else{
			assertFalse(bolCondition, strDescription);
		}
	}
	
	/**
	 * Method to validate if the screen is displayed
	 * @param bolCondition
	 * @param strDescription
	 */
	public static void assertValidationTrue(boolean bolCondition, String strDescription, String errorMsgDisplayed){
		System.out.println("-----" + strDescription + "-----");
		if(bolCondition == true) Reporter.log("<br><b style=\"color:green\">" + strDescription + "</b><br>");
		else Reporter.log("<br><b style=\"color:red\">" + errorMsgDisplayed + "</b><br>");
		Assert.assertTrue(bolCondition, errorMsgDisplayed);
	}
}