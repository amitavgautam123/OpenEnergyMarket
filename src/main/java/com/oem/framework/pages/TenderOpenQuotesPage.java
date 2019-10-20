package com.oem.framework.pages;

import com.oem.framework.core.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TenderOpenQuotesPage extends BasePage {


    By tenderQuoteDropDown =By.id("QuoteRequestsForDate");
    By supplierQuoteRequestDropDown=By.id("QuoteRequestsForSupplier");
    By supplierUploadedTable=By.id("uploaded-documents");
    By openQuotesBtn=By.xpath("//button[text()='Open Quotes']");
    By errText=By.xpath("//*[@id=\"supplier-quotes\"]/div/div/ul/li");

    By durationInMonths=By.id("QuoteDurationsToOpen_0__DurationInMonths");

    public TenderOpenQuotesPage verifyQuoteRequestDropDownExist(){
        Assert.assertTrue(isElementPresent(tenderQuoteDropDown),"verifyQuoteRequestDropDownExist didnt appear");
        return this;
    }

    public TenderOpenQuotesPage selectFirstValueInQuoteRequest(){
        selectByIndex(tenderQuoteDropDown,1);
        return this;
    }

    public TenderOpenQuotesPage selectFirstValueInSupplierQuote(){
        selectByIndex(supplierQuoteRequestDropDown,1);
        return this;
    }
    public TenderOpenQuotesPage verifySupplierQuotetDropDownExist(){
        Assert.assertTrue(isElementPresent(supplierQuoteRequestDropDown),"supplierQuoteRequestDropDown didnt appear");
        return this;
    }


    public TenderOpenQuotesPage verifySuplierUploadTable(){
        Assert.assertTrue(isElementPresent(supplierUploadedTable),"supplierUploadedTable Details didnt appear");
        return this;
    }

    @Override
    protected void isLoaded() throws Error {
        verifyQuoteRequestDropDownExist();

    }
    public TenderOpenQuotesPage clickOpenQuotesBtn(){
        click(openQuotesBtn);
        return this;
    }
    public TenderOpenQuotesPage verifyErrorTextOpenQuotes(){
        Assert.assertTrue(isElementPresent(errText),"Error Text for OpenQuotes  didnt appear");
        return this;
    }

    public TenderOpenQuotesPage setTenderDuration(String text){
        setValue(durationInMonths,text);
        return this;
    }
}
