package com.oem.QuotesAndTenders;



import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.PropertyPortfolioPage;
import com.oem.framework.pages.RequestQuotePage;

public class RequestQuoteTest extends BaseTest {

	@Test
	public void QT_RAQ_TC_003() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatePresenceOfRequestQuoteAndReviewQuotes();
	}

	/*
	 * @Test public void QT_RAQ_TC_004() throws Throwable { LoginPage loginPage
	 * = new LoginPage(); CustomerDashboardPage customerDashboardPage =
	 * (CustomerDashboardPage)loginPage.login(); PropertyPortfolioPage
	 * propertyPortfolioPage =
	 * (PropertyPortfolioPage)customerDashboardPage.goToPropertyPortfolio();
	 * //RequestQuotePage requestQuotePage = (RequestQuotePage)
	 * customerDashboardPage.goToPropertyPortfolio();//.goToRequestQuote();
	 * propertyPortfolioPage.deleteAllSites(); //requestQuotePage.(); }
	 */
	@Test
	public void QT_RAQ_TC_007() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatePresenceAllUtilities();
	}

	@Test
	public void QT_RAQ_TC_008() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validateContractDurationValuesForAllUtilities();
	}

	@Test
	public void QT_RAQ_TC_010() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessage_IfNotSelectedAndempty();
	}

	@Test
	public void QT_RAQ_TC_011() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessagewhenOnlyOneMeterisSelected();
	}

	@Test
	public void QT_RAQ_TC_012() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessagewhenMoreThanOneMeterisSelected();
	}

	@Test
	public void QT_RAQ_TC_013() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessagewhenOneContractDurationisSelected();
	}

	@Test
	public void QT_RAQ_TC_014() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessagewhenMoreThanOneContractDurationisSelected();
	}

	@Test
	public void QT_RAQ_TC_015() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validateAlertMessageWhen2ContractDurationsAreSame();
	}
	
	@Test
	public void QT_RAQ_TC_016() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessageAfterSelectingOneSuplier();
	}
	@Test
	public void QT_RAQ_TC_017() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessageAfterSelectingAllSuplier();
	}
	@Test
	public void QT_RAQ_TC_018() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessageAfterSelecting1meter1contractDuration();
	}
	@Test
	public void QT_RAQ_TC_019() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessageAfterSelecting1meterMultiplecontractDuration();
	}
	@Test
	public void QT_RAQ_TC_020() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatealertErrormessageAfterSelectingMultiplemeterMultiplecontractDuration();
	}
	@Test
	public void QT_RAQ_TC_021() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingErrorMessageAfterSelecting1contractDurationAndMultipleSuppliers();
	}
	@Test
	public void QT_RAQ_TC_022() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingErrorMessageAfterSelectingMultiplecontractDurationAndSingleSupplier();
	}
	@Test
	public void QT_RAQ_TC_023() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingErrorMessageAfterSelectingsinglecontractDurationAndmultipleSupplier();
	}
	@Test
	public void QT_RAQ_TC_024() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelecting1Meter1Contract1Supplier();
	}
	@Test
	public void QT_RAQ_TC_025() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelectingMultipleMeter1Contract1Supplier();
	}
	@Test
	public void QT_RAQ_TC_026() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelecting1MeterMultipleContract1Supplier();
	}
	@Test
	public void QT_RAQ_TC_027() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelecting1Meter1ContractMultipleSupplier();
	}
	@Test
	public void QT_RAQ_TC_028() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelectingMultipleMeterMultipleContract1Supplier();
	}
	@Test
	public void QT_RAQ_TC_029() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelectingMultipleMeter1ContractMultipleSupplier();
	}
	@Test
	public void QT_RAQ_TC_030() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelectingSingleMeterMultipleContractMultipleSupplier();
	}
	@Test
	public void QT_RAQ_TC_032() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelectingMultipleMeterMultipleContractMultipleSupplier();
	}
	@Test
	public void QT_RAQ_TC_033() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelectingAllMeterAllContractAllSupplierAndRenewableEnergy();
	}
	@Test
	public void QT_RAQ_TC_034() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingErrorMessageAfterSelectingAllMeterAllContractAllSupplierAndSettingDate5daysBefore();
	}
	@Test
	public void QT_RAQ_TC_035() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.validatingAvailablityToVerfyAfterSelectingAllMeterAllContractAllSupplierAndSettingDatetoFuture();
	}
	@Test
	public void QT_RAQ_TC_037() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhenNometerNocontractnosupplierSelectedIn_nHHUtility();
	}
	@Test
	public void QT_RAQ_TC_038() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen1meterNocontractnosupplierSelectedIn_nHHUtility();
	}
	@Test
	public void QT_RAQ_TC_039() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhenMultiplemeterNocontractnosupplierSelectedIn_nHHUtility();
	}
	@Test
	public void QT_RAQ_TC_040() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhenNometer1contractnosupplierSelectedIn_nHHUtility();
	}
	@Test
	public void QT_RAQ_TC_041() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Nometer_Multiplecontract_nosupplier_SelectedIn_nHHUtility();
	}
	@Test
	public void QT_RAQ_TC_042() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertmessageWhen2ContractDurations_selectsSameMonth_nHH();
	}
	@Test
	public void QT_RAQ_TC_043() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.VerifyErrorMessageWhenSelecting_zeroMeters_zeroContractDurations_OneSupplier_nHH();
	}
	@Test
	public void QT_RAQ_TC_044() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.VerifyErrorMessageWhenSelecting_zeroMeters_zeroContractDurations_MultipleSupplier_nHH();
	}
	@Test
	public void QT_RAQ_TC_045() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.VerifyErrorMessageWhenSelecting_SingleMeters_SingleContractDurations_ZeroSupplier_nHH();
	}
	@Test
	public void QT_RAQ_TC_046() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.VerifyErrorMessageWhenSelecting_SingleMeters_MultipleContractDurations_ZeroSupplier_nHH();
	}
	@Test
	public void QT_RAQ_TC_047() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.VerifyErrorMessageWhenSelecting_MultipleMeters_SingleContractDurations_ZeroSupplier_nHH();
	}
	@Test
	public void QT_RAQ_TC_048() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.VerifyErrorMessageWhenSelecting_ZeroMeters_SingleContractDurations_SingleSupplier_nHH();
	}
	@Test
	public void QT_RAQ_TC_049() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.VerifyErrorMessageWhenSelecting_ZeroMeters_MultipleContractDurations_SingleSupplier_nHH();
	}
	@Test
	public void QT_RAQ_TC_050() throws Throwable {
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
	public void QT_RAQ_TC_060() throws Throwable {
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
	public void QT_RAQ_TC_063() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_ZeroMeter_ZeroContractDur_ZeroSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_064() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_SingleMeter_ZeroContractDur_ZeroSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_065() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_MultipleMeter_ZeroContractDur_ZeroSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_066() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_ZeroMeter_SingleContractDur_ZeroSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_067() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_ZeroMeter_MultipleContractDur_ZeroSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_068() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertmessageWhen2ContractDurations_selectsSameMonth_Gas();
	}
	@Test
	public void QT_RAQ_TC_069() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_ZeroMeter_ZeroContractDur_SingleSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_070() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_ZeroMeter_ZeroContractDur_MultipleSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_071() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_SingleMeter_SingleContractDur_ZeroSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_072() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_SingleMeter_MultipleContractDur_ZeroSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_073() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_MultipleMeter_SingleContractDur_ZeroSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_074() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_ZeroMeter_SingleContractDur_SingleSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_075() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyErrorMessaegeWhenSelecting_ZeroMeter_MultipleContractDur_SingleSupplier_Gas();
	}
	@Test
	public void QT_RAQ_TC_076() throws Throwable {
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
	public void QT_RAQ_TC_086() throws Throwable {
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
	public void QT_RAQ_TC_089() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("zero", "zero", "zero");
	}
	@Test
	public void QT_RAQ_TC_090() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("single", "zero", "zero");
	}
	@Test
	public void QT_RAQ_TC_091() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("multiple", "zero", "zero");
	}
	@Test
	public void QT_RAQ_TC_092() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("zero", "single", "zero");
	}
	@Test
	public void QT_RAQ_TC_093() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("zero", "multiple", "zero");
	}
	@Test
	public void QT_RAQ_TC_094() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhenSelected_SameContractDuration_Water();
	}
	@Test
	public void QT_RAQ_TC_095() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("zero", "zero", "single");
	}
	@Test
	public void QT_RAQ_TC_096() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("zero", "zero", "single");
	}
	@Test
	public void QT_RAQ_TC_097() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("single", "zero", "single");
	}
	@Test
	public void QT_RAQ_TC_098() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("single", "multiple", "zero");
	}
	@Test
	public void QT_RAQ_TC_099() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("multiple", "single", "zero");
	}
	@Test
	public void QT_RAQ_TC_100() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("zero", "single", "single");
	}
	@Test
	public void QT_RAQ_TC_101() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water("zero", "multiple", "single");
	}
	@Test
	public void QT_RAQ_TC_102() throws Throwable {
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
	public void QT_RAQ_TC_112() throws Throwable {
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
	//@Test
	public void QT_RAQ_TC_116() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		RequestQuotePage requestQuotePage = (RequestQuotePage) customerDashboardPage.goToRequestQuote();
		requestQuotePage.verifyAlertmessageWhen2ContractDurations_selectsSameMonth_Water();
	}
	
}