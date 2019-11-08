package com.oem.framework.pages;

import com.oem.framework.core.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TenderResponsePage extends BasePage {


    By quoteByDateDropDown =By.id("QuoteByDate");
    By quoteRequestByIdDropDown=By.id("QuoteRequestId");
    By meterForecastsLink=By.linkText("Meter Forecasts");
    By downloadExcel=By.linkText("Download Excel");
    By calConsumptionsBtn=By.id("calculate-consumptions-button");
    By popUpDialogue=By.xpath("//form[@class='vex-dialog-form']");
    By dayConsumption1=By.id("MeterForecasts_0__DayConsumption");
    By dayConsumption2 = By.id("MeterForecasts_1__DayConsumption");
    By nightConsumption1=By.id("MeterForecasts_0__NightConsumption");
    By nightConsumption2 = By.id("MeterForecasts_1__NightConsumption");
    By okButton=By.xpath("//button[text()='OK'");
    By popUpDialogue2 = By.xpath("//form[@class = 'vex-dialog-form']/div[contains(text(), 'Saving changes to the Meter Forecasts will result in the Fixed Calculations being re-calculated for cached entries.')]");
    By quoteIdDropDown=By.id("QuoteId");



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
    public TenderResponsePage clickDownloadExcelLink() throws Throwable{
        click(downloadExcel);
        Thread.sleep(4000);
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

    public TenderResponsePage setFirstDayConsumption(String value) throws Throwable{
        setValue(dayConsumption1,value);
        Thread.sleep(4000);
        return this;
    }

    public TenderResponsePage setFirstNightConsumption(String value) throws Throwable{
        setValue(nightConsumption1,value);
        Thread.sleep(4000);
        return this;
    }
    public void verifyDayConsumptionAndNightConsumption() {
    	SoftAssert softAssertion = new SoftAssert();
    	softAssertion.assertFalse(isElementPresent(popUpDialogue), "Popup dialogue is displaying.");
    	boolean correctDayConsumption2Status = getAttribute(dayConsumption2, "value").equals("80");
    	boolean correctNightConsumption2Status = getAttribute(nightConsumption2, "value").equals("100");
    	softAssertion.assertTrue(correctDayConsumption2Status && correctNightConsumption2Status, "Day consumption and night consumption is displaying incorrect data.");
    	softAssertion.assertAll();
    }
    
}

