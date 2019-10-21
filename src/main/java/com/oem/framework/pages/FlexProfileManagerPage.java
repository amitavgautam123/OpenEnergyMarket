package com.oem.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.oem.framework.core.base.BasePage;

public class FlexProfileManagerPage extends CustomerDashboardPage {

	By flexProfileMgr = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[1]/a");
	By strategyProfile = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[2]/a");
	By riskProfile = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[3]/a");
	By flexReporting = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[4]/a");
	By tradeReporting = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[5]/a");

	By hhUtilityLink = By.id("hhUtility");
	By nhhUtilityLink = By.id("nhhUtility");
	By gasUtilityLink = By.id("gasUtility");

	By rowCount = By.xpath("//table[@id='profiles-table']//tbody//tr");
	By yesContinue = By.xpath("//a[@id='proceed-btn']");
	By QuestionsTextActual = By.xpath("//h3[contains(text(),'Questions')]");
	By SaveButton = By.xpath("//input[@id='submit-btn']");

	By flexibleProfileCompletedMessage = By
			.xpath("//h3[contains(text(),'Congratulations, your Flexible Profile is complete')]");
	By requestContractOffer = By.xpath("//a[@class='btn btn-success']");

	By fullPriceAnalysisButton = By.xpath("//a[contains(text(),'Full Price Analysis')]");
	By fullPriceAnalysis2ndRowElemets = By.xpath("//div[@id='full-price-analysis-tab']//tr[2]");
	By supplierQutedButton = By.xpath("//a[contains(text(),'Supplier Quoted')]");
	By supplier_quoted_tab2ndRowElements = By.xpath("//div[@id='supplier-quoted-tab']//tr[2]");

	By editFlexibleProfile = By.xpath("//a[@class='btn btn-warning']");
	By ReturnToFlexibleProfileManager = By.xpath("//a[@class='btn btn-primary']");
	
	
	By No_GoBackToPropertyProfoli=By.xpath("//a[@id='portfolio-manager-btn']");
	By cancelFlexibleProfileSetUp=By.xpath("//a[@id='cancel-btn']");
	String QuestionsTextExpected = "Questions";
	String PropertyPortfoli="Property Portfolio | Open Energy Market";

	String tittle_of_flexProfileMgr = "Flexible Profile Manager | Open Energy Market";

	@Override
	protected void isLoaded() throws Error {
		System.out.println("Executing isLoaded in Flexible Profile Manager Page");
		Assert.assertTrue(isElementPresent(hhUtilityLink), "Flexible Profile Manager Page didnt appear");
	}

	public void click_No_GoBackToPropertyProfoli() {
		click(No_GoBackToPropertyProfoli);
		Reporter.log("Clicked on No_GoBackToPropertyProfoli Button .", true);
	}
	public void click_cancelFlexibleProfileSetUp() {
		click(cancelFlexibleProfileSetUp);
		Reporter.log("Clicked on cancelFlexibleProfileSetUp Button .", true);
	}
	public void click_fullPriceAnalysisButton() {
		click(fullPriceAnalysisButton);
		Reporter.log("Clicked on fullPrice Analysis Button.", true);
	}

	
	public void click_ReturnToFlexibleProfileManager() {
		click(ReturnToFlexibleProfileManager);
		Reporter.log("Clicked on Return To Flexible Profile Manager button.", true);
	}

	public void click_editFlexibleProfile() {
		click(editFlexibleProfile);
		Reporter.log("Clicked on EditFlexibleProfile.", true);
	}

	public void click_supplierQutedButton() {
		click(supplierQutedButton);
		Reporter.log("Clicked on supplier QutedButton.", true);
	}

	public void click_SaveButton() {
		click(SaveButton);
		Reporter.log("Clicked on Save Button.", true);
	}

	public void click_RequestContractOffer() {
		click(requestContractOffer);
		Reporter.log("Clicked on RequestContractOffer Button.", true);
	}

