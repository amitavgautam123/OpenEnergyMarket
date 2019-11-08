package com.oem.framework.pages;

import com.oem.framework.core.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TenderOpenQuotesPage extends BasePage {


    By tenderQuoteDropDown =By.id("QuoteRequestsForDate");
    By supplierQuoteRequestDropDown=By.id("QuoteRequestsForSupplier");
    By supplierUploadedTable=By.xpath("//h3[contains(text(),'Supplier Uploaded Documents')]");
    By openQuotesBtn=By.xpath("//button[text()='Open Quotes']");
    By errText=By.xpath("//*[@id='supplier-quotes']/div/div/ul/li[text() = 'Please enter duration in months']");

    By duration1stField=By.id("QuoteDurationsToOpen_0__DurationInMonths");
    By duration2ndField=By.id("QuoteDurationsToOpen_1__DurationInMonths");
    By closeQuotesLink=By.linkText("Close");
    By popUpDialogue=By.xpath("//form[@class='vex-dialog-form']");
    By cancelBtn=By.xpath("//button[text()='Cancel']");
    By okBtn=By.xpath("//button[text()='OK']");

    public boolean isDurationPresenceInOpenQuotes(String duration) {
    	By durationInOpenQuotes = By.xpath("//p[contains(text(),'Duration: " + duration + ", Tolerance %')]");
    	boolean durationPresenceStatus = isElementPresent(durationInOpenQuotes);
    	return durationPresenceStatus;
    }
    
    public TenderOpenQuotesPage verifyQuoteRequestDropDownExist(){
        Assert.assertTrue(isElementPresent(tenderQuoteDropDown),"verifyQuoteRequestDropDownExist didnt appear");
        return this;
    }

    public TenderOpenQuotesPage selectFirstValueInQuoteRequest() throws Throwable{
        selectByIndex(tenderQuoteDropDown,1);
        Thread.sleep(2000);
        return this;
    }
    public TenderOpenQuotesPage selectSecondValueInQuoteRequest() throws Throwable{
        selectByIndex(tenderQuoteDropDown,2);
        Thread.sleep(2000);
        return this;
    }

    public TenderOpenQuotesPage selectFirstValueInSupplierQuote() throws Throwable{
        selectByIndex(supplierQuoteRequestDropDown,1);
        Thread.sleep(2000);
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
    public TenderOpenQuotesPage clickOpenQuotesBtn() throws Throwable{
        scrollToElement(openQuotesBtn);
        Thread.sleep(1000);
    	click(openQuotesBtn);
    	Thread.sleep(2000);
        return this;
    }
    public TenderOpenQuotesPage verifyErrorTextOpenQuotes(){
        Assert.assertTrue(isElementPresent(errText),"Error Text for OpenQuotes  didnt appear");
        return this;
    }

    public TenderOpenQuotesPage setATenderDurationAndVerifyPresenceInOpenQuotes() throws Throwable{
        scrollToElement(openQuotesBtn);
    	setValue(duration1stField, readExcelData("Sheet7", 1, 2));
    	clickOpenQuotesBtn();
    	scrollUp();
    	Thread.sleep(1000);
    	boolean durationDisplayStatus = isDurationPresenceInOpenQuotes(readExcelData("Sheet7", 1, 2));
    	Assert.assertTrue(durationDisplayStatus, "The duration entered in first field is not displaying.");
        return this;
    }
    public TenderOpenQuotesPage setMultipleDurationAndVerifyPresenceInOpenQuotes() throws Throwable{
    	SoftAssert softAssertion = new SoftAssert();
    	scrollToElement(openQuotesBtn);
    	Thread.sleep(1000);
    	setValue(duration1stField, readExcelData("Sheet7", 2, 2));
    	setValue(duration2ndField, readExcelData("Sheet7", 3, 2));
    	clickOpenQuotesBtn();
    	scrollUp();
    	Thread.sleep(1000);
    	boolean duration1DisplayStatus = isDurationPresenceInOpenQuotes(readExcelData("Sheet7", 2, 2));
    	softAssertion.assertTrue(duration1DisplayStatus, "The duration entered in first field is not displaying.");
    	boolean duration2DisplayStatus = isDurationPresenceInOpenQuotes(readExcelData("Sheet7", 3, 2));
    	softAssertion.assertTrue(duration2DisplayStatus, "The duration entered in second field is not displaying.");
        return this;
    }
    

    public TenderOpenQuotesPage verifyPopUpDialogue(){
        Assert.assertTrue(isElementPresent(popUpDialogue,3),"Popup Dialogue didn't appear");
        return this;
    }
    public TenderOpenQuotesPage clickCancelInPopUp() throws Throwable{
        click(cancelBtn);
        Thread.sleep(1000);
        return this;
    }

    public TenderOpenQuotesPage clickOkInPopUp() throws Throwable{
        click(okBtn);
        Thread.sleep(2000);
        return this;
    }

    public TenderOpenQuotesPage clickCloseQuotesLink() throws Throwable{
        scrollUp();
        driver.findElements(closeQuotesLink).get(0).click();
        Thread.sleep(2000);
        return this;
    }
    

}
