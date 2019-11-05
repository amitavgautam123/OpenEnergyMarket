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
    By flexprocAdmin=By.xpath("//h3[contains(text(),'Flex Procurement Admin')]");
    By flexTenderResponse=By.xpath("//li[5]//ul[1]//li[1]//a[1]");

    By user=By.xpath("//a[@id='user-link']");
	By logout=By.xpath("//a[contains(text(),'Log out')]");

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
    public CustomerDashboardPage impersonateCustomer() throws Throwable{
    	String EMAIL = getPropertyFileData("email");
        setValue(impersonateUsername, EMAIL);
        click(impersonateBtn);
        return new CustomerDashboardPage();
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



    public VerifyTendersPage goToVerifyTenders(){
        click(verifyTenders);
        VerifyTendersPage verifyTendersPage=new VerifyTendersPage();
        verifyTendersPage.isLoaded();
        return new VerifyTendersPage();
    }
    public AdminDashboardPage goFlexTenderResponse() throws Throwable{
        click(flexprocAdmin);
        Thread.sleep(2000);
        
        click(flexTenderResponse);
        FlexTenderResponsePage flexTenderResponsePage=new FlexTenderResponsePage();
        flexTenderResponsePage.isLoaded();
        return new FlexTenderResponsePage();
    }
    public void verifyAdminHomePage(){
    	boolean impersonatePresence=isElementPresent(impersonateUsername);
    	Assert.assertTrue(impersonatePresence, "Admin Home page is not displyed");
    }
    public void logOut(){
		click(user);
		click(logout);
	}
    public void refreshpage(){
		driver.navigate().refresh();
	}

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(isElementPresent(impersonateUsername),"Admin Dashboard page didnt appear");

    }
}
