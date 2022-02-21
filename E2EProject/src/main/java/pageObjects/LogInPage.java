package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage  {

	public WebDriver driver; // create webdriver object to have access to methods(create functionality/life
								// too for it)

	By email = By.cssSelector("#user_email");

	By password = By.cssSelector("#user_password");

	By signinButton = By.cssSelector("input[value='Log In']");
	
	By forgotPassword = By.cssSelector("[href*='password/new']");



	public LogInPage(WebDriver driver) {
		// CONSTRUCTOR -- until this constructor the "driver" object is just a dummy
		// object without functionality

		this.driver = driver; // this driver public WebDriver driver = driver with functionality created on
								// HomePage class
	}

	public ForgotPassword forgotPassword() {
		
		driver.findElement(forgotPassword).click();
		
		return new ForgotPassword(driver);

	}

	public WebElement getEmail() {

		return driver.findElement(email);
	}

	public WebElement getPassword() {

		return driver.findElement(password);
	}

	public WebElement getLogin() {

		return driver.findElement(signinButton);
	}



}
