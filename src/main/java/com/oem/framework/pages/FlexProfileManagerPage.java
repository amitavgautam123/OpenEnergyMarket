package com.oem.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.oem.framework.core.base.BasePage;

public class FlexProfileManagerPage extends CustomerDashboardPage {

	public int NoOfSupplier = 0;
	By flexProfileMgr = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[1]/a");
	By strategyProfile = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[2]/a");
	By riskProfile = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[3]/a");
	By flexReporting = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[4]/a");
	By tradeReporting = By.xpath("//h3[contains(text(), 'Flex Management')]/following-sibling::ul/li[5]/a");

	By hhUtilityLink = By.id("hhUtility");
	By nhhUtilityLink = By.id("nhhUtility");
	By gasUtilityLink = By.id("gasUtility");

	By notAbleToCreateSetupProfile = By.xpath("//a[text()='Return To Flexible Profile Manager']");
	By notAbleToCreateSetUpProfile1 = By.xpath(
			"//h4[contains(text(),'We are sorry but your portfolio is not correctly set up to create a Flexible Profile.')]");

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
	By acceptQuote = By.xpath("//input[@class='btn btn-success btn-block acceptQuoteBtn']");
	By okAfterAccept = By.xpath("//a[@id='global-message-button-text']");

	By editFlexibleProfile = By.xpath("//a[@class='btn btn-warning']");
	By ReturnToFlexibleProfileManager = By.xpath("//a[@class='btn btn-primary']");

	By No_GoBackToPropertyProfoli = By.xpath("//a[@id='portfolio-manager-btn']");
	By cancelFlexibleProfileSetUp = By.xpath("//a[@id='cancel-btn']");
	String QuestionsTextExpected = "Questions";
	String PropertyPortfoli = "Property Portfolio | Open Energy Market";

	String tittle_of_flexProfileMgr = "Flexible Profile Manager | Open Energy Market";

	By noOfSuppliers = By.xpath("//div[@class='span3 profile-summay-supplier-container']/div");

	By clickHHReview = By.xpath(
			"//i[@data-original-title = 'Half Hourly Electric Profile']/../../following-sibling::td/a[text() = 'Review Quotes']");
	By clickGasReview = By
			.xpath("//i[@data-original-title = 'Gas Profile']/../../following-sibling::td/a[text() = 'Review Quotes']");
	By eonImageSource = By
			.xpath("//img[@src='https://oemweb.s3.amazonaws.com/files/7face949-67d1-43ed-b378-2dce75fc7691-sq.jpg']");
	By productName = By.xpath("//table//tbody//tr//td[2]");

	By hhSetup = By.xpath(
			"//i[@data-original-title = 'Half Hourly Electric Profile']/../../following-sibling::td/a[text() = 'Setup Flexible Profile']");
	By nHHSetUp = By.xpath(
			"//i[@data-original-title = 'Non Half Hourly Electric Profile']/../../following-sibling::td/a[text() = 'Setup Flexible Profile']");
	By gasSetUp = By.xpath(
			"//i[@data-original-title = 'Gas Profile']/../../following-sibling::td/a[text() = 'Setup Flexible Profile']");

	By hhUtilitySetUpPro = By.xpath(
			"//i[@data-original-title = 'Half Hourly Electric Profile']/../../following-sibling::td/a[text() = 'Setup Flexible Profile']");
	By gasUtilitySetUpPro = By.xpath(
			"//i[@data-original-title = 'Gas Profile']/../../following-sibling::td/a[text() = 'Setup Flexible Profile']");
	By nHHUtilitySetUpPro = By.xpath(
			"//i[@data-original-title = 'Non Half Hourly Electric Profile']/../../following-sibling::td/a[text() = 'Setup Flexible Profile']");

	static List<WebElement> suppliers;

	public void clickHHReview() {
		click(clickHHReview);
		Reporter.log("Clicked On HHRewiew", true);
	}

	public void clickGasReview() {
		click(clickGasReview);
		Reporter.log("Clicked On GasRewiew", true);
	}

