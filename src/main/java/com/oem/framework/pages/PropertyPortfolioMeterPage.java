package com.oem.framework.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class PropertyPortfolioMeterPage extends CustomerDashboardPage {
	
	By siteFirstRecord = By.xpath("//div[@id = 'divSitesOverview']/hgroup[1]/table/tbody/tr/td[1]");
	
	By tipCloseBtn = By.xpath("//p[contains(text(), 'Tip')]/following-sibling::a");
	
	By addMeter = By.id("add-meter-button");
	By meterUtilitiesInAddMeterDropdown = By.xpath("//div[@id = 'add-meter-button']/ul/li[*]");
	By addHHMeter = By.xpath("//div[@id = 'add-meter-button']/ul/li[1]");
	By addnHHMeter = By.xpath("//div[@id = 'add-meter-button']/ul/li[2]");
	By addGasMeter = By.xpath("//div[@id = 'add-meter-button']/ul/li[3]");
	By addWaterMeter = By.xpath("//div[@id = 'add-meter-button']/ul/li[4]"); 
	By saveMeterBtn = By.id("save-meter-button");
	WebElement saveMetBtn = driver.findElement(By.id("save-meter-button"));
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
	/* Add Water Meter Popup */
	By spidWater = By.id("spidWater");
	By spidSWHD = By.id("spidSWHD");
	By spidWaste = By.id("spidWaste");
	By meterNumber_Water = By.id("waterMeterNumber");
	By unitRate_water = By.id("waterUnitRate");
	By annualm3 = By.id("waterExpectedConsumption");
	By annualStandingCharge = By.id("annualStandingCharge");
	By rtsUnitRate = By.id("rtsUnitRate");
	By billedWasteM3 = By.id("rtsConsumption");
	By wasteAnnualStandingCharge = By.id("rtsAnnualStandingCharge");
	
	By currentSuppliersIncoming = By.id("waterSuppliersIncoming");
	By currentSuppliersSewerage = By.id("waterSuppliersSewerage");
	By contractEndDate_Water = By.id("waterContractEndDateForMeterModel");
	By rtsContractEndDate_Water = By.id("waterRTSContractEndDateForMeterModel");
	By currentAnnualSpend_Water = By.id("waterCurrentAnnualSpend");
	By swHD = By.id("swHD");
	By swHDBasis = By.id("swHDBasis");
	
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
	//Contract History
	By addContractHistoryPopup = By.xpath("//h3[text() = 'Add new Contract History details']");
	By hhMeterDetailsBtnFirstRecord = By.xpath("//div[@id = 'meters-1']/div/div[1]/table/tbody/tr/td[7]/a[4]");
	By hhMeterNumberFirstRecord = By.xpath("//div[@id = 'meters-1']/div/div[1]/table/tbody/tr/td[2]/div[2]");
	By nhhMeterNumberFirstRecord = By.xpath("//div[@id = 'meters-3']/div/div[1]/table/tbody/tr/td[2]/div[2]");
	
	By saveContractHistoryBtn = By.xpath("//form[@id='frmAddEditContractHistory']//button");
	By dateTraded = By.id("dateTraded");
	By contractStartDate = By.id("contractStartDate");
	By contractEndDate_ContractHist = By.id("contractEndDate");
	By dayRate = By.id("dayRate");
	By nightRate = By.id("nightRate");
	By standingCharge = By.id("standingCharge");
	By unitCharge = By.id("unitCharge");
	By capacityCharge = By.id("capacityCharge");
	By contractedAnnualSpend = By.id("contractedAnnualSpend");
	By contractedConsumption = By.id("contractedConsumption");
	By supplierForContractHistoryDDwn = By.id("electricitySuppliersForContractHistory");
	By supplierContHistDDwn_Gas = By.id("gasSuppliersForContractHistory");
	By supplierProductDDwn = By.id("supplierProductForContractHistory");
	By uploadContractBtn = By.id("btnShowContractUploadModal");
	By contractHistSaveSuccessPopup = By.xpath("//div[text() = 'The contract history data was saved successfully.']");
	
	int meterValue;
	
	public void setMeterValue() {}
	public int getSavedMeterValue() {return meterValue;}
	/**
	 * Returns the locator of the Edit meter button by passing 'Meter Number' as argument
	 * @param meterNumber
	 */
	public By editMeterBtn(String meterNumber) {
		By editMeterBtn = By.xpath("//div[contains(text(), '" + meterNumber + "')]/../following-sibling::td[5]/a[1]");
		return editMeterBtn;
	}
	public By reviewHHmeterDataBtn(String mpanNumber) {
		By editMeterBtn = By.xpath("//div[contains(text(), '" + mpanNumber + "')]/../following-sibling::td[5]/a[2]");
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
	public By deleteHHmeterBtn(String mpanNumber) {
		By deleteMeterBtn = By.xpath("//div[contains(text(), '" + mpanNumber + "')]/../following-sibling::td[5]/a[3]");
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
	 * It returns the capacity of HH meter in the details section.
	 * @param mpanNumber
	 * @return
	 */
	public String capacityData(String mpanNumber) {
		By capacityData = By.xpath("//div[contains(text(), '" + mpanNumber + "')]/../../../../following-sibling::div/div[1]/table/tbody/tr/td[2]/div[2]");
		return getText(capacityData);
	}
	
	
	/**
	 * Returns the locator of HH Data Uploader button of a meter. 
	 * @param meterNumber
	 * @return 
	 */
	public By hhDataUploaderBtn(String mpanNumber) {
		By dataUploaderBtn = By.xpath("//div[contains(text(), '"+ mpanNumber +"')]/../../../../following-sibling::div/div[1]/table/tbody/tr/td[5]/button");
		return dataUploaderBtn;
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
	public By addHHcontractHistoryBtn(String mpanNumber) {
		By addContractHistBtn = By.xpath("//div[contains(text(), '"+ mpanNumber +"')]/../../../../following-sibling::div/div[1]/table/tbody/tr/td[6]/button");
		return addContractHistBtn;
	}
	/**
	 * Returns the locator of 'Add Contract History Button' of a meter for NHH and Gas utility meters.
	 * @param meterNumber
	 * @return
	 */
	public By addContractHistoryBtn(String meterNumber) {
		By addContractHistBtn = By.xpath("//div[contains(text(), '" + meterNumber + "')]/../../../../following-sibling::div/div[1]/table/tbody/tr/td[4]/button");
		return addContractHistBtn;
	}
	public By addWaterContractHistoryBtn(String spidWater) {
		By addContractHistBtn = By.xpath("//div[contains(text(), '" + spidWater + "')]/../../../../following-sibling::div/div[1]/table/tbody/tr/td[3]/button");
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
		Thread.sleep(3000);
		scrollToElement(editMeterBtn(meterNum));
		click(editMeterBtn(meterNum));
		Thread.sleep(2000);
		Random random = new Random();
		String gasMeterNum = String.valueOf(random.nextInt(1000000000));
		setValue(gasMeterNumber, gasMeterNum);
		selectByVisibleText(procurementType, "Flexible");
		String expectedConsumptionValue = String.valueOf(random.nextInt(5000));
		setValue(expectedConsumption, expectedConsumptionValue);
		selectByVisibleText(gasCurrentSuppliers, "Crown Gas");
		click(contractEndDate);
		selectFutureDateCalender(24, random.nextInt(12), 2020);
		setValue(currentAnnualSpend, String.valueOf(random.nextInt(5000)));
		click(saveMeterBtn);
		Thread.sleep(2000);
		click(okBtn);
		Thread.sleep(3000);
		scrollToElement(editMeterBtn(gasMeterNum));
		boolean expectedConsumptionDisplayStatus = expectedConsumptionData(gasMeterNum).contains(expectedConsumptionValue) && expectedConsumptionData(gasMeterNum).contains("kWh");
		softAssertion.assertTrue(expectedConsumptionDisplayStatus, "Expected consumption is not displaying correct value");
		viewMeterDetails(gasMeterNum);
		boolean meterNumberDisplayStatus = meterNumberInMeterDetails(gasMeterNum).equals(gasMeterNum);
		softAssertion.assertTrue(meterNumberDisplayStatus, "Meter number is not displaying in meter details section");
		boolean presenceOfAMRdataUploaderBtnStatus = isElementPresent(AMRdataUploaderBtn(gasMeterNum));
		softAssertion.assertTrue(presenceOfAMRdataUploaderBtnStatus, "AMR Data Uploader Button is not displaying");
		boolean presenceOfAddContractHistoryBtnStatus = isElementPresent(addContractHistoryBtn(gasMeterNum));
		softAssertion.assertTrue(presenceOfAddContractHistoryBtnStatus, "Add contract history Button is not displaying");
		softAssertion.assertAll();
	}
	
	public void validateEditGasMeterPopup() throws Throwable {
		String meterNum = addValidGasMeterGeneric();
		Thread.sleep(3000);
		scrollToElement(editMeterBtn(meterNum));
		click(editMeterBtn(meterNum));
		Thread.sleep(2000);
		boolean editGasMeterPopupDisplayStatus = isElementPresent(editMeterPopup);
		Assert.assertTrue(editGasMeterPopupDisplayStatus, "Edit popup is not displaying");
	}
	
	public void validateGasDeleteMeterPopup() throws Throwable {

		String meterNum = addValidGasMeterGeneric();
		Thread.sleep(2000);
		click(deleteMeterBtn(meterNum));
		Thread.sleep(1000);
		boolean deletePopupDisplayStatus = isElementPresent(deleteMeterPopup);
		Assert.assertTrue(deletePopupDisplayStatus, "Delete meter popup is not displaying");
	}
	/*PM_PP_TC_092*/
	public void validateDeleteGasMeter() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		String meterNum = addValidGasMeterGeneric();
		Thread.sleep(3000);
		int totalGasMeters = Integer.parseInt(getText(totalGasMetersCountInFilter));
		scrollToElement(editMeterBtn(meterNum));
		click(deleteMeterBtn(meterNum));
		Thread.sleep(2000);
		selectByVisibleText(meterDeleteReasonDropdown, "Closing down site");
		setValue(meterDeleteNotes, "Shutting down site");
		click(deleteMeterBtnInDeletePopup);
		Thread.sleep(1000);
		click(okBtn);
		Thread.sleep(1000);
		click(totalGasMetersCountInFilter);
		boolean meterStatusAfterDeletionStatus = meterStatus(meterNum).contains("DELETED");
		softAssertion.assertTrue(meterStatusAfterDeletionStatus, "Meter status 'Deleted' is not displaying");
		boolean revertDeletionBtnDisplayStatus = isElementPresent(revertMeterDeletionBtn(meterNum));
		softAssertion.assertTrue(revertDeletionBtnDisplayStatus, "Revert Deletion button is not displaying for the deleted meter.");
		int totalGasMetersNew = Integer.parseInt(getText(totalGasMetersCountInFilter));
		softAssertion.assertEquals(totalGasMetersNew, totalGasMeters - 1, "Total gas meters is not getting decremented.");
		softAssertion.assertAll();
	}
	public void validateMeterRevertDeletion() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		String meterNum = addValidGasMeterGeneric();
		Thread.sleep(2000);
		int totalGasMeters = Integer.parseInt(getText(totalGasMetersCountInFilter));
		scrollToElement(editMeterBtn(meterNum));
		click(deleteMeterBtn(meterNum));
		Thread.sleep(1000);
		selectByVisibleText(meterDeleteReasonDropdown, "Closing down site");
		setValue(meterDeleteNotes, "Shutting down site");
		click(deleteMeterBtnInDeletePopup);
		Thread.sleep(2000);
		click(okBtn);
		Thread.sleep(3000);
		click(totalGasMetersCountInFilter);
		Thread.sleep(1000);
boolean revertDeletionBtnDisplayStatus = isElementPresent(revertMeterDeletionBtn(meterNum));
		softAssertion.assertTrue(revertDeletionBtnDisplayStatus, "Revert Deletion button is not displaying for the deleted meter.");
		scrollToElement(editMeterBtn(meterNum));
		click(revertMeterDeletionBtn(meterNum));
		Thread.sleep(1000);
		boolean revertMeterDeletionConfirmPopupDisplayStatus = isElementPresent(revertMeterConfirmPopup);
		softAssertion.assertTrue(revertMeterDeletionConfirmPopupDisplayStatus, "Confirmation popup is not displaying.");
		click(cancelBtn);
		waitForElementInvisible(revertMeterConfirmPopup);
		revertMeterDeletionConfirmPopupDisplayStatus = isElementPresent(revertMeterConfirmPopup);
		softAssertion.assertFalse(revertMeterDeletionConfirmPopupDisplayStatus, "Confirmation popup is still displaying after clicking cancel button");
		click(revertMeterDeletionBtn(meterNum));
		Thread.sleep(1000);
		click(okBtn);
		Thread.sleep(2000);
		click(totalGasMetersCountInFilter);
		boolean meterStatusData = meterStatus(meterNum).contains("ACTIVE");
		softAssertion.assertTrue(meterStatusData, "Meter status is not displaying as Active after revering deletion.");
		int totalGasMetersNew = Integer.parseInt(getText(totalGasMetersCountInFilter));
		softAssertion.assertEquals(totalGasMetersNew, totalGasMeters, "Total gas meters is not displaying correct data after deleting meter and revert deletion of meter.");
	}
	
	/**
	 * Adds gas meter and returns its meter number. 
	 * @return gasMeterNumber
	 * @throws Throwable
	 */
	public String addValidGasMeterGeneric() throws Throwable {
		Random random = new Random();
		click(addMeter);
		click(addGasMeter);
		Thread.sleep(1000);
		String gasMeterNum = String.valueOf(random.nextInt(1000000000));
		setValue(gasMeterNumber, gasMeterNum);
		selectByVisibleText(procurementType, "Fixed");
		String expectedConsumptionValue = String.valueOf(random.nextInt(5000));
		setValue(expectedConsumption, expectedConsumptionValue);
		selectByVisibleText(gasCurrentSuppliers, "D-ENERGi");
		click(contractEndDate);
		selectFutureDateCalender(10, random.nextInt(12), 2020);
		setValue(currentAnnualSpend, String.valueOf(random.nextInt(5000)));
		click(saveMeterBtn);
		click(okBtn);
		return gasMeterNum;
	}
	/*PM_PP_TC_086*/
	public void addGasMeterUsingValidTestData() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		int gasMetersCount = Integer.parseInt(getText(totalGasMetersCountInFilter));
		String gasMeterNum = addValidGasMeterGeneric();
		Thread.sleep(2000);
		int newGasMetersCount = Integer.parseInt(getText(totalGasMetersCountInFilter));
		softAssertion.assertEquals(newGasMetersCount, gasMetersCount + 1, "Gas meter count in filter is getting increased");
		boolean editMeterBtnDisplayStatus = isElementPresent(editMeterBtn(gasMeterNum));
		softAssertion.assertTrue(editMeterBtnDisplayStatus, "Edit button for the meter is not displaying");
		boolean deleteMeterBtnDisplayStatus = isElementPresent(deleteMeterBtn(gasMeterNum));
		softAssertion.assertTrue(deleteMeterBtnDisplayStatus, "Delete button is not displaying for the meter");
		softAssertion.assertAll();
	}
	/*PM_PP_TC_087*/
	public void addExpiredGasMeter() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		Random random = new Random();
		click(addMeter);
		click(addGasMeter);
		Thread.sleep(1000);
		String gasMeterNum = String.valueOf(random.nextInt(1000000000));;
		setValue(gasMeterNumber, gasMeterNum);
		selectByVisibleText(procurementType, readExcelData("Sheet3",5,3));
		setValue(expectedConsumption, readExcelData("Sheet3",5,4));
		selectByVisibleText(gasCurrentSuppliers, readExcelData("Sheet3",5,5));
		click(contractEndDate);
		selectPrevDateCalender(Integer.parseInt(readExcelData("Sheet3",5,6)), Integer.parseInt(readExcelData("Sheet3",5,7)), Integer.parseInt(readExcelData("Sheet3",5,8)));
		setValue(currentAnnualSpend, readExcelData("Sheet3",5,9));
		click(saveMeterBtn);
		softAssertion.assertTrue(isElementPresent(meterSavedPopup), "Meter saved successfully is not displaying");
		click(okBtn);
		Thread.sleep(3000);
		scrollToElement(editMeterBtn(gasMeterNum));
		boolean contractRenewalDateDisplayStatus = contractRenewalDate(gasMeterNum).contains("OUT OF CONTRACT");
		Assert.assertTrue(contractRenewalDateDisplayStatus, "Contract Renewal Date is not displaying as 'Out of Contract'");
		softAssertion.assertAll();
	}
	/*PM_PP_TC_088*/
	public String checkSavedDetailsAfterAddingGasMeter() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		String gasMeterNum = addValidGasMeterGeneric();
		Thread.sleep(3000);
		scrollToElement(editMeterBtn(gasMeterNum));
		viewMeterDetails(gasMeterNum);
		boolean meterNumberDisplayStatus = meterNumberInMeterDetails(gasMeterNum).equals(gasMeterNum);
		softAssertion.assertTrue(meterNumberDisplayStatus, "Meter number is not displaying in meter details section");
		boolean presenceOfAMRdataUploaderBtnStatus = isElementPresent(AMRdataUploaderBtn(gasMeterNum));
		softAssertion.assertTrue(presenceOfAMRdataUploaderBtnStatus, "AMR Data Uploader Button is not displaying");
		boolean presenceOfAddContractHistoryBtnStatus = isElementPresent(addContractHistoryBtn(gasMeterNum));
		softAssertion.assertTrue(presenceOfAddContractHistoryBtnStatus, "Add contract history Button is not displaying");
		softAssertion.assertAll();
		return gasMeterNum;
	}
	
	public void addGasMeterUsingDifferentTestData(String gasMeterNumber, String procurementType, String expectedConsumption, 
			String currentSupplier, int dayOfMonthOfContractEndDate, int monthNumberOfContractEndDate, int yearOfContractEndDate, 
			String currentAnnualSpend) throws Throwable
	{
		SoftAssert softAssertion = new SoftAssert();
		click(addMeter);
		click(addGasMeter);
		Thread.sleep(1000);
		setValue(this.gasMeterNumber, gasMeterNumber);
		selectByVisibleText(this.procurementType, procurementType);
		setValue(this.expectedConsumption, expectedConsumption);
		selectByVisibleText(gasCurrentSuppliers, currentSupplier);
		click(contractEndDate);
		selectFutureDateCalender(dayOfMonthOfContractEndDate, monthNumberOfContractEndDate, yearOfContractEndDate);
		setValue(this.currentAnnualSpend, currentAnnualSpend);
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", saveMetBtn);
		
		if(getAttribute(this.capacity, "value").equals("")) {
			String capacityErrorStatus = getAttribute(this.capacity, "aria-invalid");
			if(capacityErrorStatus == null)
				capacityErrorStatus = "true";
			softAssertion.assertTrue(capacityErrorStatus.equals("true"), "Mandatory expression while validating Capacity field is not displaying");			
		}
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("save-meter-button"))).click().build().perform();
		
		//actionsClick(saveMeterBtn);
		if(getAttribute(this.gasMeterNumber, "value").isEmpty()) {
			String gasMeterNumberErrorStatus = getAttribute(this.gasMeterNumber, "aria-invalid");
			if(gasMeterNumberErrorStatus == null)
				gasMeterNumberErrorStatus = "true";
			softAssertion.assertTrue(gasMeterNumberErrorStatus.equals("true"), "Mandatory expression while validating 'Gas Meter Number' is not displaying");			
		}
		if(getAttribute(this.expectedConsumption, "value").equals("")) {
			String expectedConsumptionErrorStatus = getAttribute(this.expectedConsumption, "aria-invalid");
			if(expectedConsumptionErrorStatus == null)
				expectedConsumptionErrorStatus = "true";
			softAssertion.assertTrue(expectedConsumptionErrorStatus.equals("true"), "Mandatory expression while validating 'Expected Consumption' field is not displaying");			
		}
		if(getAttribute(this.contractEndDate, "value").equals("")) {
			String contractEndDateErrorStatus = getAttribute(this.contractEndDate, "aria-invalid");
			if(contractEndDateErrorStatus == null)
				contractEndDateErrorStatus = "true";
			softAssertion.assertTrue(contractEndDateErrorStatus.equals("true"), "Mandatory expression while validating 'Contract End Date' field is not displaying");			
		}
		
		/*
		 * boolean meterSuccessfullyAddedMsgStatus = isElementPresent(meterSavedPopup);
		 * if(meterSuccessfullyAddedMsgStatus) { click(okBtn); boolean
		 * meterNumDisplayedGasMeterListStatus =
		 * isElementExistInDropDown(allGasMeterList, gasMeterNumber);
		 * softAssertion.assertTrue(meterNumDisplayedGasMeterListStatus,
		 * "The meter number is not displaying gas meter list. Meter not added"); }
		 */
		softAssertion.assertAll();
	}

	
	
	public void addHHMeterUsingDifferentTestData(String meterNoSecondField, String meterNoThirdField, String meterNoFourthField, 
			String meterNoFifthField, String meterNoSixthField, String meterNoSeventhField, String expectedConsumption, 
			String capacity) throws Throwable
	{
		SoftAssert softAssertion = new SoftAssert();
		click(addMeter);
		click(addHHMeter);
		Thread.sleep(2000);
		setValue(meterNumSecondField, meterNoSecondField);
		setValue(meterNumThirdField, meterNoThirdField);
		setValue(meterNumFourthField, meterNoFourthField);
		setValue(meterNumFifthField, meterNoFifthField);
		setValue(meterNumSixthField, meterNoSixthField);
		setValue(meterNumSeventhField, meterNoSeventhField);
		
		setValue(this.expectedConsumption, expectedConsumption);
		setValue(this.capacity, capacity);
		/*boolean verifiedMPANNumberIconDisplayStatus = isElementPresent(verifiedMPANNumberIcon);
		if(verifiedMPANNumberIconDisplayStatus) {
			softAssertion.assertTrue(verifiedMPANNumberIconDisplayStatus, "Incorrect MPAN number entered");
		}
		else {
			boolean invalidMPANNumberIconDisplayStatus = isElementPresent(invalidMPANNumberIcon);
			softAssertion.assertTrue(invalidMPANNumberIconDisplayStatus, "Icon for invalid MPAN number is not displaying");
		}*/
		WebElement saveMeterBtn = driver.findElement(By.id("save-meter-button"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", saveMetBtn);
		validateMandatoryFieldAddHHandNHHMeterGeneric();
		if(getAttribute(this.capacity, "value").equals("")) {
			String capacityErrorStatus = getAttribute(this.capacity, "aria-invalid");
			if(capacityErrorStatus == null)
				capacityErrorStatus = "true";
			softAssertion.assertTrue(capacityErrorStatus.equals("true"), "Mandatory expression while validating Capacity field is not displaying");		
			softAssertion.assertAll();
		}
				
		/*boolean meterDataSaveStatus = isElementPresent(meterSavedPopup);
		softAssertion.assertTrue(meterDataSaveStatus, "Meter data was not saved");
		Reporter.log("Checked if pop for saving meter data successfully is displayed", true);*/
		
		softAssertion.assertAll();
	}
	
	public void addHHMeterUsingDifferentTestData2(String meterNoSecondField, String meterNoThirdField, String meterNoFourthField, 
			String meterNoFifthField, String meterNoSixthField, String meterNoSeventhField, int date, int month, int year,
			String expectedConsumption, String capacity) throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		click(addMeter);
		click(addHHMeter);
		Thread.sleep(2000);
		setValue(meterNumSecondField, meterNoSecondField);
		setValue(meterNumThirdField, meterNoThirdField);
		setValue(meterNumFourthField, meterNoFourthField);
		setValue(meterNumFifthField, meterNoFifthField);
		setValue(meterNumSixthField, meterNoSixthField);
		setValue(meterNumSeventhField, meterNoSeventhField);
		
		click(contractEndDate);
		Thread.sleep(1000);
		selectFutureDateCalender(date, month, year);
		setValue(this.expectedConsumption, expectedConsumption);
		setValue(this.capacity, capacity);
		
		/*
		 * boolean verifiedMPANNumberIconDisplayStatus =
		 * isElementPresent(verifiedMPANNumberIcon);
		 * if(verifiedMPANNumberIconDisplayStatus) {
		 * softAssertion.assertTrue(verifiedMPANNumberIconDisplayStatus,
		 * "Incorrect MPAN number entered");
		 * 
		 * } else { boolean invalidMPANNumberIconDisplayStatus =
		 * isElementPresent(invalidMPANNumberIcon);
		 * softAssertion.assertTrue(invalidMPANNumberIconDisplayStatus,
		 * "Icon for invalid MPAN number is not displaying");
		 * 
		 * }
		 */

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", saveMetBtn);
		
		validateMandatoryFieldAddHHandNHHMeterGeneric();
		if(getAttribute(this.capacity, "value").equals("")) {
			String capacityErrorStatus = getAttribute(this.capacity, "aria-invalid");
			if(capacityErrorStatus == null)
				capacityErrorStatus = "true";
			softAssertion.assertTrue(capacityErrorStatus.equals("true"), "Mandatory expression while validating Capacity field is not displaying");			
		}
		softAssertion.assertAll();
	}

	public String addValidHHmeterGeneric() throws Throwable {
		
		Random random = new Random();
		//int cellNum = random.nextInt(1568);
		String mpanNumber = readExcelData("Sheet2", random.nextInt(1500), 0);
		Thread.sleep(2000);
		click(addMeter);
		Thread.sleep(1000);
		click(addHHMeter);
		Thread.sleep(2000);
		setValue(meterNumSecondField, readExcelData("Sheet3", 6, 2));
		setValue(meterNumThirdField, readExcelData("Sheet3", 6, 3));
		setValue(meterNumFourthField, mpanNumber.substring(0, 2));
		setValue(meterNumFifthField, mpanNumber.substring(2, 6));
		setValue(meterNumSixthField, mpanNumber.substring(6, 10));
		setValue(meterNumSeventhField, mpanNumber.substring(10, 13));
		setValue(expectedConsumption, readExcelData("Sheet3", 8, 2));
		click(contractEndDate);
		Thread.sleep(1000);
		selectFutureDateCalender(14, random.nextInt(12), 2020);
		setValue(capacity, readExcelData("Sheet3", 8, 3));
		selectByVisibleText(currentSupplier, "British Gas Business");
		setValue(currentAnnualSpend, String.valueOf(random.nextInt(5000)));
		selectByVisibleText(currentMeterOperator, "E.ON UK Energy Services Ltd");
		selectByVisibleText(currentDataCollector, "Morrison Data Services");
		click(meterOperatorEndDate);
		Thread.sleep(1000);
		selectFutureDateCalender(26, 2, 2020);
		click(dataCollectorEndDate);
		Thread.sleep(1000);
		selectFutureDateCalender(21, 7, 2020);
		
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", saveMetBtn);
		//click(saveMeterBtn);
		Thread.sleep(2000);
		click(okBtn);
		Thread.sleep(2000);
		try {
			click(tipCloseBtn);
		}
		catch(Exception e) {
			System.out.println("Couldn't close 'Tip' message");
		}
		return mpanNumber;
	}
	
	public void addingHHMeterCheckMeterCountEditDeleteReviewOptionTest() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		int hhMetersCount = Integer.parseInt(getText(totalHHMetersCountInFilter));
		String mpanNum = addValidHHmeterGeneric();
		Thread.sleep(3000);
		int newHHMetersCount = Integer.parseInt(getText(totalHHMetersCountInFilter));
		softAssertion.assertEquals(newHHMetersCount, hhMetersCount + 1, "HH meter count in filter is not getting increased");
		boolean editMeterBtnDisplayStatus = isElementPresent(editMeterBtn(mpanNum));
		softAssertion.assertTrue(editMeterBtnDisplayStatus, "Edit button for the meter is not displaying");
		boolean reviewHHmeterDataBtnDisplayStatus = isElementPresent(reviewHHmeterDataBtn(mpanNum));
		softAssertion.assertTrue(reviewHHmeterDataBtnDisplayStatus, "Review Meter Data button for the meter is not displaying");
		boolean deleteMeterBtnDisplayStatus = isElementPresent(deleteHHmeterBtn(mpanNum));
		softAssertion.assertTrue(deleteMeterBtnDisplayStatus, "Delete button is not displaying for the meter");
		softAssertion.assertAll();
	}
	
	public void addExpiredHHmeter() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		Random random = new Random();
		String mpanNumber = readExcelData("Sheet2", random.nextInt(1500), 0);
		Thread.sleep(2000);
		click(addMeter);
		click(addHHMeter);
		setValue(meterNumSecondField, readExcelData("Sheet3", 6, 2));
		setValue(meterNumThirdField, readExcelData("Sheet3", 6, 3));
		setValue(meterNumFourthField, mpanNumber.substring(0, 2));
		setValue(meterNumFifthField, mpanNumber.substring(2, 6));
		setValue(meterNumSixthField, mpanNumber.substring(6, 10));
		setValue(meterNumSeventhField, mpanNumber.substring(10, 13));
		setValue(expectedConsumption, String.valueOf(random.nextInt(5000)));
		click(contractEndDate);
		Thread.sleep(1000);
		selectPrevDateCalender(26, random.nextInt(12), 2018);
		setValue(capacity, String.valueOf(random.nextInt(5000)));
		click(saveMeterBtn);
		Thread.sleep(2000);
		click(okBtn);
		try {
			click(tipCloseBtn);
		}
		catch(Exception e) {
			System.out.println("Couldn't close 'Tip' message");
		}
		boolean contractRenewalDateDisplayStatus = contractRenewalDate(mpanNumber).contains("OUT OF CONTRACT");
		Assert.assertTrue(contractRenewalDateDisplayStatus, "Contract Renewal Date is not displaying as 'Out of Contract'");
		softAssertion.assertAll();
	}
	
	public String checkSavedDetailsAfterAddingHHMeter() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		String mpanNumber = addValidHHmeterGeneric();
		Thread.sleep(3000);
		click(totalHHMetersCountInFilter);
		Thread.sleep(1000);
		try {
			click(tipCloseBtn);
		}
		catch(Exception e) {
			System.out.println("'Tip' message didn't appear.");
		}
		scrollToElement(editMeterBtn(mpanNumber));
		boolean expectedConsumptionDataStatus = expectedConsumptionData(mpanNumber).contains(readExcelData("Sheet3", 8, 2));
		softAssertion.assertTrue(expectedConsumptionDataStatus, "Expected consumption data is not displaying correctly");
		boolean meterStatusData = meterStatus(mpanNumber).contains("ACTIVE");
		softAssertion.assertTrue(meterStatusData, "Meter status is not displaying as Active");
		
		viewMeterDetails(mpanNumber);
		boolean hhDataUploaderDisplayStatus = isElementPresent(hhDataUploaderBtn(mpanNumber));
		softAssertion.assertTrue(hhDataUploaderDisplayStatus, "HH Data Uploader button is not displaying");
		boolean addContractHistoryBtnDisplayStatus = isElementPresent(addHHcontractHistoryBtn(mpanNumber));
		softAssertion.assertTrue(addContractHistoryBtnDisplayStatus, "'Add Contract History' button is not displaying");
		/*boolean meterNumberSecondFieldDisplayStatus = meterNumberSecondFieldInMeterDetails(mpanNumber).contains(readExcelData("Sheet3", 6, 2));
		softAssertion.assertTrue(meterNumberSecondFieldDisplayStatus, "Meter number second field is displaying incorrect data in meter details section.");
		boolean meterNumberThirdFieldDisplayStatus = meterNumberThirdFieldInMeterDetails(mpanNumber).contains(readExcelData("Sheet3", 6, 3));
		Reporter.log("Checked the data present in meter number third field in meter details section and verified if it is correct", true);
		softAssertion.assertTrue(meterNumberThirdFieldDisplayStatus, "Meter number third field is displaying incorrect data in meter details section.");*/
		boolean meterNumberFourthFieldDisplayStatus = meterNumberFourthFieldInMeterDetails(mpanNumber).contains(mpanNumber.substring(0, 2));
		softAssertion.assertTrue(meterNumberFourthFieldDisplayStatus, "Meter number fourth field is displaying incorrect data in meter details section.");
		boolean meterNumberFifthFieldDisplayStatus = meterNumberFifthFieldInMeterDetails(mpanNumber).contains(mpanNumber.substring(2, 6));
		softAssertion.assertTrue(meterNumberFifthFieldDisplayStatus, "Meter number fifth field is displaying incorrect data in meter details section.");
		boolean meterNumberSixthFieldDisplayStatus = meterNumberSixthFieldInMeterDetails(mpanNumber).contains(mpanNumber.substring(6, 10));
		softAssertion.assertTrue(meterNumberSixthFieldDisplayStatus, "Meter number sixth field is displaying incorrect data in meter details section.");
		boolean meterNumberSeventhFieldDisplayStatus = meterNumberSeventhFieldInMeterDetails(mpanNumber).contains(mpanNumber.substring(10, 13));
		softAssertion.assertTrue(meterNumberSeventhFieldDisplayStatus, "Meter number seventh field is displaying incorrect data in meter details section.");
		boolean capacityDataDisplayStatus = capacityData(mpanNumber).contains(readExcelData("Sheet3", 8, 3));
		softAssertion.assertTrue(capacityDataDisplayStatus, "Data present for capacity in meter details section is not displaying correctly.");
		
		softAssertion.assertAll();
		return mpanNumber;
	}
	
	public void validateEditHHmeterPopup() throws Throwable {
		String mpanNum = addValidHHmeterGeneric();
		Thread.sleep(2000);
		scrollToElement(editMeterBtn(mpanNum));
		click(editMeterBtn(mpanNum));
		Thread.sleep(1000);
		boolean editHHMeterPopupDisplayStatus = isElementPresent(editMeterPopup);
		Assert.assertTrue(editHHMeterPopupDisplayStatus, "Edit popup is not displaying");
	}
	
	public void validateEditHHmeter() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		String mpanNum = addValidHHmeterGeneric();
		Thread.sleep(3000);
		scrollToElement(editMeterBtn(mpanNum));
		click(editMeterBtn(mpanNum));
		Thread.sleep(1000);
		Random random = new Random();
		
		String newMpanNum = readExcelData("Sheet2", random.nextInt(1500), 0);
		setValue(meterNumSecondField, readExcelData("Sheet3", 6, 2));
		setValue(meterNumThirdField, readExcelData("Sheet3", 6, 3));
		setValue(meterNumFourthField, newMpanNum.substring(0, 2));
		setValue(meterNumFifthField, newMpanNum.substring(2, 6));
		setValue(meterNumSixthField, newMpanNum.substring(6, 10));
		setValue(meterNumSeventhField, newMpanNum.substring(10, 13));
		String expectedConsumptionValue = readExcelData("Sheet3", 12, 2);
		setValue(expectedConsumption, expectedConsumptionValue);
		click(contractEndDate);
		Thread.sleep(1000);
		selectFutureDateCalender(07, random.nextInt(12), 2020);
		setValue(capacity, readExcelData("Sheet3", 12, 3));
		selectByVisibleText(currentSupplier, "British Gas Business");
		setValue(currentAnnualSpend, String.valueOf(random.nextInt(5000)));
		selectByVisibleText(currentMeterOperator, "British Gas Metering");
		selectByVisibleText(currentDataCollector, "EDF Energy");
		click(meterOperatorEndDate);
		Thread.sleep(1000);
		selectFutureDateCalender(25, 2, 2020);
		click(dataCollectorEndDate);
		Thread.sleep(1000);
		selectFutureDateCalender(20, 7, 2020);
	WebElement saveMetBtn = driver.findElement(By.id("save-meter-button"));	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", saveMetBtn);
		
		Thread.sleep(2000);
		click(okBtn);
		Thread.sleep(2000);
		try {
			click(tipCloseBtn);
		}
		catch(Exception e) {
			System.out.println("'Tip' message didn't appear.");
		}
		
		boolean expectedConsumptionDisplayStatus = expectedConsumptionData(newMpanNum).contains(expectedConsumptionValue) && expectedConsumptionData(newMpanNum).contains("kWh");
		softAssertion.assertTrue(expectedConsumptionDisplayStatus, "Expected consumption is not displaying correct value");
		viewMeterDetails(newMpanNum);
		boolean meterNumberFourthFieldDisplayStatus = meterNumberFourthFieldInMeterDetails(newMpanNum).contains(newMpanNum.substring(0, 2));
		softAssertion.assertTrue(meterNumberFourthFieldDisplayStatus, "Meter number fourth field is displaying incorrect data in meter details section.");
		boolean meterNumberFifthFieldDisplayStatus = meterNumberFifthFieldInMeterDetails(newMpanNum).contains(newMpanNum.substring(2, 6));
		softAssertion.assertTrue(meterNumberFifthFieldDisplayStatus, "Meter number fifth field is displaying incorrect data in meter details section.");
		boolean meterNumberSixthFieldDisplayStatus = meterNumberSixthFieldInMeterDetails(newMpanNum).contains(newMpanNum.substring(6, 10));
		softAssertion.assertTrue(meterNumberSixthFieldDisplayStatus, "Meter number sixth field is displaying incorrect data in meter details section.");
		boolean meterNumberSeventhFieldDisplayStatus = meterNumberSeventhFieldInMeterDetails(newMpanNum).contains(newMpanNum.substring(10, 13));
		softAssertion.assertTrue(meterNumberSeventhFieldDisplayStatus, "Meter number seventh field is displaying incorrect data in meter details section.");
		boolean capacityDataDisplayStatus = capacityData(newMpanNum).contains(readExcelData("Sheet3", 12, 3));
		softAssertion.assertTrue(capacityDataDisplayStatus, "Data present for capacity in meter details section is not displaying correctly.");
		softAssertion.assertAll();
	}
	
	public void validateHHdeleteMeterPopup() throws Throwable {

		String mpanNumber = addValidHHmeterGeneric();
		Thread.sleep(3000);
		scrollToElement(deleteHHmeterBtn(mpanNumber));
		click(deleteHHmeterBtn(mpanNumber));
		Thread.sleep(1000);
		boolean deletePopupDisplayStatus = isElementPresent(deleteMeterPopup);
		Assert.assertTrue(deletePopupDisplayStatus, "Delete meter popup is not displaying");
	}
	public void validateDeleteHHmeter() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		String mpanNum = addValidHHmeterGeneric();
		Thread.sleep(3000);
		int totalHHmeters = Integer.parseInt(getText(totalHHMetersCountInFilter));
		scrollToElement(deleteHHmeterBtn(mpanNum));
		click(deleteHHmeterBtn(mpanNum));
		Thread.sleep(1000);
		selectByVisibleText(meterDeleteReasonDropdown, "Closing down site");
		setValue(meterDeleteNotes, "Shutting down site");
		click(deleteMeterBtnInDeletePopup);
		Thread.sleep(1000);
		click(okBtn);
		Thread.sleep(1000);
		click(totalHHMetersCountInFilter);
		scrollToElement(deleteHHmeterBtn(mpanNum));
		boolean meterStatusAfterDeletionStatus = meterStatus(mpanNum).contains("DELETED");
		softAssertion.assertTrue(meterStatusAfterDeletionStatus, "Meter status 'Deleted' is not displaying");
		boolean revertDeletionBtnDisplayStatus = isElementPresent(revertMeterDeletionBtn(mpanNum));
		softAssertion.assertTrue(revertDeletionBtnDisplayStatus, "Revert Deletion button is not displaying for the deleted meter.");
		int totalhhMetersNew = Integer.parseInt(getText(totalHHMetersCountInFilter));
		softAssertion.assertEquals(totalhhMetersNew, totalHHmeters - 1, "Total HH meters is not getting decremented.");
		softAssertion.assertAll();
	}
	
	
	
	/**
	 * Add contract history popup.
	 */
	public void validateAddContractHistoryPopup() throws Throwable {
		/*String mpanNumber = addValidHHmeterGeneric();
		scrollToElement(editMeterBtn(mpanNumber));
		viewMeterDetails(mpanNumber);
		click(addHHcontractHistoryBtn(mpanNumber));
		Reporter.log("Clicked on the 'Add Contract History' button.", true);*/
		String mpanNumber = getText(hhMeterNumberFirstRecord).trim();
		viewMeterDetails(mpanNumber);
		click(addHHcontractHistoryBtn(mpanNumber));
		boolean popupDisplayStatus = isElementPresent(addContractHistoryPopup);
		Assert.assertTrue(popupDisplayStatus, "Add Contract History popup is not displaying.");
	}
	public void addValidGascontractHistory() throws Throwable {
		String mpanNumber = getText(hhMeterNumberFirstRecord).trim();		
		click(addHHcontractHistoryBtn(mpanNumber));
		Thread.sleep(2000);
		selectByVisibleText(supplierContHistDDwn_Gas, readExcelData("Sheet3", 24, 5));
		Thread.sleep(1000);
		selectByIndex(supplierProductDDwn, 1);
		setValue(dateTraded, readExcelData("Sheet3", 24, 2));
		setValue(contractStartDate, readExcelData("Sheet3", 24, 3));
		setValue(contractEndDate_ContractHist, readExcelData("Sheet3", 24, 4));
		setValue(standingCharge, readExcelData("Sheet3", 24, 9));
		setValue(unitCharge, readExcelData("Sheet3", 24, 13));
		setValue(this.contractedAnnualSpend, readExcelData("Sheet3", 24, 11));
		click(saveContractHistoryBtn);
		Thread.sleep(3000);
		if(isElementPresent(contractHistSaveSuccessPopup)) {
			click(okBtn);
		}
	}
	public void addValidHHcontractHistory() throws Throwable {
		String mpanNumber = getText(hhMeterNumberFirstRecord).trim();		
		click(addHHcontractHistoryBtn(mpanNumber));
		Thread.sleep(2000);
		selectByVisibleText(supplierForContractHistoryDDwn, readExcelData("Sheet3", 20, 5));
		Thread.sleep(1000);
		selectByVisibleText(supplierProductDDwn, readExcelData("Sheet3", 20, 6));
		setValue(dateTraded, readExcelData("Sheet3", 20, 2));
		setValue(contractStartDate, readExcelData("Sheet3", 20, 3));
		setValue(contractEndDate_ContractHist, readExcelData("Sheet3", 20, 4));
		setValue(this.dayRate, readExcelData("Sheet3", 20, 7));
		setValue(this.nightRate, readExcelData("Sheet3", 20, 8));
		setValue(this.standingCharge, readExcelData("Sheet3", 20, 9));
		setValue(this.capacityCharge, readExcelData("Sheet3", 20, 10));
		setValue(this.contractedAnnualSpend, readExcelData("Sheet3", 20, 11));
		
		click(saveContractHistoryBtn);
		Thread.sleep(3000);
		//boolean contractHistSaveStatus = isElementPresent(contractHistSaveSuccessPopup);
		click(okBtn);
	//	Assert.assertTrue(contractHistSaveStatus, "Contract History was not saved successfully.");
	}
	public void addValidNHHcontractHistory() throws Throwable {
		String mpanNumber = getText(nhhMeterNumberFirstRecord).trim();		
		click(addHHcontractHistoryBtn(mpanNumber));
		Thread.sleep(2000);
		selectByVisibleText(supplierForContractHistoryDDwn, readExcelData("Sheet3", 22, 5));
		Thread.sleep(1000);
		selectByIndex(supplierProductDDwn, 2);
		setValue(dateTraded, readExcelData("Sheet3", 22, 2));
		setValue(contractStartDate, readExcelData("Sheet3", 22, 3));
		setValue(contractEndDate_ContractHist, readExcelData("Sheet3", 22, 4));
		setValue(this.dayRate, readExcelData("Sheet3", 22, 7));
		setValue(this.nightRate, readExcelData("Sheet3", 22, 8));
		setValue(this.standingCharge, readExcelData("Sheet3", 22, 9));
		setValue(this.capacityCharge, readExcelData("Sheet3", 22, 10));
		setValue(this.contractedAnnualSpend, readExcelData("Sheet3", 22, 11));
		
		click(saveContractHistoryBtn);
		//Thread.sleep(3000);
		boolean contractHistSaveStatus = isElementPresent(contractHistSaveSuccessPopup,3);
		click(okBtn);
		Assert.assertTrue(contractHistSaveStatus, "Contract History was not saved successfully.");
	}
	public void displayAddContractHistoryHHutilityPopup() throws Throwable {
		String mpanNumber = getText(hhMeterNumberFirstRecord).trim();
		viewMeterDetails(mpanNumber);
		Thread.sleep(1000);
		click(addHHcontractHistoryBtn(mpanNumber));
		
	}
	
	public void validateMandatoryFieldsContractHistoryPopupDataProvider(String dayRate, String nightRate, String standingCharge, 
			String capacityCharge, String contractedAnnualSpend) throws Throwable {
	
		displayAddContractHistoryHHutilityPopup();
		
		Thread.sleep(2000);
		clearValue(contractEndDate_ContractHist);
		clearValue(this.contractedAnnualSpend);
		
		setValue(this.dayRate, dayRate);
		setValue(this.nightRate, nightRate);
		setValue(this.standingCharge, standingCharge);
		setValue(this.capacityCharge, capacityCharge);
		setValue(this.contractedAnnualSpend, contractedAnnualSpend);
		
		click(saveContractHistoryBtn);
		validateMandatoryFieldsErrorMessagesContractHistoryPopup();
	}
	public void validateMandatoryFieldsContractHistoryPopupByEnteringDataInDateTraded() throws Throwable {
		displayAddContractHistoryHHutilityPopup();
		Thread.sleep(2000);
		clearValue(contractEndDate_ContractHist);
		clearValue(this.contractedAnnualSpend);
		click(dateTraded);
		Thread.sleep(1000);
		selectPrevDateCalender(12, 7, 2018);
		click(saveContractHistoryBtn);
		validateMandatoryFieldsErrorMessagesContractHistoryPopup();
	}
	public void validateMandatoryFieldsContractHistoryPopupByEnteringDataInContractStartDate() throws Throwable {
		displayAddContractHistoryHHutilityPopup();
		Thread.sleep(2000);
		clearValue(contractEndDate_ContractHist);
		clearValue(this.contractedAnnualSpend);
		click(contractStartDate);
		Thread.sleep(1000);
		selectPrevDateCalender(22, 9, 2018);
		click(saveContractHistoryBtn);
		validateMandatoryFieldsErrorMessagesContractHistoryPopup();
	}
	public void validateMandatoryFieldsContractHistoryPopupByEnteringDataInDateTradedAndContractStartDate() throws Throwable {
		displayAddContractHistoryHHutilityPopup();
		Thread.sleep(2000);
		clearValue(contractEndDate_ContractHist);
		clearValue(this.contractedAnnualSpend);
		click(dateTraded);
		Thread.sleep(1000);
		selectPrevDateCalender(16, 2, 2018);		
		click(contractStartDate);
		Thread.sleep(1000);
		selectPrevDateCalender(22, 9, 2018);
		click(saveContractHistoryBtn);
		validateMandatoryFieldsErrorMessagesContractHistoryPopup();
	}
	public void validateMandatoryFieldsContractHistoryPopupDataProvider2(int day, int month, int year, String dayRate, String nightRate, String standingCharge, 
			String capacityCharge, String contractedAnnualSpend) throws Throwable {
		
		displayAddContractHistoryHHutilityPopup();
		
		Thread.sleep(2000);
		clearValue(contractEndDate_ContractHist);
		clearValue(this.contractedAnnualSpend);
		
		click(dateTraded);
		Thread.sleep(1000);
		selectPrevDateCalender(day, month, year);
		
		setValue(this.dayRate, dayRate);
		setValue(this.nightRate, nightRate);
		setValue(this.standingCharge, standingCharge);
		setValue(this.capacityCharge, capacityCharge);
		setValue(this.contractedAnnualSpend, contractedAnnualSpend);
		
		click(saveContractHistoryBtn);
		validateMandatoryFieldsErrorMessagesContractHistoryPopup();
	}
	public void validateMandatoryFieldsContractHistoryPopupDataProvider3(int day, int month, int year, String dayRate, String nightRate, String standingCharge, 
			String capacityCharge, String contractedAnnualSpend) throws Throwable {
		
		displayAddContractHistoryHHutilityPopup();
		
		Thread.sleep(2000);
		clearValue(contractEndDate_ContractHist);
		clearValue(this.contractedAnnualSpend);
		
		click(dateTraded);
		Thread.sleep(1000);
		selectPrevDateCalender(day, month, year);
		Thread.sleep(1000);
		click(contractStartDate);
		Thread.sleep(1000);
		selectPrevDateCalender(day, month, year);
		
		setValue(this.dayRate, dayRate);
		setValue(this.nightRate, nightRate);
		setValue(this.standingCharge, standingCharge);
		setValue(this.capacityCharge, capacityCharge);
		setValue(this.contractedAnnualSpend, contractedAnnualSpend);
		
		click(saveContractHistoryBtn);
		validateMandatoryFieldsErrorMessagesContractHistoryPopup();
	}
	
	public void validateMandatoryFieldsErrorMessagesContractHistoryPopup() {
		SoftAssert softAssertion = new SoftAssert();
		if(getAttribute(dateTraded, "value").equals("")) {
			String dateTradedStatus = getAttribute(dateTraded, "aria-invalid");
			if(dateTradedStatus == null)
				dateTradedStatus = "true";
			softAssertion.assertTrue(dateTradedStatus.equals("true"), "Mandatory expression while validating Date Traded field is not displaying");
			
		}
		if(getAttribute(contractStartDate, "value").equals("")) {
			String contractStartDateFieldErrorStatus = getAttribute(contractStartDate, "aria-invalid");
			if(contractStartDateFieldErrorStatus == null)
				contractStartDateFieldErrorStatus = "true";
			softAssertion.assertTrue(contractStartDateFieldErrorStatus.equals("true"), "Mandatory expression while validating Contract Start Date field is not displaying");
			
		}
		if(getAttribute(contractEndDate_ContractHist, "value").equals("")) {
			String contractEndDateFieldErrorStatus = getAttribute(contractEndDate_ContractHist, "aria-invalid");
			if(contractEndDateFieldErrorStatus == null)
				contractEndDateFieldErrorStatus = "true";
			softAssertion.assertTrue(contractEndDateFieldErrorStatus.equals("true"), "Mandatory expression while validating Contract End Date field is not displaying");
			
		}
		if(getAttribute(this.dayRate, "value").equals("")) {
			String dayRateFieldErrorStatus = getAttribute(this.dayRate, "aria-invalid");
			if(dayRateFieldErrorStatus == null)
				dayRateFieldErrorStatus = "true";
			softAssertion.assertTrue(dayRateFieldErrorStatus.equals("true"), "Mandatory expression while validating Day Rate field is not displaying");
			
		}
		if(getAttribute(this.nightRate, "value").equals("")) {
			String nightRateFieldErrorStatus = getAttribute(this.nightRate, "aria-invalid");
			if(nightRateFieldErrorStatus == null)
				nightRateFieldErrorStatus = "true";
			softAssertion.assertTrue(nightRateFieldErrorStatus.equals("true"), "Mandatory expression while validating Night Rate field is not displaying");
		
		}
		if(getAttribute(this.standingCharge, "value").equals("")) {
			String standingChargeFieldErrorStatus = getAttribute(this.standingCharge, "aria-invalid");
			if(standingChargeFieldErrorStatus == null)
				standingChargeFieldErrorStatus = "true";
			softAssertion.assertTrue(standingChargeFieldErrorStatus.equals("true"), "Mandatory expression while validating Standing Charge field is not displaying");
			
		}
		if(getAttribute(this.capacityCharge, "value").equals("")) {
			String capacityChargeFieldErrorStatus = getAttribute(this.capacityCharge, "aria-invalid");
			if(capacityChargeFieldErrorStatus == null)
				capacityChargeFieldErrorStatus = "true";
			softAssertion.assertTrue(capacityChargeFieldErrorStatus.equals("true"), "Mandatory expression while validating Capacity Charge field is not displaying");
			
		}
		if(getAttribute(this.contractedAnnualSpend, "value").equals("")) {
			String contractedAnnualSpendFieldErrorStatus = getAttribute(this.contractedAnnualSpend, "aria-invalid");
			if(contractedAnnualSpendFieldErrorStatus == null)
				contractedAnnualSpendFieldErrorStatus = "true";
			softAssertion.assertTrue(contractedAnnualSpendFieldErrorStatus.equals("true"), "Mandatory expression while validating Contracted Annual Spend field is not displaying");
			
		}
	}
	
	
	public void validateAddnHHMeterPopupUsingDifferentTestData(String meterNoDropdownFieldValue, String meterNoSecondField, String meterNoThirdField, String meterNoFourthField, 
			String meterNoFifthField, String meterNoSixthField, String meterNoSeventhField, String procurementType, String expectedConsumption, 
			String currentSupplier, String currentAnnualSpend) throws Throwable	{
		
		SoftAssert softAssertion = new SoftAssert();
		click(addMeter);
		click(addnHHMeter);
		Thread.sleep(1000);
		selectByVisibleText(meterNumDropdownField, meterNoDropdownFieldValue);		
		setValue(meterNumSecondField, meterNoSecondField);
		setValue(meterNumThirdField, meterNoThirdField);
		setValue(meterNumFourthField, meterNoFourthField);
		setValue(meterNumFifthField, meterNoFifthField);
		setValue(meterNumSixthField, meterNoSixthField);
		setValue(meterNumSeventhField, meterNoSeventhField);
		selectByVisibleText(this.procurementType, procurementType);
		/*boolean verifiedMPANNumberIconDisplayStatus = isElementPresent(verifiedMPANNumberIcon);
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
		selectByVisibleText(this.currentSupplier, currentSupplier);
		setValue(this.currentAnnualSpend, currentAnnualSpend);
		
		click(saveMeterBtn);
		if(getAttribute(meterNumSecondField, "value").equals("")) {
			String meterNumSecondFieldErrorStatus = getAttribute(meterNumSecondField, "aria-invalid");
			if(meterNumSecondFieldErrorStatus == null)
				meterNumSecondFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumSecondFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumSecondField is not displaying");
			
		}
		if(getAttribute(meterNumThirdField, "value").equals("")) {
			String meterNumThirdFieldErrorStatus = getAttribute(meterNumThirdField, "aria-invalid");
			if(meterNumThirdFieldErrorStatus == null)
				meterNumThirdFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumThirdFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumThirdField is not displaying");
			
		}
		if(getAttribute(meterNumFourthField, "value").equals("")) {
			String meterNumFourthFieldErrorStatus = getAttribute(meterNumFourthField, "aria-invalid");
			if(meterNumFourthFieldErrorStatus == null)
				meterNumFourthFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumFourthFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumFourthField is not displaying");
			
		}
		if(getAttribute(meterNumFifthField, "value").equals("")) {
			String meterNumFifthFieldErrorStatus = getAttribute(meterNumFifthField, "aria-invalid");
			if(meterNumFifthFieldErrorStatus == null)
				meterNumFifthFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumFifthFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumFifthField is not displaying");
			
		}
		if(getAttribute(meterNumSixthField, "value").equals("")) {
			String meterNumSixthFieldErrorStatus = getAttribute(meterNumSixthField, "aria-invalid");
			if(meterNumSixthFieldErrorStatus == null)
				meterNumSixthFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumSixthFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumSixthField is not displaying");
			
		}
		if(getAttribute(meterNumSeventhField, "value").equals("")) {
			String meterNumSeventhFieldErrorStatus = getAttribute(meterNumSeventhField, "aria-invalid");
			if(meterNumSeventhFieldErrorStatus == null)
				meterNumSeventhFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumSeventhFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumSeventhField is not displaying");
			
		}
		if(getAttribute(this.expectedConsumption, "value").equals("")) {
			String expectedConsumptionFieldErrorStatus = getAttribute(this.expectedConsumption, "aria-invalid");
			if(expectedConsumptionFieldErrorStatus == null)
				expectedConsumptionFieldErrorStatus = "true";
			softAssertion.assertTrue(expectedConsumptionFieldErrorStatus.equals("true"), "Mandatory expression while validating Expected Consumption is not displaying");
			
		}
		if(getAttribute(this.contractEndDate, "value").equals("")) {
			String contractEndDateFieldErrorStatus = getAttribute(this.contractEndDate, "aria-invalid");
			if(contractEndDateFieldErrorStatus == null)
				contractEndDateFieldErrorStatus = "true";
			softAssertion.assertTrue(contractEndDateFieldErrorStatus.equals("true"), "Mandatory expression while validating Contract End Date is not displaying");
			
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
		Random random = new Random();
		String mpanNumber = readExcelData("Sheet2", random.nextInt(1500), 0);
		click(addMeter);
		click(addnHHMeter);
		Thread.sleep(2000);
		setValue(meterNumSecondField, readExcelData("Sheet3", 6, 2));
		setValue(meterNumThirdField, readExcelData("Sheet3", 6, 3));
		setValue(meterNumFourthField, mpanNumber.substring(0, 2));
		setValue(meterNumFifthField, mpanNumber.substring(2, 6));
		setValue(meterNumSixthField, mpanNumber.substring(6, 10));
		setValue(meterNumSeventhField, mpanNumber.substring(10, 13));
		click(contractEndDate);
		Thread.sleep(1000);
		selectFutureDateCalender(16, 5, 2020);
		click(saveMeterBtn);
		validateMandatoryFieldAddHHandNHHMeterGeneric();
		
	}
	
	public void validateMandatoryFieldAddHHandNHHMeterGeneric() {
		SoftAssert softAssertion = new SoftAssert();
		if(getAttribute(meterNumSecondField, "value").equals("")) {
			String meterNumSecondFieldErrorStatus = getAttribute(meterNumSecondField, "aria-invalid");
			if(meterNumSecondFieldErrorStatus == null)
				meterNumSecondFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumSecondFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumSecondField is not displaying");
			
		}
		if(getAttribute(meterNumThirdField, "value").equals("")) {
			String meterNumThirdFieldErrorStatus = getAttribute(meterNumThirdField, "aria-invalid");
			if(meterNumThirdFieldErrorStatus == null)
				meterNumThirdFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumThirdFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumThirdField is not displaying");
			
		}
		if(getAttribute(meterNumFourthField, "value").equals("")) {
			String meterNumFourthFieldErrorStatus = getAttribute(meterNumFourthField, "aria-invalid");
			if(meterNumFourthFieldErrorStatus == null)
				meterNumFourthFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumFourthFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumFourthField is not displaying");
			
		}
		if(getAttribute(meterNumFifthField, "value").equals("")) {
			String meterNumFifthFieldErrorStatus = getAttribute(meterNumFifthField, "aria-invalid");
			if(meterNumFifthFieldErrorStatus == null)
				meterNumFifthFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumFifthFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumFifthField is not displaying");
			
		}
		if(getAttribute(meterNumSixthField, "value").equals("")) {
			String meterNumSixthFieldErrorStatus = getAttribute(meterNumSixthField, "aria-invalid");
			if(meterNumSixthFieldErrorStatus == null)
				meterNumSixthFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumSixthFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumSixthField is not displaying");
			
		}
		if(getAttribute(meterNumSeventhField, "value").equals("")) {
			String meterNumSeventhFieldErrorStatus = getAttribute(meterNumSeventhField, "aria-invalid");
			if(meterNumSeventhFieldErrorStatus == null)
				meterNumSeventhFieldErrorStatus = "true";
			softAssertion.assertTrue(meterNumSeventhFieldErrorStatus.equals("true"), "Mandatory expression while validating meterNumSeventhField is not displaying");
			
		}
		if(getAttribute(this.expectedConsumption, "value").equals("")) {
			String expectedConsumptionFieldErrorStatus = getAttribute(this.expectedConsumption, "aria-invalid");
			if(expectedConsumptionFieldErrorStatus == null)
				expectedConsumptionFieldErrorStatus = "true";
			softAssertion.assertTrue(expectedConsumptionFieldErrorStatus.equals("true"), "Mandatory expression while validating Expected Consumption is not displaying");
			
		}
		if(getAttribute(this.contractEndDate, "value").equals("")) {
			String contractEndDateFieldErrorStatus = getAttribute(this.contractEndDate, "aria-invalid");
			if(contractEndDateFieldErrorStatus == null)
				contractEndDateFieldErrorStatus = "true";
			softAssertion.assertTrue(contractEndDateFieldErrorStatus.equals("true"), "Mandatory expression while validating Contract End Date is not displaying");
			
		}
		softAssertion.assertAll();
	}
	
	public String checkSavedDetailsAfterAddingNHHMeter() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		String mpanNumber = addValidNHHMeterGeneric();
		click(totalnHHMetersCountInFilter);
		Thread.sleep(2000);
		try {
			click(tipCloseBtn);
		}
		catch(Exception e) {
			System.out.println("Couldn't close 'Tip' message");
		}
		scrollToElement(editMeterBtn(mpanNumber));
		viewMeterDetails(mpanNumber);
		boolean AMRDataUploaderDisplayStatus = isElementPresent(AMRdataUploaderBtn(mpanNumber));
		softAssertion.assertTrue(AMRDataUploaderDisplayStatus, "AMR Data Uploader button is not displaying");
		boolean addContractHistoryBtnDisplayStatus = isElementPresent(addContractHistoryBtn(mpanNumber));
		softAssertion.assertTrue(addContractHistoryBtnDisplayStatus, "'Add Contract History' button is not displaying");
		/*boolean meterNumberSecondFieldDisplayStatus = meterNumberSecondFieldInMeterDetails(mpanNumber).contains(readExcelData("Sheet3", 6, 2));
		Reporter.log("Checked the data present in meter number second field in meter details section and verified if it is correct", true);
		softAssertion.assertTrue(meterNumberSecondFieldDisplayStatus, "Meter number second field is displaying incorrect data in meter details section.");
		boolean meterNumberThirdFieldDisplayStatus = meterNumberThirdFieldInMeterDetails(mpanNumber).contains(readExcelData("Sheet3", 6, 3));
		Reporter.log("Checked the data present in meter number third field in meter details section and verified if it is correct", true);
		softAssertion.assertTrue(meterNumberThirdFieldDisplayStatus, "Meter number third field is displaying incorrect data in meter details section.");*/
		boolean meterNumberFourthFieldDisplayStatus = meterNumberFourthFieldInMeterDetails(mpanNumber).contains(mpanNumber.substring(0, 2));
		softAssertion.assertTrue(meterNumberFourthFieldDisplayStatus, "Meter number fourth field is displaying incorrect data in meter details section.");
		boolean meterNumberFifthFieldDisplayStatus = meterNumberFifthFieldInMeterDetails(mpanNumber).contains(mpanNumber.substring(2, 6));
		softAssertion.assertTrue(meterNumberFifthFieldDisplayStatus, "Meter number fifth field is displaying incorrect data in meter details section.");
		boolean meterNumberSixthFieldDisplayStatus = meterNumberSixthFieldInMeterDetails(mpanNumber).contains(mpanNumber.substring(6, 10));
		softAssertion.assertTrue(meterNumberSixthFieldDisplayStatus, "Meter number sixth field is displaying incorrect data in meter details section.");
		boolean meterNumberSeventhFieldDisplayStatus = meterNumberSeventhFieldInMeterDetails(mpanNumber).contains(mpanNumber.substring(10, 13));
		softAssertion.assertTrue(meterNumberSeventhFieldDisplayStatus, "Meter number seventh field is displaying incorrect data in meter details section.");
		softAssertion.assertAll();
		return mpanNumber;
	}
	public void addExpiredNHHmeter() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		Random random = new Random();
		String mpanNumber = readExcelData("Sheet2", random.nextInt(1500), 0);
		Thread.sleep(2000);
		click(addMeter);
		Thread.sleep(1000);
		click(addnHHMeter);
		Thread.sleep(2000);
		setValue(meterNumSecondField, readExcelData("Sheet3", 6, 2));
		setValue(meterNumThirdField, readExcelData("Sheet3", 6, 3));
		setValue(meterNumFourthField, mpanNumber.substring(0, 2));
		setValue(meterNumFifthField, mpanNumber.substring(2, 6));
		setValue(meterNumSixthField, mpanNumber.substring(6, 10));
		setValue(meterNumSeventhField, mpanNumber.substring(10, 13));
		setValue(expectedConsumption, String.valueOf(random.nextInt(5000)));
		click(contractEndDate);
		Thread.sleep(1000);
		selectPrevDateCalender(26, random.nextInt(12), 2018);
		click(saveMeterBtn);
		Thread.sleep(2000);
		click(okBtn);
		try {
			click(tipCloseBtn);
		}
		catch(Exception e) {
			System.out.println("Couldn't close 'Tip' message");
		}
		
		scrollToElement(editMeterBtn(mpanNumber));
		boolean contractRenewalDateDisplayStatus = contractRenewalDate(mpanNumber).contains("OUT OF CONTRACT");
		Assert.assertTrue(contractRenewalDateDisplayStatus, "Contract Renewal Date is not displaying as 'Out of Contract'");
		softAssertion.assertAll();
	}
	
	public void validateNHHdeleteMeterPopup() throws Throwable {

		String mpanNumber = addValidNHHMeterGeneric();
		Thread.sleep(2000);
		scrollToElement(deleteMeterBtn(mpanNumber));
		click(deleteMeterBtn(mpanNumber));
		Thread.sleep(1000);
		boolean deletePopupDisplayStatus = isElementPresent(deleteMeterPopup);
		Assert.assertTrue(deletePopupDisplayStatus, "Delete meter popup is not displaying");
	}
	public void validateDeleteNHHmeter() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		String mpanNum = addValidNHHMeterGeneric();
		Thread.sleep(2000);
		int totalNHHmeters = Integer.parseInt(getText(totalnHHMetersCountInFilter));
		scrollToElement(deleteMeterBtn(mpanNum));
		click(deleteMeterBtn(mpanNum));
		Thread.sleep(1000);
		selectByVisibleText(meterDeleteReasonDropdown, "Closing down site");
		setValue(meterDeleteNotes, "Shutting down site");
		click(deleteMeterBtnInDeletePopup);
		Thread.sleep(1000);
		click(okBtn);
		Thread.sleep(1000);
		click(totalnHHMetersCountInFilter);
		scrollToElement(deleteMeterBtn(mpanNum));
		boolean meterStatusAfterDeletionStatus = meterStatus(mpanNum).contains("DELETED");
		softAssertion.assertTrue(meterStatusAfterDeletionStatus, "Meter status 'Deleted' is not displaying");
		boolean revertDeletionBtnDisplayStatus = isElementPresent(revertMeterDeletionBtn(mpanNum));
		softAssertion.assertTrue(revertDeletionBtnDisplayStatus, "Revert Deletion button is not displaying for the deleted meter.");
		int totalNhhMetersNew = Integer.parseInt(getText(totalnHHMetersCountInFilter));
		softAssertion.assertEquals(totalNhhMetersNew, totalNHHmeters - 1, "Total NHH meters is not getting decremented.");
		softAssertion.assertAll();
	}
	
	public void addNHHMeterUsingValidTestData() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		int nhhMetersCount = Integer.parseInt(getText(totalnHHMetersCountInFilter));
		String mpanNumber = addValidNHHMeterGeneric();
		Thread.sleep(2000);
		int newNHHMetersCount = Integer.parseInt(getText(totalnHHMetersCountInFilter));
		softAssertion.assertEquals(newNHHMetersCount, nhhMetersCount + 1, "NHH meter count in filter is not getting increased");
		boolean editMeterBtnDisplayStatus = isElementPresent(editMeterBtn(mpanNumber));
		softAssertion.assertTrue(editMeterBtnDisplayStatus, "Edit button for the meter is not displaying");
		boolean deleteMeterBtnDisplayStatus = isElementPresent(deleteMeterBtn(mpanNumber));
		softAssertion.assertTrue(deleteMeterBtnDisplayStatus, "Delete button is not displaying for the meter");
		softAssertion.assertAll();
	}
	
	public String addValidNHHMeterGeneric() throws Throwable {
		
		Random random = new Random();
		//int cellNum = random.nextInt(1568);
		String mpanNumber = readExcelData("Sheet2", random.nextInt(1500), 0);
		Thread.sleep(2000);
		click(addMeter);
		click(addnHHMeter);
		selectByVisibleText(meterNumDropdownField, "05");		
		setValue(meterNumSecondField, readExcelData("Sheet3", 6, 2));
		setValue(meterNumThirdField, readExcelData("Sheet3", 6, 3));
		setValue(meterNumFourthField, mpanNumber.substring(0, 2));
		setValue(meterNumFifthField, mpanNumber.substring(2, 6));
		setValue(meterNumSixthField, mpanNumber.substring(6, 10));
		setValue(meterNumSeventhField, mpanNumber.substring(10, 13));
		selectByVisibleText(procurementType, "Fixed");
		setValue(expectedConsumption, String.valueOf(random.nextInt(5000)));
		click(contractEndDate);
		Thread.sleep(1000);
		selectFutureDateCalender(14, random.nextInt(12), 2020);
		selectByVisibleText(currentSupplier, "Gazprom");
		setValue(currentAnnualSpend, String.valueOf(random.nextInt(5000)));
		//Thread.sleep(4000);
		click(saveMeterBtn);
		Thread.sleep(2000);
		click(okBtn);
		Thread.sleep(2000);
		try {
			click(tipCloseBtn);
		}
		catch(Exception e) {
			System.out.println("Couldn't close 'Tip' message");
		}
		click(totalnHHMetersCountInFilter);
		return mpanNumber;
	}
	
	
	public void validateAddMeterDropdown() throws Throwable
	{
		SoftAssert softAssertion = new SoftAssert();
		click(addMeter);
		boolean hhElectricPresenceStatus = isElementExistInDropDown(meterUtilitiesInAddMeterDropdown, "HH Electric");
		softAssertion.assertTrue(hhElectricPresenceStatus, "HH Electric is not displaying in 'Add Meter' dropdown");
		boolean nHHElectricPresenceStatus = isElementExistInDropDown(meterUtilitiesInAddMeterDropdown, "nHH Electric");
		softAssertion.assertTrue(nHHElectricPresenceStatus, "nHH Electric is not displaying in 'Add Meter' dropdown");
		boolean gasPresenceStatus = isElementExistInDropDown(meterUtilitiesInAddMeterDropdown, "Gas");
		softAssertion.assertTrue(gasPresenceStatus, "Gas utility is not displaying in 'Add Meter' dropdown");
		boolean waterPresenceStatus = isElementExistInDropDown(meterUtilitiesInAddMeterDropdown, "Water");
		softAssertion.assertTrue(waterPresenceStatus, "Water utility is not displaying in 'Add Meter' dropdown");
		softAssertion.assertAll();
	}
	public void validateAddHHMeterPopup() throws Throwable
	{
		click(addMeter);
		Thread.sleep(1000);
		click(addHHMeter);
		Assert.assertTrue(isElementPresent(currentMeterOperator), "Popup for adding new HH Electric meter didn't appear");
	}
	public void validateAddnHHMeterPopup() throws Throwable
	{
		click(addMeter);
		//Thread.sleep(1000);
		click(addnHHMeter);
		Assert.assertTrue(isElementPresent(procurementType), "Popup for adding new nHH Electric meter didn't appear");
	}
	public void validateAddGasMeterPopup()
	{
		click(addMeter);
		click(addGasMeter);
		Assert.assertTrue(isElementPresent(gasMeterNumber), "Popup for adding new nHH Electric meter didn't appear");
	}
