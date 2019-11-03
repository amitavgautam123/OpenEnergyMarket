package com.oem.Suits;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.FlexProfileManagerPage;
import com.oem.framework.pages.FlexTenderResponsePage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.PropertyPortfolioMeterPage;
import com.oem.framework.pages.VerifyTendersPage;

public class FlexManagementSuite extends BaseTest {
	CustomerDashboardPage customerDashboardPage;
	AdminDashboardPage adminDashboardPage;

	// @BeforeClass(alwaysRun = true)
	public void beforeHHSuite() throws Throwable {
		customerDashboardPage = new LoginPage().login();

	}

	// @Test(priority = 1)
	public void fillCompanyProfileTest() throws Throwable {
		customerDashboardPage.goToCompanyProfile().fillCompanyProfileGeneric();
	}

	// @Test(priority = 2)
	public void addSiteTest() throws Throwable {
		customerDashboardPage.clickPropertyPortfolio().addValidSiteGeneric();
	}

	// @Test(priority = 3)
	public void addHHmeterAndCheckSavedDetailsTest() throws Throwable {
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = new PropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.checkSavedDetailsAfterAddingHHMeter();
	}

	// @Test(priority = 4)
	public void addHHcontractHistoryTest() throws Throwable {
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = new PropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.addValidHHcontractHistory();
	}

	// @Test(priority = 5)
	public void goToFlexibleProfileManager() throws Throwable {
		customerDashboardPage.goToFlexibleProfileManager();

	}

	// @Test(priority = 6)
	public void requestForQuoteFlexProfileManagerTest() throws Throwable {
		FlexProfileManagerPage abc = new FlexProfileManagerPage();
		abc.clickOnSetUpFlexibleProfile("HH");

	}

	// @Test(priority = 7)
	public void logoutFlexProfileManagerTest() throws Throwable {

		customerDashboardPage.logout();

	}

	@Test(priority = 8)
	public void loginAsAdminAndverifyAdminHomePage() throws Throwable {
		adminDashboardPage = new LoginPage().loginAsAdmin();
		adminDashboardPage.verifyAdminHomePage();
	}

	// @Test(priority = 9)
	/*
	 * public void verifyVerifyTenderHomePage() throws Throwable {
	 * adminDashboardPage.goToVerifyTenders(); VerifyTendersPage veri = new
	 * VerifyTendersPage(); veri.verifyTendersHomePage();
	 * 
	 * }
	 */

	// @Test(priority = 10)
	public void verifypresnceOfSuppliers() throws Throwable {
		VerifyTendersPage veri = new VerifyTendersPage();
		veri.verifySuppliersPresence("HH");
	}

	/*
	 * //@Test(priority = 11) public void verifyFlexTenderResponsepHomePage() throws
	 * Throwable { adminDashboardPage.goFlexTenderResponse(); FlexTenderResponsePage
	 * abc = new FlexTenderResponsePage(); abc.verifyFlexTenderResponseHomePage();
	 * Thread.sleep(3000); // abc.logout();
	 * 
	 * }
	 */

	@Test(priority = 12)
	public void verifyQuoteRequestAfetrSelectingDate() throws Throwable {
		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyQuoteRequestAfetrSelectingDate();
		Thread.sleep(3000);

	}

	// @Test(priority = 13)
	public void verifyMeterForeCastAfetrSelectingRequestQuote() throws Throwable {
		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyMeterForeCastAfetrSelectingRequestQuote();
		Thread.sleep(3000);

	}

	// @Test(priority = 14)
	public void verifyElementsAfterClickingmeterforecast() throws Throwable {
		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyElementsAfterClickingmeterforecast();
		Thread.sleep(3000);

	}

	// @Test(priority = 15)
	public void verifymeterforecastafterenetringNoData() throws Throwable {
		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifymeterforecastafterenetringNoData();
		Thread.sleep(3000);

	}
	@Test(priority = 15)
	public void verifymeterforecastTextFields() throws Throwable {
		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifymeterforecastTextFields();
		Thread.sleep(3000);
		
	}

	// @Test(priority = 16)
	public void verifymeterHHforecastafterenetringInvalidData() throws Throwable {
		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifymeterHHforecastafterenetringInvalidData();
		Thread.sleep(3000);

	}

	// @Test(priority = 17)
	public void verifyingTextFieldNotacceptsAlphabets() throws Throwable {
		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyingTextFieldNotacceptsAlphabetsIntoMeterHH();
		Thread.sleep(3000);

	}

	// @Test(priority=18)
	public void enterInvalidDataSpecialCharctersIntoMeterHHForeCast() throws Throwable {
		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.enterInvalidDataSpecialCharctersIntoMeterHHForeCast();
		Thread.sleep(3000);

	}

	// @Test(priority=19)
	public void verifyingQuotesDropDwonAfterEnteringValidDataInMeterHHForeCast() throws Throwable {
		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyingQuotesDropDwonAfterEnteringValidDataInMeterHHForeCast();
		Thread.sleep(3000);

	}

	// @Test(priority=20)
	public void verifyingQuotesInformationAfterSelectingHHDropDwon() throws Throwable {
		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyingQuotesInformationAfterSelectingHHDropDwon();
		Thread.sleep(3000);

	}

	// @Test(priority=21)
	public void verifyingQuotesInformationHomePageAfterclickingQouteInformationLink() throws Throwable {
		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyingQuotesInformationHomePageAfterclickingQouteInformationLink();
		Thread.sleep(3000);

	}

	// @Test(priority=22)
	public void verifyingFexQuoteInformationPageAfterEnteringNoData() throws Throwable {
		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyingFexQuoteInformationPageAfterEnteringNoData();
		Thread.sleep(3000);

	}

	// @Test(priority=23)
	public void verifyingFexQuoteInformationPageAfterEnteringNegativeData() throws Throwable {
		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyingFexQuoteInformationPageAfterEnteringNegativeData();
		Thread.sleep(3000);

	}
	/*
	 * @Test(priority = 19) public void
	 * FlexTenderResponsepAdminFlexProfileManagerTest() throws Throwable {
	 * adminDashboardPage.goFlexTenderResponse(); FlexTenderResponsePage abc =
	 * new FlexTenderResponsePage(); abc.selectByDate(); abc.logout();
	 * 
	 * }
	 */

	/*
	 * @Test(priority = 13) public void
	 * loginAdminFlexProfistomerasculeManagerTest() throws Throwable {
	 * //customerDashboardPage = new LoginPage().login(); adminDashboardPage=
	 * new LoginPage().loginAsAdmin();
	 * adminDashboardPage.impersonateCustomer().goToFlexibleProfileManager();
	 * FlexProfileManagerPage abc = new FlexProfileManagerPage();
	 * abc.clickReviewQuotes("HH");
	 * 
	 * }
	 */
}
