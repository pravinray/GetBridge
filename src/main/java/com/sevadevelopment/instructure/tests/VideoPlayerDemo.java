package com.sevadevelopment.instructure.tests;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.sevadevelopment.utility.ConfigUtility;
import com.sevadevelopment.utility.GenerateTestReport;
import com.sevadevelopment.utility.SeleniumDriverFactory;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VideoPlayerDemo {
	WebDriver driver;
	ConfigUtility configUtility;
	String homePage = ("https://www.getbridge.com");
	GenerateTestReport generateTestReport = new GenerateTestReport(driver);

	@BeforeTest
	public void doBeforeTest() {
		configUtility = new ConfigUtility();
	}

	@AfterSuite
	public void doAfterSuite() {
		generateTestReport.flushReport(driver);
	}

	@BeforeMethod
	public void setupTestMethod(Method method) throws Exception {
		driver = new SeleniumDriverFactory().getDriver(configUtility.getConfig("browser"),
				configUtility.getConfig("executionMethod"), configUtility.getConfig("seleniumHubUrl"));
		driver.manage().window().setSize(new Dimension(1024, 768));
		// driver.manage().window().maximize();
		driver.get(homePage);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400)", "");
		generateTestReport.startReport(method);
	}

	@AfterMethod
	public void tearDownTestMethod(ITestResult result) {
		generateTestReport.getReport(result);
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Test(description = "To verify video source is available")
	public void verifyVideoSourceIsAvailable() throws Exception {

		String elementval = driver.findElement(By.className("paragraph-play-button")).getAttribute("data-wistiaid");
		System.out.println("WISTIA-VIDEO-ID: " + elementval);

		RestAssured.baseURI = "https://fast.wistia.net/embed/iframe/" + elementval;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();

		String contentType = response.header("Content-Type");
		System.out.println("Header body response type: " + contentType);

		assertTrue(contentType.contains("text/html"));

	}
}
