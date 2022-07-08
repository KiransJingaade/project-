package campaigntest;

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

public class Campaign {

	public static void main(String[] args) throws Throwable {
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();

		System.out.println("================================================");

		// get random number
		int ranNum = jLib.getRandomnumber();

		String orgName = eLib.getDataFromExcel("Sheet1", 1, 0) + ranNum;
		String lastName = eLib.getDataFromExcel("Sheet1", 1, 3) + ranNum;
		String productname = eLib.getDataFromExcel("Sheet1", 1, 4) + ranNum;
		String campaignName = eLib.getDataFromExcel("Sheet1", 1, 5) + ranNum;

		System.out.println("organization name is " + orgName);
		System.out.println("lastname is " + lastName);
		System.out.println("productname is " + productname);

		/* read common data from Properties File */
		String browser = fLib.getPropertyKeyValue("browser");
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
			System.out.println("launched browser is " + browser);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("launched browser is " + browser);
		} else {
			System.out.println("specify a valid browser");
		}

		wLib.maximizeWindow(driver);

		driver.get(url);

		wLib.waitforPageLoad(driver);

		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		// click on organization link
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		// click on "+" image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		// enter orgName

		String orgNames = orgName + ranNum;

		driver.findElement(By.name("accountname")).sendKeys(orgNames);
		driver.findElement(By.name("industry")).click();
		WebElement industry = driver.findElement(By.name("industry"));

		wLib.select(industry, "Healthcare");

		WebElement save = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));

		wLib.waitForElementToBeClickable(driver, save);

		save.click();

		String actText = driver.findElement(By.className("dvHeaderText")).getText();

		if (actText.contains(orgNames)) {
			System.out.println(orgNames + " is correct=PASS");
		} else {
			System.out.println(orgNames + " is not correct=FAIL");
		}
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();

		String parent = driver.getWindowHandle();
		wLib.switchToWindow(driver, "Accounts");

		driver.findElement(By.id("search_txt")).sendKeys(orgNames);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + orgNames + "']")).click();

		wLib.switchToWindow(driver, "Contacts");

		WebElement conSave = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		wLib.waitForElementToBeClickable(driver, conSave);
		conSave.click();

		String hdText = driver.findElement(By.className("dvHeaderText")).getText();
		if (hdText.contains(lastName)) {
			System.out.println(lastName + " is correct=PASS");
		} else
			System.out.println(lastName + " is not correct=FAIL");

		driver.findElement(By.linkText("Products")).click();

		driver.findElement(By.cssSelector("img[title='Create Product...']")).click();

		driver.findElement(By.name("productname")).sendKeys(productname);

		WebElement Savebutton = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		wLib.waitForElementToBeClickable(driver, Savebutton);
		Savebutton.click();

		String lvText = driver.findElement(By.className("lvtHeaderText")).getText();
		if (lvText.contains(productname)) {
			System.out.println(productname + " is correct=PASS");
		} else
			System.out.println(productname + " is not correct=FAIL");

		
		
		
		WebElement more = driver.findElement(By.linkText("More"));
		wLib.mouseOverOnElement(driver, more);

		driver.findElement(By.name("Campaigns")).click();

		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);

		WebElement campaignSave = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		wLib.waitForElementToBeClickable(driver, campaignSave);
		campaignSave.click();

		String hdTxt = driver.findElement(By.className("dvHeaderText")).getText();
		if (hdTxt.contains(campaignName)) {
			System.out.println(campaignName + " is correct=PASS");
		} else {
			System.out.println(campaignName + " is not correct=FAIL");
		}

		
		  WebElement logout =
		  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		  
		  wLib.mouseOverOnElement(driver, logout);
		 
		 logout.click();
		 
		  driver.quit();
		 
	}

}
