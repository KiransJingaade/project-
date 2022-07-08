package sampletester;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fin=new FileInputStream("./src/main/resources/testdata/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sheet = wb.getSheet("Sheet1");
		int rowcount = sheet.getLastRowNum();
		int columncount = sheet.getRow(0).getLastCellNum();

		System.out.println("total number of rows="+rowcount);
		System.out.println("total number of column="+columncount);

		for (int i = 0; i <= rowcount; i++) {
			for (int j = 0; j < columncount; j++) {
				Row row = sheet.getRow(i);
				Cell cell = row.getCell(j);
				String data = cell.getStringCellValue();
				System.out.print(data+"   ");
			}
			System.out.println();
		}
		String orgname = sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println("organization name is "+orgname);

		System.out.println("=========================================");

		FileInputStream fis = new FileInputStream(".//src/main/resources/properties/commondata.properties");
		Properties properties =new Properties();
		properties.load(fis);
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);


		WebDriver driver = null;
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("launched browser is="+browser);
		}else if(browser.equalsIgnoreCase("fireifox")) {
			driver=new FirefoxDriver();
			System.out.println("launched browser is="+browser);
		}else {
			System.out.println("specify a valid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

		WebDriverWait wait=new WebDriverWait(driver,10);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();


		Random r=new Random();
		int randomnum = r.nextInt(1000);
		orgname=orgname+randomnum;
		driver.findElement(By.name("accountname")).sendKeys(orgname);

		WebElement industry = driver.findElement(By.name("industry"));
		Select s=new Select(industry);
		s.selectByVisibleText("Healthcare");
		WebElement save = driver.findElement(By.name("button"));
		save.click();

		wait.until(ExpectedConditions.invisibilityOf(save));
		//Thread.sleep(5000);

		WebElement admin = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(admin).perform();

		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
