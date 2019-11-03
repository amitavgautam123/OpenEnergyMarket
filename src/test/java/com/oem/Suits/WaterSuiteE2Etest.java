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

public class WaterSuiteE2Etest extends BaseTest{
	
	CustomerDashboardPage customerDashboardPage;
	AdminDashboardPage adminDashboardPage;
	SupplierDashboardPage supplierDashboardPage;
	String meterValue;
	@BeforeClass(alwaysRun = true)
	public void beforeHHSuite() throws Throwable {
		customerDashboardPage = new LoginPage().login();
	}
	
	//@Test(priority = 1)
	public void fillCompanyProfileTest() throws Throwable {
		customerDashboardPage.
			goToCompanyProfile().
				fillCompanyProfileGeneric();
	}
	//@Test(dependsOnMethods = { "fillCompanyProfileTest" })
	public void addSiteTest() throws Throwable {
		customerDashboardPage.
			clickPropertyPortfolio().
				addValidSiteGeneric();
	}
	//@Test(dependsOnMethods = { "addSiteTest" })
	public void addHHmeterAndCheckSavedDetailsTest() throws Throwable {
		meterValue = customerDashboardPage.
			refreshPropertyPortfolioMeterPage().
				checkSavedDetailsAfterAddingHHMeter();
		//meterValue=propertyPortfolioMeterPage.getSavedMeterValue();
	}
	//@Test(dependsOnMethods = { "addHHmeterAndCheckSavedDetailsTest" })
	public void addHHcontractHistoryTest() throws Throwable {
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = new PropertyPortfolioMeterPage();
		//propertyPortfolioMeterPage.setMeterValue(meterValue);
		propertyPortfolioMeterPage.addValidHHcontractHistory();
	}
	
	//@Test(dependsOnMethods = { "addHHcontractHistoryTest" })
	public void requestQuoteAndVerifyTenderSummaryPageTest() throws Throwable {
		customerDashboardPage.
			goToRequestQuote().
				requestHHquoteAndVerifyTenderSummaryPageTest(meterValue);
	}
	//@Test(dependsOnMethods = { "requestQuoteAndVerifyTenderSummaryPageTest" })
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
									verifyQuoteStatusDropdownExist().
									validateQuoteRequestStatusDropdown().
									verifyPresenceOfFilters().
									verifyTenderPresenceInTendersAndAlertsTest().
									navigateToSubmitPricePageTest().
									verifySubmitPrice();
	}
	
	
	
}
