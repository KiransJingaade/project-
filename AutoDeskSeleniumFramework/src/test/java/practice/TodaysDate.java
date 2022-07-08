package practice;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TodaysDate {

	public static void main(String[] args) {
		LocalDateTime ldt=LocalDateTime.now();
		int day = ldt.getDayOfMonth();
		int year = ldt.getYear();
		String month = ldt.getMonth().name();

		String actualmonth = month.substring(0, 1).toUpperCase()+month.substring(1).toLowerCase();
		String monthandYear = actualmonth+" "+year;
		String finalFormat = +day+"-"+monthandYear;
		System.out.println(finalFormat);


				WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
				driver.get("https://www.makemytrip.com/");
				
				Actions actions=new Actions(driver);
				actions.moveByOffset(20, 30).click().perform();
				
				driver.findElement(By.className("langCardClose")).click();
				
				driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

				
			      String calendarxpath="//div[text()='"+monthandYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']";
			  			      
			      for(int i=0;i<=24;i++) {
			          try {
			       	      driver.findElement(By.xpath(calendarxpath)).click();
			       	      break;
			          }catch(Exception e) {
			       	   driver.findElement(By.cssSelector("span[aria-label='Next Month']")).click();
			          }          
	              }
			      driver.findElement(By.id("fromCity")).click();
			      driver.findElement(By.xpath("//p[text()='Bangalore, India']")).click();
				     driver.findElement(By.xpath("//span[text()='To']")).click(); 
				     driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();	
				     driver.findElement(By.xpath("//a[text()='Search']")).click();
	}
}


