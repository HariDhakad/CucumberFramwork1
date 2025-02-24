package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/feature",glue="stepDefinitions",monochrome=true,
 tags="@PlaceOrder or @OffersPage", plugin= {"html:target/cucumber.html", "json:target/cucumber.json"
		 ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		 })

public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
//glue -- is path of your stepdefinations and it default check in src/test java
	// monochrome=true -- gives more readable output in cucumber 
	// dryRun ensure the every mapping of feature with respective stepdefinitions
	// and if mapping is not done then it give syntax skeleton 
	
	
	// Below is test run parallel in cucumber using testNG using scenario method of Abstatct class
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	

}
	