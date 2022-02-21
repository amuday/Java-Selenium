package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;

public class Listeners extends Base implements ITestListener {

	public WebDriver driver;

	ExtentTest test;

	ExtentReports extent = ExtentReporterNG.getReportObject(); // to have access to the getReportObject method
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // whe I run parallel tests the test object is overwriten by all tests at once ThreadLocal stores individual test object for all parallel tests

	public void onFinish(ITestContext context) {

// TODO Auto-generated method stub

		extent.flush();

	}

	public void onStart(ITestContext context) {

// TODO Auto-generated method stub


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {

// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {

		extentTest.get().fail(result.getThrowable());//log of the failed test attached from ThreadLocal
		
		String testMethodName = result.getMethod().getMethodName();

		try {

			@SuppressWarnings("unused")
			WebDriver driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstanceName());

		} catch (Exception e) {

		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver), testMethodName); // uses the getScreenShotPath method to the index.html file
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {

// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName()); 
		
		extentTest.set(test); // set the ThreadLocal object for it to store test objects docs

	}

	public void onTestSuccess(ITestResult result) {

// TODO Auto-generated method stub

		extentTest.get().log(Status.PASS, "Test Passed"); 

	}

}