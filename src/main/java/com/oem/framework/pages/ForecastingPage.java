package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ForecastingPage extends CustomerDashboardPage	{

	By hhFilter = By.xpath("//div[@data-original-title = '<strong>Half Hourly Electricity</strong> Quotes']");
	By nHHFilter = By.xpath("//div[contains(@data-original-title, 'Non Half Hourly Electricity')]");
	By gasFilter = By.xpath("//div[contains(@data-original-title, 'Gas')]");
	By forecastYear = By.xpath("ddlForecastMonths");
	
	SoftAssert softAssertion = new SoftAssert();
	
	@Override
    protected void isLoaded()  {
		System.out.println("Executing isLoaded in forecasting Page");
        Assert.assertTrue(isElementPresent(hhFilter),"Forecasting Page didn't appear");  
    }
	
	public ForecastingPage verifyUtilityPresence() {
		softAssertion.assertTrue(isElementPresent(hhFilter), "HH utility is not displaying");
		softAssertion.assertTrue(isElementPresent(nHHFilter), "HH utility is not displaying");
		softAssertion.assertTrue(isElementPresent(gasFilter), "HH utility is not displaying");
		softAssertion.assertAll();
		return this;
	}
	
}
