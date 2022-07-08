package practice;

import org.testng.annotations.Test;

public class Twitter {

	@Test(groups="SystemTest")
	public void loginPage() {
		System.out.println("login page execution");
	}
	
	@Test(groups="IntegrationTest")
	public void homePage() {
		System.out.println("home page execution");
	}
}
