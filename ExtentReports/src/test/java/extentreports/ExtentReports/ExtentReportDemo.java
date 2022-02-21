package extentreports.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {

	ExtentReports extent;

	@BeforeTest

	public void config() {

		// ExtentReports , ExtentSparkReporter

		String path = System.getProperty("user.dir") + "\\reports\\index.html";

		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);

		reporter.config().setReportName("Web Automation Results");

		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Mihai");

	}

	@Test

	public void initialDemo() {
		
		ExtentTest test = extent.createTest("Initial Demo");

		System.setProperty("webdriver.chrome.driver", "D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com");

		System.out.println(driver.getTitle());

		driver.close();

		test.fail("Result do not match");

		extent.flush();

	}

}
