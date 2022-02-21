import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v93.network.Network;
import org.openqa.selenium.devtools.v93.network.model.ConnectionType;



public class NetworkSpeed {

	//emulate network speed (maybe we need test to be run for slower internet connections) or times when site is accesed by a lot more users
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
			
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		//Network.emulateNetworkConditions
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty())); // enable network
		
		devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.ETHERNET))); // emulate network with an Ethernet connection ( latency upload and download etc.)
		
		devTools.addListener(Network.loadingFailed(), loadingFailed-> {  //add a loading failed listener and print the network errors and time of errors
			
			System.out.println(loadingFailed.getErrorText());
			
			System.out.println(loadingFailed.getTimestamp());
			
		});
		
		long startTime = System.currentTimeMillis(); //start time
		
		driver.get("http://google.com");
		
		driver.findElement(By.id("L2AGLb")).click();
		
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		
		String title =driver.findElement(By.cssSelector(".our-story-card-title")).getText();
		
		System.out.println(title);
		
		long endTime = System.currentTimeMillis(); // end time
		
		System.out.println(endTime - startTime); // print the time the test took to run
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
