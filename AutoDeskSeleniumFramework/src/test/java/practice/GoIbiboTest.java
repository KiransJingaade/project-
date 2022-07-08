package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoIbiboTest {

	public static void main(String[]args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//li/a[@class='nav-link .']")).click();
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		WebElement area = driver.findElement(By.xpath("//input[@aria-autocomplete='list']"));
	    
		Thread.sleep(2000);
	    
		area.click();
		
	    Thread.sleep(4000);
		
	    area.sendKeys("mysore");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(area));
		area.sendKeys(Keys.ARROW_DOWN);
		area.sendKeys(Keys.ENTER);
		String frommonthandyear="March 2022";
		String fromdate="31";
		String tomonthandyear="April 2022";
		String todate="1";
		WebElement checkin = driver.findElement(By.xpath("//h4[text()='Mar 18, 2022']"));
		checkin.click();
	     driver.findElement(By.xpath("//span[text()='"+frommonthandyear+"']/ancestor::div[contains(@class,'dcalendar-newstyles__CalenderMonthContainer-s')]/descendant::span[text()='"+fromdate+"']")).click();
        
        driver.findElement(By.xpath("//span[text()='"+tomonthandyear+"']/ancestor::div[@class='dcalendar-newstyles__CalenderMonthContainer-sc-1i003by-2 kCupBq']/descendant::span[text()='"+todate+"']")).click();
	    driver.findElement(By.xpath("//input[@class='SearchBlockUIstyles__CitySearchInput-sc-fity7j-12 uGGSH']")).click();
	    WebElement room = driver.findElement(By.xpath("//span[text()='+']"));
	   
	    Actions act=new Actions(driver);
	    act.moveToElement(room).click();
	    
	    WebElement adults = driver.findElement(By.xpath("(//span[text()='+'])[2]"));
	    act.moveToElement(adults).doubleClick().perform();
	    WebElement childrens = driver.findElement(By.xpath("(//span[text()='+'])[3]"));
	    act.moveToElement(childrens).doubleClick().click().perform();
	    WebElement sele = driver.findElement(By.xpath("//div[@class='dwebCommonstyles_CenteredSpaceWrap-sc-112ty3f-0 PaxWidgetstylesContentActionWrapperDiv-sc-gv3w6r-5 PaxWidgetstyles_ContentActionDropdownWrapper-sc-gv3w6r-6 eHRHNU lhNBSu kfVCVI']"));
	    sele.click();
	    WebElement age = driver.findElement(By.xpath("//li[text()='3']"));
	    age.click();
	    driver.findElement(By.xpath("(//div[@class='dwebCommonstyles_CenteredSpaceWrap-sc-112ty3f-0 PaxWidgetstylesContentActionWrapperDiv-sc-gv3w6r-5 PaxWidgetstyles_ContentActionDropdownWrapper-sc-gv3w6r-6 eHRHNU lhNBSu kfVCVI'])[2]")).click();
	    WebElement age2 = driver.findElement(By.xpath("//li[text()='4']"));
	    age2.click();
	    driver.findElement(By.xpath("(//div[@class='dwebCommonstyles_CenteredSpaceWrap-sc-112ty3f-0 PaxWidgetstylesContentActionWrapperDiv-sc-gv3w6r-5 PaxWidgetstyles_ContentActionDropdownWrapper-sc-gv3w6r-6 eHRHNU lhNBSu kfVCVI'])[3]")).click();
	    WebElement age3= driver.findElement(By.xpath("//li[text()='5']"));
	    age3.click();
	    driver.findElement(By.xpath("//button[text()='Done']")).click();
	    
	    driver.findElement(By.xpath("//button[text()='Search Hotels']")).click();
	    List<WebElement> hotels = driver.findElements(By.xpath("//div[@class='HotelCardstyles__OuterWrapperDiv-sc-1s80tyk-0 jEdYPu']"));
	    for(WebElement hotel:hotels)
	    {
	    	System.out.println(hotel.getText());
	    }
	  
	    driver.close();
	}
}
