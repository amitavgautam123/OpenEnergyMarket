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
    
    By forecasting = By.linkText("Forecasting");
    
    By rightProfile=By.id("user-link");
    By logOut=By.xpath("//a[text()='Log out']");

    By unImpersonatenButton=By.id("unImpersonateBtn");

    public void clickUnImpersonateButton(){
    click(unImpersonatenButton);
    
    }
    
    public CompanyProfilePage goToCompanyProfile() throws Throwable	{
        click(portfolioMgr);
        Thread.sleep(2000);
        click(companyProfile);
        CompanyProfilePage companyProfilePage=new CompanyProfilePage();
        companyProfilePage.isLoaded();
        return companyProfilePage;
    }
    public CompanyProfilePage clickCompanyProfile() throws Throwable	{
        click(companyProfile);
        Thread.sleep(2000);
        CompanyProfilePage companyProfilePage=new CompanyProfilePage();
        companyProfilePage.isLoaded();
        return companyProfilePage;
    }
    
    public PortfolioCalendarPage goToPortfolioCalendar() throws Throwable{
        click(portfolioMgr);
        Thread.sleep(2000);
        click(portfolioCalendar);
        PortfolioCalendarPage portfolioCalendarPage=new PortfolioCalendarPage();
        portfolioCalendarPage.isLoaded();
        return portfolioCalendarPage;
    }
    public PortfolioCalendarPage clickPortfolioCalendar() throws Throwable{
        click(portfolioCalendar);
        Thread.sleep(2000);
        PortfolioCalendarPage portfolioCalendarPage=new PortfolioCalendarPage();
        portfolioCalendarPage.isLoaded();
        return portfolioCalendarPage;
    }
    
    public PropertyPortfolioPage goToPropertyPortfolio() throws AWTException, Throwable{
        click(portfolioMgr);
        Thread.sleep(2000);
        click(propertyPortfolio);
        PropertyPortfolioPage propertyPortfolioPage=new PropertyPortfolioPage();
        propertyPortfolioPage.isLoaded();
        return propertyPortfolioPage;
    }
    
    public PropertyPortfolioPage clickPropertyPortfolio() throws AWTException, Throwable{
        click(propertyPortfolio);
        Thread.sleep(2000);
        PropertyPortfolioPage propertyPortfolioPage=new PropertyPortfolioPage();
        propertyPortfolioPage.isLoaded();
        return propertyPortfolioPage;
    }
    
    public PropertyPortfolioMeterPage goToPropertyPortfolioMeterPage() throws Throwable{
        click(portfolioMgr);
        Thread.sleep(2000);
        click(propertyPortfolio);
        Thread.sleep(2000);
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
        Thread.sleep(2000);
        click(requestAQuoteLink);
        RequestQuotePage requestQuotePage=new RequestQuotePage();
        requestQuotePage.isLoaded();
        return requestQuotePage;
    }
    public RequestQuotePage clickRequestQuote() throws Throwable	{
    	driver.navigate().to(getPropertyFileData("homePageUrl") + readExcelData("Sheet4", 1, 6));
    	Thread.sleep(4000);
    	//driver.navigate().refresh();
        //click(requestAQuoteLink);
        RequestQuotePage requestQuotePage=new RequestQuotePage();
        //requestQuotePage.isLoaded();
        return requestQuotePage;
    }
    
    public ReviewQuoteCustomerPage goToReviewQuotes() throws Throwable{
        click(quotesAndTenders);
        Thread.sleep(2000);
        click(reviewQuoteLink);
        ReviewQuoteCustomerPage reviewQuoteCustomerPage=new ReviewQuoteCustomerPage();
        reviewQuoteCustomerPage.isLoaded();
        return reviewQuoteCustomerPage;
    }
    public FlexProfileManagerPage goToFlexibleProfileManager() throws Throwable{
        click(flexManagement);
        Thread.sleep(2000);
        click(flexProfileMgr);
        FlexProfileManagerPage flexProfileManagerPage=new FlexProfileManagerPage();
        flexProfileManagerPage.isLoaded();
        return flexProfileManagerPage;
    }
    public FlexProfileManagerPage clickFlexibleProfileManager() throws Throwable{
        click(flexProfileMgr);
        Thread.sleep(4000);
        FlexProfileManagerPage flexProfileManagerPage=new FlexProfileManagerPage();
        flexProfileManagerPage.isLoaded();
        return flexProfileManagerPage;
    }
    public ForecastingPage goToForecastingPage() throws Throwable{
        click(forecasting);
        Thread.sleep(2000);
        ForecastingPage forecastingPage=new ForecastingPage();
        forecastingPage.isLoaded();
        return forecastingPage; 
    }
    public void logOut() throws Throwable{
    	click(rightProfile);
    	Thread.sleep(2000);
    	click(logOut);
    }


    @Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in CustomerDashboard Page");
        Assert.assertTrue(isElementPresent(portfolioMgr),"Customer Dashboard Page didnt appear");
    }

    public void verifyPortfolioManagerElementExists() throws Throwable{
    	Thread.sleep(2000);
           verifyElementPresent(portfolioMgr);
    }
}
   