package TestSuites;

import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import CommonMethods.CommonScenarios;
import Utilities.Utilities;
import Validations.Valildations;

public class TestInit {
	static Properties prop = new Properties();
	static Utilities utils = new Utilities();
	static WebDriver driver;
	static String browser;
	Valildations validations = new Valildations();
	/*NielsenValidations nielsenValidations = new NielsenValidations()*/
	CommonScenarios commonScenarios = new CommonScenarios();
	/*NielsenCommonMethods nielsenCommonMethods = new NielsenCommonMethods();*/


	@BeforeSuite	
	@Parameters({"Environment"})
	public static void initSuite(String env) throws IOException {
		prop = utils.getConfigProperties(env);
		switch (prop.getProperty("Browser")) {
		case "IE":
			System.setProperty("webdriver.chrome.driver", "WebDrivers\\IEDriverServer.exe");
			break;
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "WebDrivers\\chromedriver.exe");
			break;
		}
	}

	@BeforeMethod
	public static void loadProperties() throws IOException {
//		prop = utils.getConfigProperties();
		switch (prop.getProperty("Browser")) {
		case "IE":
			DesiredCapabilities iecapabilities = DesiredCapabilities.internetExplorer();
			iecapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true );
			driver = new InternetExplorerDriver(iecapabilities);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			browser = "Internet Explore";
			break;
		case "Mozilla":
			driver = new FirefoxDriver();
			browser = "Firefox";
			driver.manage().deleteAllCookies();
			break;
		case "Chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");		
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			capabilities.setCapability("pageLoadStrategy", "none");
			driver = new ChromeDriver(capabilities);
			browser = "Chrome";
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);			
			break;
		case "Safari":
			SafariOptions safariOptions = new SafariOptions();
			safariOptions.setUseCleanSession(true);
			DesiredCapabilities safariCapabilities = DesiredCapabilities.safari();
			safariCapabilities.setCapability(SafariOptions.CAPABILITY, safariOptions);
			driver = new SafariDriver(safariCapabilities);
			browser = "Safari";
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
			driver.manage().window().maximize();
			break;
		}
	}

	@AfterMethod
	public static void testClosure(ITestResult result) throws IOException, InterruptedException, ParseException {
		utils.SaveResults(driver, result, browser);
		driver.close();
		driver.quit();
	}

}
