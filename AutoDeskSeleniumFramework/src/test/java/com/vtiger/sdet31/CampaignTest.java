package com.vtiger.sdet31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.vtiger.comcast.pomrepository.CreateCampaignpage;
import com.vtiger.comcast.pomrepository.CreateNewContactpage;
import com.vtiger.comcast.pomrepository.CreateNewOrganizationPage;
import com.vtiger.comcast.pomrepository.CreateProductPage;
import com.vtiger.comcast.pomrepository.HomePage;
import com.vtiger.comcast.pomrepository.LoginPage;
import com.vtiger.comcast.pomrepository.OrganizationInfo;
import com.vtiger.comcast.pomrepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.crm.autodesk.genricutility.ListenerImplentClass.class)
public class CampaignTest extends BaseClass {

	
	public  void campaign() throws Throwable {
		
		String orgName = eutil.getDataFromExcel("Sheet1", 1, 0) + jutil.getRandomnumber();
		String lastName = eutil.getDataFromExcel("Sheet1", 1, 3) + jutil.getRandomnumber();
		String productname = eutil.getDataFromExcel("Sheet1", 1, 4) +jutil.getRandomnumber();
		String campaignName = eutil.getDataFromExcel("Sheet1", 1, 5) + jutil.getRandomnumber();

		
		
		//click on organization link
		HomePage homepage=new HomePage(driver);
		homepage.clickOnOrganizationLink();

		//click on "+" image
		OrganizationsPage oranisationimage = new OrganizationsPage(driver);
		oranisationimage.clickOnCreateOrgImg();


		//get random number
		String orgNames = orgName+ jutil.getRandomnumber();

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
		

		CreateNewContactpage createcontactpage = new CreateNewContactpage(driver);
		createcontactpage.clickOnContacts(driver);
		createcontactpage.enterLastName(lastName);
		createcontactpage.saveContactButton();
		
		String contactinfo = createcontactpage.ActualContactName();
		
		Assert.assertEquals(contactinfo.contains(lastName), true);
//		if(contactinfo.contains(lastName)) {
//			System.out.println(lastName+" is correct=PASS");
//		}else {
//			System.out.println(lastName+" is not correct=FAIL");
//		}
//		
		/*products module*/
		CreateProductPage createproductpg = new CreateProductPage(driver);
		createproductpg.clickOnProducts();
		createproductpg.enterProductname(productname);
		createproductpg.clickOnSaveButton(driver);
		
		String productsinfo = createproductpg.ActualProductName();
		
//		if(productsinfo.contains(productname)) {
//			System.out.println(productname+"is correct=pass");
//		}else {
//			System.out.println(productname+"is correct=fail");
//
//		}
		Assert.assertEquals(productsinfo.contains(productname), true);
		
		homepage.clickOnMoreLink(driver);
		
		
		CreateCampaignpage createcampaignpage = new CreateCampaignpage(driver);
		createcampaignpage.clickOnCampaignLink();
		createcampaignpage.enterCampaignName(campaignName);
		createcampaignpage.clickOnSaveButton(driver);
		
		String campaigninfo = createcampaignpage.ActualCampaignName();
		
		Assert.assertEquals(campaigninfo.contains(campaignName), true);
//		if (campaigninfo.contains(campaignName)) {
//			System.out.println(campaignName + " is correct=PASS");
//		} else {
//			System.out.println(campaignName + " is not correct=FAIL");
//		}
		

	}

}
