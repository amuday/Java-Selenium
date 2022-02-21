import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v93.emulation.Emulation;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();//ChromeDriver instead of WebDriver cos ChromeDriver has access to devtools
		
		DevTools devTools = driver.getDevTools(); // create object of DevTools to acces that class method
		
		devTools.createSession();// create a DevTools session 
		
		//send command to CDP Methods-> CDP Methods will invoke and get access to chrome dev tools // emulate in Chrome the screen of Mobile device(600/100/50(scale factor) mobileboolean = true)
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(2000);//in real use it is better to use implicit/explicit wait
		
		driver.findElement(By.linkText("Library")).click();
		
		driver.close();
		//Network.getRequestPostData

		
	}

}
