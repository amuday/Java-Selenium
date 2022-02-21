import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.
import org.openqa.selenium.devtools.v93.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockNetworkRequests {

	//block unwanted network requests (unwanted images/objects etc of the page)
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver", "D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty())); //enable network
		
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css"))); //block .jpg images and .css styling
		
		long startTime = System.currentTimeMillis();//start time to see how many milliseconds the test takes
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.linkText("Browse Products")).click();
		
		driver.findElement(By.linkText("Selenium")).click();
		
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		
		long endTime = System.currentTimeMillis();//endtime
		
		System.out.println(endTime - startTime);// print the time it took to run the test
		
		
		
		
		 
		
		
		
		
		
	}

}
