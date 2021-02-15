package testCases;

import static org.testng.Assert.assertEquals;
import org.testng.SkipException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.DashBoard;
import pages.LoginPage;
@Listeners({AllureListner.class})
public class LoginTest extends BaseClass {
	WebDriver driver;
	
	@BeforeClass
	public void driverMethod()
	{
		BaseClass bs=new BaseClass();
		driver = bs.initialize_Driver();
		driver.get("http://www.amazon.in");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test(dataProvider="get", dataProviderClass=Utils.class)
	@Description("Reading Data from Excel using hashmap")
	@Epic("EP001")
	@Feature("Reading Data from Excel for login test")
	@Story("login Test")
	@Severity(SeverityLevel.BLOCKER)
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
	@Test
	@Description("Samle Test 2")
	@Epic("EP001")
	@Feature("test2 for verifying allure reports")
	@Story("Test2")
	@Severity(SeverityLevel.MINOR)
	public  void test2()
	{
		Assert.assertEquals(1, 2);
	}
	@Test
	@Description("Samle Test 3")
	@Epic("EP001")
	@Feature("test3 for verifying allure reports")
	@Story("Test3")
	@Severity(SeverityLevel.NORMAL)
	public void test3()
	{
		throw new SkipException("Skipng the test3");
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
}
