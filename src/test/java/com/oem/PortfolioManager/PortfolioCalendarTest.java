package com.oem.PortfolioManager;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.oem.framework.core.base.BasePage;
import com.oem.framework.core.base.BaseTest;
import com.oem.framework.pages.AdminDashboardPage;
import com.oem.framework.pages.CustomerDashboardPage;
import com.oem.framework.pages.LoginPage;
import com.oem.framework.pages.PortfolioCalendarPage;

public class PortfolioCalendarTest extends BaseTest{
	
	CustomerDashboardPage customerDashboardPage;

    @BeforeClass(alwaysRun = true)
    public void beforePortfolioCalendar() throws Throwable {
    	customerDashboardPage=new LoginPage().
    				login().
    					goToPortfolioCalendar();
    }
	@Test
	public void PM_PC_TC_003_verifyPortfolioManagerElementExistsTest() throws Throwable {
		customerDashboardPage.verifyPortfolioManagerElementExists();
	}
	@Test
	public void PM_PC_TC_004_verifyPortfolioCalendarEntrypopupTest() throws Throwable {
		customerDashboardPage.
				clickPortfolioCalendar().
						verifyPortfolioCalendarEntrypopup();
	}
	@Test 
	public void PM_PC_TC_005_verifyCloseBtnPortfolioCalendarEntrypopupTest() throws Throwable {
		customerDashboardPage.
			    clickPortfolioCalendar().
					   verifyCloseBtnPortfolioCalendarEntrypopup();
	}
	@Test
	public void PM_PC_TC_007_verifyDateInEventDateTest() throws Throwable {
		customerDashboardPage.
	    clickPortfolioCalendar().
	    verifyDateInEventDate();
	}
	@Test
	public void PM_PC_TC_008_validateEventDescriptionPortfolioCaledarEntryPopupTest() throws Throwable {
		customerDashboardPage.
	    clickPortfolioCalendar().
	    validateEventDescriptionPortfolioCaledarEntryPopup();
	}
	@Test
	public void PM_PC_TC_009_validateDeleteEventPopupTest() throws Throwable {
		customerDashboardPage.
	    clickPortfolioCalendar().
	    validateDeleteEventPopup();
	}
	@Test
	public void PM_PC_TC_010_validateCancelBtnDeleteEventPopupTest() throws Throwable {
		customerDashboardPage.
	    clickPortfolioCalendar().
	    	validateCancelBtnDeleteEventPopup();
	}
	@Test
	public void PM_PC_TC_011_validateDeleteEventTest() throws Throwable {
		customerDashboardPage.
	    clickPortfolioCalendar().
	    validateDeleteEvent();
	}
	@Test
	public void PM_PC_TC_012_validateEditEventPopupTest() throws Throwable {
		customerDashboardPage.
	    clickPortfolioCalendar().
	    validateEditEventPopup("Edit portfolio calendar entry");
	}
	/*@Test
	public void PM_PC_TC_013() throws Throwable {
		LoginPage loginPage = new LoginPage();
		CustomerDashboardPage customerDashboardPage = (CustomerDashboardPage) loginPage
				.login();
		PortfolioCalendarPage portfolioCalendarPage = (PortfolioCalendarPage) customerDashboardPage.goToPortfolioCalendar();
		portfolioCalendarPage.validateCloseIconEditEventPopup();
	}*/
	@Test
	public void PM_PC_TC_014_validateEditEventChangingDateTest() throws Throwable {
		customerDashboardPage.
	    clickPortfolioCalendar().
	    validateEditEventChangingDate();
	}
	@Test
	public void PM_PC_TC_015_validateEditEventChangingDescriptionTest() throws Throwable {
		customerDashboardPage.
	    clickPortfolioCalendar().
	    validateEditEventChangingDescription();
	}
	@Test
	public void PM_PC_TC_016_validateErrMsgEnteringDuplicateCalenderEventsTest() throws Throwable {
		customerDashboardPage.
	    clickPortfolioCalendar().
	    validateErrorMessageAfterEnteringDuplicateCalenderEvents();
	}
	@Test(dataProvider = "getData")
	public void addCalendarEventUsingDataProviderTest(String description) throws Throwable {
		customerDashboardPage.
	    clickPortfolioCalendar().
	    validateDescriptionWithDifferentTestDataPortfolioCaledarEntryPopup(description);
	}
	@DataProvider
	public Object[][] getData() {
		Object data[][] = new Object[7][1];
		data[0][0] = "Lorem Ipsum is simply dummy text.";
		data[1][0] = "";
		data[2][0] = "123456";
		data[3][0] = "!@#$%";
		data[4][0] = "       ";
		data[5][0] = "</html>";
		data[6][0] = "Lorem Ipsum123456";
		return data;
	}

}
