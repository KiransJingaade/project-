package sampletester;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Credentials {

	public static void main(String[] args) throws Exception {
		FileInputStream fin = new FileInputStream(".//src/main/resources/properties/commondata.properties");
		Properties properties =new Properties();
		properties.load(fin);
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
	     
	     driver.findElement(By.name("user_name")).sendKeys(username);
	     driver.findElement(By.name("user_password")).sendKeys(password);
	     driver.findElement(By.id("submitButton")).click();
		 
	}

}
