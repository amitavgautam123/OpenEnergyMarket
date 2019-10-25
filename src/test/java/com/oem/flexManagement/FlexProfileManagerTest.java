package com.oem.flexManagement;

import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.FlexProfileManagerPage;
import com.oem.framework.pages.LoginPage;

public class FlexProfileManagerTest extends BaseTest {
	
	
	

	@Test(priority=0)
	public void FlexProcurementFlexibleProfileManager_verifySubModulesPresenceInFlexmanagement() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage.verifySubModulesPresenceInFlexmanagement();
		
		
	}

	@Test(priority=1)
	public void FlexProcurementFlexibleProfileManager_verifyFlexibleProfileManager_HomePage() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage.verifyFlexibleProfileManager_HomePage();
	}

	@Test(priority=2)
	public void FlexProcurementFlexibleProfileManager_verifyPresenceOf3Utilitys_in_flexProfileMgrHomePage()
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage.verifyPresenceOf3Utilitys_in_flexProfileMgrHomePage();
	}

	@Test(priority=3)
	public void FlexProcurementFlexibleProfileManager_verifyingPresenceOfOptionToSetupFlexibleProfile_in_flexProfileMgrHomePage_HH()
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage.verifyingPresenceOfOptionToSetupFlexibleProfile_in_flexProfileMgrHomePage("HH");
	}

	@Test(priority=6)
	public void FlexProcurementFlexibleProfileManager_verifyingPresenceOfListOfMeters_In_FlexibleProfileMgrHomePage_HH()
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage.verifyingPresenceOfListOfMeters_In_FlexibleProfileMgrHomePage("HH");
	}

 @Test(priority=7)
	public void FlexProcurementFlexibleProfileManager_verifyingPresenceOfListQuestions_In_FlexibleProfileMgrHomePage_HH()
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage.verifyingPresenceOfListQuestions_In_FlexibleProfileMgrHomePage("HH");
	}

	@Test(priority=9)
	public void FlexProcurementFlexibleProfileManager_verifyingProfileCreation_In_FlexibleProfileMgrHomePage_HH()
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage.verifyingProfileCreation_In_FlexibleProfileMgrHomePage("HH");
	}

	@Test(priority=7)
	public void FlexProcurementFlexibleProfileManager_verifyingProfileCreationAndSelectingEditFlexibleProfile_In_FlexibleProfileMgrHomePage_HH()
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage
				.verifyingProfileCreationAndSelectingEditFlexibleProfile_In_FlexibleProfileMgrHomePage("HH");
	}

	@Test(priority=8)
	public void FlexProcurementFlexibleProfileManager_verifyingProfileCreationAndSelectingReturnToFlexibleProfileManager_In_FlexibleProfileMgrHomePage_HH()
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage
				.verifyingProfileCreationAndSelectingReturnToFlexibleProfileManager_In_FlexibleProfileMgrHomePage("HH");
	}

	@Test(priority=4)
	public void FlexProcurementFlexibleProfileManager_verifyingProfileCreationAndSelectingNo_GoBackToPropertyProfoli_In_FlexibleProfileMgrHomePage_HH()
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage
				.verifyingProfileCreationAndSelectingNo_GoBackToPropertyProfoli_In_FlexibleProfileMgrHomePage("HH");
	}

	@Test(priority=5)
	public void FlexProcurementFlexibleProfileManager_verifyCustomerDashBoardHomePageAfterClickingCancelFlexibleProfileSetUp_In_FlexibleProfileMgrHomePage_HH()
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage
				.verifyCustomerDashBoardHomePageAfterClickingCancelFlexibleProfileSetUp_In_FlexibleProfileMgrHomePage(
						"HH");
	}

	// =====================================================This is Related To
	// NHH Utility ======================================================
	//@Test
	public void FlexProcurementFlexibleProfileManager_verifyingPresenceOfOptionToSetupFlexibleProfile_in_flexProfileMgrHomePage_NHH()
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage.verifyingPresenceOfOptionToSetupFlexibleProfile_in_flexProfileMgrHomePage("NHH");
	}

	//@Test
	public void FlexProcurementFlexibleProfileManager_verifyingPresenceOfListOfMeters_In_FlexibleProfileMgrHomePage_NHH()
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage.verifyingPresenceOfListOfMeters_In_FlexibleProfileMgrHomePage("NHH");
	}

	//@Test
	public void FlexProcurementFlexibleProfileManager_verifyingPresenceOfListQuestions_In_FlexibleProfileMgrHomePage_NHH()
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage.verifyingPresenceOfListQuestions_In_FlexibleProfileMgrHomePage("NHH");
	}

	//@Test
	public void FlexProcurementFlexibleProfileManager_verifyingProfileCreation_In_FlexibleProfileMgrHomePage_NHH()
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage.verifyingProfileCreation_In_FlexibleProfileMgrHomePage("NHH");
	}

	//@Test
	public void FlexProcurementFlexibleProfileManager_verifyingProfileCreationAndSelectingEditFlexibleProfile_In_FlexibleProfileMgrHomePage_NHH()
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage
				.verifyingProfileCreationAndSelectingEditFlexibleProfile_In_FlexibleProfileMgrHomePage("NHH");
	}

	//@Test // this is not working
	public void FlexProcurementFlexibleProfileManager_verifyingProfileCreationAndSelectingReturnToFlexibleProfileManager_In_FlexibleProfileMgrHomePage_NHH()
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage
				.verifyingProfileCreationAndSelectingReturnToFlexibleProfileManager_In_FlexibleProfileMgrHomePage(
						"NHH");
	}

	//@Test
	public void FlexProcurementFlexibleProfileManager_verifyingProfileCreationAndSelectingNo_GoBackToPropertyProfoli_In_FlexibleProfileMgrHomePage_NHH()
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage
				.verifyingProfileCreationAndSelectingNo_GoBackToPropertyProfoli_In_FlexibleProfileMgrHomePage("NHH");
	}

	//@Test
	public void FlexProcurementFlexibleProfileManager_verifyCustomerDashBoardHomePageAfterClickingCancelFlexibleProfileSetUp_In_FlexibleProfileMgrHomePageNHH()
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage) customerDashboardPage
				.goToFlexibleProfileManager();
		flexProfileManagerPage
				.verifyCustomerDashBoardHomePageAfterClickingCancelFlexibleProfileSetUp_In_FlexibleProfileMgrHomePage(
						"NHH");
	}

}
