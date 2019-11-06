package com.oem.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.oem.framework.core.base.BasePage;

public class FlexTenderResponsePage extends AdminDashboardPage {
	WebElement form;
	By byDate = By.id("QuoteByDate");
	By byDate2 = By.xpath("//select[@id = 'QuoteByDate']");
	By requestQuote = By.xpath("//select[@id='QuoteRequestId']");
	By maroonClick = By.xpath("//i[@class='icon-edit'][contains(@style,'color: maroon')]");
	By greenClick = By.xpath("//i[@style='color: green'][@class='icon-check']");

	By meterForeCast = By.xpath("//a[text()=' Meter Forecasts']");
	By meter_ElectricityTLosses = By.xpath("//*[@id='MeterForecastLosses_ElectricityTLosses']");
	By Meter_ElectricityDLosses = By.xpath("//*[@id='MeterForecastLosses_ElectricityDLosses']");
	By saveButton = By.xpath("//button[text()='Save']");
	By quotes = By.id("QuoteId");
	By quoteInformation = By.xpath("//a[text()=' Quote Information']");

	By tollerance = By.xpath("//input[@id='Quote_Tolerance']");
	By productName = By.id("Quote_ProductName");
	By renewable = By.xpath("//a[@id='green3state']");
	By renewableDiscount = By.id("Quote_RenewableDiscount");
	By sContractCost = By.xpath("//a[@id='managementfee3state']");
	By netWorkCost = By.xpath("//a[@id='bsuos3state']");
	By envirnCharge = By.xpath("//a[@id='duos3state']");
	By ccl = By.xpath("//a[@id='ccl3state']");
	By paymentTerms = By.xpath("//a[@id='paymentterms3state']");
	By billingSetUp = By.xpath("//a[@id='billingsetup3state']");
	By passedCredit = By.xpath("//a[@id='passedcredit3state']");

	By NoOfRowsInQuoteInformationTable = By.xpath("//table[@id='meter-information-table']//tbody//tr");
	By submitSave = By.xpath("//button[text()='Save']");// ("submit");
	By OkButton = By.xpath("//button[text()='OK']");
	
	By cancelButton=By.xpath("//button[text()='Cancel']");
	By secondSave=By.id("submit");
	String After15days = addDaysToCurrentDate(14);
	String currentDate = getCuttrentDate();

	By notifyCustomer=By.id("send-email");
	By finalSubmitButton=By.id("submit-quote-button");
	
	@Override
	protected void isLoaded() throws Error {
		System.out.println("Executing isLoaded in Flexible Tender Response Page");
		Assert.assertTrue(isElementPresent(byDate2), "Flexible Profile Manager Page didnt appear");
	}

	public void verifyFlexTenderResponseHomePage() {
		System.out.println("Days:" + After15days);
		System.out.println("Current Date Is :" + currentDate);
		// driver.switchTo().frame(driver.findElement(By.id("by-date-selection")));
		Assert.assertTrue(isElementPresent(byDate), "Home Page is not displyed");
		// driver.switchTo().defaultContent();
	}

	public void selectdesiredvalueFromDropDown(By Locator, String Element) {
		Select se = new Select(driver.findElement(Locator));
		click(Locator);
		java.util.List<WebElement> l = se.getOptions();
		int x = l.size();// size of drop down date
		for (WebElement element : l) {
			if (element.getText().contains(Element))
				element.click();
		}
	}

	/*
	 * //new WebDriverWait(driver,
	 * 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "//input[@class='input_fromto checkSpecialCharacters ui-autocomplete-input' and @id='hp-widget__sfrom']"
	 * ))).click(); //List<WebElement> myList = new WebDriverWait(driver,
	 * 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byDate));
	 * //for (WebElement element: myList)
	 * if(element.getText().contains("Mumbai")) element.click();
	 */

	public void verifyQuoteRequestAfetrSelectingDate() throws Throwable {
		Thread.sleep(3000);
		Reporter.log("Navigated to flex tender response", true);
		// selectByVisibleText(byDate2, "16/11/2019 (21)");
		selectByValue(byDate2, After15days);
		Thread.sleep(3000);
		Reporter.log("Selected value from DropDrown.", true);
		Assert.assertTrue(isElementPresent(requestQuote), "Request Quote Is Not Present");

	}

