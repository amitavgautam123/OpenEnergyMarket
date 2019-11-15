package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class TendersAndAlertsPage extends SupplierDashboardPage{
	
	By tendersAndAlertsLink = By.xpath("//li[@data-action = 'Requests']/a/h3");
	By reviewQuotesLink = By.xpath("//li[@id = 'sidebar-review-quotes']/a/h3");
	
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
	By submitBtn = By.xpath("//button[text() = 'Submit']");
	By pleaseUploadAFilePopup = By.xpath("//div[text() = 'Please upload a file']");
	By okBtn = By.xpath("//button[text() = 'OK']");
	By invalidFileErrMsg = By.xpath("//div[contains(text(), 'An error occurred when trying to upload')]");
	
	//Submit price Success page
	By confirmBtn = By.id("btn-confirm");

	//Review Quotes Page
	By currentContractTitle = By.xpath("//h3[text() = 'Current Contract ']");
	By proposedQuotesTitle = By.xpath("//h3[text() = 'Proposed Quotes']");
	By hhUtilityFilter_ReviewQuotes = By.xpath("//td[contains(text(), 'Please select a Utility')]/following-sibling::td/div[1]");
	By nhhUtilityFilter_ReviewQuotes = By.xpath("//td[contains(text(), 'Please select a Utility')]/following-sibling::td/div[2]");
	By gasUtilityFilter_ReviewQuotes = By.xpath("//td[contains(text(), 'Please select a Utility')]/following-sibling::td/div[3]");
	By waterUtilityFilter_ReviewQuotes = By.xpath("//td[contains(text(), 'Please select a Utility')]/following-sibling::td/div[4]");		
	
	
	public By submitPricesBtn(String companyName, String tenderDate, String utility) {
		By submitPricesBtn = By.xpath("//tr[@class = 'tender-row']/td[contains(text(), '" + currentDate() + "')]/following-sibling::td[text() = '" + companyName + "']/following-sibling::td[@class = 'utility' and text() = '" + utility + "']/following-sibling::td[@class = 'tender-date' and text() = '" + tenderDate + "']/following-sibling::td/a[@id = 'submit-prices-link']");
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
	public TendersAndAlertsPage verifyHHTenderPresenceInTendersAndAlertsTest() throws Throwable {
		String companyName = readExcelData("Sheet4", 1, 1);
		String tenderDate = readExcelData("Sheet4", 1, 2);
		String utility = readExcelData("Sheet4", 1, 3);
		
		boolean tenderDisplayStatus = isElementPresent(submitPricesBtn(companyName, tenderDate, utility));		
		//click(submitPricesBtn(companyName, tenderDate, utility));
		//Reporter.log("Clicked on submit prices button.", true);
		Thread.sleep(2000);
		Assert.assertTrue(tenderDisplayStatus, "Tender is not displaying with InProgress status in Supplier account after verifying in admin panel");
		return this;
		
	}
	public TendersAndAlertsPage verifyNHHTenderPresenceInTendersAndAlertsTest() throws Throwable {
		String companyName = readExcelData("Sheet4", 1, 1);
		String tenderDate = readExcelData("Sheet4", 1, 2);
		String utility = readExcelData("Sheet4", 2, 3);
		
		boolean tenderDisplayStatus = isElementPresent(submitPricesBtn(companyName, tenderDate, utility));		
		//click(submitPricesBtn(companyName, tenderDate, utility));
		//Reporter.log("Clicked on submit prices button.", true);
		Thread.sleep(2000);
		Assert.assertTrue(tenderDisplayStatus, "Tender is not displaying with InProgress status in Supplier account after verifying in admin panel");
		return this;
	}
	public TendersAndAlertsPage verifyGasTenderPresenceInTendersAndAlertsTest() throws Throwable {
		String companyName = readExcelData("Sheet4", 1, 1);
		String tenderDate = readExcelData("Sheet4", 1, 2);
		String utility = readExcelData("Sheet4", 3, 3);
		
		boolean tenderDisplayStatus = isElementPresent(submitPricesBtn(companyName, tenderDate, utility));		
		//click(submitPricesBtn(companyName, tenderDate, utility));
		//Reporter.log("Clicked on submit prices button.", true);
		Thread.sleep(2000);
		Assert.assertTrue(tenderDisplayStatus, "Tender is not displaying with InProgress status in Supplier account after verifying in admin panel");
		return this;
	}
	public TendersAndAlertsPage navigateToHHsubmitPricePageTest() throws Throwable {
		String companyName = readExcelData("Sheet4", 1, 1);
		String tenderDate = readExcelData("Sheet4", 1, 2);
		String utility = readExcelData("Sheet4", 1, 3);
		
		click(submitPricesBtn(companyName, tenderDate, utility));
		Reporter.log("Clicked on submit prices button.", true);
		Thread.sleep(5000);
		boolean pageLoadedStatus = driver.getCurrentUrl().contains("SupplierQuotes/SubmitPrices");
		Assert.assertTrue(pageLoadedStatus, "Submit price page is not displaying");
		return this;
		
	}
	public TendersAndAlertsPage navigateToNHHsubmitPricePageTest() throws Throwable {
		String companyName = readExcelData("Sheet4", 1, 1);
		String tenderDate = readExcelData("Sheet4", 1, 2);
		String utility = readExcelData("Sheet4", 2, 3);
		
		click(submitPricesBtn(companyName, tenderDate, utility));
		Reporter.log("Clicked on submit prices button.", true);
		Thread.sleep(5000);
		boolean pageLoadedStatus = driver.getCurrentUrl().contains("SupplierQuotes/SubmitPrices");
		Assert.assertTrue(pageLoadedStatus, "Submit price page is not displaying");
		return this;
	}
	public TendersAndAlertsPage navigateToGasSubmitPricePageTest() throws Throwable {
		String companyName = readExcelData("Sheet4", 1, 1);
		String tenderDate = readExcelData("Sheet4", 1, 2);
		String utility = readExcelData("Sheet4", 3, 3);
		
		click(submitPricesBtn(companyName, tenderDate, utility));
		Reporter.log("Clicked on submit prices button.", true);
		Thread.sleep(5000);
		boolean pageLoadedStatus = driver.getCurrentUrl().contains("SupplierQuotes/SubmitPrices");
		Assert.assertTrue(pageLoadedStatus, "Submit price page is not displaying");
		return this;
		
	}
	public TendersAndAlertsPage verifyHHsubmitPricePage() throws Throwable {
		String companyName = readExcelData("Sheet4", 1, 1);
		String tenderDate = readExcelData("Sheet4", 1, 2);
		SoftAssert softAssertion = new SoftAssert();
		boolean clientNameDisplayStatus = getText(clientName).contains("Client: "+companyName);
		softAssertion.assertTrue(clientNameDisplayStatus, "Client name is not displaying in 'Submit Prices' page.");
		boolean commodityDisplayStatus = getText(commodityDetails).contains("Commodity: ElectricityHh");
		softAssertion.assertTrue(commodityDisplayStatus, "Commodity is not displaying.");
		boolean tenderDateDisplayStatus = getText(tenderDateDetails).contains(tenderDate);
		softAssertion.assertTrue(tenderDateDisplayStatus, "Tender Date is not displaying correctly.");
		//boolean quoteDropdownDisplayStatus = isElementPresent(quoteRequestStatusDropdown);
		//softAssertion.assertTrue(quoteDropdownDisplayStatus, "Quote dropdown is not displaying.");
		boolean durationDropdownDisplayStatus = isElementPresent(durationDropdown);
		softAssertion.assertTrue(durationDropdownDisplayStatus, "Duration dropdown is not displaying correctly.");
		selectByIndex(durationDropdown, 1);
		Thread.sleep(2000);
		scrollDown();
		boolean toleranceEdtBoxDisplayStatus = isElementPresent(toleranceEdtBox,2);
		softAssertion.assertTrue(toleranceEdtBoxDisplayStatus, "Tolerance edit box is not displaying after entering contract duration.");
		setValue(toleranceEdtBox, readExcelData("Sheet6", 1, 2));
		selectByVisibleText(creditStatusDropdown, readExcelData("Sheet6", 1, 3));
		selectByIndex(creditStatusDropdown, 0);
		setValue(commentsEdtBox, readExcelData("Sheet6", 1, 5));
		Thread.sleep(1000);
		selectByIndex(productDropdown, 2);
		Thread.sleep(1000);
		scrollDown();
		//selectByVisibleText(creditStatusDropdown, readExcelData("Sheet6", 1, 4));
		
		boolean uploadPriceBtnDisplayStatus = isElementPresent(uploadPrice);
		softAssertion.assertTrue(uploadPriceBtnDisplayStatus, "Upload Price button is not displaying.");
		//validateUploadPriceImproperData();
		setValue(uploadPrice, readExcelData("Sheet6", 1, 6));
		Thread.sleep(2000);
		click(submitBtn);		
		Thread.sleep(7000);
		softAssertion.assertAll();
		return this;	
	}
	public TendersAndAlertsPage verifyGasSubmitPricePage() throws Throwable {
		String companyName = readExcelData("Sheet4", 1, 1);
		String tenderDate = readExcelData("Sheet4", 1, 2);
		SoftAssert softAssertion = new SoftAssert();
		boolean clientNameDisplayStatus = getText(clientName).contains("Client: "+companyName);
		softAssertion.assertTrue(clientNameDisplayStatus, "Client name is not displaying in 'Submit Prices' page.");
		boolean commodityDisplayStatus = getText(commodityDetails).contains("Commodity: Gas");
		softAssertion.assertTrue(commodityDisplayStatus, "Commodity is not displaying.");
		boolean tenderDateDisplayStatus = getText(tenderDateDetails).contains(tenderDate);
		softAssertion.assertTrue(tenderDateDisplayStatus, "Tender Date is not displaying correctly.");
		//boolean quoteDropdownDisplayStatus = isElementPresent(quoteRequestStatusDropdown);
		//softAssertion.assertTrue(quoteDropdownDisplayStatus, "Quote dropdown is not displaying.");
		boolean durationDropdownDisplayStatus = isElementPresent(durationDropdown);
		softAssertion.assertTrue(durationDropdownDisplayStatus, "Duration dropdown is not displaying correctly.");
		selectByIndex(durationDropdown, 1);
		Thread.sleep(2000);
		scrollDown();
		boolean toleranceEdtBoxDisplayStatus = isElementPresent(toleranceEdtBox,2);
		softAssertion.assertTrue(toleranceEdtBoxDisplayStatus, "Tolerance edit box is not displaying after entering contract duration.");
		setValue(toleranceEdtBox, readExcelData("Sheet6", 1, 2));
		selectByVisibleText(creditStatusDropdown, readExcelData("Sheet6", 1, 3));
		selectByIndex(creditStatusDropdown, 0);
		setValue(commentsEdtBox, readExcelData("Sheet6", 1, 5));
		Thread.sleep(1000);
		selectByIndex(productDropdown, 2);
		Thread.sleep(2000);
		scrollDown();
		//selectByVisibleText(creditStatusDropdown, readExcelData("Sheet6", 1, 4));
		
		boolean uploadPriceBtnDisplayStatus = isElementPresent(uploadPrice);
		softAssertion.assertTrue(uploadPriceBtnDisplayStatus, "Upload Price button is not displaying.");
		//validateUploadPriceImproperData();
		setValue(uploadPrice, readExcelData("Sheet6", 2, 6));
		Thread.sleep(2000);
		click(submitBtn);		
		Thread.sleep(7000);
		softAssertion.assertAll();
		return this;
		
	}
	public void validateUploadPriceImproperData() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		click(submitBtn);
		Thread.sleep(2000);
		boolean pleaseUploadAfileDisplayStatus = isElementPresent(pleaseUploadAFilePopup);
		softAssertion.assertTrue(pleaseUploadAfileDisplayStatus, "Please upload a file popup is not displaying.");
		if(pleaseUploadAfileDisplayStatus) {
			click(okBtn);
		}
		setValue(uploadPrice, readExcelData("Sheet6", 2, 6));
		click(submitBtn);
		Thread.sleep(2000);
		boolean errorMsgDisplayStatus = isElementPresent(invalidFileErrMsg);
		softAssertion.assertTrue(errorMsgDisplayStatus, "Error message for invalid file is not diplaying.");
		softAssertion.assertAll();
	}
	public TendersAndAlertsPage verifySubmitPricesSuccessPage() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		boolean submitPricesSuccessPageDisplayStatus = driver.getCurrentUrl().contains("SupplierQuotes/SubmitPricesSuccess");
		softAssertion.assertTrue(submitPricesSuccessPageDisplayStatus, "Submit price success page is not displaying.");
		click(confirmBtn);
		Thread.sleep(5000);
		
		softAssertion.assertAll();
		return this;
	}
	
	public TendersAndAlertsPage verifyCurrentContractAndProposedQuotePresence(){
		SoftAssert softAssertion = new SoftAssert();
		boolean currentContractDisplayStatus = isElementPresent(currentContractTitle);
		softAssertion.assertTrue(currentContractDisplayStatus, "Current contract is not displaying.");
		boolean proposedQuotesDisplayStatus = isElementPresent(proposedQuotesTitle);
		softAssertion.assertTrue(proposedQuotesDisplayStatus, "Proposed Quote is not displaying.");		
        
		softAssertion.assertAll();
		return this;
    }
	public TendersAndAlertsPage verifyFilterUtilityPresence(){
		SoftAssert softAssertion = new SoftAssert();
		boolean hhUtilityDisplayStatus = isElementPresent(hhUtilityFilter_ReviewQuotes);
		softAssertion.assertTrue(hhUtilityDisplayStatus, "HH Utility filter is not displaying.");
		boolean nhhUtilityDisplayStatus = isElementPresent(nhhUtilityFilter_ReviewQuotes);
		softAssertion.assertTrue(nhhUtilityDisplayStatus, "NHH Utility filter is not displaying.");
		boolean gasUtilityDisplayStatus = isElementPresent(gasUtilityFilter_ReviewQuotes);
		softAssertion.assertTrue(gasUtilityDisplayStatus, "Gas Utility filter is not displaying.");
		boolean waterUtilityDisplayStatus = isElementPresent(waterUtilityFilter_ReviewQuotes);
		softAssertion.assertTrue(waterUtilityDisplayStatus, "Water Utility filter is not displaying.");
		softAssertion.assertAll();
        return this;
    }
	
}
