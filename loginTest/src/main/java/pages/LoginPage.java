package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;

public LoginPage(WebDriver driver)
{
	this.driver=driver;
	//init element wil create all web elements
	PageFactory.initElements(driver, this);
}
@FindBy(id="ap_email")
private WebElement username;

@FindBy(id="continue")
private WebElement Continue;

@FindBy(id="ap_password")
private WebElement password;

@FindBy(id="signInSubmit")
private WebElement signin;



public void enterUsername(String number) {
	username.sendKeys(number);
}

public void cickContniue()
{
	Continue.click();
}

public void enterPassword(String pwd)
{
	password.sendKeys(pwd);
}

public void clickSignin()
{
	signin.click();
}
}