	public void verifyMeterForeCastAfetrSelectingRequestQuote() {
		selectByValue(byDate, After15days);
		// selectdesiredvalueFromDropDown(byDate, After15days);
		selectByIndex(requestQuote, 1);
		// selectdesiredvalueFromDropDown(requestQuote, "HH");
		Assert.assertTrue(isElementPresent(meterForeCast), "MeterForeCast Is Not Present");
	}

	public void verifyElementsAfterClickingmeterforecast() throws Throwable {
		selectByValue(byDate, After15days);
		// selectdesiredvalueFromDropDown(byDate, After15days);
		selectByIndex(requestQuote, 1);
		// selectdesiredvalueFromDropDown(requestQuote, "HH");
		click(meterForeCast);

		Assert.assertTrue(isElementPresent(meter_ElectricityTLosses), "meter_ElectricityTLosses Is Not Present");
		Assert.assertTrue(isElementPresent(Meter_ElectricityDLosses), "Meter_ElectricityDLosses Is Not Present");

	}

	public void verifymeterforecastafterenetringNoData() throws Throwable {
		selectByValue(byDate, After15days);
		// selectdesiredvalueFromDropDown(byDate, After15days);
		selectByIndex(requestQuote, 1);
		// selectdesiredvalueFromDropDown(requestQuote, "HH");
		click(meterForeCast);

		click(submitSave);
		Assert.assertTrue(isAlertPresent(), "Alert is Not Present,Its Accepting Even when we dont enetr any data");

	}

	public void verifymeterforecastTextFields() throws Throwable {
		// selectByIndex(byDate,x);
		SoftAssert softAssertion = new SoftAssert();
		selectByValue(byDate, After15days);
		selectByIndex(requestQuote, 1);
		// selectdesiredvalueFromDropDown(requestQuote, "HH");
		click(meterForeCast);
		String atribute=getAttribute(meter_ElectricityTLosses,"type");
		if(atribute.equals("numbers")){
			System.out.println("meter_ElectricityTLosses text field will accept only Valid Numbers");
		}
		softAssertion.assertTrue(atribute.equals("numbers"),
				"Electricity Transmission Losses % is Accepting Other Than valid Numbers Values.");
		String atribute1=getAttribute(Meter_ElectricityDLosses,"type");
		if(atribute1.equals("numbers")){
			System.out.println("meter_ElectricityDLosses text field will accept only Valid Numbers");
		}
		softAssertion.assertTrue(atribute1.equals("numbers"),
				"Electricity Distribution Losses % is Accepting Other Than valid Numbers Values.");
		for (int i = 1; i <= 5; i++) {
			String typeOfValue = readExcelData("sheet5", 13, i);
			String TLossesInvalidData = readExcelData("sheet5", 14, i);

			String DLossesInvalidData = readExcelData("sheet5", 15, i);

			setValue(meter_ElectricityTLosses, TLossesInvalidData);
			Thread.sleep(3000);
			setValue(Meter_ElectricityDLosses, DLossesInvalidData);
			Thread.sleep(3000);
			String l = getText(meter_ElectricityTLosses);
			String d = getText(Meter_ElectricityDLosses);
			boolean displaystatusOfTLoss = l.contains(TLossesInvalidData);
			Thread.sleep(3000);
			boolean displaystatusOfDLoss = d.contains(DLossesInvalidData);
			Thread.sleep(3000);
			
			softAssertion.assertTrue(displaystatusOfTLoss,
					"Electricity Transmission Losses % is Accepting " + typeOfValue + " Values.");
			softAssertion.assertTrue(displaystatusOfDLoss,
					"Electricity Distribution Losses % " + typeOfValue + " Values.");
			System.out.println(getText(meter_ElectricityTLosses));
			System.out.println(getText(Meter_ElectricityDLosses));
			for (int j = 1; j <= 12; j++) {
				//String Data = readExcelData("sheet5", 11, i);
				By ele = By.xpath("//tbody//tr[" + j + "]//td[6]//input");
				setValue(ele, TLossesInvalidData);
				String monthsData=getText(ele);
				boolean verifymonthsData=monthsData.contains(TLossesInvalidData);
				softAssertion.assertTrue(verifymonthsData,
						"month "+j+" is Accepting " + typeOfValue + " Values.");
				// enterDateInToFlexQuoteInformation();
			}
			// softAssertion.assertAll();
		}
		

		softAssertion.assertAll();

	}

