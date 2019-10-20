package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.oem.framework.core.base.BasePage;

public class FlexProfileManagerPage extends CustomerDashboardPage {
	
	By flexProfileMgr = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[1]/a");
    By strategyProfile = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[2]/a");
    By riskProfile = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[3]/a");
    By flexReporting = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[4]/a");
    By tradeReporting = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[5]/a");
	
	By hhUtilityLink = By.id("hhUtility");
	By nhhUtilityLink = By.id("nhhUtility");
	
	@Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in Flexible Profile Manager Page");
        Assert.assertTrue(isElementPresent(hhUtilityLink),"Flexible Profile Manager Page didnt appear");    
    }
	
	public void verifySubModulesPresenceInFlexmanagement() {
		SoftAssert softAssertion = new SoftAssert();
		boolean flexProfileMgrPresenceStatus = isElementPresent(flexProfileMgr);
		softAssertion.assertTrue(flexProfileMgrPresenceStatus, "Flexible Profile Manager is not displaying.");
		Reporter.log("Checked if flexible profile manager is displaying.", true);
		boolean strategyProfilePresenceStatus = isElementPresent(strategyProfile);
		softAssertion.assertTrue(strategyProfilePresenceStatus, "Strategy Profile is not displaying.");
		Reporter.log("Checked if strategy Profile is displaying.", true);
		boolean riskProfilePresenceStatus = isElementPresent(riskProfile);
		softAssertion.assertTrue(riskProfilePresenceStatus, "Risk Profile is not displaying.");
		Reporter.log("Checked if Risk Profile is displaying.", true);
		boolean flexReportingPresenceStatus = isElementPresent(flexReporting);
		softAssertion.assertTrue(flexReportingPresenceStatus, "Flex Reporting is not displaying.");
		Reporter.log("Checked if Flex Reporting is displaying.", true);
		boolean tradeReportingPresenceStatus = isElementPresent(tradeReporting);
		softAssertion.assertTrue(tradeReportingPresenceStatus, "Trade Reporting is not displaying.");
		Reporter.log("Checked if Trade Reporting is displaying.", true);
	}
	
}
