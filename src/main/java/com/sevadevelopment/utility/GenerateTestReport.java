package com.sevadevelopment.utility;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenerateTestReport {

	WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;
	
	public GenerateTestReport() {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	public void generateReport(Method method) {
		extent = new ExtentReports("src/main/resources/extentReport.html", true);
		extent.addSystemInfo("Host Name", "Bridge Testing").addSystemInfo("Environment", "Automation Testing")
				.addSystemInfo("User Name", "Pravin Ray")
				.addSystemInfo("OS Architecture", System.getProperty("os.arch"));
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName();
		String browserVersion = cap.getVersion().toString();
		extent.addSystemInfo("Browser Name", browserName).addSystemInfo("Browser Version", browserVersion);
		extent.loadConfig(new File("src/main/resources/extent-config.xml"));

		// start logging for report generation
		logger = extent.startTest(method.getName());
	}
	
	public void flushReport(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed error is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Case Passed is " + result.getName());
		}
		extent.endTest(logger);
		extent.flush();
		
	}
}
