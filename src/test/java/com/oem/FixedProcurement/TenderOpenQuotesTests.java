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
    @Test(description = "Verify quote Request Dropdown Exists")
//    @Description("Verify whether quote request dropdown is shown after navigating to Tender Quotes page")
    public void verifyQuoteDropDown() throws Throwable {
        adminDashboardPage
                .navigateToTenderQuotes()
                .verifyQuoteRequestDropDownExist();
    }

    @Test(description = "Verify supplier quote Dropdown Exists after selecting quoteRequest")
    public void verifySupplierQuoteDropDown() throws Throwable {
        adminDashboardPage
                .navigateToTenderQuotes()
                .verifyQuoteRequestDropDownExist()
                .selectFirstValueInQuoteRequest()
                .verifySupplierQuotetDropDownExist();
    }

    @Test(description = "Verify supplier upload table is shown after selecting first value in supplier quote")
    public void verifySupplierUploadTable() throws Throwable {
        adminDashboardPage
                .navigateToTenderQuotes()
                .selectFirstValueInQuoteRequest()
                .verifySupplierQuotetDropDownExist()
                .selectFirstValueInSupplierQuote()
                .verifySuplierUploadTable();
    }


    @Test(description = "Verify no error is thrown when tender duration is provided")
    public void verifyErrorTextAppearsWithoutDuration() throws Throwable {
        adminDashboardPage
                .navigateToTenderQuotes()
                .selectFirstValueInQuoteRequest()
                .selectFirstValueInSupplierQuote()
                .clickOpenQuotesBtn()
                .verifyErrorTextOpenQuotes();
    }

    @Test(description = "Verify no error is thrown when tender duration is provided")
    public void verifySuccessWithDuration() throws Throwable {
        adminDashboardPage
                .navigateToTenderQuotes()
                .selectFirstValueInQuoteRequest()
                .selectFirstValueInSupplierQuote()
                .setTenderDuration("10")
                .clickOpenQuotesBtn();

    }

}
