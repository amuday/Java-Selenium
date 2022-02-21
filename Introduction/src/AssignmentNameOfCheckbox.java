import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AssignmentNameOfCheckbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		driver.findElement(By.id("checkBoxOption2")).click();
		
		String nameOfCheckbox = driver.findElement(By.xpath("//body/div[1]/div[4]/fieldset[1]/label[2]")).getText();
		
		System.out.println(nameOfCheckbox);
		
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		
		Select dropdown = new Select(staticDropdown);
		
		dropdown.selectByVisibleText(nameOfCheckbox);
		
		driver.findElement(By.cssSelector("#name")).click();
		
		driver.findElement(By.cssSelector("#name")).sendKeys(nameOfCheckbox);
		
		driver.findElement(By.cssSelector("#alertbtn")).click();
		
		String alertText = driver.switchTo().alert().getText();
		
		alertText = alertText.split(",")[0].split(" ")[1].trim();
		
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(nameOfCheckbox, alertText);
		
		driver.close();
		
		
		

		
	}

}
