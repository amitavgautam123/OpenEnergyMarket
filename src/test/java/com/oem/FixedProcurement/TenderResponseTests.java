package com.oem.FixedProcurement;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.TenderOpenQuotesPage;
import com.oem.framework.pages.TenderResponsePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TenderResponseTests extends BaseTest {
    AdminDashboardPage adminDashboardPage;
    TenderResponsePage tenderResponsePage;

    @BeforeClass(alwaysRun = true)
    public void beforeTenderQuote() throws Throwable {
        adminDashboardPage=new LoginPage().loginAsAdmin();
        tenderResponsePage=adminDashboardPage.navigateToTenderResponse();
    }
    @Test(description = "FPA_TR_TC_001,FPA_TR_TC_002,FPA_TR_TC_003,FPA_TR_TC_004 - Verify quote Request Dropdown Exists")
    public void verifyQuoteByDateDropDownExists() throws Throwable {
        tenderResponsePage
                .verifyQuoteByDateExist();
    }

    @Test(description = "FPA_TR_TC_005 - Verify quoteRequest DropDown Exists")
    public void verifyQuoteRequestDropDownExists() throws Throwable {
        adminDashboardPage
                .navigateToTenderResponse()
                .selectFirstValueInQuoteByDate()
                .verifyQuoteRequestDropDownExists();
    }

    @Test(description = "FPA_TOP_TC_006 - Verify meter forecast link exists ")
    public void verifyMeterForecastLinkExists() throws Throwable {
        adminDashboardPage
                .navigateToTenderResponse()
                .selectFirstValueInQuoteByDate()
                .selectFirstValueQuoteRequest()
                .verifyMeterForecastLinkExists();
    }

    @Test(description = "FPA_TOP_TC_007 - Clicking meter forecast link works ")
    public void verifyMeterForecastLinkClicable() throws Throwable {
        adminDashboardPage
                .navigateToTenderResponse()
                .selectFirstValueInQuoteByDate()
                .selectFirstValueQuoteRequest()
                .verifyMeterForecastLinkExists()
                .clickMeterForecastLink();
    }


    @Test(description = "FPA_TOP_TC_008 - verify DownloadExcel  ")
    public void verifyDownloadExcel() throws Throwable {
        adminDashboardPage
                .navigateToTenderResponse()
                .selectFirstValueInQuoteByDate()
                .selectFirstValueQuoteRequest()
                .verifyMeterForecastLinkExists()
                .clickMeterForecastLink()
                .clickDownloadExcelLink();

    }

    @Test(description = "FPA_TOP_TC_010 - verify Alert appears without consumption  ")
    public void verifyAlertWithoutConsumtion() throws Throwable {
        adminDashboardPage
                .navigateToTenderResponse()
                .selectFirstValueInQuoteByDate()
                .selectFirstValueQuoteRequest()
                .verifyMeterForecastLinkExists()
                .clickMeterForecastLink()
                .clickCalculateConsumptions()
                .verifyPopUpDialogue();

    }

}
