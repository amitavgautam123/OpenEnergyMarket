package com.oem.framework.pages;

import com.oem.framework.core.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AdminDashboardPage extends BasePage {

    By impersonateUsername=By.id("ImpersonateUserName");
    By impersonateBtn=By.id("impersonateBtn");



    public CustomerDashboardPage impersonate(String email){
        setValue(impersonateUsername,email);
        click(impersonateBtn);
        return new CustomerDashboardPage();
    }



    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(isElementPresent(impersonateUsername),"Admin Dashboard page didnt appear");

    }
}
