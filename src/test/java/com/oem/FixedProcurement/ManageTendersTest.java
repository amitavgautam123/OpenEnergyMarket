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
		adminDashboardPage.goToManageTendersPage();
	}
	@Test
	public void verfifyManageQuote() {
		
	}

}
