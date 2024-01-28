package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	By search= By.xpath("//input[@type='search']");
	By productName= By.xpath("//h4[@class='product-name']");
	By offersPageBtn = By.xpath("//a[@target='_blank'][2]");
	
	By incrementBtn = By.xpath("//a[@class='increment']");
	By incrementAddedBtn = By.xpath("//button[@class='added']");
	By addToCartBtn= By.xpath("//div[@class='product-action']/button");
	By cartIcon=By.xpath("//a[@class=\"cart-icon\"]");
	By proceedToCart=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	WebDriver driver;
	public HomePage(WebDriver driver) {
		
	
		this.driver=driver;
	}
	
	
	public void searchItem(String name) {
		
	driver.findElement(search).sendKeys(name);
		
	} 
	
	public String getsearchItem() {
		
		return driver.findElement(productName).getText();
			
		} 
	
public void goToOffersPage() {
		
	driver.findElement(offersPageBtn).click();
			
		} 
public void incrementQuantity() {
	
	driver.findElement(incrementBtn).click();
}


public void invisiblityOfWebelement() {

	WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(10000));
	wait.until(ExpectedConditions.invisibilityOfElementLocated(incrementAddedBtn));
}

public void AddToCart() {

	driver.findElement(addToCartBtn).click();
}
public void GoToCart() throws InterruptedException {

	driver.findElement(cartIcon).click();
	Thread.sleep(2000);
	driver.findElement(proceedToCart).click();
	Thread.sleep(2000);
}

}



