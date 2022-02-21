package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class Base {

	public WebDriver driver;

	public Properties prop; // initialized outside the method with public to be initiated from other classes

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties(); // initialize prop class to read the date.properties file for dynamic not
									// hardcoding browser etc.

		
		//System.getProperty("user.dir") -- dynamic path to project folder (E2E folder in this case)
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties"); // reads the
		//path to project folder easyer to use and reuse on diferent computers (not hardcoding path																				// data.properties
																										// file

		prop.load(fis); // load the data.properties file into Properties class
		
		
		//making the browser selection dynamic to be selectable from Maven(cmd)
		//String browserName=System.getProperty("browser");  // Uncomment this line if you are sending parameter from Maven
		String browserName=prop.getProperty("browser");// comment this line if you are sending parameter from Maven
		// get the browser name from data.properties file

		// if statement for the framework to run on different browsers without
		// hard-coding the browser name

		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();// for test to run in headless mode we need to create an obj of ChromeOptions class
			//to have acces to it's methods
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			
			if (browserName.contains("headless")) {
				
				options.addArguments("headless");
				
			}
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {

			// code in case firefox is the desired browser
			
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");

			 driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {

			// code in case InternetExplorer is the desired browser

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// wait, for sync purposes

		return driver; // return the webdriver object to be used in test cases etc.

	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {

		driver = new ChromeDriver();
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		
		FileHandler.copy(source, new File(destinationFile));

		return destinationFile;

	}

}
