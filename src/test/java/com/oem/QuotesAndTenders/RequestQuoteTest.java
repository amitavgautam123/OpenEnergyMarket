package com.oem.QuotesAndTenders;



import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.PropertyPortfolioPage;
import com.oem.framework.pages.RequestQuotePage;

public class RequestQuoteTest extends BaseTest {

	@Test
	public void QT_RAQ_TC_003_validatePresenceOfRequestQuoteAndReviewQuotesTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatePresenceOfRequestQuoteAndReviewQuotes();
	}

	/*
	 * @Test public void QT_RAQ_TC_005() throws Throwable { LoginPage loginPage
	 * = new LoginPage(); CustomerDashboardPage customerDashboardPage =
	 * (CustomerDashboardPage)loginPage.login(); PropertyPortfolioPage
	 * propertyPortfolioPage =
	 * (PropertyPortfolioPage)customerDashboardPage.goToPropertyPortfolio();
	 * //RequestQuotePage requestQuotePage = (RequestQuotePage)
	 * customerDashboardPage.goToPropertyPortfolio();//.goToRequestQuote();
	 * propertyPortfolioPage.deleteAllSites(); //requestQuotePage.(); }
	 */
	@Test
	public void QT_RAQ_TC_007_validatePresenceAllUtilitiesTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatePresenceAllUtilities();
	}

	@Test
	public void QT_RAQ_TC_008_validateContractDurationValuesForAllUtilitiesTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validateContractDurationValuesForAllUtilities();
	}

	@Test
	public void QT_RAQ_TC_010_validatealertErrormessage_IfNotSelectedAndemptyTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessage_IfNotSelectedAndempty();
	}

	@Test
	public void QT_RAQ_TC_011_validatealertErrormessagewhenOnlyOneMeterisSelectedTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessagewhenOnlyOneMeterisSelected();
	}

	@Test
	public void QT_RAQ_TC_012_validatealertErrormessagewhenMoreThanOneMeterisSelectedTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessagewhenMoreThanOneMeterisSelected();
	}

	@Test
	public void QT_RAQ_TC_013_validatealertErrormessagewhenOneContractDurationisSelectedTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessagewhenOneContractDurationisSelected();
	}

	@Test
	public void QT_RAQ_TC_014_validatealertErrormessagewhenMoreThanOneContractDurationisSelectedTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessagewhenMoreThanOneContractDurationisSelected();
	}

	@Test
	public void QT_RAQ_TC_015_validateAlertMessageWhen2ContractDurationsAreSameTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validateAlertMessageWhen2ContractDurationsAreSame();
	}
	
	@Test
	public void QT_RAQ_TC_016_validatealertErrormessageAfterSelectingOneSuplierTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessageAfterSelectingOneSuplier();
	}
	@Test
	public void QT_RAQ_TC_017_validatealertErrormessageAfterSelectingAllSuplierTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessageAfterSelectingAllSuplier();
	}
	@Test
	public void QT_RAQ_TC_018_validatealertErrormessageAfterSelecting1meter1contractDurationTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessageAfterSelecting1meter1contractDuration();
	}
	@Test
	public void QT_RAQ_TC_019_validatealertErrormessageAfterSelecting1meterMultiplecontractDurationTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessageAfterSelecting1meterMultiplecontractDuration();
	}
	@Test
	public void QT_RAQ_TC_020_validatealertErrormessageAfterSelectingMultiplemeterMultiplecontractDurationTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessageAfterSelectingMultiplemeterMultiplecontractDuration();
	}
	@Test
	public void QT_RAQ_TC_021_validatingErrorMessageAfterSelecting1contractDurationAndMultipleSuppliersTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingErrorMessageAfterSelecting1contractDurationAndMultipleSuppliers();
	}
	@Test
	public void QT_RAQ_TC_022_validatingErrorMessageAfterSelectingMultiplecontractDurationAndSingleSupplierTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingErrorMessageAfterSelectingMultiplecontractDurationAndSingleSupplier();
	}
	@Test
	public void QT_RAQ_TC_023_validatingErrorMessageAfterSelectingsinglecontractDurationAndmultipleSupplierTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingErrorMessageAfterSelectingsinglecontractDurationAndmultipleSupplier();
	}
	@Test
	public void QT_RAQ_TC_024_validatingAvailablityToVerfyAfterSelecting1Meter1Contract1SupplierTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelecting1Meter1Contract1Supplier();
	}
	@Test
	public void QT_RAQ_TC_025_validatingAvailablityToVerfyAfterSelectingMultipleMeter1Contract1SupplierTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelectingMultipleMeter1Contract1Supplier();
	}
	@Test
	public void QT_RAQ_TC_026_validatingAvailablityToVerfyAfterSelecting1MeterMultipleContract1SupplierTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelecting1MeterMultipleContract1Supplier();
	}
	@Test
	public void QT_RAQ_TC_027_validatingAvailablityToVerfyAfterSelecting1Meter1ContractMultipleSupplierTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelecting1Meter1ContractMultipleSupplier();
	}
	@Test
	public void QT_RAQ_TC_028_validatingAvailablityToVerfyAfterSelectingMultipleMeterMultipleContract1SupplierTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelectingMultipleMeterMultipleContract1Supplier();
	}
	@Test
	public void QT_RAQ_TC_029_validatingAvailablityToVerfyAfterSelectingMultipleMeter1ContractMultipleSupplier() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelectingMultipleMeter1ContractMultipleSupplier();
	}
	@Test
	public void QT_RAQ_TC_030_validatingAvailablityToVerfyAfterSelectingSingleMeterMultipleContractMultipleSupplierTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelectingSingleMeterMultipleContractMultipleSupplier();
	}
	@Test
	public void QT_RAQ_TC_032_validatingAvailablityToVerfyAfterSelectingMultipleMeterMultipleContractMultipleSupplierTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelectingMultipleMeterMultipleContractMultipleSupplier();
	}
	@Test
	public void QT_RAQ_TC_033_validatingAvailablityToVerfyAfterSelectingAllMeterAllContractAllSupplierAndRenewableEnergyTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelectingAllMeterAllContractAllSupplierAndRenewableEnergy();
	}
	@Test
	public void QT_RAQ_TC_034_validatingErrorMessageAfterSelectingAllMeterAllContractAllSupplierAndSettingDate5daysBeforeTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingErrorMessageAfterSelectingAllMeterAllContractAllSupplierAndSettingDate5daysBefore();
	}
	@Test
	public void QT_RAQ_TC_035_validatingAvailablityToVerfyAfterSelectingAllMeterAllContractAllSupplierAndSettingDatetoFutureTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelectingAllMeterAllContractAllSupplierAndSettingDatetoFuture();
	}
	@Test
	public void QT_RAQ_TC_037_verifyAlertMessageWhenNometerNocontractnosupplierSelectedIn_nHHUtilityTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhenNometerNocontractnosupplierSelectedIn_nHHUtility();
	}
	@Test
	public void QT_RAQ_TC_038_verifyAlertMessageWhen1meterNocontractnosupplierSelectedIn_nHHUtility() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen1meterNocontractnosupplierSelectedIn_nHHUtility();
	}
	@Test
	public void QT_RAQ_TC_039_verifyAlertMessageWhenMultiplemeterNocontractnosupplierSelectedIn_nHHUtilityTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhenMultiplemeterNocontractnosupplierSelectedIn_nHHUtility();
	}
	@Test
	public void QT_RAQ_TC_040_verifyAlertMessageWhenNometer1contractnosupplierSelectedIn_nHHUtilityTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhenNometer1contractnosupplierSelectedIn_nHHUtility();
	}
	@Test
	public void QT_RAQ_TC_041_verifyAlertMessageWhen_Nometer_Multiplecontract_nosupplier_SelectedIn_nHHUtilityTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Nometer_Multiplecontract_nosupplier_SelectedIn_nHHUtility();
	}
	@Test
	public void QT_RAQ_TC_042_verifyAlertmessageWhen2ContractDurations_selectsSameMonth_nHHTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertmessageWhen2ContractDurations_selectsSameMonth_nHH();
	}
	@Test
	public void QT_RAQ_TC_043_VerifyErrorMessageWhenSelecting_zeroMeters_zeroContractDurations_OneSupplier_nHHTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.VerifyErrorMessageWhenSelecting_zeroMeters_zeroContractDurations_OneSupplier_nHH();
	}
	@Test
	public void QT_RAQ_TC_044_VerifyErrorMessageWhenSelecting_zeroMeters_zeroContractDurations_MultipleSupplier_nHHTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.VerifyErrorMessageWhenSelecting_zeroMeters_zeroContractDurations_MultipleSupplier_nHH();
	}
	@Test
	public void QT_RAQ_TC_045_VerifyErrorMessageWhenSelecting_SingleMeters_SingleContractDurations_ZeroSupplier_nHHTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.VerifyErrorMessageWhenSelecting_SingleMeters_SingleContractDurations_ZeroSupplier_nHH();
	}
	@Test
	public void QT_RAQ_TC_046_VerifyErrorMessageWhenSelecting_SingleMeters_MultipleContractDurations_ZeroSupplier_nHHTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.VerifyErrorMessageWhenSelecting_SingleMeters_MultipleContractDurations_ZeroSupplier_nHH();
	}
	@Test
	public void QT_RAQ_TC_047_VerifyErrorMessageWhenSelecting_MultipleMeters_SingleContractDurations_ZeroSupplier_nHHTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.VerifyErrorMessageWhenSelecting_MultipleMeters_SingleContractDurations_ZeroSupplier_nHH();
	}
	@Test
	public void QT_RAQ_TC_048_VerifyErrorMessageWhenSelecting_ZeroMeters_SingleContractDurations_SingleSupplier_nHHTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.VerifyErrorMessageWhenSelecting_ZeroMeters_SingleContractDurations_SingleSupplier_nHH();
	}
	@Test
	public void QT_RAQ_TC_049_VerifyErrorMessageWhenSelecting_ZeroMeters_MultipleContractDurations_SingleSupplier_nHHTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.VerifyErrorMessageWhenSelecting_ZeroMeters_MultipleContractDurations_SingleSupplier_nHH();
	}
	@Test
	public void QT_RAQ_TC_050_VerifyErrorMessageWhenSelecting_ZeroMeters_SingleContractDurations_MultipleSupplier_nHHTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.VerifyErrorMessageWhenSelecting_ZeroMeters_SingleContractDurations_MultipleSupplier_nHH();
	}
	/*//@Test
	public void QT_RAQ_TC_051() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_SingleMeters_SingleContractDurations_SingleSupplier_nHH();
	}
	//@Test
	public void QT_RAQ_TC_052() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_MultipleMeters_SingleContractDurations_SingleSupplier_nHH();
	}
	//@Test
	public void QT_RAQ_TC_053() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_SingleMeters_MultipleContractDurations_SingleSupplier_nHH();
	}
	//@Test
	public void QT_RAQ_TC_054() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_SingleMeters_SingleContractDurations_MultipleSupplier_nHH();
	}
	//@Test
	public void QT_RAQ_TC_055() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_MultipleMeters_MultipleContractDurations_SingleSupplier_nHH();
	}
	//@Test
	public void QT_RAQ_TC_056() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_MultipleMeters_SingleContractDurations_MultipleSupplier_nHH();
	}
	//@Test
	public void QT_RAQ_TC_057() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_SingleMeters_MultipleContractDurations_MultipleSupplier_nHH();
	}
	//@Test
	public void QT_RAQ_TC_058() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_MultipleMeters_MultipleContractDurations_MultipleSupplier_nHH();
	}
	//@Test
	public void QT_RAQ_TC_059() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_MultipleMeters_MultipleContractDurations_MultipleSupplier_ClcikRenewableEnergy_nHH();
	}*/
	@Test
	public void QT_RAQ_TC_060_validatingErrorMessageAfterSelectingAllMeterAllContractAllSupplierAndSettingDate5daysBefore_nHHTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingErrorMessageAfterSelectingAllMeterAllContractAllSupplierAndSettingDate5daysBefore_nHH();
	}
	/*@Test
	public void QT_RAQ_TC_061() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingErrorMessageAfterSelectingAllMeterAllContractAllSupplierAndSettingfutureDate_nHH();
	}*/
	@Test
	public void QT_RAQ_TC_063_verifyErrorMessaegeWhenSelecting_ZeroMeter_ZeroContractDur_ZeroSupplier_Gas() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_ZeroMeter_ZeroContractDur_ZeroSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_064_verifyErrorMessaegeWhenSelecting_SingleMeter_ZeroContractDur_ZeroSupplier_GasTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_SingleMeter_ZeroContractDur_ZeroSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_065_verifyErrorMessaegeWhenSelecting_MultipleMeter_ZeroContractDur_ZeroSupplier_GasTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_MultipleMeter_ZeroContractDur_ZeroSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_066_verifyErrorMessaegeWhenSelecting_ZeroMeter_SingleContractDur_ZeroSupplier_GasTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_ZeroMeter_SingleContractDur_ZeroSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_067_verifyErrorMessaegeWhenSelecting_ZeroMeter_MultipleContractDur_ZeroSupplier_GasTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_ZeroMeter_MultipleContractDur_ZeroSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_068_verifyAlertmessageWhen2ContractDurations_selectsSameMonth_GasTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertmessageWhen2ContractDurations_selectsSameMonth_Gas();
	}
	@Test
	public void QT_RAQ_TC_069_verifyErrorMessaegeWhenSelecting_ZeroMeter_ZeroContractDur_SingleSupplier_GasTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_ZeroMeter_ZeroContractDur_SingleSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_070_verifyErrorMessaegeWhenSelecting_ZeroMeter_ZeroContractDur_MultipleSupplier_GasTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_ZeroMeter_ZeroContractDur_MultipleSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_071_verifyErrorMessaegeWhenSelecting_SingleMeter_SingleContractDur_ZeroSupplier_GasTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_SingleMeter_SingleContractDur_ZeroSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_072_verifyErrorMessaegeWhenSelecting_SingleMeter_MultipleContractDur_ZeroSupplier_GasTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_SingleMeter_MultipleContractDur_ZeroSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_073_verifyErrorMessaegeWhenSelecting_MultipleMeter_SingleContractDur_ZeroSupplier_GasTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_MultipleMeter_SingleContractDur_ZeroSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_074_verifyErrorMessaegeWhenSelecting_ZeroMeter_SingleContractDur_SingleSupplier_GasTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_ZeroMeter_SingleContractDur_SingleSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_075_verifyErrorMessaegeWhenSelecting_ZeroMeter_MultipleContractDur_SingleSupplier_GasTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_ZeroMeter_MultipleContractDur_SingleSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_076_verifyErrorMessaegeWhenSelecting_ZeroMeter_SingleContractDur_MultipleSupplier_GasTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_ZeroMeter_SingleContractDur_MultipleSupplier_Gas();
	}
	/*//@Test
	public void QT_RAQ_TC_077() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_SingleMeter_SingleContractDur_SingleSupplier_Gas();
	}
	//@Test
	public void QT_RAQ_TC_078() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_MultipleMeter_SingleContractDur_SingleSupplier_Gas();
	}
	//@Test
	public void QT_RAQ_TC_079() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_SingleMeter_MultipleContractDur_SingleSupplier_Gas();
	}
	//@Test
	public void QT_RAQ_TC_080() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_SingleMeter_SingleContractDur_MultipleSupplier_Gas();
	}
	//@Test
	public void QT_RAQ_TC_081() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_MultipleMeter_MultipleContractDur_SingleSupplier_Gas();
	}
	//@Test
	public void QT_RAQ_TC_082() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_MultipleMeter_SingleContractDur_MultipleSupplier_Gas();
	}
	//@Test
	public void QT_RAQ_TC_083() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_SingleMeter_MultipleContractDur_MultipleSupplier_Gas();
	}
	//@Test
	public void QT_RAQ_TC_084() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_MultipleMeter_MultipleContractDur_MultipleSupplier_Gas();
	}
	//@Test
	public void QT_RAQ_TC_085() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_MultipleMeter_MultipleContractDur_MultipleSupplier_RenewableEnergy_Gas();
	}*/
	@Test
	public void QT_RAQ_TC_086_verifyAlertMessageWhenSelecting_5previousDateToCurrentDate_Gas() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhenSelecting_5previousDateToCurrentDate_Gas();
	}
	/*//@Test
	public void QT_RAQ_TC_087() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhenSelecting_FutureDateToCurrentDate_Gas();
	}*/
	@Test
	public void QT_RAQ_TC_089_verifyAlertMessageOnSelecting_NoMeter_NoContractDuration_NoSupplier_WaterUtilityTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("zero", "zero", "zero");
	}
	@Test
	public void QT_RAQ_TC_090_verifyAlertMessageOnSelecting_OneMeter_NoContractDuration_NoSupplier_WaterUtilityTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("single", "zero", "zero");
	}
	@Test
	public void QT_RAQ_TC_091_verifyAlertMessageOnSelecting_MultipleMeter_NoContractDuration_NoSupplier_WaterUtilityTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("multiple", "zero", "zero");
	}
	@Test
	public void QT_RAQ_TC_092_verifyAlertMessageOnSelecting_NoMeter_OneContractDuration_NoSupplier_WaterUtilityTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("zero", "single", "zero");
	}
	@Test
	public void QT_RAQ_TC_093_verifyAlertMessageOnSelecting_DifferentCombinations_NoMeter_MultipleContractDuration_NoSupplier_WaterTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("zero", "multiple", "zero");
	}
	@Test
	public void QT_RAQ_TC_094_verifyAlertMessageWhenSelected_SameContractDuration_WaterUtilityTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhenSelected_SameContractDuration_Water();
	}
	@Test
	public void QT_RAQ_TC_095_verifyAlertMessageOnSelecting_NoMeter_NoContractDuration_OneSupplier_WaterUtilityTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("zero", "zero", "single");
	}
	@Test
	public void QT_RAQ_TC_096_verifyAlertMessageOnSelecting_NoMeter_NoContractDuration_MultipleSupplier_WaterUtilityTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("zero", "zero", "multiple");
	}
	@Test
	public void QT_RAQ_TC_097_verifyAlertMessageOnSelecting_SingleMeter_NoContractDuration_SingleSupplier_WaterUtilityTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("single", "zero", "single");
	}
	@Test
	public void QT_RAQ_TC_098_verifyAlertMessageOnSelecting_SingleMeter_MultipleContractDuration_NoSupplier_WaterUtilityTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("single", "multiple", "zero");
	}
	@Test
	public void QT_RAQ_TC_099_verifyAlertMessageOnSelecting_MultipleMeters_SingleContractDuration_NoSupplier_WaterUtilityTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("multiple", "single", "zero");
	}
	@Test
	public void QT_RAQ_TC_100_verifyAlertMessageOnSelecting_NoMeter_SingleContractDuration_SingleSupplier_WaterUtilityTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("zero", "single", "single");
	}
	@Test
	public void QT_RAQ_TC_101_verifyAlertMessageOnSelectingNoMeter_MultipleContractDuration_SingleSupplier_WaterUtilityTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("zero", "multiple", "single");
	}
	@Test
	public void QT_RAQ_TC_102_verifyAlertMessageOnSelecting_NoMeter_OneContractDuration_MultipleSupplier_WaterUtilityTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("zero", "single", "multiple");
	}
	/*//@Test
	public void QT_RAQ_TC_103() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("single", "single", "single");
	}
	//@Test
	public void QT_RAQ_TC_104() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("multiple", "single", "single");
	}
	//@Test
	public void QT_RAQ_TC_105() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("single", "multiple", "single");
	}
	//@Test
	public void QT_RAQ_TC_106() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("single", "single", "multiple");
	}
	//@Test
	public void QT_RAQ_TC_107() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("multiple", "multiple", "single");
	}
	//@Test
	public void QT_RAQ_TC_108() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("multiple", "single", "multiple");
	}
	//@Test
	public void QT_RAQ_TC_109() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("single", "multiple", "multiple");
	}
	//@Test
	public void QT_RAQ_TC_110() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("multiple", "multiple", "multiple");
	}*/
	@Test
	public void QT_RAQ_TC_112_verifyAlertMesage_After_Selecting_DifferentCombinations_Of_Meter_ContractDuration_AndpreviousDate_Supplier_WaterTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMesage_After_Selecting_DifferentCombinations_Of_Meter_ContractDuration_AndpreviousDate_Supplier_Water("multiple", "multiple", "multiple");
	}
	/*//@Test
	public void QT_RAQ_TC_113() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMesage_After_Selecting_DifferentCombinations_Of_Meter_ContractDuration_AndFutureDate_Supplier_Water("multiple", "multiple", "multiple");
	}*/
	@Test
	public void QT_RAQ_TC_116_verifyAlertmessageWhen2ContractDurations_selectsSameMonth_WaterTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertmessageWhen2ContractDurations_selectsSameMonth_Water();
	}
	@Test	
	public void QT_RAQ_TC_117_verifyTheElemtsareCheckedOrNotTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyTheElemtsareCheckedOrNot();
	}
	@Test	
	public void QT_RAQ_TC_118_validateSelectAllSupplierCheckboxWhenUnCheckedTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validateSelectAllSupplierCheckboxWhenUnChecked();
	}
	@Test	
	public void QT_RAQ_TC_119_validateSelectAllSupplierCheckboxWhenCheckedTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validateSelectAllSupplierCheckboxWhenChecked();
	}
	@Test	
	public void QT_RAQ_TC_120_validateCheckboxClickableTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validateCheckboxClickableTest();
	}
	@Test	
	public void QT_RAQ_TC_121_validateTenderSummaryPageDisplayTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validateTenderSummaryPageDisplay();
	}
	@Test	
	public void QT_RAQ_TC_122_validateEditCompanyProfileOptionTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validateEditCompanyProfileOption();
	}
	@Test	
	public void QT_RAQ_TC_123_validateEditAdditionalReqOptionTenderSummaryPageTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validateEditAdditionalReqOptionTenderSummaryPage();
	}
	@Test	
	public void QT_RAQ_TC_124_validateEditRequestQuoteOptionTenderSummaryPageTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validateEditQuoteOptionTenderSummaryPage();
	}
	@Test	
	public void QT_RAQ_TC_125_verifySupplierSelectionInTenderSummaryPage() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifySupplierSelectionInTenderSummaryPage();
	}
	
	
	
}
