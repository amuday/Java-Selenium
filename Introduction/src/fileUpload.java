import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.testng.Assert;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class fileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {

// TODO Auto-generated method stub

		String downloadPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", "D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		chromePrefs.put("profile.default_content_settings.popups", 0);

		chromePrefs.put("download.default_directory", downloadPath);

		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption("prefs", chromePrefs);

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://altoconvertpdftojpg.com/");

		driver.findElement(By.cssSelector("[class*='btn--choose']")).click();

		Thread.sleep(3000);

		Runtime.getRuntime().exec("C:\\Users\\Mihai\\Desktop\\fileupload.exe");//call AutoIT script

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));

		driver.findElement(By.cssSelector("button[class*='medium']")).click();//click on convert btn

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now"))); //wait for file to be converted

		driver.findElement(By.linkText("Download Now")).click();//click the download btn

		Thread.sleep(5000);

		File f = new File(downloadPath + "\\converted.zip"); //download the file to desktop

		if (f.exists()) // verify if file exists in the download path

		{

			Assert.assertTrue(f.exists());

			if (f.delete()) // delete the file

				System.out.println("file deleted");

		}

	}

}