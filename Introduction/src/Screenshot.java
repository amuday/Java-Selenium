

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;



public class Screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver","D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");
		
		 WebDriver driver = new ChromeDriver();
		
		 driver.manage().window().maximize();
		
		 driver.manage().deleteAllCookies();
		
		//	driver.manage().deleteCookieNamed("sessionKey");
			
		driver.get("http://google.com");
			
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
		FileUtils.copyFile(src,new File("C:\\Users\\Mihai\\Documents\\Screenshots\\screenshot.png"));
		
		
	}

}
