package com.oem.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.PortfolioCalendarPage;
import com.oem.framework.pages.PropertyPortfolioMeterPage;
import com.oem.framework.pages.PropertyPortfolioPage;

public class PropertyPortfolioTest extends BaseTest {
	
	@Test
	public void PM_PP_TC_004() throws Throwable { 
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioPage propertyPortfolioTest = (PropertyPortfolioPage) customerDashboardPage.goToPropertyPortfolio();
		propertyPortfolioTest.validatePresenceAddSitePopup();
	}
	@Test
	public void PM_PP_TC_005() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioPage propertyPortfolioTest = (PropertyPortfolioPage) customerDashboardPage.goToPropertyPortfolio();
		propertyPortfolioTest.validateMandatoryFieldsAddSitePopup();
	}
	@Test
	public void PM_PP_TC_006() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioPage propertyPortfolioTest = (PropertyPortfolioPage) customerDashboardPage.goToPropertyPortfolio();
		propertyPortfolioTest.validateAddressPostcodeMandatoryFieldsAddSitePopup();
	}
	@Test
	public void PM_PP_TC_007() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioPage propertyPortfolioTest = (PropertyPortfolioPage) customerDashboardPage.goToPropertyPortfolio();
		propertyPortfolioTest.validateMandatorySiteNamePostcodeFieldsInAddSitePopup();
	}
	@Test
	public void PM_PP_TC_008() throws Throwable  {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioPage propertyPortfolioTest = (PropertyPortfolioPage) customerDashboardPage.goToPropertyPortfolio();
		propertyPortfolioTest.validateMandatorySiteNameAddressFieldsInAddSitePopup();
	}
	
	/**
	 * Executes 'Add site' popup test cases from PM_PP_TC_005 to PM_PP_TC_013 
	 * @param name
	 * @param addr1
	 * @param postCode
	 * @param siteContactNAME
	 * @param contactPHONENo
	 * @param contactEMAIL
	 * @param site_ID
	 * @param addr2
	 * @param addr3
	 * @param addr4
	 * @param siteArea
	 * @throws Throwable
	 */
	@Test(dataProvider = "getDataForAddSite") //PM_PP_TC_005 - PM_PP_TC_013
	public void addSiteUsingDataProvider(String name, String addr1, String postCode, String siteContactNAME, String contactPHONENo, String contactEMAIL, String site_ID, String addr2, String addr3, String addr4, String siteArea) throws Throwable  {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioPage propertyPortfolioTest = (PropertyPortfolioPage) customerDashboardPage.goToPropertyPortfolio();
		propertyPortfolioTest.validateAddSitePopupDataProvider(name, addr1, postCode, 
				siteContactNAME, contactPHONENo, contactEMAIL, site_ID, addr2, addr3, addr4, siteArea);
	}
	@DataProvider
	public Object[][] getDataForAddSite()
	{
		Object[][] data = 
			{{"", "", "", "Henricks", "9823948232", "andola.amitav@gmail.com", "8125", "GR Complex", "Domlur", "Karnataka", "2000"}};
				
		return data;
	}
	@Test
	public void PM_PP_TC_014() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioPage propertyPortfolioTest = (PropertyPortfolioPage) customerDashboardPage.goToPropertyPortfolio();
		propertyPortfolioTest.validateAddMeterDropdown(); 
	}
	 //Executes Add HH Meter form for different test data. Test cases: PM_PP_TC_016 to  
	@Test(dataProvider = "getHHMeterData")
	public void addHHMeterUsingDataProvider(String meterNoDropdownFieldValue, String meterNoSecondField, String meterNoThirdField, String meterNoFourthField, 
			String meterNoFifthField, String meterNoSixthField, String meterNoSeventhField, String procurementType,	
			String expectedConsumption, String currentSupplier, String capacity, String currentAnnualSpend, 
			String currentMeterOperator, String currentDataCollector) throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioPage propertyPortfolioTest = (PropertyPortfolioPage) customerDashboardPage.goToPropertyPortfolio();
		propertyPortfolioTest.addHHMeterUsingDifferentTestData(meterNoDropdownFieldValue, meterNoSecondField, meterNoThirdField, 
				meterNoFourthField,	meterNoFifthField, meterNoSixthField, meterNoSeventhField, procurementType,	expectedConsumption, 
				currentSupplier, capacity, currentAnnualSpend, currentMeterOperator, currentDataCollector);
	}
	@DataProvider
	public Object[][] getHHMeterData()
	{
		Object[][] data = {{"00", "234", "123", "234", "345", "234", "234", "Combined Flexible", "2000", "F&S Energy", "4500", "3200", "Bury Metering Services Limited", "Energy Assets"},
		{"00", "", "", "", "", "", "", "Flexible", "2500", "F&S Energy", "3500", "3200", "Bury Metering Services Limited", "Energy Assets"}};
		return data;
	}
	
	
	
}
