package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalHomePage  {

	public WebDriver driver; // create webdriver object to have access to methods(create functionality/life
								// too for it)

	By searchBox = By.name("query");


	public portalHomePage(WebDriver driver) {
		// CONSTRUCTOR -- until this constructor the "driver" object is just a dummy
		// object without functionality

		this.driver = driver; // this driver public WebDriver driver = driver with functionality created on
								// HomePage class
	}

	
	
	
	public WebElement getSearchBox() {

		return driver.findElement(searchBox);
	}



}
