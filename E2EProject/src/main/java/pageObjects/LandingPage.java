package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver; // create webdriver object to have access to methods(create functionaliti/life too for it)
	
	By signin = By.xpath("//span[contains(text(),'Login')]");
	
	By someText = By.cssSelector("div[class='text-center'] h2");
	
	By navitem = By.cssSelector("div[role='navigation']");
	
	By header = By.cssSelector("div[class*='video-banner'] h3");
	
	By popup = By.xpath("//button[contains(text(),'NO THANKS')]");
	
	public LandingPage(WebDriver driver) {
	// -- until this constructor the "driver" object is just a dummy object without functionality
		
		this.driver = driver; // this driver public WebDriver driver = driver with functionality created on HomePage class
	}

	public LogInPage getLogin() {
		
		driver.findElement(signin).click();//no need to create a separate obj because we only need LogInPage
		
		LogInPage lp = new LogInPage(driver);
		
		return lp;
		
	}
	
	public WebElement getSomeText() {
		
		return driver.findElement(someText);
	}
	
	public WebElement getNavItem() {
		
		return driver.findElement(navitem);
	}
	
	public WebElement getHeader() {
		return driver.findElement(header);
	}
	
	public int getPopUpSize() {
		return driver.findElements(popup).size();
	}
	public WebElement getPopUp() {
		return driver.findElement(popup);
	}
	
}
