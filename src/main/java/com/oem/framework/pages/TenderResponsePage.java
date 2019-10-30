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

    By quoteIdDropDown=By.id("QuoteId");



    public TenderResponsePage verifyQuoteByDateExist(){
        Assert.assertTrue(isElementPresent(quoteByDateDropDown),"quoteByDateDropDown didnt appear");
        return this;
    }
    @Override
    protected void isLoaded() throws Error {
        verifyQuoteByDateExist();
    }

    public TenderResponsePage selectFirstValueInQuoteByDate(){
        selectByIndex(quoteByDateDropDown,1);
        return this;
    }

    public TenderResponsePage selectFirstValueQuoteRequest(){
        selectByIndex(quoteRequestByIdDropDown,1);
        return this;
    }

    public TenderResponsePage verifyQuoteRequestDropDownExists(){
        Assert.assertTrue(isElementPresent(quoteRequestByIdDropDown),"quoteRequestByIdDropDown didnt appear");
        return this;
    }

    public TenderResponsePage verifyMeterForecastLinkExists(){
        Assert.assertTrue(isElementPresent(meterForecastsLink,4),"meterForecastsLink didnt appear");
        return this;
    }
    public TenderResponsePage clickMeterForecastLink(){
        click(meterForecastsLink);
        return this;
    }
    public TenderResponsePage clickDownloadExcelLink(){
        click(downloadExcel);
        return this;
    }
    public TenderResponsePage clickCalculateConsumptions(){
        click(calConsumptionsBtn);
        return this;
    }

    public TenderResponsePage verifyPopUpDialogue(){
        staticWait(1);
        Assert.assertTrue(isElementPresent(popUpDialogue,3),"Popup Dialogue didn't appear");
        return this;
    }
}
