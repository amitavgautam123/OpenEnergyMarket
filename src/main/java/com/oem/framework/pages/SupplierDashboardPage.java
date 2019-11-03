package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.testng.Assert;


public class SupplierDashboardPage extends HeaderPage {

	By tendersAndAlertsLink = By.xpath("//li[@data-action = 'Requests']/a/h3");
	By reviewQuotesLink = By.xpath("//li[@id = 'sidebar-review-quotes']/a/h3");

	public TendersAndAlertsPage goToTendersAndAlerts(){
        click(tendersAndAlertsLink);
        TendersAndAlertsPage tendersAndAlertsPage=new TendersAndAlertsPage();
        tendersAndAlertsPage.isLoaded();
        return tendersAndAlertsPage;
    }
	public ReviewQuoteSupplierPage goToReviewQuotes(){
		click(reviewQuotesLink);
        ReviewQuoteSupplierPage reviewQuoteSupplierPage=new ReviewQuoteSupplierPage();
        reviewQuoteSupplierPage.isLoaded();
        return reviewQuoteSupplierPage;
    }
		@Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in Supplier Dashboard Page");
        Assert.assertTrue(isElementPresent(tendersAndAlertsLink),"Supplier Dashboard Page didnt appear");
        
    }
}
