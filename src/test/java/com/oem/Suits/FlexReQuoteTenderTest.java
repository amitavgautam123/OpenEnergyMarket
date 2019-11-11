package com.oem.Suits;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.FlexProfileManagerPage;
import com.oem.framework.pages.FlexReQuoteTenderPage;
import com.oem.framework.pages.FlexTenderResponsePage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.PropertyPortfolioMeterPage;
import com.oem.framework.pages.VerifyTendersPage;

public class FlexReQuoteTenderTest extends BaseTest{
	
	CustomerDashboardPage customerDashboardPage;
	AdminDashboardPage adminDashboardPage;
	@BeforeClass(alwaysRun = true)
	public void beforeHHSuite() throws Throwable {
		adminDashboardPage = new LoginPage().loginAsAdmin();
		customerDashboardPage = adminDashboardPage.impersonateFlexCustomer();

	}
	
	@Test(priority=1)
	public void loginAsAdminAndimporesanateasCustomerAndRequestQuote() throws Throwable {
		
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
		
		adminDashboardPage = new LoginPage().loginAsAdmin();
		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		abc.EnterValidDataIntoTheTextFields();
		abc.clicksubmitDetailsToReOpenQuote();
		
	}
	@Test(priority=2)
	public void verifyFlexReQuoteTenderHomePage() throws Throwable{
		
		FlexReQuoteTenderPage flexReQuoteTenderPage=new FlexReQuoteTenderPage();
		adminDashboardPage.clickAdminDashBoard();
		adminDashboardPage.goToFlexReQuoteTenderPage();
		flexReQuoteTenderPage.verifyFlxReQtTenderHomePage();
	}
	@Test(priority=3)
	public void verifyAlertMessageAfterClickingReOpenQuote() throws Throwable{
		FlexReQuoteTenderPage flexReQuoteTenderPage=new FlexReQuoteTenderPage();

		flexReQuoteTenderPage.verifyAlertMessageAfterClickingReOpenQoute();
		
	}
	@Test(priority=4)
	public void verifyPopUpAfterSelectingElementInDropDownAndClickReOpen() throws Throwable{
		FlexReQuoteTenderPage flexReQuoteTenderPage=new FlexReQuoteTenderPage();

		flexReQuoteTenderPage.verifyPopAfterSelectingElementAndClickReOpen("HH");
	}
	@Test(priority=5)
	public void verifyReOpenedQuoteIsPresentAtFlexTenedrResponse() throws Throwable{
		adminDashboardPage.goToAdminDashBoard();
		adminDashboardPage.goFlexTenderResponse();
		FlexTenderResponsePage abc = new FlexTenderResponsePage();
		//To Verify Is it Opened Or Not
		abc.EnterValidDataInToTheTextFieldsForReOpenTender("HH");
		abc.clicksubmitDetails();
		Thread.sleep(3000);
		adminDashboardPage.clickAdminDashBoard();
		adminDashboardPage.impersonateFlexCustomer();
		CustomerDashboardPage customerDashboardPage2 = new CustomerDashboardPage();
		customerDashboardPage2.goToFlexibleProfileManager();
		FlexProfileManagerPage flexRev = new FlexProfileManagerPage();
		flexRev.verifyQuoteRequestelemets();
		
	}
	@Test(priority=6)
	public void verifyQuoteIsNotPresentAfterAccepting() throws Throwable{
		adminDashboardPage = new LoginPage().loginAsAdmin();
		adminDashboardPage.goToFlexReQuoteTenderPage();
		FlexReQuoteTenderPage flexReQuoteTenderPage=new FlexReQuoteTenderPage();
		flexReQuoteTenderPage.verifyQuoteIsNotPresentAfterAccepting();
	}
}
