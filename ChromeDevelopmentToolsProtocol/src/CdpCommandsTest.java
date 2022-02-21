import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class CdpCommandsTest { 
	
// if we dont' have a custom wraper method from selenium to CDP we cand bypass selenium interpreter and send comands
//directly to CDP (Chrome DevTools Protocol) with executeCdpCommand(CDP)	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		Map<String, Object> deviceMetrics = new HashMap<String, Object>();//create a hashmap
		
		deviceMetrics.put("width",600);
		
		deviceMetrics.put("height",1000);
		
		deviceMetrics.put("deviceScaleFactor",50);
		
		deviceMetrics.put("mobile",true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics); // call of CDO method without selenium custom commands

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Library")).click();
		
		driver.close();
	
		
		
		
		
		
		
		
		
		
	}

}
