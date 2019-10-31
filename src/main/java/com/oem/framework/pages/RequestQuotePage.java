package com.oem.framework.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.oem.framework.core.base.BasePage;

public class RequestQuotePage extends CustomerDashboardPage {

	// login
	By username = By.id("Email");
	By pwd = By.id("Password");
	By signInBtn = By.xpath("//input[@value='Sign in']");
	// Logout
	By logoutDropdown = By.xpath("//figure[@id = 'logo']/following-sibling::ul/li[2]/a");
	By logoutLink = By.xpath("//figure[@id = 'logo']/following-sibling::ul/li[2]//ul/li/a[text() = 'Log out']");

	// Company Profile
	By portfolioMgr = By.xpath("//*[@id=\"accordian-menu\"]//li[3]/h3");
	By companyProfile = By.linkText("Company Profile");

	By saveBtn = By.id("submit");
	By saveSuccessMsg = By.id("global-message-text");
	By companyName = By.id("Name");
	By companyRegisteredAddress = By.id("RegisteredAddress");
	By compPostCode = By.id("Postcode");
	By companyNameError = By.id("Name-error");
	By registeredAddressError = By.id("RegisteredAddress-error");
	By registeredAddressBlankError = By.id("RegisteredAddress-error");
	By postCodeError = By.id("Postcode-error");
	By phone = By.id("ContactPhone");
	By companyRegNum = By.id("CompanyRegistrationNumber");
	By companyRegNumError = By.id("CompanyRegistrationNumber-error");
	By CompanyLogo = By.id("CompanyLogo");
	By supplierInvoicingTo = By.id("InvoiceHeadOffice");
	By preferredSupplierPayment = By.id("PreferredSupplierPayment");
	By preferredSupplierPaymentError = By.id("PreferredSupplierPayment-error");
	By loaTemplate = By.xpath("//strong[text() = 'Letter of Authority Template']");
	By existingLOA = By.xpath("//strong[text() = 'Download Existing Letter Of Authority']");
	By LOAExpiresDate = By.id("LOAExpiresDate");
	By LOAExpiresDateDatePicker = By.id("ui-datepicker-div");

	// Property Portfolio
	By propertyPortfolio = By.linkText("Property Portfolio");

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

	// Meter Page
	By siteFirstRecord = By.xpath("//div[@id = 'divSitesOverview']/hgroup[1]/table/tbody/tr/td[1]");
	By hhMeterNumberFirstRecord = By.xpath("//div[@id = 'meters-1']/div/div[1]/table/tbody/tr/td[2]/div[2]");
	By tipCloseBtn = By.xpath("//p[contains(text(), 'Tip')]/following-sibling::a");

	By addMeter = By.id("add-meter-button");
	By meterUtilitiesInAddMeterDropdown = By.xpath("//div[@id = 'add-meter-button']/ul/li[*]");
	By addHHMeter = By.xpath("//div[@id = 'add-meter-button']/ul/li[1]");
	By addnHHMeter = By.xpath("//div[@id = 'add-meter-button']/ul/li[2]");
	By addGasMeter = By.xpath("//div[@id = 'add-meter-button']/ul/li[3]");
	By addWaterMeter = By.xpath("//div[@id = 'add-meter-button']/ul/li[4]");
	By saveMeterBtn = By.id("save-meter-button");
	/* Add HH & nHH Meter popup */
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
	// Contract History
	By addContractHistoryPopup = By.xpath("//h3[text() = 'Add new Contract History details']");
	By hhMeterDetailsBtnFirstRecord = By.xpath("//div[@id = 'meters-1']/div/div[1]/table/tbody/tr/td[7]/a[4]");
	By saveContractHistoryBtn = By.xpath("//form[@id='frmAddEditContractHistory']//button");
	By dateTraded = By.id("dateTraded");
	By contractStartDate = By.id("contractStartDate");
	By contractEndDate_ContractHist = By.id("contractEndDate");
	By dayRate = By.id("dayRate");
	By nightRate = By.id("nightRate");
	By standingCharge = By.id("standingCharge");
	By capacityCharge = By.id("capacityCharge");
	By contractedAnnualSpend = By.id("contractedAnnualSpend");
	By contractedConsumption = By.id("contractedConsumption");
	By supplierForContractHistoryDDwn = By.id("electricitySuppliersForContractHistory");
	By supplierProductDDwn = By.id("supplierProductForContractHistory");
	By uploadContractBtn = By.id("btnShowContractUploadModal");

	By verifyTenders = By.xpath("//li[@data-action = 'VerifyTenders']/a");

	By requestAQuoteLink = By.xpath("//li[@id = 'sidebar-request-quote']/a");
	By reviewQuotesLink = By.xpath("//li[@data-action = 'QuoteOverview']/a");

	By filterByHHutility = By.id("request-electricity-hh-quote-a");
	By filterByNHHutility = By.id("request-electricity-nhh-quote-a");
	By filterByGasUtility = By.id("request-gas-quote-a");
	By filterByWaterUtility = By.id("request-water-quote-a");

	By contractDurationHHutility = By.id("ElectricityQuoteHh_ContractDurationInMonths");
	By contractDurationNHHutility = By.id("ElectricityQuoteNhh_ContractDurationInMonths");
	By contractDurationGasUtility = By.id("GasQuote_ContractDurationInMonths");
	By contractDurationWaterUtility = By.id("WaterQuote_ContractDurationInMonths");

	// day 01/10/2019 added //*[@id="collapseElectricityQuoteNhh_SiteMeters_0_"]
	// -------------These are for HH Electricity----------------------------
	By SelectAllChoosemeter = By.xpath("//div[@id='request-electricity-hh-quote']//a[@id='selectall']");
	By MeterFirstElement = By.xpath("//div[@id='collapseElectricityQuoteHh_SiteMeters_0_']");// this
																								// will
																								// change
																								// continuously
	By MeterSecondElement = By.xpath("//div[@id='collapseElectricityQuoteHh_SiteMeters_1_']");
	By MeterThridElement = By.xpath("//div[@id='collapseElectricityQuoteHh_SiteMeters_2_']");
	By MeterFourthElement = By.xpath("//div[@id='collapseElectricityQuoteHh_SiteMeters_3_']");

	By ContractDuration = By.xpath("//select[@id='ElectricityQuoteHh_ContractDurationInMonths']");
	By AddNewContractDuration = By.xpath(
			"//div[@id='request-electricity-hh-quote']//p[@class='add-duration'][contains(text(),'Add new contract duration')]");
	By ContractDuration2 = By.xpath("//select[@id='ElectricityQuoteHh_Duration2']");
	By ContractDuration3 = By.xpath("//select[@id='ElectricityQuoteHh_Duration3']");
	By ContractDuration4 = By.xpath("//select[@id='ElectricityQuoteHh_Duration4']");

	By SelectAllChooseSupplier = By.xpath("//div[@id='request-electricity-hh-quote']//div[@id='selectall']");
	By listOfHHsupplierCheckbox = By.xpath("//div[@id='request-electricity-hh-quote']//li[*]//label[1]");
	By FirstSupplier = By.xpath("//div[@id='request-electricity-hh-quote']//section[@id='suppliers']//li[1]//label[1]");
	By ThirdSupplier = By.xpath("//div[@id='request-electricity-hh-quote']//li[3]//label[1]");
	By FourthSupplier = By.xpath("//div[@id='request-electricity-hh-quote']//li[4]//label[1]");
	By FifthSupplier = By.xpath("//div[@id='request-electricity-hh-quote']//li[5]//label[1]");
	By SixthSupplier = By.xpath("//div[@id='request-electricity-hh-quote']//li[6]//label[1]");

	By HHElectricity = By.xpath("//a[@id='request-electricity-hh-quote-a']");

	By tenderDateHH = By.xpath("//input[@id='ElectricityQuoteHh_TenderDate']");
	By RenewableEnergy = By
			.xpath("//div[@id='request-electricity-hh-quote']//label[contains(text(),'Renewable energy')]");

	By TopSubmit = By.xpath("//input[@class='btn btn-primary pull-right']");
	By OkAlert = By.xpath("//button[@class='vex-dialog-button-primary vex-dialog-button vex-first vex-last']");
	By OkAlertTextwhen2sameContractDurationSected = By.xpath("//div[@class='vex-dialog-message']");
	By OkAlert2 = By.xpath("//button[@class='vex-dialog-button-primary vex-dialog-button vex-first vex-last']");

	By message = By.xpath("//div[@class='alert alert-error']");
	By tenderRequestSummary = By.xpath("//h1[contains(text(),'Tender Request Summary')]");

	/*
	 * By AlertMessageText =By.xpath(
	 * "//li[contains(text(),'Please select at least one meter for a quote reque')]"
	 * ); By contractErrormessage = By.xpath(
	 * "//li[contains(text(),'Please select contract duration')]"); By
	 * supplierErrorMessage = By.xpath(
	 * "//li[contains(text(),'Please select at least one supplier for a quote re')]"
	 * );
	 */

	By submit = By.xpath("btn btn-primary pull-right");
	By deleteSites = By.xpath("//hgroup[@class = 'site-overview-item']/table/tbody/tr/td[5]/a[2]");
	By okBtn = By.xpath("//button[text() = 'OK']");

	// -------------These are for nHH Electricity----------------------------

	By meterAll_nHH = By.xpath("//div[@id='request-electricity-nhh-quote']//a[@id='selectall']");
	By Firstmeter_nHH = By.xpath("//div[@id='collapseElectricityQuoteNhh_SiteMeters_0_']//li[1]");
	By Secondmeter_nHH = By.xpath("//div[@id='collapseElectricityQuoteNhh_SiteMeters_0_']//li[2]");
	By thirdmeter_nHH = By.xpath("//div[@id='collapseElectricityQuoteNhh_SiteMeters_0_']//li[3]");
	By Fourthmeter_nHH = By.xpath("//div[@id='collapseElectricityQuoteNhh_SiteMeters_0_']//li[4]");

	By contractDuration_nHH = By.xpath("//select[@id='ElectricityQuoteNhh_ContractDurationInMonths']");
	By AddContractDuration_nHH = By.xpath(
			"//div[@id='request-electricity-nhh-quote']//p[@class='add-duration'][contains(text(),'Add new contract duration')]");
	By contractDuration2_nHH = By.xpath("//select[@id='ElectricityQuoteNhh_Duration2']");
	By contractDuration3_nHH = By.xpath("//select[@id='ElectricityQuoteNhh_Duration3']");
	By contractDuration4_nHH = By.xpath("//select[@id='ElectricityQuoteNhh_Duration4']");

	By date_nHH = By.xpath("//input[@id='ElectricityQuoteNhh_TenderDate']");
	By ChooseSupplierAll_nHH = By.xpath("//div[@id='request-electricity-nhh-quote']//div[@id='selectall']");
	By supplier01_nHH = By
			.xpath("//div[@id='request-electricity-nhh-quote']//section[@id='suppliers']//li[1]//label[1]");
	By supplier02_nHH = By
			.xpath("//div[@id='request-electricity-nhh-quote']//section[@id='suppliers']//li[2]//label[1]");
	By supplier03_nHH = By
			.xpath("//div[@id='request-electricity-nhh-quote']//section[@id='suppliers']//li[3]//label[1]");
	By supplier04_nHH = By
			.xpath("//div[@id='request-electricity-nhh-quote']//section[@id='suppliers']//li[4]//label[1]");
	By renewableEnergy_nHH = By
			.xpath("//div[@id='request-electricity-nhh-quote']//label[contains(text(),'Renewable energy')]");
	// ======================================Gas======================================================

	By allmeter_Gas = By.xpath("//div[@id='request-gas-quote']//a[@id='selectall']");
	By firstMeter_Gas = By.xpath("//div[@id='collapseGasQuote_SiteMeters_0_']//li[1]");
	By secondMeter_Gas = By.xpath("//div[@id='collapseGasQuote_SiteMeters_0_']//li[2]");
	By thirdMeter_Gas = By.xpath("//div[@id='collapseGasQuote_SiteMeters_0_']//li[3]");
	By fourthMeter_Gas = By.xpath("//div[@id='collapseGasQuote_SiteMeters_0_']//li[4]");

