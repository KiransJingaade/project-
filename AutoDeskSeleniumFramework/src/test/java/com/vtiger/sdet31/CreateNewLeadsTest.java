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
/**
 * 
 * @author Kiran S
 *
 */

@Listeners(com.crm.autodesk.genricutility.ListenerImplentClass.class)

public class CreateNewLeadsTest extends BaseClass {
   @Test
	public  void createNewLeads() throws Throwable {
		

		
		HomePage homepage = new HomePage(driver);
		homepage.clickOnLeadsLink();
        
		/* click on create leads icon*/
		CreateLeadsIconPage createLeadsiconPage = new CreateLeadsIconPage(driver);
		createLeadsiconPage.createLeadsIcon();

		/*verify create new leads page*/
		CreateLeadsPage createleadspage = new CreateLeadsPage(driver);
		
		wutil.waitForElementToBeClickable(driver, createleadspage.getSuccessImage());
		String SuccessMessage = createleadspage.actualLeadsPage();
		
		
		String ExpectedLeadspage="Creating New Lead";
		Assert.assertEquals(ExpectedLeadspage.contains(SuccessMessage), true);
//		if(ExpectedLeadspage.contains(SuccessMessage))
//		{
//			System.out.println("pass:creating new leads Page is displayed");
//		}else {
//			System.out.println("fail:creating new leads Page not displayed");
//		}
		
		createleadspage.clickOnSaveButton();
		
		/*verify the alert message*/
		String expectedalertpopup="Last Name cannot be empty";
		 String actualalertpopup = createleadspage.actualAlertMessage(expectedalertpopup);
		
		 Assert.assertEquals(actualalertpopup.contains(expectedalertpopup), true);
//		 if(actualalertpopup.equals(expectedalertpopup)) {
//			 System.out.println("pass:"+actualalertpopup+"is displayed");
//		 }else {
//			 System.out.println("fail:"+actualalertpopup+"is not displayed");
//		 }
		 
		 createleadspage.switchToAlertWindowAndAccept(driver);
		
		
	}
	}

