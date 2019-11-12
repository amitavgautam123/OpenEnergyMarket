package com.oem.FixedProcurement;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.TenderOpenQuotesPage;
import com.oem.framework.pages.TenderResponsePage;
import org.testng.ITest;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TenderResponseTest extends BaseTest {
    AdminDashboardPage adminDashboardPage;
    TenderResponsePage tenderResponsePage;
    // Has to be set to prevent NullPointerException from reporters
    protected String mTestCaseName = "";

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
                .clickOnTenderResponse()
                .selectFirstValueInQuoteByDate()
                .verifyQuoteRequestDropDownExists();
    }

    @Test(description = "FPA_TOP_TC_006 - Verify meter forecast link exists ")
    public void verifyMeterForecastLinkExists() throws Throwable {
        adminDashboardPage
                .clickOnTenderResponse()
                .selectFirstValueInQuoteByDate()
                .selectFirstValueQuoteRequest()
                .verifyMeterForecastLinkExists();
    }

    @Test(description = "FPA_TOP_TC_007 - Clicking meter forecast link works ")
    public void verifyMeterForecastLinkClicable() throws Throwable {
        adminDashboardPage
                .clickOnTenderResponse()
                .selectFirstValueInQuoteByDate()
                .selectFirstValueQuoteRequest()
                .verifyMeterForecastLinkExists()
                .clickMeterForecastLink();
    }


    @Test(description = "FPA_TOP_TC_008 - verify DownloadExcel  ")
    public void verifyDownloadExcel() throws Throwable {
        adminDashboardPage
                .clickOnTenderResponse()
                .selectFirstValueInQuoteByDate()
                .selectFirstValueQuoteRequest()
                .verifyMeterForecastLinkExists()
                .clickMeterForecastLink()
                .clickDownloadExcelLink();

    }

    @Test(description = "FPA_TOP_TC_010 - verify Alert appears without consumption  ")
    public void verifyAlertWithoutConsumtion() throws Throwable {
        adminDashboardPage
                .clickOnTenderResponse()
                .selectFirstValueInQuoteByDate()
                .selectFirstValueQuoteRequest()
                .verifyMeterForecastLinkExists()
                .clickMeterForecastLink()
                .clickCalculateConsumptions()
                .verifyPopUpDialogue();

    }

    @Test(description = "FPA_TOP_TC_011 - verify Alert appears when lowest duration is provided  ")
    public void verifyAlertLowestDuration() throws Throwable {
        adminDashboardPage
                .clickOnTenderResponse()
                .selectFirstValueInQuoteByDate()
                .selectFirstValueQuoteRequest()
                .verifyMeterForecastLinkExists()
                .clickMeterForecastLink()
                .setFirstRowDayConsumption("0")
                .clickCalculateConsumptions()
                .verifyPopUpDialogue();

    }


    @Test(description = "FPA_TOP_TC_012 - verify Alert appears when lowest duration is provided for Night Consumption ")
    public void verifyAlertLowestDurationForNightConsumption() throws Throwable {
        adminDashboardPage
                .clickOnTenderResponse()
                .selectFirstValueInQuoteByDate()
                .selectFirstValueQuoteRequest()
                .verifyMeterForecastLinkExists()
                .clickMeterForecastLink()
                .setFirstRowNightConsumption("0")
                .clickCalculateConsumptions()
                .verifyPopUpDialogue();

    }



    @Test(description = "FPA_TOP_TC_013 - verify Alert appears when NonInt is provided for Night Consumption ")
    public void verifyAlertForNonIntValuesForConsumption() throws Throwable {
        adminDashboardPage
                .navigateToTenderResponse()
                .selectFirstValueInQuoteByDate()
                .selectFirstValueQuoteRequest()
                .verifyMeterForecastLinkExists()
                .clickMeterForecastLink()
                .setFirstRowDayConsumption("abc")
                .setFirstRowNightConsumption("def")
                .clickCalculateConsumptions()
                .verifyPopUpDialogue();

    }

    @Test(description = "FPA_TOP_TC_014 - verify Alert appears when SplCharts is provided for Day Consumption ")
    public void verifyAlertFoSplCharValuesForConsumption() throws Throwable {
        adminDashboardPage
                .navigateToTenderResponse()
                .selectFirstValueInQuoteByDate()
                .selectFirstValueQuoteRequest()
                .verifyMeterForecastLinkExists()
                .clickMeterForecastLink()
                .setFirstRowDayConsumption("abc@#$%")
                .setFirstRowNightConsumption("def")
                .clickCalculateConsumptions()
                .verifyPopUpDialogue();

    }

    @DataProvider(name = "consumptionInput")
    public static Object[][] credentials() {

        return new Object[][] {
                { "FPA_TOP_TC_012 - verify Alert Night consumption:0", "10","0" },
                { "FPA_TOP_TC_013 - verify Alert appears when NonInt is provided for Night Consumption", "abc","def" },
                { "FPA_TOP_TC_014 - verify Alert appears when SplCharts is provided for Day Consumption", "abc@#$@!","def" },
                { "FPA_TOP_TC_015 - verify Alert appears when SplCharts is provided for Night Consumption", "def","abc#$%!" },
                { "FPA_TOP_TC_016 - verify Alert appears when SplCharts is provided for both", "@#$%","@#$%" },
                { "FPA_TOP_TC_017 - verify Alert appears when SplCharts is provided for both", " ","@#$%" },
                { "FPA_TOP_TC_018 - verify Alert appears when space is provided for both", " "," " },
                { "FPA_TOP_TC_019 - verify Alert appears when SplCharts is provided for both", "@#$%"," " },
                { "FPA_TOP_TC_020 - verify Alert appears space is provided for night", "12345"," " },
                { "FPA_TOP_TC_021 - verify Alert appears space is provided for night", "afds"," " },
                { "FPA_TOP_TC_022 - verify Alert appears space is provided for day", " ","fdasfa" },
                { "FPA_TOP_TC_023 - verify Alert Day:Space, night: Numbers", " ","234" },
                { "FPA_TOP_TC_024 - verify Alert Day:Space, night: Special chars", " ","@#!$%" },
                { "FPA_TOP_TC_025 - verify Alert Day:Nos, night: chars", "1234","abc" },
                { "FPA_TOP_TC_026 - verify Alert Day:chars, night: Nos", "abcd","1234" },
                { "FPA_TOP_TC_027 - verify Alert Day:Nos, night: Special chars", "1234","!@#$%" },
                { "FPA_TOP_TC_028 - verify Alert Day:Spl Chars, night: Nos", "!@#$%^","1234" }
        };

    }
    
    @Test(dataProvider = "consumptionInput")
    public void verifyAlertFoSplCharValues(String desc,String dayConsumption, String nightConsumption) throws Throwable {
        adminDashboardPage
                .clickOnTenderResponse()
                .selectFirstValueInQuoteByDate()
                .selectFirstValueQuoteRequest()
                .verifyMeterForecastLinkExists()
                .clickMeterForecastLink()
                .setFirstRowDayConsumption(dayConsumption)
                .setFirstRowNightConsumption(nightConsumption)
                .clickCalculateConsumptions()
                .verifyPopUpDialogue();

    }
    //29, 30
    @Test
    public void verifyAutoFillingOfDayAndNightConsumption() throws Throwable {
    	adminDashboardPage
        	.clickOnTenderResponse()
        	.selectAssignedValueInQuoteByDate()
        	.selectFirstValueQuoteRequest()
        	.clickMeterForecastLink()
        	.setFirstRowDayConsumption("40")
        	.setFirstRowNightConsumption("50")
        	.clickCalculateConsumptions()
        	.verifyAutoFillDayConsumptionAndNightConsumption();
    }
    //31
    @Test
    public void verifyAlertMsgForDayNightConsumption() throws Throwable {
    	adminDashboardPage
        	.clickOnTenderResponse()
        	.selectAssignedValueInQuoteByDate()
        	.selectFirstValueQuoteRequest()
        	.clickMeterForecastLink()
        	.setFirstRowDayConsumption("")
        	.setFirstRowNightConsumption("")
        	.validateClickingSaveBtnWithoutEnteringConsumption();
    }
  //34
    @Test
    public void verifyAlertMsgAfterClickingCancelBtn() throws Throwable {
    	adminDashboardPage
        	.clickOnTenderResponse()
        	.selectAssignedValueInQuoteByDate()
        	.selectFirstValueQuoteRequest()
        	.clickMeterForecastLink()
        	.setFirstRowDayConsumption("40")
        	.setFirstRowNightConsumption("50")
        	.clickCalculateConsumptions().
        	clickSaveBtn().
        	clickCancelBtnInAlertMsg().
        	verifyAlertMsgPresenceAfterClickingCancelBtn();
    }
    

}