	public void verifymeterHHforecastafterenetringInvalidData() throws Throwable {
		selectByValue(byDate, After15days);
		// selectdesiredvalueFromDropDown(byDate, After15days);
		selectByIndex(requestQuote, 1);
		// selectdesiredvalueFromDropDown(requestQuote, "HH");
		click(meterForeCast);

		enterInvalidDataIntoMeterHHForeCast();
		click(submitSave);
		Assert.assertTrue(isAlertPresent(), "Alert is Not Present,Its Accepting Invalid Negative Data");

	}

	public void verifyingTextFieldNotacceptsAlphabetsIntoMeterHH() throws Throwable {
		selectByValue(byDate, After15days);
		// selectdesiredvalueFromDropDown(byDate, After15days);
		selectByIndex(requestQuote, 1);
		// selectdesiredvalueFromDropDown(requestQuote, "HH");
		click(meterForeCast);
		enterInvalidDataAlphabetsIntoMeterHHForeCast();
		click(submitSave);
		Assert.assertTrue(isAlertPresent(), "Alert is Not Present,Its Accepting Invalid Alphabets Data");

	}

	public void verifyingQuotesDropDwonAfterEnteringValidDataInMeterHHForeCast() throws Throwable {

		selectByValue(byDate, After15days);

		selectByIndex(requestQuote, 1);
		click(meterForeCast);
		enterValidDataIntoMeterHHForeCast();
		click(submitSave);
		Thread.sleep(3000);
		Assert.assertTrue(isElementPresent(quotes), "Quotes DropDown is Not Present,Its Not Accepting Valid  Data");

	}

	public void verifyingQuotesInformationAfterSelectingHHDropDwon() throws Throwable {

		selectByValue(byDate, After15days);

		selectByIndex(requestQuote, 1);
		//selectdesiredvalueFromDropDown(requestQuote, "HH");
		if (isElementPresent(greenClick)) {
			selectdesiredvalueFromDropDown(quotes, "EON");
		} else {

			click(meterForeCast);
			enterValidDataIntoMeterHHForeCast();
			click(submitSave);

			Thread.sleep(3000);
			selectdesiredvalueFromDropDown(quotes, "EON");
		}
		// selectByVisibleText(quotes, "EON");

		Assert.assertTrue(isElementPresent(quoteInformation), "QuoteInformation Link is Not Present");

	}

	public void verifyingQuotesInformationHomePageAfterclickingQouteInformationLink() throws Throwable {

		selectByValue(byDate, After15days);

		selectByIndex(requestQuote, 1);
		
		if (isElementPresent(greenClick)) {
			selectdesiredvalueFromDropDown(quotes, "EON");
		} else {
			click(meterForeCast);
			enterValidDataIntoMeterHHForeCast();
			click(submitSave);
			Thread.sleep(3000);
			selectdesiredvalueFromDropDown(quotes, "EON");
		}

		click(quoteInformation);

		Assert.assertTrue(isElementPresent(tollerance), "tollerance Text is Not Present");
		Assert.assertTrue(isElementPresent(productName), "productName Text is Not Present");
		Assert.assertTrue(isElementPresent(renewable), "renewable Text is Not Present");
		Assert.assertTrue(isElementPresent(renewableDiscount), "renewableDiscount Text is Not Present");
	}

	public void verifyingFexQuoteInformationPageAfterEnteringNoData() throws Throwable {

		selectByValue(byDate, After15days);

		selectByIndex(requestQuote, 1);
		if(isElementPresent(greenClick)){
			selectdesiredvalueFromDropDown(quotes, "EON");
		}else{
		click(meterForeCast);
		enterValidDataIntoMeterHHForeCast();
		click(submitSave);
		Thread.sleep(3000);

		selectdesiredvalueFromDropDown(quotes, "EON");
		}
		
		click(quoteInformation);
		Thread.sleep(2000);

		click(secondSave);
		Thread.sleep(2000);
		click(OkButton);
		

		Assert.assertTrue(isElementPresent(tollerance), "tollerance Text is Not Present");
		Assert.assertTrue(isElementPresent(productName), "productName Text is Not Present");
		Assert.assertTrue(isElementPresent(renewable), "renewable Text is Not Present");
		Assert.assertTrue(isElementPresent(renewableDiscount), "renewableDiscount Text is Not Present");
	}

