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
	By meter_ElectricityTLosses = By.id("MeterForecastLosses_ElectricityTLosses");
	By Meter_ElectricityDLosses = By.id("MeterForecastLosses_ElectricityDLosses");
	By saveButton = By.xpath("//button[text()='Save']");
	By quotes = By.id("QuoteId");
	By quoteInformation = By.xpath("//a[text()=' Quote Information']");

	By tollerance = By.xpath("Quote_Tolerance");
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
	By submitSave = By.id("submit");
	By OkButton = By.xpath("//button[text()='OK']");

	String After15days = addDaysToCurrentDate(14);
	String currentDate = getCuttrentDate();

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
		selectByVisibleText(byDate2, "16/11/2019 (21)");
		// selectByValue(byDate2, "16/11/2019");
		Thread.sleep(3000);
		Reporter.log("Selected value from dd.", true);
		Assert.assertTrue(isElementPresent(requestQuote), "Request Quote Is Not Present");

	}

	public void verifyMeterForeCastAfetrSelectingRequestQuote() {
		// selectByIndex(byDate,x);
		selectdesiredvalueFromDropDown(byDate, After15days);
		// selectByIndex(quotes,1);
		selectdesiredvalueFromDropDown(requestQuote, "HH");
		Assert.assertTrue(isElementPresent(meterForeCast), "MeterForeCast Is Not Present");
	}

	public void verifyElementsAfterClickingmeterforecast() throws Throwable {
		// selectByIndex(byDate,x);
		selectdesiredvalueFromDropDown(byDate, After15days);
		// selectByIndex(quotes,1);
		selectdesiredvalueFromDropDown(requestQuote, "HH");
		click(meterForeCast);

		Assert.assertTrue(isElementPresent(meter_ElectricityTLosses), "meter_ElectricityTLosses Is Not Present");
		Assert.assertTrue(isElementPresent(Meter_ElectricityDLosses), "Meter_ElectricityDLosses Is Not Present");

	}

	public void verifymeterforecastafterenetringNoData() throws Throwable {
		// selectByIndex(byDate,x);
		selectdesiredvalueFromDropDown(byDate, After15days);
		// selectByIndex(quotes,1);
		selectdesiredvalueFromDropDown(requestQuote, "HH");
		click(meterForeCast);

		click(submitSave);
		Assert.assertTrue(isAlertPresent(), "Alert is Not Present,Its Accepting Even when we dont enetr any data");
		driver.switchTo().alert().accept();

	}

	public void verifymeterHHforecastafterenetringInvalidData() throws Throwable {
		// selectByIndex(byDate,x);
		selectdesiredvalueFromDropDown(byDate, After15days);
		// selectByIndex(quotes,1);
		selectdesiredvalueFromDropDown(requestQuote, "HH");
		click(meterForeCast);

		enterInvalidDataIntoMeterHHForeCast();
		click(submitSave);
		Assert.assertTrue(isAlertPresent(), "Alert is Not Present,Its Accepting Invalid Data");
		

	}

	public void verifyingTextFieldNotacceptsAlphabetsIntoMeterHH() throws Throwable {
		// selectByIndex(byDate,x);
		selectdesiredvalueFromDropDown(byDate, After15days);
		// selectByIndex(quotes,1);
		selectdesiredvalueFromDropDown(requestQuote, "HH");
		click(meterForeCast);
		enterInvalidDataAlphabetsIntoMeterHHForeCast();
		click(submitSave);
		Assert.assertTrue(isAlertPresent(), "Alert is Not Present,Its Accepting Invalid Alphabets Data");

	}

	public void verifyingQuotesDropDwonAfterEnteringValidDataInMeterHHForeCast() throws Throwable {

		selectdesiredvalueFromDropDown(byDate, After15days);

		selectdesiredvalueFromDropDown(requestQuote, "HH");
		click(meterForeCast);
		enterValidDataIntoMeterHHForeCast();
		click(submitSave);
		Thread.sleep(3000);
		Assert.assertTrue(isElementPresent(quotes), "Quotes DropDown is Not Present,Its Not Accepting Valid  Data");

	}

	public void verifyingQuotesInformationAfterSelectingHHDropDwon() throws Throwable {

		selectdesiredvalueFromDropDown(byDate, After15days);

		selectdesiredvalueFromDropDown(requestQuote, "HH");
		click(meterForeCast);
		enterValidDataIntoMeterHHForeCast();
		click(submitSave);
		Thread.sleep(3000);

		selectdesiredvalueFromDropDown(quotes, "EON");

		Assert.assertTrue(isElementPresent(quoteInformation), "QuoteInformation Link is Not Present");

	}

	public void verifyingQuotesInformationHomePageAfterclickingQouteInformationLink() throws Throwable {

		selectdesiredvalueFromDropDown(byDate, After15days);

		selectdesiredvalueFromDropDown(requestQuote, "HH");
		click(meterForeCast);
		enterValidDataIntoMeterHHForeCast();
		click(submitSave);
		Thread.sleep(3000);

		selectdesiredvalueFromDropDown(quotes, "EON");
		click(quoteInformation);

		Assert.assertTrue(isElementPresent(tollerance), "tollerance Text is Not Present");
		Assert.assertTrue(isElementPresent(productName), "productName Text is Not Present");
		Assert.assertTrue(isElementPresent(renewable), "renewable Text is Not Present");
		Assert.assertTrue(isElementPresent(renewableDiscount), "renewableDiscount Text is Not Present");
	}

	public void verifyingFexQuoteInformationPageAfterEnteringNoData() throws Throwable {

		selectdesiredvalueFromDropDown(byDate, After15days);

		selectdesiredvalueFromDropDown(requestQuote, "HH");
		click(meterForeCast);
		enterValidDataIntoMeterHHForeCast();
		click(submitSave);
		Thread.sleep(3000);

		selectdesiredvalueFromDropDown(quotes, "EON");
		click(quoteInformation);
		Thread.sleep(2000);

		click(submitSave);
		click(OkButton);
		Thread.sleep(2000);

		Assert.assertTrue(isElementPresent(tollerance), "tollerance Text is Not Present");
		Assert.assertTrue(isElementPresent(productName), "productName Text is Not Present");
		Assert.assertTrue(isElementPresent(renewable), "renewable Text is Not Present");
		Assert.assertTrue(isElementPresent(renewableDiscount), "renewableDiscount Text is Not Present");
	}
	public void verifyingFexQuoteInformationPageAfterEnteringNegativeData() throws Throwable {

		selectdesiredvalueFromDropDown(byDate, After15days);

		selectdesiredvalueFromDropDown(requestQuote, "HH");
		//click(meterForeCast);
		//enterValidDataIntoMeterHHForeCast();
		//click(submitSave);
		Thread.sleep(3000);

		selectdesiredvalueFromDropDown(quotes, "EON");
		click(quoteInformation);
		Thread.sleep(2000);
		enternegativeDataInToFlexHHUtilityQuoteInformation();
		click(submitSave);
		//click(OkButton);
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
			By ele = By.xpath("//tbody//tr[" + i + "]//tr[6]//input");
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
			String Data = readExcelData("sheet5", 11, i);
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
		setValue(meter_ElectricityTLosses, "!@#$%^&");
		setValue(Meter_ElectricityDLosses, "!@#$%^&");
		for (int i = 1; i <= 12; i++) {
			String Data = "!@#$%^&";
			By ele = By.xpath("//tbody//tr[" + i + "]//td[6]//input");
			setValue(ele, Data);
			
		}
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
		setValue(tollerance,"-10");
		setValue(productName,"-10");
		setValue(renewableDiscount,"-10");
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
	public void verifymeterforecastTextFields() throws Throwable {
		// selectByIndex(byDate,x);
		SoftAssert softAssertion= new SoftAssert();
		selectByValue(byDate, After15days);
		selectByIndex(requestQuote,1);
		//selectdesiredvalueFromDropDown(requestQuote, "HH");
		click(meterForeCast);
	//for(int i=1;i<=5;i++){
		String typeOfValue=readExcelData("sheet5", 13, 1);	
		String TLossesInvalidData=readExcelData("sheet5", 14, 1);
		
		String DLossesInvalidData=readExcelData("sheet5", 15, 1);
		
		setValue(meter_ElectricityTLosses,TLossesInvalidData);
		Thread.sleep(3000);
		setValue(Meter_ElectricityDLosses,DLossesInvalidData);
		Thread.sleep(3000);
		boolean displaystatusOfTLoss=getText(meter_ElectricityTLosses).contains(TLossesInvalidData);
		Thread.sleep(3000);
		boolean displaystatusOfDLoss=getText(Meter_ElectricityDLosses).contains(DLossesInvalidData);
		Thread.sleep(3000);
		softAssertion.assertFalse(displaystatusOfTLoss, "Electricity Transmission Losses % is Accepting "+typeOfValue+" Values.");
		softAssertion.assertFalse(displaystatusOfDLoss, "Electricity Distribution Losses % "+typeOfValue+" Values.");
		System.out.println(getText(meter_ElectricityTLosses));
		System.out.println(getText(Meter_ElectricityDLosses));
		//softAssertion.assertAll();
		//}
		
		softAssertion.assertAll();

	}

}
