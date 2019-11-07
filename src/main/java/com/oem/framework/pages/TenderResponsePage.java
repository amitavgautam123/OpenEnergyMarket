package com.oem.framework.pages;

import com.oem.framework.core.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TenderResponsePage extends BasePage {


    By quoteByDateDropDown =By.id("QuoteByDate");
    By quoteRequestByIdDropDown=By.id("QuoteRequestId");
    By meterForecastsLink=By.linkText("Meter Forecasts");
    By downloadExcel=By.linkText("Download Excel");
    By calConsumptionsBtn=By.id("calculate-consumptions-button");
    By popUpDialogue=By.xpath("//form[@class='vex-dialog-form']");
    By dayConsumption1=By.id("MeterForecasts_0__DayConsumption");
    By nightConsumption1=By.id("MeterForecasts_0__NightConsumption");
    By okButton=By.xpath("//button[text()='OK'");

    By quoteIdDropDown=By.id("QuoteId");



    public TenderResponsePage verifyQuoteByDateExist(){
        Assert.assertTrue(isElementPresent(quoteByDateDropDown),"quoteByDateDropDown didnt appear");
        return this;
    }
    @Override
    protected void isLoaded() throws Error {
        verifyQuoteByDateExist();
    }

    public TenderResponsePage selectFirstValueInQuoteByDate() throws Throwable{
        selectByIndex(quoteByDateDropDown,1);
        Thread.sleep(2000);
        return this;
    }

    public TenderResponsePage selectFirstValueQuoteRequest() throws Throwable{
        selectByIndex(quoteRequestByIdDropDown,1);
        Thread.sleep(2000);
        return this;
    }

    public TenderResponsePage verifyQuoteRequestDropDownExists() throws Throwable{
        Assert.assertTrue(isElementPresent(quoteRequestByIdDropDown),"quoteRequestByIdDropDown didnt appear");
        Thread.sleep(2000);
        return this;
    }

    public TenderResponsePage verifyMeterForecastLinkExists() throws Throwable{
        Assert.assertTrue(isElementPresent(meterForecastsLink,4),"meterForecastsLink didnt appear");
        Thread.sleep(2000);
        return this;
    }
    public TenderResponsePage clickMeterForecastLink() throws Throwable{
        click(meterForecastsLink);
        Thread.sleep(2000);
        return this;
    }
    public TenderResponsePage clickDownloadExcelLink() throws Throwable{
        click(downloadExcel);
        Thread.sleep(2000);
        return this;
    }
    public TenderResponsePage clickCalculateConsumptions() throws Throwable{
        click(calConsumptionsBtn);
        Thread.sleep(2000);
        return this;
    }

    public TenderResponsePage verifyPopUpDialogue() throws Throwable{
        staticWait(2);
        Thread.sleep(2000);
      //  driver.switchTo().alert();
        Assert.assertTrue(isElementPresent(popUpDialogue,3),"Popup Dialogue didn't appear");
        //driver.switchTo().
        click(By.xpath("//button[text()='OK']"));
        return this;
    }

    public TenderResponsePage setFirstDayConsumption(String value) throws Throwable{
        setValue(dayConsumption1,value);
        Thread.sleep(2000);
        return this;
    }

    public TenderResponsePage setFirstNightConsumption(String value) throws Throwable{
        setValue(nightConsumption1,value);
        Thread.sleep(2000);
        return this;
    }
}