	public void verifyingFexQuoteInformationPageAfterEnteringNegativeData() throws Throwable {

		selectByValue(byDate, After15days);

		selectByIndex(requestQuote, 1);
		// click(meterForeCast);
		// enterValidDataIntoMeterHHForeCast();
		// click(submitSave);
		Thread.sleep(3000);

		selectdesiredvalueFromDropDown(quotes, "EON");
		click(quoteInformation);
		Thread.sleep(2000);
		enternegativeDataInToFlexHHUtilityQuoteInformation();
		click(secondSave);
		// click(OkButton);
		Thread.sleep(2000);

		Assert.assertTrue(isElementPresent(tollerance), "tollerance Text is Not Present");
		Assert.assertTrue(isElementPresent(productName), "productName Text is Not Present");
		Assert.assertTrue(isElementPresent(renewable), "renewable Text is Not Present");
		Assert.assertTrue(isElementPresent(renewableDiscount), "renewableDiscount Text is Not Present");
	}

	public void verifyingFexQuoteInformationPageAfterEnteringSpecialData() throws Throwable {

		selectByValue(byDate, After15days);

		selectByIndex(requestQuote, 1);
		// click(meterForeCast);
		// enterValidDataIntoMeterHHForeCast();
		// click(submitSave);
		Thread.sleep(3000);

		selectdesiredvalueFromDropDown(quotes, "EON");
		
		click(quoteInformation);
		Thread.sleep(2000);
		enterSpecialCharacterInToFlexHHUtilityQuoteInformation();
		click(secondSave);
		// click(OkButton);
		Thread.sleep(2000);

		Assert.assertTrue(isElementPresent(tollerance), "tollerance Text is Not Present");
		Assert.assertTrue(isElementPresent(productName), "productName Text is Not Present");
		Assert.assertTrue(isElementPresent(renewable), "renewable Text is Not Present");
		Assert.assertTrue(isElementPresent(renewableDiscount), "renewableDiscount Text is Not Present");
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	}

	public void selectByDate() throws Throwable {

		selectByVisibleText(byDate, After15days);
		selectByIndex(requestQuote, 01);
		click(meterForeCast);
		// enterDataIntoMeterForeCast();
		click(submitSave);
		selectByIndex(quotes, 01);
		click(quoteInformation);
		setValue(tollerance, "20");
		setValue(productName, "ABCD");
		click(ccl);
		// enterDateInToFlexQuoteInformation();
		click(submitSave);

	}

	public void enterInvalidDataIntoMeterGasForeCast() throws Throwable {
		for (int i = 1; i <= 12; i++) {
			String Data = readExcelData("sheet5", 10, i);
			By ele = By.xpath("//tbody//tr[" + i + "]//input");
			setValue(ele, Data);
			// enterDateInToFlexQuoteInformation();
		}
	}

	public void enterInvalidDataIntoMeterHHForeCast() throws Throwable {
		setValue(meter_ElectricityTLosses, "-10");
		setValue(Meter_ElectricityDLosses, "-20");
		for (int i = 1; i <= 12; i++) {
			String Data = "-10";
			By ele = By.xpath("//tbody//tr[" + i + "]//td[6]//input");
			setValue(ele, Data);

		}
	}

	public void enterInvalidDataAlphabetsIntoMeterGasForeCast() throws Throwable {

		for (int i = 1; i <= 12; i++) {
			String Data = "ABCD";
			By ele = By.xpath("//tbody//tr[" + i + "]//input");
			setValue(ele, Data);

		}
	}

	public void enterInvalidDataAlphabetsIntoMeterHHForeCast() throws Throwable {
		setValue(meter_ElectricityTLosses, "ABCD");
		setValue(Meter_ElectricityDLosses, "ABVD");
		for (int i = 1; i <= 12; i++) {
			String Data = readExcelData("sheet5", 11, i);
			By ele = By.xpath("//tbody//tr[" + i + "]//td[6]//input");
			setValue(ele, Data);
			// enterDateInToFlexQuoteInformation();
		}
	}

