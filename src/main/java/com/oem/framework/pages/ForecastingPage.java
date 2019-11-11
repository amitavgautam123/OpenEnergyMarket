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
	By projectedCost=By.xpath("//td[@id='tdProjectedCosts']//div[@class='pull-left value odometer odometer-auto-theme']");
	By bySite = By.linkText("By Site");
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
		Thread.sleep(4000);
		if(isElementPresent(forecastYear))
		{
			
		}
		else
		{
			System.out.println("Current page is budget");
		}
		return this;
	}
	public ForecastingPage verifyHHutility() throws Throwable {
		click(hhUtility);
		selectByVisibleText(forecastYear, "2020 - 2021");
		Thread.sleep(4000);
		//softAssertion.assertTrue(isElementPresent(""), "");
		return this;
	}
	public void clickBySite() throws Throwable {
		Thread.sleep(3000);
		System.out.println("By site display status = " + isElementPresent(bySite));
		click(bySite);
	}
	public void verifyForecastCost(String year) throws Throwable{
		Thread.sleep(5000);
		click(budgetsBtn);
		Thread.sleep(2000);
		click(nextContactYear);
		
		selectFutureDateCalender(1,2,2019);
		selectByVisibleText(contractYearForAnalysis,year);
		Thread.sleep(3000);
		String eleProjectCost=driver.findElement(projectedCost).getText();
		
		click(overviewOrBySite);
		Thread.sleep(6000);
		//selectByPartOfVisibleText(forecastYear,year);
		selectByIndex(forecastYear, 0);
		Thread.sleep(8000);
		String eleForecastCost=driver.findElement(forecastCostHomePage).getText();
		softAssertion.assertTrue(eleForecastCost.equals(eleProjectCost), "Cost is Not Matched");
		//click(overviewOrBySite);
		softAssertion.assertAll();
		
		
		
	}
	public void verifyForecastCost1(String year) throws Throwable{
		Thread.sleep(5000);
		click(budgetsBtn);
		Thread.sleep(2000);
		click(nextContactYear);
		
		selectFutureDateCalender(1,2,2019);
		selectByVisibleText(contractYearForAnalysis,year);
		Thread.sleep(3000);
		String eleProjectCost=driver.findElement(projectedCost).getText();
		
		click(overviewOrBySite);
		Thread.sleep(6000);
		//selectByPartOfVisibleText(forecastYear,year);
		selectByIndex(forecastYear, 1);
		
		Thread.sleep(8000);
		String eleForecastCost=driver.findElement(forecastCostHomePage).getText();
		softAssertion.assertTrue(eleForecastCost.equals(eleProjectCost), "Cost is Not Matched");
		//click(overviewOrBySite);
		softAssertion.assertAll();
		
		
		
	}
	public void verifyOnlyHHutilityDetailAreDisplyed(){
		click(hhUtility);
		
		softAssertion.assertTrue(isElementPresent(overviewOrBySite),"Overview Button is Not Displyed");
		softAssertion.assertTrue(isElementPresent(bySite), "BySite Button is Not Displyed");
		softAssertion.assertTrue(isElementPresent(hhAlertEnabled),"HH AlertElement is not present");
		softAssertion.assertAll();
	}
	public void verifyOnlynHHutilityDetailAreDisplyed(){
		
		click(nHHutility);
		softAssertion.assertTrue(isElementPresent(overviewOrBySite),"Overview Button is Not Displyed");
		softAssertion.assertTrue(isElementPresent(bySite), "BySite Button is Not Displyed");
		softAssertion.assertTrue(isElementPresent(nhhAlertEnabled), "NHH AlertElement Is Not Present");
		softAssertion.assertAll();
	}
	public void verifyOnlyGasutilityDetailAreDisplyed(){
		click(gasUtility);
		
		softAssertion.assertTrue(isElementPresent(overviewOrBySite),"Overview Button is Not Displyed");
		softAssertion.assertTrue(isElementPresent(bySite), "BySite Button is Not Displyed");
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
		Thread.sleep(3000);
		
		click(saveChanges);
		
		
		Assert.assertTrue(isElementPresent(okAlertPopup),"Alert PopUp is Not Present");
		click(cancelAlert);
		
	}
	public void VerifyAlertMessageOnClickingSaveChangesAndOKButtons() throws InterruptedException{
		click(budgetsBtn);
		Thread.sleep(3000);
		
		click(saveChanges);
		
		
		
		click(okAlertPopup);
		Assert.assertTrue(isElementPresent(savechagesDoneAlert),"savechagesSuccssAlert PopUp is Not Present");
		click(okAlertPopup);
	}
	
}
