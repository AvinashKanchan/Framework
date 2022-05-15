package com.vtiger.comcast.genericUtility;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This is the implementation class of ITestListener interface
 * @author Akshay
 *
 */
public class ListenerImplementationClass implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		
		/*step 3 create a test method during the test execution starts*/
		test=report.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		
		/*step 4 log the pass method*/
		test.log(Status.PASS, result.getName());
	}

	public void onTestFailure(ITestResult result) {
	
		/*step 4 log the fail method take and attach screenshot, exception to extent report*/
		String path = null;
		WebDriverUtility wLib=new WebDriverUtility();
		try {
			path= wLib.takeScreenshot(BaseClass.listenerDriver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getName());
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		
		/*step 4 log the skip method attach exception and method name*/
		test.log(Status.SKIP, result.getName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		/*step 1 extent report configuration*/
		ExtentSparkReporter reporter=new ExtentSparkReporter("./extentreport"+LocalDateTime.now().toString().substring(0, 19).replace(":", "_")+".html");
		reporter.config().setDocumentTitle("project extent report");
		reporter.config().setReportName("automation execution report");
		reporter.config().setTheme(Theme.STANDARD);
		
		/*step 2 attach the physical report and do the system configuration*/
		report=new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS :", System.getProperty("os.name"));
		report.setSystemInfo("Environment :", "Testing Environment");
		report.setSystemInfo("Reporter name :", "Akshay");
	}

	public void onFinish(ITestContext context) {
		
		report.flush();
	}

	
}
