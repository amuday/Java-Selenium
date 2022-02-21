package stepDefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LogInPage;
import pageObjects.portalHomePage;
import resources.Base;

public class stepDefinition extends Base {

	@Given("Initialize the browser with chrome")
	public void initialize_the_browser_with_chrome() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();
	}

	@Given("Navigate to {string} site")
	public void navigate_to_site(String string) {
		// Write code here that turns the phrase above into concrete actions
		driver.get(string);
	}

	@Given("Click on Login link in home page to land on Secure sign in page")
	public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() {
		// Write code here that turns the phrase above into concrete actions
		
		LandingPage l = new LandingPage(driver);
		if (l.getPopUpSize() > 0) {

			l.getPopUp().click();

		}
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
	}

	@When("^User enters (.+) and (.+) and logs in$")
	public void user_enters_and_and_logs_in(String username, String password) throws Throwable {

		LogInPage lp = new LogInPage(driver);

		lp.getEmail().sendKeys(username);

		lp.getPassword().sendKeys(password);

		lp.getLogin().click();
	}

	@Then("Verify that user is successfully logged in")
	public void verify_that_user_is_successfully_logged_in() {
		// Write code here that turns the phrase above into concrete actions

		portalHomePage p = new portalHomePage(driver);

		Assert.assertTrue(p.getSearchBox().isDisplayed());

	}
	
	@And("^close browsers$")
    public void close_browsers() throws Throwable {
        
		driver.quit();
		
    }

}
