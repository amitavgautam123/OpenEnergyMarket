package com.oem.framework.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class CompanyProfilePage extends CustomerDashboardPage {

	By saveBtn = By.id("submit");
    By companyName=By.id("Name");
    By companyRegisteredAddress=By.id("RegisteredAddress");
    By compPostCode=By.id("Postcode");
    By companyNameError = By.id("Name-error");
    By registeredAddressError=By.id("RegisteredAddress-error");
    By registeredAddressBlankError = By.id("RegisteredAddress-error");
    By postCodeError = By.id("Postcode-error");
    By phone = By.id("ContactPhone");
    By companyRegNum = By.id("CompanyRegistrationNumber");
    By companyRegNumError = By.id("CompanyRegistrationNumber-error");
    
    public void fillCompanyProfile(){
        setValue(companyName,"abc");
        setValue(companyRegisteredAddress,"Bangalore");
        
    }


    @Override
    protected void isLoaded() throws Error {
        System.out.println("Executing isLoaded in CustomerDashboard Page");
        Assert.assertTrue(isElementPresent(companyRegisteredAddress),"Company profile Page didnt appear");
        

    }

    public void setFieldValue(CompanyProfileFields field,String value){
           switch (field){
               case NAME:
                    setValue(companyName,value);
                    sendSpecialKeys(companyName,Keys.TAB);
                   break;
               case RegisteredAddress:
                   setValue(companyRegisteredAddress,value);
                   sendSpecialKeys(companyName,Keys.TAB);
                   break;
               case PostCode:
                   setValue(compPostCode,value);
                   break;
               case RegistrationNumber:
                   setValue(companyRegNum,value);
                   sendSpecialKeys(companyName,Keys.TAB);
                   break;
           }

    }

    public void verifyRegisteredAddressError(String value){

        Assert.assertTrue(StringUtils.isNoneBlank(getText(registeredAddressError)) &&
                getText(registeredAddressError).trim().contains(value),"Registered address error actual value: "+getText(registeredAddressError) +" but expected:"+value);
    }
    
    public void verifyBlankRegisteredAddressError(String value) {
    	
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(registeredAddressBlankError)) &&
                getText(registeredAddressBlankError).trim().contains(value),"Registered address error actual value: "+getText(registeredAddressBlankError) +" but expected:"+value);
    }

    public void verifyCompanyNameError(String value) {
    	
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(companyNameError)) &&
                getText(companyNameError).trim().contains(value),"Company Name error actual value: "+getText(companyNameError) +" but expected:"+value);
    }
    
    public void verifyBlankPostcodeError(String value) {
    	
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(postCodeError)) &&
                getText(postCodeError).trim().contains(value),"Postcode error actual value: "+getText(postCodeError) +" but expected:"+value);
    }
    
    public void verifyCompRegistrationNumberError(String value) {
    	
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(companyRegNumError)) &&
                getText(companyRegNumError).trim().contains(value),"Company Registration Number error actual value: "+getText(companyRegNumError) +" but expected:"+value);
    }
    
    
    

    public enum CompanyProfileFields
    {
        NAME, RegisteredAddress,PostCode,Phone,RegistrationNumber,
    }
}