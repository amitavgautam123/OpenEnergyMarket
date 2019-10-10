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

	@Test(dataProvider = "getHHcontractHistoryData")
	public void addHHcontractHistoryUsingDataProviderTest(String dayRate, String nightRate, String standingCharge, 
			String capacityCharge, String contractedAnnualSpend) throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterTest = (PropertyPortfolioMeterPage) customerDashboardPage.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterTest.validateMandatoryFieldsContractHistoryPopupDataProvider(dayRate, nightRate, standingCharge, 
				capacityCharge, contractedAnnualSpend);
	}
	@DataProvider
	public Object[][] getHHcontractHistoryData() {
		Object[][] data = {{"", "", "", "", ""},			//PM_PP_TC_034
				{"20", "", "", "", ""},						//PM_PP_TC_037
				{"", "18", "", "", ""},						//PM_PP_TC_038
				{"", "", "120", "", ""},					//PM_PP_TC_039
				{"", "", "", "140", ""}};					//PM_PP_TC_040
		return data;
	}
}
