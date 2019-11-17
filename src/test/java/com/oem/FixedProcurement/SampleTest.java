package com.oem.FixedProcurement;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.TenderResponsePage;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class SampleTest extends BaseTest {
    AdminDashboardPage adminDashboardPage;
    TenderResponsePage tenderResponsePage;
    // Has to be set to prevent NullPointerException from reporters
    protected String mTestCaseName = "";

    @BeforeClass(alwaysRun = true)
    public void beforeTenderQuote() throws Throwable {

    }
    @Test(description = "FPA_TR_TC_001,FPA_TR_TC_002,FPA_TR_TC_003,FPA_TR_TC_004 - Verify quote Request Dropdown Exists")
    public void verifyQuoteByDateDropDownExists() throws Throwable {
      /*  tenderResponsePage
                .verifyQuoteByDateExist();*/
    }

    @Test(description = "FPA_TR_TC_005 - Verify quoteRequest DropDown Exists")
    public void verifyQuoteRequestDropDownExists() throws Throwable {
        throw new SkipException("Skipping this case");
    }

    @Test(description = "FPA_TOP_TC_006 - Verify meter forecast link exists ")
    public void verifyMeterForecastLinkExists() throws Throwable {
        Assert.fail("fail");

    }



    @DataProvider(name = "consumptionInput")
    public static Object[][] credentials() {

        return new Object[][] {
                { "FPA_TOP_TC_012 - verify Alert Night consumption:0", "10","0" },
                { "FPA_TOP_TC_013 - verify Alert appears when NonInt is provided for Night Consumption", "abc","def" },

        };

    }
    @Test(dataProvider = "consumptionInput")
    public void verifyAlertFoSplCharValues(String desc,String dayConsumption, String nightConsumption) throws Throwable {


    }







}

