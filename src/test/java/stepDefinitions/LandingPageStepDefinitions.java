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
import utils.TestContextSetup;

public class LandingPageStepDefinitions {
	public WebDriver driver;
	//public String landingPageProductName;
	public String offersPageProductName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	
	public LandingPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.landingPage=testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
		
		}
	
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName ) throws InterruptedException {
		
		landingPage.searchItems(shortName);
		
		Thread.sleep(2000);
		String text=landingPage.getProductName();
		testContextSetup.landingPageProductName= text.split("-")[0].trim();
		System.out.println("landing page product name is : "+testContextSetup.landingPageProductName);
	}
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity)
	{
		
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
		
	}
	
	
}
