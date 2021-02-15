package testCases;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class AllureListner extends BaseClass implements ITestListener  {
	
	public static   String getMethodName(ITestResult iTestResult)
	{
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	@Attachment
	public byte[] getScreenShot(WebDriver driver)
	{
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value="{0}", type="text/plain")
	public static String logMessage(String message)
	{
		return message;
	}
	
	@Override
	public void onStart(ITestContext context )
	{
		System.out.println("on start method"+ context.getName());
		context.setAttribute("WebDriver", BaseClass.getDriver());
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println("On Test Failure"+ getMethodName(result));
		
		Object testClass = result.getInstance();
		WebDriver driver = BaseClass.getDriver();
		
		if(driver instanceof WebDriver)
		{
			System.out.println("Screenshot caputred for testcase"+ getMethodName(result));
			getScreenShot(driver);
		}
		logMessage("Screenshot Captured "+ getMethodName(result));
	}

}
