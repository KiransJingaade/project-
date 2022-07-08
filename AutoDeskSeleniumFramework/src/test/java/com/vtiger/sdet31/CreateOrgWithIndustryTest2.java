package com.vtiger.sdet31;

import static org.testng.Assert.assertEquals;

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

public class CreateOrgWithIndustryTest2 extends BaseClass{

	@Test
	public void createOrganisation() throws Throwable {
    	
		
		String orgNames =eutil.getDataFromExcel("Sheet1", 1, 0)+jutil.getRandomnumber();
		String lastName = eutil.getDataFromExcel("Sheet1", 1, 3)+jutil.getRandomnumber();


		System.out.println("organization name is "+orgNames);

		//click on organization link
		HomePage homepage=new HomePage(driver);
		homepage.clickOnOrganizationLink();

		//click on "+" image
		OrganizationsPage oranisationimage = new OrganizationsPage(driver);
		oranisationimage.clickOnCreateOrgImg();


		CreateNewOrganizationPage createneworg = new CreateNewOrganizationPage(driver);
		createneworg.createNewOrg(orgNames);
		createneworg.selectHealthcare();
		createneworg.SaveOrgButton(driver);

		OrganizationInfo orginfo = new OrganizationInfo(driver);
		String successorgname = orginfo.ActualOrgName();

		Assert.assertEquals(successorgname.contains(orgNames), true);
//		if(successorgname.contains(orgNames)) {
//			System.out.println(orgNames+" is correct=PASS");
//		}else {
//			System.out.println(orgNames+" is not correct=FAIL");
//		}	
	}
}
