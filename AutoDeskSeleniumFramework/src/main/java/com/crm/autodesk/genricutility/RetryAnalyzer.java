package com.crm.autodesk.genricutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
int count=0;
int retryCount=5;
	public boolean retry(ITestResult result) {
		
		return false;
	}

}
