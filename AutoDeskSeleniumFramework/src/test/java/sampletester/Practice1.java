package sampletester;


import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice1 {

	public static void main(String[] args) {
		
		
		Random r=new Random();
		int i=r.nextInt(1000);
		ChromeOptions options=new ChromeOptions();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		
		
		String org="Organisation name"+i;
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(org);
		driver.findElement(By.name("button")).click();
		String actual=driver.findElement(By.className("dvHeaderText")).getText();
		
		if(actual.contains(org)) {
			System.out.println("pass:organisation name is correct");
		}else {
			System.out.println("fail:organisation name is incorrect");

		}
		WebElement admin = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(admin).perform();
		
	     driver.findElement(By.linkText("Sign Out")).click();

		
		
	}
}
