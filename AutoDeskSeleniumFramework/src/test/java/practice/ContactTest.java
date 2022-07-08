package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactTest {

	@DataProvider
	public Object[][]  getdata() {
		Object[][] objarray=new Object[5][2];
		
		objarray[0][0]="Kiran";
		objarray[0][1]="8660624605";
		
		objarray[1][0]="sagar";
		objarray[1][1]="8862460521";
		
		objarray[2][0]="abhi";
		objarray[2][1]="8998789788";
		
		objarray[3][0]="punith";
		objarray[3][1]="7867867677";
		
		objarray[4][0]="harsha";
		objarray[4][1]="5488767867";
		
		return objarray;
		
	}
	@Test(dataProvider="getdata")
	public void multipledata(String lastname,String mobilenum) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://localhost:8888/");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.id("mobile")).sendKeys(mobilenum);
	}
	
	@Test(dataProvider="getdata")
	public void multipletestdata(String lastname,String mobilenum) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://localhost:8888/");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.id("mobile")).sendKeys(mobilenum);
	

}
}