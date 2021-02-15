package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver= new ThreadLocal<WebDriver>();
	
	public WebDriver initialize_Driver()
	{
		System.setProperty("webdriver.chrome.driver", "D:/BrowserDrivers/chromedriver.exe");
		driver= new ChromeDriver();
		tdriver.set(driver);
		return getDriver();
		
	}

	public static synchronized  WebDriver getDriver() {
		return tdriver.get();
	}
	
}
