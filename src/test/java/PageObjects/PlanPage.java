package PageObjects;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlanPage {
	
	WebDriver driver;
	WebDriverWait  wait;
	
	//Constructor
	
	public PlanPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	
	//Locator
	private By loc_your_age=By.cssSelector("input[placeholder='Your age']");
	private By loc_proposer_pincode=By.cssSelector("input[placeholder='Enter your pin code']");
	private By loc_Btn_calculate_premium=By.xpath("//div[@class=\"m_4081bf90 mantine-Group-root mantine-visible-from-sm\"]//span[contains(text(),\"Calculate Premium\")]");
	private By loc_base_premium=By.xpath("//span[contains(text(),\"Base Premium\")]/following-sibling::span");
	private By loc_Total_premium=By.xpath("//span[contains(text(),\"Total Premium\")]/following-sibling::span");
	private By loc_rider_amt=By.xpath("//span[contains(text(),\"Recommended Add-ons\")]/following-sibling::span");
	private By loc_btn_Configure=By.xpath("(//div[@class=\"m_dee7bd2f mantine-Grid-inner\"]//span[normalize-space()='Configure']/parent::span)[1]");
	private By loc_radioBtn=By.xpath("//label[@class=\"_label_ywycx_31 m_8ee546b8 mantine-Checkbox-label\"]");
	private By loc_confirmBtn=By.xpath("//span[contains(text(),\"Confirm\")]");
	
	//Action methods
	
	public void setAge(String age) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loc_your_age)).sendKeys(age);
	}
	
	public void setPincode(String pincode) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loc_proposer_pincode)).sendKeys(pincode);
	}
	
	public void clickbtnPremium() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loc_Btn_calculate_premium)).click();
	}
	public double getTotalPremium() {
		String strTotalPremium=wait.until(ExpectedConditions.visibilityOfElementLocated(loc_Total_premium)).getText().replaceAll("[,₹]","");
		
		double totalPrm=Double.parseDouble(strTotalPremium.trim());
		return totalPrm;
	}
	public double getBasePremium() {
		String strBasePremium=wait.until(ExpectedConditions.visibilityOfElementLocated(loc_base_premium)).getText().replaceAll("[,₹]","");
		
		double basePrm=Double.parseDouble(strBasePremium.trim());
		return basePrm;
	}
    public double getRiderAmount() {
    	String strRiderAmt=wait.until(ExpectedConditions.visibilityOfElementLocated(loc_rider_amt)).getText().replaceAll("[,₹]","");
    	double riderAmt=Double.parseDouble(strRiderAmt.trim());
		return riderAmt;
    }
    public void clickConfigureLink() {
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(loc_btn_Configure)).click();
    	
    }
    public void checkRadioBtn() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(loc_radioBtn)).click();
    }
    public void clickConfirmBtn() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(loc_confirmBtn)).click();
    }
}