	By date_Gas = By.xpath("//input[@id='GasQuote_TenderDate']");
	By renewableEnergy_Gas = By.xpath("//div[@id='request-gas-quote']//label[contains(text(),'Renewable energy')]");
	By addNewContractDuration_Gas = By.xpath(
			"//div[@id='request-gas-quote']//p[@class='add-duration'][contains(text(),'Add new contract duration')]");

	By firstContractDuration_Gas = By.xpath("//select[@id='GasQuote_ContractDurationInMonths']");
	By secondContractDuration_Gas = By.xpath("//select[@id='GasQuote_Duration2']");
	By thirdContractDuration_Gas = By.xpath("//select[@id='GasQuote_Duration3']");
	By fourthContractDuration_Gas = By.xpath("//select[@id='GasQuote_Duration4']");

	By choosSuppliers_Gas = By.xpath("//div[@id='request-gas-quote']//div[@id='selectall']");
	By firstSupplier_gas = By.xpath("//div[@id='request-gas-quote']//section[@id='suppliers']//li[1]//label[1]");
	By secondSupplier_gas = By.xpath("//div[@id='request-gas-quote']//section[@id='suppliers']//li[2]//label[1]");
	By thirdSupplier_gas = By.xpath("//div[@id='request-gas-quote']//section[@id='suppliers']//li[3]//label[1]");
	By fourthSupplier_gas = By.xpath("//div[@id='request-gas-quote']//section[@id='suppliers']//li[4]//label[1]");
	By fifthSupplier_gas = By.xpath("//div[@id='request-gas-quote']//section[@id='suppliers']//li[5]//label[1]");
	// ===========================================Water======================================================================
	By allmeter_Water = By.xpath("//div[@id='request-water-quote']//a[@id='selectall']");
	By firstMeter_Water = By.xpath("//div[@id='collapseWaterQuote_SiteMeters_0_']//li[1]");
	/*
	 * By secondMeter_Gas =
	 * By.xpath("//div[@id='collapseGasQuote_SiteMeters_0_']//li[2]"); By
	 * thirdMeter_Gas =
	 * By.xpath("//div[@id='collapseGasQuote_SiteMeters_0_']//li[3]"); By
	 * fourthMeter_Gas =
	 * By.xpath("//div[@id='collapseGasQuote_SiteMeters_0_']//li[4]");
	 */

	By date_Water = By.xpath("//input[@id='WaterQuote_TenderDate']");
	By addNewContractDuration_Water = By.xpath(
			"//div[@id='request-water-quote']//p[@class='add-duration'][contains(text(),'Add new contract duration')]");

	By firstContractDuration_Water = By.xpath("//select[@id='WaterQuote_ContractDurationInMonths']");
	By secondContractDuration_Water = By.xpath("//select[@id='WaterQuote_Duration2']");
	By thirdContractDuration_Water = By.xpath("//select[@id='WaterQuote_Duration3']");
	By fourthContractDuration_Water = By.xpath("//select[@id='WaterQuote_Duration4']");

	By numberOfSuppliers = By
			.xpath("//div[@id='request-water-quote']//section[@id='suppliers']//ul[@class='check-list']//li");

	By choosSuppliers_Water = By.xpath("//div[@id='request-water-quote']//div[@id='selectall']");
	By firstSupplier_Water = By.xpath("//div[@id='request-water-quote']//section[@id='suppliers']//li[1]//label[1]");
	By secondSupplier_Water = By.xpath("//div[@id='request-water-quote']//section[@id='suppliers']//li[2]//label[1]");
	By thirdSupplier_Water = By.xpath("//div[@id='request-water-quote']//section[@id='suppliers']//li[3]//label[1]");
	By fourthSupplier_Water = By.xpath("//div[@id='request-water-quote']//section[@id='suppliers']//li[4]//label[1]");
	By fifthSupplier_Water = By.xpath("//div[@id='request-water-quote']//section[@id='suppliers']//li[5]//label[1]");

	// Tender Summary Page
	By editCompanyDetailsTenderSummaryPage = By.xpath("//a[@title = 'Edit Company Details']");
	By editAdditionalReqTenderSummaryPage = By.xpath("//a[@title = 'Edit Additional Requirements']");
	By editMeterDetailsTenderSummaryPage = By.id("edit-quote-request");
	By invitedSuppliersHeading_TenderSummaryPage = By.xpath("//h4[text() = 'Invited Suppliers']");
	By invitedSuppliers_TenderSummaryPage = By
			.xpath("//h4[text() = 'Invited Suppliers']/following-sibling::div/table/tbody/tr/td");

	By confirmAndSubmit = By.xpath("//button[text() = 'Confirm and Submit']");
	By quoteSubmitSuccessPopup = By.xpath(
			"//p[text() = 'Your request for a quote has been submitted. You will receive feedback from the Supplier shortly.']");
	By okBtn_TenderSummaryPage = By.xpath("//a[text() = 'Ok']");

	// Verify Tenders
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
	By blockSelectedBtn = By.xpath("//input[@value = 'Block Selected']");
	By alertPopUpForNoSupplierSelection = By.xpath("//div[text() = 'Please select at least one supplier']");

	public void clickWaterUtility() {
		click(filterByWaterUtility);

	}

	public void Options_Water(String WaterMeter, String WaterContractD, String WaterSupplier) {
		switch (WaterMeter) {
		case "zero":
			selectingzerometers_Water();
			break;
		case "single":
			selectingSinglemeters_Water();
			break;
		case "multiple":
			selectingMultiplemeters_Water();
			break;
		default:
			System.out.println("no match at WaterMeter");
		}
		switch (WaterContractD) {
		case "zero":
			click(addNewContractDuration_Water);
			click(addNewContractDuration_Water);
			break;
		case "multiple":
			selectingMultipleContractDur_Water();
			break;
		case "single":
			selectingsingleContractDur_Water();
			break;
		default:
			System.out.println("no match at WaterContractDuration");
		}
		switch (WaterSupplier) {
		case "zero":
			selectingzerosupplier_Water();
			break;
		case "single":
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selectingSinglesupplier_Water();
			break;
		case "multiple":
			selectingMultiplesupplier_Water();
			break;
		default:
			System.out.println("no match at WaterSupplier");
		}
	}

	public void ClickDate_Water() {
		click(date_Water);

	}

	public void selectingzerometers_Water() {
		click(allmeter_Water);
	}

	public void selectingSinglemeters_Water() {
		click(allmeter_Water);

		click(firstMeter_Water);

	}

	public void selectingMultiplemeters_Water() {
		click(allmeter_Water);

		click(firstMeter_Water);
		/*
		 * click(secondMeter_Water); Reporter.log("Clicked on second Meter.", true);
		 * click(thirdMeter_Water); Reporter.log( "Clicked on third Meter.", true);
		 * click(fourthMeter_Water); Reporter.log("Clicked on fourth Meter.", true);
		 */

	}

	public void selectingsingleContractDur_Water() {
		selectByIndex(firstContractDuration_Water, 02);

	}

	public void selectingMultipleContractDur_Water() {
		selectByIndex(firstContractDuration_Water, 02);

		click(addNewContractDuration_Water);
		selectByIndex(secondContractDuration_Water, 03);

		click(addNewContractDuration_Water);
		selectByIndex(thirdContractDuration_Water, 04);

		click(addNewContractDuration_Water);
		selectByIndex(fourthContractDuration_Water, 05);

	}

	public void selectingzerosupplier_Water() {
		click(choosSuppliers_Water);
	}

	public void selectingSinglesupplier_Water() {
		click(choosSuppliers_Water);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		click(firstSupplier_Water);

	}

	public void selectingMultiplesupplier_Water() {
		click(choosSuppliers_Water);

		click(firstSupplier_Water);
		click(secondSupplier_Water);
		click(thirdSupplier_Water);
		click(fourthSupplier_Water);
		click(fifthSupplier_Water);

	}

	// ===========================================Water===========================================================================
	public void clickGasUtility() {
		click(filterByGasUtility);
	}

	public void Options_Gas(String GasMeter, String GasContractD, String GasSupplier) {
		switch (GasMeter) {
		case "zero":
			selectingzerometers_Gas();
			break;
		case "single":
			selectingSinglemeters_Gas();
			break;
		case "multiple":
			selectingMultiplemeters_Gas();
			break;
		default:
			System.out.println("no match at GasMeter");
		}
		switch (GasContractD) {
		case "zero":
			click(addNewContractDuration_Gas);
			click(addNewContractDuration_Gas);
			break;
		case "multiple":
			selectingMultipleContractDur_Gas();
			break;
		case "single":
			selectingsingleContractDur_Gas();
			break;
		default:
			System.out.println("no match at GasContractDuration");
		}
		switch (GasSupplier) {
		case "zero":
			selectingzerosupplier_Gas();
			break;
		case "single":
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selectingSinglesupplier_Gas();
			break;
		case "multiple":
			selectingMultiplesupplier_Gas();
			break;
		default:
			System.out.println("no match at GasSupplier");
		}
	}

	public void ClickrenewableEnergy_Gas() {
		click(renewableEnergy_Gas);

	}

	public void ClickDate_Gas() {
		click(date_Gas);

	}

	public void selectingzerometers_Gas() {
		click(allmeter_Gas);

	}

	public void selectingSinglemeters_Gas() {
		click(allmeter_Gas);
		click(firstMeter_Gas);
	}

	public void selectingMultiplemeters_Gas() {
		click(allmeter_Gas);

		click(firstMeter_Gas);

		click(secondMeter_Gas);

		click(thirdMeter_Gas);

		click(fourthMeter_Gas);

	}

	public void selectingsingleContractDur_Gas() {
		selectByIndex(firstContractDuration_Gas, 02);

	}

	public void selectingMultipleContractDur_Gas() {
		selectByIndex(firstContractDuration_Gas, 02);
		click(addNewContractDuration_Gas);
		selectByIndex(secondContractDuration_Gas, 03);
		click(addNewContractDuration_Gas);
		selectByIndex(thirdContractDuration_Gas, 04);
		click(addNewContractDuration_Gas);
		selectByIndex(fourthContractDuration_Gas, 05);
	}

	public void selectingzerosupplier_Gas() {
		click(choosSuppliers_Gas);
	}

	public void selectingSinglesupplier_Gas() {
		click(choosSuppliers_Gas);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		click(firstSupplier_gas);
	}

	public void selectingMultiplesupplier_Gas() {
		click(choosSuppliers_Gas);

		click(firstSupplier_gas);
		click(secondSupplier_gas);
		click(thirdSupplier_gas);
		click(fourthSupplier_gas);
		click(fifthSupplier_gas);
	}
	// ============================================================================================

	public void CkiclingRenewableEnergy_nHH() {
		click(renewableEnergy_nHH);
	}

	public void selectingzerometers_nHH() {
		click(meterAll_nHH);
	}

	public void selectingSinglemeters_nHH() {
		click(meterAll_nHH);
		click(Firstmeter_nHH);
	}

	public void selectingMultiplemeters_nHH() {
		click(meterAll_nHH);
		click(Firstmeter_nHH);
		click(Secondmeter_nHH);
		click(thirdmeter_nHH);
		click(Fourthmeter_nHH);
	}

	public void selectingsingleContractDur_nHH() {
		selectByIndex(contractDuration_nHH, 02);
	}

	public void selectingMultipleContractDur_nHH() {
		selectByIndex(contractDuration_nHH, 02);

		click(AddContractDuration_nHH);
		selectByIndex(contractDuration2_nHH, 03);

		click(AddContractDuration_nHH);
		selectByIndex(contractDuration3_nHH, 04);

		click(AddContractDuration_nHH);
		selectByIndex(contractDuration4_nHH, 05);

	}

