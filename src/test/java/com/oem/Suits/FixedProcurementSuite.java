package com.oem.Suits;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.TenderOpenQuotesPage;

public class FixedProcurementSuite {
	AdminDashboardPage adminDashboardPage;
    TenderOpenQuotesPage tenderOpenQuotesPage;

    @BeforeClass(alwaysRun = true)
    public void beforeTenderQuote() throws Throwable {
        adminDashboardPage=new LoginPage().loginAsAdmin();
        tenderOpenQuotesPage=adminDashboardPage.navigateToTenderQuotes();
    }
    @Test(description = "FPA_TOP_TC_002, FPA_TOP_TC_003, FPA_TOP_TC_004 - Verify quote Request Dropdown Exists")
    public void verifyQuoteDropDown() throws Throwable {
        tenderOpenQuotesPage.
                verifyQuoteRequestDropDownExist().
                selectFirstValueInQuoteRequest().
                verifySupplierQuotetDropDownExist();
    }
}
