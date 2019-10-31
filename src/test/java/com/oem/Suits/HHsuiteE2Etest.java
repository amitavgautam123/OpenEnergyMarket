package com.oem.Suits;

import java.awt.AWTException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.PropertyPortfolioMeterPage;
import com.oem.framework.pages.SupplierDashboardPage;

public class HHsuiteE2Etest extends BaseTest{
	
	CustomerDashboardPage customerDashboardPage;
	AdminDashboardPage adminDashboardPage;
	SupplierDashboardPage supplierDashboardPage;
	
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
	@Test(dependsOnMethods = { "fillCompanyProfileTest" })
	public void addSiteTest() throws Throwable {
		customerDashboardPage.
			clickPropertyPortfolio().
				addValidSiteGeneric();
	}
	@Test(dependsOnMethods = { "addSiteTest" })
	public void addHHmeterAndCheckSavedDetailsTest() throws Throwable {
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = new PropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.checkSavedDetailsAfterAddingHHMeter();
	}
	@Test(dependsOnMethods = { "addHHmeterAndCheckSavedDetailsTest" })
	public void addHHcontractHistoryTest() throws Throwable {
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = new PropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.addValidContractHistory();
	}
	
	@Test(dependsOnMethods = { "addHHcontractHistoryTest" })
	public void requestQuoteAndVerifyTenderSummaryPageTest() throws Throwable {
		customerDashboardPage.
			goToRequestQuote().
				requestAquoteAndVerifyTenderSummaryPageTest();
	}
	@Test(dependsOnMethods = { "requestQuoteAndVerifyTenderSummaryPageTest" })
	public void verifyTenderAdminPanelTest() throws Throwable {
		adminDashboardPage = new LoginPage().
									loginAsAdmin();
		 adminDashboardPage.
			goToVerifyTenders().
				verifyAllowSelectedFunctionalityTest();
			
	}
	@Test
	public void verifySuppliers() throws Throwable {
		supplierDashboardPage = new LoginPage().
									loginAsAdmin().
									impersonateSupplier().
									goToTendersAndAlerts().
									verifyTenderPresenceAndSubmitPrice();
	}
	
	
	
}
