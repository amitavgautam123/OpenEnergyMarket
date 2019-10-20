package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.testng.Assert;


public class SupplierDashboardPage extends HeaderPage {

	By tendersAndAlertsLink = By.xpath("//li[@data-action = 'Requests']/a/h3");
	
	public SupplierDashboardPage goToTendersAndAlerts(){
        click(tendersAndAlertsLink);
        TendersAndAlertsPage tendersAndAlertsPage=new TendersAndAlertsPage();
        tendersAndAlertsPage.isLoaded();
        return tendersAndAlertsPage;
    }
	
	
	@Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in Supplier Dashboard Page");
        Assert.assertTrue(isElementPresent(tendersAndAlertsLink),"Supplier Dashboard Page didnt appear");
        
    }
}
