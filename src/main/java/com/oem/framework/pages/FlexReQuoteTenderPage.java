package com.oem.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class FlexReQuoteTenderPage extends AdminDashboardPage{
	By reOpenButton=By.id("submit-reopen-quote-button");
	By quoteDropDown=By.id("SelectedQuote");
	By quoteDropDown_Options=By.xpath("//select[@id='SelectedQuote']/option");
	By okAlert=By.xpath("//button[text()='OK']");
	SoftAssert softassert=new SoftAssert();
	
	@Override
	protected void isLoaded() throws Error {
		System.out.println("Executing isLoaded in FlexReQuoteTender Page");
		Assert.assertTrue(isElementPresent(reOpenButton), "FlexReQuoteTender Page didnt appear");
	}
	
	public void verifyFlxReQtTenderHomePage(){
		Assert.assertTrue(isElementPresent(quoteDropDown), "DropDown Is Not Present At HomePage");
	}
	public void verifyAlertMessageAfterClickingReOpenQoute() throws Throwable{
		click(reOpenButton);
		Thread.sleep(2000);
		softassert.assertTrue(isElementPresent(okAlert), "Ok Alert Is Not Present After Clicking ReOpenButton");
		click(okAlert);
		softassert.assertAll();
	}
	public void verifyPopAfterSelectingElementAndClickReOpen(String utility) throws Throwable{
		driver.navigate().refresh();
		//String textToBeOpened=readExcelData("Sheet5",3,1);
		//selecting  based on Company Name and Utility
		selectByPartOfVisibleText(quoteDropDown_Options,readExcelData("Sheet5",3,1),utility);
		Select select = new Select(driver.findElement(quoteDropDown));
		WebElement option = select.getFirstSelectedOption();
		String selectedOption = option.getText();
		setExcelData("Sheet8",0,2,selectedOption);
		Thread.sleep(2000);
		click(reOpenButton);
		Thread.sleep(2000);
		softassert.assertTrue(isElementPresent(okAlert), "Ok Alert Is Not Present After selecting Element From DropDown and Clicking ReOpenButton");
		click(okAlert);
	}
	
	public void verifyQuoteIsNotPresentAfterAccepting() throws Exception{
		
		boolean Elementfound = false;
		Select select = new Select(driver.findElement(quoteDropDown));
		List<WebElement> allOptions = select.getOptions();
		for(int i=0; i<allOptions.size(); i++) {
		    if(allOptions.equals(readExcelData("Sheet8",0,2))) {
		    	Elementfound=true;
		        break;
		    }
		}
		
		softassert.assertFalse(Elementfound, "Element is Still Present in dropdown even after Accepting ");
		softassert.assertAll();
	}
	
	/*WebElement Select = driver.findElement(quoteDropDown);
	boolean found = false;
	List<WebElement> allOptions = Select.getOptions();
	for(int i=0; i<allOptions.size(); i++) {
	    if(alloptions[i].Equals("your_option_text")) {
	        found=true;
	        break;
	    }
	}
	if(found) {
	    System.out.println("Value exists");
	}
	public void isQuotePresent(){
		
	}
	
	selectByPartOfVisibleText(quoteDropDown,)*/
}
