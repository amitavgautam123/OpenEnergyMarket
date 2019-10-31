package com.oem.framework.pages;

import com.oem.framework.core.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HeaderPage extends BasePage {

    By logouLink=By.linkText("Log out");




    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(isElementPresent(logouLink,2),"Login was not succesful and logout option didn't appear");
    }

    public boolean isLoggedIn(){
        return isElementPresent(logouLink,2);
    }
    public void logout(){
    	Actions action = new Actions(driver);
		WebElement accountSettingsBtn = driver
				.findElement(By.xpath("//li[@id = 'help-icon']/preceding-sibling::li[1]"));
		WebElement logoutBtn = driver.findElement(By.xpath("//a[text() = 'Log out']"));
		action.moveToElement(accountSettingsBtn).moveToElement(logoutBtn).click().build().perform();
    }
}
