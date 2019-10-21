package com.oem.framework.pages;

import com.oem.framework.core.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;

public class AdminDashboardPage extends BasePage {

	By impersonateUsername = By.id("ImpersonateUserName");
	By impersonateBtn = By.id("impersonateBtn");

	By flexProcurementAdmin = By.xpath("//h3[contains(text(),'Flex Procurement Admin')]");
	By flexTenderResponse = By.xpath("//li[5]//ul[1]//li[1]//a[1]");
	By flexReQuoteTender = By.xpath("//li[5]//ul[1]//li[2]//a[1]");
	By flexProfileAdmin = By.xpath("//li[5]//ul[1]//li[3]//a[1]");
	
	String titleOfAdmindashBoard="Open Energy Market";

	
	
	
	public FlexibleProfileAdminPage goToflexProcurementAdmin() {
		click(flexProcurementAdmin);
		FlexibleProfileAdminPage flexprofileAdmin=new FlexibleProfileAdminPage();
		flexprofileAdmin.isLoaded();
		return flexprofileAdmin;
		
	}
	public FlexibleProfileAdminPage goToflexTenderResponse() {
		click(flexProcurementAdmin);
		click(flexTenderResponse);
		FlexibleProfileAdminPage flexprofileAdmin=new FlexibleProfileAdminPage();
		flexprofileAdmin.isLoaded();
		return flexprofileAdmin;
	}

	public FlexibleProfileAdminPage goToflexReQuoteTender() {
		click(flexProcurementAdmin);
		Reporter.log("Clicked On flexProcurementAdmin", true);
		click(flexReQuoteTender);
		Reporter.log("Clicked On flexReQuoteTender", true);
		FlexibleProfileAdminPage flexprofileAdmin=new FlexibleProfileAdminPage();
		flexprofileAdmin.isLoaded();
		return flexprofileAdmin;
	}

	public FlexibleProfileAdminPage goToflexProfileAdmin() throws Throwable {
		click(flexProcurementAdmin);
		Reporter.log("Clicked On flexProcurementAdmin", true);
		Thread.sleep(5000);
		click(flexProfileAdmin);
		Reporter.log("Clicked On flexProfileAdmin", true);
		FlexibleProfileAdminPage flexprofileAdmin=new FlexibleProfileAdminPage();
		flexprofileAdmin.isLoaded();
		return flexprofileAdmin;
	}

	public CustomerDashboardPage impersonate(String email) {
		setValue(impersonateUsername, email);
		click(impersonateBtn);
		return new CustomerDashboardPage();
	}

	public SupplierDashboardPage impersonateSupplier() throws Throwable {
		String EMAIL = getPropertyFileData("supplierEmail");
		setValue(impersonateUsername, EMAIL);
		click(impersonateBtn);
		return new SupplierDashboardPage();
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertTrue(isElementPresent(flexProcurementAdmin), "Admin Dashboard page didnt appear");

	}
	
}
