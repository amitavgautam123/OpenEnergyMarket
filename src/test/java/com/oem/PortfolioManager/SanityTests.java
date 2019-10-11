package com.oem.PortfolioManager;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.CompanyProfilePage;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.PortfolioCalendarPage;
import com.oem.framework.pages.PropertyPortfolioMeterPage;
import com.oem.framework.pages.PropertyPortfolioPage;
import com.oem.framework.pages.RequestQuotePage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SanityTests extends BaseTest {

	/*@Test
	public void PortfolioManagerDisplaysTest() {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		customerDashboardPage.verifyPortfolioManagerElementExists();

	}

	@Test
	public void TC_003_4() {

		LoginPage loginPage = new LoginPage();

		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.fillCompanyProfile();
	}*/

	@Test(dataProvider = "getHHcontractHistoryData3")
	public void addHHcontractHistoryUsingDataProviderTest3(int day, int month, int year, String dayRate, String nightRate, String standingCharge, 
			String capacityCharge, String contractedAnnualSpend) throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateMandatoryFieldsContractHistoryPopupDataProvider3(day, month, year, dayRate, nightRate, 
				standingCharge, capacityCharge, contractedAnnualSpend);
	}
	@DataProvider
	public Object[][] getHHcontractHistoryData3() {
		Object[][] data = {{20, 02, 2018, "", "", "", "", ""},			//PM_PP_TC_041
				{25, 04, 2018, "25", "", "", "", ""},					//PM_PP_TC_046
				{14, 02, 2018, "", "28", "", "", ""},					//PM_PP_TC_047
				{28, 05, 2018, "", "", "48", "", ""},					//PM_PP_TC_048
				{10, 9, 2018, "", "", "", "35", ""}}; 					//PM_PP_TC_049
		return data;
	}
}
