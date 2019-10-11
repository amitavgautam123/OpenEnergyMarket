
package com.oem.PortfolioManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.PropertyPortfolioMeterPage;
import com.oem.framework.pages.PropertyPortfolioPage;

public class PropertyPortfolioMeterTest extends BaseTest {
	
	
	@Test
	public void PM_PP_TC_015() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateAddHHMeterPopup();
	}
	
	@Test(dataProvider = "getHHdata")
	public void addHHMeterUsingDataProviderTest(String meterNoSecondField, String meterNoThirdField, String meterNoFourthField, 
			String meterNoFifthField, String meterNoSixthField, String meterNoSeventhField, String expectedConsumption, 
			String capacity) throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.addHHMeterUsingDifferentTestData(meterNoSecondField, meterNoThirdField, 
				meterNoFourthField, meterNoFifthField, meterNoSixthField, meterNoSeventhField, expectedConsumption, capacity); 
	}
	@DataProvider
	public Object[][] getHHdata() {
		Object[][] data = {{"", "", "", "", "", "", "", ""}, 									/*PM_PP_TC_016*/
				{"234", "456", "", "", "", "", "", ""},											/*PM_PP_TC_017*/
				{"", "", "10", "1270", "8070", "869", "", ""},									/*PM_PP_TC_018*/
				{"456", "564", "10", "1270", "8070", "869", "", ""},							/*PM_PP_TC_019*/
				{"456", "564", "10", "1270", "8070", "869", "3500", ""},						/*PM_PP_TC_020*/
				{"456", "564", "10", "1270", "8070", "869", "", "5200"},						/*PM_PP_TC_022*/
				{"456", "564", "10", "1270", "8070", "869", "4000", "7000"}};					/*PM_PP_TC_024*/					
		return data;
	}
	@Test(dataProvider = "getHHdata2")
	public void addHHMeterUsingDataProviderTest2(String meterNoSecondField, String meterNoThirdField, String meterNoFourthField, 
			String meterNoFifthField, String meterNoSixthField, String meterNoSeventhField, int date, int month, int year,
			String expectedConsumption, String capacity) throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.addHHMeterUsingDifferentTestData2(meterNoSecondField, meterNoThirdField, 
				meterNoFourthField, meterNoFifthField, meterNoSixthField, meterNoSeventhField, date, month, year, 
				expectedConsumption, capacity); 
	}
	@DataProvider
	public Object[][] getHHdata2() {
		Object[][] data = {{"456", "564", "10", "1270", "8070", "869", 12, 4, 2020, "", ""},				/*PM_PP_TC_021*/
				{"456", "564", "10", "1270", "8070", "869", 17, 7, 2020, "3500", ""},						/*PM_PP_TC_023*/
				{"456", "564", "10", "1270", "8070", "869", 24, 9, 2020, "4000", "7000"}};					/*PM_PP_TC_025*/					
		return data;
	}
	@Test
	public void PM_PP_TC_026() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.addHHMeterUsingValidTestData();
	}
	@Test
	public void PM_PP_TC_027() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.addValidHHmeterGeneric();
	}
	@Test
	public void PM_PP_TC_028() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.checkSavedDetailsAfterAddingHHMeter();
	}
	@Test
	public void PM_PP_TC_029() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateEditHHmeterPopup();
	}
	@Test
	public void PM_PP_TC_030() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateEditHHmeter();
	}
	@Test
	public void PM_PP_TC_031() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateHHdeleteMeterPopup();
	}
	@Test
	public void PM_PP_TC_032() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateDeleteHHmeter();
	}
	
	
	@Test
	public void PM_PP_TC_033() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateAddContractHistoryPopup();
	}
	
	@Test(dataProvider = "getHHcontractHistoryData")
	public void addHHcontractHistoryUsingDataProviderTest(String dayRate, String nightRate, String standingCharge, 
			String capacityCharge, String contractedAnnualSpend) throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateMandatoryFieldsContractHistoryPopupDataProvider(dayRate, nightRate, standingCharge, 
				capacityCharge, contractedAnnualSpend);
	}
	@DataProvider
	public Object[][] getHHcontractHistoryData() {
		Object[][] data = {{"", "", "", "", ""},			//PM_PP_TC_034
				{"20", "", "", "", ""},						//PM_PP_TC_037
				{"", "18", "", "", ""},						//PM_PP_TC_038
				{"", "", "120", "", ""},					//PM_PP_TC_039
				{"", "", "", "140", ""},					//PM_PP_TC_040
				{"", "", "", "", "2400"}};
		return data;
	}
	@Test
	public void PM_PP_TC_035() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateMandatoryFieldsContractHistoryPopupByEnteringDataInDateTraded();
	}
	@Test
	public void PM_PP_TC_036() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateMandatoryFieldsContractHistoryPopupByEnteringDataInContractStartDate();
	}
	@Test
	public void PM_PP_TC_041() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateMandatoryFieldsContractHistoryPopupByEnteringDataInDateTradedAndContractStartDate();
	}
	@Test(dataProvider = "getHHcontractHistoryData2")
	public void addHHcontractHistoryUsingDataProviderTest2(int day, int month, int year, String dayRate, String nightRate, String standingCharge, 
			String capacityCharge, String contractedAnnualSpend) throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateMandatoryFieldsContractHistoryPopupDataProvider2(day, month, year, dayRate, nightRate, 
				standingCharge, capacityCharge, contractedAnnualSpend);
	}
	@DataProvider
	public Object[][] getHHcontractHistoryData2() {
		Object[][] data = {{20, 02, 2018, "25", "", "", "", ""},		//PM_PP_TC_042
				{14, 02, 2018, "", "28", "", "", ""},					//PM_PP_TC_043
				{28, 05, 2018, "", "", "48", "", ""},					//PM_PP_TC_044
				{10, 9, 2018, "", "", "", "35", ""}}; 					//PM_PP_TC_045
		return data;
	}
	@Test(dataProvider = "getHHcontractHistoryData3")
	public void addHHcontractHistoryUsingDataProviderTest3(int day, int month, int year, String dayRate, String nightRate, String standingCharge, 
			String capacityCharge, String contractedAnnualSpend) throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateMandatoryFieldsContractHistoryPopupDataProvider3(day, month, year, dayRate, nightRate, 
				standingCharge, capacityCharge, contractedAnnualSpend);
	}
	@DataProvider
	public Object[][] getHHcontractHistoryData3() {
		Object[][] data = {{20, 02, 2018, "", "", "", "", ""},			//PM_PP_TC_041
				{25, 4, 2018, "25", "", "", "", ""},					//PM_PP_TC_046
				{14, 2, 2018, "", "28", "", "", ""},					//PM_PP_TC_047
				{28, 5, 2018, "", "", "48", "", ""},					//PM_PP_TC_048
				{10, 9, 2018, "", "", "", "35", ""}, 					//PM_PP_TC_049
				{15, 7, 2018, "20", "18", "", "", ""},					//PM_PP_TC_050
				{22, 1, 2018, "20", "", "32", "", ""},					//PM_PP_TC_051
				{15, 7, 2018, "20", "", "", "45", ""}};					//PM_PP_TC_052
		return data;
	}

	
	
	
	@Test
	public void PM_PP_TC_065() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateAddnHHMeterPopup();
	}
	@Test(dataProvider = "getNHHdata")
	public void addnHHMeterUsingDataProviderTest(String meterNoDropdownFieldValue, String meterNoSecondField, String meterNoThirdField, String meterNoFourthField, 
			String meterNoFifthField, String meterNoSixthField, String meterNoSeventhField, String procurementType, String expectedConsumption, 
			String currentSupplier, String currentAnnualSpend) throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateAddnHHMeterPopupUsingDifferentTestData(meterNoDropdownFieldValue, meterNoSecondField, 
				meterNoThirdField, meterNoFourthField, meterNoFifthField, meterNoSixthField, meterNoSeventhField, procurementType, 
				expectedConsumption, currentSupplier, currentAnnualSpend); 
	}
	@DataProvider
	public Object[][] getNHHdata() {
		Object[][] data = {{"03", "", "", "", "", "", "", "Fixed", "", "Ecotricity", ""}, 				/*PM_PP_TC_066*/
				{"04", "234", "456", "", "", "", "", "Fixed", "", "Haven Power", ""},					/*PM_PP_TC_067*/
				{"05", "", "", "10", "1270", "8070", "869", "Fixed", "", "D-ENERGi", ""},				/*PM_PP_TC_068*/
				{"02", "456", "564", "10", "1270", "8070", "869", "Fixed", "", "Ecotricity", ""},		/*PM_PP_TC_069*/
				{"02", "456", "564", "10", "1270", "8070", "869", "Fixed", "3500", "Haven Power", ""}};	/*PM_PP_TC_070*/					
		return data;
	}
	@Test
	public void PM_PP_TC_071() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateExpectedConsumptionMandatoryFieldAddNHHPopup();
	}
	@Test
	public void PM_PP_TC_072() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.checkSavedDetailsAfterAddingNHHMeter();
	}
	@Test
	public void PM_PP_TC_074() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.addExpiredNHHmeter();
	}
	@Test
	public void PM_PP_TC_075() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.checkSavedDetailsAfterAddingNHHMeter();
	}
	/*@Test
	public void PM_PP_TC_076() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.checkSavedDetailsAfterAddingNHHMeter();
	}*/
	@Test
	public void PM_PP_TC_078() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateNHHdeleteMeterPopup();
	}
	@Test
	public void PM_PP_TC_079() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateDeleteNHHmeter();
	}
	
	
	
	
	@Test(dataProvider = "getGasMeterData")
	public void addGasMeterUsingDataProviderTest(String gasMeterNumber, String procurementType, String expectedConsumption, 
			String currentSupplier, int dayOfMonthOfContractEndDate, int monthNumberOfContractEndDate, int yearOfContractEndDate, 
			String currentAnnualSpend) throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage)loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = (PropertyPortfolioMeterPage)customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.addGasMeterUsingDifferentTestData(gasMeterNumber, procurementType, expectedConsumption, 
				currentSupplier, dayOfMonthOfContractEndDate, monthNumberOfContractEndDate, 
				yearOfContractEndDate, currentAnnualSpend);
	}
	@DataProvider
	public Object[][] getGasMeterData() {
		Object[][] data = {{"", "Fixed", "", "British Gas Business", 20, 4, 2021, ""}, /*PM_PP_TC_081*/
				{"2642342754", "Fixed", "", "D-ENERGi", 20, 5, 2020, ""}, /*PM_PP_TC_082*/
				{"6786342454", "Fixed Pass Through", "2200", "Corona Energy", 10, 3, 2020, ""}, /*PM_PP_TC_083*/
				{"2842342254", "Combined Flexible", "", "Corona Energy", 10, 3, 2020, ""},/*PM_PP_TC_084*/
					{"2842342254", "Fixed", "3500", "Corona Energy", 10, 9, 2020, ""}}; /*PM_PP_TC_085*/
		return data;
	}
	@Test
	public void PM_PP_TC_080() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.validateAddGasMeterPopup();
	}
	@Test
	public void PM_PP_TC_086() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.addGasMeterUsingValidTestData();
	}
	@Test 
	public void PM_PP_TC_087() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.addExpiredGasMeter();
	}
	@Test 
	public void PM_PP_TC_088() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.checkSavedDetailsAfterAddingGasMeter();
	}
	@Test 
	public void PM_PP_TC_089() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.validateEditGasMeterPopup();
	}
	@Test 
	public void PM_PP_TC_090() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.validateEditGasMeter();
	}
	@Test 
	public void PM_PP_TC_091() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.validateGasDeleteMeterPopup();
	}
	@Test 
	public void PM_PP_TC_092() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.validateDeleteGasMeter();
	}
	@Test 
	public void PM_PP_TC_106() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.validateMeterRevertDeletion();
	}
}