	public void verifySubModulesPresenceInFlexmanagement() {
		SoftAssert softAssertion = new SoftAssert();
		boolean flexProfileMgrPresenceStatus = isElementPresent(flexProfileMgr);
		softAssertion.assertTrue(flexProfileMgrPresenceStatus, "Flexible Profile Manager is not displaying.");
		Reporter.log("Checked if flexible profile manager is displaying.", true);
		boolean strategyProfilePresenceStatus = isElementPresent(strategyProfile);
		softAssertion.assertTrue(strategyProfilePresenceStatus, "Strategy Profile is not displaying.");
		Reporter.log("Checked if strategy Profile is displaying.", true);
		boolean riskProfilePresenceStatus = isElementPresent(riskProfile);
		softAssertion.assertTrue(riskProfilePresenceStatus, "Risk Profile is not displaying.");
		Reporter.log("Checked if Risk Profile is displaying.", true);
		boolean flexReportingPresenceStatus = isElementPresent(flexReporting);
		softAssertion.assertTrue(flexReportingPresenceStatus, "Flex Reporting is not displaying.");
		Reporter.log("Checked if Flex Reporting is displaying.", true);
		boolean tradeReportingPresenceStatus = isElementPresent(tradeReporting);
		softAssertion.assertTrue(tradeReportingPresenceStatus, "Trade Reporting is not displaying.");
		Reporter.log("Checked if Trade Reporting is displaying.", true);

		softAssertion.assertAll();
	}

	public void click_hhUtilityLink() {
		click(hhUtilityLink);
		Reporter.log("Clicked on hhUtilityLink", true);
	}

	public void click_nhhUtilityLink() {
		click(nhhUtilityLink);
		Reporter.log("Clicked on nhhUtilityLink", true);
	}

	public void click_gasUtilityLink() {
		click(gasUtilityLink);
		Reporter.log("Clicked on gasUtilityLink", true);
	}

	public void verifyFlexibleProfileManager_HomePage() {
		SoftAssert softAssertion = new SoftAssert();
		// click_flexProfileMgr();
		boolean verifyTittleOfFlexibleProfileManager = driver.getTitle().equals(tittle_of_flexProfileMgr);
		Reporter.log("Checked the Tittle Of Flexible Profile Manager is Same OR Not ", true);
		softAssertion.assertTrue(verifyTittleOfFlexibleProfileManager, "Tittle Of Flexible Profile Manager is wrong ");
		softAssertion.assertAll();
	}

	public void verifyPresenceOf3Utilitys_in_flexProfileMgrHomePage() {
		// click_flexProfileMgr();
		SoftAssert softAssertion = new SoftAssert();
		boolean hhUtilityLinkPresenceStatus = isElementPresent(hhUtilityLink);
		softAssertion.assertTrue(hhUtilityLinkPresenceStatus,
				"Flexible Profile Manager Home Page is not Having hhUtilityLink .");
		Reporter.log("Checked if flexible profile manager is Having hhUtilityLink.", true);
		boolean nhhUtilityLinkPresenceStatus = isElementPresent(hhUtilityLink);
		softAssertion.assertTrue(nhhUtilityLinkPresenceStatus,
				"Flexible Profile Manager Home Page is not Having nhhUtilityLink .");
		Reporter.log("Checked if flexible profile manager is Having nhhUtilityLink.", true);
		boolean gasUtilityLinkPresenceStatus = isElementPresent(gasUtilityLink);
		softAssertion.assertTrue(gasUtilityLinkPresenceStatus,
				"Flexible Profile Manager Home Page is not Having gasUtilityLink .");
		Reporter.log("Checked if flexible profile manager is Having gasUtilityLink.", true);
		softAssertion.assertAll();
	}

	public void verifyingPresenceOfOptionToSetupFlexibleProfile_in_flexProfileMgrHomePage(String SelectUtility) {
		SoftAssert softAssertion = new SoftAssert();
		List rows = driver.findElements(rowCount);
		int rowsBeforeClick = rows.size();
		// driver.close();
		System.out.println("No Of Rows Present Before Clicking Utility " + rowsBeforeClick);
		
		switch(SelectUtility){
		case "HH":
			click_hhUtilityLink();
			break;
		case "NHH":
			click_nhhUtilityLink();
			break;	
		case "Gas":
			click_gasUtilityLink();
			break;	
		default:
			System.out.println("Please enter Correct Utility Ex:HH Or NHH Or Gas");
			break;
		}

		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();
		// driver.close();
		System.out.println("No Of Rows Present After Clicking Utility " + rowsAfterClick);

		softAssertion.assertEquals(rowsBeforeClick, rowsAfterClick - 1, "Not able to add flexible profile");
		Reporter.log("Checked For Presence of SetUp Flexible Profile", true);

		softAssertion.assertAll();
	}