	public void selectingzerosupplier_nHH() {
		click(ChooseSupplierAll_nHH);
	}

	public void selectingSinglesupplier_nHH() {
		click(ChooseSupplierAll_nHH);

		click(supplier01_nHH);

	}

	public void selectingMultiplesupplier_nHH() {
		click(ChooseSupplierAll_nHH);
		click(supplier01_nHH);
		click(supplier02_nHH);
		click(supplier03_nHH);
		click(supplier04_nHH);

	}

	// --------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------
	public void SelectingZeroMeters() {
		click(SelectAllChoosemeter);
	}

	public void SelectingSingleMeter() {
		click(SelectAllChoosemeter);

		click(MeterFirstElement);
	}

	public void SelectingMultipleMeter() {
		click(SelectAllChoosemeter);

		click(MeterFirstElement);
		click(MeterSecondElement);
		click(MeterThridElement);
	}

	public void SelectingSingleContractDuration() {
		selectByIndex(ContractDuration, 02);
	}

	public void SelectingMultipleContractDuration() {
		selectByIndex(ContractDuration, 02);
		click(AddNewContractDuration);
		selectByIndex(ContractDuration2, 03);
		click(AddNewContractDuration);
		selectByIndex(ContractDuration3, 04);
	}

	public void SelectingZeroSuppliers() {
		click(SelectAllChooseSupplier);
	}

	public void SelectingSingleSupplier() {
		click(SelectAllChooseSupplier);
		click(FirstSupplier);
	}

	public void SelectingMultipleSupplier() {
		click(SelectAllChooseSupplier);
		click(FirstSupplier);
		click(ThirdSupplier);
		click(FourthSupplier);
		click(FifthSupplier);
	}

