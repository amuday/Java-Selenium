import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

import java.net.URL;

import java.util.HashMap;

import java.util.Map;

public class SauceLabsTest {

	public static void main(String[] args) throws MalformedURLException {

		ChromeOptions options = new ChromeOptions();

		options.setPlatformName("Windows 7");

		options.setBrowserVersion("latest");

		Map<String, Object> sauceOptions = new HashMap<>();

		sauceOptions.put("oauth-durduvsmihai-4c03c", System.getenv("SAUCE_USERNAME"));

		sauceOptions.put("e21018ab-c278-4d01-80aa-af492ef9b85f", System.getenv("SAUCE_ACCESS_KEY"));

		options.setCapability("sauce:options", sauceOptions);

		URL url = new URL("http://@ondemand.us-west-1.saucelabs.com/wd/hub");

		WebDriver driver = new RemoteWebDriver(url, options);

		driver.get("https://www.google.com/");

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		driver.quit();

	}

}