	public void verifyingPresenceOfListOfMeters_In_FlexibleProfileMgrHomePage(String SelectUtility) {
		SoftAssert softAssertion = new SoftAssert();
		List rows = driver.findElements(rowCount);
		int rowsBeforeClick = rows.size();
		// driver.close();
		System.out.println("No Of Rows Present Before Clicking Utility " + rowsBeforeClick);
		switch(SelectUtility){
		case "HH":
			click_hhUtilityLink();
			break;
		case "NHH":
			click_nhhUtilityLink();
			break;	
		case "Gas":
			click_gasUtilityLink();
			break;	
		default:
			System.out.println("Please enter Correct Utility Ex:HH Or NHH Or Gas");
			break;
		}

		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();
		// driver.close();
		System.out.println("No Of Rows Present After Clicking Utility " + rowsAfterClick);

		/*
		 * softAssertion.assertEquals(rowsBeforeClick, rowsAfterClick-1,
		 * "Not able to add flexible profile(No Of Rows Before Anf After are same)."
		 * ); Reporter.log("Checked For Presence of SetUp Flexible Profile",
		 * true);
		 */

		By presentSetUpProfile = By
				.xpath("//table[@id='profiles-table']//tbody//tr[" + rowsBeforeClick + "]//td[4]//a[1]");
		click(presentSetUpProfile);
		//System.out.println("clicked on setup ");
		Reporter.log("clicked On  SetUp Flexible Profile", true);

		boolean yesContinueButton = isElementPresent(yesContinue);
		softAssertion.assertTrue(yesContinueButton,
				"Flexible Profile Manager Home Page is not Having yesContinueButton .");
		Reporter.log("Checked For the presence of yesContinue Button.", true);

		softAssertion.assertAll();
	}

	public void verifyingPresenceOfListQuestions_In_FlexibleProfileMgrHomePage(String SelectUtility) {
		SoftAssert softAssertion = new SoftAssert();
		List rows = driver.findElements(rowCount);
		int rowsBeforeClick = rows.size();
		// driver.close();
		System.out.println("No Of Rows Present Before Clicking Utility " + rowsBeforeClick);
		switch(SelectUtility){
		case "HH":
			click_hhUtilityLink();
			break;
		case "NHH":
			click_nhhUtilityLink();
			break;	
		case "Gas":
			click_gasUtilityLink();
			break;	
		default:
			System.out.println("Please enter Correct Utility Ex:HH Or NHH Or Gas");
			break;
		}

		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();
		// driver.close();
		System.out.println("No Of Rows Present After Clicking Utility " + rowsAfterClick);

		/*
		 * softAssertion.assertEquals(rowsBeforeClick, rowsAfterClick-1,
		 * "Not able to add flexible profile(No Of Rows Before Anf After are same)."
		 * ); Reporter.log("Checked For Presence of SetUp Flexible Profile",
		 * true);
		 */

		By presentSetUpProfile = By
				.xpath("//table[@id='profiles-table']//tbody//tr[" + rowsAfterClick + "]//td[4]//a[1]");
		click(presentSetUpProfile);
		System.out.println("clicked on setup ");
		Reporter.log("clicked For Presence of SetUp Flexible Profile", true);

		boolean yesContinueButton = isElementPresent(yesContinue);
		softAssertion.assertTrue(yesContinueButton,
				"Flexible Profile Manager Home Page is not Having yesContinueButton .");
		Reporter.log("Checked For the presence of yesContinue Button.", true);

		click(yesContinue);
		Reporter.log("Clicked on YesContinue Button.", true);

		String QTextActual = getText(QuestionsTextActual);
		softAssertion.assertEquals(QuestionsTextExpected, QTextActual, "Questionaries are not present.");
		Reporter.log("Checked for the presence of Questionaries.", true);
		softAssertion.assertAll();
	}

