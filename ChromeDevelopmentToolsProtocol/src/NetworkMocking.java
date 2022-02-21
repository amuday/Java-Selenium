import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v93.fetch.Fetch;

public class NetworkMocking {
	
	//mock different scenarios by sending different requests for customised scenarios (substitute browser's networ layer with custom layer)

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
System.setProperty("webdriver.chrome.driver","D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));//enable the fetching capability(class)
		
		//modify the request to a specific request that we need for our scenario, to be sent to the server
		devTools.addListener(Fetch.requestPaused(), request->
		{
			if(request.getRequest().getUrl().contains("shetty"))
			{
				String mockedUrl =request.getRequest().getUrl().replace("=shetty", "=BadGuy");//shetty has a lot of books, BadGuy has one book and a text notification that i want to get
				
				System.out.println(mockedUrl);
	
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedUrl), Optional.of(request.getRequest().getMethod()),
						Optional.empty(), Optional.empty()));
			}
			else {
				
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()),
						Optional.empty(), Optional.empty()));
				
			}
			
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.cssSelector("p")).getText()); // capture the text, we can assert it etc.
		
		
		
		
		
		
		
		
		
		
	}

}