	public void enterValidDataIntoMeterHHForeCast() throws Throwable {
		setValue(meter_ElectricityTLosses, "20");
		setValue(Meter_ElectricityDLosses, "20");
		for (int i = 1; i <= 12; i++) {
			String Data = "20";// readExcelData("sheet5", 11, i);
			By ele = By.xpath("//tbody//tr[" + i + "]//td[6]//input");
			setValue(ele, Data);
			// enterDateInToFlexQuoteInformation();
		}
	}

	public void enterInvalidDataSpecialCharctersIntoMeterGasForeCast() throws Throwable {

		for (int i = 1; i <= 12; i++) {
			String Data = "!@#$%^&";
			By ele = By.xpath("//tbody//tr[" + i + "]//input");
			setValue(ele, Data);
			// enterDateInToFlexQuoteInformation();
		}
	}

	public void enterInvalidDataSpecialCharctersIntoMeterHHForeCast() throws Throwable {

		selectByValue(byDate, After15days);
		selectByIndex(requestQuote, 01);
		click(meterForeCast);

		setValue(meter_ElectricityTLosses, "!@#$%^&");
		setValue(Meter_ElectricityDLosses, "!@#$%^&");
		for (int i = 1; i <= 12; i++) {
			String Data = "!@#$%^&";
			By ele = By.xpath("//tbody//tr[" + i + "]//td[6]//input");
			setValue(ele, Data);

		}
		click(submitSave);
		Assert.assertTrue(isAlertPresent(), "its accepting Special charecters");

	}

	public void enterDataIntoMeterGasForeCast() throws Throwable {
		for (int i = 1; i <= 12; i++) {
			String Data = readExcelData("sheet5", 9, i);
			By ele = By.xpath("//tbody//tr[" + i + "]//input");
			setValue(ele, Data);
			// enterDateInToFlexQuoteInformation();
		}
	}// table[@id='meter-forecasts']//tbody//tr/td[6]//input

	public void enterDataIntoMeterHHForeCast() throws Throwable {
		for (int i = 1; i <= 12; i++) {
			String Data = readExcelData("sheet5", 9, i);
			By ele = By.xpath("//tbody//tr[" + i + "]//td[6]//input");
			setValue(ele, Data);
			// enterDateInToFlexQuoteInformation();
		}
	}

	public void enternegativeDataInToFlexHHUtilityQuoteInformation() throws Throwable {
		setValue(tollerance, "-10");
		setValue(productName, "-10");
		setValue(renewableDiscount, "-10");
		click(ccl);
		int RowNum = driver.findElements(NoOfRowsInQuoteInformationTable).size();
		for (int i = 1; i <= RowNum; i++) {
			// String Data = readExcelData("sheet4", 12, i);
			By dropDown_ele = By.xpath("//table[@id='meter-information-table']//tbody//tr[" + i + "]//td[2]//select");
			selectByIndex(dropDown_ele, 2);
			By text_ele = By.xpath("//table[@id='meter-information-table']//tbody//tr[" + i + "]//td[3]//input");
			setValue(text_ele, "-10");

		}
		for (int i = 1; i <= 12; i++) {

			// String Data = readExcelData("sheet5", 9, i);
			By ele = By.xpath("//table[@id='meter-forecasts']//tbody//tr[" + i + "]/td[4]//input");
			setValue(ele, "-10");
		}
	}

