package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class AdminDashboardPage extends HeaderPage {

    By impersonateUsername=By.id("ImpersonateUserName");
    By impersonateBtn=By.id("impersonateBtn");
    By fixedProcurementAdmin=By.xpath("//*[@id=\"accordian-menu\"]//h3[text()='Fixed Procurement Admin']");
    By tenderOpenQuotes=By.linkText("Tender Open Quotes");
    By tenderResponseLnk=By.linkText("Tender Response");
    By tenderQuoteDropDown =By.id("QuoteRequestsForDate");
    By verifyTenders = By.xpath("//li[@data-action = 'VerifyTenders']/a");




    public CustomerDashboardPage impersonate(String email){
        setValue(impersonateUsername,email);
        click(impersonateBtn);
        return new CustomerDashboardPage();
    }
    
    public SupplierDashboardPage impersonateSupplier() throws Throwable{
    	String EMAIL = getPropertyFileData("supplierEmail");
        setValue(impersonateUsername, EMAIL);
        click(impersonateBtn);
        return new SupplierDashboardPage();
    }

    public TenderOpenQuotesPage navigateToTenderQuotes() throws Throwable{
        click(fixedProcurementAdmin);
        click(tenderOpenQuotes);
        return new TenderOpenQuotesPage();
    }


    public TenderResponsePage navigateToTenderResponse() throws Throwable{
        click(fixedProcurementAdmin);
        click(tenderResponseLnk);
        return new TenderResponsePage();
    }
    public AdminDashboardPage goToVerifyTenders(){
        click(verifyTenders);
        VerifyTendersPage verifyTendersPage=new VerifyTendersPage();
        verifyTendersPage.isLoaded();
        return new VerifyTendersPage();
    }


    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(isElementPresent(impersonateUsername),"Admin Dashboard page didnt appear");

    }
}
