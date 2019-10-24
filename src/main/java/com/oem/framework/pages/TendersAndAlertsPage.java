package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class TendersAndAlertsPage extends SupplierDashboardPage{
	
	By tendersAndAlertsLink = By.xpath("//li[@data-action = 'Requests']/a/h3");
	By quoteRequestStatusDropdown = By.id("SelectedStatus");
	By allUtilitiesFilter = By.xpath("//div[@class='filter-icons']//div/p[text() = 'ALL']");
	By hhUtilityFilter = By.xpath("//div[@data-original-title = '<strong>Half Hourly Electricity</strong>']");
	By nhhUtilityFilter = By.xpath("//div[@data-original-title = '<strong>Non Half Hourly Electricity</strong>']");
	By gasUtilityFilter = By.xpath("//div[@data-original-title = '<strong>Gas</strong>']");
	By waterUtilityFilter = By.xpath("//div[@data-original-title = '<strong>Water</strong>']");
	
	
	By submitPricesBtnFirstRecord = By.xpath("//table[@id='accept-decline-table']/tbody/tr[1]/td[9]/a");
	
	
	@Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in Supplier Dashboard Page");
        Assert.assertTrue(isElementPresent(tendersAndAlertsLink),"Supplier Dashboard Page didnt appear");
        
    }
	public void validateQuoteRequestStatusDropdownPresence() {
		boolean quoteRequestStatusDropdownPresenceStatus = isElementPresent(quoteRequestStatusDropdown);
		Assert.assertTrue(quoteRequestStatusDropdownPresenceStatus, "Quote Request status dropdown is not displaying.");
	}
	public void validateQuoteRequestStatusDropdown()	{
		SoftAssert softAssertion = new SoftAssert();
		boolean inProgressOptionPresenceStatus = isElementExistInDropDown(quoteRequestStatusDropdown, "In Progress");
		softAssertion.assertTrue(inProgressOptionPresenceStatus, "In Progress option is not present in the dropdown");
		boolean acceptedOptionPresenceStatus = isElementExistInDropDown(quoteRequestStatusDropdown, "Accepted");
		softAssertion.assertTrue(acceptedOptionPresenceStatus, "Accepted option is not present in the dropdown");
		boolean expiredOptionPresenceStatus = isElementExistInDropDown(quoteRequestStatusDropdown, "Expired");
		softAssertion.assertTrue(expiredOptionPresenceStatus, "Expired option is not present in the dropdown");
		softAssertion.assertAll();
	}
	public void validatingPresenceOfUtilities()		{
		SoftAssert softAssertion = new SoftAssert();
		boolean hhFilterPresenceStatus = isElementPresent(hhUtilityFilter);
		softAssertion.assertTrue(hhFilterPresenceStatus, "HH Utility filter is not displaying");
		boolean nhhFilterPresenceStatus = isElementPresent(nhhUtilityFilter);
		softAssertion.assertTrue(nhhFilterPresenceStatus, "NHH Utility filter is not displaying");
		boolean gasFilterPresenceStatus = isElementPresent(gasUtilityFilter);
		softAssertion.assertTrue(gasFilterPresenceStatus, "Gas Utility filter is not displaying");
		boolean waterUtilityFilterPresenceStatus = isElementPresent(waterUtilityFilter);
		softAssertion.assertTrue(waterUtilityFilterPresenceStatus, "Water Utility filter is not displaying");
		boolean allUtilitiesFilterPresenceStatus = isElementPresent(allUtilitiesFilter);
		softAssertion.assertTrue(allUtilitiesFilterPresenceStatus, "All Utility filter is not displaying");		
		softAssertion.assertAll();
	}
	/*public void validateSubmitPricePage() {
		selectByVisibleText(quoteRequestStatusDropdown, "In Progress");
		Reporter.log("Clicked on In Progress in Status dropdown", true);
		click(submitPricesBtnFirstRecord);
		Reporter.log("Clicked on In Progress button", true);
		
	}*/
}
