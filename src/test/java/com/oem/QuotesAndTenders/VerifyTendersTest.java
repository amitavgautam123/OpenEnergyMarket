package com.oem.QuotesAndTenders;

import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.SupplierDashboardPage;
import com.oem.framework.pages.TendersAndAlertsPage;
import com.oem.framework.pages.VerifyTendersPage;

public class VerifyTendersTest extends BaseTest	{

	public VerifyTendersPage loggingAndNavigatingToVerifyTenders() throws Throwable {
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage adminDashboardPage = (AdminDashboardPage)loginPage.loginAsAdmin();
		VerifyTendersPage verifyTendersPage = (VerifyTendersPage)adminDashboardPage.goToVerifyTenders();
		return verifyTendersPage;
	}
	//@Test
	public void QT_RAQ_TC_003() throws Throwable
	{
		VerifyTendersPage t = loggingAndNavigatingToVerifyTenders();
		//t.validateQuoteRequestStatusDropdownPresence();
	}
}
