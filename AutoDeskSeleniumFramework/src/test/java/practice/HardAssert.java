package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssert {

	@Test
	public  void verifyTitle() {
		String expectedtitle="Facebook helps you connect";
		String actualtitle="Facebook helps you ";
		Assert.assertEquals(actualtitle, expectedtitle);//fail
	}
@Test
	public void intassert() {
		int a=10;
		int b=20;
		Assert.assertEquals(a, b);
	}
   @Test
	public void booleanAssert() {
		boolean redlight = false;
		boolean yellowlight = false;
		boolean greenlight = true;	
		Assert.assertEquals(redlight, greenlight);
		Assert.assertTrue(yellowlight);
		System.out.println("next line");
	}

   @Test
	public void doubleAssert() {
		double a=20;
		double b=20;
		Assert.assertEquals(a, b);
	}
@Test
	public void charAssert() {
		char[] a1= {'a','c','s','x','z'};
		char[] a2= {'a','c','s','x','z'};
		Assert.assertEquals(a1, a2);
	}

}
