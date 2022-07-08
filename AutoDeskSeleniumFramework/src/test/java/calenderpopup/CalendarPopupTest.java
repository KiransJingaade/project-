package calenderpopup;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopupTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
       Actions actions= new Actions(driver);
       actions.moveByOffset(20, 30).click().perform();
       
       driver.findElement(By.className("langCardClose")).click();
       
       driver.findElement(By.cssSelector("label[for='departure']")).click();
       
       String monthandyear="May 2022";
       String day="12";
      String calendarxpath="//div[text()='"+monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']";
  
       for(int i=0;i<=24;i++) {
       try {
    	      driver.findElement(By.xpath(calendarxpath)).click();
    	      break;
       }catch(Exception e) {
    	   driver.findElement(By.cssSelector("span[aria-label='Next Month']")).click();
       } 
     String  indigopriceclick="(//p[text()='IndiGo']/ancestor::div[@class='listingCard appendBottom5']/descendant::p[@class='blackText fontSize18 blackFont white-space-no-wrap'])[1]";
       driver.findElement(By.xpath(indigopriceclick)).click();
	}
	}

}
