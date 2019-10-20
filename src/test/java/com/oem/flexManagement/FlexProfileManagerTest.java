package com.oem.flexManagement;

import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.FlexProfileManagerPage;
import com.oem.framework.pages.LoginPage;

public class FlexProfileManagerTest extends BaseTest {
	
	@Test
	public void FM_FPM_TC_003() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage)loginPage.login();
		FlexProfileManagerPage flexProfileManagerPage = (FlexProfileManagerPage)customerDashboardPage.goToFlexibleProfileManager();
		flexProfileManagerPage.verifySubModulesPresenceInFlexmanagement();
	}
}
