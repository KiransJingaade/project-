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
import com.vtiger.comcast.leadsrepository.CreateLeadsIconPage;
import com.vtiger.comcast.leadsrepository.CreateLeadsPage;
import com.vtiger.comcast.leadsrepository.HomePage;
import com.vtiger.comcast.leadsrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.crm.autodesk.genricutility.ListenerImplentClass.class)

public class CreateLeadsValidInput extends BaseClass {
@Test
	public  void createLeadValid(String[] args) throws Throwable {

		String Expectedurl="Login";
		String Actualurl=driver.getCurrentUrl();

		/*login page verification*/
		Assert.assertEquals(Actualurl.contains(Expectedurl), true);
//		if(Actualurl.contains(Expectedurl)) {
//			System.out.println("pass:login page is displaying");
//		}else {
//			System.out.println("fail:login page is not displaying");
//		}

		HomePage homepage = new HomePage(driver);
		homepage.clickOnLeadsLink();

		/*home page verification*/
		String ExpectedUrl="Home";
		String actualUrl=driver.getCurrentUrl();
	
		Assert.assertEquals(actualUrl.contains(ExpectedUrl), true);
//		if(actualUrl.contains(ExpectedUrl)) {
//			System.out.println("pass:Home Page is displayed");
//		}else {
//			System.out.println("fail:Home Page is not displayed");


			/* click on create leads icon*/
			CreateLeadsIconPage createLeadsiconPage = new CreateLeadsIconPage(driver);
			createLeadsiconPage.createLeadsIcon();

			/*verify create new leads page*/
			CreateLeadsPage createleadspage = new CreateLeadsPage(driver);

			wutil.waitForElementToBeClickable(driver, createleadspage.getSuccessImage());
			String SuccessMessage = createleadspage.actualLeadsPage();


			String ExpectedLeadspage="Creating New Lead";
			
			Assert.assertEquals(SuccessMessage.contains(ExpectedLeadspage), true);
			
//			if(ExpectedLeadspage.contains(SuccessMessage))
//			{
//				System.out.println("pass:creating new leads Page is displayed");
//			}else {
//				System.out.println("fail:creating new leads Page not displayed");
//			}

			String firstnametextfield=eutil.getDataFromExcel("Sheet1", 1, 3)+jutil.getRandomnumber();
			String companytitle=eutil.getDataFromExcel("Sheet1", 1, 7)+jutil.getRandomnumber();
			String leadsourceselect=eutil.getDataFromExcel("Sheet1", 1, 8);
			String selectindustry=eutil.getDataFromExcel("Sheet1", 1, 9);
			String leadstatus=eutil.getDataFromExcel("Sheet1", 1, 10);
			String rating=eutil.getDataFromExcel("Sheet1", 1, 11);
			String annualrevenue=eutil.getDataFromExcel("Sheet1", 1, 12);
			String NumberOfEmployees=eutil.getDataFromExcel("Sheet1", 1, 13);
			String SecondaryMail=eutil.getDataFromExcel("Sheet1", 1, 14);
			String PhoneNumber=eutil.getDataFromExcel("Sheet1", 1, 15);
			String MobileNumber=eutil.getDataFromExcel("Sheet1", 1, 16);
			String FaxNumber=eutil.getDataFromExcel("Sheet1", 1, 17);
			String EmailId=eutil.getDataFromExcel("Sheet1", 1, 18);
			String WebsiteName=eutil.getDataFromExcel("Sheet1", 1, 19);

			String StreetName=eutil.getDataFromExcel("Sheet1", 1, 20);
			String PostCode=eutil.getDataFromExcel("Sheet1", 1, 21);
	
			String CountryName=eutil.getDataFromExcel("Sheet1", 1, 22);
			String PoBoxNumber=eutil.getDataFromExcel("Sheet1", 1, 23);
			String CityName=eutil.getDataFromExcel("Sheet1", 1, 24);
			String StateName=eutil.getDataFromExcel("Sheet1", 1, 25);

			String DescriptionText=eutil.getDataFromExcel("Sheet1", 1, 26);


			createleadspage.TextField(firstnametextfield, companytitle);
			createleadspage.AnnualRevenue(annualrevenue);
			createleadspage.NoOfEmployees(NumberOfEmployees);
			createleadspage.SecondaryEmail(SecondaryMail);
			createleadspage.Phone(PhoneNumber);
			createleadspage.Mobile(MobileNumber);
			createleadspage.Fax(FaxNumber);
			createleadspage.Website(WebsiteName);
			createleadspage.Email(EmailId);
			createleadspage.Street(StreetName);
			createleadspage.Code(PostCode);
			createleadspage.Country(CountryName);
			createleadspage.PoBox(PoBoxNumber);
			createleadspage.City(CityName);
			createleadspage.State(StateName);
			createleadspage.Description(DescriptionText);
			
			createleadspage.clickOnSaveButton();

			/*verify the alert message*/
			String expectedalertpopup="Last Name cannot be empty";
			String actualalertpopup = createleadspage.actualAlertMessage(expectedalertpopup);

			Assert.assertEquals(actualalertpopup.contains(expectedalertpopup), true);
			
//			if(actualalertpopup.equals(expectedalertpopup)) {
//				System.out.println("pass:"+actualalertpopup+"is displayed");
//			}else {
//				System.out.println("fail:"+actualalertpopup+"is not displayed");
//			}
			
			createleadspage.switchToAlertWindowAndAccept(driver);
			
			
		}
	}

