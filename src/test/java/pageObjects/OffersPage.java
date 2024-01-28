package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

	WebDriver driver;
	
	public OffersPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	By offerSearch = By.xpath("//input[@id='search-field']");
	By getOfferSearch = By.xpath("//tbody/tr[1]/td[1]");
	
	

	public void offSearch(String name) {
		driver.findElement(offerSearch).sendKeys(name);
	}
	
	public String offGetSearch() {
		return driver.findElement(getOfferSearch).getText();
	}
	
	
	
}
