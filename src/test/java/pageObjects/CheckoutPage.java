package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	By cartBag= By.xpath("//img[@alt=\"Cart\"]");
	By checkOutButton= By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By promoBtn= By.xpath("//button[normalize-space()='Apply']");
	By placeOrder= By.xpath("//button[text()='Place Order']");
	
	
	public void CheckOutItems()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
		
	}
	
	public  Boolean VerifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
		
	}
	
	public  Boolean VerifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
		
	}
	

}
