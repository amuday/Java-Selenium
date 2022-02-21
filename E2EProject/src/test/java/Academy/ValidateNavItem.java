package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavItem extends Base {

	// extends Base to be able to use methods/objects from Base class in the
	// HomePage class

	public WebDriver driver;// driver = initializeDriver(); this takes the same method for all tests, I created object for this class (parallel testing issues if all test point to the same driver object
	public static Logger log = LogManager.getLogger(Base.class.getName()); // instantiate log capabilities

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver(); // initialize driver object through method from Base class

		driver.get(prop.getProperty("url")); // open the URL

	}

	@Test
	public void validateAppNavBar() throws IOException {
		

		LandingPage l = new LandingPage(driver);

		// compare text from url to required text -- error

		Assert.assertTrue(l.getNavItem().isDisplayed());

		log.info("Navigation bar is displayed!");

	}

	@AfterTest
	public void teardown() {

		driver.close();
	}

}
