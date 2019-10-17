package com.oem.FixedProcurement;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TenderOpenQuotesTests extends BaseTest {
    AdminDashboardPage adminDashboardPage;

    @BeforeClass(alwaysRun = true)
    public void beforeTenderQuote() throws Throwable {
        adminDashboardPage=new LoginPage().loginAsAdmin();
    }
    @Test
    public void FPA_TOP_TC_004() throws Throwable {
        adminDashboardPage
                .navigateToTenderQuotes()
                .verifyQuoteRequestDropDownExist();
    }

    @Test
    public void FPA_TOP_TC_005() throws Throwable {
        adminDashboardPage
                .navigateToTenderQuotes()
                .verifyQuoteRequestDropDownExist()
                .selectFirstValueInQuoteRequest()
                .verifySupplierQuotetDropDownExist();
    }

    @Test
    public void FPA_TOP_TC_006() throws Throwable {
        adminDashboardPage
                .navigateToTenderQuotes()
                .selectFirstValueInQuoteRequest()
                .verifySupplierQuotetDropDownExist()
                .selectFirstValueInSupplierQuote()
                .verifySuplierUploadTable();
    }


    @Test
    public void verifyErrorTextAppears() throws Throwable {
        adminDashboardPage
                .navigateToTenderQuotes()
                .selectFirstValueInQuoteRequest()
                .selectFirstValueInSupplierQuote()
                .clickOpenQuotesBtn()
                .verifyErrorTextOpenQuotes();
    }

    @Test
    public void FPA_TOP_TC_008() throws Throwable {
        adminDashboardPage
                .navigateToTenderQuotes()
                .selectFirstValueInQuoteRequest()
                .selectFirstValueInSupplierQuote()
                .setTenderDuration("10")
                .clickOpenQuotesBtn();

    }
}
