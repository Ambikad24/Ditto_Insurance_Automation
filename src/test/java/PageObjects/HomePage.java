package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		
	}

	//Locator
	private By prd_HDFCERGO_optimasecure=By.xpath("//span[contains(text(),\"HDFCERGO\")]/following-sibling::span");
	
    //Action method
	
	public void click_prd_HDFCERGO_optimasecure() {
		driver.findElement(prd_HDFCERGO_optimasecure).click();
	}
}
