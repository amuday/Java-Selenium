package pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage_PF {
	
	@FindBy(id = "name")
	WebElement txt_username;
	
	@FindBy(id = "password")
	WebElement txt_password;

	@FindBy(id = "login")
	WebElement btn_login;
	
	@FindBy(partialLinkText = "dude")
	List<WebElement> myLinks;
	
	@FindBy(how = How.ID, using = "name")
	WebElement abc;
	
	WebDriver driver;
	
	public LoginPage_PF(WebDriver driver) {
		this.driver = driver;
				
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		//initialise PageFactory elements every time the class in called the elements are available
	}
	
	
	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void clickOnLogin() {
		btn_login.click();
	}
}
