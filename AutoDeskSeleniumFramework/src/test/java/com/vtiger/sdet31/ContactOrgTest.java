package com.vtiger.sdet31;

import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.genricutility.BaseClass;
import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.FileUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.autodesk.genricutility.WebDriverUtility;
import com.vtiger.comcast.pomrepository.CreateNewContactpage;
import com.vtiger.comcast.pomrepository.CreateNewOrganizationPage;
import com.vtiger.comcast.pomrepository.HomePage;
import com.vtiger.comcast.pomrepository.LoginPage;
import com.vtiger.comcast.pomrepository.OrganizationInfo;
import com.vtiger.comcast.pomrepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.crm.autodesk.genricutility.ListenerImplentClass.class)

public class ContactOrgTest extends BaseClass{

    @Test
	public  void contactOrg() throws Throwable {
		
     	String orgName =eutil.getDataFromExcel("Sheet1", 1, 0);
		String lastName = eutil.getDataFromExcel("Sheet1", 1, 3);

		System.out.println("organization name is "+orgName);

			
		//click on organization link
		HomePage homepage=new HomePage(driver);
		homepage.clickOnOrganizationLink();

		//click on "+" image
		OrganizationsPage oranisationimage = new OrganizationsPage(driver);
		oranisationimage.clickOnCreateOrgImg();

		String orgNames = orgName+jutil.getRandomnumber();

		CreateNewOrganizationPage createneworg = new CreateNewOrganizationPage(driver);
		createneworg.createNewOrg(orgNames);
		createneworg.selectHealthcare();
		createneworg.SaveOrgButton(driver);


		//wLib.waitForElementToBeClickable(driver, null);

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
		
	}
}
