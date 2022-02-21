import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v93.network.Network;
import org.openqa.selenium.devtools.v93.network.model.Request;
import org.openqa.selenium.devtools.v93.network.model.Response;

public class NetworkLogActivity {

	// log the network activity on a given site/API/etc. issue frontend/backend? what Api or or object fails.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		// log file -> if a test fails read the log and see whi UI is not loadin or whatever the problem might be

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));//enable the network class and selenium log can listen/observe the network trafic.
		
		
		//add a listener to devtools network monitor
		devTools.addListener(Network.requestWillBeSent(), request -> // lambda expression*** 

		{
			Request req = request.getRequest();
			System.out.println(req.getUrl());
			// req.getHeaders()

		});

		// Event will get fired-
		devTools.addListener(Network.responseReceived(), response -> { 

			Response res = response.getResponse();

			System.out.println(res.getUrl());

			System.out.println(res.getStatus()); 

			if (res.getStatus().toString().startsWith("4")) {
				System.out.println(res.getUrl() + "is failing with status code" + res.getStatus()); // status codes that start with 4, by example 404 error --that particular item is failing.
			}
		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo");

		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

	}

}
