package com.oem.framework.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class VerifyTendersPage extends AdminDashboardPage	{

	By allowSelectedBtn = By.xpath("//input[@value = 'Allow Selected']");
	By blockSelectedBtn = By.xpath("//input[@value = 'Block Selected']");
	
	
	
	@Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in Verify Tenders Page");
        Assert.assertTrue(isElementPresent(allowSelectedBtn),"Admin Dashboard Page didn't appear.");    
    }
	
}
