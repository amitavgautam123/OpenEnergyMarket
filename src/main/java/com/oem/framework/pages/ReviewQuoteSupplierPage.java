package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ReviewQuoteSupplierPage extends HeaderPage {
	By currentContractTitle = By.xpath("//h3[text() = 'Current Contract ']");
	By proposedQuotesTitle = By.xpath("//h3[text() = 'Proposed Quotes']");
	By hhUtilityFilter_ReviewQuotes = By.xpath("//td[contains(text(), 'Please select a Utility')]/following-sibling::td/div[1]");
	By nhhUtilityFilter_ReviewQuotes = By.xpath("//td[contains(text(), 'Please select a Utility')]/following-sibling::td/div[2]");
	By gasUtilityFilter_ReviewQuotes = By.xpath("//td[contains(text(), 'Please select a Utility')]/following-sibling::td/div[3]");
	By waterUtilityFilter_ReviewQuotes = By.xpath("//td[contains(text(), 'Please select a Utility')]/following-sibling::td/div[4]");		
	
	@Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in Customer Review Quote Page");
        Assert.assertTrue(isElementPresent(currentContractTitle),"Property Portfolio Page didnt appear");        
    }
}
