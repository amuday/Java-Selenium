import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeIntroduction {

	public static void main(String[] args) {
			
		System.setProperty("webdriver.chrome.driver", "D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();//Chrome - ChromeDriver -> Methods
		
		driver.get("https://rahulshettyacademy.com/#/index");
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
		
	}

}
