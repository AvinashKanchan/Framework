package com.vtiger.comcast.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation to IRetryAnalyzer interface methods
 * @author Akshay
 *
 */
public class RetryAnalyzerImplementationClass implements IRetryAnalyzer{

	int retryCount=0;
	int retryLimit=5;
	public boolean retry(ITestResult result) {

		if(retryCount<retryLimit)
		{
			retryCount++;
			return true;
		}
		return false;
	}
	
	

}
