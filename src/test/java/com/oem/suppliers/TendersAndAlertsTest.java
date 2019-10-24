package com.oem.suppliers;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.SupplierDashboardPage;
import com.oem.framework.pages.TendersAndAlertsPage;

public class TendersAndAlertsTest extends BaseTest {

	AdminDashboardPage adminDashboardPage;
	TendersAndAlertsPage tendersAndAlertsPage;
	@BeforeClass(alwaysRun = true)
	public void beforeTenderQuote() throws Throwable {
		adminDashboardPage=new LoginPage().loginAsAdmin();
	}

	@Test(description = "Impersonate as supplier by entering username in username field and click on Impersonate")
	public void verifyImpersonateToSupplier() throws Throwable
	{
		tendersAndAlertsPage=adminDashboardPage.impersonateSupplier()
				.goToTendersAndAlerts();
		tendersAndAlertsPage.verifySupplierSummaryTableExists();
	}
	@Test(description = "Click on Tenders and Alerts and verify presence of Filters",dependsOnMethods ="verifyImpersonateToSupplier")
	public void verifyPresenceOfFilters() throws Throwable
	{
		tendersAndAlertsPage
				.verifyPresenceOfFilters()
				.verifyQuoteStatusDropdownExist();
	}
	@Test(description = "Click on Tenders and Alerts and verify presence of Utilities")
	public void verifyPresenceOfUtils() throws Throwable
	{
		tendersAndAlertsPage
				.verifyPresenceOfFilters();
	}

	@Test(description = "Verify Quote status dropdown has In Progress, Accepted and Expired as predefined inputs")
	public void verifyQuoteRequestStatusDropDown() throws Throwable
	{
		tendersAndAlertsPage
				.validateQuoteRequestStatusDropdown();
	}

	
	/*public void QT_RAQ_TC_019() throws Throwable
	{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage adminDashboardPage = (AdminDashboardPage)loginPage.loginAsAdmin();
		SupplierDashboardPage supplierDashboardPage = (SupplierDashboardPage)adminDashboardPage.impersonateSupplier();
		TendersAndAlertsPage tendersAndAlertsPage = (TendersAndAlertsPage)supplierDashboardPage.goToTendersAndAlerts();
		tendersAndAlertsPage.validateSubmitPricePage();
	}*/
	
}
