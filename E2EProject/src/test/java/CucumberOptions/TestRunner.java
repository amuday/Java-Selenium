package CucumberOptions;

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class) -- this is for junit with Cucumber

@CucumberOptions (	features = "src\\test\\java\\features" , glue = "stepDefinition") // what feature files shoud TestRunner run.


public class TestRunner extends AbstractTestNGCucumberTests{  //  extends AbstractTestNGCucumberTests to be able to run TestNG with Cucumber

	//both test will fail
	
}
