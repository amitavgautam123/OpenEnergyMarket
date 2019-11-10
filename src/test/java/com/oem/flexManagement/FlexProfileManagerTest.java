package com.oem.flexManagement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.FlexProfileManagerPage;
import com.oem.framework.pages.LoginPage;

public class FlexProfileManagerTest extends BaseTest {
	
	CustomerDashboardPage customerDashboardPage;
	
	@BeforeClass
	public void beforeFlexProfileManager() throws Throwable {
		customerDashboardPage = new LoginPage().login();
		customerDashboardPage.goToFlexibleProfileManager();
	}
	

	@Test(priority=0)
	public void FlexProcurementFlexibleProfileManager_verifySubModulesPresenceInFlexmanagement() throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifySubModulesPresenceInFlexmanagement();
	}

	@Test(priority=1)
	public void FlexProcurementFlexibleProfileManager_verifyFlexibleProfileManager_HomePage() throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifyFlexibleProfileManager_HomePage();
	}

	@Test(priority=2)
	public void FlexProcurementFlexibleProfileManager_verifyPresenceOf3Utilitys_in_flexProfileMgrHomePage()
			throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifyPresenceOf3Utilitys_in_flexProfileMgrHomePage();
	}

	@Test(priority=3)
	public void FlexProcurementFlexibleProfileManager_verifyingPresenceOfOptionToSetupFlexibleProfile_in_flexProfileMgrHomePage_HH()
			throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifyingPresenceOfOptionToSetupFlexibleProfile_in_flexProfileMgrHomePage("HH");
	}

	@Test(priority=6)
	public void FlexProcurementFlexibleProfileManager_verifyingPresenceOfListOfMeters_In_FlexibleProfileMgrHomePage_HH()
			throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifyingPresenceOfListOfMeters_In_FlexibleProfileMgrHomePage("HH");
	}

 @Test(priority=7)
	public void FlexProcurementFlexibleProfileManager_verifyingPresenceOfListQuestions_In_FlexibleProfileMgrHomePage_HH()
			throws Throwable {
	 customerDashboardPage.
		clickFlexibleProfileManager().
		verifyingPresenceOfListQuestions_In_FlexibleProfileMgrHomePage("HH");
	}

	@Test(priority=9)
	public void FlexProcurementFlexibleProfileManager_verifyingProfileCreation_In_FlexibleProfileMgrHomePage_HH()
			throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifyingProfileCreation_In_FlexibleProfileMgrHomePage("HH");
	}

	@Test(priority=7)
	public void FlexProcurementFlexibleProfileManager_verifyingProfileCreationAndSelectingEditFlexibleProfile_In_FlexibleProfileMgrHomePage_HH()
			throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifyingProfileCreationAndSelectingEditFlexibleProfile_In_FlexibleProfileMgrHomePage("HH");
	}

	@Test(priority=8)
	public void FlexProcurementFlexibleProfileManager_verifyingProfileCreationAndSelectingReturnToFlexibleProfileManager_In_FlexibleProfileMgrHomePage_HH()
			throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifyingProfileCreationAndSelectingReturnToFlexibleProfileManager_In_FlexibleProfileMgrHomePage("HH");
	}

	@Test(priority=4)
	public void FlexProcurementFlexibleProfileManager_verifyingProfileCreationAndSelectingNo_GoBackToPropertyProfoli_In_FlexibleProfileMgrHomePage_HH()
			throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifyingProfileCreationAndSelectingNo_GoBackToPropertyProfoli_In_FlexibleProfileMgrHomePage("HH");
	}

	@Test(priority=5)
	public void FlexProcurementFlexibleProfileManager_verifyCustomerDashBoardHomePageAfterClickingCancelFlexibleProfileSetUp_In_FlexibleProfileMgrHomePage_HH()
			throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifyCustomerDashBoardHomePageAfterClickingCancelFlexibleProfileSetUp_In_FlexibleProfileMgrHomePage(
						"HH");
	}

	// =====================================================This is Related To
	// NHH Utility ======================================================
	@Test
	public void FlexProcurementFlexibleProfileManager_verifyingPresenceOfOptionToSetupFlexibleProfile_in_flexProfileMgrHomePage_NHH()
			throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifyingPresenceOfOptionToSetupFlexibleProfile_in_flexProfileMgrHomePage("NHH");
	}

	@Test
	public void FlexProcurementFlexibleProfileManager_verifyingPresenceOfListOfMeters_In_FlexibleProfileMgrHomePage_NHH()
			throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifyingPresenceOfListOfMeters_In_FlexibleProfileMgrHomePage("NHH");
	}

	@Test
	public void FlexProcurementFlexibleProfileManager_verifyingPresenceOfListQuestions_In_FlexibleProfileMgrHomePage_NHH()
			throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifyingPresenceOfListQuestions_In_FlexibleProfileMgrHomePage("NHH");
	}

	@Test
	public void FlexProcurementFlexibleProfileManager_verifyingProfileCreation_In_FlexibleProfileMgrHomePage_NHH()
			throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifyingProfileCreation_In_FlexibleProfileMgrHomePage("NHH");
	}

	@Test
	public void FlexProcurementFlexibleProfileManager_verifyingProfileCreationAndSelectingEditFlexibleProfile_In_FlexibleProfileMgrHomePage_NHH()
			throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifyingProfileCreationAndSelectingEditFlexibleProfile_In_FlexibleProfileMgrHomePage("NHH");
	}

	@Test // this is not working
	public void FlexProcurementFlexibleProfileManager_verifyingProfileCreationAndSelectingReturnToFlexibleProfileManager_In_FlexibleProfileMgrHomePage_NHH()
			throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifyingProfileCreationAndSelectingReturnToFlexibleProfileManager_In_FlexibleProfileMgrHomePage(
						"NHH");
	}

	@Test
	public void FlexProcurementFlexibleProfileManager_verifyingProfileCreationAndSelectingNo_GoBackToPropertyProfoli_In_FlexibleProfileMgrHomePage_NHH()
			throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifyingProfileCreationAndSelectingNo_GoBackToPropertyProfoli_In_FlexibleProfileMgrHomePage("NHH");
	}

	@Test
	public void FlexProcurementFlexibleProfileManager_verifyCustomerDashBoardHomePageAfterClickingCancelFlexibleProfileSetUp_In_FlexibleProfileMgrHomePageNHH()
			throws Throwable {
		customerDashboardPage.
		clickFlexibleProfileManager().
		verifyCustomerDashBoardHomePageAfterClickingCancelFlexibleProfileSetUp_In_FlexibleProfileMgrHomePage(
						"NHH");
	}

}
