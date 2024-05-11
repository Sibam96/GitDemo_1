package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LandingPageStepDefinition {
public WebDriver driver;
public String LandingPageProductName;
public String offerPageProductName;
TestContextSetup testContextSetup ;
LandingPage landingPage;

public LandingPageStepDefinition(TestContextSetup testContextSetup  )
{
	this.testContextSetup=testContextSetup;
	 this.landingPage =testContextSetup.pageObjectManager.getLandingPage();
	
}


	
	@Given("User is on GreenKart Landing page")
	public void user_is_on_green_kart_landing_page() {
	Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	
		
		
	}
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.LandingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.LandingPageProductName + " is extracted from HomePage");
		
		
	 
	}
	 @When("Added {string} times of the selected product to the cart")
	 public void Added_items_product(String quantity)
	 {
		 landingPage.IncrementQuantity(Integer.parseInt(quantity));
		 landingPage.addToCart();
		 
		 
		 
		 
	 }
	


}




