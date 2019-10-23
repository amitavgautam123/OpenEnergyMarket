
package com.oem.PortfolioManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.PropertyPortfolioMeterPage;
import com.oem.framework.pages.PropertyPortfolioPage;

public class PropertyPortfolioMeterTest extends BaseTest {

	CustomerDashboardPage customerDashboardPage;

	@BeforeClass(alwaysRun = true)
	public void beforeMeterPage() throws Throwable {
		customerDashboardPage = new LoginPage().login();
	}

	@Test
	public void PM_PP_TC_015_validateAddHHMeterPopupTest() throws Throwable {
		customerDashboardPage.
			goToPropertyPortfolioMeterPage().
				validateAddHHMeterPopup();
	}

	@Test(dataProvider = "getHHdata")
	public void addHHMeterUsingDataProviderTest(String meterNoSecondField, String meterNoThirdField,
			String meterNoFourthField, String meterNoFifthField, String meterNoSixthField, String meterNoSeventhField,
			String expectedConsumption, String capacity) throws Throwable {
		customerDashboardPage.goToPropertyPortfolioMeterPage().addHHMeterUsingDifferentTestData(meterNoSecondField,
				meterNoThirdField, meterNoFourthField, meterNoFifthField, meterNoSixthField, meterNoSeventhField,
				expectedConsumption, capacity);
	}

	@DataProvider
	public Object[][] getHHdata() {
		Object[][] data = { { "", "", "", "", "", "", "", "" }, /* PM_PP_TC_016 */
				{ "234", "456", "", "", "", "", "", "" }, /* PM_PP_TC_017 */
				{ "", "", "10", "1289", "4022", "180", "", "" }, /* PM_PP_TC_018 */
				{ "456", "564", "10", "1289", "4022", "180", "", "" }, /* PM_PP_TC_019 */
				{ "456", "564", "10", "1289", "4022", "180", "3500", "" }, /* PM_PP_TC_020 */
				{ "456", "564", "10", "1289", "4022", "180", "", "5200" }, /* PM_PP_TC_022 */
				{ "456", "564", "10", "1289", "4022", "180", "4000", "7000" } }; /* PM_PP_TC_024 */
		return data;
	}

	@Test(dataProvider = "getHHdata2")
	public void addHHMeterUsingDataProviderTest2(String meterNoSecondField, String meterNoThirdField,
			String meterNoFourthField, String meterNoFifthField, String meterNoSixthField, String meterNoSeventhField,
			int date, int month, int year, String expectedConsumption, String capacity) throws Throwable {
		customerDashboardPage.
			goToPropertyPortfolioMeterPage().
					addHHMeterUsingDifferentTestData2(meterNoSecondField,
				meterNoThirdField, meterNoFourthField, meterNoFifthField, meterNoSixthField, meterNoSeventhField, date,
				month, year, expectedConsumption, capacity);
	}

	@DataProvider
	public Object[][] getHHdata2() {
		Object[][] data = { { "456", "564", "10", "1289", "4022", "180", 12, 4, 2020, "", "" }, /* PM_PP_TC_021 */
				{ "456", "564", "10", "1289", "4022", "180", 17, 7, 2020, "3500", "" }, /* PM_PP_TC_023 */
				{ "456", "564", "10", "1289", "4022", "180", 24, 9, 2020, "", "7000" } }; /* PM_PP_TC_025 */
		return data;
	}