	public void enterSpecialCharacterInToFlexHHUtilityQuoteInformation() throws Throwable {
		setValue(tollerance, "!@#$$%");
		setValue(productName, "!@#$$%");
		setValue(renewableDiscount, "!@#$$%");
		click(ccl);
		int RowNum = driver.findElements(NoOfRowsInQuoteInformationTable).size();
		for (int i = 1; i <= RowNum; i++) {
			// String Data = readExcelData("sheet4", 12, i);
			By dropDown_ele = By.xpath("//table[@id='meter-information-table']//tbody//tr[" + i + "]//td[2]//select");
			selectByIndex(dropDown_ele, 2);
			By text_ele = By.xpath("//table[@id='meter-information-table']//tbody//tr[" + i + "]//td[3]//input");
			setValue(text_ele, "!@#$$%");

		}
		for (int i = 1; i <= 12; i++) {

			// String Data = readExcelData("sheet5", 9, i);
			By ele = By.xpath("//table[@id='meter-forecasts']//tbody//tr[" + i + "]/td[4]//input");
			setValue(ele, "!@#$$%");
		}
	}
	public void verifyFlexQuoteInformationTextFields() throws Throwable {
		// selectByIndex(byDate,x);
		SoftAssert softAssertion = new SoftAssert();
		selectByValue(byDate, After15days);

		selectByIndex(requestQuote, 1);
		// click(meterForeCast);
		// enterValidDataIntoMeterHHForeCast();
		// click(submitSave);
		Thread.sleep(3000);

		selectdesiredvalueFromDropDown(quotes, "EON");
		click(quoteInformation);
		
		for (int i = 1; i <= 5; i++) {
			String typeOfValue = readExcelData("sheet5", 13, i);
			String InvalidDatas = readExcelData("sheet5", 14, i);
			
			//String DLossesInvalidData = readExcelData("sheet5", 15, i);

			setValue(tollerance, InvalidDatas);
			Thread.sleep(3000);
			setValue(productName, InvalidDatas);
			Thread.sleep(3000);
			setValue(renewableDiscount, InvalidDatas);
			String l = getText(tollerance);
			String d = getText(productName);
			String k=getText(renewableDiscount);
			boolean displaystatusTollerance = l.contains(InvalidDatas);
			Thread.sleep(3000);
			boolean displaystatusProductName = d.contains(InvalidDatas);
			Thread.sleep(3000);
			boolean displaystatusrenewableDiscount = d.contains(InvalidDatas);
			Thread.sleep(3000);
			softAssertion.assertTrue(displaystatusTollerance,
					"TolleranceText Field is Accepting " + typeOfValue + " Values.");
			softAssertion.assertFalse(displaystatusProductName,
					"ProductName is Accepting " + typeOfValue + " Values.");
			softAssertion.assertTrue(displaystatusrenewableDiscount,
					"RenewableDiscount is Accepting " + typeOfValue + " Values.");
			
			
			int RowNum = driver.findElements(NoOfRowsInQuoteInformationTable).size();
			for (int j = 1; j <= RowNum; j++) {
				// String Data = readExcelData("sheet4", 12, i);
				By element =By.xpath("//table[@id='meter-information-table']//tbody//tr[" + j + "]//td[1]/label");
				String ElementText=getText(element);
				By dropDown_ele = By.xpath("//table[@id='meter-information-table']//tbody//tr[" + j + "]//td[2]//select");
				selectByIndex(dropDown_ele, 2);
				By text_ele = By.xpath("//table[@id='meter-information-table']//tbody//tr[" + j + "]//td[3]//input");
				setValue(text_ele, InvalidDatas);
				Thread.sleep(3000);
				String firstValue=getText(text_ele);
				boolean displayElementvalue = firstValue.contains(InvalidDatas);
				softAssertion.assertTrue(displayElementvalue,
						"Element "+ElementText+" Text Field is Accepting " + typeOfValue + " Values.");

			}
			for (int z = 1; z <= 12; z++) {

				By month=By.xpath("//table[@id='meter-forecasts']//tbody//tr[" + z + "]/td[1]");
				String monthText=getText(month);
				// String Data = readExcelData("sheet5", 9, i);
				By ele = By.xpath("//table[@id='meter-forecasts']//tbody//tr[" + z + "]/td[4]//input");
				setValue(ele, InvalidDatas);
				String monthValue=getText(ele);
				boolean displayMonthvalue = monthValue.contains(InvalidDatas);
				softAssertion.assertTrue(displayMonthvalue,
						"Month "+monthText+" Text Field is Accepting " + typeOfValue + " Values.");

			}
		}
		

		softAssertion.assertAll();

	}