	// div[@id='question-container-0']//div[3]//label[1]
	// div[@id='question-container-1']//div[3]//label[1]
	public void verifyingProfileCreation_In_FlexibleProfileMgrHomePage(String SelectUtility) {
		SoftAssert softAssertion = new SoftAssert();
		List rows = driver.findElements(rowCount);
		int rowsBeforeClick = rows.size();
		// driver.close();
		System.out.println("No Of Rows Present Before Clicking Utility " + rowsBeforeClick);
		switch(SelectUtility){
		case "HH":
			click_hhUtilityLink();
			break;
		case "NHH":
			click_nhhUtilityLink();
			break;	
		case "Gas":
			click_gasUtilityLink();
			break;	
		default:
			System.out.println("Please enter Correct Utility Ex:HH Or NHH Or Gas");
			break;
		}

		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();
		// driver.close();
		System.out.println("No Of Rows Present After Clicking Utility " + rowsAfterClick);

		/*
		 * softAssertion.assertEquals(rowsBeforeClick, rowsAfterClick-1,
		 * "Not able to add flexible profile(No Of Rows Before Anf After are same)."
		 * ); Reporter.log("Checked For Presence of SetUp Flexible Profile",
		 * true);
		 */

		By presentSetUpProfile = By
				.xpath("//table[@id='profiles-table']//tbody//tr[" + rowsAfterClick + "]//td[4]//a[1]");
		click(presentSetUpProfile);
		Reporter.log("clicked For Presence of SetUp Flexible Profile", true);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean yesContinueButton = isElementPresent(yesContinue);
		softAssertion.assertTrue(yesContinueButton,
				"Flexible Profile Manager Home Page is not Having yesContinueButton .");
		Reporter.log("Checked For the presence of yesContinue Button.", true);

		click(yesContinue);
		Reporter.log("Clicked on YesContinue Button.", true);

		String QTextActual = getText(QuestionsTextActual);
		softAssertion.assertEquals(QuestionsTextExpected, QTextActual, "Questionaries are not present.");
		Reporter.log("Checked for the presence of Questionaries.", true);

		forloopToSelectMultipleQuestions();
		click_SaveButton();
		String ActualTextMessageAfterClickingSaveAndContinue = getText(flexibleProfileCompletedMessage);

		softAssertion.assertEquals(ActualTextMessageAfterClickingSaveAndContinue,
				"Congratulations, your Flexible Profile is complete",
				"Actual TextMessage After Clicking SaveAndContinue is not matching With Expected Text");
		Reporter.log(
				"Checked for the Actual Text Message After Clicking SaveAndContinue,that is,is Flexible Profile is complete.",
				true);

		boolean requestContractOfferButton = isElementPresent(requestContractOffer);
		softAssertion.assertTrue(requestContractOfferButton, "requestContractOfferButton is not Present");
		Reporter.log("Checked for the presence of Request Contract offer Button.", true);

		click_RequestContractOffer();
		String abc = getText(presentSetUpProfile);
		softAssertion.assertEquals(abc, "Download Foundation Report",
				"Not converted to 'Download Foundation Report' from 'Setup Flexible Profile'");
		Reporter.log("Checked for the presence of Text 'Download Foundation Report'.", true);

		By ReviewQuotes = By.xpath("//table[@id='profiles-table']//tbody//tr[" + rowsAfterClick + "]//td[5]//a[1]");
		click(ReviewQuotes);
		Reporter.log("clicked On ReviewQuotes", true);

		click_supplierQutedButton();
		List secondRowElementsOfSupplierqouted = driver.findElements(supplier_quoted_tab2ndRowElements);
		int ElementsPresentInSupplierQuted = secondRowElementsOfSupplierqouted.size();
		softAssertion.assertEquals(0, ElementsPresentInSupplierQuted,
				"Elements are present at second Row Of Supplier qouted.");
		Reporter.log("Checked for the Data at review page Supllier Quted ", true);

		click_fullPriceAnalysisButton();
		List secondRowElementsOfclick_fullPriceAnalysis = driver.findElements(fullPriceAnalysis2ndRowElemets);
		int ElementsPresentInfullPriceAnalysis = secondRowElementsOfclick_fullPriceAnalysis.size();
		softAssertion.assertEquals(0, ElementsPresentInfullPriceAnalysis,
				"Elements are present at second Row Of Full Price Analysis.");
		Reporter.log("Checked for the Data at review page Full price Analysis  ", true);

		softAssertion.assertAll();
	}

