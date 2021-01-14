package testCases;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DashBoard;
import pages.LoginPage;

public class LoginTest {
	WebDriver driver;
	
	@BeforeClass
	public void driverMethod()
	{
		System.setProperty("webdriver.chrome.driver", "D:/BrowserDrivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://www.amazon.in");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test(dataProvider="get", dataProviderClass=Utils.class)
	public void logInTest(Map<String, String> map) {	
		
		System.out.println("Number is:"+map.get("number"));
		System.out.println("Password is:"+map.get("pwd"));
	//creating an object of dashboard
	DashBoard dashboard= new DashBoard(driver);
	
	//creating an object of loginpage
	
	LoginPage loginpage = new LoginPage(driver);
	
	//click on login button
	
	dashboard.signinButton();
	
	//enter username and password
	
	loginpage.enterUsername(map.get("number"));
	loginpage.cickContniue();
	loginpage.enterPassword(map.get("pwd"));
	//click signin button
	loginpage.clickSignin();
		
}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
}
