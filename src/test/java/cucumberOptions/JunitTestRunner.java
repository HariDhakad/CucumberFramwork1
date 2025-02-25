package cucumberOptions;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/feature",glue="stepDefinitions",monochrome=true,
 tags="@PlaceOrder or @OffersPage", plugin= {"html:target/cucumber.html", "json:target/cucumber.json"
		 ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		 })

public class JunitTestRunner {
	
// this is for Junit test runner this need to be implement 	

}
	