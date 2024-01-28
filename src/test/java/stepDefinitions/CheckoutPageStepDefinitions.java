package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinitions {

	
	
	WebDriver driver;
	
	TestContextSetup testContextSetup;
	
	public CheckoutPageStepDefinitions(TestContextSetup testContextSetup) {
		
		this.testContextSetup=testContextSetup;
		
	}
	
	@Then("^Check if vegitable (.+) and (.+) is added to the shopping list on checkout page$")
	public void check_if_vegitable_car_and_is_added_to_the_shopping_list_on_checkout_page(String name,Integer quanti) {
	    // Write code here that turns the phrase above into concrete actions
		CheckoutPage c= new CheckoutPage(testContextSetup.driver);
		c.CheckVegNameQuantity(name, quanti);
	}
	
	@Then("Check if Apply and Checkout buttons are available on checkout page")
	public void check_if_apply_and_checkout_buttons_are_available_on_checkout_page() {
	    // Write code here that turns the phrase above into concrete actions
		CheckoutPage c= new CheckoutPage(testContextSetup.driver);
		Assert.assertTrue(c.PlaceOrderButtonCheck().isEnabled());
		Assert.assertTrue(c.PromoButtonCheck().isEnabled());
	}
	
	
	
}
