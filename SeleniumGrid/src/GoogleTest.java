import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GoogleTest {

	
	
	@Test
	public void HomePageCheck() throws MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities(); // class object for desired browser or other settings for the test we want to run in selenium grid
		
		caps.setBrowserName("chrome");
		//caps.setPlatform(Platform.);  -- mac windows linux etc.
		//caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); -- accept ssl certifications if we need it
		//caps.setCapability(CapabilityType.BROWSER_NAME, "chrome"); -- another way to declare what browser we want test to be run on

		WebDriver driver = new RemoteWebDriver(new URL("http://169.254.123.213:4444"), caps); // remote driver provided with adress of the grid and what capabilities we need
		
		driver.get("http://google.com");
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.name("q")).sendKeys("selenium grid tutorials");
		
		driver.close();
		
	}
}
