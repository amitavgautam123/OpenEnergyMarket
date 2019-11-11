package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class TenderRequotePage extends AdminDashboardPage {
	
	By quoteDropDown = By.id("ActiveQuote");
	By reopenQuoteBtn = By.id("submit-reopen-quote-button");
	
	By alertMsg = By.xpath("//div[text() = 'Are you sure you want to re-open this quote?']");
	By cancelBtn = By.xpath("//button[text() = 'Cancel']");
	By okBtn = By.xpath("//button[text() = 'OK']");
	
	@Override
    protected void isLoaded()  {
    	System.out.println("Executing isLoaded in Tender Requote page");
    	Assert.assertTrue(isElementPresent(quoteDropDown), "Tender Requote page is not displaying.");
    }
	public TenderRequotePage verifyQuoteDropDownPresence() {
		Assert.assertTrue(isElementPresent(quoteDropDown), "Quote drop down is not displaying.");
		return this;
	}
	public TenderRequotePage selectOptionFromQuoteDropDown() throws Throwable {
		selectByIndex(quoteDropDown, 1);
		Thread.sleep(3000);
		return this;
	}
	public TenderRequotePage clickReopenQuote() throws Throwable {
		click(reopenQuoteBtn);
		Thread.sleep(3000);
		return this;
	}
	public TenderRequotePage verifyAlertMsgPresence() {
		Assert.assertTrue(isElementPresent(alertMsg), "Alert popup is not displaying.");
		return this;
	}
	public TenderRequotePage validateCancelBtnInAlertMsg() throws Throwable {
		click(cancelBtn);
		Thread.sleep(3000);
		Assert.assertFalse(isElementPresent(alertMsg), "Alert popup is not displaying.");
		return this;
	}
	public TenderRequotePage clickOkBtnInAlertMsg() throws Throwable {
		click(okBtn);
		Thread.sleep(3000);
		Assert.assertFalse(isElementPresent(alertMsg), "Alert popup is not displaying.");
		return this;
	}
	
	
}
