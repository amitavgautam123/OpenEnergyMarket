package com.oem.framework.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class PropertyPortfolioMeterPage extends CustomerDashboardPage {
	
	By siteFirstRecord = By.xpath("//div[@id = 'divSitesOverview']/hgroup[1]/table/tbody/tr/td[1]");
	
	By tipCloseBtn = By.xpath("//p[text() = 'Tip 1 of 1']/following-sibling::a");
	
	By addMeter = By.id("add-meter-button");
	By meterUtilitiesInAddMeterDropdown = By.xpath("//div[@id = 'add-meter-button']/ul/li[*]");
	By addHHMeter = By.xpath("//div[@id = 'add-meter-button']/ul/li[1]");
	By addnHHMeter = By.xpath("//div[@id = 'add-meter-button']/ul/li[2]");
	By addGasMeter = By.xpath("//div[@id = 'add-meter-button']/ul/li[3]");
	By addWaterMeter = By.xpath("//div[@id = 'add-meter-button']/ul/li[4]"); 
	By saveMeterBtn = By.id("save-meter-button");
	/*Add HH & nHH Meter popup*/
	By meterNumDropdownField = By.id("profileClass");
	By meterNumSecondField = By.id("meterTimeSwitchCode");
	By meterNumThirdField = By.id("lineLossFactor");
	By meterNumFourthField = By.id("distributionId");
	By meterNumFifthField = By.id("meterPointIdNumber1");
	By meterNumSixthField = By.id("meterPointIdNumber2");
	By meterNumSeventhField = By.id("checkDigit");
	By invalidMPANNumberIcon = By.id("checksum-fail");
	By verifiedMPANNumberIcon = By.xpath("//div[@id = 'checksum-pass']/i");
	
	By procurementType = By.id("procurementType");
	By expectedConsumption = By.id("expectedConsumption");
	By currentSupplier = By.id("electricitySuppliers");
	By contractEndDate = By.id("contractEndDateForMeterModel");
	By capacity = By.id("capacity");
	By currentAnnualSpend = By.id("currentAnnualSpend");
	By includeClimateChangeLevy = By.id("isCCLInclusive");
	By currentMeterOperator = By.id("meterOperator");
	By meterOperatorEndDate = By.id("meterOperatorEndDateForMeterModel");
	By currentDataCollector = By.id("dataCollector");
	By dataCollectorEndDate = By.id("dataCollectorEndDateForMeterModel");
	/*Add Gas Meter popup*/
	By gasMeterNumber = By.id("gasMeterNumber");
	By gasCurrentSuppliers = By.id("gasSuppliers");
	/*popup after saving meter*/
	By meterSavedPopup = By.xpath("//div[text() = 'The meter data was saved successfully.']");
	By invalidMPANPopup = By.xpath("//div[text() = 'MPAN failed check digit validation, please review the number and try again']");
	By okBtn = By.xpath("//button[text() = 'OK']");
	By cancelBtn = By.xpath("//button[text() = 'Cancel']");
	/*Meter List*/	
	By allMeterList = By.xpath("//div[@id = 'meters']/div/div/div/table/tbody/tr/td[2]/div[2]");
	By allHHMeterList = By.xpath("//div[@id = 'meters']/div[@id = 'meters-1']/div/div/table/tbody/tr/td[2]/div[2]");
	By allnHHMeterList = By.xpath("//div[@id = 'meters']/div[@id = 'meters-3']/div/div/table/tbody/tr/td[2]/div[2]");
	By allGasMeterList = By.xpath("//div[@id = 'meters']/div[@id = 'meters-2']/div/div/table/tbody/tr/td[2]/div[2]");
	By allWaterMeterList = By.xpath("//div[@id = 'meters']/div[@id = 'meters-4']/div/div/table/tbody/tr/td[2]/div[2]");
	
	By totalHHMetersCountInFilter = By.id("spanUtility-1");
	By totalnHHMetersCountInFilter = By.id("spanUtility-3");
	By totalGasMetersCountInFilter = By.id("spanUtility-2");
	By totalWaterMetersCountInFilter = By.id("spanUtility-4");
	
	/*Edit, delete, review options for various gas meters*/
	By reviewHHMeterBtn = By.xpath("//div[contains(text(), '6786342454')]/../following-sibling::td[5]/a[2]");
	By deleteHHMeterBtn = By.xpath("//div[contains(text(), '6786342454')]/../following-sibling::td[5]/a[3]");
	By editMeterPopup = By.xpath("//h3[contains(text(),'Edit Meter Details')]");
	By deleteMeterPopup = By.xpath("//h3[text() = 'Delete Meter']");
	By meterDeleteReasonDropdown = By.id("meterDeleteReason");
	By meterDeleteNotes = By.id("meterDeleteNotes");
	By deleteMeterBtnInDeletePopup = By.xpath("//form[@id='frm-delete-meter']//button[1]");
	By meterDeleteSuccessfulPopup = By.xpath("//div[text() = 'The Meter was deleted successfully.']");
	By revertMeterConfirmPopup = By.xpath("//div[text() = 'Are you sure you wish to revert this meter back to an active state?']");
	
	/**
	 * Returns the locator of the Edit meter button by passing 'Meter Number' as argument
	 * @param meterNumber
	 */
	public By editMeterBtn(String meterNumber) {
		By editMeterBtn = By.xpath("//div[contains(text(), '" + meterNumber + "')]/../following-sibling::td[5]/a[1]");
		return editMeterBtn;
	}
	/**
	 * Returns the locator of the 'Delete meter' button by passing 'Meter Number' as argument. It is not applicable for HH and deleted meters
	 * @param meterNumber
	 */
	public By deleteMeterBtn(String meterNumber) {
		By deleteMeterBtn = By.xpath("//div[contains(text(), '" + meterNumber + "')]/../following-sibling::td[5]/a[2]");
		return deleteMeterBtn;
	}
	/**
	 * Returns the locator of the button to revert deletion of the meter.
	 * @param meterNumber
	 * @return
	 */
	public By revertMeterDeletionBtn(String meterNumber) {
		By revertMeterDeletionButton = By.xpath("//div[contains(text(), '" + meterNumber + "')]/../following-sibling::td[4]//span[text() = 'deleted']/../../following-sibling::td[1]/a[2]");
		return revertMeterDeletionButton;
	}
	/**
	 * Returns the contract renewal date of the meter
	 * @param meterNumber
	 * @return
	 */
	public String contractRenewalDate(String meterNumber) {
		By contractRenewDate = By.xpath("//div[contains(text(), '" + meterNumber + "')]/../following-sibling::td[2]/div[2]");
		return getText(contractRenewDate);
	}
	public void viewMeterDetails(String meterNumber) {
		By meterNumb = By.xpath("//div[contains(text(), '" + meterNumber + "')]");
		click(meterNumb);
	}
	/**
	 * Returns meter number present in meter details section for Gas utility
	 * @param meterNumber
	 */
	public String meterNumberInMeterDetails(String meterNumber) {
		By meterNum = By.xpath("//div[contains(text(), '" + meterNumber + "')]/../../../../following-sibling::div/div[1]/table/tbody/tr/td[1]/div/table/tbody/tr/td[2]");
		return getText(meterNum);
	}
	/**
	 * Returns the number present in second field of meter number for HH and NHH utility in meter details. 
	 * @param mpanNumber
	 * @return
	 */
	public String meterNumberSecondFieldInMeterDetails(String mpanNumber) {
		By meterNumberSecondField = By.xpath("//div[contains(text(), '" + mpanNumber + "')]/../../../../following-sibling::div/div[1]/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td[2]");
		return getText(meterNumberSecondField);
	}
	/**
	 * Returns the number present in third field of meter number for HH and NHH utility in meter details.
	 * @param mpanNumber
	 * @return
	 */
	public String meterNumberThirdFieldInMeterDetails(String mpanNumber) {
		By meterNumberThirdField = By.xpath("//div[contains(text(), '" + mpanNumber + "')]/../../../../following-sibling::div/div[1]/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td[3]");
		return getText(meterNumberThirdField);
	}
	/**
	 * Returns the number present in fourth field of meter number for HH and NHH utility in meter details.
	 * @param mpanNumber
	 * @return
	 */
	public String meterNumberFourthFieldInMeterDetails(String mpanNumber) {
		By meterNumberFourthField = By.xpath("//div[contains(text(), '" + mpanNumber + "')]/../../../../following-sibling::div/div[1]/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td[1]");
		return getText(meterNumberFourthField);
	}
	/**
	 * Returns the number present in fifth field of meter number for HH and NHH utility in meter details.
	 * @param mpanNumber
	 * @return
	 */
	public String meterNumberFifthFieldInMeterDetails(String mpanNumber) {
		By meterNumberFifthField = By.xpath("//div[contains(text(), '" + mpanNumber + "')]/../../../../following-sibling::div/div[1]/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td[2]");
		return getText(meterNumberFifthField);
	}
	/**
	 * Returns the number present in sixth field of meter number for HH and NHH utility in meter details.
	 * @param mpanNumber
	 * @return
	 */
	public String meterNumberSixthFieldInMeterDetails(String mpanNumber) {
		By meterNumberSixthField = By.xpath("//div[contains(text(), '" + mpanNumber + "')]/../../../../following-sibling::div/div[1]/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td[3]");
		return getText(meterNumberSixthField);
	}
	/**
	 * Returns the number present in seventh field of meter number for HH and NHH utility in meter details.
	 * @param mpanNumber
	 * @return
	 */
	public String meterNumberSeventhFieldInMeterDetails(String mpanNumber) {
		By meterNumberSeventhField = By.xpath("//div[contains(text(), '" + mpanNumber + "')]/../../../../following-sibling::div/div[1]/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td[4]");
		return getText(meterNumberSeventhField);
	}
	/**
	 * Returns the locator of AMR Data Uploader button of a meter. 
	 * @param meterNumber
	 * @return 
	 */
	public By AMRdataUploaderBtn(String meterNumber) {
		By dataUploaderBtn = By.xpath("//div[contains(text(), '" + meterNumber + "')]/../../../../following-sibling::div/div[1]/table/tbody/tr/td[3]/button");
		return dataUploaderBtn;
	}
	/**
	 * Returns the locator of 'Add Contract History Button' of a meter.
	 * @param meterNumber
	 * @return
	 */
	public By addContractHistoryBtn(String meterNumber) {
		By addContractHistBtn = By.xpath("//div[contains(text(), '" + meterNumber + "')]/../../../../following-sibling::div/div[1]/table/tbody/tr/td[4]/button");
		return addContractHistBtn;
	}
	/**
	 * It returns the expected consumption data of the meter.
	 * @param meterNumber
	 * @return
	 */
	public String expectedConsumptionData(String meterNumber) {
		By expectedConsumption = By.xpath("//div[contains(text(), '" + meterNumber + "')]/../following-sibling::td[1]/div[2]");						   
		return getText(expectedConsumption);
	}
	/**
	 * It returns the status of the meter i.e., active or deleted.
	 * @param meterNumber
	 * @return
	 */
	public String meterStatus(String meterNumber) {
		By meterStatus = By.xpath("//div[contains(text(), '" + meterNumber + "')]/../following-sibling::td[4]/div[2]");						   
		return getText(meterStatus);
	}
	@Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in Site Meters Page");
        Assert.assertTrue(isElementPresent(addMeter),"Site Meters page didnt appear");
    }
	
	public void validateEditGasMeter() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		String meterNum = addValidGasMeterGeneric();
		Reporter.log("After adding gas meter stored the meter number in the variable", true);
		Thread.sleep(2000);
		click(editMeterBtn(meterNum));
		Reporter.log("clicked on edit button", true);
		Thread.sleep(1000);
		Random random = new Random();
		String gasMeterNum = String.valueOf(random.nextInt(1000000000));
		setValue(gasMeterNumber, gasMeterNum);
		Reporter.log("Entered in MPRN number in Add Gas Meter dropdown", true);
		selectByVisibleText(procurementType, "Flexible");
		Reporter.log("Selected procurement type in Add Gas Meter dropdown", true);
		String expectedConsumptionValue = String.valueOf(random.nextInt(5000));
		setValue(expectedConsumption, expectedConsumptionValue);
		Reporter.log("Entered 'Expected Consumption' in Add Gas Meter dropdown", true);
		selectByVisibleText(gasCurrentSuppliers, "Crown Gas");
		Reporter.log("Selected 'Current Supplier' in Add Gas Meter dropdown", true);
		click(contractEndDate);
		Reporter.log("Clicked on 'Contract End Date' to show date picker in Add Gas Meter dropdown", true);
		selectFutureDateCalender(24, random.nextInt(12), 2020);
		Reporter.log("Selected 'Contract End Date' from the date picker in Add Gas Meter dropdown", true);
		setValue(currentAnnualSpend, String.valueOf(random.nextInt(5000)));
		Reporter.log("Entered 'Current Annual Spend' in Add Gas Meter dropdown", true);
		click(saveMeterBtn);
		Reporter.log("Clicked on 'Save Meter Data' button", true);
		click(okBtn);
		Reporter.log("Clicked Ok button in popup after adding meter successfully", true);
		Thread.sleep(2000);
		boolean expectedConsumptionDisplayStatus = expectedConsumptionData(gasMeterNum).contains(expectedConsumptionValue) && expectedConsumptionData(gasMeterNum).contains("kWh");
		Reporter.log("Checked if the expected consumption is displaying the correct value after editing", true);
		softAssertion.assertTrue(expectedConsumptionDisplayStatus, "Expected consumption is not displaying correct value");
		viewMeterDetails(gasMeterNum);
		Reporter.log("Clicked on meter number to see the details of the meter", true);
		boolean meterNumberDisplayStatus = meterNumberInMeterDetails(gasMeterNum).equals(gasMeterNum);
		Reporter.log("Checked if meter number is displaying in meter details section.", true);
		softAssertion.assertTrue(meterNumberDisplayStatus, "Meter number is not displaying in meter details section");
		boolean presenceOfAMRdataUploaderBtnStatus = isElementPresent(AMRdataUploaderBtn(gasMeterNum));
		Reporter.log("Checked if AMR Data Uploader button is displaying in meter details section.", true);
		softAssertion.assertTrue(presenceOfAMRdataUploaderBtnStatus, "AMR Data Uploader Button is not displaying");
		boolean presenceOfAddContractHistoryBtnStatus = isElementPresent(addContractHistoryBtn(gasMeterNum));
		Reporter.log("Checked if 'Add Contract History' button is displaying in meter details section.", true);
		softAssertion.assertTrue(presenceOfAddContractHistoryBtnStatus, "Add contract history Button is not displaying");
		softAssertion.assertAll();
	}
	
	public void validateEditGasMeterPopup() throws Throwable {
		String meterNum = addValidGasMeterGeneric();
		Reporter.log("After adding gas meter stored the meter number in the variable", true);
		Thread.sleep(2000);
		click(editMeterBtn(meterNum));
		Reporter.log("clicked on edit button", true);
		Thread.sleep(1000);
		boolean editGasMeterPopupDisplayStatus = isElementPresent(editMeterPopup);
		Reporter.log("Checked if edit meter popup is displaying", true);
		Assert.assertTrue(editGasMeterPopupDisplayStatus, "Edit popup is not displaying");
	}
	
	public void validateDeleteMeterPopup() throws Throwable {

		String meterNum = addValidGasMeterGeneric();
		Reporter.log("After adding gas meter stored the meter number in the variable", true);
		Thread.sleep(2000);
		click(deleteMeterBtn(meterNum));
		Reporter.log("Clicked on delete meter button for the meter", true);
		Thread.sleep(1000);
		boolean deletePopupDisplayStatus = isElementPresent(deleteMeterPopup);
		Reporter.log("Checked if delete meter popup is displaying", true);
		Assert.assertTrue(deletePopupDisplayStatus, "Delete meter popup is not displaying");
	}
	/*PM_PP_TC_092*/
	public void validateDeleteMeter() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		String meterNum = addValidGasMeterGeneric();
		Reporter.log("Added a gas meter and stored meter number value in the variable", true);
		Thread.sleep(2000);
		int totalGasMeters = Integer.parseInt(getText(totalGasMetersCountInFilter));
		Reporter.log("Stored count of total gas meters before deletion", true);
		click(deleteMeterBtn(meterNum));
		Reporter.log("Clicked on delete option for the meter in meter page", true);
		Thread.sleep(1000);
		selectByVisibleText(meterDeleteReasonDropdown, "Closing down site");
		Reporter.log("Selected reason of delete from the dropdown", true);
		setValue(meterDeleteNotes, "Shutting down site");
		Reporter.log("Entered delete notes", true);
		click(deleteMeterBtnInDeletePopup);
		Reporter.log("Clicked delete meter button in the popup", true);
		Thread.sleep(1000);
		click(okBtn);
		Reporter.log("Clicked on OK button in the delete success confirmation popup", true);
		Thread.sleep(1000);
		click(totalGasMetersCountInFilter);
		Reporter.log("Clicked on filter for Gas meter", true);
		boolean meterStatusAfterDeletionStatus = meterStatus(meterNum).contains("DELETED");
		Reporter.log("Checked the meter status.", true);
		softAssertion.assertTrue(meterStatusAfterDeletionStatus, "Meter status 'Deleted' is not displaying");
		boolean revertDeletionBtnDisplayStatus = isElementPresent(revertMeterDeletionBtn(meterNum));
		Reporter.log("Checked if revert deletion button is displaying.", true);
		softAssertion.assertTrue(revertDeletionBtnDisplayStatus, "Revert Deletion button is not displaying for the deleted meter.");
		int totalGasMetersNew = Integer.parseInt(getText(totalGasMetersCountInFilter));
		Reporter.log("Checked if the total gas meter count is getting decremented after deletion", true);
		softAssertion.assertEquals(totalGasMetersNew, totalGasMeters - 1, "Total gas meters is not getting decremented.");
		softAssertion.assertAll();
	}
	public void validateMeterRevertDeletion() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		String meterNum = addValidGasMeterGeneric();
		Reporter.log("Added a gas meter and stored meter number value in the variable", true);
		Thread.sleep(2000);
		int totalGasMeters = Integer.parseInt(getText(totalGasMetersCountInFilter));
		Reporter.log("Stored count of total gas meters before deletion", true);
		click(deleteMeterBtn(meterNum));
		Reporter.log("Clicked on delete option for the meter in meter page", true);
		Thread.sleep(1000);
		selectByVisibleText(meterDeleteReasonDropdown, "Closing down site");
		Reporter.log("Selected reason of delete from the dropdown", true);
		setValue(meterDeleteNotes, "Shutting down site");
		Reporter.log("Entered delete notes", true);
		click(deleteMeterBtnInDeletePopup);
		Reporter.log("Clicked delete meter button in the popup", true);
		Thread.sleep(1000);
		click(okBtn);
		Reporter.log("Clicked on OK button in the delete success confirmation popup", true);
		Thread.sleep(1000);
		click(totalGasMetersCountInFilter);
		Reporter.log("Clicked on filter for Gas meters", true);
		boolean revertDeletionBtnDisplayStatus = isElementPresent(revertMeterDeletionBtn(meterNum));
		Reporter.log("Checked if revert deletion button is displaying.", true);
		softAssertion.assertTrue(revertDeletionBtnDisplayStatus, "Revert Deletion button is not displaying for the deleted meter.");
		click(revertMeterDeletionBtn(meterNum));
		Reporter.log("Clicked on 'Revert Deletion' button for the meter", true);
		Thread.sleep(1000);
		boolean revertMeterDeletionConfirmPopupDisplayStatus = isElementPresent(revertMeterConfirmPopup);
		Reporter.log("Checked if confirmation popup is displaying.", true);
		softAssertion.assertTrue(revertMeterDeletionConfirmPopupDisplayStatus, "Confirmation popup is not displaying.");
		click(cancelBtn);
		Reporter.log("Clicked on cancel button", true);
		waitForElementInvisible(revertMeterConfirmPopup);
		revertMeterDeletionConfirmPopupDisplayStatus = isElementPresent(revertMeterConfirmPopup);
		softAssertion.assertFalse(revertMeterDeletionConfirmPopupDisplayStatus, "Confirmation popup is still displaying after clicking cancel button");
		click(revertMeterDeletionBtn(meterNum));
		Reporter.log("Clicked on 'Revert Deletion' button for the meter", true);
		Thread.sleep(1000);
		click(okBtn);
		Reporter.log("Clicked on OK button in the popup", true);
		Thread.sleep(2000);
		click(totalGasMetersCountInFilter);
		Reporter.log("Navigated to gas meters", true);
		boolean meterStatusData = meterStatus(meterNum).contains("ACTIVE");
		Reporter.log("Checked if the meter status is Active", true);
		softAssertion.assertTrue(meterStatusData, "Meter status is not displaying as Active after revering deletion.");
		int totalGasMetersNew = Integer.parseInt(getText(totalGasMetersCountInFilter));
		Reporter.log("Checked if the total gas meter count is getting changed after deletion and reverting deletion", true);
		softAssertion.assertEquals(totalGasMetersNew, totalGasMeters, "Total gas meters is not displaying correct data after deleting meter and revert deletion of meter.");
		softAssertion.assertAll();
	}
	
	/**
	 * Adds gas meter and returns its meter number. 
	 * @return gasMeterNumber
	 * @throws Throwable
	 */
	public String addValidGasMeterGeneric() throws Throwable {
		Random random = new Random();
		click(addMeter);
		Reporter.log("Clicked on 'Add Meter' dropdown", true);
		click(addGasMeter);
		Reporter.log("Clicked on 'Gas' in Add Meter dropdown", true);
		Thread.sleep(1000);
		String gasMeterNum = String.valueOf(random.nextInt(1000000000));
		setValue(gasMeterNumber, gasMeterNum);
		Reporter.log("Entered in MPRN number in Add Gas Meter dropdown", true);
		selectByVisibleText(procurementType, "Fixed");
		Reporter.log("Selected procurement type in Add Gas Meter dropdown", true);
		String expectedConsumptionValue = String.valueOf(random.nextInt(5000));
		setValue(expectedConsumption, expectedConsumptionValue);
		Reporter.log("Entered 'Expected Consumption' in Add Gas Meter dropdown", true);
		selectByVisibleText(gasCurrentSuppliers, "D-ENERGi");
		Reporter.log("Selected 'Current Supplier' in Add Gas Meter dropdown", true);
		click(contractEndDate);
		Reporter.log("Clicked on 'Contract End Date' to show date picker in Add Gas Meter dropdown", true);
		selectFutureDateCalender(10, random.nextInt(12), 2020);
		Reporter.log("Selected 'Contract End Date' from the date picker in Add Gas Meter dropdown", true);
		setValue(currentAnnualSpend, String.valueOf(random.nextInt(5000)));
		Reporter.log("Entered 'Current Annual Spend' in Add Gas Meter dropdown", true);
		click(saveMeterBtn);
		Reporter.log("Clicked on 'Save Meter Data' button", true);
		click(okBtn);
		Reporter.log("Clicked Ok button in popup after adding meter successfully", true);
		return gasMeterNum;
	}
	/*PM_PP_TC_086*/
	public void addGasMeterUsingValidTestData() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		int gasMetersCount = Integer.parseInt(getText(totalGasMetersCountInFilter));
		Reporter.log("Stored total number of gas meters as displayed in filter before adding a gas meter", true);
		String gasMeterNum = addValidGasMeterGeneric();
		Thread.sleep(2000);
		int newGasMetersCount = Integer.parseInt(getText(totalGasMetersCountInFilter));
		Reporter.log("Stored total number of gas meters as displayed in filter after adding a gas meter", true);
		softAssertion.assertEquals(newGasMetersCount, gasMetersCount + 1, "Gas meter count in filter is getting increased");
		boolean editMeterBtnDisplayStatus = isElementPresent(editMeterBtn(gasMeterNum));
		Reporter.log("Checked if edit button is displaying for the meter", true);
		softAssertion.assertTrue(editMeterBtnDisplayStatus, "Edit button for the meter is not displaying");
		boolean deleteMeterBtnDisplayStatus = isElementPresent(deleteMeterBtn(gasMeterNum));
		Reporter.log("Checked if delete button is displaying for the meter", true);
		softAssertion.assertTrue(deleteMeterBtnDisplayStatus, "Delete button is not displaying for the meter");
		softAssertion.assertAll();
	}
	/*PM_PP_TC_087*/
	public void addExpiredGasMeter() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		Random random = new Random();
		click(addMeter);
		Reporter.log("Clicked on 'Add Meter' dropdown", true);
		click(addGasMeter);
		Reporter.log("Clicked on 'Gas' in Add Meter dropdown", true);
		String gasMeterNum = String.valueOf(random.nextInt(1000000000));;
		setValue(gasMeterNumber, gasMeterNum);
		Reporter.log("Entered in MPRN number in Add Gas Meter dropdown", true);
		selectByVisibleText(procurementType, readExcelData("Sheet3",5,3));
		Reporter.log("Selected procurement type in Add Gas Meter dropdown", true);
		setValue(expectedConsumption, readExcelData("Sheet3",5,4));
		Reporter.log("Entered 'Expected Consumption' in Add Gas Meter dropdown", true);
		selectByVisibleText(gasCurrentSuppliers, readExcelData("Sheet3",5,5));
		Reporter.log("Selected 'Current Supplier' in Add Gas Meter dropdown", true);
		click(contractEndDate);
		Reporter.log("Clicked on 'Contract End Date' to show date picker in Add Gas Meter dropdown", true);
		selectPrevDateCalender(Integer.parseInt(readExcelData("Sheet3",5,6)), Integer.parseInt(readExcelData("Sheet3",5,7)), Integer.parseInt(readExcelData("Sheet3",5,8)));
		Reporter.log("Selected 'Contract End Date' from the date picker in Add Gas Meter dropdown", true);
		setValue(currentAnnualSpend, readExcelData("Sheet3",5,9));
		Reporter.log("Entered 'Current Annual Spend' in Add Gas Meter dropdown", true);
		click(saveMeterBtn);
		Reporter.log("Clicked on 'Save Meter Data' button", true);
		softAssertion.assertTrue(isElementPresent(meterSavedPopup), "Meter saved successfully is not displaying");
		click(okBtn);
		Reporter.log("Clicked Ok button in popup after adding meter successfully", true);
		Thread.sleep(2000);
		boolean contractRenewalDateDisplayStatus = contractRenewalDate(gasMeterNum).contains("OUT OF CONTRACT");
		Reporter.log("Checked if 'Contract Renewal Date is displaying as 'Out of Contract'", true);
		Assert.assertTrue(contractRenewalDateDisplayStatus, "Contract Renewal Date is not displaying as 'Out of Contract'");
		softAssertion.assertAll();
	}
	/*PM_PP_TC_088*/
	public void checkSavedDetailsAfterAddingGasMeter() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		String gasMeterNum = addValidGasMeterGeneric();
		Thread.sleep(2000);
		viewMeterDetails(gasMeterNum);
		Reporter.log("Clicked on meter number to see the details of the meter", true);
		boolean meterNumberDisplayStatus = meterNumberInMeterDetails(gasMeterNum).equals(gasMeterNum);
		Reporter.log("Checked if meter number is displaying in meter details section.", true);
		softAssertion.assertTrue(meterNumberDisplayStatus, "Meter number is not displaying in meter details section");
		boolean presenceOfAMRdataUploaderBtnStatus = isElementPresent(AMRdataUploaderBtn(gasMeterNum));
		Reporter.log("Checked if AMR Data Uploader button is displaying in meter details section.", true);
		softAssertion.assertTrue(presenceOfAMRdataUploaderBtnStatus, "AMR Data Uploader Button is not displaying");
		boolean presenceOfAddContractHistoryBtnStatus = isElementPresent(addContractHistoryBtn(gasMeterNum));
		Reporter.log("Checked if 'Add Contract History' button is displaying in meter details section.", true);
		softAssertion.assertTrue(presenceOfAddContractHistoryBtnStatus, "Add contract history Button is not displaying");
		softAssertion.assertAll();
	}
	
	public void addGasMeterUsingDifferentTestData(String gasMeterNumber, String procurementType, String expectedConsumption, 
			String currentSupplier, int dayOfMonthOfContractEndDate, int monthNumberOfContractEndDate, int yearOfContractEndDate, 
			String currentAnnualSpend) throws Throwable
	{
		SoftAssert softAssertion = new SoftAssert();
		click(addMeter);
		Reporter.log("Clicked on 'Add Meter' dropdown", true);
		click(addGasMeter);
		Reporter.log("Clicked on 'Gas' in Add Meter dropdown", true);
		Thread.sleep(1000);
		setValue(this.gasMeterNumber, gasMeterNumber);
		Reporter.log("Entered in MPRN number in Add Gas Meter dropdown", true);
		selectByVisibleText(this.procurementType, procurementType);
		Reporter.log("Selected procurement type in Add Gas Meter dropdown", true);
		setValue(this.expectedConsumption, expectedConsumption);
		Reporter.log("Entered 'Expected Consumption' in Add Gas Meter dropdown", true);
		selectByVisibleText(gasCurrentSuppliers, currentSupplier);
		Reporter.log("Selected 'Current Supplier' in Add Gas Meter dropdown", true);
		click(contractEndDate);
		Reporter.log("Clicked on 'Contract End Date' to show date picker in Add Gas Meter dropdown", true);
		selectFutureDateCalender(dayOfMonthOfContractEndDate, monthNumberOfContractEndDate, yearOfContractEndDate);
		Reporter.log("Selected 'Contract End Date' from the date picker in Add Gas Meter dropdown", true);
		setValue(this.currentAnnualSpend, currentAnnualSpend);
		Reporter.log("Entered 'Current Annual Spend' in Add Gas Meter dropdown", true);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("save-meter-button"))).click().build().perform();
		
		//actionsClick(saveMeterBtn);
		Reporter.log("Clicked on 'Save Meter Data' button", true);
		if(getAttribute(this.gasMeterNumber, "value").isEmpty()) {
			String gasMeterNumberErrorStatus = getAttribute(this.gasMeterNumber, "aria-invalid");
			System.out.println("value of aria invalid: " + gasMeterNumberErrorStatus);
			softAssertion.assertTrue(gasMeterNumberErrorStatus.isEmpty(), "Mandatory expression while validating 'Gas Meter Number' is not displaying");
			Reporter.log("Checked if error expression is displaying for 'Gas Meter Number'", true);
		}
		if(getAttribute(this.expectedConsumption, "value").isEmpty()) {
			String expectedConsumptionErrorStatus = getAttribute(this.expectedConsumption, "aria-invalid");
			softAssertion.assertTrue(expectedConsumptionErrorStatus.equals("true"), "Mandatory expression while validating 'Expected Consumption' field is not displaying");
			Reporter.log("Checked if error expression is displaying for 'Expected Consumption' Field", true);
		}
		if(getAttribute(this.contractEndDate, "value").isEmpty()) {
			String contractEndDateErrorStatus = getAttribute(this.contractEndDate, "aria-invalid");
			softAssertion.assertTrue(contractEndDateErrorStatus.equals("true"), "Mandatory expression while validating 'Contract End Date' field is not displaying");
			Reporter.log("Checked if error expression is displaying for 'Contract End Date' Field", true);
		}
		boolean meterSuccessfullyAddedMsgStatus = isElementPresent(meterSavedPopup);
		if(meterSuccessfullyAddedMsgStatus) {
			click(okBtn);
			Reporter.log("Clicked Ok button in popup after adding meter successfully", true);
			boolean meterNumDisplayedGasMeterListStatus = isElementExistInDropDown(allGasMeterList, gasMeterNumber);
			Reporter.log("Checked if meter number is displaying meter list.", true);
			softAssertion.assertTrue(meterNumDisplayedGasMeterListStatus, "The meter number is not displaying gas meter list. Meter not added");
		}
		softAssertion.assertAll();
	}
	
	public void addHHMeterUsingDifferentTestData(String meterNoDropdownFieldValue, String meterNoSecondField, String meterNoThirdField, String meterNoFourthField, 
			String meterNoFifthField, String meterNoSixthField, String meterNoSeventhField, String procurementType,	
			String expectedConsumption, String currentSupplier, String capacity, String currentAnnualSpend, 
			String currentMeterOperator, String currentDataCollector) throws Throwable
	{
		SoftAssert softAssertion = new SoftAssert();
		click(addMeter);
		click(addHHMeter);
		selectByVisibleText(meterNumDropdownField, meterNoDropdownFieldValue);		
		setValue(meterNumSecondField, meterNoSecondField);
		setValue(meterNumThirdField, meterNoThirdField);
		setValue(meterNumFourthField, meterNoFourthField);
		setValue(meterNumFifthField, meterNoFifthField);
		setValue(meterNumSixthField, meterNoSixthField);
		setValue(meterNumSeventhField, meterNoSeventhField);
		selectByVisibleText(this.procurementType, procurementType);
		
		boolean verifiedMPANNumberIconDisplayStatus = isElementPresent(verifiedMPANNumberIcon);
		if(verifiedMPANNumberIconDisplayStatus) {
			softAssertion.assertTrue(verifiedMPANNumberIconDisplayStatus, "Incorrect MPAN number entered");
			Reporter.log("Checked if symbol for valid MPAN number is displaying", true);
		}
		else {
			boolean invalidMPANNumberIconDisplayStatus = isElementPresent(invalidMPANNumberIcon);
			softAssertion.assertTrue(invalidMPANNumberIconDisplayStatus, "Icon for invalid MPAN number is not displaying");
			Reporter.log("Checked if symbol for invalid MPAN number is displaying", true);
		}
		
		setValue(this.expectedConsumption, expectedConsumption);
		selectByVisibleText(this.currentSupplier, currentSupplier);
		setValue(this.capacity, capacity);
		setValue(this.currentAnnualSpend, currentAnnualSpend);
		selectByVisibleText(this.currentMeterOperator, currentMeterOperator);
		selectByVisibleText(this.currentDataCollector, currentDataCollector);
		Reporter.log("Entered data in various fields in Add HH Meter popup", true);
		
		click(saveMeterBtn);
		Reporter.log("Clicked on 'Save Meter Data' button", true);
		if(getAttribute(meterNumSecondField, "value").equals("")) {
			String meterNumSecondFieldErrorStatus = getAttribute(meterNumSecondField, "aria-invalid");
			softAssertion.assertTrue(meterNumSecondFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumSecondField is not displaying");
			Reporter.log("Checked if error expression is displaying for meterNumSecondField", true);
		}
		if(getAttribute(meterNumThirdField, "value").equals("")) {
			String meterNumThirdFieldErrorStatus = getAttribute(meterNumThirdField, "aria-invalid");
			softAssertion.assertTrue(meterNumThirdFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumThirdField is not displaying");
			Reporter.log("Checked if error expression is displaying for meterNumThirdField", true);
		}
		if(getAttribute(meterNumFourthField, "value").equals("")) {
			String meterNumFourthFieldErrorStatus = getAttribute(meterNumFourthField, "aria-invalid");
			softAssertion.assertTrue(meterNumFourthFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumFourthField is not displaying");
			Reporter.log("Checked if error expression is displaying for meterNumFourthField", true);
		}
		if(getAttribute(meterNumFifthField, "value").equals("")) {
			String meterNumFifthFieldErrorStatus = getAttribute(meterNumFifthField, "aria-invalid");
			softAssertion.assertTrue(meterNumFifthFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumFifthField is not displaying");
			Reporter.log("Checked if error expression is displaying for meterNumFifthField", true);
		}
		if(getAttribute(meterNumSixthField, "value").equals("")) {
			String meterNumSixthFieldErrorStatus = getAttribute(meterNumSixthField, "aria-invalid");
			softAssertion.assertTrue(meterNumSixthFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumSixthField is not displaying");
			Reporter.log("Checked if error expression is displaying for meterNumSixthField", true);
		}
		if(getAttribute(meterNumSeventhField, "value").equals("")) {
			String meterNumSeventhFieldErrorStatus = getAttribute(meterNumSeventhField, "aria-invalid");
			softAssertion.assertTrue(meterNumSeventhFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumSeventhField is not displaying");
			Reporter.log("Checked if error expression is displaying for meterNumSeventhField", true);
		}
		if(getAttribute(this.expectedConsumption, "value").equals("")) {
			String expectedConsumptionFieldErrorStatus = getAttribute(this.expectedConsumption, "aria-invalid");
			softAssertion.assertTrue(expectedConsumptionFieldErrorStatus.equals("true"), "Mandatory expression while validating Expected Consumption is not displaying");
			Reporter.log("Checked if error expression is displaying for Expected Consumption", true);
		}
		if(getAttribute(this.contractEndDate, "value").equals("")) {
			String contractEndDateFieldErrorStatus = getAttribute(this.contractEndDate, "aria-invalid");
			softAssertion.assertTrue(contractEndDateFieldErrorStatus.equals("true"), "Mandatory expression while validating Contract End Date is not displaying");
			Reporter.log("Checked if error expression is displaying for Contract End Date", true);
		}
		if(getAttribute(this.capacity, "value").equals("")) {
			String capacityErrorStatus = getAttribute(this.capacity, "aria-invalid");
			softAssertion.assertTrue(capacityErrorStatus.equals("true"), "Mandatory expression while validating Capacity field is not displaying");
			Reporter.log("Checked if error expression is displaying for Capacity", true);
		}
				
		boolean meterDataSaveStatus = isElementPresent(meterSavedPopup);
		softAssertion.assertTrue(meterDataSaveStatus, "Meter data was not saved");
		Reporter.log("Checked if pop for saving meter data successfully is displayed", true);
		
		softAssertion.assertAll();
	}
	
	
	public void validateAddnHHMeterPopupUsingDifferentTestData(String meterNoDropdownFieldValue, String meterNoSecondField, String meterNoThirdField, String meterNoFourthField, 
			String meterNoFifthField, String meterNoSixthField, String meterNoSeventhField, String procurementType, String expectedConsumption, 
			String currentSupplier, String currentAnnualSpend) throws Throwable	{
		
		SoftAssert softAssertion = new SoftAssert();
		click(addMeter);
		Reporter.log("Clicked on add meter dropdown.", true);
		click(addnHHMeter);
		Reporter.log("Clicked on nHH Meter in add meter dropdown", true);
		Thread.sleep(1000);
		selectByVisibleText(meterNumDropdownField, meterNoDropdownFieldValue);		
		setValue(meterNumSecondField, meterNoSecondField);
		setValue(meterNumThirdField, meterNoThirdField);
		setValue(meterNumFourthField, meterNoFourthField);
		setValue(meterNumFifthField, meterNoFifthField);
		setValue(meterNumSixthField, meterNoSixthField);
		setValue(meterNumSeventhField, meterNoSeventhField);
		Reporter.log("Entered data in 7 fields for meter number", true);
		selectByVisibleText(this.procurementType, procurementType);
		Reporter.log("Entered procurement type", true);
		/*boolean verifiedMPANNumberIconDisplayStatus = isElementPresent(verifiedMPANNumberIcon);
		Reporter.log("Checked if the MPAN number is verified", true);
		if(verifiedMPANNumberIconDisplayStatus) {
			softAssertion.assertTrue(verifiedMPANNumberIconDisplayStatus, "Invalid MPAN number entered");
			Reporter.log("Checked if symbol for valid MPAN number is displaying", true);
		}
		else {
			boolean invalidMPANNumberIconDisplayStatus = isElementPresent(invalidMPANNumberIcon);
			softAssertion.assertTrue(invalidMPANNumberIconDisplayStatus, "Icon for invalid MPAN number is not displaying");
			Reporter.log("Checked if symbol for invalid MPAN number is displaying", true);
		}*/
		
		setValue(this.expectedConsumption, expectedConsumption);
		Reporter.log("Entered value in expected consumption", true);
		selectByVisibleText(this.currentSupplier, currentSupplier);
		Reporter.log("Selected current supplier from supplier dropdown", true);
		setValue(this.currentAnnualSpend, currentAnnualSpend);
		Reporter.log("Entered data in 'Current Annual Spent'", true);
		
		click(saveMeterBtn);
		Reporter.log("Clicked on 'Save Meter Data' button", true);
		if(getAttribute(meterNumSecondField, "value").equals("")) {
			String meterNumSecondFieldErrorStatus = getAttribute(meterNumSecondField, "aria-invalid");
			if(meterNumSecondFieldErrorStatus == null)
				meterNumSecondFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumSecondFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumSecondField is not displaying");
			Reporter.log("Checked if error expression is displaying for meterNumSecondField", true);
		}
		if(getAttribute(meterNumThirdField, "value").equals("")) {
			String meterNumThirdFieldErrorStatus = getAttribute(meterNumThirdField, "aria-invalid");
			if(meterNumThirdFieldErrorStatus == null)
				meterNumThirdFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumThirdFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumThirdField is not displaying");
			Reporter.log("Checked if error expression is displaying for meterNumThirdField", true);
		}
		if(getAttribute(meterNumFourthField, "value").equals("")) {
			String meterNumFourthFieldErrorStatus = getAttribute(meterNumFourthField, "aria-invalid");
			if(meterNumFourthFieldErrorStatus == null)
				meterNumFourthFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumFourthFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumFourthField is not displaying");
			Reporter.log("Checked if error expression is displaying for meterNumFourthField", true);
		}
		if(getAttribute(meterNumFifthField, "value").equals("")) {
			String meterNumFifthFieldErrorStatus = getAttribute(meterNumFifthField, "aria-invalid");
			if(meterNumFifthFieldErrorStatus == null)
				meterNumFifthFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumFifthFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumFifthField is not displaying");
			Reporter.log("Checked if error expression is displaying for meterNumFifthField", true);
		}
		if(getAttribute(meterNumSixthField, "value").equals("")) {
			String meterNumSixthFieldErrorStatus = getAttribute(meterNumSixthField, "aria-invalid");
			if(meterNumSixthFieldErrorStatus == null)
				meterNumSixthFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumSixthFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumSixthField is not displaying");
			Reporter.log("Checked if error expression is displaying for meterNumSixthField", true);
		}
		if(getAttribute(meterNumSeventhField, "value").equals("")) {
			String meterNumSeventhFieldErrorStatus = getAttribute(meterNumSeventhField, "aria-invalid");
			if(meterNumSeventhFieldErrorStatus == null)
				meterNumSeventhFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumSeventhFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumSeventhField is not displaying");
			Reporter.log("Checked if error expression is displaying for meter num seventh Field", true);
		}
		if(getAttribute(this.expectedConsumption, "value").equals("")) {
			String expectedConsumptionFieldErrorStatus = getAttribute(this.expectedConsumption, "aria-invalid");
			if(expectedConsumptionFieldErrorStatus == null)
				expectedConsumptionFieldErrorStatus = "true";
			softAssertion.assertTrue(expectedConsumptionFieldErrorStatus.equals("true"), "Mandatory expression while validating Expected Consumption is not displaying");
			Reporter.log("Checked if error expression is displaying for Expected Consumption", true);
		}
		if(getAttribute(this.contractEndDate, "value").equals("")) {
			String contractEndDateFieldErrorStatus = getAttribute(this.contractEndDate, "aria-invalid");
			if(contractEndDateFieldErrorStatus == null)
				contractEndDateFieldErrorStatus = "true";
			softAssertion.assertTrue(contractEndDateFieldErrorStatus.equals("true"), "Mandatory expression while validating Contract End Date is not displaying");
			Reporter.log("Checked if error expression is displaying for Contract End Date", true);
		}
		/*boolean invalidMPANPopupDisplayStatus = isElementPresent(invalidMPANPopup);
		softAssertion.assertTrue(invalidMPANPopupDisplayStatus, "Invalid MPAN popup is not displaying");
		Reporter.log("Checked if pop for invalid popup is displayed", true);
		
		boolean meterDataSaveStatus = isElementPresent(meterSavedPopup);
		softAssertion.assertTrue(meterDataSaveStatus, "Meter data was not saved");
		Reporter.log("Checked if pop for saving meter data successfully is displayed", true);*/
		
		softAssertion.assertAll();																										
	}
	/*PM_PP_TC_071*/
	public void validateExpectedConsumptionMandatoryFieldAddNHHPopup() throws Throwable {
		click(addMeter);
		Reporter.log("Clicked on add meter dropdown.", true);
		click(addnHHMeter);
		Reporter.log("Clicked on nHH Meter in add meter dropdown", true);
		Thread.sleep(1000);
		setValue(meterNumSecondField, "234");
		Reporter.log("Entered data in meter number second field", true);
		setValue(meterNumThirdField, "978");
		Reporter.log("Entered data in meter number third field", true);
		setValue(meterNumFourthField, "10");
		Reporter.log("Entered data in meter number fourth field", true);
		setValue(meterNumFifthField, "1293");
		Reporter.log("Entered data in meter number fifth field", true);
		setValue(meterNumSixthField, "5556");
		Reporter.log("Entered data in meter number sixth field", true);
		setValue(meterNumSeventhField, "271");
		Reporter.log("Entered data in meter number seventh field", true);
		click(contractEndDate);
		Reporter.log("Clicked on contract end date field", true);
		Thread.sleep(1000);
		selectFutureDateCalender(16, 5, 2020);
		Reporter.log("Selected date from date picker", true);
		click(saveMeterBtn);
		Reporter.log("Clicked on 'Save Meter Data' button", true);
		validateMandatoryFieldAddNHHMeterGeneric();
		Reporter.log("Checked validation for all mandatory fields", true);
	}
	
	public void validateMandatoryFieldAddNHHMeterGeneric() {
		SoftAssert softAssertion = new SoftAssert();
		if(getAttribute(meterNumSecondField, "value").equals("")) {
			String meterNumSecondFieldErrorStatus = getAttribute(meterNumSecondField, "aria-invalid");
			if(meterNumSecondFieldErrorStatus == null)
				meterNumSecondFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumSecondFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumSecondField is not displaying");
			Reporter.log("Checked if error expression is displaying for meterNumSecondField", true);
		}
		if(getAttribute(meterNumThirdField, "value").equals("")) {
			String meterNumThirdFieldErrorStatus = getAttribute(meterNumThirdField, "aria-invalid");
			if(meterNumThirdFieldErrorStatus == null)
				meterNumThirdFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumThirdFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumThirdField is not displaying");
			Reporter.log("Checked if error expression is displaying for meterNumThirdField", true);
		}
		if(getAttribute(meterNumFourthField, "value").equals("")) {
			String meterNumFourthFieldErrorStatus = getAttribute(meterNumFourthField, "aria-invalid");
			if(meterNumFourthFieldErrorStatus == null)
				meterNumFourthFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumFourthFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumFourthField is not displaying");
			Reporter.log("Checked if error expression is displaying for meterNumFourthField", true);
		}
		if(getAttribute(meterNumFifthField, "value").equals("")) {
			String meterNumFifthFieldErrorStatus = getAttribute(meterNumFifthField, "aria-invalid");
			if(meterNumFifthFieldErrorStatus == null)
				meterNumFifthFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumFifthFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumFifthField is not displaying");
			Reporter.log("Checked if error expression is displaying for meterNumFifthField", true);
		}
		if(getAttribute(meterNumSixthField, "value").equals("")) {
			String meterNumSixthFieldErrorStatus = getAttribute(meterNumSixthField, "aria-invalid");
			if(meterNumSixthFieldErrorStatus == null)
				meterNumSixthFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumSixthFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumSixthField is not displaying");
			Reporter.log("Checked if error expression is displaying for meterNumSixthField", true);
		}
		if(getAttribute(meterNumSeventhField, "value").equals("")) {
			String meterNumSeventhFieldErrorStatus = getAttribute(meterNumSeventhField, "aria-invalid");
			if(meterNumSeventhFieldErrorStatus == null)
				meterNumSeventhFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumSeventhFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumSeventhField is not displaying");
			Reporter.log("Checked if error expression is displaying for meterNumSeventhField", true);
		}
		if(getAttribute(this.expectedConsumption, "value").equals("")) {
			String expectedConsumptionFieldErrorStatus = getAttribute(this.expectedConsumption, "aria-invalid");
			if(expectedConsumptionFieldErrorStatus == null)
				expectedConsumptionFieldErrorStatus = "true";
			softAssertion.assertTrue(expectedConsumptionFieldErrorStatus.equals("true"), "Mandatory expression while validating Expected Consumption is not displaying");
			Reporter.log("Checked if error expression is displaying for Expected Consumption", true);
		}
		if(getAttribute(this.contractEndDate, "value").equals("")) {
			String contractEndDateFieldErrorStatus = getAttribute(this.contractEndDate, "aria-invalid");
			if(contractEndDateFieldErrorStatus == null)
				contractEndDateFieldErrorStatus = "true";
			softAssertion.assertTrue(contractEndDateFieldErrorStatus.equals("true"), "Mandatory expression while validating Contract End Date is not displaying");
			Reporter.log("Checked if error expression is displaying for Contract End Date", true);
		}
		softAssertion.assertAll();
	}
	
	public void checkSavedDetailsAfterAddingNHHMeter() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		String mpanNumber = addValidNHHMeterGeneric();
		Reporter.log("Added a valid NHH meter and stored MPAN number in a variable.", true);
		click(totalnHHMetersCountInFilter);
		Reporter.log("Clicked on filer for NHH meters", true);
		Thread.sleep(2000);
		try {
			click(tipCloseBtn);
		}
		catch(Exception e) {
			System.out.println("Couldn't close 'Tip' message");
		}
		viewMeterDetails(mpanNumber);
		Reporter.log("Clicked on the MPAN number to view the meter details.", true);
		boolean AMRDataUploaderDisplayStatus = isElementPresent(AMRdataUploaderBtn(mpanNumber));
		Reporter.log("Checked if AMR Data Uploader button is displaying.", true);
		softAssertion.assertTrue(AMRDataUploaderDisplayStatus, "AMR Data Uploader button is not displaying");
		boolean addContractHistoryBtnDisplayStatus = isElementPresent(addContractHistoryBtn(mpanNumber));
		Reporter.log("Checked if 'Add Contract History' button is displaying.", true);
		softAssertion.assertTrue(addContractHistoryBtnDisplayStatus, "'Add Contract History' button is not displaying");
		/*boolean meterNumberSecondFieldDisplayStatus = meterNumberSecondFieldInMeterDetails(mpanNumber).contains(readExcelData("Sheet3", 6, 2));
		Reporter.log("Checked the data present in meter number second field in meter details section and verified if it is correct", true);
		softAssertion.assertTrue(meterNumberSecondFieldDisplayStatus, "Meter number second field is displaying incorrect data in meter details section.");
		boolean meterNumberThirdFieldDisplayStatus = meterNumberThirdFieldInMeterDetails(mpanNumber).contains(readExcelData("Sheet3", 6, 3));
		Reporter.log("Checked the data present in meter number third field in meter details section and verified if it is correct", true);
		softAssertion.assertTrue(meterNumberThirdFieldDisplayStatus, "Meter number third field is displaying incorrect data in meter details section.");*/
		boolean meterNumberFourthFieldDisplayStatus = meterNumberFourthFieldInMeterDetails(mpanNumber).contains(mpanNumber.substring(0, 2));
		Reporter.log("Checked the data present in meter number fourth field in meter details section and verified if it is correct", true);
		softAssertion.assertTrue(meterNumberFourthFieldDisplayStatus, "Meter number fourth field is displaying incorrect data in meter details section.");
		boolean meterNumberFifthFieldDisplayStatus = meterNumberFifthFieldInMeterDetails(mpanNumber).contains(mpanNumber.substring(2, 6));
		Reporter.log("Checked the data present in meter number fifth field in meter details section and verified if it is correct", true);
		softAssertion.assertTrue(meterNumberFifthFieldDisplayStatus, "Meter number fifth field is displaying incorrect data in meter details section.");
		boolean meterNumberSixthFieldDisplayStatus = meterNumberSixthFieldInMeterDetails(mpanNumber).contains(mpanNumber.substring(6, 10));
		Reporter.log("Checked the data present in meter number sixth field in meter details section and verified if it is correct", true);
		softAssertion.assertTrue(meterNumberSixthFieldDisplayStatus, "Meter number sixth field is displaying incorrect data in meter details section.");
		boolean meterNumberSeventhFieldDisplayStatus = meterNumberSeventhFieldInMeterDetails(mpanNumber).contains(mpanNumber.substring(10, 13));
		Reporter.log("Checked the data present in meter number seventh field in meter details section and verified if it is correct", true);
		softAssertion.assertTrue(meterNumberSeventhFieldDisplayStatus, "Meter number seventh field is displaying incorrect data in meter details section.");
		softAssertion.assertAll();
	}
	
	public String addValidNHHMeterGeneric() throws Throwable {
		
		Random random = new Random();
		//int cellNum = random.nextInt(1568);
		String mpanNumber = readExcelData("Sheet2", random.nextInt(50), 0);
		Thread.sleep(2000);
		click(addMeter);
		Reporter.log("Clicked on add meter dropdown.", true);
		click(addnHHMeter);
		Reporter.log("Clicked on nHH Meter in add meter dropdown", true);
		selectByVisibleText(meterNumDropdownField, "05");		
		setValue(meterNumSecondField, readExcelData("Sheet3", 6, 2));
		setValue(meterNumThirdField, readExcelData("Sheet3", 6, 3));
		setValue(meterNumFourthField, mpanNumber.substring(0, 2));
		setValue(meterNumFifthField, mpanNumber.substring(2, 6));
		setValue(meterNumSixthField, mpanNumber.substring(6, 10));
		setValue(meterNumSeventhField, mpanNumber.substring(10, 13));
		Reporter.log("Entered data in 7 fields for meter number", true);
		selectByVisibleText(procurementType, "Fixed");
		Reporter.log("Entered procurement type", true);
		setValue(expectedConsumption, String.valueOf(random.nextInt(5000)));
		Reporter.log("Entered value in expected consumption", true);
		click(contractEndDate);
		Reporter.log("Clicked on contract end date field", true);
		Thread.sleep(1000);
		selectFutureDateCalender(14, random.nextInt(12), 2020);
		Reporter.log("Entered date in the date picker", true);
		selectByVisibleText(currentSupplier, "Gazprom");
		Reporter.log("Selected current supplier from supplier dropdown", true);
		setValue(currentAnnualSpend, String.valueOf(random.nextInt(5000)));
		Reporter.log("Entered data in 'Current Annual Spent'", true);
		//Thread.sleep(4000);
		click(saveMeterBtn);
		Reporter.log("Clicked on 'Save Meter Data' button", true);
		Thread.sleep(2000);
		click(okBtn);
		Reporter.log("Clicked on Ok button in meter saved successfully popup.", true);
		try {
			click(tipCloseBtn);
		}
		catch(Exception e) {
			System.out.println("Couldn't close 'Tip' message");
		}
		return mpanNumber;
	}
	
	
	public void validateAddMeterDropdown() throws Throwable
	{
		SoftAssert softAssertion = new SoftAssert();
		click(addMeter);
		Reporter.log("Clicked on Add Meter dropdown");
		boolean hhElectricPresenceStatus = isElementExistInDropDown(meterUtilitiesInAddMeterDropdown, "HH Electric");
		softAssertion.assertTrue(hhElectricPresenceStatus, "HH Electric is not displaying in 'Add Meter' dropdown");
		Reporter.log("Checked if HH Electric is displaying in 'Add Meter' dropdown", true);
		boolean nHHElectricPresenceStatus = isElementExistInDropDown(meterUtilitiesInAddMeterDropdown, "nHH Electric");
		softAssertion.assertTrue(nHHElectricPresenceStatus, "nHH Electric is not displaying in 'Add Meter' dropdown");
		Reporter.log("Checked if nHH Electric is displaying in 'Add Meter' dropdown", true);
		boolean gasPresenceStatus = isElementExistInDropDown(meterUtilitiesInAddMeterDropdown, "Gas");
		softAssertion.assertTrue(gasPresenceStatus, "Gas utility is not displaying in 'Add Meter' dropdown");
		Reporter.log("Checked if 'Gas' utility is displaying in 'Add Meter' dropdown", true);
		boolean waterPresenceStatus = isElementExistInDropDown(meterUtilitiesInAddMeterDropdown, "Water");
		softAssertion.assertTrue(waterPresenceStatus, "Water utility is not displaying in 'Add Meter' dropdown");
		Reporter.log("Checked if 'Water' utility is displaying in 'Add Meter' dropdown", true);
		softAssertion.assertAll();
	}
	public void validateAddHHMeterPopup() throws Throwable
	{
		click(addMeter);
		Reporter.log("Clicked on Add Meter dropdown", true);
		Thread.sleep(1000);
		click(addHHMeter);
		Reporter.log("Clicked on HH Electric", true);
		Assert.assertTrue(isElementPresent(currentMeterOperator), "Popup for adding new HH Electric meter didn't appear");
	}
	/*PM_PP_TC_065*/
	public void validateAddnHHMeterPopup() throws Throwable
	{
		click(addMeter);
		Reporter.log("Clicked on Add Meter dropdown", true);
		//Thread.sleep(1000);
		click(addnHHMeter);
		Reporter.log("Clicked on nHH Electric meter", true);
		Assert.assertTrue(isElementPresent(procurementType), "Popup for adding new nHH Electric meter didn't appear");
	}
	public void validateAddGasMeterPopup()
	{
		click(addMeter);
		Reporter.log("Clicked on Add Meter dropdown", true);
		click(addGasMeter);
		Reporter.log("Clicked on Gas meter", true);
		Assert.assertTrue(isElementPresent(gasMeterNumber), "Popup for adding new nHH Electric meter didn't appear");
	}
}