	public void ClickTopSubmitButton() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)");
		click(TopSubmit);
	}

	public void SelectElectricity_HHUtility() {
		click(HHElectricity);
	}

	public void SelectElectricity_nHHUtility() {
		click(filterByNHHutility);
	}

	public void SelectGasUtility() {
		click(filterByGasUtility);
	}

	public void SelectWaterUtility() {
		click(filterByWaterUtility);
	}

	public void EnterDate(String value) {
		clearValue(tenderDateHH);
		setValue(tenderDateHH, value);
	}

	public void ClickRenewableEnergy() {
		click(RenewableEnergy);
	}

	@Override
	protected void isLoaded() throws Error {
		System.out.println("Executing isLoaded in Request a Quote Page");
		Assert.assertTrue(isElementPresent(filterByHHutility), "Request a Quote Page didnt appear.");
	}

	public void validatePresenceOfRequestQuoteAndReviewQuotes() {
		SoftAssert softAssertion = new SoftAssert();
		boolean requestQuotePresenceStatus = isElementPresent(requestAQuoteLink);
		softAssertion.assertTrue(requestQuotePresenceStatus,
				"Request a quote option is not displaying in 'Quotes and Tenders' section.");
		boolean reviewQuotePresenceStatus = isElementPresent(reviewQuotesLink);
		softAssertion.assertTrue(reviewQuotePresenceStatus,
				"Review quote option is not displaying in 'Quotes and Tenders' section.");
		softAssertion.assertAll();
	}

	public void deleteAllSites() throws Throwable {
		List<WebElement> allElements = driver.findElements(deleteSites);
		for (WebElement element : allElements) {
			click((By) element);
			click(okBtn);
			Thread.sleep(2000);
		}
	}

	public void validatePresenceAllUtilities() {
		SoftAssert softAssertion = new SoftAssert();
		boolean hhUtilityPresenceStatus = isElementPresent(filterByHHutility);
		softAssertion.assertTrue(hhUtilityPresenceStatus, "HH Utility is not displaying in 'Request a Quote' page.");
		boolean nhhUtilityPresenceStatus = isElementPresent(filterByNHHutility);
		softAssertion.assertTrue(nhhUtilityPresenceStatus, "NHH Utility is not displaying in 'Request a Quote' page.");
		boolean gasUtilityPresenceStatus = isElementPresent(filterByGasUtility);
		softAssertion.assertTrue(nhhUtilityPresenceStatus, "Gas Utility is not displaying in 'Request a Quote' page.");
		boolean waterUtilityPresenceStatus = isElementPresent(filterByWaterUtility);
		softAssertion.assertTrue(waterUtilityPresenceStatus,
				"Water Utility is not displaying in 'Request a Quote' page.");
		softAssertion.assertAll();
	}

	public void validateContractDurationValuesForAllUtilities() {
		SoftAssert softAssertion = new SoftAssert();
		click(filterByHHutility);
		boolean contractEndDate6monthsPresenceStatusHHUtility = isElementExistInDropDown(contractDurationHHutility,
				"6 months");
		softAssertion.assertTrue(contractEndDate6monthsPresenceStatusHHUtility,
				"6 months is not displaying in contract end date dropdown for HH Utility");
		boolean contractEndDate12monthsPresenceStatusHHUtility = isElementExistInDropDown(contractDurationHHutility,
				"12 months");
		softAssertion.assertTrue(contractEndDate12monthsPresenceStatusHHUtility,
				"12 months is not displaying in contract end date dropdown for HH Utility");
		boolean contractEndDate18monthsPresenceStatusHHUtility = isElementExistInDropDown(contractDurationHHutility,
				"18 months");
		softAssertion.assertTrue(contractEndDate18monthsPresenceStatusHHUtility,
				"18 months is not displaying in contract end date dropdown for HH Utility");
		boolean contractEndDate24monthsPresenceStatusHHUtility = isElementExistInDropDown(contractDurationHHutility,
				"24 months");
		softAssertion.assertTrue(contractEndDate24monthsPresenceStatusHHUtility,
				"24 months is not displaying in contract end date dropdown for HH Utility");
		boolean contractEndDate30monthsPresenceStatusHHUtility = isElementExistInDropDown(contractDurationHHutility,
				"30 months");
		softAssertion.assertTrue(contractEndDate30monthsPresenceStatusHHUtility,
				"30 months is not displaying in contract end date dropdown for HH Utility");
		boolean contractEndDate36monthsPresenceStatusHHUtility = isElementExistInDropDown(contractDurationHHutility,
				"36 months");
		softAssertion.assertTrue(contractEndDate36monthsPresenceStatusHHUtility,
				"36 months is not displaying in contract end date dropdown for HH Utility");
		boolean contractEndDate60monthsPresenceStatusHHUtility = isElementExistInDropDown(contractDurationHHutility,
				"60 months");
		softAssertion.assertTrue(contractEndDate60monthsPresenceStatusHHUtility,
				"60 months is not displaying in contract end date dropdown for HH Utility");
		click(filterByNHHutility);
		boolean contractEndDate6monthsPresenceStatusNHHUtility = isElementExistInDropDown(contractDurationNHHutility,
				"6 months");
		softAssertion.assertTrue(contractEndDate6monthsPresenceStatusNHHUtility,
				"6 months is not displaying in contract end date dropdown for NHH Utility");
		boolean contractEndDate12monthsPresenceStatusNHHUtility = isElementExistInDropDown(contractDurationNHHutility,
				"12 months");
		softAssertion.assertTrue(contractEndDate12monthsPresenceStatusNHHUtility,
				"12 months is not displaying in contract end date dropdown for NHH Utility");
		boolean contractEndDate18monthsPresenceStatusNHHUtility = isElementExistInDropDown(contractDurationNHHutility,
				"18 months");
		softAssertion.assertTrue(contractEndDate18monthsPresenceStatusNHHUtility,
				"18 months is not displaying in contract end date dropdown for NHH Utility");
		boolean contractEndDate24monthsPresenceStatusNHHUtility = isElementExistInDropDown(contractDurationNHHutility,
				"24 months");
		softAssertion.assertTrue(contractEndDate24monthsPresenceStatusNHHUtility,
				"24 months is not displaying in contract end date dropdown for NHH Utility");
		boolean contractEndDate30monthsPresenceStatusNHHUtility = isElementExistInDropDown(contractDurationNHHutility,
				"30 months");
		softAssertion.assertTrue(contractEndDate30monthsPresenceStatusNHHUtility,
				"30 months is not displaying in contract end date dropdown for NHH Utility");
		boolean contractEndDate36monthsPresenceStatusNHHUtility = isElementExistInDropDown(contractDurationNHHutility,
				"36 months");
		softAssertion.assertTrue(contractEndDate36monthsPresenceStatusNHHUtility,
				"36 months is not displaying in contract end date dropdown for NHH Utility");
		boolean contractEndDate60monthsPresenceStatusNHHUtility = isElementExistInDropDown(contractDurationNHHutility,
				"60 months");
		softAssertion.assertTrue(contractEndDate60monthsPresenceStatusNHHUtility,
				"60 months is not displaying in contract end date dropdown for NHH Utility");

		click(filterByGasUtility);
		boolean contractEndDate6monthsPresenceStatusGasUtility = isElementExistInDropDown(contractDurationGasUtility,
				"6 months");
		softAssertion.assertTrue(contractEndDate6monthsPresenceStatusGasUtility,
				"6 months is not displaying in contract end date dropdown for Gas Utility");
		boolean contractEndDate12monthsPresenceStatusGasUtility = isElementExistInDropDown(contractDurationGasUtility,
				"12 months");
		softAssertion.assertTrue(contractEndDate12monthsPresenceStatusGasUtility,
				"12 months is not displaying in contract end date dropdown for Gas Utility");
		boolean contractEndDate18monthsPresenceStatusGasUtility = isElementExistInDropDown(contractDurationGasUtility,
				"18 months");
		softAssertion.assertTrue(contractEndDate18monthsPresenceStatusGasUtility,
				"18 months is not displaying in contract end date dropdown for Gas Utility");
		boolean contractEndDate24monthsPresenceStatusGasUtility = isElementExistInDropDown(contractDurationGasUtility,
				"24 months");
		softAssertion.assertTrue(contractEndDate24monthsPresenceStatusGasUtility,
				"24 months is not displaying in contract end date dropdown for Gas Utility");
		boolean contractEndDate30monthsPresenceStatusGasUtility = isElementExistInDropDown(contractDurationGasUtility,
				"30 months");
		softAssertion.assertTrue(contractEndDate30monthsPresenceStatusGasUtility,
				"30 months is not displaying in contract end date dropdown for Gas Utility");
		boolean contractEndDate36monthsPresenceStatusGasUtility = isElementExistInDropDown(contractDurationGasUtility,
				"36 months");
		softAssertion.assertTrue(contractEndDate36monthsPresenceStatusGasUtility,
				"36 months is not displaying in contract end date dropdown for Gas Utility");
		boolean contractEndDate60monthsPresenceStatusGasUtility = isElementExistInDropDown(contractDurationGasUtility,
				"60 months");
		softAssertion.assertTrue(contractEndDate60monthsPresenceStatusGasUtility,
				"60 months is not displaying in contract end date dropdown for Gas Utility");
		click(filterByWaterUtility);
		/*
		 * boolean contractEndDate6monthsPresenceStatusWaterUtility =
		 * isElementExistInDropDown(contractDurationWaterUtility, "6 months");
		 * softAssertion.assertFalse( contractEndDate6monthsPresenceStatusWaterUtility,
		 * "6 months is displaying in contract end date dropdown for Water Utility" );
		 * Reporter.log(
		 * "Checked if 6 months is displaying in contract end date dropdown for Water Utility"
		 * , true);
		 */
		boolean contractEndDate12monthsPresenceStatusWaterUtility = isElementExistInDropDown(
				contractDurationWaterUtility, "12 months");
		softAssertion.assertTrue(contractEndDate12monthsPresenceStatusWaterUtility,
				"12 months is not displaying in contract end date dropdown for Water Utility");
		boolean contractEndDate18monthsPresenceStatusWaterUtility = isElementExistInDropDown(
				contractDurationWaterUtility, "18 months");
		softAssertion.assertTrue(contractEndDate18monthsPresenceStatusWaterUtility,
				"18 months is not displaying in contract end date dropdown for Water Utility");
		boolean contractEndDate24monthsPresenceStatusWaterUtility = isElementExistInDropDown(
				contractDurationWaterUtility, "24 months");
		softAssertion.assertTrue(contractEndDate24monthsPresenceStatusWaterUtility,
				"24 months is not displaying in contract end date dropdown for Water Utility");
		boolean contractEndDate30monthsPresenceStatusWaterUtility = isElementExistInDropDown(
				contractDurationWaterUtility, "30 months");
		softAssertion.assertTrue(contractEndDate30monthsPresenceStatusWaterUtility,
				"30 months is not displaying in contract end date dropdown for Water Utility");
		boolean contractEndDate36monthsPresenceStatusWaterUtility = isElementExistInDropDown(
				contractDurationWaterUtility, "36 months");
		softAssertion.assertTrue(contractEndDate36monthsPresenceStatusWaterUtility,
				"36 months is not displaying in contract end date dropdown for Water Utility");
		boolean contractEndDate60monthsPresenceStatusWaterUtility = isElementExistInDropDown(
				contractDurationWaterUtility, "60 months");
		softAssertion.assertTrue(contractEndDate60monthsPresenceStatusWaterUtility,
				"60 months is not displaying in contract end date dropdown for Water Utility");
		softAssertion.assertAll();
	}

	public void validatealertErrormessage_IfNotSelectedAndempty() {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		click(SelectAllChoosemeter);
		clearValue(tenderDateHH);
		click(SelectAllChooseSupplier);
		click(TopSubmit);
		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		softAssertion.assertAll();
	}

	public void validatealertErrormessagewhenOnlyOneMeterisSelected() {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		click(SelectAllChoosemeter);
		click(MeterFirstElement);
		clearValue(tenderDateHH);
		click(SelectAllChooseSupplier);
		click(TopSubmit);
		try {
			click(OkAlert);
		} catch (Exception e) {
		}
		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();
	}

	public void validatealertErrormessagewhenMoreThanOneMeterisSelected() {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		clearValue(tenderDateHH);
		click(SelectAllChooseSupplier);
		click(TopSubmit);
		try {
			click(OkAlert);
		} catch (Exception e) {

			e.printStackTrace();
		}

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();

	}

	public void validatealertErrormessagewhenOneContractDurationisSelected() {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		click(SelectAllChoosemeter);
		selectByIndex(ContractDuration, 01);
		clearValue(tenderDateHH);
		click(SelectAllChooseSupplier);
		click(TopSubmit);

		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();

	}

	public void validatealertErrormessagewhenMoreThanOneContractDurationisSelected() {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		click(SelectAllChoosemeter);
		selectByIndex(ContractDuration, 01);
		click(AddNewContractDuration);
		selectByIndex(ContractDuration2, 02);
		clearValue(tenderDateHH);
		click(SelectAllChooseSupplier);
		click(TopSubmit);

		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		softAssertion.assertAll();
	}

	public void validateAlertMessageWhen2ContractDurationsAreSame() {
		SoftAssert softAssertion = new SoftAssert();
		// click(SelectAllChoosemeter);
		selectByIndex(ContractDuration, 02);
		click(AddNewContractDuration);
		selectByIndex(ContractDuration2, 02);
		boolean errorMessageDisplayStatusForSelecting2SameContractDurations = getText(
				OkAlertTextwhen2sameContractDurationSected).contains("You have already selected that duration");
		softAssertion.assertTrue(errorMessageDisplayStatusForSelecting2SameContractDurations,
				"Error message is not displaying for selecting 2 same Contract Durations");
		softAssertion.assertAll();
		click(OkAlert2);
	}

	public void validatealertErrormessageAfterSelectingOneSuplier() {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		click(SelectAllChoosemeter);
		clearValue(tenderDateHH);
		click(TopSubmit);
		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");
		softAssertion.assertAll();
	}

	public void validatealertErrormessageAfterSelectingAllSuplier() {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		click(SelectAllChoosemeter);
		clearValue(tenderDateHH);
		click(TopSubmit);
		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");
		softAssertion.assertAll();
	}

	public void validatealertErrormessageAfterSelecting1meter1contractDuration() {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		click(SelectAllChoosemeter);
		click(MeterFirstElement);
		selectByIndex(ContractDuration, 02);
		clearValue(tenderDateHH);
		click(SelectAllChooseSupplier);
		click(TopSubmit);
		try {
			click(OkAlert2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		softAssertion.assertAll();
	}

	public void validatealertErrormessageAfterSelecting1meterMultiplecontractDuration() {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		click(SelectAllChoosemeter);
		click(MeterFirstElement);
		selectByIndex(ContractDuration, 02);
		click(AddNewContractDuration);
		selectByIndex(ContractDuration2, 03);
		click(AddNewContractDuration);
		selectByIndex(ContractDuration3, 04);
		click(AddNewContractDuration);
		selectByIndex(ContractDuration4, 05);
		click(SelectAllChooseSupplier);
		click(TopSubmit);

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		softAssertion.assertAll();
	}

	public void validatealertErrormessageAfterSelectingMultiplemeterMultiplecontractDuration() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		click(SelectAllChoosemeter);

		click(MeterFirstElement);
		click(MeterSecondElement);
		click(MeterThridElement);
		click(MeterFourthElement);

		selectByIndex(ContractDuration, 02);
		click(AddNewContractDuration);
		selectByIndex(ContractDuration2, 03);
		click(AddNewContractDuration);
		selectByIndex(ContractDuration3, 04);
		click(AddNewContractDuration);
		selectByIndex(ContractDuration4, 05);
		Thread.sleep(2000);
		click(SelectAllChooseSupplier);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(2000);
		click(TopSubmit);
		Thread.sleep(2000);

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		softAssertion.assertAll();
	}

	public void validatingErrorMessageAfterSelecting1contractDurationAndMultipleSuppliers() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		click(SelectAllChoosemeter);
		selectByIndex(ContractDuration, 02);
		click(SelectAllChooseSupplier);
		click(ThirdSupplier);
		click(FourthSupplier);
		click(FifthSupplier);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)");
		click(TopSubmit);
		Thread.sleep(2000);
		/*
		 * boolean errorMessageDisplyStatusForNotSelectingMeter = getText(message)
		 * .contains("Please select at least one meter for a quote request.");
		 * softAssertion.assertTrue(errorMessageDisplyStatusForNotSelectingMeter,
		 * "Error message is not displaying for not selecting any Meter.");
		 */
		softAssertion.assertAll();
	}

	public void validatingErrorMessageAfterSelectingMultiplecontractDurationAndSingleSupplier() {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_HHUtility();
		SelectingZeroMeters();
		SelectingMultipleContractDuration();
		SelectingSingleSupplier();
		ClickTopSubmitButton();
		boolean errorMessageDisplyStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		softAssertion.assertTrue(errorMessageDisplyStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any Meter.");
		softAssertion.assertAll();
	}

	public void validatingErrorMessageAfterSelectingsinglecontractDurationAndmultipleSupplier() {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_HHUtility();
		SelectingZeroMeters();
		SelectingSingleContractDuration();
		SelectingMultipleSupplier();
		ClickTopSubmitButton();
		/*
		 * boolean errorMessageDisplyStatusForNotSelectingMeter = getText(message)
		 * .contains("Please select at least one meter for a quote request.");
		 * softAssertion.assertTrue(errorMessageDisplyStatusForNotSelectingMeter,
		 * "Error message is not displaying for not selecting any Meter.");
		 */
		softAssertion.assertAll();

	}

	public void validatingAvailablityToVerfyAfterSelecting1Meter1Contract1Supplier() {
		SelectElectricity_HHUtility();
		SelectingSingleMeter();
		SelectingSingleContractDuration();
		SelectingSingleSupplier();
		ClickTopSubmitButton();
		// need to write further script to verify is it present at admin portal
	}

	public void validatingAvailablityToVerfyAfterSelectingMultipleMeter1Contract1Supplier() {
		SelectElectricity_HHUtility();
		SelectingMultipleMeter();
		SelectingSingleContractDuration();
		SelectingSingleSupplier();
		ClickTopSubmitButton();
		// need to write further script to verify is it present at admin portal
	}

	public void validatingAvailablityToVerfyAfterSelecting1MeterMultipleContract1Supplier() {
		SelectElectricity_HHUtility();
		SelectingSingleMeter();
		SelectingMultipleContractDuration();
		SelectingSingleSupplier();
		ClickTopSubmitButton();
		// need to write further script to verify is it present at admin portal
	}

	public void validatingAvailablityToVerfyAfterSelecting1Meter1ContractMultipleSupplier() {
		SelectElectricity_HHUtility();
		SelectingSingleMeter();
		SelectingSingleContractDuration();
		SelectingMultipleSupplier();
		ClickTopSubmitButton();
		// need to write further script to verify is it present at admin portal
	}

	public void validatingAvailablityToVerfyAfterSelectingMultipleMeterMultipleContract1Supplier() {
		SelectElectricity_HHUtility();
		SelectingMultipleMeter();
		SelectingMultipleContractDuration();
		SelectingSingleSupplier();
		ClickTopSubmitButton();
		// need to write further script to verify is it present at admin portal
	}

	public void validatingAvailablityToVerfyAfterSelectingMultipleMeter1ContractMultipleSupplier() {
		SelectElectricity_HHUtility();
		SelectingMultipleMeter();
		SelectingSingleContractDuration();
		SelectingMultipleSupplier();
		ClickTopSubmitButton();
		// need to write further script to verify is it present at admin portal
	}

	public void validatingAvailablityToVerfyAfterSelectingSingleMeterMultipleContractMultipleSupplier() {
		SelectElectricity_HHUtility();
		SelectingSingleMeter();
		SelectingMultipleContractDuration();
		SelectingMultipleSupplier();
		ClickTopSubmitButton();
		// need to write further script to verify is it present at admin portal
	}

	public void validatingAvailablityToVerfyAfterSelectingMultipleMeterMultipleContractMultipleSupplier() {
		SelectElectricity_HHUtility();
		SelectingMultipleMeter();
		SelectingMultipleContractDuration();
		SelectingMultipleSupplier();
		ClickTopSubmitButton();
		// need to write further script to verify is it present at admin portal
	}

	public void validatingAvailablityToVerfyAfterSelectingAllMeterAllContractAllSupplierAndRenewableEnergy() {
		SelectElectricity_HHUtility();
		ClickRenewableEnergy();
		SelectingMultipleContractDuration();
		ClickTopSubmitButton();

	}

	public void validatingErrorMessageAfterSelectingAllMeterAllContractAllSupplierAndSettingDate5daysBefore() {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_HHUtility();
		SelectingMultipleContractDuration();
		EnterDate("27/09/2019");
		ClickTopSubmitButton();

		boolean errorMessageDisplyStatusForEnteringwrongDate = getText(message)
				.contains("Tender date must be at least five days in the future");
		softAssertion.assertTrue(errorMessageDisplyStatusForEnteringwrongDate,
				"Error message is not displaying for Entring Wrong Date.");
		// Assert.assertEquals(actual, expected)
		softAssertion.assertAll();

	}

	public void validatingAvailablityToVerfyAfterSelectingAllMeterAllContractAllSupplierAndSettingDatetoFuture() {

		SelectElectricity_HHUtility();
		SelectingMultipleContractDuration();
		EnterDate("05/10/2019");
		ClickTopSubmitButton();
	}

	public void Options(String nHHMeter, String nHHContractD, String nHHSupplier) {
		switch (nHHMeter) {
		case "zero":
			selectingzerometers_nHH();
			break;
		case "single":
			selectingSinglemeters_nHH();
			break;
		case "multiple":
			selectingMultiplemeters_nHH();
			break;
		default:
			System.out.println("no match at nHHMeter");
		}
		switch (nHHContractD) {
		case "zero":
			click(contractDuration_nHH);
			click(contractDuration_nHH);
			break;
		case "multiple":
			selectingMultipleContractDur_nHH();
			break;
		case "single":
			selectingsingleContractDur_nHH();
			break;
		default:
			System.out.println("no match at nHHContractDuration");
		}
		switch (nHHSupplier) {
		case "zero":
			selectingzerosupplier_nHH();
			break;
		case "single":
			selectingSinglesupplier_nHH();
			break;
		case "multiple":
			selectingMultiplesupplier_nHH();
			break;
		default:
			System.out.println("no match at nHHSupplier");
		}
	}

	public void verifyAlertMessageWhenNometerNocontractnosupplierSelectedIn_nHHUtility() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_nHHUtility();
		Options("zero", "zero", "zero");
		ClickTopSubmitButton();

		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();
	}

	public void verifyAlertMessageWhen1meterNocontractnosupplierSelectedIn_nHHUtility() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_nHHUtility();
		Options("single", "zero", "zero");
		ClickTopSubmitButton();

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();
	}

	public void verifyAlertMessageWhenMultiplemeterNocontractnosupplierSelectedIn_nHHUtility() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_nHHUtility();
		Options("multiple", "zero", "zero");
		ClickTopSubmitButton();

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();
	}

	public void verifyAlertMessageWhenNometer1contractnosupplierSelectedIn_nHHUtility() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_nHHUtility();
		Options("zero", "single", "zero");
		ClickTopSubmitButton();

		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();
	}

	public void verifyAlertMessageWhen_Nometer_Multiplecontract_nosupplier_SelectedIn_nHHUtility() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_nHHUtility();
		Options("zero", "multiple", "zero");
		ClickTopSubmitButton();

		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();
	}

	public void verifyAlertmessageWhen2ContractDurations_selectsSameMonth_nHH() {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_nHHUtility();
		selectByIndex(contractDuration_nHH, 02);
		click(AddContractDuration_nHH);
		selectByIndex(contractDuration2_nHH, 02);

		boolean errorMessageDisplayStatusForSelecting2SameContractDurations = getText(
				OkAlertTextwhen2sameContractDurationSected).contains("You have already selected that duration");
		softAssertion.assertTrue(errorMessageDisplayStatusForSelecting2SameContractDurations,
				"Error message is not displaying for selecting 2 same contract durations.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();
	}

	public void VerifyErrorMessageWhenSelecting_zeroMeters_zeroContractDurations_OneSupplier_nHH() {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_nHHUtility();
		Options("zero", "zero", "single");
		ClickTopSubmitButton();

		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		softAssertion.assertAll();
	}

	public void VerifyErrorMessageWhenSelecting_zeroMeters_zeroContractDurations_MultipleSupplier_nHH() {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_nHHUtility();
		Options("zero", "zero", "single");
		ClickTopSubmitButton();

		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		softAssertion.assertAll();
	}

	public void VerifyErrorMessageWhenSelecting_SingleMeters_SingleContractDurations_ZeroSupplier_nHH() {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_nHHUtility();
		Options("single", "single", "zero");
		ClickTopSubmitButton();

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();
	}

	public void VerifyErrorMessageWhenSelecting_SingleMeters_MultipleContractDurations_ZeroSupplier_nHH() {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_nHHUtility();
		Options("single", "multiple", "zero");
		ClickTopSubmitButton();

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();
	}

	public void VerifyErrorMessageWhenSelecting_MultipleMeters_SingleContractDurations_ZeroSupplier_nHH() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_nHHUtility();
		Options("multiple", "single", "zero");
		Thread.sleep(1000);
		ClickTopSubmitButton();
		Thread.sleep(2000);
		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();
	}

	public void VerifyErrorMessageWhenSelecting_ZeroMeters_SingleContractDurations_SingleSupplier_nHH() {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_nHHUtility();
		Options("zero", "single", "single");
		ClickTopSubmitButton();

		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		softAssertion.assertAll();
	}

	public void VerifyErrorMessageWhenSelecting_ZeroMeters_MultipleContractDurations_SingleSupplier_nHH() {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_nHHUtility();
		Options("zero", "multiple", "single");
		ClickTopSubmitButton();

		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		softAssertion.assertAll();
	}

	public void VerifyErrorMessageWhenSelecting_ZeroMeters_SingleContractDurations_MultipleSupplier_nHH() {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_nHHUtility();
		Options("zero", "single", "multiple");
		ClickTopSubmitButton();

		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		softAssertion.assertAll();
	}

	public void ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_SingleMeters_SingleContractDurations_SingleSupplier_nHH() {

		SelectElectricity_nHHUtility();
		Options("single", "single", "single");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClickTopSubmitButton();

	}

	public void ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_MultipleMeters_SingleContractDurations_SingleSupplier_nHH() {

		SelectElectricity_nHHUtility();
		Options("multiple", "single", "single");
		ClickTopSubmitButton();

	}

	public void ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_SingleMeters_MultipleContractDurations_SingleSupplier_nHH() {

		SelectElectricity_nHHUtility();
		Options("single", "multiple", "single");
		ClickTopSubmitButton();

	}

	public void ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_SingleMeters_SingleContractDurations_MultipleSupplier_nHH() {

		SelectElectricity_nHHUtility();
		Options("single", "single", "multiple");
		ClickTopSubmitButton();

	}

	public void ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_MultipleMeters_MultipleContractDurations_SingleSupplier_nHH() {

		SelectElectricity_nHHUtility();
		Options("multiple", "multiple", "single");
		ClickTopSubmitButton();

	}

	public void ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_MultipleMeters_SingleContractDurations_MultipleSupplier_nHH() {

		SelectElectricity_nHHUtility();
		Options("multiple", "single", "multiple");
		ClickTopSubmitButton();

	}

	public void ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_SingleMeters_MultipleContractDurations_MultipleSupplier_nHH() {

		SelectElectricity_nHHUtility();
		Options("single", "multiple", "multiple");
		ClickTopSubmitButton();

	}

	public void ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_MultipleMeters_MultipleContractDurations_MultipleSupplier_nHH() {

		SelectElectricity_nHHUtility();
		Options("multiple", "multiple", "multiple");
		ClickTopSubmitButton();

	}

	public void ValidatePresenceOfReqQuoteAtAdminPortalWhenSelecting_MultipleMeters_MultipleContractDurations_MultipleSupplier_ClcikRenewableEnergy_nHH()
			throws Throwable {

		SelectElectricity_nHHUtility();
		Options("multiple", "multiple", "multiple");
		CkiclingRenewableEnergy_nHH();
		Thread.sleep(5000);
		ClickTopSubmitButton();

	}

	public void validatingErrorMessageAfterSelectingAllMeterAllContractAllSupplierAndSettingDate5daysBefore_nHH()
			throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_nHHUtility();
		Options("multiple", "multiple", "multiple");
		click(date_nHH);
		selectPrevDateCalender(27, 8, 2019);
		Thread.sleep(10000);
		ClickTopSubmitButton();

		boolean errorMessageDisplyStatusForEnteringwrongDate = getText(message)
				.contains("Tender date must be at least five days in the future");
		softAssertion.assertTrue(errorMessageDisplyStatusForEnteringwrongDate,
				"Error message is not displaying for Entring Wrong Date.");
		// Assert.assertEquals(actual, expected)
		softAssertion.assertAll();

	}

	public void validatingErrorMessageAfterSelectingAllMeterAllContractAllSupplierAndSettingfutureDate_nHH()
			throws Throwable {

		SelectElectricity_nHHUtility();
		Options("multiple", "multiple", "multiple");
		click(date_nHH);
		selectPrevDateCalender(10, 9, 2019);
		Thread.sleep(10000);
		ClickTopSubmitButton();
		Thread.sleep(10000);

	}

	public void verifyErrorMessaegeWhenSelecting_ZeroMeter_ZeroContractDur_ZeroSupplier_Gas() {
		SoftAssert softAssertion = new SoftAssert();
		clickGasUtility();
		Options_Gas("zero", "zero", "zero");
		ClickTopSubmitButton();

		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();
	}

	public void softassertfor_(String text, String text1, String text2) {

		switch (text) {
		case "meter":
			SoftAssert softAssertion = new SoftAssert();
			boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
					.contains("Please select at least one meter for a quote request.");
			softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
					"Error message is not displaying for not selecting any meter.");
			softAssertion.assertAll();
			break;
		case "null":
			System.out.print("");

			break;
		default:
			System.out.println("please enter correct name ie :meter");
			break;
		}

		switch (text1) {
		case "contract":
			SoftAssert softAssertion = new SoftAssert();
			boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
					.contains("Please select contract duration");
			softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
					"Error message is not displaying for not entering contract duration.");
			softAssertion.assertAll();

			break;

		case "null":
			System.out.print("");
			break;
		default:
			System.out.println("please enter correct name ie :contract");
			break;
		}
		switch (text2) {
		case "supplier":
			SoftAssert softAssertion = new SoftAssert();
			boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
					.contains("Please select at least one supplier for a quote request.");
			// Reporter.log("Checked if error message for not selecting any supplier is
			// displaying.", true);
			softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
					"Error message is not displaying for not selecting any supplier.");
			softAssertion.assertAll();
			break;
		case "null":
			System.out.print("");
			break;
		default:
			System.out.println("please enter correct name ie :supplier");
			break;

		}
	}

	public void verifyErrorMessaegeWhenSelecting_SingleMeter_ZeroContractDur_ZeroSupplier_Gas() {
		SoftAssert softAssertion = new SoftAssert();
		clickGasUtility();
		Options_Gas("single", "zero", "zero");
		ClickTopSubmitButton();

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		// Reporter.log("Checked if error message for not selecting contract duration is
		// displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		// Reporter.log("Checked if error message for not selecting any supplier is
		// displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();
	}

	public void verifyErrorMessaegeWhenSelecting_MultipleMeter_ZeroContractDur_ZeroSupplier_Gas() {

		clickGasUtility();
		Options_Gas("multiple", "zero", "zero");
		ClickTopSubmitButton();

		softassertfor_("null", "contract", "supplier");

	}

	public void verifyErrorMessaegeWhenSelecting_ZeroMeter_SingleContractDur_ZeroSupplier_Gas() {

		clickGasUtility();
		Options_Gas("zero", "single", "zero");
		ClickTopSubmitButton();

		softassertfor_("meter", "null", "supplier");

	}

	public void verifyErrorMessaegeWhenSelecting_ZeroMeter_MultipleContractDur_ZeroSupplier_Gas() {

		clickGasUtility();
		Options_Gas("zero", "multiple", "zero");
		ClickTopSubmitButton();

		softassertfor_("meter", "null", "supplier");

	}

	public void verifyAlertmessageWhen2ContractDurations_selectsSameMonth_Gas() {
		SoftAssert softAssertion = new SoftAssert();
		clickGasUtility();
		selectByIndex(firstContractDuration_Gas, 02);
		// Reporter.log("Selected First Contract Duration.", true);
		click(addNewContractDuration_Gas);
		// Reporter.log("Clicked on add contract Duration", true);
		selectByIndex(secondContractDuration_Gas, 02);
		// Reporter.log("Selected second Contract Duration.", true);

		boolean errorMessageDisplayStatusForSelecting2SameContractDurations = getText(
				OkAlertTextwhen2sameContractDurationSected).contains("You have already selected that duration");
		// Reporter.log("Checked if error message for Selecting 2 same Contract
		// Durations is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForSelecting2SameContractDurations,
				"Error message is not displaying for selecting 2 same contract durations.");

		softAssertion.assertAll();
	}

	public void verifyErrorMessaegeWhenSelecting_ZeroMeter_ZeroContractDur_SingleSupplier_Gas() {

		clickGasUtility();
		Options_Gas("zero", "zero", "single");
		ClickTopSubmitButton();

		softassertfor_("meter", "contract", "null");

	}

	public void verifyErrorMessaegeWhenSelecting_ZeroMeter_ZeroContractDur_MultipleSupplier_Gas() {

		clickGasUtility();
		Options_Gas("zero", "zero", "multiple");
		ClickTopSubmitButton();

		softassertfor_("meter", "contract", "null");

	}

	public void verifyErrorMessaegeWhenSelecting_SingleMeter_SingleContractDur_ZeroSupplier_Gas() {

		clickGasUtility();
		Options_Gas("single", "single", "zero");
		ClickTopSubmitButton();

		softassertfor_("null", "null", "supplier");

	}

	public void verifyErrorMessaegeWhenSelecting_SingleMeter_MultipleContractDur_ZeroSupplier_Gas() {

		clickGasUtility();
		Options_Gas("single", "multiple", "zero");
		ClickTopSubmitButton();

		softassertfor_("null", "null", "supplier");

	}

	public void verifyErrorMessaegeWhenSelecting_MultipleMeter_SingleContractDur_ZeroSupplier_Gas() throws Throwable {

		clickGasUtility();
		Options_Gas("multiple", "single", "zero");
		Thread.sleep(10000);
		ClickTopSubmitButton();

		softassertfor_("null", "null", "supplier");

	}

	public void verifyErrorMessaegeWhenSelecting_ZeroMeter_SingleContractDur_SingleSupplier_Gas() {

		clickGasUtility();
		Options_Gas("zero", "single", "single");

		ClickTopSubmitButton();

		softassertfor_("meter", "null", "null");

	}

	public void verifyErrorMessaegeWhenSelecting_ZeroMeter_MultipleContractDur_SingleSupplier_Gas() {

		clickGasUtility();
		Options_Gas("zero", "multiple", "single");

		ClickTopSubmitButton();

		softassertfor_("meter", "null", "null");

	}

	public void verifyErrorMessaegeWhenSelecting_ZeroMeter_SingleContractDur_MultipleSupplier_Gas() {

		clickGasUtility();
		Options_Gas("zero", "single", "multiple");

		ClickTopSubmitButton();

		softassertfor_("meter", "null", "null");

	}

	public void verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_SingleMeter_SingleContractDur_SingleSupplier_Gas() {

		clickGasUtility();
		Options_Gas("single", "single", "single");
		ClickTopSubmitButton();
	}

	public void verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_MultipleMeter_SingleContractDur_SingleSupplier_Gas() {

		clickGasUtility();
		Options_Gas("multiple", "single", "single");
		ClickTopSubmitButton();
	}

	public void verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_SingleMeter_MultipleContractDur_SingleSupplier_Gas() {

		clickGasUtility();
		Options_Gas("single", "multiple", "single");
		ClickTopSubmitButton();
	}

	public void verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_SingleMeter_SingleContractDur_MultipleSupplier_Gas() {

		clickGasUtility();
		Options_Gas("single", "single", "multiple");
		ClickTopSubmitButton();
	}

	public void verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_MultipleMeter_MultipleContractDur_SingleSupplier_Gas() {

		clickGasUtility();
		Options_Gas("multiple", "multiple", "single");
		ClickTopSubmitButton();
	}

	public void verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_MultipleMeter_SingleContractDur_MultipleSupplier_Gas() {

		clickGasUtility();
		Options_Gas("multiple", "single", "multiple");
		ClickTopSubmitButton();
	}

	public void verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_SingleMeter_MultipleContractDur_MultipleSupplier_Gas() {

		clickGasUtility();
		Options_Gas("single", "multiple", "multiple");
		ClickTopSubmitButton();
	}

	public void verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_MultipleMeter_MultipleContractDur_MultipleSupplier_Gas() {

		clickGasUtility();
		Options_Gas("multiple", "multiple", "multiple");
		ClickTopSubmitButton();
	}

	public void verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_MultipleMeter_MultipleContractDur_MultipleSupplier_RenewableEnergy_Gas()
			throws Throwable {

		clickGasUtility();
		Options_Gas("multiple", "multiple", "multiple");
		Thread.sleep(5000);
		ClickrenewableEnergy_Gas();
		Thread.sleep(5000);
		ClickTopSubmitButton();
	}

	public void verifyAlertMessageWhenSelecting_5previousDateToCurrentDate_Gas() {
		SoftAssert softAssertion = new SoftAssert();
		clickGasUtility();
		Options_Gas("multiple", "multiple", "multiple");
		ClickDate_Gas();
		selectPrevDateCalender(28, 8, 2019);
		ClickTopSubmitButton();

		boolean errorMessageDisplyStatusForEnteringwrongDate = getText(message)
				.contains("Tender date must be at least five days in the future");
		// Reporter.log("Checked if error message for Entering wrong Date is
		// displaying.", true);
		softAssertion.assertTrue(errorMessageDisplyStatusForEnteringwrongDate,
				"Error message is not displaying for Entring Wrong Date.");
		// Assert.assertEquals(actual, expected)
		softAssertion.assertAll();

	}

	public void verifyAlertMessageWhenSelecting_FutureDateToCurrentDate_Gas() {

		clickGasUtility();
		Options_Gas("multiple", "multiple", "multiple");
		ClickDate_Gas();
		selectPrevDateCalender(12, 9, 2019);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClickTopSubmitButton();
	}

	public void verifyAlertMessageWhen_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water(
			String NoOfMeter, String NoOfContractDur, String NoOfSupplier) {
		clickWaterUtility();
		String Meter = "meter";
		String ContractDuration = "contract";
		String Supplier = "supplier";
		if (NoOfMeter != "zero") {
			Meter = "null";
		}
		if (NoOfContractDur != "zero") {
			ContractDuration = "null";
		}
		if (NoOfSupplier != "zero") {
			Supplier = "null";
		}
		Options_Water(NoOfMeter, NoOfContractDur, NoOfSupplier);
		ClickTopSubmitButton();

		softassertfor_(Meter, ContractDuration, Supplier);

	}

	public void verifyAlertMessageWhenSelected_SameContractDuration_Water() {
		SoftAssert softAssertion = new SoftAssert();
		clickWaterUtility();
		selectByIndex(firstContractDuration_Water, 02);
		// Reporter.log("Selected First Contract Duration.", true);
		click(addNewContractDuration_Water);
		// Reporter.log("Clicked on add contract Duration", true);
		selectByIndex(secondContractDuration_Water, 02);
		// Reporter.log("Selected second Contract Duration.", true);

		boolean errorMessageDisplayStatusForSelecting2SameContractDurations = getText(
				OkAlertTextwhen2sameContractDurationSected).contains("You have already selected that duration");
		// Reporter.log("Checked if error message for Selecting 2 same Contract
		// Durations is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForSelecting2SameContractDurations,
				"Error message is not displaying for selecting 2 same contract durations.");
		softAssertion.assertAll();

	}

	public void verifyPresenceOfReqQouteAtAdminPortalAfter_Selecting_DifferentCombinations_Of_Meter_ContractDuration_Supplier_Water(
			String NoOfMeter, String NoOfContractDur, String NoOfSupplier) {
		clickWaterUtility();
		Options_Water(NoOfMeter, NoOfContractDur, NoOfSupplier);
		ClickTopSubmitButton();

	}

	public void verifyAlertMesage_After_Selecting_DifferentCombinations_Of_Meter_ContractDuration_AndpreviousDate_Supplier_Water(
			String NoOfMeter, String NoOfContractDur, String NoOfSupplier) {
		SoftAssert softAssertion = new SoftAssert();
		clickWaterUtility();
		ClickDate_Water();
		selectPrevDateCalender(05, 9, 2019);
		Options_Water(NoOfMeter, NoOfContractDur, NoOfSupplier);
		ClickTopSubmitButton();

		boolean errorMessageDisplyStatusForEnteringwrongDate = getText(message)
				.contains("Tender date must be at least five days in the future");
		// Reporter.log("Checked if error message for Entering wrong Date is
		// displaying.", true);
		softAssertion.assertTrue(errorMessageDisplyStatusForEnteringwrongDate,
				"Error message is not displaying for Entring Wrong Date.");
		// Assert.assertEquals(actual, expected)
		softAssertion.assertAll();
	}

	public void verifyAlertMesage_After_Selecting_DifferentCombinations_Of_Meter_ContractDuration_AndFutureDate_Supplier_Water(
			String NoOfMeter, String NoOfContractDur, String NoOfSupplier) {
		clickWaterUtility();
		ClickDate_Water();
		selectPrevDateCalender(15, 9, 2019);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Options_Water(NoOfMeter, NoOfContractDur, NoOfSupplier);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClickTopSubmitButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void verifyAlertmessageWhen2ContractDurations_selectsSameMonth_Water() {
		SoftAssert softAssertion = new SoftAssert();
		clickWaterUtility();
		selectByIndex(firstContractDuration_Water, 02);
		// Reporter.log("Selected First Contract Duration.", true);
		click(addNewContractDuration_Water);
		// Reporter.log("Clicked on add contract Duration", true);
		selectByIndex(secondContractDuration_Water, 02);
		// Reporter.log("Selected second Contract Duration.", true);

		boolean errorMessageDisplayStatusForSelecting2SameContractDurations = getText(
				OkAlertTextwhen2sameContractDurationSected).contains("You have already selected that duration");
		// Reporter.log("Checked if error message for Selecting 2 same Contract
		// Durations is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForSelecting2SameContractDurations,
				"Error message is not displaying for selecting 2 same contract durations.");

		softAssertion.assertAll();
	}

	public void verifyTheElemtsareCheckedOrNot() {
		// driver.findElements(By.xpath("//div[@id='request-water-quote']//section[@id='suppliers']//ul[@class='check-list']//li"))
		clickWaterUtility();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// selectingzerosupplier_Water();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		numberOfCheckListPresent(numberOfSuppliers);

	}

	public void validateSelectAllSupplierCheckboxWhenUnChecked() {
		click(filterByHHutility);
		// Reporter.log("Clicked on filter for HH Utility", true);
		click(SelectAllChooseSupplier);
		// Reporter.log("Clicked on select all option for HH utility.", true);
		List<WebElement> allElements = driver.findElements(listOfHHsupplierCheckbox);
		boolean status = false;
		for (WebElement element : allElements) {
			if (element.isSelected() == false) {
				System.out.println(element);
				status = true;
			} else {
				status = false;
				Assert.assertTrue(status, "All checkbox are not unchecked.");
			}
		}
		Assert.assertTrue(status, "All checkbox are unchecked");
	}

	public void validateSelectAllSupplierCheckboxWhenChecked() {
		click(filterByHHutility);
		// Reporter.log("Clicked on filter for HH Utility", true);
		click(SelectAllChooseSupplier);
		// Reporter.log("Clicked on select all option for HH utility.", true);
		List<WebElement> allElements = driver.findElements(listOfHHsupplierCheckbox);
		boolean status = false;
		for (WebElement element : allElements) {
			if (element.isSelected() == false) {
				System.out.println(element);
				status = true;
			} else {
				status = false;
				Assert.assertTrue(status, "All checkbox are not unchecked.");
			}
		}
		Assert.assertTrue(status, "All checkbox are unchecked");
	}

	public void validateCheckboxClickableTest() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		click(filterByHHutility);
		// Reporter.log("Clicked on filter for HH Utility", true);
		click(SelectAllChooseSupplier);
		// Reporter.log("Clicked on select all option for HH utility.", true);
		click(FirstSupplier);
		// Reporter.log("Clicked the checkbox for British gas business.", true);
		Thread.sleep(1000);
		boolean checkboxCheckedstatusforBritishGasBusiness = driver.findElement(FirstSupplier).isSelected();
		softAssertion.assertFalse(checkboxCheckedstatusforBritishGasBusiness,
				"Checkbox is unchecked for British Gas Business.");
		click(ThirdSupplier);
		boolean checkboxCheckedstatusForCoronaEnergy = driver.findElement(ThirdSupplier).isSelected();
		softAssertion.assertFalse(checkboxCheckedstatusForCoronaEnergy, "Checkbox is unchecked for Corona Energy.");
		// FourthSupplier
		softAssertion.assertAll();
	}

	public void validateTenderSummaryPageDisplay() throws Throwable {
		SelectingSingleMeter();
		SelectingSingleContractDuration();
		SelectingSingleSupplier();
		ClickTopSubmitButton();
		Thread.sleep(3000);
		boolean verifyTenderRequestSummaryURL = driver.getCurrentUrl().contains("RequestQuoteSubmit");
		Assert.assertTrue(verifyTenderRequestSummaryURL, "Incorrect URL is displaying.");
	}

	public void validateEditCompanyProfileOption() throws Throwable {
		SelectingSingleMeter();
		SelectingSingleContractDuration();
		SelectingSingleSupplier();
		ClickTopSubmitButton();
		Thread.sleep(3000);
		click(editCompanyDetailsTenderSummaryPage);
		Thread.sleep(2000);
		boolean verifyCompanyProfileURL = driver.getCurrentUrl().contains("CompanyProfile");
		Assert.assertTrue(verifyCompanyProfileURL, "Incorrect URL is displaying.");
	}

	public void validateEditAdditionalReqOptionTenderSummaryPage() throws Throwable {
		SelectingSingleMeter();
		SelectingSingleContractDuration();
		SelectingSingleSupplier();
		ClickTopSubmitButton();
		Thread.sleep(3000);
		click(editAdditionalReqTenderSummaryPage);
		Thread.sleep(2000);
		boolean verifyCompanyProfileURL = driver.getCurrentUrl().contains("CompanyProfile");
		Assert.assertTrue(verifyCompanyProfileURL, "Incorrect URL is displaying.");
	}

	public void validateEditQuoteOptionTenderSummaryPage() throws Throwable {
		SelectingSingleMeter();
		SelectingSingleContractDuration();
		SelectingSingleSupplier();
		ClickTopSubmitButton();
		Thread.sleep(3000);
		click(editMeterDetailsTenderSummaryPage);
		Thread.sleep(2000);
		boolean verifyEditRequestQuoteURL = driver.getCurrentUrl().contains("Quote/EditRequestQuote");
		Assert.assertTrue(verifyEditRequestQuoteURL, "Incorrect URL is displaying.");
	}

	public void verifySupplierSelectionInTenderSummaryPage() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// navigateToCompanyProfile();
		/*
		 * fillCompanyProfile(); Thread.sleep(1000); click(propertyPortfolio);
		 * Thread.sleep(2000); addSite(); Thread.sleep(2000); String mpanNum =
		 * addValidHHmeterGeneric(); addContractHistory(); try { click(okBtn); } catch
		 * (Exception e) { e.printStackTrace(); } Reporter.log("Closed tip message",
		 * true); Thread.sleep(2000); click(quotesAndTenders); Thread.sleep(1000);
		 * click(requestAQuoteLink); Reporter.log("Clicked on request a quote link",
		 * true);
		 */
		String companyName = "AGB3";
		scrollToElement(checkboxForMeter("1012703797008"));// need to be replaced by mpanNum
		selectingSingleMeterModified("1012703797008");// need to be replaced by mpanNum
		jse.executeScript("window.scrollBy(0,-500)");
		SelectingSingleContractDuration();
		click(tenderDateHH);
		Thread.sleep(1000);
		String tenderDate = "12/11/2019";
		selectFutureDateCalender(12, 10, 2019);
		SelectingMultipleSupplier();
		Reporter.log("Selected suppliers.", true);
		String firstSelectedSupplierName = getText(FirstSupplier);
		String secondSelectedSupplierName = getText(ThirdSupplier);
		String fourthSelectedSupplierName = getText(FifthSupplier);

		ClickTopSubmitButton();
		Reporter.log("Clicked on submit button", true);
		Thread.sleep(3000);
		scrollToElement(invitedSuppliersHeading_TenderSummaryPage);
		boolean firstSupplierPresenceStatus = isElementExistInList(invitedSuppliers_TenderSummaryPage,
				firstSelectedSupplierName);
		softAssertion.assertTrue(firstSupplierPresenceStatus, "Selected supplier is not displaying.");

		boolean secondSupplierPresenceStatus = isElementExistInList(invitedSuppliers_TenderSummaryPage,
				secondSelectedSupplierName);
		softAssertion.assertTrue(secondSupplierPresenceStatus, "Selected supplier is not displaying.");

		boolean fourthSupplierPresenceStatus = isElementExistInList(invitedSuppliers_TenderSummaryPage,
				fourthSelectedSupplierName);
		softAssertion.assertTrue(fourthSupplierPresenceStatus, "Selected supplier is not displaying.");
		scrollToElement(confirmAndSubmit);
		click(confirmAndSubmit);
		Reporter.log("Clicked on confirm and submit button.", true);
		Thread.sleep(2000);
		boolean tenderSubmitSuccessPopupDisplayStatus = isElementPresent(quoteSubmitSuccessPopup);
		softAssertion.assertTrue(tenderSubmitSuccessPopupDisplayStatus,
				"Tender Submit Success Popup is not displaying.");
		click(okBtn_TenderSummaryPage);
		Reporter.log("Clicked on Ok button.", true);
		logout();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(getPropertyFileData("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginAsAdmin();
		/*
		 * click(verifyTenders); boolean verifyTendersDisplayStatus =
		 * driver.getCurrentUrl().contains("/VerifyTenders");
		 * Reporter.log("Checked if verify tenders page is displaying.", true);
		 * softAssertion.assertTrue(verifyTendersDisplayStatus,
		 * "Verify Tenders page is not displaying.");//VT_TC_003
		 * verifyUtilityFilterPresenceVerifyTenders();//VT_TC_004
		 * Reporter.log("Checked presence of filters.", true); click(allowSelectedBtn);
		 * boolean alertPopupDisplayStatus =
		 * isElementPresent(alertPopUpForNoSupplierSelection);
		 * softAssertion.assertTrue(alertPopupDisplayStatus,
		 * "Alert popup is not displaying");//VT_TC_007 click(okBtn);
		 * Reporter.log("Clicked on Ok button", true); Thread.sleep(1000);
		 * click(blockSelectedBtn); Reporter.log("Clicked on Block selected button",
		 * true); alertPopupDisplayStatus =
		 * isElementPresent(alertPopUpForNoSupplierSelection);
		 * Reporter.log("Checked if the alert message is displaying.", true);
		 * softAssertion.assertTrue(alertPopupDisplayStatus,
		 * "Alert popup is not displaying");//VT_TC_008 click(okBtn);
		 * Reporter.log("Clicked on Ok button", true); Thread.sleep(1000);
		 * scrollToElement(findQuote(companyName)); boolean downloadTenderPresenceStatus
		 * = isElementPresent(downloadTenderDetailsButton(companyName));
		 * softAssertion.assertTrue(downloadTenderPresenceStatus,
		 * "Download tender button is not displaying.");//VT_TC_005 boolean
		 * supplier1PresenceStatus =
		 * isElementExistInList(suppliersListForQuote(companyName),
		 * firstSelectedSupplierName); boolean supplier2PresenceStatus =
		 * isElementExistInList(suppliersListForQuote(companyName),
		 * secondSelectedSupplierName); boolean supplier4PresenceStatus =
		 * isElementExistInList(suppliersListForQuote(companyName),
		 * fourthSelectedSupplierName); boolean allSuppliersDisplayStatus =
		 * supplier1PresenceStatus && supplier2PresenceStatus &&
		 * supplier4PresenceStatus; softAssertion.assertTrue(allSuppliersDisplayStatus,
		 * "All suppliers are not dispaying for the quote in verify tenders.");//
		 * VT_TC_006 boolean allCheckBoxSuppliersListEnabledStatus =
		 * checkboxListEnabledStatus(checkboxAllSupplierList(companyName)); Reporter.
		 * log("Checked if all the checkbox for the suppliers are enabled in suppliers list."
		 * , true); softAssertion.assertTrue(allCheckBoxSuppliersListEnabledStatus,
		 * "All checkbox for the suppliers are not enabled in suppliers list for the quote."
		 * );//VT_TC_009 boolean allCheckBoxMatrixPriceListEnabledStatus =
		 * checkboxListEnabledStatus(checkboxMatrixPriceList(companyName)); Reporter.
		 * log("Checked if all the checkbox for the suppliers are enabled in matrix price list."
		 * , true); softAssertion.assertTrue(allCheckBoxMatrixPriceListEnabledStatus,
		 * "All checkbox for the suppliers are not enabled in matrix price list for the quote."
		 * );//VT_TC_012 //block supplier
		 * 
		 * click(checkboxSupplier(companyName, secondSelectedSupplierName));
		 * Reporter.log("Clicked on the checkbox for the supplier.", true);
		 * //JavascriptExecutor jse = (JavascriptExecutor)driver;
		 * jse.executeScript("window.scrollBy(0,-2000)");
		 * //scrollToElement(blockSelectedBtn); click(blockSelectedBtn);
		 * Reporter.log("Clicked on block selected button.", true); Thread.sleep(2000);
		 * scrollToElement(findQuote(companyName)); boolean
		 * supplierPresenceInListStatusAfterBlock =
		 * isElementExistInList(suppliersListForQuote(companyName),
		 * firstSelectedSupplierName);
		 * Reporter.log("Checked if supplier name is displaying after blocking it.",
		 * true); softAssertion.assertFalse(supplierPresenceInListStatusAfterBlock,
		 * "Supplier name is still displaying after blocking it.");
		 * 
		 * //allow supplier click(checkboxSupplier(companyName,
		 * firstSelectedSupplierName));
		 * Reporter.log("Clicked on the checkbox for the supplier.", true);
		 * jse.executeScript("window.scrollBy(0,-2000)"); Thread.sleep(1000);
		 * click(allowSelectedBtn); Reporter.log("Clicked on allow selected button.",
		 * true); Thread.sleep(2000); scrollToElement(findQuote(companyName)); boolean
		 * supplierPresenceInListStatusAfterAllow =
		 * isElementExistInList(suppliersListForQuote(companyName),
		 * secondSelectedSupplierName);
		 * Reporter.log("Checked if supplier name is displaying after allowing it.",
		 * true); softAssertion.assertFalse(supplierPresenceInListStatusAfterAllow,
		 * "Supplier name is still displaying after allowing it.");
		 */
		driver.findElement(By.id("ImpersonateUserName")).sendKeys("BGB@openenergymarket.com", Keys.ENTER);
		Thread.sleep(2000);
		softAssertion.assertTrue(driver.getCurrentUrl().contains("SupplierHome"), "Supplier Dashboard page is not displaying.");
		click(tendersAndAlertsLink);
		Thread.sleep(2000);
		boolean tenderDisplayStatus = isElementPresent(submitPricesBtn(companyName, tenderDate));
		softAssertion.assertTrue(tenderDisplayStatus, "Tender is not displaying in Supplier account after verifying in admin panel");
		click(submitPricesBtn(companyName, tenderDate));
		Reporter.log("Clicked on submit prices button.", true);
		Thread.sleep(2000);
		boolean clientNameDisplayStatus = driver.findElement(By.xpath("//h1[text() = 'Submit Prices']/../following-sibling::div[1]/div[1]")).getText().contains("Client: "+companyName);
		softAssertion.assertTrue(clientNameDisplayStatus, "Client name is not displaying in 'Submit Prices' page.");
		boolean commodityDisplayStatus = driver.findElement(By.xpath("//h1[text() = 'Submit Prices']/../following-sibling::div[1]/div[2]")).getText().contains("Commodity: ElectricityHh");
		softAssertion.assertTrue(commodityDisplayStatus, "Commodity is not displaying.");
		
		//WebElement tenderDateDisplayStatus = driver.findElement(By.xpath(""));
				
		softAssertion.assertAll();
	}
	//Suppliers
	By tendersAndAlertsLink = By.xpath("//li[@data-action = 'Requests']/a/h3");

	By quoteRequestStatusDropdown = By.id("SelectedStatus");
	
	public By submitPricesBtn(String companyName, String tenderDate) {
		By submitPricesBtn = By.xpath("//tr[@class = 'tender-row']/td[text() = '" + currentDate() + "']/following-sibling::td[text() = '" + companyName + "']/following-sibling::td[@class = 'utility' and text() = 'HH']/following-sibling::td[@class = 'tender-date' and text() = '" + tenderDate + "']/following-sibling::td/a[@id = 'submit-prices-link']");
		return submitPricesBtn;
	}
	
	public void logout() {
		Actions action = new Actions(driver);
		WebElement accountSettingsBtn = driver
				.findElement(By.xpath("//figure[@id = 'logo']/following-sibling::ul/li[2]/a"));
		WebElement logoutBtn = driver.findElement(By.xpath("//a[text() = 'Log out']"));
		action.moveToElement(accountSettingsBtn).moveToElement(logoutBtn).click().build().perform();
	}

	public void loginAsAdmin() throws Throwable {
		String URL = getPropertyFileData("url");
		String EMAIL = getPropertyFileData("adminEmail");
		String PASSWORD = getPropertyFileData("adminPassword");
		driver.get(URL);
		setValue(username, EMAIL);
		setValue(pwd, PASSWORD);
		click(signInBtn);
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
		By quote = By.xpath("//i[@class = 'icon-lightning icon-2x']/../following-sibling::td[text() = '" + currentDate()
				+ "']/preceding-sibling::td[text() = '" + companyName + "']");
		return quote;
	}

	public By downloadTenderDetailsButton(String companyName) {
		By downloadBtn = By
				.xpath("//i[@class = 'icon-lightning icon-2x']/../following-sibling::td[text() = '" + currentDate()
						+ "']/preceding-sibling::td[text() = '" + companyName + "']/following-sibling::td[3]/a");
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
				.xpath("//i[@class = 'icon-lightning icon-2x']/../following-sibling::td[text() = '" + currentDate()
						+ "']/preceding-sibling::td[text() = '" + companyName + "']/following-sibling::td[5]/label");
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
				.xpath("//i[@class = 'icon-lightning icon-2x']/../following-sibling::td[text() = '" + currentDate()
						+ "']/preceding-sibling::td[text() = '" + companyName + "']/following-sibling::td[5]/input");
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
				.xpath("//i[@class = 'icon-lightning icon-2x']/../following-sibling::td[text() = '" + currentDate()
						+ "']/preceding-sibling::td[text() = '" + companyName + "']/following-sibling::td[4]/input");
		return checkboxLst;
	}

	/**
	 * Returns the locator of the checkbox for the supplier in supplier list in
	 * verify tenders.
	 * 
	 * @param companyName
	 * @param supplierName
	 */
	public By checkboxSupplier(String companyName, String supplierName) {
		By supCheckbox = By.xpath("//i[@class = 'icon-lightning icon-2x']/../following-sibling::td[text() = '"
				+ currentDate() + "']/preceding-sibling::td[text() = '" + companyName
				+ "']/following-sibling::td[4]/label[text() = '" + supplierName + "']/preceding-sibling::input[1]");
		return supCheckbox;
	}

	public void navigateToCompanyProfile() {
		click(portfolioMgr);
		click(companyProfile);
	}

	public void fillCompanyProfile() throws Throwable {
		setValue(companyName, "AGB3");
		setValue(companyRegisteredAddress, "Bangalore");

		setValue(compPostCode, "2983472");
		setValue(phone, "8923472834");
		setValue(companyRegNum, "8173812323");
		click(saveBtn);
		Thread.sleep(2000);
		click(okBtn_TenderSummaryPage);
	}

	public void addSite() throws Throwable {
		click(addSite);
		Reporter.log("Clicked Add Site button", true);
		Thread.sleep(2000);
		setValue(siteName, "Domlur");
		setValue(address1, "G R Complex, No. 31, Ground & 1st Floor");
		setValue(postcode, "560071");
		setValue(siteContactName, "Amitav");
		setValue(contactPhoneNo, "9823423412");
		setValue(contactEmail, "andola.amitav@gmail.com");
		setValue(siteID, "555");
		setValue(address2, "Kempegowda Service Rd");
		setValue(address3, "Bengaluru");
		setValue(address4, "Karnataka");
		setValue(siteArea, "100");
		Reporter.log("Entered data in various fields in 'Add Site' popup", true);
		WebElement saveSiteBtn = driver.findElement(By.id("save-btn"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", saveSiteBtn);
		Thread.sleep(2000);
		try {
			click(tipCloseBtn);
		} catch (Exception e) {
			System.out.println("Couldn't close 'Tip' message");
		}
	}

	public String addValidHHmeterGeneric() throws Throwable {

		Random random = new Random();
		// int cellNum = random.nextInt(1568);
		String mpanNumber = readExcelData("Sheet2", random.nextInt(1500), 0);
		Thread.sleep(2000);
		click(addMeter);
		Reporter.log("Clicked on add meter dropdown.", true);
		click(addHHMeter);
		Reporter.log("Clicked on HH Meter in add meter dropdown", true);
		setValue(meterNumSecondField, readExcelData("Sheet3", 6, 2));
		setValue(meterNumThirdField, readExcelData("Sheet3", 6, 3));
		setValue(meterNumFourthField, mpanNumber.substring(0, 2));
		setValue(meterNumFifthField, mpanNumber.substring(2, 6));
		setValue(meterNumSixthField, mpanNumber.substring(6, 10));
		setValue(meterNumSeventhField, mpanNumber.substring(10, 13));
		Reporter.log("Entered data in 6 fields for meter number", true);
		setValue(expectedConsumption, readExcelData("Sheet3", 8, 2));
		Reporter.log("Entered value in expected consumption", true);
		click(contractEndDate);
		Reporter.log("Clicked on contract end date field", true);
		Thread.sleep(1000);
		selectFutureDateCalender(14, random.nextInt(12), 2020);
		Reporter.log("Entered date in the date picker", true);
		setValue(capacity, readExcelData("Sheet3", 8, 3));
		Reporter.log("Entered data in capacity field.", true);
		selectByVisibleText(currentSupplier, "British Gas Business");
		Reporter.log("Selected current supplier from supplier dropdown", true);
		setValue(currentAnnualSpend, String.valueOf(random.nextInt(5000)));
		Reporter.log("Entered data in 'Current Annual Spent'", true);
		selectByVisibleText(currentMeterOperator, "E.ON UK Energy Services Ltd");
		Reporter.log("Selected value from 'Current Meter Operator' dropdown", true);
		selectByVisibleText(currentDataCollector, "Morrison Data Services");
		Reporter.log("Selected value from 'Current Data Collector' dropdown", true);
		click(meterOperatorEndDate);
		Reporter.log("Clicked on Meter Operator End date", true);
		Thread.sleep(1000);
		selectFutureDateCalender(26, 2, 2020);
		Reporter.log("Selected date from date picker", true);
		click(dataCollectorEndDate);
		Reporter.log("Clicked on Data Collector End date", true);
		Thread.sleep(1000);
		selectFutureDateCalender(21, 7, 2020);
		Reporter.log("Selected date from date picker", true);
		WebElement saveMetBtn = driver.findElement(By.id("save-meter-button"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", saveMetBtn);
		// click(saveMeterBtn);
		Reporter.log("Clicked on 'Save Meter Data' button", true);
		Thread.sleep(4000);
		click(okBtn);
		Reporter.log("Clicked on Ok button in meter saved successfully popup.", true);
		Thread.sleep(2000);
		try {
			click(tipCloseBtn);
		} catch (Exception e) {
			System.out.println("Couldn't close 'Tip' message");
		}
		return mpanNumber;
	}

	public void addContractHistory() throws Throwable {
		// Need to enter supplier product
		String mpanNumber = getText(hhMeterNumberFirstRecord).trim();
		viewMeterDetails(mpanNumber);
		Thread.sleep(1000);
		click(addHHcontractHistoryBtn(mpanNumber));
		Reporter.log("Clicked on the 'Add Contract History' button.", true);
		Thread.sleep(1000);
		setValue(dayRate, "320");
		setValue(nightRate, "300");
		setValue(standingCharge, "1200");
		setValue(capacityCharge, "1400");
		Reporter.log("Entered data in capacity charge.", true);
		click(dateTraded);
		Thread.sleep(1000);
		selectPrevDateCalender(16, 2, 2018);
		Reporter.log("Entered data in contract date traded", true);
		Thread.sleep(1000);
		click(contractStartDate);
		Thread.sleep(1000);
		selectPrevDateCalender(22, 9, 2018);
		Reporter.log("Entered data in contract start date", true);
		click(saveContractHistoryBtn);
		Thread.sleep(2000);

	}

	public void viewMeterDetails(String meterNumber) {
		By meterNumb = By.xpath("//div[contains(text(), '" + meterNumber + "')]");
		click(meterNumb);
		Reporter.log("Clicked on the meter number to view the detail section.", true);
	}

	public By addHHcontractHistoryBtn(String mpanNumber) {
		By addContractHistBtn = By.xpath("//div[contains(text(), '" + mpanNumber
				+ "')]/../../../../following-sibling::div/div[1]/table/tbody/tr/td[6]/button");
		return addContractHistBtn;
	}

	/**
	 * Provides the locator of checkbox for the meter in tender request page.
	 * 
	 * @return
	 */
	public By checkboxForMeter(String mpan) {
		By checkboxMeter = By.xpath("//label[contains(text(),'" + mpan + "')]/../../../..");
		return checkboxMeter;
	}

	public void selectingSingleMeterModified(String mpan) {
		click(SelectAllChoosemeter);
		click(checkboxForMeter(mpan));
	}
	//Used in HH Suite
	public void requestAquoteAndVerifyTenderSummaryPageTest() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String companyName = "Auto_Company_555";
		scrollToElement(checkboxForMeter("1014568646666"));// need to be replaced by mpanNum
		selectingSingleMeterModified("1014568646666");// need to be replaced by mpanNum
		jse.executeScript("window.scrollBy(0,-500)");
		SelectingSingleContractDuration();
		click(tenderDateHH);
		Thread.sleep(1000);
		String tenderDate = "12/11/2019";
		selectFutureDateCalender(12, 10, 2019);
		SelectingMultipleSupplier();
		Reporter.log("Selected suppliers.", true);
		String firstSelectedSupplierName = getText(FirstSupplier);
		String secondSelectedSupplierName = getText(ThirdSupplier);
		String thirdSelectedSupplierName = getText(FifthSupplier);

		ClickTopSubmitButton();
		Reporter.log("Clicked on submit button", true);
		Thread.sleep(3000);
		scrollToElement(invitedSuppliersHeading_TenderSummaryPage);
		boolean firstSupplierPresenceStatus = isElementExistInList(invitedSuppliers_TenderSummaryPage,
				firstSelectedSupplierName);
		softAssertion.assertTrue(firstSupplierPresenceStatus, "Selected supplier is not displaying.");

		boolean secondSupplierPresenceStatus = isElementExistInList(invitedSuppliers_TenderSummaryPage,
				secondSelectedSupplierName);
		softAssertion.assertTrue(secondSupplierPresenceStatus, "Selected supplier is not displaying.");

		boolean thirdSupplierPresenceStatus = isElementExistInList(invitedSuppliers_TenderSummaryPage,
				thirdSelectedSupplierName);
		softAssertion.assertTrue(thirdSupplierPresenceStatus, "Selected supplier is not displaying.");
		scrollToElement(confirmAndSubmit);
		click(confirmAndSubmit);
		Reporter.log("Clicked on confirm and submit button.", true);
		Thread.sleep(2000);
		boolean tenderSubmitSuccessPopupDisplayStatus = isElementPresent(quoteSubmitSuccessPopup);
		softAssertion.assertTrue(tenderSubmitSuccessPopupDisplayStatus,
				"Tender Submit Success Popup is not displaying.");
		click(okBtn_TenderSummaryPage);
		Reporter.log("Clicked on Ok button.", true);
		logout();
		softAssertion.assertAll();
	}

}
