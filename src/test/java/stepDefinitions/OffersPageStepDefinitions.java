package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OffersPageStepDefinitions {
	
	
	WebDriver driver;
	String[] homeItem;
	
	String dealsItem;
	TestContextSetup testContextSetup;
	
public OffersPageStepDefinitions(TestContextSetup testContextSetup) {
		
		this.testContextSetup=testContextSetup;
		
	}
	
	@Then("^user searched with same short name (.+) in offers page$")
	public void user_searched_with_same_short_name_in_offers_page(String shortName) {
		
		SwitchToOffersPage();	
		OffersPage op = new OffersPage(testContextSetup.driver);
		op.offSearch(shortName);
		dealsItem=op.offGetSearch();
		System.out.println(dealsItem);
	}
	
	
	public void SwitchToOffersPage() {
		// Skip this code if you are alreay switch to Offers page.
		Set<String> windows = testContextSetup.driver.getWindowHandles(); //[parentid,childid,subchildId
		Iterator<String>it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		testContextSetup.driver.switchTo().window(childWindow);
	}
	
	@Then("check if the product is available")
	public void check_if_the_product_is_available() {
		System.out.println(testContextSetup.homeItem[0]);
		Assert.assertTrue(dealsItem.equalsIgnoreCase(testContextSetup.homeItem[0]));
	
	}

}
