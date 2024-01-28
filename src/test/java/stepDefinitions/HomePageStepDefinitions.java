package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utils.TestContextSetup;

public class HomePageStepDefinitions {

	WebDriver driver;
	String[] homeItem;
	
	String dealsItem;
	
	TestContextSetup testContextSetup;
	
	public HomePageStepDefinitions(TestContextSetup testContextSetup) {
		
		this.testContextSetup=testContextSetup;
		
	}

@Given("user is on Greenkart home page")
public void user_is_on_greenkart_home_page() throws IOException, InterruptedException {
	
	
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/global.properties");
	Properties p = new Properties();
	p.load(fis);
	
	if (p.getProperty("browser").equalsIgnoreCase("chrome")) 
	{
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/chromedriver");
	testContextSetup.driver= new ChromeDriver();
	}
	testContextSetup.driver.get(p.getProperty("QAurl"));
	Thread.sleep(2000);
}
@When("^user searched with short name (.+) and extracted actual name of the product$")
public void user_searched_with_short_name_and_extracted_actual_name_of_the_product(String shortName) throws InterruptedException {
	
	HomePage hp = new HomePage(testContextSetup.driver);
	hp.searchItem(shortName);
	Thread.sleep(2000);
	String Item=hp.getsearchItem();
	testContextSetup.homeItem =Item.split(" ");
	hp.goToOffersPage();
}


@When("^user searched with short name (.+) and extracted actual name of the product then$")
public void user_searched_with_short_name_car_and_extracted_actual_name_of_the_product_then(String name) throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	
	HomePage hp = new HomePage(testContextSetup.driver);
	hp.searchItem(name);
	Thread.sleep(2000);
	String Item=hp.getsearchItem();
	System.out.println(Item);
	Thread.sleep(2000);
	homeItem =Item.split("-");
	System.out.println(homeItem[0].trim());
	System.out.println(homeItem[1].trim());
	}


@When("^User adds the (.+) of the product moves to checkout page$")
public void user_adds_the_of_the_product_moves_to_checkout_page(Integer quantity) throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	HomePage hp = new HomePage(testContextSetup.driver);
	
	System.out.println(quantity);
	
	
		
		for (int i=1;i<quantity;i++) {
			 
			hp.incrementQuantity();
		}
		
	hp.AddToCart();
	hp.invisiblityOfWebelement();
	Thread.sleep(2000);
	hp.GoToCart();
//	Thread.sleep(2000);
   
}


	
}
