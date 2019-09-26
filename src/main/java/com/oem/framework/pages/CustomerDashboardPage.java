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
    By tipCloseBtn = By.xpath("//p[text() = 'Tip 1 of 1']/following-sibling::a");

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



    @Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in CustomerDashboard Page");
        Assert.assertTrue(isElementPresent(portfolioMgr),"Customer Dashboard Page didnt appear");
    }

    public void verifyPortfolioManagerElementExists(){
           verifyElementPresent(portfolioMgr);
    }


}
