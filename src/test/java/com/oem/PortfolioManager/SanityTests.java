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
	 
	
	
	@Test(dataProvider = "getGasMeterData")
	public void validateMandatoryFieldAddGasMeterUsingDataProviderTest(String gasMeterNumber, String procurementType,
			String expectedConsumption, String currentSupplier, int dayOfMonthOfContractEndDate,
			int monthNumberOfContractEndDate, int yearOfContractEndDate, String currentAnnualSpend) throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = (PropertyPortfolioMeterPage) customerDashboardPage
				.goToPropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.addGasMeterUsingDifferentTestData(gasMeterNumber, procurementType,
				expectedConsumption, currentSupplier, dayOfMonthOfContractEndDate, monthNumberOfContractEndDate,
				yearOfContractEndDate, currentAnnualSpend);
	}

	@DataProvider
	public Object[][] getGasMeterData() {
		Object[][] data = { { "6786342454", "Fixed Pass Through", "2200", "Corona Energy", 10, 3, 2020, "" }, /* PM_PP_TC_083 */
				{ "2842342254", "Fixed", "3500", "Corona Energy", 10, 9, 2020, "" } }; /* PM_PP_TC_085 */
		return data;
	}

}