public String addValidWaterMeterGeneric() throws Throwable {
		
		Random random = new Random();
		//int cellNum = random.nextInt(1568);
		String mpanNumber = readExcelData("Sheet2", random.nextInt(1500), 0);
		Thread.sleep(2000);
		click(addMeter);
		Thread.sleep(1000);
		click(addWaterMeter);
		Thread.sleep(2000);
		setValue(spidWater, String.valueOf(random.nextInt(1000000)));
		setValue(spidSWHD, String.valueOf(random.nextInt(1000000)));
		setValue(spidWaste, String.valueOf(random.nextInt(1000000)));
		setValue(meterNumber_Water, String.valueOf(random.nextInt(1000000)));
		setValue(unitRate_water, String.valueOf(random.nextInt(300)));
		setValue(annualm3, String.valueOf(random.nextInt(1000)));
		setValue(annualStandingCharge, String.valueOf(random.nextInt(2000)));
		setValue(rtsUnitRate, String.valueOf(random.nextInt(200)));
		setValue(billedWasteM3, String.valueOf(random.nextInt(1000)));
		
		
		click(contractEndDate);
		Thread.sleep(1000);
		selectFutureDateCalender(14, random.nextInt(12), 2020);
		setValue(capacity, readExcelData("Sheet3", 8, 3));
		selectByVisibleText(currentSupplier, "British Gas Business");
		setValue(currentAnnualSpend, String.valueOf(random.nextInt(5000)));
		selectByVisibleText(currentMeterOperator, "E.ON UK Energy Services Ltd");
		selectByVisibleText(currentDataCollector, "Morrison Data Services");
		click(meterOperatorEndDate);
		Thread.sleep(1000);
		selectFutureDateCalender(26, 2, 2020);
		click(dataCollectorEndDate);
		Thread.sleep(1000);
		selectFutureDateCalender(21, 7, 2020);
		
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", saveMetBtn);
		//click(saveMeterBtn);
		Thread.sleep(2000);
		click(okBtn);
		Thread.sleep(2000);
		try {
			click(tipCloseBtn);
		}
		catch(Exception e) {
			System.out.println("Couldn't close 'Tip' message");
		}
		return mpanNumber;
	}
}