	public void enterDataInToFlexHHUtilityQuoteInformation() throws Throwable {

		int RowNum = driver.findElements(NoOfRowsInQuoteInformationTable).size();
		for (int i = 1; i <= RowNum; i++) {
			String Data = readExcelData("sheet4", 12, i);
			By dropDown_ele = By.xpath("//table[@id='meter-information-table']//tbody//tr[" + i + "]//td[2]//select");
			selectByIndex(dropDown_ele, 2);
			By text_ele = By.xpath("//table[@id='meter-information-table']//tbody//tr[" + i + "]//td[3]//input");
			setValue(text_ele, Data);

		}
		for (int i = 1; i <= 12; i++) {

			String Data = readExcelData("sheet5", 9, i);
			By ele = By.xpath("//table[@id='meter-forecasts']//tbody//tr[" + i + "]/td[4]//input");
			setValue(ele, Data);
		}
	}
	public void enterValidInToFlexHHUtilityQuoteInformation() throws Throwable {
		setValue(tollerance, readExcelData("sheet5", 22, 1));
		setValue(productName, readExcelData("sheet5", 23, 1));
		setValue(renewableDiscount, readExcelData("sheet5", 24, 1));
		click(ccl);
		int RowNum = driver.findElements(NoOfRowsInQuoteInformationTable).size();
		for (int i = 1; i <= RowNum; i++) {
			 String Data = readExcelData("sheet5", 25, 1);
			By dropDown_ele = By.xpath("//table[@id='meter-information-table']//tbody//tr[" + i + "]//td[2]//select");
			selectByIndex(dropDown_ele, 2);
			By text_ele = By.xpath("//table[@id='meter-information-table']//tbody//tr[" + i + "]//td[3]//input");
			setValue(text_ele, Data);

		}
		for (int i = 1; i <= 12; i++) {

			 String Data = readExcelData("sheet5", 26, 1);
			By ele = By.xpath("//table[@id='meter-forecasts']//tbody//tr[" + i + "]/td[4]//input");
			setValue(ele, Data);
		}
	}
	public void verifyingsubmitButtonAfterEnteringValidFexQuoteInformationAndclickingSave57() throws Throwable {

		selectByValue(byDate, After15days);

		selectByIndex(requestQuote, 1);
		// click(meterForeCast);
		// enterValidDataIntoMeterHHForeCast();
		// click(submitSave);
		Thread.sleep(3000);

		selectdesiredvalueFromDropDown(quotes, "EON");
		
		click(quoteInformation);
		Thread.sleep(2000);
		enterValidInToFlexHHUtilityQuoteInformation();
		click(secondSave);
		Assert.assertTrue(isElementPresent(notifyCustomer), "Notify Customer Is Not Present");
		Assert.assertTrue(isElementPresent(finalSubmitButton),"Submit Button is not present");
	}
	public void verifyconformatonpopAfterClikingSbmitButton(){
		click(notifyCustomer);
		click(finalSubmitButton);
		Assert.assertTrue(isElementPresent(cancelButton), "Cancel Button Is Not Present");
		Assert.assertTrue(isElementPresent(OkButton), "Ok Button Is Not Present");
	}
	public void verifyconformatonpopsesAftercloAfterClikingcancelButton(){
		click(cancelButton);
		
		Assert.assertTrue(isElementPresent(finalSubmitButton), "Submit Button is not present after canceling the submit popup");
	}
	public void verifyflexResponsePageAfterClikingOkButtonOnSubmitPopUp() throws Throwable{
		click(finalSubmitButton);
		click(OkButton);
		Thread.sleep(3000);
		By finalOk=By.xpath("//a[text()='Ok']");
		click(finalOk);
		Thread.sleep(3000);
		Assert.assertTrue(isElementPresent(byDate), " ByDate DropDown is not present after submitting request");
	}
	public void EnterValidDataIntoTheTextFields() throws Throwable {

		selectByValue(byDate, After15days);

		selectByIndex(requestQuote, 1);
		click(meterForeCast);
		enterValidDataIntoMeterHHForeCast();
		click(submitSave);
		Thread.sleep(3000);

		selectdesiredvalueFromDropDown(quotes, "EON");

		click(quoteInformation);
		Thread.sleep(2000);
		enterValidInToFlexHHUtilityQuoteInformation();
		click(secondSave);
		}
	public void clickSubmitDetails() throws Throwable{
		click(notifyCustomer);
		click(finalSubmitButton);
		click(OkButton);
		Thread.sleep(3000);
		By finalOk=By.xpath("//a[text()='Ok']");
		click(finalOk);
		}
}
