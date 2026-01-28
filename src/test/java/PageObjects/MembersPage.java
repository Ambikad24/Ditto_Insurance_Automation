package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MembersPage {
	
	WebDriver driver;
	WebDriverWait  wait;
	
	//Constructor
	public MembersPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	} 
	
	//Locator
	private By loc_self_select=By.xpath("//span[normalize-space()='Self']");
	private By loc_gender_female=By.xpath("(//label//div[contains(text(),\"Female\")])[1]");
	private By loc_nextstep_btn=By.xpath("//span[contains(text(),\"Next step\")]");
	
	//Action methods
	
	public void selectSelfOption() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loc_self_select)).click();
		
	}
	
	public void selectFemaleOption() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loc_gender_female)).click();
	}
	public void clickNextstepBtn() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loc_nextstep_btn)).click();
	}

}
