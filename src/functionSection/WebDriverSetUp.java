package functionSection;

// Import Libraries
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSetUp {
	
	// Global Variables
	private WebDriver objDriver;
	private String strBrowser;
	private String stWebUrl = "https://www.saucedemo.com/";
	private String strCapability;
	private String strDriverPath;
	
	// Constructor Creation
	public WebDriverSetUp (WebDriver driver, String browser) {
		this.objDriver = driver;
		this.strBrowser = browser;
	}
	
	public WebDriver setUp() {
		
		switch(strBrowser.trim().toLowerCase()) {
		case "chrome":
			strCapability = "webdriver.chrome.driver";
			strDriverPath = ".\\DriverEXE\\chromedriver.exe";	
			break;
		case "edge":
			strCapability = "webdriver.edge.driver";
			strDriverPath = ".\\DriverEXE\\msedgedriver.exe";	
			break;
		case "firefox":
			strCapability = "webdriver.gecko.driver";
			strDriverPath = ".\\DriverEXE\\geckodriver.exe";	
			break;
		default:
			strCapability = "webdriver.chrome.driver";
			strDriverPath = ".\\DriverEXE\\chromedriver.exe";			
			break;
		}
		
		// Set Capabilities
		System.setProperty(strCapability, strDriverPath);
		
		// Select Correct Capabilities According the browser
		switch(strBrowser.trim().toLowerCase()) {
		case "chrome":
			objDriver = new ChromeDriver();
			break;
		case "edge":
			objDriver = new EdgeDriver();
			break;
		case "firefox":
			//DesiredCapabilities objCapabilities = DesiredCapabilities.firefox();
			//objCapabilities.setCapability("marionette", true);
			objDriver = new FirefoxDriver();
			break;
		default:
			objDriver = new ChromeDriver();			
			break;
		}
		
		// Manage Browser SetUp
		objDriver.get(stWebUrl);
		objDriver.manage().window().maximize();
		objDriver.manage().deleteAllCookies();
		
		// Return Web Driver
		return this.objDriver;
	}
	
}
