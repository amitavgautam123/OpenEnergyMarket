package com.oem.tests;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.CompanyProfilePage;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CompanyProfileTest extends BaseTest { 

	@Test
	public void PM_CP_TC_003() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		customerDashboardPage.verifyPortfolioManagerElementExists();

	}

	@Test
	public void PM_CP_TC_004() throws Throwable {

		LoginPage loginPage = new LoginPage();

		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.verifyRegisteredAddressInputs();
	}

	@Test
	public void PM_CP_TC_005() throws Throwable {

		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.verifyRegisteredAddressError(
				"The field Registered address must be a string with a maximum length of 200");
	}

	@Test
	public void PM_CP_TC_006() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.verifyBlankRegisteredAddressError("Registered address field is required");

	}
	
	@Test
	public void PM_CP_TC_007() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.verifyCompanyNameError("The Company name field is required.");
	}
	
	@Test
	public void PM_CP_TC_008() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.validateCompanyNameAlphabeticAcceptance();
	}

	@Test
	public void PM_CP_TC_009() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.verifyBlankPostcodeError("Postcode field is required");
	}
	
	@Test
	public void PM_CP_TC_010() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.validatePostcodeSpecialSymbolTest();
	}
	
	@Test
	public void PM_CP_TC_011() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.validatePostcodeNumericDataTest();
	}
	@Test
	public void PM_CP_TC_012() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.validateIfPhoneFieldMandatory();
	}
	@Test
	public void PM_CP_TC_013() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.validatePhoneFieldAlphabeticTestData();
	}
	@Test
	public void PM_CP_TC_014() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.validatePhoneFieldNumericTestData();
	}

	@Test
	public void PM_CP_TC_015() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.verifyCompRegistrationNumberError("Company registration number field is required");
	}

	@Test
	public void PM_CP_TC_018() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.uploadLogo();
	}

	@Test
	public void PM_CP_TC_019() throws Throwable
	{
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.validateOptionsSupplierInvoiceTo();
	}
	@Test
	public void PM_CP_TC_021() throws Throwable
	{
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.validateOptionsPrefferedSupplierPayment();
	}
	@Test
	public void PM_CP_TC_022() throws Throwable
	{
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.validateMandatoryPrefferedSupplierPayment();
	}

	@Test
	public void PM_CP_TC_026() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.verifyLOATemplateDisplay("Letter of Authority Template");
	}

	@Test
	public void PM_CP_TC_027() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.verifyExistingLOADisplay("Download Existing Letter Of Authority");
	}

	@Test
	public void PM_CP_TC_028() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		// companyProfilePage.click(By.id("LOAExpiresDate"));
		companyProfilePage.verifyDatePickerDisplayLOAExpiresDate();
	}

	@Test
	public void PM_CP_TC_029() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.click(By.id("LOAExpiresDate"));
		companyProfilePage.selectFutureDateCalender(27, 10, 2021);
	}

	@Test
	public void PM_CP_TC_030() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.click(By.id("LOAExpiresDate"));
		companyProfilePage.selectPrevDateCalender(12, 5, 2017);
	}

	@Test
	public void PM_CP_TC_031() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.verifyRegisteredAddressErrorSpaceTestData();
	}

	@Test
	public void PM_CP_TC_032() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.verifyPostcodeWithSpaceTestData();
	} 

	@Test(dataProvider = "getData")
	public void fillCompanyProfileWithDifferentDataTest(String compName, String addr, String postCode, String ph, String regdNo)
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		CompanyProfilePage companyProfilePage = (CompanyProfilePage) customerDashboardPage.goToCompanyProfile();
		companyProfilePage.validateProfileDiffDataSets(compName, addr, postCode, ph, regdNo);
	}

	@DataProvider
	public Object[][] getData() {
		 Object[][] data = {{"Tibco Inc", "Bangalore", "123456", "7234823423", "123456"},
				 {"Tibco12345", "G R Complex, No. 31, Ground & 1st Floor, Kempegowda Service Rd, Domlur, Bengaluru, Karnataka", "123456", "7234823423", "123456"},
		 {"!@#$%^&", "G R Complex, No. 31, Ground & 1st Floor, Kempegowda Service Rd, Domlur, Bengaluru, Karnataka", "123456", "7234823423", "123456"},
		 {"      ", "G R Complex, No. 31, Ground & 1st Floor, Kempegowda Service Rd, Domlur, Bengaluru, Karnataka", "123456", "7234823423", "123456"},
		 {"</html>", "G R Complex, No. 31, Ground & 1st Floor, Kempegowda Service Rd, Domlur, Bengaluru, Karnataka", "123456", "7234823423", "123456"},
		 {"AGB3", "123456789", "123456", "7234823423", "123456"},
		 {"AGB3", "!@#$%^&*", "123456", "7234823423", "123456"}};
		
		 return data;
	}
}
