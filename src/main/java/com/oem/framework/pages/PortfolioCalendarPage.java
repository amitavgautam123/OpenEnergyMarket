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
	By delete_CancelBtn = By.xpath("//button[@class = 'vex-dialog-button-secondary vex-dialog-button vex-last' and text() = 'Cancel']");
	By delete_OkBtn = By.xpath("//button[@class = 'vex-dialog-button-primary vex-dialog-button vex-first' and text() = 'OK']");
	By eventDes_firstRecord = By.xpath("//tbody[@aria-live = 'polite']/tr[1]/td[2]");
	By eventDate_firstRecord = By.xpath("//table[@id = 'event-table']/tbody/tr[1]/td[1]");
	By editEntry = By.xpath("//tbody[@aria-live = 'polite']/tr[1]/td[3]/a");
	By edit_popup = By.xpath("//h3[text() = 'Edit portfolio calendar entry']");
	
	
	@Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in CustomerDashboard Page");
        Assert.assertTrue(isElementPresent(addCalendarEntry),"Portfolio Calendar Page didnt appear");
        
    }
	public void verifyPortfolioCalendarEntrypopup(String value) throws InterruptedException{
		PortfolioCalendarPage pc = new PortfolioCalendarPage();
		pc.click(addCalendarEntry);
		Thread.sleep(1000);
        Assert.assertTrue(StringUtils.isNoneBlank(getText(portfolioCalendarEntryPopUp)) &&
                getText(portfolioCalendarEntryPopUp).trim().contains(value),"Portfolio Calendar Entry Popup heading actual value: "+getText(portfolioCalendarEntryPopUp) +" but expected:"+value);
    }
	public void verifyCloseBtnPortfolioCalendarEntrypopup() throws InterruptedException{
		PortfolioCalendarPage pc = new PortfolioCalendarPage();
		pc.click(addCalendarEntry);
		Thread.sleep(1000);
		pc.click(close_PortfolioCalendarEntryPopup);
		Thread.sleep(1000);
		boolean status = driver.findElement(By.xpath("//h3[text() = 'Add new portfolio calendar entry']")).isDisplayed();
		Assert.assertEquals(status, false);
    }
	public void verifyspaceDataPortfolioCaledarEntryPopup(String data) throws InterruptedException
	{
		PortfolioCalendarPage pc = new PortfolioCalendarPage();
		pc.click(addCalendarEntry);
		Thread.sleep(2000);
		pc.click(eventDate);
		pc.selectFutureDateCalender();
		pc.setValue(eventDescription, data);
		pc.click(saveBtn);
	}
	public void validateEventDescriptionPortfolioCaledarEntryPopup(String value) throws InterruptedException
	{
		PortfolioCalendarPage pc = new PortfolioCalendarPage();
		pc.click(addCalendarEntry);
		Thread.sleep(2000);
		pc.click(eventDate);
		pc.selectFutureDateCalender();
		pc.setValue(eventDescription, "");
		pc.click(saveBtn);
		Assert.assertTrue(StringUtils.isNoneBlank(getText(eventDescriptionErrorMessage)) &&
                getText(eventDescriptionErrorMessage).trim().contains(value),"Event Description Error message actual value: "+getText(eventDescriptionErrorMessage) +" but expected:"+value);
	}
	public void validateDeleteEventPopup(String value)
	{
		PortfolioCalendarPage pc = new PortfolioCalendarPage();
		pc.click(deleteEntry);
		Assert.assertTrue(StringUtils.isNoneBlank(getText(delete_popup)) &&
                getText(delete_popup).trim().contains(value),"Delete event popup message: "+getText(delete_popup) +" but expected:"+value);
	}
	public void validateCancelBtnDeleteEventPopup() throws InterruptedException
	{
		PortfolioCalendarPage pc = new PortfolioCalendarPage();
		pc.click(deleteEntry);
		pc.click(delete_CancelBtn);
		Thread.sleep(1000);
		boolean status = pc.isElementPresent(delete_popup);
		System.out.println("Is delete popup displaying: " + status);
		Assert.assertEquals(false, status);		
	}
	public void validateDeleteEvent() throws InterruptedException
	{
		PortfolioCalendarPage pc = new PortfolioCalendarPage();
		String date = pc.getText(eventDate_firstRecord);
		String desc = pc.getText(eventDes_firstRecord);
		pc.click(deleteEntry);
		Reporter.log("clicked 'Delete Entry' button for first row");
		pc.click(delete_OkBtn);
		Reporter.log("clicked Ok button in delete popup");
		Thread.sleep(2000);
		boolean status = desc.equals(pc.getText(eventDes_firstRecord)) && date.equals(pc.getText(eventDate_firstRecord));
		Reporter.log("compared description and date in the first row before delete and after deleting an event");		
		Assert.assertEquals(false, status);
	}
	public void validateEditEventPopup(String value)
	{
		PortfolioCalendarPage pc = new PortfolioCalendarPage();
		pc.click(editEntry);
		Reporter.log("clicked 'Edit Entry' button for first row");
		Assert.assertTrue(StringUtils.isNoneBlank(getText(edit_popup)) &&
                getText(edit_popup).trim().contains(value),"Edit event popup heading: "+getText(edit_popup) +" but expected:"+value);
	}
	public void validateCloseIconEditEventPopup() throws InterruptedException
	{
		PortfolioCalendarPage pc = new PortfolioCalendarPage();
		pc.click(editEntry);
		Reporter.log("clicked 'Edit Entry' button for first row");
		Thread.sleep(1000);
		pc.click(close_PortfolioCalendarEntryPopup);
		Reporter.log("Clicked close icon in edit entry popup");
		Thread.sleep(2000);
		boolean status = pc.isElementPresent(edit_popup);
		System.out.println("Is edit popup displaying: " + status);
		Reporter.log("Checked if edit popup is still displaying");
		Assert.assertEquals(false, status);		
	}
	public void validateEditEventChangingDate() throws InterruptedException
	{
		PortfolioCalendarPage pc = new PortfolioCalendarPage();
		String desc = pc.getText(eventDes_firstRecord);
		Reporter.log("captured description in first record");
		pc.click(editEntry);
		Reporter.log("clicked 'Edit Entry' button for first row");
		Thread.sleep(1000);
		pc.click(eventDate);
		int count = 0;
		while(count<=60) 
		{
			try {
				driver.findElement(By.xpath("//td[@data-month = '2' and @data-year = '2017']/a[text() = '20']")).click();//March 20, 2017
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//a[@data-handler = 'prev']/span[text() = 'Prev']")).click();
				count++;
			}
		}
		Reporter.log("Entered date in date picker");
		pc.click(saveBtn);
		Reporter.log("Clicked save entry button");
		boolean status = pc.getText(eventDate_firstRecord).equals("20/03/2017") && pc.getText(eventDes_firstRecord).equals(desc);
		Reporter.log("compared date and description editing");
		Assert.assertEquals(true, status);
	}
	public void validateEditEventChangingDescription() throws InterruptedException
	{
		PortfolioCalendarPage pc = new PortfolioCalendarPage();
		String date = pc.getText(eventDate_firstRecord);
		pc.click(editEntry);
		Reporter.log("Clicked on edit entry");
		Thread.sleep(1000);
		pc.setValue(eventDescription, "Bank holiday");
		Reporter.log("Entered data in event description");
		pc.click(saveBtn);
		Reporter.log("clicked save button");
		Thread.sleep(1000);
		boolean status = pc.getText(eventDes_firstRecord).equals("Bank holiday") && pc.getText(eventDate).equals(date);
		Reporter.log("Compared data in event date and description after editing");
	}
	/*public void readData() throws Throwable
	{
		FileInputStream fObj = new FileInputStream("./data/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fObj);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(9);
		String data = row.getCell(0).getStringCellValue();
		System.out.println(data);
	}*/
}
