package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
			
			this.driver=driver;
		}
		

	By vegNameOffersPage = By.xpath("//p[@class='product-name']");
	By quantityOffersPage= By.xpath("//p[@class=\"quantity\"]");
	By promoButton=By.xpath("//button[@class=\"promoBtn\"]");
	By placeOrder=By.xpath("//button[contains(text(),'Place Order')]");


	public void CheckVegNameQuantity(String VegName, Integer quant) {
		
		List<WebElement> vegs= driver.findElements(vegNameOffersPage);
		
		for(int j=0;j<vegs.size();j++) {
			vegs.get(j).getText().equalsIgnoreCase(VegName);
			List<WebElement> quantity= driver.findElements(quantityOffersPage);
			quantity.get(j).equals(quant);
		}
		
		
			}
	public WebElement PromoButtonCheck() {
		
		return driver.findElement(promoButton);
			
		
	}
public WebElement PlaceOrderButtonCheck() {
		
		return driver.findElement(placeOrder);
			
		
	}

}
