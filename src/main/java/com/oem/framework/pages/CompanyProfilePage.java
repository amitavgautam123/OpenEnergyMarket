package com.oem.framework.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

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
    
    public void verifyRegisteredAddressInputs()	{
    	setValue(companyRegisteredAddress, "Domlur");
    	Reporter.log("Entered value in registered address field", true);
    	String valueAttributevalue = getAttribute(companyRegisteredAddress, "value");
    	Reporter.log("Stored the value of value attribute in a string variable", true);
        boolean inputDisplayStatus = valueAttributevalue.contains("Domlur");
        Reporter.log("Compared if the entered data is equal to the value of value attribute", true);
        Assert.assertTrue(inputDisplayStatus, "Registered address is not displaying the value we entered in the field");
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
        boolean regdAddrErrorDisplayStatus = isElementPresent(registeredAddressBlankError);
        Assert.assertTrue(regdAddrErrorDisplayStatus, "Registered address is not displaying any error after entering 'space' as test data.");
    }

    public void verifyCompanyNameError(String value) {
    	setValue(companyName, "");
        click(saveBtn);
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(companyNameError)) &&
                getText(companyNameError).trim().contains(value),"Company Name error actual value: "+getText(companyNameError) +" but expected:"+value);
    }
    
    public void validateCompanyNameAlphabeticAcceptance() {
    	setValue(companyName, "Apple");
    	String attrValue = getAttribute(companyName, "value");
    	boolean displayStatus = attrValue.equals("Apple");
    	Reporter.log("Checked if the value attribute is displaying the same as entered in the 'Company Name' textbox", true);
    	Assert.assertTrue(displayStatus, "Company Name field is not accepting alphabetic characters");
    }
    
    public void verifyBlankPostcodeError(String value) { 
    	
    	setValue(compPostCode, "");
        click(saveBtn);
    	Assert.assertTrue(StringUtils.isNoneBlank(getText(postCodeError)) &&
                getText(postCodeError).trim().contains(value),"Postcode error actual value: "+getText(postCodeError) +" but expected:"+value);
    }
    public void verifyPostcodeWithSpaceTestData() {
    	
    	setValue(compPostCode, "    ");
        click(saveBtn);
        boolean postCodeErrorDisplayStatus = isElementPresent(postCodeError);
    	Assert.assertTrue(postCodeErrorDisplayStatus, "Error message for postcode field is not displaying on entering space test data");
    }
    
    public void validatePostcodeSpecialSymbolTest() {
    	setValue(compPostCode, "%<>#");
        click(saveBtn);
        String ariaInvalidAttributeStatus = getAttribute(compPostCode, "aria-invalid");
        System.out.println("Aria-invalid status: " + ariaInvalidAttributeStatus);
        Reporter.log("Checked if error message for invalid postcode is displaying", true);
        boolean errorMsgDisplayStatus = ariaInvalidAttributeStatus.equals("true");
        Assert.assertTrue(errorMsgDisplayStatus, "Invalid postcode error is not displaying.");
    }
    
    public void validatePostcodeNumericDataTest() {
    	setValue(compPostCode, "8923443");
    	String postcodeValueAtrributeValue = getAttribute(compPostCode, "value");
    	boolean numericValueAcceptanceStatus = postcodeValueAtrributeValue.equals("8923443");
    	Reporter.log("Checked if the numeric data entered in postcode field is displaying", true);
    	Assert.assertTrue(numericValueAcceptanceStatus, "Numeric value is not geting accepted in postcodefield.");
    }
    
    public void validateIfPhoneFieldMandatory() {
    	setValue(phone, "");
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
    	Assert.assertFalse(phoneErrorMsgDisplayStatus, "Error message for phone field is displaying even if it is not mandatory");
    }
    
    public void validatePhoneFieldAlphabeticTestData() {
    	setValue(phone, "Lorem Ipsum");
    	Reporter.log("Entered alphabetic data in phone field", true);
    	click(saveBtn);
    	String errorStatus = getAttribute(phone, "aria-invalid");
    	if(errorStatus == null) {
    		errorStatus = "false";
    	}
    	boolean phoneErrorMsgDisplayStatus = errorStatus.equals("true");
    	Reporter.log("Checked if error message for phone field is displaying", true);
    	Assert.assertTrue(phoneErrorMsgDisplayStatus, "Error message for phone field is not displaying after alphabetic data in it");
    }
    
    public void validatePhoneFieldNumericTestData() {
    	setValue(phone, "9872391239");
    	Reporter.log("Entered alphabetic data in phone field", true);
    	String enteredValue = getAttribute(phone, "value");
    	boolean enteredValueDisplaystatus = enteredValue.equals("9872391239");
    	Reporter.log("Checked if the value entered is displaying in 'phone' field", true);
    	Assert.assertTrue(enteredValueDisplaystatus, "The entered value is not displaying in phone field");
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
        softAssertion.assertTrue(isElementPresent(saveSuccessMsg), "Save success message didn’t appear after saving profile data.");
        Reporter.log("Checked if the save success popup is displaying", true);
        softAssertion.assertAll();
    }
    
    
    
    public enum CompanyProfileFields
    {
        NAME, RegisteredAddress,PostCode,Phone,RegistrationNumber,
    }
}
