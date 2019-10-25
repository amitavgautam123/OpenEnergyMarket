package com.oem.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

	By No_GoBackToPropertyProfoli = By.xpath("//a[@id='portfolio-manager-btn']");
	By cancelFlexibleProfileSetUp = By.xpath("//a[@id='cancel-btn']");
	String QuestionsTextExpected = "Questions";
	String PropertyPortfoli = "Property Portfolio | Open Energy Market";

	String tittle_of_flexProfileMgr = "Flexible Profile Manager | Open Energy Market";

	By noOfSuppliers = By.xpath("//div[@class='span3 profile-summay-supplier-container']/div");

	@Override
	protected void isLoaded() throws Error {
		System.out.println("Executing isLoaded in Flexible Profile Manager Page");
		Assert.assertTrue(isElementPresent(hhUtilityLink), "Flexible Profile Manager Page didnt appear");
	}

	public void click_No_GoBackToPropertyProfoli() {
		click(No_GoBackToPropertyProfoli);
		
	}

	public void click_cancelFlexibleProfileSetUp() {
		click(cancelFlexibleProfileSetUp);
		
	}

	public void click_fullPriceAnalysisButton() {
		click(fullPriceAnalysisButton);
		
	}

	public void click_ReturnToFlexibleProfileManager() {
		click(ReturnToFlexibleProfileManager);
		
	}

	public void click_editFlexibleProfile() {
		click(editFlexibleProfile);
		
	}

	public void click_supplierQutedButton() {
		click(supplierQutedButton);
		
	}

	public void click_SaveButton() {
		click(SaveButton);
		
	}

	public void click_RequestContractOffer() {
		click(requestContractOffer);
		
	}

	public void verifySubModulesPresenceInFlexmanagement() {
		SoftAssert softAssertion = new SoftAssert();
		boolean flexProfileMgrPresenceStatus = isElementPresent(flexProfileMgr);
		softAssertion.assertTrue(flexProfileMgrPresenceStatus, "Flexible Profile Manager is not displaying.");
		boolean strategyProfilePresenceStatus = isElementPresent(strategyProfile);
		softAssertion.assertTrue(strategyProfilePresenceStatus, "Strategy Profile is not displaying.");
		boolean riskProfilePresenceStatus = isElementPresent(riskProfile);
		softAssertion.assertTrue(riskProfilePresenceStatus, "Risk Profile is not displaying.");
		boolean flexReportingPresenceStatus = isElementPresent(flexReporting);
		softAssertion.assertTrue(flexReportingPresenceStatus, "Flex Reporting is not displaying.");
		boolean tradeReportingPresenceStatus = isElementPresent(tradeReporting);
		softAssertion.assertTrue(tradeReportingPresenceStatus, "Trade Reporting is not displaying.");
		
		softAssertion.assertAll();
	}

	public void click_hhUtilityLink() {
		click(hhUtilityLink);
		
	}

	public void click_nhhUtilityLink() {
		click(nhhUtilityLink);
		
	}

	public void click_gasUtilityLink() {
		click(gasUtilityLink);
		
	}

	public void verifyFlexibleProfileManager_HomePage() {
		SoftAssert softAssertion = new SoftAssert();
		// click_flexProfileMgr();
		boolean verifyTittleOfFlexibleProfileManager = driver.getTitle().equals(tittle_of_flexProfileMgr);
		softAssertion.assertTrue(verifyTittleOfFlexibleProfileManager, "Tittle Of Flexible Profile Manager is wrong ");
		softAssertion.assertAll();
	}

	public void verifyPresenceOf3Utilitys_in_flexProfileMgrHomePage() {
		// click_flexProfileMgr();
		SoftAssert softAssertion = new SoftAssert();
		boolean hhUtilityLinkPresenceStatus = isElementPresent(hhUtilityLink);
		softAssertion.assertTrue(hhUtilityLinkPresenceStatus,
				"Flexible Profile Manager Home Page is not Having hhUtilityLink .");
		boolean nhhUtilityLinkPresenceStatus = isElementPresent(hhUtilityLink);
		softAssertion.assertTrue(nhhUtilityLinkPresenceStatus,
				"Flexible Profile Manager Home Page is not Having nhhUtilityLink .");
		boolean gasUtilityLinkPresenceStatus = isElementPresent(gasUtilityLink);
		softAssertion.assertTrue(gasUtilityLinkPresenceStatus,
				"Flexible Profile Manager Home Page is not Having gasUtilityLink .");
		By ffdfg=By.xpath("//a[@class='btn btn-info btn-block']");
		
		boolean SetupProfile = isElementPresent(ffdfg);
		if(SetupProfile){
			System.out.println("Set Up Profile is present");
		}
		else{
			//driver.findElement(By.xpath("//a[@class='btn btn-info btn-block']")).click();
			click(hhUtilityLink);
		}
		softAssertion.assertAll();
	}

	public void verifyingPresenceOfOptionToSetupFlexibleProfile_in_flexProfileMgrHomePage(String SelectUtility)
			throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();

		System.out.println("No Of Rows Present After Clicking Utility " + rowsAfterClick);
		Thread.sleep(3000);
		firstLoop: for (int i = 1; i <= rowsAfterClick; i++) {

			By presentSetUpProfile = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[4]//a[1]");
			By presentUtility = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[2]//i");
			Thread.sleep(3000);
			String utilityHH = getText(presentUtility);

			String Text = getText(presentSetUpProfile);
			Thread.sleep(3000);
			boolean trueOrFalse = Text.contains("Setup Flexible Profile");
			if (trueOrFalse) {

				softAssertion.assertTrue(trueOrFalse, "Setup Flexible Profile is Not Present");
				
				softAssertion.assertAll();
				break firstLoop;
			}

		}
	}

	public void verifyingPresenceOfListOfMeters_In_FlexibleProfileMgrHomePage(String SelectUtility) throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();

		Thread.sleep(3000);
		firstLoop: for (int i = 1; i <= rowsAfterClick; i++) {

			By presentSetUpProfile = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[4]//a[1]");
			By presentUtility = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[2]//i");
			Thread.sleep(3000);
			String utilityHH = getText(presentUtility);

			String Text = getText(presentSetUpProfile);
			Thread.sleep(3000);
			boolean trueOrFalse = Text.contains("Setup Flexible Profile");
			if (trueOrFalse) {

				click(presentSetUpProfile);
				Thread.sleep(2000);
				break firstLoop;
			}

		}
		
		boolean yesContinueButton = isElementPresent(yesContinue);
		softAssertion.assertTrue(yesContinueButton,
				"Flexible Profile Manager Home Page is not Having yesContinueButton .");
		
		softAssertion.assertAll();
	}

	public void verifyingPresenceOfListQuestions_In_FlexibleProfileMgrHomePage(String SelectUtility) throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();

		// System.out.println("No Of Rows Present After Clicking Utility " +
		// rowsAfterClick);
		Thread.sleep(3000);
		firstLoop: for (int i = 1; i <= rowsAfterClick; i++) {

			By presentSetUpProfile = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[4]//a[1]");
			By presentUtility = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[2]//i");
			Thread.sleep(3000);
			String utilityHH = getText(presentUtility);

			String Text = getText(presentSetUpProfile);
			Thread.sleep(3000);
			boolean trueOrFalse = Text.contains("Setup Flexible Profile");
			if (trueOrFalse) {

				click(presentSetUpProfile);
				break firstLoop;
			}

		}
		Thread.sleep(2000);
		click(yesContinue);
		
		String QTextActual = getText(QuestionsTextActual);
		softAssertion.assertEquals(QuestionsTextExpected, QTextActual, "Questionaries are not present.");
		softAssertion.assertAll();
	}

	public void clickOnSetUpFlexibleProfile() throws Throwable {
		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();

		System.out.println("No Of Rows Present After Clicking Utility " + rowsAfterClick);
		Thread.sleep(3000);
		firstLoop: for (int i = 1; i <= rowsAfterClick; i++) {

			By presentSetUpProfile = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[4]//a[1]");
			By presentUtility = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[2]//i");
			Thread.sleep(3000);
			String utilityHH = getText(presentUtility);

			String Text = getText(presentSetUpProfile);
			Thread.sleep(3000);
			if (Text.contains("Setup Flexible Profile")) {
				Thread.sleep(3000);
				click(presentSetUpProfile);
				break firstLoop;
			}
		}
		click(yesContinue);
		
		// List suppliers=driver.findElements(noOfSuppliers);

		List<WebElement> suppliers = driver.findElements(noOfSuppliers);
		int NoOfSupplier = suppliers.size();
		System.out.println("No Of Suplliers Present are:" + NoOfSupplier);
		setExcelIntData("sheet5", 0, 1, NoOfSupplier);// which stores No Of
														// Suppliers present in
														// page to excel
		// Traversing through the list and printing its Suppliers Name along and
		// store them in excelFile
		int i = 0;
		for (WebElement suppliersName : suppliers) {

			String supplier = suppliersName.getText();
			System.out.println(supplier);
			setExcelData("sheet5", 1, i, supplier);
			i++;
		}

		Thread.sleep(3000);
		forloopToSelectMultipleQuestions();

		click_SaveButton();
		click(requestContractOffer);

	}

	// div[@id='question-container-0']//div[3]//label[1]
	// div[@id='question-container-1']//div[3]//label[1]
	public void verifyingProfileCreation_In_FlexibleProfileMgrHomePage(String SelectUtility) throws Throwable {

		SoftAssert softAssertion = new SoftAssert();
		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();

		// System.out.println("No Of Rows Present After Clicking Utility " +
		// rowsAfterClick);
		Thread.sleep(3000);
		firstLoop: for (int i = 1; i <= rowsAfterClick; i++) {

			By presentSetUpProfile = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[4]//a[1]");
			By presentUtility = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[2]//i");
			Thread.sleep(3000);
			String utilityHH = getText(presentUtility);

			String Text = getText(presentSetUpProfile);
			Thread.sleep(3000);
			boolean trueOrFalse = Text.contains("Continue Profile Setup");
			if (trueOrFalse) {

				click(presentSetUpProfile);
				
				forloopToSelectMultipleQuestions();

				click_SaveButton();
				String ActualTextMessageAfterClickingSaveAndContinue = getText(flexibleProfileCompletedMessage);

				softAssertion.assertEquals(ActualTextMessageAfterClickingSaveAndContinue,
						"Congratulations, your Flexible Profile is complete",
						"Actual TextMessage After Clicking SaveAndContinue is not matching With Expected Text");
				

				boolean requestContractOfferButton = isElementPresent(requestContractOffer);
				softAssertion.assertTrue(requestContractOfferButton, "requestContractOfferButton is not Present");
				
				click_RequestContractOffer();
				String abc = getText(presentSetUpProfile);
				softAssertion.assertEquals(abc, "Download Foundation Report",
						"Not converted to 'Download Foundation Report' from 'Setup Flexible Profile'");
				
				By ReviewQuotes = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[5]//a[1]");
				click(ReviewQuotes);
				
				click_supplierQutedButton();
				List secondRowElementsOfSupplierqouted = driver.findElements(supplier_quoted_tab2ndRowElements);
				int ElementsPresentInSupplierQuted = secondRowElementsOfSupplierqouted.size();
				softAssertion.assertEquals(0, ElementsPresentInSupplierQuted,
						"Elements are present at second Row Of Supplier qouted.");
				
				click_fullPriceAnalysisButton();
				List secondRowElementsOfclick_fullPriceAnalysis = driver.findElements(fullPriceAnalysis2ndRowElemets);
				int ElementsPresentInfullPriceAnalysis = secondRowElementsOfclick_fullPriceAnalysis.size();
				softAssertion.assertEquals(0, ElementsPresentInfullPriceAnalysis,
						"Elements are present at second Row Of Full Price Analysis.");
				
				softAssertion.assertAll();
				break firstLoop;
			}
		}
	}

	public void verifyingProfileCreationAndSelectingEditFlexibleProfile_In_FlexibleProfileMgrHomePage(
			String SelectUtility) throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();

		// System.out.println("No Of Rows Present After Clicking Utility " +
		// rowsAfterClick);
		Thread.sleep(3000);
		firstLoop: for (int i = 1; i <= rowsAfterClick; i++) {

			By presentSetUpProfile = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[4]//a[1]");
			By presentUtility = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[2]//i");
			Thread.sleep(3000);
			String utilityHH = getText(presentUtility);

			String Text = getText(presentSetUpProfile);
			Thread.sleep(3000);
			boolean trueOrFalse = Text.contains("Setup Flexible Profile");
			if (trueOrFalse) {

				click(presentSetUpProfile);
				
				click(yesContinue);
				
				forloopToSelectMultipleQuestions();

				click_SaveButton();
				String ActualTextMessageAfterClickingSaveAndContinue = getText(flexibleProfileCompletedMessage);

				softAssertion.assertEquals(ActualTextMessageAfterClickingSaveAndContinue,
						"Congratulations, your Flexible Profile is complete",
						"Actual TextMessage After Clicking SaveAndContinue is not matching With Expected Text");
				

				boolean requestContractOfferButton = isElementPresent(requestContractOffer);
				softAssertion.assertTrue(requestContractOfferButton, "requestContractOfferButton is not Present");
				
				click_editFlexibleProfile();

				click_SaveButton();
				String ActualTextMessageAfterClickingSaveAndContinue1 = getText(flexibleProfileCompletedMessage);
				softAssertion.assertEquals(ActualTextMessageAfterClickingSaveAndContinue1,
						"Congratulations, your Flexible Profile is complete",
						"Actual TextMessage After Clicking SaveAndContinue is not matching With Expected Text");
				
				boolean requestContractOfferButton1 = isElementPresent(requestContractOffer);
				softAssertion.assertTrue(requestContractOfferButton1, "requestContractOfferButton is not Present");
				softAssertion.assertAll();
				break firstLoop;
			}
		}
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
				
			} else {

				driver.findElement(By.xpath("//div[@id='question-container-" + i + "']//div[2]//label[1]")).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	}

	public void verifyingProfileCreationAndSelectingReturnToFlexibleProfileManager_In_FlexibleProfileMgrHomePage(
			String SelectUtility) throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();

		// System.out.println("No Of Rows Present After Clicking Utility " +
		// rowsAfterClick);
		Thread.sleep(3000);
		firstLoop: for (int i = 1; i <= rowsAfterClick; i++) {

			By presentSetUpProfile = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[4]//a[1]");
			By presentUtility = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[2]//i");
			Thread.sleep(3000);
			String utilityHH = getText(presentUtility);

			String Text = getText(presentSetUpProfile);
			Thread.sleep(3000);
			boolean trueOrFalse = Text.contains("Continue Profile Setup");
			if (trueOrFalse) {

				click(presentSetUpProfile);
				
				String QTextActual1 = getText(QuestionsTextActual);
				softAssertion.assertEquals(QuestionsTextExpected, QTextActual1, "Questionaries are not present.");
				softAssertion.assertAll();
				break firstLoop;
			}
		}
	}

	public void verifyingProfileCreationAndSelectingNo_GoBackToPropertyProfoli_In_FlexibleProfileMgrHomePage(
			String SelectUtility) throws Throwable {

		SoftAssert softAssertion = new SoftAssert();
		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();

		Thread.sleep(3000);
		firstLoop: for (int i = 1; i <= rowsAfterClick; i++) {

			By presentSetUpProfile = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[4]//a[1]");
			By presentUtility = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[2]//i");
			Thread.sleep(3000);
			String utilityHH = getText(presentUtility);

			String Text = getText(presentSetUpProfile);
			Thread.sleep(3000);
			boolean trueOrFalse = Text.contains("Setup Flexible Profile");
			if (trueOrFalse) {

				click(presentSetUpProfile);
				
				click_No_GoBackToPropertyProfoli();
				Thread.sleep(3000);
				boolean titleOfPropertyProfoliPage = driver.getTitle().contains(PropertyPortfoli);
				softAssertion.assertTrue(titleOfPropertyProfoliPage,
						"Not Redirected To Property Profoli HomePage Page");
				
				softAssertion.assertAll();
				break firstLoop;
			}
		}

	}

	public void verifyCustomerDashBoardHomePage() {
		SoftAssert softAssertion = new SoftAssert();
		String Title = "Dashboard | Open Energy Market";
		boolean titleOfCustDashBoard = driver.getTitle().contentEquals(Title);
		softAssertion.assertTrue(titleOfCustDashBoard, "Title is not as expected ");
		softAssertion.assertAll();
	}

	public void verifyCustomerDashBoardHomePageAfterClickingCancelFlexibleProfileSetUp_In_FlexibleProfileMgrHomePage(
			String SelectUtility) throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();

		// System.out.println("No Of Rows Present After Clicking Utility " +
		// rowsAfterClick);
		Thread.sleep(3000);
		firstLoop: for (int i = 1; i <= rowsAfterClick; i++) {

			By presentSetUpProfile = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[4]//a[1]");
			By presentUtility = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[2]//i");
			Thread.sleep(3000);
			String utilityHH = getText(presentUtility);

			String Text = getText(presentSetUpProfile);
			Thread.sleep(3000);
			boolean trueOrFalse = Text.contains("Continue Profile Setup");
			if (trueOrFalse) {

				click(presentSetUpProfile);
				
				click(yesContinue);
				
				String QTextActual = getText(QuestionsTextActual);
				softAssertion.assertEquals(QuestionsTextExpected, QTextActual, "Questionaries are not present.");
				
				click_cancelFlexibleProfileSetUp();
				verifyCustomerDashBoardHomePage();
				break firstLoop;
			}
		}
	}
}
