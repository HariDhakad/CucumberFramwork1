package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) // to identify test as a junit test
@CucumberOptions(features="src/test/java/feature",glue="stepDefinitions",monochrome=true,
 tags="@PlaceOrder or @OffersPage", plugin= {"html:target/cucumber.html", "json:target/cucumber.json"
		 ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		 })

public class JunitTestRunnerTest {
	
// this is for Junit test runner this need to be implement 	
// this is commit for newly created dev branch
//
}
	