package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ReviewQuoteCustomerPage extends HeaderPage{

	By currentContractTitle = By.xpath("//h3[text() = 'Current Contract ']");
	By proposedQuotesTitle = By.xpath("//h3[text() = 'Proposed Quotes']");
	By hhUtilityFilter_ReviewQuotes = By.xpath("//td[contains(text(), 'Please select a Utility')]/following-sibling::td/div[1]");
	By nhhUtilityFilter_ReviewQuotes = By.xpath("//td[contains(text(), 'Please select a Utility')]/following-sibling::td/div[2]");
	By gasUtilityFilter_ReviewQuotes = By.xpath("//td[contains(text(), 'Please select a Utility')]/following-sibling::td/div[3]");
	By waterUtilityFilter_ReviewQuotes = By.xpath("//td[contains(text(), 'Please select a Utility')]/following-sibling::td/div[4]");		
	
	By currentContract = By.xpath("//h3[text() = 'Current Contract ']/following-sibling::div/div/div/table/tbody/tr/td[contains(text(), 'Current Contract')]");
	By expiredBtn = By.xpath("//h3[text() = 'Proposed Quotes']/following-sibling::div/div/table/tbody/tr/td/button[text()='Expired']");
	
	@Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in Customer Review Quote Page");
        Assert.assertTrue(isElementPresent(currentContractTitle),"Property Portfolio Page didnt appear");        
    }
	public ReviewQuoteCustomerPage verifyFilterUtilityPresence(){
		SoftAssert softAssertion = new SoftAssert();
		boolean hhUtilityDisplayStatus = isElementPresent(hhUtilityFilter_ReviewQuotes);
		softAssertion.assertTrue(hhUtilityDisplayStatus, "HH Utility filter is not displaying.");
		boolean nhhUtilityDisplayStatus = isElementPresent(nhhUtilityFilter_ReviewQuotes);
		softAssertion.assertTrue(nhhUtilityDisplayStatus, "NHH Utility filter is not displaying.");
		boolean gasUtilityDisplayStatus = isElementPresent(gasUtilityFilter_ReviewQuotes);
		softAssertion.assertTrue(gasUtilityDisplayStatus, "Gas Utility filter is not displaying.");
		boolean waterUtilityDisplayStatus = isElementPresent(waterUtilityFilter_ReviewQuotes);
		softAssertion.assertTrue(waterUtilityDisplayStatus, "Water Utility filter is not displaying.");
		softAssertion.assertAll();
        return this;
    }
	public ReviewQuoteCustomerPage verifyCurrentContractAndProposedQuotePresence(){
		SoftAssert softAssertion = new SoftAssert();
		boolean currentContractDisplayStatus = isElementPresent(currentContractTitle);
		softAssertion.assertTrue(currentContractDisplayStatus, "Current contract is not displaying.");
		boolean proposedQuotesDisplayStatus = isElementPresent(proposedQuotesTitle);
		softAssertion.assertTrue(proposedQuotesDisplayStatus, "Proposed Quote is not displaying.");		
		softAssertion.assertAll();
		return this;
    }
	public ReviewQuoteCustomerPage verifyReviewQuotes() {
		SoftAssert softAssertion = new SoftAssert();
		verifyFilterUtilityPresence();
		verifyCurrentContractAndProposedQuotePresence();
		boolean currentContractDisplayStatus = isElementPresent(currentContract);
		boolean expiredQuoteDisplayStatus = isElementPresent(currentContract);
	return this;
	}
}
