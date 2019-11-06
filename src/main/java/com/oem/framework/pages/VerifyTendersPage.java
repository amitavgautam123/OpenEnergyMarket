package com.oem.framework.pages;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class VerifyTendersPage extends AdminDashboardPage	{

	By filterAllUtility_VerifyTender = By
			.xpath("//td[contains(text(), 'Filter by Utility')]/following-sibling::td[1]/div[1]");
	By filterHHutility_VerifyTender = By
			.xpath("//td[contains(text(), 'Filter by Utility')]/following-sibling::td[1]/div[2]");
	By filterNHHutility_VerifyTender = By
			.xpath("//td[contains(text(), 'Filter by Utility')]/following-sibling::td[1]/div[3]");
	By filterGasUtility_VerifyTender = By
			.xpath("//td[contains(text(), 'Filter by Utility')]/following-sibling::td[1]/div[4]");
	By filterWaterUtility_VerifyTender = By
			.xpath("//td[contains(text(), 'Filter by Utility')]/following-sibling::td[1]/div[5]");	
	By allowSelectedBtn = By.xpath("//input[@value = 'Allow Selected']");
	By allowSelectedBtnBottomPage = By.xpath(("(//input[@value = 'Allow Selected'])[2]"));
	By blockSelectedBtn = By.xpath("//input[@value = 'Block Selected']");
	By alertPopUpForNoSupplierSelection = By.xpath("//div[text() = 'Please select at least one supplier']");
	By requestDateHeading = By.xpath("//div[contains(text(),'Request Date')]/..");
	
	By hHUtility = By.xpath("//div[@class='meter-type-circle-tiny'][1]");
	By nHHUtility = By.xpath("//div[@class='meter-type-circle-tiny'][2]");
	By gasUtility = By.xpath("//div[@class='meter-type-circle-tiny'][3]");
	By waterUtility = By.xpath("//div[@class='meter-type-circle-tiny'][4]");

	By noOfRowsInCustomer = By.xpath("//table[@id='verify-quote-requests']//tbody//tr");
	By customer = By.xpath("//div[text()='Customer']");
	By requestDate = By.xpath("//div[text()='Request Date']");
	
	String selectAll = "All";
	String firstSelectedSupplierName = "British Gas Business";
	String secondSelectedSupplierName = "Corona Energy";
	String fourthSelectedSupplierName = "Dong Energy";
	
	@Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in Verify Tenders Page");
        Assert.assertTrue(isElementPresent(allowSelectedBtn),"Verify Tenders Page didn't appear.");    
    }
	public VerifyTendersPage setRequestDateDescending() {
		if(getAttribute(requestDateHeading, "aria-sort").equals("ascending")) {
			click(requestDateHeading);
		}
		return this;
	}
	public String currentDate() {
		LocalDate myObj1 = LocalDate.now(); // Create a date object

		Object d1 = myObj1;
		String date = d1.toString();

		int day = Integer.parseInt(date.substring(8, 10));
		int month = Integer.parseInt(date.substring(5, 7));
		int year = Integer.parseInt(date.substring(0, 4));
		String currentDate = day + "/" + month + "/" + year;
		return currentDate;
	}
	public VerifyTendersPage goToNHHmeterSection() throws Throwable {
		click(filterNHHutility_VerifyTender);
		Thread.sleep(1000);
		return this;
	}

	public void verifyUtilityFilterPresenceVerifyTenders() {
		SoftAssert softAssertion = new SoftAssert();
		boolean allFilterPresenceStatus = isElementPresent(filterAllUtility_VerifyTender);
		softAssertion.assertTrue(allFilterPresenceStatus, "All utilities filter is not displaying.");
		boolean hhFilterPresenceStatus = isElementPresent(filterHHutility_VerifyTender);
		softAssertion.assertTrue(hhFilterPresenceStatus, "HH utility filter is not displaying.");
		boolean nhhFilterPresenceStatus = isElementPresent(filterNHHutility_VerifyTender);
		softAssertion.assertTrue(nhhFilterPresenceStatus, "NHH utility filter is not displaying.");
		boolean gasFilterPresenceStatus = isElementPresent(filterGasUtility_VerifyTender);
		softAssertion.assertTrue(gasFilterPresenceStatus, "Gas utility filter is not displaying.");
		boolean waterFilterPresenceStatus = isElementPresent(filterWaterUtility_VerifyTender);
		softAssertion.assertTrue(waterFilterPresenceStatus, "Water utility filter is not displaying.");
		softAssertion.assertAll();
	}

	/**
	 * Looks for the HH quote in verify tenders by using current date, company name
	 * 
	 * @param companyName
	 * @return
	 */
	public By findQuote(String companyName) {
		By quote = By.xpath("//i[@class = 'icon-lightning icon-2x']/../following-sibling::td[contains(text(), '" + currentDate() + "')]/"
				+ "preceding-sibling::td[text() = '" + companyName + "']");
		return quote;
	}

	public By downloadTenderDetailsButton(String companyName) {
		By downloadBtn = By.xpath("//i[@class = 'icon-lightning icon-2x']/../following-sibling::td[contains(text(), '" + currentDate() + "']/preceding-sibling::td[text() = '" + companyName + "']/following-sibling::td[3]/a");
		return downloadBtn;
	}

	/**
	 * Consists of list of suppliers which were selected while requesting a quote
	 * for the quote in verify tenders.
	 * 
	 * @param companyName
	 * @return
	 */
	public By suppliersListForQuote(String companyName) {
		By suppliers = By
				.xpath("//i[@class = 'icon-lightning icon-2x']/../following-sibling::td[contains(text(), '" + currentDate()
						+ "')]/preceding-sibling::td[text() = '" + companyName + "']/following-sibling::td[5]/label");
		return suppliers;
	}

	/**
	 * Returns the list of locators of check box for the all the suppliers in
	 * Supplier column.
	 * 
	 * @return
	 */
	public By checkboxAllSupplierList(String companyName) {
		By checkboxLst = By
				.xpath("//i[@class = 'icon-lightning icon-2x']/../following-sibling::td[contains(text(), '" + currentDate()
						+ "')]/preceding-sibling::td[text() = '" + companyName + "']/following-sibling::td[5]/input");
		return checkboxLst;
	}

	/**
	 * Returns the list of locators of check box for the all the suppliers in Matrix
	 * Price column.
	 * 
	 * @return
	 */
	public By checkboxMatrixPriceList(String companyName) {
		By checkboxLst = By
				.xpath("//i[@class = 'icon-lightning icon-2x']/../following-sibling::td[contains(text(), '" + currentDate()
						+ "')]/preceding-sibling::td[text() = '" + companyName + "']/following-sibling::td[4]/input");
		return checkboxLst;
	}

	/**
	 * Returns the locator of the check box for the supplier in supplier list in
	 * verify tenders.
	 * 
	 * @param companyName
	 * @param supplierName
	 */
	public By checkboxSupplier(String companyName, String supplierName) {
		By supCheckbox = By.xpath("//i[@class = 'icon-lightning icon-2x']/../following-sibling::td[contains(text(), '"
				+ currentDate() + "')]/preceding-sibling::td[text() = '" + companyName
				+ "']/following-sibling::td[4]/label[text() = '" + supplierName + "']/preceding-sibling::input[1]");
		return supCheckbox;
	}
	
	public void verifyAllowSelectedFunctionalityTest() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String companyName = readExcelData("Sheet4", 1, 1);
		click(filterHHutility_VerifyTender);
		Reporter.log("Click on HH filter", true);
		Thread.sleep(1000);
		setRequestDateDescending();
		Reporter.log("Request quote is set descending.", true);
		Thread.sleep(1000);
		click(checkboxSupplier(companyName, selectAll));
		Reporter.log("Clicked on the checkbox for the supplier.", true);
		scrollUp();
		Thread.sleep(1000);
		click(allowSelectedBtn);
		Reporter.log("Clicked on allow selected button.", true); 
		Thread.sleep(2000);
		 
		/*
		 * scrollToElement(findQuote(companyName)); boolean
		 * supplierPresenceInListStatusAfterAllow =
		 * isElementExistInList(suppliersListForQuote(companyName),
		 * firstSelectedSupplierName);
		 * Reporter.log("Checked if supplier name is displaying after allowing it.",
		 * true); softAssertion.assertFalse(supplierPresenceInListStatusAfterAllow,
		 * "Supplier name is still displaying after allowing it.");
		 */
		
		logout();
	}
	
	public int noOfRowsOrCustomers() {
		int rowsORcustomers = driver.findElements(noOfRowsInCustomer).size();
		return rowsORcustomers;
	}

	public void verifySuppliersPresence(String utility) throws Throwable {
		switch (utility) {
		case "HH":
		Thread.sleep(3000);
		click(hHUtility);
		break;
		case "nHH":
		click(nHHUtility);
		break;
		case "Gas":
		click(gasUtility);
		break;
		case "Water":
		click(waterUtility);
		break;
		default:
		System.out.println("Enter Correct Utility");
		}

		click(requestDate);// click on utility
		Thread.sleep(3000);
		Reporter.log("Clicked Request Date", true);
		Thread.sleep(3000);
		click(checkboxSupplier(readExcelData("Sheet5",3,1), readExcelData("Sheet5",0,1)));
		Thread.sleep(3000);
		click(allowSelectedBtn);
	}
	public void verifyTendersHomePage() {
		Assert.assertTrue(isElementPresent(allowSelectedBtn), "Allow selected Button is Not Present");
		Assert.assertTrue(isElementPresent(blockSelectedBtn), "Block selected Button is Not Present");
		Assert.assertTrue(isElementPresent(hHUtility), "hHHUtility is Not Present");
		Assert.assertTrue(isElementPresent(nHHUtility), "nHHUtility is Not Present");
		Assert.assertTrue(isElementPresent(gasUtility), "GasUtility is Not Present");
		Assert.assertTrue(isElementPresent(waterUtility), "WaterUtility is Not Present");
	}
	
}