import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentNewWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		
		Set<String> windows = driver.getWindowHandles(); // [parentid,childid,subchildId]

		Iterator<String> it = windows.iterator();

		String parentId = it.next();

		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		String text = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
		
		System.out.println(text);
		
		driver.switchTo().window(parentId);
		
		String text2 = driver.findElement(By.tagName("h3")).getText();
		
		System.out.println(text2);

		
		

	}

}
