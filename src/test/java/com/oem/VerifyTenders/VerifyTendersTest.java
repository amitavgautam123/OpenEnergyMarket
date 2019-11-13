package com.oem.VerifyTenders;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.VerifyTendersPage;

public class VerifyTendersTest extends BaseTest{

	AdminDashboardPage adminDashboardPage;
	VerifyTendersPage verifyTendersPage;
	
	@BeforeClass
	public void beforeVerifyTenders() throws Throwable {
		adminDashboardPage = new LoginPage().
									loginAsAdmin();
	}
	@Test
	public void verifyAllowSelectedWithoutSelectingAnySupplier() throws Throwable {
		verifyTendersPage.
		goToVerifyTenders().
		verifyAllowSelectedWithoutSelectingAnySupplier();
	}
	@Test
	public void verifyBlockSelectedWithoutSelectingAnySupplier() throws Throwable {
		verifyTendersPage.
		goToVerifyTenders().
		verifyBlockSelectedWithoutSelectingAnySupplier();
	}
}
