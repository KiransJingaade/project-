package com.crm.autodesk.genricutility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlTest;

import com.vtiger.comcast.pomrepository.HomePage;
import com.vtiger.comcast.pomrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends DatabaseUtility {

	public  WebDriver driver=null;
	public FileUtility futil=new FileUtility();
	public ExcelUtility  eutil=new ExcelUtility();
	public JavaUtility jutil=new JavaUtility();
    public WebDriverUtility wutil=new WebDriverUtility();
    public  static WebDriver sDriver;
	
    @BeforeSuite
	public void bs() {
		System.out.println("establish jdbc connection");
	}

	@BeforeTest
	public void bt() {
		System.out.println("parallel execution");
	}

	@Parameters("browser")
	@BeforeClass 
	public void bc() throws Throwable {
	
		String browsername = futil.getPropertyKeyValue("browser");
		String url = futil.getPropertyKeyValue("url");

		System.out.println("broswername");
		System.out.println("url");
		
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browsername.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else if(browsername.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}else {
			throw new Exception("browser is not compatible");
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(IPathConstants.ITO, TimeUnit.SECONDS);
		sDriver=driver;
	}

	@BeforeMethod 
	public void bm() throws Throwable {
		String username = futil.getPropertyKeyValue("username");
		String password = futil.getPropertyKeyValue("password");

		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		System.out.println("username");
		System.out.println("password");

	}

	@AfterMethod
	public void am() {
		HomePage homepage=new HomePage(driver);
		homepage.logOut(driver);
	}

	@AfterClass
	public void ac() {
		driver.quit();
	}

	@AfterTest
	public void at() {
		System.out.println("close parallel execution");
	}

	@AfterSuite
	public void as() {
		System.out.println("close database connection");
	}
}
