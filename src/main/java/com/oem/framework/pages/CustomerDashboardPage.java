package com.oem.framework.pages;

import com.oem.framework.core.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CustomerDashboardPage extends BasePage {

    By portfolioMgr= By.xpath("//*[@id=\"accordian-menu\"]//li[3]/h3");
    By companyProfile=By.linkText("Company Profile");
    By portfolioCalendar = By.linkText("Portfolio Calendar");
    By propertyPortfolio = By.linkText("Property Portfolio");
    By siteFirstRecord = By.xpath("//div[@id = 'divSitesOverview']/hgroup[1]/table/tbody/tr/td[1]");
    By tipCloseBtn = By.xpath("//p[contains(text(),'Tip')]/following-sibling::a");
    
    By quotesAndTenders = By.xpath("//div[@id = 'accordian-menu']//li[4]/h3");
    By requestAQuoteLink = By.xpath("//li[@id = 'sidebar-request-quote']/a");
    By flexManagement = By.xpath("//h3[contains(text(),'Flex Management')]");
    By flexProfileMgr = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[1]/a");
    By strategyProfile = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[2]/a");
    By riskProfile = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[3]/a");
    By flexReporting = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[4]/a");
    By tradeReporting = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[5]/a");
    
    public CustomerDashboardPage goToCompanyProfile(){
        click(portfolioMgr);
        click(companyProfile);
        CompanyProfilePage companyProfilePage=new CompanyProfilePage();
        companyProfilePage.isLoaded();
        return companyProfilePage;
    }
    
    public CustomerDashboardPage goToPortfolioCalendar(){
        click(portfolioMgr);
        click(portfolioCalendar);
        PortfolioCalendarPage portfolioCalendarPage=new PortfolioCalendarPage();
        portfolioCalendarPage.isLoaded();
        return portfolioCalendarPage;
    }
    
    public CustomerDashboardPage goToPropertyPortfolio(){
        click(portfolioMgr);
        click(propertyPortfolio);
        PropertyPortfolioPage propertyPortfolioPage=new PropertyPortfolioPage();
        propertyPortfolioPage.isLoaded();
        return propertyPortfolioPage;
    }

    public CustomerDashboardPage goToPropertyPortfolioMeterPage() throws Throwable{
        click(portfolioMgr);
        click(propertyPortfolio);
        click(siteFirstRecord);
        Thread.sleep(2000);
        try {
			click(tipCloseBtn);
		}
		catch(Exception e) {
			System.out.println("Couldn't close 'Tip' message");
		}
        PropertyPortfolioMeterPage propertyPortfolioMeterPage=new PropertyPortfolioMeterPage();
        propertyPortfolioMeterPage.isLoaded();
        return propertyPortfolioMeterPage; 
    }
    
    public CustomerDashboardPage goToRequestQuote(){
    	click(quotesAndTenders);
        click(requestAQuoteLink);
        RequestQuotePage requestQuotePage=new RequestQuotePage();
        requestQuotePage.isLoaded();
        return requestQuotePage;
    }
    public CustomerDashboardPage goToFlexibleProfileManager(){
        click(flexManagement);
        click(flexProfileMgr);
        FlexProfileManagerPage flexProfileManagerPage=new FlexProfileManagerPage();
        flexProfileManagerPage.isLoaded();
        return flexProfileManagerPage;
    }
    public CustomerDashboardPage goToStrategyProfile(){
        click(flexManagement);
        click(strategyProfile);
        FlexProfileManagerPage flexProfileManagerPage=new FlexProfileManagerPage();
        flexProfileManagerPage.isLoaded();
        return flexProfileManagerPage;
    }
    public CustomerDashboardPage goToRiskProfile(){
        click(flexManagement);
        click(riskProfile);
        FlexProfileManagerPage flexProfileManagerPage=new FlexProfileManagerPage();
        flexProfileManagerPage.isLoaded();
        return flexProfileManagerPage;
    }
    public CustomerDashboardPage goToFlexReporting(){
        click(flexManagement);
        click(flexReporting);
        FlexProfileManagerPage flexProfileManagerPage=new FlexProfileManagerPage();
        flexProfileManagerPage.isLoaded();
        return flexProfileManagerPage;
    }
    public CustomerDashboardPage goToTradeReporting(){
        click(flexManagement);
        click(tradeReporting);
        FlexProfileManagerPage flexProfileManagerPage=new FlexProfileManagerPage();
        flexProfileManagerPage.isLoaded();
        return flexProfileManagerPage;
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
