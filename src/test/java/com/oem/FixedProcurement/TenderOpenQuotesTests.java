package com.oem.FixedProcurement;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.TenderOpenQuotesPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TenderOpenQuotesTests extends BaseTest {
    AdminDashboardPage adminDashboardPage;
    TenderOpenQuotesPage tenderOpenQuotesPage;

    @BeforeClass(alwaysRun = true)
    public void beforeTenderQuote() throws Throwable {
        adminDashboardPage=new LoginPage().loginAsAdmin();
        tenderOpenQuotesPage=adminDashboardPage.navigateToTenderQuotes();
    }
    @Test(description = "FPA_TOP_TC_002, FPA_TOP_TC_003, FPA_TOP_TC_004 - Verify quote Request Dropdown Exists")
    public void verifyQuoteDropDown() throws Throwable {
        tenderOpenQuotesPage
                .verifyQuoteRequestDropDownExist();
    }

    @Test(description = "FPA_TOP_TC_005 - Verify supplier quote Dropdown Exists after selecting quoteRequest")
    public void verifySupplierQuoteDropDown() throws Throwable {
        adminDashboardPage
                .navigateToTenderQuotes()
                .verifyQuoteRequestDropDownExist()
                .selectFirstValueInQuoteRequest()
                .verifySupplierQuotetDropDownExist();
    }

    @Test(description = "FPA_TOP_TC_006 - Verify supplier upload table is shown after selecting first value in supplier quote")
    public void verifySupplierUploadTable() throws Throwable {
        adminDashboardPage
                .navigateToTenderQuotes()
                .selectFirstValueInQuoteRequest()
                .verifySupplierQuotetDropDownExist()
                .selectFirstValueInSupplierQuote()
                .verifySuplierUploadTable();
    }


    @Test(description = "FPA_TOP_TC_007 - Verify error is thrown when tender duration is not provided")
    public void verifyErrorTextAppearsWithoutDuration() throws Throwable {
        adminDashboardPage
                .navigateToTenderQuotes()
                .selectFirstValueInQuoteRequest()
                .selectFirstValueInSupplierQuote()
                .clickOpenQuotesBtn()
                .verifyErrorTextOpenQuotes();
    }

    @Test(description = "FPA_TOP_TC_008 - Verify no error is thrown when tender duration is provided")
    public void verifySuccessWithDuration() throws Throwable {
        adminDashboardPage
                .navigateToTenderQuotes()
                .selectFirstValueInQuoteRequest()
                .selectFirstValueInSupplierQuote()
                .setTenderDuration("10")
                .clickOpenQuotesBtn();
        // TODO Add validation if required


    }

    @Test(description = "FPA_TOP_TC_009 Verify added durations should get list out in Open Quotes section above")
    public void verifyMoreThanOneDuration() throws Throwable {
        adminDashboardPage
                .navigateToTenderQuotes()
                .selectFirstValueInQuoteRequest()
                .selectFirstValueInSupplierQuote()
                .setTenderDuration("10")
                .set2ndTenderDuration("20")
                .clickOpenQuotesBtn();
        // TODO Add validation if required

    }

    @Test(description = "FPA_TOP_TC_011 VerifyPopup when trying to close Open Quotes")
    public void verifyCloseQuotesPopUp() throws Throwable {
        adminDashboardPage
                .navigateToTenderQuotes()
                .selectFirstValueInQuoteRequest()
                .selectFirstValueInSupplierQuote()
                .setTenderDuration("10")
                .clickOpenQuotesBtn()
                .clickCloseQuotesLink()
                .verifyPopUpDialogue()
                .clickCancelInPopUp();
    }

    @Test(description = "FPA_TOP_TC_012 Verify closing one of the Open Quotes")
    public void verifyCloseCurrentOpenQuotes() throws Throwable {
        adminDashboardPage
                .navigateToTenderQuotes()
                .selectFirstValueInQuoteRequest()
                .selectFirstValueInSupplierQuote()
                .setTenderDuration("10")
                .clickOpenQuotesBtn()
                .clickCloseQuotesLink()
                .clickOkInPopUp();
        Thread.sleep(2000);

        // TODO Add validation if required

    }

}