	private List<WebElement> supplierList = captureSuppliers();

	public List<WebElement> getSupplierList() {
		// List<WebElement> allElements
		// suppliers = driver.findElements(noOfSuppliers);
		// for (WebElement element : suppliers) {
		// System.out.println(element.getText());
		return supplierList;

	}

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

	public FlexProfileManagerPage verifySubModulesPresenceInFlexmanagement() {
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
		return this;
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
		By ffdfg = By.xpath("//a[@class='btn btn-info btn-block']");

		boolean SetupProfile = isElementPresent(ffdfg);
		if (SetupProfile) {
			System.out.println("Set Up Profile is present");
		} else {
			// driver.findElement(By.xpath("//a[@class='btn btn-info
			// btn-block']")).click();
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
				Reporter.log("Checked For Presence of SetUp Flexible Profile", true);

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
				Reporter.log("clicked On  SetUp Flexible Profile", true);
				break firstLoop;
			}

		}

		boolean yesContinueButton = isElementPresent(yesContinue);
		softAssertion.assertTrue(yesContinueButton,
				"Flexible Profile Manager Home Page is not Having yesContinueButton .");
		Reporter.log("Checked For the presence of yesContinue Button.", true);

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
				Reporter.log("clicked On  SetUp Flexible Profile", true);
				break firstLoop;
			}

		}
		Thread.sleep(2000);
		click(yesContinue);
		Reporter.log("Clicked on YesContinue Button.", true);

		String QTextActual = getText(QuestionsTextActual);
		softAssertion.assertEquals(QuestionsTextExpected, QTextActual, "Questionaries are not present.");
		Reporter.log("Checked for the presence of Questionaries.", true);
		softAssertion.assertAll();
	}

	public void clickOnSetUpFlexibleProfile(String SelectUtility) throws Throwable {

		switch (SelectUtility) {

		case "HH":
			if (isElementPresent(hhUtilitySetUpPro)) {
				click(hhUtilitySetUpPro);
			} else {
				click_hhUtilityLink();
				Thread.sleep(2000);
				//click(hhUtilitySetUpPro);
				Thread.sleep(3000);

				if (isElementPresent(notAbleToCreateSetupProfile)) {
					FlexProfileAdminPage flexAdmin = new FlexProfileAdminPage();
					flexAdmin.deleteProfile("HH");

				}else {
					click(hhUtilitySetUpPro);
				}
			}
			break;

		case "nHH":

			if (isElementPresent(nHHUtilitySetUpPro)) {
				click(nHHUtilitySetUpPro);
			} else {
				click_nhhUtilityLink();
				Thread.sleep(2000);
				//click(nHHUtilitySetUpPro);
				if (isElementPresent(notAbleToCreateSetupProfile)) {
					FlexProfileAdminPage flexAdmin = new FlexProfileAdminPage();
					flexAdmin.deleteProfile("nHH");

				}
				else {
					click(nHHUtilitySetUpPro);
				}
			}
			break;
		case "Gas":
			if (isElementPresent(gasUtilitySetUpPro)) {
				click(gasUtilitySetUpPro);
			} else {

				click_gasUtilityLink();
				Thread.sleep(2000);
				
				if (isElementPresent(notAbleToCreateSetupProfile)) {
					FlexProfileAdminPage flexAdmin = new FlexProfileAdminPage();
					flexAdmin.deleteProfile("Gas");

				}
				else {
					click(gasUtilitySetUpPro);
				}
			}
			break;
		default:
			System.out.println("Please Enetr HH or nHH or Gas Utilitys Correctly");
		}

		click(yesContinue);
		Reporter.log("Clicked on YesContinue Button.", true);

		forloopToSelectMultipleQuestions();

		click_SaveButton();

		scrollToElement(requestContractOffer);
		List<WebElement> allSuppliers = driver.findElements(noOfSuppliers);
		int i = 0;
		// Traversing through the list and printing its Suppliers text
		for (WebElement supplier : allSuppliers) {
			Thread.sleep(3000);
			setExcelData("Sheet5", 1, i, supplier.getText());
			Thread.sleep(3000);
			i++;
		}

		Thread.sleep(3000);
		// forloopToSelectMultipleQuestions();
		scrollToElement(requestContractOffer);
		click(requestContractOffer);
		Reporter.log("Clicked On Request Contract Offer ", true);
	}

	public List<WebElement> captureSuppliers() {
		supplierList = driver.findElements(noOfSuppliers);
		return supplierList;
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
				Reporter.log("clicked On  Continue Profile Setup", true);

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

				By ReviewQuotes = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[5]//a[1]");
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
				Reporter.log("clicked On  SetUp Flexible Profile", true);

				click(yesContinue);
				Reporter.log("Clicked on YesContinue Button.", true);

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
				Reporter.log("clicked On  Continue Profile Setup", true);

				String QTextActual1 = getText(QuestionsTextActual);
				softAssertion.assertEquals(QuestionsTextExpected, QTextActual1, "Questionaries are not present.");
				Reporter.log("Checked for the presence of Questionaries.", true);
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
				Reporter.log("clicked On  SetUp Flexible Profile", true);

				click_No_GoBackToPropertyProfoli();
				Thread.sleep(3000);
				boolean titleOfPropertyProfoliPage = driver.getTitle().contains(PropertyPortfoli);
				softAssertion.assertTrue(titleOfPropertyProfoliPage,
						"Not Redirected To Property Profoli HomePage Page");
				Reporter.log(
						"Checked for Home Page Of Property Profoli After Selecting No-Go Back To Property Profoli Button. ",
						true);
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
		Reporter.log("Verified the title of customer Dashboard", true);
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
				Reporter.log("clicked On  Continue Profile Setup", true);

				click(yesContinue);
				Reporter.log("Clicked on YesContinue Button.", true);

				String QTextActual = getText(QuestionsTextActual);
				softAssertion.assertEquals(QuestionsTextExpected, QTextActual, "Questionaries are not present.");
				Reporter.log("Checked for the presence of Questionaries.", true);

				click_cancelFlexibleProfileSetUp();
				verifyCustomerDashBoardHomePage();
				break firstLoop;
			}
		}
	}

	public void clickReviewQuotes(String SelectUtility) throws Throwable {
		List rowsAfter = driver.findElements(rowCount);
		int rowsAfterClick = rowsAfter.size();
		switch (SelectUtility) {
		case "HH":

			System.out.println("No Of Flexible Purchasing Profiles Present Are :  " + rowsAfterClick);
			Thread.sleep(3000);

			firstLoop: for (int i = 1; i <= rowsAfterClick; i++) {

				By presentSetUpProfile = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[5]//a[1]");
				By presentUtility = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i
						+ "]//td[2]//i[@data-original-title='Half Hourly Electric Profile']");
				Thread.sleep(3000);
				String utilityHH = getText(presentUtility);

				String Text = getText(presentSetUpProfile);
				Thread.sleep(3000);
				boolean utilityPresence = driver.findElement(presentUtility).isDisplayed();
				if ((Text.contains("Review Quotes")) & (utilityPresence)) {
					Thread.sleep(3000);
					click(presentSetUpProfile);
					Reporter.log("Clicked On Review Quotes Of HH Utility", true);
					click(acceptQuote);
					click(okAfterAccept);
					break firstLoop;
				}

			}
			break;
		case "nHH":
			System.out.println("No Of Flexible Purchasing Profiles Present Are :  " + rowsAfterClick);
			Thread.sleep(3000);

			firstLoop: for (int i = 1; i <= rowsAfterClick; i++) {

				By presentSetUpProfile = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[5]//a[1]");
				By presentUtility = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i
						+ "]//td[2]//i[@data-original-title='Gas Profile']");
				Thread.sleep(3000);
				String utilityHH = getText(presentUtility);

				String Text = getText(presentSetUpProfile);
				Thread.sleep(3000);
				boolean utilityPresence = driver.findElement(presentUtility).isDisplayed();

				if ((Text.contains("Review Quotes")) & (utilityPresence)) {
					Thread.sleep(3000);
					click(presentSetUpProfile);
					Reporter.log("Clicked On Review Quotes of nHH", true);
					click(acceptQuote);
					click(okAfterAccept);
					break firstLoop;
				}

			}
			break;
		case "Gas":
			System.out.println("No Of Flexible Purchasing Profiles Present Are :  " + rowsAfterClick);
			Thread.sleep(3000);

			firstLoop: for (int i = 1; i <= rowsAfterClick; i++) {

				By presentSetUpProfile = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i + "]//td[5]//a[1]");
				By presentUtility = By.xpath("//table[@id='profiles-table']//tbody//tr[" + i
						+ "]//td[2]//i[@data-original-title='Gas Profile']");
				Thread.sleep(3000);
				String utilityHH = getText(presentUtility);

				String Text = getText(presentSetUpProfile);
				Thread.sleep(3000);
				boolean utilityPresence = driver.findElement(presentUtility).isDisplayed();

				if ((Text.contains("Review Quotes")) & (utilityPresence)) {
					Thread.sleep(3000);
					click(presentSetUpProfile);
					Reporter.log("Clicked On Review Quotes of Gas", true);
					click(acceptQuote);
					click(okAfterAccept);
					break firstLoop;
				}

			}
			break;
		default:
			System.out.println("Please enter the Correct Spelling ie. HH or nHH or Gas");
		}
	}

	public void verifyQuoteRequestelemets() throws Throwable {
		clickHHReview();
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(isElementPresent(eonImageSource), "EON image is Not Present");
		String productNameFroexcel = readExcelData("Sheet5", 23, 1);
		softAssertion.assertTrue(getText(productName).contains(productNameFroexcel),
				"Product Name Is Different(MisMatch) ");
		By supplierContractCosstatust = By.xpath("//table//tbody//tr//td[4]//i");
		By networksCostsstatu = By.xpath("//table//tbody//tr//td[5]//i");
		By enviChargesstatus = By.xpath("//table//tbody//tr//td[6]//i");

		By cclStatus = By.xpath("//table//tbody//tr//td[7]/i");
		By paymentTermsstatus = By.xpath("//table//tbody//tr//td[8]//i");
		By billingSetUpStatus = By.xpath("//table//tbody//tr//td[9]//i");
		By passedCreditStatus = By.xpath("//table//tbody//tr//td[10]//i");
		By acceptButton = By.xpath("//table//tbody//tr//td[11]//input");

		boolean supplierContractCostVerifystatust = getAttribute(supplierContractCosstatust, "class")
				.equals("icon-close");
		softAssertion.assertTrue(supplierContractCostVerifystatust, "SupplierContractCost is displaying as selected");

		boolean networksCostsverifystatu = getAttribute(networksCostsstatu, "class").equals("icon-close");
		softAssertion.assertFalse(networksCostsverifystatu, "NetworksCosts is displaying as selected");

		boolean envichargesVerifyStatus = getAttribute(enviChargesstatus, "class").equals("icon-close");
		softAssertion.assertTrue(envichargesVerifyStatus, "Enivronmental Charges is displaying as selected");

		boolean cclVerifyStatus = getAttribute(cclStatus, "class").equals("icon-checkmark");
		softAssertion.assertTrue(cclVerifyStatus, "CCL is not displaying as selected");

		boolean paymentTermserifystatus = getAttribute(paymentTermsstatus, "class").equals("icon-close");
		softAssertion.assertTrue(paymentTermserifystatus, "Payment Terms is displaying as selected");
		boolean billingSetUpverifyStatus = getAttribute(billingSetUpStatus, "class").equals("icon-close");
		softAssertion.assertTrue(billingSetUpverifyStatus, "BillingSetUp is displaying as selected");
		boolean passedCreditverifyStatus = getAttribute(passedCreditStatus, "class").equals("icon-close");
		softAssertion.assertTrue(passedCreditverifyStatus, "Passed Credit is displaying as selected");
		boolean verifyacceptButton = isElementPresent(acceptButton);
		softAssertion.assertTrue(verifyacceptButton, "Accept Button is not Present");

		click(acceptButton);
		Reporter.log("Clicked Accept Buutton", true);
		By okButton = By.id("global-message-button-text");
		Thread.sleep(5000);
		click(okButton);
		Reporter.log("Quote acceptenace has been passed and Clicked on Ok ");
		softAssertion.assertAll();
	}

	public void verifyQuoteRequestelemetsForGas() throws Throwable {
		clickGasReview();
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(isElementPresent(eonImageSource), "EON image is Not Present");
		String productNameFroexcel = readExcelData("Sheet5", 23, 1);
		softAssertion.assertTrue(getText(productName).contains(productNameFroexcel),
				"Product Name Is Different(MisMatch) ");
		By transportationandDistrbutionstatus = By.xpath("//table//tbody//tr//td[4]//i");
		By unifiedGasstatus = By.xpath("//table//tbody//tr//td[5]//i");
		By managementFeestatus = By.xpath("//table//tbody//tr//td[6]//i");

		By cclStatus = By.xpath("//table//tbody//tr//td[7]/i");
		/*
		 * By paymentTermsstatus=By.xpath("//table//tbody//tr//td[8]//i"); By
		 * billingSetUpStatus=By.xpath("//table//tbody//tr//td[9]//i"); By
		 * passedCreditStatus=By.xpath("//table//tbody//tr//td[10]//i");
		 */
		By acceptButton = By.xpath("//table//tbody//tr//td[8]//input");

		boolean TransAndDistVerifystatust = getAttribute(transportationandDistrbutionstatus, "class")
				.equals("icon-close");
		softAssertion.assertTrue(TransAndDistVerifystatust,
				"TransportationAndDistrbutionstatus is displaying as selected");

		boolean unifiedGasverifystatu = getAttribute(unifiedGasstatus, "class").equals("icon-close");
		softAssertion.assertTrue(unifiedGasverifystatu, "UnifiedGasstatus is displaying as selected");

		boolean managementFeeVerifyStatus = getAttribute(managementFeestatus, "class").equals("icon-close");
		softAssertion.assertTrue(managementFeeVerifyStatus, "ManagementFee is displaying as selected");

		boolean cclVerifyStatus = getAttribute(cclStatus, "class").equals("icon-checkmark");
		softAssertion.assertTrue(cclVerifyStatus, "CCL is not displaying as selected");

		/*
		 * boolean paymentTermserifystatus = getAttribute(paymentTermsstatus,
		 * "class").equals("icon-close");
		 * softAssertion.assertTrue(paymentTermserifystatus,
		 * "Payment Terms is displaying as selected"); boolean billingSetUpverifyStatus
		 * = getAttribute(billingSetUpStatus, "class").equals("icon-close");
		 * softAssertion.assertTrue(billingSetUpverifyStatus,
		 * "BillingSetUp is displaying as selected"); boolean passedCreditverifyStatus =
		 * getAttribute(passedCreditStatus, "class").equals("icon-close");
		 * softAssertion.assertTrue(passedCreditverifyStatus,
		 * "Passed Credit is displaying as selected");
		 */
		boolean verifyacceptButton = isElementPresent(acceptButton);
		softAssertion.assertTrue(verifyacceptButton, "Accept Button is not Present");

		click(acceptButton);
		Reporter.log("Clicked Accept Buutton", true);
		By okButton = By.id("global-message-button-text");
		click(okButton);
		Reporter.log("Quote acceptenace has been passed and Clicked on Ok ");

		Thread.sleep(5000);
		By acceptedButton = By.xpath("//input[@value = 'Accepted Quote']");
		softAssertion.assertTrue(isElementPresent(acceptedButton), "Accepted Text Is Not Found");
		softAssertion.assertAll();
	}
}
