package com.oem.framework.pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CompanyProfilePage extends CustomerDashboardPage {

	By saveBtn = By.id("submit");
	By saveSuccessMsg = By.id("global-message-text");
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
    By CompanyLogo = By.id("CompanyLogo");
    By supplierInvoicingTo = By.id("InvoiceHeadOffice");
    By preferredSupplierPayment = By.id("PreferredSupplierPayment");
    By preferredSupplierPaymentError = By.id("PreferredSupplierPayment-error");
    By loaTemplate = By.xpath("//strong[text() = 'Letter of Authority Template']");
    By existingLOA = By.xpath("//strong[text() = 'Download Existing Letter Of Authority']");
    By LOAExpiresDate = By.id("LOAExpiresDate");
    By LOAExpiresDateDatePicker = By.id("ui-datepicker-div");
      
    
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
    	setValue(companyRegisteredAddress, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it.");
        click(saveBtn);
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(registeredAddressError)) &&
                getText(registeredAddressError).trim().contains(value),"Registered address error actual value: "+getText(registeredAddressError) +" but expected:"+value);
    }
    
    public void verifyBlankRegisteredAddressError(String value) {
    	setValue(companyRegisteredAddress, "");
        click(saveBtn);
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(registeredAddressBlankError)) &&
                getText(registeredAddressBlankError).trim().contains(value),"Registered address error actual value: "+getText(registeredAddressBlankError) +" but expected:"+value);
    }
    public void verifyRegisteredAddressErrorSpaceTestData() {
    	setValue(companyRegisteredAddress, "       ");
        click(saveBtn);
        Assert.assertEquals(true, isElementPresent(registeredAddressBlankError));
    }

    public void verifyCompanyNameError(String value) {
    	setValue(companyName, "");
        click(saveBtn);
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(companyNameError)) &&
                getText(companyNameError).trim().contains(value),"Company Name error actual value: "+getText(companyNameError) +" but expected:"+value);
    }
    
    public void verifyBlankPostcodeError(String value) {
    	
    	//setValue(compPostCode, "");
    	setValue(compPostCode, "    ");
        click(saveBtn);
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(postCodeError)) &&
                getText(postCodeError).trim().contains(value),"Postcode error actual value: "+getText(postCodeError) +" but expected:"+value);
    }
    
    public void verifyCompRegistrationNumberError(String value) {
    	setValue(companyRegNum, "");
        click(saveBtn);
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(companyRegNumError)) &&
                getText(companyRegNumError).trim().contains(value),"Company Registration Number error actual value: "+getText(companyRegNumError) +" but expected:"+value);
    }
    
    public void verifyLOATemplateDisplay(String value)
    {
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(loaTemplate)) &&
                getText(loaTemplate).trim().contains(value),"Letter of Authority Template"+getText(loaTemplate) +" but expected:"+value);
    }
    public void verifyExistingLOADisplay(String value)
    {
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(existingLOA)) &&
                getText(existingLOA).trim().contains(value),"Download Existing Letter Of Authority"+getText(existingLOA) +" but expected:"+value);
    }
    public void verifyDatePickerDisplayLOAExpiresDate()
    {   
    	click(LOAExpiresDate);
        isElementPresent(LOAExpiresDateDatePicker);
    	Assert.assertEquals(isElementPresent(LOAExpiresDateDatePicker), true);	
    }
    public void uploadLogo()
    {   
    	setValue(CompanyLogo, "C:\\Users\\sowjanya\\Desktop\\Bank.jpg");
    	click(saveBtn);
    	boolean status = isElementPresent(saveSuccessMsg);
        Assert.assertEquals(true, status);
    }
    public void validateOptionsSupplierInvoiceTo()
    {
    	boolean status = isElementExistInDropDown(supplierInvoicingTo, "Individual Sites") &&
    			isElementExistInDropDown(supplierInvoicingTo, "Head Office");
    	Assert.assertTrue(status, "Dropdown options are not displaying in Supplier Invoice To");
    }
    public void validateOptionsPrefferedSupplierPayment()
    {
    	boolean status = isElementExistInDropDown(preferredSupplierPayment, "Direct Debit") &&
    			isElementExistInDropDown(preferredSupplierPayment, "Chaps") &&
    			isElementExistInDropDown(preferredSupplierPayment, "14 Day BACs") &&
    			isElementExistInDropDown(preferredSupplierPayment, "24 Day BACs") &&
    			isElementExistInDropDown(preferredSupplierPayment, "30 Day BACs");
    	Assert.assertTrue(status, "Dropdown options are not displaying in Preferred Supplier Payment");
    }
    public void validateMandatoryPrefferedSupplierPayment()
    {	
    	selectByVisibleText(preferredSupplierPayment,"Please select");
    	click(saveBtn);
    	Assert.assertTrue(getText(preferredSupplierPaymentError).equals("Preferred supplier payment field is required"), 
    			"Error message for Preferred Supplier Payment is not displaying");
    }
    public void validateProfileDiffDataSets(String compName, String addr, String postCode, String ph, String regdNo) throws InterruptedException
    {
    	setValue(companyName, compName);
        setValue(companyRegisteredAddress, addr);
        setValue(compPostCode, postCode);
        setValue(phone, ph);
        setValue(companyRegNum, regdNo);
        click(saveBtn);
        Thread.sleep(2000);
        Assert.assertTrue(isElementPresent(saveSuccessMsg), "Save success message didn�t appear after saving profile data.");   	
    }
    
    
    
    public enum CompanyProfileFields
    {
        NAME, RegisteredAddress,PostCode,Phone,RegistrationNumber,
    }
}
