package com.oem.framework.pages;

import java.util.List;

//import org.assertj.core.api.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class FlexProfileAdminPage extends AdminDashboardPage{

	public boolean isComapanyPresent() throws Throwable{
		By clickCompany= By.xpath("//h1[contains(text(),'"+readExcelData("sheet5",3,1)+"')]");
		boolean trueOrFals=isElementPresent(clickCompany);
		return trueOrFals;
	}

	@Override
	protected void isLoaded() throws Error {
		
		
		System.out.println("Executing isLoaded in Flexible Profile Admin Page");
		try {
			Assert.assertTrue(isComapanyPresent(), "Flexible Profile Admin Page didnt appear");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteProfile(String Utility) throws Throwable{
		FlexProfileManagerPage flex=new FlexProfileManagerPage();
		flex.logOut();
		AdminDashboardPage adminDashboardPage =new AdminDashboardPage();
		adminDashboardPage=new LoginPage().loginAsAdmin();
		Thread.sleep(3000);
		adminDashboardPage.goToflexProfileAdmin();
		By clickCompany= By.xpath("//h1[contains(text(),'"+readExcelData("sheet5",3,1)+"')]");
		click(clickCompany);
		switch(Utility){
		case "HH":
			By hhProfileDelete=By.xpath("//span[contains(text(),'   Half Hourly Electric Profile')]/../following-sibling::td[7]/a[@style='display:block'][text()='Delete Profile']");
			List<WebElement> hhprofiles =driver.findElements(hhProfileDelete);
			int noOfHHProfiles=hhprofiles.size();
			for(int i=1;i<noOfHHProfiles;i++){
				click(hhProfileDelete);
			}
			adminDashboardPage.logOut();
			CustomerDashboardPage customerDashboardPage1 =new CustomerDashboardPage();
			customerDashboardPage1 = new LoginPage().login();
			customerDashboardPage1.goToFlexibleProfileManager();
			FlexProfileManagerPage flexproMang=new FlexProfileManagerPage();
			By setUpProfileAtProfileStatus = By.xpath("//tr//td[4]//a[@class='btn btn-info btn-block']");
			flexproMang.click_hhUtilityLink();
			org.testng.Assert.assertTrue(isElementPresent(setUpProfileAtProfileStatus), "SetUpProfile Element is not Not Present Even After Deleting Profiles");
				System.out.println("SetUpProfile Element is Present");
			
			
			break;
		case "nHH":
			By nhhProfileDelete=By.xpath("//span[contains(text(),'Non Half Hourly Electric Profile')]/../following-sibling::td[7]/a[@style='display:block'][text()='Delete Profile']");
			List<WebElement> nhhprofiles =driver.findElements(nhhProfileDelete);
			int noOfnHHProfiles=nhhprofiles.size();
			for(int i=1;i<noOfnHHProfiles;i++){
				click(nhhProfileDelete);
			}
			adminDashboardPage.logOut();
			//CustomerDashboardPage customerDashboardPage =new CustomerDashboardPage();
			customerDashboardPage1 = new LoginPage().login();
			customerDashboardPage1.goToFlexibleProfileManager();
			FlexProfileManagerPage flexproMang1=new FlexProfileManagerPage();
			By setUpProfileAtProfileStatus1 = By.xpath("//tr//td[4]//a[@class='btn btn-info btn-block']");
			flexproMang1.click_nhhUtilityLink();
			org.testng.Assert.assertTrue(isElementPresent(setUpProfileAtProfileStatus1), "SetUpProfile Element is not Not Present Even After Deleting Profiles");
				System.out.println("SetUpProfile Element is Present");
			break;
			
		case "Gas":
			By gasProfileDelete=By.xpath("//span[contains(text(),'Gas Profile')]/../following-sibling::td[7]/a[@style='display:block'][text()='Delete Profile']");
			List<WebElement> gasprofiles =driver.findElements(gasProfileDelete);
			int noOfgasProfiles=gasprofiles.size();
			for(int i=1;i<noOfgasProfiles;i++){
				click(gasProfileDelete);
			}
			adminDashboardPage.logOut();
			//CustomerDashboardPage customerDashboardPage =new CustomerDashboardPage();
			customerDashboardPage1 = new LoginPage().login();
			customerDashboardPage1.goToFlexibleProfileManager();
			FlexProfileManagerPage flexproMang2=new FlexProfileManagerPage();
			By setUpProfileAtProfileStatus2 = By.xpath("//tr//td[4]//a[@class='btn btn-info btn-block']");
			flexproMang2.click_gasUtilityLink();
			org.testng.Assert.assertTrue(isElementPresent(setUpProfileAtProfileStatus2), "SetUpProfile Element is not Not Present Even After Deleting Profiles");
				System.out.println("SetUpProfile Element is Present");
			break;
			
		default:
			System.out.println("Please Enter Correct Utility ie:HH,nHH,Gas");
		}
		
	}
	
}