	@Test
	public void PM_PP_TC_026_addingHHMeterCheckMeterCountEditDeleteReviewOptionTest() throws Throwable {
		customerDashboardPage.
			goToPropertyPortfolioMeterPage().
				addingHHMeterCheckMeterCountEditDeleteReviewOptionTest();
	}
	/*
	 * @Test public void PM_PP_TC_027_addValidHHmeterTest() throws Throwable {
	 * customerDashboardPage. goToPropertyPortfolioMeterPage().
	 * addValidHHmeterGeneric(); }
	 * 
	 * @Test public void PM_PP_TC_028_checkSavedDetailsAfterAddingHHmeterTest()
	 * throws Throwable { customerDashboardPage .goToPropertyPortfolioMeterPage()
	 * .checkSavedDetailsAfterAddingHHMeter(); }
	 * 
	 * @Test public void PM_PP_TC_029_validateEditHHmeterPopupTest() throws
	 * Throwable { customerDashboardPage. goToPropertyPortfolioMeterPage().
	 * validateEditHHmeterPopup(); }
	 * 
	 * @Test public void PM_PP_TC_030_validateEditHHmeterTest() throws Throwable {
	 * customerDashboardPage. goToPropertyPortfolioMeterPage().
	 * validateEditHHmeter(); }
	 * 
	 * @Test public void PM_PP_TC_031_validateHHdeleteMeterPopupTest() throws
	 * Throwable { customerDashboardPage. goToPropertyPortfolioMeterPage().
	 * validateHHdeleteMeterPopup(); }
	 * 
	 * @Test public void PM_PP_TC_032_validateDeleteHHmeterTest() throws Throwable {
	 * customerDashboardPage. goToPropertyPortfolioMeterPage().
	 * validateDeleteHHmeter(); }
	 * 
	 * @Test public void PM_PP_TC_033_validateAddContractHistoryPopupTest() throws
	 * Throwable { customerDashboardPage. goToPropertyPortfolioMeterPage()
	 * .validateAddContractHistoryPopup(); }
	 * 
	 * @Test(dataProvider = "getHHcontractHistoryData") public void
	 * validateHHcontractHistoryMandatoryFieldUsingDataProviderTest(String dayRate,
	 * String nightRate, String standingCharge, String capacityCharge, String
	 * contractedAnnualSpend) throws Throwable { customerDashboardPage.
	 * goToPropertyPortfolioMeterPage().
	 * validateMandatoryFieldsContractHistoryPopupDataProvider(dayRate, nightRate,
	 * standingCharge, capacityCharge, contractedAnnualSpend); }
	 * 
	 * @DataProvider public Object[][] getHHcontractHistoryData() { Object[][] data
	 * = { { "", "", "", "", "" }, // PM_PP_TC_034 { "20", "", "", "", "" }, //
	 * PM_PP_TC_037 { "", "18", "", "", "" }, // PM_PP_TC_038 { "", "", "120", "",
	 * "" }, // PM_PP_TC_039 { "", "", "", "140", "" }, // PM_PP_TC_040 { "", "",
	 * "", "", "2400" } }; return data; }
	 * 
	 * @Test public void
	 * PM_PP_TC_035_validateMandatoryFieldsContHistPopupEnteringDateTradedTest()
	 * throws Throwable { customerDashboardPage. goToPropertyPortfolioMeterPage().
	 * validateMandatoryFieldsContractHistoryPopupByEnteringDataInDateTraded(); }
	 * 
	 * @Test public void
	 * PM_PP_TC_036_validateMandatoryFieldsContHistPopupEnteringContStartDateTest()
	 * throws Throwable { customerDashboardPage. goToPropertyPortfolioMeterPage().
	 * validateMandatoryFieldsContractHistoryPopupByEnteringDataInContractStartDate(
	 * ); }
	 * 
	 * @Test public void
	 * PM_PP_TC_041_validateMandatoryFieldsContHistPopupEnteringDateTradedContractStartDateTest
	 * () throws Throwable { customerDashboardPage.
	 * goToPropertyPortfolioMeterPage().
	 * validateMandatoryFieldsContractHistoryPopupByEnteringDataInDateTradedAndContractStartDate
	 * (); }
	 * 
	 * @Test(dataProvider = "getHHcontractHistoryData2") public void
	 * validateMandatoryFieldHHcontHistUsingDataProviderTest2(int day, int month,
	 * int year, String dayRate, String nightRate, String standingCharge, String
	 * capacityCharge, String contractedAnnualSpend) throws Throwable {
	 * customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * validateMandatoryFieldsContractHistoryPopupDataProvider2(day, month, year,
	 * dayRate, nightRate, standingCharge, capacityCharge, contractedAnnualSpend); }
	 * 
	 * @DataProvider public Object[][] getHHcontractHistoryData2() { Object[][] data
	 * = { { 20, 02, 2018, "25", "", "", "", "" }, // PM_PP_TC_042 { 14, 02, 2018,
	 * "", "28", "", "", "" }, // PM_PP_TC_043 { 28, 05, 2018, "", "", "48", "", ""
	 * }, // PM_PP_TC_044 { 10, 9, 2018, "", "", "", "35", "" } }; // PM_PP_TC_045
	 * return data; }
	 * 
	 * @Test(dataProvider = "getHHcontractHistoryData3") public void
	 * validateMandatoryFieldHHcontHistUsingDataProviderTest3(int day, int month,
	 * int year, String dayRate, String nightRate, String standingCharge, String
	 * capacityCharge, String contractedAnnualSpend) throws Throwable {
	 * customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * validateMandatoryFieldsContractHistoryPopupDataProvider3(day, month, year,
	 * dayRate, nightRate, standingCharge, capacityCharge, contractedAnnualSpend); }
	 * 
	 * @DataProvider public Object[][] getHHcontractHistoryData3() { Object[][] data
	 * = { { 20, 02, 2018, "", "", "", "", "" }, // PM_PP_TC_041 { 25, 4, 2018,
	 * "25", "", "", "", "" }, // PM_PP_TC_046 { 14, 2, 2018, "", "28", "", "", ""
	 * }, // PM_PP_TC_047 { 28, 5, 2018, "", "", "48", "", "" }, // PM_PP_TC_048 {
	 * 10, 9, 2018, "", "", "", "35", "" }, // PM_PP_TC_049 { 15, 7, 2018, "20",
	 * "18", "", "", "" }, // PM_PP_TC_050 { 22, 1, 2018, "20", "", "32", "", "" },
	 * // PM_PP_TC_051 { 15, 7, 2018, "20", "", "", "45", "" } }; // PM_PP_TC_052
	 * return data; }
	 * 
	 * @Test public void PM_PP_TC_065_validateAddnHHmeterPopupTest() throws
	 * Throwable { customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * validateAddnHHMeterPopup(); }
	 * 
	 * @Test(dataProvider = "getNHHdata") public void
	 * validateMandatoryFieldsNHHmeterUsingDataProviderTest(String
	 * meterNoDropdownFieldValue, String meterNoSecondField, String
	 * meterNoThirdField, String meterNoFourthField, String meterNoFifthField,
	 * String meterNoSixthField, String meterNoSeventhField, String procurementType,
	 * String expectedConsumption, String currentSupplier, String
	 * currentAnnualSpend) throws Throwable { customerDashboardPage
	 * .goToPropertyPortfolioMeterPage().
	 * validateAddnHHMeterPopupUsingDifferentTestData(meterNoDropdownFieldValue,
	 * meterNoSecondField, meterNoThirdField, meterNoFourthField, meterNoFifthField,
	 * meterNoSixthField, meterNoSeventhField, procurementType, expectedConsumption,
	 * currentSupplier, currentAnnualSpend); }
	 * 
	 * @DataProvider public Object[][] getNHHdata() { Object[][] data = { { "03",
	 * "", "", "", "", "", "", "Fixed", "", "Ecotricity", "" }, PM_PP_TC_066 { "04",
	 * "234", "456", "", "", "", "", "Fixed", "", "Haven Power", "" }, PM_PP_TC_067
	 * { "05", "", "", "10", "1270", "8070", "869", "Fixed", "", "D-ENERGi", "" },
	 * PM_PP_TC_068 { "02", "456", "564", "10", "1270", "8070", "869", "Fixed", "",
	 * "Ecotricity", "" }, PM_PP_TC_069 { "02", "456", "564", "10", "1270", "8070",
	 * "869", "Fixed", "3500", "Haven Power", "" } }; PM_PP_TC_070 return data; }
	 * 
	 * @Test public void
	 * PM_PP_TC_071_validateExpConsumpMandatoryFieldAddNHHPopupTest() throws
	 * Throwable { customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * validateExpectedConsumptionMandatoryFieldAddNHHPopup(); }
	 * 
	 * @Test public void PM_PP_TC_072_checkSavedDetailsAfterAddingNHHMeterTest()
	 * throws Throwable { customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * checkSavedDetailsAfterAddingNHHMeter(); }
	 * 
	 * @Test public void PM_PP_TC_074_addExpiredNHHmeterTest() throws Throwable {
	 * customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * addExpiredNHHmeter(); }
	 * 
	 * @Test public void PM_PP_TC_075_checkSavedDetailsAfterAddingNHHMeterTest()
	 * throws Throwable { customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * checkSavedDetailsAfterAddingNHHMeter(); }
	 * 
	 * 
	 * @Test public void PM_PP_TC_076() throws Throwable { LoginPage loginPage = new
	 * LoginPage(); CustomerDashboardPage customerDashboardPage =
	 * (CustomerDashboardPage) loginPage .login(); PropertyPortfolioMeterPage
	 * propertyPortfolioMeterTest = (PropertyPortfolioMeterPage)
	 * customerDashboardPage.goToPropertyPortfolioMeterPage();
	 * propertyPortfolioMeterTest.checkSavedDetailsAfterAddingNHHMeter(); }
	 * 
	 * @Test public void PM_PP_TC_078_validateNHHdeleteMeterPopupTest() throws
	 * Throwable { customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * validateNHHdeleteMeterPopup(); }
	 * 
	 * @Test public void PM_PP_TC_079_validateDeleteNHHmeterTest() throws Throwable
	 * { customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * validateDeleteNHHmeter(); }
	 * 
	 * @Test(dataProvider = "getGasMeterData") public void
	 * validateMandatoryFieldAddGasMeterUsingDataProviderTest(String gasMeterNumber,
	 * String procurementType, String expectedConsumption, String currentSupplier,
	 * int dayOfMonthOfContractEndDate, int monthNumberOfContractEndDate, int
	 * yearOfContractEndDate, String currentAnnualSpend) throws Throwable {
	 * customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * addGasMeterUsingDifferentTestData(gasMeterNumber, procurementType,
	 * expectedConsumption, currentSupplier, dayOfMonthOfContractEndDate,
	 * monthNumberOfContractEndDate, yearOfContractEndDate, currentAnnualSpend); }
	 * 
	 * @DataProvider public Object[][] getGasMeterData() { Object[][] data = { { "",
	 * "Fixed", "", "British Gas Business", 20, 4, 2021, "" }, PM_PP_TC_081 {
	 * "2642342754", "Fixed", "", "D-ENERGi", 20, 5, 2020, "" }, PM_PP_TC_082 {
	 * "6786342454", "Fixed Pass Through", "2200", "Corona Energy", 10, 3, 2020, ""
	 * }, PM_PP_TC_083 { "2842342254", "Combined Flexible", "", "Corona Energy", 10,
	 * 3, 2020, "" }, PM_PP_TC_084 { "2842342254", "Fixed", "3500", "Corona Energy",
	 * 10, 9, 2020, "" } }; PM_PP_TC_085 return data; }
	 * 
	 * @Test public void PM_PP_TC_080_validateAddGasMeterPopupTest() throws
	 * Throwable { customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * validateAddGasMeterPopup(); }
	 * 
	 * @Test public void PM_PP_TC_086_addGasMeterUsingValidTestDataTest() throws
	 * Throwable { customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * addGasMeterUsingValidTestData(); }
	 * 
	 * @Test public void PM_PP_TC_087_addExpiredGasMeterTest() throws Throwable {
	 * customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * addExpiredGasMeter(); }
	 * 
	 * @Test public void PM_PP_TC_088_checkSavedDetailsAfterAddingGasMeterTest()
	 * throws Throwable { customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * checkSavedDetailsAfterAddingGasMeter(); }
	 * 
	 * @Test public void PM_PP_TC_089_validateEditGasMeterPopupTest() throws
	 * Throwable { customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * validateEditGasMeterPopup(); }
	 * 
	 * @Test public void PM_PP_TC_090_validateEditGasMeterTest() throws Throwable {
	 * customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * validateEditGasMeter(); }
	 * 
	 * @Test public void PM_PP_TC_091_validateGasDeleteMeterPopupTest() throws
	 * Throwable { customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * validateGasDeleteMeterPopup(); }
	 * 
	 * @Test public void PM_PP_TC_092_validateDeleteGasMeterTest() throws Throwable
	 * { customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * validateDeleteGasMeter(); }
	 * 
	 * @Test public void PM_PP_TC_106_validateMeterRevertDeletionTest() throws
	 * Throwable { customerDashboardPage .goToPropertyPortfolioMeterPage().
	 * validateMeterRevertDeletion(); }
	 */
}
