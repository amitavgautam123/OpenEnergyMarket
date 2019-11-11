package com.oem.framework.pages;

import com.oem.framework.core.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TenderResponsePage extends BasePage {


    By quoteByDateDropDown =By.id("QuoteByDate");
    By quoteRequestByIdDropDown=By.id("QuoteRequestId");
    By meterForecastsLink=By.linkText("Meter Forecasts");
    By meterForecastsHeading = By.xpath("//h2[contains(text(),'Meter Forecasts')]");
    By downloadExcel=By.linkText("Download Excel");
    By chooseFileBtn = By.id("ExcelFile");
    By uploadBtn = By.xpath("//input[@value = 'Upload']");
    By calConsumptionsBtn=By.id("calculate-consumptions-button");
    By popUpDialogue=By.xpath("//form[@class='vex-dialog-form']");
    By dayConsumption1=By.id("MeterForecasts_0__DayConsumption");
    By dayConsumption2 = By.id("MeterForecasts_1__DayConsumption");
    By nightConsumption1=By.id("MeterForecasts_0__NightConsumption");
    By nightConsumption2 = By.id("MeterForecasts_1__NightConsumption");
    By okButton=By.xpath("//button[text()='OK']");
    By popUpDialogue2 = By.xpath("//form[@class = 'vex-dialog-form']/div[contains(text(), 'Saving changes to the Meter Forecasts will result in the Fixed Calculations being re-calculated for cached entries.')]");
    By quoteDropDown=By.id("QuoteId");
    By saveBtn = By.xpath("//button[@id = 'save-forecasts-button']");
    By cancelBtn = By.xpath("//button[text() = 'Cancel']");
    
    By quoteInfoLink = By.xpath("//a[contains(text(),'Quote Information')]");
    By meterInfoLink = By.xpath("//a[contains(text(),'Meter Information')]");
    
    //Quote Information
    By tolerance = By.id("Tolerance");
    By expiryTime = By.id("ContractExpiryTime");
    By offerStatus = By.id("QuoteOfferStatusId");
    By comment = By.id("Comment");
    By productName = By.id("ProductName");
    By creditStatus = By.id("CreditStatus");
    By renewableCheckBox = By.id("Green");
    By FiT = By.id("fit3state");
    By RO = By.id("renewable3state");
    By CFD = By.id("cfd3state");
    By BSUOS = By.id("bsuos3state");
    By DUOSorTUOS = By.id("duostuos3state");
    By saveBtn_QuoteInfo = By.id("submit");

    //Meter Info
    By saveBtn_MeterInfo = By.xpath("//button[contains(text(),'Save')]");
    By dayRateFirstRow = By.xpath("//input[@id='MeterQuotes_0__DayUnitRate']");
    By nightRateFirstRow = By.xpath("//input[@id='MeterQuotes_0__NightUnitRate']");
    By standingChargeFirstRow = By.xpath("MeterQuotes_0__StandingCharge");
    By sc_FormatDropDwnFirstRow = By.xpath("//select[@id='MeterQuotes_0__StandingChargeFormat']");
    By capacityChargeFirstRow = By.xpath("//input[@id='MeterQuotes_0__CapacityCharge']");
    
    By notifyCustomerViaEmailCheckBox = By.id("send-email");
    By submitQuoteBtn = By.id("submit-quote-button");
    
    By alertMsgOnClickingSubmitQuote = By.xpath("//div[text() = 'Are you sure you want to post this quote?']");
    
    SoftAssert softAssertion = new SoftAssert();
    
    public TenderResponsePage verifyQuoteByDateExist() throws Throwable {
        Assert.assertTrue(isElementPresent(quoteByDateDropDown),"quoteByDateDropDown didnt appear");
        Thread.sleep(4000);
        return this;
    }
    @Override
    protected void isLoaded()  {
    	
    	try {
			verifyQuoteByDateExist();
		} catch (Throwable e) {
			e.printStackTrace();
		}
    }

    public TenderResponsePage selectFirstValueInQuoteByDate() throws Throwable{
        selectByIndex(quoteByDateDropDown,1);
        Thread.sleep(4000);
        return this;
    }
    public TenderResponsePage selectAssignedValueInQuoteByDate() throws Throwable{
        selectByValue(quoteByDateDropDown, "29/08/2019");
    	Thread.sleep(4000);
        return this;
    }

    public TenderResponsePage selectFirstValueQuoteRequest() throws Throwable{
        selectByIndex(quoteRequestByIdDropDown,1);
        Thread.sleep(4000);
        return this;
    }

    public TenderResponsePage verifyQuoteRequestDropDownExists() throws Throwable{
        Assert.assertTrue(isElementPresent(quoteRequestByIdDropDown),"quoteRequestByIdDropDown didnt appear");
        Thread.sleep(4000);
        return this;
    }

    public TenderResponsePage verifyMeterForecastLinkExists() throws Throwable{
        Assert.assertTrue(isElementPresent(meterForecastsLink,4),"meterForecastsLink didnt appear");
        Thread.sleep(4000);
        return this;
    }
    public TenderResponsePage clickMeterForecastLink() throws Throwable{
        click(meterForecastsLink);
        Thread.sleep(4000);
        return this;
    }
    public TenderResponsePage verifyAfterClickingMeterForecastLink() throws Throwable{
        softAssertion.assertTrue(isElementPresent(downloadExcel), "Download excel is not displaying.");
        softAssertion.assertTrue(isElementPresent(chooseFileBtn), "Choose File button is not displaying.");
        scrollToElement(saveBtn);
        Thread.sleep(2000);
        softAssertion.assertTrue(isElementPresent(saveBtn), "Download excel is not displaying.");
        softAssertion.assertTrue(isElementPresent(calConsumptionsBtn), "Calculate consumption button is not displaying.");
        softAssertion.assertAll();
        return this;
    }
    public TenderResponsePage clickDownloadExcelLink() throws Throwable{
        click(downloadExcel);
        Thread.sleep(4000);
        Assert.assertTrue(isEnabled(downloadExcel), "Download excel is not enabled");
        return this;
    }
    public TenderResponsePage clickCalculateConsumptions() throws Throwable{
        click(calConsumptionsBtn);
        Thread.sleep(4000);
        return this;
    }

    public TenderResponsePage verifyPopUpDialogue() throws Throwable{
        staticWait(4);
      //  driver.switchTo().alert();
        Assert.assertTrue(isElementPresent(popUpDialogue,3),"Popup Dialogue didn't appear");
        //driver.switchTo().
        
        click(By.xpath("//button[text()='OK']"));
        return this;
    }
    public By dayConsumptionForSpecificDuration(String duration) {
    	By dayConsumption = By.xpath("//td[@class = 'grid-edit-cell duration' and text() = '" + duration + "']/following-sibling::td[@class = 'grid-edit-cell day-consumption']/input");
    	return dayConsumption;
    }
    public By nightConsumptionForSpecificDuration(String duration) {
    	By nightConsumption = By.xpath("//td[@class = 'grid-edit-cell duration' and text() = '" + duration + "']/following-sibling::td[@class = 'grid-edit-cell night-consumption']/input");
    	return nightConsumption;
    }
    public By capacityForSpecificDuration(String duration) {
    	By nightConsumption = By.xpath("//td[@class = 'grid-edit-cell duration' and text() = '" + duration + "']/following-sibling::td[@class = 'grid-edit-cell forecast-capacity']/input");
    	return nightConsumption;
    }
    
    public TenderResponsePage setFirstRowDayConsumption(String value) throws Throwable{
        setValue(dayConsumption1,value);
        Thread.sleep(3000);
        return this;
    }

    public TenderResponsePage setFirstRowNightConsumption(String value) throws Throwable{
        setValue(nightConsumption1,value);
        Thread.sleep(3000);
        return this;
    }
    public TenderResponsePage setDayConsumptionChoosingDuration(String duration, String value) throws Throwable{
        setValue(dayConsumptionForSpecificDuration(duration),value);
        Thread.sleep(4000);
        return this;
    }
    public TenderResponsePage setNightConsumptionChoosingDuration(String duration, String value) throws Throwable{
        setValue(nightConsumptionForSpecificDuration(duration),value);
        Thread.sleep(4000);
        return this;
    }
  //29,30
    public TenderResponsePage verifyAutoFillDayConsumptionAndNightConsumption() {
    	SoftAssert softAssertion = new SoftAssert();
    	softAssertion.assertFalse(isElementPresent(popUpDialogue), "Popup dialogue is displaying.");
    	boolean correctDayConsumption2Status = getAttribute(dayConsumption2, "value").equals("80");
    	boolean correctNightConsumption2Status = getAttribute(nightConsumption2, "value").equals("100");
    	softAssertion.assertFalse(isElementPresent(popUpDialogue,3),"Popup Dialogue didn't appear");
    	softAssertion.assertTrue(correctDayConsumption2Status && correctNightConsumption2Status, "Day consumption and night consumption is displaying incorrect data.");
    	softAssertion.assertAll();
    	return this;
    }
    //31
    public TenderResponsePage validateClickingSaveBtnWithoutEnteringConsumption() throws Throwable{
    	clearValue(dayConsumption1);
        clearValue(nightConsumption1);
    	scrollToElement(saveBtn);
    	Thread.sleep(2000);
        click(saveBtn);
        Thread.sleep(3000);
        boolean alertMsgDisplayStatus = isElementPresent(popUpDialogue2);
        softAssertion.assertTrue(alertMsgDisplayStatus, "Alert popup is not displaying after clicking save btn.");
        click(cancelBtn);
        Thread.sleep(2000);
        boolean meterForecastsDisplayStatus = isElementPresent(meterForecastsHeading);
        softAssertion.assertFalse(meterForecastsDisplayStatus, "Meter Forecast is still displaying.");
        return this;
    }
    public TenderResponsePage clickSaveBtn() throws Throwable{
    	scrollToElement(saveBtn);
    	Thread.sleep(2000);
        click(saveBtn);
        Thread.sleep(3000);
        return this;
    }
    public TenderResponsePage verifyAlertMsgAfterClickingSaveBtn() throws Throwable{
        boolean alertMsgDisplayStatus = isElementPresent(popUpDialogue2);
        Assert.assertTrue(alertMsgDisplayStatus, "Alert popup is not displaying after clicking save btn.");
        return this;
    }
    
    public TenderResponsePage clickCancelBtnInAlertMsg() throws Throwable{
        click(cancelBtn);
        Thread.sleep(3000);
        return this;
    }
    public TenderResponsePage verifyAlertMsgPresenceAfterClickingCancelBtn() throws Throwable{
        boolean alertMsgDisplayStatus = isElementPresent(popUpDialogue2);
        Assert.assertFalse(alertMsgDisplayStatus, "Alert popup is not displaying after clicking save btn.");
        return this;
    }
    public TenderResponsePage clickOkBtnInAlertMsg() throws Throwable{
        click(okButton);
        Thread.sleep(3000);
        return this;
    }
    public TenderResponsePage verifyQuoteDropdownPresence() throws Throwable{
        Assert.assertTrue(isElementPresent(quoteDropDown), "Quote dropdown is not displaying.");
        return this;
    }
    public TenderResponsePage selectFirstOptionQuoteDropdown() throws Throwable{
        selectByIndex(quoteDropDown, 1);
        return this;
    }
    
    public TenderResponsePage verifyQuoteInfoMeterInfoPresence() throws Throwable{
        softAssertion.assertTrue(isElementPresent(quoteInfoLink), "Quote Info link is not displaying.");
        softAssertion.assertTrue(isElementPresent(meterInfoLink), "Quote Info link is not displaying.");
        softAssertion.assertAll();
        return this;
    }
    public TenderResponsePage verifyQuoteInfoElementsPresence() throws Throwable{
        click(quoteInfoLink);
        scrollToElement(saveBtn_QuoteInfo);
        softAssertion.assertTrue(isElementPresent(tolerance), "Tolerance is not displaying.");
        softAssertion.assertTrue(isElementPresent(expiryTime), "expiryTime is not displaying.");
        softAssertion.assertTrue(isElementPresent(offerStatus), "offerStatus is not displaying.");
        softAssertion.assertTrue(isElementPresent(productName), "productName is not displaying.");
        softAssertion.assertTrue(isElementPresent(offerStatus), "offerStatus is not displaying.");
        softAssertion.assertTrue(isElementPresent(comment), "Comment is not displaying.");
        softAssertion.assertTrue(isElementPresent(creditStatus), "creditStatus is not displaying.");
        softAssertion.assertTrue(isElementPresent(renewableCheckBox), "renewableCheckBox is not displaying.");
        softAssertion.assertTrue(isElementPresent(FiT), "FiT is not displaying.");
        softAssertion.assertTrue(isElementPresent(RO), "RO is not displaying.");
        softAssertion.assertTrue(isElementPresent(CFD), "CFD is not displaying.");
        softAssertion.assertTrue(isElementPresent(BSUOS), "BSUOS is not displaying.");
        softAssertion.assertTrue(isElementPresent(DUOSorTUOS), "DUOSorTUOS is not displaying.");
        softAssertion.assertTrue(isElementPresent(saveBtn_QuoteInfo), "save button is not displaying.");
        softAssertion.assertAll();
        return this;
    }
    public TenderResponsePage enterDataInQuoteInfo() throws Throwable{
        click(quoteInfoLink);
        scrollToElement(saveBtn_QuoteInfo);
        setValue(tolerance, readExcelData("Sheet7", 7, 2));
        selectByIndex(offerStatus, 0);
        setValue(comment, readExcelData("Sheet7", 7, 4));
        setValue(expiryTime, readExcelData("Sheet7", 7, 5));
        setValue(productName, readExcelData("Sheet7", 7, 6));
        selectByIndex(creditStatus, 0);
        click(FiT);
        click(RO);
        click(CFD);
        Thread.sleep(2000);
        click(saveBtn_QuoteInfo);
        Thread.sleep(2000);
        Assert.assertFalse(isElementPresent(tolerance), "Quote info details is still displaying after clicking save button.");
        return this;
    }
    public TenderResponsePage verifyMeterInfoElementsPresence() throws Throwable{
        click(meterInfoLink);
        scrollToElement(saveBtn_MeterInfo);
        softAssertion.assertTrue(isElementPresent(saveBtn_MeterInfo), "Save Button is not displaying.");
        softAssertion.assertTrue(isElementPresent(dayRateFirstRow), "day Rate is not displaying.");
        softAssertion.assertTrue(isElementPresent(nightRateFirstRow), "Night Rate is not displaying.");
        softAssertion.assertTrue(isElementPresent(standingChargeFirstRow), "Standing Charge is not displaying.");
        softAssertion.assertTrue(isElementPresent(sc_FormatDropDwnFirstRow), "SC format is not displaying.");
        softAssertion.assertTrue(isElementPresent(capacityChargeFirstRow), "capacity Charge is not displaying.");
        softAssertion.assertAll();
        return this;
    }
    public TenderResponsePage enterDataInMeterInfo() throws Throwable{
        click(meterInfoLink);
        scrollToElement(saveBtn_MeterInfo);
        setValue(dayRateFirstRow, readExcelData("Sheet7", 10, 2));
        setValue(nightRateFirstRow, readExcelData("Sheet7", 10, 3));
        setValue(standingChargeFirstRow, readExcelData("Sheet7", 10, 4));
        setValue(capacityChargeFirstRow, readExcelData("Sheet7", 10, 5));
        selectByIndex(sc_FormatDropDwnFirstRow, 1);
        Thread.sleep(2000);
        click(saveBtn_MeterInfo);
        Thread.sleep(2000);
        Assert.assertFalse(isElementPresent(dayRateFirstRow), "Meter info details is still displaying after clicking save button.");
        softAssertion.assertAll();
        return this;
    }
    public TenderResponsePage clickSubmitQuote() throws Throwable{
    	click(submitQuoteBtn);
    	Thread.sleep(3000);
    	return this;
    }
    public TenderResponsePage notifyCustomerViaEmail() throws Throwable{
    	click(notifyCustomerViaEmailCheckBox);
    	return this;
    }
    public TenderResponsePage verifyAlertMsgOnClickingSubmitQuote() throws Throwable{
    	softAssertion.assertTrue(isElementPresent(alertMsgOnClickingSubmitQuote), "Alert msg is not displaying on clicking submit quote button.");
    	softAssertion.assertTrue(isElementPresent(okButton), "Ok button is not displaying in alert message");
    	softAssertion.assertTrue(isElementPresent(cancelBtn), "Cancel button is not displaying in alert message");
    	
    	Thread.sleep(3000);
    	return this;
    }
    
}

