package com.oem.framework.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class PropertyPortfolioPage extends CustomerDashboardPage {
	
	By addSite = By.xpath("//button[@id = 'add-site-btn'][1]");
	By addNewSitePopup = By.xpath("//h3[text() = 'Add New Site']");
	By saveSiteDataBtn = By.id("save-btn"); 
	By siteName = By.id("NewSite_Name");
	By siteName_Error = By.id("NewSite_Name-error");
	By address1 = By.id("NewSite_Address1");
	By address1Error = By.id("NewSite_Address1-error");
	By postcode = By.id("NewSite_Postcode");
	By postcodeError = By.id("NewSite_Postcode-error");
	By siteContactName = By.id("NewSite_ContactName");
	By contactPhoneNo = By.id("NewSite_PhoneNo");
	By contactEmail = By.id("NewSite_Email");
	By siteID = By.id("NewSite_SiteId");
	By address2 = By.id("NewSite_Address2");
	By address3 = By.id("NewSite_Address3");
	By address4 = By.id("NewSite_Address4");
	By siteArea = By.id("NewSite_SiteArea");
	
	By siteNameList = By.xpath("//div[@id = 'divSitesOverview']/hgroup[*]/table/tbody/tr/td[2]/div[1]");
	
	By siteFirstRecord = By.xpath("//div[@id = 'divSitesOverview']/hgroup[1]/table/tbody/tr/td[1]");
	By addMeter = By.id("add-meter-button");
	By addMeterUtilities = By.xpath("//div[@id = 'add-meter-button']/ul/li[*]");
	By addHHMeter = By.xpath("//div[@id = 'add-meter-button']/ul/li[1]");
	By addnHHMeter = By.xpath("//div[@id = 'add-meter-button']/ul/li[2]");
	By addGasMeter = By.xpath("//div[@id = 'add-meter-button']/ul/li[3]");
	By addWaterMeter = By.xpath("//div[@id = 'add-meter-button']/ul/li[4]");
	By saveMeter = By.id("save-meter-button");
	/*Add HH Meter popup*/
	By meterNumDropdownField = By.id("profileClass");
	By meterNumSecondField = By.id("meterTimeSwitchCode");
	By meterNumThirdField = By.id("lineLossFactor");
	By meterNumFourthField = By.id("distributionId");
	By meterNumFifthField = By.id("meterPointIdNumber1");
	By meterNumSixthField = By.id("meterPointIdNumber2");
	By meterNumSeventhField = By.id("checkDigit");
	By invalidMPANNumberIcon = By.id("checksum-fail");
	By verifiedMPANNumberIcon = By.id("checksum-pass");
	
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
	
	By deleteSites = By.xpath("//hgroup[@class = 'site-overview-item']/table/tbody/tr/td[5]/a[2]");
	By okBtn = By.xpath("//button[text() = 'OK']");

	By currentMeterOperator_HH = By.id("meterOperator");
	By meterSavedPopup = By.xpath("//div[text() = 'The meter data was saved successfully.']");
	By invalidMPANPopup = By.xpath("//div[text() = 'MPAN failed check digit validation, please review the number and try again']");
	By okButtonInPopUp = By.xpath("//button[text() = 'OK']");
	
	By portfolioMeterDataUpload = By.xpath("//button[@id = 'add-site-btn'][2]");
	By forecastingBtn = By.xpath("//div[@class = 'text-right']/a[1]");
	By portfolioBtn = By.xpath("//div[@class = 'text-right']/a[2]");
	By filterByAllUtilities = By.xpath("//td[contains(text(), 'Filter by Utility')]/../td[2]/div[1]");
	By filterBy_HH_Utility = By.xpath("//td[contains(text(), 'Filter by Utility')]/../td[2]/div[2]");
	By filterBy_nHH_Utility = By.xpath("//td[contains(text(), 'Filter by Utility')]/../td[2]/div[3]");
	By filterBy_gas_Utility = By.xpath("//td[contains(text(), 'Filter by Utility')]/../td[2]/div[4]");
	By filterBy_water_Utility = By.xpath("//td[contains(text(), 'Filter by Utility')]/../td[2]/div[5]");
	
	
	
	@Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in CustomerDashboard Page");
        Assert.assertTrue(isElementPresent(addSite),"Property Portfolio Page didnt appear");
        
    }
	public void validatePresenceAddSitePopup() throws Throwable
	{
		
		click(addSite);
		Robot robot = new Robot();
        for(int i = 1; i<=2; i++) {
        	robot.keyPress(KeyEvent.VK_CONTROL);
        	robot.keyPress(KeyEvent.VK_SUBTRACT);
        	robot.keyRelease(KeyEvent.VK_SUBTRACT);
        	robot.keyRelease(KeyEvent.VK_CONTROL);
        }
		Thread.sleep(1000);
		Assert.assertTrue(isElementPresent(addNewSitePopup), "Add site popup is not displaying");
	}
	
	public void validateMandatoryFieldsAddSitePopup() throws Throwable 
	{
		click(addSite);
		Thread.sleep(1000);
		click(saveSiteDataBtn);
		Thread.sleep(1000);
		boolean siteNameErrorStatus = isElementPresent(siteName_Error);
		boolean address1ErrorStatus = isElementPresent(address1Error);
		boolean postcodeErrorStatus = isElementPresent(postcodeError);
		Assert.assertTrue(siteNameErrorStatus && address1ErrorStatus && postcodeErrorStatus, 
				"Validation messages for mandatory fields are not displaying");
	}
	public void validateAddressPostcodeMandatoryFieldsAddSitePopup() throws Throwable 
	{
		click(addSite);
		Thread.sleep(1000);
		setValue(siteName, "Patia");
		click(saveSiteDataBtn);
		Thread.sleep(1000);
		boolean address1ErrorStatus = isElementPresent(address1Error);
		boolean postcodeErrorStatus = isElementPresent(postcodeError);
		Assert.assertTrue(address1ErrorStatus && postcodeErrorStatus, 
				"Validation messages for mandatory fields are not displaying");
	}
	public void validateMandatorySiteNamePostcodeFieldsInAddSitePopup() throws Throwable {
		click(addSite);
		Robot robot = new Robot();
        for(int i = 1; i<=2; i++) {
        	robot.keyPress(KeyEvent.VK_CONTROL);
        	robot.keyPress(KeyEvent.VK_SUBTRACT);
        	robot.keyRelease(KeyEvent.VK_SUBTRACT);
        	robot.keyRelease(KeyEvent.VK_CONTROL);
        }
		Thread.sleep(2000);
		setValue(address1, "Patia");
		click(saveSiteDataBtn);
		boolean siteNameErrorStatus = isElementPresent(siteName_Error);
		boolean postcodeErrorStatus = isElementPresent(postcodeError);
		Assert.assertTrue(siteNameErrorStatus && postcodeErrorStatus, 
				"Validation messages for mandatory fields are not displaying");
	}
	public void validateMandatorySiteNameAddressFieldsInAddSitePopup() throws InterruptedException, Throwable {
		click(addSite);
		Robot robot = new Robot();
        for(int i = 1; i<=2; i++) {
        	robot.keyPress(KeyEvent.VK_CONTROL);
        	robot.keyPress(KeyEvent.VK_SUBTRACT);
        	robot.keyRelease(KeyEvent.VK_SUBTRACT);
        	robot.keyRelease(KeyEvent.VK_CONTROL);
        }
		Thread.sleep(2000);
		setValue(postcode, "8723423");
		Thread.sleep(1000);
		click(saveSiteDataBtn);
		boolean siteNameErrorStatus = isElementPresent(siteName_Error);
		boolean address1ErrorStatus = isElementPresent(address1Error);
		Assert.assertTrue(siteNameErrorStatus && address1ErrorStatus, 
				"Validation messages for mandatory fields are not displaying");
	}
	public void validateAddSitePopupDataProvider(String name, String addr1, String postCode, String siteContactNAME, 
			String contactPHONENo, String contactEMAIL, String site_ID, String addr2, String addr3, String addr4, String siteAREA) throws Throwable
	{
		SoftAssert s = new SoftAssert();
		click(addSite);
		Reporter.log("Clicked Add Site button", true);
		Robot robot = new Robot();
        for(int i = 1; i<=2; i++) {
        	robot.keyPress(KeyEvent.VK_CONTROL);
        	robot.keyPress(KeyEvent.VK_SUBTRACT);
        	robot.keyRelease(KeyEvent.VK_SUBTRACT);
        	robot.keyRelease(KeyEvent.VK_CONTROL);
        }
		Thread.sleep(2000);
		setValue(siteName, name);
		setValue(address1, addr1);
		setValue(postcode, postCode);
		setValue(siteContactName, siteContactNAME);
		setValue(contactPhoneNo, contactPHONENo);
		setValue(contactEmail, contactEMAIL);
		setValue(siteID, site_ID);
		setValue(address2, addr2);
		setValue(address3, addr3);
		setValue(address4, addr4);
		setValue(siteArea, siteAREA);
		Reporter.log("Entered data in various fields in 'Add Site' popup", true);
		click(saveSiteDataBtn);
		Reporter.log("Clicked save button", true);
		if(getAttribute(siteName, "value").equals("")) {
			boolean siteNameErr = isElementPresent(siteName_Error);
			s.assertTrue(siteNameErr, "Error message for 'Site Name' field is not displaying");
			Reporter.log("Checked if validation message for site name field is displaying", true);
		}
		if(getAttribute(address1, "value").equals("")) {
			boolean addressErr = isElementPresent(address1Error);
			s.assertTrue(addressErr, "Error message for 'Address' field is not displaying");
			Reporter.log("Checked if validation message for address1 field is displaying", true);
		}
		if(getAttribute(postcode, "value").equals("")) {
			boolean postcodeErr = isElementPresent(postcodeError);
			s.assertTrue(postcodeErr, "Error message for 'postcode' field is not displaying");
			Reporter.log("Checked if validation message for postcode field is displaying", true);
		}
		waitForElementInvisible(addNewSitePopup);
		boolean popupDisplayStatus = isElementPresent(addNewSitePopup);
		if(popupDisplayStatus) {
			Assert.assertTrue(popupDisplayStatus, "Add site form is not getting saved");
		}
		List<WebElement> siteNames = driver.findElements(siteNameList);
		boolean siteAddstatus = false;
    	for (WebElement siteName: siteNames) {
            if(siteName.getText().contains(name)==true) 
            {
            	siteAddstatus = true;
            }
        }
		s.assertTrue(siteAddstatus, "Site not displaying in site table after creation");
		Reporter.log("Checked if the site is displaying in site table after site creation", true);
		s.assertAll();	
	}
	public void validateAddMeterDropdown() throws Throwable
	{
		SoftAssert softAssertion = new SoftAssert();
		click(siteFirstRecord);
		Reporter.log("Clicked on the first site present in the Property Portfolio page");
		Thread.sleep(2000);
		click(addMeter);
		Reporter.log("Clicked on Add Meter dropdown");
		boolean hhElectricPresenceStatus = isElementExistInDropDown(addMeterUtilities, "HH Electric");
		softAssertion.assertTrue(hhElectricPresenceStatus, "HH Electric is not displaying in 'Add Meter' dropdown");
		Reporter.log("Checked if HH Electric is displaying in 'Add Meter' dropdown", true);
		boolean nHHElectricPresenceStatus = isElementExistInDropDown(addMeterUtilities, "nHH Electric");
		softAssertion.assertTrue(nHHElectricPresenceStatus, "nHH Electric is not displaying in 'Add Meter' dropdown");
		Reporter.log("Checked if nHH Electric is displaying in 'Add Meter' dropdown", true);
		boolean gasPresenceStatus = isElementExistInDropDown(addMeterUtilities, "Gas");
		softAssertion.assertTrue(gasPresenceStatus, "Gas utility is not displaying in 'Add Meter' dropdown");
		Reporter.log("Checked if 'Gas' utility is displaying in 'Add Meter' dropdown", true);
		boolean waterPresenceStatus = isElementExistInDropDown(addMeterUtilities, "Water");
		softAssertion.assertTrue(waterPresenceStatus, "Water utility is not displaying in 'Add Meter' dropdown");
		Reporter.log("Checked if 'Water' utility is displaying in 'Add Meter' dropdown", true);
		softAssertion.assertAll();
	}
	public void validateAddnHHMeterPopup() throws Throwable
	{
		click(siteFirstRecord);
		Reporter.log("Clicked on the first site present in the Property Portfolio page");
		Thread.sleep(2000);
		click(addMeter);
		Reporter.log("Clicked on Add Meter dropdown");
		Thread.sleep(1000);
		click(addnHHMeter);
		Reporter.log("Clicked on nHH Electric meter");
		Assert.assertTrue(isElementPresent(procurementType), 
				"Popup for adding new nHH Electric meter didn't appear");
		Reporter.log("Checked if popup is displaying");
	}
	
	public void deleteAllSites() throws Throwable {
		List<WebElement> allElements = driver.findElements(deleteSites);
		for (WebElement element: allElements) {
			click((By) element);
			click(okBtn);
			Thread.sleep(2000);
		}
	}
}
