package com.oem.Suits;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.TenderOpenQuotesPage;
import com.oem.framework.pages.TenderResponsePage;

public class FixedProcurementSuite extends BaseTest	{
	AdminDashboardPage adminDashboardPage;
    TenderOpenQuotesPage tenderOpenQuotesPage;
    TenderResponsePage tenderResponsePage;

    @BeforeClass(alwaysRun = true)
    public void beforeTenderQuote() throws Throwable {
        adminDashboardPage=new LoginPage().loginAsAdmin();
        tenderOpenQuotesPage=adminDashboardPage.navigateToTenderQuotes();
    }
    @Test
    public void verifyQuoteRequestAndSupplierQuoteRequestDropDownExistsTest() throws Throwable {
        tenderOpenQuotesPage.
                verifyQuoteRequestDropDownExist().
                selectFirstValueInQuoteRequest().
                verifySupplierQuotetDropDownExist().
        		selectFirstValueInSupplierQuote().
        		verifySuplierUploadTable().
        		clickOpenQuotesBtn().
        		verifyErrorTextOpenQuotes();
    }
    @Test(dependsOnMethods = "verifyQuoteRequestAndSupplierQuoteRequestDropDownExistsTest")
    public void verifySupplierUploadTable() throws Throwable {
    	tenderOpenQuotesPage.
    			selectSecondValueInQuoteRequest().
    			selectFirstValueInSupplierQuote().
    			setATenderDurationAndVerifyPresenceInOpenQuotes().
    			setMultipleDurationAndVerifyPresenceInOpenQuotes().
    			clickCloseQuotesLink().
    			clickCancelInPopUp().
    			clickCloseQuotesLink().
    			clickOkInPopUp();
    }			
    @Test
    public void verifyTenderResponsePage() throws Throwable {
    	tenderResponsePage = adminDashboardPage.
    							clickOnTenderResponse().
    							verifyQuoteByDateExist().
    							selectAssignedValueInQuoteByDate().
    							verifyQuoteRequestDropDownExists().
    							selectFirstValueQuoteRequest().
    							verifyMeterForecastLinkExists().
    							clickMeterForecastLink().
    				        	setFirstRowDayConsumption("70").
    				        	setFirstRowNightConsumption("80").
    				        	clickCalculateConsumptions().
    				        	clickSaveBtn().
    				        	verifyAlertMsgAfterClickingSaveBtn().
    				        	clickOkBtnInAlertMsg().
    				        	verifyQuoteDropdownPresence().
    				        	selectFirstOptionQuoteDropdown().
    				        	verifyQuoteInfoElementsPresence().
    				        	enterDataInQuoteInfo().
    				        	verifyMeterInfoElementsPresence().
    				        	enterDataInMeterInfo();
    
    
    
    }
}