package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FlexTenderResponsePage extends AdminDashboardPage {

	By byDate = By.xpath("//select[@id='QuoteByDate']");
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

	String After15days = addDaysToCurrentDate(15);

	public void selectByDate() throws Throwable {

		selectByVisibleText(byDate, After15days);
		selectByIndex(requestQuote,01);
		click(meterForeCast);
		enterDataIntoMeterForeCast();
		click(submitSave);
		selectByIndex(quotes,01);
		click(quoteInformation);
		setValue(tollerance, "20");
		setValue(productName, "ABCD");
		click(ccl);
		enterDateInToFlexQuoteInformation();
		click(submitSave);
		
	}

	public void enterDataIntoMeterForeCast() throws Throwable {
		for (int i = 1; i <= 12; i++) {
			String Data = readExcelData("sheet5", 9, i);
			By ele = By.xpath("//tbody//tr[" + i + "]//td[6]//input");
			setValue(ele, Data);
			enterDateInToFlexQuoteInformation();
		}
	}

	public void enterDateInToFlexQuoteInformation() throws Throwable {

		int RowNum = driver.findElements(NoOfRowsInQuoteInformationTable).size();
		for (int i = 1; i <= RowNum; i++) {
			String Data = readExcelData("sheet4", 12, i);
			By dropDown_ele = By.xpath("//table[@id='meter-information-table']//tbody//tr[" + i + "]//td[2]//select");
			selectByIndex(dropDown_ele, 2);
			By text_ele = By.xpath("//table[@id='meter-information-table']//tbody//tr[" + i + "]//td[]//input");
			setValue(text_ele, Data);

		}
		for (int i = 1; i <= 12; i++) {

			String Data = readExcelData("sheet5", 9, i);
			By ele = By.xpath("//table[@id='meter-forecasts']//tbody//tr[" + i + "]/td[4]//input");
			setValue(ele, Data);
		}
	}

}
