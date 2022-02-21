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

public class ValidateTitle extends Base {

	// extends Base to be able to use methods/objects from Base class in the
	// HomePage class

	public WebDriver driver;// driver = initializeDriver(); this takes the same method for all tests, I
							// created object for this class (parallel testing issues if all test point to
							// the same driver object

	public static Logger log = LogManager.getLogger(Base.class.getName()); // instantiate log capabilities

	LandingPage l;
	
	@BeforeTest

	public void initialize() throws IOException {

		log.info("Driver is initialized");

		driver = initializeDriver(); // initialize driver object through method from Base class

		driver.get(prop.getProperty("url")); // open the URL

		log.info("Navigated to HomePage");
	}

	@Test
	public void validateAppTitle() throws IOException {
		// how many rows in data provider Array, the same nr of parameters in method
		// parameters input().
		// method assigns itself the parameters from Array, just define the type (String
		// ... String ... String ...)

		// driver = initializeDriver(); // initialize driver object through method from
		// Base class

		// driver.get(prop.getProperty("url")); // open the URL

		// create an object of LandingPage class to be able to invoke methods from that
		// class ( extends or create object of that class to invoke methods of that
		// class)

		// one is inheritance
		// creating object to that class and invoke methods of it
		l = new LandingPage(driver);
		// compare the text from the browser with actual text.- Error..
		
		Assert.assertEquals(l.getNavItem().getText(), "FEATURED CO123URSES");
		
		log.info("Successfully validated Text message");
		
		System.out.println("Test completed");

		;

	}

@Test

	public void validateHeader() throws IOException {
	
	Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
}

	
	@AfterTest
	public void teardown() {

		driver.close();
	}
	
	
	

}
