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
	
	
	
	@Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in CustomerDashboard Page");
        Assert.assertTrue(isElementPresent(addCalendarEntry),"Portfolio Calendar Page didnt appear");
        
    }
	public void verifyPortfolioCalendarEntrypopup(String value) throws InterruptedException{
		click(addCalendarEntry);
		Thread.sleep(1000);
        Assert.assertTrue(StringUtils.isNoneBlank(getText(portfolioCalendarEntryPopUp)) &&
                getText(portfolioCalendarEntryPopUp).trim().contains(value),"Portfolio Calendar Entry Popup heading actual value: "+getText(portfolioCalendarEntryPopUp) +" but expected:"+value);
    }
	public void verifyCloseBtnPortfolioCalendarEntrypopup() throws InterruptedException{
		click(addCalendarEntry);
		Thread.sleep(1000);
		click(close_PortfolioCalendarEntryPopup);
		Thread.sleep(1000);
		boolean status = driver.findElement(By.xpath("//h3[text() = 'Add new portfolio calendar entry']")).isDisplayed();
		Assert.assertEquals(status, false);
    }
	public void verifyDateInEventDate() throws Throwable {
		click(addCalendarEntry);
		Thread.sleep(1000);
		click(eventDate);
		selectFutureDateCalender(18, 6, 2020);
		String dateData = getAttribute(eventDate, "value");
		Reporter.log("Stored the data present in value attribut of event date field", true);
		boolean dateDisplayStatus = dateData.contains("18/07/2020");
		Reporter.log("Checked if the value attribute contains the same date we entered in the date picker", true);
		Assert.assertTrue(dateDisplayStatus, "Incorrect date is displaying after choosing date in date picker");
	}
	public void validateDescriptionWithDifferentTestDataPortfolioCaledarEntryPopup(String data) throws InterruptedException
	{
		click(addCalendarEntry);
		Thread.sleep(2000);
		click(eventDate);
		selectFutureDateCalender(15, 3, 2020);
		setValue(eventDescription, data);
		click(saveBtn);
		Assert.assertTrue(isElementExistInDropDown(eventDes_AllRecords, data), 
				"The calendar event was not saved.");
	}
	public void validateEventDescriptionPortfolioCaledarEntryPopup(String value) throws InterruptedException
	{
		click(addCalendarEntry);
		Thread.sleep(2000);
		click(eventDate);
		selectFutureDateCalender(20, 4, 2020);
		setValue(eventDescription, "");
		click(saveBtn);
		Assert.assertTrue(StringUtils.isNoneBlank(getText(eventDescriptionErrorMessage)) &&
                getText(eventDescriptionErrorMessage).trim().contains(value),"Event Description Error message actual value: "+getText(eventDescriptionErrorMessage) +" but expected:"+value);
	}
	public void validateDeleteEventPopup(String value)
	{
		click(deleteEntry);
		Assert.assertTrue(StringUtils.isNoneBlank(getText(delete_popup)) &&
                getText(delete_popup).trim().contains(value),"Delete event popup message: "+getText(delete_popup) +" but expected:"+value);
	}
	public void validateCancelBtnDeleteEventPopup() throws InterruptedException
	{
		click(deleteEntry);
		click(delete_CancelBtn);
		Thread.sleep(1000);
		boolean status = isElementPresent(delete_popup);
		System.out.println("Is delete popup displaying: " + status);
		Assert.assertEquals(false, status);		
	}
	public void validateDeleteEvent() throws InterruptedException
	{
		String date = getText(eventDate_firstRecord);
		String desc = getText(eventDes_firstRecord);
		click(deleteEntry);
		Reporter.log("clicked 'Delete Entry' button for first row");
		click(delete_OkBtn);
		Reporter.log("clicked Ok button in delete popup");
		Thread.sleep(2000);
		boolean status = desc.equals(getText(eventDes_firstRecord)) && date.equals(getText(eventDate_firstRecord));
		Reporter.log("compared description and date in the first row before delete and after deleting an event");		
		Assert.assertEquals(false, status);
	}
	public void validateEditEventPopup(String value) throws Throwable
	{
		click(editEntry);
		Thread.sleep(2000);
		Reporter.log("clicked 'Edit Entry' button for first row");
		Assert.assertTrue(StringUtils.isNoneBlank(getText(edit_popup)) &&
                getText(edit_popup).trim().contains(value),"Edit event popup heading: "+getText(edit_popup) +" but expected:"+value);
	}
	public void validateCloseIconEditEventPopup() throws InterruptedException
	{
		click(editEntry);
		Reporter.log("clicked 'Edit Entry' button for first row");
		Thread.sleep(1000);
		click(close_PortfolioCalendarEntryPopup);
		Reporter.log("Clicked close icon in edit entry popup");
		Thread.sleep(2000);
		boolean editPopUpDisplayStatus = isElementPresent(edit_popup);
		Reporter.log("Checked if edit popup is still displaying");
		Assert.assertFalse(editPopUpDisplayStatus, "Edit popup is still displaying after closing it.");		
	}
	public void validateEditEventChangingDate() throws InterruptedException
	{
		String desc = getText(eventDes_firstRecord);
		Reporter.log("captured description in first record");
		click(editEntry);
		Reporter.log("clicked 'Edit Entry' button for first row");
		Thread.sleep(1000);
		click(eventDate);
		selectPrevDateCalender(20, 2, 2017);
		Reporter.log("Entered date in date picker");
		click(saveBtn);
		Reporter.log("Clicked save entry button");
		boolean status = getText(eventDate_firstRecord).equals("20/03/2017") && getText(eventDes_firstRecord).equals(desc);
		Reporter.log("compared date and description editing");
		Assert.assertEquals(true, status);
	}
	public void validateEditEventChangingDescription() throws InterruptedException
	{
		String date = getText(eventDate_firstRecord);
		click(editEntry);
		Reporter.log("Clicked on edit entry");
		Thread.sleep(1000);
		setValue(eventDescription, "Bank holiday");
		Reporter.log("Entered data in event description");
		click(saveBtn);
		Reporter.log("clicked save button");
		Thread.sleep(1000);
		boolean status = getText(eventDes_firstRecord).equals("Bank holiday") && getText(eventDate).equals(date);
		Reporter.log("Compared data in event date and description after editing");
	}
	
}
