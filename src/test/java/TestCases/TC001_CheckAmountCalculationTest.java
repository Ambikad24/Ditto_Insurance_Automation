package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.MembersPage;
import PageObjects.PlanPage;
import PageObjects.PolicyPage;
import TestBase.BaseClass;

public class TC001_CheckAmountCalculationTest extends BaseClass {
	
	@Test
	public void verifyAmountCal() {
		
		try {
			
			logger.info("****** selectig the HDFCERGO Optima Secure Product*********");
			
			HomePage homepage=new HomePage(driver);
			homepage.click_prd_HDFCERGO_optimasecure();
			
			String policyPagetUrl=driver.getCurrentUrl();
			Assert.assertEquals(policyPagetUrl, "https://app.joinditto.in/health/fq/optima-secure");
			
			logger.info("****clicking 'Next' buttons in policy page******");
			
			PolicyPage policypage=new PolicyPage(driver);
			for(int i=0;i<3;i++) {
				policypage.clickNextButton();
			}
			
			policypage.clickContinueButton();
			String membersPageUrl=driver.getCurrentUrl();
			Assert.assertEquals(membersPageUrl,"https://app.joinditto.in/health/fq/optima-secure/members");
			
			logger.info("*******Filling Insurer's information*******");
		
			MembersPage memberpage=new MembersPage(driver);
			memberpage.selectSelfOption();
			memberpage.selectFemaleOption();
			memberpage.clickNextstepBtn();
			
			String planPageUrl=driver.getCurrentUrl();
			Assert.assertEquals(planPageUrl,"https://app.joinditto.in/health/fq/optima-secure/plan");
			
			logger.info("*****Filling 'Age' and 'Pincode' information********");
			PlanPage planpage=new PlanPage(driver);
			planpage.setAge("32");
			planpage.setPincode("560023");
			planpage.clickbtnPremium();
			planpage.clickConfigureLink();
			planpage.checkRadioBtn();
			planpage.clickConfirmBtn();
			double totalPremium=planpage.getTotalPremium();
			//System.out.println(totalPremium);
			double basePremium=planpage.getBasePremium();
			//System.out.println(basePremium);
			double riderAmount=planpage.getRiderAmount();
			//System.out.println(riderAmount);
			if(totalPremium==(basePremium+riderAmount)) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			
			
		}catch(Exception e) {
			logger.error("Test failed due to exception", e);
		    Assert.fail("Test failed due to exception: " + e.getMessage());
		}
		
		logger.info("***** Finished TC001_CheckAmountCalculationTest *****");
		
		
	}
	
	

}
