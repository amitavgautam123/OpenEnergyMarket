package com.oem.Suits;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.FlexProfileManagerPage;
import com.oem.framework.pages.FlexTenderResponsePage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.PropertyPortfolioMeterPage;
import com.oem.framework.pages.VerifyTendersPage;

public class FlexManagementSuite extends BaseTest{
	CustomerDashboardPage customerDashboardPage;
	AdminDashboardPage adminDashboardPage;

	@BeforeClass(alwaysRun = true)
	public void beforeHHSuite() throws Throwable {
		customerDashboardPage = new LoginPage().login();
	}
	
	@Test(priority = 1)
	public void fillCompanyProfileTest() throws Throwable {
		customerDashboardPage.
			goToCompanyProfile().
				fillCompanyProfileGeneric();
	}
	@Test(priority = 2)
	public void addSiteTest() throws Throwable {
		customerDashboardPage.
			clickPropertyPortfolio().
				addValidSiteGeneric();
	}
	@Test(priority = 3)
	public void addHHmeterAndCheckSavedDetailsTest() throws Throwable {
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = new PropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.checkSavedDetailsAfterAddingHHMeter();
	}
	@Test(priority = 4)
	public void addHHcontractHistoryTest() throws Throwable {
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = new PropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.addValidContractHistory();
	}

	@Test(priority = 5)
	public void addFlexProfileManagerTest() throws Throwable {
		customerDashboardPage.goToFlexibleProfileManager();
		
	}
	
	@Test(priority = 6)
	public void requestForQuoteFlexProfileManagerTest() throws Throwable {
		FlexProfileManagerPage abc = new FlexProfileManagerPage();
		abc.clickOnSetUpFlexibleProfile("HH");

	}

	@Test(priority = 7)
	public void logoutFlexProfileManagerTest() throws Throwable {
		FlexProfileManagerPage abc = new FlexProfileManagerPage();
		abc.logout();

	}
	
	@Test(priority = 8)
	public void loginAsAdminAndGoToVerifyTendersFlexProfileManagerTest() throws Throwable {
		adminDashboardPage = new LoginPage().loginAsAdmin();
		adminDashboardPage.goToVerifyTenders();
		VerifyTendersPage veri=new VerifyTendersPage();
		veri.verifySuppliersPresence("HH");

	}
	@Test(priority = 9)
	public void FlexTenderResponsepAdminFlexProfileManagerTest() throws Throwable {
		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc=new FlexTenderResponsePage();
		abc.selectByDate();
		abc.logout();

	}
	@Test(priority = 10)
	public void loginAdminFlexProfistomerasculeManagerTest() throws Throwable {
		adminDashboardPage.impersonateCustomer().goToFlexibleProfileManager();
		FlexProfileManagerPage abc = new FlexProfileManagerPage();
		abc.clickReviewQuotes("HH");
		
	}
	

}
