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

	@BeforeClass(alwaysRun = true)
	public void beforeHHSuite() throws Throwable {
		adminDashboardPage = new LoginPage().
									loginAsAdmin();
		customerDashboardPage = adminDashboardPage.
									impersonateFlexCustomer();

	}

	@Test(priority = 1)
	public void fillCompanyProfileTest() throws Throwable {
		customerDashboardPage.
		goToCompanyProfile().
		fillCompanyProfile_Flexible();
	}

	@Test(priority = 2)
	public void addSiteTest() throws Throwable {
		customerDashboardPage.
			clickPropertyPortfolio().
				addValidSiteGeneric();
	}

	@Test(priority = 3)
	public void addHHmeterAndCheckSavedDetailsTest() throws Throwable {
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = new PropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.checkSavedDetailsAfterAddingHHMeterForFlexible();
	}

	@Test(priority = 4)
	public void addHHcontractHistoryTest() throws Throwable {
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = new PropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.addValidHHcontractHistory();
	}

	@Test(priority = 5)
	public void goToFlexibleProfileManager() throws Throwable {
		customerDashboardPage.goToFlexibleProfileManager();

	}
	
	@Test(priority = 6)
	public void requestForQuoteFlexProfileManagerTest() throws Throwable {
		FlexProfileManagerPage abc = new FlexProfileManagerPage();
		abc.clickOnSetUpFlexibleProfile("HH");
		customerDashboardPage.logOut();
	}

	@Test(priority = 7)
	public void loginAsAdminAndverifyAdminHomePage() throws Throwable {
		adminDashboardPage = new LoginPage().loginAsAdmin();
		adminDashboardPage.verifyAdminHomePage();
	}

	@Test(priority = 8)
	public void verifyVerifyTenderHomePage() throws Throwable {
		adminDashboardPage.goToVerifyTenders();
		VerifyTendersPage veri = new VerifyTendersPage();
		veri.verifyTendersHomePage();

	}

	@Test(priority = 9)
	public void verifypresnceOfSuppliers() throws Throwable {
		VerifyTendersPage veri = new VerifyTendersPage();
		veri.verifySuppliersPresence("HH");
	}

	@Test(priority = 10)
	public void verifyFlexTenderResponsepHomePage() throws Throwable {

		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyFlexTenderResponseHomePage();
		Thread.sleep(3000);

	}

	@Test(priority = 11)
	public void verifyQuoteRequestAfetrSelectingDate() throws Throwable {
		adminDashboardPage.refreshpage();
		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyQuoteRequestAfetrSelectingDate();
		Thread.sleep(3000);

	}

	@Test(priority = 12)
	public void verifyMeterForeCastAfetrSelectingRequestQuote() throws Throwable {
		adminDashboardPage.refreshpage();
		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyMeterForeCastAfetrSelectingRequestQuote("HH");
		Thread.sleep(3000);

	}

	@Test(priority = 13)
	public void verifyElementsAfterClickingmeterforecast() throws Throwable {
		adminDashboardPage.refreshpage();
		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyElementsAfterClickingmeterforecast("HH");
		Thread.sleep(3000);

	}

	@Test(priority = 14)
	public void verifymeterforecastafterenetringNoData() throws Throwable {
		adminDashboardPage.refreshpage();
		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifymeterforecastafterenetringNoData("HH");
		Thread.sleep(3000);

	}

	@Test(priority = 15)
	public void verifymeterforecastTextFields() throws Throwable {
		adminDashboardPage.refreshpage();
		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifymeterforecastTextFields("HH");
		Thread.sleep(3000);

	}

	@Test(priority = 16)
	public void verifymeterHHforecastafterenetringInvalidData() throws Throwable {
		adminDashboardPage.refreshpage();
		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifymeterHHforecastafterenetringInvalidData("HH");
		Thread.sleep(3000);

	}

	@Test(priority = 17)
	public void verifyingTextFieldNotacceptsAlphabets() throws Throwable {
		adminDashboardPage.refreshpage();
		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyingTextFieldNotacceptsAlphabetsIntoMeterHH("HH");
		Thread.sleep(3000);

	}

	@Test(priority = 18)
	public void enterInvalidDataSpecialCharctersIntoMeterHHForeCast() throws Throwable {
		adminDashboardPage.refreshpage();
		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.enterInvalidDataSpecialCharctersIntoMeterHHForeCast("HH");
		Thread.sleep(3000);

	}

	@Test(priority = 19)
	public void verifyingQuotesDropDwonAfterEnteringValidDataInMeterHHForeCast() throws Throwable {
		adminDashboardPage.refreshpage();
		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyingQuotesDropDwonAfterEnteringValidDataInMeterHHForeCast("HH");
		Thread.sleep(3000);

	}

	@Test(priority = 20)
	public void verifyingQuotesInformationAfterSelectingHHDropDwon() throws Throwable {
		adminDashboardPage.refreshpage();
		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyingQuotesInformationAfterSelectingHHDropDwon("HH");
		Thread.sleep(3000);

	}

	@Test(priority = 21)
	public void verifyingQuotesInformationHomePageAfterclickingQouteInformationLink() throws Throwable {
		adminDashboardPage.refreshpage();
		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyingQuotesInformationHomePageAfterclickingQouteInformationLink("HH");
		Thread.sleep(3000);

	}

	@Test(priority = 22)
	public void verifyingFexQuoteInformationPageAfterEnteringNoData() throws Throwable {
		adminDashboardPage.refreshpage();
		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyingFexQuoteInformationPageAfterEnteringNoData("HH");
		Thread.sleep(3000);

	}

	@Test(priority = 23)
	public void verifyFlexQuoteInformationTextFields() throws Throwable {
		adminDashboardPage.refreshpage();
		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyFlexQuoteInformationTextFields("HH");
		Thread.sleep(3000);

	}

	@Test(priority = 24)
	public void verifyingFexQuoteInformationPageAfterEnteringNegativeData() throws Throwable {
		adminDashboardPage.refreshpage();
		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyingFexQuoteInformationPageAfterEnteringNegativeData("HH");
		Thread.sleep(3000);

	}

	@Test(priority = 25)
	public void verifyingFexQuoteInformationPageAfterEnteringSpecialData() throws Throwable {

		adminDashboardPage.refreshpage();
		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyingFexQuoteInformationPageAfterEnteringSpecialData("HH");
		Thread.sleep(3000);

	}

	@Test(priority = 26)
	public void verifyingsubmitButtonAfterEnteringValidFexQuoteInformationAndclickingSave57() throws Throwable {

		adminDashboardPage.refreshpage();
		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyingsubmitButtonAfterEnteringValidFexQuoteInformationAndclickingSave57("HH");
		Thread.sleep(3000);

	}

	@Test(priority = 27)
	public void verifyconformatonpopAfterClikingSbmitButton() throws Throwable {

		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyconformatonpopAfterClikingSbmitButton();
		Thread.sleep(3000);

	}

	@Test(priority = 28)
	public void verifyconformatonpopsesAftercloAfterClikingcancelButton() throws Throwable {

	
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyconformatonpopsesAftercloAfterClikingcancelButton();
		Thread.sleep(3000);

	}

	@Test(priority = 29)
	public void verifyflexResponsePageAfterClikingOkButtonOnSubmitPopUp61() throws Throwable {

		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.verifyflexResponsePageAfterClikingOkButtonOnSubmitPopUp();
		Thread.sleep(3000);

	}

	@Test(priority = 30)
	public void verifyFlexibleProfileManager_HomePageAfterLogOutFromFlexTenderResopnse() throws Throwable {

		
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.logOut();
		Thread.sleep(3000);
		adminDashboardPage = new LoginPage().loginAsAdmin();
		customerDashboardPage = adminDashboardPage.impersonateFlexCustomer();//new LoginPage().login();
		customerDashboardPage.goToFlexibleProfileManager();
		FlexProfileManagerPage abc2 = new FlexProfileManagerPage();
		abc2.verifyFlexibleProfileManager_HomePage();
	}

	

	@Test(priority = 31)
	public void loginAdminandgotoFlexprofManagerandverifyQuoteRequestelemetsandacceptQuote() throws Throwable {
		FlexProfileManagerPage flexRev = new FlexProfileManagerPage();

		flexRev.verifyQuoteRequestelemets();
		flexRev.logOut();
	}

	@Test(priority = 32)
	public void loginAsAdminAndimporesanateasCustomerAndRequestQuote() throws Throwable {
		adminDashboardPage = new LoginPage().loginAsAdmin();
		adminDashboardPage.impersonateFlexCustomer();
		CustomerDashboardPage customerDashboardPage1 = new CustomerDashboardPage();
		customerDashboardPage1.verifyPortfolioManagerElementExists();
		customerDashboardPage1.goToCompanyProfile();// .fillCompanyProfileGeneric();
		customerDashboardPage1.clickPropertyPortfolio().addValidSiteGeneric();
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = new PropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.checkSavedDetailsAfterAddingHHMeter();
		propertyPortfolioMeterPage.addValidHHcontractHistory();

		customerDashboardPage1.goToFlexibleProfileManager();
		FlexProfileManagerPage flex = new FlexProfileManagerPage();
		flex.clickOnSetUpFlexibleProfile("HH");

		customerDashboardPage1.clickUnImpersonateButton();
		adminDashboardPage.goToVerifyTenders();
		VerifyTendersPage veri = new VerifyTendersPage();
		veri.verifySuppliersPresence("HH");
	}

	@Test(priority = 33)
	public void verifyFlexTenderResponse_ReviewsuppliersubmittedQuoteusingImporsonate() throws Throwable {
		adminDashboardPage = new LoginPage().loginAsAdmin();
		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.EnterValidDataInToTheTextFieldsHH("HH");
		abc.clicksubmitDetails();
		Thread.sleep(3000);
		adminDashboardPage.clickAdminDashBoard();
		adminDashboardPage.impersonateFlexCustomer();
		CustomerDashboardPage customerDashboardPage2 = new CustomerDashboardPage();
		customerDashboardPage2.goToFlexibleProfileManager();
		FlexProfileManagerPage flexRev = new FlexProfileManagerPage();
		flexRev.verifyQuoteRequestelemets();

	}

	@Test(priority = 34)
	public void verifyGasUtilityEndTOEndFunction() throws Throwable {
		adminDashboardPage = new LoginPage().loginAsAdmin();
		CustomerDashboardPage customerDashboardPage1 = new CustomerDashboardPage();
		customerDashboardPage1 = adminDashboardPage.impersonateFlexCustomer();

		customerDashboardPage1.verifyPortfolioManagerElementExists();
		customerDashboardPage1.goToCompanyProfile();// .fillCompanyProfileGeneric();
		customerDashboardPage1.clickPropertyPortfolio().addValidSiteGeneric();
		PropertyPortfolioMeterPage propertyPortfolioMeterPage = new PropertyPortfolioMeterPage();
		propertyPortfolioMeterPage.checkSavedDetailsAfterAddingGasMeterForFlexible();
		propertyPortfolioMeterPage.addValidGascontractHistoryForFlexible();
		Thread.sleep(3000);
		customerDashboardPage1.goToFlexibleProfileManager();
		FlexProfileManagerPage flex = new FlexProfileManagerPage();
		flex.clickOnSetUpFlexibleProfile("Gas");
		flex.logOut();

		AdminDashboardPage adminDashboardPage1 = new AdminDashboardPage();
		adminDashboardPage1 = new LoginPage().loginAsAdmin();
		adminDashboardPage1.goToVerifyTenders();
		VerifyTendersPage veri = new VerifyTendersPage();
		veri.verifySuppliersPresence("Gas");

		adminDashboardPage1.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.EnterValidDataInToTheTextFieldsGas("Gas");
		abc.clicksubmitDetails();
		abc.logOut();
		CustomerDashboardPage customerDashboardPage2 = new CustomerDashboardPage();
		customerDashboardPage2 = adminDashboardPage.impersonateFlexCustomer();
		customerDashboardPage2.goToFlexibleProfileManager();
		FlexProfileManagerPage abc2 = new FlexProfileManagerPage();
		abc2.verifyQuoteRequestelemetsForGas();
	}

}
