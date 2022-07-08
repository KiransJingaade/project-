package com.crm.autodesk.genricutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplentClass implements ITestListener {

	ExtentTest test;
	ExtentReports report;
	
	
	public void onTestStart(ITestResult result) {
		//step3:-create a test method during test execution starts
		test=report.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) {
		//step4:-log the pass method
		test.log(Status.PASS, result.getMethod().getMethodName());
	}
	
	public void onTestFailure(ITestResult result) {
		//step6:-log fail method,take screenshot ,attach screenshot to test case name and report exception logs
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
        String path=null;
		
		WebDriverUtility wutil = new WebDriverUtility();
		try {
	    path=wutil.getscreenshot(BaseClass.sDriver, result.getMethod().getMethodName());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		//step5:-log the skip method
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onStart(ITestContext context) {
		//step1:-Extent report configuration
		ExtentSparkReporter htmlreporter = new ExtentSparkReporter("./extentreport.html");
		htmlreporter.config().setReportName("Regression execution report");
		htmlreporter.config().setDocumentTitle("Comcast automation execution report");
		htmlreporter.config().setTheme(Theme.DARK);

		//step2:-attach the physical report and do the system configuration
		report=new ExtentReports();
		report.attachReporter(htmlreporter);
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Environment", "Testing environment");
		report.setSystemInfo("URL", "https://localhost:8888");
		report.setSystemInfo("Reporter Name", "Kiran");
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

}
