package com.vtiger.sdet31;

import static org.testng.Assert.assertEquals;

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
import com.vtiger.comcast.pomrepository.CreateNewContactpage;
import com.vtiger.comcast.pomrepository.CreateNewOrganizationPage;
import com.vtiger.comcast.pomrepository.CreateProductPage;
import com.vtiger.comcast.pomrepository.HomePage;
import com.vtiger.comcast.pomrepository.LoginPage;
import com.vtiger.comcast.pomrepository.OrganizationInfo;
import com.vtiger.comcast.pomrepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.crm.autodesk.genricutility.ListenerImplentClass.class)

public class ProductsTest extends BaseClass {

	@Test
	public  void product() throws Throwable {
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();

		System.out.println("================================================");

		//get random number
		int ranNum = jLib.getRandomnumber();


		String orgName =eLib.getDataFromExcel("Sheet1", 1, 0)+ranNum;
		String lastName = eLib.getDataFromExcel("Sheet1", 1, 3)+ranNum;
		String productname = eLib.getDataFromExcel("Sheet1", 1, 4)+ranNum;



		
		//click on organization link
		HomePage homepage=new HomePage(driver);
		homepage.clickOnOrganizationLink();

		//click on "+" image
		OrganizationsPage oranisationimage = new OrganizationsPage(driver);
		oranisationimage.clickOnCreateOrgImg();


		//get random number
		String orgNames = orgName+ranNum;

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
		if(contactinfo.contains(lastName)) {
			System.out.println(lastName+" is correct=PASS");
		}else {
			System.out.println(lastName+" is not correct=FAIL");
		}
		
		/*products module*/
		CreateProductPage createproductpg = new CreateProductPage(driver);
		createproductpg.clickOnProducts();
		createproductpg.enterProductname(productname);
		createproductpg.clickOnSaveButton(driver);
		
		String productsinfo = createproductpg.ActualProductName();
		
		Assert.assertEquals(productsinfo.contains(productname), true);
//		if(productsinfo.contains(productname)) {
//			System.out.println(productname+"is correct=pass");
//		}else {
//			System.out.println(productname+"is correct=fail");
//
//		}
		
	}
}
