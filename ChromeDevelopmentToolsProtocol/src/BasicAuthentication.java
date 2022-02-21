import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URI;
import java.util.function.Predicate;

public class BasicAuthentication {

	//authentificate in http window popups
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "D:\\Java&Selenium Udemy\\chromedriver_win32\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		Predicate<URI> uriPredicate = uri ->  uri.getHost().contains("httpbin.org"); // predicate logic with lambda 
		
		((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("foo", "bar")); // cast driver to HasAuthentication class and input parameters at the predicated uri
		
		driver.get("http://httpbin.org/basic-auth/foo/bar");
		
	}

}
