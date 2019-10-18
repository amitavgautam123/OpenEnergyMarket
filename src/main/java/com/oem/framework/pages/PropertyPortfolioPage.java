package com.oem.framework.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	
	
	By deleteSites = By.xpath("//hgroup[@class = 'site-overview-item']/table/tbody/tr/td[5]/a[2]");
	By okBtn = By.xpath("//button[text() = 'OK']");
	
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
		Thread.sleep(1000);
		Assert.assertTrue(isElementPresent(addNewSitePopup), "Add site popup is not displaying");
	}
	public void addValidSiteGeneric() throws Throwable {
		click(addSite);		
			//JavascriptExecutor executor = (JavascriptExecutor)driver;
		    //executor.executeScript("document.body.style.zoom = '0.8'");
		Thread.sleep(1000);
		setValue(siteName, "Auto_Domlur");
		setValue(address1, "Auto_G R Complex, No. 31, Ground & 1st Floor");
		setValue(postcode, "560071");
		setValue(siteContactName, "Auto_Amitav");
		setValue(contactPhoneNo, "9823423412");
		setValue(contactEmail, "andola.amitav@gmail.com");
		setValue(siteID, "Auto_555");
		setValue(address2, "Auto_Kempegowda Service Rd");
		setValue(address3, "Auto_Bengaluru");
		setValue(address4, "Auto_Karnataka");
		setValue(siteArea, "200");
		Reporter.log("Entered data in various fields in 'Add Site' popup", true);
			WebElement saveSiteBtn = driver.findElement(By.id("save-btn"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", saveSiteBtn);
		Reporter.log("Clicked save site data button.", true);
		Thread.sleep(2000);
		try {
			click(tipCloseBtn);
		}
		catch(Exception e) {
			System.out.println("Couldn't close 'Tip' message");
		}
		boolean meterPageURLstatus = driver.getCurrentUrl().contains("CompanyProfile/SiteMeters");
		Reporter.log("Verified URL in meter page.", true);
		Assert.assertTrue(meterPageURLstatus, "Site hasn't got saved.");
	}
	public void validateMandatoryFieldsAddSitePopup() throws Throwable 
	{
		SoftAssert softAssertion = new SoftAssert();
		if(getAttribute(siteName, "value").equals("")) {
			boolean siteNameErrorStatus = isElementPresent(siteName_Error);
			softAssertion.assertTrue(siteNameErrorStatus, "Error message for site name field is not displaying.");
		}
		if(getAttribute(address1, "value").equals("")) {
			boolean address1ErrorStatus = isElementPresent(address1Error);
			softAssertion.assertTrue(address1ErrorStatus, "Error message for address1 field is not displaying.");
		}
		if(getAttribute(postcode, "value").equals(""))	{
			boolean postcodeErrorStatus = isElementPresent(postcodeError);
			softAssertion.assertTrue(postcodeErrorStatus, "Error message for postcode field is not displaying.");
		}
		softAssertion.assertAll();
	}
	public void validateAddSitePopupDataProvider(String name, String addr1, String postCode, String siteContactNAME, 
			String contactPHONENo, String contactEMAIL, String site_ID, String addr2, String addr3, String addr4, String siteAREA) throws Throwable
	{
		click(addSite);
		Thread.sleep(1000);
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
	WebElement saveSiteBtn = driver.findElement(By.id("save-btn"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", saveSiteBtn);

		validateMandatoryFieldsAddSitePopup();
		
		/*
		 * List<WebElement> siteNames = driver.findElements(siteNameList); boolean
		 * siteAddstatus = false; for (WebElement siteName: siteNames) {
		 * if(siteName.getText().contains(name)==true) { siteAddstatus = true; } }
		 * s.assertTrue(siteAddstatus,
		 * "Site not displaying in site table after creation"); Reporter.
		 * log("Checked if the site is displaying in site table after site creation",
		 * true);
		 */
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
	
	
	public void deleteAllSites() throws Throwable {
		List<WebElement> allElements = driver.findElements(deleteSites);
		for (WebElement element: allElements) {
			click((By) element);
			click(okBtn);
			Thread.sleep(2000);
		}
	}
}
