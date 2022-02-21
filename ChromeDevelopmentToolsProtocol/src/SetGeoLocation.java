import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class SetGeoLocation {
	
	//change the location of the user for example (sort of like using a VPN). -- Used if I want to run test for the Indian/Usa/Romanian etc. version of the website.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	System.setProperty("webdriver.chrome.driver", "D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		//40 3
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		Map<String,Object>coordinates = new HashMap<String,Object>();// hashmap with the location atributes 
		//Madrid. SPain = lat 40  long 3
		
		coordinates.put("latitude", 40);
		
		coordinates.put("longitude", 3);
		
		coordinates.put("accuracy", 1);
		
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates); // CDP direct without selenium custom methods
		
		driver.get("http://google.com");
		
		driver.findElement(By.id("L2AGLb")).click();
		
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		
		String title =driver.findElement(By.cssSelector(".our-story-card-title")).getText();
		
		System.out.println(title);
		
		
	}

}
