package practice;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.FileUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.autodesk.genricutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Organisation {

	public static void main(String[] args) throws Throwable  {
		ExcelUtility eLib=new ExcelUtility();

		//launch browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebDriverWait wait=new WebDriverWait(driver,20);

		driver.get("http://localhost:8888/");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();

		//click on organisation link
		WebElement orglinkclick=driver.findElement(By.linkText("Organizations"));

		orglinkclick.click();



		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();


		Random random=new Random();
		int randomnum=random.nextInt(1000);

		//fetch data from excel
		String orgname=eLib.getDataFromExcel("Sheet1", 2, 0)+randomnum;

		//enter organisation name
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		//click on save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		WebElement actualorgname = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));

		String orgtext = actualorgname.getText();

		//return to organisation link
		wait.until(ExpectedConditions.stalenessOf(orglinkclick));

		driver.findElement(By.linkText("Organizations")).click();

		List<WebElement> organisationslist = driver.findElements(By.xpath("//a[@title='Organizations']"));

		System.out.println("total links="+organisationslist.size());

		//		for(;;) {
		//		       try {
		//		    	   if(organisationslist.contains(orgname)) {}
		//		    	      driver.findElement(By.xpath("//span[@class='dvHeaderText']")).click();
		//		    	      break;
		//		       }catch(Exception e) {
		//		    	   driver.findElement(By.xpath("(//img[@src='themes/images/next.gif'])[2]")).click();		   
		//		    	   }     
		//			}
		for(;;) {
			try
			{
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[text()='"+orgname+"'"));
				break;
			}
			catch(Exception e) {
				
				WebElement nextbtn = driver.findElement(By.xpath("//img[@src='themes/images/next.gif']"));
                
				wait.until(ExpectedConditions.visibilityOf(nextbtn));
				nextbtn.click();
			}
		}
		driver.findElement(By.xpath("//input[@title='Delete [Alt+D]'")).click();
		driver.switchTo().alert().accept();
		WebElement move = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG'"));
		wait.until(ExpectedConditions.elementToBeClickable(move));

		Actions actions=new Actions(driver);
		actions.moveToElement(move).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}    


