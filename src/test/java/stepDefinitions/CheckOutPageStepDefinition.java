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

public class CheckOutPageStepDefinition {
public WebDriver driver;
public String LandingPageProductName;
public String offerPageProductName;
public  CheckoutPage checkoutPage;
TestContextSetup testContextSetup ;


public CheckOutPageStepDefinition(TestContextSetup testContextSetup  )
{
	this.testContextSetup=testContextSetup;
	this.checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
	
}

@Then("verify user has ability to enter promo code and place the order")
public void verify_user_has_ability_to_enter_promo()
{
	checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
	Assert.assertTrue(checkoutPage.VerifyPromoBtn());
	Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
	
	
	
}

@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
public void User_proceeds_to_checkout(String name) throws InterruptedException
{
	checkoutPage.CheckOutItems();
	
}

 
	
	


}
