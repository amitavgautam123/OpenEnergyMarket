package com.oem.PortfolioManager;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.CompanyProfilePage;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CompanyProfileTest extends BaseTest {

	CustomerDashboardPage customerDashboardPage;

	@BeforeClass(alwaysRun = true)
	public void beforeCompanyProfile() throws Throwable {
		customerDashboardPage = new LoginPage().login();
		customerDashboardPage.goToCompanyProfile();
	}

	@AfterClass
	public void afterCompanyProfile() {
		customerDashboardPage.logout();
	}

	@Test
	public void PM_CP_TC_003_verifyPortfolioManagerElementExistsTest() throws Throwable {
		customerDashboardPage.verifyPortfolioManagerElementExists();

	}

	@Test
	public void PM_CP_TC_004_verifyRegisteredAddressInputsTest() throws Throwable {

		customerDashboardPage.clickCompanyProfile().verifyRegisteredAddressInputs();
	}

	@Test
	public void PM_CP_TC_005_verifyRegisteredAddressExceedingMaxLengthErrorTest() throws Throwable {

		customerDashboardPage.clickCompanyProfile().verifyRegisteredAddressExceedingMaxLengthError(
				"The field Registered address must be a string with a maximum length of 200");
	}

	
	  @Test public void PM_CP_TC_006_verifyBlankRegisteredAddressErrorTest() throws
	  Throwable { customerDashboardPage. clickCompanyProfile().
	  verifyBlankRegisteredAddressError("Registered address field is required"); }
	  
	  @Test public void PM_CP_TC_007_verifyCompanyNameBlankErrorTest() throws
	  Throwable { customerDashboardPage. clickCompanyProfile().
	  verifyCompanyNameError("The Company name field is required."); }
	  
	  @Test public void PM_CP_TC_008_validateCompanyNameAlphabeticAcceptanceTest()
	  throws Throwable { customerDashboardPage. clickCompanyProfile().
	  validateCompanyNameAlphabeticAcceptance(); }
	  
	  @Test public void PM_CP_TC_009_verifyBlankPostcodeErrorTest() throws
	  Throwable { customerDashboardPage. clickCompanyProfile().
	  verifyBlankPostcodeError("Postcode field is required"); }
	  
	  @Test public void PM_CP_TC_010_validatePostcodeSpecialSymbolTest() throws
	  Throwable { customerDashboardPage. clickCompanyProfile().
	  validatePostcodeSpecialSymbolTest(); }
	  
	  @Test public void PM_CP_TC_011_validatePostcodeNumericDataTest() throws
	  Throwable { customerDashboardPage. clickCompanyProfile().
	  validatePostcodeNumericDataTest(); }
	  
	  @Test public void PM_CP_TC_012_validateIfPhoneFieldMandatoryTest() throws
	  Throwable { customerDashboardPage. clickCompanyProfile().
	  validateIfPhoneFieldMandatory(); }
	  
	  @Test public void PM_CP_TC_013_validatePhoneFieldAlphabeticTestData() throws
	  Throwable { customerDashboardPage. clickCompanyProfile().
	  validatePhoneFieldAlphabeticTestData(); }
	  
	  @Test public void PM_CP_TC_014_validatePhoneFieldNumericTestData() throws
	  Throwable { customerDashboardPage. clickCompanyProfile().
	  validatePhoneFieldNumericTestData(); }
	  
	  @Test public void PM_CP_TC_015_verifyCompRegistrationNumberErrorTest() throws
	  Throwable { customerDashboardPage. clickCompanyProfile().
	  verifyCompRegistrationNumberError("Company registration number field is required"
	  ); }
	  
	  
	  @Test public void PM_CP_TC_018_uploadLogoTest() throws Throwable {
	  customerDashboardPage. goToCompanyProfile(). uploadLogo(); }
	  
	  
	  @Test public void PM_CP_TC_019_validateOptionsSupplierInvoiceToTest() throws
	  Throwable { customerDashboardPage. clickCompanyProfile().
	  validateOptionsSupplierInvoiceTo(); }
	  
	  @Test public void PM_CP_TC_021_validateOptionsPrefferedSupplierPaymentTest()
	  throws Throwable { customerDashboardPage. clickCompanyProfile().
	  validateOptionsPrefferedSupplierPayment(); }
	  
	  @Test public void
	  PM_CP_TC_022_validateMandatoryPrefferedSupplierPaymentTest() throws Throwable
	  { customerDashboardPage. clickCompanyProfile().
	  validateMandatoryPrefferedSupplierPayment(); }
	  
	  @Test public void PM_CP_TC_026_verifyLOATemplateDisplayTest() throws
	  Throwable { customerDashboardPage. clickCompanyProfile().
	  verifyLOATemplateDisplay("Letter of Authority Template"); }
	  
	  @Test public void PM_CP_TC_027_verifyExistingLOAdisplayTest() throws
	  Throwable { customerDashboardPage. clickCompanyProfile().
	  verifyExistingLOADisplay("Download Existing Letter Of Authority"); }
	  
	  @Test public void PM_CP_TC_028_verifyDatePickerDisplayLOAExpiresDateTest()
	  throws Throwable { customerDashboardPage. clickCompanyProfile().
	  verifyDatePickerDisplayLOAExpiresDate(); }
	  
	  @Test public void PM_CP_TC_029_LOAExpiresDateSelectFutureDateTest() throws
	  Throwable { customerDashboardPage. clickCompanyProfile().
	  validateLOAExpiresDateSelectFutureDateTest(); }
	  
	  @Test public void
	  PM_CP_TC_030_validateLOApreviousDateSelectPreviousDateTest() throws Throwable
	  { customerDashboardPage. clickCompanyProfile().
	  validateLOAPreviousDateSelectPreviousDateTest(); }
	  
	  @Test public void
	  PM_CP_TC_031_verifyRegisteredAddressErrorSpaceTestDataTest() throws Throwable
	  { customerDashboardPage. clickCompanyProfile().
	  verifyRegisteredAddressErrorSpaceTestData(); }
	  
	  @Test public void PM_CP_TC_032_verifyPostcodeWithSpaceTestDataTest() throws
	  Throwable { customerDashboardPage. clickCompanyProfile().
	  verifyPostcodeWithSpaceTestData(); }
	  
	  @Test(dataProvider = "getData") public void
	  fillCompanyProfileWithDifferentDataTest(String compName, String addr, String
	  postCode, String ph, String regdNo) throws Throwable { customerDashboardPage.
	  clickCompanyProfile(). validateProfileDiffDataSets(compName, addr, postCode,
	  ph, regdNo); }
	  
	  @DataProvider public Object[][] getData() { Object[][] data = {{"Tibco Inc",
	  "Bangalore", "123456", "7234823423", "123456"}, {"Tibco12345",
	  "G R Complex, No. 31, Ground & 1st Floor, Kempegowda Service Rd, Domlur, Bengaluru, Karnataka"
	  , "123456", "7234823423", "123456"}, {"!@#$%^&",
	  "G R Complex, No. 31, Ground & 1st Floor, Kempegowda Service Rd, Domlur, Bengaluru, Karnataka"
	  , "123456", "7234823423", "123456"}, {"      ",
	  "G R Complex, No. 31, Ground & 1st Floor, Kempegowda Service Rd, Domlur, Bengaluru, Karnataka"
	  , "123456", "7234823423", "123456"}, {"</html>",
	  "G R Complex, No. 31, Ground & 1st Floor, Kempegowda Service Rd, Domlur, Bengaluru, Karnataka"
	  , "123456", "7234823423", "123456"}, {"AGB3", "123456789", "123456",
	  "7234823423", "123456"}, {"AGB3", "!@#$%^&*", "123456", "7234823423",
	  "123456"}};
	  
	  return data; }
	 }
