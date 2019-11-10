package com.oem.flexManagement;

import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.FlexProfileAdminPage;
import com.oem.framework.pages.LoginPage;

public class FlexibleProfileAdminTest extends BaseTest{

	@Test
	public void TC_FMP_04() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		Thread.sleep(5000);
		FlexProfileAdminPage flexibleprofileAdmin= (FlexProfileAdminPage)admindashborad.goToflexProfileAdmin();
		Thread.sleep(5000);
		flexibleprofileAdmin.verifyThePresenceOfAllCustomers();
		
	}
	@Test
	public void TC_FMP_03() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		Thread.sleep(5000);
		FlexibleProfileAdminPage flexibleprofileAdmin= (FlexProfileAdminPage)admindashborad.goToflexProcurementAdmin();
		Thread.sleep(5000);
		flexibleprofileAdmin.verifyPresenceOf3Modules();
		
	}
	@Test
	public void TC_FMP_05() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		Thread.sleep(5000);
		FlexibleProfileAdminPage flexibleprofileAdmin= (FlexibleProfileAdminPage)admindashborad.goToflexProfileAdmin();
		Thread.sleep(5000);
		flexibleprofileAdmin.VerifypresenceOfDuration_Manage_DeleteOptions_AfterSelectingCustomer();
	}
	@Test
	public void TC_FMP_06() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		Thread.sleep(5000);
		FlexProfileAdminPage flexibleprofileAdmin= (FlexProfileAdminPage)admindashborad.goToflexProfileAdmin();
		Thread.sleep(5000);
		flexibleprofileAdmin.verifyProfileDetails_ProfileActions_PresenceOf_Impersonate_Users();
		/*System.out.println("=================Ghg=============");
		flexibleprofileAdmin.verifyingCustomerBiding_AfterClicking_GovernanceManage();*/
	}
	@Test
	public void TC_FMP_007() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		Thread.sleep(5000);
		FlexibleProfileAdminPage flexibleprofileAdmin= (FlexibleProfileAdminPage)admindashborad.goToflexProfileAdmin();
		Thread.sleep(5000);
		flexibleprofileAdmin.verifyingCustomerBiding_AfterClicking_GovernanceManage();
	}
	@Test
	public void TC_FMP_07() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		Thread.sleep(5000);
		FlexProfileAdminPage flexibleprofileAdmin= (FlexibleProfileAdminPage)admindashborad.goToflexProfileAdmin();
		Thread.sleep(5000);
		flexibleprofileAdmin.verify_Upadate_Accept_RejectOptions_ArePresent();
	}
	@Test//need to work on this
	public void TC_FMP_09() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		Thread.sleep(5000);
		FlexProfileAdminPage flexibleprofileAdmin= (FlexProfileAdminPage)admindashborad.goToflexProfileAdmin();
		Thread.sleep(5000);
		flexibleprofileAdmin.verifying_presenceOfUpdateButton_AfetrClikingAcceptButton();
	}
	@Test//need to work on this
	public void TC_FMP_08() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		Thread.sleep(5000);
		FlexibleProfileAdminPage flexibleprofileAdmin= (FlexProfileAdminPage)admindashborad.goToflexProfileAdmin();
		Thread.sleep(5000);
		flexibleprofileAdmin.verifying_presenceOfUpdateButton_AfetrClikingRejectButton();
	}
	@Test
	public void TC_FMP_44() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		Thread.sleep(5000);
		FlexibleProfileAdminPage flexibleprofileAdmin= (FlexibleProfileAdminPage)admindashborad.goToflexProfileAdmin();
		Thread.sleep(5000);
		flexibleprofileAdmin.verifyingEditTradeVolumePage();
	}
	@Test
	public void TC_FMP_46() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		//Thread.sleep(5000);
		FlexibleProfileAdminPage flexibleprofileAdmin= (FlexibleProfileAdminPage)admindashborad.goToflexProfileAdmin();
		//Thread.sleep(5000);
		flexibleprofileAdmin.verifyingEditButton_CancelButton_VoluemIsEnabledOfSupplierclipVolumes();
	}
	@Test
	public void TC_FMP_47() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		//Thread.sleep(5000);
		FlexibleProfileAdminPage flexibleprofileAdmin= (FlexibleProfileAdminPage)admindashborad.goToflexProfileAdmin();
		//Thread.sleep(5000);
		flexibleprofileAdmin.verifyDisablityOfVolumeAfterClickingCancelButton();
	}
	@Test
	public void TC_FMP_48() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		//Thread.sleep(5000);
		FlexibleProfileAdminPage flexibleprofileAdmin= (FlexibleProfileAdminPage)admindashborad.goToflexProfileAdmin();
		//Thread.sleep(5000);
		flexibleprofileAdmin.verifyDisablityOfVolumeAfterChangingVolumeandClickingCancelButton();
	}
	@Test
	public void TC_FMP_51() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		//Thread.sleep(5000);
		FlexibleProfileAdminPage flexibleprofileAdmin= (FlexibleProfileAdminPage)admindashborad.goToflexProfileAdmin();
		//Thread.sleep(5000);
		flexibleprofileAdmin.verifyingVolumeTextBoxShouldNotAcceptAlphabets();
	}
	
	@Test
	public void TC_FMP_57() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		//Thread.sleep(5000);
		FlexibleProfileAdminPage flexibleprofileAdmin= (FlexibleProfileAdminPage)admindashborad.goToflexProfileAdmin();
		//Thread.sleep(5000);
		flexibleprofileAdmin.verifyValueOfVolumeAfterEnteringValidVolumeDataandClickingSaveButton();
	}
	@Test
	public void TC_FMP_58() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		FlexibleProfileAdminPage flexibleprofileAdmin= (FlexibleProfileAdminPage)admindashborad.goToflexProfileAdmin();
		flexibleprofileAdmin.verify_Recient_Clicked_EditButton_Willbe_ShownItsActions();
	}
	@Test
	public void TC_FMP_59() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		FlexibleProfileAdminPage flexibleprofileAdmin= (FlexibleProfileAdminPage)admindashborad.goToflexProfileAdmin();
		flexibleprofileAdmin.verify_HomePageIfTrading_AfetrClicking_TradingLink();
	}
	@Test
	public void TC_FMP_60() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		FlexibleProfileAdminPage flexibleprofileAdmin= (FlexibleProfileAdminPage)admindashborad.goToflexProfileAdmin();
		flexibleprofileAdmin.verify_HomePageIfTrad_AfetrClicking_TradLinkInTradingHomePage();
	}
	@Test
	public void TC_FMP_61_verify_TotalValue_AfterEnteringUnitPrice_RequiredVolume() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		FlexibleProfileAdminPage flexibleprofileAdmin= (FlexProfileAdminPage)admindashborad.goToflexProfileAdmin();
		flexibleprofileAdmin.verify_TotalValue_AfterEnteringUnitPrice_RequiredVolume();
	}
	@Test
	public void TC_FMP_62_verify_AlertMessage_AfterEnteringUnitPrice_RequiredVolume_andClickingSaveButton() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		FlexibleProfileAdminPage flexibleprofileAdmin= (FlexProfileAdminPage)admindashborad.goToflexProfileAdmin();
		flexibleprofileAdmin.verify_AlertMessage_AfterEnteringUnitPrice_RequiredVolume_andClickingSaveButton();
	}
	@Test
	public void TC_FMP_63_verify_DeleteButton_AfterEnteringUnitPrice_RequiredVolume_andClickingSaveButton() throws Throwable{
		LoginPage loginPage = new LoginPage();
		AdminDashboardPage admindashborad=(AdminDashboardPage) loginPage.loginAsAdmin();
		FlexibleProfileAdminPage flexibleprofileAdmin= (FlexibleProfileAdminPage)admindashborad.goToflexProfileAdmin();
		flexibleprofileAdmin.verify_DeleteButton_AfterEnteringUnitPrice_RequiredVolume_andClickingSaveButton();
	}
}
