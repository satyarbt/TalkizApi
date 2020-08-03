package com.Reports;

import java.io.File;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.DataMapper.EnvironmentDataMapper;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportListner implements ITestListener {
	protected static ExtentReports reports;
	protected static ExtentTest test;

	private static String resultpath = getResultPath();

	public static void deleteDirectory(File directory) {
		if (directory.exists()) {
			File[] files = directory.listFiles();
			if (null != files) {
				for (int i = 0; i < files.length; i++) {
					System.out.println(files[i].getName());
					if (files[i].isDirectory()) {
						deleteDirectory(files[i]);
					} else {
						files[i].delete();
					}
				}
			}
		}
	}

	private static String getResultPath() {

		resultpath = "Reports/";
		if (!new File(resultpath).isDirectory()) {
			new File(resultpath);
		}
		return resultpath;
	}

	String ReportLocation = resultpath;

	public void onTestStart(ITestResult result) {

		test = reports.startTest(result.getMethod().getDescription());
		test.log(LogStatus.INFO, result.getMethod().getDescription());
		System.out.println(result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		
		//test.log(LogStatus.PASS, result.getThrowable().getMessage());

		test.log(LogStatus.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) {

		test.log(LogStatus.FAIL, result.getThrowable().fillInStackTrace());
		test.log(LogStatus.FAIL, "Test Failed");

	}

	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, "Test is skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	 // TODO Auto-generated method stub
	  
	  }

	public void onStart(ITestContext context) {
		if (reports == null) {
			reports = new ExtentReports(ReportLocation + "Talkiz_Api_Report.html", true, DisplayOrder.NEWEST_FIRST);
			// reports.loadConfig(new
			// File(System.getProperty("user.dir")+"//extent-config.xml"));

		}

	}

	public void onFinish(ITestContext context) {

		System.out.println(context.getFailedTests().getAllResults().size());
		reports.endTest(test);
		reports.flush();
		int testPassed = context.getPassedTests().getAllResults().size();
		int testFailed = context.getFailedTests().getAllResults().size();
		int testSkipped = context.getSkippedTests().getAllResults().size();
		int totalTests = context.getSuite().getAllInvokedMethods().size();
		int testError = context.getFailedButWithinSuccessPercentageTests().size();
		String host_name;
		host_name = EnvironmentDataMapper.envAndFile().get("baseUrl");
		String os = System.getProperty("os.name");
		String test_suite = context.getSuite().getName();
		System.out.println(host_name);
		System.out.println(os);
		System.out.println(test_suite);
		PropertiesConfiguration config;
		try {
			config = new PropertiesConfiguration(System.getProperty("user.dir") + "/TestData/TestResults.properties");
			config.setProperty("TotalCases", totalTests);
			config.setProperty("TC_Passed", testPassed);
			config.setProperty("TC_Failed", testFailed);
			config.setProperty("TC_Skipped", testSkipped);
			config.setProperty("TC_Error", testError);
			config.setProperty("HostName", host_name);
			config.setProperty("OS", os);
			config.setProperty("TestSuite", test_suite);

			config.save();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}