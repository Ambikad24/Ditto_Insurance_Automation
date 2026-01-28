package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PolicyPage {
	
	WebDriver driver;
	WebDriverWait  wait;
	JavascriptExecutor js;
	
	//constructor
	public PolicyPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		this.js=(JavascriptExecutor) driver;
	}
	
	//Locator
	private By btn_loc_next=By.xpath("//span[contains(text(),'Next')]");
	private By btn_loc_continue=By.xpath("//span[contains(text(),'Continue')]");
	
	//Action methods
	
	public void clickNextButton(){
		try{
		   js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	       wait.until(ExpectedConditions.visibilityOfElementLocated(btn_loc_next)).click();
		}catch(ElementClickInterceptedException e) {
		  wait.until(ExpectedConditions.visibilityOfElementLocated(btn_loc_next)).click();
		}
		
	}
	
	public void clickContinueButton() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		wait.until(ExpectedConditions.visibilityOfElementLocated(btn_loc_continue)).click();
	}

}
