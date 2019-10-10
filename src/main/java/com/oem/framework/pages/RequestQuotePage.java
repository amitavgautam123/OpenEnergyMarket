package com.oem.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class RequestQuotePage extends CustomerDashboardPage {

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
	By MeterFourElement = By.xpath("//div[@id='collapseElectricityQuoteHh_SiteMeters_3_']");

	By ContractDuration = By.xpath("//select[@id='ElectricityQuoteHh_ContractDurationInMonths']");
	By AddNewContractDuration = By.xpath(
			"//div[@id='request-electricity-hh-quote']//p[@class='add-duration'][contains(text(),'Add new contract duration')]");
	By ContractDuration2 = By.xpath("//select[@id='ElectricityQuoteHh_Duration2']");
	By ContractDuration3 = By.xpath("//select[@id='ElectricityQuoteHh_Duration3']");
	By ContractDuration4 = By.xpath("//select[@id='ElectricityQuoteHh_Duration4']");

	By SelectAllChooseSupplier = By.xpath("//div[@id='request-electricity-hh-quote']//div[@id='selectall']");
	By FirstSupplier = By.xpath("//div[@id='request-electricity-hh-quote']//section[@id='suppliers']//li[1]//label[1]");
	By ThirdrdSupplier = By.xpath("//div[@id='request-electricity-hh-quote']//li[3]//label[1]");
	By FourthSupplier = By.xpath("//div[@id='request-electricity-hh-quote']//li[4]//label[1]");
	By FifthSupplier = By.xpath("//div[@id='request-electricity-hh-quote']//li[5]//label[1]");
	By SixthSupplier = By.xpath("//div[@id='request-electricity-hh-quote']//li[6]//label[1]");

	By HHElectricity = By.xpath("//a[@id='request-electricity-hh-quote-a']");

	By Date = By.xpath("//input[@id='ElectricityQuoteHh_TenderDate']");
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
	
	By numberOfSuppliers=By.xpath("//div[@id='request-water-quote']//section[@id='suppliers']//ul[@class='check-list']//li");

	By choosSuppliers_Water = By.xpath("//div[@id='request-water-quote']//div[@id='selectall']");
	By firstSupplier_Water = By.xpath("//div[@id='request-water-quote']//section[@id='suppliers']//li[1]//label[1]");
	By secondSupplier_Water = By.xpath("//div[@id='request-water-quote']//section[@id='suppliers']//li[2]//label[1]");
	By thirdSupplier_Water = By.xpath("//div[@id='request-water-quote']//section[@id='suppliers']//li[3]//label[1]");
	By fourthSupplier_Water = By.xpath("//div[@id='request-water-quote']//section[@id='suppliers']//li[4]//label[1]");
	By fifthSupplier_Water = By.xpath("//div[@id='request-water-quote']//section[@id='suppliers']//li[5]//label[1]");

	public void clickWaterUtility() {
		click(filterByWaterUtility);
		Reporter.log("Clicked on Water Utility.", true);
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
		Reporter.log("Clicked on Date.", true);
	}

	public void selectingzerometers_Water() {
		click(allmeter_Water);
		Reporter.log("Clicked on Choose Meter All.", true);
	}

	public void selectingSinglemeters_Water() {
		click(allmeter_Water);
		Reporter.log("Clicked on Choose Meter All.", true);

		click(firstMeter_Water);
		Reporter.log("Clicked on First Meter.", true);

	}

	public void selectingMultiplemeters_Water() {
		click(allmeter_Water);
		Reporter.log("Clicked on Choose Meter All.", true);

		click(firstMeter_Water);
		Reporter.log("Clicked on First Meter.", true);
		/*
		 * click(secondMeter_Water); Reporter.log("Clicked on second Meter.",
		 * true); click(thirdMeter_Water); Reporter.log(
		 * "Clicked on third Meter.", true); click(fourthMeter_Water);
		 * Reporter.log("Clicked on fourth Meter.", true);
		 */

	}

	public void selectingsingleContractDur_Water() {
		selectByIndex(firstContractDuration_Water, 02);
		Reporter.log("Selected First Contract Duration.", true);
	}

	public void selectingMultipleContractDur_Water() {
		selectByIndex(firstContractDuration_Water, 02);

		Reporter.log("Selected First Contract Duration.", true);

		click(addNewContractDuration_Water);
		Reporter.log("Clicked on add contract Duration", true);
		selectByIndex(secondContractDuration_Water, 03);
		Reporter.log("Selected second Contract Duration.", true);

		click(addNewContractDuration_Water);
		Reporter.log("Clicked on add contract Duration", true);
		selectByIndex(thirdContractDuration_Water, 04);
		Reporter.log("Selected third Contract Duration.", true);

		click(addNewContractDuration_Water);
		Reporter.log("Clicked on add contract Duration", true);
		selectByIndex(fourthContractDuration_Water, 05);
		Reporter.log("Selected fourth Contract Duration.", true);

	}

	public void selectingzerosupplier_Water() {
		click(choosSuppliers_Water);
		Reporter.log("clicked on all suppliers", true);
	}

	public void selectingSinglesupplier_Water() {
		click(choosSuppliers_Water);
		Reporter.log("clicked on all suppliers", true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		click(firstSupplier_Water);
		Reporter.log("clicked on first supplier", true);

	}

	public void selectingMultiplesupplier_Water() {
		click(choosSuppliers_Water);
		Reporter.log("clicked on all suppliers", true);

		click(firstSupplier_Water);
		Reporter.log("clicked on first supplier", true);
		click(secondSupplier_Water);
		Reporter.log("clicked on second supplier", true);
		click(thirdSupplier_Water);
		Reporter.log("clicked on third supplier", true);
		click(fourthSupplier_Water);
		Reporter.log("clicked on fourth supplier", true);
		click(fifthSupplier_Water);
		Reporter.log("clicked on fourth supplier", true);

	}

	// ===========================================Water===========================================================================
	public void clickGasUtility() {
		click(filterByGasUtility);
		Reporter.log("Clicked on GasUtility.", true);
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
		Reporter.log("Clicked on Renewable Energy.", true);
	}

	public void ClickDate_Gas() {
		click(date_Gas);
		Reporter.log("Clicked on Date.", true);
	}

	public void selectingzerometers_Gas() {
		click(allmeter_Gas);
		Reporter.log("Clicked on Choose Meter All.", true);
	}

	public void selectingSinglemeters_Gas() {
		click(allmeter_Gas);
		Reporter.log("Clicked on Choose Meter All.", true);

		click(firstMeter_Gas);
		Reporter.log("Clicked on First Meter.", true);

	}

	public void selectingMultiplemeters_Gas() {
		click(allmeter_Gas);
		Reporter.log("Clicked on Choose Meter All.", true);

		click(firstMeter_Gas);
		Reporter.log("Clicked on First Meter.", true);
		click(secondMeter_Gas);
		Reporter.log("Clicked on second Meter.", true);
		click(thirdMeter_Gas);
		Reporter.log("Clicked on third Meter.", true);
		click(fourthMeter_Gas);
		Reporter.log("Clicked on fourth Meter.", true);

	}

	public void selectingsingleContractDur_Gas() {
		selectByIndex(firstContractDuration_Gas, 02);
		Reporter.log("Selected First Contract Duration.", true);
	}

	public void selectingMultipleContractDur_Gas() {
		selectByIndex(firstContractDuration_Gas, 02);

		Reporter.log("Selected First Contract Duration.", true);

		click(addNewContractDuration_Gas);
		Reporter.log("Clicked on add contract Duration", true);
		selectByIndex(secondContractDuration_Gas, 03);
		Reporter.log("Selected second Contract Duration.", true);

		click(addNewContractDuration_Gas);
		Reporter.log("Clicked on add contract Duration", true);
		selectByIndex(thirdContractDuration_Gas, 04);
		Reporter.log("Selected third Contract Duration.", true);

		click(addNewContractDuration_Gas);
		Reporter.log("Clicked on add contract Duration", true);
		selectByIndex(fourthContractDuration_Gas, 05);
		Reporter.log("Selected fourth Contract Duration.", true);

	}

	public void selectingzerosupplier_Gas() {
		click(choosSuppliers_Gas);
		Reporter.log("clicked on all suppliers", true);
	}

	public void selectingSinglesupplier_Gas() {
		click(choosSuppliers_Gas);
		Reporter.log("clicked on all suppliers", true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		click(firstSupplier_gas);
		Reporter.log("clicked on first supplier", true);

	}

	public void selectingMultiplesupplier_Gas() {
		click(choosSuppliers_Gas);
		Reporter.log("clicked on all suppliers", true);

		click(firstSupplier_gas);
		Reporter.log("clicked on first supplier", true);
		click(secondSupplier_gas);
		Reporter.log("clicked on second supplier", true);
		click(thirdSupplier_gas);
		Reporter.log("clicked on third supplier", true);
		click(fourthSupplier_gas);
		Reporter.log("clicked on fourth supplier", true);
		click(fifthSupplier_gas);
		Reporter.log("clicked on fourth supplier", true);

	}
	// ============================================================================================

	public void CkiclingRenewableEnergy_nHH() {
		click(renewableEnergy_nHH);
		Reporter.log("Clicked on Renewable Energy.", true);
	}

	public void selectingzerometers_nHH() {
		click(meterAll_nHH);
		Reporter.log("Clicked on Choose Meter All.", true);
	}

	public void selectingSinglemeters_nHH() {
		click(meterAll_nHH);
		Reporter.log("Clicked on Choose Meter All.", true);

		click(Firstmeter_nHH);
		Reporter.log("Clicked on First Meter.", true);

	}

	public void selectingMultiplemeters_nHH() {
		click(meterAll_nHH);
		Reporter.log("Clicked on Choose Meter All.", true);

		click(Firstmeter_nHH);
		Reporter.log("Clicked on First Meter.", true);
		click(Secondmeter_nHH);
		Reporter.log("Clicked on second Meter.", true);
		click(thirdmeter_nHH);
		Reporter.log("Clicked on third Meter.", true);
		click(Fourthmeter_nHH);
		Reporter.log("Clicked on fourth Meter.", true);

	}

	public void selectingsingleContractDur_nHH() {
		selectByIndex(contractDuration_nHH, 02);
		Reporter.log("Selected First Contract Duration.", true);
	}

	public void selectingMultipleContractDur_nHH() {
		selectByIndex(contractDuration_nHH, 02);

		Reporter.log("Selected First Contract Duration.", true);

		click(AddContractDuration_nHH);
		Reporter.log("Clicked on add contract Duration", true);
		selectByIndex(contractDuration2_nHH, 03);
		Reporter.log("Selected second Contract Duration.", true);

		click(AddContractDuration_nHH);
		Reporter.log("Clicked on add contract Duration", true);
		selectByIndex(contractDuration3_nHH, 04);
		Reporter.log("Selected third Contract Duration.", true);

		click(AddContractDuration_nHH);
		Reporter.log("Clicked on add contract Duration", true);
		selectByIndex(contractDuration4_nHH, 05);
		Reporter.log("Selected fourth Contract Duration.", true);

	}

	public void selectingzerosupplier_nHH() {
		click(ChooseSupplierAll_nHH);
		Reporter.log("clicked on all suppliers", true);
	}

	public void selectingSinglesupplier_nHH() {
		click(ChooseSupplierAll_nHH);
		Reporter.log("clicked on all suppliers", true);

		click(supplier01_nHH);
		Reporter.log("clicked on first supplier", true);

	}

	public void selectingMultiplesupplier_nHH() {
		click(ChooseSupplierAll_nHH);
		Reporter.log("clicked on all suppliers", true);

		click(supplier01_nHH);
		Reporter.log("clicked on first supplier", true);
		click(supplier02_nHH);
		Reporter.log("clicked on second supplier", true);
		click(supplier03_nHH);
		Reporter.log("clicked on third supplier", true);
		click(supplier04_nHH);
		Reporter.log("clicked on fourth supplier", true);

	}

	// --------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------
	public void SelectingZeroMeters() {
		click(SelectAllChoosemeter);
		Reporter.log("Clicked on Choose Meter All.", true);
	}

	public void SelectingSingleMeter() {
		click(SelectAllChoosemeter);
		Reporter.log("Clicked on Choose Meter All.", true);

		click(MeterFirstElement);
		Reporter.log("Clicked on First Meter.", true);
	}

	public void SelectingMultipleMeter() {
		click(SelectAllChoosemeter);
		Reporter.log("Clicked on Choose Meter All.", true);

		click(MeterFirstElement);
		Reporter.log("Clicked on First Meter.", true);
		click(MeterSecondElement);
		Reporter.log("Clicked on Second Meter.", true);
		click(MeterThridElement);
		Reporter.log("Clicked on Third Meter.", true);

	}

	public void SelectingSingleContractDuration() {
		selectByIndex(ContractDuration, 02);
		Reporter.log("Selected First Contract Duration.", true);
	}

	public void SelectingMultipleContractDuration() {
		selectByIndex(ContractDuration, 02);
		Reporter.log("Selected First Contract Duration.", true);

		click(AddNewContractDuration);
		Reporter.log("Clicked Add Contract Duration. ", true);
		selectByIndex(ContractDuration2, 03);
		Reporter.log("Selected second Contract Duration.", true);

		click(AddNewContractDuration);
		Reporter.log("Clicked Add Contract Duration. ", true);
		selectByIndex(ContractDuration3, 04);
		Reporter.log("Selected Third Contract Duration.", true);
	}

	public void SelectingZeroSuppliers() {
		click(SelectAllChooseSupplier);
		Reporter.log("Clicked Choose Supplier All.", true);
	}

	public void SelectingSingleSupplier() {
		click(SelectAllChooseSupplier);
		Reporter.log("Clicked Choose Supplier All.", true);

		click(FirstSupplier);
		Reporter.log("Clicked First Supplier.", true);
	}

	public void SelectingMultipleSupplier() {
		click(SelectAllChooseSupplier);
		Reporter.log("Clicked Choose Supplier All.", true);

		click(FirstSupplier);
		Reporter.log("Clicked 1st Supplier.", true);
		click(ThirdrdSupplier);
		Reporter.log("Clicked 3rd Supplier.", true);
		click(FourthSupplier);
		Reporter.log("Clicked 4th Supplier.", true);
		click(FifthSupplier);
		Reporter.log("Clicked 5th Supplier.", true);

	}

	public void ClickTopSubmitButton() {
		click(TopSubmit);
		Reporter.log("Clicked Submit Button.", true);
	}

	public void SelectElectricity_HHUtility() {
		click(HHElectricity);
		Reporter.log("Clicked HH ElectricityUtility. ", true);

	}

	public void SelectElectricity_nHHUtility() {
		click(filterByNHHutility);
		Reporter.log("Clicked nHH ElectricityUtility. ", true);

	}

	public void SelectGasUtility() {
		click(filterByGasUtility);
		Reporter.log("Clicked GasUtility. ", true);

	}

	public void SelectWaterUtility() {
		click(filterByWaterUtility);
		Reporter.log("Clicked WaterUtility. ", true);

	}

	public void EnterDate(String value) {
		clearValue(Date);
		Reporter.log("Cleared Date. ", true);
		setValue(Date, value);
		Reporter.log("Enterd Date. ", true);
	}

	public void ClickRenewableEnergy() {
		click(RenewableEnergy);
		Reporter.log("Clicked Renewable Energy. ", true);
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
		Reporter.log("Clicked on filter for HH Utility.", true);
		boolean contractEndDate6monthsPresenceStatusHHUtility = isElementExistInDropDown(contractDurationHHutility,
				"6 months");
		softAssertion.assertTrue(contractEndDate6monthsPresenceStatusHHUtility,
				"6 months is not displaying in contract end date dropdown for HH Utility");
		Reporter.log("Checked if 6 months is displaying in contract end date dropdown for HH Utility", true);
		boolean contractEndDate12monthsPresenceStatusHHUtility = isElementExistInDropDown(contractDurationHHutility,
				"12 months");
		softAssertion.assertTrue(contractEndDate12monthsPresenceStatusHHUtility,
				"12 months is not displaying in contract end date dropdown for HH Utility");
		Reporter.log("Checked if 12 months is displaying in contract end date dropdown for HH Utility", true);
		boolean contractEndDate18monthsPresenceStatusHHUtility = isElementExistInDropDown(contractDurationHHutility,
				"18 months");
		softAssertion.assertTrue(contractEndDate18monthsPresenceStatusHHUtility,
				"18 months is not displaying in contract end date dropdown for HH Utility");
		Reporter.log("Checked if 18 months is displaying in contract end date dropdown for HH Utility", true);
		boolean contractEndDate24monthsPresenceStatusHHUtility = isElementExistInDropDown(contractDurationHHutility,
				"24 months");
		softAssertion.assertTrue(contractEndDate24monthsPresenceStatusHHUtility,
				"24 months is not displaying in contract end date dropdown for HH Utility");
		Reporter.log("Checked if 24 months is displaying in contract end date dropdown for HH Utility", true);
		boolean contractEndDate30monthsPresenceStatusHHUtility = isElementExistInDropDown(contractDurationHHutility,
				"30 months");
		softAssertion.assertTrue(contractEndDate30monthsPresenceStatusHHUtility,
				"30 months is not displaying in contract end date dropdown for HH Utility");
		Reporter.log("Checked if 30 months is displaying in contract end date dropdown for HH Utility", true);
		boolean contractEndDate36monthsPresenceStatusHHUtility = isElementExistInDropDown(contractDurationHHutility,
				"36 months");
		softAssertion.assertTrue(contractEndDate36monthsPresenceStatusHHUtility,
				"36 months is not displaying in contract end date dropdown for HH Utility");
		Reporter.log("Checked if 36 months is displaying in contract end date dropdown for HH Utility", true);
		boolean contractEndDate60monthsPresenceStatusHHUtility = isElementExistInDropDown(contractDurationHHutility,
				"60 months");
		softAssertion.assertTrue(contractEndDate60monthsPresenceStatusHHUtility,
				"60 months is not displaying in contract end date dropdown for HH Utility");
		Reporter.log("Checked if 60 months is displaying in contract end date dropdown for HH Utility", true);

		click(filterByNHHutility);
		Reporter.log("Clicked on filter for NHH Utility.", true);
		boolean contractEndDate6monthsPresenceStatusNHHUtility = isElementExistInDropDown(contractDurationNHHutility,
				"6 months");
		softAssertion.assertTrue(contractEndDate6monthsPresenceStatusNHHUtility,
				"6 months is not displaying in contract end date dropdown for NHH Utility");
		Reporter.log("Checked if 6 months is displaying in contract end date dropdown for NHH Utility", true);
		boolean contractEndDate12monthsPresenceStatusNHHUtility = isElementExistInDropDown(contractDurationNHHutility,
				"12 months");
		softAssertion.assertTrue(contractEndDate12monthsPresenceStatusNHHUtility,
				"12 months is not displaying in contract end date dropdown for NHH Utility");
		Reporter.log("Checked if 12 months is displaying in contract end date dropdown for NHH Utility", true);
		boolean contractEndDate18monthsPresenceStatusNHHUtility = isElementExistInDropDown(contractDurationNHHutility,
				"18 months");
		softAssertion.assertTrue(contractEndDate18monthsPresenceStatusNHHUtility,
				"18 months is not displaying in contract end date dropdown for NHH Utility");
		Reporter.log("Checked if 18 months is displaying in contract end date dropdown for NHH Utility", true);
		boolean contractEndDate24monthsPresenceStatusNHHUtility = isElementExistInDropDown(contractDurationNHHutility,
				"24 months");
		softAssertion.assertTrue(contractEndDate24monthsPresenceStatusNHHUtility,
				"24 months is not displaying in contract end date dropdown for NHH Utility");
		Reporter.log("Checked if 24 months is displaying in contract end date dropdown for NHH Utility", true);
		boolean contractEndDate30monthsPresenceStatusNHHUtility = isElementExistInDropDown(contractDurationNHHutility,
				"30 months");
		softAssertion.assertTrue(contractEndDate30monthsPresenceStatusNHHUtility,
				"30 months is not displaying in contract end date dropdown for NHH Utility");
		Reporter.log("Checked if 30 months is displaying in contract end date dropdown for NHH Utility", true);
		boolean contractEndDate36monthsPresenceStatusNHHUtility = isElementExistInDropDown(contractDurationNHHutility,
				"36 months");
		softAssertion.assertTrue(contractEndDate36monthsPresenceStatusNHHUtility,
				"36 months is not displaying in contract end date dropdown for NHH Utility");
		Reporter.log("Checked if 36 months is displaying in contract end date dropdown for NHH Utility", true);
		boolean contractEndDate60monthsPresenceStatusNHHUtility = isElementExistInDropDown(contractDurationNHHutility,
				"60 months");
		softAssertion.assertTrue(contractEndDate60monthsPresenceStatusNHHUtility,
				"60 months is not displaying in contract end date dropdown for NHH Utility");
		Reporter.log("Checked if 60 months is displaying in contract end date dropdown for NHH Utility", true);

		click(filterByGasUtility);
		Reporter.log("Clicked on filter for Gas Utility.", true);
		boolean contractEndDate6monthsPresenceStatusGasUtility = isElementExistInDropDown(contractDurationGasUtility,
				"6 months");
		softAssertion.assertTrue(contractEndDate6monthsPresenceStatusGasUtility,
				"6 months is not displaying in contract end date dropdown for Gas Utility");
		Reporter.log("Checked if 6 months is displaying in contract end date dropdown for Gas Utility", true);
		boolean contractEndDate12monthsPresenceStatusGasUtility = isElementExistInDropDown(contractDurationGasUtility,
				"12 months");
		softAssertion.assertTrue(contractEndDate12monthsPresenceStatusGasUtility,
				"12 months is not displaying in contract end date dropdown for Gas Utility");
		Reporter.log("Checked if 12 months is displaying in contract end date dropdown for Gas Utility", true);
		boolean contractEndDate18monthsPresenceStatusGasUtility = isElementExistInDropDown(contractDurationGasUtility,
				"18 months");
		softAssertion.assertTrue(contractEndDate18monthsPresenceStatusGasUtility,
				"18 months is not displaying in contract end date dropdown for Gas Utility");
		Reporter.log("Checked if 18 months is displaying in contract end date dropdown for Gas Utility", true);
		boolean contractEndDate24monthsPresenceStatusGasUtility = isElementExistInDropDown(contractDurationGasUtility,
				"24 months");
		softAssertion.assertTrue(contractEndDate24monthsPresenceStatusGasUtility,
				"24 months is not displaying in contract end date dropdown for Gas Utility");
		Reporter.log("Checked if 24 months is displaying in contract end date dropdown for Gas Utility", true);
		boolean contractEndDate30monthsPresenceStatusGasUtility = isElementExistInDropDown(contractDurationGasUtility,
				"30 months");
		softAssertion.assertTrue(contractEndDate30monthsPresenceStatusGasUtility,
				"30 months is not displaying in contract end date dropdown for Gas Utility");
		Reporter.log("Checked if 30 months is displaying in contract end date dropdown for Gas Utility", true);
		boolean contractEndDate36monthsPresenceStatusGasUtility = isElementExistInDropDown(contractDurationGasUtility,
				"36 months");
		softAssertion.assertTrue(contractEndDate36monthsPresenceStatusGasUtility,
				"36 months is not displaying in contract end date dropdown for Gas Utility");
		Reporter.log("Checked if 36 months is displaying in contract end date dropdown for Gas Utility", true);
		boolean contractEndDate60monthsPresenceStatusGasUtility = isElementExistInDropDown(contractDurationGasUtility,
				"60 months");
		softAssertion.assertTrue(contractEndDate60monthsPresenceStatusGasUtility,
				"60 months is not displaying in contract end date dropdown for Gas Utility");
		Reporter.log("Checked if 60 months is displaying in contract end date dropdown for Gas Utility", true);

		click(filterByWaterUtility);
		Reporter.log("Clicked on filter for Water Utility.", true);
		/*
		 * boolean contractEndDate6monthsPresenceStatusWaterUtility =
		 * isElementExistInDropDown(contractDurationWaterUtility, "6 months");
		 * softAssertion.assertFalse(
		 * contractEndDate6monthsPresenceStatusWaterUtility,
		 * "6 months is displaying in contract end date dropdown for Water Utility"
		 * ); Reporter.log(
		 * "Checked if 6 months is displaying in contract end date dropdown for Water Utility"
		 * , true);
		 */
		boolean contractEndDate12monthsPresenceStatusWaterUtility = isElementExistInDropDown(
				contractDurationWaterUtility, "12 months");
		softAssertion.assertTrue(contractEndDate12monthsPresenceStatusWaterUtility,
				"12 months is not displaying in contract end date dropdown for Water Utility");
		Reporter.log("Checked if 12 months is displaying in contract end date dropdown for Water Utility", true);
		boolean contractEndDate18monthsPresenceStatusWaterUtility = isElementExistInDropDown(
				contractDurationWaterUtility, "18 months");
		softAssertion.assertTrue(contractEndDate18monthsPresenceStatusWaterUtility,
				"18 months is not displaying in contract end date dropdown for Water Utility");
		Reporter.log("Checked if 18 months is displaying in contract end date dropdown for Water Utility", true);
		boolean contractEndDate24monthsPresenceStatusWaterUtility = isElementExistInDropDown(
				contractDurationWaterUtility, "24 months");
		softAssertion.assertTrue(contractEndDate24monthsPresenceStatusWaterUtility,
				"24 months is not displaying in contract end date dropdown for Water Utility");
		Reporter.log("Checked if 24 months is displaying in contract end date dropdown for Water Utility", true);
		boolean contractEndDate30monthsPresenceStatusWaterUtility = isElementExistInDropDown(
				contractDurationWaterUtility, "30 months");
		softAssertion.assertTrue(contractEndDate30monthsPresenceStatusWaterUtility,
				"30 months is not displaying in contract end date dropdown for Water Utility");
		Reporter.log("Checked if 30 months is displaying in contract end date dropdown for Water Utility", true);
		boolean contractEndDate36monthsPresenceStatusWaterUtility = isElementExistInDropDown(
				contractDurationWaterUtility, "36 months");
		softAssertion.assertTrue(contractEndDate36monthsPresenceStatusWaterUtility,
				"36 months is not displaying in contract end date dropdown for Water Utility");
		Reporter.log("Checked if 36 months is displaying in contract end date dropdown for Water Utility", true);
		boolean contractEndDate60monthsPresenceStatusWaterUtility = isElementExistInDropDown(
				contractDurationWaterUtility, "60 months");
		softAssertion.assertTrue(contractEndDate60monthsPresenceStatusWaterUtility,
				"60 months is not displaying in contract end date dropdown for Water Utility");
		Reporter.log("Checked if 60 months is displaying in contract end date dropdown for Water Utility", true);

		softAssertion.assertAll();
	}

	public void validatealertErrormessage_IfNotSelectedAndempty() {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		click(SelectAllChoosemeter);
		clearValue(Date);
		click(SelectAllChooseSupplier);
		click(TopSubmit);
		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		Reporter.log("Checked if error message for not selecting any meter is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();
	}

	public void validatealertErrormessagewhenOnlyOneMeterisSelected() {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		click(SelectAllChoosemeter);
		// click(MeterFirstElement);i am not able to find this element
		clearValue(Date);
		click(SelectAllChooseSupplier);
		click(TopSubmit);
		click(OkAlert);
		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();
	}

	public void validatealertErrormessagewhenMoreThanOneMeterisSelected() {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		clearValue(Date);
		click(SelectAllChooseSupplier);
		click(TopSubmit);
		click(OkAlert);

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
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
		clearValue(Date);
		click(SelectAllChooseSupplier);
		click(TopSubmit);

		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		Reporter.log("Checked if error message for not selecting any meter is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
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
		clearValue(Date);
		click(SelectAllChooseSupplier);
		click(TopSubmit);

		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		Reporter.log("Checked if error message for not selecting any meter is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

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
		Reporter.log("Checked if error message for selecting 2 same Contract Durations", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForSelecting2SameContractDurations,
				"Error message is not displaying for selecting 2 same Contract Durations");
		softAssertion.assertAll();
		click(OkAlert2);
	}

	public void validatealertErrormessageAfterSelectingOneSuplier() {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		click(SelectAllChoosemeter);
		clearValue(Date);
		click(TopSubmit);
		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		Reporter.log("Checked if error message for not selecting any meter is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");
		softAssertion.assertAll();
	}

	public void validatealertErrormessageAfterSelectingAllSuplier() {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		click(SelectAllChoosemeter);
		clearValue(Date);
		click(TopSubmit);
		boolean errorMessageDisplayStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		Reporter.log("Checked if error message for not selecting any meter is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();
	}

	public void validatealertErrormessageAfterSelecting1meter1contractDuration() {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		click(SelectAllChoosemeter);
		click(MeterFirstElement);
		selectByIndex(ContractDuration, 02);
		clearValue(Date);
		click(SelectAllChooseSupplier);
		click(TopSubmit);
		// click(OkAlert2);
		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)
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
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)
		softAssertion.assertAll();
	}

	public void validatealertErrormessageAfterSelectingMultiplemeterMultiplecontractDuration() {
		SoftAssert softAssertion = new SoftAssert();
		click(HHElectricity);
		Reporter.log("Clicked on  HHE Electricity.", true);

		click(SelectAllChoosemeter);
		Reporter.log("Clicked on ChooseMeter All.", true);

		click(MeterFirstElement);
		Reporter.log("Clicked First Meter.", true);
		click(MeterSecondElement);
		Reporter.log("Clicked second Meter.", true);
		click(MeterThridElement);
		Reporter.log("Clicked Third Meter.", true);
		click(MeterFourElement);
		Reporter.log("Clicked fourth Meter.", true);

		selectByIndex(ContractDuration, 02);
		Reporter.log("Selected 1st contract duration.", true);
		click(AddNewContractDuration);
		Reporter.log("Clicked on Add New Contract Duration.", true);
		selectByIndex(ContractDuration2, 03);
		Reporter.log("Selected 2nd contract duration.", true);
		click(AddNewContractDuration);
		Reporter.log("Clicked on Add New Contract Duration.", true);
		selectByIndex(ContractDuration3, 04);
		Reporter.log("Selected 3rd contract duration.", true);
		click(AddNewContractDuration);
		Reporter.log("Clicked on Add New Contract Duration.", true);
		selectByIndex(ContractDuration4, 05);
		Reporter.log("Selected 4th contract duration.", true);
		click(SelectAllChooseSupplier);
		Reporter.log("Clicked on Choose Supplier All.", true);
		click(TopSubmit);
		Reporter.log("Clicked Submit Button.", true);

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)
		softAssertion.assertAll();
	}

	public void validatingErrorMessageAfterSelecting1contractDurationAndMultipleSuppliers() {
		SoftAssert softAssertion = new SoftAssert();

		click(HHElectricity);
		Reporter.log("Clicked on  HHE Electricity.", true);

		click(SelectAllChoosemeter);
		Reporter.log("Clicked on ChooseMeter All.", true);

		selectByIndex(ContractDuration, 02);
		Reporter.log("Selected 1st contract duration.", true);

		click(SelectAllChooseSupplier);
		Reporter.log("Clicked on Choose Supplier All.", true);
		click(ThirdrdSupplier);
		Reporter.log("Clicked on 3rd Supplier.", true);
		click(FourthSupplier);
		Reporter.log("Clicked on 4th Supplier.", true);
		click(FifthSupplier);
		Reporter.log("Clicked on 5th Supplier.", true);

		click(TopSubmit);
		Reporter.log("Clicked Submit Button.", true);

		boolean errorMessageDisplyStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		Reporter.log("Checked if error message for not selecting Meter is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplyStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any Meter.");
		// Assert.assertEquals(actual, expected)
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
		Reporter.log("Checked if error message for not selecting Meter is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplyStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any Meter.");
		// Assert.assertEquals(actual, expected)
		softAssertion.assertAll();

	}

	public void validatingErrorMessageAfterSelectingsinglecontractDurationAndmultipleSupplier() {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_HHUtility();
		SelectingZeroMeters();
		SelectingSingleContractDuration();
		SelectingMultipleSupplier();
		ClickTopSubmitButton();
		boolean errorMessageDisplyStatusForNotSelectingMeter = getText(message)
				.contains("Please select at least one meter for a quote request.");
		Reporter.log("Checked if error message for not selecting Meter is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplyStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any Meter.");
		// Assert.assertEquals(actual, expected)
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
		Reporter.log("Checked if error message for Entering wrong Date is displaying.", true);
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
		Reporter.log("Checked if error message for not selecting any meter is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		Reporter.log("Checked if error message for not selecting any supplier is displaying.", true);
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
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		Reporter.log("Checked if error message for not selecting any supplier is displaying.", true);
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
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		Reporter.log("Checked if error message for not selecting any Supplier is displaying.", true);
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
		Reporter.log("Checked if error message for not selecting any meter is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		Reporter.log("Checked if error message for not selecting any Supplier is displaying.", true);
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
		Reporter.log("Checked if error message for not selecting any meter is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		Reporter.log("Checked if error message for not selecting any Supplier is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();
	}

	public void verifyAlertmessageWhen2ContractDurations_selectsSameMonth_nHH() {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_nHHUtility();
		selectByIndex(contractDuration_nHH, 02);
		Reporter.log("Selected First Contract Duration.", true);
		click(AddContractDuration_nHH);
		Reporter.log("Clicked on add contract Duration", true);
		selectByIndex(contractDuration2_nHH, 02);
		Reporter.log("Selected second Contract Duration.", true);

		boolean errorMessageDisplayStatusForSelecting2SameContractDurations = getText(
				OkAlertTextwhen2sameContractDurationSected).contains("You have already selected that duration");
		Reporter.log("Checked if error message for Selecting 2 same Contract Durations is displaying.", true);
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
		Reporter.log("Checked if error message for not selecting any meter is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
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
		Reporter.log("Checked if error message for not selecting any meter is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
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
		Reporter.log("Checked if error message for not selecting any Supplier is displaying.", true);
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
		Reporter.log("Checked if error message for not selecting any Supplier is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingSuplier,
				"Error message is not displaying for not selecting any supplier.");
		// Assert.assertEquals(actual, expected)

		softAssertion.assertAll();
	}

	public void VerifyErrorMessageWhenSelecting_MultipleMeters_SingleContractDurations_ZeroSupplier_nHH() {
		SoftAssert softAssertion = new SoftAssert();
		SelectElectricity_nHHUtility();
		Options("multiple", "single", "zero");
		ClickTopSubmitButton();

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		Reporter.log("Checked if error message for not selecting any Supplier is displaying.", true);
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
		Reporter.log("Checked if error message for not selecting any meter is displaying.", true);
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
		Reporter.log("Checked if error message for not selecting any meter is displaying.", true);
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
		Reporter.log("Checked if error message for not selecting any meter is displaying.", true);
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
		Reporter.log("Clicked date", true);
		selectPrevDateCalender(27, 8, 2019);
		Thread.sleep(10000);
		ClickTopSubmitButton();

		boolean errorMessageDisplyStatusForEnteringwrongDate = getText(message)
				.contains("Tender date must be at least five days in the future");
		Reporter.log("Checked if error message for Entering wrong Date is displaying.", true);
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
		Reporter.log("Clicked date", true);
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
		Reporter.log("Checked if error message for not selecting any meter is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingMeter,
				"Error message is not displaying for not selecting any meter.");

		boolean errorMessageDisplayStatusForNotSelectingContractDuration = getText(message)
				.contains("Please select contract duration");
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		Reporter.log("Checked if error message for not selecting any supplier is displaying.", true);
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
			Reporter.log("Checked if error message for not selecting any meter is displaying.", true);
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
			Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
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
			Reporter.log("Checked if error message for not selecting any supplier is displaying.", true);
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
		Reporter.log("Checked if error message for not selecting contract duration is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForNotSelectingContractDuration,
				"Error message is not displaying for not entering contract duration.");

		boolean errorMessageDisplayStatusForNotSelectingSuplier = getText(message)
				.contains("Please select at least one supplier for a quote request.");
		Reporter.log("Checked if error message for not selecting any supplier is displaying.", true);
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
		Reporter.log("Selected First Contract Duration.", true);
		click(addNewContractDuration_Gas);
		Reporter.log("Clicked on add contract Duration", true);
		selectByIndex(secondContractDuration_Gas, 02);
		Reporter.log("Selected second Contract Duration.", true);

		boolean errorMessageDisplayStatusForSelecting2SameContractDurations = getText(
				OkAlertTextwhen2sameContractDurationSected).contains("You have already selected that duration");
		Reporter.log("Checked if error message for Selecting 2 same Contract Durations is displaying.", true);
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
		Reporter.log("Checked if error message for Entering wrong Date is displaying.", true);
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
		Reporter.log("Selected First Contract Duration.", true);
		click(addNewContractDuration_Water);
		Reporter.log("Clicked on add contract Duration", true);
		selectByIndex(secondContractDuration_Water, 02);
		Reporter.log("Selected second Contract Duration.", true);

		boolean errorMessageDisplayStatusForSelecting2SameContractDurations = getText(
				OkAlertTextwhen2sameContractDurationSected).contains("You have already selected that duration");
		Reporter.log("Checked if error message for Selecting 2 same Contract Durations is displaying.", true);
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
		selectPrevDateCalender(05,9,2019);
		Options_Water(NoOfMeter, NoOfContractDur, NoOfSupplier);
		ClickTopSubmitButton();
		
		boolean errorMessageDisplyStatusForEnteringwrongDate = getText(message)
				.contains("Tender date must be at least five days in the future");
		Reporter.log("Checked if error message for Entering wrong Date is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplyStatusForEnteringwrongDate,
				"Error message is not displaying for Entring Wrong Date.");
		// Assert.assertEquals(actual, expected)
		softAssertion.assertAll();
	}
	public void verifyAlertMesage_After_Selecting_DifferentCombinations_Of_Meter_ContractDuration_AndFutureDate_Supplier_Water(
			String NoOfMeter, String NoOfContractDur, String NoOfSupplier) {
		clickWaterUtility();
		ClickDate_Water();
		selectPrevDateCalender(15,9,2019);
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
		Reporter.log("Selected First Contract Duration.", true);
		click(addNewContractDuration_Water);
		Reporter.log("Clicked on add contract Duration", true);
		selectByIndex(secondContractDuration_Water, 02);
		Reporter.log("Selected second Contract Duration.", true);

		boolean errorMessageDisplayStatusForSelecting2SameContractDurations = getText(
				OkAlertTextwhen2sameContractDurationSected).contains("You have already selected that duration");
		Reporter.log("Checked if error message for Selecting 2 same Contract Durations is displaying.", true);
		softAssertion.assertTrue(errorMessageDisplayStatusForSelecting2SameContractDurations,
				"Error message is not displaying for selecting 2 same contract durations.");

		softAssertion.assertAll();
	}
}