	public void verifyingProfileCreationAndSelectingEditFlexibleProfile_In_FlexibleProfileMgrHomePage(String SelectUtility) {
		SoftAssert softAssertion = new SoftAssert();
		List rows = driver.findElements(rowCount);
		int rowsBeforeClick = rows.size();
		// driver.close();
		System.out.println("No Of Rows Present Before Clicking Utility " + rowsBeforeClick);
		switch(SelectUtility){
		case "HH":
			click_hhUtilityLink();
			break;
		case "NHH":
			click_nhhUtilityLink();
			break;	
		case "Gas":
			click_gasUtilityLink();
			break;	
		default:
			System.out.println("Please enter Correct Utility Ex:HH Or NHH Or Gas");
			break;
		}

		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();
		// driver.close();
		System.out.println("No Of Rows Present After Clicking Utility " + rowsAfterClick);

		/*
		 * softAssertion.assertEquals(rowsBeforeClick, rowsAfterClick-1,
		 * "Not able to add flexible profile(No Of Rows Before Anf After are same)."
		 * ); Reporter.log("Checked For Presence of SetUp Flexible Profile",
		 * true);
		 */

		By presentSetUpProfile = By
				.xpath("//table[@id='profiles-table']//tbody//tr[" + rowsAfterClick + "]//td[4]//a[1]");
		click(presentSetUpProfile);
		Reporter.log("clicked For Presence of SetUp Flexible Profile", true);

		boolean yesContinueButton = isElementPresent(yesContinue);
		softAssertion.assertTrue(yesContinueButton,
				"Flexible Profile Manager Home Page is not Having yesContinueButton .");
		Reporter.log("Checked For the presence of yesContinue Button.", true);

		click(yesContinue);
		Reporter.log("Clicked on YesContinue Button.", true);

		String QTextActual = getText(QuestionsTextActual);
		softAssertion.assertEquals(QuestionsTextExpected, QTextActual, "Questionaries are not present.");
		Reporter.log("Checked for the presence of Questionaries.", true);

		forloopToSelectMultipleQuestions();

		click_SaveButton();
		String ActualTextMessageAfterClickingSaveAndContinue = getText(flexibleProfileCompletedMessage);

		softAssertion.assertEquals(ActualTextMessageAfterClickingSaveAndContinue,
				"Congratulations, your Flexible Profile is complete",
				"Actual TextMessage After Clicking SaveAndContinue is not matching With Expected Text");
		Reporter.log(
				"Checked for the Actual Text Message After Clicking SaveAndContinue,that is,is Flexible Profile is complete.",
				true);

		boolean requestContractOfferButton = isElementPresent(requestContractOffer);
		softAssertion.assertTrue(requestContractOfferButton, "requestContractOfferButton is not Present");
		Reporter.log("Checked for the presence of Request Contract offer Button.", true);

		click_editFlexibleProfile();

		softAssertion.assertEquals(QuestionsTextExpected, QTextActual, "Questionaries are not present.");
		Reporter.log("Checked for the presence of Questionaries.", true);

		click_SaveButton();
		String ActualTextMessageAfterClickingSaveAndContinue1 = getText(flexibleProfileCompletedMessage);
		softAssertion.assertEquals(ActualTextMessageAfterClickingSaveAndContinue1,
				"Congratulations, your Flexible Profile is complete",
				"Actual TextMessage After Clicking SaveAndContinue is not matching With Expected Text");
		Reporter.log(
				"Checked for the Actual Text Message After Clicking SaveAndContinue,that is,is Flexible Profile is complete.",
				true);

		boolean requestContractOfferButton1 = isElementPresent(requestContractOffer);
		softAssertion.assertTrue(requestContractOfferButton1, "requestContractOfferButton is not Present");
		Reporter.log("Checked for the presence of Request Contract offer Button.", true);
		softAssertion.assertAll();
	}

	public void forloopToSelectMultipleQuestions() {

		

			for (int i = 0; i < 10; i++) {

				if (i % 2 == 0) {
					driver.findElement(By.xpath("//div[@id='question-container-" + i + "']//div[1]//label[1]")).click();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Reporter.log("clicked on " + i + "Question and 1 Option.", true);
				} else {

					driver.findElement(By.xpath("//div[@id='question-container-" + i + "']//div[2]//label[1]")).click();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Reporter.log("clicked on " + i + "Question and 2 Option.", true);
				}
			}

		

	}

