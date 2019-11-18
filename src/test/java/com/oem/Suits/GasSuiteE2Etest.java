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

public class GasSuiteE2Etest extends BaseTest{
	
	CustomerDashboardPage customerDashboardPage;
	AdminDashboardPage adminDashboardPage;
	SupplierDashboardPage supplierDashboardPage;
	String meterValue;
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
	public void addGasmeterAndCheckSavedDetailsTest() throws Throwable {
		meterValue = customerDashboardPage.
			refreshPropertyPortfolioMeterPage().
			checkSavedDetailsAfterAddingGasMeter();
		//meterValue=propertyPortfolioMeterPage.getSavedMeterValue();
	}
	@Test(dependsOnMethods = { "addGasmeterAndCheckSavedDetailsTest" })
	public void addGascontractHistoryTest() throws Throwable {
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = new PropertyPortfolioMeterPage();
		//propertyPortfolioMeterPage.setMeterValue(meterValue);
		propertyPortfolioMeterPage.addValidGascontractHistory();
	}
	
	@Test(dependsOnMethods = { "addGascontractHistoryTest" })
	public void requestQuoteAndVerifyTenderSummaryPageTest() throws Throwable {
		customerDashboardPage.
			goToRequestQuote().
			goToGasMetersSection().
			requestGasQuoteAndVerifyTenderSummaryPageTest(meterValue);
	}
	@Test(dependsOnMethods = { "requestQuoteAndVerifyTenderSummaryPageTest" })
	public void verifyTenderTest() throws Throwable {
		adminDashboardPage = new LoginPage().
									loginAsAdmin();
		 adminDashboardPage.
			goToVerifyTenders().
				selectGasUtilityFilter().
					verifyAllowSelectedFunctionalityTest();
	}
	@Test(dependsOnMethods = { "verifyTenderTest" })
	public void verifySuppliers() throws Throwable {
		supplierDashboardPage = new LoginPage().
									loginAsAdmin().
									impersonateSupplier().
									goToTendersAndAlerts().
									verifyQuoteStatusDropdownExist().
									validateQuoteRequestStatusDropdown().
									verifyPresenceOfFilters().
									verifyGasTenderPresenceInTendersAndAlertsTest().
									navigateToGasSubmitPricePageTest().
									verifyGasSubmitPricePage().
									verifySubmitPricesSuccessPage();
	}
	@Test(dependsOnMethods = { "verifySuppliers" })
	public void verifyCustomerReviewQuotesTest() throws Throwable {
		
		  customerDashboardPage = new LoginPage(). 
				  						login(); 
		  customerDashboardPage.goToReviewQuotes().
				  					verifyReviewQuotes().
				  						acceptQuoteTest();
		 
	}
	
	
}
