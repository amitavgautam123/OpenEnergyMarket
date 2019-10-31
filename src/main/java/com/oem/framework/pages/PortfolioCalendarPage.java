package com.oem.framework.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class PortfolioCalendarPage extends CustomerDashboardPage {
	
	By addCalendarEntry = By.id("new-entry-btn");
	By portfolioCalendarEntryPopUp = By.xpath("//h3[text() = 'Add new portfolio calendar entry']");
	By close_PortfolioCalendarEntryPopup = By.xpath("//div[@id='add-calendar-entry']//button[@class='close icon-close']");
	By eventDate = By.id("NewCalendarEntry_EventDate");
	By eventDescription = By.id("NewCalendarEntry_EventDescription");
	By saveBtn = By.xpath("//button[text() = 'Save entry']");
	By eventDescriptionErrorMessage = By.id("NewCalendarEntry_EventDescription-error");
	By deleteEntry = By.xpath("//tbody[@aria-live = 'polite']/tr[1]/td[4]/a");
	By delete_popup = By.xpath("//div[@class = 'vex-dialog-message' and text() = 'Are you sure you want to delete this event?']");
	By delete_CancelBtn = By.xpath("//button[@class and text() = 'Cancel']");
	By delete_OkBtn = By.xpath("//button[@class and text() = 'OK']");
	By eventDes_firstRecord = By.xpath("//tbody[@aria-live = 'polite']/tr[1]/td[2]");
	By eventDes_AllRecords = By.xpath("//table[@id = 'event-table']/tbody/tr[*]/td[2]");
	By eventDate_firstRecord = By.xpath("//table[@id = 'event-table']/tbody/tr[1]/td[1]");
	By editEntry = By.xpath("//tbody[@aria-live = 'polite']/tr[1]/td[3]/a");
	By edit_popup = By.xpath("//h3[text() = 'Edit portfolio calendar entry']");
	By serverError = By.xpath("//*[contains(text(), 'Server Error')]");
	
	
	@Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in CustomerDashboard Page");
        Assert.assertTrue(isElementPresent(addCalendarEntry),"Portfolio Calendar Page didnt appear");
        
    }
	public void verifyPortfolioCalendarEntrypopup() throws InterruptedException{
		click(addCalendarEntry);
		Thread.sleep(1000);
		boolean popupDisplayStatus = isElementPresent(portfolioCalendarEntryPopUp);
		refreshPage();
        Assert.assertTrue(popupDisplayStatus, "Portfolio Calendar popup is not displaying.");
    }
	public PortfolioCalendarPage verifyCloseBtnPortfolioCalendarEntrypopup() throws InterruptedException{
		click(addCalendarEntry);
		Thread.sleep(1000);
		click(close_PortfolioCalendarEntryPopup);
		Thread.sleep(1000);
		boolean status = driver.findElement(By.xpath("//h3[text() = 'Add new portfolio calendar entry']")).isDisplayed();
		Assert.assertFalse(status, "Close button not working.");
		return this;
    }
	public void verifyDateInEventDate() throws Throwable {
		click(addCalendarEntry);
		Thread.sleep(1000);
		click(eventDate);
		selectFutureDateCalender(18, 6, 2020);
		String dateData = getAttribute(eventDate, "value");
		boolean dateDisplayStatus = dateData.contains("18/07/2020");
		refreshPage();
		Assert.assertTrue(dateDisplayStatus, "Incorrect date is displaying after choosing date in date picker");
	}
	public void validateDescriptionWithDifferentTestDataPortfolioCaledarEntryPopup(String data) throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		click(addCalendarEntry);
		Thread.sleep(2000);
		click(eventDate);
		Thread.sleep(1000);
		selectFutureDateCalender(15, 3, 2020);
		setValue(eventDescription, data);
		click(saveBtn);
		Thread.sleep(2000);
		boolean eventAdditionStatus = isElementExistInDropDown(eventDes_AllRecords, data);
		if(isElementPresent(serverError, 10)) {
        	driver.navigate().back();
        	softAssertion.assertTrue(false, "Server Error is displaying.");
        }
		refreshPage();
		softAssertion.assertTrue(eventAdditionStatus, 
				"The calendar event was not saved.");
		softAssertion.assertAll();
	}
	public void validateEventDescriptionPortfolioCaledarEntryPopup() throws InterruptedException
	{
		click(addCalendarEntry);
		Thread.sleep(2000);
		click(eventDate);
		selectFutureDateCalender(20, 4, 2020);
		clearValue(eventDescription);
		click(saveBtn);
		Thread.sleep(1000);
		boolean errMsgDisplayStatus = isElementPresent(eventDescriptionErrorMessage);
		refreshPage();
		Assert.assertTrue(errMsgDisplayStatus, "Error message for event description is not displaying.");
	}
	public void validateDeleteEventPopup() throws InterruptedException
	{
		click(deleteEntry);
		Thread.sleep(1000);
		boolean deletePopupDisplayStatus = isElementPresent(delete_popup);
		refreshPage();
		Assert.assertTrue(deletePopupDisplayStatus, "Delete popup is not displaying.");
	}
	public void validateCancelBtnDeleteEventPopup() throws InterruptedException
	{
		click(deleteEntry);
		Thread.sleep(1000);
		click(delete_CancelBtn);
		Thread.sleep(1000);
		boolean status = isElementPresent(delete_popup);
		refreshPage();
		Assert.assertFalse(status, "Delete popup is still displaying.");		
	}
	public void validateDeleteEvent() throws InterruptedException
	{
		String date = getText(eventDate_firstRecord);
		String desc = getText(eventDes_firstRecord);
		click(deleteEntry);
		Thread.sleep(1000);
		click(delete_OkBtn);
		Thread.sleep(2000);
		boolean status = desc.equals(getText(eventDes_firstRecord)) && date.equals(getText(eventDate_firstRecord));
		refreshPage();
		Assert.assertFalse(status, "Event is not getting deleted.");
	}
	public void validateEditEventPopup(String value) throws Throwable
	{
		click(editEntry);
		Thread.sleep(2000);
		boolean popupDisplayStatus = isElementPresent(edit_popup);
		refreshPage();
		Assert.assertTrue(popupDisplayStatus, "Edit popup is not displaying.");
	}
	public void validateCloseIconEditEventPopup() throws InterruptedException
	{
		click(editEntry);
		Thread.sleep(1000);
		//boolean editPopUpDisplayStatus1=driver.findElement(saveBtn).isDisplayed();
		//System.out.println(editPopUpDisplayStatus1);
		click(close_PortfolioCalendarEntryPopup);
		Thread.sleep(2000);
		boolean editPopUpDisplayStatus=driver.findElement(saveBtn).isDisplayed();//Checking for the Save Button which is inside PopUp Is Displayed Or Not
		//System.out.println(editPopUpDisplayStatus);
		Assert.assertFalse(editPopUpDisplayStatus, "Edit popup is still displaying after closing it.");	
		
	}
	public void validateEditEventChangingDate() throws InterruptedException
	{
		String desc = getText(eventDes_firstRecord);
		click(editEntry);
		Thread.sleep(1000);
		click(eventDate);
		Thread.sleep(1000);
		selectPrevDateCalender(20, 2, 2017);
		click(saveBtn);
		boolean status = getText(eventDate_firstRecord).equals("20/03/2017") && getText(eventDes_firstRecord).equals(desc);
		refreshPage();
		Assert.assertEquals(status, "Event is not showing proper description after editing date.");
	}
	public void validateEditEventChangingDescription() throws InterruptedException
	{
		String date = getText(eventDate_firstRecord);
		click(editEntry);
		Thread.sleep(1000);
		setValue(eventDescription, "Bank holiday");
		click(saveBtn);
		Thread.sleep(1000);
		boolean status = getText(eventDes_firstRecord).equals("Bank holiday") && getText(eventDate).equals(date);
		
	}
	public void validateErrorMessageAfterEnteringDuplicateCalenderEvents() throws Throwable{
		click(addCalendarEntry);
		Thread.sleep(1000);
		click(eventDate);
		
		Thread.sleep(1000);
		selectFutureDateCalender(20,11,2020);
		setValue(eventDescription, "2025 year Event");
		click(saveBtn);
		//Entering date and Description For the second time with same Data 
		click(addCalendarEntry);
		Thread.sleep(2000);
		click(eventDate);
		Thread.sleep(1000);
		selectFutureDateCalender(20,11,2020);
		setValue(eventDescription, "2025 year Event");
		click(saveBtn);
		
		boolean text=driver.findElement(addCalendarEntry).isDisplayed();
		refreshPage();
		Assert.assertFalse(text, "No Alert Message Is Shown, Even After Entering Duplicate Event Dates ");	

		
		
	}
	
}
