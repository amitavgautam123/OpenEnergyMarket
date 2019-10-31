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
    By duration2ndField=By.id("QuoteDurationsToOpen_1__DurationInMonths");
    By closeQuotesLink=By.linkText("Close");
    By popUpDialogue=By.xpath("//form[@class='vex-dialog-form']");
    By cancelBtn=By.xpath("//button[text()='Cancel']");
    By okBtn=By.xpath("//button[text()='OK']");

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
    public TenderOpenQuotesPage set2ndTenderDuration(String text){
        setValue(duration2ndField,text);
        return this;
    }

    public TenderOpenQuotesPage verifyPopUpDialogue(){
        Assert.assertTrue(isElementPresent(popUpDialogue,3),"Popup Dialogue didn't appear");
        return this;
    }
    public TenderOpenQuotesPage clickCancelInPopUp(){
        click(cancelBtn);
        return this;
    }

    public TenderOpenQuotesPage clickOkInPopUp(){
        click(okBtn);
        return this;
    }

    public TenderOpenQuotesPage clickCloseQuotesLink(){
        scrollUp();
        driver.findElements(closeQuotesLink).get(0).click();
        return this;
    }

}
