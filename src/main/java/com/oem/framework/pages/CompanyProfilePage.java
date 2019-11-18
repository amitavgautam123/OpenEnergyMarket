package com.oem.framework.pages;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class CompanyProfilePage extends CustomerDashboardPage {

	By saveBtn = By.id("submit");
	By saveSuccessMsg = By.id("global-message-text");
	By okBtn = By.xpath("//a[text() = 'Ok']");
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
    By serverError = By.xpath("//*[contains(text(), 'Server Error')]");
    
    public CompanyProfilePage fillCompanyProfile(){
        setValue(companyName,"abc");
        setValue(companyRegisteredAddress,"Bangalore"); 
        return this;
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
    
    public CompanyProfilePage verifyRegisteredAddressInputs() throws Throwable	{
    	setValue(companyRegisteredAddress, readExcelData("Sheet3", 2, 3));
    	Reporter.log("Entered value in registered address field", true);
    	String valueAttributevalue = getAttribute(companyRegisteredAddress, "value");
    	Reporter.log("Stored the value of value attribute in a string variable", true);
        boolean inputDisplayStatus = valueAttributevalue.contains(readExcelData("Sheet3", 2, 3));
        Reporter.log("Compared if the entered data is equal to the value of value attribute", true);
        Assert.assertTrue(inputDisplayStatus, "Registered address is not displaying the value we entered in the field");
        return this;
    }
    
    public CompanyProfilePage verifyRegisteredAddressExceedingMaxLengthError(String value){
    	setValue(companyRegisteredAddress, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it.");
        click(saveBtn);
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(registeredAddressError)) &&
                getText(registeredAddressError).trim().contains(value),"Registered address error actual value: "+getText(registeredAddressError) +" but expected:"+value);
    	return this;
    }
    
    public CompanyProfilePage verifyBlankRegisteredAddressError(String value) throws Throwable {
    	setValue(companyRegisteredAddress, "");
        click(saveBtn);
        Thread.sleep(2000);
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(registeredAddressBlankError)) &&
                getText(registeredAddressBlankError).trim().contains(value),"Registered address error actual value: "+getText(registeredAddressBlankError) +" but expected:"+value);
    	return this;
    }
    public CompanyProfilePage verifyRegisteredAddressErrorSpaceTestData() throws Throwable {
    	SoftAssert softAssertion = new SoftAssert();
    	setValue(companyRegisteredAddress, "       ");
        click(saveBtn);
        boolean serverErrorDisplayStatus = isElementPresent(serverError, 10);
        if(serverErrorDisplayStatus) {
        	driver.navigate().back();
        	softAssertion.assertFalse(false, "Server Error is displaying.");
        }
        Thread.sleep(4000);
        if(isElementPresent(okBtn)) {
        	click(okBtn);
        }
        softAssertion.assertAll(); 
        return this;
    }

    public CompanyProfilePage verifyCompanyNameError(String value) throws Throwable {
    	clearValue(companyName);
        click(saveBtn);
        Thread.sleep(3000);
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(companyNameError)) &&
                getText(companyNameError).trim().contains(value),"Company Name error actual value: "+getText(companyNameError) +" but expected:"+value);
    	return this;
    }
    
    public CompanyProfilePage validateCompanyNameAlphabeticAcceptance() {
    	setValue(companyName, "Apple");
    	String attrValue = getAttribute(companyName, "value");
    	boolean displayStatus = attrValue.equals("Apple");
    	Reporter.log("Checked if the value attribute is displaying the same as entered in the 'Company Name' textbox", true);
    	Assert.assertTrue(displayStatus, "Company Name field is not accepting alphabetic characters");
    	return this;
    }
    
    public CompanyProfilePage verifyBlankPostcodeError(String value) { 
    	clearValue(compPostCode);
    	//setValue(compPostCode, "");
        click(saveBtn);
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(postCodeError)) &&
                getText(postCodeError).trim().contains(value),"Postcode error actual value: "+getText(postCodeError) +" but expected:"+value);
    	return this;
    }
    public CompanyProfilePage verifyPostcodeWithSpaceTestData() throws Throwable {
    	SoftAssert softAssertion = new SoftAssert();
    	setValue(compPostCode, "    ");
    	Thread.sleep(2000);
    	click(saveBtn);
        boolean serverErrorDisplayStatus = isElementPresent(serverError, 10);
        if(serverErrorDisplayStatus) {
        	driver.navigate().back();
        	softAssertion.assertFalse(false, "Server Error is displaying.");
        }
        Thread.sleep(4000);
        if(isElementPresent(okBtn)) {
        	click(okBtn);
        }
        softAssertion.assertAll();
    	return this;
    }
    
    public CompanyProfilePage validatePostcodeSpecialSymbolTest() throws Throwable {
    	setValue(compPostCode, "%<>#");
        click(saveBtn);
        
        String errorStatus = getAttribute(compPostCode, "aria-invalid");
    	if(errorStatus == null) {
    		errorStatus = "false";
    	}
    	Reporter.log("Strored the value of the aria-invalid attribute in a string variable", true);
    	boolean postCodeErrorMsgDisplayStatus = errorStatus.equals("true");
    	Reporter.log("Checked if error message for postcode field is displaying", true);
        
        Thread.sleep(3000);
        boolean saveStatus  = isElementPresent(okBtn);
        if(isElementPresent(okBtn)) {
        	click(okBtn);
        }
        Assert.assertTrue(saveStatus, "Invalid postcode error is not displaying.");
        return this;
    }
    
    public CompanyProfilePage validatePostcodeNumericDataTest() throws Throwable {
    	setValue(compPostCode, readExcelData("Sheet3", 2, 4));
    	String postcodeValueAtrributeValue = getAttribute(compPostCode, "value");
    	boolean numericValueAcceptanceStatus = postcodeValueAtrributeValue.equals(readExcelData("Sheet3", 2, 4));
    	Reporter.log("Checked if the numeric data entered in postcode field is displaying", true);
    	Assert.assertTrue(numericValueAcceptanceStatus, "Numeric value is not geting accepted in postcodefield.");
    	return this;
    }
    
    public CompanyProfilePage validateIfPhoneFieldMandatory() throws Throwable {
    	clearValue(phone);
    	Reporter.log("Entered blank data in phone field", true);
    	click(saveBtn);
    	Reporter.log("Clicked save button", true);
    	String errorStatus = getAttribute(phone, "aria-invalid");
    	if(errorStatus == null) {
    		errorStatus = "false";
    	}
    	Reporter.log("Strored the value of the aria-invalid attribute in a string variable", true);
    	boolean phoneErrorMsgDisplayStatus = errorStatus.equals("true");
    	Reporter.log("Checked if error message for phone field is displaying", true);
    	Thread.sleep(3000);
    	if(isElementPresent(okBtn)) {
        	click(okBtn);
        }
    	Assert.assertFalse(phoneErrorMsgDisplayStatus, "Error message for phone field is displaying even if it is not mandatory");
    	return this;
    }
    
    public CompanyProfilePage validatePhoneFieldAlphabeticTestData() throws Throwable {
    	setValue(phone, "Lorem Ipsum");
    	Reporter.log("Entered alphabetic data in phone field", true);
    	click(saveBtn);
    	String errorStatus = getAttribute(phone, "aria-invalid");
    	if(errorStatus == null) {
    		errorStatus = "false";
    	}
    	boolean phoneErrorMsgDisplayStatus = errorStatus.equals("true");
    	Reporter.log("Checked if error message for phone field is displaying", true);
    	Thread.sleep(2000);
    	boolean saveStatus = isElementPresent(okBtn);
    	if(isElementPresent(okBtn)) {
        	click(okBtn);
        }
    	Assert.assertTrue(saveStatus, "Company profile didn't get saved.");
    	return this;
    }
    
    public CompanyProfilePage validatePhoneFieldNumericTestData() throws Throwable {
    	setValue(phone, readExcelData("Sheet3", 2, 5));
    	Reporter.log("Entered alphabetic data in phone field", true);
    	String enteredValue = getAttribute(phone, "value");
    	boolean enteredValueDisplaystatus = enteredValue.equals(readExcelData("Sheet3", 2, 5));
    	Reporter.log("Checked if the value entered is displaying in 'phone' field", true);
    	Assert.assertTrue(enteredValueDisplaystatus, "The entered value is not displaying in phone field");
    	return this;
    }
    
    public CompanyProfilePage verifyCompRegistrationNumberError(String value) throws Throwable {
    	clearValue(companyRegNum);
        click(saveBtn);
        Thread.sleep(1000);
        Assert.assertTrue(StringUtils.isNoneBlank(getText(companyRegNumError)) &&
                getText(companyRegNumError).trim().contains(value),"Company Registration Number error actual value: "+getText(companyRegNumError) +" but expected:"+value);
    	return this;
    }
    
    public CompanyProfilePage verifyLOATemplateDisplay(String value)
    {
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(loaTemplate)) &&
                getText(loaTemplate).trim().contains(value),"Letter of Authority Template"+getText(loaTemplate) +" but expected:"+value);
    	return this;
    }
    public CompanyProfilePage verifyExistingLOADisplay(String value)
    {
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(existingLOA)) &&
                getText(existingLOA).trim().contains(value),"Download Existing Letter Of Authority"+getText(existingLOA) +" but expected:"+value);
    	return this;
    }
    public CompanyProfilePage verifyDatePickerDisplayLOAExpiresDate() throws Throwable
    {   
    	click(LOAExpiresDate);
    	Thread.sleep(1000);
        isElementPresent(LOAExpiresDateDatePicker);
    	Assert.assertEquals(isElementPresent(LOAExpiresDateDatePicker), true);	
    	return this;
    }
    public CompanyProfilePage validateLOAExpiresDateSelectFutureDateTest() throws Throwable {
    	click(LOAExpiresDate);
    	Thread.sleep(1000);
		selectFutureDateCalender(27, 10, 2020);
		boolean dateSelectionStatus = getAttribute(LOAExpiresDate, "value").contains("27/11/2020");
		Assert.assertTrue(dateSelectionStatus, "Unable to select future date.");
		return this;
    }
    public CompanyProfilePage validateLOAPreviousDateSelectPreviousDateTest() throws Throwable { 	
    	setValue(LOAExpiresDate, "12/6/2018");
    	//Thread.sleep(1000);
    	//selectPrevDateCalender(12, 5, 2018);
		boolean dateSelectionStatus = getAttribute(LOAExpiresDate, "value").contains("12/6/2018");
		//System.out.println("Value attr = " + getAttribute(LOAExpiresDate, "value"));
		Assert.assertTrue(dateSelectionStatus, "Unable to select previous date.");
		return this;
    }
    public CompanyProfilePage uploadLogo()
    {   
    	setValue(CompanyLogo, "C:\\Users\\sowjanya\\Desktop\\Bank.jpg");
    	click(saveBtn);
    	boolean status = isElementPresent(saveSuccessMsg);
        Assert.assertEquals(true, status);
        return this;
    }
    public CompanyProfilePage validateOptionsSupplierInvoiceTo()
    {
    	boolean status = isElementExistInDropDown(supplierInvoicingTo, "Individual Sites") &&
    			isElementExistInDropDown(supplierInvoicingTo, "Head Office");
    	Assert.assertTrue(status, "Dropdown options are not displaying in Supplier Invoice To");
    	return this;
    }
    public CompanyProfilePage validateOptionsPrefferedSupplierPayment()
    {
    	boolean status = isElementExistInDropDown(preferredSupplierPayment, "Direct Debit") &&
    			isElementExistInDropDown(preferredSupplierPayment, "Chaps") &&
    			isElementExistInDropDown(preferredSupplierPayment, "14 Day BACs") &&
    			isElementExistInDropDown(preferredSupplierPayment, "24 Day BACs") &&
    			isElementExistInDropDown(preferredSupplierPayment, "30 Day BACs");
    	Assert.assertTrue(status, "Dropdown options are not displaying in Preferred Supplier Payment");
    	return this;
    }
    public CompanyProfilePage validateMandatoryPrefferedSupplierPayment() throws Throwable
    {	
    	selectByVisibleText(preferredSupplierPayment,"Please select");
    	click(saveBtn);
    	Thread.sleep(1000);
    	Assert.assertTrue(getText(preferredSupplierPaymentError).equals("Preferred supplier payment field is required"), 
    			"Error message for Preferred Supplier Payment is not displaying");
    	return this;
    }
    public CompanyProfilePage validateProfileDiffDataSets(String compName, String addr, String postCode, String ph, String regdNo) throws InterruptedException
    {
    	SoftAssert softAssertion = new SoftAssert();
    	setValue(companyName, compName);
    	softAssertion.assertTrue(getAttribute(companyName, "value").equals(compName), 
        		"The entered data is not displaying correctly in 'Company Name' field");
        Reporter.log("Checked if the entered is displaying correctly in 'Company Name' field", true);
        setValue(companyRegisteredAddress, addr);
        softAssertion.assertTrue(getAttribute(companyRegisteredAddress, "value").equals(addr), 
        		"The entered data is not displaying correctly in 'Company Registered Address' field");
        Reporter.log("Checked if the entered is displaying correctly in 'Company Registered Address' field", true);
        setValue(compPostCode, postCode);
        softAssertion.assertTrue(getAttribute(compPostCode, "value").equals(postCode), 
        		"The entered data is not displaying correctly in 'Postcode' field");
        Reporter.log("Checked if the entered is displaying correctly in 'Postcode' field", true);
        setValue(phone, ph);
        softAssertion.assertTrue(getAttribute(phone, "value").equals(ph), 
        		"The entered data is not displaying correctly in 'Phone' field");
        Reporter.log("Checked if the entered is displaying correctly in 'Phone' field", true);
        setValue(companyRegNum, regdNo);
        softAssertion.assertTrue(getAttribute(companyRegNum, "value").equals(regdNo), 
        		"The entered data is not displaying correctly in 'Company Registration Number' field");
        Reporter.log("Checked if the entered is displaying correctly in 'Company Registration Number' field", true);
        click(saveBtn);
        Reporter.log("Clicked on save button", true);
        Thread.sleep(2000);
        if(isElementPresent(serverError, 10)) {
        	driver.navigate().back();
        	softAssertion.assertFalse(false, "Server Error is displaying.");
        }
        softAssertion.assertTrue(isElementPresent(saveSuccessMsg), "Save success message didn�t appear after saving profile data.");
        Reporter.log("Checked if the save success popup is displaying", true);
        Thread.sleep(2000);
        if(isElementPresent(okBtn)) {
        	click(okBtn);
        }
        softAssertion.assertAll();
        return this;
    }
    public void fillCompanyProfileGeneric() throws Throwable {
		String compName = readExcelData("Sheet4", 1, 1);
		setValue(companyName, compName);
		Thread.sleep(1000);
    	setValue(companyRegisteredAddress, "Bangalore");
    	Thread.sleep(1000);
        setValue(compPostCode, "2983472");
        Thread.sleep(1000);
        setValue(phone, "8923472834");
        Thread.sleep(1000);
        setValue(companyRegNum, "8173812323");
        Thread.sleep(1000);
        click(saveBtn);
        Thread.sleep(4000);
        click(okBtn);
        Thread.sleep(2000);
	}
    public void fillCompanyProfile_Flexible() throws Throwable {
		String compName = readExcelData("Sheet5",3,1);
		setValue(companyName, compName);
		Thread.sleep(1000);
    	setValue(companyRegisteredAddress, "Bangalore");
    	Thread.sleep(1000);
        setValue(compPostCode, "2983472");
        Thread.sleep(1000);
        setValue(phone, "8923472834");
        Thread.sleep(1000);
        setValue(companyRegNum, "8173812323");
        Thread.sleep(1000);
        click(saveBtn);
        Thread.sleep(3000);
        click(okBtn);
        Thread.sleep(2000);
	}
    
    
    public enum CompanyProfileFields
    {
        NAME, RegisteredAddress,PostCode,Phone,RegistrationNumber,
    }
}
