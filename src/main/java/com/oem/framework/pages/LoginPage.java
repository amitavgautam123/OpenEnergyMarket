package com.oem.framework.pages;

import com.oem.framework.core.base.BasePage;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;


public class LoginPage extends BasePage {

    By username=By.id("Email");
    By pwd=By.id("Password");
    By signInBtn=By.xpath("//input[@value='Sign in']");

   /* static {
        threadLocalPage.set(new LoginPage());
    }*/

   /* public static LoginPage getInstance(){
        return (LoginPage) threadLocalPage.get();
    }*/

    public BasePage loginUsing(String userName, String password){
        driver.get("https://portal.oem-testing.com/Account/Login");
        setValue(username,userName);
        setValue(pwd,password);
        click(signInBtn);


        if(isAdminDashboardPage())
            return new AdminDashboardPage();

        if(isCustomerDashboardPage())
            return new CustomerDashboardPage();

        //Failed login
        return this;
    }
    
    public BasePage login() throws Throwable  {
    	String URL = getPropertyFileData("url");
    	String EMAIL = getPropertyFileData("email");
    	String PASSWORD = getPropertyFileData("password");
    	//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.get(URL);
        setValue(username, EMAIL);
        setValue(pwd, PASSWORD);
        click(signInBtn);


        if(isAdminDashboardPage())
            return new AdminDashboardPage();

        if(isCustomerDashboardPage())
            return new CustomerDashboardPage();

        //Failed login
        return this;
    }


    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(isSignInPage(),"Login page didnt appear");
    }


}
