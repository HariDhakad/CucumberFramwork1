package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OffersPageStepDefinitions {
	public String offersPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	// single responsibility principle
	//loosly coupled
	// Factory design pattern -- creating object in separate class 
	//(i.e. one class has assign responsibility for crating objects of all classes)
	
	public OffersPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		// above constructor is example of DI
	}
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
		
		// After separating step definitions i.e. multiple classes driver is giving null
		//means driver has no life only global variable is their but no life i.e. initialize or assignments 
		// diff2 classes assignments is not working 
		//2. landingPageProductName also not getting in this class i.e. No assignment in this class
		//i.e. it does not mean that if it initialize it in other class pass the same variable value here also
		// every class independent variable , so this class dont have knowledge of landingPageProductName
		
		// How to do it (How to implement dependency injection in our framework)
		// By using cucumber dependency injection 
		//Ans-- cucumber picocontainer
		//
		
		
		
				
		switchToOffersPage();
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		offersPage.searchItems(shortName);
		Thread.sleep(2000);
		offersPageProductName=offersPage.getProductName();
		System.out.println("offers page product name is :"+offersPageProductName);
	}
	
	public void switchToOffersPage() {
//	    pageObjectManager = new PageObjectManager(testContextSetup.driver);
		
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopdealsPage();
		testContextSetup.genericUtils.switchWindowToChild();
		
	}
	
	@Then("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
	    
		Assert.assertEquals(offersPageProductName, testContextSetup.landingPageProductName);
	}

}
