package com.sevadevelopment.instructure.tests;

import com.sevadevelopment.utility.ConfigUtility;
import com.sevadevelopment.utility.SeleniumDriverFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.testng.Assert.assertTrue;

public class VideoPlayerDemo {
	WebDriver driver;
	ConfigUtility configUtility;
	String homePage = ("https://www.getbridge.com");
	//GenerateTestReport generateTestReport = new GenerateTestReport(driver);


	@BeforeClass
	public void setupTestClass() {
		configUtility = new ConfigUtility();
	}

	@AfterSuite
	public void doAfterSuite() {
		//generateTestReport.flushReport(driver);
	}

	@BeforeMethod
	@Parameters({"browser","isGrid"})
	public void setupTestMethod(String browser, boolean isGrid, Method method) throws Exception {
		System.out.println("Before Method started ::"+Thread.currentThread().getId());
		SeleniumDriverFactory.setDriver(browser, isGrid);

		driver = SeleniumDriverFactory.getDriver();

		driver.manage().window().setSize(new Dimension(1024, 768));
		driver.get(homePage);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400)", "");
		//generateTestReport.startReport(method);
	}

	@AfterMethod
	public void tearDownTestMethod(ITestResult result) {
		//generateTestReport.getReport(result);
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
