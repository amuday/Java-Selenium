import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

@SuppressWarnings("unused")
public class SSLCertif {

	public static void main(String[] args) {
// TODO Auto-generated method stub



//Desired capabilities = general chrome profile
		DesiredCapabilities ch = new DesiredCapabilities();

		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);//ch.acceptInsecureCerts();
		
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//SSl certificates
		
		ChromeOptions c = new ChromeOptions();
		
		c.merge(ch);
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver(c);// local browser

		//driver.findElement(By.className("asd"));

	}

}