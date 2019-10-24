package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.oem.framework.core.base.BasePage;

public class SupplierDashboardPage extends BasePage {

	By tendersAndAlertsLink = By.xpath("//li[@data-action = 'Requests']/a/h3");
	By reviewQuotes = By.linkText("Review Quotes");
	
	public SupplierDashboardPage goToTendersAndAlerts(){
        click(tendersAndAlertsLink);
        TendersAndAlertsPage tendersAndAlertsPage=new TendersAndAlertsPage();
        tendersAndAlertsPage.isLoaded();
        return tendersAndAlertsPage;
    }
	public SupplierDashboardPage goToReviewQuotes(){
        click(reviewQuotes);
        ReviewQuotesPage reviewQuotesPage=new ReviewQuotesPage();
        reviewQuotesPage.isLoaded();
        return reviewQuotesPage;
    }
	
	
	@Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in Supplier Dashboard Page");
        Assert.assertTrue(isElementPresent(tendersAndAlertsLink),"Supplier Dashboard Page didnt appear");
        
    }
}
