package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ForecastingPage extends CustomerDashboardPage	{

	By hhUtility = By.xpath("//div[@data-original-title = '<strong>Half Hourly Electricity</strong> Quotes']");
	By nHHutility = By.xpath("//div[contains(@data-original-title, 'Non Half Hourly Electricity')]");
	By gasUtility = By.xpath("//div[contains(@data-original-title, 'Gas')]");
	
	By forecastYear = By.xpath("//select[@id='ddlForecastMonths']");
	By budgetsBtn = By.xpath("//div[@class='forecast-sub-heading']//button[1]");
	By overviewOrBySite = By.xpath("//div[@id='content']//button[1]");
	By budgetsOrBySite = By.xpath("//body//button[2]");
	By historicalAnalysis = By.xpath("//*[contains(text(), 'Historical Analysis')]");
	By forecastCost = By.id("divForecastCostValue");
	
	
	By forecastCostHomePage=By.xpath("//div[@id='divForecastCostValue']//div[@class='odometer-inside']");
	By nextContactYear=By.id("txtFinancialYearStart");
	By contractYearForAnalysis=By.id("ddlFinancialYear");
	//By projectedCost=By.xpath("//td[@id='tdProjectedCosts']//div[@class='pull-left value odometer odometer-auto-theme']");
	//By bySite = By.linkText("By Site");
//inside BySitePage
	By rowsite=By.xpath("//th[contains(text(),'Site')]");
	By rowMPAN=By.xpath("//th[contains(text(),'MPAN')]");
	By rowContractRenewalData=By.xpath("//th[contains(text(),'Contract renewal date')]");
	By rowContractContractYearvalue=By.xpath("//th[contains(text(),'Current contract year value')]");
	
	
	By bySiteButton=By.xpath("//body//button[2]");
	By hhAlertEnabled=By.xpath("//input[@id='hh-tripwire-alerts-enabled']");
	By nhhAlertEnabled=By.xpath("//input[@id='nhh-tripwire-alerts-enabled']");
	By gasAlertEnabled=By.xpath("//input[@id='gas-tripwire-alerts-enabled']");
	By saveChanges=By.id("save-budgets");
	//inside Budget Elements
	By eleNextContarctYear=By.xpath("//strong[contains(text(),'Next Contract Year Start')]");
	By eleContarctYearForAnalysis=By.xpath("//strong[contains(text(),'Contract Year For Analysis')]");
	By eleTopBudget=By.xpath("//strong[text()='Top Budget']");
	By eleRaisingMarketAlert=By.xpath("//body//div[@id='content']//div//div[1]//div[1]//table[1]//tbody[1]//tr[5]//td[1]//strong[1]");
	By eleFallingMarketAlert=By.xpath("//body//div[@id='content']//div//div[1]//div[1]//table[1]//tbody[1]//tr[6]//td[1]//strong[1]");
	By okAlertPopup=By.xpath("//button[text()='OK']");
	By savechagesDoneAlert=By.xpath("//div[text()='The changes were saved successfully and your revised forecasts are now ready.']");
	By cancelAlert=By.xpath("//button[text()='Cancel']");
	
	By topBuggetText=By.xpath("//input[@id='txtTopBudgetPercentage']");
	By raisingMarketText=By.xpath("//input[@id='txtRisingMarketAlertPercentage']");
	By fallingMarketText=By.xpath("//input[@id='txtFallingMarketAlertPercentage']");
	By currentContractYearCost=By.xpath("//td[@id='tdCurrentFinancialYearCost']//div[@class='odometer-inside']");
	By projectedCost=By.xpath("//div[@class='projected-cost-data-available']//div[@class='odometer-inside']");
	By topBudgetCost=By.xpath("//td[@id='tdTopBudgetCost']//div[@class='odometer-inside']");
	By raisingmarketCost=By.xpath("//td[@id='tdRisingMarketAlert']//div[@class='odometer-inside']");
	By fallingMarketalertCost=By.xpath("//td[@id='tdFallingMarketAlert']//div[@class='odometer-inside']");
	By secondSaveChanges=By.id("save-settings");
	By forecastingReportingEnabled=By.id("forecast-reporting-enabled");
	By alertToselectfrequency=By.xpath("//div[contains(text(),'Please select a forecast reporting frequency before continuing...')]");
	SoftAssert softAssertion = new SoftAssert();
	
	@Override
    protected void isLoaded()  {
		System.out.println("Executing isLoaded in forecasting Page");
        Assert.assertTrue(isElementPresent(hhUtility),"Forecasting Page didn't appear");  
    }
	
	public ForecastingPage verifyUtilityPresence() {
		softAssertion.assertTrue(isElementPresent(hhUtility), "HH utility is not displaying");
		softAssertion.assertTrue(isElementPresent(nHHutility), "HH utility is not displaying");
		softAssertion.assertTrue(isElementPresent(gasUtility), "HH utility is not displaying");
		softAssertion.assertAll();
		return this;
	}
	public ForecastingPage verifyGraphsDisplayAfterSelectingForcastingYear() throws Throwable {
		selectByIndex(forecastYear, 0);
		Thread.sleep(5000);
		if(isElementPresent(forecastYear) == false)
		{
			System.out.println("Current page is budget");
		}
		return this;
	}
	public ForecastingPage verifyHHutility() throws Throwable {
		click(hhUtility);
		selectByVisibleText(forecastYear, "2020 - 2021");
		Thread.sleep(5000);
		//softAssertion.assertTrue(isElementPresent(""), "");
		return this;
	}
	public void clickBySite() throws Throwable {
		Thread.sleep(5000);
		System.out.println("By site display status = " + isElementPresent(bySiteButton));
		click(bySiteButton);
		
		softAssertion.assertTrue(isElementPresent(rowsite), "Row Site Is Not Displyed at Bysite HomePage");
		softAssertion.assertTrue(isElementPresent(rowMPAN), "Row MPAN Is Not Displyed at Bysite HomePage");
		softAssertion.assertTrue(isElementPresent(rowContractRenewalData), "Row ContractRenewalData Is Not Displyed at Bysite HomePage");
		softAssertion.assertTrue(isElementPresent(rowContractContractYearvalue), "Row ContractYearValue Is Not Displyed at Bysite HomePage");
		softAssertion.assertAll();
	}
	public void verifyForecastCost(String year) throws Throwable{
		Thread.sleep(5000);
		click(budgetsBtn);
		Thread.sleep(5000);
		click(nextContactYear);
		Thread.sleep(2000);
		selectFutureDateCalender(1,2,2019);
		selectByVisibleText(contractYearForAnalysis,year);
		Thread.sleep(3000);
		String eleProjectCost=driver.findElement(projectedCost).getText();
		
		click(overviewOrBySite);
		Thread.sleep(6000);
		selectByPartOfVisibleText(forecastYear,year);
		//selectByIndex(forecastYear, 0);
		Thread.sleep(8000);
		String eleForecastCost=driver.findElement(forecastCostHomePage).getText();
		softAssertion.assertTrue(eleForecastCost.equals(eleProjectCost), "Cost is Not Matched for year "+year+" ");
		//click(overviewOrBySite);
		softAssertion.assertAll();
		
		
		
	}
	public void verifyForecastCost1(String year) throws Throwable{
		Thread.sleep(5000);
		click(budgetsBtn);
		Thread.sleep(4000);
		click(nextContactYear);
		Thread.sleep(2000);
		selectFutureDateCalender(1,2,2019);
		selectByVisibleText(contractYearForAnalysis,year);
		Thread.sleep(3000);
		String eleProjectCost=driver.findElement(projectedCost).getText();
		
		click(overviewOrBySite);
		Thread.sleep(10000);
		//selectByPartOfVisibleText(forecastYear,year);
		selectByIndex(forecastYear, 2);
		
		Thread.sleep(10000);
		String eleForecastCost=driver.findElement(forecastCostHomePage).getText();
		softAssertion.assertTrue(eleForecastCost.equals(eleProjectCost), "Cost is Not Matched for the year "+year);
		//click(overviewOrBySite);
		softAssertion.assertAll();
		
		
		
	}
	public void verifyOnlyHHutilityDetailAreDisplyed() throws Throwable{
		click(hhUtility);
		Thread.sleep(3000);
		softAssertion.assertTrue(isElementPresent(overviewOrBySite),"Overview Button is Not Displyed");
		softAssertion.assertTrue(isElementPresent(bySiteButton), "BySite Button is Not Displyed");
		softAssertion.assertTrue(isElementPresent(hhAlertEnabled),"HH AlertElement is not present");
		softAssertion.assertAll();
	}
	public void verifyOnlynHHutilityDetailAreDisplyed() throws Throwable{
		
		click(nHHutility);
		Thread.sleep(5000);
		softAssertion.assertTrue(isElementPresent(overviewOrBySite),"Overview Button is Not Displyed");
		softAssertion.assertTrue(isElementPresent(bySiteButton), "BySite Button is Not Displyed");
		softAssertion.assertTrue(isElementPresent(nhhAlertEnabled), "NHH AlertElement Is Not Present");
		softAssertion.assertAll();
	}
	public void verifyOnlyGasutilityDetailAreDisplyed() throws Throwable{
		click(gasUtility);
		Thread.sleep(5000);
		softAssertion.assertTrue(isElementPresent(overviewOrBySite),"Overview Button is Not Displyed");
		softAssertion.assertTrue(isElementPresent(bySiteButton), "BySite Button is Not Displyed");
		softAssertion.assertTrue(isElementPresent(gasAlertEnabled), "Gas AlertElement is Not Present");
		softAssertion.assertAll();
	}
	public void VerifyBudgetHomePageElements() throws Throwable{
		click(budgetsBtn);
		Thread.sleep(6000);
		
		softAssertion.assertTrue(isElementPresent(eleNextContarctYear), "Next Contract year is not present");
		softAssertion.assertTrue(isElementPresent(eleContarctYearForAnalysis), "Contract year for analysis is not present");
		softAssertion.assertTrue(isElementPresent(eleTopBudget), "TopBudget is not present");
		softAssertion.assertTrue(isElementPresent(eleRaisingMarketAlert), "Raising Market Alert is not present");
		softAssertion.assertTrue(isElementPresent(eleFallingMarketAlert), "Falling Market Alert is not present");
		
		softAssertion.assertAll();
		
	}
	public void VerifyAlertMessageOnClickingSaveChangesButton() throws InterruptedException{
		click(budgetsBtn);
		Thread.sleep(5000);
		click(saveChanges);
		Thread.sleep(5000);
		Assert.assertTrue(isElementPresent(okAlertPopup),"Alert PopUp is Not Present");
		click(cancelAlert);
		
	}
	public void VerifyAlertMessageOnClickingSaveChangesAndOKButtons() throws InterruptedException{
		click(budgetsBtn);
		Thread.sleep(5000);
		click(saveChanges);
		Thread.sleep(5000);
		softAssertion.assertTrue(isElementPresent(okAlertPopup),"savechagesSuccssAlert PopUp is Not Present");
		click(okAlertPopup);
		//Thread.sleep(2000);
		
		//click(okAlertPopup);
		softAssertion.assertAll();
	}
	public void verifyCostsAfterAddingSomePercentage() throws Throwable{
		String budgetpercentage=readExcelData("Sheet8",3,1);
		int addbudgetPercentage=Integer.parseInt(budgetpercentage);
		
		String raisinggetpercentage=readExcelData("Sheet8",4,1);
		int addraisingPercentage=Integer.parseInt(raisinggetpercentage);
		
		click(budgetsBtn);
		Thread.sleep(5000);
		click(nextContactYear);
		Thread.sleep(2000);
		selectFutureDateCalender(1,2,2019);
		String year = getText(currentContractYearCost);
		String strInt=year.replace(",", "");
		int curConYearCost = Integer.parseInt(strInt.replace(" ", ""));
		
		//Entering Budget % and market %
		setValue(topBuggetText,budgetpercentage);
		setValue(raisingMarketText,raisinggetpercentage);
		click(fallingMarketText);
		Thread.sleep(5000);
		String topbudget=getText(topBudgetCost);
		String strInt1=topbudget.replace(",", "");
		int actualtopBudgetCostint = Integer.parseInt(strInt1);
		int excpectedTopBudgetCost=((curConYearCost*addbudgetPercentage)/100)+curConYearCost;
		
		boolean trufals=excpectedTopBudgetCost==actualtopBudgetCostint;
		softAssertion.assertTrue(trufals, "Top BudgetCost is Showing wrongly After Adding "+addbudgetPercentage+"% TopBudget");
		
		String raising=getText(raisingmarketCost);
		String strInt2=raising.replace(",", "");
		int actualraisingCost = Integer.parseInt(strInt2);
		
		int expectedraisingCost=((curConYearCost*addraisingPercentage)/100)+curConYearCost;
		
		boolean trueORfalse=actualraisingCost==expectedraisingCost;
		softAssertion.assertTrue(trueORfalse, "Raising Market Cost is Showing wrongly After Adding "+addraisingPercentage+"% RaisingMarket");
		softAssertion.assertAll();
	}
	public void verifyFallingMarketValueAfterAddingPercentage() throws Throwable{
		String fallingmarktgetpercentage=readExcelData("Sheet8",5,1);
		int addfallingPercentage=Integer.parseInt(fallingmarktgetpercentage);
		
		click(budgetsBtn);
		Thread.sleep(5000);
		click(nextContactYear);
		Thread.sleep(2000);
		selectFutureDateCalender(1,2,2019);
		
		
		
		String year = getText(currentContractYearCost);
		String strInt1=year.replace(",", "");
		int curConYearCost = Integer.parseInt(strInt1.replace(" ", ""));
		
		//Entering falling market value % 
		setValue(fallingMarketText,fallingmarktgetpercentage);
		
		click(topBudgetCost);
		Thread.sleep(5000);
		String topbudget=getText(fallingMarketalertCost);
		String strInt=topbudget.replace(",", "");
		int actualtopfallingCostint = Integer.parseInt(strInt);
		int excpectedTopfallingCost=((curConYearCost*addfallingPercentage)/100)-curConYearCost;
		
		boolean trufals=actualtopfallingCostint==excpectedTopfallingCost;
		softAssertion.assertTrue(trufals, "Falling market Alert is Showing wrongly After Adding "+addfallingPercentage+"% TopBudget");
		
	}
	public void verifyAlertMesageAfetrclickingSaveChangesinBudgetHomePage() throws Throwable{
		click(budgetsBtn);
		Thread.sleep(5000);
		click(secondSaveChanges);
		Thread.sleep(5000);
		By savedsuccessfully=By.xpath("//div[contains(text(),'The changes were saved successfully.')]");
		boolean truORfalse=getText(savedsuccessfully).contains("The changes were saved successfully.");
		softAssertion.assertTrue(truORfalse, "No Alert is present after clicking last savechanges in budget Home page ");
		Thread.sleep(5000);
		click(okAlertPopup);
		softAssertion.assertAll();
	}
	public void verifyAlertMesageAfetrclickingForecastReportEnabledandClickingSaveChangesinBudgetHomePage() throws Throwable{
		click(budgetsBtn);
		Thread.sleep(5000);
		click(forecastingReportingEnabled);
		Thread.sleep(5000);
		click(secondSaveChanges);
		Thread.sleep(5000);
		boolean truORfalse=getText(alertToselectfrequency).contains("Please select a forecast reporting frequency before continuing...");
		softAssertion.assertTrue(truORfalse, "No Alert is present after clicking on ForecastReportingEnabled check box and clicking  savechanges in budget Home page ");
		Thread.sleep(2000);
		click(okAlertPopup);
		softAssertion.assertAll();
	}
	public void verifyAlertmsgAfterClickingHHTriwareAndForecastRepoetingEnabled() throws Throwable{
		click(budgetsBtn);
		Thread.sleep(5000);
		click(hhAlertEnabled);
		Thread.sleep(5000);
		click(forecastingReportingEnabled);
		Thread.sleep(5000);
		click(secondSaveChanges);
		Thread.sleep(5000);
		boolean truORfalse=getText(alertToselectfrequency).contains("Please select a forecast reporting frequency before continuing...");
		softAssertion.assertTrue(truORfalse, "No Alert is present after clicking on ForecastReportingEnabled check box and clicking  savechanges in budget Home page ");
		Thread.sleep(2000);
		click(okAlertPopup);
		softAssertion.assertAll();
	}
}
