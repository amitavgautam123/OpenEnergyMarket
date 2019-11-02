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
	//Submit Price Page
	By clientName = By.xpath("//h1[text() = 'Submit Prices']/../following-sibling::div[1]/div[1]");
	By commodityDetails = By.xpath("//h1[text() = 'Submit Prices']/../following-sibling::div[1]/div[2]");
	By tenderDateDetails = By.xpath("//h1[text() = 'Submit Prices']/../following-sibling::div[1]/div[3]");
	By selectQuoteDropdown = By.id("SelectedQuote");
	By durationDropdown = By.id("SelectedDuration");
	By toleranceEdtBox = By.id("Tolerance");
	By creditStatusDropdown = By.id("CreditStatus");
	By productDropdown = By.id("SelectedProductId");
	By commentsEdtBox = By.id("Comments");
	By uploadPrice = By.id("FileUpload");
	
	
	String companyName = "Auto_Company_555";
	String tenderDate = "12/11/2019";
	
	public By submitPricesBtn(String companyName, String tenderDate) {
		By submitPricesBtn = By.xpath("//tr[@class = 'tender-row']/td[text() = '" + currentDate() + "']/following-sibling::td[text() = '" + companyName + "']/following-sibling::td[@class = 'utility' and text() = 'HH']/following-sibling::td[@class = 'tender-date' and text() = '" + tenderDate + "']/following-sibling::td/a[@id = 'submit-prices-link']");
		return submitPricesBtn;
	}
	
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
	public TendersAndAlertsPage verifyTenderPresenceInTendersAndAlertsTest() throws Throwable {		
		boolean tenderDisplayStatus = isElementPresent(submitPricesBtn(companyName, tenderDate));		
		click(submitPricesBtn(companyName, tenderDate));
		Reporter.log("Clicked on submit prices button.", true);
		Thread.sleep(2000);
		Assert.assertTrue(tenderDisplayStatus, "Tender is not displaying with InProgress status in Supplier account after verifying in admin panel");
		return this;
		
	}
	public TendersAndAlertsPage navigateToSubmitPricePageTest() throws Throwable {		
		click(submitPricesBtn(companyName, tenderDate));
		Reporter.log("Clicked on submit prices button.", true);
		Thread.sleep(2000);
		boolean pageLoadedStatus = driver.getCurrentUrl().contains("SupplierQuotes/SubmitPrices");
		Assert.assertTrue(pageLoadedStatus, "Submit price page is not displaying");
		return this;
		
	}
	public TendersAndAlertsPage verifySubmitPrice() throws Throwable {
		
		SoftAssert softAssertion = new SoftAssert();
		boolean clientNameDisplayStatus = getText(clientName).contains("Client: "+companyName);
		softAssertion.assertTrue(clientNameDisplayStatus, "Client name is not displaying in 'Submit Prices' page.");
		boolean commodityDisplayStatus = getText(commodityDetails).contains("Commodity: ElectricityHh");
		softAssertion.assertTrue(commodityDisplayStatus, "Commodity is not displaying.");
		boolean tenderDateDisplayStatus = getText(tenderDateDetails).contains(tenderDate);
		softAssertion.assertTrue(tenderDateDisplayStatus, "Tender Date is not displaying correctly.");
		boolean quoteDropdownDisplayStatus = isElementPresent(quoteRequestStatusDropdown);
		softAssertion.assertTrue(quoteDropdownDisplayStatus, "Quote dropdown is not displaying correctly.");
		boolean durationDropdownDisplayStatus = isElementPresent(durationDropdown);
		softAssertion.assertTrue(durationDropdownDisplayStatus, "Duration dropdown is not displaying correctly.");
		selectByValue(durationDropdown, readExcelData("Sheet1", 1, 2));
		boolean toleranceEdtBoxDisplayStatus = isElementPresent(toleranceEdtBox,2);
		softAssertion.assertTrue(toleranceEdtBoxDisplayStatus, "Tolerance edit box is not displaying after entering contract duration.");
		setValue(toleranceEdtBox, readExcelData("Sheet6", 1, 2));
		selectByVisibleText(creditStatusDropdown, readExcelData("Sheet6", 1, 3));
		selectByVisibleText(creditStatusDropdown, readExcelData("Sheet6", 1, 4));
		setValue(commentsEdtBox, readExcelData("Sheet6", 1, 5));
		setValue(uploadPrice, readExcelData("Sheet6", 1, 6));
		softAssertion.assertAll();
		return this;
		
	}
	
}
