package com.oem.FixedProcurement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.LoginPage;

public class ManageTendersTest extends BaseTest {
	
	AdminDashboardPage adminDashboardPage;
	
	@BeforeClass
	public void beforeManageTenders() throws Throwable {
		adminDashboardPage = new LoginPage().loginAsAdmin();
		
	}
	@Test
	public void verfifySubModuleAndUtilityPresence() throws Throwable {
		adminDashboardPage.
		goToManageTendersPage().
		verifyFixedProcurementSubModulesPresence().
		verifyUtilityPresence();
	}
	@Test
	public void hhUtilityTenderBindTest() throws Throwable {
		adminDashboardPage.
		navigateToManageTendersPage().verifyHHutilityBind();
	}
	@Test
	public void nhhUtilityTenderBindTest() throws Throwable {
		adminDashboardPage.
		navigateToManageTendersPage().verifyNHHutilityBind();
	}
	@Test
	public void gasUtilityTenderBindTest() throws Throwable {
		adminDashboardPage.
		navigateToManageTendersPage().verifyGasUtilityBind();
	}

}
