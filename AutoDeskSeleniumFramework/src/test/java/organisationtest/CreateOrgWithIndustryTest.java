package organisationtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.EncryptedDocumentException;
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

public class CreateOrgWithIndustryTest {

	public static void main(String[] args) throws Throwable {
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();

		System.out.println("================================================");

		String orgName =eLib.getDataFromExcel("Sheet1", 1, 0);
		String lastName = eLib.getDataFromExcel("Sheet1", 1, 3);


		System.out.println("organization name is "+orgName);

		/* read common data from Properties File*/		
		String browser=fLib.getPropertyKeyValue("browser");
		String url = fLib.getPropertyKeyValue("url");
		String username = fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("password");

		/* launch the Browser */ 
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("launched browser is "+ browser);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("launched browser is "+ browser);
		}else {
			System.out.println("specify a valid browser");
		}


		wLib.maximizeWindow(driver);

		driver.get(url);

		wLib.waitforPageLoad(driver);

		//  display loginpage
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);

		//click on organization link
		HomePage homepage=new HomePage(driver);
		homepage.clickOnOrganizationLink();

		//click on "+" image
		OrganizationsPage oranisationimage = new OrganizationsPage(driver);
		oranisationimage.clickOnCreateOrgImg();


		//get random number
		int ranNum = jLib.getRandomnumber();
		String orgNames = orgName+ranNum;

		CreateNewOrganizationPage createneworg = new CreateNewOrganizationPage(driver);
		createneworg.createNewOrg(orgNames);
		createneworg.selectHealthcare();
		createneworg.SaveOrgButton(driver);


		//wLib.waitForElementToBeClickable(driver, null);

		OrganizationInfo orginfo = new OrganizationInfo(driver);
		String successorgname = orginfo.ActualOrgName();

		if(successorgname.contains(orgNames)) {
			System.out.println(orgNames+" is correct=PASS");
		}else {
			System.out.println(orgNames+" is not correct=FAIL");
		}
		
		homepage.logOut(driver);
		
		driver.quit();
	}
}
