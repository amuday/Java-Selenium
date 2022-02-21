import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentNestedFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Nested Frames")).click();
		
		//Switch to frames

		driver.switchTo().frame("frame-top");//.frame(string)

		driver.switchTo().frame("frame-middle");//.frame(string)


		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]")).getText());

		//driver.switchTo().defaultContent();

		//driver.navigate().back();

		//System.out.println(driver.getTitle());


		}


		}


