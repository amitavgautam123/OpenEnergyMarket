package com.oem.FixedProcurement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.LoginPage;

public class TenderRequoteTest extends BaseTest{

	AdminDashboardPage adminDashboardPage;
	
	@BeforeClass
	public void beforeTenderRequote() throws Throwable {
		adminDashboardPage = new LoginPage().loginAsAdmin();
	}
	@Test
	public void validateReQuoteFunctionality() throws Throwable {
		adminDashboardPage.
		goToTenderReQuotePage().
		verifyQuoteDropDownPresence().
		selectOptionFromQuoteDropDown().
		clickReopenQuote().
		verifyAlertMsgPresence().
		validateCancelBtnInAlertMsg().
		clickReopenQuote().
		clickOkBtnInAlertMsg();
	}
}
