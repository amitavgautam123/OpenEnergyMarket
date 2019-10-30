package com.oem.framework.pages;

import com.oem.framework.core.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HeaderPage extends BasePage {

    By logouLink=By.linkText("Log out");
    By avatar=By.id("avatar");



    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(isElementPresent(logouLink,2),"Login was not succesful and logout option didn't appear");
    }

    public boolean isLoggedIn(){
        if(isElementPresent(avatar,5))
            mouseOver(avatar);
        return isElementPresent(logouLink,1);
    }
    public void logout(){
        mouseOver(avatar);
        click(logouLink);
    }
}
