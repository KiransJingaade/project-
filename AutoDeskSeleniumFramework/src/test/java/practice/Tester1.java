package practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.genricutility.BaseClass;

@Listeners(com.crm.autodesk.genricutility.ListenerImplentClass.class)

public class Tester1 extends BaseClass {

	@Test
	public void createOrgTest() {
		System.out.println("Test passed");
	}
	
	@Test
	public void createContactTest() {
		System.out.println("test failed");
        Assert.fail();
	}
	
	@Test
	public void createLeads() {
		System.out.println("test skipped");
		throw new SkipException("skipped");
	}
}
