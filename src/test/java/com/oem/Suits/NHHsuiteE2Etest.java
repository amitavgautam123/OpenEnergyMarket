package com.oem.Suits;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.PropertyPortfolioMeterPage;
import com.oem.framework.pages.SupplierDashboardPage;

public class NHHsuiteE2Etest extends BaseTest {

	CustomerDashboardPage customerDashboardPage;
	AdminDashboardPage adminDashboardPage;
	SupplierDashboardPage supplierDashboardPage;
	String meterValue;
	
	@BeforeClass(alwaysRun = true)
	public void beforeNHHSuite() throws Throwable {
		customerDashboardPage = new LoginPage().
									login();
	}
	
	@Test(priority = 1)
	public void fillCompanyProfileTest() throws Throwable {
		customerDashboardPage = new LoginPage().
				login();
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
	public void addNHHmeterAndCheckSavedDetailsTest() throws Throwable {
		meterValue = customerDashboardPage.
		refreshPropertyPortfolioMeterPage().
		checkSavedDetailsAfterAddingNHHMeter();
	}
	@Test(dependsOnMethods = { "addNHHmeterAndCheckSavedDetailsTest" })
	public void addNHHcontractHistoryTest() throws Throwable {
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = new PropertyPortfolioMeterPage();
		//propertyPortfolioMeterPage.setMeterValue(meterValue);
		propertyPortfolioMeterPage.addValidNHHcontractHistory();		
	}
	@Test(dependsOnMethods = { "addNHHcontractHistoryTest" })
	public void requestNHHquoteAndVerifyTenderSummaryPageTest() throws Throwable {
		customerDashboardPage.
			goToRequestQuote().
				goToNHHmetersSection().
					requestNHHquoteAndVerifyTenderSummaryPageTest(meterValue);
	}
	@Test(dependsOnMethods = { "requestNHHquoteAndVerifyTenderSummaryPageTest" })
	public void verifyTenderAdminPanelTest() throws Throwable {
		adminDashboardPage = new LoginPage().
									loginAsAdmin();
		 adminDashboardPage.
			goToVerifyTenders().
				goToNHHmeterSection().
					verifyAllowSelectedFunctionalityTest();
			
	}
}
