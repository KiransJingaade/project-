package com.crm.autodesk.genricutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * This class contains implementation for ITestListener interface
 * @author Kiran S
 *
 */
public class ListenerImplementationClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------> Start Test");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--------->Script Execution Success");
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-------->Script Execution Failed");
		System.out.println(result.getThrowable());
		
		try {
		String path = new WebDriverUtility().getscreenshot(BaseClass.sDriver, methodName);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------->Execution Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Execution Started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Execution Finish");
	}	
}
