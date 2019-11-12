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
	@Test(priority=1)
	public void verifyUtiltityPresence() throws Throwable {
		customerDashboardPage.
			goToForecastingPage().
				verifyUtilityPresence();
	}
	//@Test(priority=2)
	public void verifyBySite() throws Throwable {
		customerDashboardPage.
		goToForecastingPage().
		clickBySite();	
	}
	@Test(priority=3)
	public void verifyForecastCostForForecastYear1() throws Throwable{
		customerDashboardPage.
		goToForecastingPage().
		verifyForecastCost("2019-2020");
	}
	@Test(priority=4)
	public void verifyForecastCostForForecastYear2() throws Throwable{
		customerDashboardPage.
		goToForecastingPage().
		verifyForecastCost1("2021-2022");
	}
	@Test(priority=6)
	public void verifyOnlyHHutilityDetailAreDisplyed() throws Throwable{
		customerDashboardPage.
		goToForecastingPage().
		verifyOnlyHHutilityDetailAreDisplyed();
	}
	@Test(priority=5)
	public void verifyOnlynHHutilityDetailAreDisplyed() throws Throwable{
		customerDashboardPage.
		goToForecastingPage().
		verifyOnlynHHutilityDetailAreDisplyed();
	}
	@Test(priority=7)
	public void verifyOnlyGasutilityDetailAreDisplyed() throws Throwable{
		customerDashboardPage.
		goToForecastingPage().
		verifyOnlyGasutilityDetailAreDisplyed();
	}
	@Test(priority=8)
	public void verifyBudgetHomePage() throws Throwable{
		customerDashboardPage.
		goToForecastingPage().
		VerifyBudgetHomePageElements();
	}
	@Test(priority=9)
	public void verifyAlertMessageAfterClickingOnSaveChangesWithoutEntringanyData() throws Throwable, Throwable{
		customerDashboardPage.
		goToForecastingPage().
		VerifyAlertMessageOnClickingSaveChangesButton();
	}
	@Test(priority=10)
	public void VerifyAlertMessageOnClickingSaveChangesAndOKButtons() throws Throwable, Throwable{
		customerDashboardPage.
		goToForecastingPage().
		VerifyAlertMessageOnClickingSaveChangesAndOKButtons();
	}
}