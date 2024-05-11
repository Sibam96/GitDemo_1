package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class OfferPageStepDefinition {
public WebDriver driver;
public String LandingPageProductName;
public String offerPageProductName;
PageObjectManager pageObjectManager;

TestContextSetup testContextSetup ;


public OfferPageStepDefinition(TestContextSetup testContextSetup  )
{
	this.testContextSetup=testContextSetup;
	
}

		
	
	@Then("^user searched for (.+) shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortname) throws InterruptedException {
		
	
		switchToOffersPage();
		Thread.sleep(2000);
		OffersPage 	offersPage = testContextSetup.pageObjectManager.OffersPage();
	     offersPage.searchItem(shortname);
		//testContextSetup.driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys(shortname);
		Thread.sleep(2000);
		offerPageProductName=offersPage.getProductName();
		
		
	  
	}
	
	public  void switchToOffersPage()
	
	{
		
//		if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"));
		//testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
	//	pageObjectManager=new PageObjectManager(testContextSetup.driver);
		LandingPage landingPage =testContextSetup.pageObjectManager.getLandingPage();
		
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.SwitchWindowToChild();
		
		
		
	}
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page()
	{
		Assert.assertEquals(offerPageProductName, testContextSetup.LandingPageProductName);
		
	}
	


}
