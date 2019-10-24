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
	By supplierSummaryTable=By.id("tender-summary-div");
	
	By submitPricesBtnFirstRecord = By.xpath("//table[@id='accept-decline-table']/tbody/tr[1]/td[9]/a");
	
	
	@Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in Supplier Dashboard Page");
        Assert.assertTrue(isElementPresent(tendersAndAlertsLink),"Supplier Dashboard Page didnt appear");
        
    }
	public TendersAndAlertsPage verifyQuoteStatusDropdownExist() {
		boolean quoteRequestStatusDropdownPresenceStatus = isElementPresent(quoteRequestStatusDropdown);
		Reporter.log("Checked if Quote Request status dropdown is displaying.", 3, true);
		Assert.assertTrue(quoteRequestStatusDropdownPresenceStatus, "Quote Request status dropdown is not displaying.");
		return this;
	}
	public TendersAndAlertsPage validateQuoteRequestStatusDropdown()	{
		SoftAssert softAssertion = new SoftAssert();
		boolean inProgressOptionPresenceStatus = isElementExistInDropDown(quoteRequestStatusDropdown, "In Progress");
		Reporter.log("Checked if 'In Progress' option is present in the dropdown", 3, true);
		softAssertion.assertTrue(inProgressOptionPresenceStatus, "In Progress option is not present in the dropdown");
		boolean acceptedOptionPresenceStatus = isElementExistInDropDown(quoteRequestStatusDropdown, "Accepted");
		Reporter.log("Checked if 'Accepted' option is present in the dropdown", 3, true);
		softAssertion.assertTrue(acceptedOptionPresenceStatus, "Accepted option is not present in the dropdown");
		boolean expiredOptionPresenceStatus = isElementExistInDropDown(quoteRequestStatusDropdown, "Expired");
		Reporter.log("Checked if 'Expired' option is present in the dropdown", 3, true);
		softAssertion.assertTrue(expiredOptionPresenceStatus, "Expired option is not present in the dropdown");
		softAssertion.assertAll();
		return this;
	}
	public TendersAndAlertsPage verifyPresenceOfFilters(){
		SoftAssert softAssertion = new SoftAssert();
		boolean hhFilterPresenceStatus = isElementPresent(hhUtilityFilter);
		Reporter.log("Checked if HH utility filter is displaying", 3, true);
		softAssertion.assertTrue(hhFilterPresenceStatus, "HH Utility filter is not displaying");
		boolean nhhFilterPresenceStatus = isElementPresent(nhhUtilityFilter);
		Reporter.log("Checked if NHH utility filter is displaying", 3, true);
		softAssertion.assertTrue(nhhFilterPresenceStatus, "NHH Utility filter is not displaying");
		boolean gasFilterPresenceStatus = isElementPresent(gasUtilityFilter);
		Reporter.log("Checked if Gas utility filter is displaying", 3, true);
		softAssertion.assertTrue(gasFilterPresenceStatus, "Gas Utility filter is not displaying");
		boolean waterUtilityFilterPresenceStatus = isElementPresent(waterUtilityFilter);
		Reporter.log("Checked if Water utility filter is displaying", 3, true);
		softAssertion.assertTrue(waterUtilityFilterPresenceStatus, "Water Utility filter is not displaying");
		boolean allUtilitiesFilterPresenceStatus = isElementPresent(allUtilitiesFilter);
		Reporter.log("Checked if All utilities filter is displaying", 3, true);
		softAssertion.assertTrue(allUtilitiesFilterPresenceStatus, "All Utility filter is not displaying");		
		softAssertion.assertAll();
		return this;
	}
	/*public void validateSubmitPricePage() {
		selectByVisibleText(quoteRequestStatusDropdown, "In Progress");
		Reporter.log("Clicked on In Progress in Status dropdown", true);
		click(submitPricesBtnFirstRecord);
		Reporter.log("Clicked on In Progress button", true);
		
	}*/

	public SupplierDashboardPage verifySupplierSummaryTableExists(){
		Assert.assertTrue(isElementPresent(supplierSummaryTable),"Supplier Summary table is not shown after impersonating");
		return this;
	}

}
