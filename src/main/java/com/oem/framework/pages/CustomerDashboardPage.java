package com.oem.framework.pages;

import com.oem.framework.core.base.BasePage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CustomerDashboardPage extends HeaderPage {

    By portfolioMgr= By.xpath("//*[@id='accordian-menu']//li[3]/h3");
    By companyProfile=By.linkText("Company Profile");
    By portfolioCalendar = By.linkText("Portfolio Calendar");
    By propertyPortfolio = By.linkText("Property Portfolio");
    By siteFirstRecord = By.xpath("//div[@id = 'divSitesOverview']/hgroup[1]/table/tbody/tr/td[1]");
    By tipCloseBtn = By.xpath("//p[contains(text(),'Tip')]/following-sibling::a");
    
    By quotesAndTenders = By.xpath("//div[@id = 'accordian-menu']//li[4]/h3");
    By requestAQuoteLink = By.xpath("//li[@id = 'sidebar-request-quote']/a");
    By reviewQuoteLink = By.xpath("//li[@data-controller = 'ReviewQuotes']/a");
    By flexManagement = By.xpath("//h3[contains(text(),'Flex Management')]");
    By flexProfileMgr = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[1]/a");
    By strategyProfile = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[2]/a");
    By riskProfile = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[3]/a");
    By flexReporting = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[4]/a");
    By tradeReporting = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[5]/a");
    
    By rightProfile=By.id("user-link");
    By logOut=By.xpath("//a[text()='Log out']");

    By unImpersonatenButton=By.id("unImpersonateBtn");

    public void clickUnImpersonateButton(){
    click(unImpersonatenButton);
    
    }
    
    public CompanyProfilePage goToCompanyProfile()	{
        click(portfolioMgr);
        click(companyProfile);
        CompanyProfilePage companyProfilePage=new CompanyProfilePage();
        companyProfilePage.isLoaded();
        return companyProfilePage;
    }
    public CompanyProfilePage clickCompanyProfile()	{
        click(companyProfile);
        CompanyProfilePage companyProfilePage=new CompanyProfilePage();
        companyProfilePage.isLoaded();
        return companyProfilePage;
    }
    
    public PortfolioCalendarPage goToPortfolioCalendar(){
        click(portfolioMgr);
        click(portfolioCalendar);
        PortfolioCalendarPage portfolioCalendarPage=new PortfolioCalendarPage();
        portfolioCalendarPage.isLoaded();
        return portfolioCalendarPage;
    }
    public PortfolioCalendarPage clickPortfolioCalendar(){
        click(portfolioCalendar);
        PortfolioCalendarPage portfolioCalendarPage=new PortfolioCalendarPage();
        portfolioCalendarPage.isLoaded();
        return portfolioCalendarPage;
    }
    
    public PropertyPortfolioPage goToPropertyPortfolio() throws AWTException{
        click(portfolioMgr);
        click(propertyPortfolio);
        PropertyPortfolioPage propertyPortfolioPage=new PropertyPortfolioPage();
        propertyPortfolioPage.isLoaded();
        return propertyPortfolioPage;
    }
    
    public PropertyPortfolioPage clickPropertyPortfolio() throws AWTException{
        click(propertyPortfolio);
        PropertyPortfolioPage propertyPortfolioPage=new PropertyPortfolioPage();
        propertyPortfolioPage.isLoaded();
        return propertyPortfolioPage;
    }
    
    public PropertyPortfolioMeterPage goToPropertyPortfolioMeterPage() throws Throwable{
        click(portfolioMgr);
        click(propertyPortfolio);
        click(siteFirstRecord);
        Thread.sleep(2000);
        try {
			click(tipCloseBtn);
		}
		catch(Exception e) {
			System.out.println("Tip message didn't appear");
		}
        PropertyPortfolioMeterPage propertyPortfolioMeterPage=new PropertyPortfolioMeterPage();
        propertyPortfolioMeterPage.isLoaded();
        return propertyPortfolioMeterPage; 
    }
    public PropertyPortfolioMeterPage refreshPropertyPortfolioMeterPage() throws Throwable{
        driver.navigate().refresh();
        Thread.sleep(2000);
        try {
			click(tipCloseBtn);
		}
		catch(Exception e) {
			System.out.println("Tip message didn't appear");
		}
        scrollUp();
        PropertyPortfolioMeterPage propertyPortfolioMeterPage=new PropertyPortfolioMeterPage();
        propertyPortfolioMeterPage.isLoaded();
        return propertyPortfolioMeterPage; 
    }
    
    public RequestQuotePage goToRequestQuote() throws Throwable{
        click(quotesAndTenders);
        Thread.sleep(1000);
        click(requestAQuoteLink);
        RequestQuotePage requestQuotePage=new RequestQuotePage();
        requestQuotePage.isLoaded();
        return requestQuotePage;
    }
    public RequestQuotePage clickRequestQuote(){
    	driver.navigate().refresh();
        click(requestAQuoteLink);
        RequestQuotePage requestQuotePage=new RequestQuotePage();
        requestQuotePage.isLoaded();
        return requestQuotePage;
    }
    
    public ReviewQuoteCustomerPage goToReviewQuotes() throws Throwable{
        click(quotesAndTenders);
        Thread.sleep(1000);
        click(reviewQuoteLink);
        ReviewQuoteCustomerPage reviewQuoteCustomerPage=new ReviewQuoteCustomerPage();
        reviewQuoteCustomerPage.isLoaded();
        return reviewQuoteCustomerPage;
    }
    public CustomerDashboardPage goToFlexibleProfileManager() throws Throwable{
        click(flexManagement);
        Thread.sleep(3000);
        click(flexProfileMgr);
        FlexProfileManagerPage flexProfileManagerPage=new FlexProfileManagerPage();
        flexProfileManagerPage.isLoaded();
        return flexProfileManagerPage;
    }
    public void logOut(){
    	click(rightProfile);
    	click(logOut);
    }


    @Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in CustomerDashboard Page");
        Assert.assertTrue(isElementPresent(portfolioMgr),"Customer Dashboard Page didnt appear");
    }

    public void verifyPortfolioManagerElementExists(){
           verifyElementPresent(portfolioMgr);
    }
}
   