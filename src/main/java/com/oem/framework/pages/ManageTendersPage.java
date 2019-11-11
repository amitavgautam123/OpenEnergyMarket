package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ManageTendersPage extends AdminDashboardPage{
	
	By hhUtilityFilter = By.xpath("//div[@data-original-title = '<strong>Half Hourly Electricity</strong>']");
	By nHHUtilityFilter = By.xpath("//div[contains(@data-original-title, 'Non Half Hourly Electricity')]");
	By gasUtilityFilter = By.xpath("//div[contains(@data-original-title, 'Gas')]");
	By waterUtilityFilter = By.xpath("//div[contains(@data-original-title, 'Water')]");
	
	
	SoftAssert softAssertion = new SoftAssert();
	
	@Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(isElementPresent(hhUtilityFilter),"Manage Tenders page didn't appear");
    }
	
	public ManageTendersPage verifyUtilityPresence() {
		softAssertion.assertTrue(isElementPresent(hhUtilityFilter), "HH utility filter is not displaying.");
		softAssertion.assertTrue(isElementPresent(nHHUtilityFilter), "NHH utility filter is not displaying.");
		softAssertion.assertTrue(isElementPresent(gasUtilityFilter), "Gas utility filter is not displaying.");
		softAssertion.assertTrue(isElementPresent(waterUtilityFilter), "Water utility filter is not displaying.");
		softAssertion.assertAll();
		return this;
	}
	public ManageTendersPage verifyFixedProcurementSubModulesPresence() {
		softAssertion.assertTrue(isElementPresent(tenderOpenQuotes), "Tender Open Quotes is not displaying.");
		softAssertion.assertTrue(isElementPresent(tenderResponseLnk), "Tender Response is not displaying.");
		softAssertion.assertTrue(isElementPresent(tenderReQuoteLink), "Tender Requote is not displaying.");
		softAssertion.assertTrue(isElementPresent(manageTendersLink), "Manage Tender is not displaying.");
		softAssertion.assertAll();
		return this;
	}
			
}
