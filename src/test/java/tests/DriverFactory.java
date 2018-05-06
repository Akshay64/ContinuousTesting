package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.SlimClass;

public class DriverFactory {

	private static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	private WebDriver driver;
	
	public static SlimClass sc;
	
	public static void setDriver(WebDriver driver) {
		dr.set(driver);
	}

	public static WebDriver getDriver() {
		return dr.get();
	}

	@BeforeTest
	@Parameters({ "browserName" })
	public void driverInitialization(String browserName) {
		if (browserName.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", "E://Automation//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-infobars");
			options.addArguments("-disable-notifications");
			options.addArguments("start-maximized");
			options.setAcceptInsecureCerts(true);
			
			driver = new ChromeDriver(options);
		}
		
		if(browserName.equalsIgnoreCase("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", "E://Automation//geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setAcceptInsecureCerts(true);
			options.addPreference("dom.webnotifications.disable",true);
			options.addArguments("start-maximized");
			driver = new FirefoxDriver(options);			
		}
		DriverFactory.setDriver(driver);
		sc = new SlimClass(DriverFactory.getDriver());
		
	}	
	
	@AfterTest
	public void closeBrowsers() {
		getDriver().quit();
	}
}
