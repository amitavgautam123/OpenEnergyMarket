package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ForecastingPage extends CustomerDashboardPage	{

	By hhUtility = By.xpath("//div[@data-original-title = '<strong>Half Hourly Electricity</strong> Quotes']");
	By nHHutility = By.xpath("//div[contains(@data-original-title, 'Non Half Hourly Electricity')]");
	By gasUtility = By.xpath("//div[contains(@data-original-title, 'Gas')]");
	
	By forecastYear = By.xpath("ddlForecastMonths");
	By budgetsBtn = By.xpath("//div[@class='forecast-sub-heading']//button[1]");
	By overviewOrBySite = By.xpath("//div[@id='content']//button[1]");
	By budgetsOrBySite = By.xpath("//body//button[2]");
	By historicalAnalysis = By.xpath("//*[contains(text(), 'Historical Analysis')]");
	By forecastCost = By.id("divForecastCostValue");
	
	By bySite = By.linkText("By Site");
	
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
	
}
