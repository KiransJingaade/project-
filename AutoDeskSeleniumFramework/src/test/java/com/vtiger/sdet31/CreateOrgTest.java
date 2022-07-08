package com.vtiger.sdet31;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.TreeSet;
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

import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateOrgTest {

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

		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);

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


		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		//click on organization link
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Leads']")).click();
		//click on "+" image
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		Thread.sleep(5000);

		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[@class='lvtColData']/td[3]"));
		
		Thread.sleep(5000);
		
		ArrayList<String> actualorder = new ArrayList<String>();
		for(WebElement l:list)
		{
			System.out.println(l.getText());
			System.out.println(actualorder.size());
		}
//		ArrayList<String> expectedorder = new ArrayList<String>(actualorder);
//		Collections.sort(expectedorder);
//		System.out.println("expectedorder="+expectedorder);
//		System.out.println("actualorder="+actualorder);
		//table[@class='lvt small']/tbody/tr[@class='lvtColData']/td[3]
		
		//enter orgName


		//get random number
		/*int ranNum = jLib.getRandomnumber();
		String orgNames = orgName+ranNum;

		driver.findElement(By.name("accountname")).sendKeys(orgNames);*/
	}
}
