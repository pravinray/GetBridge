package com.sevadevelopment.instructure.tests;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.sevadevelopment.utility.ConfigUtility;
import com.sevadevelopment.utility.GenerateTestReport;
import com.sevadevelopment.utility.SeleniumDriverFactory;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoPlayerDemo {
	WebDriver driver;
	ConfigUtility configUtility;
	String homePage = ("https://www.getbridge.com");
	//GenerateTestReport generateTestReport = new GenerateTestReport(driver);

	public Map<Long, WebDriver> driverMap = new ConcurrentHashMap();
	public WebDriverWait wait;
	public SeleniumDriverFactory tlDriverFactory = new SeleniumDriverFactory();

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

		driverMap.put(Thread.currentThread().getId(),SeleniumDriverFactory.getDriver());
		driver = driverMap.get(Long.valueOf(Thread.currentThread().getId()));

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
