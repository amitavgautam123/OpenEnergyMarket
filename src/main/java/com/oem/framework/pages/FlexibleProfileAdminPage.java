package com.oem.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class FlexibleProfileAdminPage extends AdminDashboardPage {

	By customerProfiles = By.xpath("//a//section[1]");
	By NoOfRows_01 = By.xpath("//table[@id='profile-table']//tbody//tr");
	By governanceManage = By.xpath("//td[text()='Governance']/following-sibling::td/div/a");
	By purchaseRequirementManage = By.xpath("//td[text()='Purchasing Requirement']/following-sibling::td/div/a");
	By rollingCoverManage = By.xpath("//td[text()='Rolling Cover']/following-sibling::td/div/a");

	By firstcustomerProfile = By.xpath("//a[1]//section[1]");
	By secondcustomerProfile = By.xpath("//a[2]//section[1]");

	By manageProfiles = By.xpath("//table[@id='profile-table']//tr//td[7]");

	By profileDetailsText = By.xpath("//h4[contains(text(),'Profile Details')]");
	By profileActionsText = By.xpath("//h4[contains(text(),'Profile Actions')]");
	By customerDefinedRiskesText = By.xpath("//h4[contains(text(),'Customer Defined Risk / Strategy')]");
	By imporsenateUserText = By.xpath("//h4[@class='heading']");

	By imporsanateuser = By.xpath("//button[@class='btn-link btn-primary']");

	By rejectButton = By.xpath("//button[@class='btn btn-danger']");
	By acceptButton = By.xpath("//button[@class='btn btn-success']");
	By tickMarkAfterClickingAcceptButton = By.xpath("//span[@class='fa fa-2x fa-fw fa-check green']");
	By UpdateButtonOFPurchas = By.xpath("//button[@id='purchasingRequirement_AddBtn']");
	By UpdateButtonOfGovenance = By.id("governance_AddBtn");
	By cancelButtoun = By.xpath("//button[text()='Cancel']");
	// purchase
	// ====================Profile Actions================================
	By editTradeVolumes = By.xpath("//a[text()='Edit Trade Volumes']");
	By trading = By.xpath("//a[text()='Trading']");
	By updateCalculationsResult = By.xpath("//a[contains(text(),'Update Calculation Results')]");
	By supplierclipvolume1stEditButton = By.xpath("//button[contains(text(),'Edit')][1]");

	By positionWithTrades = By.xpath("//a[contains(text(),'Positions with Trades')]");
	By positionWithoutTrades = By.xpath("//a[contains(text(),'Positions without Trades')]");
	By positionExpired = By.xpath("//a[contains(text(),'Positions Expired')]");
	By tradingHistory = By.xpath("//a[contains(text(),'Trading History')]");
	// ======================Trade Page=========================================
	By firstTrade = By.xpath("//input[@class='btn btn-success'][1]");
	By buy = By.id("tradeTypeId1");
	By sell = By.id("tradeTypeId2");
	By unitPrice = By.id("UnitPrice");
	By tpd = By.id("volumeInputUnit");
	By percent = By.id("volumeInputPercent");
	By volumetext = By.className("tradeVolumeUnit");
	By save = By.xpath("//button[contains(text(),'Save')]");

	public void verifyThePresenceOfAllCustomers(/* String CustomerName */) {
		/*
		 * List<WebElement> customers = driver.findElements(customerProfiles);
		 * int NoOfCustomers = customers.size(); System.out.println(
		 * "No Of Customers are:" + NoOfCustomers+"customers are/n");
		 * System.out.println(customers); boolean isElemntPresent =
		 * customers.contains(CustomerName); if (isElemntPresent) { for (int i =
		 * 1; i <= NoOfCustomers; i++) { if (driver.findElement(By.xpath("//a["
		 * + i + "]//section[1]")).equals(CustomerName)) {
		 * driver.findElement(By.xpath("//a[" + i + "]//section[1]")).click(); }
		 * 
		 * } } else { System.out.println("Please Enter Correct Customer Name");
		 * }
		 */
		SoftAssert softAssertion = new SoftAssert();
		List<WebElement> customers = driver.findElements(customerProfiles);
		int NoOfCustomers = customers.size();
		System.out.println("No Of Customers Are:" + NoOfCustomers);
		for (int i = 1; i <= NoOfCustomers; i++) {

			String CustomerName = driver.findElement(By.xpath("//a[" + i + "]//section[1]")).getText();
			System.out.println(i + "\t" + CustomerName);

		}
		softAssertion.assertTrue(NoOfCustomers > 1, "No Elements are Present.");
		
	}

	public void verifyPresenceOf3Modules() {
		SoftAssert softAssertion = new SoftAssert();
		boolean presenceOfFlexTenderResponse = isElementPresent(flexTenderResponse);
		softAssertion.assertTrue(presenceOfFlexTenderResponse, "flex Tender Response is Not Present.");
		
		boolean presenceOfflexReQuoteTender = isElementPresent(flexReQuoteTender);
		softAssertion.assertTrue(presenceOfflexReQuoteTender, "flex Re-Quote Tender is Not Present.");
		
		boolean presenceOfflexProfileAdmin = isElementPresent(flexProfileAdmin);
		softAssertion.assertTrue(presenceOfflexProfileAdmin, "flex Profile Admin is Not Present.");
		
		softAssertion.assertAll();
	}

	public void VerifypresenceOfDuration_Manage_DeleteOptions_AfterSelectingCustomer() {

		click(firstcustomerProfile);
		SoftAssert softAssertion = new SoftAssert();
		for (int i = 0; i < 9; i++) {
			if (i == 3) {
				String DurationText = driver.findElement(By.xpath("//table[@id='profile-table']//tr//td[" + i + "]"))
						.getText();
				boolean DuratText = DurationText.contains("Years");
				softAssertion.assertTrue(DuratText, "Duration is Not Present");
				
			}
			if (i == 7) {

				String ManageProfileText = driver
						.findElement(By.xpath("//table[@id='profile-table']//tr//td[" + i + "]")).getText();
				boolean ManagPrText = ManageProfileText.contentEquals("Manage Profile");
				softAssertion.assertTrue(ManagPrText, "Manage Profile Text is Not Present");
				
			}
			if (i == 8) {
				String DeleteProfileText = driver
						.findElement(By.xpath("//table[@id='profile-table']//tr//td[" + i + "]")).getText();
				boolean DeletePrText = DeleteProfileText.contains("Delete");
				softAssertion.assertTrue(DeletePrText, "Delete Profile Text is Not Present");
				
			}
		}
		softAssertion.assertAll();

	}

	public void verifyProfileDetails_ProfileActions_PresenceOf_Impersonate_Users() {
		SoftAssert softAssertion = new SoftAssert();
		click(firstcustomerProfile);
		click(manageProfiles);
		boolean Profile_Details = getText(profileDetailsText).contains("Profile Details");
		boolean Profile_Actions = getText(profileActionsText).contains("Profile Actions");
		boolean Customer_Defined_Risk = getText(customerDefinedRiskesText).contains("Customer Defined Risk / Strategy");
		boolean Impersonate_Users = getText(imporsenateUserText).contains("Impersonate Users");
		softAssertion.assertTrue(Profile_Details, "Profile Details Are Not Present.");
		softAssertion.assertTrue(Profile_Actions, "Profile Actions Are Not Present.");
		softAssertion.assertTrue(Customer_Defined_Risk, "Customer Defined Risks Are Not Present.");
		softAssertion.assertTrue(Impersonate_Users, "Impersonate Users Are Not Present.");

		softAssertion.assertAll();
	}

	public void verifyingCustomerBiding_AfterClicking_GovernanceManage() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		selectingCustomerAndManageProfile();
		click(governanceManage);
		String GovernanceExpectedText = "Governance";
		String GovernanceActualText = driver.findElement(By.xpath("//h3[@id='governance_WidgetTitle']")).getText();
		boolean abc = GovernanceActualText.contentEquals(GovernanceExpectedText);
		softAssertion.assertTrue(abc, "Not directed Expected Page");
		
	}

	public void selectingCustomerAndManageProfile() throws Throwable {
		List<WebElement> customers = driver.findElements(customerProfiles);
		int NoOfCustomers = customers.size();
		System.out.println("No Of Customers are:" + NoOfCustomers);

		OuterLoop: for (int i = 1; i <= NoOfCustomers; i++) {

			driver.findElement(By.xpath("//a[" + i + "]//section[1]")).click();
			int NoOfRows = driver.findElements(NoOfRows_01).size();

			System.out.println("No Of Rows(Profile Utilitys) Of " + i + ". Customer Are:" + NoOfRows);
			Thread.sleep(3000);
			innerLoop: for (int j = 1; j < NoOfRows; j++) {
				Thread.sleep(3000);
				String TextDelete = driver.findElement(By.xpath("//tr[" + j + "]//td[8]")).getText();
				boolean tickPresent = false;
				try {
					tickPresent = driver.findElement(By.xpath(
							"//input[@name='__RequestVerificationToken']//parent::tbody//tr[" + j + "]//td[6]/i"))
							.isDisplayed();
				} catch (Exception e) {

					e.printStackTrace();
				}
				Thread.sleep(3000);
				if (TextDelete.contains("Delete Profile") & tickPresent) {
					Thread.sleep(3000);
					driver.findElement(By.xpath("//tr[" + j + "]//td[7]")).click();
					break OuterLoop;

				}

			}
			driver.navigate().back();
		}

	}

	public void selectingCustomerHaving_governanceData() throws Throwable {
		List<WebElement> customersRed = driver.findElements(By.xpath("//span[@class='ChangeRequest']"));
		int NoOfCustomersRed = customersRed.size();
		System.out.println("No Of Customers are:" + NoOfCustomersRed);
	firstLoop:	for(int i=1;i<=NoOfCustomersRed;i++){
		driver.findElement(By.xpath("//span[@class='ChangeRequest']["+i+"]")).click();
		
		/*List<WebElement> UtilityRed = driver.findElements(By.xpath("//span[@class='CustomerProfileOverview ChangeRequest']/parent::*"));
		int NoOfUtilityRed = UtilityRed.size();
		for()*/
		boolean TextPresent = driver.findElement(By.xpath("//span[@class='CustomerProfileOverview ChangeRequest']/parent::*")).isDisplayed();

		Thread.sleep(3000);
		if (TextPresent) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[@class='CustomerProfileOverview ChangeRequest']/parent::*")).click();
			break firstLoop;
		}
		}
	}

	public void afterClickingAccept() {
		SoftAssert softAssertion = new SoftAssert();
		boolean presenceoftickmark = driver.findElement(tickMarkAfterClickingAcceptButton).isDisplayed();
		softAssertion.assertTrue(presenceoftickmark, "Right Tick Mark Is Not Present");
		boolean presenceofupdateButton = driver.findElement(UpdateButtonOFPurchas).isDisplayed();
		softAssertion.assertTrue(presenceofupdateButton, "Update Button  Is Not Present");
		softAssertion.assertAll();
	}

	public void verify_Upadate_Accept_RejectOptions_ArePresent() throws Throwable {
		SoftAssert softAssertion = new SoftAssert();
		selectingCustomerHaving_governanceData();
		Thread.sleep(3000);
		click(purchaseRequirementManage);
		Thread.sleep(6000);
		boolean rejButtonPresent = driver.findElement(rejectButton).isDisplayed();
		softAssertion.assertTrue(rejButtonPresent, "Reject Button is Not Present");
		boolean accepButtonPresent = driver.findElement(acceptButton).isDisplayed();
		softAssertion.assertTrue(accepButtonPresent, "Accept Button is Not Present");
		softAssertion.assertAll();
		
	}

	public void verifying_presenceOfUpdateButton_AfetrClikingAcceptButton() throws Throwable {
		selectingCustomerHaving_governanceData();
		Thread.sleep(3000);
		click(governanceManage);
		Thread.sleep(6000);
		click(acceptButton);
		String AcceptText = driver.switchTo().alert().getText();
		System.out.println(AcceptText);
		Thread.sleep(3000);
		/* driver.switchTo().alert().accept(); */
		afterClickingAccept();
	}

	public void verifying_presenceOfUpdateButton_AfetrClikingRejectButton() throws Throwable {
		selectingCustomerHaving_governanceData();
		Thread.sleep(3000);
		click(governanceManage);
		Thread.sleep(6000);
		click(rejectButton);
		Thread.sleep(3000);
		/*
		 * String RejectText=driver.switchTo().alert().getText();
		 * System.out.println(RejectText);
		 */

		afterClickingAccept();
	}

	/*
	 * public void selectingCustomerDefinedRisks(String selectManage){
	 * switch(selectManage){ case "governance": click(governanceManage);
	 * Reporter.log("Clicked on Governance Manage", true); break; case
	 * "purchase" : click(purchaseRequirementManage); Reporter.log(
	 * "Clicked on Purchase Requirement Manage", true); break; case "rolling":
	 * click(rollingCoverManage); Reporter.log("Clicked on Rolling Cover Manage"
	 * , true); break; default : System.out.println(
	 * "Enter/Select  Correct manage governance OR purchase OR rolling"); } }
	 */
	public void selectButtonsAfterClickingGovernanceMamange(String selectButton) {
		switch (selectButton) {
		case "accept":
			click(acceptButton);
			break;
		case "reject":
			click(rejectButton);
			break;
		case "update":
			click(UpdateButtonOfGovenance);
			break;
		case "cancel":
			click(cancelButtoun);
			break;
		default:
			System.out.println("Enter/Select  Correct manage accept OR reject OR update OR cancel ");
		}
	}

	public void verifyingEditTradeVolumePage() throws Throwable {
		selectingCustomerAndManageProfile();
		Thread.sleep(3000);
		click(editTradeVolumes);
		boolean supplierClipVolumesPresence = driver
				.findElement(By.xpath("//h3[contains(text(),'Supplier Clip Volumes')]")).isDisplayed();
		Assert.assertTrue(supplierClipVolumesPresence, "Not Redirected to Supplier Clip Volumes page");
		
	}

	public void verifyingEditButton_CancelButton_VoluemIsEnabledOfSupplierclipVolumes() throws Throwable {
		selectingCustomerAndManageProfile();
		Thread.sleep(3000);
		click(editTradeVolumes);
		Thread.sleep(5000);
		int NoOfRows = driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();

		System.out.println("No Of Row Present are: " + NoOfRows);

		for (int i = 1; i <= NoOfRows; i++) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td//button[text()='Edit']"))
					.click();

			boolean volumeEnabled = driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td[3]"))
					.isEnabled();

			boolean cancelButtonDisplyed = driver
					.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td//button[text()='Cancel']"))
					.isDisplayed();

			boolean saveButtonDisplyed = driver
					.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td//button[text()='Save']"))
					.isDisplayed();

			Assert.assertTrue(volumeEnabled, "Volume is not Enabled");
			Assert.assertTrue(cancelButtonDisplyed, "Cancel Button is not Displyed");
			Assert.assertTrue(saveButtonDisplyed, "Save Button is not Displyed");
			
		}

	}

	public void verifyDisablityOfVolumeAfterClickingCancelButton() throws Throwable {
		selectingCustomerAndManageProfile();
		Thread.sleep(3000);
		click(editTradeVolumes);
		Thread.sleep(5000);
		int NoOfRows = driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();

		System.out.println("No Of Row Present are: " + NoOfRows);

		for (int i = 1; i <= NoOfRows; i++) {
			Thread.sleep(2000);
			boolean volumeEnabled1 = driver
					.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td[3]//span")).isEnabled();
			System.out.println("Enability" + volumeEnabled1);
			driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td//button[text()='Edit']"))
					.click();

			boolean volumeEnabled2 = driver
					.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td[3]//input")).isEnabled();
			System.out.println("Enability" + volumeEnabled2);

			Thread.sleep(2000);
			driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td//button[text()='Cancel']"))
					.click();
			Thread.sleep(3000);
			boolean volumeEnabled = driver
					.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td[3]/span")).isEnabled();
			System.out.println("Enability" + volumeEnabled);
			Assert.assertFalse(volumeEnabled, "Volume is Enabled after Clicking cancel Button");

		}
		
	}

	public void verifyDisablityOfVolumeAfterChangingVolumeandClickingCancelButton() throws Throwable {
		selectingCustomerAndManageProfile();
		Thread.sleep(3000);
		click(editTradeVolumes);
		Thread.sleep(5000);
		int NoOfRows = driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();

		System.out.println("No Of Row Present are: " + NoOfRows);

		for (int i = 1; i <= NoOfRows; i++) {
			Thread.sleep(2000);

			driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td//button[text()='Edit']"))
					.click();

			setValue(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td[3]//input"), ".70");

			Thread.sleep(5000);
			driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td//button[text()='Cancel']"))
					.click();
			Thread.sleep(3000);
			boolean volumeEnabled = driver
					.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td[3]/span")).isEnabled();
			System.out.println("Enability" + volumeEnabled);
			Assert.assertFalse(volumeEnabled, "Volume is Enabled after Clicking cancel Button");

		}
		
	}

	public void verifyValueOfVolumeAfterEnteringValidVolumeDataandClickingSaveButton() throws Throwable {
		selectingCustomerAndManageProfile();
		Thread.sleep(3000);
		click(editTradeVolumes);
		Thread.sleep(5000);
		int NoOfRows = driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();

		System.out.println("No Of Row Present are: " + NoOfRows);

		for (int i = 1; i <= NoOfRows; i++) {
			Thread.sleep(2000);

			driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td//button[text()='Edit']"))
					.click();

			String volumeData = "123.00";

			setValue(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td[3]//input"), volumeData);

			Thread.sleep(5000);
			driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td//button[text()='Save']"))
					.click();
			Thread.sleep(3000);
			String ChangedVolumeData = driver
					.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td[3]/span")).getText();
			Thread.sleep(3000);
			boolean valueChangedOrNot = ChangedVolumeData.contentEquals(volumeData);
			System.out.println(" Is Both Entered Data and Changed Data Are same -> " + "  " + valueChangedOrNot
					+ ChangedVolumeData + " " + volumeData);
			Assert.assertTrue(valueChangedOrNot,
					"Volume Data is Not Changed after Entering Valid Data and clicking Save button.");

		}
	
	}

	public void verify_Recient_Clicked_EditButton_Willbe_ShownItsActions() throws Throwable {
		selectingCustomerAndManageProfile();
		Thread.sleep(3000);
		click(editTradeVolumes);
		Thread.sleep(5000);
		int NoOfRows = driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();

		System.out.println("No Of Row Present are: " + NoOfRows);

		for (int i = 1; i <= NoOfRows; i++) {
			Thread.sleep(2000);

			driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td//button[text()='Edit']"))
					.click();

			boolean volumeEnabled = driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td[3]"))
					.isEnabled();

			boolean cancelButtonDisplyed = driver
					.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td//button[text()='Cancel']"))
					.isDisplayed();

			boolean saveButtonDisplyed = driver
					.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td//button[text()='Save']"))
					.isDisplayed();

			Assert.assertTrue(volumeEnabled, "Volume is not Enabled");
			Assert.assertTrue(cancelButtonDisplyed, "Cancel Button is not Displyed");
			Assert.assertTrue(saveButtonDisplyed, "Save Button is not Displyed");
			
			i = i + 3;
		}
		
	}

	public void verify_HomePageIfTrading_AfetrClicking_TradingLink() throws Throwable {
		selectingCustomerAndManageProfile();

		click(trading);
		Thread.sleep(6000);

		Assert.assertTrue(isElementPresent(positionWithTrades), "Position With Trades Element Is Not Present");
		Assert.assertTrue(isElementPresent(positionWithoutTrades), "Position Without Trades Element Is Not Present");
		Assert.assertTrue(isElementPresent(positionExpired), "Position Expired Element Is Not Present");
		Assert.assertTrue(isElementPresent(tradingHistory), "Trading History Element Is Not Present");
		

	}

	public void verify_HomePageIfTrad_AfetrClicking_TradLinkInTradingHomePage() throws Throwable {
		selectingCustomerAndManageProfile();

		click(trading);
		Thread.sleep(3000);
		verify_Record_a_TradPage();
	}

	public void verifyingVolumeTextBoxShouldNotAcceptAlphabets() throws Throwable {
		selectingCustomerAndManageProfile();
		Thread.sleep(3000);
		click(editTradeVolumes);
		Thread.sleep(5000);
		int NoOfRows = driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();

		System.out.println("No Of Row Present are: " + NoOfRows);

		for (int i = 1; i <= NoOfRows; i++) {
			Thread.sleep(2000);

			driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td//button[text()='Edit']"))
					.click();

			// String EntervolumeData = "ABCD";

			String EnterVolumeData = readExcelData("Sheet4", 1, 0);
			setValue(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td[3]//input"), EnterVolumeData);

			Thread.sleep(5000);
			driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td//button[text()='Save']"))
					.click();
			Thread.sleep(3000);
			String ChangedVolumeData = driver
					.findElement(By.xpath("//table[@class='table']//tbody//tr[" + i + "]//td[3]/span")).getText();
			Thread.sleep(3000);
			boolean valueChangedOrNot = ChangedVolumeData.contentEquals(EnterVolumeData);
			System.out.println(" Is Both Entered Data and Changed Data Are same -> " + "  " + valueChangedOrNot
					+ ChangedVolumeData + " " + EnterVolumeData);
			Assert.assertFalse(valueChangedOrNot,
					"Volume Data is changed  after Entering inValid Data (String ABCD) and clicking Save button.");

		}
		
	}

	public void verify_Record_a_TradPage() throws Throwable {
		int NoOFRows = driver.findElements(By.xpath("//table[@id='trading-table']//tbody//tr")).size();

		tradeLoop: for (int i = 1; i <= NoOFRows; i++) {
			driver.findElement(By.xpath("//table[@id='trading-table']//tbody//tr[" + i + "]//td[8]")).click();// clicking
			boolean buyButton = isElementPresent(buy); // on
			boolean selButton = isElementPresent(sell); // trade // trade
			boolean UnitPrice = isElementPresent(unitPrice); // Home // button
			boolean tdpPresence = isElementPresent(tpd); // page // at
			Assert.assertTrue(buyButton, "Buy Button Is Not Present");
			Assert.assertTrue(selButton, "Sell Button Is Not Present");
			Assert.assertTrue(UnitPrice, "UnitPrice Button Is Not Present");
			Assert.assertTrue(tdpPresence, "TDP Button Is Not Present");
			
			driver.navigate().back();
			click(trading);
			Thread.sleep(2000);

		}
	}
}