	public void verifyingProfileCreationAndSelectingReturnToFlexibleProfileManager_In_FlexibleProfileMgrHomePage(String SelectUtility) {
		SoftAssert softAssertion = new SoftAssert();
		List rows = driver.findElements(rowCount);
		int rowsBeforeClick = rows.size();
		// driver.close();
		System.out.println("No Of Rows Present Before Clicking Utility " + rowsBeforeClick);
		switch(SelectUtility){
		case "HH":
			click_hhUtilityLink();
			break;
		case "NHH":
			click_nhhUtilityLink();
			break;	
		case "Gas":
			click_gasUtilityLink();
			break;	
		default:
			System.out.println("Please enter Correct Utility Ex:HH Or NHH Or Gas");
			break;
		}

		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();
		// driver.close();
		System.out.println("No Of Rows Present After Clicking Utility " + rowsAfterClick);

		/*
		 * softAssertion.assertEquals(rowsBeforeClick, rowsAfterClick-1,
		 * "Not able to add flexible profile(No Of Rows Before Anf After are same)."
		 * ); Reporter.log("Checked For Presence of SetUp Flexible Profile",
		 * true);
		 */

		By presentSetUpProfile = By
				.xpath("//table[@id='profiles-table']//tbody//tr[" + rowsAfterClick + "]//td[4]//a[1]");
		click(presentSetUpProfile);
		Reporter.log("clicked For Presence of SetUp Flexible Profile", true);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean yesContinueButton = isElementPresent(yesContinue);
		softAssertion.assertTrue(yesContinueButton,
				"Flexible Profile Manager Home Page is not Having yesContinueButton .");
		Reporter.log("Checked For the presence of yesContinue Button.", true);

		click(yesContinue);
		Reporter.log("Clicked on YesContinue Button.", true);

		String QTextActual = getText(QuestionsTextActual);
		softAssertion.assertEquals(QuestionsTextExpected, QTextActual, "Questionaries are not present.");
		Reporter.log("Checked for the presence of Questionaries.", true);

		forloopToSelectMultipleQuestions();

		click_SaveButton();
		String ActualTextMessageAfterClickingSaveAndContinue = getText(flexibleProfileCompletedMessage);

		softAssertion.assertEquals(ActualTextMessageAfterClickingSaveAndContinue,
				"Congratulations, your Flexible Profile is complete",
				"Actual TextMessage After Clicking SaveAndContinue is not matching With Expected Text");
		Reporter.log(
				"Checked for the Actual Text Message After Clicking SaveAndContinue,that is,is Flexible Profile is complete.",
				true);

		boolean requestContractOfferButton = isElementPresent(requestContractOffer);
		softAssertion.assertTrue(requestContractOfferButton, "requestContractOfferButton is not Present");
		Reporter.log("Checked for the presence of Request Contract offer Button.", true);

		click_ReturnToFlexibleProfileManager();
		
		verifyFlexibleProfileManager_HomePage();
		
		By ContinueProfileSetUp = By
				.xpath("//table[@id='profiles-table']//tbody//tr[" + rowsAfterClick + "]//td[4]//a[1]");
		String textOfContinue=getText(ContinueProfileSetUp);
		if(textOfContinue=="Continue Profile Setup"){
			click(ContinueProfileSetUp);
			Reporter.log("clicked on Continue Profile SetUp", true);
		}
		else{
			System.out.println("No 'Continue Profile Setup' is present");
		}
		String QTextActual1 = getText(QuestionsTextActual);
		softAssertion.assertEquals(QuestionsTextExpected, QTextActual1, "Questionaries are not present.");
		Reporter.log("Checked for the presence of Questionaries.", true);
		softAssertion.assertAll();
	
	}
	
