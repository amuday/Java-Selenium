package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LogInPage;
import resources.Base;

public class HomePage extends Base {

	// extends Base to be able to use methods/objects from Base class in the
	// HomePage class
	public WebDriver driver;// driver = initializeDriver(); this takes the same method for all tests, I
							// created object for this class (parallel testing issues if all test point to
							// the same driver object
	public static Logger log = LogManager.getLogger(Base.class.getName()); // instantiate log capabilities

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver(); // initialize driver object through method from Base class

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException {
		// how many rows in data provider Array, the same number of parameters in method
		// parameters input().
		// method assigns itself the parameters from Array, just define the type (String
		// ... String ... String ...)

		// driver = initializeDriver(); // initialize driver object through method from
		// Base class
		driver.get(prop.getProperty("url")); // open the URL
		
		LandingPage l = new LandingPage(driver);// create an object of LandingPage class to be able to invoke methods from that
		// class (extends or create object of that class to invoke methods of that class)
		((WebElement) l.getLogin()).click();

		LogInPage lp = l.getLogin();
		
		lp.getEmail().sendKeys(Username);

		lp.getPassword().sendKeys(Password);

		log.info("Sign in button clicked");

		lp.getLogin().click();

		ForgotPassword fp = lp.forgotPassword();

		fp.getEmail().sendKeys("xxx");

		fp.sendMeInstructions().click();

	}

	@AfterTest
	public void teardown() {

		driver.close();
	}

	@DataProvider

	public Object[][] getData() {

		// rows stand for how many different data types need to be run
		// columns stand for how many values per test
		Object[][] data = new Object[2][3];

		// 0th row
		data[0][0] = "asd@asd.com"; // username(email)
		data[0][1] = "asdasd"; // password
		data[0][2] = "usertype"; // another data type you might need (banned user, user with special privilage
									// etc.)

		// 1st row
		data[1][0] = "restricted@asd.com"; // username(email)
		data[1][1] = "12345"; // password
		data[1][2] = "restricteduser"; // another data type you might need

		return data;
	}

}
