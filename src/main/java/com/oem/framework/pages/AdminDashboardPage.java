package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class AdminDashboardPage extends HeaderPage {

    By impersonateUsername=By.id("ImpersonateUserName");
    By impersonateBtn=By.id("impersonateBtn");
    By fixedProcurementAdmin=By.xpath("//*[@id=\"accordian-menu\"]//h3[text()='Fixed Procurement Admin']");
    By tenderOpenQuotes=By.linkText("Tender Open Quotes");
    By tenderResponseLnk=By.linkText("Tender Response");
    By tenderReQuoteLink = By.linkText("Tender Re-Quote");
    By manageTendersLink = By.linkText("Manage Tenders");
    By tenderHistoryLink = By.linkText("Tender History");
    By tenderQuoteDropDown =By.id("QuoteRequestsForDate");
    By verifyTenders = By.xpath("//li[@data-action = 'VerifyTenders']/a");
    By flexprocAdmin=By.xpath("//h3[contains(text(),'Flex Procurement Admin')]");
    By flexTenderResponse=By.xpath("//li[5]//ul[1]//li[1]//a[1]");

    By user=By.xpath("//a[@id='user-link']");
	By logout=By.xpath("//a[contains(text(),'Log out')]");
	By dashBoard=By.linkText("Dashboard");
	By flexProfileAdmin=By.xpath("//a[@href='/FlexibleProfileAdmin/CustomerOverview']");
	By flexReQouteTender=By.linkText("Flex Re-Quote Tender");
	
    public CustomerDashboardPage impersonate(String email) throws Throwable{
        setValue(impersonateUsername,email);
        Thread.sleep(1000);
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
    public CustomerDashboardPage impersonateFlexCustomer() throws Throwable{
    	String EMAIL = getPropertyFileData("emailForFlex");
        setValue(impersonateUsername, EMAIL);
        click(impersonateBtn);
        return new CustomerDashboardPage();
    }

    public TenderOpenQuotesPage navigateToTenderQuotes() throws Throwable{
        click(fixedProcurementAdmin);
        Thread.sleep(2000);
        click(tenderOpenQuotes);
        return new TenderOpenQuotesPage();
    }
    public TenderResponsePage navigateToTenderResponse() throws Throwable{
    	 click(fixedProcurementAdmin);
    	 Thread.sleep(2000);
    	 click(tenderResponseLnk);
         return new TenderResponsePage();
    }
    public TenderResponsePage clickOnTenderResponse() throws Throwable{
   	 click(tenderResponseLnk);
   	 Thread.sleep(3000);
        return new TenderResponsePage();
   }
    public TenderRequotePage goToTenderReQuotePage() throws Throwable{
    	click(fixedProcurementAdmin);
   	 	Thread.sleep(2000);
   	 	click(tenderReQuoteLink);
   	 	Thread.sleep(3000);
        TenderRequotePage tenderRequotePage=new TenderRequotePage();
        tenderRequotePage.isLoaded();
    	return tenderRequotePage;
    }
    public ManageTendersPage goToManageTendersPage() throws Throwable{
    	click(fixedProcurementAdmin);
   	 	Thread.sleep(2000);
   	 	click(manageTendersLink);
   	 	Thread.sleep(3000);
        ManageTendersPage manageTendersPage=new ManageTendersPage();
        manageTendersPage.isLoaded();
    	return manageTendersPage;
    }
    public ManageTendersPage goToTenderHistoryPage() throws Throwable{
    	click(fixedProcurementAdmin);
   	 	Thread.sleep(2000);
   	 	click(tenderHistoryLink);
   	 	Thread.sleep(3000);
        ManageTendersPage manageTendersPage=new ManageTendersPage();
        manageTendersPage.isLoaded();
    	return manageTendersPage;
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
    public void goToAdminDashBoard(){
    	click(dashBoard);    	
    }
    public void verifyAdminHomePage(){
    	boolean impersonatePresence=isElementPresent(impersonateUsername);
    	Assert.assertTrue(impersonatePresence, "Admin Home page is not displyed");
    }
    public void clickAdminDashBoard(){
    	
    	click(dashBoard);
    	
    	}
    public void logOut() throws Throwable{
		click(user);
		Thread.sleep(1000);
		click(logout);
	}
    public void refreshpage(){
		driver.navigate().refresh();
	}
    public AdminDashboardPage goToflexProfileAdmin() throws Throwable{
    	click(flexprocAdmin);
    	Thread.sleep(2000);

    	click(flexProfileAdmin);
    	Thread.sleep(4000);
    	FlexProfileAdminPage flexProfileAdminPage=new FlexProfileAdminPage();
    	flexProfileAdminPage.isLoaded();
    	return new FlexProfileAdminPage();
    }
    public AdminDashboardPage clickflexProfileAdmin() throws Throwable{
    	click(flexProfileAdmin);
    	Thread.sleep(4000);
    	FlexProfileAdminPage flexProfileAdminPage=new FlexProfileAdminPage();
    	flexProfileAdminPage.isLoaded();
    	return new FlexProfileAdminPage();
    }
    public AdminDashboardPage goToFlexReQuoteTenderPage() throws Throwable{
    	click(flexprocAdmin);
    	Thread.sleep(3000);

    	click(flexReQouteTender);
    	FlexReQuoteTenderPage flexReQuoteTenderPage=new FlexReQuoteTenderPage();
    	flexReQuoteTenderPage.isLoaded();
    	return new FlexReQuoteTenderPage();
    }
    


    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(isElementPresent(impersonateUsername),"Admin Dashboard page didnt appear");

    }
}
