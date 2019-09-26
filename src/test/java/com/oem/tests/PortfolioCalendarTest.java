package com.oem.tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.PortfolioCalendarPage;

public class PortfolioCalendarTest extends BaseTest{
	@Test
	public void PM_PC_TC_003() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		customerDashboardPage.verifyPortfolioManagerElementExists();
	}
	@Test
	public void PM_PC_TC_004() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PortfolioCalendarPage portfolioCalendarPage = (PortfolioCalendarPage) customerDashboardPage.goToPortfolioCalendar();
		portfolioCalendarPage.verifyPortfolioCalendarEntrypopup(
				"Add new portfolio calendar entry");
	}
	@Test 
	public void PM_PC_TC_005() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PortfolioCalendarPage portfolioCalendarPage = (PortfolioCalendarPage) customerDashboardPage.goToPortfolioCalendar();
		portfolioCalendarPage.verifyCloseBtnPortfolioCalendarEntrypopup();
	}
	@Test
	public void PM_PC_TC_007() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PortfolioCalendarPage portfolioCalendarPage = (PortfolioCalendarPage) customerDashboardPage.goToPortfolioCalendar();
		portfolioCalendarPage.verifyDateInEventDate();
	}
	@Test
	public void PM_PC_TC_008() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PortfolioCalendarPage portfolioCalendarPage = (PortfolioCalendarPage) customerDashboardPage.goToPortfolioCalendar();
		portfolioCalendarPage.validateEventDescriptionPortfolioCaledarEntryPopup("The Event Description * field is required.");
	}
	@Test
	public void PM_PC_TC_009() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PortfolioCalendarPage portfolioCalendarPage = (PortfolioCalendarPage) customerDashboardPage.goToPortfolioCalendar();
		portfolioCalendarPage.validateDeleteEventPopup("Are you sure you want to delete this event?");
	}
	@Test
	public void PM_PC_TC_010() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PortfolioCalendarPage portfolioCalendarPage = (PortfolioCalendarPage) customerDashboardPage.goToPortfolioCalendar();
		portfolioCalendarPage.validateCancelBtnDeleteEventPopup();
	}
	@Test
	public void PM_PC_TC_011() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PortfolioCalendarPage portfolioCalendarPage = (PortfolioCalendarPage) customerDashboardPage.goToPortfolioCalendar();
		portfolioCalendarPage.validateDeleteEvent();
	}
	@Test
	public void PM_PC_TC_012() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PortfolioCalendarPage portfolioCalendarPage = (PortfolioCalendarPage) customerDashboardPage.goToPortfolioCalendar();
		portfolioCalendarPage.validateEditEventPopup("Edit portfolio calendar entry");
	}
	@Test
	public void PM_PC_TC_013() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PortfolioCalendarPage portfolioCalendarPage = (PortfolioCalendarPage) customerDashboardPage.goToPortfolioCalendar();
		portfolioCalendarPage.validateCloseIconEditEventPopup();
	}
	@Test
	public void PM_PC_TC_014() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PortfolioCalendarPage portfolioCalendarPage = (PortfolioCalendarPage) customerDashboardPage.goToPortfolioCalendar();
		portfolioCalendarPage.validateEditEventChangingDate();
	}
	@Test
	public void PM_PC_TC_015() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PortfolioCalendarPage portfolioCalendarPage = (PortfolioCalendarPage) customerDashboardPage.goToPortfolioCalendar();
		portfolioCalendarPage.validateEditEventChangingDescription();
	}
	@Test(dataProvider = "getData")
	public void addCalendarEventUsingDataProviderTest(String description) throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PortfolioCalendarPage portfolioCalendarPage = (PortfolioCalendarPage) customerDashboardPage.goToPortfolioCalendar();
		portfolioCalendarPage.validateDescriptionWithDifferentTestDataPortfolioCaledarEntryPopup(description);
	}
	@DataProvider
	public Object[][] getData() {
		Object data[][] = new Object[7][1];
		data[0][0] = "Lorem Ipsum is simply dummy text.";
		data[1][0] = "";
		data[2][0] = "123456";
		data[3][0] = "!@#$%";
		data[4][0] = "Lorem Ipsum123456";
		data[5][0] = "</html>";
		data[6][0] = "      ";
		return data;
	}

}
