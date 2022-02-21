import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlightDateSelect {

	static String URL = "https://www.phptravels.net/flights";

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(URL);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//input[@id='autocomplete']")).click();

		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("Del");

		driver.findElement(By.xpath("//*[@id='onereturn']/div[1]/div/div[1]/div/div/div/div/div[1]")).click();

		driver.findElement(By.xpath("//input[@id='autocomplete2']")).click();

		driver.findElement(By.xpath("//input[@id='autocomplete2']")).sendKeys("Mum");

		driver.findElement(By.xpath("//*[@id='onereturn']/div[1]/div/div[2]/div/div/div/div/div[1]")).click();

		selectDate("January 2022", "20", driver);

		getPassengers(driver);

		// search

		driver.findElement(By.xpath("//button[@id='flights-search']")).click();

	}

	public static void selectDate(String monthName, String date, WebDriver driver) {

		driver.findElement(By.xpath("(//input[@id='departure'])[1]")).click();

		WebElement month = driver.findElement(By.xpath("(//table[@class=' table-condensed']//th)[2]"));

		while(!month.getText().contains(monthName)) {

			driver.findElement(By.cssSelector("(//th[@class='next'])[1]")).click();

		}

		int count= driver.findElements(By.cssSelector("td[class='day ']")).size();

		for(int i=0;i<count;i++) {

			String text=driver.findElements(By.xpath("//td[@class='day ']")).get(i).getText();

			if(text.equalsIgnoreCase(date)) {

				driver.findElements(By.xpath("//td[@class='day ']")).get(i).click();

				System.out.println("Date is:"+text);

				break;

			}

		}

	}

	public static void getPassengers(WebDriver driver) {

		driver.findElement(By.xpath("//a[@class='dropdown-toggle dropdown-btn waves-effect']")).click();


		for(int i=0;i<3;i++ ) {

			driver.findElement(By.xpath("(//*[@class='la la-plus'])[1]")).click();       

		}

		driver.findElement(By.xpath("//a[@class='dropdown-toggle dropdown-btn waves-effect']")).click();

	}



}