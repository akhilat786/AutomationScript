package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoard {
	WebDriver driver;
	
	//Constructor to initialize webDriver
	public DashBoard(WebDriver driver) {
	this.driver=driver;	
	//init element wil create all web elements
	PageFactory.initElements(driver, this);
		}
	
	//find login login link dashboard
	
	@FindBy(css="#nav-link-accountList>div>span")	
		 WebElement login;
	
	public void signinButton()
	{
			//WebDriverWait  wait  = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.elementToBeClickable(login));
		 //   return  login;
		login.click();
	}
	
	

}
