package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoIbibo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,10);

		driver.get("https://www.goibibo.com/");

		driver.findElement(By.linkText("Hotels")).click();

		driver.findElement(By.name("CountryType")).click();


		driver.findElement(By.xpath("//div[text()='Check-in']")).click();


		driver.findElement(By.xpath("//span[text()='31']")).click();

		driver.findElement(By.xpath("//div[@data-testid='openCheckoutCalendar']")).click();

		driver.findElement(By.xpath("//span[text()='April 2022']/ancestor::div[@class='dcalendar-newstyles__CalenderMonthContainer-sc-1i003by-2 kCupBq']/descendant::span[text()='1']")).click();

		driver.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//p[text()='Mumbai']")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//label[text()='GUEST & ROOMS']/following::input[@type='text']")).click();

		int pluscount=2;

		for (int i = 0; i <=pluscount; i++) {
			driver.findElement(By.xpath("//span[text()='Children']/following::span[text()='+']")).click();
		}


		WebElement selectage1 = driver.findElement(By.xpath("//h4[text()='Select']"));
		driver.findElement(By.xpath("//li[text()='1']")).click();
	
		WebElement selectage2 = driver.findElement(By.xpath("(//span[text()='Child ']/following::h4[text()='Select'])[2]"));
		driver.findElement(By.xpath("//li[text()='2'")).click();

		WebElement selectage3 = driver.findElement(By.xpath("(//span[text()='Child ']/following::h4[text()='Select'])[3]"));
		driver.findElement(By.xpath("//li[text()='4'")).click();

		driver.findElement(By.xpath("//button[text()='UPDATE SEARCH']")).click();
		
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		
		List<WebElement> hotellist = driver.findElements(By.xpath("//h4[@itemprop='name']"));
		for (WebElement ele : hotellist) {
			System.out.println(ele.getText());
		}
	}
}




