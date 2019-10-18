package com.oem.suppliers;

import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.SupplierDashboardPage;
import com.oem.framework.pages.TendersAndAlertsPage;

public class TendersAndAlertsTest extends BaseTest {
	
	public TendersAndAlertsPage generic() throws Throwable {
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage adminDashboardPage = (AdminDashboardPage)loginPage.loginAsAdmin();
		SupplierDashboardPage supplierDashboardPage = (SupplierDashboardPage)adminDashboardPage.impersonateSupplier();
		TendersAndAlertsPage tendersAndAlertsPage = (TendersAndAlertsPage)supplierDashboardPage.goToTendersAndAlerts();
		return tendersAndAlertsPage;
	}
	@Test
	public void QT_RAQ_TC_003_validateQuoteRequestStatusDropdownPresenceTest() throws Throwable
	{
		TendersAndAlertsPage t = generic();
		t.validateQuoteRequestStatusDropdownPresence();
	}
	@Test
	public void QT_RAQ_TC_004_validatingPresenceOfUtilitiesTest() throws Throwable
	{
		TendersAndAlertsPage t = generic();
		t.validatingPresenceOfUtilities();
	}
	@Test
	public void QT_RAQ_TC_005_validateQuoteRequestStatusDropdownTest() throws Throwable
	{
		TendersAndAlertsPage t = generic();
		t.validateQuoteRequestStatusDropdown();	
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
