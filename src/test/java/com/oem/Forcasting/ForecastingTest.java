package com.oem.Forcasting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.LoginPage;

public class ForecastingTest extends BaseTest	{

	CustomerDashboardPage customerDashboardPage;
	
	@BeforeClass
	public void beforeForecasting() throws Throwable {
		customerDashboardPage = new LoginPage().login();
		customerDashboardPage.goToForecastingPage();
	}
	@Test
	public void verifyUtiltityPresence() throws Throwable {
		customerDashboardPage.
			goToForecastingPage().
				verifyUtilityPresence();
	}
	@Test
	public void verifyBySite() throws Throwable {
		customerDashboardPage.
		goToForecastingPage().
		clickBySite();	
	}
}
