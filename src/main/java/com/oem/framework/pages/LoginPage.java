package com.oem.framework.pages;

import com.oem.framework.core.base.BasePage;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
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
    
    public CustomerDashboardPage login() throws Exception  {
    	String URL = getPropertyFileData("url");
    	String EMAIL = getPropertyFileData("email");
    	String PASSWORD = getPropertyFileData("password");
        loginUsing(URL,EMAIL,PASSWORD);

        if(isCustomerDashboardPage())
            return new CustomerDashboardPage();
        else
        	throw new IOException("After login didn't show Customer Dashboard page");
    }
    public CustomerDashboardPage loginForFlex() throws Exception  {
    	String URL = getPropertyFileData("url");
    	String EMAIL = getPropertyFileData("emailForFlex");
    	String PASSWORD = getPropertyFileData("passwordForFlex");
        loginUsing(URL,EMAIL,PASSWORD);

        if(isCustomerDashboardPage())
            return new CustomerDashboardPage();
        else
        	throw new IOException("After login didn't show Customer Dashboard page");
    }


    public AdminDashboardPage loginAsAdmin() throws Exception  {
    	String URL = getPropertyFileData("url");
    	String EMAIL = getPropertyFileData("adminEmail");
    	String PASSWORD = getPropertyFileData("adminPassword");
    	loginUsing(URL,EMAIL,PASSWORD);


        if(isAdminDashboardPage())
            return new AdminDashboardPage();
        else
            throw new IOException("After login didn't show Admin Dashboard page");
    }

    private void loginUsing(String url, String uname, String password){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get(url);
        setValue(username, uname);
        setValue(pwd, password);
        click(signInBtn);
    }


    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(isSignInPage(),"Login page didnt appear");
    }


}