	public void verifyingProfileCreationAndSelectingNo_GoBackToPropertyProfoli_In_FlexibleProfileMgrHomePage(String SelectUtility) {
		SoftAssert softAssertion = new SoftAssert();
		List rows = driver.findElements(rowCount);
		int rowsBeforeClick = rows.size();
		// driver.close();
		System.out.println("No Of Rows Present Before Clicking Utility " + rowsBeforeClick);
		switch(SelectUtility){
		case "HH":
			click_hhUtilityLink();
			break;
		case "NHH":
			click_nhhUtilityLink();
			break;	
		case "Gas":
			click_gasUtilityLink();
			break;	
		default:
			System.out.println("Please enter Correct Utility Ex:HH Or NHH Or Gas");
			break;
		}

		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();
		// driver.close();
		System.out.println("No Of Rows Present After Clicking Utility " + rowsAfterClick);

		/*
		 * softAssertion.assertEquals(rowsBeforeClick, rowsAfterClick-1,
		 * "Not able to add flexible profile(No Of Rows Before Anf After are same)."
		 * ); Reporter.log("Checked For Presence of SetUp Flexible Profile",
		 * true);
		 */

		By presentSetUpProfile = By
				.xpath("//table[@id='profiles-table']//tbody//tr[" + rowsAfterClick + "]//td[4]//a[1]");
		click(presentSetUpProfile);
		Reporter.log("clicked On Presence of SetUp Flexible Profile", true);
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click_No_GoBackToPropertyProfoli();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean titleOfPropertyProfoliPage=driver.getTitle().contentEquals(PropertyPortfoli);
		softAssertion.assertTrue(titleOfPropertyProfoliPage, "Not Redirected To Property Profoli HomePage Page");
		Reporter.log("Checked for Home Page Of Property Profoli After Selecting No-Go Back To Property Profoli Button. ", true);
		softAssertion.assertAll();
		
		
		
	}
	public void verifyCustomerDashBoardHomePage(){
		SoftAssert softAssertion = new SoftAssert();
    	String Title="Dashboard | Open Energy Market";
    	boolean titleOfCustDashBoard=driver.getTitle().contentEquals(Title);
    	softAssertion.assertTrue(titleOfCustDashBoard, "Title is not as expected ");
    	Reporter.log("Verified the title of customer Dashboard", true);
    	softAssertion.assertAll();
    }
	public void verifyCustomerDashBoardHomePageAfterClickingCancelFlexibleProfileSetUp_In_FlexibleProfileMgrHomePage(String SelectUtility) {
		SoftAssert softAssertion = new SoftAssert();
		List rows = driver.findElements(rowCount);
		int rowsBeforeClick = rows.size();
		// driver.close();
		System.out.println("No Of Rows Present Before Clicking hhUtility " + rowsBeforeClick);
		switch(SelectUtility){
		case "HH":
			click_hhUtilityLink();
			break;
		case "NHH":
			click_nhhUtilityLink();
			break;	
		case "Gas":
			click_gasUtilityLink();
			break;	
		default:
			System.out.println("Please enter Correct Utility Ex:HH Or NHH Or Gas");
			break;
		}

		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();
		// driver.close();
		System.out.println("No Of Rows Present After Clicking hhUtility " + rowsAfterClick);

		/*
		 * softAssertion.assertEquals(rowsBeforeClick, rowsAfterClick-1,
		 * "Not able to add flexible profile(No Of Rows Before Anf After are same)."
		 * ); Reporter.log("Checked For Presence of SetUp Flexible Profile",
		 * true);
		 */

		By presentSetUpProfile = By
				.xpath("//table[@id='profiles-table']//tbody//tr[" + rowsAfterClick + "]//td[4]//a[1]");
		click(presentSetUpProfile);
		Reporter.log("clicked For Presence of SetUp Flexible Profile", true);

		boolean yesContinueButton = isElementPresent(yesContinue);
		softAssertion.assertTrue(yesContinueButton,
				"Flexible Profile Manager Home Page is not Having yesContinueButton .");
		Reporter.log("Checked For the presence of yesContinue Button.", true);

		click(yesContinue);
		Reporter.log("Clicked on YesContinue Button.", true);

		String QTextActual = getText(QuestionsTextActual);
		softAssertion.assertEquals(QuestionsTextExpected, QTextActual, "Questionaries are not present.");
		Reporter.log("Checked for the presence of Questionaries.", true);
		 
		click_cancelFlexibleProfileSetUp();
		verifyCustomerDashBoardHomePage();
		
	}
}
