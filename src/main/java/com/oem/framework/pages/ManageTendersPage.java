package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ManageTendersPage extends AdminDashboardPage{
	
	By hhUtilityFilter = By.xpath("//div[@data-original-title = '<strong>Half Hourly Electricity</strong>']");
	By nHHUtilityFilter = By.xpath("//div[contains(@data-original-title, 'Non Half Hourly Electricity')]");
	By gasUtilityFilter = By.xpath("//div[contains(@data-original-title, 'Gas')]");
	By waterUtilityFilter = By.xpath("//div[contains(@data-original-title, 'Water')]");
	
	By hhList = By.xpath("//table[@id = 'close-quote-requests']/tbody/tr/td[@class = 'utility' and text() = 'HH']");
	By gasList = By.xpath("//table[@id = 'close-quote-requests']/tbody/tr/td[@class = 'utility' and text() = 'Gas']");
	By nHHList = By.xpath("//table[@id = 'close-quote-requests']/tbody/tr/td[@class = 'utility' and text() = 'nHH']");
	
	
	
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
		softAssertion.assertTrue(isElementPresent(tenderHistoryLink), "Manage Tender is not displaying.");
		softAssertion.assertAll();
		return this;
	}
	public ManageTendersPage verifyHHutilityBind() throws Throwable {
		click(hhUtilityFilter);
		Thread.sleep(2000);
		boolean nHHtendersPresenceStatus = isElementExistInList(hhList, "nHH");
		softAssertion.assertFalse(nHHtendersPresenceStatus, "NHH tenders are dislaying in HH list");
		boolean gasTendersPresenceStatus = isElementExistInList(hhList, "Gas");
		softAssertion.assertFalse(gasTendersPresenceStatus, "Gas tenders are dislaying in HH list");
		softAssertion.assertAll();
		return this;
	}
	public ManageTendersPage verifyNHHutilityBind() throws Throwable {
		click(nHHUtilityFilter);
		Thread.sleep(2000);
		boolean nHHtendersPresenceStatus = isElementExistInList(nHHList, "HH");
		softAssertion.assertFalse(nHHtendersPresenceStatus, "HH tenders are dislaying in NHH list");
		boolean gasTendersPresenceStatus = isElementExistInList(nHHList, "Gas");
		softAssertion.assertFalse(gasTendersPresenceStatus, "Gas tenders are dislaying in NHH list");
		softAssertion.assertAll();
		return this;
	}
	public ManageTendersPage verifyGasUtilityBind() throws Throwable {
		click(nHHUtilityFilter);
		Thread.sleep(2000);
		boolean hhTendersPresenceStatus = isElementExistInList(gasList, "HH");
		softAssertion.assertFalse(hhTendersPresenceStatus, "HH tenders are dislaying in Gas list");
		boolean nHHtendersPresenceStatus = isElementExistInList(gasList, "nHH");
		softAssertion.assertFalse(nHHtendersPresenceStatus, "NHH tenders are dislaying in Gas list");
		softAssertion.assertAll();
		return this;
	}
	
	
	
			
}
