package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.FileUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.autodesk.genricutility.WebDriverUtility;
import com.vtiger.comcast.pomrepository.HomePage;
import com.vtiger.comcast.pomrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LastChckbox {

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

		WebDriverWait wait=new WebDriverWait(driver,(10));
		
		wLib.waitforPageLoad(driver);

		//  display loginpage
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);

		//click on organization link
		HomePage homepage=new HomePage(driver);
		homepage.clickOnOrganizationLink();
		
	

		List<WebElement> autosuggestionlist = driver.findElements(By.xpath("//input[@name='selected_id']"));
		
		wait.until(ExpectedConditions.visibilityOfAllElements(autosuggestionlist));
		
		int lastindex=autosuggestionlist.size()-1;
		
		autosuggestionlist.get(lastindex).click();
		
		
	}

}
