package com.vtiger.sdet31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.genricutility.BaseClass;
import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.FileUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.autodesk.genricutility.WebDriverUtility;
import com.vtiger.comcast.pomrepository.CreateNewOrganizationPage;
import com.vtiger.comcast.pomrepository.HomePage;
import com.vtiger.comcast.pomrepository.LoginPage;
import com.vtiger.comcast.pomrepository.OrganizationInfo;
import com.vtiger.comcast.pomrepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.crm.autodesk.genricutility.ListenerImplentClass.class)

public class CreateOrganizationTest extends BaseClass {

	@Test(groups="SmokeTest")
	public  void CreateOrg() throws Throwable {
		
		
		String orgName=eutil.getDataFromExcel("Sheet1", 1, 0)+jutil.getRandomnumber();
		
		HomePage homepage = new HomePage(driver);
		homepage.clickOnOrganizationLink();
		
		OrganizationsPage organizationspage = new OrganizationsPage(driver);
		organizationspage.clickOnCreateOrgImg();
		
		CreateNewOrganizationPage createneworgpage = new CreateNewOrganizationPage(driver);
		createneworgpage.createNewOrg(orgName);
		createneworgpage.SaveOrgButton(driver);
		
		
		OrganizationInfo OrgInfo = new OrganizationInfo(driver);
		wutil.waitForElementToBeClickable(driver, OrgInfo.getSuccessImage());
		
		String SuccessMessage = OrgInfo.ActualOrgName();
       
	    Assert.assertEquals(SuccessMessage.contains(orgName), true);	
	//	if(SuccessMessage.contains(orgName)) {
//			System.out.println("pass:"+orgName+" name is saved successfully");
//		}else {
//			System.out.println("fail:"+orgName+" name is not saved ");
//
//		}
	}
}
