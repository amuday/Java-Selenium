import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AssignmentForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/"); //URL in the browser
		
		driver.findElement(By.xpath("//body/app-root[1]/form-comp[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys("Mihai");
		
		driver.findElement(By.xpath("//body/app-root[1]/form-comp[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys("asd@asd.com");
		
		driver.findElement(By.cssSelector("#exampleInputPassword1")).sendKeys("12345");
		
		driver.findElement(By.cssSelector("#exampleCheck1")).click();
		
		WebElement staticDropdown = driver.findElement(By.tagName("select"));
		
		Select dropdown = new Select(staticDropdown);
		
		dropdown.selectByIndex(0);
		
		driver.findElement(By.cssSelector("#inlineRadio1")).click();
		
		driver.findElement(By.cssSelector("input[name='bday']")).click();
		
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("22Dec");
		
		WebElement birthday = driver.findElement(By.cssSelector("input[name='bday']"));
		
		birthday.sendKeys(Keys.TAB);
		
		birthday.sendKeys("1987");
		
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		
		if (driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).isDisplayed()) {
			
			System.out.println("GG!!!");

			Assert.assertTrue(true);

		}

		else

		{

			Assert.assertTrue(false);

		}
		
		
		
	}

}
